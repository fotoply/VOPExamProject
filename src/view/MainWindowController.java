package view;

import ancient_encryption.AtbashCipher;
import ancient_encryption.CaesarCipher;
import ancient_encryption.CipherInterface;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import rock_scissors_paper.RockScissorsPaper;

import java.io.File;
import java.util.HashMap;

public class MainWindowController {

    private RockScissorsPaper rockScissorsPaper;
    private HashMap<String, Image> imageMap = new HashMap<>();

    @FXML
    private TextField decryptedTextField;

    @FXML
    private TextField originalTextField;

    @FXML
    private RadioButton atbashRadioButton;

    @FXML
    private ToggleGroup encryptionToggleGroup;

    @FXML
    private RadioButton caesarRadioButton;

    @FXML
    private Spinner<Integer> rotationFactorSpinner;

    @FXML
    private Button encryptButton;

    @FXML
    private Button decryptButton;

    @FXML
    private TextField encryptedTextField;

    @FXML
    private Button rockButton;

    @FXML
    private Button scissorsButton;

    @FXML
    private Button paperButton;

    @FXML
    private Text computerChoiceText;

    @FXML
    private Text resultsText;

    @FXML
    private ImageView computerChoiceImage;

    @FXML
    private ImageView yourChoiceImage;

    @FXML
    private Text yourChoiceText;

    @FXML
    void rockPaperScissorsButtonClicked(ActionEvent event) {
        if (event.getSource() == rockButton) {
            rockScissorsPaper.play("Sten");
        } else if (event.getSource() == paperButton) {
            rockScissorsPaper.play("Papir");
        } else if (event.getSource() == scissorsButton) {
            rockScissorsPaper.play("Saks");
        } else {
            throw new IllegalArgumentException("This (rockPaperScissors) event was called without pressing one of the three buttons.");
        }
        computerChoiceText.setText(rockScissorsPaper.getComputersHand());
        yourChoiceText.setText(rockScissorsPaper.getPlayersHand());

        computerChoiceImage.setImage(imageMap.get(rockScissorsPaper.getComputersHand()));
        yourChoiceImage.setImage(imageMap.get(rockScissorsPaper.getPlayersHand()));

        resultsText.setText(rockScissorsPaper.getWinner());
    }

    @FXML
    void encryptionButtonClicked(ActionEvent event) {
        CipherInterface cipherInterface = getUsedCipher();

        if (event.getSource().equals(encryptButton)) {
            encryptedTextField.setText(cipherInterface.encrypt(originalTextField.getText()));
        } else if (event.getSource().equals(decryptButton)) {
            decryptedTextField.setText(cipherInterface.decrypt(encryptedTextField.getText()));
        } else {
            throw new IllegalArgumentException("This (encryption) event was called without pressing one of the two buttons.");
        }
    }

    private CipherInterface getUsedCipher() {
        if (atbashRadioButton.isSelected()) {
            return new AtbashCipher();
        } else if(caesarRadioButton.isSelected()){
            return new CaesarCipher(rotationFactorSpinner.getValue());
        } else {
            throw new IllegalArgumentException("This (encryption) event was called without pressing one of the two radio buttons.");
        }
    }

    @FXML
    void initialize() {
        rotationFactorSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, CipherInterface.ALPHABETH.length - 1, CipherInterface.ALPHABETH.length / 2));
        rockScissorsPaper = new RockScissorsPaper();
        imageMap.put("Sten", new Image(new File("res/Rock.png").toURI().toString()));
        imageMap.put("Saks", new Image(new File("res/Scissors.png").toURI().toString()));
        imageMap.put("Papir", new Image(new File("res/Paper.png").toURI().toString()));
    }

}