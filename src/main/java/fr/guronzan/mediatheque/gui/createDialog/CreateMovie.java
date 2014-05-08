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
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.WindowConstants;

import lombok.extern.slf4j.Slf4j;

import com.toedter.calendar.JCalendar;

import fr.guronzan.mediatheque.gui.MainMediatheque;
import fr.guronzan.mediatheque.utils.FileUtils;
import fr.guronzan.mediatheque.utils.ImageFileFilter;
import fr.guronzan.mediatheque.webservice.DBAccess;
import fr.guronzan.mediatheque.webservice.DBAccessServiceLocator;
import fr.guronzan.mediatheque.webservice.Movie;
import fr.guronzan.mediatheque.webservice.User;
import fr.guronzan.mediatheque.webservice.VideoType;

@Slf4j
public class CreateMovie implements CreateDialog {
    /**
     *
     */
    private static final String ERREUR_CREATION_FILM = "Erreur cr�ation film";

    private JDialog frame;
    private JTextField titleField;
    private JTextField directorField;
    private JCalendar releaseDateField;
    private JSpinner tomeSpinner;
    private final JCheckBox ownedDvDCheckbox = new JCheckBox("");
    private final JComboBox<VideoType> typeBox = new JComboBox<>();

    private File picture = null;
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
                    final CreateMovie window = new CreateMovie(null, "nick",
                            dbAccess);
                    window.frame.setVisible(true);
                } catch (final Exception e) {
                    log.error("Error while creating new movie.", e);
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
    public CreateMovie(final MainMediatheque mainMediatheque,
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
        this.frame.setBounds(100, 100, 535, 423);
        this.frame
                .setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        final GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[] { 118, 261, 0 };
        gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        gridBagLayout.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
        gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
                0.0, 0.0, 0.0, Double.MIN_VALUE };
        this.frame.getContentPane().setLayout(gridBagLayout);
        this.frame.setLocationRelativeTo(null);
        this.frame.setModalityType(ModalityType.APPLICATION_MODAL);

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

        final JLabel lblRalisateur = new JLabel("R\u00E9alisateur");
        final GridBagConstraints gbcLblRalisateur = new GridBagConstraints();
        gbcLblRalisateur.insets = new Insets(0, 0, 5, 5);
        gbcLblRalisateur.gridx = 0;
        gbcLblRalisateur.gridy = 2;
        this.frame.getContentPane().add(lblRalisateur, gbcLblRalisateur);

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
        gbcBtnCreer.gridy = 8;
        btnCreer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    if (createMovie()) {
                        if (CreateMovie.this.parent != null) {
                            CreateMovie.this.parent.populateMovieList();
                        }
                        CreateMovie.this.frame.dispose();
                    }
                } catch (final IOException e1) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Erreur durant la cr�ation du film : "
                                    + e1.getMessage(), ERREUR_CREATION_FILM,
                            JOptionPane.ERROR_MESSAGE);
                    CreateMovie.log
                            .error("Error while creating new movie.", e1);
                }
            }
        });

        final JLabel lblType = new JLabel("Type");
        final GridBagConstraints gbcLblType = new GridBagConstraints();
        gbcLblType.anchor = GridBagConstraints.EAST;
        gbcLblType.insets = new Insets(0, 0, 5, 5);
        gbcLblType.gridx = 0;
        gbcLblType.gridy = 4;
        this.frame.getContentPane().add(lblType, gbcLblType);

        final VideoType[] types = { VideoType.CONCERT, VideoType.DOCUMENTARY,
                VideoType.MOVIE, VideoType.TV_SHOW };
        this.typeBox.setModel(new DefaultComboBoxModel<>(types));
        final GridBagConstraints gbcTypeBox = new GridBagConstraints();
        gbcTypeBox.insets = new Insets(0, 0, 5, 0);
        gbcTypeBox.fill = GridBagConstraints.HORIZONTAL;
        gbcTypeBox.gridx = 1;
        gbcTypeBox.gridy = 4;
        this.frame.getContentPane().add(this.typeBox, gbcTypeBox);

        final JLabel lblOwnedDvD = new JLabel("Support DVD");
        final GridBagConstraints gbcLblOwnedDvD = new GridBagConstraints();
        gbcLblOwnedDvD.insets = new Insets(0, 0, 5, 5);
        gbcLblOwnedDvD.gridx = 0;
        gbcLblOwnedDvD.gridy = 5;
        this.frame.getContentPane().add(lblOwnedDvD, gbcLblOwnedDvD);

        final GridBagConstraints gbcOwnedDvDCheckbox = new GridBagConstraints();
        gbcOwnedDvDCheckbox.insets = new Insets(0, 0, 5, 0);
        gbcOwnedDvDCheckbox.gridx = 1;
        gbcOwnedDvDCheckbox.gridy = 5;
        this.frame.getContentPane().add(this.ownedDvDCheckbox,
                gbcOwnedDvDCheckbox);
        this.frame.getContentPane().add(btnCreer, gbcBtnCreer);

        final JLabel lblNumber = new JLabel("Saison / Num\u00E9ro");
        final GridBagConstraints gbcLblNumber = new GridBagConstraints();
        gbcLblNumber.insets = new Insets(0, 0, 5, 5);
        gbcLblNumber.gridx = 0;
        gbcLblNumber.gridy = 6;
        this.frame.getContentPane().add(lblNumber, gbcLblNumber);

        this.tomeSpinner = new JSpinner();
        this.tomeSpinner.setModel(new SpinnerNumberModel(0, 0, 20, 1));
        final GridBagConstraints gbcTomeSpinner = new GridBagConstraints();
        gbcTomeSpinner.insets = new Insets(0, 0, 5, 0);
        gbcTomeSpinner.gridx = 1;
        gbcTomeSpinner.gridy = 6;
        this.frame.getContentPane().add(this.tomeSpinner, gbcTomeSpinner);

        final JLabel lblPicture = new JLabel("Affiche");
        final GridBagConstraints gbcLblPicture = new GridBagConstraints();
        gbcLblPicture.insets = new Insets(0, 0, 5, 5);
        gbcLblPicture.gridx = 0;
        gbcLblPicture.gridy = 7;
        this.frame.getContentPane().add(lblPicture, gbcLblPicture);

        final JButton btnSelectionnerImage = new JButton("Selectionner image");
        final GridBagConstraints gbcBtnSelectionnerImage = new GridBagConstraints();
        gbcBtnSelectionnerImage.insets = new Insets(0, 0, 5, 0);
        gbcBtnSelectionnerImage.gridx = 1;
        gbcBtnSelectionnerImage.gridy = 7;
        this.frame.getContentPane().add(btnSelectionnerImage,
                gbcBtnSelectionnerImage);

        btnSelectionnerImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileFilter(new ImageFileFilter());
                final int result = fileChooser
                        .showOpenDialog(CreateMovie.this.frame);

                if (result == JFileChooser.APPROVE_OPTION) {
                    CreateMovie.this.picture = fileChooser.getSelectedFile();
                }
            }
        });

        final JButton btnQuitter = new JButton("Quitter");
        final GridBagConstraints gbcBtnQuitter = new GridBagConstraints();
        gbcBtnQuitter.gridx = 1;
        gbcBtnQuitter.gridy = 8;
        btnQuitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                CreateMovie.this.frame.dispose();
            }
        });
        this.frame.getContentPane().add(btnQuitter, gbcBtnQuitter);
    }

    private boolean createMovie() throws IOException {
        final Integer seasonValue = (Integer) this.tomeSpinner.getValue();
        final boolean movieExists;
        if (seasonValue == 0) {
            movieExists = this.dbAccess.containsMovie(
                    this.titleField.getText(), -1);
        } else {
            movieExists = this.dbAccess.containsMovie(
                    this.titleField.getText(), seasonValue);
        }

        if (movieExists) {
            JOptionPane
                    .showMessageDialog(
                            null,
                            "Titre et saison d�j� existant, veuillez le choisir dans la liste",
                            "Erreur cr�ation Livre", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        final String title = this.titleField.getText();
        if (title.equals("...") || title.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Veuillez renseigner un Titre.", ERREUR_CREATION_FILM,
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        final String directorName = this.directorField.getText();
        if (directorName.equals("...") || directorName.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Veuillez renseigner un r�alisateur.",
                    ERREUR_CREATION_FILM, JOptionPane.ERROR_MESSAGE);
            return false;
        }

        final Movie movie = new Movie();
        movie.setTitle(title);
        movie.setDirectorName(directorName);
        movie.setPicture(FileUtils.getArray(this.picture));
        movie.setOwnedDVD(this.ownedDvDCheckbox.isSelected());
        movie.setType((VideoType) this.typeBox.getSelectedItem());
        movie.setReleaseDate(this.releaseDateField.getCalendar());

        this.dbAccess.addMovie(movie);
        final User currentUser = this.dbAccess
                .getUserFromNickName(this.currentNick);

        final Movie[] movies = currentUser.getMovies();
        if (movies == null) {
            final Movie[] newList = { movie };
            currentUser.setMovies(newList);
        } else {
            movies[movies.length] = movie;
        }

        this.dbAccess.updateUserFromUser(currentUser);

        JOptionPane.showMessageDialog(null,
                "Cr�ation du film " + movie.getTitle()
                        + " r�alis�e avec succ�s.", "Cr�ation r�ussie",
                JOptionPane.INFORMATION_MESSAGE);
        log.info("Movie {} created sucessfully at {}", movie, new Date());
        return true;
    }

    @Override
    public void create() {
        this.frame.setVisible(true);
    }
}
