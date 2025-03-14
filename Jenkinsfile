pipeline {
    agent any

    environment {
        DOCKER_IMAGE_NAME = "yadeleke/blog:latest"  

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/y-adeleke/blog.git'
            }
        }
        stage('Build') {
            steps {
                sh '/opt/homebrew/bin/mvn clean package'
            }
        }
        stage('Test') {
            steps {
                sh '/opt/homebrew/bin/mvn test'
            }
        }
        stage('Docker Login') {
            steps {
                // Use withCredentials to securely inject username and password
                withCredentials([usernamePassword(credentialsId: 'docker-hub-cred', 
                                                  usernameVariable: 'DOCKER_HUB_USERNAME', 
                                                  passwordVariable: 'DOCKER_HUB_PASSWORD')]) {
                    // Docker login command using the injected credentials
                    sh "echo $DOCKER_HUB_PASSWORD | docker login -u $DOCKER_HUB_USERNAME --password-stdin"
                }
            }
        }
        stage('Docker Build') {
            steps {
                sh "docker build -t ${DOCKER_IMAGE_NAME} ."
            }
        }
        stage('Docker Push') {
            steps {
                sh "docker push ${DOCKER_IMAGE_NAME}"
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying application...'
            }
        }
    }
}
