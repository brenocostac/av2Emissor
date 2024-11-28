pipeline {
    agent any
     
    stages {

        stage('Verificar Repositório') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']],
                          userRemoteConfigs: [[url: 'https://github.com/brenocostac/Jenkins.git']]])
            }
        }

        

        stage('Construir Imagem Docker') {
            steps {
                script {
                    def appName = 'clienteemissor'
                    def imageTag = "${appName}:${env.BUILD_ID}"
                    bat "docker build --build-arg  -t ${imageTag} ."
                }
            }
        }

        stage('Fazer Deploy') {
            steps {
                script {
                    def appName = 'clienteemissor'
                    def imageTag = "${appName}:${env.BUILD_ID}"
                    bat "docker stop ${appName} || exit 0"
                    bat "docker rm ${appName} || exit 0"
                    bat "docker-compose up -d --build"
                }
            }
        }
    }

    post {
        success {
            echo 'Deploy realizado com sucesso!'
        }
        failure {
            echo 'Houve um erro durante o deploy.'
        }
    }
}