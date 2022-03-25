pipeline {
	agent any
	stages {
		stage ('Clone Code') {
			steps {
				sh 'cd /var/lib/jenkins/workspace/backend-pipeline'
				sh 'sudo rm -r target'
				// get some code from a GitHub repository
				git (url: 'https://github.com/rebeccaAtRevature/Project-1.git', branch: 'continuous-integration', )
			}
		}
		
		stage ('Build Code') {
			steps {
				sh 'mvn clean package'
			}
		}
		
		stage ('Staging') {
			steps {
				sh 'docker-compose down'
				sh 'docker-compose up'
			}
		}
	}
}