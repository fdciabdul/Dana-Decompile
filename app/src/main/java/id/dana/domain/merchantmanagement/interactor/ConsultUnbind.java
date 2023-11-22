package id.dana.domain.merchantmanagement.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.merchantmanagement.MerchantManagementRepository;
import id.dana.domain.merchantmanagement.model.UnbindConsultInfo;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/merchantmanagement/interactor/ConsultUnbind;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/merchantmanagement/model/UnbindConsultInfo;", "Lid/dana/domain/merchantmanagement/interactor/ConsultUnbind$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/merchantmanagement/interactor/ConsultUnbind$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/merchantmanagement/MerchantManagementRepository;", "merchantManagementRepository", "Lid/dana/domain/merchantmanagement/MerchantManagementRepository;", "<init>", "(Lid/dana/domain/merchantmanagement/MerchantManagementRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ConsultUnbind extends BaseUseCase<UnbindConsultInfo, Params> {
    private final MerchantManagementRepository merchantManagementRepository;

    @Inject
    public ConsultUnbind(MerchantManagementRepository merchantManagementRepository) {
        Intrinsics.checkNotNullParameter(merchantManagementRepository, "");
        this.merchantManagementRepository = merchantManagementRepository;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J0\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004R\"\u0010\u0007\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004\"\u0004\b\u0016\u0010\u0017R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0018\u0010\u0004\"\u0004\b\u0019\u0010\u0017R\"\u0010\b\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u001a\u0010\u0004\"\u0004\b\u001b\u0010\u0017"}, d2 = {"Lid/dana/domain/merchantmanagement/interactor/ConsultUnbind$Params;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "clientId", "merchantId", "divisionId", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/merchantmanagement/interactor/ConsultUnbind$Params;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getClientId", "setClientId", "(Ljava/lang/String;)V", "getDivisionId", "setDivisionId", "getMerchantId", "setMerchantId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Params {
        private String clientId;
        private String divisionId;
        private String merchantId;

        public static /* synthetic */ Params copy$default(Params params, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = params.clientId;
            }
            if ((i & 2) != 0) {
                str2 = params.merchantId;
            }
            if ((i & 4) != 0) {
                str3 = params.divisionId;
            }
            return params.copy(str, str2, str3);
        }

        /* renamed from: component1  reason: from getter */
        public final String getClientId() {
            return this.clientId;
        }

        /* renamed from: component2  reason: from getter */
        public final String getMerchantId() {
            return this.merchantId;
        }

        /* renamed from: component3  reason: from getter */
        public final String getDivisionId() {
            return this.divisionId;
        }

        public final Params copy(String clientId, String merchantId, String divisionId) {
            Intrinsics.checkNotNullParameter(clientId, "");
            Intrinsics.checkNotNullParameter(merchantId, "");
            return new Params(clientId, merchantId, divisionId);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Params) {
                Params params = (Params) other;
                return Intrinsics.areEqual(this.clientId, params.clientId) && Intrinsics.areEqual(this.merchantId, params.merchantId) && Intrinsics.areEqual(this.divisionId, params.divisionId);
            }
            return false;
        }

        public final int hashCode() {
            int hashCode = this.clientId.hashCode();
            int hashCode2 = this.merchantId.hashCode();
            String str = this.divisionId;
            return (((hashCode * 31) + hashCode2) * 31) + (str == null ? 0 : str.hashCode());
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Params(clientId=");
            sb.append(this.clientId);
            sb.append(", merchantId=");
            sb.append(this.merchantId);
            sb.append(", divisionId=");
            sb.append(this.divisionId);
            sb.append(')');
            return sb.toString();
        }

        public Params(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            this.clientId = str;
            this.merchantId = str2;
            this.divisionId = str3;
        }

        public /* synthetic */ Params(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i & 4) != 0 ? null : str3);
        }

        @JvmName(name = "getClientId")
        public final String getClientId() {
            return this.clientId;
        }

        @JvmName(name = "setClientId")
        public final void setClientId(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.clientId = str;
        }

        @JvmName(name = "getMerchantId")
        public final String getMerchantId() {
            return this.merchantId;
        }

        @JvmName(name = "setMerchantId")
        public final void setMerchantId(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.merchantId = str;
        }

        @JvmName(name = "getDivisionId")
        public final String getDivisionId() {
            return this.divisionId;
        }

        @JvmName(name = "setDivisionId")
        public final void setDivisionId(String str) {
            this.divisionId = str;
        }
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<UnbindConsultInfo> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.merchantManagementRepository.unbindConsult(params.getClientId(), params.getMerchantId(), params.getDivisionId());
    }
}
