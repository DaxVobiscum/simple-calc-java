#!/bin/bash

# Creates ./build/classes if it doesn't exist;
# cleans up any existing app.jar file;
# builds all .java files under ./src into ./build/classes;
# creates the app.jar file;
# runs the app.jar file.

if [ ! -d build ]; then
  mkdir build && mkdir build/classes
elif [ ! -d build/classes ]; then
  mkdir build/classes
fi

rm -rf app.jar &&
javac -d build/classes $(find src -name *.java) &&
jar cfe app.jar com.polonius.java.Program -C build/classes . &&
java -jar app.jar

