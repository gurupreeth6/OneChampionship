# OneChampionship
one championship app automation for verification of landing page carousel, event page and athlete nick name verification

# File Overview
* `/Configuration`
  * `config.properties` Contains base URL and path of chrome driver and firefox driver
* `/App`
  * `app-arm64-v8a-release.apk` - apk for one championship
* `/src/test/java/pageObject` - Contains page object for all the pages
  * `OneChampionshipHome` - Contains common elements and methods of One championship home page
  * `OneChampionshipLanding` - Contains common elements and methods of One championship landing page
  * `OneChampionshipProfile` - Contains common elements and methods of Athlete profile page
  * `OneChampionshipSearch` - Contains common elements and methods of Athlete search page
* `/src/test/java/testCases`
  * `BaseClass` - Contains driver initilisation, teardown method 
  * `TC_OneChampionshipHome_001` - Contains all the test cases of Carousel element verification, Athlete search and print the nick name
* `/src/test/java/testData`
  * `SearchData.xlsx` - Contains all the test data needed for the Test
* `/src/test/java/testData`
  * `ReadConfig` - To fetch all the config from config.properties file
  * `Reporting` - Contains TestListener methods
  * `XLUtils` - Contains methods to read data from excel
* `/src/test/java/resources`
  * `extent-config.xml` - xml config for extent report
  * `log4j2.xml` - xml config of log4j for loggin config
  * `TestNG.xml` - xml config of TestNG for passing browser and setting other params
* `test-output` - contains all the html reports generated
* `pom.xml` - xml config for getting all the required dependencies


#How to Execute
 * Import the project to any of the IDE
 * /src/test/java/resources/TestNG.xml - Change the value of param 'device' - Currently supports only android.
 * Navigate to /src/test/java/resources/TestNG.xml right click and RunAs TestNG. This will execute the script and generate report
