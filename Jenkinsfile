node('master') {
   def mvnHome
   stage('Preparation') { // for display purposes
      // Get some code from a GitHub repository
      git 'https://github.com/ct-training/CalculatorService.git'
      // Get the Maven tool.
      // ** NOTE: This 'M3' Maven tool must be configured
      // **       in the global configuration.           
      mvnHome = tool 'maven_3.5.0'
      env.JAVA_HOME = tool 'jdk_1.8.0_linux'
      
   }
   stage('Build') {
      // Run the maven build
      if (isUnix()) {
         sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean install"
      } else {
         bat(/"${mvnHome}\bin\mvn" -Dmaven.test.failure.ignore clean package/)
      }
   }
   stage('Results') {
      junit '**/target/surefire-reports/TEST-*.xml'
      archive 'target/*.jar'
   }
}

node('master') {
    stage('Deploy') {
    sh '''#!/bin/bash -l
    wget http://mirror.fibergrid.in/apache/tomcat/tomcat-8/v8.5.14/bin/apache-tomcat-8.5.14.tar.gz

    if [ ! -d /opt/tomcat ]
    then
    	mkdir /opt/tomcat
    	tar -zxvf apache-tomcat-8.5.14.tar.gz -C /opt/tomcat --strip=1
        sed -i -e 's/8080/8081/g' /opt/tomcat/conf/server.xml
    fi
    
    cd /opt/tomcat/bin/
    ./shutdown.sh
    nohup sh startup.sh &
    '''
    }
}
