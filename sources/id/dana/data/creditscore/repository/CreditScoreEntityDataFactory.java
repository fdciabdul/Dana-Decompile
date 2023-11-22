package id.dana.data.creditscore.repository;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.creditscore.repository.source.network.NetworkCreditScoreEntityData;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0006\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/data/creditscore/repository/CreditScoreEntityDataFactory;", "Lid/dana/data/AbstractEntityDataFactory;", "Lid/dana/data/creditscore/repository/CreditScoreEntityData;", "Lid/dana/data/creditscore/repository/source/network/NetworkCreditScoreEntityData;", "PlaceComponentResult", "Lid/dana/data/creditscore/repository/source/network/NetworkCreditScoreEntityData;", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "<init>", "(Lid/dana/data/creditscore/repository/source/network/NetworkCreditScoreEntityData;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CreditScoreEntityDataFactory extends AbstractEntityDataFactory<CreditScoreEntityData> {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    final NetworkCreditScoreEntityData KClassImpl$Data$declaredNonStaticMembers$2;

    @Inject
    public CreditScoreEntityDataFactory(NetworkCreditScoreEntityData networkCreditScoreEntityData) {
        Intrinsics.checkNotNullParameter(networkCreditScoreEntityData, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = networkCreditScoreEntityData;
    }

    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public final /* bridge */ /* synthetic */ CreditScoreEntityData createData2(String str) {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
