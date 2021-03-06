# TV-Shows-MVVM



![dribbble-x2](https://user-images.githubusercontent.com/51374446/135772739-0641542a-478b-468e-a1aa-6b2f836b4fd7.png)



```gradle

  compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }

    buildFeatures {
        dataBinding true
    }

```


```gradle

dependencies {

    //Material Design
    implementation 'com.google.android.material:material:1.2.1'

    //Retrofit & JSON
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'

    //Picasso
    implementation 'com.squareup.picasso:picasso:2.71828'

    //Life Cycle Extensions
    implementation 'androidx.lifecycle:lifecycle-extensions:2.2.0'

    //Room and RXJava Support
    implementation 'androidx.room:room-runtime:2.2.5'
    annotationProcessor 'androidx.room:room-compiler:2.2.5'
    implementation 'androidx.room:room-rxjava2:2.2.5'

    //Rxjava
    implementation 'io.reactivex.rxjava2:rxandroid:2.0.1'
    //Scaleable Size Units
    implementation 'com.intuit.sdp:sdp-android:1.0.6'
    implementation 'com.intuit.ssp:ssp-android:1.0.6'

    //Rounded Image View
    implementation 'com.makeramen:roundedimageview:2.3.0'
}

```
