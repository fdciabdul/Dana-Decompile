package id.dana.domain.promoquest.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.promoquest.model.QuestRedeem;
import id.dana.domain.promoquest.respository.PromoQuestRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class RedeemQuest extends UseCase<QuestRedeem, Params> {
    private final PromoQuestRepository questRepository;

    @Inject
    public RedeemQuest(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, PromoQuestRepository promoQuestRepository) {
        super(threadExecutor, postExecutionThread);
        this.questRepository = promoQuestRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<QuestRedeem> buildUseCaseObservable(Params params) {
        return this.questRepository.redeemQuest(params.missionId, params.questId);
    }

    /* loaded from: classes4.dex */
    public static class Params {
        private String missionId;
        private String questId;

        private Params(String str, String str2) {
            this.missionId = str;
            this.questId = str2;
        }

        public static Params forRedeemQuest(String str, String str2) {
            return new Params(str, str2);
        }
    }
}
