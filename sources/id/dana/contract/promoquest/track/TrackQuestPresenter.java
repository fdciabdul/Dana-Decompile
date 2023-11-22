package id.dana.contract.promoquest.track;

import android.text.TextUtils;
import id.dana.contract.promoquest.track.TrackQuestContract;
import id.dana.domain.DefaultObserver;
import id.dana.domain.promoquest.interactor.TrackUserQuest;
import id.dana.domain.promoquest.model.QuestTrack;
import id.dana.network.exception.NetworkException;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class TrackQuestPresenter implements TrackQuestContract.Presenter {
    private final TrackUserQuest BuiltInFictitiousFunctionClassFactory;
    private final TrackQuestContract.View PlaceComponentResult;

    @Inject
    public TrackQuestPresenter(TrackQuestContract.View view, TrackUserQuest trackUserQuest) {
        this.PlaceComponentResult = view;
        this.BuiltInFictitiousFunctionClassFactory = trackUserQuest;
    }

    @Override // id.dana.contract.promoquest.track.TrackQuestContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(String str, final String str2, final boolean z, String str3, String str4) {
        this.BuiltInFictitiousFunctionClassFactory.execute(new DefaultObserver<QuestTrack>() { // from class: id.dana.contract.promoquest.track.TrackQuestPresenter.1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                QuestTrack questTrack = (QuestTrack) obj;
                if (questTrack == null) {
                    TrackQuestPresenter.this.PlaceComponentResult.PlaceComponentResult();
                } else if (questTrack.isTrackResult()) {
                    TrackQuestPresenter.getAuthRequestContext(TrackQuestPresenter.this, questTrack.isRedeemResult(), z, str2);
                } else {
                    TrackQuestPresenter.getAuthRequestContext(TrackQuestPresenter.this, questTrack.getQuestRedirectType(), questTrack.getQuestRedirectValue());
                }
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                super.onError(th);
                if (th instanceof NetworkException) {
                    TrackQuestPresenter.this.PlaceComponentResult.onError(th.getMessage());
                }
                TrackQuestPresenter.this.PlaceComponentResult.PlaceComponentResult();
            }
        }, TrackUserQuest.Params.forTrackUserQuest(str, str2, false, str3, str4));
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        this.BuiltInFictitiousFunctionClassFactory.dispose();
    }

    static /* synthetic */ void getAuthRequestContext(TrackQuestPresenter trackQuestPresenter, boolean z, boolean z2, String str) {
        if (z) {
            trackQuestPresenter.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2();
        } else {
            trackQuestPresenter.PlaceComponentResult.MyBillsEntityDataFactory(z2, str);
        }
    }

    static /* synthetic */ void getAuthRequestContext(TrackQuestPresenter trackQuestPresenter, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            trackQuestPresenter.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(str, str2);
        } else {
            trackQuestPresenter.PlaceComponentResult.PlaceComponentResult();
        }
    }
}
