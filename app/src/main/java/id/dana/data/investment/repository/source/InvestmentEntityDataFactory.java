package id.dana.data.investment.repository.source;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.investment.repository.source.network.NetworkInvestmentEntityData;
import id.dana.data.investment.repository.source.split.SplitInvestmentEntityData;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/data/investment/repository/source/InvestmentEntityDataFactory;", "Lid/dana/data/AbstractEntityDataFactory;", "Lid/dana/data/investment/repository/source/InvestmentEntityData;", "Lid/dana/data/investment/repository/source/network/NetworkInvestmentEntityData;", "MyBillsEntityDataFactory", "Lid/dana/data/investment/repository/source/network/NetworkInvestmentEntityData;", "Lid/dana/data/investment/repository/source/split/SplitInvestmentEntityData;", "PlaceComponentResult", "Lid/dana/data/investment/repository/source/split/SplitInvestmentEntityData;", "p0", "p1", "<init>", "(Lid/dana/data/investment/repository/source/network/NetworkInvestmentEntityData;Lid/dana/data/investment/repository/source/split/SplitInvestmentEntityData;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class InvestmentEntityDataFactory extends AbstractEntityDataFactory<InvestmentEntityData> {
    public final NetworkInvestmentEntityData MyBillsEntityDataFactory;
    public final SplitInvestmentEntityData PlaceComponentResult;

    @Inject
    public InvestmentEntityDataFactory(NetworkInvestmentEntityData networkInvestmentEntityData, SplitInvestmentEntityData splitInvestmentEntityData) {
        Intrinsics.checkNotNullParameter(networkInvestmentEntityData, "");
        Intrinsics.checkNotNullParameter(splitInvestmentEntityData, "");
        this.MyBillsEntityDataFactory = networkInvestmentEntityData;
        this.PlaceComponentResult = splitInvestmentEntityData;
    }

    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public final /* synthetic */ InvestmentEntityData createData2(String str) {
        return Intrinsics.areEqual(str, "split") ? this.PlaceComponentResult : this.MyBillsEntityDataFactory;
    }
}
