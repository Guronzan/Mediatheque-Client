package fr.guronzan.mediatheque.gui.createDialog;

import java.awt.Dialog.ModalityType;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import lombok.extern.slf4j.Slf4j;

import com.toedter.calendar.JCalendar;

import fr.guronzan.mediatheque.gui.MainMediatheque;
import fr.guronzan.mediatheque.utils.FileUtils;
import fr.guronzan.mediatheque.utils.ImageFileFilter;
import fr.guronzan.mediatheque.webservice.Cd;
import fr.guronzan.mediatheque.webservice.CdKindType;
import fr.guronzan.mediatheque.webservice.DBAccess;
import fr.guronzan.mediatheque.webservice.DBAccessServiceLocator;
import fr.guronzan.mediatheque.webservice.User;

@Slf4j
public class CreateCD implements CreateDialog {
    /**
     *
     */
    private static final String ERREUR_CREATION_CD = "Erreur cr�ation CD";

    private JDialog frame;
    private JTextField titleField;
    private JTextField directorField;
    private JCalendar releaseDateField;
    private File picture = null;

    private final JComboBox<CdKindType> kindTypeBox = new JComboBox<>();

    private final String currentNick;

    private final MainMediatheque parent;

    private final DBAccess dbAccess;

    /**
     * Launch the application.
     */
    public static void main(final String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    final DBAccessServiceLocator serviceLocator = new DBAccessServiceLocator();
                    final DBAccess dbAccess = serviceLocator.getDBAccessPort();
                    final CreateCD window = new CreateCD(null, "nick", dbAccess);
                    window.frame.setVisible(true);
                } catch (final Exception e) {
                    log.error("Error while creating new CD.", e);
                }
            }
        });
    }

    /**
     * Create the application.
     *
     * @param mainMediatheque
     *
     * @param currentUser
     */
    public CreateCD(final MainMediatheque mainMediatheque,
            final String currentUser, final DBAccess dbAccess) {
        this.currentNick = currentUser;
        this.parent = mainMediatheque;
        this.dbAccess = dbAccess;
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        this.frame = new JDialog();
        this.frame.setBounds(100, 100, 536, 387);
        this.frame
                .setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        final GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[] { 118, 261, 0 };
        gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        gridBagLayout.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
        gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
                0.0, 0.0, Double.MIN_VALUE };
        this.frame.getContentPane().setLayout(gridBagLayout);
        this.frame.setModalityType(ModalityType.APPLICATION_MODAL);
        this.frame.setLocationRelativeTo(null);

        final JLabel lblTitle = new JLabel("Titre");
        final GridBagConstraints gbcLblTitle = new GridBagConstraints();
        gbcLblTitle.insets = new Insets(0, 0, 5, 5);
        gbcLblTitle.gridx = 0;
        gbcLblTitle.gridy = 1;
        this.frame.getContentPane().add(lblTitle, gbcLblTitle);

        this.titleField = new JTextField();
        this.titleField.setText("...");
        final GridBagConstraints gbcTitleField = new GridBagConstraints();
        gbcTitleField.fill = GridBagConstraints.HORIZONTAL;
        gbcTitleField.insets = new Insets(0, 0, 5, 0);
        gbcTitleField.gridx = 1;
        gbcTitleField.gridy = 1;
        this.frame.getContentPane().add(this.titleField, gbcTitleField);
        this.titleField.setColumns(10);

        final JLabel lblAuthor = new JLabel("Chanteur / Groupe");
        final GridBagConstraints gbcLblAuthor = new GridBagConstraints();
        gbcLblAuthor.insets = new Insets(0, 0, 5, 5);
        gbcLblAuthor.gridx = 0;
        gbcLblAuthor.gridy = 2;
        this.frame.getContentPane().add(lblAuthor, gbcLblAuthor);

        this.directorField = new JTextField();
        this.directorField.setText("...");
        final GridBagConstraints gbcDirectorField = new GridBagConstraints();
        gbcDirectorField.insets = new Insets(0, 0, 5, 0);
        gbcDirectorField.fill = GridBagConstraints.HORIZONTAL;
        gbcDirectorField.gridx = 1;
        gbcDirectorField.gridy = 2;
        this.frame.getContentPane().add(this.directorField, gbcDirectorField);
        this.directorField.setColumns(10);

        final JLabel lblReleaseDate = new JLabel("Date de sortie");
        final GridBagConstraints gbcLblReleaseDate = new GridBagConstraints();
        gbcLblReleaseDate.insets = new Insets(0, 0, 5, 5);
        gbcLblReleaseDate.gridx = 0;
        gbcLblReleaseDate.gridy = 3;
        this.frame.getContentPane().add(lblReleaseDate, gbcLblReleaseDate);

        this.releaseDateField = new JCalendar();
        this.releaseDateField.setCalendar(Calendar.getInstance());
        final GridBagConstraints gbcReleaseDateField = new GridBagConstraints();
        gbcReleaseDateField.insets = new Insets(0, 0, 5, 0);
        gbcReleaseDateField.fill = GridBagConstraints.HORIZONTAL;
        gbcReleaseDateField.gridx = 1;
        gbcReleaseDateField.gridy = 3;
        this.frame.getContentPane().add(this.releaseDateField,
                gbcReleaseDateField);

        final JButton btnCreer = new JButton("Cr\u00E9er");
        final GridBagConstraints gbcBtnCreer = new GridBagConstraints();
        gbcBtnCreer.insets = new Insets(0, 0, 0, 5);
        gbcBtnCreer.gridx = 0;
        gbcBtnCreer.gridy = 7;
        btnCreer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    if (createCD()) {
                        if (CreateCD.this.parent != null) {
                            CreateCD.this.parent.populateCDList();
                        }
                        CreateCD.this.frame.dispose();
                    }
                } catch (final IOException e1) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Erreur durant la cr�ation du CD : "
                                    + e1.getMessage(), ERREUR_CREATION_CD,
                            JOptionPane.ERROR_MESSAGE);
                    CreateCD.log.error("Error while creating new CD.", e1);
                }
            }
        });

        final JLabel lblKind = new JLabel("Genre");
        final GridBagConstraints gbcLblKind = new GridBagConstraints();
        gbcLblKind.anchor = GridBagConstraints.EAST;
        gbcLblKind.insets = new Insets(0, 0, 5, 5);
        gbcLblKind.gridx = 0;
        gbcLblKind.gridy = 4;
        this.frame.getContentPane().add(lblKind, gbcLblKind);

        final CdKindType[] types = { CdKindType.POP, CdKindType.ROCK,
                CdKindType.VARIETE_FRANCAISE };
        this.kindTypeBox.setModel(new DefaultComboBoxModel<>(types));
        final GridBagConstraints gbcComboBox = new GridBagConstraints();
        gbcComboBox.insets = new Insets(0, 0, 5, 0);
        gbcComboBox.fill = GridBagConstraints.HORIZONTAL;
        gbcComboBox.gridx = 1;
        gbcComboBox.gridy = 4;
        this.frame.getContentPane().add(this.kindTypeBox, gbcComboBox);

        final JLabel lblPicture = new JLabel("Jacquette");
        final GridBagConstraints gbcLblPicture = new GridBagConstraints();
        gbcLblPicture.insets = new Insets(0, 0, 5, 5);
        gbcLblPicture.gridx = 0;
        gbcLblPicture.gridy = 5;
        this.frame.getContentPane().add(lblPicture, gbcLblPicture);

        final JButton btnSelectionnerImage = new JButton("Selectionner image");
        final GridBagConstraints gbcBtnSelectionnerImage = new GridBagConstraints();
        gbcBtnSelectionnerImage.insets = new Insets(0, 0, 5, 0);
        gbcBtnSelectionnerImage.gridx = 1;
        gbcBtnSelectionnerImage.gridy = 5;
        this.frame.getContentPane().add(btnSelectionnerImage,
                gbcBtnSelectionnerImage);

        btnSelectionnerImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileFilter(new ImageFileFilter());
                final int result = fileChooser
                        .showOpenDialog(CreateCD.this.frame);

                if (result == JFileChooser.APPROVE_OPTION) {
                    CreateCD.this.picture = fileChooser.getSelectedFile();
                }
            }
        });
        this.frame.getContentPane().add(btnCreer, gbcBtnCreer);

        final JButton btnQuitter = new JButton("Quitter");
        final GridBagConstraints gbcBtnQuitter = new GridBagConstraints();
        gbcBtnQuitter.gridx = 1;
        gbcBtnQuitter.gridy = 7;
        btnQuitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                CreateCD.this.frame.dispose();
            }
        });
        this.frame.getContentPane().add(btnQuitter, gbcBtnQuitter);
    }

    private boolean createCD() throws IOException {

        final boolean cdExists = this.dbAccess.containsCD(this.titleField
                .getText());

        if (cdExists) {
            JOptionPane.showMessageDialog(null,
                    "Titre d�j� existant, veuillez le choisir dans la liste",
                    ERREUR_CREATION_CD, JOptionPane.ERROR_MESSAGE);
            return false;
        }

        final String title = this.titleField.getText();
        if (title.equals("...") || title.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Veuillez renseigner un Titre.", ERREUR_CREATION_CD,
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        final String authorName = this.directorField.getText();
        if (authorName.equals("...") || authorName.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Veuillez renseigner un groupe/chanteur.",
                    ERREUR_CREATION_CD, JOptionPane.ERROR_MESSAGE);
            return false;
        }

        final Cd cd = new Cd();
        cd.setTitle(title);
        cd.setAuthorName(authorName);
        cd.setPicture(FileUtils.getArray(this.picture));
        cd.setKind((CdKindType) this.kindTypeBox.getSelectedItem());
        final Calendar calendar = this.releaseDateField.getCalendar();
        cd.setReleaseDate(new GregorianCalendar(calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH), calendar
                        .get(Calendar.DAY_OF_MONTH)));
        final User currentUser = this.dbAccess
                .getUserFromNickName(this.currentNick);

        this.dbAccess.addCD(cd);
        final Cd[] cds = currentUser.getCds();
        if (cds == null) {
            final Cd[] newList = { cd };
            currentUser.setCds(newList);
        } else {
            cds[cds.length] = cd;
        }

        this.dbAccess.updateUserFromUser(currentUser);

        JOptionPane.showMessageDialog(null, "Cr�ation du CD " + cd.getTitle()
                + " r�alis�e avec succ�s.", "Cr�ation r�ussie",
                JOptionPane.INFORMATION_MESSAGE);
        log.info("CD {} created sucessfully at {}", cd, new Date());
        return true;
    }

    @Override
    public void create() {
        this.frame.setVisible(true);
    }
}
