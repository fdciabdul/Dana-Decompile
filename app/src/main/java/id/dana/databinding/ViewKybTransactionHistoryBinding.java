package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;

/* loaded from: classes4.dex */
public final class ViewKybTransactionHistoryBinding implements ViewBinding {
    public final ImageView BuiltInFictitiousFunctionClassFactory;
    public final DanaButtonSecondaryView KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatImageView MyBillsEntityDataFactory;
    public final RecyclerView PlaceComponentResult;
    public final TextView getAuthRequestContext;
    private final ConstraintLayout getErrorConfigVersion;
    public final TextView moveToNextValue;
    public final TextView scheduleImpl;

    private ViewKybTransactionHistoryBinding(ConstraintLayout constraintLayout, DanaButtonSecondaryView danaButtonSecondaryView, AppCompatImageView appCompatImageView, ImageView imageView, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3) {
        this.getErrorConfigVersion = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = danaButtonSecondaryView;
        this.MyBillsEntityDataFactory = appCompatImageView;
        this.BuiltInFictitiousFunctionClassFactory = imageView;
        this.PlaceComponentResult = recyclerView;
        this.getAuthRequestContext = textView;
        this.scheduleImpl = textView2;
        this.moveToNextValue = textView3;
    }

    public static ViewKybTransactionHistoryBinding getAuthRequestContext(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.view_kyb_transaction_history, (ViewGroup) null, false);
        int i = R.id.btn_see_all;
        DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.btn_see_all);
        if (danaButtonSecondaryView != null) {
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.iv_logo_empty_state_kyb_transaction_history);
            if (appCompatImageView != null) {
                ImageView imageView = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.iv_red_dot_btn_view_all);
                if (imageView != null) {
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.rv_kyb_transaction_history);
                    if (recyclerView != null) {
                        TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_info_empty_state_kyb_transaction_history);
                        if (textView != null) {
                            TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_kyb_transaction_count);
                            if (textView2 != null) {
                                TextView textView3 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_title_kyb_transaction_history);
                                if (textView3 != null) {
                                    return new ViewKybTransactionHistoryBinding((ConstraintLayout) inflate, danaButtonSecondaryView, appCompatImageView, imageView, recyclerView, textView, textView2, textView3);
                                }
                                i = R.id.tv_title_kyb_transaction_history;
                            } else {
                                i = R.id.tv_kyb_transaction_count;
                            }
                        } else {
                            i = R.id.tv_info_empty_state_kyb_transaction_history;
                        }
                    } else {
                        i = R.id.rv_kyb_transaction_history;
                    }
                } else {
                    i = R.id.iv_red_dot_btn_view_all;
                }
            } else {
                i = R.id.iv_logo_empty_state_kyb_transaction_history;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getErrorConfigVersion;
    }
}
