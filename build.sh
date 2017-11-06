rm -rf app.jar &&
javac -d build/classes $(find src -name *.java) &&
jar cfe app.jar workshops.Program -C build/classes . &&
java -jar app.jar
