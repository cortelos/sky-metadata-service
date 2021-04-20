pipeline {
    agent any

    stages {
        stage('Compile & Test') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Build Docker Image') {
            steps {
                sh 'docker build -t sky/metadata-service .'
            }
        }
        stage('Run in Staging') {
            steps {
                sh 'docker stop sky_metadata_service_staging'
                sh 'docker rm sky_metadata_service_staging'
                sh 'docker run -d --name sky_metadata_service_staging -p 9000:8080 sky/metadata-service'
            }
        }
    }
}