Java - Java Work Directory
========

Java programming language is widely popular for development in application including Android application.
Java is used for JKL frame base and Android app. Apache Poi is used for exporting results to Excel.

Apache Poi API is a project run by the Apache Software Foundation, and previously a sub-project
of the Jakarta Project, provides pure Java libraries for reading and writing files in Microsoft
Office formats, such as Word, PowerPoint, and Excel.

https://poi.apache.org/


Features
--------

Learning - File of java classes where I learned how to program Java and adapt to their syntax using
my knowledge of C/C++ programming.  If one desired to learn how to programming in Java then this link
is what I used to learn. https://www.udemy.com/java-tutorial/learn/v4/overview

JKL - Java Koolness Lab

Android - Android Development using Java and README is included

Installation
------------

I used Eclipse for Java programming and Android Studio for Android development using applied Java.
Apache Poi is needed to be installed for JKL otherwise export excel spreadsheet function won't work.

Eclipse Java Oxygen - https://www.eclipse.org/home/index.php
Android Studio - https://developer.android.com/studio/index.html
Apache Poi - 
https://poi.apache.org/

Content
-------

JKL = Split to five different sections
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> JKL Server (Included ExcelFunction.java)

This is most updated working project than another sections.  I used this to create JKL.jar application
and all features except for Import function works as I expected to.  IP Address is from host computer
IP Address and port number is default to 7777.  Ability to change will be changed in the future.
'Ping' Pong feature is added to test button features and will be removed when full version is done.
Import Feature and Export feature are in ExcelFunction.java and are still WIP. Import feature is 
disabled because of bugs kept program from running but Export feature will export only results 
to new created 'Example.xls.' This can be used as 'hard-bone' framework to build a way around it and good knowledge of Java
programming will be very benefical. 

Barcode Application for Windows and Android.  JKL can be used to scan aka emulation of keyboard as
long as it has function to enter after it was scanned.  I developed Android app to work with JKL
and offline app.  Android app can be used as input as long as it is connecting to same IP Address
and Port number.  JKL can be used for frame base to build around it

-> JKL ServerTest

ServerTest is for testing purpose to test connection between Computer and Android app to see if
I can send anything from Android to Computer and make Computer to say same thing as Android input.

-> JKLUSBScanner

JKLUSBScanner is another test purpose to see if keyboard emulation will work as it types and press enter
as nice versa.  This is used with GUI to display only Android inputs.

-> USBScannerTest

This is test purpose to print scan results on output.

License
-------

The project is licensed under the BSD license.