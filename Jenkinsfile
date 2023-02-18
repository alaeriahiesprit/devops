pipeline{
 agent any
    stages {
       stage('Git') {
            steps {
                echo "GitHub clone step"
                git branch: "main",
                url: "https://github.com/alaeriahiesprit/devops.git"
            }
        }
       stage('Compile & test Maven') {
            steps {
                sh "mvn clean compile -DskipTests"
            }
        }
       stage('JUNIT/Mockito') {
            steps {
                sh "mvn test"
            }
        }
       stage('Run SonarQube') {
            steps {
                sh   "mvn sonar:sonar -Dsonar.projectKey=devopsproject -Dsonar.host.url=http://192.168.1.124:9090 -Dsonar.login=5e8984946c58bd420a2539e089857e7085016345"
            }
        }
        
       stage('Nexus') {
            steps {
                sh "mvn clean package -DskipTests deploy:deploy-file -DgroupId=tn.esprit -DartifactId=ExamThourayaS2 -Dversion=1.0 -DgeneratePom=true -Dpackaging=war -DrepositoryId=deploymentRepo -Durl=http://192.168.1.124:8082/repository/maven-releases/ -Dfile=target/ExamThourayaS2-0.0.1-SNAPSHOT.jar"
            }
        }
       stage('Deploy') {
            steps {
                sh "mvn clean install -DskipTests=true"
            }
        }
 }
    
}
