package ancient_encryption;

/**
 * Created 6/10/16
 *
 * @author Niels Norberg
 */
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
