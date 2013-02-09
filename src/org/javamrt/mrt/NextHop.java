package org.javamrt.mrt;

import java.net.InetAddress;

import org.javamrt.utils.RecordAccess;


public class NextHop implements Attribute {

	public NextHop() throws Exception {
		byte nh[] = { (byte) 255, (byte) 255, (byte) 255, (byte) 255 };
		this.nextHopIA = InetAddress.getByAddress(nh);
	}

	public NextHop(byte[] buffer) throws Exception {
		int offset = 0;
		int len = buffer.length;
		byte nh[] = RecordAccess.getBytes(buffer, offset, len);
		this.nextHopIA = InetAddress.getByAddress(nh);
	}

	public NextHop(InetAddress nextHopIA) throws NullPointerException {
		if (nextHopIA == null)
			throw new NullPointerException(
					"Initialising nextHop with null pointer");
		this.nextHopIA = nextHopIA;
	}

	public InetAddress getRaw() {
		return nextHopIA;
	}

	public String toString() {
		if (this.nextHopIA == null)
			return null;
		return MRTConstants.ipAddressString(nextHopIA);
	}

	public boolean isDefault() {
		byte[] buffer = this.nextHopIA.getAddress();
		for (int i = 0; i < buffer.length; i++)
			if (buffer[i] != 0)
				return false;
		return true;
	}

	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (this == o)
			return true;
		if (o.getClass() == this.getClass())
			return this.nextHopIA.equals(((NextHop) o).nextHopIA);
		return false;
	}

	protected InetAddress nextHopIA;
}
