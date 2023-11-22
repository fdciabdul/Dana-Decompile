package id.dana.data.wallet_v3.repository.source;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.wallet_v3.repository.WalletV3EntityData;
import id.dana.data.wallet_v3.repository.source.network.NetworkWalletV3EntityData;
import id.dana.data.wallet_v3.repository.source.persistence.PersistenceWalletV3EntityData;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/data/wallet_v3/repository/source/WalletV3EntityDataFactory;", "Lid/dana/data/AbstractEntityDataFactory;", "Lid/dana/data/wallet_v3/repository/WalletV3EntityData;", "", "source", "createData", "(Ljava/lang/String;)Lid/dana/data/wallet_v3/repository/WalletV3EntityData;", "Lid/dana/data/wallet_v3/repository/source/network/NetworkWalletV3EntityData;", "networkWalletV3EntityData", "Lid/dana/data/wallet_v3/repository/source/network/NetworkWalletV3EntityData;", "Lid/dana/data/wallet_v3/repository/source/persistence/PersistenceWalletV3EntityData;", "persistenceWalletV3EntityData", "Lid/dana/data/wallet_v3/repository/source/persistence/PersistenceWalletV3EntityData;", "<init>", "(Lid/dana/data/wallet_v3/repository/source/network/NetworkWalletV3EntityData;Lid/dana/data/wallet_v3/repository/source/persistence/PersistenceWalletV3EntityData;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class WalletV3EntityDataFactory extends AbstractEntityDataFactory<WalletV3EntityData> {
    private final NetworkWalletV3EntityData networkWalletV3EntityData;
    private final PersistenceWalletV3EntityData persistenceWalletV3EntityData;

    @Inject
    public WalletV3EntityDataFactory(NetworkWalletV3EntityData networkWalletV3EntityData, PersistenceWalletV3EntityData persistenceWalletV3EntityData) {
        Intrinsics.checkNotNullParameter(networkWalletV3EntityData, "");
        Intrinsics.checkNotNullParameter(persistenceWalletV3EntityData, "");
        this.networkWalletV3EntityData = networkWalletV3EntityData;
        this.persistenceWalletV3EntityData = persistenceWalletV3EntityData;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public final WalletV3EntityData createData2(String source) {
        Intrinsics.checkNotNullParameter(source, "");
        return Intrinsics.areEqual(source, "network") ? this.networkWalletV3EntityData : this.persistenceWalletV3EntityData;
    }
}
