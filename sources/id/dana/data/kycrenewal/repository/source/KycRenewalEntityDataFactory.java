package id.dana.data.kycrenewal.repository.source;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.kycrenewal.repository.source.network.NetworkKycRenewalEntityData;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/data/kycrenewal/repository/source/KycRenewalEntityDataFactory;", "Lid/dana/data/AbstractEntityDataFactory;", "Lid/dana/data/kycrenewal/repository/source/KycRenewalEntityData;", "Lid/dana/data/kycrenewal/repository/source/network/NetworkKycRenewalEntityData;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/data/kycrenewal/repository/source/network/NetworkKycRenewalEntityData;", "p0", "<init>", "(Lid/dana/data/kycrenewal/repository/source/network/NetworkKycRenewalEntityData;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class KycRenewalEntityDataFactory extends AbstractEntityDataFactory<KycRenewalEntityData> {
    public final NetworkKycRenewalEntityData KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public final /* synthetic */ KycRenewalEntityData createData2(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Inject
    public KycRenewalEntityDataFactory(NetworkKycRenewalEntityData networkKycRenewalEntityData) {
        Intrinsics.checkNotNullParameter(networkKycRenewalEntityData, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = networkKycRenewalEntityData;
    }
}
