pipeline {
    agent any
    tools {
        // Assurez-vous que le nom ici correspond à l'installation Maven configurée dans Jenkins
        maven 'Maven Home'
    }
    stages {
        stage('Checkout') {
            steps {
                // Récupérer le code source du dépôt GitHub
                git 'https://github.com/Gdiaby/Shopin.git'
            }
        }
        stage('Test') {
            steps {
                // Exécuter les tests avec Maven
                echo 'Running tests...'
                sh 'mvn test'
            }
        }
    }
    post {
       always {
            echo 'Archiving artifacts and test results...'
            archiveArtifacts artifacts: 'target/surefire-reports/*.xml', allowEmptyArchive: true
            junit 'target/surefire-reports/*.xml'
        }
    }
}
