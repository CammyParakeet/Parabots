plugins {
    `java-library`
    `maven-publish`
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "com.parakeetstudios.parabots"
version = "1.0.0-SNAPSHOT"
description = "Core implementation for Parabots library/plugin"

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.20.1-R0.1-SNAPSHOT")
    implementation(project(":Parabots-API"))
    implementation(project(":Parabots-Core", configuration = "reobf"))
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            artifact(tasks.shadowJar)
            groupId = "com.parakeetstudios"
            artifactId = "parabots"
            version = "1.0.0"
        }
    }
}

repositories {
    mavenLocal()
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

tasks {
    assemble{
        dependsOn(shadowJar)
    }
    compileJava {
        options.encoding = Charsets.UTF_8.name()
        options.release.set(17)
    }
    javadoc {
        options.encoding = Charsets.UTF_8.name()
    }
}

tasks.shadowJar {
    archiveBaseName.set("parabots")
    archiveVersion.set("1.0.0")
    archiveClassifier.set("")
    dependsOn(project(":Parabots-Core").tasks.getByName("reobfJar"))
}






