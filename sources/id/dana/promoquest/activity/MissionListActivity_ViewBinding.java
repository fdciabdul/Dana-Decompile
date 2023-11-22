package id.dana.promoquest.activity;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public final class MissionListActivity_ViewBinding implements Unbinder {
    private View BuiltInFictitiousFunctionClassFactory;
    private MissionListActivity KClassImpl$Data$declaredNonStaticMembers$2;

    public MissionListActivity_ViewBinding(final MissionListActivity missionListActivity, View view) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = missionListActivity;
        View BuiltInFictitiousFunctionClassFactory = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.left_button, "method 'closeToHome'");
        this.BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.promoquest.activity.MissionListActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                missionListActivity.closeToHome();
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
