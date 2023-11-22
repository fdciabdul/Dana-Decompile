package id.dana.danapoly.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.danapoly.R;

/* loaded from: classes4.dex */
public final class ItemDailyCheckPointBinding implements ViewBinding {
    public final AppCompatImageView BuiltInFictitiousFunctionClassFactory;
    public final ConstraintLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatImageView MyBillsEntityDataFactory;
    public final TextView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final AppCompatImageView PlaceComponentResult;
    public final FrameLayout getAuthRequestContext;
    public final ConstraintLayout getErrorConfigVersion;
    public final View lookAheadTest;
    public final View moveToNextValue;
    public final TextView scheduleImpl;

    private ItemDailyCheckPointBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, FrameLayout frameLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, TextView textView, TextView textView2, View view, View view2) {
        this.getErrorConfigVersion = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constraintLayout2;
        this.getAuthRequestContext = frameLayout;
        this.MyBillsEntityDataFactory = appCompatImageView;
        this.PlaceComponentResult = appCompatImageView2;
        this.BuiltInFictitiousFunctionClassFactory = appCompatImageView3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = textView;
        this.scheduleImpl = textView2;
        this.lookAheadTest = view;
        this.moveToNextValue = view2;
    }

    public static ItemDailyCheckPointBinding KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View BuiltInFictitiousFunctionClassFactory;
        View BuiltInFictitiousFunctionClassFactory2;
        View inflate = layoutInflater.inflate(R.layout.item_daily_check_point, viewGroup, false);
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        int i = R.id.fl_blink;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (frameLayout != null) {
            i = R.id.iv_background;
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (appCompatImageView != null) {
                i = R.id.getCardNumberOCR_res_0x7f0a0a99;
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (appCompatImageView2 != null) {
                    i = R.id.res_0x7f0a0bdb_promocategorypresenter_1;
                    AppCompatImageView appCompatImageView3 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                    if (appCompatImageView3 != null) {
                        i = R.id.res_0x7f0a1847_navigationmenupresenter_headerviewholder;
                        TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                        if (textView != null) {
                            i = R.id.AppCategory;
                            TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                            if (textView2 != null && (BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, (i = R.id.res_0x7f0a19e9_r8_lambda_zxhmsujxtx99vyz6bmhxqp1wkc8))) != null && (BuiltInFictitiousFunctionClassFactory2 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, (i = R.id.v_bottom_space_2))) != null) {
                                return new ItemDailyCheckPointBinding(constraintLayout, constraintLayout, frameLayout, appCompatImageView, appCompatImageView2, appCompatImageView3, textView, textView2, BuiltInFictitiousFunctionClassFactory, BuiltInFictitiousFunctionClassFactory2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getErrorConfigVersion;
    }
}
