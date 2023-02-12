# M3U8 Parser

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=vincenzogovernali_M3U8Parser&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=vincenzogovernali_M3U8Parser)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=vincenzogovernali_M3U8Parser&metric=coverage)](https://sonarcloud.io/summary/new_code?id=vincenzogovernali_M3U8Parser)
[![](https://jitpack.io/v/vincenzogovernali/M3U8Parser.svg)](https://jitpack.io/#vincenzogovernali/M3U8Parser)

This library deals with parsing a content of type M3U8 into a list of *GenericModel*.

Add it in your root build.gradle at the end of repositories:
```
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```

Step 2. Add the dependency

```
dependencies {
        implementation 'com.github.vincenzogovernali:M3U8Parser:1.0.0'
}
```

Finally use the M3U8Parser class to parse the content via the *parse* method.