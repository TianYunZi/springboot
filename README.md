spring-boot的application-properties文件，debug=true查看已启用配置

ssl相关在7.2.4模块

设置自己的favicon.ico在7.2.4模块

application.properties在/resources目录下，带有thymeleaf的.html文件在/resources/templates目录下，一般静态文件在/resources/static目录下，
.jsp在/resources目录下

7.6.3包含Spring Security

8.2.2
开启docker mysql容器命令：docker run -d -p 127.0.0.1:3305:3306 --name port-mysql -v /Users/Admin/docker/mysql/data:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=”abc123##” mysql:latest

在容器中进行常规的Linux系统命令：docker exec -it port-mysql bash

data.sql文件在初始化时使用，以后需删除或者改名

8.5.1
Spring Cache: 使用任意一个实现CacheManager，需要注册实现的CacheManager的Bean
Spring Boot: 需要通过@EnableCaching开启缓存支持

8.5.4
使用EhCache做缓存需添加配置文件并在pom.xml里添加依赖，使用Guava和Redis做缓存只需在Redis添加依赖

8.6.2
Spring Data目前只支持2.6和2.8版本的Redis, Model类继承Serializable接口

9.1.3
Spring-Boot-Security扩展配置只需配置类继承WebSecurityConfigurerAdapter类，无需使用@EnableWebSecurity注解

9.2.3
Spring-Boot-Starter-Batch依赖jar包需排除hsqldb依赖jar包