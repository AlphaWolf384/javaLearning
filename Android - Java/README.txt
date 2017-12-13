Android - Android Work Directory
========

Android is being used for JKL project development and designed app to work with JKL.  Knowledge of
Java and XML will do sufficient however, I do recommend to learn how does Android app works.  
Android app uses applied Java programming language just like Arduino uses C programming.  
Comments will be hard to teach you but I'll try my best as I can.

Manifest describes the fundamental characteristics of the app and defines each of its components.
Java is file that contains Java codes, it will comes with three different files.  One is for writing,
one is for Android test, and one for computer test.  Res contains XML files defines the layout
for the activity's UI what you sees on your phone.

Gradle Scripts compile and build your app.  It will comes with two files with this name: one for
the project and one for the "app" module.

Goal is to create application that can take barcode scan and store it to list which it has option
to save it on Android or to Excel on Computer.

NOTE!!

Anything is abandoned will not be commented because they are intended to be abandoned with no interest
to come back.

Features
--------

- BarcodeTest
- JKL
- JKL_Bravo
- MyFirstApp
- ScannerApp

Installation
------------

ZXing ("Zebra Crossing") barcode scanning library for Java, Android is used in Android application.
ZXing can be downloaded from this github link: https://github.com/zxing/zxing. 

Content
-------

-> BarcodeTest *ABANDONED*

BarcodeTest was attempted test to use without ZXing library to use camera to take picture and read
the barcode data.  However, this was failed attempt and it was abandoned to move on to ZXing method.

-> JKL

JKL is initial project phase to scan and save it to list on Android.  Camera is itself button to
start scanning and it has option to back out to main screen.  There is list button to see what you
have scanned so far.  Problem is that list does not save itself every time you back out to MainScreen
or closed app. This bug is still WIP and this project is moved to JKL_Bravo for additional features.
I intended to use this for other purpose as framework base. Also, in Gradle Scripts, ZXing module
is added to build.gradle(Module:app) to get barcode scan working.  Same thing for other scanning app.

-> JKL_Bravo

JKL_Bravo was created after Alpha stage which it is JKL.  This was created for working with computer's
IP Address and Port number as Server Socket to send data results to computer and computer will have
it's own JAR to display data results.  Addition features are Connect/Disconnect, Input for IP Address
and Port Number, and Enter a message for test purpose.  Status is added to see if it is connecting
to IP Address or disconnected.  JKL_Bravo is most updated of this project and currently paused for
other developments.

-> MyFirstApp

The first app ever I made on my own is to write a message to second page which second page 
will display whatever I said in the message bar.  I used this in JKL_Bravo for debug purpose.

-> ScannerApp *ABANDONED*

This is scrap code created from BarcodeTest and I tried to improve it without libraries to use different
method.  This is failed attempted and abandoned same time as BarcodeTest.


License
-------

The project is licensed under the BSD license.
