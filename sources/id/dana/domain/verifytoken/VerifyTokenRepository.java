package id.dana.domain.verifytoken;

import io.reactivex.Observable;

/* loaded from: classes2.dex */
public interface VerifyTokenRepository {
    Observable<String> getPinWithVerifiedToken(String str, String str2, String str3);
}
