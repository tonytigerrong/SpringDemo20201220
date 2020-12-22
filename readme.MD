[Test]

Normal: http://localhost:8080/springdemo20201220/springdemo/greeting?name=tony1
exception: http://localhost:8080/springdemo20201220/springdemo/greeting?name=GreetingNotfoundException
[POM.xml]

springframework: web/webmvc/test 
jackson: core/databind/annotation

plugin: 
  - maven-war-plugin, setup outputDirectory for war target folder
  - tomcat7-maven-plugin, embeded app server
  - maven-compiler-plugin, default pom.xl plugin for compiler

[custom validator annotation]
  - valid params: name=tony/david
  - test GreetingNotfoundException handler: name=GreetingNotfoundException
  - custom validator annotation test: GET http://localhost:8080/springdemo20201220/springdemo/greeting?name=tony1
  - custom combination validator test: POST http://localhost:8080/springdemo20201220/springdemo/email
    validate if email equals emailConfirm 
    {
        "email": "1234",
        "emailConfirm": "1234"
    }
