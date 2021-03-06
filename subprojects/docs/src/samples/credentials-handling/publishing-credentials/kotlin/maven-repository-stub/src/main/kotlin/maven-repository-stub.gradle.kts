tasks.withType<PublishToMavenRepository>().configureEach {
    doFirst {
        val address = com.example.MavenRepositoryStub.start()
        getRepository().setUrl(address)
    }
    doLast {
        com.example.MavenRepositoryStub.stop()
    }
}
