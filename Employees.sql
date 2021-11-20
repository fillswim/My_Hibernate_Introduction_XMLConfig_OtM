CREATE TABLE my_db.employees
(
    id            int not null auto_increment,
    name          varchar(15),
    surname       varchar(25),
    salary        int,
    department_id int,
    primary key (id),
    foreign key (department_id) references my_db.departments (id)
);


