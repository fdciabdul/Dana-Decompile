package id.dana.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.component.cellcomponent.DanaCellLeftView;
import id.dana.richview.BlueSwitchView;

/* loaded from: classes4.dex */
public final class ItemMenuSettingsLocationPermissionBinding implements ViewBinding {
    public final AppCompatImageView BuiltInFictitiousFunctionClassFactory;
    public final ImageView KClassImpl$Data$declaredNonStaticMembers$2;
    public final LinearLayout MyBillsEntityDataFactory;
    public final BlueSwitchView PlaceComponentResult;
    public final ImageView getAuthRequestContext;
    public final View getErrorConfigVersion;
    private final LinearLayout lookAheadTest;
    public final TextView moveToNextValue;
    public final DanaCellLeftView scheduleImpl;

    private ItemMenuSettingsLocationPermissionBinding(LinearLayout linearLayout, LinearLayout linearLayout2, ImageView imageView, ImageView imageView2, AppCompatImageView appCompatImageView, BlueSwitchView blueSwitchView, TextView textView, DanaCellLeftView danaCellLeftView, View view) {
        this.lookAheadTest = linearLayout;
        this.MyBillsEntityDataFactory = linearLayout2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = imageView;
        this.getAuthRequestContext = imageView2;
        this.BuiltInFictitiousFunctionClassFactory = appCompatImageView;
        this.PlaceComponentResult = blueSwitchView;
        this.moveToNextValue = textView;
        this.scheduleImpl = danaCellLeftView;
        this.getErrorConfigVersion = view;
    }

    public static ItemMenuSettingsLocationPermissionBinding BuiltInFictitiousFunctionClassFactory(View view) {
        int i = R.id.f3500btn_activate;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f3500btn_activate);
        if (linearLayout != null) {
            ImageView imageView = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.CustomPopMenuExtension);
            if (imageView != null) {
                ImageView imageView2 = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_item_menu_avatar_red_dot);
                if (imageView2 != null) {
                    AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_user_service);
                    if (appCompatImageView != null) {
                        BlueSwitchView blueSwitchView = (BlueSwitchView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f4196sv_enable_location_permission);
                        if (blueSwitchView != null) {
                            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.setClientPackageName);
                            if (textView != null) {
                                DanaCellLeftView danaCellLeftView = (DanaCellLeftView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_title);
                                if (danaCellLeftView != null) {
                                    View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f4555res_0x7f0a1a0b_filter_jgv0xpq);
                                    if (BuiltInFictitiousFunctionClassFactory != null) {
                                        return new ItemMenuSettingsLocationPermissionBinding((LinearLayout) view, linearLayout, imageView, imageView2, appCompatImageView, blueSwitchView, textView, danaCellLeftView, BuiltInFictitiousFunctionClassFactory);
                                    }
                                    i = R.id.f4555res_0x7f0a1a0b_filter_jgv0xpq;
                                } else {
                                    i = R.id.tv_title;
                                }
                            } else {
                                i = R.id.setClientPackageName;
                            }
                        } else {
                            i = R.id.f4196sv_enable_location_permission;
                        }
                    } else {
                        i = R.id.iv_user_service;
                    }
                } else {
                    i = R.id.iv_item_menu_avatar_red_dot;
                }
            } else {
                i = R.id.CustomPopMenuExtension;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.lookAheadTest;
    }
}
