package io.andreslond.moviecatalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;

@SpringBootApplication
public class MovieCatalogServiceApplication {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        clientHttpRequestFactory.setConnectionRequestTimeout(3000);
        return new RestTemplate(clientHttpRequestFactory);
    }

    @Bean
    @LoadBalanced
    public WebClient.Builder getWebClientBuilder() {
        HttpClient client = HttpClient.create().responseTimeout(Duration.ofSeconds(3));
        return WebClient.builder().clientConnector(new ReactorClientHttpConnector(client));
    }

    public static void main(String[] args) {
        SpringApplication.run(MovieCatalogServiceApplication.class, args);
    }

}
