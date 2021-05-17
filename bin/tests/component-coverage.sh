./gradlew componentTestReport
if ! test -d ./target/component; then
  mkdir "./target/component"
fi
cp -R ./build/target/component/* ./target/component