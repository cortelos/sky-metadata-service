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
                sh 'docker ps -q --filter "name=sky_metadata_service_staging" | grep -q . && docker stop sky_metadata_service_staging && docker rm -fv sky_metadata_service_staging || true'
                sh 'docker run -d --name sky_metadata_service_staging -p 9000:8080 sky/metadata-service'
            }
        }
        stage('Production Deploy Approval') {
            steps {
                input "Deploy to production?"
            }
        }
        stage('Run in Production') {
            steps {
                sh 'docker ps -q --filter "name=sky_metadata_service_production" | grep -q . && docker stop sky_metadata_service_production && docker rm -fv sky_metadata_service_production || true'
                sh 'docker run -d --name sky_metadata_service_production -p 9001:8080 sky/metadata-service'
            }
        }
    }
}