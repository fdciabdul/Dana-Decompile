package id.dana.domain.sslpinning;

import io.reactivex.Observable;

/* loaded from: classes2.dex */
public interface SSLPinningRepository {
    Boolean isSslPinningSuccess();

    Observable<Boolean> pinCertificateRemote();

    Observable<Boolean> pinCertificates();

    Observable<Boolean> pinHotUpdate();
}
