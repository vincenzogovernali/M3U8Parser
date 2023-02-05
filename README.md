# M3U8 Parser

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=vincenzogovernali_M3U8Parser&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=vincenzogovernali_M3U8Parser)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=vincenzogovernali_M3U8Parser&metric=coverage)](https://sonarcloud.io/summary/new_code?id=vincenzogovernali_M3U8Parser)

This library deals with parsing a content of type M3U8 into a list of *GenericModel*.

To use this library, simply import the dependency into your Pom.

```
<dependency>
    <groupId>org.vexen1999</groupId>
    <artifactId>M3U8Parser</artifactId>
    <version>1.0.0</version>
</dependency>
```

Finally use the M3U8Parser class to parse the content via the *parse* method.