# ProminentColor
Android Library to get average/prominent color of bitmap/drawable

[![](https://jitpack.io/v/mathiazhagan01/ProminentColor.svg)](https://jitpack.io/#mathiazhagan01/ProminentColor)
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-ProminentColor-blue.svg?style=flat-square)](https://android-arsenal.com/details/1/5979)
[![Codix](https://codix.io/gh/badge/mathiazhagan01/ProminentColor)](https://codix.io/gh/repo/mathiazhagan01/ProminentColor)
[![](https://az743702.vo.msecnd.net/cdn/kofi4.png?v=b)](https://ko-fi.com/A8817MW)
[![](http://api.flattr.com/button/flattr-badge-large.png)](https://flattr.com/@mathiazhagan01)

If you like the library, please rate us on <a href="https://codix.io/gh/repo/mathiazhagan01/ProminentColor">codix.io!</a>

### Gradle

#### Step 1. Add the JitPack repository to your build file
  Add it in your root build.gradle at the end of repositories:
  
``` gradle
allprojects {
	repositories {
		// ...
		maven { url "https://jitpack.io" }
	}
}
```

#### Step 2. Add the dependency

``` gradle
dependencies {
	compile 'com.github.mathiazhagan01:ProminentColor:v1.0'
}
```	  

### Maven

#### Step 1. Add the JitPack repository to your build file

``` xml
<repositories>
	<repository>
		<id>jitpack.io</id>
		<url>https://jitpack.io</url>
	</repository>
</repositories>
```  

#### Step 2. Add the dependency

``` xml	
<dependency>
	<groupId>com.github.mathiazhagan01</groupId>
	<artifactId>ProminentColor</artifactId>
	<version>V1.0</version>
</dependency>
```

![Screenshot](./1.png)

![Screenshot](./2.png)

![Screenshot](./4.png)

### Example 1

``` java
ProminentColor prominentColor = new ProminentColor();   

prominentColor.setBitmap(bitmap);
prominentColor.getColor(new ProminentColorListener() {
	@Override
	public void onGettingColor(int color) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			getWindow().setStatusBarColor(color)
		}

		colorButton.setBackgroundColor(color);
	}
});
```

### LICENSE

	ProminentColor library for Android
	Copyright (c) 2017 Mathiazhagan Dinesh (http://github.com/mathiazhagan01).

	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at

	http://www.apache.org/licenses/LICENSE-2.0

	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
