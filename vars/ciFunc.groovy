def checkoutVarFunc(Map specs) {
  println "Printing specs" + specs
  docheckout = new com.hexaware.service.Codecheckout(this, specs)
  docheckout.checkOutFunc(specs)  
}
def build(Map specs, Map config) {
  dobuild = new com.hexaware.service.Build(this, specs, config)
  dobuild.buildFunc(specs, config) 
}
def unittest(Map specs, Map config) {
  dounittest = new com.hexaware.service.Unittesting(this, specs, config)
  dounittest.unitTestFunc(specs, config) 
}
def codecoverage(Map specs, Map config) {
  docodecoverage = new com.hexaware.service.Codecoverage(this, specs, config)
  docodecoverage.codecoverageCheckFunc(specs, config) 
}
def codequality(Map specs, Map config) {
  docodequality = new com.hexaware.service.Codequality(this, specs, config)
  docodequality.codequalityFunc(specs, config) 
}
def artifactupload() {
      def server = Artifactory.server 'artifactory'
      def uploadSpec = """{
      "files": [
        {
          "pattern": "target/*.zip",
          "target": "default-maven-local/petclinic/jar/"
        }
     ]
    }"""
     server.upload spec: uploadSpec
}
