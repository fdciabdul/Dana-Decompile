package id.dana.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewBackToTopBinding implements ViewBinding {
    public final CardView BuiltInFictitiousFunctionClassFactory;
    public final TextView KClassImpl$Data$declaredNonStaticMembers$2;
    public final ImageView MyBillsEntityDataFactory;
    public final CardView getAuthRequestContext;

    private ViewBackToTopBinding(CardView cardView, CardView cardView2, ImageView imageView, TextView textView) {
        this.BuiltInFictitiousFunctionClassFactory = cardView;
        this.getAuthRequestContext = cardView2;
        this.MyBillsEntityDataFactory = imageView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = textView;
    }

    public static ViewBackToTopBinding PlaceComponentResult(View view) {
        CardView cardView = (CardView) view;
        int i = R.id.iv_up;
        ImageView imageView = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_up);
        if (imageView != null) {
            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_back_to_top);
            if (textView != null) {
                return new ViewBackToTopBinding(cardView, cardView, imageView, textView);
            }
            i = R.id.tv_back_to_top;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
