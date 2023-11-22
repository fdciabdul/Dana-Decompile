package id.dana.domain.promoquest.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.promoquest.model.QuestTrack;
import id.dana.domain.promoquest.respository.PromoQuestRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class TrackUserQuest extends UseCase<QuestTrack, Params> {
    private final PromoQuestRepository promoQuestRepository;

    @Inject
    public TrackUserQuest(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, PromoQuestRepository promoQuestRepository) {
        super(threadExecutor, postExecutionThread);
        this.promoQuestRepository = promoQuestRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<QuestTrack> buildUseCaseObservable(Params params) {
        return this.promoQuestRepository.trackQuestUser(params.missionId, params.questId, params.autoRedeem, params.bizType, params.activityId);
    }

    /* loaded from: classes4.dex */
    public static class Params {
        private final String activityId;
        private final boolean autoRedeem;
        private final String bizType;
        private final String missionId;
        private final String questId;

        public Params(boolean z, String str, String str2, String str3, String str4) {
            this.autoRedeem = z;
            this.missionId = str;
            this.questId = str2;
            this.bizType = str3;
            this.activityId = str4;
        }

        public static Params forTrackUserQuest(String str, String str2, boolean z, String str3, String str4) {
            return new Params(z, str, str2, str3, str4);
        }
    }
}
