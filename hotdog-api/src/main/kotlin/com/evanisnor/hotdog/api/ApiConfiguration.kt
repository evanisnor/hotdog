package com.evanisnor.hotdog.api

import com.evanisnor.hotdog.api.handler.HelloHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.router

@Configuration
class ApiConfiguration {

  @Bean
  fun routes(helloHandler: HelloHandler) =
      router {
        accept(MediaType.APPLICATION_JSON).nest {
          GET("/", { ok().syncBody("") })
          GET("/hello", helloHandler::sayHello)
        }
      }

}