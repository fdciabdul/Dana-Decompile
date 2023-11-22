package id.dana.cashier.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentActivity;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.internal.main.DialogLayout;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.api.constants.GriverEvents;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.anggrayudi.storage.permission.FragmentPermissionRequest;
import com.anggrayudi.storage.permission.PermissionCallback;
import com.anggrayudi.storage.permission.PermissionReport;
import com.anggrayudi.storage.permission.PermissionRequest;
import com.anggrayudi.storage.permission.PermissionResult;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.BaseActivity;
import id.dana.base.BaseFragment;
import id.dana.cashier.RiskParamsFactory;
import id.dana.cashier.model.AttributeCashierPayModel;
import id.dana.cashier.model.CashierPayMethodModel;
import id.dana.cashier.model.RiskVerificationMethodModel;
import id.dana.cashier.model.VoucherCashierModel;
import id.dana.component.customtoastcomponent.CustomToast;
import id.dana.component.dialogcomponent.CustomDialog;
import id.dana.component.dialogcomponent.CustomDialog$sam$android_view_View_OnClickListener$0;
import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.dialog.DanaLoadingDialog;
import id.dana.pay.PayActivity;
import id.dana.promoquest.handler.nativepage.NativePageType;
import id.dana.richview.LogoProgressView;
import id.dana.utils.KeyboardHelper;
import id.dana.utils.permission.PermissionHelper;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Deprecated(level = DeprecationLevel.WARNING, message = "This class would be removed soon. Please use BaseVBCashierFragment instead", replaceWith = @ReplaceWith(expression = "BaseVBCashierFragment", imports = {}))
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010:\u001a\u00020.H\u0016J\b\u0010;\u001a\u00020.H\u0004J\b\u0010<\u001a\u00020.H\u0016J\u0010\u0010=\u001a\u00020.2\u0006\u0010>\u001a\u00020\u0012H\u0004J\b\u0010?\u001a\u00020.H\u0004J\u0010\u0010@\u001a\u00020.2\u0006\u0010A\u001a\u00020BH\u0014J\n\u0010C\u001a\u0004\u0018\u00010DH\u0004JF\u0010E\u001a\u00020.2\u0006\u0010F\u001a\u00020\u00042\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010I\u001a\u00020\u00042\b\b\u0002\u0010J\u001a\u00020\u00042\b\b\u0002\u0010K\u001a\u00020\u0012H\u0014J\u0010\u0010L\u001a\u00020.2\u0006\u0010M\u001a\u00020NH\u0004J\u0006\u0010O\u001a\u00020.J\b\u0010P\u001a\u00020.H\u0014J\b\u0010Q\u001a\u00020.H\u0014J\b\u0010R\u001a\u00020.H\u0014J\b\u0010S\u001a\u00020.H\u0014J\b\u0010T\u001a\u00020.H\u0016J\b\u0010U\u001a\u00020.H\u0014J\b\u0010V\u001a\u00020\u0012H\u0004J\b\u0010W\u001a\u00020\u0012H\u0004J\b\u0010X\u001a\u00020\u0012H\u0004J\b\u0010Y\u001a\u00020\u0012H\u0004J\b\u0010Z\u001a\u00020\u0012H\u0004J\b\u0010[\u001a\u00020\u0012H\u0004J\b\u0010\\\u001a\u00020\u0012H\u0004J\b\u0010]\u001a\u00020\u0012H\u0004J\b\u0010^\u001a\u00020.H\u0004J&\u0010_\u001a\u0004\u0018\u00010`2\u0006\u0010a\u001a\u00020b2\b\u0010c\u001a\u0004\u0018\u00010d2\b\u0010e\u001a\u0004\u0018\u00010fH\u0016J\u0006\u0010g\u001a\u00020.J\b\u0010h\u001a\u00020.H\u0014J\b\u0010i\u001a\u00020.H\u0002J\u0010\u0010j\u001a\u00020.2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010k\u001a\u00020.H\u0016J\b\u0010l\u001a\u00020.H\u0014J\u001a\u0010m\u001a\u00020.2\u0006\u0010n\u001a\u00020`2\b\u0010e\u001a\u0004\u0018\u00010fH\u0016J\b\u0010o\u001a\u00020.H\u0004J\b\u0010p\u001a\u00020.H\u0014J\u0010\u0010q\u001a\u00020.2\u0006\u0010r\u001a\u00020\u0012H\u0004J\b\u0010s\u001a\u00020.H\u0004J\u0010\u0010t\u001a\u00020.2\u0006\u0010u\u001a\u00020\u0004H\u0004J\u0010\u0010v\u001a\u00020.2\u0006\u0010w\u001a\u00020\u0004H\u0002J\b\u0010x\u001a\u00020.H\u0004J\u001e\u0010y\u001a\u00020.2\b\u0010G\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010w\u001a\u0004\u0018\u00010\u0004H\u0004J\u0012\u0010z\u001a\u00020.2\b\u0010G\u001a\u0004\u0018\u00010\u0004H\u0004J\u001e\u0010{\u001a\u00020.2\u0014\b\u0002\u0010|\u001a\u000e\u0012\u0004\u0012\u00020`\u0012\u0004\u0012\u00020.0-H\u0004J\b\u0010}\u001a\u00020.H\u0004J\b\u0010~\u001a\u00020.H\u0016J\u0006\u0010\u007f\u001a\u00020.J\u0007\u0010\u0080\u0001\u001a\u00020.J\u0013\u0010\u0081\u0001\u001a\u00020.2\b\u0010G\u001a\u0004\u0018\u00010\u0004H\u0004J\u0013\u0010\u0082\u0001\u001a\u00020.2\b\u0010\u0083\u0001\u001a\u00030\u0084\u0001H\u0014J\u0012\u0010\u0085\u0001\u001a\u00020.2\u0007\u0010\u0086\u0001\u001a\u00020\u0012H\u0014J\u0019\u0010\u0087\u0001\u001a\u00020.*\u00030\u0088\u00012\t\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u0004H\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0012X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u000e\u0010\u0018\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u00048DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001a\u0010\u0006R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u0004X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0006\"\u0004\b%\u0010\bR\u001c\u0010&\u001a\u0004\u0018\u00010'X\u0094\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R&\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020.0-X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u00107\u001a\u0004\u0018\u00010\u0004X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0006\"\u0004\b9\u0010\b¨\u0006\u008a\u0001"}, d2 = {"Lid/dana/cashier/fragment/BaseCashierFragment;", "Lid/dana/base/BaseFragment;", "()V", "bizOrderId", "", "getBizOrderId", "()Ljava/lang/String;", "setBizOrderId", "(Ljava/lang/String;)V", "cameraPermission", "Lcom/anggrayudi/storage/permission/FragmentPermissionRequest;", "getCameraPermission", "()Lcom/anggrayudi/storage/permission/FragmentPermissionRequest;", "danaLoadingDialog", "Lid/dana/dialog/DanaLoadingDialog;", "danaLoadingLayout", "Landroid/widget/FrameLayout;", "isFallbackFaceAuth", "", "()Z", "setFallbackFaceAuth", "(Z)V", "isForceFaceAuth", "setForceFaceAuth", GriverMonitorConstants.KEY_IS_LOADING, "orderTitleFromSummary", "getOrderTitleFromSummary", "orderTitleFromSummary$delegate", "Lkotlin/Lazy;", "riskParamsFactory", "Lid/dana/cashier/RiskParamsFactory;", "getRiskParamsFactory", "()Lid/dana/cashier/RiskParamsFactory;", "setRiskParamsFactory", "(Lid/dana/cashier/RiskParamsFactory;)V", BioUtilityBridge.SECURITY_ID, "getSecurityId", "setSecurityId", "selectedCashierPromo", "Lid/dana/cashier/model/VoucherCashierModel;", "getSelectedCashierPromo", "()Lid/dana/cashier/model/VoucherCashierModel;", "setSelectedCashierPromo", "(Lid/dana/cashier/model/VoucherCashierModel;)V", "showAddOn", "Lkotlin/Function1;", "", "getShowAddOn", "()Lkotlin/jvm/functions/Function1;", "setShowAddOn", "(Lkotlin/jvm/functions/Function1;)V", "toolbarBackArrow", "Landroidx/appcompat/widget/AppCompatImageView;", "toolbarTitle", "Landroidx/appcompat/widget/AppCompatTextView;", "transType", "getTransType", "setTransType", "configToolbar", "dismissDanaLoadingProgress", "dismissSkeleton", "enableActivityTouchEvent", "isEnable", "expandBottomSheet", "getErrorState", "errorState", "Lid/dana/cashier/helper/CashierErrorState;", "getPayActivity", "Lid/dana/pay/PayActivity;", "goToPaymentResultPage", "status", "errorMessage", "errorCode", "addonId", "transactionScenario", "reloadBalance", "handleForceFaceAuth", "attributeCashierPayModel", "Lid/dana/cashier/model/AttributeCashierPayModel;", "hideToolbarBackArrow", IAPSyncCommand.COMMAND_INIT, "initCashierListener", "initComponent", "initPermission", "initToolbar", "initViews", "isFromFamilyAccountApproval", "isFromSendMoney", "isFromSendMoneyOverseas", "isX2b", "isX2c", "isX2g", "isX2l", "isX2p", "onBackToolbarPressed", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", BranchLinkConstant.PathTarget.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onFaceAuthFallback", "onPermissionGrantedFaceAuth", "onRedirectToSystemSetting", "onRequestCashierSmileToPay", "onResume", "onRiskFaceAuthFallback", "onViewCreated", "view", "popCurrentFragment", "prepareBundle", "setDismissAllowed", "isAllowed", "setHalfBottomSheet", GriverEvents.EVENT_SET_TITLE, "title", "setTitleContentDesc", "contentDesc", "showDanaLoadingProgress", "showErrorToast", "showFailedToast", "showForceFaceAuthDialog", "onClickVerify", "showOtpLimitedDialog", "showSkeleton", "showSmartpayActivationErrorToast", "showSmartpayActivationSuccessToast", "showWarningToast", "trackPaymentExecution", "payMethod", "Lid/dana/cashier/model/CashierPayMethodModel;", "trackPaymentFaceRiskChallenge", "isFaceVerificationSuccess", "setMerchantLogo", "Landroid/widget/ImageView;", "merchantLogoUrl", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class BaseCashierFragment extends BaseFragment {
    private VoucherCashierModel GetContactSyncConfig;
    private DanaLoadingDialog KClassImpl$Data$declaredNonStaticMembers$2;
    private FrameLayout NetworkUserEntityData$$ExternalSyntheticLambda0;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda1;
    private RiskParamsFactory NetworkUserEntityData$$ExternalSyntheticLambda2;
    private AppCompatTextView NetworkUserEntityData$$ExternalSyntheticLambda7;
    private final FragmentPermissionRequest PlaceComponentResult;
    public boolean getErrorConfigVersion;
    private AppCompatImageView isLayoutRequested;
    String lookAheadTest;
    private boolean moveToNextValue;
    public Map<Integer, View> MyBillsEntityDataFactory = new LinkedHashMap();
    private Function1<? super Boolean, Unit> PrepareContext = new Function1<Boolean, Unit>() { // from class: id.dana.cashier.fragment.BaseCashierFragment$showAddOn$1
        public final void invoke(boolean z) {
        }

        @Override // kotlin.jvm.functions.Function1
        public final /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.INSTANCE;
        }
    };
    private String initRecordTimeStamp = "";
    public String scheduleImpl = "";
    private final Lazy DatabaseTableConfigUtil = LazyKt.lazy(new Function0<String>() { // from class: id.dana.cashier.fragment.BaseCashierFragment$orderTitleFromSummary$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            FragmentActivity activity = BaseCashierFragment.this.getActivity();
            PayActivity payActivity = activity instanceof PayActivity ? (PayActivity) activity : null;
            String orderTitleFromSummary = payActivity != null ? payActivity.getOrderTitleFromSummary() : null;
            return orderTitleFromSummary == null ? "" : orderTitleFromSummary;
        }
    });

    public View BuiltInFictitiousFunctionClassFactory(int i) {
        View findViewById;
        Map<Integer, View> map = this.MyBillsEntityDataFactory;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View view2 = getView();
            if (view2 == null || (findViewById = view2.findViewById(i)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    protected void BuiltInFictitiousFunctionClassFactory() {
    }

    protected void BuiltInFictitiousFunctionClassFactory(String str, String str2, String str3, String str4, String str5, boolean z) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
    }

    public void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.MyBillsEntityDataFactory.clear();
    }

    public void KClassImpl$Data$declaredNonStaticMembers$2(RiskParamsFactory riskParamsFactory) {
        Intrinsics.checkNotNullParameter(riskParamsFactory, "");
    }

    protected void KClassImpl$Data$declaredNonStaticMembers$2(CashierPayMethodModel cashierPayMethodModel) {
        Intrinsics.checkNotNullParameter(cashierPayMethodModel, "");
    }

    protected void MyBillsEntityDataFactory(boolean z) {
    }

    public void NetworkUserEntityData$$ExternalSyntheticLambda0() {
    }

    protected void PlaceComponentResult() {
    }

    protected void PrepareContext() {
    }

    public void getAuthRequestContext() {
    }

    public void getErrorConfigVersion() {
    }

    public void initRecordTimeStamp() {
    }

    public void lookAheadTest() {
    }

    protected void moveToNextValue() {
    }

    @Override // id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public void whenAvailable() {
    }

    public BaseCashierFragment() {
        FragmentPermissionRequest.Builder builder = new FragmentPermissionRequest.Builder(this);
        String[] strArr = {"android.permission.CAMERA"};
        Intrinsics.checkNotNullParameter(strArr, "");
        builder.getAuthRequestContext = ArraysKt.toSet(strArr);
        PermissionCallback permissionCallback = new PermissionCallback() { // from class: id.dana.cashier.fragment.BaseCashierFragment$cameraPermission$1
            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final /* synthetic */ void onDisplayConsentDialog(PermissionRequest permissionRequest) {
                PermissionCallback.CC.getAuthRequestContext(permissionRequest);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onPermissionsChecked(PermissionResult p0, boolean p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                if (p0.MyBillsEntityDataFactory()) {
                    BaseCashierFragment.this.lookAheadTest();
                } else {
                    BaseCashierFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda0();
                }
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onShouldRedirectToSystemSettings(List<PermissionReport> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                BaseCashierFragment.KClassImpl$Data$declaredNonStaticMembers$2(BaseCashierFragment.this);
            }
        };
        Intrinsics.checkNotNullParameter(permissionCallback, "");
        builder.BuiltInFictitiousFunctionClassFactory = permissionCallback;
        this.PlaceComponentResult = builder.PlaceComponentResult();
    }

    @JvmName(name = "setShowAddOn")
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        this.PrepareContext = function1;
    }

    @JvmName(name = "getShowAddOn")
    public final Function1<Boolean, Unit> isLayoutRequested() {
        return this.PrepareContext;
    }

    @JvmName(name = "setRiskParamsFactory")
    public final void BuiltInFictitiousFunctionClassFactory(RiskParamsFactory riskParamsFactory) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = riskParamsFactory;
    }

    @JvmName(name = "getRiskParamsFactory")
    /* renamed from: GetContactSyncConfig  reason: from getter */
    public final RiskParamsFactory getNetworkUserEntityData$$ExternalSyntheticLambda2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda2;
    }

    @JvmName(name = "setSecurityId")
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.initRecordTimeStamp = str;
    }

    @JvmName(name = "getSecurityId")
    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from getter */
    public final String getInitRecordTimeStamp() {
        return this.initRecordTimeStamp;
    }

    @JvmName(name = "getSelectedCashierPromo")
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public VoucherCashierModel getGetContactSyncConfig() {
        return this.GetContactSyncConfig;
    }

    @JvmName(name = "setSelectedCashierPromo")
    public void getAuthRequestContext(VoucherCashierModel voucherCashierModel) {
        this.GetContactSyncConfig = voucherCashierModel;
    }

    @JvmName(name = "isForceFaceAuth")
    /* renamed from: newProxyInstance  reason: from getter */
    public final boolean getMoveToNextValue() {
        return this.moveToNextValue;
    }

    @JvmName(name = "getOrderTitleFromSummary")
    public final String DatabaseTableConfigUtil() {
        return (String) this.DatabaseTableConfigUtil.getValue();
    }

    @JvmName(name = "getCameraPermission")
    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from getter */
    public final FragmentPermissionRequest getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }

    @Override // id.dana.base.BaseFragment
    public void init() {
        PlaceComponentResult();
        PrepareContext();
        moveToNextValue();
        getErrorConfigVersion();
    }

    @Override // id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup r3, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "");
        View onCreateView = super.onCreateView(inflater, r3, savedInstanceState);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = onCreateView != null ? (FrameLayout) onCreateView.findViewById(R.id.flDanaLoading) : null;
        return onCreateView;
    }

    @Override // id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "");
        super.onViewCreated(view, savedInstanceState);
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = (AppCompatTextView) view.findViewById(R.id.tvTitlePage);
        this.isLayoutRequested = (AppCompatImageView) view.findViewById(R.id.f3832res_0x7f0a093d_property_propertytype_1);
        this.lookAheadTest = NetworkUserEntityData$$ExternalSyntheticLambda8() ? NativePageType.SEND_MONEY : null;
        AppCompatImageView appCompatImageView = this.isLayoutRequested;
        if (appCompatImageView != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.cashier.fragment.BaseCashierFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    BaseCashierFragment.MyBillsEntityDataFactory(BaseCashierFragment.this);
                }
            });
        }
        String string = getString(R.string.sdet_lbl_header);
        Intrinsics.checkNotNullExpressionValue(string, "");
        AppCompatTextView appCompatTextView = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
        if (appCompatTextView != null) {
            appCompatTextView.setContentDescription(string);
        }
        getAuthRequestContext();
    }

    @Override // id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        BuiltInFictitiousFunctionClassFactory();
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda2 == null || !this.getErrorConfigVersion) {
            return;
        }
        NetworkUserEntityData$$ExternalSyntheticLambda0();
        this.getErrorConfigVersion = false;
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(BaseCashierFragment baseCashierFragment, String str, String str2, String str3, String str4, String str5, boolean z, int i) {
        baseCashierFragment.BuiltInFictitiousFunctionClassFactory(str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? false : z);
    }

    public final void getAuthRequestContext(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        AppCompatTextView appCompatTextView = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
        if (appCompatTextView != null) {
            appCompatTextView.setText(str);
        }
    }

    public final void scheduleImpl() {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda1) {
            FrameLayout frameLayout = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (frameLayout != null) {
                LogoProgressView logoProgressView = (LogoProgressView) BuiltInFictitiousFunctionClassFactory(R.id.lpvLoading);
                if (logoProgressView != null) {
                    logoProgressView.stopRefresh();
                }
                frameLayout.setVisibility(8);
                this.NetworkUserEntityData$$ExternalSyntheticLambda1 = false;
            }
            DanaLoadingDialog danaLoadingDialog = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (danaLoadingDialog != null) {
                if (danaLoadingDialog == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    danaLoadingDialog = null;
                }
                danaLoadingDialog.PlaceComponentResult();
                this.NetworkUserEntityData$$ExternalSyntheticLambda1 = false;
            }
        }
        BaseActivity baseActivity = getBaseActivity();
        PayActivity payActivity = baseActivity instanceof PayActivity ? (PayActivity) baseActivity : null;
        if (payActivity != null) {
            payActivity.enableDisableActivityTouchEvent(true);
        }
    }

    public final void PlaceComponentResult(Function1<? super View, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        Context context = getContext();
        if (context != null) {
            CustomDialog.Builder builder = new CustomDialog.Builder(context);
            builder.SubSequence = getString(R.string.force_face_auth_title);
            builder.GetContactSyncConfig = getString(R.string.force_face_auth_content);
            String string = getString(R.string.force_face_auth_action);
            Intrinsics.checkNotNullParameter(function1, "");
            CustomDialog$sam$android_view_View_OnClickListener$0 customDialog$sam$android_view_View_OnClickListener$0 = new CustomDialog$sam$android_view_View_OnClickListener$0(function1);
            builder.NetworkUserEntityData$$ExternalSyntheticLambda6 = string;
            builder.getSupportButtonTintMode = customDialog$sam$android_view_View_OnClickListener$0;
            CustomDialog.Builder KClassImpl$Data$declaredNonStaticMembers$2 = builder.PlaceComponentResult(true).KClassImpl$Data$declaredNonStaticMembers$2(true);
            KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue = 0L;
            MaterialDialog BuiltInFictitiousFunctionClassFactory = KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory();
            DialogLayout view = BuiltInFictitiousFunctionClassFactory.getView();
            int BuiltInFictitiousFunctionClassFactory2 = ContextCompat.BuiltInFictitiousFunctionClassFactory(context, R.color.f26522131100321);
            ((TextView) view.findViewById(16908310)).setTextColor(BuiltInFictitiousFunctionClassFactory2);
            TextView textView = (TextView) view.findViewById(16908304);
            textView.setTextColor(BuiltInFictitiousFunctionClassFactory2);
            textView.setTypeface(ResourcesCompat.PlaceComponentResult(textView.getContext(), (int) R.font.sf_pro_regular));
            BuiltInFictitiousFunctionClassFactory.show();
        }
    }

    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda7() {
        BaseActivity baseActivity = getBaseActivity();
        return Intrinsics.areEqual(baseActivity != null ? baseActivity.getSource() : null, "Family Account");
    }

    public final void PlaceComponentResult(AttributeCashierPayModel attributeCashierPayModel) {
        RiskVerificationMethodModel riskVerificationMethodModel;
        Intrinsics.checkNotNullParameter(attributeCashierPayModel, "");
        this.moveToNextValue = true;
        List<RiskVerificationMethodModel> list = attributeCashierPayModel.SummaryVoucherView$$ExternalSyntheticLambda1;
        String str = (list == null || (riskVerificationMethodModel = (RiskVerificationMethodModel) CollectionsKt.firstOrNull((List) list)) == null) ? null : riskVerificationMethodModel.MyBillsEntityDataFactory;
        this.initRecordTimeStamp = str != null ? str : "";
        this.PlaceComponentResult.check();
    }

    public final void SubSequence() {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda2 == null || !this.getErrorConfigVersion) {
            return;
        }
        NetworkUserEntityData$$ExternalSyntheticLambda0();
        this.getErrorConfigVersion = false;
    }

    public final boolean getSupportButtonTintMode() {
        FragmentActivity activity = getActivity();
        PayActivity payActivity = activity instanceof PayActivity ? (PayActivity) activity : null;
        return Intrinsics.areEqual(payActivity != null ? payActivity.getTransferType() : null, "BALANCE");
    }

    public final boolean FragmentBottomSheetPaymentSettingBinding() {
        FragmentActivity activity = getActivity();
        PayActivity payActivity = activity instanceof PayActivity ? (PayActivity) activity : null;
        return Intrinsics.areEqual(payActivity != null ? payActivity.getTransferType() : null, "BANK_TRANSFER");
    }

    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda3() {
        FragmentActivity activity = getActivity();
        PayActivity payActivity = activity instanceof PayActivity ? (PayActivity) activity : null;
        return Intrinsics.areEqual(payActivity != null ? payActivity.getTransferType() : null, "LINK");
    }

    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda5() {
        FragmentActivity activity = getActivity();
        PayActivity payActivity = activity instanceof PayActivity ? (PayActivity) activity : null;
        return Intrinsics.areEqual(payActivity != null ? payActivity.getTransferType() : null, "OTC");
    }

    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda6() {
        return Intrinsics.areEqual(getBaseActivity().getSource(), "Group Send");
    }

    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda4() {
        return Intrinsics.areEqual(getBaseActivity().getSource(), TrackerKey.SourceType.TRANSFER_OVERSEAS);
    }

    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda8() {
        return Intrinsics.areEqual(getBaseActivity().getSource(), "Send Money") || NetworkUserEntityData$$ExternalSyntheticLambda6();
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(BaseCashierFragment baseCashierFragment) {
        Intrinsics.checkNotNullParameter(baseCashierFragment, "");
        KeyboardHelper.BuiltInFictitiousFunctionClassFactory(baseCashierFragment.getBaseActivity());
        BaseActivity baseActivity = baseCashierFragment.getBaseActivity();
        PayActivity payActivity = baseActivity instanceof PayActivity ? (PayActivity) baseActivity : null;
        if (payActivity != null) {
            payActivity.onBackPressed();
        }
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(BaseCashierFragment baseCashierFragment) {
        BaseActivity baseActivity = baseCashierFragment.getBaseActivity();
        Intrinsics.checkNotNullExpressionValue(baseActivity, "");
        PermissionHelper.MyBillsEntityDataFactory(baseActivity);
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(BaseCashierFragment baseCashierFragment, String str) {
        BaseActivity baseActivity = baseCashierFragment.getBaseActivity();
        Intrinsics.checkNotNullExpressionValue(baseActivity, "");
        CustomToast.BuiltInFictitiousFunctionClassFactory(baseActivity, R.drawable.ic_warning_24, R.drawable.bg_rounded_toast_payment_auth, str, 72, true, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0060, code lost:
    
        if (r1.equals("BCA_ONE_KLIK") == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0069, code lost:
    
        if (r1.equals(id.dana.cashier.helper.CashierErrorType.RETRYABLE_RISK_CHALLENGE) != false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x006b, code lost:
    
        r11 = r11.getAuthRequestContext.asString(getContext());
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0075, code lost:
    
        if (r11 != null) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0077, code lost:
    
        r11 = getString(id.dana.R.string.SchedulerPoolFactory);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, "");
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0081, code lost:
    
        r4 = r11;
        r11 = getBaseActivity();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, "");
        id.dana.component.customtoastcomponent.CustomToast.BuiltInFictitiousFunctionClassFactory(r11, id.dana.R.drawable.ic_warning_24, id.dana.R.drawable.bg_rounded_toast_payment_auth, r4, 72, true, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0099, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void KClassImpl$Data$declaredNonStaticMembers$2(id.dana.cashier.helper.CashierErrorState r11) {
        /*
            r10 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r1 = r11.MyBillsEntityDataFactory
            int r2 = r1.hashCode()
            switch(r2) {
                case -2080396080: goto L63;
                case -1485728293: goto L5a;
                case -630188208: goto L30;
                case 778234933: goto L10;
                default: goto Le;
            }
        Le:
            goto L9a
        L10:
            java.lang.String r0 = "API_LIMITED"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L9a
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
            KClassImpl$Data$declaredNonStaticMembers$2(r2, r3, r4, r5, r6, r7, r8, r9)
            return
        L30:
            java.lang.String r2 = "EXCEED_LIMIT"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L9a
            id.dana.core.ui.model.UiTextModel r11 = r11.getAuthRequestContext
            android.content.Context r1 = r10.getContext()
            java.lang.String r5 = r11.asString(r1)
            r8 = 0
            id.dana.base.BaseActivity r11 = r10.getBaseActivity()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r0)
            r2 = r11
            android.app.Activity r2 = (android.app.Activity) r2
            r3 = 2131233844(0x7f080c34, float:1.8083837E38)
            r4 = 2131232158(0x7f08059e, float:1.8080417E38)
            r6 = 72
            r7 = 1
            id.dana.component.customtoastcomponent.CustomToast.BuiltInFictitiousFunctionClassFactory(r2, r3, r4, r5, r6, r7, r8)
            return
        L5a:
            java.lang.String r2 = "BCA_ONE_KLIK"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L6b
            goto L9a
        L63:
            java.lang.String r2 = "RETRYABLE_RISK_CHALLENGE"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L9a
        L6b:
            id.dana.core.ui.model.UiTextModel r11 = r11.getAuthRequestContext
            android.content.Context r1 = r10.getContext()
            java.lang.String r11 = r11.asString(r1)
            if (r11 != 0) goto L81
            r11 = 2131957285(0x7f131625, float:1.955115E38)
            java.lang.String r11 = r10.getString(r11)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r0)
        L81:
            r4 = r11
            r7 = 0
            id.dana.base.BaseActivity r11 = r10.getBaseActivity()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r0)
            r1 = r11
            android.app.Activity r1 = (android.app.Activity) r1
            r2 = 2131233844(0x7f080c34, float:1.8083837E38)
            r3 = 2131232158(0x7f08059e, float:1.8080417E38)
            r5 = 72
            r6 = 1
            id.dana.component.customtoastcomponent.CustomToast.BuiltInFictitiousFunctionClassFactory(r1, r2, r3, r4, r5, r6, r7)
            return
        L9a:
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
            KClassImpl$Data$declaredNonStaticMembers$2(r2, r3, r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.fragment.BaseCashierFragment.KClassImpl$Data$declaredNonStaticMembers$2(id.dana.cashier.helper.CashierErrorState):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x002f, code lost:
    
        if (NetworkUserEntityData$$ExternalSyntheticLambda4() != false) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void getAuthRequestContext(android.widget.ImageView r3, java.lang.String r4) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            id.dana.base.BaseActivity r0 = r2.getBaseActivity()
            boolean r1 = r0 instanceof id.dana.pay.PayActivity
            if (r1 == 0) goto L10
            id.dana.pay.PayActivity r0 = (id.dana.pay.PayActivity) r0
            goto L11
        L10:
            r0 = 0
        L11:
            r1 = 1
            if (r0 == 0) goto L1a
            boolean r0 = r0.isFromDanaKagetRevamp()
            if (r0 == r1) goto L1b
        L1a:
            r1 = 0
        L1b:
            if (r1 == 0) goto L25
            r4 = 2131232906(0x7f08088a, float:1.8081934E38)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            goto L38
        L25:
            boolean r0 = r2.NetworkUserEntityData$$ExternalSyntheticLambda8()
            if (r0 != 0) goto L31
            boolean r0 = r2.NetworkUserEntityData$$ExternalSyntheticLambda4()
            if (r0 == 0) goto L38
        L31:
            r4 = 2131233660(0x7f080b7c, float:1.8083464E38)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
        L38:
            android.content.Context r0 = r3.getContext()
            if (r0 == 0) goto L56
            com.bumptech.glide.RequestManager r0 = com.bumptech.glide.Glide.KClassImpl$Data$declaredNonStaticMembers$2(r0)
            com.bumptech.glide.RequestBuilder r0 = r0.PlaceComponentResult()
            com.bumptech.glide.RequestBuilder r4 = r0.MyBillsEntityDataFactory(r4)
            r0 = 2131231788(0x7f08042c, float:1.8079667E38)
            com.bumptech.glide.request.BaseRequestOptions r4 = r4.BuiltInFictitiousFunctionClassFactory(r0)
            com.bumptech.glide.RequestBuilder r4 = (com.bumptech.glide.RequestBuilder) r4
            r4.MyBillsEntityDataFactory(r3)
        L56:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.fragment.BaseCashierFragment.getAuthRequestContext(android.widget.ImageView, java.lang.String):void");
    }

    public final void readMicros() {
        BaseActivity baseActivity = getBaseActivity();
        DanaLoadingDialog danaLoadingDialog = null;
        PayActivity payActivity = baseActivity instanceof PayActivity ? (PayActivity) baseActivity : null;
        if (payActivity != null) {
            payActivity.enableDisableActivityTouchEvent(false);
        }
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda1) {
            return;
        }
        FrameLayout frameLayout = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (frameLayout == null) {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null && frameLayout == null) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = new DanaLoadingDialog(getBaseActivity());
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
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = true;
            return;
        }
        frameLayout.setVisibility(0);
        LogoProgressView logoProgressView = (LogoProgressView) BuiltInFictitiousFunctionClassFactory(R.id.lpvLoading);
        if (logoProgressView != null) {
            logoProgressView.startRefresh();
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = true;
    }
}
