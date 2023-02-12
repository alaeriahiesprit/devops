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
                sh 'mvn clean compile -DskipTests'
            }
        }
             stage('Run SonarQube') {
            steps {
                sh   "mvn sonar:sonar -Dsonar.projectKey=devopsproject -Dsonar.host.url=http://192.168.1.124:9090 -Dsonar.login=91c548fabf0c6bdab48d8f24ad26aa6a74b10d2f"
            }
        }
             stage('JUNIT/Mockito') {
            steps {
                sh 'mvn test'
            }
        }
             stage('Nexus') {
            steps {
                sh "mvn deploy"
            }
        }
 }
    
}
