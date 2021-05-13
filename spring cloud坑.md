# 盘盘Spring cloud 中遇到的坑

## 一、nacos 配置中心读取失败

spring boot 2.4.x中移除了spring-cloud-starter-bootstrap模块，导致nacos 配置模块无法正常读取配置中心的配置，在依赖中添加spring-cloud-starter-bootstrap即可正常使用

```xml
<dependency>
    <groupId>com.alibaba.cloud</groupId>
    <artifactId>spring-cloud-starter-alibaba-nacos-config</artifactId>
    <version>2021.1</version>
</dependency>

<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-bootstrap</artifactId>
    <version>3.0.2</version>
</dependency>
```

