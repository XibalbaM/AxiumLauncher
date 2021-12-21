package fr.xibalba.utils;

import java.util.Locale;

public enum OperatingSystem {
    LINUX("linux", "linux", "unix"),
    WINDOWS("windows", "win"),
    MACOS("osx", "mac"),
    UNKNOWN("unknown");

    private final String name;
    private final String[] aliases;

    OperatingSystem(String name, String... aliases) {

        this.name = name;
        this.aliases = aliases == null ? new String[0] : aliases;
    }

    public static OperatingSystem getCurrentOS() {

        final String osName = System.getProperty("os.name").toLowerCase();

        for (final OperatingSystem os : values()) {

            for (String alias : os.aliases) {
                if (osName.contains(alias)) {
                    return os;
                }
            }
        }

        return OperatingSystem.UNKNOWN;
    }

    public String getName() {

        return name;
    }

    public String[] getAliases() {

        return aliases;
    }
}