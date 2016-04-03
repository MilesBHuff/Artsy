#!/bin/env sh
## Script by Miles B Huff
echo "Building 'Artsy'..."
mkdir build && cd build
javac ../src/*.java
cd ..
jar -cf Artsy.jar build/*.class
#rm -rf build
echo "Done.  "
