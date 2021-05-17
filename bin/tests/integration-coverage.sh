./gradlew integrationTestReport
if ! test -d ./target/integration; then
  mkdir "./target/integration"
fi
cp -R ./build/target/integration/* ./target/integration