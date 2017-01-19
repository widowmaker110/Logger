# Logger
Android Library designed to help you more efficiently debug an entire project

## PREFACE ##
1. Project Synopsis 
2. Installation
3. Usage
4. Future Plans
5. License

### Project Synopsis ###

This project is intended for those working in large apps and need something to help them understand click paths with their respective files. With the help of this library, you don't have to remember every single file and what they do, you know exactly which ones you're hitting just by running the app.

### Installation ###

In your ```build.gradle``` (Project: **ProjectName**) file, place the following:

![Project Gradle](/images/project_gradle.png?raw=true "Project Gradle")

```sh
repositories { 
    jcenter()
    maven { url 'https://dl.bintray.com/alexander-miller110/Logger' }
}

```
In your ```build.gradle``` (Module: **app**) file, place the following:

![App Gradle](/images/app_gradle.png?raw=true "App Gradle")

```sh
dependencies {
    compile 'alexander-miller110:logger:0.1'
}
```

Click **Sync Now** and thats it!

### Usage ###

When you're doing development work, make sure to flip on the controlling boolean before you being. **Always turn this to false when releasing to production. Logging is expensive on the CPU**

TODO: configure that in the project

To reference it in your project, use the following code:
```sh
import widowmaker110.logger.Logger;

public class MainActivity extends AppCompatActivity {

Logger logger;

// always ensure the library is initialized before use
public void init(){
    if(logger == null)
        logger = new Logger();
}

// print what you need
public void someFunction(){
    logger.message("Hello World!");
}
}
```

The result:
```sh
01-18 21:59:02.545 3973-3994/? D/MainActivity.java - someFunction: Hello World!
```

The class name and function from the stacktrace is automatically generated. As the developer, you get to spend more time giving it the information it needs.

### Future Plans ###

1. The ability to choose between File Name, Class Name, Function Name, and Line Number through function parameters.
2. More to come

### License ###
```
MIT License

Copyright (c) 2017 Alexander Miller

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:
The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
