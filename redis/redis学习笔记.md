# 入门概述

## 为什么使用NoSQL？

今天我们通过第三方平台可以很容易的访问和抓取数据。用户的个人信息，社交网络，地理位置，用户生成的数据和用户操作日志已经成倍的增加。

如果要对这些用户数据进行挖掘，那SQL数据库已经不适合这些应用了，NoSQL的发展能很好的处理这些大的数据。

## 是什么

Not Only SQL

泛指非关系型数据库。这些类型的数据存储不需要固定的模式，无需多余的操作就可以横向扩展。

## 能干嘛

### 易扩展

NoSQL的共同特点是去掉了关系型数据库的关系型特性。

数据之间无关系，这样就非常容易扩展。

### 大数据量高性能

NoSQL具有非常高的读写性能，得益于它的无关系性，数据库的结构简单。

NoSQL的缓存对于MySQL来说是一种更细粒度的缓存，NoSQL是记录级缓存。

### 多样灵活的数据模型

NoSQL无需事先为要存储的数据建立字段，随时可以存储自定义的数据格式。

关系数据库中，增删字段是非常麻烦的事情，如果是数据量很大的表，增加字段是噩梦。

## 关系型数据库 VS NoSQL

RDBMS

- 高度组织化结构化数据
- 结构化查询语言（SQL）
- 数据和关系都储存在单独的表中
- 数据操控语言，数据定义语言
- 严格的一致性
- 基础事务

NoSQL

- 代表着不仅仅是SQL
- 没有声明性查询语言
- 没有预定义的模式
- 键值对存储，列存储，文档存储，图形数据库
- 最终一致性，而非ACID属性
- 非结构化和不可预知的数据
- CAP定理
- 高性能、高可用性和可伸缩性

## 有什么

- Redis
- Memcache
- Mongdb

## 怎么玩

- KV

- Cache

- Persistence

# 3V + 3高

## 大数据时代的3V

- 海量Volume
- 多样Vairety
- 实时Velocity

## 互联网需求的3高

- 高并发
- 高可扩
- 高性能

# NoSQL经典应用

当下的应用是SQL与NoSQL一起使用

## 阿里巴巴中文站商品信息如何存放

看看阿里巴巴中文网站首页以女装/女包包为例

### 架构发展历程：

1. 演变过程

![img](images/aHR0cHM6Ly9naXRlZS5jb20vamFsbGVua3dvbmcvTGVhcm5SZWRpcy9yYXcvbWFzdGVyL2ltYWdlLzA4LnBuZw)

1. 第5代

![img](images/aHR0cHM6Ly9naXRlZS5jb20vamFsbGVua3dvbmcvTGVhcm5SZWRpcy9yYXcvbWFzdGVyL2ltYWdlLzA5LnBuZw)

1. 第5代架构使命

![img](images/aHR0cHM6Ly9naXRlZS5jb20vamFsbGVua3dvbmcvTGVhcm5SZWRpcy9yYXcvbWFzdGVyL2ltYWdlLzEwLnBuZw)

------

**和我们相关的，多数据源类型的存储问题**

![img](images/aHR0cHM6Ly9naXRlZS5jb20vamFsbGVua3dvbmcvTGVhcm5SZWRpcy9yYXcvbWFzdGVyL2ltYWdlLzExLnBuZw)

### 商品信息的存储方案

1. 商品基本信息
   - 名称、价格，出厂日期，生产厂商等
   - 关系型数据库，mysql/oracle目前淘宝在去O化(也即拿掉Oracle)，注意，淘宝内部用的Mysql是里面的大牛自己改造过的
     - 为什么去IOE（在IT建设过程中，去除IBM小型机、Oracle数据库及EMC存储设备） 简而意之，可不用穿脚链跳舞。
2. 商品描述、详情、评价信息(多文字类)
   - 多文字信息描述类，IO读写性能变差
   - 文档数据库MongDB
3. 商品的图片
   - 商品图片展现类
   - 分布式的文件系统中
     - 淘宝自家TFS
     - Google的GFS
     - Hadoop的HDFS
4. 商品的关键字
   - 淘宝自家
   - ISearch
5. 商品的波段性的热点高频信息（如，情人节的巧克力）
   - 内存数据库
   - Tair、Redis、Memcache
6. 商品的交易、价格计算、积分累计
   - 外部系统，外部第3方支付接口
   - 支付宝