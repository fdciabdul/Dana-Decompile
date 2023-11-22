package id.dana.richview.leaderboardentry;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public class LeaderboardEntryView_ViewBinding implements Unbinder {
    private View KClassImpl$Data$declaredNonStaticMembers$2;
    private LeaderboardEntryView MyBillsEntityDataFactory;

    public LeaderboardEntryView_ViewBinding(final LeaderboardEntryView leaderboardEntryView, View view) {
        this.MyBillsEntityDataFactory = leaderboardEntryView;
        View BuiltInFictitiousFunctionClassFactory = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_leaderboard_entry, "method 'onClickEntry'");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.richview.leaderboardentry.LeaderboardEntryView_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                leaderboardEntryView.onClickEntry();
            }
        });
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        if (this.MyBillsEntityDataFactory == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.MyBillsEntityDataFactory = null;
        this.KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(null);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
    }
}
