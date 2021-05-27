解决Maven下载慢的问题，修改settings中镜像地址为阿里云仓库
```xml
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0
                      http://maven.apache.org/xsd/settings-1.0.0.xsd">
    <localRepository/>
    <interactiveMode/>
    <usePluginRegistry/>
    <offline/>
    <pluginGroups/>
    <servers/>
    <mirrors>
        <mirror>
            <id>nexus-aliyun</id>
            <mirrorOf>central</mirrorOf>
            <name>Nexus aliyun</name>
            <url>https://maven.aliyun.com/nexus/content/groups/public</url>
        </mirror>

        <!-- 备选镜像，也是可以通过 url 去查找确定一下，
            该镜像是否含有你想要的包，它比 spring-libs-milestone 快  -->
        <mirror>
            <id>central-repository</id>
            <mirrorOf>*</mirrorOf>
            <name>Central Repository</name>
            <url>https://central.maven.org/maven2/</url>
        </mirror>
        <mirror>
            <id>aliyunmaven</id>
            <mirrorOf>central</mirrorOf>
            <name>阿里云公共仓库</name>
            <url>https://maven.aliyun.com/repository/central</url>
        </mirror>
        <mirror>
            <id>aliyunmaven</id>
            <mirrorOf>apache snapshots</mirrorOf>
            <name>阿里云阿帕奇仓库</name>
            <url>https://maven.aliyun.com/repository/apache-snapshots</url>
        </mirror>
    </mirrors>
</settings>

```

