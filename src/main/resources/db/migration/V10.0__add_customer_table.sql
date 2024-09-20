create table customer
(
    id bigint auto_increment primary key,
    customer_name varchar(50),
    address varchar(30),
    city varchar(30),
    state varchar(30),
    zip_code varchar(30),
    phone varchar(20),
    email varchar(255),
    created_date timestamp,
    last_modified_date timestamp
);

alter table order_header
    add column customer_id bigint,
    add constraint customer_pk foreign key (customer_id) references customer(id);

alter table order_header
    drop column customer;

insert into customer(customer_name, created_date, last_modified_date)
    values ('CUSTOMER1', now(), now());

update order_header
    set order_header.customer_id = (select id from customer where customer_name = 'CUSTOMER1' limit 1);