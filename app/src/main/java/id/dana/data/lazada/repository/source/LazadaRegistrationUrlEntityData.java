package id.dana.data.lazada.repository.source;

import id.dana.data.lazada.repository.source.network.response.LazadaRegistrationUrlResult;
import io.reactivex.Observable;

/* loaded from: classes2.dex */
public interface LazadaRegistrationUrlEntityData {
    Observable<LazadaRegistrationUrlResult> getLazadaRegistrationUrl(String str, String str2);
}
