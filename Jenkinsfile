pipeline {
    agent any

    tools {
        maven "MAVEN_HOME"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'devops', credentialsId: 'gitlab-creadential', url: 'https://git.nagarro.com/GITG00641/DotNet/divyanshu-mishra.git'
            }
        }

        stage('Build and Test') {
            steps {
                bat "mvn clean test"
            }
        }

        stage('Package') {
            steps {
                bat "mvn package"
            }

            post {
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.war'
                    rtUpload (
                        serverId: 'artifactory-server-id',
                        spec: '''{
                            "files": [
                                {
                                    "pattern": "target/*.war",
                                    "target": "libs-release-local/"
                                }
                            ]
                        }'''
                    )
                }
            }
        }
    }
}
