package id.dana.domain.merchantmanagement.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.merchantmanagement.MerchantManagementRepository;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/merchantmanagement/interactor/CheckUnbindEligibility;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/merchantmanagement/interactor/CheckUnbindEligibility$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/merchantmanagement/interactor/CheckUnbindEligibility$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/merchantmanagement/MerchantManagementRepository;", "merchantManagementRepository", "Lid/dana/domain/merchantmanagement/MerchantManagementRepository;", "<init>", "(Lid/dana/domain/merchantmanagement/MerchantManagementRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CheckUnbindEligibility extends BaseUseCase<String, Params> {
    private final MerchantManagementRepository merchantManagementRepository;

    @Inject
    public CheckUnbindEligibility(MerchantManagementRepository merchantManagementRepository) {
        Intrinsics.checkNotNullParameter(merchantManagementRepository, "");
        this.merchantManagementRepository = merchantManagementRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<String> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.merchantManagementRepository.checkUnbindEligibility(params.getClientId(), params.getMerchantId(), params.getDivisionId());
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0003\u001a\u00020\u00028\u0001X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006"}, d2 = {"Lid/dana/domain/merchantmanagement/interactor/CheckUnbindEligibility$Params;", "", "", "clientId", "Ljava/lang/String;", "getClientId$domain_productionRelease", "()Ljava/lang/String;", "divisionId", "getDivisionId$domain_productionRelease", "merchantId", "getMerchantId$domain_productionRelease", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {
        private final String clientId;
        private final String divisionId;
        private final String merchantId;

        public Params(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            this.clientId = str;
            this.merchantId = str2;
            this.divisionId = str3;
        }

        @JvmName(name = "getClientId$domain_productionRelease")
        /* renamed from: getClientId$domain_productionRelease  reason: from getter */
        public final String getClientId() {
            return this.clientId;
        }

        @JvmName(name = "getMerchantId$domain_productionRelease")
        /* renamed from: getMerchantId$domain_productionRelease  reason: from getter */
        public final String getMerchantId() {
            return this.merchantId;
        }

        @JvmName(name = "getDivisionId$domain_productionRelease")
        /* renamed from: getDivisionId$domain_productionRelease  reason: from getter */
        public final String getDivisionId() {
            return this.divisionId;
        }
    }
}
