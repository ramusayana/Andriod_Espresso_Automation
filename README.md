Andriod Espresso Automation: 

This repository contains the source code. This project utilizes Kotlin and includes a suite of automated Espresso UI Tests to ensure key user flows are stable and functional.

Table of Contents
1.Prerequisites

2.Getting Started

3.Running Tests Locally

4.Understanding the Tests

CI/CD Integration (Advanced)

1. Prerequisites
To work with and run the tests in this project, you need the following tools installed on your computer:

Android Studio (Latest Version): The official IDE for Android development.

Java Development Kit (JDK 17 or higher): Required for Gradle to run.

2. Getting Started
2.1. Cloning the Repository
Use Git to download the project source code:

Bash

git clone repo name
2.2. Opening the Project
Open Android Studio.

Select File > Open and navigate to the directory where you cloned the project.

Android Studio will automatically sync the project using Gradle. Wait for the process to complete (the "Build" window at the bottom should show BUILD SUCCESSFUL).

3. Running Tests Locally
Espresso tests are instrumentation tests, meaning they require a running Android device or emulator to execute.

3.1. Launching an Emulator
In Android Studio, click the Device Manager icon (it looks like a little phone/tablet).

Start an existing Android Virtual Device (AVD) or create a new one. A device running a recent API level (e.g., API 30 or 34) is recommended.

3.2. Executing the Tests
You have two simple ways to run all the Espresso tests:

A. Using Android Studio (Recommended for Beginners)
Navigate to the app/src/androidTest/ directory in the Project window.

Right-click on the main test package (e.g., com.example.yourapp.test).

Select "Run 'Tests in 'com.example.yourapp.test'".

Android Studio will install the test APK, run the tests on your connected emulator, and display the results in the "Run" window.

B. Using the Terminal (Advanced/CI Prep)
You can run the tests directly using the Gradle Wrapper. This command cleans the project, builds the necessary APKs, and executes all connected instrumentation tests.

Open the Terminal tab in Android Studio (or your system terminal).

Navigate to the root of the project directory.

Execute the following command:

Bash

./gradlew connectedDebugAndroidTest
3.3. Viewing Test Results
After the command completes, an HTML report is generated that you can open in your browser for a clear summary:

Report Location: [Project Root]/app/build/reports/androidTests/connected/index.html

4. Understanding the Tests
All UI tests for this project are written in Kotlin and are located in the app/src/androidTest/ directory.

Key Concepts:
Espresso: The testing framework used to interact with the UI elements (e.g., click buttons, type text, scroll).

Test Annotation (@Test): Every function starting with this annotation is treated as a separate test case.

ViewMatchers: Used to find a specific UI element (e.g., onView(withId(R.id.login_button))).

ViewActions: Used to interact with the found element (e.g., .perform(click())).

ViewAssertions: Used to check if an element is in the expected state (e.g., .check(matches(isDisplayed()))).

Kotlin

// Example Espresso Test Snippet:
@Test
fun loginScenario_shouldShowDashboard() {
    // 1. Find the username field and type text
    onView(withId(R.id.username_input)).perform(typeText("testuser"))

    // 2. Find the password field and type text
    onView(withId(R.id.password_input)).perform(typeText("password123"), closeSoftKeyboard())

    // 3. Find the login button and click it
    onView(withId(R.id.login_button)).perform(click())

    // 4. Assert that the dashboard title is now displayed
    onView(withText("Welcome to Dashboard")).check(matches(isDisplayed()))
}
5. CI/CD Integration (Advanced)
This project is configured for Continuous Integration using a Jenkins Pipeline.

The Jenkinsfile
The file named Jenkinsfile in the project root defines the automated pipeline workflow:

Starts an Android Emulator (API 30).

Runs the connectedDebugAndroidTest Gradle task.

Publishes the Espresso test results to Jenkins.

Shuts down the emulator.

This ensures that every code change is validated automatically against the UI tests before deployment.
