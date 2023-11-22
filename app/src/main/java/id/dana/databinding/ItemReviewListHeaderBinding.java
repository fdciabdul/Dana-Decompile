package id.dana.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;

/* loaded from: classes4.dex */
public final class ItemReviewListHeaderBinding implements ViewBinding {
    public final TextView BuiltInFictitiousFunctionClassFactory;
    private final TextView MyBillsEntityDataFactory;

    private ItemReviewListHeaderBinding(TextView textView, TextView textView2) {
        this.MyBillsEntityDataFactory = textView;
        this.BuiltInFictitiousFunctionClassFactory = textView2;
    }

    public static ItemReviewListHeaderBinding BuiltInFictitiousFunctionClassFactory(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        TextView textView = (TextView) view;
        return new ItemReviewListHeaderBinding(textView, textView);
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory;
    }
}
