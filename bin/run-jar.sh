JAR=$1
if [ -z "$1" ]; then
  JAR="./jar/training-full.jar"
fi

echo "java -jar $JAR"
java -jar $JAR