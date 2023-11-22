package id.dana.data.sslpinning.source;

import io.reactivex.Observable;
import java.util.List;

/* loaded from: classes2.dex */
public interface SslPinningEntityData {
    Observable<Boolean> addAndPersistRemoteCertificates(int i, List<String> list);

    Observable<Boolean> closeSslPinning();

    Boolean isSslPinningSuccess();
}
