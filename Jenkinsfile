pipeline {
    agent any

    environment {
        // Make sure you have set up a Jenkins Credential with ID 'docker-hub-password'
        DOCKER_HUB_CREDENTIALS = credentials('Olatunji29$')
        DOCKER_HUB_USERNAME = 'yadeleke' // Replace with your Docker Hub username
        DOCKER_IMAGE_NAME = "${DOCKER_HUB_USERNAME}/blog:latest"
    }

    stages {
        stage('Checkout') {
            steps {
                // Clone your repo from GitHub
                git branch: 'main', url: 'https://github.com/y-adeleke/blog.git'
            }
        }
        stage('Build') {
            steps {
                // Build your Maven project
                sh '/opt/homebrew/bin/mvn clean package'
            }
        }
        stage('Test') {
            steps {
                // Run tests
                sh '/opt/homebrew/bin/mvn test'
            }
        }
        stage('Docker Login') {
            steps {
                // Log into Docker Hub using Jenkins credentials
                sh "echo ${DOCKER_HUB_CREDENTIALS} | docker login -u ${DOCKER_HUB_USERNAME} --password-stdin"
            }
        }
        stage('Docker Build') {
            steps {
                // Build the Docker image using the Dockerfile
                sh "docker build -t ${DOCKER_IMAGE_NAME} ."
            }
        }
        stage('Docker Push') {
            steps {
                // Push the image to Docker Hub
                sh "docker push ${DOCKER_IMAGE_NAME}"
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying application...'
                // Optionally, add steps to deploy or run the container locally
            }
        }
    }
}
