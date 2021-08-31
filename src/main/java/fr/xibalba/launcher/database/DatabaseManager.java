package fr.xibalba.launcher.database;

public class DatabaseManager {

    DatabaseConnection connection;

    public void init() {
        connection = DatabaseConnection.getInstance();

    }

    public void connectClient(String email, String mdp) {

    }
}
