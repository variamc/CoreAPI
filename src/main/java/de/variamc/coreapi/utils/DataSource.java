package de.variamc.coreapi.utils;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import de.variamc.coreapi.CoreAPI;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Class created by Kaseax on 2022
 */
public class DataSource {

    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;

    static {
        config.setJdbcUrl("jdbc:mysql://" + CoreAPI.getInstance().getConfig().getString("mysql.host") + ":" + CoreAPI.getInstance().getConfig().getString("mysql.port") + "/" + CoreAPI.getInstance().getConfig().getString("mysql.database"));
        config.setUsername(CoreAPI.getInstance().getConfig().getString("mysql.user"));
        config.setPassword(CoreAPI.getInstance().getConfig().getString("mysql.password"));
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        ds = new HikariDataSource(config);
    }

    public DataSource() {}

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
