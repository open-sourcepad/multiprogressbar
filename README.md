# MultiProgressbar
 Tri-colored customizable circular progressbar
 
 <p>
<img src="https://user-images.githubusercontent.com/5505872/62622916-1d354d00-b952-11e9-89f2-e81efbe001ff.png" width="100" height = "100"/>
<img src="https://user-images.githubusercontent.com/5505872/62622917-1dcde380-b952-11e9-90e7-4ec26edd86a0.png" width="100" height = "100"/>
 <img src="https://user-images.githubusercontent.com/5505872/62622918-1e667a00-b952-11e9-941a-d81f354d8208.png" width="100" height = "100"/>
 <img src="https://user-images.githubusercontent.com/5505872/62622920-1e667a00-b952-11e9-982c-86ce3f47a10c.png" width="100" height = "100"/>
 </p>


#### Set progressbar width
``` kotlin
  multiProgressbar.setWidth(width:Float)
  ```
#### Set color for each progressbar
``` kotlin
  multiProgressbar.setColor(colorRes1:Int, colorRes2:Int, colorRes3:Int)
```
#### Set current progress, use -1 value if no changes required or just use the named parameters to specify which progress to change
``` kotlin
  multiProgressbar.setProgress(progress1:Float,progress2:Float,progress3:Float)
  multiProgressbar.setProgress(progress1=60f)

```

#### Via XML
```xml
<com.sourcepad.core.multiprogressbar.MultiProgressBar
    app:progress1Color="@color/yellow"
    app:progress2Color="@color/blue"
    app:progress3Color="@color/red"
    app:progressWidth="10dp"/>
```

## Usage
In your build.gradle, add the following:
``` groovy
  dependencies{
    implementation 'com.sourcepad.opensource:multiprogressbar:0.1'
  }
  
  repositories {
    maven{
        url  "https://sourcepad.bintray.com/opensource"
    }
  }

```

