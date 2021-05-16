#!/usr/bin/env bash
# **********************************************
# Clean build folder
# **********************************************
rm -rf ./jar/*.jar
rm -rf ./jar/*.json

# **********************************************
# Migrations
# **********************************************
# ./gradlew flywayMigrate -i

# **********************************************
# Build
# **********************************************
# step 1
./gradlew build -x test -x javadoc

# step 2
./gradlew buildDependents -x test -x javadoc

# step 3
./gradlew sourcesJar
echo "Build: jar generated in ./build/libs/training-full.jar"

# **********************************************
# JAR
# **********************************************
# Copiar o jar
cp ./build/libs/training-full.jar ./jar/
echo "Build: jar copied to ./jar/training-full.jar"

echo "Build: To execute type: java -jar ./jar/training-full.jar"
echo "Build: Done!"