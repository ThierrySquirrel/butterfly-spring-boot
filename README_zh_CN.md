# butterfly-spring-boot-starter

蝴蝶RocketMQ   SpringBoot 版

[English](./README.md)

支持功能：
- [x] RPC远程调用  
- [X] 过滤器  

# RPC远程调用： 
 使用松树提供的对外扩展的组件  
 提供负载均衡的'半长连接'RPC工具  
 
# 过滤器:  
 过滤请求和响应的数据   
 
## Quick Start

```xml
<!--在pom.xml中添加依赖-->
        <dependency>
            <artifactId>butterfly-spring-boot-starter</artifactId>
            <groupId>com.github.thierrysquirrel</groupId>
            <version>1.4.1.4-RELEASE</version>
        </dependency>
``` 

 ### 配置文件
 
 ```properties
 ## application.properties
butterfly.butterfly-service-name="ServiceDemo" 服务名称
butterfly.butterfly-service-url="127.0.0.1:5050" 蝴蝶服务地址
butterfly.pine-service-url="127.0.0.1:6060" 松树服务地址,如果您需要集群 127.0.0.1:6060,127.0.0.1:6061,127.0.0.1:6062
 ```

 # 启动Butterfly
 ```java
 @SpringBootApplication
 @EnableButterfly
 public class DemoApplication{
     public static void main(String[] args){
         SpringApplication.run(DemoApplication.class, args);
     }
    
 }
 ```

# RPC生产者 

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

# RPC消费者

 ```java
@Butterfly("ServiceDemo")
public interface Consumer {
    @Flutter ("/ServiceDemo/hello")
    String hello();

    @Flutter("/ServiceDemo/world")
    String hello(String text);
}
 ```

# 使用RPC

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

# 过滤器  

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

