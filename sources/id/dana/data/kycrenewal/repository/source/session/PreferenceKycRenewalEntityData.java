package id.dana.data.kycrenewal.repository.source.session;

import id.dana.data.kycrenewal.repository.source.KycRenewalPreferenceEntityData;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/data/kycrenewal/repository/source/session/PreferenceKycRenewalEntityData;", "Lid/dana/data/kycrenewal/repository/source/KycRenewalPreferenceEntityData;", "Lid/dana/data/kycrenewal/repository/source/session/KycRenewalPreference;", "getAuthRequestContext", "Lid/dana/data/kycrenewal/repository/source/session/KycRenewalPreference;", "MyBillsEntityDataFactory", "p0", "<init>", "(Lid/dana/data/kycrenewal/repository/source/session/KycRenewalPreference;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PreferenceKycRenewalEntityData implements KycRenewalPreferenceEntityData {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final KycRenewalPreference MyBillsEntityDataFactory;

    @Inject
    public PreferenceKycRenewalEntityData(KycRenewalPreference kycRenewalPreference) {
        Intrinsics.checkNotNullParameter(kycRenewalPreference, "");
        this.MyBillsEntityDataFactory = kycRenewalPreference;
    }
}
