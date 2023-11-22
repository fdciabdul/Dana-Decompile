package id.dana.domain.promoquest.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.promoquest.model.MissionSummary;
import id.dana.domain.promoquest.respository.PromoQuestRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes8.dex */
public class GetMissionSummary extends UseCase<List<MissionSummary>, Void> {
    private final PromoQuestRepository promoQuestRepository;

    @Inject
    public GetMissionSummary(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, PromoQuestRepository promoQuestRepository) {
        super(threadExecutor, postExecutionThread);
        this.promoQuestRepository = promoQuestRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<List<MissionSummary>> buildUseCaseObservable(Void r1) {
        return this.promoQuestRepository.getMissionSummary();
    }
}
