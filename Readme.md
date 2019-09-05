---
Integrate a MySQL Database into your Java Spring Boot GraphQL Service
---

We're going to the [Spring Data JPA] starter which uses the [Java Persistence API] to save and retrieve your entity models to/from your chosen database.  This API gives you an easy to use abstraction layer so you can use any of a large number of different databases.  We're going to use [MySQL]as it's the most popular database out there.


## Pre-requisites

MySQL server and client installed.  You'll need a privileged user that can create a schema and users.  


## MySQL Setup

create the schema:

    CREATE SCHEMA `graphql` DEFAULT COLLATE=`utf8_bin` DEFAULT CHARACTER SET=`utf8`;

Finally, create the table we need:

    CREATE TABLE `pets` (`id` INT(11) NOT NULL AUTO_INCREMENT, `name` VARCHAR(255) DEFAULT NULL, `age` TINYINT(3) DEFAULT NULL, `type` ENUM('DOG','CAT','BADGER','MAMMOTH'), PRIMARY KEY(`id`));

Let's create a few entries in the table so we've got something to retrieve:

    INSERT INTO `pets` (`name`,`age`,`type`) VALUES ('Steve', 5, 'BADGER'), ('Jeff', 88, 'MAMMOTH'), ('Oscar', 2, 'CAT');

Now let's check everything is in there:

    SELECT * FROM pets;

This should show the following result:

    +----+-------+------+---------+
    | id | name  | age  | type    |
    +----+-------+------+---------+
    |  1 | Steve |    5 | BADGER  |
    |  2 | Jeff  |   88 | MAMMOTH |
    |  3 | Oscar |    2 | CAT     |
    +----+-------+------+---------+
    3 rows in set (0.00 sec)

Great, that's all the MySQL setup done! Type "exit" and press enter to get out of MySQL and back to the command line.


## Spring Data JPA

Now we need to add the Spring Data JPA project to our app.  Add these lines in your pom.xml in the `<dependencies>` section:

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
    </dependency>
        
Then run the install:

    mvn install

Now we need to tell our app how to connect to our database.  If you've checked-out the github repo, copy the application.properties.example file to application.properties and add in your own URL and credentials.  If you haven't, create this file:

    src/main/resources/application.properties

And put in this contents

    spring.datasource.url=jdbc:mysql://localhost:3306/graphql
    spring.datasource.username=graphql_tutorial_user
    spring.datasource.password=ThePasswordYouCreatedAbove

This sets up our connection URL, the username and the password for Spring Data to connect to your database instance.

## Run Application
That's it! Now start up your app again:

    mvn spring-boot:start

Navigate to [http://localhost:8080/graphiql](http://localhost:8080/graphiql) and you should again see the GraphIQL UI.  

Run this query:

    {
	    pets {
            name,
            age,
            type
	    }
    }

You should see this result:

    {
      "data": {
        "pets": [
          {
            "name": "Steve",
            "age": 5,
            "type": "BADGER"
          },
          {
            "name": "Jeff",
            "age": 88,
            "type": "MAMMOTH"
          },
          {
            "name": "Oscar",
            "age": 2,
            "type": "CAT"
          }
        ]
      }
    }

