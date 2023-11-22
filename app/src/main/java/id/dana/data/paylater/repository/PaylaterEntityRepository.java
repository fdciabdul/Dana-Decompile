package id.dana.data.paylater.repository;

import id.dana.data.account.repository.source.AccountEntityData;
import id.dana.data.account.repository.source.AccountEntityDataFactory;
import id.dana.data.errorconfig.ErrorConfigEntityData;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.holdlogin.v1.HoldLoginV1Repository;
import id.dana.data.login.source.LoginEntityData;
import id.dana.data.paylater.mapper.PayLaterResultMapper;
import id.dana.data.paylater.repository.mapper.PaylaterCicilMethodConfigResultMapperKt;
import id.dana.data.paylater.repository.source.network.result.LoanWhitelistResult;
import id.dana.data.paylater.repository.source.network.result.PaylaterCicilMethodConfigResult;
import id.dana.domain.paylater.PaylaterRepository;
import id.dana.domain.paylater.model.LoanStatusWhitelist;
import id.dana.domain.paylater.model.LoanWhitelist;
import id.dana.domain.paylater.model.PaylaterCicilMethodConfig;
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
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B)\b\u0007\u0012\u0006\u0010L\u001a\u00020K\u0012\u0006\u0010I\u001a\u00020H\u0012\u0006\u0010:\u001a\u000209\u0012\u0006\u0010F\u001a\u00020E¢\u0006\u0004\bQ\u0010RJ*\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0096\u0001¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0096\u0001¢\u0006\u0004\b\u0006\u0010\nJ\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eH\u0096\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0010J\u0010\u0010\u0013\u001a\u00020\u0012H\u0096\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0012H\u0096\u0001¢\u0006\u0004\b\u0015\u0010\u0014J\u0010\u0010\u0017\u001a\u00020\u0016H\u0096\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00042\u0006\u0010\u0019\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0004H\u0016¢\u0006\u0004\b\u001d\u0010\rJ\u001b\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e0\u0004H\u0016¢\u0006\u0004\b \u0010\rJ\u0015\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u0004H\u0016¢\u0006\u0004\b\"\u0010\rJ\u0015\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u0004H\u0016¢\u0006\u0004\b$\u0010\rJ\u0015\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\u0004H\u0002¢\u0006\u0004\b&\u0010\rJ\u0015\u0010'\u001a\b\u0012\u0004\u0012\u00020%0\u0004H\u0002¢\u0006\u0004\b'\u0010\rJ\u0015\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004H\u0016¢\u0006\u0004\b(\u0010\rJ\u001d\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00042\u0006\u0010)\u001a\u00020\u001aH\u0016¢\u0006\u0004\b*\u0010+J#\u0010-\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00042\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0016¢\u0006\u0004\b-\u0010.J\u001d\u00100\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00042\u0006\u0010/\u001a\u00020#H\u0016¢\u0006\u0004\b0\u00101J%\u00104\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00042\u0006\u00102\u001a\u00020%2\u0006\u00103\u001a\u00020%H\u0016¢\u0006\u0004\b4\u00105J\u001d\u00107\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00042\u0006\u00106\u001a\u00020%H\u0016¢\u0006\u0004\b7\u00108R\u0014\u0010:\u001a\u0002098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u001b\u0010A\u001a\u00020<8CX\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\u001b\u0010D\u001a\u00020<8CX\u0083\u0084\u0002¢\u0006\f\n\u0004\bB\u0010>\u001a\u0004\bC\u0010@R\u0014\u0010F\u001a\u00020E8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010I\u001a\u00020H8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0014\u0010L\u001a\u00020K8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\u001b\u0010P\u001a\u00020<8CX\u0083\u0084\u0002¢\u0006\f\n\u0004\bN\u0010>\u001a\u0004\bO\u0010@"}, d2 = {"Lid/dana/data/paylater/repository/PaylaterEntityRepository;", "Lid/dana/domain/paylater/PaylaterRepository;", "Lid/dana/data/holdlogin/v1/HoldLoginV1Repository;", "T", "Lio/reactivex/Observable;", "observable", "authenticatedRequest", "(Lio/reactivex/Observable;)Lio/reactivex/Observable;", "Lkotlinx/coroutines/flow/Flow;", "flow", "(Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/Flow;", "", "clearCachePayLaterLoanWhitelist", "()Lio/reactivex/Observable;", "Lid/dana/data/account/repository/source/AccountEntityData;", "createAccountData", "()Lid/dana/data/account/repository/source/AccountEntityData;", "createAccountLocalEntityData", "Lid/dana/data/errorconfig/ErrorConfigEntityData;", "createLocalErrorConfigData", "()Lid/dana/data/errorconfig/ErrorConfigEntityData;", "createNetworkErrorConfigData", "Lid/dana/data/login/source/LoginEntityData;", "createNetworkLogin", "()Lid/dana/data/login/source/LoginEntityData;", "withBill", "Lid/dana/domain/paylater/model/LoanWhitelist;", "getLoanConsultWhitelist", "(Z)Lio/reactivex/Observable;", "getPayLaterCacheWhitelistValue", "", "Lid/dana/domain/paylater/model/LoanStatusWhitelist;", "getPayLaterLoanStatus", "Lid/dana/domain/paylater/model/PaylaterCicilMethodConfig;", "getPaylaterCicilConfig", "", "getPaylaterRotationDelayTime", "", "getPhoneNumber", "getUserId", "resetPayLaterCacheLoanWhitelist", "loanWhitelist", "savePayLaterCacheWhitelistValue", "(Lid/dana/domain/paylater/model/LoanWhitelist;)Lio/reactivex/Observable;", "loanStatus", "savePayLaterLoanStatus", "(Ljava/util/List;)Lio/reactivex/Observable;", "rotationDelayTime", "savePaylaterRotationDelayTime", "(J)Lio/reactivex/Observable;", "type", "state", "setLoanServicesState", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "paylaterChannel", "setPaylaterChannel", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/data/account/repository/source/AccountEntityDataFactory;", "accountEntityDataFactory", "Lid/dana/data/account/repository/source/AccountEntityDataFactory;", "Lid/dana/data/paylater/repository/PaylaterEntityData;", "createLocalPaylaterEntityData$delegate", "Lkotlin/Lazy;", "getCreateLocalPaylaterEntityData", "()Lid/dana/data/paylater/repository/PaylaterEntityData;", "createLocalPaylaterEntityData", "createPaylaterEntityData$delegate", "getCreatePaylaterEntityData", "createPaylaterEntityData", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "holdLoginV1EntityRepository", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "Lid/dana/data/paylater/mapper/PayLaterResultMapper;", "payLaterResultMapper", "Lid/dana/data/paylater/mapper/PayLaterResultMapper;", "Lid/dana/data/paylater/repository/PaylaterEntityDataFactory;", "paylaterEntityDataFactory", "Lid/dana/data/paylater/repository/PaylaterEntityDataFactory;", "splitPaylaterEntitydata$delegate", "getSplitPaylaterEntitydata", "splitPaylaterEntitydata", "<init>", "(Lid/dana/data/paylater/repository/PaylaterEntityDataFactory;Lid/dana/data/paylater/mapper/PayLaterResultMapper;Lid/dana/data/account/repository/source/AccountEntityDataFactory;Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PaylaterEntityRepository implements PaylaterRepository, HoldLoginV1Repository {
    private final AccountEntityDataFactory accountEntityDataFactory;

    /* renamed from: createLocalPaylaterEntityData$delegate  reason: from kotlin metadata */
    private final Lazy createLocalPaylaterEntityData;

    /* renamed from: createPaylaterEntityData$delegate  reason: from kotlin metadata */
    private final Lazy createPaylaterEntityData;
    private final HoldLoginV1EntityRepository holdLoginV1EntityRepository;
    private final PayLaterResultMapper payLaterResultMapper;
    private final PaylaterEntityDataFactory paylaterEntityDataFactory;

    /* renamed from: splitPaylaterEntitydata$delegate  reason: from kotlin metadata */
    private final Lazy splitPaylaterEntitydata;

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
    public PaylaterEntityRepository(PaylaterEntityDataFactory paylaterEntityDataFactory, PayLaterResultMapper payLaterResultMapper, AccountEntityDataFactory accountEntityDataFactory, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        Intrinsics.checkNotNullParameter(paylaterEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(payLaterResultMapper, "");
        Intrinsics.checkNotNullParameter(accountEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(holdLoginV1EntityRepository, "");
        this.paylaterEntityDataFactory = paylaterEntityDataFactory;
        this.payLaterResultMapper = payLaterResultMapper;
        this.accountEntityDataFactory = accountEntityDataFactory;
        this.holdLoginV1EntityRepository = holdLoginV1EntityRepository;
        this.splitPaylaterEntitydata = LazyKt.lazy(new Function0<PaylaterEntityData>() { // from class: id.dana.data.paylater.repository.PaylaterEntityRepository$splitPaylaterEntitydata$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PaylaterEntityData invoke() {
                PaylaterEntityDataFactory paylaterEntityDataFactory2;
                paylaterEntityDataFactory2 = PaylaterEntityRepository.this.paylaterEntityDataFactory;
                return paylaterEntityDataFactory2.createData2("split");
            }
        });
        this.createPaylaterEntityData = LazyKt.lazy(new Function0<PaylaterEntityData>() { // from class: id.dana.data.paylater.repository.PaylaterEntityRepository$createPaylaterEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PaylaterEntityData invoke() {
                PaylaterEntityDataFactory paylaterEntityDataFactory2;
                paylaterEntityDataFactory2 = PaylaterEntityRepository.this.paylaterEntityDataFactory;
                return paylaterEntityDataFactory2.createData2("network");
            }
        });
        this.createLocalPaylaterEntityData = LazyKt.lazy(new Function0<PaylaterEntityData>() { // from class: id.dana.data.paylater.repository.PaylaterEntityRepository$createLocalPaylaterEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PaylaterEntityData invoke() {
                PaylaterEntityDataFactory paylaterEntityDataFactory2;
                paylaterEntityDataFactory2 = PaylaterEntityRepository.this.paylaterEntityDataFactory;
                return paylaterEntityDataFactory2.createData2("local");
            }
        });
    }

    @JvmName(name = "getSplitPaylaterEntitydata")
    private final PaylaterEntityData getSplitPaylaterEntitydata() {
        return (PaylaterEntityData) this.splitPaylaterEntitydata.getValue();
    }

    @JvmName(name = "getCreatePaylaterEntityData")
    private final PaylaterEntityData getCreatePaylaterEntityData() {
        return (PaylaterEntityData) this.createPaylaterEntityData.getValue();
    }

    @JvmName(name = "getCreateLocalPaylaterEntityData")
    private final PaylaterEntityData getCreateLocalPaylaterEntityData() {
        return (PaylaterEntityData) this.createLocalPaylaterEntityData.getValue();
    }

    @Override // id.dana.domain.paylater.PaylaterRepository
    public final Observable<PaylaterCicilMethodConfig> getPaylaterCicilConfig() {
        Observable map = getSplitPaylaterEntitydata().getPaylaterCicilMethodConfig().map(new Function() { // from class: id.dana.data.paylater.repository.PaylaterEntityRepository$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                PaylaterCicilMethodConfig m1569getPaylaterCicilConfig$lambda0;
                m1569getPaylaterCicilConfig$lambda0 = PaylaterEntityRepository.m1569getPaylaterCicilConfig$lambda0((PaylaterCicilMethodConfigResult) obj);
                return m1569getPaylaterCicilConfig$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getPaylaterCicilConfig$lambda-0  reason: not valid java name */
    public static final PaylaterCicilMethodConfig m1569getPaylaterCicilConfig$lambda0(PaylaterCicilMethodConfigResult paylaterCicilMethodConfigResult) {
        Intrinsics.checkNotNullParameter(paylaterCicilMethodConfigResult, "");
        return PaylaterCicilMethodConfigResultMapperKt.toPaylaterMethodConfig(paylaterCicilMethodConfigResult);
    }

    @Override // id.dana.domain.paylater.PaylaterRepository
    public final Observable<Boolean> setPaylaterChannel(String paylaterChannel) {
        Intrinsics.checkNotNullParameter(paylaterChannel, "");
        return getSplitPaylaterEntitydata().setPaylaterChannel(paylaterChannel);
    }

    @Override // id.dana.domain.paylater.PaylaterRepository
    public final Observable<LoanWhitelist> getLoanConsultWhitelist(final boolean withBill) {
        Observable flatMap = getUserId().flatMap(new Function() { // from class: id.dana.data.paylater.repository.PaylaterEntityRepository$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m1566getLoanConsultWhitelist$lambda1;
                m1566getLoanConsultWhitelist$lambda1 = PaylaterEntityRepository.m1566getLoanConsultWhitelist$lambda1(PaylaterEntityRepository.this, withBill, (String) obj);
                return m1566getLoanConsultWhitelist$lambda1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getLoanConsultWhitelist$lambda-1  reason: not valid java name */
    public static final ObservableSource m1566getLoanConsultWhitelist$lambda1(PaylaterEntityRepository paylaterEntityRepository, boolean z, String str) {
        Intrinsics.checkNotNullParameter(paylaterEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        HoldLoginV1EntityRepository holdLoginV1EntityRepository = paylaterEntityRepository.holdLoginV1EntityRepository;
        Observable<LoanWhitelistResult> loanConsultWhitelist = paylaterEntityRepository.getCreatePaylaterEntityData().getLoanConsultWhitelist(str, z);
        final PayLaterResultMapper payLaterResultMapper = paylaterEntityRepository.payLaterResultMapper;
        return holdLoginV1EntityRepository.authenticatedRequest(loanConsultWhitelist.map(new Function() { // from class: id.dana.data.paylater.repository.PaylaterEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return PayLaterResultMapper.this.transform((LoanWhitelistResult) obj);
            }
        }));
    }

    @Override // id.dana.domain.paylater.PaylaterRepository
    public final Observable<Boolean> setLoanServicesState(String type, String state) {
        Intrinsics.checkNotNullParameter(type, "");
        Intrinsics.checkNotNullParameter(state, "");
        return getSplitPaylaterEntitydata().setLoanServicesState(type, state);
    }

    @Override // id.dana.domain.paylater.PaylaterRepository
    public final Observable<Boolean> savePayLaterCacheWhitelistValue(final LoanWhitelist loanWhitelist) {
        Intrinsics.checkNotNullParameter(loanWhitelist, "");
        Observable flatMap = getPhoneNumber().flatMap(new Function() { // from class: id.dana.data.paylater.repository.PaylaterEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m1574savePayLaterCacheWhitelistValue$lambda2;
                m1574savePayLaterCacheWhitelistValue$lambda2 = PaylaterEntityRepository.m1574savePayLaterCacheWhitelistValue$lambda2(PaylaterEntityRepository.this, loanWhitelist, (String) obj);
                return m1574savePayLaterCacheWhitelistValue$lambda2;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: savePayLaterCacheWhitelistValue$lambda-2  reason: not valid java name */
    public static final ObservableSource m1574savePayLaterCacheWhitelistValue$lambda2(PaylaterEntityRepository paylaterEntityRepository, LoanWhitelist loanWhitelist, String str) {
        Intrinsics.checkNotNullParameter(paylaterEntityRepository, "");
        Intrinsics.checkNotNullParameter(loanWhitelist, "");
        Intrinsics.checkNotNullParameter(str, "");
        return paylaterEntityRepository.getCreateLocalPaylaterEntityData().savePayLaterCacheWhitelistValue(str, loanWhitelist);
    }

    @Override // id.dana.domain.paylater.PaylaterRepository
    public final Observable<LoanWhitelist> getPayLaterCacheWhitelistValue() {
        Observable flatMap = getPhoneNumber().flatMap(new Function() { // from class: id.dana.data.paylater.repository.PaylaterEntityRepository$$ExternalSyntheticLambda9
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m1567getPayLaterCacheWhitelistValue$lambda3;
                m1567getPayLaterCacheWhitelistValue$lambda3 = PaylaterEntityRepository.m1567getPayLaterCacheWhitelistValue$lambda3(PaylaterEntityRepository.this, (String) obj);
                return m1567getPayLaterCacheWhitelistValue$lambda3;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getPayLaterCacheWhitelistValue$lambda-3  reason: not valid java name */
    public static final ObservableSource m1567getPayLaterCacheWhitelistValue$lambda3(PaylaterEntityRepository paylaterEntityRepository, String str) {
        Intrinsics.checkNotNullParameter(paylaterEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        return paylaterEntityRepository.getCreateLocalPaylaterEntityData().getPayLaterCacheWhitelistValue(str);
    }

    @Override // id.dana.domain.paylater.PaylaterRepository
    public final Observable<Boolean> resetPayLaterCacheLoanWhitelist() {
        Observable<Boolean> flatMap = getPhoneNumber().flatMap(new Function() { // from class: id.dana.data.paylater.repository.PaylaterEntityRepository$$ExternalSyntheticLambda10
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m1571resetPayLaterCacheLoanWhitelist$lambda5;
                m1571resetPayLaterCacheLoanWhitelist$lambda5 = PaylaterEntityRepository.m1571resetPayLaterCacheLoanWhitelist$lambda5(PaylaterEntityRepository.this, (String) obj);
                return m1571resetPayLaterCacheLoanWhitelist$lambda5;
            }
        }).flatMap(new Function() { // from class: id.dana.data.paylater.repository.PaylaterEntityRepository$$ExternalSyntheticLambda11
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m1573resetPayLaterCacheLoanWhitelist$lambda6;
                m1573resetPayLaterCacheLoanWhitelist$lambda6 = PaylaterEntityRepository.m1573resetPayLaterCacheLoanWhitelist$lambda6(PaylaterEntityRepository.this, (Boolean) obj);
                return m1573resetPayLaterCacheLoanWhitelist$lambda6;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: resetPayLaterCacheLoanWhitelist$lambda-5  reason: not valid java name */
    public static final ObservableSource m1571resetPayLaterCacheLoanWhitelist$lambda5(final PaylaterEntityRepository paylaterEntityRepository, String str) {
        Intrinsics.checkNotNullParameter(paylaterEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        return paylaterEntityRepository.getCreateLocalPaylaterEntityData().getPayLaterCacheWhitelistValue(str).flatMap(new Function() { // from class: id.dana.data.paylater.repository.PaylaterEntityRepository$$ExternalSyntheticLambda12
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m1572resetPayLaterCacheLoanWhitelist$lambda5$lambda4;
                m1572resetPayLaterCacheLoanWhitelist$lambda5$lambda4 = PaylaterEntityRepository.m1572resetPayLaterCacheLoanWhitelist$lambda5$lambda4(PaylaterEntityRepository.this, (LoanWhitelist) obj);
                return m1572resetPayLaterCacheLoanWhitelist$lambda5$lambda4;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: resetPayLaterCacheLoanWhitelist$lambda-5$lambda-4  reason: not valid java name */
    public static final ObservableSource m1572resetPayLaterCacheLoanWhitelist$lambda5$lambda4(PaylaterEntityRepository paylaterEntityRepository, LoanWhitelist loanWhitelist) {
        Intrinsics.checkNotNullParameter(paylaterEntityRepository, "");
        Intrinsics.checkNotNullParameter(loanWhitelist, "");
        return paylaterEntityRepository.getSplitPaylaterEntitydata().setOffLoanServicesState(loanWhitelist);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: resetPayLaterCacheLoanWhitelist$lambda-6  reason: not valid java name */
    public static final ObservableSource m1573resetPayLaterCacheLoanWhitelist$lambda6(PaylaterEntityRepository paylaterEntityRepository, Boolean bool) {
        Intrinsics.checkNotNullParameter(paylaterEntityRepository, "");
        Intrinsics.checkNotNullParameter(bool, "");
        return paylaterEntityRepository.getCreateLocalPaylaterEntityData().resetPayLaterCacheLoanWhitelist();
    }

    @Override // id.dana.domain.paylater.PaylaterRepository
    public final Observable<Boolean> clearCachePayLaterLoanWhitelist() {
        Observable flatMap = getPhoneNumber().flatMap(new Function() { // from class: id.dana.data.paylater.repository.PaylaterEntityRepository$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m1565clearCachePayLaterLoanWhitelist$lambda7;
                m1565clearCachePayLaterLoanWhitelist$lambda7 = PaylaterEntityRepository.m1565clearCachePayLaterLoanWhitelist$lambda7(PaylaterEntityRepository.this, (String) obj);
                return m1565clearCachePayLaterLoanWhitelist$lambda7;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: clearCachePayLaterLoanWhitelist$lambda-7  reason: not valid java name */
    public static final ObservableSource m1565clearCachePayLaterLoanWhitelist$lambda7(PaylaterEntityRepository paylaterEntityRepository, String str) {
        Intrinsics.checkNotNullParameter(paylaterEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        return paylaterEntityRepository.getCreateLocalPaylaterEntityData().clearCacheLoanWhitelist(str);
    }

    @Override // id.dana.domain.paylater.PaylaterRepository
    public final Observable<Boolean> savePayLaterLoanStatus(final List<LoanStatusWhitelist> loanStatus) {
        Intrinsics.checkNotNullParameter(loanStatus, "");
        Observable flatMap = getPhoneNumber().flatMap(new Function() { // from class: id.dana.data.paylater.repository.PaylaterEntityRepository$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m1575savePayLaterLoanStatus$lambda8;
                m1575savePayLaterLoanStatus$lambda8 = PaylaterEntityRepository.m1575savePayLaterLoanStatus$lambda8(PaylaterEntityRepository.this, loanStatus, (String) obj);
                return m1575savePayLaterLoanStatus$lambda8;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: savePayLaterLoanStatus$lambda-8  reason: not valid java name */
    public static final ObservableSource m1575savePayLaterLoanStatus$lambda8(PaylaterEntityRepository paylaterEntityRepository, List list, String str) {
        Intrinsics.checkNotNullParameter(paylaterEntityRepository, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(str, "");
        return paylaterEntityRepository.getCreateLocalPaylaterEntityData().savePayLaterLoanStatus(list, str);
    }

    @Override // id.dana.domain.paylater.PaylaterRepository
    public final Observable<List<LoanStatusWhitelist>> getPayLaterLoanStatus() {
        Observable flatMap = getPhoneNumber().flatMap(new Function() { // from class: id.dana.data.paylater.repository.PaylaterEntityRepository$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m1568getPayLaterLoanStatus$lambda9;
                m1568getPayLaterLoanStatus$lambda9 = PaylaterEntityRepository.m1568getPayLaterLoanStatus$lambda9(PaylaterEntityRepository.this, (String) obj);
                return m1568getPayLaterLoanStatus$lambda9;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getPayLaterLoanStatus$lambda-9  reason: not valid java name */
    public static final ObservableSource m1568getPayLaterLoanStatus$lambda9(PaylaterEntityRepository paylaterEntityRepository, String str) {
        Intrinsics.checkNotNullParameter(paylaterEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        return paylaterEntityRepository.getCreateLocalPaylaterEntityData().getPayLaterLoanStatus(str);
    }

    @Override // id.dana.domain.paylater.PaylaterRepository
    public final Observable<Boolean> savePaylaterRotationDelayTime(final long rotationDelayTime) {
        Observable flatMap = getPhoneNumber().flatMap(new Function() { // from class: id.dana.data.paylater.repository.PaylaterEntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m1576savePaylaterRotationDelayTime$lambda10;
                m1576savePaylaterRotationDelayTime$lambda10 = PaylaterEntityRepository.m1576savePaylaterRotationDelayTime$lambda10(PaylaterEntityRepository.this, rotationDelayTime, (String) obj);
                return m1576savePaylaterRotationDelayTime$lambda10;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: savePaylaterRotationDelayTime$lambda-10  reason: not valid java name */
    public static final ObservableSource m1576savePaylaterRotationDelayTime$lambda10(PaylaterEntityRepository paylaterEntityRepository, long j, String str) {
        Intrinsics.checkNotNullParameter(paylaterEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        return paylaterEntityRepository.getCreateLocalPaylaterEntityData().savePaylaterRotationDelayTime(str, j);
    }

    @Override // id.dana.domain.paylater.PaylaterRepository
    public final Observable<Long> getPaylaterRotationDelayTime() {
        Observable flatMap = getPhoneNumber().flatMap(new Function() { // from class: id.dana.data.paylater.repository.PaylaterEntityRepository$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m1570getPaylaterRotationDelayTime$lambda11;
                m1570getPaylaterRotationDelayTime$lambda11 = PaylaterEntityRepository.m1570getPaylaterRotationDelayTime$lambda11(PaylaterEntityRepository.this, (String) obj);
                return m1570getPaylaterRotationDelayTime$lambda11;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getPaylaterRotationDelayTime$lambda-11  reason: not valid java name */
    public static final ObservableSource m1570getPaylaterRotationDelayTime$lambda11(PaylaterEntityRepository paylaterEntityRepository, String str) {
        Intrinsics.checkNotNullParameter(paylaterEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        return paylaterEntityRepository.getCreateLocalPaylaterEntityData().getPaylaterRotationDelayTime(str);
    }

    private final Observable<String> getPhoneNumber() {
        Observable<String> phoneNumber = createAccountLocalEntityData().getPhoneNumber();
        Intrinsics.checkNotNullExpressionValue(phoneNumber, "");
        return phoneNumber;
    }

    private final Observable<String> getUserId() {
        Observable<String> userId = createAccountLocalEntityData().getUserId();
        Intrinsics.checkNotNullExpressionValue(userId, "");
        return userId;
    }

    private final AccountEntityData createAccountLocalEntityData() {
        AccountEntityData createData2 = this.accountEntityDataFactory.createData2("local");
        Intrinsics.checkNotNullExpressionValue(createData2, "");
        return createData2;
    }
}
