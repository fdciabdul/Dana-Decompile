package id.dana.data.saving.repository;

import id.dana.data.account.repository.source.AccountEntityData;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.data.errorconfig.ErrorConfigEntityData;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.holdlogin.v1.HoldLoginV1Repository;
import id.dana.data.login.source.LoginEntityData;
import id.dana.data.saving.mapper.SavingDetailMapperKt;
import id.dana.data.saving.mapper.SavingEmptyStateMapperKt;
import id.dana.data.saving.mapper.SavingLimitMapperKt;
import id.dana.data.saving.mapper.SavingTopUpInitMapperKt;
import id.dana.data.saving.mapper.SavingUpdateInitMapperKt;
import id.dana.data.saving.mapper.SavingWithdrawMapperKt;
import id.dana.data.saving.model.SavingEmptyStateEntity;
import id.dana.data.saving.model.SavingLimitEntity;
import id.dana.data.saving.model.SavingViewKt;
import id.dana.data.saving.repository.source.network.response.GoalCreateInitResult;
import id.dana.data.saving.repository.source.network.response.GoalCreateInitResultKt;
import id.dana.data.saving.repository.source.network.response.GoalCreateSubmitResult;
import id.dana.data.saving.repository.source.network.response.GoalRevokeResult;
import id.dana.data.saving.repository.source.network.response.GoalTopUpInitResult;
import id.dana.data.saving.repository.source.network.response.GoalUpdateInitResult;
import id.dana.data.saving.repository.source.network.response.GoalUpdateSubmitResult;
import id.dana.data.saving.repository.source.network.response.SavingDetailResult;
import id.dana.data.saving.repository.source.network.response.SavingTopUpSubmitResult;
import id.dana.data.saving.repository.source.network.response.SavingWithdrawInitEntityResult;
import id.dana.data.saving.repository.source.network.response.UserSavingSummaryConsultResult;
import id.dana.data.saving.repository.source.network.response.UserSavingSummaryConsultResultKt;
import id.dana.domain.saving.SavingRepository;
import id.dana.domain.saving.model.SavingCreateInit;
import id.dana.domain.saving.model.SavingDetail;
import id.dana.domain.saving.model.SavingEmptyState;
import id.dana.domain.saving.model.SavingGoalView;
import id.dana.domain.saving.model.SavingLimit;
import id.dana.domain.saving.model.SavingSummary;
import id.dana.domain.saving.model.SavingTopUpInit;
import id.dana.domain.saving.model.SavingUpdateInit;
import id.dana.domain.saving.model.SavingWithdrawInitRequest;
import id.dana.domain.saving.model.SavingWithdrawInitResult;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

