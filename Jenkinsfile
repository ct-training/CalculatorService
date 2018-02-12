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

node('slave') {
    stage('Deploy') {
    sh '''#!/bin/bash -l
    wget http://www-us.apache.org/dist/tomcat/tomcat-8/v8.5.27/bin/apache-tomcat-8.5.27.tar.gz

    if [ ! -d /opt/tomcat ]
    then
    	sudo mkdir /opt/tomcat
    	sudo tar -zxvf apache-tomcat-8.5.14.tar.gz -C /opt/tomcat --strip=1
        sudo sed -i -e 's/8080/8081/g' /opt/tomcat/conf/server.xml
    fi
    
    cd /opt/tomcat/bin/
    sudo ./shutdown.sh
    sudo nohup sh startup.sh &
    '''
    }
}
