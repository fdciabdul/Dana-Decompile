package id.dana.challenge.otp;

import com.alibaba.ariver.kernel.RVEvents;
import com.alipay.android.phone.mobilesdk.socketcraft.monitor.DataflowMonitorModel;
import id.dana.base.AbstractContractKt;
import id.dana.cashier.utils.CashierKeyParams;
import id.dana.challenge.otp.OtpState;
import id.dana.danah5.bioutility.BioUtilityBridge;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/challenge/otp/AbstractOtpContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface AbstractOtpContract {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0016J8\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0010\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0016J8\u0010\u0010\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0011\u001a\u00020\u0003H&J\b\u0010\u0012\u001a\u00020\u0003H&J\u0012\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H&J \u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\rH&J\b\u0010\u0019\u001a\u00020\u0003H&J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001cH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001dÀ\u0006\u0001"}, d2 = {"Lid/dana/challenge/otp/AbstractOtpContract$View;", "Lid/dana/base/AbstractContractKt$AbstractView;", "onAkamaiChallenged", "", "challengeContext", "", "otpChannel", "sendStrategy", "serviceCode", RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, "errorCode", "errorMessage", "leftTimes", "", "operationType", "traceId", "onErrorInputVerify", "onFreezeVerifyOtp", "onGetIsSyncPermission", "onOtpReceived", "otpCode", "onOtpSent", "expirySeconds", "retrySendSeconds", "otpCodeLength", "onSuccess", "setResendWhatsAppFeature", "enable", "", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface View extends AbstractContractKt.AbstractView {
        void BuiltInFictitiousFunctionClassFactory(String str);

        void BuiltInFictitiousFunctionClassFactory(String str, String str2, String str3, String str4);

        void KClassImpl$Data$declaredNonStaticMembers$2();

        void MyBillsEntityDataFactory();

        void MyBillsEntityDataFactory(int i, int i2);

        void PlaceComponentResult();

        void PlaceComponentResult(String str);

        void PlaceComponentResult(String str, String str2, String str3);

        void getAuthRequestContext();

        void getAuthRequestContext(String str, String str2, String str3, String str4);

        /* renamed from: id.dana.challenge.otp.AbstractOtpContract$View$-CC  reason: invalid class name */
        /* loaded from: classes4.dex */
        public final /* synthetic */ class CC {
            public static void BuiltInFictitiousFunctionClassFactory(View view, String str, String str2, String str3) {
                view.BuiltInFictitiousFunctionClassFactory(str, str2, null, str3);
            }

            public static void getAuthRequestContext(View view, String str) {
                view.onError(str);
            }
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0012\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH\u0016J4\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J@\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0017\u001a\u00020\u0006H&J4\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0017\u001a\u00020\u0006H&J\b\u0010\u0019\u001a\u00020\u0003H&J \u0010\u001a\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0016J\u0012\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u0006H&J0\u0010\u001c\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\u0012\u0010\u001d\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\b\u0010\u001e\u001a\u00020\u0003H\u0016J\b\u0010\u001f\u001a\u00020\u0003H\u0016J\b\u0010 \u001a\u00020\u0003H\u0016J\b\u0010!\u001a\u00020\u0003H\u0016J\b\u0010\"\u001a\u00020\u0003H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006#À\u0006\u0001"}, d2 = {"Lid/dana/challenge/otp/AbstractOtpContract$Presenter;", "Lid/dana/base/AbstractContractKt$AbstractPresenter;", "checkIsWhatsAppFeatureEnable", "", "firstInput", "otpPurpose", "", "getOtpNumberOfRequest", "", "getOtpState", "Lid/dana/challenge/otp/OtpState;", "initData", "phoneNumber", "otpChannel", "sendStrategy", "serviceCode", "isWhatsappOnly", "", "input", "otpInput", "loginType", BioUtilityBridge.SECURITY_ID, "sendOtpStrategy", CashierKeyParams.VERIFICATION_METHOD, "inputOtpRisk", "receiveOtp", "requestOtp", "saveIsFreezeVerifyOtp", DataflowMonitorModel.METHOD_NAME_SEND, "sendViaWhatsApp", "startTrackSMSOtpFlowDuration", "startTrackWhatsappOtpFlowDuration", "stopTrackOtpArrivalDuration", "stopTrackSMSOtpFlowDuration", "stopTrackWhatsappOtpFlowDuration", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface Presenter extends AbstractContractKt.AbstractPresenter {
        OtpState BuiltInFictitiousFunctionClassFactory();

        void BuiltInFictitiousFunctionClassFactory(String str);

        void BuiltInFictitiousFunctionClassFactory(String str, String str2, String str3, String str4, String str5, String str6);

        void KClassImpl$Data$declaredNonStaticMembers$2();

        void KClassImpl$Data$declaredNonStaticMembers$2(String str);

        void KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2, String str3, String str4, String str5);

        void KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2, String str3, String str4, boolean z);

        void MyBillsEntityDataFactory();

        void MyBillsEntityDataFactory(String str, String str2, String str3);

        void NetworkUserEntityData$$ExternalSyntheticLambda0();

        int PlaceComponentResult();

        void PlaceComponentResult(String str);

        void PlaceComponentResult(String str, String str2, String str3);

        void getAuthRequestContext();

        void lookAheadTest();

        void moveToNextValue();

        /* renamed from: id.dana.challenge.otp.AbstractOtpContract$Presenter$-CC  reason: invalid class name */
        /* loaded from: classes4.dex */
        public final /* synthetic */ class CC {
            public static void KClassImpl$Data$declaredNonStaticMembers$2() {
            }

            public static void MyBillsEntityDataFactory() {
            }

            public static void PlaceComponentResult() {
            }

            public static void PlaceComponentResult(String str, String str2) {
                Intrinsics.checkNotNullParameter(str, "");
                Intrinsics.checkNotNullParameter(str2, "");
            }

            public static void getAuthRequestContext() {
            }

            public static void getAuthRequestContext(String str, String str2, String str3) {
                Intrinsics.checkNotNullParameter(str, "");
                Intrinsics.checkNotNullParameter(str2, "");
                Intrinsics.checkNotNullParameter(str3, "");
            }

            public static OtpState BuiltInFictitiousFunctionClassFactory() {
                return OtpState.SMS1.INSTANCE;
            }
        }
    }
}
