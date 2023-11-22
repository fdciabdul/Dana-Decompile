package id.dana.passkey.challenge;

import android.util.Base64;
import java.security.SecureRandom;

/* loaded from: classes5.dex */
public class FidoChallengerGenerator implements ChallengeGenerator {
    private final SecureRandom secureRandom = new SecureRandom();

    @Override // id.dana.passkey.challenge.ChallengeGenerator
    public String generateChallenge() {
        byte[] bArr = new byte[32];
        this.secureRandom.nextBytes(bArr);
        return Base64.encodeToString(bArr, 11);
    }
}
