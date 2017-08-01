# jPUBG Android

[![Build Status](https://travis-ci.org/Lukaszpg/jPUBG.svg?branch=master)](https://travis-ci.org/Lukaszpg/jPUBG)
[![GitHub license](https://img.shields.io/badge/license-MIT-blue.svg)](https://raw.githubusercontent.com/Lukaszpg/jPUBG/master/LICENSE)
[![Maven Central](https://img.shields.io/maven-central/v/pro.lukasgorny/jpubg.svg)](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22pro.lukasgorny%22)
[![Javadocs](http://www.javadoc.io/badge/pro.lukasgorny/jpubg.svg)](http://www.javadoc.io/doc/pro.lukasgorny/jpubg)

## Overview

Simple API wrapper written in Java for retriving statistics from http://pubgtracker.com API. his is Android version without Java 8 features to provide full compatibility with Android.
You need valid pubgtracker.com API KEY in order to use my API wrapper. You can get one here: https://pubgtracker.com/site-api.

## How to get

### 1. Using Maven

It's simple - just add few lines below to your pom.xml and you're good to go! X.X.X is of course preferable version of the library.

```
<dependency>
      <groupId>pro.lukasgorny</groupId>
      <artifactId>jpubg-android</artifactId>
      <version>X.X.X</version>
</dependency>
```

### 2. As a standalone library

To get the library file compiled with Java 1.8.0_131 please go to [releases](https://github.com/Lukaszpg/jPUBG-Android/releases) and download latest available version. Add it to your project classpath, then get the jPUBG API wrapper object from the factory with your api key and start fetching data! 


## Example usage

### Simple FilterCriteria 
```java
// Always remember to specify your API key
JPubg jPubg = JPubgFactory.getWrapper(YOUR_API_KEY);

// We're filtering by mode here. If you don't want to filter by certain criteria, just don't pass it to the filter
FilterCriteria criteria = new FilterCriteria();
criteria.setMode(PUBGMode.solo);

// You can also create object of FilterCriteria class with constructor with arguments
FilterCriteria criteria2 = new FilterCriteria(PUBGMode.solo, PUBGRegion.eu, PUBGSeason.PRE2_2017);

// If you would like to stop filtering by that criteria, just pass the null value
// If no criterias are specified, player object without data filtering will be returned
criteria.setMode(null);

// All solo matches from all seasons are being returned here
Player player = jPubg.getByNickname("TheHusar", criteria);
```

### Stat from season filtering

WARNING! You have to be very specific with filters if you want to retrieve single stat from season data, because if more than one season data will be present in player object, exception will be called.

```java
// Always remember to specify your API key
JPubg jPubg = JPubgFactory.getWrapper(YOUR_API_KEY);

// We're filtering by mode, region and season here
FilterCriteria criteria = new FilterCriteria();
criteria.setMode(PUBGMode.solo);
criteria.setRegion(PUBGRegion.eu);
criteria.setSeason(PUBGSeason.PRE2_2017);

Player player = jPubg.getByNickname("TheHusar", criteria);

// We would like to retrieve best rating for player "TheHusar" for season PRE2_2017
Stat stat = jPubg.getPlayerMatchStatByStatName(player, PUBGStat.BEST_RATING);

// You can get season name directly from stat object
System.out.println("Player " + player.getPlayerName() + " best rating in season: " + stat.getSeason().getSeasonName() + " is: " + stat.getStringValue());
```

## Compiling on your own

As this is completely Open Source project, you may clone the code from the Github and compile the library on your own. 
1. Be sure that you have Maven (at least version 3.3.9) installed.
2. Go to the directory where you have cloned the repository.
3. Perform ***mvn clean package*** command and wait a minute.
4. Compiled .jar file will appear in the ***/target*** folder. The one you should use is named ***jPUBG-Android-X.X.X-SNAPSHOT-jar-with-dependencies.jar***, where X.X.X is of course version of the application.

## Documentation

Documentation is available on: http://www.javadoc.io/doc/pro.lukasgorny/jpubg-android

JavaDocs are updated once per 24h after new version release.
