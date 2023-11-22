package id.dana.promoquest.views;

import dagger.MembersInjector;
import id.dana.contract.promoquest.quest.MissionSummaryContract;

/* loaded from: classes9.dex */
public final class MissionSummaryView_MembersInjector implements MembersInjector<MissionSummaryView> {
    public static void PlaceComponentResult(MissionSummaryView missionSummaryView, MissionSummaryContract.Presenter presenter) {
        missionSummaryView.missionSummaryPresenter = presenter;
    }
}
