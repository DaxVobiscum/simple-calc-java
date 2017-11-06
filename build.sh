rm -rf app.jar &&
javac -d build/classes $(find src -name *.java) &&
jar cfe app.jar com.polonius.java.Program -C build/classes . &&
java -jar app.jar
