# Getting Started

* [Official documentation for MD file ](https://guides.github.com/features/mastering-markdown/)



### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.5.2/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.5.2/gradle-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.5.2/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.5.2/reference/htmlsingle/#boot-features-jpa-and-spring-data)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

### POST host:8080/v1/news
### REQUEST
```JSON
{
  "title":"New Title ddd",
  "content":"New Content fff",
  "authorId":1
}

```



### RESPONSE
```JSON
{
     "id": 8,
     "title": "New Title ddd",
     "content": "New Content fff",
     "createdAt": "2021-07-14T20:46:46.321406",
     "updateAt": "2021-07-14T20:46:46.321464",
     "author": {
         "id": 1,
         "name": "Anar",
         "surname": "Xocayev"
     },
     "active": true,
     "deleted": false
 }
```


### JAVA
```JAVA
public class MyClass{

}
```


