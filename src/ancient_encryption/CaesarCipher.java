package ancient_encryption;

public class CaesarCipher extends AbstractCipher {

    private int rotFactor;

    public CaesarCipher(int rotFactor) {
        if (rotFactor < 0) {
            this.rotFactor = 0;
        } else if (rotFactor > ALPHABETH.length) {
            this.rotFactor = ALPHABETH.length;
        } else {
            this.rotFactor = rotFactor;
        }
    }

    @Override
    public String encrypt(String original) {
        StringBuilder encryptedString = new StringBuilder();
        for (char character : original.toCharArray()) {
            encryptedString.append(findCharacterByRotation(character));
        }
        return encryptedString.toString();
    }

    private char findCharacterByRotation(char ch) {
        int index = findCharIndex(ch);
        if (index == -1) {
            return ch;
        }

        return ALPHABETH[(index + rotFactor) % (ALPHABETH.length - 1)];
    }

    private char findCharacterByNegativeRotation(char ch) {
        int index = findCharIndex(ch);
        if (index == -1) {
            return ch;
        }

        int newIndex = index - rotFactor;
        if (newIndex < 0) {
            newIndex = ALPHABETH.length + newIndex - 1;
        }
        return ALPHABETH[newIndex];
    }

    @Override
    public String decrypt(String encrypted) {
        StringBuilder decryptedString = new StringBuilder();
        for (char character : encrypted.toCharArray()) {
            decryptedString.append(findCharacterByNegativeRotation(character));
        }
        return decryptedString.toString();
    }
}
