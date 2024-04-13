pipeline {
    agent any

    tools {
        maven "MAVEN_HOME"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/ithevas/Jenkins.git'
            }
        }

        stage('Build and Test') {
            steps {
                sh "mvn clean install"
            }
        }

        stage('Sonar Analysis'){
            steps {
                sh "mvn sonar:sonar"
            }
        }
        
        stage('Upload to Artifactory'){
            steps {
                script {
                    rtMavenDeployer id: 'deployer', serverId: 'Artifactory', releaseRepo: 'libs-release-local', snapshotRepo: 'libs-snapshot-local'
                    rtMavenRun pom: 'pom.xml', goals: 'clean install', deployerId: 'deployer'
                    rtPublisherBuildInfo serverId: 'Artifactory'
                }
            }
        }


//        stage('Package') {
//            steps {
//              sh "mvn package"
//          }

//          post {
//              success {
//                  junit '**/target/surefire-reports/TEST-*.xml'
//                  archiveArtifacts 'target/*.war'
//                  rtUpload (
//                      serverId: 'Artifactory',
//                      spec: '''{
//                          "files": [
//                              {
//                                  "pattern": "target/*.war",
//                                  "target": "libs-release-local/"
//                              }
//                          ]
//                      }''',
//                      buildName: 'Calculator-App',
//                      buildNumber: '1',
        
//                    )
//              }
//          }
//      }
    }
}
