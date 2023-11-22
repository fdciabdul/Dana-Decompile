package id.dana.biometric.data;

import id.dana.biometric.data.mapper.RiskTrackerConfigEntityMapperKt;
import id.dana.biometric.data.mapper.ScoringDeviceEntityMapperKt;
import id.dana.biometric.data.source.RiskTrackerConfigEntityData;
import id.dana.biometric.data.source.RiskTrackerConfigEntityDataFactory;
import id.dana.biometric.data.source.RiskTrackerEntityData;
import id.dana.biometric.data.source.RiskTrackerEntityDataFactory;
import id.dana.biometric.data.source.local.RiskTrackerConfigEntity;
import id.dana.biometric.data.source.local.ScoringDeviceEntity;
import id.dana.biometric.data.source.network.result.InsertDeviceScoringDataResult;
import id.dana.biometric.domain.RiskTrackerRepository;
import id.dana.biometric.domain.model.BiometricDataSize;
import id.dana.biometric.domain.model.RiskTrackerConfig;
import id.dana.biometric.domain.model.ScoringDeviceModel;
import id.dana.biometric.utils.DataSizeUtil;
import id.dana.biometric.utils.EmptyDataException;
import id.dana.data.account.repository.source.AccountEntityData;
import id.dana.data.errorconfig.ErrorConfigEntityData;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.holdlogin.v1.HoldLoginV1Repository;
import id.dana.data.login.source.LoginEntityData;
import id.dana.domain.foundation.logger.PerformanceConstant;
import id.dana.sendmoney.summary.SummaryActivity;
import id.dana.utils.foundation.logger.log.DanaLog;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

