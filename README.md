# ads2_sdk_savedoge SDK 接入说明

## 1. 环境要求
### （1）Android Studio Ladybug+
### （2）minSdk 24+
### （3）targetSdk 35
### （4）Kotlin 1.9+
### （5）Java 17
### （6）真机环境测试

## 2. 导入 SDK
### （1）配置 Maven 仓库
在项目根目录的 build.gradle 添加 Maven 仓库和jitpack 仓库：
项目根目录 build.gradle 代码如下：
```gradle
allprojects { 
    repositories {
        maven {url "https://maven.bidderdesk.com/repository/maven-releases/" }
        google()
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}
```
### （2）配置 build.gradle
在模块的 build.gradle 中添加依赖：
```gradle
android {
 	 compileOptions {
 	  sourceCompatibility = JavaVersion.VERSION_17
 	  targetCompatibility = JavaVersion.VERSION_17
 	  //启用核心库脱糖（关键配置）
      coreLibraryDesugaringEnabled true
 	 }
 	 kotlinOptions { jvmTarget = "17" }
 	}

 	dependencies {
 		implementation 'com.github.HomepageMeta:ads2_sdk_savedoge:v1.0.6'

 		// 3. 添加核心库脱糖的依赖（必须）
    	coreLibraryDesugaring 'com.android.tools:desugar_jdk_libs:2.1.5'
 	}
```
###  (3) 配置 ProGuard 混淆规则
在 proguard-rules.pro 中添加：
```xml
-keep class androidx.**{ *; }
 		-keep class kotlin.**{ *; }
 		-keep class kotlinx.**{ *; }
 		-keep class **.R
 		-keep class **.R$* { *; }
 		-keepclassmembers class * {
 			public static ** INSTANCE;
 		}
 		-keep,allowshrinking,allowoptimization class com.crocs.sdk {
 			<init>(...); 
 			public <methods>;
 		}
 		-keep class com.monetize.core.** { *; }
 		-dontwarn com.monetize.core.**
 		-keep class com.crocs.sdk.sw.** { *; } 
 		-dontwarn com.crocs.sdk.**
```
## 3.API接口
### （1）引入类
```kotlin
import com.xn.ads2.ads2_sdk_savedoge.SaveDogeHelper
```

### （2）初始化
在 Activity 的 onCreate ⽅法中调⽤：
```kotlin
//SDK 会⾃动检查⽹络状态，⽆⽹络时会跳过初始化，并且初始化是异步的，不会阻塞主线程
SaveDogeHelper.saveDogeInit(this)
```

### （3)开启变现功能
```kotlin
SaveDogeHelper.saveDogeStart(context)
```
### （4)网络权限配置
确保在 AndroidManifest.xml 中添加⽹络权限：
```xml
 	<uses-permission android:name="android.permission.INTERNET" />
 	<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
```