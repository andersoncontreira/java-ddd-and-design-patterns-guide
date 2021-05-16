package dev.andersoncontreira.trainingddd.infrastructure.persistence.hibernate;

import dev.andersoncontreira.trainingddd.application.configuration.Configuration;

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

    public PersistenceConfiguration() {

    }

    public PersistenceConfiguration(Configuration configuration) {
        populate(configuration);
    }

    public void populate(Configuration configuration) {
        hostname = configuration.get("persistence.hostname");
        username = configuration.get("persistence.username");
        password = configuration.get("persistence.password");
        database = configuration.get("persistence.database");
        driver = configuration.get("persistence.driver");
        manager = configuration.get("persistence.manager");
        type = configuration.get("persistence.type");
        poolSize = Integer.parseInt(configuration.get("persistence.poolSize"));
        port = Integer.parseInt(configuration.get("persistence.port"));
        showSql = Boolean.valueOf(configuration.get("persistence.showSql"));
    }
}
