package dev.andersoncontreira.trainingddd.infrastructure.persistence.hibernate;

public class PersistenceConfiguration {
    public String hostname = "localhost";

    public String username = "username";

    public String password = "password";

    public String database = "database";

    public String driver = "com.mysql.cj.jdbc.Driver";

    public String manager = "hibernate";

    public String type = "mysql";

    public int poolSize = 100;

    public int port = 3306;

    public Boolean showSql = false;

}
