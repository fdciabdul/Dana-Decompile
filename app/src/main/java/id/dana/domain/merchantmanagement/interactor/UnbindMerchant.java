package id.dana.domain.merchantmanagement.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.merchantmanagement.MerchantManagementRepository;
import id.dana.domain.merchantmanagement.model.UnbindMerchantParam;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/merchantmanagement/interactor/UnbindMerchant;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/merchantmanagement/interactor/UnbindMerchant$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/merchantmanagement/interactor/UnbindMerchant$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/merchantmanagement/MerchantManagementRepository;", "merchantManagementRepository", "Lid/dana/domain/merchantmanagement/MerchantManagementRepository;", "<init>", "(Lid/dana/domain/merchantmanagement/MerchantManagementRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class UnbindMerchant extends BaseUseCase<Boolean, Params> {
    private final MerchantManagementRepository merchantManagementRepository;

    @Inject
    public UnbindMerchant(MerchantManagementRepository merchantManagementRepository) {
        Intrinsics.checkNotNullParameter(merchantManagementRepository, "");
        this.merchantManagementRepository = merchantManagementRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<Boolean> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.merchantManagementRepository.unbindMerchant(params.getUnbindMerchantParam());
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0005\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004"}, d2 = {"Lid/dana/domain/merchantmanagement/interactor/UnbindMerchant$Params;", "", "Lid/dana/domain/merchantmanagement/model/UnbindMerchantParam;", "component1", "()Lid/dana/domain/merchantmanagement/model/UnbindMerchantParam;", "unbindMerchantParam", "copy", "(Lid/dana/domain/merchantmanagement/model/UnbindMerchantParam;)Lid/dana/domain/merchantmanagement/interactor/UnbindMerchant$Params;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/domain/merchantmanagement/model/UnbindMerchantParam;", "getUnbindMerchantParam", "<init>", "(Lid/dana/domain/merchantmanagement/model/UnbindMerchantParam;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Params {
        private final UnbindMerchantParam unbindMerchantParam;

        public static /* synthetic */ Params copy$default(Params params, UnbindMerchantParam unbindMerchantParam, int i, Object obj) {
            if ((i & 1) != 0) {
                unbindMerchantParam = params.unbindMerchantParam;
            }
            return params.copy(unbindMerchantParam);
        }

        /* renamed from: component1  reason: from getter */
        public final UnbindMerchantParam getUnbindMerchantParam() {
            return this.unbindMerchantParam;
        }

        public final Params copy(UnbindMerchantParam unbindMerchantParam) {
            Intrinsics.checkNotNullParameter(unbindMerchantParam, "");
            return new Params(unbindMerchantParam);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Params) && Intrinsics.areEqual(this.unbindMerchantParam, ((Params) other).unbindMerchantParam);
        }

        public final int hashCode() {
            return this.unbindMerchantParam.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Params(unbindMerchantParam=");
            sb.append(this.unbindMerchantParam);
            sb.append(')');
            return sb.toString();
        }

        public Params(UnbindMerchantParam unbindMerchantParam) {
            Intrinsics.checkNotNullParameter(unbindMerchantParam, "");
            this.unbindMerchantParam = unbindMerchantParam;
        }

        @JvmName(name = "getUnbindMerchantParam")
        public final UnbindMerchantParam getUnbindMerchantParam() {
            return this.unbindMerchantParam;
        }
    }
}
