package com.svetikov.kotlinpostgres

import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface CustomerRepository:ReactiveCrudRepository<Customer,Int> {
}