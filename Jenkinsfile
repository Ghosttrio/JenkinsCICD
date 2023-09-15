pipeline {
    agent any

    stages {

        stage('Fetch repository') {
            steps {
                git branch: 'master', credentialsId: 'gitHub-token', url: 'https://github.com/Ghosttrio/JenkinsCICD.git'
            }
        }

//         stage('build') {
//             steps {
//                 script{
//                     sh '''chmod +x gradlew
//                         ./gradlew clean test
//                         ./gradlew clean build'''
//                 }
//             }
//             steps {
//                 script{
//                     sh '''docker build --build-arg DEPENDENCY=build/dependency -t chaordadocker/matchuum-backend --platform linux/amd64 .
//
//                     docker push chaordadocker/matchuum-backend'''
//                 }
//             }
//         }
//
        stage('deployments') {
            parallel {
                stage('deploy to prod') {
                    steps {
                        sshPublisher(publishers: [sshPublisherDesc(configName: 'DevServer', transfers: [sshTransfer(cleanRemote: false, excludes: '', execCommand: '''docker pull chaordadocker/matchuum-backend

                        docker ps -q --filter name=matchuum | grep -q . && docker rm -f $(docker ps -aq --filter name=matchuum)

                        docker run -d --name=matchuum -p 80:8088 -p 2023:2023 chaordadocker/matchuum-backend''', execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '', remoteDirectorySDF: false, removePrefix: '', sourceFiles: '**/*.jar')], usePromotionTimestamp: false, useWorkspaceInPromotion: false, verbose: false)])

                        echo 'prod deployment done'
                    }
                }
            }
        }

    }
}