@Singleton
@Metadata(d1 = {"\u0000Ø\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B1\b\u0007\u0012\u0006\u0010C\u001a\u00020B\u0012\u0006\u0010R\u001a\u00020Q\u0012\u0006\u0010U\u001a\u00020T\u0012\u0006\u0010I\u001a\u00020H\u0012\u0006\u0010F\u001a\u00020E¢\u0006\u0004\b_\u0010`J*\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0096\u0001¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0096\u0001¢\u0006\u0004\b\u0006\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bH\u0096\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eH\u0096\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u000eH\u0096\u0001¢\u0006\u0004\b\u0011\u0010\u0010J\u0010\u0010\u0013\u001a\u00020\u0012H\u0096\u0001¢\u0006\u0004\b\u0013\u0010\u0014J-\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001f\u0010\u001eJ-\u0010%\u001a\b\u0012\u0004\u0012\u00020$0\u00042\u0006\u0010 \u001a\u00020\u00152\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!H\u0016¢\u0006\u0004\b%\u0010&J\u0015\u0010(\u001a\b\u0012\u0004\u0012\u00020'0\u0004H\u0016¢\u0006\u0004\b(\u0010)J\u0015\u0010+\u001a\b\u0012\u0004\u0012\u00020*0\u0004H\u0016¢\u0006\u0004\b+\u0010)J\u0015\u0010-\u001a\b\u0012\u0004\u0012\u00020,0\u0004H\u0016¢\u0006\u0004\b-\u0010)J\u001b\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150.0\u0004H\u0016¢\u0006\u0004\b/\u0010)J\u0015\u00101\u001a\b\u0012\u0004\u0012\u0002000\u0004H\u0016¢\u0006\u0004\b1\u0010)J\u001d\u00103\u001a\b\u0012\u0004\u0012\u0002020\u00042\u0006\u0010 \u001a\u00020\u0015H\u0016¢\u0006\u0004\b3\u00104J\u001d\u00106\u001a\b\u0012\u0004\u0012\u0002050\u00042\u0006\u0010 \u001a\u00020\u0015H\u0016¢\u0006\u0004\b6\u00104J\u001d\u00109\u001a\b\u0012\u0004\u0012\u0002080\u00042\u0006\u0010 \u001a\u000207H\u0016¢\u0006\u0004\b9\u0010:J\u001d\u0010<\u001a\b\u0012\u0004\u0012\u00020;0\u00042\u0006\u0010 \u001a\u00020\u0015H\u0016¢\u0006\u0004\b<\u00104J%\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00150\u00042\u0006\u0010 \u001a\u00020\u00152\u0006\u0010=\u001a\u00020\u0015H\u0016¢\u0006\u0004\b>\u0010?J5\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00190\u00042\u0006\u0010 \u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0016¢\u0006\u0004\b@\u0010AR\u0014\u0010C\u001a\u00020B8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0014\u0010F\u001a\u00020E8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010I\u001a\u00020H8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u001b\u0010P\u001a\u00020K8CX\u0083\u0084\u0002¢\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010OR\u0014\u0010R\u001a\u00020Q8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\u0014\u0010U\u001a\u00020T8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bU\u0010VR\u001b\u0010[\u001a\u00020W8CX\u0083\u0084\u0002¢\u0006\f\n\u0004\bX\u0010M\u001a\u0004\bY\u0010ZR\u001b\u0010^\u001a\u00020W8CX\u0083\u0084\u0002¢\u0006\f\n\u0004\b\\\u0010M\u001a\u0004\b]\u0010Z"}, d2 = {"Lid/dana/data/saving/repository/SavingEntityRepository;", "Lid/dana/domain/saving/SavingRepository;", "Lid/dana/data/holdlogin/v1/HoldLoginV1Repository;", "T", "Lio/reactivex/Observable;", "observable", "authenticatedRequest", "(Lio/reactivex/Observable;)Lio/reactivex/Observable;", "Lkotlinx/coroutines/flow/Flow;", "flow", "(Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/data/account/repository/source/AccountEntityData;", "createAccountData", "()Lid/dana/data/account/repository/source/AccountEntityData;", "Lid/dana/data/errorconfig/ErrorConfigEntityData;", "createLocalErrorConfigData", "()Lid/dana/data/errorconfig/ErrorConfigEntityData;", "createNetworkErrorConfigData", "Lid/dana/data/login/source/LoginEntityData;", "createNetworkLogin", "()Lid/dana/data/login/source/LoginEntityData;", "", "categoryCode", "title", "targetAmount", "Lid/dana/domain/saving/model/SavingGoalView;", "createSaving", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/data/saving/repository/SavingConfigEntityData;", "createSavingConfigLocalEntityData", "()Lid/dana/data/saving/repository/SavingConfigEntityData;", "createSavingConfigSplitEntityData", "savingId", "", "topUpViewsPage", "topUpViewsSize", "Lid/dana/domain/saving/model/SavingDetail;", "getSavingDetail", "(Ljava/lang/String;JJ)Lio/reactivex/Observable;", "Lid/dana/domain/saving/model/SavingEmptyState;", "getSavingEmptyState", "()Lio/reactivex/Observable;", "Lid/dana/domain/saving/model/SavingLimit;", "getSavingLimit", "Lid/dana/domain/saving/model/SavingSummary;", "getSavingSummary", "", "getWithdrawOption", "Lid/dana/domain/saving/model/SavingCreateInit;", "initSavingCreate", "Lid/dana/domain/saving/model/SavingTopUpInit;", "initSavingTopUp", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/domain/saving/model/SavingUpdateInit;", "initSavingUpdate", "Lid/dana/domain/saving/model/SavingWithdrawInitRequest;", "Lid/dana/domain/saving/model/SavingWithdrawInitResult;", "initSavingWithdraw", "(Lid/dana/domain/saving/model/SavingWithdrawInitRequest;)Lio/reactivex/Observable;", "", "revokeSaving", "fundAmount", "topUpSaving", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "updateSaving", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/data/config/DeviceInformationProvider;", "deviceInformationProvider", "Lid/dana/data/config/DeviceInformationProvider;", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "holdLoginV1EntityRepository", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "Lid/dana/data/saving/repository/SavingConfigEntityDataFactory;", "savingConfigEntityDataFactory", "Lid/dana/data/saving/repository/SavingConfigEntityDataFactory;", "Lid/dana/data/saving/repository/SavingEntityData;", "savingEntityData$delegate", "Lkotlin/Lazy;", "getSavingEntityData", "()Lid/dana/data/saving/repository/SavingEntityData;", "savingEntityData", "Lid/dana/data/saving/repository/SavingEntityDataFactory;", "savingEntityDataFactory", "Lid/dana/data/saving/repository/SavingEntityDataFactory;", "Lid/dana/data/saving/repository/SavingWithdrawEntityDataFactory;", "savingWithdrawEntityDataFactory", "Lid/dana/data/saving/repository/SavingWithdrawEntityDataFactory;", "Lid/dana/data/saving/repository/SavingWithdrawEntityData;", "savingWithdrawLocalEntityData$delegate", "getSavingWithdrawLocalEntityData", "()Lid/dana/data/saving/repository/SavingWithdrawEntityData;", "savingWithdrawLocalEntityData", "savingWithdrawNetworkEntityData$delegate", "getSavingWithdrawNetworkEntityData", "savingWithdrawNetworkEntityData", "<init>", "(Lid/dana/data/config/DeviceInformationProvider;Lid/dana/data/saving/repository/SavingEntityDataFactory;Lid/dana/data/saving/repository/SavingWithdrawEntityDataFactory;Lid/dana/data/saving/repository/SavingConfigEntityDataFactory;Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SavingEntityRepository implements SavingRepository, HoldLoginV1Repository {
    private final DeviceInformationProvider deviceInformationProvider;
    private final HoldLoginV1EntityRepository holdLoginV1EntityRepository;
    private final SavingConfigEntityDataFactory savingConfigEntityDataFactory;

    /* renamed from: savingEntityData$delegate  reason: from kotlin metadata */
    private final Lazy savingEntityData;
    private final SavingEntityDataFactory savingEntityDataFactory;
    private final SavingWithdrawEntityDataFactory savingWithdrawEntityDataFactory;

    /* renamed from: savingWithdrawLocalEntityData$delegate  reason: from kotlin metadata */
    private final Lazy savingWithdrawLocalEntityData;

    /* renamed from: savingWithdrawNetworkEntityData$delegate  reason: from kotlin metadata */
    private final Lazy savingWithdrawNetworkEntityData;

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
    public SavingEntityRepository(DeviceInformationProvider deviceInformationProvider, SavingEntityDataFactory savingEntityDataFactory, SavingWithdrawEntityDataFactory savingWithdrawEntityDataFactory, SavingConfigEntityDataFactory savingConfigEntityDataFactory, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        Intrinsics.checkNotNullParameter(deviceInformationProvider, "");
        Intrinsics.checkNotNullParameter(savingEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(savingWithdrawEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(savingConfigEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(holdLoginV1EntityRepository, "");
        this.deviceInformationProvider = deviceInformationProvider;
        this.savingEntityDataFactory = savingEntityDataFactory;
        this.savingWithdrawEntityDataFactory = savingWithdrawEntityDataFactory;
        this.savingConfigEntityDataFactory = savingConfigEntityDataFactory;
        this.holdLoginV1EntityRepository = holdLoginV1EntityRepository;
        this.savingEntityData = LazyKt.lazy(new Function0<SavingEntityData>() { // from class: id.dana.data.saving.repository.SavingEntityRepository$savingEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SavingEntityData invoke() {
                SavingEntityDataFactory savingEntityDataFactory2;
                savingEntityDataFactory2 = SavingEntityRepository.this.savingEntityDataFactory;
                return savingEntityDataFactory2.createData2("network");
            }
        });
        this.savingWithdrawLocalEntityData = LazyKt.lazy(new Function0<SavingWithdrawEntityData>() { // from class: id.dana.data.saving.repository.SavingEntityRepository$savingWithdrawLocalEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SavingWithdrawEntityData invoke() {
                SavingWithdrawEntityDataFactory savingWithdrawEntityDataFactory2;
                savingWithdrawEntityDataFactory2 = SavingEntityRepository.this.savingWithdrawEntityDataFactory;
                return savingWithdrawEntityDataFactory2.createData2("local");
            }
        });
        this.savingWithdrawNetworkEntityData = LazyKt.lazy(new Function0<SavingWithdrawEntityData>() { // from class: id.dana.data.saving.repository.SavingEntityRepository$savingWithdrawNetworkEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SavingWithdrawEntityData invoke() {
                SavingWithdrawEntityDataFactory savingWithdrawEntityDataFactory2;
                savingWithdrawEntityDataFactory2 = SavingEntityRepository.this.savingWithdrawEntityDataFactory;
                return savingWithdrawEntityDataFactory2.createData2("network");
            }
        });
    }

    @JvmName(name = "getSavingEntityData")
    private final SavingEntityData getSavingEntityData() {
        return (SavingEntityData) this.savingEntityData.getValue();
    }

    @JvmName(name = "getSavingWithdrawLocalEntityData")
    private final SavingWithdrawEntityData getSavingWithdrawLocalEntityData() {
        return (SavingWithdrawEntityData) this.savingWithdrawLocalEntityData.getValue();
    }

    @JvmName(name = "getSavingWithdrawNetworkEntityData")
    private final SavingWithdrawEntityData getSavingWithdrawNetworkEntityData() {
        return (SavingWithdrawEntityData) this.savingWithdrawNetworkEntityData.getValue();
    }

    @Override // id.dana.domain.saving.SavingRepository
    public final Observable<SavingSummary> getSavingSummary() {
        ObservableSource map = getSavingEntityData().getSavingSummary().map(new Function() { // from class: id.dana.data.saving.repository.SavingEntityRepository$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SavingSummary m1854getSavingSummary$lambda0;
                m1854getSavingSummary$lambda0 = SavingEntityRepository.m1854getSavingSummary$lambda0((UserSavingSummaryConsultResult) obj);
                return m1854getSavingSummary$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return authenticatedRequest((Observable) map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getSavingSummary$lambda-0  reason: not valid java name */
    public static final SavingSummary m1854getSavingSummary$lambda0(UserSavingSummaryConsultResult userSavingSummaryConsultResult) {
        Intrinsics.checkNotNullParameter(userSavingSummaryConsultResult, "");
        return UserSavingSummaryConsultResultKt.toSavingSummary(userSavingSummaryConsultResult);
    }

    @Override // id.dana.domain.saving.SavingRepository
    public final Observable<SavingDetail> getSavingDetail(String savingId, long topUpViewsPage, long topUpViewsSize) {
        Intrinsics.checkNotNullParameter(savingId, "");
        ObservableSource map = getSavingEntityData().getSavingDetail(savingId, topUpViewsPage, topUpViewsSize).map(new Function() { // from class: id.dana.data.saving.repository.SavingEntityRepository$$ExternalSyntheticLambda10
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SavingDetail m1851getSavingDetail$lambda1;
                m1851getSavingDetail$lambda1 = SavingEntityRepository.m1851getSavingDetail$lambda1((SavingDetailResult) obj);
                return m1851getSavingDetail$lambda1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return authenticatedRequest((Observable) map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getSavingDetail$lambda-1  reason: not valid java name */
    public static final SavingDetail m1851getSavingDetail$lambda1(SavingDetailResult savingDetailResult) {
        Intrinsics.checkNotNullParameter(savingDetailResult, "");
        return SavingDetailMapperKt.toSavingDetail(savingDetailResult);
    }

    @Override // id.dana.domain.saving.SavingRepository
    public final Observable<SavingCreateInit> initSavingCreate() {
        ObservableSource map = getSavingEntityData().initSavingCreate().map(new Function() { // from class: id.dana.data.saving.repository.SavingEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SavingCreateInit m1856initSavingCreate$lambda2;
                m1856initSavingCreate$lambda2 = SavingEntityRepository.m1856initSavingCreate$lambda2((GoalCreateInitResult) obj);
                return m1856initSavingCreate$lambda2;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return authenticatedRequest((Observable) map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initSavingCreate$lambda-2  reason: not valid java name */
    public static final SavingCreateInit m1856initSavingCreate$lambda2(GoalCreateInitResult goalCreateInitResult) {
        Intrinsics.checkNotNullParameter(goalCreateInitResult, "");
        return GoalCreateInitResultKt.toSavingCreateInit(goalCreateInitResult);
    }

    @Override // id.dana.domain.saving.SavingRepository
    public final Observable<SavingGoalView> createSaving(String categoryCode, String title, String targetAmount) {
        Intrinsics.checkNotNullParameter(categoryCode, "");
        Intrinsics.checkNotNullParameter(title, "");
        Intrinsics.checkNotNullParameter(targetAmount, "");
        SavingEntityData savingEntityData = getSavingEntityData();
        String deviceUUID = this.deviceInformationProvider.getDeviceUUID();
        Intrinsics.checkNotNullExpressionValue(deviceUUID, "");
        ObservableSource map = savingEntityData.createSaving(deviceUUID, categoryCode, title, targetAmount).map(new Function() { // from class: id.dana.data.saving.repository.SavingEntityRepository$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SavingGoalView m1850createSaving$lambda3;
                m1850createSaving$lambda3 = SavingEntityRepository.m1850createSaving$lambda3((GoalCreateSubmitResult) obj);
                return m1850createSaving$lambda3;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return authenticatedRequest((Observable) map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: createSaving$lambda-3  reason: not valid java name */
    public static final SavingGoalView m1850createSaving$lambda3(GoalCreateSubmitResult goalCreateSubmitResult) {
        Intrinsics.checkNotNullParameter(goalCreateSubmitResult, "");
        return SavingViewKt.toSavingGoalView(goalCreateSubmitResult.getSavingView());
    }

    @Override // id.dana.domain.saving.SavingRepository
    public final Observable<SavingUpdateInit> initSavingUpdate(String savingId) {
        Intrinsics.checkNotNullParameter(savingId, "");
        ObservableSource map = getSavingEntityData().initSavingUpdate(savingId).map(new Function() { // from class: id.dana.data.saving.repository.SavingEntityRepository$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SavingUpdateInit m1858initSavingUpdate$lambda4;
                m1858initSavingUpdate$lambda4 = SavingEntityRepository.m1858initSavingUpdate$lambda4((GoalUpdateInitResult) obj);
                return m1858initSavingUpdate$lambda4;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return authenticatedRequest((Observable) map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initSavingUpdate$lambda-4  reason: not valid java name */
    public static final SavingUpdateInit m1858initSavingUpdate$lambda4(GoalUpdateInitResult goalUpdateInitResult) {
        Intrinsics.checkNotNullParameter(goalUpdateInitResult, "");
        return SavingUpdateInitMapperKt.toSavingUpdateInit(goalUpdateInitResult);
    }

    @Override // id.dana.domain.saving.SavingRepository
    public final Observable<SavingGoalView> updateSaving(String savingId, String categoryCode, String title, String targetAmount) {
        Intrinsics.checkNotNullParameter(savingId, "");
        Intrinsics.checkNotNullParameter(categoryCode, "");
        Intrinsics.checkNotNullParameter(title, "");
        Intrinsics.checkNotNullParameter(targetAmount, "");
        ObservableSource map = getSavingEntityData().updateSaving(savingId, categoryCode, title, targetAmount).map(new Function() { // from class: id.dana.data.saving.repository.SavingEntityRepository$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SavingGoalView m1862updateSaving$lambda5;
                m1862updateSaving$lambda5 = SavingEntityRepository.m1862updateSaving$lambda5((GoalUpdateSubmitResult) obj);
                return m1862updateSaving$lambda5;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return authenticatedRequest((Observable) map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateSaving$lambda-5  reason: not valid java name */
    public static final SavingGoalView m1862updateSaving$lambda5(GoalUpdateSubmitResult goalUpdateSubmitResult) {
        Intrinsics.checkNotNullParameter(goalUpdateSubmitResult, "");
        return SavingViewKt.toSavingGoalView(goalUpdateSubmitResult.getSavingView());
    }

    @Override // id.dana.domain.saving.SavingRepository
    public final Observable<Boolean> revokeSaving(String savingId) {
        Intrinsics.checkNotNullParameter(savingId, "");
        ObservableSource map = getSavingEntityData().revokeSaving(savingId).map(new Function() { // from class: id.dana.data.saving.repository.SavingEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Boolean m1860revokeSaving$lambda6;
                m1860revokeSaving$lambda6 = SavingEntityRepository.m1860revokeSaving$lambda6((GoalRevokeResult) obj);
                return m1860revokeSaving$lambda6;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return authenticatedRequest((Observable) map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: revokeSaving$lambda-6  reason: not valid java name */
    public static final Boolean m1860revokeSaving$lambda6(GoalRevokeResult goalRevokeResult) {
        Intrinsics.checkNotNullParameter(goalRevokeResult, "");
        return Boolean.valueOf(goalRevokeResult.getNeedWithdraw());
    }

    @Override // id.dana.domain.saving.SavingRepository
    public final Observable<SavingTopUpInit> initSavingTopUp(String savingId) {
        Intrinsics.checkNotNullParameter(savingId, "");
        ObservableSource map = getSavingEntityData().initSavingTopUp(savingId).map(new Function() { // from class: id.dana.data.saving.repository.SavingEntityRepository$$ExternalSyntheticLambda9
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SavingTopUpInit m1857initSavingTopUp$lambda7;
                m1857initSavingTopUp$lambda7 = SavingEntityRepository.m1857initSavingTopUp$lambda7((GoalTopUpInitResult) obj);
                return m1857initSavingTopUp$lambda7;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return authenticatedRequest((Observable) map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initSavingTopUp$lambda-7  reason: not valid java name */
    public static final SavingTopUpInit m1857initSavingTopUp$lambda7(GoalTopUpInitResult goalTopUpInitResult) {
        Intrinsics.checkNotNullParameter(goalTopUpInitResult, "");
        return SavingTopUpInitMapperKt.toSavingTopUpInit(goalTopUpInitResult);
    }

    @Override // id.dana.domain.saving.SavingRepository
    public final Observable<String> topUpSaving(String savingId, String fundAmount) {
        Intrinsics.checkNotNullParameter(savingId, "");
        Intrinsics.checkNotNullParameter(fundAmount, "");
        SavingEntityData savingEntityData = getSavingEntityData();
        String deviceUUID = this.deviceInformationProvider.getDeviceUUID();
        Intrinsics.checkNotNullExpressionValue(deviceUUID, "");
        ObservableSource map = savingEntityData.topUpSaving(savingId, fundAmount, deviceUUID).map(new Function() { // from class: id.dana.data.saving.repository.SavingEntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                String m1861topUpSaving$lambda8;
                m1861topUpSaving$lambda8 = SavingEntityRepository.m1861topUpSaving$lambda8((SavingTopUpSubmitResult) obj);
                return m1861topUpSaving$lambda8;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return authenticatedRequest((Observable) map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: topUpSaving$lambda-8  reason: not valid java name */
    public static final String m1861topUpSaving$lambda8(SavingTopUpSubmitResult savingTopUpSubmitResult) {
        Intrinsics.checkNotNullParameter(savingTopUpSubmitResult, "");
        return savingTopUpSubmitResult.getCheckoutUrl();
    }

    @Override // id.dana.domain.saving.SavingRepository
    public final Observable<List<String>> getWithdrawOption() {
        Observable flatMap = getSavingWithdrawNetworkEntityData().getWithdrawOption().flatMap(new Function() { // from class: id.dana.data.saving.repository.SavingEntityRepository$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m1855getWithdrawOption$lambda9;
                m1855getWithdrawOption$lambda9 = SavingEntityRepository.m1855getWithdrawOption$lambda9(SavingEntityRepository.this, (List) obj);
                return m1855getWithdrawOption$lambda9;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getWithdrawOption$lambda-9  reason: not valid java name */
    public static final ObservableSource m1855getWithdrawOption$lambda9(SavingEntityRepository savingEntityRepository, List list) {
        Intrinsics.checkNotNullParameter(savingEntityRepository, "");
        Intrinsics.checkNotNullParameter(list, "");
        return list.isEmpty() ? savingEntityRepository.getSavingWithdrawLocalEntityData().getWithdrawOption() : Observable.just(list);
    }

    @Override // id.dana.domain.saving.SavingRepository
    public final Observable<SavingWithdrawInitResult> initSavingWithdraw(SavingWithdrawInitRequest savingId) {
        Intrinsics.checkNotNullParameter(savingId, "");
        Observable map = getSavingEntityData().initSavingWithdraw(savingId).map(new Function() { // from class: id.dana.data.saving.repository.SavingEntityRepository$$ExternalSyntheticLambda12
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SavingWithdrawInitResult m1859initSavingWithdraw$lambda10;
                m1859initSavingWithdraw$lambda10 = SavingEntityRepository.m1859initSavingWithdraw$lambda10((SavingWithdrawInitEntityResult) obj);
                return m1859initSavingWithdraw$lambda10;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initSavingWithdraw$lambda-10  reason: not valid java name */
    public static final SavingWithdrawInitResult m1859initSavingWithdraw$lambda10(SavingWithdrawInitEntityResult savingWithdrawInitEntityResult) {
        Intrinsics.checkNotNullParameter(savingWithdrawInitEntityResult, "");
        return SavingWithdrawMapperKt.toSavingWithdrawInitResult(savingWithdrawInitEntityResult);
    }

    @Override // id.dana.domain.saving.SavingRepository
    public final Observable<SavingEmptyState> getSavingEmptyState() {
        Observable map = createSavingConfigSplitEntityData().getSavingEmptyState().onErrorResumeNext(createSavingConfigLocalEntityData().getSavingEmptyState()).map(new Function() { // from class: id.dana.data.saving.repository.SavingEntityRepository$$ExternalSyntheticLambda11
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SavingEmptyState m1852getSavingEmptyState$lambda11;
                m1852getSavingEmptyState$lambda11 = SavingEntityRepository.m1852getSavingEmptyState$lambda11((SavingEmptyStateEntity) obj);
                return m1852getSavingEmptyState$lambda11;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getSavingEmptyState$lambda-11  reason: not valid java name */
    public static final SavingEmptyState m1852getSavingEmptyState$lambda11(SavingEmptyStateEntity savingEmptyStateEntity) {
        Intrinsics.checkNotNullParameter(savingEmptyStateEntity, "");
        return SavingEmptyStateMapperKt.toSavingEmptyState(savingEmptyStateEntity);
    }

    @Override // id.dana.domain.saving.SavingRepository
    public final Observable<SavingLimit> getSavingLimit() {
        Observable map = createSavingConfigSplitEntityData().getSavingLimit().onErrorResumeNext(createSavingConfigLocalEntityData().getSavingLimit()).map(new Function() { // from class: id.dana.data.saving.repository.SavingEntityRepository$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SavingLimit m1853getSavingLimit$lambda12;
                m1853getSavingLimit$lambda12 = SavingEntityRepository.m1853getSavingLimit$lambda12((SavingLimitEntity) obj);
                return m1853getSavingLimit$lambda12;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getSavingLimit$lambda-12  reason: not valid java name */
    public static final SavingLimit m1853getSavingLimit$lambda12(SavingLimitEntity savingLimitEntity) {
        Intrinsics.checkNotNullParameter(savingLimitEntity, "");
        return SavingLimitMapperKt.toSavingLimit(savingLimitEntity);
    }

    private final SavingConfigEntityData createSavingConfigSplitEntityData() {
        return this.savingConfigEntityDataFactory.createData2("split");
    }

    private final SavingConfigEntityData createSavingConfigLocalEntityData() {
        return this.savingConfigEntityDataFactory.createData2("local");
    }
}
