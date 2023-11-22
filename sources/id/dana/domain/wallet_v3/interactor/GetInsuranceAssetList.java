package id.dana.domain.wallet_v3.interactor;

import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.pocket.model.AssetStatus;
import id.dana.domain.pocket.model.PocketQueryList;
import id.dana.domain.wallet_v3.model.InsuranceAsset;
import id.dana.domain.wallet_v3.repository.PersonalTabRepository;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001:\u0001\u000eB\u0011\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/domain/wallet_v3/interactor/GetInsuranceAssetList;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/pocket/model/PocketQueryList;", "Lid/dana/domain/wallet_v3/model/InsuranceAsset;", "Lid/dana/domain/wallet_v3/interactor/GetInsuranceAssetList$Param;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/wallet_v3/interactor/GetInsuranceAssetList$Param;)Lio/reactivex/Observable;", "Lid/dana/domain/wallet_v3/repository/PersonalTabRepository;", "personalTabRepository", "Lid/dana/domain/wallet_v3/repository/PersonalTabRepository;", "<init>", "(Lid/dana/domain/wallet_v3/repository/PersonalTabRepository;)V", "Param"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetInsuranceAssetList extends BaseUseCase<PocketQueryList<InsuranceAsset>, Param> {
    private final PersonalTabRepository personalTabRepository;

    @Inject
    public GetInsuranceAssetList(PersonalTabRepository personalTabRepository) {
        Intrinsics.checkNotNullParameter(personalTabRepository, "");
        this.personalTabRepository = personalTabRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<PocketQueryList<InsuranceAsset>> buildUseCase(Param params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.personalTabRepository.getInsuranceAssets(params.getPageNum(), params.getPageSize(), params.getStatuses$domain_productionRelease());
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0003\u001a\u00020\u00028\u0001X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R(\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0001@\u0001X\u0081\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/domain/wallet_v3/interactor/GetInsuranceAssetList$Param;", "", "", "pageNum", "I", "getPageNum$domain_productionRelease", "()I", SecurityConstants.KEY_PAGE_SIZE, "getPageSize$domain_productionRelease", "", "Lid/dana/domain/pocket/model/AssetStatus;", "statuses", "Ljava/util/List;", "getStatuses$domain_productionRelease", "()Ljava/util/List;", "setStatuses$domain_productionRelease", "(Ljava/util/List;)V", "<init>", "(IILjava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Param {
        private final int pageNum;
        private final int pageSize;
        private List<? extends AssetStatus> statuses;

        public Param(int i, int i2, List<? extends AssetStatus> list) {
            Intrinsics.checkNotNullParameter(list, "");
            this.pageNum = i;
            this.pageSize = i2;
            this.statuses = list;
        }

        @JvmName(name = "getPageNum$domain_productionRelease")
        /* renamed from: getPageNum$domain_productionRelease  reason: from getter */
        public final int getPageNum() {
            return this.pageNum;
        }

        @JvmName(name = "getPageSize$domain_productionRelease")
        /* renamed from: getPageSize$domain_productionRelease  reason: from getter */
        public final int getPageSize() {
            return this.pageSize;
        }

        public /* synthetic */ Param(int i, int i2, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, i2, (i3 & 4) != 0 ? CollectionsKt.listOf((Object[]) new AssetStatus[]{AssetStatus.INIT, AssetStatus.ACTIVE}) : list);
        }

        @JvmName(name = "getStatuses$domain_productionRelease")
        public final List<AssetStatus> getStatuses$domain_productionRelease() {
            return this.statuses;
        }

        @JvmName(name = "setStatuses$domain_productionRelease")
        public final void setStatuses$domain_productionRelease(List<? extends AssetStatus> list) {
            Intrinsics.checkNotNullParameter(list, "");
            this.statuses = list;
        }
    }
}
