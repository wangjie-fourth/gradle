
dependencies {
    implementation(project(":basics"))
    implementation(project(":dependencyModules"))
    implementation(project(":jvm"))

    implementation("org.gradle.kotlin:gradle-kotlin-dsl-conventions")
    implementation(kotlin("gradle-plugin"))
    implementation("org.ow2.asm:asm")

    testImplementation("junit:junit")
    testImplementation("com.nhaarman:mockito-kotlin")
}
