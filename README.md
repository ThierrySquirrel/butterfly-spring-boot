# butterfly-spring-boot-starter

butterfly RocketMQ Spring Book Edition

[中文](./README_zh_CN.md)

Support function:
- [x] RPC Remote call

# RPC Remote call： 
 Use the components provided by pine for external expansion    
 Provide 'half long connection' RPC tool for load balancing  

# Filter:  
 Filtering data for requests and responses  
  
## Quick Start

```xml
<!--Adding dependencies to pom. XML-->
        <dependency>
            <artifactId>butterfly-spring-boot-starter</artifactId>
            <groupId>com.github.thierrysquirrel</groupId>
            <version>1.4.1.4-RELEASE</version>
        </dependency>
``` 

 ### configuration file
 
 ```properties
 ## application.properties
butterfly.butterfly-service-name="ServiceDemo" Service name
butterfly.butterfly-service-url="127.0.0.1:5050" Butterfly service address
butterfly.pine-service-url="127.0.0.1:6060" Pine service address,If you need a cluster 127.0.0.1:6060,127.0.0.1:6061,127.0.0.1:6062
 ```

 # Start Butterfly
 ```java
 @SpringBootApplication
 @EnableButterfly
 public class DemoApplication{
     public static void main(String[] args){
         SpringApplication.run(DemoApplication.class, args);
     }
    
 }
 ```

# RPC Producer 

 ```java
@Flower
public class Producer {
    @Fragrance("/ServiceDemo/hello")
    public String hello() {
        return "world";
    }

    @Fragrance("/ServiceDemo/world")
    public String hello(String world) {
        return "world"+world;
    }
}
 ```

# RPC Consumer

 ```java
@Butterfly("ServiceDemo")
public interface Consumer {
    @Flutter ("/ServiceDemo/hello")
    String hello();

    @Flutter("/ServiceDemo/world")
    String hello(String text);
}
 ```

# Using RPC

 ```java
@RestController
public class Demo {
    @Resource
    private Consumer consumer;

    @GetMapping("/play")
    public String world() {
        return consumer.hello ();
    }
}
 ```  

# Filter  

```java
@ButterflyFilter
public class ConsumerFilter implements Filter {
	@Override
	public void filter(PineRequestContextFilterDomain pineRequestContextFilterDomain) {
        pineRequestContextFilterDomain.setAttachment("key","value");        	
	}
}
```  

```java
@FlowerFilter
public class ProducerFilter implements Filter {
	@Override
	public void filter(PineRequestContextFilterDomain pineRequestContextFilterDomain) {
		pineRequestContextFilterDomain.getAttachment("key");	
	}
}
```

![Russian flag](https://user-images.githubusercontent.com/49895274/190373325-689211c8-9267-41a2-9759-70f98011a1d3.png)
