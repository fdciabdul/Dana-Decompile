package id.dana.domain.resetpin.interactor;

import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.resetpin.ResetPinRepository;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/resetpin/interactor/SelfUnfreeze;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/resetpin/interactor/SelfUnfreeze$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/resetpin/interactor/SelfUnfreeze$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/resetpin/ResetPinRepository;", "resetPinRepository", "Lid/dana/domain/resetpin/ResetPinRepository;", "<init>", "(Lid/dana/domain/resetpin/ResetPinRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SelfUnfreeze extends BaseUseCase<Boolean, Params> {
    private final ResetPinRepository resetPinRepository;

    @Inject
    public SelfUnfreeze(ResetPinRepository resetPinRepository) {
        Intrinsics.checkNotNullParameter(resetPinRepository, "");
        this.resetPinRepository = resetPinRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<Boolean> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.resetPinRepository.selfUnfreeze(params.getSecurityId());
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/domain/resetpin/interactor/SelfUnfreeze$Params;", "", "", BioUtilityBridge.SECURITY_ID, "Ljava/lang/String;", "getSecurityId", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {
        private final String securityId;

        public Params(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.securityId = str;
        }

        @JvmName(name = "getSecurityId")
        public final String getSecurityId() {
            return this.securityId;
        }
    }
}
