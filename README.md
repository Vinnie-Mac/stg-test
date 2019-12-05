# stg-test
Submission for the following task - https://github.com/thestarsgroup/technical_tester_assessment

### "Ok cool you've completed it ... But how do I run it?"
Easily is how you run it! (said nobody EVER when it comes to testing)
Below I have outlined simple instructions that will allow you to run my set of tests against the mock API server provided via the stars group assessment project.

If for any reason Maven starts complaining, your command line bugs out or IntelliJ crashes then please feel free to Google your problems because I'm unfortunately no good to you there - However if you wish to ask any questions at all regarding my design choices, dependancy selection or anything code specific then please do drop me a line over at my personal email address <vincentmcdonald33@gmail.com>

#### Terminal
1. As stated in the link above, make sure to run `npm install && npm run start` in order to get the Mock API up and running (provided you've followed their instructions and installed LTS version of NodeJs and NPM)
2. Once that is running, head to a new terminal window then cd to where you've either cloned or downloaded this project and navigate further until you reach the `stg-test` directory
3. Enter the following commands into your terminal window ``

#### IntelliJ IDEA
1. Launch IntelliJ and be sure to begint he 'Open Project' process. 
2. Select the folder location containing the pom.xml file (it will be the `stg-test` root directory)
3. Once the project has loaded and Maven dependancies have been download and you've done a successful build of the project, head over to Edit configurations and type int the following serentity/maven based commands/flags -> ``
