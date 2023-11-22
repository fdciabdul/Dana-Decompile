package id.dana.domain.qriscrossborder.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.globalnetwork.GlobalNetworkRepository;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/qriscrossborder/interactor/SendRiskEventWithParams;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/qriscrossborder/interactor/SendRiskEventWithParams$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/qriscrossborder/interactor/SendRiskEventWithParams$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/globalnetwork/GlobalNetworkRepository;", "globalNetworkRepository", "Lid/dana/domain/globalnetwork/GlobalNetworkRepository;", "<init>", "(Lid/dana/domain/globalnetwork/GlobalNetworkRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SendRiskEventWithParams extends BaseUseCase<Boolean, Params> {
    private final GlobalNetworkRepository globalNetworkRepository;

    @Inject
    public SendRiskEventWithParams(GlobalNetworkRepository globalNetworkRepository) {
        Intrinsics.checkNotNullParameter(globalNetworkRepository, "");
        this.globalNetworkRepository = globalNetworkRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<Boolean> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable<Boolean> sendRiskEvent = this.globalNetworkRepository.sendRiskEvent(params.getOriginCountry(), params.getCurrentCountry());
        Intrinsics.checkNotNullExpressionValue(sendRiskEvent, "");
        return sendRiskEvent;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0019\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006"}, d2 = {"Lid/dana/domain/qriscrossborder/interactor/SendRiskEventWithParams$Params;", "", "", "currentCountry", "Ljava/lang/String;", "getCurrentCountry", "()Ljava/lang/String;", "originCountry", "getOriginCountry", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String currentCountry;
        private final String originCountry;

        public /* synthetic */ Params(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2);
        }

        private Params(String str, String str2) {
            this.originCountry = str;
            this.currentCountry = str2;
        }

        @JvmName(name = "getCurrentCountry")
        public final String getCurrentCountry() {
            return this.currentCountry;
        }

        @JvmName(name = "getOriginCountry")
        public final String getOriginCountry() {
            return this.originCountry;
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/domain/qriscrossborder/interactor/SendRiskEventWithParams$Params$Companion;", "", "", "originCountry", "currentCountry", "Lid/dana/domain/qriscrossborder/interactor/SendRiskEventWithParams$Params;", "forSendRiskEventWithParams", "(Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/qriscrossborder/interactor/SendRiskEventWithParams$Params;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Params forSendRiskEventWithParams(String originCountry, String currentCountry) {
                Intrinsics.checkNotNullParameter(originCountry, "");
                Intrinsics.checkNotNullParameter(currentCountry, "");
                return new Params(originCountry, currentCountry, null);
            }
        }
    }
}
