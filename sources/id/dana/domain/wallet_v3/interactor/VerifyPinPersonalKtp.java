package id.dana.domain.wallet_v3.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.wallet_v3.model.VerifyPinKtpModel;
import id.dana.domain.wallet_v3.repository.PersonalTabRepository;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/wallet_v3/interactor/VerifyPinPersonalKtp;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/wallet_v3/model/VerifyPinKtpModel;", "Lid/dana/domain/wallet_v3/interactor/VerifyPinPersonalKtp$Param;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/wallet_v3/interactor/VerifyPinPersonalKtp$Param;)Lio/reactivex/Observable;", "Lid/dana/domain/wallet_v3/repository/PersonalTabRepository;", "personalTabRepository", "Lid/dana/domain/wallet_v3/repository/PersonalTabRepository;", "<init>", "(Lid/dana/domain/wallet_v3/repository/PersonalTabRepository;)V", "Param"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class VerifyPinPersonalKtp extends BaseUseCase<VerifyPinKtpModel, Param> {
    private final PersonalTabRepository personalTabRepository;

    @Inject
    public VerifyPinPersonalKtp(PersonalTabRepository personalTabRepository) {
        Intrinsics.checkNotNullParameter(personalTabRepository, "");
        this.personalTabRepository = personalTabRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<VerifyPinKtpModel> buildUseCase(Param params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.personalTabRepository.verifyPinPersonalKtp(params.getInputPin());
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0003\u001a\u00020\u00028\u0001X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/domain/wallet_v3/interactor/VerifyPinPersonalKtp$Param;", "", "", "inputPin", "Ljava/lang/String;", "getInputPin$domain_productionRelease", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Param {
        private final String inputPin;

        public Param(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.inputPin = str;
        }

        @JvmName(name = "getInputPin$domain_productionRelease")
        /* renamed from: getInputPin$domain_productionRelease  reason: from getter */
        public final String getInputPin() {
            return this.inputPin;
        }
    }
}
