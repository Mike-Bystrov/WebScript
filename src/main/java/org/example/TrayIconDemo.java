package org.example;
import java.awt.*;
import java.awt.TrayIcon.MessageType;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class TrayIconDemo {

    public static void main(String[] args) throws AWTException {
        if (SystemTray.isSupported()) {
            TrayIconDemo td = new TrayIconDemo();
            td.displayTray("hello, mikee");
        } else {
            System.err.println("System tray not supported!");
        }
    }

    public void displayTray(String message) throws AWTException {
        SystemTray tray = SystemTray.getSystemTray();

        Image image = Toolkit.getDefaultToolkit().createImage("icon.png");
        TrayIcon trayIcon = new TrayIcon(image, "Tray Demo");
        trayIcon.setImageAutoSize(true);
        trayIcon.setToolTip("System tray icon demo");

        trayIcon.addActionListener(e -> {
            try {
                Desktop.getDesktop().browse(new URI("https://pass.rw.by/ru/route/?from=%D0%92%D0%B8%D1%82%D0%B5%D0%B1%D1%81%D0%BA&from_exp=0&from_esr=0&to=%D0%9C%D0%B8%D0%BD%D1%81%D0%BA&to_exp=0&to_esr=0&date=&type=1"));
            } catch (IOException | URISyntaxException ex) {
                ex.printStackTrace();
            }
        });

        tray.add(trayIcon);

        trayIcon.displayMessage("Hello, World", message, MessageType.INFO);
    }
}
