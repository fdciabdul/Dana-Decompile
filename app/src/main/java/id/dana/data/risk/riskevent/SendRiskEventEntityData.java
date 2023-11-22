package id.dana.data.risk.riskevent;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import io.reactivex.Observable;

/* loaded from: classes2.dex */
public interface SendRiskEventEntityData {
    Observable<BaseRpcResult> sendRiskEvent(String str, String str2);

    Observable<Object> sendRiskEvent(String str, String str2, String str3);
}
