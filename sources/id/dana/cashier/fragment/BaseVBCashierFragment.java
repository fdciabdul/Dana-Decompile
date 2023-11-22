package id.dana.cashier.fragment;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentActivity;
import androidx.viewbinding.ViewBinding;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.api.constants.GriverEvents;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.anggrayudi.storage.permission.FragmentPermissionRequest;
import com.anggrayudi.storage.permission.PermissionCallback;
import com.anggrayudi.storage.permission.PermissionReport;
import com.anggrayudi.storage.permission.PermissionRequest;
import com.anggrayudi.storage.permission.PermissionResult;
import id.dana.DanaApplication;
import id.dana.R;
import id.dana.base.AbstractContract;
import id.dana.base.DisposableHandler;
import id.dana.cashier.RiskParamsFactory;
import id.dana.cashier.model.VoucherCashierModel;
import id.dana.core.ui.BaseViewBindingFragment;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.di.component.ApplicationComponent;
import id.dana.dialog.DanaLoadingDialog;
import id.dana.pay.PayActivity;
import id.dana.promoquest.handler.nativepage.NativePageType;
import id.dana.richview.LogoProgressView;
import id.dana.utils.KeyboardHelper;
import id.dana.utils.permission.PermissionHelper;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Ø\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0011\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0012\u0010H\u001a\u0002092\b\u0010I\u001a\u0004\u0018\u00010JH\u0016J\b\u0010K\u001a\u000209H\u0014J\b\u0010L\u001a\u000209H\u0004J\b\u0010M\u001a\u000209H\u0016J\b\u0010N\u001a\u000209H\u0016J\b\u0010O\u001a\u000209H\u0002J\u0010\u0010P\u001a\u0002092\u0006\u0010Q\u001a\u00020\u0017H\u0004J\b\u0010R\u001a\u000209H\u0004J\n\u0010S\u001a\u0004\u0018\u00010TH\u0004J\u0010\u0010U\u001a\u0002092\u0006\u0010V\u001a\u00020WH\u0014J\n\u0010X\u001a\u0004\u0018\u00010YH\u0004JF\u0010Z\u001a\u0002092\u0006\u0010[\u001a\u00020\u00072\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010]\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010^\u001a\u00020\u00072\b\b\u0002\u0010_\u001a\u00020\u00072\b\b\u0002\u0010`\u001a\u00020\u0017H\u0014J\u0010\u0010a\u001a\u0002092\u0006\u0010b\u001a\u00020cH\u0004J\u0006\u0010d\u001a\u000209J\b\u0010e\u001a\u000209H\u0014J\b\u0010f\u001a\u000209H\u0014J\b\u0010g\u001a\u000209H\u0014J\b\u0010h\u001a\u000209H\u0014J\b\u0010i\u001a\u000209H\u0016J\b\u0010j\u001a\u000209H\u0014J\b\u0010k\u001a\u00020\u0017H\u0004J\b\u0010l\u001a\u00020\u0017H\u0004J\b\u0010m\u001a\u00020\u0017H\u0004J\b\u0010n\u001a\u00020\u0017H\u0004J\b\u0010o\u001a\u00020\u0017H\u0004J\b\u0010p\u001a\u00020\u0017H\u0004J\b\u0010q\u001a\u000209H\u0004J&\u0010r\u001a\u0004\u0018\u00010s2\u0006\u0010t\u001a\u00020u2\b\u0010v\u001a\u0004\u0018\u00010w2\b\u0010x\u001a\u0004\u0018\u00010yH\u0016J\b\u0010z\u001a\u000209H\u0016J\u0006\u0010{\u001a\u000209J\b\u0010|\u001a\u000209H\u0014J\b\u0010}\u001a\u000209H\u0002J\u0010\u0010~\u001a\u0002092\u0006\u0010(\u001a\u00020)H\u0016J\b\u0010\u007f\u001a\u000209H\u0016J\t\u0010\u0080\u0001\u001a\u000209H\u0014J\u001c\u0010\u0081\u0001\u001a\u0002092\u0007\u0010\u0082\u0001\u001a\u00020s2\b\u0010x\u001a\u0004\u0018\u00010yH\u0016J\t\u0010\u0083\u0001\u001a\u000209H\u0004J\t\u0010\u0084\u0001\u001a\u000209H\u0014J%\u0010\u0085\u0001\u001a\u0002092\u0014\u0010\u0086\u0001\u001a\u000b\u0012\u0006\b\u0001\u0012\u00020&0\u0087\u0001\"\u00020&H\u0004¢\u0006\u0003\u0010\u0088\u0001J\u0012\u0010\u0089\u0001\u001a\u0002092\u0007\u0010\u008a\u0001\u001a\u00020\u0017H\u0004J\t\u0010\u008b\u0001\u001a\u000209H\u0004J\u0012\u0010\u008c\u0001\u001a\u0002092\u0007\u0010\u008d\u0001\u001a\u00020\u0007H\u0004J\u0012\u0010\u008e\u0001\u001a\u0002092\u0007\u0010\u008f\u0001\u001a\u00020\u0007H\u0002J\t\u0010\u0090\u0001\u001a\u000209H\u0004J\u0013\u0010\u0091\u0001\u001a\u0002092\b\u0010\\\u001a\u0004\u0018\u00010\u0007H\u0004J\u0013\u0010\u0092\u0001\u001a\u0002092\b\u0010\\\u001a\u0004\u0018\u00010\u0007H\u0004J \u0010\u0093\u0001\u001a\u0002092\u0015\b\u0002\u0010\u0094\u0001\u001a\u000e\u0012\u0004\u0012\u00020s\u0012\u0004\u0012\u00020908H\u0004J\u0014\u0010\u0095\u0001\u001a\u0002092\t\u0010\u0096\u0001\u001a\u0004\u0018\u00010YH\u0004J\t\u0010\u0097\u0001\u001a\u000209H\u0016J\u0007\u0010\u0098\u0001\u001a\u000209J\u0007\u0010\u0099\u0001\u001a\u000209J\u0013\u0010\u009a\u0001\u001a\u0002092\b\u0010\\\u001a\u0004\u0018\u00010\u0007H\u0004J\u0013\u0010\u009b\u0001\u001a\u0002092\b\u0010\u009c\u0001\u001a\u00030\u009d\u0001H\u0014J\u0012\u0010\u009e\u0001\u001a\u0002092\u0007\u0010\u009f\u0001\u001a\u00020\u0017H\u0014J#\u0010 \u0001\u001a\u000209*\u00030¡\u00012\t\u0010¢\u0001\u001a\u0004\u0018\u00010\u00072\b\u0010>\u001a\u0004\u0018\u00010\u0007H\u0004R\u001a\u0010\u0006\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0017X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0017X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR\u000e\u0010\u001d\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010 \u001a\u00020\u00078DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b!\u0010\tR\u001e\u0010$\u001a\u0012\u0012\u0004\u0012\u00020&0%j\b\u0012\u0004\u0012\u00020&`'X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010(\u001a\u0004\u0018\u00010)X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\t\"\u0004\b0\u0010\u000bR\u001c\u00101\u001a\u0004\u0018\u000102X\u0094\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R&\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020908X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001b\u0010>\u001a\u00020\u00078DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b@\u0010#\u001a\u0004\b?\u0010\tR\u0010\u0010A\u001a\u0004\u0018\u00010BX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u0004\u0018\u00010DX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010E\u001a\u0004\u0018\u00010\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\t\"\u0004\bG\u0010\u000b¨\u0006£\u0001"}, d2 = {"Lid/dana/cashier/fragment/BaseVBCashierFragment;", "VB", "Landroidx/viewbinding/ViewBinding;", "Lid/dana/core/ui/BaseViewBindingFragment;", "Lid/dana/base/DisposableHandler;", "()V", "bizOrderId", "", "getBizOrderId", "()Ljava/lang/String;", "setBizOrderId", "(Ljava/lang/String;)V", "cameraPermission", "Lcom/anggrayudi/storage/permission/FragmentPermissionRequest;", "getCameraPermission", "()Lcom/anggrayudi/storage/permission/FragmentPermissionRequest;", "danaLoadingDialog", "Lid/dana/dialog/DanaLoadingDialog;", "danaLoadingLayout", "Landroid/widget/FrameLayout;", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "isFallbackFaceAuth", "", "()Z", "setFallbackFaceAuth", "(Z)V", "isForceFaceAuth", "setForceFaceAuth", GriverMonitorConstants.KEY_IS_LOADING, "lpvLoading", "Lid/dana/richview/LogoProgressView;", "orderTitleFromSummary", "getOrderTitleFromSummary", "orderTitleFromSummary$delegate", "Lkotlin/Lazy;", "presenterList", "Ljava/util/ArrayList;", "Lid/dana/base/AbstractContract$AbstractPresenter;", "Lkotlin/collections/ArrayList;", "riskParamsFactory", "Lid/dana/cashier/RiskParamsFactory;", "getRiskParamsFactory", "()Lid/dana/cashier/RiskParamsFactory;", "setRiskParamsFactory", "(Lid/dana/cashier/RiskParamsFactory;)V", BioUtilityBridge.SECURITY_ID, "getSecurityId", "setSecurityId", "selectedCashierPromo", "Lid/dana/cashier/model/VoucherCashierModel;", "getSelectedCashierPromo", "()Lid/dana/cashier/model/VoucherCashierModel;", "setSelectedCashierPromo", "(Lid/dana/cashier/model/VoucherCashierModel;)V", "showAddOn", "Lkotlin/Function1;", "", "getShowAddOn", "()Lkotlin/jvm/functions/Function1;", "setShowAddOn", "(Lkotlin/jvm/functions/Function1;)V", "source", "getSource", "source$delegate", "toolbarBackArrow", "Landroidx/appcompat/widget/AppCompatImageView;", "toolbarTitle", "Landroidx/appcompat/widget/AppCompatTextView;", "transType", "getTransType", "setTransType", "addDisposable", "disposable", "Lio/reactivex/disposables/Disposable;", "configToolbar", "dismissDanaLoadingProgress", "dismissSkeleton", "dispose", "disposePresenter", "enableActivityTouchEvent", "isEnable", "expandBottomSheet", "getApplicationComponent", "Lid/dana/di/component/ApplicationComponent;", "getErrorState", "errorState", "Lid/dana/cashier/helper/CashierErrorState;", "getPayActivity", "Lid/dana/pay/PayActivity;", "goToPaymentResultPage", "status", "errorMessage", "errorCode", "addonId", "transactionScenario", "reloadBalance", "handleForceFaceAuth", "attributeCashierPayModel", "Lid/dana/cashier/model/AttributeCashierPayModel;", "hideToolbarBackArrow", IAPSyncCommand.COMMAND_INIT, "initCashierListener", "initComponent", "initPermission", "initToolbar", "initViews", "isFromFamilyAccountApproval", "isX2b", "isX2c", "isX2g", "isX2l", "isX2p", "onBackToolbarPressed", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", BranchLinkConstant.PathTarget.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onFaceAuthFallback", "onPermissionGrantedFaceAuth", "onRedirectToSystemSetting", "onRequestCashierSmileToPay", "onResume", "onRiskFaceAuthFallback", "onViewCreated", "view", "popCurrentFragment", "prepareBundle", "registerPresenter", "presenters", "", "([Lid/dana/base/AbstractContract$AbstractPresenter;)V", "setDismissAllowed", "isAllowed", "setHalfBottomSheet", GriverEvents.EVENT_SET_TITLE, "title", "setTitleContentDesc", "contentDesc", "showDanaLoadingProgress", "showErrorToast", "showFailedToast", "showForceFaceAuthDialog", "onClickVerify", "showOtpLimitedDialog", AkuEventParamsKey.KEY_ACTIVITY, "showSkeleton", "showSmartpayActivationErrorToast", "showSmartpayActivationSuccessToast", "showWarningToast", "trackPaymentExecution", "payMethod", "Lid/dana/cashier/model/CashierPayMethodModel;", "trackPaymentFaceRiskChallenge", "isFaceVerificationSuccess", "setMerchantLogo", "Landroid/widget/ImageView;", "merchantLogoUrl", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class BaseVBCashierFragment<VB extends ViewBinding> extends BaseViewBindingFragment<VB> implements DisposableHandler {
    private AppCompatImageView FragmentBottomSheetPaymentSettingBinding;
    private LogoProgressView GetContactSyncConfig;
    private DanaLoadingDialog KClassImpl$Data$declaredNonStaticMembers$2;
    private final FragmentPermissionRequest MyBillsEntityDataFactory;
    boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
    private RiskParamsFactory NetworkUserEntityData$$ExternalSyntheticLambda1;
    private AppCompatTextView NetworkUserEntityData$$ExternalSyntheticLambda4;
    private String NetworkUserEntityData$$ExternalSyntheticLambda6;
    private VoucherCashierModel NetworkUserEntityData$$ExternalSyntheticLambda7;
    private FrameLayout PlaceComponentResult;
    private boolean moveToNextValue;
    public Map<Integer, View> lookAheadTest = new LinkedHashMap();
    private final ArrayList<AbstractContract.AbstractPresenter> initRecordTimeStamp = new ArrayList<>();
    private final CompositeDisposable scheduleImpl = new CompositeDisposable();
    protected Function1<? super Boolean, Unit> DatabaseTableConfigUtil = new Function1<Boolean, Unit>() { // from class: id.dana.cashier.fragment.BaseVBCashierFragment$showAddOn$1
        public final void invoke(boolean z) {
        }

        @Override // kotlin.jvm.functions.Function1
        public final /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.INSTANCE;
        }
    };
    private String isLayoutRequested = "";
    String getErrorConfigVersion = "";
    protected final Lazy NetworkUserEntityData$$ExternalSyntheticLambda2 = LazyKt.lazy(new Function0<String>(this) { // from class: id.dana.cashier.fragment.BaseVBCashierFragment$orderTitleFromSummary$2
        final /* synthetic */ BaseVBCashierFragment<VB> this$0;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
            this.this$0 = this;
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            FragmentActivity activity = this.this$0.getActivity();
            PayActivity payActivity = activity instanceof PayActivity ? (PayActivity) activity : null;
            String orderTitleFromSummary = payActivity != null ? payActivity.getOrderTitleFromSummary() : null;
            return orderTitleFromSummary == null ? "" : orderTitleFromSummary;
        }
    });
    private final Lazy NetworkUserEntityData$$ExternalSyntheticLambda5 = LazyKt.lazy(new Function0<String>(this) { // from class: id.dana.cashier.fragment.BaseVBCashierFragment$source$2
        final /* synthetic */ BaseVBCashierFragment<VB> this$0;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
            this.this$0 = this;
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            Intent intent;
            Bundle extras;
            FragmentActivity activity = this.this$0.getActivity();
            String string = (activity == null || (intent = activity.getIntent()) == null || (extras = intent.getExtras()) == null) ? null : extras.getString("source");
            return string == null ? "" : string;
        }
    });

    public void A() {
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public void KClassImpl$Data$declaredNonStaticMembers$2() {
    }

    protected void NetworkUserEntityData$$ExternalSyntheticLambda3() {
    }

    protected void NetworkUserEntityData$$ExternalSyntheticLambda4() {
    }

    protected void NetworkUserEntityData$$ExternalSyntheticLambda6() {
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public View getAuthRequestContext(int i) {
        View findViewById;
        Map<Integer, View> map = this.lookAheadTest;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View getAuthRequestContext = getGetAuthRequestContext();
            if (getAuthRequestContext == null || (findViewById = getAuthRequestContext.findViewById(i)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public void getAuthRequestContext() {
        this.lookAheadTest.clear();
    }

    public void getAuthRequestContext(RiskParamsFactory riskParamsFactory) {
        Intrinsics.checkNotNullParameter(riskParamsFactory, "");
    }

    protected void getAuthRequestContext(String str, String str2, String str3, String str4, String str5, boolean z) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void getAuthRequestContext(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void getCallingPid() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void readMicros() {
    }

    protected void whenAvailable() {
    }

    public BaseVBCashierFragment() {
        FragmentPermissionRequest.Builder builder = new FragmentPermissionRequest.Builder(this);
        String[] strArr = {"android.permission.CAMERA"};
        Intrinsics.checkNotNullParameter(strArr, "");
        builder.getAuthRequestContext = ArraysKt.toSet(strArr);
        PermissionCallback permissionCallback = new PermissionCallback(this) { // from class: id.dana.cashier.fragment.BaseVBCashierFragment$cameraPermission$1
            final /* synthetic */ BaseVBCashierFragment<VB> getAuthRequestContext;

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final /* synthetic */ void onDisplayConsentDialog(PermissionRequest permissionRequest) {
                PermissionCallback.CC.getAuthRequestContext(permissionRequest);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.getAuthRequestContext = this;
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onPermissionsChecked(PermissionResult p0, boolean p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                if (p0.MyBillsEntityDataFactory()) {
                    this.getAuthRequestContext.getCallingPid();
                } else {
                    this.getAuthRequestContext.readMicros();
                }
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onShouldRedirectToSystemSettings(List<PermissionReport> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                BaseVBCashierFragment.PlaceComponentResult(this.getAuthRequestContext);
            }
        };
        Intrinsics.checkNotNullParameter(permissionCallback, "");
        builder.BuiltInFictitiousFunctionClassFactory = permissionCallback;
        this.MyBillsEntityDataFactory = builder.PlaceComponentResult();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @JvmName(name = "setRiskParamsFactory")
    public final void KClassImpl$Data$declaredNonStaticMembers$2(RiskParamsFactory riskParamsFactory) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = riskParamsFactory;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @JvmName(name = "getRiskParamsFactory")
    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from getter */
    public final RiskParamsFactory getNetworkUserEntityData$$ExternalSyntheticLambda1() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @JvmName(name = "setSecurityId")
    public final void BuiltInFictitiousFunctionClassFactory(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.isLayoutRequested = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @JvmName(name = "getSecurityId")
    /* renamed from: isLayoutRequested  reason: from getter */
    public final String getIsLayoutRequested() {
        return this.isLayoutRequested;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @JvmName(name = "setSelectedCashierPromo")
    public final void MyBillsEntityDataFactory(VoucherCashierModel voucherCashierModel) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = voucherCashierModel;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @JvmName(name = "getSelectedCashierPromo")
    /* renamed from: PrepareContext  reason: from getter */
    public final VoucherCashierModel getNetworkUserEntityData$$ExternalSyntheticLambda7() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda7;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @JvmName(name = "getTransType")
    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from getter */
    public final String getNetworkUserEntityData$$ExternalSyntheticLambda6() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda6;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @JvmName(name = "getSource")
    public final String NetworkUserEntityData$$ExternalSyntheticLambda8() {
        return (String) this.NetworkUserEntityData$$ExternalSyntheticLambda5.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @JvmName(name = "getCameraPermission")
    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from getter */
    public final FragmentPermissionRequest getMyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public void FragmentBottomSheetPaymentSettingBinding() {
        NetworkUserEntityData$$ExternalSyntheticLambda3();
        whenAvailable();
        NetworkUserEntityData$$ExternalSyntheticLambda4();
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "");
        View onCreateView = super.onCreateView(inflater, container, savedInstanceState);
        this.PlaceComponentResult = onCreateView != null ? (FrameLayout) onCreateView.findViewById(R.id.flDanaLoading) : null;
        this.GetContactSyncConfig = onCreateView != null ? (LogoProgressView) onCreateView.findViewById(R.id.f4033lpvLoading) : null;
        return onCreateView;
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "");
        super.onViewCreated(view, savedInstanceState);
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = (AppCompatTextView) view.findViewById(R.id.tvTitlePage);
        this.FragmentBottomSheetPaymentSettingBinding = (AppCompatImageView) view.findViewById(R.id.f3832res_0x7f0a093d_property_propertytype_1);
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = Intrinsics.areEqual((String) this.NetworkUserEntityData$$ExternalSyntheticLambda5.getValue(), "Send Money") ? NativePageType.SEND_MONEY : null;
        AppCompatImageView appCompatImageView = this.FragmentBottomSheetPaymentSettingBinding;
        if (appCompatImageView != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.cashier.fragment.BaseVBCashierFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    BaseVBCashierFragment.getAuthRequestContext(BaseVBCashierFragment.this);
                }
            });
        }
        String string = getString(R.string.sdet_lbl_header);
        Intrinsics.checkNotNullExpressionValue(string, "");
        AppCompatTextView appCompatTextView = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
        if (appCompatTextView != null) {
            appCompatTextView.setContentDescription(string);
        }
        KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        NetworkUserEntityData$$ExternalSyntheticLambda6();
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda1 == null || !this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            return;
        }
        readMicros();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Iterator<T> it = this.initRecordTimeStamp.iterator();
        while (it.hasNext()) {
            ((AbstractContract.AbstractPresenter) it.next()).onDestroy();
        }
        this.scheduleImpl.dispose();
        getAuthRequestContext();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ApplicationComponent initRecordTimeStamp() {
        FragmentActivity activity = getActivity();
        Application application = activity != null ? activity.getApplication() : null;
        DanaApplication danaApplication = application instanceof DanaApplication ? (DanaApplication) application : null;
        if (danaApplication != null) {
            return danaApplication.getApplicationComponent();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void BuiltInFictitiousFunctionClassFactory(AbstractContract.AbstractPresenter... abstractPresenterArr) {
        Intrinsics.checkNotNullParameter(abstractPresenterArr, "");
        CollectionsKt.addAll(this.initRecordTimeStamp, abstractPresenterArr);
    }

    public final void PlaceComponentResult(Disposable disposable) {
        if (disposable != null) {
            this.scheduleImpl.getAuthRequestContext(disposable);
        }
    }

    public static /* synthetic */ void getAuthRequestContext(BaseVBCashierFragment baseVBCashierFragment, String str, String str2, String str3, String str4, String str5, boolean z, int i) {
        baseVBCashierFragment.getAuthRequestContext(str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? false : z);
    }

    public final void newProxyInstance() {
        AppCompatImageView appCompatImageView = this.FragmentBottomSheetPaymentSettingBinding;
        if (appCompatImageView != null) {
            appCompatImageView.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void MyBillsEntityDataFactory(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        AppCompatTextView appCompatTextView = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
        if (appCompatTextView != null) {
            appCompatTextView.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void GetContactSyncConfig() {
        if (this.moveToNextValue) {
            FrameLayout frameLayout = this.PlaceComponentResult;
            if (frameLayout != null) {
                LogoProgressView logoProgressView = this.GetContactSyncConfig;
                if (logoProgressView != null) {
                    logoProgressView.stopRefresh();
                }
                frameLayout.setVisibility(8);
                this.moveToNextValue = false;
            }
            DanaLoadingDialog danaLoadingDialog = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (danaLoadingDialog != null) {
                if (danaLoadingDialog == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    danaLoadingDialog = null;
                }
                danaLoadingDialog.PlaceComponentResult();
                this.moveToNextValue = false;
            }
        }
        FragmentActivity activity = getActivity();
        PayActivity payActivity = activity instanceof PayActivity ? (PayActivity) activity : null;
        if (payActivity != null) {
            payActivity.enableDisableActivityTouchEvent(true);
        }
    }

    public final void getSupportButtonTintMode() {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda1 == null || !this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            return;
        }
        readMicros();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
    }

    public static /* synthetic */ void getAuthRequestContext(BaseVBCashierFragment baseVBCashierFragment) {
        Intrinsics.checkNotNullParameter(baseVBCashierFragment, "");
        FragmentActivity activity = baseVBCashierFragment.getActivity();
        if (activity != null) {
            KeyboardHelper.BuiltInFictitiousFunctionClassFactory(activity);
        }
        FragmentActivity activity2 = baseVBCashierFragment.getActivity();
        PayActivity payActivity = activity2 instanceof PayActivity ? (PayActivity) activity2 : null;
        if (payActivity != null) {
            payActivity.onBackPressed();
        }
    }

    public static final /* synthetic */ void PlaceComponentResult(BaseVBCashierFragment baseVBCashierFragment) {
        FragmentActivity activity = baseVBCashierFragment.getActivity();
        if (activity != null) {
            PermissionHelper.MyBillsEntityDataFactory(activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x005b, code lost:
    
        if (r1.equals("BCA_ONE_KLIK") == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0064, code lost:
    
        if (r1.equals(id.dana.cashier.helper.CashierErrorType.RETRYABLE_RISK_CHALLENGE) != false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0066, code lost:
    
        r11 = r11.getAuthRequestContext.asString(getContext());
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0070, code lost:
    
        if (r11 != null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0072, code lost:
    
        r11 = getString(id.dana.R.string.SchedulerPoolFactory);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, "");
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007c, code lost:
    
        r0 = getActivity();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0080, code lost:
    
        if (r0 == null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0082, code lost:
    
        id.dana.component.customtoastcomponent.CustomToast.BuiltInFictitiousFunctionClassFactory(r0, id.dana.R.drawable.ic_warning_24, id.dana.R.drawable.bg_rounded_toast_payment_auth, r11, 72, true, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0087, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void PlaceComponentResult(id.dana.cashier.helper.CashierErrorState r11) {
        /*
            r10 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r1 = r11.MyBillsEntityDataFactory
            int r2 = r1.hashCode()
            r3 = 72
            r4 = 2131232158(0x7f08059e, float:1.8080417E38)
            r5 = 2131233844(0x7f080c34, float:1.8083837E38)
            switch(r2) {
                case -2080396080: goto L5e;
                case -1485728293: goto L55;
                case -630188208: goto L37;
                case 778234933: goto L17;
                default: goto L16;
            }
        L16:
            goto L88
        L17:
            java.lang.String r0 = "API_LIMITED"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L88
            id.dana.core.ui.model.UiTextModel r0 = r11.getAuthRequestContext
            android.content.Context r1 = r10.getContext()
            java.lang.String r4 = r0.asString(r1)
            java.lang.String r5 = r11.KClassImpl$Data$declaredNonStaticMembers$2
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 56
            java.lang.String r3 = "processing"
            r2 = r10
            getAuthRequestContext(r2, r3, r4, r5, r6, r7, r8, r9)
            return
        L37:
            java.lang.String r0 = "EXCEED_LIMIT"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L88
            id.dana.core.ui.model.UiTextModel r11 = r11.getAuthRequestContext
            android.content.Context r0 = r10.getContext()
            java.lang.String r11 = r11.asString(r0)
            androidx.fragment.app.FragmentActivity r0 = r10.getActivity()
            if (r0 == 0) goto L54
            android.app.Activity r0 = (android.app.Activity) r0
            id.dana.component.customtoastcomponent.CustomToast.MyBillsEntityDataFactory(r0, r5, r4, r11, r3)
        L54:
            return
        L55:
            java.lang.String r2 = "BCA_ONE_KLIK"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L66
            goto L88
        L5e:
            java.lang.String r2 = "RETRYABLE_RISK_CHALLENGE"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L88
        L66:
            id.dana.core.ui.model.UiTextModel r11 = r11.getAuthRequestContext
            android.content.Context r1 = r10.getContext()
            java.lang.String r11 = r11.asString(r1)
            if (r11 != 0) goto L7c
            r11 = 2131957285(0x7f131625, float:1.955115E38)
            java.lang.String r11 = r10.getString(r11)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r0)
        L7c:
            androidx.fragment.app.FragmentActivity r0 = r10.getActivity()
            if (r0 == 0) goto L87
            android.app.Activity r0 = (android.app.Activity) r0
            id.dana.component.customtoastcomponent.CustomToast.MyBillsEntityDataFactory(r0, r5, r4, r11, r3)
        L87:
            return
        L88:
            id.dana.core.ui.model.UiTextModel r0 = r11.getAuthRequestContext
            android.content.Context r1 = r10.getContext()
            java.lang.String r4 = r0.asString(r1)
            java.lang.String r5 = r11.KClassImpl$Data$declaredNonStaticMembers$2
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 56
            java.lang.String r3 = "fail"
            r2 = r10
            getAuthRequestContext(r2, r3, r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.fragment.BaseVBCashierFragment.PlaceComponentResult(id.dana.cashier.helper.CashierErrorState):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda5() {
        return Intrinsics.areEqual((String) this.NetworkUserEntityData$$ExternalSyntheticLambda5.getValue(), "Family Account");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void SubSequence() {
        FragmentActivity activity = getActivity();
        DanaLoadingDialog danaLoadingDialog = null;
        PayActivity payActivity = activity instanceof PayActivity ? (PayActivity) activity : null;
        if (payActivity != null) {
            payActivity.enableDisableActivityTouchEvent(false);
        }
        if (this.moveToNextValue) {
            return;
        }
        FrameLayout frameLayout = this.PlaceComponentResult;
        if (frameLayout != null) {
            LogoProgressView logoProgressView = this.GetContactSyncConfig;
            if (logoProgressView != null) {
                logoProgressView.startRefresh();
            }
            frameLayout.setVisibility(0);
            this.moveToNextValue = true;
            return;
        }
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null && frameLayout == null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new DanaLoadingDialog(getActivity());
        }
        DanaLoadingDialog danaLoadingDialog2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (danaLoadingDialog2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            danaLoadingDialog = danaLoadingDialog2;
        }
        if (!danaLoadingDialog.MyBillsEntityDataFactory.isShowing()) {
            danaLoadingDialog.MyBillsEntityDataFactory.show();
            danaLoadingDialog.getAuthRequestContext.startRefresh();
        }
        this.moveToNextValue = true;
    }
}
