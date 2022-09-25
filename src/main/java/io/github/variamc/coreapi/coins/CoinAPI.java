package io.github.variamc.coreapi.coins;

import io.github.variamc.coreapi.utils.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class created by Kaseax on 2022
 */
public class CoinAPI {

    public CoinAPI() {

    }

    /**
     * Get the Coins of an uuid
     * @param uuid
     * @return an int with the coins amount from the uuid
     */
    public static int getCoins(String uuid) {
        try(Connection con = DataSource.getConnection()) {
            PreparedStatement Stmt = con.prepareStatement("SELECT coins FROM players WHERE uuid = ?");
            Stmt.setString(1, uuid);
            ResultSet rs = Stmt.executeQuery();
            while (rs.next())
                return rs.getInt("coins");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void setCoins(String uuid, int coins) {
        if(getCoins(uuid) == -1) {
            try(Connection con = DataSource.getConnection()) {
                PreparedStatement Stmt = con.prepareStatement("INSERT INTO players (uuid, coins) VALUES (?, ?)");
                Stmt.setString(1, uuid);
                Stmt.setInt(2, coins);
                Stmt.executeUpdate();
                //TODO: Call PlayerCoinChangeEvent
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            try(Connection con = DataSource.getConnection()) {
                PreparedStatement Stmt = con.prepareStatement("UPDATE players SET coins = ? WHERE uuid = ?");
                Stmt.setString(2, uuid);
                Stmt.setInt(1, coins);
                Stmt.executeUpdate();
                //TODO: Call PlayerCoinChangeEvent
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void addCoins(String uuid, int coins) {
        int current = getCoins(uuid);
        setCoins(uuid, coins + current);
    }

    public static void resetCoins(String uuid) {
        setCoins(uuid, 0);
    }

    public static void removeCoins(String uuid, int coins) {
        setCoins(uuid, getCoins(uuid) - coins);
    }
}
