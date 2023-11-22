package id.dana.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;

/* loaded from: classes4.dex */
public final class ItemTitleListAccountBinding implements ViewBinding {
    private final TextView KClassImpl$Data$declaredNonStaticMembers$2;

    private ItemTitleListAccountBinding(TextView textView) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = textView;
    }

    public static ItemTitleListAccountBinding PlaceComponentResult(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        return new ItemTitleListAccountBinding((TextView) view);
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
