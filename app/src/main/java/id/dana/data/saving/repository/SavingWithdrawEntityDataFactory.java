package id.dana.data.saving.repository;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.saving.repository.source.local.DefaultSavingWithdrawEntityData;
import id.dana.data.saving.repository.source.network.NetworkSavingWithdrawEntityData;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0005\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/data/saving/repository/SavingWithdrawEntityDataFactory;", "Lid/dana/data/AbstractEntityDataFactory;", "Lid/dana/data/saving/repository/SavingWithdrawEntityData;", "", "source", "createData", "(Ljava/lang/String;)Lid/dana/data/saving/repository/SavingWithdrawEntityData;", "Lid/dana/data/saving/repository/source/local/DefaultSavingWithdrawEntityData;", "defaultSavingWithdrawEntityData", "Lid/dana/data/saving/repository/source/local/DefaultSavingWithdrawEntityData;", "Lid/dana/data/saving/repository/source/network/NetworkSavingWithdrawEntityData;", "networkSavingWithdrawEntityData", "Lid/dana/data/saving/repository/source/network/NetworkSavingWithdrawEntityData;", "<init>", "(Lid/dana/data/saving/repository/source/network/NetworkSavingWithdrawEntityData;Lid/dana/data/saving/repository/source/local/DefaultSavingWithdrawEntityData;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SavingWithdrawEntityDataFactory extends AbstractEntityDataFactory<SavingWithdrawEntityData> {
    private final DefaultSavingWithdrawEntityData defaultSavingWithdrawEntityData;
    private final NetworkSavingWithdrawEntityData networkSavingWithdrawEntityData;

    @Inject
    public SavingWithdrawEntityDataFactory(NetworkSavingWithdrawEntityData networkSavingWithdrawEntityData, DefaultSavingWithdrawEntityData defaultSavingWithdrawEntityData) {
        Intrinsics.checkNotNullParameter(networkSavingWithdrawEntityData, "");
        Intrinsics.checkNotNullParameter(defaultSavingWithdrawEntityData, "");
        this.networkSavingWithdrawEntityData = networkSavingWithdrawEntityData;
        this.defaultSavingWithdrawEntityData = defaultSavingWithdrawEntityData;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public final SavingWithdrawEntityData createData2(String source) {
        return Intrinsics.areEqual(source, "network") ? this.networkSavingWithdrawEntityData : this.defaultSavingWithdrawEntityData;
    }
}
