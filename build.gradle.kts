import nebula.plugin.contacts.Contact
import nebula.plugin.contacts.ContactsExtension

plugins {
    id("org.openrewrite.build.recipe-library") version "latest.release"
}

group = "org.openrewrite"
description = "Rewrite recipes with a generative AI twist."

//The bom version can also be set to a specific version or latest.release.
val rewriteVersion = rewriteRecipe.rewriteVersion.get()


dependencies {
    compileOnly("org.projectlombok:lombok:latest.release")
    compileOnly("com.google.code.findbugs:jsr305:latest.release")
    annotationProcessor("org.projectlombok:lombok:latest.release")
    implementation(platform("org.openrewrite:rewrite-bom:${rewriteVersion}"))
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")
    implementation("org.openrewrite:rewrite-java")
    implementation("org.slf4j:slf4j-api:1.7.36")
    runtimeOnly("org.openrewrite:rewrite-java-17")
    // Need to have a slf4j binding to see any output enabled from the parser.
    runtimeOnly("ch.qos.logback:logback-classic:1.2.+")

    testImplementation("org.junit.jupiter:junit-jupiter-api:latest.release")
    testImplementation("org.junit.jupiter:junit-jupiter-params:latest.release")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:latest.release")

    testImplementation("org.openrewrite:rewrite-test")
    testImplementation("org.assertj:assertj-core:latest.release")
}
