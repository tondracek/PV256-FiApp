object Version {
    const val apolloVersion = "1.3.2"
    const val pagingVersion = "2.1.2"

    const val androidPlayCore = "1.6.4"

    const val appCompat = "1.1.0"
    const val supportV4 = "1.0.0"
    const val supportDesign = "1.3.0-alpha04"
    const val supportCardView = "1.0.0"
    const val supportRecyclerView = "1.1.0"
    const val supportCore = "1.12.0"
    const val fragment = "1.2.1"

    const val roomVersion = "2.3.0-alpha03"

    const val lifecycle = "2.7.0"

    const val constraintVersion = "1.1.3"

    const val playServicesVersion = "17.0.0"

    const val glideVersion = "4.10.0"

    const val workVersion = "2.2.0"

    const val robolectricVersion = "4.5-alpha-1"

    const val jackson = "2.10.1"

    const val rxAndroid = "2.1.1"
    const val rxJava = "2.2.15"
    const val rxBinding = "2.2.0"

    const val firebaseMessaging = "20.1.0"
    const val firebaseCore = "17.2.1"
    const val firebaseAuth = "19.2.0"
    const val firebaseAuthUI = "6.2.0"
    const val playServiceLocation = "17.0.0"
    const val googlePublisher = "rev95-1.25.0"
    const val googleService = "4.3.5"

    const val facebookLogin = "4.42.0"

    const val googleServiceBase = "17.1.0"
    const val googleServiceIdentity = "17.0.0"
    const val googleServiceAuth = "17.0.0"
    const val googleServiceAuthApiPhone = "17.3.0"

    const val beacon = "2.16.3"

    const val kontaktio = "4.1.0"

    const val bugsnag = "4.21.1"

    const val zxing = "3.4.0"

    const val flashBar = "1.0.3"

    const val stepper = "4.3.1"

    const val swipeRevealLayout = "1.4.1"

    const val rotateLayout = "3.0.0"

    const val leakCanary = "2.5"

    const val dagger = "2.26"

    const val arVersion = "1.13.0"

    const val assistedInject = "0.5.2"

    const val shimmer = "0.5.0"

    const val trueTime = "3.4"
    const val threeten = "1.2.2"

    const val rxDogTag = "0.3.0"
    const val sequenceLayout = "1.0.11"
}

object Shimmer {
    val shimmer = "com.facebook.shimmer:shimmer:${Version.shimmer}"
}
object SequenceLayout {
    val sequenceLayout = "com.github.transferwise:sequence-layout:${Version.sequenceLayout}"
}

object AndroidPlay {
    val core = "com.google.android.play:core:${Version.androidPlayCore}"
}

object SupportLibraries {
    val appCompat = "androidx.appcompat:appcompat:${Version.appCompat}"
    val appResources = "androidx.appcompat:appcompat-resources:${Version.appCompat}"
    val support = "androidx.legacy:legacy-support-v4:${Version.supportV4}"
    val design = "com.google.android.material:material:${Version.supportDesign}"
    val cardView = "androidx.cardview:cardview:${Version.supportCardView}"
    val recyclerView = "androidx.recyclerview:recyclerview:${Version.supportRecyclerView}"
    val core = "androidx.core:core-ktx:${Version.supportCore}"
    val ui = "androidx.compose.ui:ui:1.6.5"
    val material1 = "androidx.compose.material:material:1.0.1"
    val activity = "androidx.activity:activity-compose:1.8.2"
    val navigation = "androidx.hilt:hilt-navigation-compose:1.0.0"
    val navigationCompose = "androidx.navigation:navigation-compose:2.5.3"
    val fragment = "androidx.fragment:fragment-ktx:${Version.fragment}"
    val material3 = "androidx.compose.material3:material3:1.2.1"
}

object Glide {
    val glide = "com.github.bumptech.glide:glide:${Version.glideVersion}"
    val glideCompiler = "com.github.bumptech.glide:compiler:${Version.glideVersion}"
    val glideIntegration = "com.github.bumptech.glide:okhttp3-integration:${Version.glideVersion}"
}

object Lifecycle {
    val extension = "androidx.lifecycle:lifecycle-extensions:${Version.lifecycle}"
    val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.lifecycle}"
    val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:${Version.lifecycle}"
    val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.lifecycle}"
    val savedstate = "androidx.lifecycle:lifecycle-viewmodel-savedstate:1.2.1"
}

object Firebase {
    val bom = "com.google.firebase:firebase-bom:26.5.0"
    val messaging = " com.google.firebase:firebase-messaging-ktx:"
    val analytics  = "com.google.firebase:firebase-analytics-ktx"
    val auth = "com.google.firebase:firebase-auth:${Version.firebaseAuth}"
    val authUI = "com.firebaseui:firebase-ui-auth:${Version.firebaseAuthUI}"
    val core = "com.google.firebase:firebase-core:${Version.firebaseCore}"
}

