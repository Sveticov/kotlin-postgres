package com.svetikov.kotlinpostgres

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.support.beans
import org.springframework.web.reactive.function.server.HandlerFunction
import org.springframework.web.reactive.function.server.RouterFunctions.route
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.body
import org.springframework.web.reactive.function.server.router
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


@SpringBootApplication
class KotlinPostgresApplication

//@Bean
//fun httpRoutes(cr: CustomerRepository) = router {
//    GET("/customers/{id}") {
//        val publisher: Mono<Customer> = cr.findById(Integer.parseInt(it.pathVariable("id")))
//        ServerResponse.ok().body(publisher)
//    }
//    GET("/customers") {
//        val publisher: Flux<Customer> = cr.findAll()
//        ServerResponse.ok().body(publisher)
//    }
//    GET("/test") {
//        val customer=Customer(3,"Kotlin")
//        ServerResponse.ok().body(Mono.just(customer))
//    }
//
//}


fun main(args: Array<String>) {
    runApplication<KotlinPostgresApplication>(*args){
        addInitializers(beans {
            bean {
                val cr= ref<CustomerRepository>()
                router {
                    GET("/customers/{id}") {
                        val publisher: Mono<Customer> = cr.findById(Integer.parseInt(it.pathVariable("id")))
                        ServerResponse.ok().body(publisher)
                    }
                    GET("/customers") {
                        val publisher: Flux<Customer> = cr.findAll()
                        ServerResponse.ok().body(publisher)
                    }
                    GET("/test") {
                        val customer=Customer(3,"Kotlin")
                        ServerResponse.ok().body(Mono.just(customer))
                    }
                }
            }
        })
    }

}
