pipelineJob("CI-Pipelines/${j}-ci") {
    configure { flowdefinition ->
      flowdefinition << delegate.'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps') {
        'scm'(class:'hudson.plugins.git.GitSCM',plugin:'git') {
          'userRemoteConfigs' {
            'hudson.plugins.git.UserRemoteConfig' {
              'url'('https://github.com/Manmohan506/frontend-1.git')
            }
          }
          'branches' {
            'hudson.plugins.git.BranchSpec' {
               'name'('*/main')
            }
          }
        }
        'scriptPath'('Jenkinsfile')
        'lightweight'(true)
      }
    }
  }