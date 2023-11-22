package id.dana.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.richview.LogoProgressView;

/* loaded from: classes4.dex */
public final class ViewMoreForYouBinding implements ViewBinding {
    public final FrameLayout BuiltInFictitiousFunctionClassFactory;
    public final RecyclerView KClassImpl$Data$declaredNonStaticMembers$2;
    public final LinearLayout MyBillsEntityDataFactory;
    private final FrameLayout NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final LogoProgressView PlaceComponentResult;
    public final LinearLayout getAuthRequestContext;
    public final ViewHeaderWithActionBinding moveToNextValue;
    public final TextView scheduleImpl;

    private ViewMoreForYouBinding(FrameLayout frameLayout, LinearLayout linearLayout, LinearLayout linearLayout2, FrameLayout frameLayout2, LogoProgressView logoProgressView, RecyclerView recyclerView, TextView textView, ViewHeaderWithActionBinding viewHeaderWithActionBinding) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = frameLayout;
        this.MyBillsEntityDataFactory = linearLayout;
        this.getAuthRequestContext = linearLayout2;
        this.BuiltInFictitiousFunctionClassFactory = frameLayout2;
        this.PlaceComponentResult = logoProgressView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = recyclerView;
        this.scheduleImpl = textView;
        this.moveToNextValue = viewHeaderWithActionBinding;
    }

    public static ViewMoreForYouBinding KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        int i = R.id.llHeaderMoreForYou;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.llHeaderMoreForYou);
        if (linearLayout != null) {
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ll_progress_view);
            if (linearLayout2 != null) {
                FrameLayout frameLayout = (FrameLayout) view;
                LogoProgressView logoProgressView = (LogoProgressView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f4081progress_view);
                if (logoProgressView != null) {
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.rv_more_for_you);
                    if (recyclerView != null) {
                        TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_loading_text);
                        if (textView != null) {
                            View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.v_header_with_action);
                            if (BuiltInFictitiousFunctionClassFactory != null) {
                                return new ViewMoreForYouBinding(frameLayout, linearLayout, linearLayout2, frameLayout, logoProgressView, recyclerView, textView, ViewHeaderWithActionBinding.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory));
                            }
                            i = R.id.v_header_with_action;
                        } else {
                            i = R.id.tv_loading_text;
                        }
                    } else {
                        i = R.id.rv_more_for_you;
                    }
                } else {
                    i = R.id.f4081progress_view;
                }
            } else {
                i = R.id.ll_progress_view;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }
}
