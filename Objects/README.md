# Java-Kotlin Fall 2020 Project 1

## Description of the project

---

- Create a Java class with various properties and methods
- Use unit tests to ensure that the class is working as expected

<br> 

## Description of the Mandolin class

---

<br>

### Properties

- strings: The amount of strings currently on the instrument (int)
- stringMax: The total number of strings allowed on the instrument (int)
- inTune: The status of whether the instrument is tuned or not (boolean)
    - Assumes a new instrument is already tuned
- playing: The status of whether the instrument is being played or not (boolean)
    - A new instrument is not being played
    - The mandolin must be in tune before it can be played
- playedHours: How many hours the instrument has been played since it was last tuned (double)
    - A mandolin goes out of tune after 10 hours
    - Must be re-tuned before it can be played again
- volume: the volume of the mandolin while it is being played (double)
    - The default volume of the mandolin while being played is 5
    - It resets to 0 when it is not being played
    - The volume can range between 0 and 10

---

<br>

### Methods


- getStrings: Returns the value of the strings on the mandolin
- setStrings: Allows you to put new strings on the instrument
    - Ranges from 0 to the number of tuning pegs on the mandolin
    - After changing the strings the instrument is not in tune
    - After changing the strings the played hours is reset to 0
- getStringMax: Returns the number of tuning pegs on the instrument
- getInTune: Returns the status of the instruments tuning
- setInTune: Sets the tuning to true, and resets the played hours to 0;
- getPlaying: Returns whether or not the instrument is being played
- startPlaying: Takes one argument for how many hours the mandolin will be played and sets the played hours equal to that
    - The instrument must be in tune before it can be played
    - The hours must be greater than 0
    - By default it sets the volume equal to 5
- stopPlaying: Sets the volume to 0 and the playing boolean to false
- getPlayedHours: Returns the amount of hours the mandolin has been played since the last tuning
- getVolume: Returns the value of the volume for the mandolin
- setVolume: Sets the volume of the mandolin to a given double
    - The mandolin must be playing
    - The volume can only be between 0 and 10

---

