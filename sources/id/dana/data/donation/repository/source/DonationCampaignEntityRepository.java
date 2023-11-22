package id.dana.data.donation.repository.source;

import id.dana.data.account.repository.source.AccountEntityData;
import id.dana.data.donation.mapper.DonationCampaignMapperKt;
import id.dana.data.donation.repository.DonationCampaignEntityData;
import id.dana.data.donation.repository.source.network.result.DonationCampaignResult;
import id.dana.data.errorconfig.ErrorConfigEntityData;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.holdlogin.v1.HoldLoginV1Repository;
import id.dana.data.login.source.LoginEntityData;
import id.dana.domain.donation.DonationRepository;
import id.dana.domain.donation.model.DonationCampaign;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\b\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b\"\u0010#J*\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0096\u0001¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0096\u0001¢\u0006\u0004\b\u0006\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bH\u0096\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eH\u0096\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u000eH\u0096\u0001¢\u0006\u0004\b\u0014\u0010\u0010J\u0010\u0010\u0016\u001a\u00020\u0015H\u0096\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u0004H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!"}, d2 = {"Lid/dana/data/donation/repository/source/DonationCampaignEntityRepository;", "Lid/dana/domain/donation/DonationRepository;", "Lid/dana/data/holdlogin/v1/HoldLoginV1Repository;", "T", "Lio/reactivex/Observable;", "observable", "authenticatedRequest", "(Lio/reactivex/Observable;)Lio/reactivex/Observable;", "Lkotlinx/coroutines/flow/Flow;", "flow", "(Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/data/account/repository/source/AccountEntityData;", "createAccountData", "()Lid/dana/data/account/repository/source/AccountEntityData;", "Lid/dana/data/errorconfig/ErrorConfigEntityData;", "createLocalErrorConfigData", "()Lid/dana/data/errorconfig/ErrorConfigEntityData;", "Lid/dana/data/donation/repository/DonationCampaignEntityData;", "createNetworkDonationCampaignData", "()Lid/dana/data/donation/repository/DonationCampaignEntityData;", "createNetworkErrorConfigData", "Lid/dana/data/login/source/LoginEntityData;", "createNetworkLogin", "()Lid/dana/data/login/source/LoginEntityData;", "", "Lid/dana/domain/donation/model/DonationCampaign;", "getDonationCampaigns", "()Lio/reactivex/Observable;", "Lid/dana/data/donation/repository/source/DonationCampaignDataFactory;", "donationCampaignDataFactory", "Lid/dana/data/donation/repository/source/DonationCampaignDataFactory;", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "holdLoginV1EntityRepository", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "<init>", "(Lid/dana/data/donation/repository/source/DonationCampaignDataFactory;Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DonationCampaignEntityRepository implements DonationRepository, HoldLoginV1Repository {
    private final DonationCampaignDataFactory donationCampaignDataFactory;
    private final HoldLoginV1EntityRepository holdLoginV1EntityRepository;

    public final <T> Observable<T> authenticatedRequest(Observable<T> observable) {
        Intrinsics.checkNotNullParameter(observable, "");
        Observable<T> authenticatedRequest = this.holdLoginV1EntityRepository.authenticatedRequest(observable);
        Intrinsics.checkNotNullExpressionValue(authenticatedRequest, "");
        return authenticatedRequest;
    }

    public final <T> Flow<T> authenticatedRequest(Flow<? extends T> flow) {
        Intrinsics.checkNotNullParameter(flow, "");
        return this.holdLoginV1EntityRepository.PlaceComponentResult(flow);
    }

    public final AccountEntityData createAccountData() {
        AccountEntityData createAccountData = this.holdLoginV1EntityRepository.createAccountData();
        Intrinsics.checkNotNullExpressionValue(createAccountData, "");
        return createAccountData;
    }

    public final ErrorConfigEntityData createLocalErrorConfigData() {
        ErrorConfigEntityData createLocalErrorConfigData = this.holdLoginV1EntityRepository.createLocalErrorConfigData();
        Intrinsics.checkNotNullExpressionValue(createLocalErrorConfigData, "");
        return createLocalErrorConfigData;
    }

    public final ErrorConfigEntityData createNetworkErrorConfigData() {
        ErrorConfigEntityData createNetworkErrorConfigData = this.holdLoginV1EntityRepository.createNetworkErrorConfigData();
        Intrinsics.checkNotNullExpressionValue(createNetworkErrorConfigData, "");
        return createNetworkErrorConfigData;
    }

    public final LoginEntityData createNetworkLogin() {
        LoginEntityData createNetworkLogin = this.holdLoginV1EntityRepository.createNetworkLogin();
        Intrinsics.checkNotNullExpressionValue(createNetworkLogin, "");
        return createNetworkLogin;
    }

    @Inject
    public DonationCampaignEntityRepository(DonationCampaignDataFactory donationCampaignDataFactory, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        Intrinsics.checkNotNullParameter(donationCampaignDataFactory, "");
        Intrinsics.checkNotNullParameter(holdLoginV1EntityRepository, "");
        this.donationCampaignDataFactory = donationCampaignDataFactory;
        this.holdLoginV1EntityRepository = holdLoginV1EntityRepository;
    }

    @Override // id.dana.domain.donation.DonationRepository
    public final Observable<List<DonationCampaign>> getDonationCampaigns() {
        Observable<List<DonationCampaign>> map = authenticatedRequest(createNetworkDonationCampaignData().getDonationCampaigns()).map(new Function() { // from class: id.dana.data.donation.repository.source.DonationCampaignEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List m1207getDonationCampaigns$lambda0;
                m1207getDonationCampaigns$lambda0 = DonationCampaignEntityRepository.m1207getDonationCampaigns$lambda0((DonationCampaignResult) obj);
                return m1207getDonationCampaigns$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getDonationCampaigns$lambda-0  reason: not valid java name */
    public static final List m1207getDonationCampaigns$lambda0(DonationCampaignResult donationCampaignResult) {
        Intrinsics.checkNotNullParameter(donationCampaignResult, "");
        return DonationCampaignMapperKt.toDonationList(donationCampaignResult);
    }

    private final DonationCampaignEntityData createNetworkDonationCampaignData() {
        return this.donationCampaignDataFactory.createData2("network");
    }
}
