pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Clone your GitHub repository
                git branch: 'main', url: 'https://github.com/mahii47/RedBusAutomationProject'
            }
        }

        stage('Build') {
            steps {
                // Clean and compile the Maven project
                bat 'mvn clean compile'
            }
        }

        stage('Run Tests') {
            steps {
                // Run your test cases
                bat 'mvn test'
            }
        }
    }

    post {
        success {
            echo 'Build and tests completed successfully!'
        }
        failure {
            echo 'Build failed. Please check Jenkins console logs.'
        }
    }
}
