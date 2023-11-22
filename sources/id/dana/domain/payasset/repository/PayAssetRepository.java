package id.dana.domain.payasset.repository;

import id.dana.domain.payasset.model.ChangePayMethodResponse;
import id.dana.domain.payasset.model.QueryPayMethodResponse;
import io.reactivex.Observable;

/* loaded from: classes2.dex */
public interface PayAssetRepository {
    Observable<ChangePayMethodResponse> changePayMethod(String str, String str2, String str3);

    Observable<Boolean> getEnableAddNewCard();

    Observable<QueryPayMethodResponse> queryPayMethod(String str, String str2, boolean z);
}
