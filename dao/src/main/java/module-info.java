module dao {
    requires spring.tx;
    requires spring.orm;
    requires spring.beans;
    requires spring.context;
    requires org.hibernate.orm.core;
    requires java.persistence;
    requires spring.core;
    requires druid;
    requires java.sql;
    requires spring.data.jpa;
    requires java.naming;
    requires java.management;
    requires lombok;

    exports dao;
    exports dao.api;
    exports dao.entity.po;
}