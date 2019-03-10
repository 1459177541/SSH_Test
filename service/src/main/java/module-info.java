module service {

    exports entity.dto;
    exports service;

    requires dao;
    requires spring.context;
    requires spring.beans;
    requires org.hibernate.orm.core;
    requires spring.tx;
    requires spring.orm;
    requires java.sql;
}