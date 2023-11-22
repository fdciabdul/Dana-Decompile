package id.dana.riskChallenges.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.imageview.ShapeableImageView;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.core.ui.databinding.ViewBaseToolbarBinding;
import id.dana.riskChallenges.R;

/* loaded from: classes5.dex */
public final class FragmentPasskeyEnrollmentFaqBinding implements ViewBinding {
    public final ViewBaseToolbarBinding BuiltInFictitiousFunctionClassFactory;
    public final RecyclerView KClassImpl$Data$declaredNonStaticMembers$2;
    public final ShapeableImageView MyBillsEntityDataFactory;
    public final TextView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final TextView PlaceComponentResult;
    public final DanaButtonSecondaryView getAuthRequestContext;
    private final RelativeLayout lookAheadTest;

    private FragmentPasskeyEnrollmentFaqBinding(RelativeLayout relativeLayout, DanaButtonSecondaryView danaButtonSecondaryView, ShapeableImageView shapeableImageView, RecyclerView recyclerView, ViewBaseToolbarBinding viewBaseToolbarBinding, TextView textView, TextView textView2) {
        this.lookAheadTest = relativeLayout;
        this.getAuthRequestContext = danaButtonSecondaryView;
        this.MyBillsEntityDataFactory = shapeableImageView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = recyclerView;
        this.BuiltInFictitiousFunctionClassFactory = viewBaseToolbarBinding;
        this.PlaceComponentResult = textView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = textView2;
    }

    public static FragmentPasskeyEnrollmentFaqBinding KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater layoutInflater) {
        View BuiltInFictitiousFunctionClassFactory;
        View inflate = layoutInflater.inflate(R.layout.fragment_passkey_enrollment_faq, (ViewGroup) null, false);
        int i = R.id.PlaceComponentResult_res_0x7f0a01e4;
        DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (danaButtonSecondaryView != null) {
            i = R.id.iv_illustration_passkey_enrollment_faq;
            ShapeableImageView shapeableImageView = (ShapeableImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (shapeableImageView != null) {
                i = R.id.rvFaqPasskey;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (recyclerView != null && (BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, (i = R.id.toolbar_passkey_enrollment_faq))) != null) {
                    ViewBaseToolbarBinding MyBillsEntityDataFactory = ViewBaseToolbarBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
                    i = R.id.tv_desc_passkey_enrollment_faq;
                    TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                    if (textView != null) {
                        i = R.id.tv_title_passkey_enrollment_faq;
                        TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                        if (textView2 != null) {
                            return new FragmentPasskeyEnrollmentFaqBinding((RelativeLayout) inflate, danaButtonSecondaryView, shapeableImageView, recyclerView, MyBillsEntityDataFactory, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.lookAheadTest;
    }
}
