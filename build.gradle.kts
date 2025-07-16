plugins {
    java
    id("org.openjfx.javafxplugin") version "0.1.0"
}

group = "com.paulrezzonico"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

repositories {
    mavenCentral()
}

javafx {
    version = "24"
    modules("javafx.controls", "javafx.fxml", "javafx.graphics", "javafx.base")
}

dependencies {
    implementation("org.openjfx:javafx-controls:24.0.1")
    implementation("org.openjfx:javafx-fxml:24.0.1")
    implementation("org.openjfx:javafx-base:24.0.1")
    implementation("org.openjfx:javafx-graphics:24.0.1")
    testImplementation("org.junit.jupiter:junit-jupiter:5.13.3")
    testImplementation("org.assertj:assertj-core:3.27.3")
}

tasks.test {
    useJUnitPlatform()
}