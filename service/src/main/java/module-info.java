module service {
    exports entity.dto;
    exports service;
    requires dao;
    requires jackson.annotations;
    requires lombok;
    requires spring.context;
    requires spring.beans;
    requires org.hibernate.orm.core;
}