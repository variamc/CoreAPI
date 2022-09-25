package io.github.variamc.coreapi.language;

import io.github.variamc.coreapi.utils.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class created by Kaseax on 2022
 */
public class LanguageAPI {

    public LanguageAPI() {

    }

    public static String getLanguage(String uuid) {
        try (Connection con = DataSource.getConnection()) {
            PreparedStatement Stmt = con.prepareStatement("SELECT language FROM players WHERE uuid = ?");
            Stmt.setString(1, uuid);
            ResultSet rs = Stmt.executeQuery();
            while (rs.next())
                return rs.getString("language");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void setLanguage(String uuid, String language) {
        try(Connection con = DataSource.getConnection()) {
            PreparedStatement Stmt = con.prepareStatement("UPDATE players SET language = ? WHERE uuid = ?");
            Stmt.setString(2, uuid);
            Stmt.setString(1, language);
            Stmt.executeUpdate();
            //TODO: Call PlayerLanguageChangeEvent
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
