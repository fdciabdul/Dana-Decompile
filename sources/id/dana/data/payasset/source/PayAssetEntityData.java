package id.dana.data.payasset.source;

import id.dana.data.payasset.source.network.result.ChangePayMethodResult;
import id.dana.data.payasset.source.network.result.QueryPayMethodResult;
import io.reactivex.Observable;

/* loaded from: classes2.dex */
public interface PayAssetEntityData {
    Observable<ChangePayMethodResult> changePayMethod(String str, String str2, String str3);

    Observable<QueryPayMethodResult> queryPayMethod(String str, String str2);
}
