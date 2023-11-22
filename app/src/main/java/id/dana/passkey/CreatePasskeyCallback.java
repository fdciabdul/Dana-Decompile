package id.dana.passkey;

import id.dana.passkey.exception.PasskeyException;
import id.dana.passkey.model.CreatePasskeyResponse;

/* loaded from: classes5.dex */
public interface CreatePasskeyCallback {
    void onError(PasskeyException passkeyException);

    void onResult(CreatePasskeyResponse createPasskeyResponse);
}
