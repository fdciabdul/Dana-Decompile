package id.dana.contract.promoquest.redeem;

import id.dana.contract.promoquest.redeem.RedeemQuestContract;
import id.dana.domain.DefaultObserver;
import id.dana.domain.promoquest.interactor.RedeemQuest;
import id.dana.domain.promoquest.model.PrizeInfoEntity;
import id.dana.domain.promoquest.model.QuestRedeem;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\r\u0012\u0006\u0010\u0007\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u000e"}, d2 = {"Lid/dana/contract/promoquest/redeem/RedeemQuestPresenter;", "Lid/dana/contract/promoquest/redeem/RedeemQuestContract$Presenter;", "", "onDestroy", "()V", "", "p0", "p1", "PlaceComponentResult", "(Ljava/lang/String;Ljava/lang/String;)V", "Lid/dana/domain/promoquest/interactor/RedeemQuest;", "MyBillsEntityDataFactory", "Lid/dana/domain/promoquest/interactor/RedeemQuest;", "Lid/dana/contract/promoquest/redeem/RedeemQuestContract$View;", "Lid/dana/contract/promoquest/redeem/RedeemQuestContract$View;", "getAuthRequestContext", "<init>", "(Lid/dana/contract/promoquest/redeem/RedeemQuestContract$View;Lid/dana/domain/promoquest/interactor/RedeemQuest;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RedeemQuestPresenter implements RedeemQuestContract.Presenter {
    private final RedeemQuest MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final RedeemQuestContract.View getAuthRequestContext;

    @Inject
    public RedeemQuestPresenter(RedeemQuestContract.View view, RedeemQuest redeemQuest) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(redeemQuest, "");
        this.getAuthRequestContext = view;
        this.MyBillsEntityDataFactory = redeemQuest;
    }

    @Override // id.dana.contract.promoquest.redeem.RedeemQuestContract.Presenter
    public final void PlaceComponentResult(String p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        this.getAuthRequestContext.showProgress();
        this.MyBillsEntityDataFactory.execute(new DefaultObserver<QuestRedeem>() { // from class: id.dana.contract.promoquest.redeem.RedeemQuestPresenter$redeemQuest$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                RedeemQuestContract.View view;
                RedeemQuestContract.View view2;
                RedeemQuestContract.View view3;
                QuestRedeem questRedeem = (QuestRedeem) obj;
                Intrinsics.checkNotNullParameter(questRedeem, "");
                view = RedeemQuestPresenter.this.getAuthRequestContext;
                view.dismissProgress();
                Intrinsics.checkNotNullExpressionValue(questRedeem.getPrizeInfoList(), "");
                if ((!r1.isEmpty()) != false) {
                    view3 = RedeemQuestPresenter.this.getAuthRequestContext;
                    List<PrizeInfoEntity> prizeInfoList = questRedeem.getPrizeInfoList();
                    Intrinsics.checkNotNullExpressionValue(prizeInfoList, "");
                    Object first = CollectionsKt.first((List<? extends Object>) prizeInfoList);
                    Intrinsics.checkNotNullExpressionValue(first, "");
                    view3.KClassImpl$Data$declaredNonStaticMembers$2((PrizeInfoEntity) first);
                    return;
                }
                view2 = RedeemQuestPresenter.this.getAuthRequestContext;
                view2.getAuthRequestContext();
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p02) {
                RedeemQuestContract.View view;
                RedeemQuestContract.View view2;
                Intrinsics.checkNotNullParameter(p02, "");
                view = RedeemQuestPresenter.this.getAuthRequestContext;
                view.dismissProgress();
                view2 = RedeemQuestPresenter.this.getAuthRequestContext;
                view2.getAuthRequestContext();
            }
        }, RedeemQuest.Params.forRedeemQuest(p0, p1));
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.MyBillsEntityDataFactory.dispose();
    }
}
