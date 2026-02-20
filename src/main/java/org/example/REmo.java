package org.example;

import org.apache.maven.execution.MavenSession;

import org.sonatype.nexus.maven.staging.remote.Parameters;

import org.sonatype.nexus.maven.staging.remote.RemoteNexus;

import org.sonatype.plexus.components.sec.dispatcher.SecDispatcher;

public class REmo extends RemoteNexus {
    public REmo(MavenSession mavenSession, SecDispatcher secDispatcher, Parameters parameters) {
        super(mavenSession, secDispatcher, parameters);




    }
}
