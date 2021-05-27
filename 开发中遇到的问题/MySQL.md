sql添加创建时间和修改时间
```sql
alter table <tableName>
	add create_time DATETIME not null comment '创建时间' DEFAULT current_timestamp();

alter table <tableName>
	add update_time DATETIME not null comment '修改时间' DEFAULT current_timestamp() ON UPDATE current_timestamp();
```

