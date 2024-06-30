# Programmatically adding beans to the Spring context

> This project is based on chapter **2.2.3. Programmatically adding beans to the Spring context** from book **Spring Starts here (2021)** by Laurentiu Spilca.

## Create Maven project with Intellij Idea

File > New project > Java

## Create entity class

```java
public class Book {
    private final String title;

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Book book = (Book) obj;
        return title == book.title || (title != null && title.equals(book.title));
    }

    public int hashCode() {
        return title == null ? 0 : title.hashCode();
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

## Add tests

### Add dependency for Spring TestContext Framework

```xml
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-test</artifactId>
    <version>6.1.10</version>
    <scope>test</scope>
</dependency>
```

### Add dependency for JUnit

```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-engine</artifactId>
    <version>5.11.0-M2</version>
    <scope>test</scope>
</dependency>
```

### Create test to check that application context is created

```java
public class ApplicationTests {

    @Test
    @DisplayName("Checks that Application Context is created")
    public void checkApplicationContextCreated() {
        ApplicationContext context = new AnnotationConfigApplicationContext();

        assertNotNull(context);
    }
}
```

### Create test to check that bean is registered in the context

```java
public class BookTests {

    @Test
    @DisplayName("Checks that Book is added to the context")
    public void checkBookAddedToContext() {
        GenericApplicationContext context = new AnnotationConfigApplicationContext();
        context.registerBean(Book.class, "The Hunger Games");
        context.refresh();

        Book book = context.getBean(Book.class);

        assertEquals(new Book("The Hunger Games"), book);
    }
}
```
