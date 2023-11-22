package id.dana.data.wallet_v3.repository.source.local;

import id.dana.data.wallet_v3.repository.source.network.WalletConfigEntityData;
import id.dana.domain.wallet_v3.model.WalletConfig;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00022\u0006\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/data/wallet_v3/repository/source/local/LocalWalletConfigEntityData;", "Lid/dana/data/wallet_v3/repository/source/network/WalletConfigEntityData;", "Lio/reactivex/Observable;", "Lid/dana/domain/wallet_v3/model/WalletConfig;", "getWalletConfig", "()Lio/reactivex/Observable;", "walletConfig", "", "saveWalletConfig", "(Lid/dana/domain/wallet_v3/model/WalletConfig;)Lio/reactivex/Observable;", "Lid/dana/data/wallet_v3/repository/source/local/WalletConfigPreference;", "walletConfigPreference", "Lid/dana/data/wallet_v3/repository/source/local/WalletConfigPreference;", "<init>", "(Lid/dana/data/wallet_v3/repository/source/local/WalletConfigPreference;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LocalWalletConfigEntityData implements WalletConfigEntityData {
    private final WalletConfigPreference walletConfigPreference;

    @Inject
    public LocalWalletConfigEntityData(WalletConfigPreference walletConfigPreference) {
        Intrinsics.checkNotNullParameter(walletConfigPreference, "");
        this.walletConfigPreference = walletConfigPreference;
    }

    @Override // id.dana.data.wallet_v3.repository.source.network.WalletConfigEntityData
    public final Observable<Boolean> saveWalletConfig(WalletConfig walletConfig) {
        Intrinsics.checkNotNullParameter(walletConfig, "");
        Observable<Boolean> just = Observable.just(Boolean.valueOf(this.walletConfigPreference.saveWalletConfig(walletConfig)));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.wallet_v3.repository.source.network.WalletConfigEntityData
    public final Observable<WalletConfig> getWalletConfig() {
        WalletConfig walletConfig = this.walletConfigPreference.getWalletConfig();
        if (walletConfig != null) {
            Observable<WalletConfig> just = Observable.just(walletConfig);
            Intrinsics.checkNotNullExpressionValue(just, "");
            return just;
        }
        Observable<WalletConfig> error = Observable.error(new IllegalStateException("No config found on walletConfigPreference"));
        Intrinsics.checkNotNullExpressionValue(error, "");
        return error;
    }
}
