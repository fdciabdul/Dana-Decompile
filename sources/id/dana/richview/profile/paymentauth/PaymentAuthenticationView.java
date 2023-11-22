package id.dana.richview.profile.paymentauth;

import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.text.HtmlCompat;
import butterknife.BindView;
import butterknife.OnClick;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonScreen;
import com.ethanhua.skeleton.ViewSkeletonScreen;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.challenge.ChallengeControl;
import id.dana.danah5.DanaH5;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerPaymentAuthenticationComponent;
import id.dana.di.modules.PaymentAuthenticationModule;
import id.dana.dialog.DanaLoadingDialog;
import id.dana.dialog.DialogWithImage;
import id.dana.myprofile.SettingMoreProfileActivity;
import id.dana.myprofile.model.PaymentSecurityInitModel;
import id.dana.myprofile.model.PaymentSecuritySwitchModel;
import id.dana.richview.profile.paymentauth.PaymentAuthenticationContract;
import id.dana.utils.CustomToastUtil;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class PaymentAuthenticationView extends BaseRichView implements PaymentAuthenticationContract.View {
    public static final int REQUEST_CODE_PHONE_PERMISSION = 1002;
    private SkeletonScreen BuiltInFictitiousFunctionClassFactory;
    private DanaLoadingDialog MyBillsEntityDataFactory;
    private String PlaceComponentResult;
    @BindView(R.id.f3679cl_payment_auth)
    ConstraintLayout clContainerPaymentAuth;
    @BindView(R.id.view_dana_protection)
    ImageView ivDanaProtection;
    @Inject
    PaymentAuthenticationContract.Presenter presenter;
    @BindView(R.id.switch_button)
    SwitchCompat switchButton;
    @BindView(R.id.tv_subtitle)
    TextView tvSubtitle;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    @Override // id.dana.base.BaseRichView
    public int getLayout() {
        return R.layout.authentication_payment_view;
    }

    public PaymentAuthenticationView(Context context) {
        super(context);
    }

    public PaymentAuthenticationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PaymentAuthenticationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // id.dana.base.BaseRichView
    public void init(Context context, AttributeSet attributeSet, boolean z) {
        super.init(context, attributeSet, z);
        this.switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: id.dana.richview.profile.paymentauth.PaymentAuthenticationView$$ExternalSyntheticLambda0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                PaymentAuthenticationView.this.m2848xc1ebe61a(compoundButton, z2);
            }
        });
        ((SettingMoreProfileActivity) getBaseActivity()).setPaymentAuthListener(new SettingMoreProfileActivity.Listener() { // from class: id.dana.richview.profile.paymentauth.PaymentAuthenticationView.1
            @Override // id.dana.myprofile.SettingMoreProfileActivity.Listener
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                PaymentAuthenticationView.access$000(PaymentAuthenticationView.this);
            }

            @Override // id.dana.myprofile.SettingMoreProfileActivity.Listener
            public final void BuiltInFictitiousFunctionClassFactory(String str) {
                if (ChallengeControl.CancelReason.PIN_TEMPORARY_LOCKED.equals(str)) {
                    PaymentAuthenticationView.access$100(PaymentAuthenticationView.this);
                } else if ("forgot_pin".equals(str)) {
                    PaymentAuthenticationView.access$200(PaymentAuthenticationView.this).getPhonePermission().check();
                }
                PaymentAuthenticationView.this.paymentSwitchState(true);
                PaymentAuthenticationView.access$300(PaymentAuthenticationView.this);
            }
        });
    }

    @Override // id.dana.base.BaseRichView
    public void injectComponent(ApplicationComponent applicationComponent) {
        DaggerPaymentAuthenticationComponent.Builder BuiltInFictitiousFunctionClassFactory = DaggerPaymentAuthenticationComponent.BuiltInFictitiousFunctionClassFactory();
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = (PaymentAuthenticationModule) Preconditions.getAuthRequestContext(new PaymentAuthenticationModule(this));
        BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory().BuiltInFictitiousFunctionClassFactory(this);
        registerPresenter(this.presenter);
    }

    @Override // id.dana.base.BaseRichView
    public void injected(boolean z) {
        if (z) {
            this.presenter.BuiltInFictitiousFunctionClassFactory();
        }
    }

    @OnClick({R.id.f3652cl_dana_protection})
    public void onClDanaProtectionClick() {
        DanaH5.startContainerFullUrl("https://m.dana.id/m/standalone/protection");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onSwitchCheckedChanged$0$id-dana-richview-profile-paymentauth-PaymentAuthenticationView  reason: not valid java name */
    public /* synthetic */ void m2848xc1ebe61a(CompoundButton compoundButton, boolean z) {
        this.switchButton.setThumbTintList(getResources().getColorStateList(R.color.colorWhite));
        if (z) {
            this.switchButton.setTrackTintList(getResources().getColorStateList(R.color.azure));
        } else {
            this.switchButton.setTrackTintList(getResources().getColorStateList(R.color.f27012131100470));
        }
        if (compoundButton.getTag() == null) {
            this.presenter.PlaceComponentResult(this.switchButton.isChecked(), this.PlaceComponentResult);
        }
    }

    public void setTitle(String str) {
        this.tvTitle.setText(str);
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public void onError(String str) {
        showWarningDialog(str);
    }

    @Override // id.dana.richview.profile.paymentauth.PaymentAuthenticationContract.View
    public void onSuccessInitPaymentControl(PaymentSecurityInitModel paymentSecurityInitModel) {
        if (paymentSecurityInitModel != null && paymentSecurityInitModel.KClassImpl$Data$declaredNonStaticMembers$2()) {
            this.PlaceComponentResult = paymentSecurityInitModel.BuiltInFictitiousFunctionClassFactory;
            this.clContainerPaymentAuth.setVisibility(0);
            this.switchButton.setTag(IAPSyncCommand.COMMAND_INIT);
            this.switchButton.setChecked(paymentSecurityInitModel.BuiltInFictitiousFunctionClassFactory());
            this.switchButton.setTag(null);
            return;
        }
        this.clContainerPaymentAuth.setVisibility(8);
    }

    @Override // id.dana.richview.profile.paymentauth.PaymentAuthenticationContract.View
    public void showSwitchLoading() {
        if (getBaseActivity() != null) {
            DanaLoadingDialog danaLoadingDialog = new DanaLoadingDialog(getBaseActivity());
            this.MyBillsEntityDataFactory = danaLoadingDialog;
            if (danaLoadingDialog.MyBillsEntityDataFactory.isShowing()) {
                return;
            }
            danaLoadingDialog.MyBillsEntityDataFactory.show();
            danaLoadingDialog.getAuthRequestContext.startRefresh();
        }
    }

    @Override // id.dana.richview.profile.paymentauth.PaymentAuthenticationContract.View
    public void dismissSwitchLoading() {
        DanaLoadingDialog danaLoadingDialog = this.MyBillsEntityDataFactory;
        if (danaLoadingDialog != null) {
            danaLoadingDialog.PlaceComponentResult();
        }
    }

    @Override // id.dana.richview.profile.paymentauth.PaymentAuthenticationContract.View
    public void challengePassword(PaymentSecuritySwitchModel paymentSecuritySwitchModel) {
        ChallengeControl.Builder builder = new ChallengeControl.Builder(getBaseActivity());
        builder.scheduleImpl = "payment_auth";
        builder.VerifyPinStateManager$executeRiskChallenge$2$1 = "payment_auth";
        new ChallengeControl(builder.getAuthRequestContext(this.switchButton.isChecked(), paymentSecuritySwitchModel), null).getAuthRequestContext();
    }

    public void paymentSwitchState(boolean z) {
        SwitchCompat switchCompat = this.switchButton;
        if (switchCompat != null) {
            switchCompat.setTag(IAPSyncCommand.COMMAND_INIT);
            this.switchButton.setChecked(z);
            this.switchButton.setTag(null);
        }
    }

    static /* synthetic */ void access$000(PaymentAuthenticationView paymentAuthenticationView) {
        CustomToastUtil.getAuthRequestContext(paymentAuthenticationView.getBaseActivity(), R.drawable.ic_success, paymentAuthenticationView.getContext().getString(R.string.msg_payment_authentication_success));
    }

    static /* synthetic */ void access$100(final PaymentAuthenticationView paymentAuthenticationView) {
        DialogWithImage.BuiltInFictitiousFunctionClassFactory(paymentAuthenticationView.getBaseActivity(), new DialogInterface.OnClickListener() { // from class: id.dana.richview.profile.paymentauth.PaymentAuthenticationView$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                PaymentAuthenticationView.this.m2847x72fabe1c(dialogInterface, i);
            }
        }).MyBillsEntityDataFactory();
    }

    static /* synthetic */ SettingMoreProfileActivity access$200(PaymentAuthenticationView paymentAuthenticationView) {
        return (SettingMoreProfileActivity) paymentAuthenticationView.getBaseActivity();
    }

    static /* synthetic */ void access$300(PaymentAuthenticationView paymentAuthenticationView) {
        CustomToastUtil.getAuthRequestContext(paymentAuthenticationView.getBaseActivity(), R.drawable.ic_close_red, paymentAuthenticationView.getContext().getString(R.string.msg_payment_authentication_failed));
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public void dismissProgress() {
        SkeletonScreen skeletonScreen = this.BuiltInFictitiousFunctionClassFactory;
        if (skeletonScreen != null) {
            skeletonScreen.PlaceComponentResult();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getPinLockedListener$1$id-dana-richview-profile-paymentauth-PaymentAuthenticationView  reason: not valid java name */
    public /* synthetic */ void m2847x72fabe1c(DialogInterface dialogInterface, int i) {
        if (i != -2) {
            if (i != -1) {
                return;
            }
            ((SettingMoreProfileActivity) getBaseActivity()).getPhonePermission().check();
        }
        dialogInterface.dismiss();
    }

    @Override // id.dana.richview.profile.paymentauth.PaymentAuthenticationContract.View
    public void onErrorInitPaymentAuth() {
        SkeletonScreen skeletonScreen = this.BuiltInFictitiousFunctionClassFactory;
        if (skeletonScreen != null) {
            skeletonScreen.PlaceComponentResult();
        }
        this.clContainerPaymentAuth.setVisibility(8);
    }

    @Override // id.dana.richview.profile.paymentauth.PaymentAuthenticationContract.View
    public void onErrorSwitchPaymentAuth() {
        CustomToastUtil.getAuthRequestContext(getBaseActivity(), R.drawable.ic_close_red, getContext().getString(R.string.msg_payment_authentication_failed));
        paymentSwitchState(false);
    }

    @Override // id.dana.richview.profile.paymentauth.PaymentAuthenticationContract.View
    public void onSuccesSwitchPaymentControl(PaymentSecuritySwitchModel paymentSecuritySwitchModel) {
        CustomToastUtil.getAuthRequestContext(getBaseActivity(), R.drawable.ic_success, getContext().getString(R.string.msg_payment_authentication_success));
    }

    @Override // id.dana.base.BaseRichView
    public void setup() {
        this.tvSubtitle.setText(HtmlCompat.PlaceComponentResult(getContext().getString(R.string.description_auth_payment), 0));
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public void showProgress() {
        SkeletonScreen skeletonScreen = this.BuiltInFictitiousFunctionClassFactory;
        if (skeletonScreen == null) {
            ViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory(this.clContainerPaymentAuth);
            BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = R.layout.view_switch_button_skeleton;
            BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = 20;
            BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = 1500;
            BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.lookAheadTest.getContext(), R.color.f27082131100491);
            BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = 20;
            ViewSkeletonScreen viewSkeletonScreen = new ViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory, (byte) 0);
            viewSkeletonScreen.MyBillsEntityDataFactory();
            this.BuiltInFictitiousFunctionClassFactory = viewSkeletonScreen;
            return;
        }
        skeletonScreen.MyBillsEntityDataFactory();
    }
}
