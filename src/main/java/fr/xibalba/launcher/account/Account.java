package fr.xibalba.launcher.account;

import javafx.scene.image.Image;

public class Account {

    private String username;

    private Image icon;

    private int level;

    public String username() {
        return username;
    }

    public Image icon() {
        return icon;
    }

    public int level() {
        return level;
    }

    public static class Builder {

        private Account product;

        private Builder(Account product) {
            this.product = product;
            this.product.level = 1;
        }

        public static Builder of() {
            return new Builder(new Account());
        }

        public Builder withUsername(String username) {
            product.username = username;
            return this;
        }

        public Builder withIcon(Image icon) {
            product.icon = icon;
            return this;
        }

        public Builder withLevel(int level) {
            product.level = level;
            return this;
        }

        public Account build() {
            return product;
        }
    }
}