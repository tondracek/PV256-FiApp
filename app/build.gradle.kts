import com.google.protobuf.gradle.*

//plugins {
//    alias(libs.plugins.androidApplication)
//    alias(libs.plugins.jetbrainsKotlinAndroid)
//}
plugins {
//    id("com.android.library")
    id("com.android.application")
    id("com.google.protobuf")
    kotlin("android")
    kotlin("kapt")
//    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.fiapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.fiapp"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.11"
    }
//    packaging {
//        resources {
//            excludes += "/META-INF/{AL2.0,LGPL2.1}"
//        }
//    }

}

protobuf {
    protoc {
        // Ensure that you are using a version compatible with your protobuf runtime libraries
        artifact = "com.google.protobuf:protoc:${Versions.protobuf}:osx-x86_64"
    }
    plugins {
        id("javalite") {
            // Make sure this version is compatible with your runtime version
            // linux version
//            artifact = "com.google.protobuf:protoc-gen-javalite:${Versions.java}"

            // mac 3.0.0 version + :osx-x86_64
            artifact = "com.google.protobuf:protoc-gen-javalite:${Versions.java}:osx-x86_64"
        }
        id("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:${Versions.grpc}"
        }
        id("grpckt") {
            artifact = "io.grpc:protoc-gen-grpc-kotlin:1.4.1:jdk8@jar"
        }
    }
    generateProtoTasks {
        all().forEach { task ->
            task.builtins {
                java { }
            }

            task.plugins {
                id("javalite") {
                    option("lite")
                }
                id("grpc") {
                    option("lite")
                }
                id("grpckt") {
                    option("lite")
                }
            }
        }
    }
}

dependencies {
    // GRPC
    api(Dependencies.Grpc.javaxAnnotation)
    api(Dependencies.Grpc.protobufLite)
    api(Dependencies.Grpc.grpcOkHttp)
    api(Dependencies.Grpc.grpcStub)
    api(Dependencies.Grpc.grpcStub2)
    api(Dependencies.Grpc.grpcJava) {
        exclude("com.google.protobuf", "protobuf-java")
        exclude("com.google.protobuf", "protobuf-lite")
        exclude("com.google.protobuf", "protobuf-javalite")
    }
    api(Dependencies.Grpc.grpcAndroid)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}