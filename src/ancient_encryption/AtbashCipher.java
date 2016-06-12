package ancient_encryption;

public class AtbashCipher extends AbstractCipher {

    @Override
    public String encrypt(String original) {
        StringBuilder encryptedString = new StringBuilder();
        for (char character : original.toCharArray()) {
            encryptedString.append(getOppositeCharacter(character));
        }
        return encryptedString.toString();
    }

    private char getOppositeCharacter(char ch) {
        int index = findCharIndex(ch);
        if (index == -1) {
            return ch;
        }
        return ALPHABETH[ALPHABETH.length - index - 1];
    }

    @Override
    public String decrypt(String encrypted) {
        return encrypt(encrypted);
    }
}
