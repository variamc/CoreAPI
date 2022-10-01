package io.github.variamc.coreapi.player;

import io.github.variamc.coreapi.utils.DataSource;
import org.bukkit.entity.Player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class created by Kaseax on 2022
 */
public class PlayerSettings {

    protected final Player player;

    public PlayerSettings(Player player) {
        this.player = player;
    }

    public boolean showTitles() {
        try (Connection con = DataSource.getConnection()) {
            PreparedStatement Stmt = con.prepareStatement("SELECT titles FROM players WHERE uuid = ?");
            Stmt.setString(1, player.getUniqueId().toString());
            ResultSet rs = Stmt.executeQuery();
            while (rs.next())
                return rs.getBoolean("titles");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void enableTitles() {
        try(Connection con = DataSource.getConnection()) {
            PreparedStatement Stmt = con.prepareStatement("UPDATE players SET titles = ? WHERE uuid = ?");
            Stmt.setString(2, player.getUniqueId().toString());
            Stmt.setBoolean(1, true);
            Stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void disableTitles() {
        try(Connection con = DataSource.getConnection()) {
            PreparedStatement Stmt = con.prepareStatement("UPDATE players SET titles = ? WHERE uuid = ?");
            Stmt.setString(2, player.getUniqueId().toString());
            Stmt.setBoolean(1, false);
            Stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean showPets() {
        try (Connection con = DataSource.getConnection()) {
            PreparedStatement Stmt = con.prepareStatement("SELECT pets FROM players WHERE uuid = ?");
            Stmt.setString(1, player.getUniqueId().toString());
            ResultSet rs = Stmt.executeQuery();
            while (rs.next())
                return rs.getBoolean("pets");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void enablePets() {
        try(Connection con = DataSource.getConnection()) {
            PreparedStatement Stmt = con.prepareStatement("UPDATE players SET pets = ? WHERE uuid = ?");
            Stmt.setString(2, player.getUniqueId().toString());
            Stmt.setBoolean(1, true);
            Stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void disablePets() {
        try(Connection con = DataSource.getConnection()) {
            PreparedStatement Stmt = con.prepareStatement("UPDATE players SET pets = ? WHERE uuid = ?");
            Stmt.setString(2, player.getUniqueId().toString());
            Stmt.setBoolean(1, false);
            Stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean showParticles() {
        try (Connection con = DataSource.getConnection()) {
            PreparedStatement Stmt = con.prepareStatement("SELECT particles FROM players WHERE uuid = ?");
            Stmt.setString(1, player.getUniqueId().toString());
            ResultSet rs = Stmt.executeQuery();
            while (rs.next())
                return rs.getBoolean("particles");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void enableParticles() {
        try(Connection con = DataSource.getConnection()) {
            PreparedStatement Stmt = con.prepareStatement("UPDATE players SET particles = ? WHERE uuid = ?");
            Stmt.setString(2, player.getUniqueId().toString());
            Stmt.setBoolean(1, true);
            Stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void disableParticles() {
        try(Connection con = DataSource.getConnection()) {
            PreparedStatement Stmt = con.prepareStatement("UPDATE players SET particles = ? WHERE uuid = ?");
            Stmt.setString(2, player.getUniqueId().toString());
            Stmt.setBoolean(1, false);
            Stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean showBalloons() {
        try (Connection con = DataSource.getConnection()) {
            PreparedStatement Stmt = con.prepareStatement("SELECT balloons FROM players WHERE uuid = ?");
            Stmt.setString(1, player.getUniqueId().toString());
            ResultSet rs = Stmt.executeQuery();
            while (rs.next())
                return rs.getBoolean("balloons");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void enableBalloons() {
        try(Connection con = DataSource.getConnection()) {
            PreparedStatement Stmt = con.prepareStatement("UPDATE players SET balloons = ? WHERE uuid = ?");
            Stmt.setString(2, player.getUniqueId().toString());
            Stmt.setBoolean(1, true);
            Stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void disableBalloons() {
        try(Connection con = DataSource.getConnection()) {
            PreparedStatement Stmt = con.prepareStatement("UPDATE players SET balloons = ? WHERE uuid = ?");
            Stmt.setString(2, player.getUniqueId().toString());
            Stmt.setBoolean(1, false);
            Stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean showArmor() {
        try (Connection con = DataSource.getConnection()) {
            PreparedStatement Stmt = con.prepareStatement("SELECT armor FROM players WHERE uuid = ?");
            Stmt.setString(1, player.getUniqueId().toString());
            ResultSet rs = Stmt.executeQuery();
            while (rs.next())
                return rs.getBoolean("armor");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void enableArmor() {
        try(Connection con = DataSource.getConnection()) {
            PreparedStatement Stmt = con.prepareStatement("UPDATE players SET armor = ? WHERE uuid = ?");
            Stmt.setString(2, player.getUniqueId().toString());
            Stmt.setBoolean(1, true);
            Stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void disableArmor() {
        try(Connection con = DataSource.getConnection()) {
            PreparedStatement Stmt = con.prepareStatement("UPDATE players SET armor = ? WHERE uuid = ?");
            Stmt.setString(2, player.getUniqueId().toString());
            Stmt.setBoolean(1, false);
            Stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean showAbilities() {
        try (Connection con = DataSource.getConnection()) {
            PreparedStatement Stmt = con.prepareStatement("SELECT abilities FROM players WHERE uuid = ?");
            Stmt.setString(1, player.getUniqueId().toString());
            ResultSet rs = Stmt.executeQuery();
            while (rs.next())
                return rs.getBoolean("abilities");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void enableAbilities() {
        try(Connection con = DataSource.getConnection()) {
            PreparedStatement Stmt = con.prepareStatement("UPDATE players SET abilities = ? WHERE uuid = ?");
            Stmt.setString(2, player.getUniqueId().toString());
            Stmt.setBoolean(1, true);
            Stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void disableAbilities() {
        try(Connection con = DataSource.getConnection()) {
            PreparedStatement Stmt = con.prepareStatement("UPDATE players SET abilities = ? WHERE uuid = ?");
            Stmt.setString(2, player.getUniqueId().toString());
            Stmt.setBoolean(1, false);
            Stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
