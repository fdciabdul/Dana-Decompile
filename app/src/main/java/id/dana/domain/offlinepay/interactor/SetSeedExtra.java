package id.dana.domain.offlinepay.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.qrpay.QrPayRepository;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/offlinepay/interactor/SetSeedExtra;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/offlinepay/interactor/SetSeedExtra$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/offlinepay/interactor/SetSeedExtra$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/qrpay/QrPayRepository;", "paymentRepository", "Lid/dana/domain/qrpay/QrPayRepository;", "<init>", "(Lid/dana/domain/qrpay/QrPayRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SetSeedExtra extends BaseUseCase<Boolean, Params> {
    private final QrPayRepository paymentRepository;

    @Inject
    public SetSeedExtra(QrPayRepository qrPayRepository) {
        Intrinsics.checkNotNullParameter(qrPayRepository, "");
        this.paymentRepository = qrPayRepository;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/domain/offlinepay/interactor/SetSeedExtra$Params;", "", "", "seedExtra", "Ljava/lang/String;", "getSeedExtra", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String seedExtra;

        public /* synthetic */ Params(String str, DefaultConstructorMarker defaultConstructorMarker) {
            this(str);
        }

        @JvmStatic
        public static final Params forSeedExtra(String str) {
            return INSTANCE.forSeedExtra(str);
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/domain/offlinepay/interactor/SetSeedExtra$Params$Companion;", "", "", "seedExtra", "Lid/dana/domain/offlinepay/interactor/SetSeedExtra$Params;", "forSeedExtra", "(Ljava/lang/String;)Lid/dana/domain/offlinepay/interactor/SetSeedExtra$Params;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Params forSeedExtra(String seedExtra) {
                Intrinsics.checkNotNullParameter(seedExtra, "");
                return new Params(seedExtra, null);
            }
        }

        private Params(String str) {
            this.seedExtra = str;
        }

        @JvmName(name = "getSeedExtra")
        public final String getSeedExtra() {
            return this.seedExtra;
        }
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<Boolean> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable<Boolean> seedExtra = this.paymentRepository.setSeedExtra(params.getSeedExtra());
        Intrinsics.checkNotNullExpressionValue(seedExtra, "");
        return seedExtra;
    }
}
