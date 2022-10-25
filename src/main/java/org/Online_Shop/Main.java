package org.Online_Shop;

import org.Online_Shop.menu.Impl.MainMenu;
import org.Online_Shop.menu.Menu;

public class Main {

    public static final String EXIT_COMMAND = "exit";

        public static void main(String[] args) {
            Menu mainMenu = new MainMenu();
            mainMenu.start();
        }
    }
