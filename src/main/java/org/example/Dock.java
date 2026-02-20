package org.example;

import com.github.dockerjava.api.model.AuthConfig;

import com.github.dockerjava.api.model.AuthConfigurations;

import com.github.dockerjava.core.DockerClientBuilder;

import com.github.dockerjava.core.DockerClientConfig;

import com.github.dockerjava.core.RemoteApiVersion;

import com.github.dockerjava.core.SSLConfig;

import com.github.dockerjava.transport.DockerHttpClient;

import java.io.IOException;

import java.io.InputStream;

import java.net.URI;

import java.util.List;

import java.util.Map;

public class Dock implements DockerHttpClient {

    Dock(){

        DockerClientBuilder.getInstance(new DockerClientConfig() {
            @Override
            public URI getDockerHost() {

                return URI.create("");
            }

            @Override
            public RemoteApiVersion getApiVersion() {
                return null;
            }

            @Override
            public String getRegistryUsername() {
                return null;
            }

            @Override
            public String getRegistryPassword() {
                return null;
            }

            @Override
            public String getRegistryEmail() {
                return null;
            }

            @Override
            public String getRegistryUrl() {
                return null;
            }

            @Override
            public AuthConfig effectiveAuthConfig(String imageName) {
                return new AuthConfig().withEmail("").withPassword("").withUsername("");
            }

            @Override
            public AuthConfigurations getAuthConfigurations() {
                return new AuthConfigurations();
            }

            @Override
            public SSLConfig getSSLConfig() {
                return null;
            }
        }).withDockerHttpClient(this).build();

    }

    @Override
    public Response execute(Request request) {
        return new Response() {
            @Override
            public int getStatusCode() {

                return 0;
            }

            @Override
            public Map<String, List<String>> getHeaders() {
                return null;
            }

            @Override
            public InputStream getBody() {
                return request.body();
            }

            @Override
            public void close() {

            }
        };
    }

    @Override
    public void close() throws IOException {

    }
}
