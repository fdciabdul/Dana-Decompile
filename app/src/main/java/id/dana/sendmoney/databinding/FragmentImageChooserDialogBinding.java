package id.dana.sendmoney.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.sendmoney.R;

/* loaded from: classes5.dex */
public final class FragmentImageChooserDialogBinding implements ViewBinding {
    public final TextView BuiltInFictitiousFunctionClassFactory;
    public final TextView KClassImpl$Data$declaredNonStaticMembers$2;
    public final FrameLayout MyBillsEntityDataFactory;
    private final CoordinatorLayout PlaceComponentResult;
    public final TextView getAuthRequestContext;

    private FragmentImageChooserDialogBinding(CoordinatorLayout coordinatorLayout, FrameLayout frameLayout, TextView textView, TextView textView2, TextView textView3) {
        this.PlaceComponentResult = coordinatorLayout;
        this.MyBillsEntityDataFactory = frameLayout;
        this.BuiltInFictitiousFunctionClassFactory = textView;
        this.getAuthRequestContext = textView2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = textView3;
    }

    public static FragmentImageChooserDialogBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.res_0x7f0d01cd_networkuserentitydata_externalsyntheticlambda7, viewGroup, false);
        int i = R.id.flImageChooser;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (frameLayout != null) {
            i = R.id.itemClicked$core;
            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (textView != null) {
                i = R.id.DialogTncInformation_ViewBinding_res_0x7f0a1500;
                TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (textView2 != null) {
                    i = R.id.getKybKaFilter;
                    TextView textView3 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                    if (textView3 != null) {
                        return new FragmentImageChooserDialogBinding((CoordinatorLayout) inflate, frameLayout, textView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult;
    }
}
