

### Usage

#### Gradle

##### Step 1.  Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

```gr
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```

##### Step 2. Add the dependency

```gr
dependencies {
	compile 'com.github.zzice:AnimalLoadingView:0.0.1'
}

```

#### Maven

```xml
<repositories>
	<repository>
		<id>jitpack.io</id>
		<url>https://jitpack.io</url>
	</repository>
</repositories>
```

##### Add the dependency

```xml
<dependency>
	<groupId>com.github.zzice</groupId>
	<artifactId>AnimalLoadingView</artifactId>
	<version>0.0.1</version>
</dependency>
```




