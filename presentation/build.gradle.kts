plugins {
    id(Dependency.Gradle.LIBRARY)
    id(Dependency.Gradle.KOTLIN)
}

android {
    namespace = ProjectProperties.NameSpace.PRESENTATION
    compileSdk = ProjectProperties.Versions.COMPILE_SDK

    defaultConfig {
        minSdk = ProjectProperties.Versions.MIN_SDK

        testInstrumentationRunner = ProjectProperties.Test.TEST_RUNNER
        consumerProguardFiles(ProjectProperties.Files.CONSUMER_PROGUARD_FILES)
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile(ProjectProperties.Files.DEFAULT_PROGUARD_FILES),
                ProjectProperties.Files.PROGUARD_FILES
            )
        }
    }
    compileOptions {
        sourceCompatibility = ProjectProperties.Versions.JAVA_VERSION
        targetCompatibility = ProjectProperties.Versions.JAVA_VERSION
    }
    kotlinOptions {
        jvmTarget = ProjectProperties.Versions.JVM_TARGET
    }
}

dependencies {
    implementation(project(":domain"))

    implementation(Dependency.AndroidX.CORE_KTX)
    implementation(Dependency.AndroidX.LIFECYCLE)

    implementation(Dependency.Compose.ACTIVITY_COMPOSE)
    implementation(platform(Dependency.Compose.COMPOSE_BOM))
    implementation(Dependency.Compose.COMPOSE)
    implementation(Dependency.Compose.COMPOSE_GRAPHICS)
    implementation(Dependency.Compose.COMPOSE_PREVIEW)
    implementation(Dependency.Compose.COMPOSE_MATERIAL3)
    implementation(Dependency.Compose.COMPOSE_MATERIAL)
    debugImplementation(Dependency.Compose.COMPOSE_TOOLING)

    testImplementation(Dependency.Test.JUNIT)
    androidTestImplementation(Dependency.Test.ANDROID_JUNIT)
    androidTestImplementation(Dependency.Test.ESPRESSO)
    androidTestImplementation(platform(Dependency.Compose.COMPOSE_BOM))
    androidTestImplementation(Dependency.Test.COMPOSE_JUNIT)
    debugImplementation(Dependency.Test.COMPOSE_MANIFEST)
}