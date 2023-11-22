package id.dana.domain.wallet_v3.interactor;

import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.pocket.model.AssetStatus;
import id.dana.domain.wallet_v3.repository.WalletV3Repository;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/wallet_v3/interactor/GetTotalUserPocketAsset;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/wallet_v3/interactor/GetTotalUserPocketAsset$Param;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/wallet_v3/interactor/GetTotalUserPocketAsset$Param;)Lio/reactivex/Observable;", "Lid/dana/domain/wallet_v3/repository/WalletV3Repository;", "walletV3Repository", "Lid/dana/domain/wallet_v3/repository/WalletV3Repository;", "<init>", "(Lid/dana/domain/wallet_v3/repository/WalletV3Repository;)V", "Param"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetTotalUserPocketAsset extends BaseUseCase<Integer, Param> {
    private final WalletV3Repository walletV3Repository;

    @Inject
    public GetTotalUserPocketAsset(WalletV3Repository walletV3Repository) {
        Intrinsics.checkNotNullParameter(walletV3Repository, "");
        this.walletV3Repository = walletV3Repository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<Integer> buildUseCase(Param params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.walletV3Repository.getTotalSavedPocketAssets(params.getPageNum(), params.getPageSize(), params.getStatuses(), params.getAssetTypes(), params.getCardTitle());
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0006\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b&\u0010'J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0006HÆ\u0003¢\u0006\u0004\b\u000b\u0010\tJ\u0012\u0010\f\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\f\u0010\rJP\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0004J\u0010\u0010\u001a\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u001a\u0010\rR(\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u00068\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u001b\u001a\u0004\b\u001c\u0010\t\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\n8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001f\u001a\u0004\b \u0010\rR\u001a\u0010\u000e\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010!\u001a\u0004\b\"\u0010\u0004R\u001a\u0010\u000f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010!\u001a\u0004\b#\u0010\u0004R(\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u001b\u001a\u0004\b$\u0010\t\"\u0004\b%\u0010\u001e"}, d2 = {"Lid/dana/domain/wallet_v3/interactor/GetTotalUserPocketAsset$Param;", "", "", "component1", "()I", "component2", "", "Lid/dana/domain/pocket/model/AssetStatus;", "component3", "()Ljava/util/List;", "", "component4", "component5", "()Ljava/lang/String;", "pageNum", SecurityConstants.KEY_PAGE_SIZE, "statuses", "assetTypes", "cardTitle", "copy", "(IILjava/util/List;Ljava/util/List;Ljava/lang/String;)Lid/dana/domain/wallet_v3/interactor/GetTotalUserPocketAsset$Param;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Ljava/util/List;", "getAssetTypes", "setAssetTypes", "(Ljava/util/List;)V", "Ljava/lang/String;", "getCardTitle", "I", "getPageNum", "getPageSize", "getStatuses", "setStatuses", "<init>", "(IILjava/util/List;Ljava/util/List;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Param {
        private List<String> assetTypes;
        private final String cardTitle;
        private final int pageNum;
        private final int pageSize;
        private List<? extends AssetStatus> statuses;

        public static /* synthetic */ Param copy$default(Param param, int i, int i2, List list, List list2, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = param.pageNum;
            }
            if ((i3 & 2) != 0) {
                i2 = param.pageSize;
            }
            int i4 = i2;
            List<? extends AssetStatus> list3 = list;
            if ((i3 & 4) != 0) {
                list3 = param.statuses;
            }
            List list4 = list3;
            List<String> list5 = list2;
            if ((i3 & 8) != 0) {
                list5 = param.assetTypes;
            }
            List list6 = list5;
            if ((i3 & 16) != 0) {
                str = param.cardTitle;
            }
            return param.copy(i, i4, list4, list6, str);
        }

        /* renamed from: component1  reason: from getter */
        public final int getPageNum() {
            return this.pageNum;
        }

        /* renamed from: component2  reason: from getter */
        public final int getPageSize() {
            return this.pageSize;
        }

        public final List<AssetStatus> component3() {
            return this.statuses;
        }

        public final List<String> component4() {
            return this.assetTypes;
        }

        /* renamed from: component5  reason: from getter */
        public final String getCardTitle() {
            return this.cardTitle;
        }

        public final Param copy(int pageNum, int pageSize, List<? extends AssetStatus> statuses, List<String> assetTypes, String cardTitle) {
            Intrinsics.checkNotNullParameter(statuses, "");
            Intrinsics.checkNotNullParameter(assetTypes, "");
            return new Param(pageNum, pageSize, statuses, assetTypes, cardTitle);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Param) {
                Param param = (Param) other;
                return this.pageNum == param.pageNum && this.pageSize == param.pageSize && Intrinsics.areEqual(this.statuses, param.statuses) && Intrinsics.areEqual(this.assetTypes, param.assetTypes) && Intrinsics.areEqual(this.cardTitle, param.cardTitle);
            }
            return false;
        }

        public final int hashCode() {
            int i = this.pageNum;
            int i2 = this.pageSize;
            int hashCode = this.statuses.hashCode();
            int hashCode2 = this.assetTypes.hashCode();
            String str = this.cardTitle;
            return (((((((i * 31) + i2) * 31) + hashCode) * 31) + hashCode2) * 31) + (str == null ? 0 : str.hashCode());
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Param(pageNum=");
            sb.append(this.pageNum);
            sb.append(", pageSize=");
            sb.append(this.pageSize);
            sb.append(", statuses=");
            sb.append(this.statuses);
            sb.append(", assetTypes=");
            sb.append(this.assetTypes);
            sb.append(", cardTitle=");
            sb.append(this.cardTitle);
            sb.append(')');
            return sb.toString();
        }

        public Param(int i, int i2, List<? extends AssetStatus> list, List<String> list2, String str) {
            Intrinsics.checkNotNullParameter(list, "");
            Intrinsics.checkNotNullParameter(list2, "");
            this.pageNum = i;
            this.pageSize = i2;
            this.statuses = list;
            this.assetTypes = list2;
            this.cardTitle = str;
        }

        public /* synthetic */ Param(int i, int i2, List list, List list2, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, i2, list, list2, (i3 & 16) != 0 ? null : str);
        }

        @JvmName(name = "getPageNum")
        public final int getPageNum() {
            return this.pageNum;
        }

        @JvmName(name = "getPageSize")
        public final int getPageSize() {
            return this.pageSize;
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

        @JvmName(name = "getCardTitle")
        public final String getCardTitle() {
            return this.cardTitle;
        }
    }
}
