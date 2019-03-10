module controller {
    requires spring.context;
    requires spring.tx;
    requires spring.webmvc;
    requires thymeleaf.spring5;
    requires thymeleaf;
    requires spring.beans;
    requires spring.web;
    requires service;
    requires fastjson;
    requires javax.servlet;
    requires org.hibernate.orm.core;
    requires spring.orm;
    requires java.sql;
    requires druid;
    requires spring.core;
    requires spring.data.jpa;
}