object Facebook {
    val facebookLogin = "com.facebook.android:facebook-login:${Version.facebookLogin}"
}

object GoogleService {
    val publisher = "com.google.apis:google-api-services-androidpublisher:v3-${Version.googlePublisher}"
    val playServiceLocation = "com.google.android.gms:play-services-location:${Version.playServiceLocation}"
    val playServiceMaps = "com.google.android.gms:play-services-maps:${Version.playServicesVersion}"
    val googleService = "com.google.gms:google-services:${Version.googleService}"
    val googleServicesBase = "com.google.android.gms:play-services-base:${Version.googleServiceBase}"
    val googleServicesIdentity = "com.google.android.gms:play-services-identity:${Version.googleServiceIdentity}"
    val googleServicesAuth = "com.google.android.gms:play-services-auth:${Version.googleServiceAuth}"
    val googleServicesAuthApiPhone = "com.google.android.gms:play-services-auth-api-phone:${Version.googleServiceAuthApiPhone}"
}

object Jackson {
    val core = "com.fasterxml.jackson.core:jackson-core:${Version.jackson}"
    val annotations = "com.fasterxml.jackson.core:jackson-annotations:${Version.jackson}"
    val databind = "com.fasterxml.jackson.core:jackson-databind:${Version.jackson}"
}

object Paging {
    val paging = "androidx.paging:paging-runtime-ktx:${Version.pagingVersion}"
    val pagingRxjava = "androidx.paging:paging-rxjava2-ktx:${Version.pagingVersion}"
}

object Room {
    val roomRuntime = "androidx.room:room-runtime:${Version.roomVersion}"
    val roomCompiler = "androidx.room:room-compiler:${Version.roomVersion}"
    val roomRxjava = "androidx.room:room-rxjava2:${Version.roomVersion}"
}

object Apollo {
    val apolloRuntime = "com.apollographql.apollo:apollo-runtime:${Version.apolloVersion}"
    val apolloRxjava = "com.apollographql.apollo:apollo-rx2-support:${Version.apolloVersion}"
    val apolloHttp = "com.apollographql.apollo:apollo-http-cache:${Version.apolloVersion}"
    val apolloGradlePlugin = "com.apollographql.apollo:apollo-gradle-plugin:${Version.apolloVersion}"
}

object Rxjava {
    val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Version.rxAndroid}"
    val rxJava = "io.reactivex.rxjava2:rxjava:${Version.rxJava}"
    val rxBinding = "com.jakewharton.rxbinding2:rxbinding:${Version.rxBinding}"
    val rxDogTag = "com.uber.rxdogtag:rxdogtag:${Version.rxDogTag}"
}

object Dagger {
    val dagger = "com.google.dagger:dagger-android:${Version.dagger}"
    val daggerSupport = "com.google.dagger:dagger-android-support:${Version.dagger}"
    val daggerCompiler = "com.google.dagger:dagger-compiler:${Version.dagger}"
    val daggerAndroidProcessor = "com.google.dagger:dagger-android-processor:${Version.dagger}"

    val assistedInjectAnnotation = "com.squareup.inject:assisted-inject-annotations-dagger2:${Version.assistedInject}"
    val assistedInjectProcessor = "com.squareup.inject:assisted-inject-processor-dagger2:${Version.assistedInject}"
    val inflationInject = "com.squareup.inject:inflation-inject:${Version.assistedInject}"
    val inflationInjectProcessor = "com.squareup.inject:inflation-processor:${Version.assistedInject}"
}

object Annotations {
    val annotation = "javax.annotation:jsr250-api:1.0"
    val inject = "javax.inject:javax.inject:1"
}

object WorkManager {
    val workManager = "androidx.work:work-runtime-ktx:${Version.workVersion}"
    val workManagerRx = "androidx.work:work-rxjava2:${Version.workVersion}"
}

object ViewsLibraries {
    val instaDotView = "com.github.hrskrs:InstaDotView:1.1"
    val photoView = "com.github.chrisbanes:PhotoView:2.3.0"
    val indefinitePagerIndicator = "com.ryanjeffreybrooks:indefinitepagerindicator:1.0.10"
    val youtubePlayer = "com.pierfrancescosoffritti.androidyoutubeplayer:core:8.0.1"
    val snackbar = "com.nispok:snackbar:2.11.0"
    val roundCornerProgressBar = "com.akexorcist:RoundCornerProgressBar:2.0.3"
    val customGauge = "pl.pawelkleczkowski.customgauge:CustomGauge:1.0.4"
    val constraintLayout = "androidx.constraintlayout:constraintlayout:${Version.constraintVersion}"
    val simpleBarcodeScanner = "com.github.bobekos:SimpleBarcodeScanner:1.0.23"
    val edittextField = "com.poovam:pin-edittext-field:1.2.1"
    val crystalRangeSeekbar = "com.crystal:crystalrangeseekbar:1.1.3"
}

