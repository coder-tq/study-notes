docker run -p 3306:3306 --name mysql -v /mydata/mysql/log:/var/log/mysql -v /mydata/mysql/data:/var/lib/mysql -v /mydata/mysql/conf:/etc/mysql -v /mydata/mysql/mysql-files:/var/lib/mysql-files/ -e MYSQL_ROOT_PASSWORD=root -d mysql:8.0

