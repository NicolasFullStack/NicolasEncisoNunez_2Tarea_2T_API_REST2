plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.nicolasencisonunez_2tarea_2t_api_rest2"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.nicolasencisonunez_2tarea_2t_api_rest2"
        minSdk = 29
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    // 2º- habilitar   los elementos buildFeatures
    //Caracteristica que facilita el acceso directo a las vistas(copilot resumido) lo recomienda google
    buildFeatures{
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)


    // 3. Agrega las dependencias en el archivo build.gradle:
    // implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.6")
    // cambio en la implementacion a 1.7.3 ya que en el ejemplo de clase me funciona
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")//conversor y serializar json
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")//uso de corrutinas para establecer peticiones asincronas
    //Implementacion  de libreria picasso para la Gestion de imagenes.
    implementation ("com.squareup.picasso:picasso:2.71828")


    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}