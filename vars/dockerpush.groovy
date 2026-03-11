def call(String project, String imageTag, String credId) {
    withCredentials([usernamePassword(credentialsId: credId,
        passwordVariable: 'dockerhubpass',
        usernameVariable: 'dockerhubuser')]) {
        sh "docker login -u ${dockerhubuser} -p ${dockerhubpass}"
        sh "docker push ${dockerhubuser}/${project}:${imageTag}"
    }
}
