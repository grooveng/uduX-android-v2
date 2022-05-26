UduX Android V2
=====================================
The goal of this sample is to show how to implement an audio media app that works
across multiple form factors and provides a consistent user experience
on Android phones, tablets, Android Auto, Android Wear, Android TV, Google Cast devices,
and with the Google Assistant. 

To get started with UAMP please read the [full guide](docs/FullGuide.md).

![Screenshot showing UAMP's UI for browsing albums and songs](docs/images/1-browse-albums-screenshot.png "Browse albums screenshot")
![Screenshot showing UAMP's UI for playing a song](docs/images/2-play-song-screenshot.png "Play song screenshot")

Pre-requisites
--------------

- Android Studio 3.x

Getting Started
---------------

This sample uses the Gradle build system. To build this project, use the
"gradlew build" command or use "Import Project" in Android Studio.

Support
-------

- Check out the [FAQs page](docs/FAQs.md)
- Stack Overflow: http://stackoverflow.com/questions/tagged/android
> Setup process for building Udux to access its KMM module for IOS implementation.

## Table of Contents
* [General Info](#general-information)
* [Technologies Used](#technologies-used)
* [Setup](#setup)
* [Usage](#usage)
* [Project Status](#project-status)
<!-- * [License](#license) -->


## General Information
- Clean Udux project for build on new pc.
<!-- You don't have to answer all the questions - just the ones relevant to your project. -->


## Technologies Used
- Kotlin and XML(No composables yet)
- Exxoplayer
- Mac Pro Big Sur - RAM 16Gb/ Mac Pro Monterrey
- Android Studio - Artic Fox and above
- Jdk 11 and above, should come embedded with the new Android Studio


## Setup
- Pull project from the latest git branch(dev) on the repo and check out to the feature branches.
- Open Android Studio, Import Project, wait for Build to finish

## PROJECT AND MODULE LEVEL DOCUMENTATIONS
This project uses different modules which are split primarily by features.
PRIMARY MODULE is the default app module. It only carries the previous splashscreen page.
The Authentication module is a standalone feature that can be run individually as an app it. This module contains everything that has to do with authentication(all forms of registration and login in)
The mediaplayer module similarly is also a standalone feature module that contains everything involved in playing music. For more info check the full guide for the mediaplayer module [full guide](docs/FullGuide.md)

## Project Status
Project is:  _currently being worked on_.




## Room for Improvement
Some of the IOS libraries are not working the firebase, these involves the FirebaseAuth, Please kindly into it that.

