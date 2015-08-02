Basic Griffon JavaFX/Groovy project
-----------------------------------

This file was automatically generated except for this paragraph. If you actually stumble upon this project and for some reason want to run it, I'm not sure if these instructions will work, so follow them at your own risk. I just uploaded this repository today because I'm going mobile. This file will be appropriately updated once the app reaches a more workable state. And it's not really in a workable state. There are a number of issues with the web views and a lot of dead links. This is mostly a research project for me to keep my skills up between jobs.

You have just created a basic Griffon application with JavaFX as the UI toolkit
and Groovy as the main language. The project has the following file structure

    .
    ├── build.gradle
    ├── griffon-app
    │   ├── conf
    │   ├── controllers
    │   ├── i18n
    │   ├── lifecycle
    │   ├── models
    │   ├── resources
    │   ├── services
    │   └── views
    ├── pom.xml
    └── src
        ├── integration-test
        │   └── groovy
        ├── main
        │   ├── groovy
        │   └── resources
        └── test
            ├── groovy
            └── resources

Simply add your source files to `src/main/groovy`, your test cases to
`src/test/groovy` and then you will be able to build your project with

    gradle build
    gradle test
    gradle run

Don't forget to add any extra JAR dependencies to `build.gradle`!

If you prefer building with Maven then execute the following commands

    mvn compile
    mvn test
    mvn -Prun

Don't forget to add any extra JAR dependencies to `pom.xml`!
