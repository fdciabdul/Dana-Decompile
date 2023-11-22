package id.dana.data.globalnetwork.source;

import id.dana.data.globalnetwork.model.UniPaymentEntityResult;
import io.reactivex.Observable;
import java.util.List;

/* loaded from: classes4.dex */
public interface UniPaymentEntityData {
    Observable<UniPaymentEntityResult> getUniPaymentResult(List<String> list, String str, String str2);
}
