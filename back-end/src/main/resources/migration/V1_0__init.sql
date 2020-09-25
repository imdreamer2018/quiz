CREATE table product (
    id int(11) not null primary key auto_increment,
    name varchar(255) not null,
    price int(11) not null,
    unit varchar(100) not null,
    img_link varchar(100) not null
) engine=InnoDB default charset=utf8;