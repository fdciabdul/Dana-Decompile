package id.dana.myprofile.mepagerevamp.securitysettings.view;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.base.viewbinding.ViewBindingRichView;
import id.dana.core.ui.glide.GlideApp;
import id.dana.databinding.ItemMenuSettingsLocationPermissionBinding;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsActivity;
import id.dana.myprofile.mepagerevamp.securitysettings.view.locationpermission.SettingLocationPermissionContract;
import id.dana.richview.BlueSwitchView;
import id.dana.utils.OSUtil;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B'\b\u0016\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010!\u001a\u00020\u0007¢\u0006\u0004\b\"\u0010#B+\b\u0016\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\u0006\u0010!\u001a\u00020\u0007\u0012\u0006\u0010$\u001a\u00020\u0007¢\u0006\u0004\b\"\u0010%J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u0006J\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0016\u0010\u0015R*\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00048\u0007@GX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\u001cR\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0019"}, d2 = {"Lid/dana/myprofile/mepagerevamp/securitysettings/view/SwitchLocationPermissionView;", "Lid/dana/base/viewbinding/ViewBindingRichView;", "Lid/dana/databinding/ItemMenuSettingsLocationPermissionBinding;", "Lid/dana/myprofile/mepagerevamp/securitysettings/view/locationpermission/SettingLocationPermissionContract$View;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()Z", "", "getLayout", "()I", "PlaceComponentResult", "Landroid/view/View;", "view", "initViewBinding", "(Landroid/view/View;)Lid/dana/databinding/ItemMenuSettingsLocationPermissionBinding;", "Lid/dana/domain/profilemenu/model/SettingModel;", "data", "", "onBind", "(Lid/dana/domain/profilemenu/model/SettingModel;)V", "setup", "()V", "switchLocationPermission", "value", "getAuthRequestContext", "Z", "isLocationPermissionEnabled", "setLocationPermissionEnabled", "(Z)V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SwitchLocationPermissionView extends ViewBindingRichView<ItemMenuSettingsLocationPermissionBinding> implements SettingLocationPermissionContract.View {
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private boolean isLocationPermissionEnabled;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SwitchLocationPermissionView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SwitchLocationPermissionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.base.viewbinding.ViewBindingRichView
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

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final /* synthetic */ void dismissProgress() {
        AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView
    public final /* synthetic */ String getErrorSource() {
        return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
    }

    @Override // id.dana.base.BaseRichView
    public final int getLayout() {
        return R.layout.item_menu_settings_location_permission;
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final /* synthetic */ void onError(String str) {
        AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final /* synthetic */ void showProgress() {
        AbstractContractKt.AbstractView.CC.PlaceComponentResult();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwitchLocationPermissionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ SwitchLocationPermissionView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwitchLocationPermissionView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    @JvmName(name = "isLocationPermissionEnabled")
    /* renamed from: isLocationPermissionEnabled  reason: from getter */
    public final boolean getIsLocationPermissionEnabled() {
        return this.isLocationPermissionEnabled;
    }

    @JvmName(name = "setLocationPermissionEnabled")
    public final void setLocationPermissionEnabled(boolean z) {
        this.isLocationPermissionEnabled = z;
        getBinding().PlaceComponentResult.setChecked(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final ItemMenuSettingsLocationPermissionBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ItemMenuSettingsLocationPermissionBinding BuiltInFictitiousFunctionClassFactory = ItemMenuSettingsLocationPermissionBinding.BuiltInFictitiousFunctionClassFactory(view);
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    private final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        if (OSUtil.GetContactSyncConfig()) {
            return PlaceComponentResult();
        }
        return false;
    }

    private final boolean PlaceComponentResult() {
        return ContextCompat.KClassImpl$Data$declaredNonStaticMembers$2(getBaseActivity(), "android.permission.ACCESS_FINE_LOCATION") == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean BuiltInFictitiousFunctionClassFactory(SwitchLocationPermissionView switchLocationPermissionView) {
        Intrinsics.checkNotNullParameter(switchLocationPermissionView, "");
        switchLocationPermissionView.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        return false;
    }

    public final void onBind(SettingModel data) {
        AppCompatImageView appCompatImageView;
        if (data != null) {
            String iconUrl = data.getIconUrl();
            if (iconUrl == null) {
                iconUrl = "";
            }
            if ((iconUrl.length() > 0) && (appCompatImageView = getBinding().BuiltInFictitiousFunctionClassFactory) != null) {
                GlideApp.getAuthRequestContext(appCompatImageView.getContext()).PlaceComponentResult(iconUrl).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).getErrorConfigVersion((int) R.drawable.res_0x7f080633_networkuserentitydata_externalsyntheticlambda2).PlaceComponentResult((int) R.drawable.res_0x7f080633_networkuserentitydata_externalsyntheticlambda2).MyBillsEntityDataFactory((ImageView) appCompatImageView);
                appCompatImageView.setVisibility(0);
            }
            getBinding().scheduleImpl.setCellLabelIcon(data.getTitle(), R.drawable.ic_info_blue);
        }
    }

    public static /* synthetic */ void $r8$lambda$wQfkJK0nTcGcidPmsHY6ZrSlqvA(SwitchLocationPermissionView switchLocationPermissionView, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(switchLocationPermissionView, "");
        if (switchLocationPermissionView.KClassImpl$Data$declaredNonStaticMembers$2) {
            switchLocationPermissionView.KClassImpl$Data$declaredNonStaticMembers$2 = false;
            if (z) {
                BaseActivity baseActivity = switchLocationPermissionView.getBaseActivity();
                if (baseActivity != null) {
                    ((SecuritySettingsActivity) baseActivity).getLocationPermission().check();
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsActivity");
            }
            BaseActivity baseActivity2 = switchLocationPermissionView.getBaseActivity();
            if (baseActivity2 != null) {
                SecuritySettingsActivity securitySettingsActivity = (SecuritySettingsActivity) baseActivity2;
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                BaseActivity baseActivity3 = switchLocationPermissionView.getBaseActivity();
                if (baseActivity3 != null) {
                    intent.setData(Uri.fromParts("package", ((SecuritySettingsActivity) baseActivity3).getPackageName(), null));
                    securitySettingsActivity.startActivity(intent);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsActivity");
            }
            throw new NullPointerException("null cannot be cast to non-null type id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsActivity");
        }
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        LinearLayout linearLayout = getBinding().MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "");
        linearLayout.setVisibility(8);
        ImageView imageView = getBinding().getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(imageView, "");
        imageView.setVisibility(8);
        BlueSwitchView blueSwitchView = getBinding().PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(blueSwitchView, "");
        blueSwitchView.setVisibility(0);
        getBinding().PlaceComponentResult.setChecked(KClassImpl$Data$declaredNonStaticMembers$2());
        getBinding().PlaceComponentResult.setOnTouchListener(new View.OnTouchListener() { // from class: id.dana.myprofile.mepagerevamp.securitysettings.view.SwitchLocationPermissionView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean BuiltInFictitiousFunctionClassFactory;
                BuiltInFictitiousFunctionClassFactory = SwitchLocationPermissionView.BuiltInFictitiousFunctionClassFactory(SwitchLocationPermissionView.this);
                return BuiltInFictitiousFunctionClassFactory;
            }
        });
        getBinding().PlaceComponentResult.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: id.dana.myprofile.mepagerevamp.securitysettings.view.SwitchLocationPermissionView$$ExternalSyntheticLambda0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                SwitchLocationPermissionView.$r8$lambda$wQfkJK0nTcGcidPmsHY6ZrSlqvA(SwitchLocationPermissionView.this, compoundButton, z);
            }
        });
    }

    public final void switchLocationPermission() {
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity != null) {
            ((SecuritySettingsActivity) baseActivity).getLocationPermission().check();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsActivity");
    }
}
