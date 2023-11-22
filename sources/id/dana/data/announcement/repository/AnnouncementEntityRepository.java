package id.dana.data.announcement.repository;

import id.dana.data.account.repository.source.AccountEntityData;
import id.dana.data.announcement.AnnouncementEntityData;
import id.dana.data.announcement.mapper.AnnouncementMapperKt;
import id.dana.data.announcement.repository.source.AnnouncementEntityDataFactory;
import id.dana.data.announcement.repository.source.network.result.AnnouncementResult;
import id.dana.data.errorconfig.ErrorConfigEntityData;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.holdlogin.v1.HoldLoginV1Repository;
import id.dana.data.login.source.LoginEntityData;
import id.dana.domain.announcement.AnnouncementRepository;
import id.dana.domain.announcement.model.AnnouncementsInfo;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\b\u0007\u0012\u0006\u0010*\u001a\u00020)\u0012\u0006\u0010-\u001a\u00020,¢\u0006\u0004\b/\u00100J*\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0096\u0001¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0096\u0001¢\u0006\u0004\b\u0006\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bH\u0096\u0001¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0010J\u0010\u0010\u0013\u001a\u00020\u0012H\u0096\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0012H\u0096\u0001¢\u0006\u0004\b\u0015\u0010\u0014J\u0010\u0010\u0017\u001a\u00020\u0016H\u0096\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u0004H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ1\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u00042\u0006\u0010\u001d\u001a\u00020\u001a2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a0\u001eH\u0016¢\u0006\u0004\b!\u0010\"J\u001b\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u0004H\u0016¢\u0006\u0004\b#\u0010\u001cJ\u001d\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\u00042\u0006\u0010$\u001a\u00020\u001aH\u0016¢\u0006\u0004\b&\u0010'J\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020%0\u00042\u0006\u0010$\u001a\u00020\u001aH\u0016¢\u0006\u0004\b(\u0010'R\u0014\u0010*\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010-\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010."}, d2 = {"Lid/dana/data/announcement/repository/AnnouncementEntityRepository;", "Lid/dana/domain/announcement/AnnouncementRepository;", "Lid/dana/data/holdlogin/v1/HoldLoginV1Repository;", "T", "Lio/reactivex/Observable;", "observable", "authenticatedRequest", "(Lio/reactivex/Observable;)Lio/reactivex/Observable;", "Lkotlinx/coroutines/flow/Flow;", "flow", "(Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/data/account/repository/source/AccountEntityData;", "createAccountData", "()Lid/dana/data/account/repository/source/AccountEntityData;", "Lid/dana/data/announcement/AnnouncementEntityData;", "createAnnouncementEntityData", "()Lid/dana/data/announcement/AnnouncementEntityData;", "createLocalAnnouncementEntityData", "Lid/dana/data/errorconfig/ErrorConfigEntityData;", "createLocalErrorConfigData", "()Lid/dana/data/errorconfig/ErrorConfigEntityData;", "createNetworkErrorConfigData", "Lid/dana/data/login/source/LoginEntityData;", "createNetworkLogin", "()Lid/dana/data/login/source/LoginEntityData;", "", "", "getAnnouncementGnIds", "()Lio/reactivex/Observable;", "type", "", "extendInfo", "Lid/dana/domain/announcement/model/AnnouncementsInfo;", "getAnnouncements", "(Ljava/lang/String;Ljava/util/Map;)Lio/reactivex/Observable;", "getTrackedAnnouncementsGnId", "id", "", "saveAnnouncementGnId", "(Ljava/lang/String;)Lio/reactivex/Observable;", "saveTrackedAnnouncementGnId", "Lid/dana/data/announcement/repository/source/AnnouncementEntityDataFactory;", "announcementEntityDataFactory", "Lid/dana/data/announcement/repository/source/AnnouncementEntityDataFactory;", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "holdLoginV1EntityRepository", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "<init>", "(Lid/dana/data/announcement/repository/source/AnnouncementEntityDataFactory;Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AnnouncementEntityRepository implements AnnouncementRepository, HoldLoginV1Repository {
    private final AnnouncementEntityDataFactory announcementEntityDataFactory;
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
    public AnnouncementEntityRepository(AnnouncementEntityDataFactory announcementEntityDataFactory, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        Intrinsics.checkNotNullParameter(announcementEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(holdLoginV1EntityRepository, "");
        this.announcementEntityDataFactory = announcementEntityDataFactory;
        this.holdLoginV1EntityRepository = holdLoginV1EntityRepository;
    }

    @Override // id.dana.domain.announcement.AnnouncementRepository
    public final Observable<AnnouncementsInfo> getAnnouncements(String type, Map<String, String> extendInfo) {
        Intrinsics.checkNotNullParameter(type, "");
        Intrinsics.checkNotNullParameter(extendInfo, "");
        ObservableSource map = createAnnouncementEntityData().getAnnouncements(type, extendInfo).timeout(5L, TimeUnit.SECONDS).map(new Function() { // from class: id.dana.data.announcement.repository.AnnouncementEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                AnnouncementsInfo m779getAnnouncements$lambda0;
                m779getAnnouncements$lambda0 = AnnouncementEntityRepository.m779getAnnouncements$lambda0((AnnouncementResult) obj);
                return m779getAnnouncements$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return authenticatedRequest((Observable) map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getAnnouncements$lambda-0  reason: not valid java name */
    public static final AnnouncementsInfo m779getAnnouncements$lambda0(AnnouncementResult announcementResult) {
        Intrinsics.checkNotNullParameter(announcementResult, "");
        return AnnouncementMapperKt.toAnnouncementsInfo(announcementResult);
    }

    @Override // id.dana.domain.announcement.AnnouncementRepository
    public final Observable<List<String>> getAnnouncementGnIds() {
        return createLocalAnnouncementEntityData().getAnnouncementsIdGNSubscription();
    }

    @Override // id.dana.domain.announcement.AnnouncementRepository
    public final Observable<List<String>> getTrackedAnnouncementsGnId() {
        return createLocalAnnouncementEntityData().getTrackedAnnouncementsIdGNSubscription();
    }

    @Override // id.dana.domain.announcement.AnnouncementRepository
    public final Observable<Boolean> saveAnnouncementGnId(String id2) {
        Intrinsics.checkNotNullParameter(id2, "");
        return createLocalAnnouncementEntityData().setAnnouncementIdGNSubscription(id2);
    }

    @Override // id.dana.domain.announcement.AnnouncementRepository
    public final Observable<Boolean> saveTrackedAnnouncementGnId(String id2) {
        Intrinsics.checkNotNullParameter(id2, "");
        return createLocalAnnouncementEntityData().setTrackedAnnouncementIdGNSubscription(id2);
    }

    private final AnnouncementEntityData createAnnouncementEntityData() {
        return this.announcementEntityDataFactory.createData2("network");
    }

    private final AnnouncementEntityData createLocalAnnouncementEntityData() {
        return this.announcementEntityDataFactory.createData2("local");
    }
}
