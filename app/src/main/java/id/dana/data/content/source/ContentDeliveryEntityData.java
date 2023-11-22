package id.dana.data.content.source;

import id.dana.data.content.source.network.result.SpaceRpcResult;
import io.reactivex.Observable;

/* loaded from: classes4.dex */
public interface ContentDeliveryEntityData {
    Observable<SpaceRpcResult> get(String str);
}
