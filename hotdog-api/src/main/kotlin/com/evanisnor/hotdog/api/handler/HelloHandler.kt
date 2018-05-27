package com.evanisnor.hotdog.api.handler

import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse.ok

@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
@Service
class HelloHandler {

  fun sayHello(req: ServerRequest) = ok().syncBody("hello")
}