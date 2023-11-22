package id.dana.sendmoney.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.sendmoney.R;

/* loaded from: classes5.dex */
public final class ViewHeaderGroupDetailBinding implements ViewBinding {
    public final AppCompatImageView BuiltInFictitiousFunctionClassFactory;
    public final ConstraintLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatImageView MyBillsEntityDataFactory;
    public final View NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final ConstraintLayout PlaceComponentResult;
    public final CircleImageView getAuthRequestContext;
    private final ConstraintLayout getErrorConfigVersion;
    public final TextView lookAheadTest;
    public final TextView scheduleImpl;

    private ViewHeaderGroupDetailBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, CircleImageView circleImageView, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, TextView textView, TextView textView2, View view) {
        this.getErrorConfigVersion = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constraintLayout2;
        this.PlaceComponentResult = constraintLayout3;
        this.getAuthRequestContext = circleImageView;
        this.BuiltInFictitiousFunctionClassFactory = appCompatImageView;
        this.MyBillsEntityDataFactory = appCompatImageView2;
        this.lookAheadTest = textView;
        this.scheduleImpl = textView2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = view;
    }

    public static ViewHeaderGroupDetailBinding KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        View BuiltInFictitiousFunctionClassFactory;
        int i = R.id.clAvatarGroup;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
        if (constraintLayout != null) {
            i = R.id.clGroupDetailHeader;
            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
            if (constraintLayout2 != null) {
                i = R.id.ivAvatarGroup;
                CircleImageView circleImageView = (CircleImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                if (circleImageView != null) {
                    i = R.id.access$getCapacity$p;
                    AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                    if (appCompatImageView != null) {
                        i = R.id.isRegionMiniProgram_res_0x7f0a09a8;
                        AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                        if (appCompatImageView2 != null) {
                            i = R.id.ResourceResponseInfo;
                            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                            if (textView != null) {
                                i = R.id.setBackgroundTime_res_0x7f0a14e0;
                                TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                                if (textView2 != null && (BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, (i = R.id.clearName))) != null) {
                                    return new ViewHeaderGroupDetailBinding((ConstraintLayout) view, constraintLayout, constraintLayout2, circleImageView, appCompatImageView, appCompatImageView2, textView, textView2, BuiltInFictitiousFunctionClassFactory);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getErrorConfigVersion;
    }
}
