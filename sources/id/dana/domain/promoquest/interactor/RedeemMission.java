package id.dana.domain.promoquest.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.promoquest.model.MissionRedeem;
import id.dana.domain.promoquest.respository.PromoQuestRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class RedeemMission extends UseCase<MissionRedeem, Params> {
    private final PromoQuestRepository questRepository;

    @Inject
    public RedeemMission(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, PromoQuestRepository promoQuestRepository) {
        super(threadExecutor, postExecutionThread);
        this.questRepository = promoQuestRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<MissionRedeem> buildUseCaseObservable(Params params) {
        return this.questRepository.redeemMission(params.missionId);
    }

    /* loaded from: classes4.dex */
    public static class Params {
        private String missionId;

        private Params(String str) {
            this.missionId = str;
        }

        public static Params forRedeemMission(String str) {
            return new Params(str);
        }
    }
}
