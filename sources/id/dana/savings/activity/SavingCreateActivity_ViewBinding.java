package id.dana.savings.activity;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public class SavingCreateActivity_ViewBinding implements Unbinder {
    private SavingCreateActivity KClassImpl$Data$declaredNonStaticMembers$2;
    private View getAuthRequestContext;

    public SavingCreateActivity_ViewBinding(final SavingCreateActivity savingCreateActivity, View view) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = savingCreateActivity;
        View BuiltInFictitiousFunctionClassFactory = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.f3959iv_total_saving_limit_tooltip, "method 'onTotalSavingLimitAboutClick'");
        this.getAuthRequestContext = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.savings.activity.SavingCreateActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                savingCreateActivity.onTotalSavingLimitAboutClick();
            }
        });
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        this.getAuthRequestContext.setOnClickListener(null);
        this.getAuthRequestContext = null;
    }
}
