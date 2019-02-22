module dao {
    requires spring.tx;
    requires spring.orm;
    requires spring.beans;
    requires spring.context;
    requires lombok;
    requires org.hibernate.orm.core;
    requires java.persistence;
    requires spring.core;
    requires druid;
    requires java.sql;
    requires spring.data.jpa;

    exports dao;
    exports dao.api;
    exports dao.entity.po;
}