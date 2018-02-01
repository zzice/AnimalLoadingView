

> Fork from [https://github.com/Rogero0o/CatLoadingView](https://github.com/Rogero0o/CatLoadingView)

loadingview

![dog_loading_original](https://github.com/zzice/AnimalLoadingView/blob/master/images/dog_loading_original.gif)



### Added compared to the original

#### Provide some methods

```java
// set view custom background resource
setBgResId(@DrawableRes int bgResId)
```

```java
// set loading text
setMsgText(CharSequence msgText) || setMsgResId(@StringRes int msgResId)
```



![loading_view_google](https://github.com/zzice/AnimalLoadingView/blob/master/images/loading_view_google.gif)



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



#### Use it in code

```java
AnimalLoadingView loadingView = new AnimalLoadingView();
// config loadingview
// Example
// loadingView.setMsgText("Google大法好");
/**
 * @param FragmentManager manager
 * @param String tag
 */
loadingView.show(manager, tag);
```



### TODO

- custom animal loading view # add dog , cat and many more


