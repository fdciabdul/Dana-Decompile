package id.dana.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.cashier.view.PaylaterTimelineView;

/* loaded from: classes4.dex */
public final class ItemBillDetailPaylaterBinding implements ViewBinding {
    public final PaylaterTimelineView BuiltInFictitiousFunctionClassFactory;
    public final AppCompatTextView KClassImpl$Data$declaredNonStaticMembers$2;
    public final LinearLayout MyBillsEntityDataFactory;
    public final AppCompatTextView PlaceComponentResult;
    public final LinearLayout getAuthRequestContext;
    public final AppCompatTextView lookAheadTest;
    private final ConstraintLayout moveToNextValue;

    private ItemBillDetailPaylaterBinding(ConstraintLayout constraintLayout, LinearLayout linearLayout, LinearLayout linearLayout2, PaylaterTimelineView paylaterTimelineView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3) {
        this.moveToNextValue = constraintLayout;
        this.getAuthRequestContext = linearLayout;
        this.MyBillsEntityDataFactory = linearLayout2;
        this.BuiltInFictitiousFunctionClassFactory = paylaterTimelineView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatTextView;
        this.PlaceComponentResult = appCompatTextView2;
        this.lookAheadTest = appCompatTextView3;
    }

    public static ItemBillDetailPaylaterBinding getAuthRequestContext(View view) {
        int i = R.id.ll_bill_detail_paylater_container;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ll_bill_detail_paylater_container);
        if (linearLayout != null) {
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ll_bill_detail_paylater_content);
            if (linearLayout2 != null) {
                PaylaterTimelineView paylaterTimelineView = (PaylaterTimelineView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.paylater_timeline_view);
                if (paylaterTimelineView != null) {
                    AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_bill_detail_amount);
                    if (appCompatTextView != null) {
                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_bill_detail_description);
                        if (appCompatTextView2 != null) {
                            AppCompatTextView appCompatTextView3 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_bill_detail_title);
                            if (appCompatTextView3 != null) {
                                return new ItemBillDetailPaylaterBinding((ConstraintLayout) view, linearLayout, linearLayout2, paylaterTimelineView, appCompatTextView, appCompatTextView2, appCompatTextView3);
                            }
                            i = R.id.tv_bill_detail_title;
                        } else {
                            i = R.id.tv_bill_detail_description;
                        }
                    } else {
                        i = R.id.tv_bill_detail_amount;
                    }
                } else {
                    i = R.id.paylater_timeline_view;
                }
            } else {
                i = R.id.ll_bill_detail_paylater_content;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.moveToNextValue;
    }
}
