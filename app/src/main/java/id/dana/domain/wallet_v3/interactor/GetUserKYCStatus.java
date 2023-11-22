package id.dana.domain.wallet_v3.interactor;

import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.wallet_v3.model.KycInfo;
import id.dana.domain.wallet_v3.repository.PersonalTabRepository;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/wallet_v3/interactor/GetUserKYCStatus;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/wallet_v3/model/KycInfo;", "Lid/dana/domain/wallet_v3/interactor/GetUserKYCStatus$Param;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/wallet_v3/interactor/GetUserKYCStatus$Param;)Lio/reactivex/Observable;", "Lid/dana/domain/wallet_v3/repository/PersonalTabRepository;", "personalTabRepository", "Lid/dana/domain/wallet_v3/repository/PersonalTabRepository;", "<init>", "(Lid/dana/domain/wallet_v3/repository/PersonalTabRepository;)V", "Param"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetUserKYCStatus extends BaseUseCase<KycInfo, Param> {
    private final PersonalTabRepository personalTabRepository;

    @Inject
    public GetUserKYCStatus(PersonalTabRepository personalTabRepository) {
        Intrinsics.checkNotNullParameter(personalTabRepository, "");
        this.personalTabRepository = personalTabRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<KycInfo> buildUseCase(Param params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.personalTabRepository.getUserKYCStatus(params.getPageNum(), params.getPageSize());
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u0003\u001a\u00020\u00028\u0001X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006"}, d2 = {"Lid/dana/domain/wallet_v3/interactor/GetUserKYCStatus$Param;", "", "", "pageNum", "I", "getPageNum$domain_productionRelease", "()I", SecurityConstants.KEY_PAGE_SIZE, "getPageSize$domain_productionRelease", "<init>", "(II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Param {
        private final int pageNum;
        private final int pageSize;

        public Param(int i, int i2) {
            this.pageNum = i;
            this.pageSize = i2;
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
    }
}
