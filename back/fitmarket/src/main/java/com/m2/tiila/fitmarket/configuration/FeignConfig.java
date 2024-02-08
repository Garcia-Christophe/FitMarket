package com.m2.tiila.fitmarket.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Feign;
import feign.Logger.JavaLogger;
import feign.Logger.Level;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import jakarta.inject.Inject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.concurrent.TimeUnit;

@Configuration
@Profile("!TEST")
public class FeignConfig {

  //TODO appel api extérieur
  /*@Inject
  private OpenWeatherInterceptor interceptor;

  @Inject
  private ObjectMapper objectMapper;

  @Bean
  public OpenWeatherClient getOpenWeatherClient() {
    return Feign.builder()
        .encoder(new JacksonEncoder(objectMapper))
        .decoder(new JacksonDecoder(objectMapper))
        .client(new OkHttpClient(getOkHttpClient()))
        .requestInterceptor(interceptor)
        .logger(new JavaLogger(FeignConfig.class))
        .logLevel(Level.FULL)
        .target(OpenWeatherClient.class, "https://api.openweathermap.org/");
  }

  private okhttp3.OkHttpClient getOkHttpClient() {
    var okHttpClient = new okhttp3.OkHttpClient().newBuilder();
    okHttpClient.connectTimeout(1000, TimeUnit.MILLISECONDS);
    okHttpClient.readTimeout(1000, TimeUnit.MILLISECONDS);
    return okHttpClient.build();
  }*/

}
