// src/org/example/MyAnsibleLib.groovy
package org.example

class MyAnsibleLib implements Serializable {
  def script

  MyAnsibleLib(script) {
    this.script = script
  }

  def cloneRepository(String repoUrl, String branch = 'main') {
    script.git(url: repoUrl, branch: branch)
  }

  def userApproval(String message) {
    script.input(message: message)
  }

  def executePlaybook(String playbook, String inventory) {
    script.sh "ansible-playbook -i ${inventory} ${playbook}"
  }

  def notify(String message) {
    script.echo message
  }
}

