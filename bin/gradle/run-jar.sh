echo 'Preparing jar'
./gradlew jar
#./gradlew bootJar

echo 'Running jar file'
java -jar ./build/libs/training-ddd-and-design-patterns-java-1.0.0-SNAPSHOT.jar