@Singleton
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 H2\u00020\u00012\u00020\u0002:\u0001HB!\b\u0007\u0012\u0006\u0010@\u001a\u00020?\u0012\u0006\u0010=\u001a\u00020<\u0012\u0006\u00105\u001a\u000204¢\u0006\u0004\bF\u0010GJ*\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0096\u0001¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0096\u0001¢\u0006\u0004\b\u0006\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013H\u0096\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016H\u0096\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0016H\u0096\u0001¢\u0006\u0004\b\u0019\u0010\u0018J\u0010\u0010\u001b\u001a\u00020\u001aH\u0096\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u00042\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b \u0010!J\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00042\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\"\u0010!J\u0015\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u0004H\u0016¢\u0006\u0004\b$\u0010\u0012J%\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00100\u00042\u0006\u0010%\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b(\u0010)J\u0015\u0010+\u001a\b\u0012\u0004\u0012\u00020*0\u0004H\u0016¢\u0006\u0004\b+\u0010\u0012J5\u00100\u001a\b\u0012\u0004\u0012\u00020/0\u00042\u0006\u0010,\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020-H\u0016¢\u0006\u0004\b0\u00101J5\u00102\u001a\b\u0012\u0004\u0012\u00020/0\u00042\u0006\u0010,\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020-H\u0016¢\u0006\u0004\b2\u00101J5\u00103\u001a\b\u0012\u0004\u0012\u00020\u00100\u00042\u0006\u0010,\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020-H\u0016¢\u0006\u0004\b3\u00101R\u0014\u00105\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u001b\u0010;\u001a\u00020&8CX\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u0014\u0010=\u001a\u00020<8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010@\u001a\u00020?8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010B\u001a\u00020\r8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010D\u001a\u00020\r8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bD\u0010CR\u0016\u0010E\u001a\u00020\r8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bE\u0010C"}, d2 = {"Lid/dana/biometric/data/RiskTrackerEntityRepository;", "Lid/dana/biometric/domain/RiskTrackerRepository;", "Lid/dana/data/holdlogin/v1/HoldLoginV1Repository;", "T", "Lio/reactivex/Observable;", "observable", "authenticatedRequest", "(Lio/reactivex/Observable;)Lio/reactivex/Observable;", "Lkotlinx/coroutines/flow/Flow;", "flow", "(Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/biometric/data/source/local/ScoringDeviceEntity;", "biometricData", "", "calculateDataSizeinKb", "(Lid/dana/biometric/data/source/local/ScoringDeviceEntity;)D", "", "clearData", "()Lio/reactivex/Observable;", "Lid/dana/data/account/repository/source/AccountEntityData;", "createAccountData", "()Lid/dana/data/account/repository/source/AccountEntityData;", "Lid/dana/data/errorconfig/ErrorConfigEntityData;", "createLocalErrorConfigData", "()Lid/dana/data/errorconfig/ErrorConfigEntityData;", "createNetworkErrorConfigData", "Lid/dana/data/login/source/LoginEntityData;", "createNetworkLogin", "()Lid/dana/data/login/source/LoginEntityData;", "", PerformanceConstant.PERFORMANCE_PHASE, "Lid/dana/biometric/domain/model/ScoringDeviceModel;", "getAccelerometerData", "(Ljava/lang/String;)Lio/reactivex/Observable;", "getGyroscopeData", "Lid/dana/biometric/domain/model/RiskTrackerConfig;", "getRiskTrackerConfig", "data", "Lid/dana/biometric/data/source/RiskTrackerEntityData;", "networkRiskTrackerEntityData", "handleNetworkCall", "(Lid/dana/biometric/data/source/local/ScoringDeviceEntity;Lid/dana/biometric/data/source/RiskTrackerEntityData;)Lio/reactivex/Observable;", "Lid/dana/biometric/domain/model/BiometricDataSize;", "onPageEndAndZip", "scheme", "", "timestamp", "", "saveAndGetAccelerometerDataState", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)Lio/reactivex/Observable;", "saveAndGetGyroscopeDataState", "saveKeystrokeDataState", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "holdLoginV1EntityRepository", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "localRiskTrackerEntityData$delegate", "Lkotlin/Lazy;", "getLocalRiskTrackerEntityData", "()Lid/dana/biometric/data/source/RiskTrackerEntityData;", "localRiskTrackerEntityData", "Lid/dana/biometric/data/source/RiskTrackerConfigEntityDataFactory;", "riskTrackerConfigEntityDataFactory", "Lid/dana/biometric/data/source/RiskTrackerConfigEntityDataFactory;", "Lid/dana/biometric/data/source/RiskTrackerEntityDataFactory;", "riskTrackerEntityDataFactory", "Lid/dana/biometric/data/source/RiskTrackerEntityDataFactory;", "sizeAccelerometer", SummaryActivity.DAYS, "sizeGyroscope", "sizeKeystroke", "<init>", "(Lid/dana/biometric/data/source/RiskTrackerEntityDataFactory;Lid/dana/biometric/data/source/RiskTrackerConfigEntityDataFactory;Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RiskTrackerEntityRepository implements RiskTrackerRepository, HoldLoginV1Repository {
    private static final String TAG = "RiskTrackerEntityRepository";
    private final HoldLoginV1EntityRepository holdLoginV1EntityRepository;

    /* renamed from: localRiskTrackerEntityData$delegate  reason: from kotlin metadata */
    private final Lazy localRiskTrackerEntityData;
    private final RiskTrackerConfigEntityDataFactory riskTrackerConfigEntityDataFactory;
    private final RiskTrackerEntityDataFactory riskTrackerEntityDataFactory;
    private double sizeAccelerometer;
    private double sizeGyroscope;
    private double sizeKeystroke;

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
    public RiskTrackerEntityRepository(RiskTrackerEntityDataFactory riskTrackerEntityDataFactory, RiskTrackerConfigEntityDataFactory riskTrackerConfigEntityDataFactory, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        Intrinsics.checkNotNullParameter(riskTrackerEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(riskTrackerConfigEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(holdLoginV1EntityRepository, "");
        this.riskTrackerEntityDataFactory = riskTrackerEntityDataFactory;
        this.riskTrackerConfigEntityDataFactory = riskTrackerConfigEntityDataFactory;
        this.holdLoginV1EntityRepository = holdLoginV1EntityRepository;
        this.localRiskTrackerEntityData = LazyKt.lazy(new Function0<RiskTrackerEntityData>() { // from class: id.dana.biometric.data.RiskTrackerEntityRepository$localRiskTrackerEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RiskTrackerEntityData invoke() {
                RiskTrackerEntityDataFactory riskTrackerEntityDataFactory2;
                riskTrackerEntityDataFactory2 = RiskTrackerEntityRepository.this.riskTrackerEntityDataFactory;
                return riskTrackerEntityDataFactory2.create("local");
            }
        });
    }

    @JvmName(name = "getLocalRiskTrackerEntityData")
    private final RiskTrackerEntityData getLocalRiskTrackerEntityData() {
        return (RiskTrackerEntityData) this.localRiskTrackerEntityData.getValue();
    }

    @Override // id.dana.biometric.domain.RiskTrackerRepository
    public final Observable<Boolean> saveAndGetAccelerometerDataState(String scheme, String phase, String data, long timestamp) {
        Intrinsics.checkNotNullParameter(scheme, "");
        Intrinsics.checkNotNullParameter(phase, "");
        Intrinsics.checkNotNullParameter(data, "");
        return getLocalRiskTrackerEntityData().saveAndGetAccelerometerDataState(scheme, phase, data, timestamp);
    }

    @Override // id.dana.biometric.domain.RiskTrackerRepository
    public final Observable<Boolean> saveAndGetGyroscopeDataState(String scheme, String phase, String data, long timestamp) {
        Intrinsics.checkNotNullParameter(scheme, "");
        Intrinsics.checkNotNullParameter(phase, "");
        Intrinsics.checkNotNullParameter(data, "");
        return getLocalRiskTrackerEntityData().saveAndGetGyroscopeDataState(scheme, phase, data, timestamp);
    }

    @Override // id.dana.biometric.domain.RiskTrackerRepository
    public final Observable<Unit> saveKeystrokeDataState(String scheme, String phase, String data, long timestamp) {
        Intrinsics.checkNotNullParameter(scheme, "");
        Intrinsics.checkNotNullParameter(phase, "");
        Intrinsics.checkNotNullParameter(data, "");
        return getLocalRiskTrackerEntityData().saveKeystrokeDataState(scheme, phase, data, timestamp);
    }

    @Override // id.dana.biometric.domain.RiskTrackerRepository
    public final Observable<ScoringDeviceModel> getAccelerometerData(String phase) {
        Intrinsics.checkNotNullParameter(phase, "");
        Observable map = getLocalRiskTrackerEntityData().getAccelerometerData(phase).map(new Function() { // from class: id.dana.biometric.data.RiskTrackerEntityRepository$$ExternalSyntheticLambda10
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ScoringDeviceModel m447getAccelerometerData$lambda0;
                m447getAccelerometerData$lambda0 = RiskTrackerEntityRepository.m447getAccelerometerData$lambda0((ScoringDeviceEntity) obj);
                return m447getAccelerometerData$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getAccelerometerData$lambda-0  reason: not valid java name */
    public static final ScoringDeviceModel m447getAccelerometerData$lambda0(ScoringDeviceEntity scoringDeviceEntity) {
        Intrinsics.checkNotNullParameter(scoringDeviceEntity, "");
        return ScoringDeviceEntityMapperKt.toScoringDeviceModel(scoringDeviceEntity);
    }

    @Override // id.dana.biometric.domain.RiskTrackerRepository
    public final Observable<ScoringDeviceModel> getGyroscopeData(String phase) {
        Intrinsics.checkNotNullParameter(phase, "");
        Observable map = getLocalRiskTrackerEntityData().getGyroscopeData(phase).map(new Function() { // from class: id.dana.biometric.data.RiskTrackerEntityRepository$$ExternalSyntheticLambda14
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ScoringDeviceModel m448getGyroscopeData$lambda1;
                m448getGyroscopeData$lambda1 = RiskTrackerEntityRepository.m448getGyroscopeData$lambda1((ScoringDeviceEntity) obj);
                return m448getGyroscopeData$lambda1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getGyroscopeData$lambda-1  reason: not valid java name */
    public static final ScoringDeviceModel m448getGyroscopeData$lambda1(ScoringDeviceEntity scoringDeviceEntity) {
        Intrinsics.checkNotNullParameter(scoringDeviceEntity, "");
        return ScoringDeviceEntityMapperKt.toScoringDeviceModel(scoringDeviceEntity);
    }

    @Override // id.dana.biometric.domain.RiskTrackerRepository
    public final Observable<Unit> clearData() {
        return getLocalRiskTrackerEntityData().clearData();
    }

    @Override // id.dana.biometric.domain.RiskTrackerRepository
    public final Observable<BiometricDataSize> onPageEndAndZip() {
        final RiskTrackerEntityData create = this.riskTrackerEntityDataFactory.create("network");
        Observable<BiometricDataSize> map = getLocalRiskTrackerEntityData().getAllAccelerometerData().flatMap(new Function() { // from class: id.dana.biometric.data.RiskTrackerEntityRepository$$ExternalSyntheticLambda15
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m456onPageEndAndZip$lambda2;
                m456onPageEndAndZip$lambda2 = RiskTrackerEntityRepository.m456onPageEndAndZip$lambda2(RiskTrackerEntityRepository.this, create, (ScoringDeviceEntity) obj);
                return m456onPageEndAndZip$lambda2;
            }
        }).onErrorResumeNext(new Function() { // from class: id.dana.biometric.data.RiskTrackerEntityRepository$$ExternalSyntheticLambda16
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m457onPageEndAndZip$lambda4;
                m457onPageEndAndZip$lambda4 = RiskTrackerEntityRepository.m457onPageEndAndZip$lambda4((Throwable) obj);
                return m457onPageEndAndZip$lambda4;
            }
        }).flatMap(new Function() { // from class: id.dana.biometric.data.RiskTrackerEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m459onPageEndAndZip$lambda5;
                m459onPageEndAndZip$lambda5 = RiskTrackerEntityRepository.m459onPageEndAndZip$lambda5(RiskTrackerEntityRepository.this, (Unit) obj);
                return m459onPageEndAndZip$lambda5;
            }
        }).flatMap(new Function() { // from class: id.dana.biometric.data.RiskTrackerEntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m460onPageEndAndZip$lambda6;
                m460onPageEndAndZip$lambda6 = RiskTrackerEntityRepository.m460onPageEndAndZip$lambda6(RiskTrackerEntityRepository.this, create, (ScoringDeviceEntity) obj);
                return m460onPageEndAndZip$lambda6;
            }
        }).onErrorResumeNext(new Function() { // from class: id.dana.biometric.data.RiskTrackerEntityRepository$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m461onPageEndAndZip$lambda8;
                m461onPageEndAndZip$lambda8 = RiskTrackerEntityRepository.m461onPageEndAndZip$lambda8((Throwable) obj);
                return m461onPageEndAndZip$lambda8;
            }
        }).flatMap(new Function() { // from class: id.dana.biometric.data.RiskTrackerEntityRepository$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m463onPageEndAndZip$lambda9;
                m463onPageEndAndZip$lambda9 = RiskTrackerEntityRepository.m463onPageEndAndZip$lambda9(RiskTrackerEntityRepository.this, (Unit) obj);
                return m463onPageEndAndZip$lambda9;
            }
        }).flatMap(new Function() { // from class: id.dana.biometric.data.RiskTrackerEntityRepository$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m452onPageEndAndZip$lambda10;
                m452onPageEndAndZip$lambda10 = RiskTrackerEntityRepository.m452onPageEndAndZip$lambda10(RiskTrackerEntityRepository.this, create, (ScoringDeviceEntity) obj);
                return m452onPageEndAndZip$lambda10;
            }
        }).onErrorResumeNext(new Function() { // from class: id.dana.biometric.data.RiskTrackerEntityRepository$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m453onPageEndAndZip$lambda12;
                m453onPageEndAndZip$lambda12 = RiskTrackerEntityRepository.m453onPageEndAndZip$lambda12((Throwable) obj);
                return m453onPageEndAndZip$lambda12;
            }
        }).map(new Function() { // from class: id.dana.biometric.data.RiskTrackerEntityRepository$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                BiometricDataSize m455onPageEndAndZip$lambda13;
                m455onPageEndAndZip$lambda13 = RiskTrackerEntityRepository.m455onPageEndAndZip$lambda13(RiskTrackerEntityRepository.this, (Unit) obj);
                return m455onPageEndAndZip$lambda13;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onPageEndAndZip$lambda-2  reason: not valid java name */
    public static final ObservableSource m456onPageEndAndZip$lambda2(RiskTrackerEntityRepository riskTrackerEntityRepository, RiskTrackerEntityData riskTrackerEntityData, ScoringDeviceEntity scoringDeviceEntity) {
        Intrinsics.checkNotNullParameter(riskTrackerEntityRepository, "");
        Intrinsics.checkNotNullParameter(riskTrackerEntityData, "");
        Intrinsics.checkNotNullParameter(scoringDeviceEntity, "");
        riskTrackerEntityRepository.sizeAccelerometer = riskTrackerEntityRepository.calculateDataSizeinKb(scoringDeviceEntity);
        return riskTrackerEntityRepository.handleNetworkCall(scoringDeviceEntity, riskTrackerEntityData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onPageEndAndZip$lambda-4  reason: not valid java name */
    public static final ObservableSource m457onPageEndAndZip$lambda4(final Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        return Observable.fromCallable(new Callable() { // from class: id.dana.biometric.data.RiskTrackerEntityRepository$$ExternalSyntheticLambda11
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Unit m458onPageEndAndZip$lambda4$lambda3;
                m458onPageEndAndZip$lambda4$lambda3 = RiskTrackerEntityRepository.m458onPageEndAndZip$lambda4$lambda3(th);
                return m458onPageEndAndZip$lambda4$lambda3;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onPageEndAndZip$lambda-4$lambda-3  reason: not valid java name */
    public static final Unit m458onPageEndAndZip$lambda4$lambda3(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        DanaLog.PlaceComponentResult(TAG, th.getMessage(), th);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onPageEndAndZip$lambda-5  reason: not valid java name */
    public static final ObservableSource m459onPageEndAndZip$lambda5(RiskTrackerEntityRepository riskTrackerEntityRepository, Unit unit) {
        Intrinsics.checkNotNullParameter(riskTrackerEntityRepository, "");
        Intrinsics.checkNotNullParameter(unit, "");
        return riskTrackerEntityRepository.getLocalRiskTrackerEntityData().getAllGyroscopeData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onPageEndAndZip$lambda-6  reason: not valid java name */
    public static final ObservableSource m460onPageEndAndZip$lambda6(RiskTrackerEntityRepository riskTrackerEntityRepository, RiskTrackerEntityData riskTrackerEntityData, ScoringDeviceEntity scoringDeviceEntity) {
        Intrinsics.checkNotNullParameter(riskTrackerEntityRepository, "");
        Intrinsics.checkNotNullParameter(riskTrackerEntityData, "");
        Intrinsics.checkNotNullParameter(scoringDeviceEntity, "");
        riskTrackerEntityRepository.sizeGyroscope = riskTrackerEntityRepository.calculateDataSizeinKb(scoringDeviceEntity);
        return riskTrackerEntityRepository.handleNetworkCall(scoringDeviceEntity, riskTrackerEntityData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onPageEndAndZip$lambda-8  reason: not valid java name */
    public static final ObservableSource m461onPageEndAndZip$lambda8(final Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        return Observable.fromCallable(new Callable() { // from class: id.dana.biometric.data.RiskTrackerEntityRepository$$ExternalSyntheticLambda12
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Unit m462onPageEndAndZip$lambda8$lambda7;
                m462onPageEndAndZip$lambda8$lambda7 = RiskTrackerEntityRepository.m462onPageEndAndZip$lambda8$lambda7(th);
                return m462onPageEndAndZip$lambda8$lambda7;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onPageEndAndZip$lambda-8$lambda-7  reason: not valid java name */
    public static final Unit m462onPageEndAndZip$lambda8$lambda7(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        DanaLog.PlaceComponentResult(TAG, th.getMessage(), th);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onPageEndAndZip$lambda-9  reason: not valid java name */
    public static final ObservableSource m463onPageEndAndZip$lambda9(RiskTrackerEntityRepository riskTrackerEntityRepository, Unit unit) {
        Intrinsics.checkNotNullParameter(riskTrackerEntityRepository, "");
        Intrinsics.checkNotNullParameter(unit, "");
        return riskTrackerEntityRepository.getLocalRiskTrackerEntityData().getAllKeystrokeData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onPageEndAndZip$lambda-10  reason: not valid java name */
    public static final ObservableSource m452onPageEndAndZip$lambda10(RiskTrackerEntityRepository riskTrackerEntityRepository, RiskTrackerEntityData riskTrackerEntityData, ScoringDeviceEntity scoringDeviceEntity) {
        Intrinsics.checkNotNullParameter(riskTrackerEntityRepository, "");
        Intrinsics.checkNotNullParameter(riskTrackerEntityData, "");
        Intrinsics.checkNotNullParameter(scoringDeviceEntity, "");
        riskTrackerEntityRepository.sizeKeystroke = riskTrackerEntityRepository.calculateDataSizeinKb(scoringDeviceEntity);
        return riskTrackerEntityRepository.handleNetworkCall(scoringDeviceEntity, riskTrackerEntityData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onPageEndAndZip$lambda-12  reason: not valid java name */
    public static final ObservableSource m453onPageEndAndZip$lambda12(final Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        return Observable.fromCallable(new Callable() { // from class: id.dana.biometric.data.RiskTrackerEntityRepository$$ExternalSyntheticLambda13
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Unit m454onPageEndAndZip$lambda12$lambda11;
                m454onPageEndAndZip$lambda12$lambda11 = RiskTrackerEntityRepository.m454onPageEndAndZip$lambda12$lambda11(th);
                return m454onPageEndAndZip$lambda12$lambda11;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onPageEndAndZip$lambda-12$lambda-11  reason: not valid java name */
    public static final Unit m454onPageEndAndZip$lambda12$lambda11(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        DanaLog.PlaceComponentResult(TAG, th.getMessage(), th);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onPageEndAndZip$lambda-13  reason: not valid java name */
    public static final BiometricDataSize m455onPageEndAndZip$lambda13(RiskTrackerEntityRepository riskTrackerEntityRepository, Unit unit) {
        Intrinsics.checkNotNullParameter(riskTrackerEntityRepository, "");
        Intrinsics.checkNotNullParameter(unit, "");
        return new BiometricDataSize(riskTrackerEntityRepository.sizeGyroscope, riskTrackerEntityRepository.sizeAccelerometer, riskTrackerEntityRepository.sizeKeystroke);
    }

    /* JADX WARN: Type inference failed for: r6v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    private final Observable<Unit> handleNetworkCall(ScoringDeviceEntity data, RiskTrackerEntityData networkRiskTrackerEntityData) {
        int i = 1;
        if (!(data.getScheme().length() == 0)) {
            if (!(data.getType().length() == 0) && !data.getValue().isEmpty()) {
                Observable<Unit> map = authenticatedRequest(networkRiskTrackerEntityData.onPageEndAndZip(data)).map(new Function() { // from class: id.dana.biometric.data.RiskTrackerEntityRepository$$ExternalSyntheticLambda9
                    @Override // io.reactivex.functions.Function
                    public final Object apply(Object obj) {
                        Unit m451handleNetworkCall$lambda14;
                        m451handleNetworkCall$lambda14 = RiskTrackerEntityRepository.m451handleNetworkCall$lambda14((InsertDeviceScoringDataResult) obj);
                        return m451handleNetworkCall$lambda14;
                    }
                });
                Intrinsics.checkNotNullExpressionValue(map, "");
                return map;
            }
        }
        ?? r6 = 0;
        Observable<Unit> error = Observable.error(new EmptyDataException(r6, i, r6));
        Intrinsics.checkNotNullExpressionValue(error, "");
        return error;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handleNetworkCall$lambda-14  reason: not valid java name */
    public static final Unit m451handleNetworkCall$lambda14(InsertDeviceScoringDataResult insertDeviceScoringDataResult) {
        Intrinsics.checkNotNullParameter(insertDeviceScoringDataResult, "");
        return Unit.INSTANCE;
    }

    @Override // id.dana.biometric.domain.RiskTrackerRepository
    public final Observable<RiskTrackerConfig> getRiskTrackerConfig() {
        RiskTrackerConfigEntityData create = this.riskTrackerConfigEntityDataFactory.create("split");
        final RiskTrackerConfigEntityData create2 = this.riskTrackerConfigEntityDataFactory.create("local");
        Observable map = create.getRiskTrackerConfig().timeout(3000L, TimeUnit.MILLISECONDS).onErrorResumeNext(new Function() { // from class: id.dana.biometric.data.RiskTrackerEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m449getRiskTrackerConfig$lambda15;
                m449getRiskTrackerConfig$lambda15 = RiskTrackerEntityRepository.m449getRiskTrackerConfig$lambda15(RiskTrackerConfigEntityData.this, (Throwable) obj);
                return m449getRiskTrackerConfig$lambda15;
            }
        }).map(new Function() { // from class: id.dana.biometric.data.RiskTrackerEntityRepository$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                RiskTrackerConfig m450getRiskTrackerConfig$lambda16;
                m450getRiskTrackerConfig$lambda16 = RiskTrackerEntityRepository.m450getRiskTrackerConfig$lambda16((RiskTrackerConfigEntity) obj);
                return m450getRiskTrackerConfig$lambda16;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getRiskTrackerConfig$lambda-15  reason: not valid java name */
    public static final ObservableSource m449getRiskTrackerConfig$lambda15(RiskTrackerConfigEntityData riskTrackerConfigEntityData, Throwable th) {
        Intrinsics.checkNotNullParameter(riskTrackerConfigEntityData, "");
        Intrinsics.checkNotNullParameter(th, "");
        return riskTrackerConfigEntityData.getRiskTrackerConfig();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getRiskTrackerConfig$lambda-16  reason: not valid java name */
    public static final RiskTrackerConfig m450getRiskTrackerConfig$lambda16(RiskTrackerConfigEntity riskTrackerConfigEntity) {
        Intrinsics.checkNotNullParameter(riskTrackerConfigEntity, "");
        return RiskTrackerConfigEntityMapperKt.toRiskTrackerConfig(riskTrackerConfigEntity);
    }

    private final double calculateDataSizeinKb(ScoringDeviceEntity biometricData) {
        DataSizeUtil dataSizeUtil = DataSizeUtil.INSTANCE;
        return DataSizeUtil.BuiltInFictitiousFunctionClassFactory(biometricData);
    }
}
