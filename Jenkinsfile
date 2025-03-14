pipeline {
    agent any

    environment {
        // Set your Docker Hub username here
        DOCKER_HUB_USERNAME = 'yadeleke'
        DOCKER_IMAGE_NAME = "${DOCKER_HUB_USERNAME}/blog:latest"
    }

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
                withCredentials([string(credentialsId: 'Olatunji29$', variable: 'DOCKER_HUB_PASSWORD')]) {
                    sh "echo $DOCKER_HUB_PASSWORD | docker login -u ${DOCKER_HUB_USERNAME} --password-stdin"
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
