package id.dana.sendmoney.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.sendmoney.R;

/* loaded from: classes5.dex */
public final class ItemEditGridviewBinding implements ViewBinding {
    public final CircleImageView KClassImpl$Data$declaredNonStaticMembers$2;
    public final ConstraintLayout PlaceComponentResult;
    public final TextView getAuthRequestContext;

    private ItemEditGridviewBinding(ConstraintLayout constraintLayout, CircleImageView circleImageView, TextView textView) {
        this.PlaceComponentResult = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = circleImageView;
        this.getAuthRequestContext = textView;
    }

    public static ItemEditGridviewBinding KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.item_edit_gridview, viewGroup, false);
        int i = R.id.getReadyFragment;
        CircleImageView circleImageView = (CircleImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (circleImageView != null) {
            i = R.id.setNewRibbon;
            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (textView != null) {
                return new ItemEditGridviewBinding((ConstraintLayout) inflate, circleImageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult;
    }
}
