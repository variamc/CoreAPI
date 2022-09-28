plugins {
    java
}

group = "io.github.variamc"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven { url = uri("https://repo.papermc.io/repository/maven-public/") }
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.19.2-R0.1-SNAPSHOT")
    implementation("net.axay:kspigot:1.19.0")
    implementation("com.zaxxer:HikariCP:5.0.1")
    implementation("org.apache.commons:commons-lang3:3.12.0")
}

    apply(plugin = "maven-publish")
    apply(plugin = "signing")

    project.gradle.projectsEvaluated {
        configure<PublishingExtension> {
            repositories {
                maven {
                    name = "ossrh"
                    url = uri(
                        if (version.toString().endsWith("SNAPSHOT")) {
                            "https://s01.oss.sonatype.org/content/repositories/snapshots/"
                        } else {
                            "https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/"
                        }
                    )
                    credentials {
                        username = project.findProperty("ossrhUsername") as String? ?: System.getenv("ossrhUsername")
                        password = project.findProperty("ossrhPassword") as String? ?: System.getenv("ossrhPassword")
                    }
                }
            }
        }

        val publications: PublicationContainer = extensions.getByType<PublishingExtension>().publications

        publications.withType<MavenPublication>().forEach {
            it.pom {
                name.set(project.name)
                description.set("The official VariaMC CoreAPI to work with.")
                url.set("https://github.com/variamc/CoreAPI")
                packaging = "jar"

                scm {
                    connection.set("scm:git:https://github.com/variamc/CoreAPI")
                    developerConnection.set("scm:git:https://github.com/Unerheblich")
                    url.set("https://github.com/variamc/CoreAPI")
                }

                licenses {
                    license {
                        name.set("MIT License")
                        url.set("https://opensource.org/licenses/MIT")
                        distribution.set("repo")
                    }
                }

                developers {
                    developer {
                        id.set("kaseax")
                        name.set("Fynn B")
                        email.set("greenpepper1489@gmail.com")
                    }
                }
            }
        }

        configure<SigningExtension> {
            useGpgCmd()
            val signingKey =
                project.findProperty("signingKey") as String? ?: System.getenv("signing.keyId")?.replace("\\n", "\n")
            val signingKeyPassphrase =
                project.findProperty("signingPassphrase") as String? ?: System.getenv("signing.password")
            useInMemoryPgpKeys(signingKey, signingKeyPassphrase)
            sign(publications)
        }
    }


