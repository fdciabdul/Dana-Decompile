package id.dana.challenge;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.griver.image.photo.utils.DiskFormatter;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import com.iap.ac.android.container.constant.ContainerErrorCode;
import id.dana.base.BaseFragment;
import id.dana.cashier.model.CashierPayMethodModel;
import id.dana.cashier.model.SendBankOtpModel;
import id.dana.familyaccount.model.InviteMemberModel;
import id.dana.model.LoginAuthenticationMethod;
import id.dana.model.Trust2RiskLoginModel;
import id.dana.myprofile.model.PaymentSecuritySwitchModel;
import id.dana.riskChallenges.ui.passkey.launcher.enrollment.EnrollPasskeyLauncher;
import id.dana.sendmoney.summary.SummaryActivity;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 /2\u00020\u0001:\u000501/23B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020)¢\u0006\u0004\b-\u0010.J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\bJ\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\f\u0010\bJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\bJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000e\u0010\bJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\bJ\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0010\u0010\bJ\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0011\u0010\bJ\u0017\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0012\u0010\bJ\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0013\u0010\bJ\u0017\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0014\u0010\bJ\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0015\u0010\bJ\r\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u0016J'\u0010\t\u001a\u00020\u001b2\u0006\u0010\u0003\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\t\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001d\u0010\u0005J\u0017\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001e\u0010\u0005J\u0017\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001f\u0010\u0005J\u0017\u0010 \u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b \u0010\u0005J\u0017\u0010!\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b!\u0010\u0005J\u0017\u0010\"\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\"\u0010\u0005J\u0017\u0010#\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b#\u0010\u0005J\u0017\u0010$\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b$\u0010\u0005J\u0017\u0010%\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b%\u0010\u0005J\u0017\u0010&\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b&\u0010\u0005J\u0017\u0010'\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b'\u0010\bJ\u0017\u0010(\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b(\u0010\bR\u0014\u0010\n\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010*R\u0014\u0010\u000b\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010,"}, d2 = {"Lid/dana/challenge/ChallengeControl;", "", "Landroid/os/Bundle;", "p0", "BuiltInFictitiousFunctionClassFactory", "(Landroid/os/Bundle;)Landroid/os/Bundle;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/os/Bundle;)V", "MyBillsEntityDataFactory", "getAuthRequestContext", "PlaceComponentResult", "NetworkUserEntityData$$ExternalSyntheticLambda0", "getErrorConfigVersion", "scheduleImpl", "lookAheadTest", "moveToNextValue", "NetworkUserEntityData$$ExternalSyntheticLambda1", "DatabaseTableConfigUtil", "NetworkUserEntityData$$ExternalSyntheticLambda2", "GetContactSyncConfig", "initRecordTimeStamp", "()V", "", "p1", "Landroid/content/Intent;", "p2", "", "(IILandroid/content/Intent;)Z", "newProxyInstance", "NetworkUserEntityData$$ExternalSyntheticLambda8", "PrepareContext", "NetworkUserEntityData$$ExternalSyntheticLambda7", "isLayoutRequested", "NetworkUserEntityData$$ExternalSyntheticLambda4", "NetworkUserEntityData$$ExternalSyntheticLambda5", "NetworkUserEntityData$$ExternalSyntheticLambda6", "NetworkUserEntityData$$ExternalSyntheticLambda3", "FragmentBottomSheetPaymentSettingBinding", "whenAvailable", "getCallingPid", "Lid/dana/challenge/ChallengeControl$Builder;", "Lid/dana/challenge/ChallengeControl$Builder;", "Lid/dana/challenge/ChallengeControlFacade;", "Lid/dana/challenge/ChallengeControlFacade;", "<init>", "(Lid/dana/challenge/ChallengeControl$Builder;)V", "Companion", "Builder", "CancelReason", "Key", "Listener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ChallengeControl {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final ChallengeControlFacade PlaceComponentResult;
    private final Builder getAuthRequestContext;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J-\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\n\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\n\u0010\u000bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/challenge/ChallengeControl$Listener;", "", "", "p0", "p1", "Landroid/os/Bundle;", "p2", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V", "getAuthRequestContext", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public interface Listener {
        void BuiltInFictitiousFunctionClassFactory(String p0, String p1, Bundle p2);

        void getAuthRequestContext();
    }

    public /* synthetic */ ChallengeControl(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private ChallengeControl(Builder builder) {
        this.getAuthRequestContext = builder;
        this.PlaceComponentResult = builder.NetworkUserEntityData$$ExternalSyntheticLambda1;
    }

    public final void getAuthRequestContext() {
        Bundle bundle = new Bundle();
        bundle.putString(Key.SCENARIO, this.getAuthRequestContext.scheduleImpl);
        if (!TextUtils.isEmpty(this.getAuthRequestContext.getSupportButtonTintMode)) {
            bundle.putString(Key.PHONE_NUMBER, this.getAuthRequestContext.getSupportButtonTintMode);
        }
        if (this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda2 > 0 || this.getAuthRequestContext.B > 0 || this.getAuthRequestContext.readMicros > 0) {
            bundle.putInt(Key.EXPIRY_SECONDS, this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda2);
            bundle.putInt(Key.RETRY_SEND_SECONDS, this.getAuthRequestContext.B);
            bundle.putInt(Key.OTP_CODE_LENGTH, this.getAuthRequestContext.readMicros);
            bundle.putString(Key.OTP_CHANNEL, this.getAuthRequestContext.getCallingPid);
            bundle.putBoolean(Key.IS_ERROR_RESEND, this.getAuthRequestContext.getNetworkUserEntityData$$ExternalSyntheticLambda7());
        }
        bundle.putString(Key.REGISTRATION_SOURCE, this.getAuthRequestContext.VerifyPinStateManager$executeRiskChallenge$2$1);
        bundle.putBoolean(Key.HELP_BUTTON_CHATBOT_FEATURE, this.getAuthRequestContext.getNetworkUserEntityData$$ExternalSyntheticLambda0());
        bundle.putBoolean(Key.FROZEN_ACCOUNT_CHATBOT_FEATURE, this.getAuthRequestContext.getNewProxyInstance());
        bundle.putString(Key.HELP_BUTTON_URL, this.getAuthRequestContext.isLayoutRequested);
        bundle.putBoolean(Key.IS_FREEZE_VERIFY_OTP, this.getAuthRequestContext.getNetworkUserEntityData$$ExternalSyntheticLambda4());
        String str = this.getAuthRequestContext.scheduleImpl;
        if (str != null) {
            switch (str.hashCode()) {
                case -2047416274:
                    if (str.equals(ChallengeScenario.WALLET_PERSONAL_KTP)) {
                        lookAheadTest(bundle);
                        return;
                    }
                    return;
                case -1999183539:
                    if (str.equals(ChallengeScenario.REGISTRATION)) {
                        bundle.putString(Key.SECURITY_ID, this.getAuthRequestContext.E);
                        bundle.putString(Key.OTP_PURPOSE, this.getAuthRequestContext.SubSequence);
                        moveToNextValue(bundle);
                        return;
                    }
                    return;
                case -978524326:
                    if (str.equals(ChallengeScenario.REMOVE_FAMILY_MEMBER)) {
                        FragmentBottomSheetPaymentSettingBinding(bundle);
                        NetworkUserEntityData$$ExternalSyntheticLambda2(bundle);
                        return;
                    }
                    return;
                case -786182429:
                    if (str.equals(ChallengeScenario.JOIN_INVITATION_FAMILY_ACCOUNT)) {
                        NetworkUserEntityData$$ExternalSyntheticLambda3(bundle);
                        getErrorConfigVersion(bundle);
                        return;
                    }
                    return;
                case -781220926:
                    if (str.equals(ChallengeScenario.CARD_BINDING_OTP)) {
                        newProxyInstance(bundle);
                        MyBillsEntityDataFactory(bundle);
                        return;
                    }
                    return;
                case -781220308:
                    if (str.equals("card_binding_pin")) {
                        NetworkUserEntityData$$ExternalSyntheticLambda8(bundle);
                        getAuthRequestContext(bundle);
                        return;
                    }
                    return;
                case -497502143:
                    if (str.equals("payment_auth")) {
                        isLayoutRequested(bundle);
                        NetworkUserEntityData$$ExternalSyntheticLambda1(bundle);
                        return;
                    }
                    return;
                case -489325167:
                    if (str.equals("unbind_merchant")) {
                        BuiltInFictitiousFunctionClassFactory(bundle);
                        getCallingPid(bundle);
                        return;
                    }
                    return;
                case -41045063:
                    if (str.equals("auto_route")) {
                        PrepareContext(bundle);
                        KClassImpl$Data$declaredNonStaticMembers$2(bundle);
                        return;
                    }
                    return;
                case 103149417:
                    if (str.equals("login")) {
                        bundle.putBoolean(Key.WITH_MOBILE_DATA, this.getAuthRequestContext.getI());
                        scheduleImpl(bundle);
                        return;
                    }
                    return;
                case 539748434:
                    if (str.equals("family_account")) {
                        NetworkUserEntityData$$ExternalSyntheticLambda6(bundle);
                        NetworkUserEntityData$$ExternalSyntheticLambda0(bundle);
                        return;
                    }
                    return;
                case 703631723:
                    if (str.equals(ChallengeScenario.TRUST_RISK_LOGIN_TWILIO)) {
                        scheduleImpl(bundle);
                        return;
                    }
                    return;
                case 1124674296:
                    if (!str.equals("twilio_otp")) {
                        return;
                    }
                    bundle.putString(Key.SECURITY_ID, this.getAuthRequestContext.E);
                    initRecordTimeStamp(bundle);
                    return;
                case 1124674914:
                    if (!str.equals("twilio_pin")) {
                        return;
                    }
                    bundle.putString(Key.SECURITY_ID, this.getAuthRequestContext.E);
                    initRecordTimeStamp(bundle);
                    return;
                case 1319662811:
                    if (str.equals(ChallengeScenario.TRUST_RISK_LOGIN_V2)) {
                        NetworkUserEntityData$$ExternalSyntheticLambda5(bundle);
                        GetContactSyncConfig(bundle);
                        return;
                    }
                    return;
                case 1573803584:
                    if (str.equals(ChallengeScenario.TRUST_RISK_LOGIN)) {
                        NetworkUserEntityData$$ExternalSyntheticLambda4(bundle);
                        GetContactSyncConfig(bundle);
                        return;
                    }
                    return;
                case 1656771640:
                    if (str.equals("face_activation")) {
                        NetworkUserEntityData$$ExternalSyntheticLambda7(bundle);
                        PlaceComponentResult(bundle);
                        return;
                    }
                    return;
                case 1667024159:
                    if (!str.equals(ChallengeScenario.AUTH_AGREEMENT_OTP)) {
                        return;
                    }
                    bundle.putString(Key.SECURITY_ID, this.getAuthRequestContext.E);
                    whenAvailable(bundle);
                    return;
                case 1667024777:
                    if (!str.equals(ChallengeScenario.AUTH_AGREEMENT_PIN)) {
                        return;
                    }
                    bundle.putString(Key.SECURITY_ID, this.getAuthRequestContext.E);
                    whenAvailable(bundle);
                    return;
                case 1899283821:
                    if (str.equals(ChallengeScenario.REMOVE_FAMILY_ACCOUNT)) {
                        bundle.putString(Key.PUB_KEY, this.getAuthRequestContext.BottomSheetCardBindingView$watcherCardNumberView$1);
                        bundle.putString(Key.SECURITY_ID, this.getAuthRequestContext.E);
                        DatabaseTableConfigUtil(bundle);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private final Bundle NetworkUserEntityData$$ExternalSyntheticLambda6(Bundle p0) {
        p0.putString(Key.PUB_KEY, this.getAuthRequestContext.BottomSheetCardBindingView$watcherCardNumberView$1);
        p0.putString(Key.SECURITY_ID, this.getAuthRequestContext.E);
        p0.putString(Key.PHONE_NUMBER, this.getAuthRequestContext.getSupportButtonTintMode);
        p0.putString("address", this.getAuthRequestContext.MyBillsEntityDataFactory);
        p0.putString(Key.RELATION, this.getAuthRequestContext.A);
        return p0;
    }

    private final Bundle NetworkUserEntityData$$ExternalSyntheticLambda3(Bundle p0) {
        p0.putString(Key.PUB_KEY, this.getAuthRequestContext.BottomSheetCardBindingView$watcherCardNumberView$1);
        p0.putString(Key.SECURITY_ID, this.getAuthRequestContext.E);
        p0.putString("invitation_id", this.getAuthRequestContext.PrepareContext);
        return p0;
    }

    private final Bundle FragmentBottomSheetPaymentSettingBinding(Bundle p0) {
        p0.putString(Key.PUB_KEY, this.getAuthRequestContext.BottomSheetCardBindingView$watcherCardNumberView$1);
        p0.putString(Key.SECURITY_ID, this.getAuthRequestContext.E);
        p0.putString("invitation_id", this.getAuthRequestContext.PrepareContext);
        return p0;
    }

    private final Bundle newProxyInstance(Bundle p0) {
        p0.putString(Key.VERIFICATION_METHOD, this.getAuthRequestContext.H);
        p0.putParcelable(Key.BANK_OTP_MODEL, this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2);
        p0.putBoolean(Key.IS_RISK_PHASE_2, this.getAuthRequestContext.getFragmentBottomSheetPaymentSettingBinding());
        p0.putBoolean(Key.IS_BINDING_DIRECT_DEBIT, this.getAuthRequestContext.getNetworkUserEntityData$$ExternalSyntheticLambda8());
        p0.putParcelable(Key.PAY_METHOD_MODEL, this.getAuthRequestContext.whenAvailable);
        return p0;
    }

    private final Bundle NetworkUserEntityData$$ExternalSyntheticLambda8(Bundle p0) {
        p0.putString(Key.VERIFICATION_METHOD, this.getAuthRequestContext.H);
        p0.putBoolean(Key.IS_RISK_PHASE_2, this.getAuthRequestContext.getFragmentBottomSheetPaymentSettingBinding());
        p0.putString(Key.CASHIER_ORDER_ID, this.getAuthRequestContext.lookAheadTest);
        p0.putParcelable(Key.PAY_METHOD_MODEL, this.getAuthRequestContext.whenAvailable);
        p0.putString(Key.PIN_PUB_KEY, this.getAuthRequestContext.C);
        return p0;
    }

    private final Bundle isLayoutRequested(Bundle p0) {
        p0.putString(Key.PUB_KEY, this.getAuthRequestContext.BottomSheetCardBindingView$watcherCardNumberView$1);
        p0.putString(Key.SECURITY_ID, this.getAuthRequestContext.E);
        p0.putString(Key.AUTH_TYPE, this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory);
        p0.putBoolean(Key.AUTH_STATUS, this.getAuthRequestContext.getPlaceComponentResult());
        return p0;
    }

    private final Bundle NetworkUserEntityData$$ExternalSyntheticLambda7(Bundle p0) {
        p0.putString(Key.SECURITY_ID, this.getAuthRequestContext.E);
        p0.putString(Key.PUB_KEY, this.getAuthRequestContext.BottomSheetCardBindingView$watcherCardNumberView$1);
        p0.putBoolean(Key.FACE_AUTH_NEW, this.getAuthRequestContext.getInitRecordTimeStamp());
        return p0;
    }

    private final Bundle PrepareContext(Bundle p0) {
        p0.putString(Key.PUB_KEY, this.getAuthRequestContext.BottomSheetCardBindingView$watcherCardNumberView$1);
        p0.putString(Key.SECURITY_ID, this.getAuthRequestContext.E);
        p0.putBoolean(Key.AUTO_ROUTE_STATUS, this.getAuthRequestContext.getGetAuthRequestContext());
        return p0;
    }

    private final Bundle NetworkUserEntityData$$ExternalSyntheticLambda5(Bundle p0) {
        p0.putString(Key.SECURITY_ID, this.getAuthRequestContext.E);
        p0.putBoolean(Key.FACE_ONLY_LOGIN, this.getAuthRequestContext.getGetContactSyncConfig());
        p0.putBoolean(Key.FACE_LOGIN_ENROLLED, this.getAuthRequestContext.getDatabaseTableConfigUtil());
        p0.putBoolean(Key.KYC_FLAG, this.getAuthRequestContext.getNetworkUserEntityData$$ExternalSyntheticLambda6());
        p0.putBoolean(Key.RISK_FLAG, this.getAuthRequestContext.getD());
        p0.putBoolean(Key.WITH_MOBILE_DATA, this.getAuthRequestContext.getI());
        p0.putParcelable(Key.TRUST_2_RISK_LOGIN_MODEL, this.getAuthRequestContext.getValueOfTouchPositionAbsolute);
        Trust2RiskLoginModel trust2RiskLoginModel = this.getAuthRequestContext.getValueOfTouchPositionAbsolute;
        boolean z = false;
        if (trust2RiskLoginModel != null ? trust2RiskLoginModel.BuiltInFictitiousFunctionClassFactory() : false) {
            EnrollPasskeyLauncher.Companion companion = EnrollPasskeyLauncher.INSTANCE;
            if (EnrollPasskeyLauncher.Companion.PlaceComponentResult()) {
                z = true;
            }
        }
        p0.putBoolean(Key.PASSKEY_ELIGIBILITY, z);
        return p0;
    }

    private final Bundle NetworkUserEntityData$$ExternalSyntheticLambda4(Bundle p0) {
        p0.putString(Key.SECURITY_ID, this.getAuthRequestContext.E);
        p0.putBoolean(Key.FACE_ONLY_LOGIN, this.getAuthRequestContext.getGetContactSyncConfig());
        p0.putBoolean(Key.FACE_LOGIN_ENROLLED, this.getAuthRequestContext.getDatabaseTableConfigUtil());
        p0.putBoolean(Key.KYC_FLAG, this.getAuthRequestContext.getNetworkUserEntityData$$ExternalSyntheticLambda6());
        p0.putBoolean(Key.RISK_FLAG, this.getAuthRequestContext.getD());
        p0.putBoolean(Key.WITH_MOBILE_DATA, this.getAuthRequestContext.getI());
        return p0;
    }

    private final Bundle BuiltInFictitiousFunctionClassFactory(Bundle p0) {
        p0.putString(Key.SECURITY_ID, this.getAuthRequestContext.E);
        p0.putString(Key.PUB_KEY, this.getAuthRequestContext.BottomSheetCardBindingView$watcherCardNumberView$1);
        p0.putString(Key.MERCHANT_ID, this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda3);
        p0.putString(Key.CLIENT_ID, this.getAuthRequestContext.moveToNextValue);
        p0.putString(Key.DIVISION_ID, this.getAuthRequestContext.getErrorConfigVersion);
        p0.putString(Key.UNBIND_ELIGIBILITY_CHECK_ID, this.getAuthRequestContext.getOnBoardingScenario);
        p0.putString(Key.USER_BOUND_ID, this.getAuthRequestContext.VerifyPinStateManager$executeRiskChallenge$2$2);
        return p0;
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda1(Bundle p0) {
        Intent PlaceComponentResult = this.PlaceComponentResult.PlaceComponentResult(ChallengeActivity.class);
        PlaceComponentResult.putExtras(p0);
        PlaceComponentResult.setFlags(67108864);
        this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult, 1001);
    }

    private final void initRecordTimeStamp(Bundle p0) {
        Intent PlaceComponentResult = this.PlaceComponentResult.PlaceComponentResult(ChallengeActivity.class);
        PlaceComponentResult.putExtras(p0);
        PlaceComponentResult.setFlags(67108864);
        this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult, 1005);
    }

    private final void moveToNextValue(Bundle p0) {
        Intent PlaceComponentResult = this.PlaceComponentResult.PlaceComponentResult(ChallengeActivity.class);
        PlaceComponentResult.putExtras(p0);
        PlaceComponentResult.setFlags(67108864);
        this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult, 1000);
    }

    private final void PlaceComponentResult(Bundle p0) {
        Intent PlaceComponentResult = this.PlaceComponentResult.PlaceComponentResult(ChallengeActivity.class);
        PlaceComponentResult.putExtras(p0);
        PlaceComponentResult.setFlags(67108864);
        this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult, 1002);
    }

    private final void scheduleImpl(Bundle p0) {
        Intent PlaceComponentResult = this.PlaceComponentResult.PlaceComponentResult(ChallengePinWithFaceActivity.class);
        PlaceComponentResult.putExtras(p0);
        PlaceComponentResult.setFlags(67108864);
        this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult, 998);
    }

    private final void GetContactSyncConfig(Bundle p0) {
        Intent PlaceComponentResult = this.PlaceComponentResult.PlaceComponentResult(ChallengePinWithFaceActivity.class);
        PlaceComponentResult.putExtras(p0);
        PlaceComponentResult.setFlags(67108864);
        this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult, 999);
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(Bundle p0) {
        Intent PlaceComponentResult = this.PlaceComponentResult.PlaceComponentResult(ChallengeActivity.class);
        PlaceComponentResult.putExtras(p0);
        PlaceComponentResult.setFlags(67108864);
        this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult, 1006);
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda0(Bundle p0) {
        Intent PlaceComponentResult = this.PlaceComponentResult.PlaceComponentResult(ChallengeActivity.class);
        PlaceComponentResult.putExtras(p0);
        PlaceComponentResult.setFlags(67108864);
        this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult, 1008);
    }

    private final void DatabaseTableConfigUtil(Bundle p0) {
        Intent PlaceComponentResult = this.PlaceComponentResult.PlaceComponentResult(ChallengeActivity.class);
        PlaceComponentResult.putExtras(p0);
        PlaceComponentResult.setFlags(67108864);
        this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult, 1009);
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda2(Bundle p0) {
        Intent PlaceComponentResult = this.PlaceComponentResult.PlaceComponentResult(ChallengeActivity.class);
        PlaceComponentResult.putExtras(p0);
        PlaceComponentResult.setFlags(67108864);
        this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult, 1010);
    }

    private final void getErrorConfigVersion(Bundle p0) {
        Intent PlaceComponentResult = this.PlaceComponentResult.PlaceComponentResult(ChallengeActivity.class);
        PlaceComponentResult.putExtras(p0);
        PlaceComponentResult.setFlags(67108864);
        this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult, 1011);
    }

    private final void lookAheadTest(Bundle p0) {
        Intent PlaceComponentResult = this.PlaceComponentResult.PlaceComponentResult(ChallengeActivity.class);
        PlaceComponentResult.putExtras(p0);
        PlaceComponentResult.setFlags(67108864);
        this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult, ContainerErrorCode.JS_RUN_FAIL);
    }

    private final void MyBillsEntityDataFactory(Bundle p0) {
        Intent PlaceComponentResult = this.PlaceComponentResult.PlaceComponentResult(ChallengeActivity.class);
        PlaceComponentResult.putExtras(p0);
        PlaceComponentResult.setFlags(67108864);
        this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult, ContainerErrorCode.WEBVIEW_LOAD_PERMISSION_FAIL);
    }

    private final void getAuthRequestContext(Bundle p0) {
        Intent PlaceComponentResult = this.PlaceComponentResult.PlaceComponentResult(ChallengeActivity.class);
        PlaceComponentResult.putExtras(p0);
        PlaceComponentResult.setFlags(67108864);
        this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult, ContainerErrorCode.EVENT_BUBBLE_INTERUPTED);
    }

    private final void getCallingPid(Bundle p0) {
        Intent PlaceComponentResult = this.PlaceComponentResult.PlaceComponentResult(ChallengeActivity.class);
        PlaceComponentResult.putExtras(p0);
        PlaceComponentResult.setFlags(67108864);
        this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult, 1003);
    }

    private final void whenAvailable(Bundle p0) {
        Intent PlaceComponentResult = this.PlaceComponentResult.PlaceComponentResult(ChallengeActivity.class);
        PlaceComponentResult.putExtras(p0);
        PlaceComponentResult.setFlags(67108864);
        this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult, 1004);
    }

    public final boolean MyBillsEntityDataFactory(int p0, int p1, Intent p2) {
        Bundle bundle;
        Listener listener;
        if (23623 == p0 || 1005 == p0 || 998 == p0 || 1002 == p0 || 1004 == p0) {
            if (-1 == p1 && (listener = this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda5) != null) {
                String str = this.getAuthRequestContext.scheduleImpl;
                listener.getAuthRequestContext();
            }
            if (p1 == 0) {
                String str2 = null;
                if (p2 == null || p2.getExtras() == null) {
                    bundle = null;
                } else {
                    bundle = p2.getExtras();
                    if (bundle != null) {
                        str2 = bundle.getString(Key.CANCEL_REASON);
                    }
                }
                Listener listener2 = this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda5;
                if (listener2 != null) {
                    listener2.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.scheduleImpl, str2, bundle);
                    return true;
                }
                return true;
            }
            return true;
        }
        return false;
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000"}, d2 = {"Lid/dana/challenge/ChallengeControl$Key;", "", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: classes2.dex */
    public @interface Key {
        public static final String ADDRESS = "address";
        public static final String AUTH_AGREEMENT = "auth_agreement";
        public static final String AUTH_STATUS = "auth_status";
        public static final String AUTH_TYPE = "auth_type";
        public static final String AUTO_ROUTE = "auto_route";
        public static final String AUTO_ROUTE_STATUS = "auto_route_status";
        public static final String BANK_OTP_MODEL = "bank_otp_model";
        public static final String CANCEL_REASON = "cancel_reason";
        public static final String CARD_BINDING_PIN = "card_binding_pin";
        public static final String CASHIER_AGREEMENT_MODEL = "cashier_agreement_model";
        public static final String CASHIER_ORDER_ID = "cashier_order_id";
        public static final String CASHIER_PAY_MODEL = "cashier_pay_model";
        public static final String CLIENT_ID = "client_id";

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.getAuthRequestContext;
        public static final String DIVISION_ID = "division_id";
        public static final String EXPIRY_SECONDS = "expiry_seconds";
        public static final String FACE_ACTIVATION = "face_activation";
        public static final String FACE_ACTIVATION_REGISTRATION = "face_activation_registration";
        public static final String FACE_ACTIVATION_SMART_PAY = "face_activation_smart_pay";
        public static final String FACE_AUTH_NEW = "face_auth_new";
        public static final String FACE_LOGIN_ENROLLED = "face_login_enrolled";
        public static final String FACE_ONLY_LOGIN = "face_only_login";
        public static final String FAMILY_ACCOUNT = "family_account";
        public static final String FROZEN_ACCOUNT_CHATBOT_FEATURE = "frozen_account_chatbot_feature";
        public static final String HELP_BUTTON_CHATBOT_FEATURE = "help_button_chatbot_feature";
        public static final String HELP_BUTTON_URL = "help_button_url";
        public static final String INVITATION_ID = "invitation_id";
        public static final String IS_BINDING_DIRECT_DEBIT = "is_direct_debit";
        public static final String IS_ERROR_RESEND = "is_error_resend";
        public static final String IS_FREEZE_VERIFY_OTP = "is_freeze_verify_otp";
        public static final String IS_RISK_PHASE_2 = "is_risk_phase_2";
        public static final String IS_WHATSAPP_ONLY = "is_whatsapp_only";
        public static final String KYC_FLAG = "kyc_flag";
        public static final String MERCHANT_ID = "merchant_id";
        public static final String OTP_CHANNEL = "otp_channel";
        public static final String OTP_CODE_LENGTH = "otp_code_length";
        public static final String OTP_PURPOSE = "otp_purpose";
        public static final String PASSKEY_ELIGIBILITY = "passkey_eligibility";
        public static final String PAYMENT_AUTH = "payment_auth";
        public static final String PAY_METHOD_MODEL = "pay_method_model";
        public static final String PHONE_NUMBER = "phone_number";
        public static final String PIN_PUB_KEY = "pin_pub_key";
        public static final String PUB_KEY = "pub_key";
        public static final String REGISTRATION_SOURCE = "registration_source";
        public static final String RELATION = "relation";
        public static final String RETRY_SEND_SECONDS = "retry_send_seconds";
        public static final String RISK_FLAG = "risk_flag";
        public static final String SCENARIO = "key_scenario";
        public static final String SECURITY_ID = "security_id";
        public static final String TRUST_2_RISK_LOGIN_MODEL = "trust_2_risk_login_model";
        public static final String TWILIO_OTP = "twilio_otp";
        public static final String TWILIO_PIN = "twilio_pin";
        public static final String UNBIND_ELIGIBILITY_CHECK_ID = "unbind_eligibility_check_id";
        public static final String UNBIND_MERCHANT = "unbind_merchant";
        public static final String USER_BOUND_ID = "user_bound_id";
        public static final String VERIFICATION_METHOD = "verification_method";
        public static final String WALLET_PERSONAL_FEATURE = "wallet_personal_feature";
        public static final String WITH_MOBILE_DATA = "with_mobile_data";

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/challenge/ChallengeControl$Key$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            static final /* synthetic */ Companion getAuthRequestContext = new Companion();

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000"}, d2 = {"Lid/dana/challenge/ChallengeControl$CancelReason;", "", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: classes2.dex */
    public @interface CancelReason {
        public static final String ACCOUNT_FROZEN = "account_frozen";
        public static final String BACK = "back";
        public static final String CLOSE = "close";

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.MyBillsEntityDataFactory;
        public static final String ERROR = "error";
        public static final String FORGOT_PIN = "forgot_pin";
        public static final String PIN_TEMPORARY_LOCKED = "pin_temporary_locked";
        public static final String SESSION_EXPIRED = "sessionExpired";
        public static final String VERIFY_PASSWORD_TRUST_RISK_EXPIRED = "verify_password_trust_risk_expired";

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/challenge/ChallengeControl$CancelReason$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            static final /* synthetic */ Companion MyBillsEntityDataFactory = new Companion();

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020N¢\u0006\u0004\bO\u0010PB-\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020N\u0012\u001a\u0010\u0005\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010R\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020S0Q¢\u0006\u0004\bO\u0010TB\u0013\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010U¢\u0006\u0004\bO\u0010VJ)\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ9\u0010\r\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ;\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000f\u0010\u0010J1\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0011J)\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0013\u0010\u0014J%\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0016J7\u0010\r\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u00172\u0006\u0010\u0006\u001a\u00020\u00172\b\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u0018J\u001d\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0086\u0002¢\u0006\u0006\n\u0004\b\u000f\u0010\u001cR\u001a\u0010\u000f\u001a\u00020\u00028\u0007X\u0086\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u000f\u0010\u001fR\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u0004X\u0087\u0002¢\u0006\u0006\n\u0004\b\r\u0010\u001cR\u001a\u0010\u001a\u001a\u00020\u00028\u0007X\u0087\u0006¢\u0006\f\n\u0004\b \u0010\u001e\u001a\u0004\b\u0013\u0010\u001fR\u0014\u0010\r\u001a\u0004\u0018\u00010\tX\u0087\u0002¢\u0006\u0006\n\u0004\b\u0013\u0010!R\u0014\u0010\"\u001a\u0004\u0018\u00010\u0004X\u0087\u0002¢\u0006\u0006\n\u0004\b\u0007\u0010\u001cR\u0014\u0010#\u001a\u0004\u0018\u00010\u0004X\u0087\u0002¢\u0006\u0006\n\u0004\b\u001a\u0010\u001cR\u001a\u0010%\u001a\u00020\u00028\u0007X\u0087\u0006¢\u0006\f\n\u0004\b$\u0010\u001e\u001a\u0004\b\u001a\u0010\u001fR\u0014\u0010&\u001a\u0004\u0018\u00010\u0004X\u0087\u0002¢\u0006\u0006\n\u0004\b%\u0010\u001cR\u0014\u0010$\u001a\u0004\u0018\u00010\u0004X\u0087\u0002¢\u0006\u0006\n\u0004\b\"\u0010\u001cR\u0012\u0010(\u001a\u00020\u0017X\u0087\u0002¢\u0006\u0006\n\u0004\b&\u0010'R\u0012\u0010+\u001a\u00020)X\u0087\u0002¢\u0006\u0006\n\u0004\b#\u0010*R\u001a\u0010-\u001a\u00020\u00028\u0007X\u0087\u0006¢\u0006\f\n\u0004\b,\u0010\u001e\u001a\u0004\b\r\u0010\u001fR\u001a\u0010/\u001a\u00020\u00028\u0007X\u0087\u0006¢\u0006\f\n\u0004\b.\u0010\u001e\u001a\u0004\b\u0007\u0010\u001fR\u001a\u00101\u001a\u00020\u00028\u0007X\u0087\u0006¢\u0006\f\n\u0004\b0\u0010\u001e\u001a\u0004\b%\u0010\u001fR\u001a\u00102\u001a\u00020\u00028\u0007X\u0087\u0006¢\u0006\f\n\u0004\b(\u0010\u001e\u001a\u0004\b#\u0010\u001fR\u0014\u00103\u001a\u0004\u0018\u00010\u0004X\u0087\u0002¢\u0006\u0006\n\u0004\b1\u0010\u001cR\u0014\u00104\u001a\u0004\u0018\u00010\u0004X\u0087\u0002¢\u0006\u0006\n\u0004\b/\u0010\u001cR\u001a\u00106\u001a\u00020\u00028\u0007X\u0087\u0006¢\u0006\f\n\u0004\b5\u0010\u001e\u001a\u0004\b/\u0010\u001fR\u001a\u00108\u001a\u00020\u00028\u0007X\u0087\u0006¢\u0006\f\n\u0004\b7\u0010\u001e\u001a\u0004\b+\u0010\u001fR\u001a\u00109\u001a\u00020\u00028\u0007X\u0087\u0006¢\u0006\f\n\u0004\b-\u0010\u001e\u001a\u0004\b(\u0010\u001fR\u001a\u0010;\u001a\u00020\u00028\u0007X\u0087\u0006¢\u0006\f\n\u0004\b:\u0010\u001e\u001a\u0004\b-\u0010\u001fR\u001a\u0010=\u001a\u00020\u00028\u0007X\u0087\u0006¢\u0006\f\n\u0004\b<\u0010\u001e\u001a\u0004\b&\u0010\u001fR\u0014\u0010@\u001a\u0004\u0018\u00010>X\u0087\u0002¢\u0006\u0006\n\u0004\b+\u0010?R\u0014\u0010A\u001a\u0004\u0018\u00010\u0004X\u0087\u0002¢\u0006\u0006\n\u0004\b4\u0010\u001cR\u0014\u0010B\u001a\u0004\u0018\u00010\u0004X\u0087\u0002¢\u0006\u0006\n\u0004\b2\u0010\u001cR\u0012\u0010C\u001a\u00020\u0017X\u0087\u0002¢\u0006\u0006\n\u0004\b3\u0010'R\u0014\u0010D\u001a\u0004\u0018\u00010\u0004X\u0087\u0002¢\u0006\u0006\n\u0004\b8\u0010\u001cR\u0014\u0010F\u001a\u0004\u0018\u00010\u000bX\u0087\u0002¢\u0006\u0006\n\u0004\b6\u0010ER\u0014\u0010G\u001a\u0004\u0018\u00010\u0004X\u0087\u0002¢\u0006\u0006\n\u0004\bA\u0010\u001cR\u0014\u0010,\u001a\u0004\u0018\u00010\u0004X\u0087\u0002¢\u0006\u0006\n\u0004\b=\u0010\u001cR\u0014\u0010 \u001a\u0004\u0018\u00010\u0004X\u0087\u0002¢\u0006\u0006\n\u0004\b;\u0010\u001cR\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u0004X\u0087\u0002¢\u0006\u0006\n\u0004\b9\u0010\u001cR\u0014\u0010H\u001a\u0004\u0018\u00010\u0004X\u0087\u0002¢\u0006\u0006\n\u0004\b@\u0010\u001cR\u0012\u0010.\u001a\u00020\u0017X\u0087\u0002¢\u0006\u0006\n\u0004\bD\u0010'R\u001a\u00105\u001a\u00020\u00028\u0007X\u0087\u0006¢\u0006\f\n\u0004\bI\u0010\u001e\u001a\u0004\b\"\u0010\u001fR\u0014\u0010<\u001a\u0004\u0018\u00010\u0004X\u0087\u0002¢\u0006\u0006\n\u0004\bB\u0010\u001cR\u0014\u0010:\u001a\u0004\u0018\u00010JX\u0087\u0002¢\u0006\u0006\n\u0004\bF\u0010KR\u0014\u00107\u001a\u0004\u0018\u00010\u0004X\u0087\u0002¢\u0006\u0006\n\u0004\bC\u0010\u001cR\u0014\u00100\u001a\u0004\u0018\u00010\u0004X\u0087\u0002¢\u0006\u0006\n\u0004\bG\u0010\u001cR\u0014\u0010L\u001a\u0004\u0018\u00010\u0004X\u0087\u0002¢\u0006\u0006\n\u0004\bH\u0010\u001cR\u001a\u0010'\u001a\u00020\u00028\u0007X\u0087\u0006¢\u0006\f\n\u0004\bM\u0010\u001e\u001a\u0004\b$\u0010\u001f"}, d2 = {"Lid/dana/challenge/ChallengeControl$Builder;", "", "", "p0", "", "p1", "p2", "MyBillsEntityDataFactory", "(ZLjava/lang/String;Ljava/lang/String;)Lid/dana/challenge/ChallengeControl$Builder;", "Lid/dana/cashier/model/SendBankOtpModel;", "p3", "Lid/dana/cashier/model/CashierPayMethodModel$CardPayMethod;", "p4", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;Lid/dana/cashier/model/SendBankOtpModel;ZZLid/dana/cashier/model/CashierPayMethodModel$CardPayMethod;)Lid/dana/challenge/ChallengeControl$Builder;", "PlaceComponentResult", "(Ljava/lang/String;Ljava/lang/String;ZLid/dana/cashier/model/CashierPayMethodModel$CardPayMethod;Ljava/lang/String;)Lid/dana/challenge/ChallengeControl$Builder;", "(ZLjava/lang/String;Ljava/lang/String;Z)Lid/dana/challenge/ChallengeControl$Builder;", "Lid/dana/model/LoginAuthenticationMethod;", "BuiltInFictitiousFunctionClassFactory", "(ZLjava/lang/String;Lid/dana/model/LoginAuthenticationMethod;)Lid/dana/challenge/ChallengeControl$Builder;", "Lid/dana/familyaccount/model/InviteMemberModel;", "(Lid/dana/familyaccount/model/InviteMemberModel;Ljava/lang/String;Ljava/lang/String;)Lid/dana/challenge/ChallengeControl$Builder;", "", "(IILjava/lang/String;Z)Lid/dana/challenge/ChallengeControl$Builder;", "Lid/dana/myprofile/model/PaymentSecuritySwitchModel;", "getAuthRequestContext", "(ZLid/dana/myprofile/model/PaymentSecuritySwitchModel;)Lid/dana/challenge/ChallengeControl$Builder;", "Ljava/lang/String;", "VerifyPinStateManager$executeRiskChallenge$2$1", "Z", "()Z", "BottomSheetCardBindingView$watcherCardNumberView$1", "Lid/dana/cashier/model/SendBankOtpModel;", "lookAheadTest", "scheduleImpl", "getErrorConfigVersion", "NetworkUserEntityData$$ExternalSyntheticLambda0", "moveToNextValue", "I", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lid/dana/challenge/ChallengeControlFacade;", "Lid/dana/challenge/ChallengeControlFacade;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "C", "initRecordTimeStamp", DiskFormatter.B, "DatabaseTableConfigUtil", "VerifyPinStateManager$executeRiskChallenge$2$2", "GetContactSyncConfig", "newProxyInstance", "isLayoutRequested", "PrepareContext", SummaryActivity.DAYS, "NetworkUserEntityData$$ExternalSyntheticLambda8", "getOnBoardingScenario", "NetworkUserEntityData$$ExternalSyntheticLambda7", "NetworkUserEntityData$$ExternalSyntheticLambda4", "getValueOfTouchPositionAbsolute", "FragmentBottomSheetPaymentSettingBinding", "E", "NetworkUserEntityData$$ExternalSyntheticLambda6", "Lid/dana/challenge/ChallengeControl$Listener;", "Lid/dana/challenge/ChallengeControl$Listener;", "NetworkUserEntityData$$ExternalSyntheticLambda5", "NetworkUserEntityData$$ExternalSyntheticLambda3", "getCallingPid", "readMicros", "SubSequence", "Lid/dana/cashier/model/CashierPayMethodModel$CardPayMethod;", "whenAvailable", "getSupportButtonTintMode", "A", LogConstants.RESULT_FALSE, "Lid/dana/model/Trust2RiskLoginModel;", "Lid/dana/model/Trust2RiskLoginModel;", SummaryActivity.HOURS, "AppCompatEmojiTextHelper", "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "Lkotlin/Function2;", "Landroid/content/Intent;", "", "(Landroid/app/Activity;Lkotlin/jvm/functions/Function2;)V", "Lid/dana/base/BaseFragment;", "(Lid/dana/base/BaseFragment;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: A  reason: from kotlin metadata */
        String H;

        /* renamed from: AppCompatEmojiTextHelper  reason: from kotlin metadata */
        private boolean I;

        /* renamed from: B  reason: from kotlin metadata */
        private boolean DatabaseTableConfigUtil;

        /* renamed from: BottomSheetCardBindingView$watcherCardNumberView$1  reason: from kotlin metadata */
        private boolean getAuthRequestContext;

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        SendBankOtpModel KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: C  reason: from kotlin metadata */
        private boolean initRecordTimeStamp;

        /* renamed from: D  reason: from kotlin metadata */
        private boolean NetworkUserEntityData$$ExternalSyntheticLambda8;

        /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
        public String PrepareContext;

        /* renamed from: E  reason: from kotlin metadata */
        private boolean NetworkUserEntityData$$ExternalSyntheticLambda6;

        /* renamed from: F  reason: from kotlin metadata */
        private boolean D;

        /* renamed from: FragmentBottomSheetPaymentSettingBinding  reason: from kotlin metadata */
        public String BottomSheetCardBindingView$watcherCardNumberView$1;

        /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
        public String isLayoutRequested;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        String BuiltInFictitiousFunctionClassFactory;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        String lookAheadTest;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
        public String moveToNextValue;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
        public Listener NetworkUserEntityData$$ExternalSyntheticLambda5;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
        public boolean newProxyInstance;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda3  reason: from kotlin metadata */
        public String getSupportButtonTintMode;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda4  reason: from kotlin metadata */
        public String VerifyPinStateManager$executeRiskChallenge$2$1;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda5  reason: from kotlin metadata */
        String A;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda6  reason: from kotlin metadata */
        String C;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
        public String SubSequence;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
        CashierPayMethodModel.CardPayMethod whenAvailable;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        String MyBillsEntityDataFactory;

        /* renamed from: PrepareContext  reason: from kotlin metadata */
        public String NetworkUserEntityData$$ExternalSyntheticLambda3;

        /* renamed from: SubSequence  reason: from kotlin metadata */
        int B;

        /* renamed from: VerifyPinStateManager$executeRiskChallenge$2$1  reason: from kotlin metadata */
        private boolean PlaceComponentResult;

        /* renamed from: VerifyPinStateManager$executeRiskChallenge$2$2  reason: from kotlin metadata */
        private boolean GetContactSyncConfig;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public String scheduleImpl;

        /* renamed from: getCallingPid  reason: from kotlin metadata */
        public String E;

        /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
        public boolean NetworkUserEntityData$$ExternalSyntheticLambda0;

        /* renamed from: getOnBoardingScenario  reason: from kotlin metadata */
        private boolean NetworkUserEntityData$$ExternalSyntheticLambda7;

        /* renamed from: getSupportButtonTintMode  reason: from kotlin metadata */
        public String VerifyPinStateManager$executeRiskChallenge$2$2;

        /* renamed from: getValueOfTouchPositionAbsolute  reason: from kotlin metadata */
        private boolean FragmentBottomSheetPaymentSettingBinding;

        /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
        public boolean NetworkUserEntityData$$ExternalSyntheticLambda4;

        /* renamed from: isLayoutRequested  reason: from kotlin metadata */
        int readMicros;

        /* renamed from: lookAheadTest  reason: from kotlin metadata */
        public String getErrorConfigVersion;

        /* renamed from: moveToNextValue  reason: from kotlin metadata */
        int NetworkUserEntityData$$ExternalSyntheticLambda2;

        /* renamed from: newProxyInstance  reason: from kotlin metadata */
        String getCallingPid;

        /* renamed from: readMicros  reason: from kotlin metadata */
        public String getOnBoardingScenario;

        /* renamed from: scheduleImpl  reason: from kotlin metadata */
        ChallengeControlFacade NetworkUserEntityData$$ExternalSyntheticLambda1;

        /* renamed from: whenAvailable  reason: from kotlin metadata */
        public Trust2RiskLoginModel getValueOfTouchPositionAbsolute;

        @JvmName(name = "NetworkUserEntityData$$ExternalSyntheticLambda1")
        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from getter */
        public final boolean getNetworkUserEntityData$$ExternalSyntheticLambda7() {
            return this.NetworkUserEntityData$$ExternalSyntheticLambda7;
        }

        @JvmName(name = "NetworkUserEntityData$$ExternalSyntheticLambda2")
        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from getter */
        public final boolean getNetworkUserEntityData$$ExternalSyntheticLambda4() {
            return this.NetworkUserEntityData$$ExternalSyntheticLambda4;
        }

        @JvmName(name = "PlaceComponentResult")
        /* renamed from: PlaceComponentResult  reason: from getter */
        public final boolean getPlaceComponentResult() {
            return this.PlaceComponentResult;
        }

        @JvmName(name = "NetworkUserEntityData$$ExternalSyntheticLambda0")
        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from getter */
        public final boolean getGetContactSyncConfig() {
            return this.GetContactSyncConfig;
        }

        @JvmName(name = "MyBillsEntityDataFactory")
        /* renamed from: MyBillsEntityDataFactory  reason: from getter */
        public final boolean getDatabaseTableConfigUtil() {
            return this.DatabaseTableConfigUtil;
        }

        @JvmName(name = "moveToNextValue")
        /* renamed from: moveToNextValue  reason: from getter */
        public final boolean getNetworkUserEntityData$$ExternalSyntheticLambda6() {
            return this.NetworkUserEntityData$$ExternalSyntheticLambda6;
        }

        @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
        public final boolean getInitRecordTimeStamp() {
            return this.initRecordTimeStamp;
        }

        @JvmName(name = "lookAheadTest")
        /* renamed from: lookAheadTest  reason: from getter */
        public final boolean getD() {
            return this.D;
        }

        @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
        public final boolean getGetAuthRequestContext() {
            return this.getAuthRequestContext;
        }

        @JvmName(name = "getErrorConfigVersion")
        /* renamed from: getErrorConfigVersion  reason: from getter */
        public final boolean getI() {
            return this.I;
        }

        @JvmName(name = "getAuthRequestContext")
        /* renamed from: getAuthRequestContext  reason: from getter */
        public final boolean getNetworkUserEntityData$$ExternalSyntheticLambda0() {
            return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        }

        @JvmName(name = "scheduleImpl")
        /* renamed from: scheduleImpl  reason: from getter */
        public final boolean getNewProxyInstance() {
            return this.newProxyInstance;
        }

        @JvmName(name = "initRecordTimeStamp")
        /* renamed from: initRecordTimeStamp  reason: from getter */
        public final boolean getFragmentBottomSheetPaymentSettingBinding() {
            return this.FragmentBottomSheetPaymentSettingBinding;
        }

        @JvmName(name = "DatabaseTableConfigUtil")
        /* renamed from: DatabaseTableConfigUtil  reason: from getter */
        public final boolean getNetworkUserEntityData$$ExternalSyntheticLambda8() {
            return this.NetworkUserEntityData$$ExternalSyntheticLambda8;
        }

        public Builder(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "");
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new ActivityChallengeControl(activity);
        }

        public Builder(Activity activity, Function2<? super Intent, ? super Integer, Unit> function2) {
            Intrinsics.checkNotNullParameter(activity, "");
            Intrinsics.checkNotNullParameter(function2, "");
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new BridgeActivityChallengeControl(activity, function2);
        }

        public Builder(BaseFragment baseFragment) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new FragmentChallengeControl(baseFragment);
        }

        public final Builder KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2, String str, boolean z) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = 0;
            this.B = i;
            this.readMicros = i2;
            if (str == null) {
                str = "";
            }
            this.getCallingPid = str;
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = z;
            return this;
        }

        public final Builder getAuthRequestContext(boolean p0, PaymentSecuritySwitchModel p1) {
            Intrinsics.checkNotNullParameter(p1, "");
            this.PlaceComponentResult = p0;
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = p1.getAuthRequestContext.PlaceComponentResult;
            this.E = p1.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory;
            this.BuiltInFictitiousFunctionClassFactory = p1.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext;
            return this;
        }

        public final Builder MyBillsEntityDataFactory(boolean p0, String p1, String p2, boolean p3) {
            this.PlaceComponentResult = p0;
            if (p1 == null) {
                p1 = "";
            }
            this.E = p1;
            if (p2 == null) {
                p2 = "";
            }
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = p2;
            this.initRecordTimeStamp = p3;
            return this;
        }

        public final Builder BuiltInFictitiousFunctionClassFactory(boolean p0, String p1, LoginAuthenticationMethod p2) {
            this.GetContactSyncConfig = p0;
            if (p1 == null) {
                p1 = "";
            }
            this.E = p1;
            this.DatabaseTableConfigUtil = p2 != null ? p2.KClassImpl$Data$declaredNonStaticMembers$2() : false;
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = p2 != null ? p2.MyBillsEntityDataFactory() : false;
            this.D = p2 != null ? p2.PlaceComponentResult() : false;
            return this;
        }

        public final Builder MyBillsEntityDataFactory(boolean p0, String p1, String p2) {
            this.getAuthRequestContext = p0;
            if (p1 == null) {
                p1 = "";
            }
            this.E = p1;
            if (p2 == null) {
                p2 = "";
            }
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = p2;
            return this;
        }

        public final Builder PlaceComponentResult(InviteMemberModel p0, String p1, String p2) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            Intrinsics.checkNotNullParameter(p2, "");
            this.getSupportButtonTintMode = p0.getAuthRequestContext;
            this.MyBillsEntityDataFactory = p0.BuiltInFictitiousFunctionClassFactory;
            this.A = p0.MyBillsEntityDataFactory;
            this.E = p1;
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = p2;
            return this;
        }

        public final Builder KClassImpl$Data$declaredNonStaticMembers$2(String p0, SendBankOtpModel p1, boolean p2, boolean p3, CashierPayMethodModel.CardPayMethod p4) {
            Intrinsics.checkNotNullParameter(p0, "");
            this.H = p0;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = p1;
            this.FragmentBottomSheetPaymentSettingBinding = p2;
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = p3;
            this.whenAvailable = p4;
            String str = p1 != null ? p1.getAuthRequestContext : null;
            this.getSupportButtonTintMode = str != null ? str : "";
            return this;
        }

        public final Builder PlaceComponentResult(String p0, String p1, boolean p2, CashierPayMethodModel.CardPayMethod p3, String p4) {
            Intrinsics.checkNotNullParameter(p0, "");
            this.H = p0;
            this.lookAheadTest = p1;
            this.FragmentBottomSheetPaymentSettingBinding = p2;
            this.whenAvailable = p3;
            this.C = p4;
            return this;
        }
    }
}
