package com.hexaware.service
class Dockerbuild implements Serializable{
Script mainScript
Map specs
Map config

  def Dockerbuild(Script mainScript, Map specs, Map config){
  this.mainScript = mainScript
  this.specs = specs
  this.config = config
  }
  def dockerbuildCheckFunc(Map specs, Map config){
    mainScript.withCredentials([mainScript.usernamePassword(credentialsId: 'artifactory', passwordVariable: 'password', usernameVariable: 'username')]) {
      mainScript.sh """ docker login -u ${mainScript.username} -p ${mainScript.password} ${config.java.dockerbuild.docker.dockerurl} """
      mainScript.sh config.java.dockerbuild.docker.command
      mainScript.sh config.java.dockerbuild.docker.tag
      mainScript.sh config.java.dockerbuild.docker.push
    }
  }
}
