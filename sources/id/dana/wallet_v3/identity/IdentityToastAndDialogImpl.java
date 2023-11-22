package id.dana.wallet_v3.identity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.view.DefaultLifecycleObserver;
import androidx.view.LifecycleOwner;
import com.afollestad.materialdialogs.MaterialDialog;
import id.dana.R;
import id.dana.base.BaseActivity;
import id.dana.base.BaseFragment;
import id.dana.component.customsnackbarcomponent.CustomSnackbar;
import id.dana.component.dialogcomponent.CustomDialog;
import id.dana.core.ui.constant.DialogType;
import id.dana.core.ui.util.DANAToast;
import id.dana.danah5.DanaH5;
import id.dana.data.constant.DanaUrl;
import id.dana.dialog.LoginInfoDialog;
import id.dana.dialog.TwoButtonWithImageDialog;
import id.dana.extension.view.ViewExtKt;
import id.dana.riskChallenges.ui.resetpin.model.UseCaseStrategy;
import id.dana.riskChallenges.ui.util.uicomponent.UIComponentType;
import id.dana.riskChallenges.ui.util.uicomponent.UiComponent;
import id.dana.riskChallenges.ui.verifypin.VerifyPinLauncher;
import id.dana.utils.UrlUtil;
import id.dana.wallet_v3.identity.presenter.PersonalPresenter;
import id.dana.wallet_v3.identity.view.KtpDetailActivity;
import id.dana.wallet_v3.view.NewWalletFragment;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 U2\u00020\u00012\u00020\u0002:\u0001UB\u000f\u0012\u0006\u0010B\u001a\u00020A¢\u0006\u0004\bS\u0010TJ9\u0010\n\u001a\u00020\b2\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001f\u0010\u001eJ\u000f\u0010 \u001a\u00020\bH\u0016¢\u0006\u0004\b \u0010!J]\u0010*\u001a\u00020\b2\u001a\u0010%\u001a\u0016\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\b\u0018\u00010\"j\u0004\u0018\u0001`$2\u001a\u0010'\u001a\u0016\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\b\u0018\u00010\"j\u0004\u0018\u0001`&2\u0014\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\u0004\u0018\u0001`(H\u0016¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\bH\u0016¢\u0006\u0004\b,\u0010!J\u000f\u0010-\u001a\u00020\bH\u0016¢\u0006\u0004\b-\u0010!J\u000f\u0010.\u001a\u00020\bH\u0002¢\u0006\u0004\b.\u0010!J\u001d\u0010/\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002¢\u0006\u0004\b/\u00100J!\u00105\u001a\u00020\b2\b\u00102\u001a\u0004\u0018\u0001012\u0006\u00104\u001a\u000203H\u0002¢\u0006\u0004\b5\u00106J\u0017\u00107\u001a\u00020\b2\u0006\u00104\u001a\u000203H\u0016¢\u0006\u0004\b7\u00108R\u0016\u0010<\u001a\u0004\u0018\u0001098CX\u0082\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;R$\u0010=\u001a\u0010\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\u0004\u0018\u0001`(8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b=\u0010>R*\u0010?\u001a\u0016\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\b\u0018\u00010\"j\u0004\u0018\u0001`&8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010B\u001a\u00020A8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010E\u001a\u00020D8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bE\u0010FR*\u0010G\u001a\u0016\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\b\u0018\u00010\"j\u0004\u0018\u0001`$8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bG\u0010@R\u001b\u0010M\u001a\u00020H8CX\u0083\u0084\u0002¢\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010LR\u001b\u0010R\u001a\u00020N8CX\u0083\u0084\u0002¢\u0006\f\n\u0004\bO\u0010J\u001a\u0004\bP\u0010Q"}, d2 = {"Lid/dana/wallet_v3/identity/IdentityToastAndDialogImpl;", "Lid/dana/wallet_v3/identity/IdentityToastAndDialog;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "", "", "extendInfo", "kycLandingPage", "Lkotlin/Function0;", "", "acceptConsentAction", "checkKYCStatusAndCertType", "(Ljava/util/Map;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "Landroid/text/style/ClickableSpan;", "getClickableSpan", "()Landroid/text/style/ClickableSpan;", "fullText", "", "startHighlightedText", "stopHighlightedText", "Landroid/text/SpannableString;", "getSpannableString", "(Ljava/lang/String;II)Landroid/text/SpannableString;", "Landroid/text/Spannable;", "getTncSpannable", "()Landroid/text/Spannable;", "goToKycLandingPage", "(Ljava/lang/String;)V", "Landroidx/lifecycle/LifecycleOwner;", "owner", "onCreate", "(Landroidx/lifecycle/LifecycleOwner;)V", "onDestroy", "openPinChallenge", "()V", "Lkotlin/Function1;", "Landroid/os/Bundle;", "Lid/dana/riskChallenges/ui/util/strategy/SuccessListener;", "onSuccessListener", "Lid/dana/riskChallenges/ui/util/strategy/ErrorListener;", "onErrorListener", "Lid/dana/riskChallenges/ui/util/strategy/CancelListener;", "onCanceledListener", "setListener", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "showErrorToast", "showErrorVerifyPinPopup", "showKtpNotRegisteredDialog", "showRequestConsentDialog", "(Lkotlin/jvm/functions/Function0;)V", "Landroid/view/ViewGroup;", "parent", "Lid/dana/base/BaseFragment;", "baseFragment", "showSuccessAddKtpSnackBar", "(Landroid/view/ViewGroup;Lid/dana/base/BaseFragment;)V", "showSuccessToast", "(Lid/dana/base/BaseFragment;)V", "Lid/dana/base/BaseActivity;", "getBaseActivity", "()Lid/dana/base/BaseActivity;", "baseActivity", "cancelListener", "Lkotlin/jvm/functions/Function0;", "errorListener", "Lkotlin/jvm/functions/Function1;", "Landroidx/fragment/app/Fragment;", "fragment", "Landroidx/fragment/app/Fragment;", "Lid/dana/component/customsnackbarcomponent/CustomSnackbar;", "successAddKtpSnackBar", "Lid/dana/component/customsnackbarcomponent/CustomSnackbar;", "successListener", "Lid/dana/riskChallenges/ui/util/uicomponent/UiComponent;", "uiComponentVerifyPIN$delegate", "Lkotlin/Lazy;", "getUiComponentVerifyPIN", "()Lid/dana/riskChallenges/ui/util/uicomponent/UiComponent;", "uiComponentVerifyPIN", "Lid/dana/riskChallenges/ui/verifypin/VerifyPinLauncher;", "verifyPinKtpLauncher$delegate", "getVerifyPinKtpLauncher", "()Lid/dana/riskChallenges/ui/verifypin/VerifyPinLauncher;", "verifyPinKtpLauncher", "<init>", "(Landroidx/fragment/app/Fragment;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class IdentityToastAndDialogImpl implements IdentityToastAndDialog, DefaultLifecycleObserver {
    private static final String IS_KYC = "isKyc";
    private static final String KTP = "ktp";
    private static final String TRUE = "true";
    private Function0<Unit> cancelListener;
    private Function1<? super Bundle, Unit> errorListener;
    private final Fragment fragment;
    private CustomSnackbar successAddKtpSnackBar;
    private Function1<? super Bundle, Unit> successListener;

    /* renamed from: uiComponentVerifyPIN$delegate  reason: from kotlin metadata */
    private final Lazy uiComponentVerifyPIN;

    /* renamed from: verifyPinKtpLauncher$delegate  reason: from kotlin metadata */
    private final Lazy verifyPinKtpLauncher;

    @Override // androidx.view.FullLifecycleObserver
    public final /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver.CC.MyBillsEntityDataFactory();
    }

    @Override // androidx.view.FullLifecycleObserver
    public final /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver.CC.BuiltInFictitiousFunctionClassFactory();
    }

    @Override // androidx.view.FullLifecycleObserver
    public final /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver.CC.PlaceComponentResult();
    }

    @Override // androidx.view.FullLifecycleObserver
    public final /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver.CC.scheduleImpl();
    }

    public IdentityToastAndDialogImpl(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "");
        this.fragment = fragment;
        this.uiComponentVerifyPIN = LazyKt.lazy(new Function0<UiComponent>() { // from class: id.dana.wallet_v3.identity.IdentityToastAndDialogImpl$uiComponentVerifyPIN$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final UiComponent invoke() {
                return new UiComponent(UIComponentType.BottomSheet, R.color.f27072131100488, R.string.ktp_verify_pin_title);
            }
        });
        this.verifyPinKtpLauncher = LazyKt.lazy(new Function0<VerifyPinLauncher>() { // from class: id.dana.wallet_v3.identity.IdentityToastAndDialogImpl$verifyPinKtpLauncher$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final VerifyPinLauncher invoke() {
                Fragment fragment2;
                UiComponent uiComponentVerifyPIN;
                fragment2 = IdentityToastAndDialogImpl.this.fragment;
                VerifyPinLauncher.Builder builder = new VerifyPinLauncher.Builder(fragment2);
                UseCaseStrategy useCaseStrategy = new UseCaseStrategy("AP_PAYMENT", null, null, 6, null);
                Intrinsics.checkNotNullParameter(useCaseStrategy, "");
                builder.PlaceComponentResult = useCaseStrategy;
                Intrinsics.checkNotNullParameter("PAYMENT", "");
                builder.getAuthRequestContext = "PAYMENT";
                uiComponentVerifyPIN = IdentityToastAndDialogImpl.this.getUiComponentVerifyPIN();
                Intrinsics.checkNotNullParameter(uiComponentVerifyPIN, "");
                builder.scheduleImpl = uiComponentVerifyPIN;
                final IdentityToastAndDialogImpl identityToastAndDialogImpl = IdentityToastAndDialogImpl.this;
                Function1<Bundle, Unit> function1 = new Function1<Bundle, Unit>() { // from class: id.dana.wallet_v3.identity.IdentityToastAndDialogImpl$verifyPinKtpLauncher$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(Bundle bundle) {
                        invoke2(bundle);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Bundle bundle) {
                        Function1 function12;
                        Fragment fragment3;
                        Fragment fragment4;
                        Intrinsics.checkNotNullParameter(bundle, "");
                        function12 = IdentityToastAndDialogImpl.this.successListener;
                        if (function12 != null) {
                            function12.invoke(bundle);
                        }
                        fragment3 = IdentityToastAndDialogImpl.this.fragment;
                        Intent intent = new Intent(fragment3.getContext(), KtpDetailActivity.class);
                        fragment4 = IdentityToastAndDialogImpl.this.fragment;
                        fragment4.startActivityForResult(intent, NewWalletFragment.Companion.getIDENTITY_REQUEST_CODE());
                    }
                };
                Intrinsics.checkNotNullParameter(function1, "");
                builder.getErrorConfigVersion = function1;
                final IdentityToastAndDialogImpl identityToastAndDialogImpl2 = IdentityToastAndDialogImpl.this;
                Function1<Bundle, Unit> function12 = new Function1<Bundle, Unit>() { // from class: id.dana.wallet_v3.identity.IdentityToastAndDialogImpl$verifyPinKtpLauncher$2.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(Bundle bundle) {
                        invoke2(bundle);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Bundle bundle) {
                        Function1 function13;
                        Intrinsics.checkNotNullParameter(bundle, "");
                        function13 = IdentityToastAndDialogImpl.this.errorListener;
                        if (function13 != null) {
                            function13.invoke(bundle);
                        }
                    }
                };
                Intrinsics.checkNotNullParameter(function12, "");
                builder.PlaceComponentResult = function12;
                final IdentityToastAndDialogImpl identityToastAndDialogImpl3 = IdentityToastAndDialogImpl.this;
                Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.wallet_v3.identity.IdentityToastAndDialogImpl$verifyPinKtpLauncher$2.3
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        Function0 function02;
                        function02 = IdentityToastAndDialogImpl.this.cancelListener;
                        if (function02 != null) {
                            function02.invoke();
                        }
                    }
                };
                Intrinsics.checkNotNullParameter(function0, "");
                builder.KClassImpl$Data$declaredNonStaticMembers$2 = function0;
                return builder.KClassImpl$Data$declaredNonStaticMembers$2();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmName(name = "getBaseActivity")
    public final BaseActivity getBaseActivity() {
        FragmentActivity activity = this.fragment.getActivity();
        if (activity instanceof BaseActivity) {
            return (BaseActivity) activity;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmName(name = "getUiComponentVerifyPIN")
    public final UiComponent getUiComponentVerifyPIN() {
        return (UiComponent) this.uiComponentVerifyPIN.getValue();
    }

    @JvmName(name = "getVerifyPinKtpLauncher")
    private final VerifyPinLauncher getVerifyPinKtpLauncher() {
        return (VerifyPinLauncher) this.verifyPinKtpLauncher.getValue();
    }

    @Override // id.dana.wallet_v3.identity.IdentityToastAndDialog
    public final void setListener(Function1<? super Bundle, Unit> onSuccessListener, Function1<? super Bundle, Unit> onErrorListener, Function0<Unit> onCanceledListener) {
        this.successListener = onSuccessListener;
        this.errorListener = onErrorListener;
        this.cancelListener = onCanceledListener;
    }

    @Override // androidx.view.FullLifecycleObserver
    public final void onCreate(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "");
        DefaultLifecycleObserver.CC.KClassImpl$Data$declaredNonStaticMembers$2();
        owner.getLifecycle().BuiltInFictitiousFunctionClassFactory(getVerifyPinKtpLauncher());
    }

    @Override // androidx.view.FullLifecycleObserver
    public final void onDestroy(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "");
        DefaultLifecycleObserver.CC.getAuthRequestContext();
        owner.getLifecycle().KClassImpl$Data$declaredNonStaticMembers$2(getVerifyPinKtpLauncher());
    }

    @Override // id.dana.wallet_v3.identity.IdentityToastAndDialog
    public final void checkKYCStatusAndCertType(Map<String, String> extendInfo, String kycLandingPage, Function0<Unit> acceptConsentAction) {
        Intrinsics.checkNotNullParameter(extendInfo, "");
        Intrinsics.checkNotNullParameter(kycLandingPage, "");
        Intrinsics.checkNotNullParameter(acceptConsentAction, "");
        String str = (String) MapsKt.getValue(extendInfo, "isKyc");
        String str2 = (String) MapsKt.getValue(extendInfo, PersonalPresenter.CERT_TYPE);
        if (Intrinsics.areEqual(str, "true") && StringsKt.contains((CharSequence) str2, (CharSequence) KTP, true)) {
            showRequestConsentDialog(acceptConsentAction);
        } else if (Intrinsics.areEqual(str, "true") && !StringsKt.contains((CharSequence) str2, (CharSequence) KTP, true)) {
            showKtpNotRegisteredDialog();
        } else {
            goToKycLandingPage(kycLandingPage);
        }
    }

    @Override // id.dana.wallet_v3.identity.IdentityToastAndDialog
    public final void openPinChallenge() {
        getVerifyPinKtpLauncher().BuiltInFictitiousFunctionClassFactory();
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [id.dana.base.BaseMaterialDialog, T, id.dana.dialog.LoginInfoDialog] */
    @Override // id.dana.wallet_v3.identity.IdentityToastAndDialog
    public final void showErrorVerifyPinPopup() {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity != null) {
            LoginInfoDialog.Builder builder = new LoginInfoDialog.Builder(baseActivity);
            builder.initRecordTimeStamp = baseActivity.getString(R.string.verify_pin_error_title);
            builder.PlaceComponentResult = baseActivity.getString(R.string.verify_pin_error_subtitle);
            builder.NetworkUserEntityData$$ExternalSyntheticLambda2 = DialogType.PIN_LOCK;
            String string = baseActivity.getString(R.string.tnc_ok_button);
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: id.dana.wallet_v3.identity.IdentityToastAndDialogImpl$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    IdentityToastAndDialogImpl.m2997showErrorVerifyPinPopup$lambda2$lambda0(Ref.ObjectRef.this, view);
                }
            };
            builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = string;
            builder.moveToNextValue = onClickListener;
            builder.MyBillsEntityDataFactory = false;
            LoginInfoDialog.Builder MyBillsEntityDataFactory = builder.BuiltInFictitiousFunctionClassFactory().MyBillsEntityDataFactory();
            ?? loginInfoDialog = new LoginInfoDialog(MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2, MyBillsEntityDataFactory.getAuthRequestContext, MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda1, MyBillsEntityDataFactory, (byte) 0);
            loginInfoDialog.MyBillsEntityDataFactory();
            objectRef.element = loginInfoDialog;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showErrorVerifyPinPopup$lambda-2$lambda-0  reason: not valid java name */
    public static final void m2997showErrorVerifyPinPopup$lambda2$lambda0(Ref.ObjectRef objectRef, View view) {
        Intrinsics.checkNotNullParameter(objectRef, "");
        LoginInfoDialog loginInfoDialog = (LoginInfoDialog) objectRef.element;
        if (loginInfoDialog != null) {
            loginInfoDialog.getAuthRequestContext();
        }
    }

    @Override // id.dana.wallet_v3.identity.IdentityToastAndDialog
    public final void showSuccessToast(BaseFragment baseFragment) {
        ViewGroup viewGroup;
        Intrinsics.checkNotNullParameter(baseFragment, "");
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null || (viewGroup = (ViewGroup) baseActivity.findViewById(16908290)) == null) {
            return;
        }
        showSuccessAddKtpSnackBar(viewGroup, baseFragment);
    }

    @Override // id.dana.wallet_v3.identity.IdentityToastAndDialog
    public final void showErrorToast() {
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity != null) {
            DANAToast dANAToast = DANAToast.BuiltInFictitiousFunctionClassFactory;
            BaseActivity baseActivity2 = baseActivity;
            String string = baseActivity.getString(R.string.failed_add_ktp_msg);
            Intrinsics.checkNotNullExpressionValue(string, "");
            DANAToast.MyBillsEntityDataFactory(baseActivity2, string, "");
        }
    }

    /* JADX WARN: Type inference failed for: r6v8, types: [T, id.dana.dialog.TwoButtonWithImageDialog] */
    private final void showRequestConsentDialog(final Function0<Unit> acceptConsentAction) {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity != null) {
            TwoButtonWithImageDialog.Builder builder = new TwoButtonWithImageDialog.Builder(baseActivity);
            builder.FragmentBottomSheetPaymentSettingBinding = baseActivity.getString(R.string.request_consent_dialog_title);
            builder.getErrorConfigVersion = baseActivity.getString(R.string.request_consent_dialog_desc);
            builder.PlaceComponentResult = getTncSpannable();
            builder.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.ic_request_consent;
            builder.PlaceComponentResult(false);
            builder.MyBillsEntityDataFactory(false);
            String string = baseActivity.getString(R.string.request_consent_dialog_positive_button);
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: id.dana.wallet_v3.identity.IdentityToastAndDialogImpl$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    IdentityToastAndDialogImpl.m2998showRequestConsentDialog$lambda8$lambda7$lambda5(Function0.this, objectRef, view);
                }
            };
            builder.NetworkUserEntityData$$ExternalSyntheticLambda8 = string;
            builder.NetworkUserEntityData$$ExternalSyntheticLambda4 = onClickListener;
            builder.PrepareContext = baseActivity.getString(R.string.wallet_btn_yes_identity);
            String string2 = baseActivity.getString(R.string.request_consent_dialog_negative_button);
            View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: id.dana.wallet_v3.identity.IdentityToastAndDialogImpl$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    IdentityToastAndDialogImpl.m2999showRequestConsentDialog$lambda8$lambda7$lambda6(Ref.ObjectRef.this, view);
                }
            };
            builder.NetworkUserEntityData$$ExternalSyntheticLambda2 = string2;
            builder.DatabaseTableConfigUtil = onClickListener2;
            builder.GetContactSyncConfig = baseActivity.getString(R.string.wallet_btn_later_identity);
            builder.newProxyInstance = true;
            objectRef.element = builder.KClassImpl$Data$declaredNonStaticMembers$2();
            TwoButtonWithImageDialog twoButtonWithImageDialog = (TwoButtonWithImageDialog) objectRef.element;
            if (twoButtonWithImageDialog != null) {
                twoButtonWithImageDialog.MyBillsEntityDataFactory();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showRequestConsentDialog$lambda-8$lambda-7$lambda-5  reason: not valid java name */
    public static final void m2998showRequestConsentDialog$lambda8$lambda7$lambda5(Function0 function0, Ref.ObjectRef objectRef, View view) {
        Intrinsics.checkNotNullParameter(function0, "");
        Intrinsics.checkNotNullParameter(objectRef, "");
        function0.invoke();
        TwoButtonWithImageDialog twoButtonWithImageDialog = (TwoButtonWithImageDialog) objectRef.element;
        if (twoButtonWithImageDialog != null) {
            twoButtonWithImageDialog.getAuthRequestContext();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showRequestConsentDialog$lambda-8$lambda-7$lambda-6  reason: not valid java name */
    public static final void m2999showRequestConsentDialog$lambda8$lambda7$lambda6(Ref.ObjectRef objectRef, View view) {
        Intrinsics.checkNotNullParameter(objectRef, "");
        TwoButtonWithImageDialog twoButtonWithImageDialog = (TwoButtonWithImageDialog) objectRef.element;
        if (twoButtonWithImageDialog != null) {
            twoButtonWithImageDialog.getAuthRequestContext();
        }
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [T, com.afollestad.materialdialogs.MaterialDialog] */
    private final void showKtpNotRegisteredDialog() {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity != null) {
            CustomDialog.Builder builder = new CustomDialog.Builder(baseActivity);
            builder.DatabaseTableConfigUtil = R.drawable.ic_ktp_not_registered;
            builder.SubSequence = baseActivity.getString(R.string.ktp_not_registered_dialog_title);
            builder.GetContactSyncConfig = baseActivity.getString(R.string.ktp_not_registered_dialog_desc);
            builder.BuiltInFictitiousFunctionClassFactory(baseActivity.getString(R.string.tnc_ok_button), new Function1<View, Unit>() { // from class: id.dana.wallet_v3.identity.IdentityToastAndDialogImpl$showKtpNotRegisteredDialog$1$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(View view) {
                    Intrinsics.checkNotNullParameter(view, "");
                    MaterialDialog materialDialog = objectRef.element;
                    if (materialDialog != null) {
                        materialDialog.dismiss();
                    }
                }
            });
            builder.KClassImpl$Data$declaredNonStaticMembers$2(false);
            builder.PlaceComponentResult(false);
            builder.moveToNextValue = 0L;
            objectRef.element = builder.BuiltInFictitiousFunctionClassFactory();
            MaterialDialog materialDialog = (MaterialDialog) objectRef.element;
            if (materialDialog != null) {
                materialDialog.show();
            }
        }
    }

    private final void goToKycLandingPage(String kycLandingPage) {
        StringBuilder sb = new StringBuilder();
        sb.append("https://m.dana.id");
        sb.append(kycLandingPage);
        DanaH5.startContainerFullUrl(sb.toString());
    }

    private final Spannable getTncSpannable() {
        String str;
        BaseActivity baseActivity = getBaseActivity();
        String str2 = "";
        if (baseActivity != null) {
            String string = baseActivity.getString(R.string.ktp_not_registered_dialog_footer);
            Intrinsics.checkNotNullExpressionValue(string, "");
            str = baseActivity.getString(R.string.ktp_not_registered_dialog_footer_highlight);
            Intrinsics.checkNotNullExpressionValue(str, "");
            str2 = string;
        } else {
            str = "";
        }
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str2, str, 0, false, 6, (Object) null);
        return getSpannableString(str2, indexOf$default, str.length() + indexOf$default);
    }

    private final SpannableString getSpannableString(String fullText, int startHighlightedText, int stopHighlightedText) {
        SpannableString spannableString = new SpannableString(fullText);
        ClickableSpan clickableSpan = getClickableSpan();
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity != null) {
            spannableString.setSpan(clickableSpan, startHighlightedText, stopHighlightedText, 33);
            spannableString.setSpan(new ForegroundColorSpan(ContextCompat.BuiltInFictitiousFunctionClassFactory(baseActivity, R.color.f22912131099753)), startHighlightedText, stopHighlightedText, 33);
        }
        return spannableString;
    }

    private final ClickableSpan getClickableSpan() {
        return new ClickableSpan() { // from class: id.dana.wallet_v3.identity.IdentityToastAndDialogImpl$getClickableSpan$1
            @Override // android.text.style.ClickableSpan
            public final void onClick(View widget) {
                Intrinsics.checkNotNullParameter(widget, "");
                String authRequestContext = UrlUtil.getAuthRequestContext(DanaUrl.TERMS_AND_CONDITION_KTP);
                Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
                DanaH5.startContainerFullUrl(authRequestContext);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public final void updateDrawState(TextPaint ds) {
                BaseActivity baseActivity;
                Intrinsics.checkNotNullParameter(ds, "");
                ds.setUnderlineText(false);
                baseActivity = IdentityToastAndDialogImpl.this.getBaseActivity();
                if (baseActivity != null) {
                    ds.setColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(baseActivity, R.color.f22912131099753));
                }
            }
        };
    }

    private final void showSuccessAddKtpSnackBar(ViewGroup parent, BaseFragment baseFragment) {
        if (parent != null) {
            CustomSnackbar.Builder builder = new CustomSnackbar.Builder(parent);
            BaseActivity baseActivity = getBaseActivity();
            builder.lookAheadTest = baseActivity != null ? baseActivity.getString(R.string.success_add_ktp__button_msg) : null;
            BaseActivity baseActivity2 = getBaseActivity();
            builder.initRecordTimeStamp = baseActivity2 != null ? baseActivity2.getString(R.string.success_add_ktp_msg) : null;
            builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = R.drawable.ic_check_24_green50_filled_circle;
            builder.moveToNextValue = 0;
            builder.MyBillsEntityDataFactory = R.drawable.bg_rounded_border_green_50;
            builder.getAuthRequestContext = ViewExtKt.PlaceComponentResult(55.0f);
            Function1<CustomSnackbar, Unit> function1 = new Function1<CustomSnackbar, Unit>() { // from class: id.dana.wallet_v3.identity.IdentityToastAndDialogImpl$showSuccessAddKtpSnackBar$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(CustomSnackbar customSnackbar) {
                    invoke2(customSnackbar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(CustomSnackbar customSnackbar) {
                    Intrinsics.checkNotNullParameter(customSnackbar, "");
                    IdentityToastAndDialogImpl.this.openPinChallenge();
                }
            };
            Intrinsics.checkNotNullParameter(function1, "");
            builder.getErrorConfigVersion = function1;
            CustomSnackbar BuiltInFictitiousFunctionClassFactory = builder.BuiltInFictitiousFunctionClassFactory();
            this.successAddKtpSnackBar = BuiltInFictitiousFunctionClassFactory;
            BuiltInFictitiousFunctionClassFactory.show();
        }
    }
}
