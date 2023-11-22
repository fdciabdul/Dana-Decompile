package id.dana.data.profilemenu.repository.source;

import id.dana.data.profilemenu.repository.source.network.result.PaymentSecurityInitResult;
import id.dana.network.response.profilemenu.PaymentSecuritySwitchResult;
import io.reactivex.Observable;

/* loaded from: classes2.dex */
public interface PaymentAuthenticationEntityData {
    Observable<PaymentSecurityInitResult> getPaymentSecurityInitResult();

    Observable<PaymentSecuritySwitchResult> getSecuritySwitchResult(boolean z, String str, String str2, String str3, String str4);
}
