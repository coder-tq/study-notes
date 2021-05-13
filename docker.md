# docker常用命令

- docker pull xxxx:yy 拉取xxxx镜像到本地，yy为版本号，默认是latest最新版
- docker run 运行一个镜像 
  - -p xxxx:yyyy 将主机的xxxx端口映射到容器的xxxx端口 
  - --name xxx 给容器起一个xxx的名字
  - -v xxx:yyy 将容器中的yyy文件夹映射到主机xxx文件夹
  - -d 容器后台运行
  - -it 以可交互方式运行
  - -e MYSQL_ROOT_PASSWORD=root 容器运行时添加环境变量

# 谷粒商城docker命令

- 启动mysql
  - docker run -p 3306:3306 --name mysql -v /mydata/mysql/log:/var/log/mysql -v /mydata/mysql/data:/var/lib/mysql -v /mydata/mysql/conf:/etc/mysql -v /mydata/mysql/mysql-files:/var/lib/mysql-files/ -e MYSQL_ROOT_PASSWORD=root -d mysql:8.0
- 启动redis
  - mkdir -p /mydata/redis/conf
  - touch /mydata/redis/conf/redis.conf
  - docker run -p 6379:6379 --name redis -v /mydata/redis/data:/data -v /mydata/redis/conf/redis.conf:/etc/redis/redis.conf  -d redis redis-server /etc/redis/redis.conf

- 使容器随docker启动
  - docker update mysql --restart=always