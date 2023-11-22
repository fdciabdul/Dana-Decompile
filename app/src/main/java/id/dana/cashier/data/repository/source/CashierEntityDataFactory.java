package id.dana.cashier.data.repository.source;

import id.dana.cashier.data.repository.source.local.LocalCashierEntityData;
import id.dana.cashier.data.repository.source.network.NetworkCashierEntityData;
import id.dana.cashier.data.repository.source.split.SplitCashierEntityData;
import id.dana.data.AbstractEntityDataFactory;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/cashier/data/repository/source/CashierEntityDataFactory;", "Lid/dana/data/AbstractEntityDataFactory;", "Lid/dana/cashier/data/repository/source/CashierEntityData;", "", "source", "createData", "(Ljava/lang/String;)Lid/dana/cashier/data/repository/source/CashierEntityData;", "Lid/dana/cashier/data/repository/source/local/LocalCashierEntityData;", "localCashierEntityData", "Lid/dana/cashier/data/repository/source/local/LocalCashierEntityData;", "Lid/dana/cashier/data/repository/source/network/NetworkCashierEntityData;", "networkCashierEntityData", "Lid/dana/cashier/data/repository/source/network/NetworkCashierEntityData;", "Lid/dana/cashier/data/repository/source/split/SplitCashierEntityData;", "splitCashierEntityData", "Lid/dana/cashier/data/repository/source/split/SplitCashierEntityData;", "<init>", "(Lid/dana/cashier/data/repository/source/network/NetworkCashierEntityData;Lid/dana/cashier/data/repository/source/split/SplitCashierEntityData;Lid/dana/cashier/data/repository/source/local/LocalCashierEntityData;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CashierEntityDataFactory extends AbstractEntityDataFactory<CashierEntityData> {
    private final LocalCashierEntityData localCashierEntityData;
    private final NetworkCashierEntityData networkCashierEntityData;
    private final SplitCashierEntityData splitCashierEntityData;

    @Inject
    public CashierEntityDataFactory(NetworkCashierEntityData networkCashierEntityData, SplitCashierEntityData splitCashierEntityData, LocalCashierEntityData localCashierEntityData) {
        Intrinsics.checkNotNullParameter(networkCashierEntityData, "");
        Intrinsics.checkNotNullParameter(splitCashierEntityData, "");
        Intrinsics.checkNotNullParameter(localCashierEntityData, "");
        this.networkCashierEntityData = networkCashierEntityData;
        this.splitCashierEntityData = splitCashierEntityData;
        this.localCashierEntityData = localCashierEntityData;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public final CashierEntityData createData2(String source) {
        Intrinsics.checkNotNullParameter(source, "");
        return Intrinsics.areEqual(source, "network") ? this.networkCashierEntityData : Intrinsics.areEqual(source, "split") ? this.splitCashierEntityData : this.localCashierEntityData;
    }
}
