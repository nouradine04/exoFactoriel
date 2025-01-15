pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', changelog: false, credentialsId: 'a0ca0d28-80bd-4911-90cf-f4191d8fd2cc', poll: false, url: 'https://github.com/nouradine04/exoFactoriel.git'            }
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
