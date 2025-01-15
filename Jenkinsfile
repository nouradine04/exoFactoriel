pipeline {
    agent {
        label 'maven'
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/nouradine04/exoFactoriel.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Docker Build') {
            steps {
                script {
                    docker.build("exo-factoriel:${env.BUILD_ID}")
                }
            }
        }

        stage('Docker Push') {
            steps {
                script {
                    docker.withRegistry('https://registry.hub.docker.com', 'docker-hub-credentials') {
                        docker.image("exo-factoriel:${env.BUILD_ID}").push()
                    }
                }
            }
        }

        stage('Deploy') {
            steps {
                sh 'docker run -d -p 8080:8080 exo-factoriel:${env.BUILD_ID}'
            }
        }
    }
}
