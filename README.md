# Add Spring context to Maven project

> This project is based on chapter **2.2.3. Programmatically adding beans to the Spring context** from book **Spring Starts here (2021)** by Laurentiu Spilca.

## Create Maven project with Intellij Idea

File > New project > Java

## Create entity class

```java
public class Book {
    private String title;

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
```

## Add Spring Context dependency

```xml
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-context</artifactId>
    <version>6.1.10</version>
</dependency>
```

## Create Spring context

```java
ApplicationContext context = new AnnotationConfigApplicationContext();
```

## Register bean in Spring context

```java
context.registerBean(Book.class, "The Hunger Games");
```

## Refresh Spring context

```java
context.refresh();
```

## Get bean from Spring context

```java
System.out.println("The book's title is " + context.getBean(Book.class).getTitle());
```
