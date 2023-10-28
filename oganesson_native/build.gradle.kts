plugins {
    id("fr.stardustenterprises.rust.wrapper")
}

rust {
    release.set(true)
    command.set("cargo")
    targets {
        this += defaultTarget()
    }
}