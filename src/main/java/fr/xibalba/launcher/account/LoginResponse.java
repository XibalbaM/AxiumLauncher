package fr.xibalba.launcher.account;

import fr.xibalba.launcher.exceptions.LoginException;

public record LoginResponse(boolean succeed, LoginException error) {}