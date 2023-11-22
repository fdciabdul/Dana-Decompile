package id.dana.domain.donation.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.donation.DonationRepository;
import id.dana.domain.donation.model.DonationCampaign;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001B!\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/domain/donation/interactor/GetDonationCampaigns;", "Lid/dana/domain/UseCase;", "", "Lid/dana/domain/donation/model/DonationCampaign;", "", "params", "Lio/reactivex/Observable;", "buildUseCaseObservable", "(Lkotlin/Unit;)Lio/reactivex/Observable;", "Lid/dana/domain/donation/DonationRepository;", "donationRepository", "Lid/dana/domain/donation/DonationRepository;", "Lid/dana/utils/concurrent/ThreadExecutor;", "threadExecutor", "Lid/dana/domain/PostExecutionThread;", "postExecutionThread", "<init>", "(Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/domain/PostExecutionThread;Lid/dana/domain/donation/DonationRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class GetDonationCampaigns extends UseCase<List<? extends DonationCampaign>, Unit> {
    private final DonationRepository donationRepository;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public GetDonationCampaigns(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, DonationRepository donationRepository) {
        super(threadExecutor, postExecutionThread);
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(postExecutionThread, "");
        Intrinsics.checkNotNullParameter(donationRepository, "");
        this.donationRepository = donationRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public final Observable<List<DonationCampaign>> buildUseCaseObservable(Unit params) {
        return this.donationRepository.getDonationCampaigns();
    }
}
