package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.sendmoney_v2.landing.view.ShowMoreView;

/* loaded from: classes4.dex */
public final class ViewTransactionRecentBinding implements ViewBinding {
    public final AppCompatImageView BuiltInFictitiousFunctionClassFactory;
    public final ShowMoreView KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatTextView MyBillsEntityDataFactory;
    public final RecyclerView PlaceComponentResult;
    public final AppCompatTextView getAuthRequestContext;
    private final ConstraintLayout moveToNextValue;

    private ViewTransactionRecentBinding(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, RecyclerView recyclerView, ShowMoreView showMoreView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.moveToNextValue = constraintLayout;
        this.BuiltInFictitiousFunctionClassFactory = appCompatImageView;
        this.PlaceComponentResult = recyclerView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = showMoreView;
        this.MyBillsEntityDataFactory = appCompatTextView;
        this.getAuthRequestContext = appCompatTextView2;
    }

    public static ViewTransactionRecentBinding getAuthRequestContext(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.view_transaction_recent, (ViewGroup) null, false);
        int i = R.id.ivHistory;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.ivHistory);
        if (appCompatImageView != null) {
            RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f4096res_0x7f0a1050_linkedtreemap_linkedtreemapiterator);
            if (recyclerView != null) {
                ShowMoreView showMoreView = (ShowMoreView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.showMoreRecent);
                if (showMoreView != null) {
                    AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvSearch);
                    if (appCompatTextView != null) {
                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvTitle);
                        if (appCompatTextView2 != null) {
                            return new ViewTransactionRecentBinding((ConstraintLayout) inflate, appCompatImageView, recyclerView, showMoreView, appCompatTextView, appCompatTextView2);
                        }
                        i = R.id.tvTitle;
                    } else {
                        i = R.id.tvSearch;
                    }
                } else {
                    i = R.id.showMoreRecent;
                }
            } else {
                i = R.id.f4096res_0x7f0a1050_linkedtreemap_linkedtreemapiterator;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.moveToNextValue;
    }
}
