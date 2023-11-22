package id.dana.cashier.domain.interactor;

import id.dana.cashier.domain.CashierRepository;
import id.dana.cashier.domain.model.CashierAgreementRequest;
import id.dana.cashier.domain.model.CashierAgreementResponse;
import id.dana.cashier.utils.CashierKeyParams;
import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.domain.core.usecase.BaseUseCase;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \r2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\r\u000eB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/cashier/domain/interactor/CreateCashierAgreement;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/cashier/domain/model/CashierAgreementResponse;", "Lid/dana/cashier/domain/interactor/CreateCashierAgreement$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/cashier/domain/interactor/CreateCashierAgreement$Params;)Lio/reactivex/Observable;", "Lid/dana/cashier/domain/CashierRepository;", "cashierRepository", "Lid/dana/cashier/domain/CashierRepository;", "<init>", "(Lid/dana/cashier/domain/CashierRepository;)V", "Companion", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CreateCashierAgreement extends BaseUseCase<CashierAgreementResponse, Params> {
    private static final String VERIFY_EXTEND_DATA = "CREATE_DIRECT_DEBIT_AGREEMENT";
    private static final String VERIFY_SCENE = "DIRECT_DEBIT_AGREEMENT";
    private final CashierRepository cashierRepository;

    @Inject
    public CreateCashierAgreement(CashierRepository cashierRepository) {
        Intrinsics.checkNotNullParameter(cashierRepository, "");
        this.cashierRepository = cashierRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<CashierAgreementResponse> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.cashierRepository.createCashierAgreement(new CashierAgreementRequest("", params.getValidateData(), params.getSendStrategy(), params.getPhoneNumber(), params.getCashierOrderId(), params.getVerifyExtendData(), params.getVerifyScene()));
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015BO\b\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006"}, d2 = {"Lid/dana/cashier/domain/interactor/CreateCashierAgreement$Params;", "", "", CashierKeyParams.CASHIER_ORDER_ID, "Ljava/lang/String;", "getCashierOrderId", "()Ljava/lang/String;", "phoneNumber", "getPhoneNumber", BioUtilityBridge.SECURITY_ID, "getSecurityId", "sendStrategy", "getSendStrategy", "validateData", "getValidateData", "verifyExtendData", "getVerifyExtendData", "verifyScene", "getVerifyScene", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String cashierOrderId;
        private final String phoneNumber;
        private final String securityId;
        private final String sendStrategy;
        private final String validateData;
        private final String verifyExtendData;
        private final String verifyScene;

        public /* synthetic */ Params(String str, String str2, String str3, String str4, String str5, String str6, String str7, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, str4, str5, str6, str7);
        }

        @JvmStatic
        public static final Params createSendBankOtpParam(String str, String str2, String str3) {
            return INSTANCE.createSendBankOtpParam(str, str2, str3);
        }

        private Params(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
            this.cashierOrderId = str;
            this.phoneNumber = str2;
            this.securityId = str3;
            this.sendStrategy = str4;
            this.validateData = str5;
            this.verifyExtendData = str6;
            this.verifyScene = str7;
        }

        @JvmName(name = "getCashierOrderId")
        public final String getCashierOrderId() {
            return this.cashierOrderId;
        }

        @JvmName(name = "getPhoneNumber")
        public final String getPhoneNumber() {
            return this.phoneNumber;
        }

        @JvmName(name = "getSecurityId")
        public final String getSecurityId() {
            return this.securityId;
        }

        @JvmName(name = "getSendStrategy")
        public final String getSendStrategy() {
            return this.sendStrategy;
        }

        @JvmName(name = "getValidateData")
        public final String getValidateData() {
            return this.validateData;
        }

        @JvmName(name = "getVerifyExtendData")
        public final String getVerifyExtendData() {
            return this.verifyExtendData;
        }

        @JvmName(name = "getVerifyScene")
        public final String getVerifyScene() {
            return this.verifyScene;
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ-\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/cashier/domain/interactor/CreateCashierAgreement$Params$Companion;", "", "", CashierKeyParams.CASHIER_ORDER_ID, "phoneNumber", "validateData", "Lid/dana/cashier/domain/interactor/CreateCashierAgreement$Params;", "createSendBankOtpParam", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/cashier/domain/interactor/CreateCashierAgreement$Params;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Params createSendBankOtpParam(String cashierOrderId, String phoneNumber, String validateData) {
                return new Params(cashierOrderId, phoneNumber, "", "AP_PAYMENT", validateData, CreateCashierAgreement.VERIFY_EXTEND_DATA, CreateCashierAgreement.VERIFY_SCENE, null);
            }
        }
    }
}
