package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.imageview.ShapeableImageView;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewPushVerifyChallengeInfoBinding implements ViewBinding {
    public final ShapeableImageView KClassImpl$Data$declaredNonStaticMembers$2;
    private final ConstraintLayout MyBillsEntityDataFactory;
    public final TextView PlaceComponentResult;
    public final TextView getAuthRequestContext;

    private ViewPushVerifyChallengeInfoBinding(ConstraintLayout constraintLayout, ShapeableImageView shapeableImageView, TextView textView, TextView textView2) {
        this.MyBillsEntityDataFactory = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = shapeableImageView;
        this.PlaceComponentResult = textView;
        this.getAuthRequestContext = textView2;
    }

    public static ViewPushVerifyChallengeInfoBinding getAuthRequestContext(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.view_push_verify_challenge_info, (ViewGroup) null, false);
        int i = R.id.iv_icon;
        ShapeableImageView shapeableImageView = (ShapeableImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.iv_icon);
        if (shapeableImageView != null) {
            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_description);
            if (textView != null) {
                TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_title);
                if (textView2 != null) {
                    return new ViewPushVerifyChallengeInfoBinding((ConstraintLayout) inflate, shapeableImageView, textView, textView2);
                }
                i = R.id.tv_title;
            } else {
                i = R.id.tv_description;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory;
    }
}
