# stg-test
Submission for the following task - https://github.com/thestarsgroup/technical_tester_assessment

### "Ok cool you've completed it ... But how do I run it?"
Easily is how you run it! (said nobody EVER when it comes to testing)
Below I have outlined simple instructions that will allow you to run my set of tests against the mock API server provided via the stars group assessment project.

If for any reason Maven starts complaining, your command line bugs out or IntelliJ crashes then please feel free to Google your problems because I'm unfortunately no good to you there - However if you wish to ask any questions at all regarding my design choices, dependancy selection or anything code specific then please do drop me a line over at my personal email address <vincentmcdonald33@gmail.com>

#### Terminal
1. As stated in the link above, make sure to run `npm install && npm run start` in order to get the Mock API up and running (provided you've followed their instructions and installed LTS version of NodeJs and NPM)

2. Once that is running, head to a new terminal window then cd to where you've either cloned or downloaded this project and navigate further until you reach the `stg-test` directory that contains the `pom.xml` file

3. Enter the following commands into your terminal window `mvn clean -P automation-test verify -Dtags=Fixtures serenity:aggregate`

4. Verify the report is generated under the 'Serenity Reports' folder that is generated every time you run a batch of tests. A unique timestamp is added to the end of the folder name to let you know which report to check. The location is as follow ->Target folder has been populated and you may find a copy of the report at thw following location -> `tg-test/serenity-reports/Serenity_Report%GENERATEDTIMESTAMP%/index.html`
