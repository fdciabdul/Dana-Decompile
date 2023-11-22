package id.dana.domain.usercredential.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.usercredential.CredentialRepository;
import id.dana.domain.usercredential.model.PinRegularChangesConfig;
import id.dana.domain.usercredential.model.QueryCredentialInfoModel;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/usercredential/interactor/GetPasswordLastModifiedWithConfigChecking;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/usercredential/model/QueryCredentialInfoModel;", "Lid/dana/domain/usercredential/interactor/GetPasswordLastModifiedWithConfigChecking$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/usercredential/interactor/GetPasswordLastModifiedWithConfigChecking$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/usercredential/CredentialRepository;", "credentialRepository", "Lid/dana/domain/usercredential/CredentialRepository;", "<init>", "(Lid/dana/domain/usercredential/CredentialRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetPasswordLastModifiedWithConfigChecking extends BaseUseCase<QueryCredentialInfoModel, Params> {
    private final CredentialRepository credentialRepository;

    @Inject
    public GetPasswordLastModifiedWithConfigChecking(CredentialRepository credentialRepository) {
        Intrinsics.checkNotNullParameter(credentialRepository, "");
        this.credentialRepository = credentialRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<QueryCredentialInfoModel> buildUseCase(final Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable flatMap = this.credentialRepository.getFeaturePinRegularChangesConfig(params.getShouldUpdateConfigFromSplit()).flatMap(new Function() { // from class: id.dana.domain.usercredential.interactor.GetPasswordLastModifiedWithConfigChecking$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2506buildUseCase$lambda0;
                m2506buildUseCase$lambda0 = GetPasswordLastModifiedWithConfigChecking.m2506buildUseCase$lambda0(GetPasswordLastModifiedWithConfigChecking.this, params, (PinRegularChangesConfig) obj);
                return m2506buildUseCase$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-0  reason: not valid java name */
    public static final ObservableSource m2506buildUseCase$lambda0(GetPasswordLastModifiedWithConfigChecking getPasswordLastModifiedWithConfigChecking, Params params, PinRegularChangesConfig pinRegularChangesConfig) {
        Observable<QueryCredentialInfoModel> error;
        Intrinsics.checkNotNullParameter(getPasswordLastModifiedWithConfigChecking, "");
        Intrinsics.checkNotNullParameter(params, "");
        Intrinsics.checkNotNullParameter(pinRegularChangesConfig, "");
        if (pinRegularChangesConfig.getEnable()) {
            error = getPasswordLastModifiedWithConfigChecking.credentialRepository.getPasswordLastModified(params.getShouldUpdatePasswordLastModifiedFromBackend(), pinRegularChangesConfig.getPinExpiredInDays());
        } else {
            error = Observable.error(new IllegalStateException("Feature Pin Regular Changes is disabled"));
            Intrinsics.checkNotNullExpressionValue(error, "");
        }
        return error;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u000b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0007\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u001a\u0010\u0006\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0015\u0010\u0004"}, d2 = {"Lid/dana/domain/usercredential/interactor/GetPasswordLastModifiedWithConfigChecking$Params;", "", "", "component1", "()Z", "component2", "shouldUpdatePasswordLastModifiedFromBackend", "shouldUpdateConfigFromSplit", "copy", "(ZZ)Lid/dana/domain/usercredential/interactor/GetPasswordLastModifiedWithConfigChecking$Params;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Z", "getShouldUpdateConfigFromSplit", "getShouldUpdatePasswordLastModifiedFromBackend", "<init>", "(ZZ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Params {
        private final boolean shouldUpdateConfigFromSplit;
        private final boolean shouldUpdatePasswordLastModifiedFromBackend;

        public static /* synthetic */ Params copy$default(Params params, boolean z, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                z = params.shouldUpdatePasswordLastModifiedFromBackend;
            }
            if ((i & 2) != 0) {
                z2 = params.shouldUpdateConfigFromSplit;
            }
            return params.copy(z, z2);
        }

        /* renamed from: component1  reason: from getter */
        public final boolean getShouldUpdatePasswordLastModifiedFromBackend() {
            return this.shouldUpdatePasswordLastModifiedFromBackend;
        }

        /* renamed from: component2  reason: from getter */
        public final boolean getShouldUpdateConfigFromSplit() {
            return this.shouldUpdateConfigFromSplit;
        }

        public final Params copy(boolean shouldUpdatePasswordLastModifiedFromBackend, boolean shouldUpdateConfigFromSplit) {
            return new Params(shouldUpdatePasswordLastModifiedFromBackend, shouldUpdateConfigFromSplit);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Params) {
                Params params = (Params) other;
                return this.shouldUpdatePasswordLastModifiedFromBackend == params.shouldUpdatePasswordLastModifiedFromBackend && this.shouldUpdateConfigFromSplit == params.shouldUpdateConfigFromSplit;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public final int hashCode() {
            boolean z = this.shouldUpdatePasswordLastModifiedFromBackend;
            ?? r0 = z;
            if (z) {
                r0 = 1;
            }
            boolean z2 = this.shouldUpdateConfigFromSplit;
            return (r0 * 31) + (z2 ? 1 : z2 ? 1 : 0);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Params(shouldUpdatePasswordLastModifiedFromBackend=");
            sb.append(this.shouldUpdatePasswordLastModifiedFromBackend);
            sb.append(", shouldUpdateConfigFromSplit=");
            sb.append(this.shouldUpdateConfigFromSplit);
            sb.append(')');
            return sb.toString();
        }

        public Params(boolean z, boolean z2) {
            this.shouldUpdatePasswordLastModifiedFromBackend = z;
            this.shouldUpdateConfigFromSplit = z2;
        }

        @JvmName(name = "getShouldUpdatePasswordLastModifiedFromBackend")
        public final boolean getShouldUpdatePasswordLastModifiedFromBackend() {
            return this.shouldUpdatePasswordLastModifiedFromBackend;
        }

        @JvmName(name = "getShouldUpdateConfigFromSplit")
        public final boolean getShouldUpdateConfigFromSplit() {
            return this.shouldUpdateConfigFromSplit;
        }
    }
}
