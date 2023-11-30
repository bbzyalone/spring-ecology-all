# spring-ecology-all
### 子模块打包命令


```maven
mvn package -pl {module-name} -am
```

### 目录结构
````
├── README.md
├── mybatis-flex.config
├── pom.xml
├── spring-boot-common
│   ├── pom.xml
│   └── src
│       └── main
│           └── java
│               └── com
│                   └── ecology
│                       └── bbzy
│                           ├── logger
│                           │   └── Logger.java
│                           └── result
│                               ├── IResultCode.java
│                               ├── Result.java
│                               └── ResultCode.java
├── spring-boot-db
│   ├── pom.xml
│   └── src
│       └── main
│           └── java
│               └── com
│                   └── ecology
│                       └── bbzy
│                           ├── entity
│                           │   ├── TbAccount.java
│                           │   └── TbInfo.java
│                           ├── mybatis
│                           │   ├── Codegen.java
│                           │   └── MyBatisFlexConfiguration.java
│                           └── redisson
│                               └── RedisUtil.java
└── spring-boot-main
    ├── pom.xml
    └── src
        └── main
            ├── java
            │   └── com
            │       └── ecology
            │           └── bbzy
            │               ├── SpringEcologyMain.java
            │               ├── controller
            │               │   ├── MybatisFlexTest.java
            │               │   └── TestController.java
            │               ├── model
            │               │   └── User.java
            │               └── service
            │                   ├── Impl
            │                   │   └── UserServiceImpl.java
            │                   └── UserService.java
            └── resources
                └── application.yml
````
