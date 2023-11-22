package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ActivityBottomSheetBankListBinding implements ViewBinding {
    public final LayoutGeneralEmptyStateBinding BuiltInFictitiousFunctionClassFactory;
    public final ConstraintLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatImageView MyBillsEntityDataFactory;
    public final LayoutBankListBinding PlaceComponentResult;
    public final AppCompatImageView getAuthRequestContext;
    private final ConstraintLayout lookAheadTest;
    public final TextView scheduleImpl;

    private ActivityBottomSheetBankListBinding(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, LayoutBankListBinding layoutBankListBinding, LayoutGeneralEmptyStateBinding layoutGeneralEmptyStateBinding, ConstraintLayout constraintLayout2, TextView textView) {
        this.lookAheadTest = constraintLayout;
        this.MyBillsEntityDataFactory = appCompatImageView;
        this.getAuthRequestContext = appCompatImageView2;
        this.PlaceComponentResult = layoutBankListBinding;
        this.BuiltInFictitiousFunctionClassFactory = layoutGeneralEmptyStateBinding;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constraintLayout2;
        this.scheduleImpl = textView;
    }

    public static ActivityBottomSheetBankListBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.activity_bottom_sheet_bank_list, (ViewGroup) null, false);
        int i = R.id.RecurringAnnouncementEntity;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.RecurringAnnouncementEntity);
        if (appCompatImageView != null) {
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.containsObjectForKey_res_0x7f0a0a3d);
            if (appCompatImageView2 != null) {
                View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.layoutBankList);
                if (BuiltInFictitiousFunctionClassFactory != null) {
                    LayoutBankListBinding BuiltInFictitiousFunctionClassFactory2 = LayoutBankListBinding.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory);
                    View BuiltInFictitiousFunctionClassFactory3 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.layoutGeneralEmptyState);
                    if (BuiltInFictitiousFunctionClassFactory3 != null) {
                        LayoutGeneralEmptyStateBinding BuiltInFictitiousFunctionClassFactory4 = LayoutGeneralEmptyStateBinding.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory3);
                        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
                        TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_title);
                        if (textView != null) {
                            return new ActivityBottomSheetBankListBinding(constraintLayout, appCompatImageView, appCompatImageView2, BuiltInFictitiousFunctionClassFactory2, BuiltInFictitiousFunctionClassFactory4, constraintLayout, textView);
                        }
                        i = R.id.tv_title;
                    } else {
                        i = R.id.layoutGeneralEmptyState;
                    }
                } else {
                    i = R.id.layoutBankList;
                }
            } else {
                i = R.id.containsObjectForKey_res_0x7f0a0a3d;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.lookAheadTest;
    }
}
