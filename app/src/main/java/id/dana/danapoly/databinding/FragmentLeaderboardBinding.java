package id.dana.danapoly.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.core.ui.databinding.ViewBaseToolbarBinding;
import id.dana.danapoly.R;
import id.dana.danapoly.ui.leaderboard.view.CountDownView;
import id.dana.danapoly.ui.leaderboard.view.LeaderboardTopThreeView;

/* loaded from: classes4.dex */
public final class FragmentLeaderboardBinding implements ViewBinding {
    public final LeaderboardTopThreeView BuiltInFictitiousFunctionClassFactory;
    public final ViewBaseToolbarBinding KClassImpl$Data$declaredNonStaticMembers$2;
    public final RecyclerView MyBillsEntityDataFactory;
    public final Barrier PlaceComponentResult;
    public final CountDownView getAuthRequestContext;
    private final ConstraintLayout scheduleImpl;

    private FragmentLeaderboardBinding(ConstraintLayout constraintLayout, Barrier barrier, RecyclerView recyclerView, ViewBaseToolbarBinding viewBaseToolbarBinding, CountDownView countDownView, LeaderboardTopThreeView leaderboardTopThreeView) {
        this.scheduleImpl = constraintLayout;
        this.PlaceComponentResult = barrier;
        this.MyBillsEntityDataFactory = recyclerView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = viewBaseToolbarBinding;
        this.getAuthRequestContext = countDownView;
        this.BuiltInFictitiousFunctionClassFactory = leaderboardTopThreeView;
    }

    public static FragmentLeaderboardBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View BuiltInFictitiousFunctionClassFactory;
        View inflate = layoutInflater.inflate(R.layout.res_0x7f0d01da_networkuserentitydata_externalsyntheticlambda1, viewGroup, false);
        int i = R.id.BuiltInFictitiousFunctionClassFactory_res_0x7f0a00c3;
        Barrier barrier = (Barrier) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (barrier != null) {
            i = R.id.res_0x7f0a10ff_securitysettingsactivity_createpinlauncher_2_2;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (recyclerView != null && (BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, (i = R.id.toolbar_danapoly))) != null) {
                ViewBaseToolbarBinding MyBillsEntityDataFactory = ViewBaseToolbarBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
                i = R.id.getTypeMappings_res_0x7f0a1a7a;
                CountDownView countDownView = (CountDownView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (countDownView != null) {
                    i = R.id.viewTopThree;
                    LeaderboardTopThreeView leaderboardTopThreeView = (LeaderboardTopThreeView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                    if (leaderboardTopThreeView != null) {
                        return new FragmentLeaderboardBinding((ConstraintLayout) inflate, barrier, recyclerView, MyBillsEntityDataFactory, countDownView, leaderboardTopThreeView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.scheduleImpl;
    }
}
