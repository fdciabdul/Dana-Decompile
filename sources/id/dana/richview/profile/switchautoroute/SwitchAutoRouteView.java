package id.dana.richview.profile.switchautoroute;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.res.ResourcesCompat;
import com.alibaba.ariver.kernel.RVEvents;
import com.alibaba.griver.api.jsapi.diagnostic.RecordError;
import com.anggrayudi.storage.permission.ActivityPermissionRequest;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.autoroute.BottomSheetAutoRoutingInfoActivity;
import id.dana.autoroute.BottomSheetNoAssetInfoActivity;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.base.BaseRichView;
import id.dana.challenge.ChallengeControl;
import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.danah5.customdialog.CustomDialogKey;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerSwitchAutoRouteComponent;
import id.dana.di.modules.SwitchAutoRouteModule;
import id.dana.dialog.DanaLoadingDialog;
import id.dana.dialog.DialogWithImage;
import id.dana.dialog.TwoButtonWithImageDialog;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.myprofile.SettingMoreProfileActivity;
import id.dana.richview.profile.switchautoroute.SwitchAutoRouteContract;
import id.dana.utils.CustomToastUtil;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 g2\u00020\u00012\u00020\u0002:\u0001gB'\b\u0016\u0012\u0006\u0010_\u001a\u00020^\u0012\n\b\u0002\u0010a\u001a\u0004\u0018\u00010`\u0012\b\b\u0002\u0010b\u001a\u00020\u000b¢\u0006\u0004\bc\u0010dB+\b\u0016\u0012\u0006\u0010_\u001a\u00020^\u0012\b\u0010a\u001a\u0004\u0018\u00010`\u0012\u0006\u0010b\u001a\u00020\u000b\u0012\u0006\u0010e\u001a\u00020\u000b¢\u0006\u0004\bc\u0010fJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\n\u0010\u0005J\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0011\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0016\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u001a\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001d\u0010\tJ\u001f\u0010!\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0006H\u0016¢\u0006\u0004\b!\u0010\"J\u0019\u0010%\u001a\u00020\u00032\b\u0010$\u001a\u0004\u0018\u00010#H\u0016¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0003H\u0016¢\u0006\u0004\b'\u0010\u0005J\u0017\u0010(\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0006H\u0016¢\u0006\u0004\b(\u0010\tJ\u0017\u0010)\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0006H\u0016¢\u0006\u0004\b)\u0010\tJ'\u0010,\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u00062\u0006\u0010*\u001a\u00020#2\u0006\u0010+\u001a\u00020#H\u0016¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\u0003H\u0016¢\u0006\u0004\b.\u0010\u0005J\u0017\u0010/\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b/\u0010\tJ\u0017\u00102\u001a\u00020\u00032\u0006\u00101\u001a\u000200H\u0016¢\u0006\u0004\b2\u00103J\u0017\u00105\u001a\u00020\u00032\u0006\u00101\u001a\u000204H\u0016¢\u0006\u0004\b5\u00106J\u0017\u00108\u001a\u00020\u00032\u0006\u00107\u001a\u00020\u0006H\u0016¢\u0006\u0004\b8\u0010\tJ\u000f\u00109\u001a\u00020\u0003H\u0016¢\u0006\u0004\b9\u0010\u0005J\u000f\u0010:\u001a\u00020\u0003H\u0014¢\u0006\u0004\b:\u0010\u0005J\u000f\u0010;\u001a\u00020\u0003H\u0014¢\u0006\u0004\b;\u0010\u0005J\u000f\u0010<\u001a\u00020\u0003H\u0016¢\u0006\u0004\b<\u0010\u0005J\u0017\u0010>\u001a\u00020\u00032\u0006\u0010=\u001a\u00020\u0006H\u0014¢\u0006\u0004\b>\u0010\tJ\u000f\u0010?\u001a\u00020\u0003H\u0004¢\u0006\u0004\b?\u0010\u0005R$\u0010E\u001a\u0004\u0018\u00010#8\u0005@\u0005X\u0084\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010&R\u0018\u0010H\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\b\u0010GR$\u0010O\u001a\u0004\u0018\u00010I8\u0005@\u0005X\u0085\u000e¢\u0006\u0012\n\u0004\b/\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\"\u0010Q\u001a\u00020P8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\"\u0010X\u001a\u00020W8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]"}, d2 = {"Lid/dana/richview/profile/switchautoroute/SwitchAutoRouteView;", "Lid/dana/base/BaseRichView;", "Lid/dana/richview/profile/switchautoroute/SwitchAutoRouteContract$View;", "", "activityResultRendering", "()V", "", "p0", "PlaceComponentResult", "(Z)V", "dismissProgress", "", "getLayout", "()I", "Landroid/content/DialogInterface$OnClickListener;", "getPinLockedListener", "()Landroid/content/DialogInterface$OnClickListener;", "Lid/dana/myprofile/SettingMoreProfileActivity;", "getSettingMoreProfileActivity", "()Lid/dana/myprofile/SettingMoreProfileActivity;", "Lid/dana/di/component/ApplicationComponent;", "applicationComponent", "injectComponent", "(Lid/dana/di/component/ApplicationComponent;)V", "Lid/dana/domain/profilemenu/model/SettingModel;", "data", "onBind", "(Lid/dana/domain/profilemenu/model/SettingModel;)V", "isHaveAsset", "onCheckHavingAutorouteAsset", "Landroid/widget/CompoundButton;", "compoundButton", CustomDialogKey.Response.IS_CHECKED, "onCheckedChange", "(Landroid/widget/CompoundButton;Z)V", "", "errorMessage", RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, "(Ljava/lang/String;)V", "onProceedSwitchOn", "onSwitchResultAccept", "onSwitchResultReject", BioUtilityBridge.SECURITY_ID, RecordError.KEY_PUB_KEY, "onSwitchResultRisk", "(ZLjava/lang/String;Ljava/lang/String;)V", "revertChecked", "getAuthRequestContext", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setSwitchButtonOnCheckedChangeListener", "(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V", "Landroid/view/View$OnClickListener;", "setSwitchButtonOnClickListener", "(Landroid/view/View$OnClickListener;)V", "isVisible", "setViewVisibility", "setup", "showErrorToast", "showPinLockedDialog", "showProgress", "autoRouteRequestedStatus", "showSuccessToast", "switchOnOperation", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "getAuthenticationType", "()Ljava/lang/String;", "setAuthenticationType", "authenticationType", "Lid/dana/dialog/TwoButtonWithImageDialog;", "Lid/dana/dialog/TwoButtonWithImageDialog;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/dialog/DanaLoadingDialog;", "Lid/dana/dialog/DanaLoadingDialog;", "getDanaLoadingDialog", "()Lid/dana/dialog/DanaLoadingDialog;", "setDanaLoadingDialog", "(Lid/dana/dialog/DanaLoadingDialog;)V", "danaLoadingDialog", "Lid/dana/richview/profile/switchautoroute/SwitchAutoRouteAnalyticsTracker;", "switchAutoRouteAnalyticsTracker", "Lid/dana/richview/profile/switchautoroute/SwitchAutoRouteAnalyticsTracker;", "getSwitchAutoRouteAnalyticsTracker", "()Lid/dana/richview/profile/switchautoroute/SwitchAutoRouteAnalyticsTracker;", "setSwitchAutoRouteAnalyticsTracker", "(Lid/dana/richview/profile/switchautoroute/SwitchAutoRouteAnalyticsTracker;)V", "Lid/dana/richview/profile/switchautoroute/SwitchAutoRoutePresenter;", "switchAutoRoutePresenter", "Lid/dana/richview/profile/switchautoroute/SwitchAutoRoutePresenter;", "getSwitchAutoRoutePresenter", "()Lid/dana/richview/profile/switchautoroute/SwitchAutoRoutePresenter;", "setSwitchAutoRoutePresenter", "(Lid/dana/richview/profile/switchautoroute/SwitchAutoRoutePresenter;)V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public class SwitchAutoRouteView extends BaseRichView implements SwitchAutoRouteContract.View {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private String authenticationType;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private TwoButtonWithImageDialog KClassImpl$Data$declaredNonStaticMembers$2;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private DanaLoadingDialog danaLoadingDialog;
    @Inject
    public SwitchAutoRouteAnalyticsTracker switchAutoRouteAnalyticsTracker;
    @Inject
    public SwitchAutoRoutePresenter switchAutoRoutePresenter;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SwitchAutoRouteView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SwitchAutoRouteView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i) {
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

    @Override // id.dana.base.AbstractContractKt.AbstractView
    public /* synthetic */ String getErrorSource() {
        return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
    }

    @Override // id.dana.base.BaseRichView
    public int getLayout() {
        return R.layout.item_menu_switch_button;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwitchAutoRouteView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ SwitchAutoRouteView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwitchAutoRouteView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    @JvmName(name = "getSwitchAutoRoutePresenter")
    public final SwitchAutoRoutePresenter getSwitchAutoRoutePresenter() {
        SwitchAutoRoutePresenter switchAutoRoutePresenter = this.switchAutoRoutePresenter;
        if (switchAutoRoutePresenter != null) {
            return switchAutoRoutePresenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setSwitchAutoRoutePresenter")
    public final void setSwitchAutoRoutePresenter(SwitchAutoRoutePresenter switchAutoRoutePresenter) {
        Intrinsics.checkNotNullParameter(switchAutoRoutePresenter, "");
        this.switchAutoRoutePresenter = switchAutoRoutePresenter;
    }

    @JvmName(name = "getSwitchAutoRouteAnalyticsTracker")
    public final SwitchAutoRouteAnalyticsTracker getSwitchAutoRouteAnalyticsTracker() {
        SwitchAutoRouteAnalyticsTracker switchAutoRouteAnalyticsTracker = this.switchAutoRouteAnalyticsTracker;
        if (switchAutoRouteAnalyticsTracker != null) {
            return switchAutoRouteAnalyticsTracker;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setSwitchAutoRouteAnalyticsTracker")
    public final void setSwitchAutoRouteAnalyticsTracker(SwitchAutoRouteAnalyticsTracker switchAutoRouteAnalyticsTracker) {
        Intrinsics.checkNotNullParameter(switchAutoRouteAnalyticsTracker, "");
        this.switchAutoRouteAnalyticsTracker = switchAutoRouteAnalyticsTracker;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @JvmName(name = "getDanaLoadingDialog")
    public final DanaLoadingDialog getDanaLoadingDialog() {
        return this.danaLoadingDialog;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @JvmName(name = "setDanaLoadingDialog")
    public final void setDanaLoadingDialog(DanaLoadingDialog danaLoadingDialog) {
        this.danaLoadingDialog = danaLoadingDialog;
    }

    @JvmName(name = "getAuthenticationType")
    protected final String getAuthenticationType() {
        return this.authenticationType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @JvmName(name = "setAuthenticationType")
    public final void setAuthenticationType(String str) {
        this.authenticationType = str;
    }

    @Override // id.dana.base.BaseRichView
    public void setup() {
        activityResultRendering();
    }

    @Override // id.dana.base.BaseRichView
    public void injectComponent(ApplicationComponent applicationComponent) {
        DaggerSwitchAutoRouteComponent.Builder MyBillsEntityDataFactory = DaggerSwitchAutoRouteComponent.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory.getAuthRequestContext = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = (SwitchAutoRouteModule) Preconditions.getAuthRequestContext(new SwitchAutoRouteModule(this));
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory().MyBillsEntityDataFactory(this);
        registerPresenter(getSwitchAutoRoutePresenter());
    }

    public void setSwitchButtonOnClickListener(View.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "");
        ((SwitchCompat) _$_findCachedViewById(R.id.GroupDetailUiState$OnSuccessGetLeastTransactionFavoriteAccount)).setOnClickListener(listener);
    }

    public void setSwitchButtonOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "");
        ((SwitchCompat) _$_findCachedViewById(R.id.GroupDetailUiState$OnSuccessGetLeastTransactionFavoriteAccount)).setOnCheckedChangeListener(listener);
    }

    public void setViewVisibility(boolean isVisible) {
        ((RelativeLayout) _$_findCachedViewById(R.id.LayoutAddBankBinding)).setVisibility(isVisible ? 0 : 8);
        _$_findCachedViewById(R.id.res_0x7f0a1a0b_filter_jgv0xpq).setVisibility(isVisible ? 0 : 8);
    }

    public void onBind(SettingModel data) {
        if (data != null) {
            this.authenticationType = data.getAutoRouteAuthenticationType();
            setViewVisibility(data.isNeedToShow());
            ((TextView) _$_findCachedViewById(R.id.setDrawValueAboveBar)).setText(data.getTitle());
            getAuthRequestContext(data.isAutoRouteSwitch());
            PlaceComponentResult(data.isAutoRouteSwitch());
        }
    }

    public void onCheckedChange(CompoundButton compoundButton, boolean isChecked) {
        Intrinsics.checkNotNullParameter(compoundButton, "");
        PlaceComponentResult(isChecked);
        if (compoundButton.getTag() != null) {
            compoundButton.setTag(null);
        } else if (isChecked) {
            switchOnOperation();
        } else {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                TwoButtonWithImageDialog.Builder builder = new TwoButtonWithImageDialog.Builder(getContext());
                builder.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.ic_auto_route_disable;
                builder.FragmentBottomSheetPaymentSettingBinding = getResources().getString(R.string.disable_auto_routing_title);
                builder.getErrorConfigVersion = getResources().getString(R.string.disable_auto_routing_message);
                String string = getResources().getString(R.string.disable_auto_routing_positive);
                View.OnClickListener onClickListener = new View.OnClickListener() { // from class: id.dana.richview.profile.switchautoroute.SwitchAutoRouteView$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SwitchAutoRouteView.$r8$lambda$Z8XtX33lSOAeQFs678k4z2ATbNo(SwitchAutoRouteView.this, view);
                    }
                };
                builder.NetworkUserEntityData$$ExternalSyntheticLambda8 = string;
                builder.NetworkUserEntityData$$ExternalSyntheticLambda4 = onClickListener;
                String string2 = getResources().getString(R.string.disable_auto_routing_negative);
                View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: id.dana.richview.profile.switchautoroute.SwitchAutoRouteView$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SwitchAutoRouteView.$r8$lambda$E_v85vCtrgHY2s8dviBcXyIhstc(SwitchAutoRouteView.this, view);
                    }
                };
                builder.NetworkUserEntityData$$ExternalSyntheticLambda2 = string2;
                builder.DatabaseTableConfigUtil = onClickListener2;
                builder.initRecordTimeStamp = true;
                this.KClassImpl$Data$declaredNonStaticMembers$2 = builder.PlaceComponentResult(false).MyBillsEntityDataFactory(false).KClassImpl$Data$declaredNonStaticMembers$2();
            }
            TwoButtonWithImageDialog twoButtonWithImageDialog = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (twoButtonWithImageDialog != null) {
                twoButtonWithImageDialog.MyBillsEntityDataFactory();
            }
        }
    }

    public void revertChecked() {
        getAuthRequestContext(!((SwitchCompat) _$_findCachedViewById(R.id.GroupDetailUiState$OnSuccessGetLeastTransactionFavoriteAccount)).isChecked());
    }

    public void onSwitchResultRisk(boolean isChecked, String securityId, String pubKey) {
        Intrinsics.checkNotNullParameter(securityId, "");
        Intrinsics.checkNotNullParameter(pubKey, "");
        BaseActivity baseActivity = getBaseActivity();
        Intrinsics.checkNotNullExpressionValue(baseActivity, "");
        ChallengeControl.Builder builder = new ChallengeControl.Builder(baseActivity);
        builder.scheduleImpl = "auto_route";
        builder.VerifyPinStateManager$executeRiskChallenge$2$1 = "auto_route";
        new ChallengeControl(builder.MyBillsEntityDataFactory(isChecked, securityId, pubKey), null).getAuthRequestContext();
    }

    public void onSwitchResultAccept(boolean isChecked) {
        String source;
        SwitchAutoRouteAnalyticsTracker switchAutoRouteAnalyticsTracker = getSwitchAutoRouteAnalyticsTracker();
        BaseActivity baseActivity = getBaseActivity();
        Intrinsics.checkNotNullExpressionValue(baseActivity, "");
        if (TextUtils.isEmpty(baseActivity.getSource())) {
            source = TrackerKey.SourceType.PROFILE;
        } else {
            source = baseActivity.getSource();
            Intrinsics.checkNotNullExpressionValue(source, "");
        }
        switchAutoRouteAnalyticsTracker.BuiltInFictitiousFunctionClassFactory(source, isChecked);
        showSuccessToast(isChecked);
    }

    public void onSwitchResultReject(boolean isChecked) {
        revertChecked();
        showErrorToast();
    }

    public void onProceedSwitchOn() {
        getSwitchAutoRoutePresenter().MyBillsEntityDataFactory(true, this.authenticationType);
    }

    public void onCheckHavingAutorouteAsset(boolean isHaveAsset) {
        if (isHaveAsset) {
            getBaseActivity().startActivityForResult(new Intent(getBaseActivity(), BottomSheetAutoRoutingInfoActivity.class), 2001);
        } else {
            getBaseActivity().startActivity(new Intent(getBaseActivity(), BottomSheetNoAssetInfoActivity.class));
        }
    }

    public void showProgress() {
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity != null) {
            DanaLoadingDialog danaLoadingDialog = new DanaLoadingDialog(baseActivity);
            this.danaLoadingDialog = danaLoadingDialog;
            if (danaLoadingDialog.MyBillsEntityDataFactory.isShowing()) {
                return;
            }
            danaLoadingDialog.MyBillsEntityDataFactory.show();
            danaLoadingDialog.getAuthRequestContext.startRefresh();
        }
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public void dismissProgress() {
        DanaLoadingDialog danaLoadingDialog = this.danaLoadingDialog;
        if (danaLoadingDialog != null) {
            danaLoadingDialog.PlaceComponentResult();
        }
    }

    public void onError(String errorMessage) {
        showErrorToast();
        revertChecked();
    }

    private final void getAuthRequestContext(boolean p0) {
        ((SwitchCompat) _$_findCachedViewById(R.id.GroupDetailUiState$OnSuccessGetLeastTransactionFavoriteAccount)).setTag("SwitchIgnore");
        ((SwitchCompat) _$_findCachedViewById(R.id.GroupDetailUiState$OnSuccessGetLeastTransactionFavoriteAccount)).setChecked(p0);
        ((SwitchCompat) _$_findCachedViewById(R.id.GroupDetailUiState$OnSuccessGetLeastTransactionFavoriteAccount)).setTag(null);
    }

    private final void PlaceComponentResult(boolean p0) {
        ColorStateList KClassImpl$Data$declaredNonStaticMembers$2;
        SwitchCompat switchCompat = (SwitchCompat) _$_findCachedViewById(R.id.GroupDetailUiState$OnSuccessGetLeastTransactionFavoriteAccount);
        Intrinsics.checkNotNullExpressionValue(switchCompat, "");
        KClassImpl$Data$declaredNonStaticMembers$2 = ResourcesCompat.KClassImpl$Data$declaredNonStaticMembers$2(r1.getResources(), R.color.colorWhite, switchCompat.getContext().getTheme());
        switchCompat.setThumbTintList(KClassImpl$Data$declaredNonStaticMembers$2);
        switchCompat.setTrackTintList(p0 ? ResourcesCompat.KClassImpl$Data$declaredNonStaticMembers$2(r4.getResources(), R.color.azure, switchCompat.getContext().getTheme()) : ResourcesCompat.KClassImpl$Data$declaredNonStaticMembers$2(r4.getResources(), R.color.f27012131100470, switchCompat.getContext().getTheme()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void switchOnOperation() {
        getSwitchAutoRoutePresenter().KClassImpl$Data$declaredNonStaticMembers$2();
    }

    protected void activityResultRendering() {
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.myprofile.SettingMoreProfileActivity");
        }
        final SettingMoreProfileActivity settingMoreProfileActivity = (SettingMoreProfileActivity) baseActivity;
        settingMoreProfileActivity.setAutoRouteListener(new SettingMoreProfileActivity.Listener() { // from class: id.dana.richview.profile.switchautoroute.SwitchAutoRouteView$activityResultRendering$1
            @Override // id.dana.myprofile.SettingMoreProfileActivity.Listener
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                SwitchAutoRouteView.this.getSwitchAutoRouteAnalyticsTracker().BuiltInFictitiousFunctionClassFactory(SwitchAutoRouteView.access$getAutoRouteSource(SwitchAutoRouteView.this, settingMoreProfileActivity), ((SwitchCompat) SwitchAutoRouteView.this._$_findCachedViewById(R.id.GroupDetailUiState$OnSuccessGetLeastTransactionFavoriteAccount)).isChecked());
                SwitchAutoRouteView switchAutoRouteView = SwitchAutoRouteView.this;
                switchAutoRouteView.showSuccessToast(((SwitchCompat) switchAutoRouteView._$_findCachedViewById(R.id.GroupDetailUiState$OnSuccessGetLeastTransactionFavoriteAccount)).isChecked());
            }

            @Override // id.dana.myprofile.SettingMoreProfileActivity.Listener
            public final void BuiltInFictitiousFunctionClassFactory(String p0) {
                SettingMoreProfileActivity settingMoreProfileActivity2;
                ActivityPermissionRequest phonePermission;
                if (Intrinsics.areEqual(ChallengeControl.CancelReason.PIN_TEMPORARY_LOCKED, p0)) {
                    SwitchAutoRouteView.this.showPinLockedDialog();
                } else if (Intrinsics.areEqual("forgot_pin", p0) && (settingMoreProfileActivity2 = SwitchAutoRouteView.this.getSettingMoreProfileActivity()) != null && (phonePermission = settingMoreProfileActivity2.getPhonePermission()) != null) {
                    phonePermission.check();
                }
                SwitchAutoRouteView.this.revertChecked();
                SwitchAutoRouteView.this.showErrorToast();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showPinLockedDialog() {
        DialogWithImage.BuiltInFictitiousFunctionClassFactory(getBaseActivity(), getPinLockedListener()).MyBillsEntityDataFactory();
    }

    protected DialogInterface.OnClickListener getPinLockedListener() {
        return new DialogInterface.OnClickListener() { // from class: id.dana.richview.profile.switchautoroute.SwitchAutoRouteView$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                SwitchAutoRouteView.$r8$lambda$9cQbrJEfgb55fLJxaMmh51D8ulk(SwitchAutoRouteView.this, dialogInterface, i);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showSuccessToast(boolean autoRouteRequestedStatus) {
        String string = getContext().getString(autoRouteRequestedStatus ? R.string.auto_routing_success_activation : R.string.auto_routing_success_deactivation);
        Intrinsics.checkNotNullExpressionValue(string, "");
        BaseActivity baseActivity = getBaseActivity();
        Intrinsics.checkNotNullExpressionValue(baseActivity, "");
        CustomToastUtil.PlaceComponentResult(baseActivity, R.drawable.ic_success, R.drawable.bg_rounded_toast_auto_route, string, 48, 60, false, null, 384);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showErrorToast() {
        BaseActivity baseActivity = getBaseActivity();
        Intrinsics.checkNotNullExpressionValue(baseActivity, "");
        CustomToastUtil.PlaceComponentResult(baseActivity, R.drawable.ic_close_red, R.drawable.bg_rounded_toast_failed, getContext().getString(R.string.auto_routing_error), 48, 60, false, null, 384);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final SettingMoreProfileActivity getSettingMoreProfileActivity() {
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity instanceof SettingMoreProfileActivity) {
            return (SettingMoreProfileActivity) baseActivity;
        }
        return null;
    }

    public static /* synthetic */ void $r8$lambda$9cQbrJEfgb55fLJxaMmh51D8ulk(SwitchAutoRouteView switchAutoRouteView, DialogInterface dialogInterface, int i) {
        ActivityPermissionRequest phonePermission;
        Intrinsics.checkNotNullParameter(switchAutoRouteView, "");
        Intrinsics.checkNotNullParameter(dialogInterface, "");
        if (i == -2) {
            dialogInterface.dismiss();
        } else if (i == -1) {
            SettingMoreProfileActivity settingMoreProfileActivity = switchAutoRouteView.getSettingMoreProfileActivity();
            if (settingMoreProfileActivity != null && (phonePermission = settingMoreProfileActivity.getPhonePermission()) != null) {
                phonePermission.check();
            }
            dialogInterface.dismiss();
        }
    }

    public static /* synthetic */ void $r8$lambda$E_v85vCtrgHY2s8dviBcXyIhstc(SwitchAutoRouteView switchAutoRouteView, View view) {
        Intrinsics.checkNotNullParameter(switchAutoRouteView, "");
        switchAutoRouteView.revertChecked();
    }

    public static /* synthetic */ void $r8$lambda$Z8XtX33lSOAeQFs678k4z2ATbNo(SwitchAutoRouteView switchAutoRouteView, View view) {
        Intrinsics.checkNotNullParameter(switchAutoRouteView, "");
        switchAutoRouteView.getSwitchAutoRoutePresenter().MyBillsEntityDataFactory(false, switchAutoRouteView.authenticationType);
    }

    public static final /* synthetic */ String access$getAutoRouteSource(SwitchAutoRouteView switchAutoRouteView, BaseActivity baseActivity) {
        if (TextUtils.isEmpty(baseActivity.getSource())) {
            return TrackerKey.SourceType.PROFILE;
        }
        String source = baseActivity.getSource();
        Intrinsics.checkNotNullExpressionValue(source, "");
        return source;
    }
}
