package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class BottomSheetReactionListBinding implements ViewBinding {
    public final LinearLayout BuiltInFictitiousFunctionClassFactory;
    public final ImageView KClassImpl$Data$declaredNonStaticMembers$2;
    private final LinearLayout MyBillsEntityDataFactory;
    public final TextView PlaceComponentResult;
    public final RecyclerView getAuthRequestContext;

    private BottomSheetReactionListBinding(LinearLayout linearLayout, ImageView imageView, RecyclerView recyclerView, TextView textView, LinearLayout linearLayout2) {
        this.MyBillsEntityDataFactory = linearLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = imageView;
        this.getAuthRequestContext = recyclerView;
        this.PlaceComponentResult = textView;
        this.BuiltInFictitiousFunctionClassFactory = linearLayout2;
    }

    public static BottomSheetReactionListBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.bottom_sheet_reaction_list, (ViewGroup) null, false);
        int i = R.id.secondaryHash_res_0x7f0a08d3;
        ImageView imageView = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.secondaryHash_res_0x7f0a08d3);
        if (imageView != null) {
            RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.rv_reaction_list);
            if (recyclerView != null) {
                TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_reaction_list_title);
                if (textView != null) {
                    LinearLayout linearLayout = (LinearLayout) inflate;
                    return new BottomSheetReactionListBinding(linearLayout, imageView, recyclerView, textView, linearLayout);
                }
                i = R.id.tv_reaction_list_title;
            } else {
                i = R.id.rv_reaction_list;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory;
    }
}
