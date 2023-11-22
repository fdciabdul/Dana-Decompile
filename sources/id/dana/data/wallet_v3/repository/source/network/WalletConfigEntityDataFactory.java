package id.dana.data.wallet_v3.repository.source.network;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.wallet_v3.repository.source.local.LocalWalletConfigEntityData;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/data/wallet_v3/repository/source/network/WalletConfigEntityDataFactory;", "Lid/dana/data/AbstractEntityDataFactory;", "Lid/dana/data/wallet_v3/repository/source/network/WalletConfigEntityData;", "", "source", "Lid/dana/data/wallet_v3/repository/source/local/LocalWalletConfigEntityData;", "createData", "(Ljava/lang/String;)Lid/dana/data/wallet_v3/repository/source/local/LocalWalletConfigEntityData;", "localWalletConfigEntityData", "Lid/dana/data/wallet_v3/repository/source/local/LocalWalletConfigEntityData;", "<init>", "(Lid/dana/data/wallet_v3/repository/source/local/LocalWalletConfigEntityData;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class WalletConfigEntityDataFactory extends AbstractEntityDataFactory<WalletConfigEntityData> {
    private final LocalWalletConfigEntityData localWalletConfigEntityData;

    @Inject
    public WalletConfigEntityDataFactory(LocalWalletConfigEntityData localWalletConfigEntityData) {
        Intrinsics.checkNotNullParameter(localWalletConfigEntityData, "");
        this.localWalletConfigEntityData = localWalletConfigEntityData;
    }

    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData  reason: merged with bridge method [inline-methods] */
    public final WalletConfigEntityData createData2(String source) {
        Intrinsics.checkNotNullParameter(source, "");
        return this.localWalletConfigEntityData;
    }
}
