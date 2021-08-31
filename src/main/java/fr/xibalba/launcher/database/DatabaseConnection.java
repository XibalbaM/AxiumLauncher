package fr.xibalba.launcher.database;

public class DatabaseConnection {

    private static DatabaseConnection instance = new DatabaseConnection();

    private DatabaseConnection() {
    }

    public static DatabaseConnection getInstance() {
        return instance;
    }
}
