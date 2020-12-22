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


