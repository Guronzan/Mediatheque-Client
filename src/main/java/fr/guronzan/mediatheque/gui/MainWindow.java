package fr.guronzan.mediatheque.gui;

import java.rmi.RemoteException;

import javax.swing.JOptionPane;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MainWindow {
    /**
     * Launch the application.
     */
    public static void main(final String[] args) {
        final MainMediatheque mainMediatheque = new MainMediatheque();
        mainMediatheque.getFrame().setVisible(true);

        final Login loginWindow = new Login(mainMediatheque.getFrame());
        loginWindow.getDialogLogin().setVisible(true);

        final String result = loginWindow.getUserNick();

        try {
            if (result != null) {
                mainMediatheque.setUserNick(result);
                mainMediatheque.fillData();
            } else {
                JOptionPane.showMessageDialog(null,
                        "Compte inconnu ou mot de passe invalide.",
                        "Erreur Login", JOptionPane.ERROR_MESSAGE);
            }
        } catch (final RemoteException e) {
            log.error("RemoteException error while using the application", e);
        }
    }
}
