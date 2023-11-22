package id.dana.myprofile.mepagerevamp.smartpay.view;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
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
import id.dana.myprofile.mepagerevamp.smartpay.SmartPayActivity;
import id.dana.richview.profile.switchautoroute.SwitchAutoRouteAnalyticsTracker;
import id.dana.richview.profile.switchautoroute.SwitchAutoRouteAnalyticsTracker$trackAutoSwitchPayment$1;
import id.dana.richview.profile.switchautoroute.SwitchAutoRouteContract;
import id.dana.richview.profile.switchautoroute.SwitchAutoRoutePresenter;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.utils.CustomToastUtil;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 R2\u00020\u00012\u00020\u0002:\u0001RB'\b\u0016\u0012\u0006\u0010J\u001a\u00020I\u0012\n\b\u0002\u0010L\u001a\u0004\u0018\u00010K\u0012\b\b\u0002\u0010M\u001a\u00020\n¢\u0006\u0004\bN\u0010OB+\b\u0016\u0012\u0006\u0010J\u001a\u00020I\u0012\b\u0010L\u001a\u0004\u0018\u00010K\u0012\u0006\u0010M\u001a\u00020\n\u0012\u0006\u0010P\u001a\u00020\n¢\u0006\u0004\bN\u0010QJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0016\u0010\u0007J\u001f\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001e\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0005H\u0016¢\u0006\u0004\b \u0010\tJ\u0017\u0010!\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0003H\u0016¢\u0006\u0004\b!\u0010\u0007J\u0017\u0010\"\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\"\u0010\u0007J'\u0010%\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u001cH\u0016¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0005H\u0016¢\u0006\u0004\b'\u0010\tJ\u0017\u0010(\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b(\u0010\u0007J\u0017\u0010+\u001a\u00020\u00052\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b+\u0010,J\u0017\u0010.\u001a\u00020\u00052\u0006\u0010*\u001a\u00020-H\u0016¢\u0006\u0004\b.\u0010/J\u0017\u00101\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u0003H\u0016¢\u0006\u0004\b1\u0010\u0007J\u000f\u00102\u001a\u00020\u0005H\u0016¢\u0006\u0004\b2\u0010\tJ\u000f\u0010(\u001a\u00020\u0005H\u0002¢\u0006\u0004\b(\u0010\tJ\u000f\u00103\u001a\u00020\u0005H\u0016¢\u0006\u0004\b3\u0010\tJ\u0017\u00104\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b4\u0010\u0007R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u00105R\u0018\u00108\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00107R\u0018\u0010(\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u0010:R\"\u0010<\u001a\u00020;8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\"\u0010C\u001a\u00020B8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010H"}, d2 = {"Lid/dana/myprofile/mepagerevamp/smartpay/view/NewSwitchAutoRouteView;", "Lid/dana/base/BaseRichView;", "Lid/dana/richview/profile/switchautoroute/SwitchAutoRouteContract$View;", "", "p0", "", "getAuthRequestContext", "(Z)V", "dismissProgress", "()V", "", "getLayout", "()I", "Lid/dana/di/component/ApplicationComponent;", "applicationComponent", "injectComponent", "(Lid/dana/di/component/ApplicationComponent;)V", "Lid/dana/domain/profilemenu/model/SettingModel;", "data", "onBind", "(Lid/dana/domain/profilemenu/model/SettingModel;)V", "isHaveAsset", "onCheckHavingAutorouteAsset", "Landroid/widget/CompoundButton;", "compoundButton", CustomDialogKey.Response.IS_CHECKED, "onCheckedChange", "(Landroid/widget/CompoundButton;Z)V", "", "errorMessage", RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, "(Ljava/lang/String;)V", "onProceedSwitchOn", "onSwitchResultAccept", "onSwitchResultReject", BioUtilityBridge.SECURITY_ID, RecordError.KEY_PUB_KEY, "onSwitchResultRisk", "(ZLjava/lang/String;Ljava/lang/String;)V", "revertChecked", "MyBillsEntityDataFactory", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setSwitchButtonOnCheckedChangeListener", "(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V", "Landroid/view/View$OnClickListener;", "setSwitchButtonOnClickListener", "(Landroid/view/View$OnClickListener;)V", "isVisible", "setViewVisibility", "setup", "showProgress", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "Lid/dana/dialog/TwoButtonWithImageDialog;", "Lid/dana/dialog/TwoButtonWithImageDialog;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/dialog/DanaLoadingDialog;", "Lid/dana/dialog/DanaLoadingDialog;", "Lid/dana/richview/profile/switchautoroute/SwitchAutoRouteAnalyticsTracker;", "switchAutoRouteAnalyticsTracker", "Lid/dana/richview/profile/switchautoroute/SwitchAutoRouteAnalyticsTracker;", "getSwitchAutoRouteAnalyticsTracker", "()Lid/dana/richview/profile/switchautoroute/SwitchAutoRouteAnalyticsTracker;", "setSwitchAutoRouteAnalyticsTracker", "(Lid/dana/richview/profile/switchautoroute/SwitchAutoRouteAnalyticsTracker;)V", "Lid/dana/richview/profile/switchautoroute/SwitchAutoRoutePresenter;", "switchAutoRoutePresenter", "Lid/dana/richview/profile/switchautoroute/SwitchAutoRoutePresenter;", "getSwitchAutoRoutePresenter", "()Lid/dana/richview/profile/switchautoroute/SwitchAutoRoutePresenter;", "setSwitchAutoRoutePresenter", "(Lid/dana/richview/profile/switchautoroute/SwitchAutoRoutePresenter;)V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NewSwitchAutoRouteView extends BaseRichView implements SwitchAutoRouteContract.View {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private DanaLoadingDialog MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private TwoButtonWithImageDialog BuiltInFictitiousFunctionClassFactory;
    public Map<Integer, View> _$_findViewCache;
    private String getAuthRequestContext;
    @Inject
    public SwitchAutoRouteAnalyticsTracker switchAutoRouteAnalyticsTracker;
    @Inject
    public SwitchAutoRoutePresenter switchAutoRoutePresenter;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NewSwitchAutoRouteView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NewSwitchAutoRouteView(Context context, AttributeSet attributeSet) {
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

    @Override // id.dana.base.AbstractContractKt.AbstractView
    public final /* synthetic */ String getErrorSource() {
        return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
    }

    @Override // id.dana.base.BaseRichView
    public final int getLayout() {
        return R.layout.new_item_menu_switch_button;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewSwitchAutoRouteView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ NewSwitchAutoRouteView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewSwitchAutoRouteView(Context context, AttributeSet attributeSet, int i, int i2) {
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

    @Override // id.dana.base.BaseRichView
    public final void injectComponent(ApplicationComponent applicationComponent) {
        DaggerSwitchAutoRouteComponent.Builder MyBillsEntityDataFactory = DaggerSwitchAutoRouteComponent.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory.getAuthRequestContext = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = (SwitchAutoRouteModule) Preconditions.getAuthRequestContext(new SwitchAutoRouteModule(this));
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory().MyBillsEntityDataFactory(this);
        registerPresenter(getSwitchAutoRoutePresenter());
    }

    public final void setSwitchButtonOnClickListener(View.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "");
        ((SwitchCompat) _$_findCachedViewById(R.id.GroupDetailUiState$OnSuccessGetLeastTransactionFavoriteAccount)).setOnClickListener(listener);
    }

    public final void setSwitchButtonOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "");
        ((SwitchCompat) _$_findCachedViewById(R.id.GroupDetailUiState$OnSuccessGetLeastTransactionFavoriteAccount)).setOnCheckedChangeListener(listener);
    }

    public final void setViewVisibility(boolean isVisible) {
        ((RelativeLayout) _$_findCachedViewById(R.id.LayoutAddBankBinding)).setVisibility(isVisible ? 0 : 8);
        _$_findCachedViewById(R.id.res_0x7f0a1a0b_filter_jgv0xpq).setVisibility(isVisible ? 0 : 8);
    }

    public final void onBind(SettingModel data) {
        if (data != null) {
            this.getAuthRequestContext = data.getAutoRouteAuthenticationType();
            setViewVisibility(data.isNeedToShow());
            ((TextView) _$_findCachedViewById(R.id.setDrawValueAboveBar)).setText(data.getTitle());
            MyBillsEntityDataFactory(data.isAutoRouteSwitch());
            getAuthRequestContext(data.isAutoRouteSwitch());
        }
    }

    public final void onCheckedChange(CompoundButton compoundButton, boolean isChecked) {
        Intrinsics.checkNotNullParameter(compoundButton, "");
        getAuthRequestContext(isChecked);
        if (compoundButton.getTag() != null) {
            compoundButton.setTag(null);
        } else if (isChecked) {
            getSwitchAutoRoutePresenter().KClassImpl$Data$declaredNonStaticMembers$2();
        } else {
            if (this.BuiltInFictitiousFunctionClassFactory == null) {
                TwoButtonWithImageDialog.Builder builder = new TwoButtonWithImageDialog.Builder(getContext());
                builder.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.ic_auto_route_disable;
                builder.FragmentBottomSheetPaymentSettingBinding = getResources().getString(R.string.disable_auto_routing_title);
                builder.getErrorConfigVersion = getResources().getString(R.string.disable_auto_routing_message);
                String string = getResources().getString(R.string.disable_auto_routing_positive);
                View.OnClickListener onClickListener = new View.OnClickListener() { // from class: id.dana.myprofile.mepagerevamp.smartpay.view.NewSwitchAutoRouteView$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        NewSwitchAutoRouteView.m2701$r8$lambda$mFrSS1mtoVrjBnHLh96Zy7ZUIY(NewSwitchAutoRouteView.this, view);
                    }
                };
                builder.NetworkUserEntityData$$ExternalSyntheticLambda8 = string;
                builder.NetworkUserEntityData$$ExternalSyntheticLambda4 = onClickListener;
                builder.isLayoutRequested = true;
                String string2 = getResources().getString(R.string.disable_auto_routing_negative);
                View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: id.dana.myprofile.mepagerevamp.smartpay.view.NewSwitchAutoRouteView$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        NewSwitchAutoRouteView.m2700$r8$lambda$RFzvCyKQdgKQ29SzgngXSgWhv4(NewSwitchAutoRouteView.this, view);
                    }
                };
                builder.NetworkUserEntityData$$ExternalSyntheticLambda2 = string2;
                builder.DatabaseTableConfigUtil = onClickListener2;
                builder.initRecordTimeStamp = true;
                this.BuiltInFictitiousFunctionClassFactory = builder.PlaceComponentResult(false).MyBillsEntityDataFactory(false).KClassImpl$Data$declaredNonStaticMembers$2();
            }
            TwoButtonWithImageDialog twoButtonWithImageDialog = this.BuiltInFictitiousFunctionClassFactory;
            if (twoButtonWithImageDialog != null) {
                twoButtonWithImageDialog.MyBillsEntityDataFactory();
            }
        }
    }

    public final void revertChecked() {
        MyBillsEntityDataFactory(!((SwitchCompat) _$_findCachedViewById(R.id.GroupDetailUiState$OnSuccessGetLeastTransactionFavoriteAccount)).isChecked());
    }

    @Override // id.dana.richview.profile.switchautoroute.SwitchAutoRouteContract.View
    public final void onSwitchResultRisk(boolean isChecked, String securityId, String pubKey) {
        Intrinsics.checkNotNullParameter(securityId, "");
        Intrinsics.checkNotNullParameter(pubKey, "");
        BaseActivity baseActivity = getBaseActivity();
        Intrinsics.checkNotNullExpressionValue(baseActivity, "");
        ChallengeControl.Builder builder = new ChallengeControl.Builder(baseActivity);
        builder.scheduleImpl = "auto_route";
        builder.VerifyPinStateManager$executeRiskChallenge$2$1 = "auto_route";
        new ChallengeControl(builder.MyBillsEntityDataFactory(isChecked, securityId, pubKey), null).getAuthRequestContext();
    }

    @Override // id.dana.richview.profile.switchautoroute.SwitchAutoRouteContract.View
    public final void onSwitchResultAccept(boolean isChecked) {
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
        Intrinsics.checkNotNullParameter(source, "");
        SwitchAutoRouteAnalyticsTracker$trackAutoSwitchPayment$1 switchAutoRouteAnalyticsTracker$trackAutoSwitchPayment$1 = new SwitchAutoRouteAnalyticsTracker$trackAutoSwitchPayment$1(source, isChecked);
        EventTrackerModel.Builder PlaceComponentResult = EventTrackerModel.Builder.PlaceComponentResult(switchAutoRouteAnalyticsTracker.MyBillsEntityDataFactory);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        switchAutoRouteAnalyticsTracker$trackAutoSwitchPayment$1.invoke((SwitchAutoRouteAnalyticsTracker$trackAutoSwitchPayment$1) PlaceComponentResult);
        PlaceComponentResult.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(PlaceComponentResult, (byte) 0));
        KClassImpl$Data$declaredNonStaticMembers$2(isChecked);
    }

    @Override // id.dana.richview.profile.switchautoroute.SwitchAutoRouteContract.View
    public final void onSwitchResultReject(boolean isChecked) {
        revertChecked();
        MyBillsEntityDataFactory();
    }

    public final void onProceedSwitchOn() {
        getSwitchAutoRoutePresenter().MyBillsEntityDataFactory(true, this.getAuthRequestContext);
    }

    @Override // id.dana.richview.profile.switchautoroute.SwitchAutoRouteContract.View
    public final void onCheckHavingAutorouteAsset(boolean isHaveAsset) {
        if (isHaveAsset) {
            getBaseActivity().startActivityForResult(new Intent(getBaseActivity(), BottomSheetAutoRoutingInfoActivity.class), 2001);
        } else {
            getBaseActivity().startActivity(new Intent(getBaseActivity(), BottomSheetNoAssetInfoActivity.class));
        }
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final void showProgress() {
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity != null) {
            DanaLoadingDialog danaLoadingDialog = new DanaLoadingDialog(baseActivity);
            this.MyBillsEntityDataFactory = danaLoadingDialog;
            if (danaLoadingDialog.MyBillsEntityDataFactory.isShowing()) {
                return;
            }
            danaLoadingDialog.MyBillsEntityDataFactory.show();
            danaLoadingDialog.getAuthRequestContext.startRefresh();
        }
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final void dismissProgress() {
        DanaLoadingDialog danaLoadingDialog = this.MyBillsEntityDataFactory;
        if (danaLoadingDialog != null) {
            danaLoadingDialog.PlaceComponentResult();
        }
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final void onError(String errorMessage) {
        MyBillsEntityDataFactory();
        revertChecked();
    }

    private final void MyBillsEntityDataFactory(boolean p0) {
        ((SwitchCompat) _$_findCachedViewById(R.id.GroupDetailUiState$OnSuccessGetLeastTransactionFavoriteAccount)).setTag("SwitchIgnore");
        ((SwitchCompat) _$_findCachedViewById(R.id.GroupDetailUiState$OnSuccessGetLeastTransactionFavoriteAccount)).setChecked(p0);
        ((SwitchCompat) _$_findCachedViewById(R.id.GroupDetailUiState$OnSuccessGetLeastTransactionFavoriteAccount)).setTag(null);
    }

    private final void getAuthRequestContext(boolean p0) {
        ColorStateList KClassImpl$Data$declaredNonStaticMembers$2;
        SwitchCompat switchCompat = (SwitchCompat) _$_findCachedViewById(R.id.GroupDetailUiState$OnSuccessGetLeastTransactionFavoriteAccount);
        Intrinsics.checkNotNullExpressionValue(switchCompat, "");
        KClassImpl$Data$declaredNonStaticMembers$2 = ResourcesCompat.KClassImpl$Data$declaredNonStaticMembers$2(r1.getResources(), R.color.colorWhite, switchCompat.getContext().getTheme());
        switchCompat.setThumbTintList(KClassImpl$Data$declaredNonStaticMembers$2);
        switchCompat.setTrackTintList(p0 ? ResourcesCompat.KClassImpl$Data$declaredNonStaticMembers$2(r4.getResources(), R.color.azure, switchCompat.getContext().getTheme()) : ResourcesCompat.KClassImpl$Data$declaredNonStaticMembers$2(r4.getResources(), R.color.f27012131100470, switchCompat.getContext().getTheme()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0) {
        String string = getContext().getString(p0 ? R.string.auto_routing_success_activation : R.string.auto_routing_success_deactivation);
        Intrinsics.checkNotNullExpressionValue(string, "");
        BaseActivity baseActivity = getBaseActivity();
        Intrinsics.checkNotNullExpressionValue(baseActivity, "");
        CustomToastUtil.PlaceComponentResult(baseActivity, R.drawable.ic_success, R.drawable.bg_rounded_toast_auto_route, string, 48, 60, false, null, 384);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void MyBillsEntityDataFactory() {
        BaseActivity baseActivity = getBaseActivity();
        Intrinsics.checkNotNullExpressionValue(baseActivity, "");
        CustomToastUtil.PlaceComponentResult(baseActivity, R.drawable.ic_close_red, R.drawable.bg_rounded_toast_failed, getContext().getString(R.string.auto_routing_error), 48, 60, false, null, 384);
    }

    public static /* synthetic */ void $r8$lambda$AQ1r93eEIJ0w7HYSKeZcrtIZdNM(NewSwitchAutoRouteView newSwitchAutoRouteView, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(newSwitchAutoRouteView, "");
        Intrinsics.checkNotNullParameter(dialogInterface, "");
        if (i != -2) {
            if (i != -1) {
                return;
            }
            BaseActivity baseActivity = newSwitchAutoRouteView.getBaseActivity();
            if (baseActivity != null) {
                ((SmartPayActivity) baseActivity).getPhonePermission().check();
            } else {
                throw new NullPointerException("null cannot be cast to non-null type id.dana.myprofile.mepagerevamp.smartpay.SmartPayActivity");
            }
        }
        dialogInterface.dismiss();
    }

    /* renamed from: $r8$lambda$RFzvCyK-QdgKQ29SzgngXSgWhv4  reason: not valid java name */
    public static /* synthetic */ void m2700$r8$lambda$RFzvCyKQdgKQ29SzgngXSgWhv4(NewSwitchAutoRouteView newSwitchAutoRouteView, View view) {
        Intrinsics.checkNotNullParameter(newSwitchAutoRouteView, "");
        newSwitchAutoRouteView.revertChecked();
    }

    /* renamed from: $r8$lambda$mFrSS1mtoVrjBnHLh96Zy-7ZUIY  reason: not valid java name */
    public static /* synthetic */ void m2701$r8$lambda$mFrSS1mtoVrjBnHLh96Zy7ZUIY(NewSwitchAutoRouteView newSwitchAutoRouteView, View view) {
        Intrinsics.checkNotNullParameter(newSwitchAutoRouteView, "");
        newSwitchAutoRouteView.getSwitchAutoRoutePresenter().MyBillsEntityDataFactory(false, newSwitchAutoRouteView.getAuthRequestContext);
    }

    public static final /* synthetic */ String access$getAutoRouteSource(NewSwitchAutoRouteView newSwitchAutoRouteView, BaseActivity baseActivity) {
        if (TextUtils.isEmpty(baseActivity.getSource())) {
            return TrackerKey.SourceType.PROFILE;
        }
        String source = baseActivity.getSource();
        Intrinsics.checkNotNullExpressionValue(source, "");
        return source;
    }

    public static final /* synthetic */ SmartPayActivity access$getSmartPayActivity(NewSwitchAutoRouteView newSwitchAutoRouteView) {
        BaseActivity baseActivity = newSwitchAutoRouteView.getBaseActivity();
        if (baseActivity != null) {
            return (SmartPayActivity) baseActivity;
        }
        throw new NullPointerException("null cannot be cast to non-null type id.dana.myprofile.mepagerevamp.smartpay.SmartPayActivity");
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.myprofile.mepagerevamp.smartpay.SmartPayActivity");
        }
        final SmartPayActivity smartPayActivity = (SmartPayActivity) baseActivity;
        smartPayActivity.setAutoRouteListener(new SmartPayActivity.Listener() { // from class: id.dana.myprofile.mepagerevamp.smartpay.view.NewSwitchAutoRouteView$activityResultRendering$1
            @Override // id.dana.myprofile.mepagerevamp.smartpay.SmartPayActivity.Listener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(Bundle p0) {
                byte b = 0;
                boolean z = true;
                if (p0 != null) {
                    z = p0.getBoolean(ChallengeControl.Key.AUTO_ROUTE_STATUS);
                } else {
                    SwitchCompat switchCompat = (SwitchCompat) NewSwitchAutoRouteView.this._$_findCachedViewById(R.id.GroupDetailUiState$OnSuccessGetLeastTransactionFavoriteAccount);
                    if (switchCompat == null || !switchCompat.isChecked()) {
                        z = false;
                    }
                }
                SwitchAutoRouteAnalyticsTracker switchAutoRouteAnalyticsTracker = NewSwitchAutoRouteView.this.getSwitchAutoRouteAnalyticsTracker();
                String access$getAutoRouteSource = NewSwitchAutoRouteView.access$getAutoRouteSource(NewSwitchAutoRouteView.this, smartPayActivity);
                Intrinsics.checkNotNullParameter(access$getAutoRouteSource, "");
                SwitchAutoRouteAnalyticsTracker$trackAutoSwitchPayment$1 switchAutoRouteAnalyticsTracker$trackAutoSwitchPayment$1 = new SwitchAutoRouteAnalyticsTracker$trackAutoSwitchPayment$1(access$getAutoRouteSource, z);
                EventTrackerModel.Builder PlaceComponentResult = EventTrackerModel.Builder.PlaceComponentResult(switchAutoRouteAnalyticsTracker.MyBillsEntityDataFactory);
                Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
                switchAutoRouteAnalyticsTracker$trackAutoSwitchPayment$1.invoke((SwitchAutoRouteAnalyticsTracker$trackAutoSwitchPayment$1) PlaceComponentResult);
                PlaceComponentResult.PlaceComponentResult();
                EventTracker.PlaceComponentResult(new EventTrackerModel(PlaceComponentResult, b));
                NewSwitchAutoRouteView.this.KClassImpl$Data$declaredNonStaticMembers$2(z);
            }

            @Override // id.dana.myprofile.mepagerevamp.smartpay.SmartPayActivity.Listener
            public final void MyBillsEntityDataFactory(String p0) {
                if (!Intrinsics.areEqual(ChallengeControl.CancelReason.PIN_TEMPORARY_LOCKED, p0)) {
                    if (Intrinsics.areEqual("forgot_pin", p0)) {
                        NewSwitchAutoRouteView.access$getSmartPayActivity(NewSwitchAutoRouteView.this).getPhonePermission().check();
                    }
                } else {
                    DialogWithImage.BuiltInFictitiousFunctionClassFactory(r2.getBaseActivity(), new DialogInterface.OnClickListener() { // from class: id.dana.myprofile.mepagerevamp.smartpay.view.NewSwitchAutoRouteView$$ExternalSyntheticLambda0
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            NewSwitchAutoRouteView.$r8$lambda$AQ1r93eEIJ0w7HYSKeZcrtIZdNM(NewSwitchAutoRouteView.this, dialogInterface, i);
                        }
                    }).MyBillsEntityDataFactory();
                }
                NewSwitchAutoRouteView.this.revertChecked();
                NewSwitchAutoRouteView.this.MyBillsEntityDataFactory();
            }
        });
    }
}
