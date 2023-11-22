package id.dana.challenge.pin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ClickableSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.afollestad.materialdialogs.MaterialDialog;
import com.alipay.iap.android.wallet.acl.base.Result;
import com.anggrayudi.storage.permission.FragmentPermissionRequest;
import com.anggrayudi.storage.permission.PermissionCallback;
import com.anggrayudi.storage.permission.PermissionRequest;
import com.anggrayudi.storage.permission.PermissionResult;
import dagger.Lazy;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.BaseFragment;
import id.dana.cashier.model.CashierPayModel;
import id.dana.challenge.ChallengeControl;
import id.dana.challenge.ChallengeScenario;
import id.dana.challenge.ChallengeScenarioListener;
import id.dana.challenge.botprotection.BotProtectionChallenge;
import id.dana.challenge.pin.AbstractPinContract;
import id.dana.constants.ErrorCode;
import id.dana.core.ui.richview.PinEntryEditText;
import id.dana.danah5.DanaH5;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.data.foundation.logger.log.LoginTrackingConstants;
import id.dana.data.login.source.network.model.VerifyMethod;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerPinChallengeComponent;
import id.dana.di.component.PinChallengeComponent;
import id.dana.di.modules.PinChallengeModule;
import id.dana.riskChallenges.di.module.FaceAuthenticationModule;
import id.dana.tracker.EventTracker;
import id.dana.tracker.mixpanel.ChallengeEvent;
import id.dana.tracker.rds.RDSConstant;
import id.dana.tracker.rds.RDSEvent;
import id.dana.utils.DanaTextWatcher;
import id.dana.utils.PhoneCall;
import id.dana.utils.TextUtil;
import id.dana.utils.android.AppUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public class PinChallengeFragment extends BaseFragment implements AbstractPinContract.View {
    private PinChallengeComponent DatabaseTableConfigUtil;
    private String GetContactSyncConfig;
    FragmentPermissionRequest KClassImpl$Data$declaredNonStaticMembers$2;
    private String MyBillsEntityDataFactory;
    private ChallengeScenarioListener NetworkUserEntityData$$ExternalSyntheticLambda0;
    private String NetworkUserEntityData$$ExternalSyntheticLambda1;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda2;
    private boolean PlaceComponentResult;
    private String PrepareContext;
    @Inject
    Lazy<BotProtectionChallenge> botProtectionChallenge;
    @BindView(R.id.ll_bottom_message_block)
    LinearLayout bottomMesageBlock;
    @BindView(R.id.bottom_message)
    TextView bottomMessage;
    @BindView(R.id.bottom_try_again)
    TextView bottomTryAgain;
    @BindView(R.id.res_0x7f0a0208_networkuserentitydata_externalsyntheticlambda0)
    AppCompatTextView btnShowHidePin;
    @Inject
    DynamicUrlWrapper dynamicUrlWrapper;
    @BindView(R.id.other_action)
    TextView forgotPin;
    private boolean getErrorConfigVersion;
    @BindView(R.id.ic_image_fg)
    ImageView icImageFg;
    @BindView(R.id.res_0x7f0a0905_networkuserentitydata_externalsyntheticlambda8)
    PinEntryEditText inputPin;
    private Bundle moveToNextValue;
    @Inject
    AbstractPinContract.Presenter presenter;
    @BindView(R.id.ic_progress)
    RelativeLayout progressBar;
    @BindView(R.id.rl_warning)
    RelativeLayout relativeWarningIcon;
    private boolean scheduleImpl;
    @BindView(R.id.ic_success)
    ImageView successIcon;
    @BindView(R.id.pin_success)
    TextView successPin;
    @BindView(R.id.res_0x7f0a0907_networkuserentitydata_externalsyntheticlambda7)
    TextView txtInputPinMessage;
    private final DanaTextWatcher lookAheadTest = new DanaTextWatcher();
    private String initRecordTimeStamp = "";

    protected void BuiltInFictitiousFunctionClassFactory(Bundle bundle) {
    }

    public /* synthetic */ void BuiltInFictitiousFunctionClassFactory(CashierPayModel cashierPayModel, boolean z) {
        AbstractPinContract.View.CC.getAuthRequestContext();
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.View
    public final void KClassImpl$Data$declaredNonStaticMembers$2(long j) {
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.View
    public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean z) {
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.View
    public final /* synthetic */ void PlaceComponentResult() {
        AbstractPinContract.View.CC.PlaceComponentResult();
    }

    @Override // id.dana.base.BaseFragment
    public int getLayout() {
        return R.layout.fragment_input_pin;
    }

    public static PinChallengeFragment getAuthRequestContext(Bundle bundle) {
        PinChallengeFragment pinChallengeFragment = new PinChallengeFragment();
        pinChallengeFragment.setArguments(bundle);
        return pinChallengeFragment;
    }

    public final String BuiltInFictitiousFunctionClassFactory() {
        return this.GetContactSyncConfig;
    }

    public final String MyBillsEntityDataFactory() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda1;
    }

    public final String getErrorConfigVersion() {
        return this.PrepareContext;
    }

    @Override // id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        FragmentPermissionRequest.Builder builder = new FragmentPermissionRequest.Builder(this);
        String[] strArr = {"android.permission.CALL_PHONE"};
        Intrinsics.checkNotNullParameter(strArr, "");
        builder.getAuthRequestContext = ArraysKt.toSet(strArr);
        PermissionCallback permissionCallback = new PermissionCallback() { // from class: id.dana.challenge.pin.PinChallengeFragment$$ExternalSyntheticLambda1
            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final /* synthetic */ void onDisplayConsentDialog(PermissionRequest permissionRequest) {
                PermissionCallback.CC.getAuthRequestContext(permissionRequest);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final /* synthetic */ void onShouldRedirectToSystemSettings(List list) {
                PermissionCallback.CC.BuiltInFictitiousFunctionClassFactory(list);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onPermissionsChecked(PermissionResult permissionResult, boolean z) {
                PinChallengeFragment pinChallengeFragment = PinChallengeFragment.this;
                if (permissionResult.MyBillsEntityDataFactory()) {
                    PhoneCall.KClassImpl$Data$declaredNonStaticMembers$2(pinChallengeFragment.getBaseActivity(), "1500445", true);
                }
            }
        };
        Intrinsics.checkNotNullParameter(permissionCallback, "");
        builder.BuiltInFictitiousFunctionClassFactory = permissionCallback;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = builder.PlaceComponentResult();
        try {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = (ChallengeScenarioListener) getBaseActivity();
        } catch (ClassCastException unused) {
            StringBuilder sb = new StringBuilder();
            sb.append(context.toString());
            sb.append("must implement ChallengeScenarioListener");
            throw new ClassCastException(sb.toString());
        }
    }

    @Override // id.dana.base.BaseFragment
    public void init() {
        Bundle arguments = getArguments();
        this.moveToNextValue = arguments;
        byte b = 0;
        if (arguments != null) {
            BuiltInFictitiousFunctionClassFactory(arguments);
            this.GetContactSyncConfig = this.moveToNextValue.getString(ChallengeControl.Key.SCENARIO);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = this.moveToNextValue.getString(ChallengeControl.Key.PUB_KEY);
            this.PrepareContext = this.moveToNextValue.getString(ChallengeControl.Key.SECURITY_ID);
            this.MyBillsEntityDataFactory = this.moveToNextValue.getString(ChallengeControl.Key.AUTH_TYPE);
            this.PlaceComponentResult = this.moveToNextValue.getBoolean(ChallengeControl.Key.AUTH_STATUS, false);
            this.getErrorConfigVersion = this.moveToNextValue.getBoolean(ChallengeControl.Key.FACE_AUTH_NEW);
            this.scheduleImpl = this.moveToNextValue.getBoolean(ChallengeControl.Key.AUTO_ROUTE_STATUS);
            String str = this.GetContactSyncConfig;
            if (this.DatabaseTableConfigUtil == null) {
                DaggerPinChallengeComponent.Builder authRequestContext = DaggerPinChallengeComponent.getAuthRequestContext();
                authRequestContext.MyBillsEntityDataFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
                authRequestContext.getAuthRequestContext = (PinChallengeModule) Preconditions.getAuthRequestContext(new PinChallengeModule(this, str));
                authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2 = (FaceAuthenticationModule) Preconditions.getAuthRequestContext(new FaceAuthenticationModule());
                Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.getAuthRequestContext, PinChallengeModule.class);
                if (authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                    authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2 = new FaceAuthenticationModule();
                }
                Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.MyBillsEntityDataFactory, ApplicationComponent.class);
                this.DatabaseTableConfigUtil = new DaggerPinChallengeComponent.PinChallengeComponentImpl(authRequestContext.getAuthRequestContext, authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2, authRequestContext.MyBillsEntityDataFactory, b);
            }
            this.DatabaseTableConfigUtil.KClassImpl$Data$declaredNonStaticMembers$2(this);
            registerPresenter(this.presenter);
            this.initRecordTimeStamp = this.moveToNextValue.getString(ChallengeControl.Key.REGISTRATION_SOURCE);
            this.presenter.PlaceComponentResult();
            this.presenter.BuiltInFictitiousFunctionClassFactory(this.initRecordTimeStamp);
        }
        String str2 = this.initRecordTimeStamp;
        if (str2 != null) {
            if ("TIX ID, Bukalapak, or Ramayana App".equalsIgnoreCase(str2)) {
                this.initRecordTimeStamp = getString(R.string.registration_source_merchant_app);
            }
            String str3 = this.initRecordTimeStamp;
            str3.hashCode();
            char c = 65535;
            switch (str3.hashCode()) {
                case -781220308:
                    if (str3.equals("card_binding_pin")) {
                        c = 0;
                        break;
                    }
                    break;
                case -526265877:
                    if (str3.equals(ChallengeControl.Key.FACE_ACTIVATION_SMART_PAY)) {
                        c = 1;
                        break;
                    }
                    break;
                case -497502143:
                    if (str3.equals("payment_auth")) {
                        c = 2;
                        break;
                    }
                    break;
                case -489325167:
                    if (str3.equals("unbind_merchant")) {
                        c = 3;
                        break;
                    }
                    break;
                case -41045063:
                    if (str3.equals("auto_route")) {
                        c = 4;
                        break;
                    }
                    break;
                case 539748434:
                    if (str3.equals("family_account")) {
                        c = 5;
                        break;
                    }
                    break;
                case 1075210109:
                    if (str3.equals(ChallengeControl.Key.WALLET_PERSONAL_FEATURE)) {
                        c = 6;
                        break;
                    }
                    break;
                case 1124674296:
                    if (str3.equals("twilio_otp")) {
                        c = 7;
                        break;
                    }
                    break;
                case 1124674914:
                    if (str3.equals("twilio_pin")) {
                        c = '\b';
                        break;
                    }
                    break;
                case 1656771640:
                    if (str3.equals("face_activation")) {
                        c = '\t';
                        break;
                    }
                    break;
                case 1908226099:
                    if (str3.equals(ChallengeControl.Key.AUTH_AGREEMENT)) {
                        c = '\n';
                        break;
                    }
                    break;
                case 1980733792:
                    if (str3.equals(ChallengeControl.Key.FACE_ACTIVATION_REGISTRATION)) {
                        c = 11;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 6:
                case 7:
                case '\b':
                case '\t':
                case '\n':
                case 11:
                    this.txtInputPinMessage.setText(getString(R.string.input_password_payment_auth));
                    break;
                case 4:
                    this.txtInputPinMessage.setText(getString(R.string.input_your_pin));
                    this.forgotPin.setText(getString(R.string.forgot_pin_uppercase_with_question_mark));
                    RelativeLayout relativeLayout = this.relativeWarningIcon;
                    if (relativeLayout != null && this.btnShowHidePin != null && this.forgotPin != null) {
                        relativeLayout.setContentDescription(getContext().getString(R.string.txt_pin_input));
                        this.btnShowHidePin.setContentDescription(getContext().getString(R.string.btn_show_pin));
                        this.forgotPin.setContentDescription(getContext().getString(R.string.btn_forgot_pin));
                        break;
                    }
                    break;
                case 5:
                    this.txtInputPinMessage.setText(getString(R.string.input_your_pin_v2));
                    this.txtInputPinMessage.setContentDescription(getString(R.string.txt_risk_pin));
                    this.forgotPin.setText(getString(R.string.forgot_pin_uppercase_with_question_mark));
                    break;
                default:
                    this.txtInputPinMessage.setText(String.format(getString(R.string.input_password_with_register_source), this.initRecordTimeStamp));
                    break;
            }
        }
        this.inputPin.requestFocus();
        this.inputPin.setOnBackButtonListener(new PinEntryEditText.IOnBackButtonListener() { // from class: id.dana.challenge.pin.PinChallengeFragment$$ExternalSyntheticLambda2
            @Override // id.dana.core.ui.richview.PinEntryEditText.IOnBackButtonListener
            public final boolean PlaceComponentResult() {
                return PinChallengeFragment.this.scheduleImpl();
            }
        });
        this.inputPin.setContentDescription(getContext().getString(R.string.wallet_txt_input_pin_identity));
        this.lookAheadTest.PlaceComponentResult(this.inputPin, new TextWatcher() { // from class: id.dana.challenge.pin.PinChallengeFragment.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence.length() == PinChallengeFragment.this.inputPin.getMaxLength()) {
                    PinChallengeFragment.this.PlaceComponentResult(charSequence.toString());
                    if ("login".equals(PinChallengeFragment.this.GetContactSyncConfig)) {
                        DanaLog.KClassImpl$Data$declaredNonStaticMembers$2(LoginTrackingConstants.NormalLogin.BEGIN, "");
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                EventTracker.BuiltInFictitiousFunctionClassFactory(new RDSEvent("Onboarding", "rds_on_key_down", RDSConstant.INPUT_PIN, editable.toString().replaceAll("[0-9]", "*")));
            }
        });
        this.inputPin.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: id.dana.challenge.pin.PinChallengeFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                PinChallengeFragment.MyBillsEntityDataFactory(z);
            }
        });
        this.inputPin.setOnKeyListener(new View.OnKeyListener() { // from class: id.dana.challenge.pin.PinChallengeFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                return PinChallengeFragment.this.getAuthRequestContext(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ boolean scheduleImpl() {
        getBaseActivity().finish();
        return true;
    }

    @Override // id.dana.base.BaseFragment
    public void onSelected() {
        super.onSelected();
    }

    @Override // id.dana.base.BaseFragment
    public void onUnSelected() {
        super.onUnSelected();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void MyBillsEntityDataFactory(boolean z) {
        if (z) {
            EventTracker.BuiltInFictitiousFunctionClassFactory(new RDSEvent("Onboarding", "rds_on_lost_focus", RDSConstant.INPUT_PIN_GET_FOCUS, true));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ boolean getAuthRequestContext(int i) {
        if (i == 67) {
            this.inputPin.maskLastPinCharacter();
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void PlaceComponentResult(String str) {
        String str2 = this.GetContactSyncConfig;
        if (str2 != null) {
            str2.hashCode();
            char c = 65535;
            switch (str2.hashCode()) {
                case -2047416274:
                    if (str2.equals(ChallengeScenario.WALLET_PERSONAL_KTP)) {
                        c = 0;
                        break;
                    }
                    break;
                case -497502143:
                    if (str2.equals("payment_auth")) {
                        c = 1;
                        break;
                    }
                    break;
                case -489325167:
                    if (str2.equals("unbind_merchant")) {
                        c = 2;
                        break;
                    }
                    break;
                case -41045063:
                    if (str2.equals("auto_route")) {
                        c = 3;
                        break;
                    }
                    break;
                case 1124674914:
                    if (str2.equals("twilio_pin")) {
                        c = 4;
                        break;
                    }
                    break;
                case 1656771640:
                    if (str2.equals("face_activation")) {
                        c = 5;
                        break;
                    }
                    break;
                case 1667024777:
                    if (str2.equals(ChallengeScenario.AUTH_AGREEMENT_PIN)) {
                        c = 6;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    this.presenter.KClassImpl$Data$declaredNonStaticMembers$2(str);
                    return;
                case 1:
                    this.presenter.PlaceComponentResult(str, this.MyBillsEntityDataFactory, this.PlaceComponentResult, this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.PrepareContext);
                    return;
                case 2:
                    this.presenter.BuiltInFictitiousFunctionClassFactory(str, this.moveToNextValue);
                    return;
                case 3:
                    this.presenter.getAuthRequestContext(str, this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.PrepareContext, this.scheduleImpl);
                    return;
                case 4:
                    this.presenter.MyBillsEntityDataFactory(str, "PASSWORD", this.PrepareContext, "TWILIO_CONSULT");
                    return;
                case 5:
                    AbstractPinContract.Presenter presenter = this.presenter;
                    String str3 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    String str4 = this.PrepareContext;
                    boolean z = this.getErrorConfigVersion;
                    presenter.getAuthRequestContext(str, str3, str4, Boolean.valueOf(z), requireActivity());
                    return;
                case 6:
                    this.presenter.MyBillsEntityDataFactory(str, "PASSWORD", this.PrepareContext, null);
                    return;
                default:
                    this.presenter.getAuthRequestContext(str, AppUtil.MyBillsEntityDataFactory(getContext()));
                    return;
            }
        }
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public void showProgress() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.hideClose();
        this.progressBar.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.res_0x7f010050_kclassimpl_data_declarednonstaticmembers_2);
        loadAnimation.setInterpolator(new LinearInterpolator());
        this.icImageFg.setVisibility(0);
        this.icImageFg.startAnimation(loadAnimation);
        this.inputPin.setVisibility(8);
        this.btnShowHidePin.setVisibility(8);
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public void dismissProgress() {
        if (this.progressBar == null || this.icImageFg == null || this.inputPin == null || this.forgotPin == null) {
            return;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.showClose();
        this.progressBar.setVisibility(4);
        this.icImageFg.setVisibility(8);
        this.inputPin.setVisibility(0);
        this.forgotPin.setVisibility(0);
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public void onError(String str) {
        MyBillsEntityDataFactory(null, str, 0, "");
    }

    private void PlaceComponentResult(String str, String str2, String str3, boolean z, boolean z2) {
        this.forgotPin.setVisibility(4);
        if (z) {
            this.inputPin.setVisibility(4);
            Intent intent = new Intent();
            if (!TextUtils.isEmpty(str3)) {
                intent.putExtra(ChallengeControl.Key.CANCEL_REASON, str3);
            }
            if (!TextUtils.isEmpty(str)) {
                intent.putExtra("errorCode", str);
            }
            intent.putExtra("message", str2);
            getBaseActivity().setResult(0, intent);
            getBaseActivity().finish();
            return;
        }
        this.bottomMesageBlock.setVisibility(0);
        this.relativeWarningIcon.setVisibility(0);
        this.bottomMessage.setVisibility(0);
        TextUtil.getAuthRequestContext(this.bottomMessage, new ClickableSpan() { // from class: id.dana.challenge.pin.PinChallengeFragment.2
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                PinChallengeFragment.this.onTryAgain(view);
            }
        }, str2, getString(R.string.try_again));
        if (z2) {
            this.bottomTryAgain.setVisibility(8);
        } else {
            this.bottomTryAgain.setVisibility(4);
        }
        if (!this.GetContactSyncConfig.equals("face_activation") || getActivity() == null || z2) {
            return;
        }
        Intent intent2 = new Intent();
        intent2.putExtra(ChallengeControl.Key.CANCEL_REASON, "NETWORK_EXCEPTION");
        getActivity().setResult(0, intent2);
        getActivity().finish();
    }

    @OnClick({R.id.bottom_try_again})
    public void onTryAgain(View view) {
        this.successPin.setVisibility(4);
        this.relativeWarningIcon.setVisibility(4);
        this.bottomMessage.setVisibility(4);
        this.bottomTryAgain.setVisibility(4);
        this.bottomMesageBlock.setVisibility(4);
        this.inputPin.setText("");
        this.inputPin.setVisibility(0);
        this.inputPin.requestFocus();
        this.forgotPin.setVisibility(0);
        this.btnShowHidePin.setVisibility(0);
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.View
    public final void getAuthRequestContext() {
        if (getContext() == null || this.inputPin == null || this.forgotPin == null || this.successIcon == null || this.successPin == null) {
            return;
        }
        EventTracker.BuiltInFictitiousFunctionClassFactory(new RDSEvent("Onboarding", "rds_on_lost_focus", RDSConstant.INPUT_PIN_LOST_FOCUS, false));
        if ("login".equals(this.GetContactSyncConfig)) {
            DanaLog.KClassImpl$Data$declaredNonStaticMembers$2(LoginTrackingConstants.NormalLogin.SUCCESS_TO_HOME, "");
        }
        this.inputPin.setVisibility(4);
        this.forgotPin.setVisibility(4);
        this.successIcon.setVisibility(0);
        this.successPin.setVisibility(0);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.hideClose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.onNext(null, null);
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.View
    public final void BuiltInFictitiousFunctionClassFactory(List<String> list) {
        String str;
        if ("login".equals(this.GetContactSyncConfig)) {
            DanaLog.KClassImpl$Data$declaredNonStaticMembers$2(LoginTrackingConstants.NormalLogin.SUCCESS_TO_OTPLOGIN, "");
        }
        ChallengeScenarioListener challengeScenarioListener = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (list.size() <= 1 || !list.get(0).equals(VerifyMethod.CARRIER_IDENTIFICATION)) {
            str = (list.size() <= 1 || !list.get(0).equals(VerifyMethod.PUSH_VERIFY)) ? "Direct Challenge" : ChallengeEvent.OTPPurpose.PV_FAILOVER;
        } else {
            str = ChallengeEvent.OTPPurpose.PNV_FAILOVER;
        }
        challengeScenarioListener.onNext(list, str);
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.View
    public final void MyBillsEntityDataFactory(final String str, String str2) {
        final boolean MyBillsEntityDataFactory = AppUtil.MyBillsEntityDataFactory(getContext());
        this.botProtectionChallenge.get().getAuthRequestContext(getBaseActivity(), str2, new Function0() { // from class: id.dana.challenge.pin.PinChallengeFragment$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                PinChallengeFragment pinChallengeFragment = PinChallengeFragment.this;
                pinChallengeFragment.presenter.getAuthRequestContext(str, MyBillsEntityDataFactory);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.View
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2, Integer num, String str3, Integer num2) {
        MyBillsEntityDataFactory(str, str2, num, str3);
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.View
    public final void MyBillsEntityDataFactory(String str, String str2, Integer num, String str3) {
        String str4;
        String str5;
        boolean z;
        boolean z2;
        String replace;
        if (getContext() == null) {
            return;
        }
        String str6 = "";
        if (str == null) {
            replace = getContext().getText(R.string.challenge_error).toString();
        } else {
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -1814848530:
                    if (str.equals(ErrorCode.ERROR_CODE_DANA_ACCOUNT_FROZEN)) {
                        c = 0;
                        break;
                    }
                    break;
                case -1813066743:
                    if (str.equals(ErrorCode.DANA_PIN_NOT_EXIST)) {
                        c = 1;
                        break;
                    }
                    break;
                case -1813066739:
                    if (str.equals(ErrorCode.DANA_PIN_UNMATCHED)) {
                        c = 2;
                        break;
                    }
                    break;
                case -1813066738:
                    if (str.equals(ErrorCode.DANA_PIN_LOCKED)) {
                        c = 3;
                        break;
                    }
                    break;
                case -1813066736:
                    if (str.equals(ErrorCode.DANA_PIN_IDENTIFY_NOT_AVAILABLE)) {
                        c = 4;
                        break;
                    }
                    break;
                case 100204731:
                    if (str.equals(ErrorCode.SHOULD_CALL_CS_1)) {
                        c = 5;
                        break;
                    }
                    break;
                case 100205848:
                    if (str.equals(ErrorCode.SHOULD_CALL_CS_2)) {
                        c = 6;
                        break;
                    }
                    break;
                case 100205849:
                    if (str.equals(ErrorCode.SHOULD_CALL_CS_3)) {
                        c = 7;
                        break;
                    }
                    break;
                case 100205938:
                    if (str.equals(ErrorCode.SHOULD_CALL_CS_4)) {
                        c = '\b';
                        break;
                    }
                    break;
                case 279506736:
                    if (str.equals(ErrorCode.ERROR_CODE_DANA_PIN_OR_OTP_TEMPORARY_LOCK)) {
                        c = '\t';
                        break;
                    }
                    break;
                case 408588460:
                    if (str.equals(ErrorCode.SHOULD_CALL_CS_5)) {
                        c = '\n';
                        break;
                    }
                    break;
                case 408588464:
                    if (str.equals(ErrorCode.ERROR_CODE_DANA_PIN_TEMPORARY_LOCK_3)) {
                        c = 11;
                        break;
                    }
                    break;
                case 408588589:
                    if (str.equals(ErrorCode.ERROR_CODE_DANA_PIN_TEMPORARY_LOCK_1)) {
                        c = '\f';
                        break;
                    }
                    break;
                case 408594416:
                    if (str.equals(ErrorCode.PHONE_NUMBER_RISK_REJECTED)) {
                        c = '\r';
                        break;
                    }
                    break;
                case 995396396:
                    if (str.equals(ErrorCode.PENDING_TRANSACTION_IN_MERCHANT)) {
                        c = 14;
                        break;
                    }
                    break;
                case 1658411398:
                    if (str.equals("AE15002058020050")) {
                        c = 15;
                        break;
                    }
                    break;
            }
            switch (c) {
                case '\t':
                case 11:
                case '\f':
                    str6 = ChallengeControl.CancelReason.PIN_TEMPORARY_LOCKED;
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case '\b':
                case '\n':
                case '\r':
                case 14:
                    str4 = str2;
                    str5 = str6;
                    z = true;
                    z2 = false;
                    break;
                case 15:
                    replace = str2.replace("{{leftTimes}}", num.toString());
                    break;
                default:
                    replace = getContext().getText(R.string.msg_system_busy).toString();
                    break;
            }
            PlaceComponentResult(str, str4, str5, z, z2);
        }
        str4 = replace;
        str5 = "";
        z = false;
        z2 = true;
        PlaceComponentResult(str, str4, str5, z, z2);
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.View
    public final void BuiltInFictitiousFunctionClassFactory(boolean z) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = z;
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.View
    public final void PlaceComponentResult(int i) {
        String str;
        String str2;
        boolean z;
        String string = getString(R.string.msg_system_busy);
        if (i != 1001) {
            if (i == 1003) {
                str = "back";
                str2 = str;
                z = true;
                PlaceComponentResult(String.valueOf(i), string, str2, z, false);
            } else if (i != 1005 && i != 1006) {
                str2 = null;
                z = false;
                PlaceComponentResult(String.valueOf(i), string, str2, z, false);
            }
        }
        str = "error";
        str2 = str;
        z = true;
        PlaceComponentResult(String.valueOf(i), string, str2, z, false);
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.View
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        PlaceComponentResult(Result.ERROR_CODE_TIMEOUT, getContext() != null ? getContext().getString(R.string.msg_system_busy) : "", "back", true, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.presenter.MyBillsEntityDataFactory();
    }

    @OnClick({R.id.other_action})
    public void onForgotPin(View view) {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda2) {
            DanaH5.startContainerFullUrl(this.dynamicUrlWrapper.getForgotPinUrl());
            return;
        }
        String string = getContext().getString(R.string.option_call);
        new MaterialDialog(requireContext(), MaterialDialog.getDEFAULT_BEHAVIOR()).cancelOnTouchOutside(false).message(Integer.valueOf((int) R.string.call_customer_question), null, null).positiveButton(null, string, new Function1() { // from class: id.dana.challenge.pin.PinChallengeFragment$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                MaterialDialog materialDialog = (MaterialDialog) obj;
                PinChallengeFragment.this.KClassImpl$Data$declaredNonStaticMembers$2.check();
                return null;
            }
        }).negativeButton(null, getContext().getString(R.string.option_cancel), null).show();
    }

    @OnClick({R.id.res_0x7f0a0208_networkuserentitydata_externalsyntheticlambda0})
    public void showHidePin() {
        if (this.btnShowHidePin.getText().toString().equals(getString(R.string.show_pin))) {
            this.inputPin.showCharacters();
            this.btnShowHidePin.setText(getString(R.string.hide_pin));
            return;
        }
        this.inputPin.hideCharacters();
        this.btnShowHidePin.setText(getString(R.string.show_pin));
    }
}
