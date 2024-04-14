package dagger

object Dependencies {
    const val DAGGER = "com.google.dagger:dagger:${Versions.DAGGER2}"
    const val DAGGER_COMPILER = "com.google.dagger:dagger-compiler:${Versions.DAGGER2}"
    const val DAGGER_ANDROID = "com.google.dagger:dagger-android-support:${Versions.DAGGER2}"
    const val DAGGER_ANDROID_PROCESSOR =
        "com.google.dagger:dagger-android-processor:${Versions.DAGGER2}"
}

object Versions {
    const val DAGGER2 = "2.26"
}