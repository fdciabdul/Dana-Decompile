package id.dana.domain.merchantmanagement.interactor;

import com.zoloz.android.phone.zdoc.service.ZdocRecordService;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.merchantmanagement.MerchantManagementRepository;
import id.dana.domain.merchantmanagement.model.LinkedMerchantInfo;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/merchantmanagement/interactor/GetLinkedMerchants;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/merchantmanagement/model/LinkedMerchantInfo;", "Lid/dana/domain/merchantmanagement/interactor/GetLinkedMerchants$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/merchantmanagement/interactor/GetLinkedMerchants$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/merchantmanagement/MerchantManagementRepository;", "merchantManagementRepository", "Lid/dana/domain/merchantmanagement/MerchantManagementRepository;", "<init>", "(Lid/dana/domain/merchantmanagement/MerchantManagementRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetLinkedMerchants extends BaseUseCase<LinkedMerchantInfo, Params> {
    private final MerchantManagementRepository merchantManagementRepository;

    @Inject
    public GetLinkedMerchants(MerchantManagementRepository merchantManagementRepository) {
        Intrinsics.checkNotNullParameter(merchantManagementRepository, "");
        this.merchantManagementRepository = merchantManagementRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<LinkedMerchantInfo> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.merchantManagementRepository.getLinkedMerchants(params.getPageNumber());
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0013J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\u0005\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0004\"\u0004\b\u0012\u0010\u0013"}, d2 = {"Lid/dana/domain/merchantmanagement/interactor/GetLinkedMerchants$Params;", "", "", "component1", "()I", ZdocRecordService.PAGE_NUMBER, "copy", "(I)Lid/dana/domain/merchantmanagement/interactor/GetLinkedMerchants$Params;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "I", "getPageNumber", "setPageNumber", "(I)V", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Params {
        private int pageNumber;

        public static /* synthetic */ Params copy$default(Params params, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = params.pageNumber;
            }
            return params.copy(i);
        }

        /* renamed from: component1  reason: from getter */
        public final int getPageNumber() {
            return this.pageNumber;
        }

        public final Params copy(int pageNumber) {
            return new Params(pageNumber);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Params) && this.pageNumber == ((Params) other).pageNumber;
        }

        public final int hashCode() {
            return this.pageNumber;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Params(pageNumber=");
            sb.append(this.pageNumber);
            sb.append(')');
            return sb.toString();
        }

        public Params(int i) {
            this.pageNumber = i;
        }

        @JvmName(name = "getPageNumber")
        public final int getPageNumber() {
            return this.pageNumber;
        }

        @JvmName(name = "setPageNumber")
        public final void setPageNumber(int i) {
            this.pageNumber = i;
        }
    }
}
