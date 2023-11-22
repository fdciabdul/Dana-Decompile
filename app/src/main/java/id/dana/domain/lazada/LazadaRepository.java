package id.dana.domain.lazada;

import io.reactivex.Observable;

/* loaded from: classes2.dex */
public interface LazadaRepository {
    Observable<LazadaRegistrationUrl> getLazadaRegistrationUrl(String str, String str2);

    Observable<Boolean> isClickedAgree();

    Observable<Boolean> saveClickedAgree();
}
