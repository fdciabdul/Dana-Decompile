package id.dana.data.security.source;

import io.reactivex.Observable;

/* loaded from: classes2.dex */
public interface SecurityEntityData {
    Observable<String> cardCredentialKey();

    Observable<String> loginKey();

    Observable<String> offlinePayKey();
}
