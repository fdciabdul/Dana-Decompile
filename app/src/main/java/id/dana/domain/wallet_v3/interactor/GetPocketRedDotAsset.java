package id.dana.domain.wallet_v3.interactor;

import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.pocket.model.AssetStatus;
import id.dana.domain.wallet_v3.model.UserPocketAssetListModel;
import id.dana.domain.wallet_v3.model.UserPocketAssetModel;
import id.dana.domain.wallet_v3.repository.WalletV3Repository;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001:\u0001\u000eB\u0011\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/domain/wallet_v3/interactor/GetPocketRedDotAsset;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/wallet_v3/model/UserPocketAssetListModel;", "Lid/dana/domain/wallet_v3/model/UserPocketAssetModel;", "Lid/dana/domain/wallet_v3/interactor/GetPocketRedDotAsset$Param;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/wallet_v3/interactor/GetPocketRedDotAsset$Param;)Lio/reactivex/Observable;", "Lid/dana/domain/wallet_v3/repository/WalletV3Repository;", "walletV3Repository", "Lid/dana/domain/wallet_v3/repository/WalletV3Repository;", "<init>", "(Lid/dana/domain/wallet_v3/repository/WalletV3Repository;)V", "Param"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetPocketRedDotAsset extends BaseUseCase<UserPocketAssetListModel<UserPocketAssetModel>, Param> {
    private final WalletV3Repository walletV3Repository;

    @Inject
    public GetPocketRedDotAsset(WalletV3Repository walletV3Repository) {
        Intrinsics.checkNotNullParameter(walletV3Repository, "");
        this.walletV3Repository = walletV3Repository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<UserPocketAssetListModel<UserPocketAssetModel>> buildUseCase(Param params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.walletV3Repository.getPocketRedDotAsset(params.getPageNum(), params.getPageSize(), params.getStatuses(), params.getAssetTypes());
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0002\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0015\u0010\u0016R(\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u000b\u001a\u00020\n8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\n8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000eR(\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0007\"\u0004\b\u0014\u0010\t"}, d2 = {"Lid/dana/domain/wallet_v3/interactor/GetPocketRedDotAsset$Param;", "", "", "", "assetTypes", "Ljava/util/List;", "getAssetTypes", "()Ljava/util/List;", "setAssetTypes", "(Ljava/util/List;)V", "", "pageNum", "I", "getPageNum", "()I", SecurityConstants.KEY_PAGE_SIZE, "getPageSize", "Lid/dana/domain/pocket/model/AssetStatus;", "statuses", "getStatuses", "setStatuses", "<init>", "(IILjava/util/List;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Param {
        private List<String> assetTypes;
        private final int pageNum;
        private final int pageSize;
        private List<? extends AssetStatus> statuses;

        public Param(int i, int i2, List<? extends AssetStatus> list, List<String> list2) {
            Intrinsics.checkNotNullParameter(list, "");
            Intrinsics.checkNotNullParameter(list2, "");
            this.pageNum = i;
            this.pageSize = i2;
            this.statuses = list;
            this.assetTypes = list2;
        }

        @JvmName(name = "getPageNum")
        public final int getPageNum() {
            return this.pageNum;
        }

        @JvmName(name = "getPageSize")
        public final int getPageSize() {
            return this.pageSize;
        }

        public /* synthetic */ Param(int i, int i2, List list, List list2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? 1 : i, (i3 & 2) != 0 ? 10 : i2, (i3 & 4) != 0 ? CollectionsKt.listOf((Object[]) new AssetStatus[]{AssetStatus.INIT, AssetStatus.INACTIVE, AssetStatus.EXPIRING}) : list, list2);
        }

        @JvmName(name = "getStatuses")
        public final List<AssetStatus> getStatuses() {
            return this.statuses;
        }

        @JvmName(name = "setStatuses")
        public final void setStatuses(List<? extends AssetStatus> list) {
            Intrinsics.checkNotNullParameter(list, "");
            this.statuses = list;
        }

        @JvmName(name = "getAssetTypes")
        public final List<String> getAssetTypes() {
            return this.assetTypes;
        }

        @JvmName(name = "setAssetTypes")
        public final void setAssetTypes(List<String> list) {
            Intrinsics.checkNotNullParameter(list, "");
            this.assetTypes = list;
        }
    }
}
