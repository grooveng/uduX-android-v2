UduX Android V2
=====================================

## General Information
- Clean Udux project for build on new pc.


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
- PRIMARY MODULE is the default app module. It only carries the previous splashscreen page.
- The Authentication module is a standalone feature that can be run individually as an app it. This module contains everything that has to do with authentication(all forms of registration and login in)
- The mediaplayer module similarly is also a standalone feature module that contains everything involved in playing music. For more info check the full guide for the mediaplayer module [full guide](docs/FullGuide.md)

## Project Status
Project is:  _currently being worked on_.




## Room for Improvement
Optimize gradle dependencies for all modules to make it easier to maintain
