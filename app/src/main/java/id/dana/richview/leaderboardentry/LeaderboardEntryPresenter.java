package id.dana.richview.leaderboardentry;

import android.content.Context;
import id.dana.domain.DefaultObserver;
import id.dana.domain.featureconfig.interactor.CheckLeaderboardEntryFeature;
import id.dana.domain.promotion.Space;
import id.dana.domain.promotion.interactor.GetLeaderboardEntryBanner;
import id.dana.mapper.LeaderboardMapper;
import id.dana.richview.leaderboardentry.LeaderboardEntryContract;
import id.dana.utils.ErrorUtil;
import javax.inject.Inject;

/* loaded from: classes9.dex */
public class LeaderboardEntryPresenter implements LeaderboardEntryContract.Presenter {
    private final CheckLeaderboardEntryFeature BuiltInFictitiousFunctionClassFactory;
    private final LeaderboardEntryContract.View KClassImpl$Data$declaredNonStaticMembers$2;
    private final GetLeaderboardEntryBanner MyBillsEntityDataFactory;
    private final Context PlaceComponentResult;
    private final LeaderboardMapper getAuthRequestContext;

    @Inject
    public LeaderboardEntryPresenter(Context context, LeaderboardEntryContract.View view, GetLeaderboardEntryBanner getLeaderboardEntryBanner, CheckLeaderboardEntryFeature checkLeaderboardEntryFeature, LeaderboardMapper leaderboardMapper) {
        this.PlaceComponentResult = context;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
        this.MyBillsEntityDataFactory = getLeaderboardEntryBanner;
        this.BuiltInFictitiousFunctionClassFactory = checkLeaderboardEntryFeature;
        this.getAuthRequestContext = leaderboardMapper;
    }

    @Override // id.dana.richview.leaderboardentry.LeaderboardEntryContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.showProgress();
        this.MyBillsEntityDataFactory.execute(new DefaultObserver<Space>() { // from class: id.dana.richview.leaderboardentry.LeaderboardEntryPresenter.1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                Space space = (Space) obj;
                if (space.getCdpContents() != null) {
                    LeaderboardEntryPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2.onGetLeaderBoardSuccess(LeaderboardEntryPresenter.this.getAuthRequestContext.apply(space).BuiltInFictitiousFunctionClassFactory);
                }
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                LeaderboardEntryPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2.onError(ErrorUtil.PlaceComponentResult(th, LeaderboardEntryPresenter.this.PlaceComponentResult));
            }
        });
    }

    @Override // id.dana.richview.leaderboardentry.LeaderboardEntryContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.BuiltInFictitiousFunctionClassFactory.execute(new DefaultObserver<Boolean>() { // from class: id.dana.richview.leaderboardentry.LeaderboardEntryPresenter.2
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                LeaderboardEntryPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2.onCheckLeaderBoardFeatureSuccess(((Boolean) obj).booleanValue());
            }
        });
    }

    @Override // id.dana.richview.leaderboardentry.LeaderboardEntryContract.Presenter
    public final void PlaceComponentResult() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.dismissProgress();
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        this.MyBillsEntityDataFactory.dispose();
        this.BuiltInFictitiousFunctionClassFactory.dispose();
    }
}
