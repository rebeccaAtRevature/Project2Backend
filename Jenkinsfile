pipeline {
	agent any
	stages {
		stage ('Clone Code') {
			steps {
				// get some code from a GitHub repository
				git (url: 'https://github.com/rebeccaAtRevature/Project2Backend.git', branch: 'continuous-integration', )
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
				sh 'docker rm -f $(docker ps -a -q)'
				sh 'docker volume rm $(docker volume ls -q)'
				sh 'docker-compose up'
			}
		}
	}
}