object Bugsnag {
    val bugsnag = "com.bugsnag:bugsnag-android:${Version.bugsnag}"
}

object Beacon {
    val beacon = "org.altbeacon:android-beacon-library:${Version.beacon}"
}

object Kontaktio {
    val kontaktio = "com.kontaktio:sdk:${Version.kontaktio}"
}

object Zxing {
    val zxing = "com.google.zxing:core:${Version.zxing}"
}

object Snackbar {
    val flashBar = "com.andrognito.flashbar:flashbar:${Version.flashBar}"
}

object Stepper {
    val stepper = "com.stepstone.stepper:material-stepper:${Version.stepper}"
}

object SwipeRevealLayout {
    val swipeRevealLayout = "com.chauthai.swipereveallayout:swipe-reveal-layout:${Version.swipeRevealLayout}"
}

object RotateLayout {
    val rotateLayout = "rongi.rotate-layout:rotate-layout:${Version.rotateLayout}"
}

object LeakCanary {
    val leakCanary = "com.squareup.leakcanary:leakcanary-android:${Version.leakCanary}"
}

object TestingLibraries {
    val junit = "junit:junit:4.12"
    val core = "androidx.test:core:1.2.0"
    val testRunner = "androidx.test:runner:1.2.0"
    val espressoCore = "androidx.test.espresso:espresso-core:3.2.0"
    val roomTest = "androidx.room:room-testing:${Version.roomVersion}"
    val pagingCommonTest = "androidx.paging:paging-common-ktx:${Version.pagingVersion}"
    val robolectric = "org.robolectric:robolectric:${Version.robolectricVersion}"
    val mockito = "com.nhaarman.mockitokotlin2:mockito-kotlin:2.2.0"
    val mockitoInline = "org.mockito:mockito-inline:2.13.0"
    val mockk = "io.mockk:mockk:1.9.3"

}

object Time {
    val trueTime = "com.github.instacart.truetime-android:library-extension-rx:${Version.trueTime}"
    val threetenabp = "com.jakewharton.threetenabp:threetenabp:${Version.threeten}"
}

object Tor {
    val tor = "org.torproject:tor-android-binary:0.4.4.6"
}

object Ar {
    val ar = "com.google.ar.sceneform:plugin:${Version.arVersion}"
    val arUx = "com.google.ar.sceneform.ux:sceneform-ux:${Version.arVersion}"
}

object Timber {
    private object Versions {
        const val timber = "4.7.1"
    }

    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
}

object Versions{
    const val kotlinVersion = "1.9.23"

    const val buildGradle = "8.3.1"

    // grpc
    const val protobuf = "3.21.1"
    const val protobufLite = "3.0.1"
    const val javaxAnnotation = "1.3.2"
    const val grpc = "1.62.2"
    const val grpcKotlin = "0.1.1"
    const val java = "3.0.0"

    const val reactiveGrpcVersion = "1.2.4"

    // navigation components
    const val navigationComponents = "2.3.0-alpha02"


    const val gradlePlugin = "com.android.tools.build:gradle:${Versions.buildGradle}"

}

object Dependencies {

    object Plugins {
        const val detekt = "io.gitlab.arturbosch.detekt"
        const val ktlint = "org.jlleitschuh.gradle.ktlint"
        const val templates = "com.thefuntasty.mvvm.android-templates"

        const val grpc = "grpc"
        const val grpckt = "grpckt"
        const val java = "javalite"
        const val stream = "rxgrpc"
        const val coroutines = "coroutines"
    }

    object Grpc {
        const val protobuf = "com.google.protobuf:protoc:${Versions.protobuf}"
        const val protobufLite = "com.google.protobuf:protobuf-lite:${Versions.protobufLite}"

        const val javaxAnnotation =
            "javax.annotation:javax.annotation-api:${Versions.javaxAnnotation}"
        const val grpcStub = "io.grpc:grpc-stub:${Versions.grpc}"
        const val grpcStub2 = "io.grpc:grpc-kotlin-stub:1.4.1"
        const val grpcAndroid = "io.grpc:grpc-android:${Versions.grpc}"
        const val grpcJava = "io.grpc:grpc-protobuf-lite:${Versions.grpc}"
        const val grpcOkHttp = "io.grpc:grpc-okhttp:${Versions.grpc}"
//        const val grpcProtoLite = "io.grpc:grpc-protobuf-lite:${Versions.grpc}"

    }

    object NavigationComponents {
        const val safeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigationComponents}"
        const val fragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigationComponents}"
        const val ui = "androidx.navigation:navigation-ui-ktx:${Versions.navigationComponents}"
    }
}