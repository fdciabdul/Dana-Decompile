package id.dana.promoquest.fragment;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public final class MissionListFragment_ViewBinding implements Unbinder {
    private View BuiltInFictitiousFunctionClassFactory;
    private MissionListFragment KClassImpl$Data$declaredNonStaticMembers$2;

    public MissionListFragment_ViewBinding(final MissionListFragment missionListFragment, View view) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = missionListFragment;
        View BuiltInFictitiousFunctionClassFactory = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.f3534res_0x7f0a023f_apistatus_availablesince, "method 'fetchMissions'");
        this.BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.promoquest.fragment.MissionListFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                missionListFragment.fetchMissions();
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
