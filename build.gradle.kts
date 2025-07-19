plugins {
    application
    kotlin("jvm") version "1.9.23"

    id("org.javamodularity.moduleplugin") version "1.8.12"
    id("org.openjfx.javafxplugin")      version "0.1.0"
    id("org.beryx.jlink")               version "2.25.0"
}

group = "com.paulrezzonico"
version = "1.0-SNAPSHOT"

repositories { mavenCentral() }

java {
    // Utilise un JDK 21 (ou 22) via les toolchains Gradle
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
    // Laisse Gradle inférer le module‑path
    modularity.inferModulePath.set(true)
}

application {
    mainModule.set("latice")
    mainClass.set("latice.Latice")
}

javafx {
    version = "21.0.2"                              // dernière révision stable
    // → modules requis explicitement
    modules(
        "javafx.base",
        "javafx.graphics",
        "javafx.controls",
        "javafx.fxml",
        "javafx.media"
    )
}

dependencies {
    implementation(kotlin("stdlib"))

    implementation("org.controlsfx:controlsfx:11.2.1")
    implementation("com.dlsc.formsfx:formsfx-core:11.6.0") {
        exclude(group = "org.openjfx")
    }
    implementation("net.synedra:validatorfx:0.5.0") {
        exclude(group = "org.openjfx")
    }
    implementation("org.kordamp.bootstrapfx:bootstrapfx-core:0.4.0")
    implementation("com.github.almasb:fxgl:17.3") {
        exclude(group = "org.openjfx")
        exclude(group = "org.jetbrains.kotlin")
    }

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.2")
    testImplementation("org.assertj:assertj-core:3.24.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.2")
}

tasks.withType<Test> { useJUnitPlatform() }

jlink {
    imageZip.set(layout.buildDirectory.file("distributions/app-${javafx.platform.classifier}.zip"))
    options.set(listOf("--strip-debug", "--compress", "2", "--no-header-files", "--no-man-pages"))
    launcher { name = "app" }
}
