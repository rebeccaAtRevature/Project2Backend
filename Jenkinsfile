pipeline {
	agent any

	stages {
		stage ('Clone Code') {
			steps {
				// get some code from a GitHub repository
				git (url: 'https://github.com/rebeccaAtRevature/Project2Backend.git', branch: 'master', )
			}
		}
		
		stage ('Build Code') {
			steps {
			
				withMaven 
	   			 { 
	   			 	sh 'mvn clean package'
	   			 }
				
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