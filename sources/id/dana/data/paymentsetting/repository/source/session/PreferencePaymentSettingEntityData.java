package id.dana.data.paymentsetting.repository.source.session;

import id.dana.data.paymentsetting.repository.source.PaymentSettingPreferenceEntityData;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/data/paymentsetting/repository/source/session/PreferencePaymentSettingEntityData;", "Lid/dana/data/paymentsetting/repository/source/PaymentSettingPreferenceEntityData;", "Lid/dana/data/paymentsetting/repository/source/session/PaymentSettingPreference;", "MyBillsEntityDataFactory", "Lid/dana/data/paymentsetting/repository/source/session/PaymentSettingPreference;", "getAuthRequestContext", "p0", "<init>", "(Lid/dana/data/paymentsetting/repository/source/session/PaymentSettingPreference;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PreferencePaymentSettingEntityData implements PaymentSettingPreferenceEntityData {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final PaymentSettingPreference getAuthRequestContext;

    @Inject
    public PreferencePaymentSettingEntityData(PaymentSettingPreference paymentSettingPreference) {
        Intrinsics.checkNotNullParameter(paymentSettingPreference, "");
        this.getAuthRequestContext = paymentSettingPreference;
    }
}
