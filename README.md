java-mrt
========

Java library to parse the binary MRT format.

This library is released under LGPL license. Read LICENSE.txt.

## Releasing
Do not touch anything in `pom.xml`, do not update versions.

1. Commit and push all the changes.
2. `mvn release:clean release:prepare`
   - answer all the questions (just hit `return`)
3. `mvn release:perform`
4. Check that new version was released on Nexus
5. Check that new tag was set in Github
6. Make a new release via Github interface using latest tag.
