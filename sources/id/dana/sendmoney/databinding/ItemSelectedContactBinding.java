package id.dana.sendmoney.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.sendmoney.R;

/* loaded from: classes5.dex */
public final class ItemSelectedContactBinding implements ViewBinding {
    public final CircleImageView BuiltInFictitiousFunctionClassFactory;
    public final TextView KClassImpl$Data$declaredNonStaticMembers$2;
    public final ConstraintLayout MyBillsEntityDataFactory;
    public final FrameLayout PlaceComponentResult;
    public final AppCompatImageView getAuthRequestContext;
    public final TextView moveToNextValue;

    private ItemSelectedContactBinding(ConstraintLayout constraintLayout, FrameLayout frameLayout, CircleImageView circleImageView, AppCompatImageView appCompatImageView, TextView textView, TextView textView2) {
        this.MyBillsEntityDataFactory = constraintLayout;
        this.PlaceComponentResult = frameLayout;
        this.BuiltInFictitiousFunctionClassFactory = circleImageView;
        this.getAuthRequestContext = appCompatImageView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = textView;
        this.moveToNextValue = textView2;
    }

    public static ItemSelectedContactBinding KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.res_0x7f0d0354_verifypinstatemanager_executeriskchallenge_2_2, (ViewGroup) null, false);
        int i = R.id.fl_photo_container;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (frameLayout != null) {
            i = R.id.View$OnClickListener;
            CircleImageView circleImageView = (CircleImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (circleImageView != null) {
                i = R.id.BannerEntityDataFactory_Factory_res_0x7f0a0c11;
                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (appCompatImageView != null) {
                    i = R.id.NearbySearchPresenter$getNearbyTrendingKeyword$2;
                    TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                    if (textView != null) {
                        i = R.id.appendStatementEnd;
                        TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                        if (textView2 != null) {
                            return new ItemSelectedContactBinding((ConstraintLayout) inflate, frameLayout, circleImageView, appCompatImageView, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory;
    }
}
