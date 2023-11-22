package id.dana.domain.sendmoney.interactor;

import com.alibaba.ariver.engine.common.track.watchdog.ARiverTrackWatchDogEventConstant;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.sendmoney.repository.SendMoneyRepository;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/sendmoney/interactor/SaveStateSuspiciousAccountSmartFriction;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/sendmoney/interactor/SaveStateSuspiciousAccountSmartFriction$Param;", "param", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/sendmoney/interactor/SaveStateSuspiciousAccountSmartFriction$Param;)Lio/reactivex/Observable;", "Lid/dana/domain/sendmoney/repository/SendMoneyRepository;", "sendMoneyRepository", "Lid/dana/domain/sendmoney/repository/SendMoneyRepository;", "<init>", "(Lid/dana/domain/sendmoney/repository/SendMoneyRepository;)V", "Param"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SaveStateSuspiciousAccountSmartFriction extends BaseUseCase<Boolean, Param> {
    private final SendMoneyRepository sendMoneyRepository;

    @Inject
    public SaveStateSuspiciousAccountSmartFriction(SendMoneyRepository sendMoneyRepository) {
        Intrinsics.checkNotNullParameter(sendMoneyRepository, "");
        this.sendMoneyRepository = sendMoneyRepository;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0003\u001a\u00020\u00028\u0001X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/domain/sendmoney/interactor/SaveStateSuspiciousAccountSmartFriction$Param;", "", "", "isShow", "Z", "isShow$domain_productionRelease", "()Z", "<init>", "(Z)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Param {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean isShow;

        public /* synthetic */ Param(boolean z, DefaultConstructorMarker defaultConstructorMarker) {
            this(z);
        }

        @JvmStatic
        public static final Param create(boolean z) {
            return INSTANCE.create(z);
        }

        private Param(boolean z) {
            this.isShow = z;
        }

        @JvmName(name = "isShow$domain_productionRelease")
        /* renamed from: isShow$domain_productionRelease  reason: from getter */
        public final boolean getIsShow() {
            return this.isShow;
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/domain/sendmoney/interactor/SaveStateSuspiciousAccountSmartFriction$Param$Companion;", "", "", "isShow", "Lid/dana/domain/sendmoney/interactor/SaveStateSuspiciousAccountSmartFriction$Param;", ARiverTrackWatchDogEventConstant.FLAG_START_UP_CREATE, "(Z)Lid/dana/domain/sendmoney/interactor/SaveStateSuspiciousAccountSmartFriction$Param;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Param create(boolean isShow) {
                return new Param(isShow, null);
            }
        }
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<Boolean> buildUseCase(Param param) {
        Intrinsics.checkNotNullParameter(param, "");
        Observable<Boolean> saveStateSuspiciousAccountSmartFriction = this.sendMoneyRepository.saveStateSuspiciousAccountSmartFriction(param.getIsShow());
        Intrinsics.checkNotNullExpressionValue(saveStateSuspiciousAccountSmartFriction, "");
        return saveStateSuspiciousAccountSmartFriction;
    }
}
