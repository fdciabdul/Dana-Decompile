package id.dana.myprofile.mepagerevamp.smartpay.view;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import com.alibaba.ariver.kernel.RVEvents;
import com.alibaba.griver.api.constants.GriverEvents;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonScreen;
import com.ethanhua.skeleton.ViewSkeletonScreen;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.BaseActivity;
import id.dana.base.BaseRichView;
import id.dana.challenge.ChallengeControl;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerPaymentAuthenticationComponent;
import id.dana.di.modules.PaymentAuthenticationModule;
import id.dana.dialog.DanaLoadingDialog;
import id.dana.dialog.DialogWithImage;
import id.dana.myprofile.mepagerevamp.smartpay.SmartPayActivity;
import id.dana.myprofile.model.PaymentSecurityInitModel;
import id.dana.myprofile.model.PaymentSecuritySwitchModel;
import id.dana.richview.profile.paymentauth.PaymentAuthenticationContract;
import id.dana.utils.CustomToastUtil;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 B2\u00020\u00012\u00020\u0002:\u0001BB'\b\u0016\u0012\u0006\u0010:\u001a\u000209\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010;\u0012\b\b\u0002\u0010=\u001a\u00020\u000b¢\u0006\u0004\b>\u0010?B+\b\u0016\u0012\u0006\u0010:\u001a\u000209\u0012\b\u0010<\u001a\u0004\u0018\u00010;\u0012\u0006\u0010=\u001a\u00020\u000b\u0012\u0006\u0010@\u001a\u00020\u000b¢\u0006\u0004\b>\u0010AJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001a\u0010\tJ\u000f\u0010\u001b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001b\u0010\tJ\u0017\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001c\u0010\u0007J\u0017\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010\"\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0012¢\u0006\u0004\b\"\u0010\u0015J\u0017\u0010$\u001a\u00020\u00052\b\u0010#\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b$\u0010\u0019J\u000f\u0010%\u001a\u00020\u0005H\u0016¢\u0006\u0004\b%\u0010\tJ\u000f\u0010&\u001a\u00020\u0005H\u0002¢\u0006\u0004\b&\u0010\tJ\u000f\u0010'\u001a\u00020\u0005H\u0016¢\u0006\u0004\b'\u0010\tJ\u000f\u0010(\u001a\u00020\u0005H\u0002¢\u0006\u0004\b(\u0010\tJ\u000f\u0010)\u001a\u00020\u0005H\u0016¢\u0006\u0004\b)\u0010\tR\u0018\u0010(\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010&\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\"\u00100\u001a\u00020/8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0018\u00108\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b(\u00107"}, d2 = {"Lid/dana/myprofile/mepagerevamp/smartpay/view/NewPaymentAuthenticationView;", "Lid/dana/base/BaseRichView;", "Lid/dana/richview/profile/paymentauth/PaymentAuthenticationContract$View;", "Lid/dana/myprofile/model/PaymentSecuritySwitchModel;", "paymentSecuritySwitchModel", "", "challengePassword", "(Lid/dana/myprofile/model/PaymentSecuritySwitchModel;)V", "dismissProgress", "()V", "dismissSwitchLoading", "", "getLayout", "()I", "Lid/dana/di/component/ApplicationComponent;", "applicationComponent", "injectComponent", "(Lid/dana/di/component/ApplicationComponent;)V", "", "isInjected", "injected", "(Z)V", "", "errorMessage", RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, "(Ljava/lang/String;)V", "onErrorInitPaymentAuth", "onErrorSwitchPaymentAuth", "onSuccesSwitchPaymentControl", "Lid/dana/myprofile/model/PaymentSecurityInitModel;", "paymentSecurityInitModel", "onSuccessInitPaymentControl", "(Lid/dana/myprofile/model/PaymentSecurityInitModel;)V", "state", "paymentSwitchState", "title", GriverEvents.EVENT_SET_TITLE, "setup", "PlaceComponentResult", "showProgress", "BuiltInFictitiousFunctionClassFactory", "showSwitchLoading", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "Lid/dana/dialog/DanaLoadingDialog;", "MyBillsEntityDataFactory", "Lid/dana/dialog/DanaLoadingDialog;", "Lid/dana/richview/profile/paymentauth/PaymentAuthenticationContract$Presenter;", "presenter", "Lid/dana/richview/profile/paymentauth/PaymentAuthenticationContract$Presenter;", "getPresenter", "()Lid/dana/richview/profile/paymentauth/PaymentAuthenticationContract$Presenter;", "setPresenter", "(Lid/dana/richview/profile/paymentauth/PaymentAuthenticationContract$Presenter;)V", "Lcom/ethanhua/skeleton/SkeletonScreen;", "Lcom/ethanhua/skeleton/SkeletonScreen;", "getAuthRequestContext", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NewPaymentAuthenticationView extends BaseRichView implements PaymentAuthenticationContract.View {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private SkeletonScreen getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private DanaLoadingDialog PlaceComponentResult;
    public Map<Integer, View> _$_findViewCache;
    @Inject
    public PaymentAuthenticationContract.Presenter presenter;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NewPaymentAuthenticationView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NewPaymentAuthenticationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public final View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            if (findViewById != null) {
                map.put(Integer.valueOf(i), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    @Override // id.dana.base.BaseRichView
    public final int getLayout() {
        return R.layout.new_authentication_payment_view;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewPaymentAuthenticationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ NewPaymentAuthenticationView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewPaymentAuthenticationView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    @JvmName(name = "getPresenter")
    public final PaymentAuthenticationContract.Presenter getPresenter() {
        PaymentAuthenticationContract.Presenter presenter = this.presenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setPresenter")
    public final void setPresenter(PaymentAuthenticationContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.presenter = presenter;
    }

    @Override // id.dana.base.BaseRichView
    public final void injectComponent(ApplicationComponent applicationComponent) {
        Intrinsics.checkNotNullParameter(applicationComponent, "");
        DaggerPaymentAuthenticationComponent.Builder BuiltInFictitiousFunctionClassFactory = DaggerPaymentAuthenticationComponent.BuiltInFictitiousFunctionClassFactory();
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = (PaymentAuthenticationModule) Preconditions.getAuthRequestContext(new PaymentAuthenticationModule(this));
        BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory().BuiltInFictitiousFunctionClassFactory(this);
        registerPresenter(getPresenter());
    }

    @Override // id.dana.base.BaseRichView
    public final void injected(boolean isInjected) {
        if (isInjected) {
            getPresenter().BuiltInFictitiousFunctionClassFactory();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void BuiltInFictitiousFunctionClassFactory() {
        BaseActivity baseActivity = getBaseActivity();
        Intrinsics.checkNotNullExpressionValue(baseActivity, "");
        CustomToastUtil.PlaceComponentResult(baseActivity, R.drawable.ic_success, R.drawable.bg_rounded_toast_payment_auth, getContext().getString(R.string.msg_payment_authentication_success), 48, 60, false, null, 384);
    }

    public final void setTitle(String title) {
        AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.setDrawValueAboveBar);
        if (appCompatTextView != null) {
            appCompatTextView.setText(title);
        }
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public final void onError(String errorMessage) {
        Intrinsics.checkNotNullParameter(errorMessage, "");
        showWarningDialog(errorMessage);
    }

    @Override // id.dana.richview.profile.paymentauth.PaymentAuthenticationContract.View
    public final void onSuccesSwitchPaymentControl(PaymentSecuritySwitchModel paymentSecuritySwitchModel) {
        Intrinsics.checkNotNullParameter(paymentSecuritySwitchModel, "");
        BuiltInFictitiousFunctionClassFactory();
    }

    @Override // id.dana.richview.profile.paymentauth.PaymentAuthenticationContract.View
    public final void onSuccessInitPaymentControl(PaymentSecurityInitModel paymentSecurityInitModel) {
        Intrinsics.checkNotNullParameter(paymentSecurityInitModel, "");
        if (paymentSecurityInitModel.KClassImpl$Data$declaredNonStaticMembers$2()) {
            this.BuiltInFictitiousFunctionClassFactory = paymentSecurityInitModel.BuiltInFictitiousFunctionClassFactory;
            ((ConstraintLayout) _$_findCachedViewById(R.id.cl_payment_auth)).setVisibility(0);
            ((SwitchCompat) _$_findCachedViewById(R.id.GroupDetailUiState$OnSuccessGetLeastTransactionFavoriteAccount)).setTag(IAPSyncCommand.COMMAND_INIT);
            ((SwitchCompat) _$_findCachedViewById(R.id.GroupDetailUiState$OnSuccessGetLeastTransactionFavoriteAccount)).setChecked(paymentSecurityInitModel.BuiltInFictitiousFunctionClassFactory());
            ((SwitchCompat) _$_findCachedViewById(R.id.GroupDetailUiState$OnSuccessGetLeastTransactionFavoriteAccount)).setTag(null);
            return;
        }
        ((ConstraintLayout) _$_findCachedViewById(R.id.cl_payment_auth)).setVisibility(8);
    }

    @Override // id.dana.richview.profile.paymentauth.PaymentAuthenticationContract.View
    public final void showSwitchLoading() {
        if (getBaseActivity() != null) {
            DanaLoadingDialog danaLoadingDialog = new DanaLoadingDialog(getBaseActivity());
            this.PlaceComponentResult = danaLoadingDialog;
            Intrinsics.checkNotNull(danaLoadingDialog);
            if (danaLoadingDialog.MyBillsEntityDataFactory.isShowing()) {
                return;
            }
            danaLoadingDialog.MyBillsEntityDataFactory.show();
            danaLoadingDialog.getAuthRequestContext.startRefresh();
        }
    }

    @Override // id.dana.richview.profile.paymentauth.PaymentAuthenticationContract.View
    public final void dismissSwitchLoading() {
        DanaLoadingDialog danaLoadingDialog = this.PlaceComponentResult;
        if (danaLoadingDialog != null) {
            Intrinsics.checkNotNull(danaLoadingDialog);
            danaLoadingDialog.PlaceComponentResult();
        }
    }

    @Override // id.dana.richview.profile.paymentauth.PaymentAuthenticationContract.View
    public final void challengePassword(PaymentSecuritySwitchModel paymentSecuritySwitchModel) {
        Intrinsics.checkNotNullParameter(paymentSecuritySwitchModel, "");
        BaseActivity baseActivity = getBaseActivity();
        Intrinsics.checkNotNullExpressionValue(baseActivity, "");
        ChallengeControl.Builder builder = new ChallengeControl.Builder(baseActivity);
        builder.scheduleImpl = "payment_auth";
        builder.VerifyPinStateManager$executeRiskChallenge$2$1 = "payment_auth";
        new ChallengeControl(builder.getAuthRequestContext(((SwitchCompat) _$_findCachedViewById(R.id.GroupDetailUiState$OnSuccessGetLeastTransactionFavoriteAccount)).isChecked(), paymentSecuritySwitchModel), null).getAuthRequestContext();
    }

    @Override // id.dana.richview.profile.paymentauth.PaymentAuthenticationContract.View
    public final void onErrorSwitchPaymentAuth() {
        PlaceComponentResult();
        paymentSwitchState(false);
    }

    public final void paymentSwitchState(boolean state) {
        if (((SwitchCompat) _$_findCachedViewById(R.id.GroupDetailUiState$OnSuccessGetLeastTransactionFavoriteAccount)) != null) {
            ((SwitchCompat) _$_findCachedViewById(R.id.GroupDetailUiState$OnSuccessGetLeastTransactionFavoriteAccount)).setTag(IAPSyncCommand.COMMAND_INIT);
            ((SwitchCompat) _$_findCachedViewById(R.id.GroupDetailUiState$OnSuccessGetLeastTransactionFavoriteAccount)).setChecked(state);
            ((SwitchCompat) _$_findCachedViewById(R.id.GroupDetailUiState$OnSuccessGetLeastTransactionFavoriteAccount)).setTag(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void PlaceComponentResult() {
        BaseActivity baseActivity = getBaseActivity();
        Intrinsics.checkNotNullExpressionValue(baseActivity, "");
        CustomToastUtil.PlaceComponentResult(baseActivity, R.drawable.ic_close_red, R.drawable.bg_rounded_toast_payment_auth, getContext().getString(R.string.msg_payment_authentication_failed), 48, 60, false, null, 384);
    }

    public static /* synthetic */ void $r8$lambda$5XhHUY2Cv656ivmtSc_tYD9jFDc(NewPaymentAuthenticationView newPaymentAuthenticationView, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(newPaymentAuthenticationView, "");
        Intrinsics.checkNotNullParameter(dialogInterface, "");
        if (i != -2) {
            if (i != -1) {
                return;
            }
            BaseActivity baseActivity = newPaymentAuthenticationView.getBaseActivity();
            if (baseActivity != null) {
                ((SmartPayActivity) baseActivity).getPhonePermission().check();
            } else {
                throw new NullPointerException("null cannot be cast to non-null type id.dana.myprofile.mepagerevamp.smartpay.SmartPayActivity");
            }
        }
        dialogInterface.dismiss();
    }

    public static /* synthetic */ void $r8$lambda$tWHbYDatqBxZx_ob4Td_ihrMnrc(NewPaymentAuthenticationView newPaymentAuthenticationView, CompoundButton compoundButton, boolean z) {
        ColorStateList KClassImpl$Data$declaredNonStaticMembers$2;
        ColorStateList KClassImpl$Data$declaredNonStaticMembers$22;
        ColorStateList KClassImpl$Data$declaredNonStaticMembers$23;
        Intrinsics.checkNotNullParameter(newPaymentAuthenticationView, "");
        Intrinsics.checkNotNullParameter(compoundButton, "");
        SwitchCompat switchCompat = (SwitchCompat) newPaymentAuthenticationView._$_findCachedViewById(R.id.GroupDetailUiState$OnSuccessGetLeastTransactionFavoriteAccount);
        KClassImpl$Data$declaredNonStaticMembers$2 = ResourcesCompat.KClassImpl$Data$declaredNonStaticMembers$2(r1.getResources(), R.color.colorWhite, newPaymentAuthenticationView.getContext().getTheme());
        switchCompat.setThumbTintList(KClassImpl$Data$declaredNonStaticMembers$2);
        if (z) {
            SwitchCompat switchCompat2 = (SwitchCompat) newPaymentAuthenticationView._$_findCachedViewById(R.id.GroupDetailUiState$OnSuccessGetLeastTransactionFavoriteAccount);
            KClassImpl$Data$declaredNonStaticMembers$23 = ResourcesCompat.KClassImpl$Data$declaredNonStaticMembers$2(r0.getResources(), R.color.azure, newPaymentAuthenticationView.getContext().getTheme());
            switchCompat2.setTrackTintList(KClassImpl$Data$declaredNonStaticMembers$23);
        } else {
            SwitchCompat switchCompat3 = (SwitchCompat) newPaymentAuthenticationView._$_findCachedViewById(R.id.GroupDetailUiState$OnSuccessGetLeastTransactionFavoriteAccount);
            KClassImpl$Data$declaredNonStaticMembers$22 = ResourcesCompat.KClassImpl$Data$declaredNonStaticMembers$2(r0.getResources(), R.color.f27012131100470, newPaymentAuthenticationView.getContext().getTheme());
            switchCompat3.setTrackTintList(KClassImpl$Data$declaredNonStaticMembers$22);
        }
        if (compoundButton.getTag() == null) {
            newPaymentAuthenticationView.getPresenter().PlaceComponentResult(((SwitchCompat) newPaymentAuthenticationView._$_findCachedViewById(R.id.GroupDetailUiState$OnSuccessGetLeastTransactionFavoriteAccount)).isChecked(), newPaymentAuthenticationView.BuiltInFictitiousFunctionClassFactory);
        }
    }

    public static final /* synthetic */ SmartPayActivity access$getSmartPayActivity(NewPaymentAuthenticationView newPaymentAuthenticationView) {
        BaseActivity baseActivity = newPaymentAuthenticationView.getBaseActivity();
        if (baseActivity != null) {
            return (SmartPayActivity) baseActivity;
        }
        throw new NullPointerException("null cannot be cast to non-null type id.dana.myprofile.mepagerevamp.smartpay.SmartPayActivity");
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public final void dismissProgress() {
        SkeletonScreen skeletonScreen = this.getAuthRequestContext;
        if (skeletonScreen != null) {
            Intrinsics.checkNotNull(skeletonScreen);
            skeletonScreen.PlaceComponentResult();
        }
    }

    @Override // id.dana.richview.profile.paymentauth.PaymentAuthenticationContract.View
    public final void onErrorInitPaymentAuth() {
        SkeletonScreen skeletonScreen = this.getAuthRequestContext;
        if (skeletonScreen != null) {
            Intrinsics.checkNotNull(skeletonScreen);
            skeletonScreen.PlaceComponentResult();
        }
        ((ConstraintLayout) _$_findCachedViewById(R.id.cl_payment_auth)).setVisibility(8);
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        ((SwitchCompat) _$_findCachedViewById(R.id.GroupDetailUiState$OnSuccessGetLeastTransactionFavoriteAccount)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: id.dana.myprofile.mepagerevamp.smartpay.view.NewPaymentAuthenticationView$$ExternalSyntheticLambda1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                NewPaymentAuthenticationView.$r8$lambda$tWHbYDatqBxZx_ob4Td_ihrMnrc(NewPaymentAuthenticationView.this, compoundButton, z);
            }
        });
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity != null) {
            ((SmartPayActivity) baseActivity).setPaymentAuthListener(new SmartPayActivity.Listener() { // from class: id.dana.myprofile.mepagerevamp.smartpay.view.NewPaymentAuthenticationView$activityResultRendering$1
                @Override // id.dana.myprofile.mepagerevamp.smartpay.SmartPayActivity.Listener
                public final void KClassImpl$Data$declaredNonStaticMembers$2(Bundle p0) {
                    NewPaymentAuthenticationView.this.BuiltInFictitiousFunctionClassFactory();
                }

                @Override // id.dana.myprofile.mepagerevamp.smartpay.SmartPayActivity.Listener
                public final void MyBillsEntityDataFactory(String p0) {
                    if (!Intrinsics.areEqual(ChallengeControl.CancelReason.PIN_TEMPORARY_LOCKED, p0)) {
                        if (Intrinsics.areEqual("forgot_pin", p0)) {
                            NewPaymentAuthenticationView.access$getSmartPayActivity(NewPaymentAuthenticationView.this).getPhonePermission().check();
                        }
                    } else {
                        DialogWithImage.BuiltInFictitiousFunctionClassFactory(r2.getBaseActivity(), new DialogInterface.OnClickListener() { // from class: id.dana.myprofile.mepagerevamp.smartpay.view.NewPaymentAuthenticationView$$ExternalSyntheticLambda0
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                NewPaymentAuthenticationView.$r8$lambda$5XhHUY2Cv656ivmtSc_tYD9jFDc(NewPaymentAuthenticationView.this, dialogInterface, i);
                            }
                        }).MyBillsEntityDataFactory();
                    }
                    NewPaymentAuthenticationView.this.paymentSwitchState(true);
                    NewPaymentAuthenticationView.this.PlaceComponentResult();
                }
            });
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type id.dana.myprofile.mepagerevamp.smartpay.SmartPayActivity");
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public final void showProgress() {
        SkeletonScreen skeletonScreen = this.getAuthRequestContext;
        if (skeletonScreen == null) {
            ViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory((ConstraintLayout) _$_findCachedViewById(R.id.cl_payment_auth));
            BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = R.layout.view_switch_button_skeleton;
            BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = 20;
            BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = 1500;
            BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.lookAheadTest.getContext(), R.color.f27082131100491);
            BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = 20;
            Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
            ViewSkeletonScreen viewSkeletonScreen = new ViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory, (byte) 0);
            viewSkeletonScreen.MyBillsEntityDataFactory();
            this.getAuthRequestContext = viewSkeletonScreen;
            return;
        }
        Intrinsics.checkNotNull(skeletonScreen);
        skeletonScreen.MyBillsEntityDataFactory();
    }
}
