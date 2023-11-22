package id.dana.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewholderFeedSectionTitleBinding implements ViewBinding {
    private final ConstraintLayout PlaceComponentResult;
    public final TextView getAuthRequestContext;

    private ViewholderFeedSectionTitleBinding(ConstraintLayout constraintLayout, TextView textView) {
        this.PlaceComponentResult = constraintLayout;
        this.getAuthRequestContext = textView;
    }

    public static ViewholderFeedSectionTitleBinding PlaceComponentResult(View view) {
        TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvTitle);
        if (textView != null) {
            return new ViewholderFeedSectionTitleBinding((ConstraintLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.tvTitle)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult;
    }
}
