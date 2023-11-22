package id.dana.domain.maintenance.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.maintenance.model.BroadcastSavingStateResult;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/maintenance/interactor/SaveLastDismissedBroadcast;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/maintenance/model/BroadcastSavingStateResult;", "Lid/dana/domain/maintenance/interactor/SaveLastDismissedBroadcast$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/maintenance/interactor/SaveLastDismissedBroadcast$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/featureconfig/FeatureConfigRepository;", "featureConfigRepository", "Lid/dana/domain/featureconfig/FeatureConfigRepository;", "<init>", "(Lid/dana/domain/featureconfig/FeatureConfigRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class SaveLastDismissedBroadcast extends BaseUseCase<BroadcastSavingStateResult, Params> {
    private final FeatureConfigRepository featureConfigRepository;

    @Inject
    public SaveLastDismissedBroadcast(FeatureConfigRepository featureConfigRepository) {
        Intrinsics.checkNotNullParameter(featureConfigRepository, "");
        this.featureConfigRepository = featureConfigRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<BroadcastSavingStateResult> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        if (params.getForSavingPurpose()) {
            Observable<BroadcastSavingStateResult> broadcastSavingState = this.featureConfigRepository.setBroadcastSavingState(params.getMaintenanceBroadcastText());
            Intrinsics.checkNotNullExpressionValue(broadcastSavingState, "");
            return broadcastSavingState;
        }
        Observable<BroadcastSavingStateResult> broadcastSavingState2 = this.featureConfigRepository.getBroadcastSavingState(params.getMaintenanceBroadcastText());
        Intrinsics.checkNotNullExpressionValue(broadcastSavingState2, "");
        return broadcastSavingState2;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\r\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0004R\u0017\u0010\t\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\t\u0010\u0013\u001a\u0004\b\u0014\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004"}, d2 = {"Lid/dana/domain/maintenance/interactor/SaveLastDismissedBroadcast$Params;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Z", "maintenanceBroadcastText", "forSavingPurpose", "copy", "(Ljava/lang/String;Z)Lid/dana/domain/maintenance/interactor/SaveLastDismissedBroadcast$Params;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Z", "getForSavingPurpose", "Ljava/lang/String;", "getMaintenanceBroadcastText", "<init>", "(Ljava/lang/String;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final /* data */ class Params {
        private final boolean forSavingPurpose;
        private final String maintenanceBroadcastText;

        public static /* synthetic */ Params copy$default(Params params, String str, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = params.maintenanceBroadcastText;
            }
            if ((i & 2) != 0) {
                z = params.forSavingPurpose;
            }
            return params.copy(str, z);
        }

        /* renamed from: component1  reason: from getter */
        public final String getMaintenanceBroadcastText() {
            return this.maintenanceBroadcastText;
        }

        /* renamed from: component2  reason: from getter */
        public final boolean getForSavingPurpose() {
            return this.forSavingPurpose;
        }

        public final Params copy(String maintenanceBroadcastText, boolean forSavingPurpose) {
            return new Params(maintenanceBroadcastText, forSavingPurpose);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Params) {
                Params params = (Params) other;
                return Intrinsics.areEqual(this.maintenanceBroadcastText, params.maintenanceBroadcastText) && this.forSavingPurpose == params.forSavingPurpose;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final int hashCode() {
            String str = this.maintenanceBroadcastText;
            int hashCode = str == null ? 0 : str.hashCode();
            boolean z = this.forSavingPurpose;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            return (hashCode * 31) + i;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Params(maintenanceBroadcastText=");
            sb.append(this.maintenanceBroadcastText);
            sb.append(", forSavingPurpose=");
            sb.append(this.forSavingPurpose);
            sb.append(')');
            return sb.toString();
        }

        public Params(String str, boolean z) {
            this.maintenanceBroadcastText = str;
            this.forSavingPurpose = z;
        }

        public /* synthetic */ Params(String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str, z);
        }

        @JvmName(name = "getMaintenanceBroadcastText")
        public final String getMaintenanceBroadcastText() {
            return this.maintenanceBroadcastText;
        }

        @JvmName(name = "getForSavingPurpose")
        public final boolean getForSavingPurpose() {
            return this.forSavingPurpose;
        }
    }
}
