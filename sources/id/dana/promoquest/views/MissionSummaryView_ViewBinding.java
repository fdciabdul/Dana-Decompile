package id.dana.promoquest.views;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public final class MissionSummaryView_ViewBinding implements Unbinder {
    private View BuiltInFictitiousFunctionClassFactory;
    private MissionSummaryView KClassImpl$Data$declaredNonStaticMembers$2;

    public MissionSummaryView_ViewBinding(final MissionSummaryView missionSummaryView, View view) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = missionSummaryView;
        View BuiltInFictitiousFunctionClassFactory = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.btn_view_all, "method 'onViewAllClicked'");
        this.BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.promoquest.views.MissionSummaryView_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                missionSummaryView.onViewAllClicked();
            }
        });
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        this.BuiltInFictitiousFunctionClassFactory.setOnClickListener(null);
        this.BuiltInFictitiousFunctionClassFactory = null;
    }
}
