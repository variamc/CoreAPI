package de.variamc.coreapi.player;

import de.variamc.coreapi.utils.DataSource;
import org.bukkit.Bukkit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

/**
 * Class created by Kaseax on 2022
 */
public class CorePlayer {

    protected final String name;

    protected final UUID uuid;

    public CorePlayer(UUID uuid) {
        this.uuid = uuid;
        this.name = Bukkit.getOfflinePlayer(uuid).getName();
    }

    public boolean isRegistered() {
        try (Connection con = DataSource.getConnection()) {
            PreparedStatement Stmt = con.prepareStatement("SELECT * FROM players WHERE uuid = ?");
            Stmt.setString(1, uuid.toString());
            ResultSet rs = Stmt.executeQuery();
            if (rs.next())
                return (rs.getString("uuid") != null);
            rs.close();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void getLanguage() {

    }

    public void setLanguage() {

    }

    public String getName() {
        return name;
    }

    public UUID getUniqueId() {
        return uuid;
    }
}
