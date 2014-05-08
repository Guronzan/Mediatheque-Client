package fr.guronzan.mediatheque.gui;

import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.xml.rpc.ServiceException;

import lombok.extern.slf4j.Slf4j;
import fr.guronzan.mediatheque.gui.createDialog.CreateUser;
import fr.guronzan.mediatheque.utils.DigestUtils;
import fr.guronzan.mediatheque.webservice.DBAccess;
import fr.guronzan.mediatheque.webservice.DBAccessServiceLocator;
import fr.guronzan.mediatheque.webservice.User;

@Slf4j
public class Login {
    private static DBAccess DB_ACCESS;
    static {
        final DBAccessServiceLocator serviceLocator = new DBAccessServiceLocator();
        try {
            DB_ACCESS = serviceLocator.getDBAccessPort();
        } catch (final ServiceException e) {
            DB_ACCESS = null;
            log.error("Error while accessing the webservice", e);
        }

    }

    private JDialog dialogLogin;
    private final JLabel lblPseudo = new JLabel("Pseudo");
    private final JTextField pseudoField = new JTextField();
    private final JLabel lblMotDePasse = new JLabel("Mot de passe");
    private final JButton btnOK = new JButton("OK");
    private final JButton btnExit = new JButton("Quitter");
    private User user;
    private final JButton btnCreateAccount = new JButton("Cr\u00E9er compte");
    private final JLabel lblCreateAccount = new JLabel("Pas encore de compte ?");
    private final JPasswordField passwordField = new JPasswordField();

    /**
     * Launch the application.
     */
    public static void main(final String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    final Login window = new Login(null);
                    window.dialogLogin.setVisible(true);
                } catch (final Exception e) {
                    log.error("Erreur durant l'execution de la frame Login", e);
                }
            }
        });
    }

    /**
     * Create the application.
     *
     * @param parent
     */
    public Login(final Frame parent) {
        initialize(parent);
    }

    /**
     * Initialize the contents of the frame.
     *
     * @param parent
     */
    private void initialize(final Frame parent) {
        this.dialogLogin = new JDialog(parent, true);
        this.dialogLogin.setType(Type.POPUP);
        this.dialogLogin.setTitle("Login");
        this.dialogLogin.setResizable(false);
        this.dialogLogin.setSize(300, 221);
        this.dialogLogin.setLocationRelativeTo(null);
        this.dialogLogin
        .setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        final GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[] { 139, 288, 0 };
        gridBagLayout.rowHeights = new int[] { 0, 56, 40, 39, 46, 0 };
        gridBagLayout.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
        gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
                Double.MIN_VALUE };
        this.dialogLogin.getContentPane().setLayout(gridBagLayout);

        final GridBagConstraints gbcLblPseudo = new GridBagConstraints();
        gbcLblPseudo.fill = GridBagConstraints.VERTICAL;
        gbcLblPseudo.insets = new Insets(0, 0, 5, 5);
        gbcLblPseudo.gridx = 0;
        gbcLblPseudo.gridy = 1;
        this.dialogLogin.getContentPane().add(this.lblPseudo, gbcLblPseudo);
        this.pseudoField.setText("...");
        this.pseudoField.setColumns(10);

        final GridBagConstraints gbcPseudoField = new GridBagConstraints();
        gbcPseudoField.insets = new Insets(0, 0, 5, 0);
        gbcPseudoField.fill = GridBagConstraints.BOTH;
        gbcPseudoField.gridx = 1;
        gbcPseudoField.gridy = 1;
        this.dialogLogin.getContentPane().add(this.pseudoField, gbcPseudoField);

        final GridBagConstraints gbcLblMotDePasse = new GridBagConstraints();
        gbcLblMotDePasse.insets = new Insets(0, 0, 5, 5);
        gbcLblMotDePasse.gridx = 0;
        gbcLblMotDePasse.gridy = 2;
        this.dialogLogin.getContentPane().add(this.lblMotDePasse,
                gbcLblMotDePasse);

        final GridBagConstraints gbcBtnOK = new GridBagConstraints();
        gbcBtnOK.insets = new Insets(0, 0, 0, 5);
        gbcBtnOK.gridx = 0;
        gbcBtnOK.gridy = 4;
        this.btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    final boolean result = DB_ACCESS.checkPasswordFromNickName(
                            Login.this.pseudoField.getText(), DigestUtils
                            .hashPassword(Login.this.passwordField
                                    .getPassword()));
                    if (result) {
                        Login.this.user = DB_ACCESS
                                .getUserFromNickName(Login.this.pseudoField
                                        .getText());
                    }
                } catch (final RemoteException e1) {
                    log.error("Error while checking Password from NickName", e1);
                }
                if (Login.this.user == null) {
                    JOptionPane.showMessageDialog(null,
                            "Compte inconnu ou mot de passe invalide.",
                            "Erreur Login", JOptionPane.ERROR_MESSAGE);
                } else {
                    Login.this.dialogLogin.dispose();
                }
            }
        });
        this.dialogLogin.getContentPane().add(this.btnOK, gbcBtnOK);

        final GridBagConstraints gbcPasswordField = new GridBagConstraints();
        gbcPasswordField.insets = new Insets(0, 0, 5, 0);
        gbcPasswordField.fill = GridBagConstraints.BOTH;
        gbcPasswordField.gridx = 1;
        gbcPasswordField.gridy = 2;
        this.dialogLogin.getContentPane().add(this.passwordField,
                gbcPasswordField);

        final GridBagConstraints gbcLblCreateAccount = new GridBagConstraints();
        gbcLblCreateAccount.insets = new Insets(0, 0, 5, 5);
        gbcLblCreateAccount.gridx = 0;
        gbcLblCreateAccount.gridy = 3;
        this.dialogLogin.getContentPane().add(this.lblCreateAccount,
                gbcLblCreateAccount);

        final GridBagConstraints gbcBtnCreateAccount = new GridBagConstraints();
        gbcBtnCreateAccount.insets = new Insets(0, 0, 5, 0);
        gbcBtnCreateAccount.gridx = 1;
        gbcBtnCreateAccount.gridy = 3;
        this.dialogLogin.getContentPane().add(this.btnCreateAccount,
                gbcBtnCreateAccount);
        this.btnCreateAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                new CreateUser(Login.this.dialogLogin, DB_ACCESS).create();
            }
        });

        final GridBagConstraints gbcBtnExit = new GridBagConstraints();
        gbcBtnExit.gridx = 1;
        gbcBtnExit.gridy = 4;
        this.btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                System.exit(0);
            }
        });
        this.dialogLogin.getContentPane().add(this.btnExit, gbcBtnExit);
    }

    public JDialog getDialogLogin() {
        return this.dialogLogin;
    }

    public String getUserNick() {
        return this.user == null ? null : this.user.getNickName();
    }

    public void setVisible() {
        this.dialogLogin.setVisible(true);
    }
}
