package id.dana.data.verifytoken.repository.source;

import id.dana.data.verifytoken.repository.source.network.result.VerifyTokenResult;
import io.reactivex.Observable;

/* loaded from: classes2.dex */
public interface VerifyTokenEntityData {
    Observable<VerifyTokenResult> getVerifyToken(String str, String str2);
}
