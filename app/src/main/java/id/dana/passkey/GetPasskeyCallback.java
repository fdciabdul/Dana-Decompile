package id.dana.passkey;

import id.dana.passkey.exception.PasskeyException;
import id.dana.passkey.model.GetPasskeyResponse;

/* loaded from: classes5.dex */
public interface GetPasskeyCallback {
    void onError(PasskeyException passkeyException);

    void onResult(GetPasskeyResponse getPasskeyResponse);
}
