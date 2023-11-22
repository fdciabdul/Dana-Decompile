package id.dana.contract.promoquest.redeem;

import id.dana.contract.promoquest.redeem.RedeemMissionContract;
import id.dana.domain.DefaultObserver;
import id.dana.domain.promoquest.interactor.RedeemMission;
import id.dana.domain.promoquest.model.MissionRedeem;
import id.dana.domain.promoquest.model.PrizeInfoEntity;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0007\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u000e"}, d2 = {"Lid/dana/contract/promoquest/redeem/RedeemMissionPresenter;", "Lid/dana/contract/promoquest/redeem/RedeemMissionContract$Presenter;", "", "onDestroy", "()V", "", "p0", "PlaceComponentResult", "(Ljava/lang/String;)V", "Lid/dana/domain/promoquest/interactor/RedeemMission;", "MyBillsEntityDataFactory", "Lid/dana/domain/promoquest/interactor/RedeemMission;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/contract/promoquest/redeem/RedeemMissionContract$View;", "Lid/dana/contract/promoquest/redeem/RedeemMissionContract$View;", "p1", "<init>", "(Lid/dana/contract/promoquest/redeem/RedeemMissionContract$View;Lid/dana/domain/promoquest/interactor/RedeemMission;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RedeemMissionPresenter implements RedeemMissionContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final RedeemMissionContract.View PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final RedeemMission BuiltInFictitiousFunctionClassFactory;

    @Inject
    public RedeemMissionPresenter(RedeemMissionContract.View view, RedeemMission redeemMission) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(redeemMission, "");
        this.PlaceComponentResult = view;
        this.BuiltInFictitiousFunctionClassFactory = redeemMission;
    }

    @Override // id.dana.contract.promoquest.redeem.RedeemMissionContract.Presenter
    public final void PlaceComponentResult(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.PlaceComponentResult.showProgress();
        this.BuiltInFictitiousFunctionClassFactory.execute(new DefaultObserver<MissionRedeem>() { // from class: id.dana.contract.promoquest.redeem.RedeemMissionPresenter$redeemMission$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                RedeemMissionContract.View view;
                RedeemMissionContract.View view2;
                RedeemMissionContract.View view3;
                MissionRedeem missionRedeem = (MissionRedeem) obj;
                Intrinsics.checkNotNullParameter(missionRedeem, "");
                view = RedeemMissionPresenter.this.PlaceComponentResult;
                view.dismissProgress();
                Intrinsics.checkNotNullExpressionValue(missionRedeem.getPrizeInfoList(), "");
                if ((!r1.isEmpty()) != false) {
                    view3 = RedeemMissionPresenter.this.PlaceComponentResult;
                    List<PrizeInfoEntity> prizeInfoList = missionRedeem.getPrizeInfoList();
                    Intrinsics.checkNotNullExpressionValue(prizeInfoList, "");
                    Object first = CollectionsKt.first((List<? extends Object>) prizeInfoList);
                    Intrinsics.checkNotNullExpressionValue(first, "");
                    view3.KClassImpl$Data$declaredNonStaticMembers$2((PrizeInfoEntity) first);
                    return;
                }
                view2 = RedeemMissionPresenter.this.PlaceComponentResult;
                view2.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p02) {
                RedeemMissionContract.View view;
                RedeemMissionContract.View view2;
                Intrinsics.checkNotNullParameter(p02, "");
                view = RedeemMissionPresenter.this.PlaceComponentResult;
                view.dismissProgress();
                view2 = RedeemMissionPresenter.this.PlaceComponentResult;
                view2.BuiltInFictitiousFunctionClassFactory();
            }
        }, RedeemMission.Params.forRedeemMission(p0));
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.BuiltInFictitiousFunctionClassFactory.dispose();
    }
}
