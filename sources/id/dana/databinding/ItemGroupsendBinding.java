package id.dana.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ItemGroupsendBinding implements ViewBinding {
    public final TextView BuiltInFictitiousFunctionClassFactory;
    public final TextView KClassImpl$Data$declaredNonStaticMembers$2;
    public final TextView MyBillsEntityDataFactory;
    public final CircleImageView PlaceComponentResult;
    public final TextView getAuthRequestContext;
    private final ConstraintLayout moveToNextValue;

    private ItemGroupsendBinding(ConstraintLayout constraintLayout, CircleImageView circleImageView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.moveToNextValue = constraintLayout;
        this.PlaceComponentResult = circleImageView;
        this.getAuthRequestContext = textView;
        this.MyBillsEntityDataFactory = textView2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = textView3;
        this.BuiltInFictitiousFunctionClassFactory = textView4;
    }

    public static ItemGroupsendBinding PlaceComponentResult(View view) {
        int i = R.id.ivGroupLogo;
        CircleImageView circleImageView = (CircleImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ivGroupLogo);
        if (circleImageView != null) {
            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.cl_first_option);
            if (textView != null) {
                TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.cl_merchant_latest_review);
                if (textView2 != null) {
                    TextView textView3 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvGroupSendMemberCount);
                    if (textView3 != null) {
                        TextView textView4 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvGroupSendType);
                        if (textView4 != null) {
                            return new ItemGroupsendBinding((ConstraintLayout) view, circleImageView, textView, textView2, textView3, textView4);
                        }
                        i = R.id.tvGroupSendType;
                    } else {
                        i = R.id.tvGroupSendMemberCount;
                    }
                } else {
                    i = R.id.cl_merchant_latest_review;
                }
            } else {
                i = R.id.cl_first_option;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.moveToNextValue;
    }
}
