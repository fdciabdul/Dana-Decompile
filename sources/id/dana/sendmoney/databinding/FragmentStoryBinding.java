package id.dana.sendmoney.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.sendmoney.R;

/* loaded from: classes5.dex */
public final class FragmentStoryBinding implements ViewBinding {
    public final View BuiltInFictitiousFunctionClassFactory;
    public final View KClassImpl$Data$declaredNonStaticMembers$2;
    public final ImageView MyBillsEntityDataFactory;
    public final TextView PlaceComponentResult;
    public final TextView getAuthRequestContext;
    private final FrameLayout getErrorConfigVersion;

    private FragmentStoryBinding(FrameLayout frameLayout, ImageView imageView, TextView textView, TextView textView2, View view, View view2) {
        this.getErrorConfigVersion = frameLayout;
        this.MyBillsEntityDataFactory = imageView;
        this.getAuthRequestContext = textView;
        this.PlaceComponentResult = textView2;
        this.BuiltInFictitiousFunctionClassFactory = view;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view2;
    }

    public static FragmentStoryBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View BuiltInFictitiousFunctionClassFactory;
        View BuiltInFictitiousFunctionClassFactory2;
        View inflate = layoutInflater.inflate(R.layout.res_0x7f0d0209_networkuserentitydata_externalsyntheticlambda8, viewGroup, false);
        int i = R.id.res_0x7f0a0a41_arraytable_3;
        ImageView imageView = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (imageView != null) {
            i = R.id.SokalSneathDissimilarity;
            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (textView != null) {
                i = R.id.AttributeView;
                TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (textView2 != null && (BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, (i = R.id.ThreadLocalKey_res_0x7f0a19cd))) != null && (BuiltInFictitiousFunctionClassFactory2 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, (i = R.id.LimitedDispatcher))) != null) {
                    return new FragmentStoryBinding((FrameLayout) inflate, imageView, textView, textView2, BuiltInFictitiousFunctionClassFactory, BuiltInFictitiousFunctionClassFactory2);
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
