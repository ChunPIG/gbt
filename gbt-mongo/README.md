# Spring Boot Intergation MongDB



* 1 添加依赖
```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-data-mongodb</artifactId>
</dependency> 
```

* 2 配置数据源
* 2.1 方案一 使用Spring Boot默认配置
```properties
# 在src/main/resources/application.properties
# spring.data.mongodb.uri=mongodb://username:password@localhost:27017/dbname
spring.data.mongodb.uri=mongodb://airag:channel@192.168.20.155:27017/airag
```
* 2.2 方案二 手动创建MongoTemplate
```java
@Configuration
@EnableMongoRepositories
public class MongoConfig extends AbstractMongoConfiguration {
 
    private String mongoHost = "localhost";
    private int mongoPort = 27017;
    private String dbName = "springboot-db";
 
    private static final String MONGO_BASE_PACKAGE = "com.lianggzone.springboot.action.data.mongodb.entity";
 
    @Autowired
    private ApplicationContext appContext;
 
    @Override
    protected String getDatabaseName() {
        return dbName;
    }
 
    @Override
    public Mongo mongo() throws Exception {
        MongoClient mongoClient = new MongoClient(mongoHost, mongoPort);
        return mongoClient;
    }
 
    @Override
    protected String getMappingBasePackage() {
        return MONGO_BASE_PACKAGE;
    }
 
    @Override
    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), getDatabaseName());
    }
}
```

