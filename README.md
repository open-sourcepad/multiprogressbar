# MultiProgressbar
 Tri-colored customizable circular progressbar

#### Set progressbar width
``` kotlin
  multiProgressbar.setWidth(width:Float)
  ```
#### Set color for each progressbar
``` kotlin
  multiProgressbar.setColor(colorRes1:Int, colorRes2:Int, colorRes3:Int)
```
#### Set current progress, use -1 value if no changes required
``` kotlin
  multiProgressbar.setProgress(progress1:Float,progress2:Float,progress3:Float)
```

#### Via XML
```xml
<com.sourcepad.core.multiprogressbar.MultiProgressBar
    app:progress1Color="@color/x"
    app:progress2Color="@color/y"
    app:progress3Color="@color/z"
    app:progressWidth="10dp"/>
```

## Usage
TODO upload on bintray

