package ancient_encryption;

public abstract class AbstractCipher implements CipherInterface {

    @Override
    public abstract String encrypt(String original);

    @Override
    public abstract String decrypt(String encrypted);

    protected int findCharIndex(char ch) {
        for (int i = 0; i < ALPHABETH.length; i++) {
            if (ALPHABETH[i] == ch) {
                return i;
            }
        }
        return -1;
    }
}
