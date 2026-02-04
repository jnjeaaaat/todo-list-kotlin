plugins {
    kotlin("kapt")
}

dependencies {
    api(project(":domain"))
    api(project(":support:logging"))
    api(project(":support:error"))
    api(project(":config"))

    implementation("org.springframework.boot:spring-boot-starter-webmvc")
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-validation")

    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("tools.jackson.module:jackson-module-kotlin")

    implementation("org.mapstruct:mapstruct:1.5.3.Final")
    kapt("org.mapstruct:mapstruct-processor:1.5.3.Final")

    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

    runtimeOnly("com.mysql:mysql-connector-j")

    testImplementation(kotlin("test"))
}

kapt {
    arguments {
        arg("mapstruct.defaultComponentModel", "spring")
        arg("mapstruct.unmappedTargetPolicy", "IGNORE")
    }
}