package id.dana.domain.saving.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.saving.SavingRepository;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/saving/interactor/TopUpSaving;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/saving/interactor/TopUpSaving$Param;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/saving/interactor/TopUpSaving$Param;)Lio/reactivex/Observable;", "Lid/dana/domain/saving/SavingRepository;", "savingRepository", "Lid/dana/domain/saving/SavingRepository;", "<init>", "(Lid/dana/domain/saving/SavingRepository;)V", "Param"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TopUpSaving extends BaseUseCase<String, Param> {
    private final SavingRepository savingRepository;

    @Inject
    public TopUpSaving(SavingRepository savingRepository) {
        Intrinsics.checkNotNullParameter(savingRepository, "");
        this.savingRepository = savingRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<String> buildUseCase(Param params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.savingRepository.topUpSaving(params.getSavingId(), params.getFundAmount());
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006"}, d2 = {"Lid/dana/domain/saving/interactor/TopUpSaving$Param;", "", "", "fundAmount", "Ljava/lang/String;", "getFundAmount", "()Ljava/lang/String;", "savingId", "getSavingId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Param {
        private final String fundAmount;
        private final String savingId;

        public Param(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            this.savingId = str;
            this.fundAmount = str2;
        }

        @JvmName(name = "getSavingId")
        public final String getSavingId() {
            return this.savingId;
        }

        @JvmName(name = "getFundAmount")
        public final String getFundAmount() {
            return this.fundAmount;
        }
    }
}
