package com.yoong.javaspring

import org.springframework.context.annotation.AnnotationConfigApplicationContext

class Test {


    fun main(args: Array<String>) {
        val applicationContext = AnnotationConfigApplicationContext(AppConfig::class.java)
    }
}