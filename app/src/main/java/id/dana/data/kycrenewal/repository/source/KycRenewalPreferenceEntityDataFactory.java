package id.dana.data.kycrenewal.repository.source;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.kycrenewal.repository.source.session.KycRenewalPreference;
import id.dana.data.kycrenewal.repository.source.session.PreferenceKycRenewalEntityData;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/data/kycrenewal/repository/source/KycRenewalPreferenceEntityDataFactory;", "Lid/dana/data/AbstractEntityDataFactory;", "Lid/dana/data/kycrenewal/repository/source/session/PreferenceKycRenewalEntityData;", "Lid/dana/data/kycrenewal/repository/source/session/KycRenewalPreference;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/data/kycrenewal/repository/source/session/KycRenewalPreference;", "p0", "<init>", "(Lid/dana/data/kycrenewal/repository/source/session/KycRenewalPreference;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class KycRenewalPreferenceEntityDataFactory extends AbstractEntityDataFactory<PreferenceKycRenewalEntityData> {
    public final KycRenewalPreference KClassImpl$Data$declaredNonStaticMembers$2;

    @Inject
    public KycRenewalPreferenceEntityDataFactory(KycRenewalPreference kycRenewalPreference) {
        Intrinsics.checkNotNullParameter(kycRenewalPreference, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = kycRenewalPreference;
    }

    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public final /* synthetic */ PreferenceKycRenewalEntityData createData2(String str) {
        return new PreferenceKycRenewalEntityData(this.KClassImpl$Data$declaredNonStaticMembers$2);
    }
}
