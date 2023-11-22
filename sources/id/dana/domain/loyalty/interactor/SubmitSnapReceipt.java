package id.dana.domain.loyalty.interactor;

import com.alibaba.ariver.engine.common.track.watchdog.ARiverTrackWatchDogEventConstant;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.loyalty.LoyaltyRepository;
import id.dana.domain.loyalty.model.Base64ReceiptLoyalty;
import id.dana.domain.loyalty.model.SubmitReceiptResult;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/loyalty/interactor/SubmitSnapReceipt;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/loyalty/model/SubmitReceiptResult;", "Lid/dana/domain/loyalty/interactor/SubmitSnapReceipt$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/loyalty/interactor/SubmitSnapReceipt$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/loyalty/LoyaltyRepository;", "loyaltyRepository", "Lid/dana/domain/loyalty/LoyaltyRepository;", "<init>", "(Lid/dana/domain/loyalty/LoyaltyRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class SubmitSnapReceipt extends BaseUseCase<SubmitReceiptResult, Params> {
    private final LoyaltyRepository loyaltyRepository;

    @Inject
    public SubmitSnapReceipt(LoyaltyRepository loyaltyRepository) {
        Intrinsics.checkNotNullParameter(loyaltyRepository, "");
        this.loyaltyRepository = loyaltyRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<SubmitReceiptResult> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.loyaltyRepository.submitReceipt(params.getBase64ReceiptLoyalty(), params.getToken());
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0003\u001a\u00020\u00028\u0001X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/domain/loyalty/interactor/SubmitSnapReceipt$Params;", "", "Lid/dana/domain/loyalty/model/Base64ReceiptLoyalty;", "base64ReceiptLoyalty", "Lid/dana/domain/loyalty/model/Base64ReceiptLoyalty;", "getBase64ReceiptLoyalty$domain_productionRelease", "()Lid/dana/domain/loyalty/model/Base64ReceiptLoyalty;", "", "token", "Ljava/lang/String;", "getToken$domain_productionRelease", "()Ljava/lang/String;", "<init>", "(Lid/dana/domain/loyalty/model/Base64ReceiptLoyalty;Ljava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class Params {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Base64ReceiptLoyalty base64ReceiptLoyalty;
        private final String token;

        public /* synthetic */ Params(Base64ReceiptLoyalty base64ReceiptLoyalty, String str, DefaultConstructorMarker defaultConstructorMarker) {
            this(base64ReceiptLoyalty, str);
        }

        @JvmStatic
        public static final Params create(Base64ReceiptLoyalty base64ReceiptLoyalty, String str) {
            return INSTANCE.create(base64ReceiptLoyalty, str);
        }

        private Params(Base64ReceiptLoyalty base64ReceiptLoyalty, String str) {
            this.base64ReceiptLoyalty = base64ReceiptLoyalty;
            this.token = str;
        }

        @JvmName(name = "getBase64ReceiptLoyalty$domain_productionRelease")
        /* renamed from: getBase64ReceiptLoyalty$domain_productionRelease  reason: from getter */
        public final Base64ReceiptLoyalty getBase64ReceiptLoyalty() {
            return this.base64ReceiptLoyalty;
        }

        @JvmName(name = "getToken$domain_productionRelease")
        /* renamed from: getToken$domain_productionRelease  reason: from getter */
        public final String getToken() {
            return this.token;
        }

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/domain/loyalty/interactor/SubmitSnapReceipt$Params$Companion;", "", "Lid/dana/domain/loyalty/model/Base64ReceiptLoyalty;", "base64ReceiptLoyalty", "", "token", "Lid/dana/domain/loyalty/interactor/SubmitSnapReceipt$Params;", ARiverTrackWatchDogEventConstant.FLAG_START_UP_CREATE, "(Lid/dana/domain/loyalty/model/Base64ReceiptLoyalty;Ljava/lang/String;)Lid/dana/domain/loyalty/interactor/SubmitSnapReceipt$Params;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes8.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Params create(Base64ReceiptLoyalty base64ReceiptLoyalty, String token) {
                Intrinsics.checkNotNullParameter(base64ReceiptLoyalty, "");
                Intrinsics.checkNotNullParameter(token, "");
                return new Params(base64ReceiptLoyalty, token, null);
            }
        }
    }
}
