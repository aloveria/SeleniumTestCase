javac -cp "$JENKINS_HOME/workspace/$JOB_NAME/lib/*:" -d bin src/com/selenium/webdriver/basic/*.java

java -cp "$JENKINS_HOME/workspace/$JOB_NAME/bin:$JENKINS_HOME/workspace/$JOB_NAME/lib/*:resources/" org.testng.TestNG config/testng.xml
