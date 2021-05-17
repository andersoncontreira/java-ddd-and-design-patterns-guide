./gradlew unitTestReport
if ! test -d ./target/unit; then
  mkdir "./target/unit"
fi
cp -R ./build/target/unit/* ./target/unit