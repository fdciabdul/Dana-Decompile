package id.dana.cashier.view;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import com.alibaba.ariver.kernel.RVEvents;
import com.alibaba.griver.api.jsapi.diagnostic.RecordError;
import com.anggrayudi.storage.permission.ActivityPermissionRequest;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import id.dana.R;
import id.dana.autoroute.BottomSheetAutoRoutingInfoActivity;
import id.dana.autoroute.BottomSheetNoAssetInfoActivity;
import id.dana.base.BaseActivity;
import id.dana.challenge.ChallengeControl;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.danah5.customdialog.CustomDialogKey;
import id.dana.dialog.DanaLoadingDialog;
import id.dana.dialog.DialogWithImage;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.pay.PayActivity;
import id.dana.richview.profile.switchautoroute.SwitchAutoRouteView;
import id.dana.utils.CustomToastUtil;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 M2\u00020\u0001:\u0001MB'\b\u0016\u0012\u0006\u0010E\u001a\u00020D\u0012\n\b\u0002\u0010G\u001a\u0004\u0018\u00010F\u0012\b\b\u0002\u0010H\u001a\u00020\u0006¢\u0006\u0004\bI\u0010JB+\b\u0016\u0012\u0006\u0010E\u001a\u00020D\u0012\b\u0010G\u001a\u0004\u0018\u00010F\u0012\u0006\u0010H\u001a\u00020\u0006\u0012\u0006\u0010K\u001a\u00020\u0006¢\u0006\u0004\bI\u0010LJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\n\u001a\u0004\u0018\u00010\tH\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001b\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001d\u0010\u0013J\u0017\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001e\u0010\u0013J'\u0010!\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u0019H\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0002H\u0016¢\u0006\u0004\b#\u0010\u0004J\u0017\u0010&\u001a\u00020\u00022\u0006\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b&\u0010'J\u0017\u0010)\u001a\u00020\u00022\u0006\u0010%\u001a\u00020(H\u0016¢\u0006\u0004\b)\u0010*J\u0017\u0010,\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u0010H\u0016¢\u0006\u0004\b,\u0010\u0013J\u000f\u0010-\u001a\u00020\u0002H\u0016¢\u0006\u0004\b-\u0010\u0004J\u000f\u0010.\u001a\u00020\u0002H\u0014¢\u0006\u0004\b.\u0010\u0004J\u000f\u0010/\u001a\u00020\u0002H\u0014¢\u0006\u0004\b/\u0010\u0004J\u000f\u00100\u001a\u00020\u0002H\u0016¢\u0006\u0004\b0\u0010\u0004J\u0017\u00102\u001a\u00020\u00022\u0006\u00101\u001a\u00020\u0010H\u0014¢\u0006\u0004\b2\u0010\u0013R.\u0010;\u001a\u0004\u0018\u0001032\b\u00104\u001a\u0004\u0018\u0001038\u0007@GX\u0086\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R(\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00020<8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010B"}, d2 = {"Lid/dana/cashier/view/CashierSmartPayView;", "Lid/dana/richview/profile/switchautoroute/SwitchAutoRouteView;", "", "activityResultRendering", "()V", "checkSmartPayAsset", "", "getLayout", "()I", "Landroid/content/DialogInterface$OnClickListener;", "getPinLockedListener", "()Landroid/content/DialogInterface$OnClickListener;", "Lid/dana/domain/profilemenu/model/SettingModel;", "data", "onBind", "(Lid/dana/domain/profilemenu/model/SettingModel;)V", "", "isHaveAsset", "onCheckHavingAutorouteAsset", "(Z)V", "Landroid/widget/CompoundButton;", "compoundButton", CustomDialogKey.Response.IS_CHECKED, "onCheckedChange", "(Landroid/widget/CompoundButton;Z)V", "", "errorMessage", RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, "(Ljava/lang/String;)V", "onSwitchResultAccept", "onSwitchResultReject", BioUtilityBridge.SECURITY_ID, RecordError.KEY_PUB_KEY, "onSwitchResultRisk", "(ZLjava/lang/String;Ljava/lang/String;)V", "revertChecked", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setSwitchButtonOnCheckedChangeListener", "(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V", "Landroid/view/View$OnClickListener;", "setSwitchButtonOnClickListener", "(Landroid/view/View$OnClickListener;)V", "isVisible", "setViewVisibility", "setup", "showErrorToast", "showPinLockedDialog", "showProgress", "autoRouteRequestedStatus", "showSuccessToast", "Lid/dana/base/BaseActivity;", "value", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/base/BaseActivity;", "getActivity", "()Lid/dana/base/BaseActivity;", "setActivity", "(Lid/dana/base/BaseActivity;)V", AkuEventParamsKey.KEY_ACTIVITY, "Lkotlin/Function0;", "PlaceComponentResult", "Lkotlin/jvm/functions/Function0;", "getOnSuccessActivationSmartPayListener", "()Lkotlin/jvm/functions/Function0;", "setOnSuccessActivationSmartPayListener", "(Lkotlin/jvm/functions/Function0;)V", "onSuccessActivationSmartPayListener", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class CashierSmartPayView extends SwitchAutoRouteView {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private BaseActivity activity;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private Function0<Unit> onSuccessActivationSmartPayListener;
    public Map<Integer, View> _$_findViewCache;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CashierSmartPayView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CashierSmartPayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.richview.profile.switchautoroute.SwitchAutoRouteView
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.richview.profile.switchautoroute.SwitchAutoRouteView
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

    @Override // id.dana.richview.profile.switchautoroute.SwitchAutoRouteView, id.dana.base.BaseRichView
    public final int getLayout() {
        return R.layout.view_cashier_smartpay;
    }

    @Override // id.dana.richview.profile.switchautoroute.SwitchAutoRouteView
    public final void onCheckedChange(CompoundButton compoundButton, boolean isChecked) {
        Intrinsics.checkNotNullParameter(compoundButton, "");
    }

    @Override // id.dana.richview.profile.switchautoroute.SwitchAutoRouteView
    public final void revertChecked() {
    }

    @Override // id.dana.richview.profile.switchautoroute.SwitchAutoRouteView
    public final void setSwitchButtonOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "");
    }

    @Override // id.dana.richview.profile.switchautoroute.SwitchAutoRouteView
    public final void setSwitchButtonOnClickListener(View.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "");
    }

    @Override // id.dana.richview.profile.switchautoroute.SwitchAutoRouteView
    public final void setViewVisibility(boolean isVisible) {
    }

    @Override // id.dana.richview.profile.switchautoroute.SwitchAutoRouteView, id.dana.base.BaseRichView
    public final void setup() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CashierSmartPayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.onSuccessActivationSmartPayListener = CashierSmartPayView$onSuccessActivationSmartPayListener$1.INSTANCE;
    }

    public /* synthetic */ CashierSmartPayView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CashierSmartPayView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.onSuccessActivationSmartPayListener = CashierSmartPayView$onSuccessActivationSmartPayListener$1.INSTANCE;
    }

    @JvmName(name = "getActivity")
    public final BaseActivity getActivity() {
        return this.activity;
    }

    @JvmName(name = "setActivity")
    public final void setActivity(BaseActivity baseActivity) {
        this.activity = baseActivity;
        if (baseActivity != null) {
            activityResultRendering();
        }
    }

    @JvmName(name = "getOnSuccessActivationSmartPayListener")
    public final Function0<Unit> getOnSuccessActivationSmartPayListener() {
        return this.onSuccessActivationSmartPayListener;
    }

    @JvmName(name = "setOnSuccessActivationSmartPayListener")
    public final void setOnSuccessActivationSmartPayListener(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "");
        this.onSuccessActivationSmartPayListener = function0;
    }

    @Override // id.dana.richview.profile.switchautoroute.SwitchAutoRouteView
    public final void onBind(SettingModel data) {
        if (data != null) {
            setAuthenticationType(data.getAutoRouteAuthenticationType());
        }
    }

    @Override // id.dana.richview.profile.switchautoroute.SwitchAutoRouteView, id.dana.richview.profile.switchautoroute.SwitchAutoRouteContract.View
    public final void onSwitchResultRisk(boolean isChecked, String securityId, String pubKey) {
        Intrinsics.checkNotNullParameter(securityId, "");
        Intrinsics.checkNotNullParameter(pubKey, "");
        BaseActivity baseActivity = this.activity;
        if (baseActivity != null) {
            ChallengeControl.Builder builder = new ChallengeControl.Builder(baseActivity);
            builder.scheduleImpl = "auto_route";
            builder.VerifyPinStateManager$executeRiskChallenge$2$1 = "auto_route";
            new ChallengeControl(builder.MyBillsEntityDataFactory(isChecked, securityId, pubKey), null).getAuthRequestContext();
        }
    }

    @Override // id.dana.richview.profile.switchautoroute.SwitchAutoRouteView, id.dana.richview.profile.switchautoroute.SwitchAutoRouteContract.View
    public final void onSwitchResultAccept(boolean isChecked) {
        showSuccessToast(isChecked);
    }

    @Override // id.dana.richview.profile.switchautoroute.SwitchAutoRouteView, id.dana.richview.profile.switchautoroute.SwitchAutoRouteContract.View
    public final void onSwitchResultReject(boolean isChecked) {
        showErrorToast();
    }

    @Override // id.dana.richview.profile.switchautoroute.SwitchAutoRouteView, id.dana.richview.profile.switchautoroute.SwitchAutoRouteContract.View
    public final void onCheckHavingAutorouteAsset(boolean isHaveAsset) {
        if (isHaveAsset) {
            BaseActivity baseActivity = this.activity;
            if (baseActivity != null) {
                baseActivity.startActivityForResult(new Intent(this.activity, BottomSheetAutoRoutingInfoActivity.class), 3001);
                return;
            }
            return;
        }
        BaseActivity baseActivity2 = this.activity;
        if (baseActivity2 != null) {
            baseActivity2.startActivity(new Intent(this.activity, BottomSheetNoAssetInfoActivity.class));
        }
    }

    @Override // id.dana.richview.profile.switchautoroute.SwitchAutoRouteView, id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final void onError(String errorMessage) {
        showErrorToast();
    }

    @Override // id.dana.richview.profile.switchautoroute.SwitchAutoRouteView
    public final void showPinLockedDialog() {
        BaseActivity baseActivity = this.activity;
        if (baseActivity != null) {
            DialogWithImage.BuiltInFictitiousFunctionClassFactory(baseActivity, getPinLockedListener()).MyBillsEntityDataFactory();
        }
    }

    @Override // id.dana.richview.profile.switchautoroute.SwitchAutoRouteView
    public final DialogInterface.OnClickListener getPinLockedListener() {
        return new DialogInterface.OnClickListener() { // from class: id.dana.cashier.view.CashierSmartPayView$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                CashierSmartPayView.m594$r8$lambda$9U09T9f6WDUHch0yJfvaya7f2Y(CashierSmartPayView.this, dialogInterface, i);
            }
        };
    }

    @Override // id.dana.richview.profile.switchautoroute.SwitchAutoRouteView
    public final void showSuccessToast(boolean autoRouteRequestedStatus) {
        String string = getContext().getString(autoRouteRequestedStatus ? R.string.auto_routing_success_activation : R.string.auto_routing_success_deactivation);
        Intrinsics.checkNotNullExpressionValue(string, "");
        BaseActivity baseActivity = this.activity;
        if (baseActivity != null) {
            BaseActivity baseActivity2 = baseActivity;
            String string2 = autoRouteRequestedStatus ? getContext().getString(R.string.toast_activate_success_smartpay) : "";
            Intrinsics.checkNotNullExpressionValue(string2, "");
            CustomToastUtil.getAuthRequestContext(baseActivity2, R.drawable.ic_success, R.drawable.bg_rounded_toast_auto_route, string, 48, 0, 60, false, string2);
        }
        this.onSuccessActivationSmartPayListener.invoke();
    }

    @Override // id.dana.richview.profile.switchautoroute.SwitchAutoRouteView
    public final void showErrorToast() {
        BaseActivity baseActivity = this.activity;
        if (baseActivity != null) {
            CustomToastUtil.PlaceComponentResult(baseActivity, R.drawable.ic_close_red, R.drawable.bg_rounded_toast_failed, getContext().getString(R.string.auto_routing_error), 48, 60, false, null, 384);
        }
    }

    @Override // id.dana.richview.profile.switchautoroute.SwitchAutoRouteView, id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final void showProgress() {
        BaseActivity baseActivity = this.activity;
        if (baseActivity != null) {
            setDanaLoadingDialog(new DanaLoadingDialog(baseActivity));
            DanaLoadingDialog danaLoadingDialog = getDanaLoadingDialog();
            if (danaLoadingDialog == null || danaLoadingDialog.MyBillsEntityDataFactory.isShowing()) {
                return;
            }
            danaLoadingDialog.MyBillsEntityDataFactory.show();
            danaLoadingDialog.getAuthRequestContext.startRefresh();
        }
    }

    public final void checkSmartPayAsset() {
        switchOnOperation();
    }

    /* renamed from: $r8$lambda$9U09T9f6WDUHch0yJfvaya-7f2Y  reason: not valid java name */
    public static /* synthetic */ void m594$r8$lambda$9U09T9f6WDUHch0yJfvaya7f2Y(CashierSmartPayView cashierSmartPayView, DialogInterface dialogInterface, int i) {
        ActivityPermissionRequest phonePermission;
        Intrinsics.checkNotNullParameter(cashierSmartPayView, "");
        Intrinsics.checkNotNullParameter(dialogInterface, "");
        if (i == -2) {
            dialogInterface.dismiss();
        } else if (i == -1) {
            BaseActivity baseActivity = cashierSmartPayView.activity;
            PayActivity payActivity = baseActivity instanceof PayActivity ? (PayActivity) baseActivity : null;
            if (payActivity != null && (phonePermission = payActivity.getPhonePermission()) != null) {
                phonePermission.check();
            }
            dialogInterface.dismiss();
        }
    }

    public static final /* synthetic */ PayActivity access$getPayActivity(CashierSmartPayView cashierSmartPayView) {
        BaseActivity baseActivity = cashierSmartPayView.activity;
        if (baseActivity instanceof PayActivity) {
            return (PayActivity) baseActivity;
        }
        return null;
    }

    @Override // id.dana.richview.profile.switchautoroute.SwitchAutoRouteView
    public final void activityResultRendering() {
        BaseActivity baseActivity = this.activity;
        PayActivity payActivity = baseActivity instanceof PayActivity ? (PayActivity) baseActivity : null;
        if (payActivity != null) {
            payActivity.setCashierSmartPayListener(new PayActivity.CashierSmartPayListener() { // from class: id.dana.cashier.view.CashierSmartPayView$activityResultRendering$1
                @Override // id.dana.pay.PayActivity.CashierSmartPayListener
                public final void getAuthRequestContext() {
                    CashierSmartPayView.this.showSuccessToast(true);
                }

                @Override // id.dana.pay.PayActivity.CashierSmartPayListener
                public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
                    PayActivity access$getPayActivity;
                    ActivityPermissionRequest phonePermission;
                    if (Intrinsics.areEqual(ChallengeControl.CancelReason.PIN_TEMPORARY_LOCKED, p0)) {
                        CashierSmartPayView.this.showPinLockedDialog();
                    } else if (Intrinsics.areEqual("forgot_pin", p0) && (access$getPayActivity = CashierSmartPayView.access$getPayActivity(CashierSmartPayView.this)) != null && (phonePermission = access$getPayActivity.getPhonePermission()) != null) {
                        phonePermission.check();
                    }
                    CashierSmartPayView.this.showErrorToast();
                }
            });
        }
    }
}
