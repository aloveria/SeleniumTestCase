@echo off
javac -cp "lib/*;C:/Program Files/Java/jre1.8.0_131/lib/*" -d bin src/com/selenium/webdriver/basic/*.java

java -cp bin;lib/*;resources/ org.testng.TestNG config/testng.xml