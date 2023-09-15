pipeline {
    agent any

    stages {
        stage('git') {
            steps {
                git branch: 'master', credentialsId: 'credentialmasonkey', url: 'https://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@github.com/hsyang-chaorda/chaorda_matchuum_last.git'
            }
        }
        stage('build') {
            steps {
                sh '''chmod +x gradlew
                    ./gradlew clean test
                    ./gradlew clean build'''
            }
            steps {
                sh '''docker build --build-arg DEPENDENCY=build/dependency -t chaordadocker/matchuum-backend --platform linux/amd64 .

                    docker push chaordadocker/matchuum-backend'''
            }
        }
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