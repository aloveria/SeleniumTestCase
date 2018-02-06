CLASSPATH=lib/*:bin:resources/
javac -cp "lib/*" -d bin src/com/selenium/webdriver/basic/*.java

java -classpath ".:CLASSPATH" org.testng.TestNG config/testng.xml
