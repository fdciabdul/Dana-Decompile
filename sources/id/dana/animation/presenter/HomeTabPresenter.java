package id.dana.animation.presenter;

import dagger.Lazy;
import id.dana.animation.presenter.HomeTabContract;
import id.dana.base.AbstractContractKt;
import id.dana.base.BasePresenter;
import id.dana.biometric.domain.model.BiometricDataSize;
import id.dana.biometric.presentation.RiskTracker;
import id.dana.domain.DefaultObserver;
import id.dana.domain.account.interactor.IsFirstTime;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.CompletableUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.devicestats.storage.ScheduleDeviceStatsReport;
import id.dana.domain.featureconfig.interactor.GetQueryUserDataConfig;
import id.dana.domain.featureconfig.model.QueryUserDataConfig;
import id.dana.domain.featureconfig.model.ResetAndChangePinNativeEntryConfig;
import id.dana.domain.home.interactor.CheckHomePassiveBioTracked;
import id.dana.domain.home.interactor.SavePassiveBioTracked;
import id.dana.domain.homeinfo.interactor.GetFeatureHoldLoginConfig;
import id.dana.domain.homeinfo.interactor.GetMixpanelStorageConfig;
import id.dana.domain.homeinfo.interactor.GetVoiceAssistantConfig;
import id.dana.domain.login.interactor.CheckSession;
import id.dana.domain.login.interactor.GetIsSessionChecked;
import id.dana.domain.login.interactor.SaveIsSessionChecked;
import id.dana.domain.resetpin.interactor.ConsultForceDanaVizEnroll;
import id.dana.domain.resetpin.interactor.GetResetAndChangePinNativeEntryConfig;
import id.dana.domain.resetpin.model.ConsultDanaVizModel;
import id.dana.domain.user.interactor.GetUserCohort;
import id.dana.domain.usercredential.interactor.GetPasswordLastModifiedWithConfigChecking;
import id.dana.domain.usercredential.model.QueryCredentialInfoModel;
import id.dana.performancetracker.AppReadyMixpanelTracker;
import id.dana.utils.DateTimeUtil;
import java.util.Date;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u00012\u00020\u0002Bñ\u0001\b\u0007\u0012\u0006\u0010\u0012\u001a\u000209\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020(0!\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020.0!\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020,0!\u0012\f\u0010<\u001a\b\u0012\u0004\u0012\u0002020!\u0012\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\"0!\u0012\f\u0010>\u001a\b\u0012\u0004\u0012\u0002050!\u0012\f\u0010?\u001a\b\u0012\u0004\u0012\u00020)0!\u0012\f\u0010@\u001a\b\u0012\u0004\u0012\u00020*0!\u0012\f\u0010A\u001a\b\u0012\u0004\u0012\u00020&0!\u0012\f\u0010B\u001a\b\u0012\u0004\u0012\u00020%0!\u0012\f\u0010C\u001a\b\u0012\u0004\u0012\u00020+0!\u0012\f\u0010D\u001a\b\u0012\u0004\u0012\u0002070!\u0012\f\u0010E\u001a\b\u0012\u0004\u0012\u00020'0!\u0012\f\u0010F\u001a\b\u0012\u0004\u0012\u0002030!\u0012\f\u0010G\u001a\b\u0012\u0004\u0012\u00020$0!\u0012\f\u0010H\u001a\b\u0012\u0004\u0012\u0002000!¢\u0006\u0004\bI\u0010JJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0005J\u000f\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\n\u0010\u0005J\u000f\u0010\u000b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\u0005J\u000f\u0010\f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\r\u0010\u0005J\u000f\u0010\u000e\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\u0005J\u000f\u0010\u000f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000f\u0010\u0005J\u000f\u0010\u0010\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0005JG\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u00132\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00030\u0016H\u0016¢\u0006\u0004\b\u0004\u0010\u0019J\u001f\u0010\t\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u001aH\u0000¢\u0006\u0004\b\t\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001c\u0010\u0005J#\u0010\b\u001a\u00020\u00032\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00030\u0016H\u0016¢\u0006\u0004\b\b\u0010\u001eJ+\u0010\t\u001a\u00020\u00032\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013H\u0016¢\u0006\u0004\b\t\u0010\u001fR\u0016\u0010\t\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010 R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\"0!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010#R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020$0!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010#R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020%0!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010#R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020&0!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010#R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020'0!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010#R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020(0!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010#R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020)0!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010#R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020*0!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010#R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020+0!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010#R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020,0!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010#R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020.0!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010#R\u001a\u00101\u001a\b\u0012\u0004\u0012\u0002000!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u0010#R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010#R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002030!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u0010#R\u001a\u00106\u001a\b\u0012\u0004\u0012\u0002050!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010#R\u001a\u00108\u001a\b\u0012\u0004\u0012\u0002070!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u0010#R\u0014\u0010;\u001a\u0002098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u0010:"}, d2 = {"Lid/dana/home/presenter/HomeTabPresenter;", "Lid/dana/home/presenter/HomeTabContract$Presenter;", "Lid/dana/base/BasePresenter;", "", "BuiltInFictitiousFunctionClassFactory", "()V", "PlaceComponentResult", "getAuthRequestContext", "MyBillsEntityDataFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "lookAheadTest", "scheduleImpl", "NetworkUserEntityData$$ExternalSyntheticLambda0", "moveToNextValue", "getErrorConfigVersion", "NetworkUserEntityData$$ExternalSyntheticLambda1", "NetworkUserEntityData$$ExternalSyntheticLambda2", "", "p0", "Lkotlin/Function0;", "p1", "p2", "Lkotlin/Function1;", "", "p3", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "", "(JJ)Z", "onDestroy", "Lid/dana/biometric/domain/model/BiometricDataSize;", "(Lkotlin/jvm/functions/Function1;)V", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "Z", "Ldagger/Lazy;", "Lid/dana/domain/home/interactor/CheckHomePassiveBioTracked;", "Ldagger/Lazy;", "Lid/dana/domain/login/interactor/CheckSession;", "Lid/dana/domain/resetpin/interactor/ConsultForceDanaVizEnroll;", "Lid/dana/domain/homeinfo/interactor/GetFeatureHoldLoginConfig;", "Lid/dana/domain/login/interactor/GetIsSessionChecked;", "Lid/dana/domain/homeinfo/interactor/GetMixpanelStorageConfig;", "Lid/dana/domain/usercredential/interactor/GetPasswordLastModifiedWithConfigChecking;", "Lid/dana/domain/featureconfig/interactor/GetQueryUserDataConfig;", "Lid/dana/domain/resetpin/interactor/GetResetAndChangePinNativeEntryConfig;", "Lid/dana/domain/user/interactor/GetUserCohort;", "DatabaseTableConfigUtil", "Lid/dana/domain/homeinfo/interactor/GetVoiceAssistantConfig;", "initRecordTimeStamp", "Lid/dana/domain/account/interactor/IsFirstTime;", "GetContactSyncConfig", "Lid/dana/biometric/presentation/RiskTracker;", "Lid/dana/domain/login/interactor/SaveIsSessionChecked;", "isLayoutRequested", "Lid/dana/domain/home/interactor/SavePassiveBioTracked;", "NetworkUserEntityData$$ExternalSyntheticLambda8", "Lid/dana/domain/devicestats/storage/ScheduleDeviceStatsReport;", "NetworkUserEntityData$$ExternalSyntheticLambda7", "Lid/dana/home/presenter/HomeTabContract$View;", "Lid/dana/home/presenter/HomeTabContract$View;", "PrepareContext", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "p12", "p13", "p14", "p15", "p16", "<init>", "(Lid/dana/home/presenter/HomeTabContract$View;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HomeTabPresenter extends BasePresenter implements HomeTabContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    final Lazy<SavePassiveBioTracked> NetworkUserEntityData$$ExternalSyntheticLambda8;
    private final Lazy<GetUserCohort> DatabaseTableConfigUtil;
    private final Lazy<IsFirstTime> GetContactSyncConfig;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Lazy<CheckHomePassiveBioTracked> getAuthRequestContext;
    private final Lazy<CheckSession> MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final Lazy<GetPasswordLastModifiedWithConfigChecking> lookAheadTest;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private final Lazy<GetVoiceAssistantConfig> initRecordTimeStamp;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private final Lazy<GetResetAndChangePinNativeEntryConfig> scheduleImpl;
    private final Lazy<ScheduleDeviceStatsReport> NetworkUserEntityData$$ExternalSyntheticLambda7;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private final HomeTabContract.View PrepareContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Lazy<ConsultForceDanaVizEnroll> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final Lazy<GetFeatureHoldLoginConfig> PlaceComponentResult;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private final Lazy<RiskTracker> NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private final Lazy<SaveIsSessionChecked> NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final Lazy<GetQueryUserDataConfig> moveToNextValue;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final Lazy<GetIsSessionChecked> NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final Lazy<GetMixpanelStorageConfig> getErrorConfigVersion;

    @Inject
    public HomeTabPresenter(HomeTabContract.View view, Lazy<GetMixpanelStorageConfig> lazy, Lazy<GetVoiceAssistantConfig> lazy2, Lazy<GetUserCohort> lazy3, Lazy<RiskTracker> lazy4, Lazy<CheckHomePassiveBioTracked> lazy5, Lazy<SavePassiveBioTracked> lazy6, Lazy<GetPasswordLastModifiedWithConfigChecking> lazy7, Lazy<GetQueryUserDataConfig> lazy8, Lazy<GetFeatureHoldLoginConfig> lazy9, Lazy<ConsultForceDanaVizEnroll> lazy10, Lazy<GetResetAndChangePinNativeEntryConfig> lazy11, Lazy<ScheduleDeviceStatsReport> lazy12, Lazy<GetIsSessionChecked> lazy13, Lazy<SaveIsSessionChecked> lazy14, Lazy<CheckSession> lazy15, Lazy<IsFirstTime> lazy16) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(lazy, "");
        Intrinsics.checkNotNullParameter(lazy2, "");
        Intrinsics.checkNotNullParameter(lazy3, "");
        Intrinsics.checkNotNullParameter(lazy4, "");
        Intrinsics.checkNotNullParameter(lazy5, "");
        Intrinsics.checkNotNullParameter(lazy6, "");
        Intrinsics.checkNotNullParameter(lazy7, "");
        Intrinsics.checkNotNullParameter(lazy8, "");
        Intrinsics.checkNotNullParameter(lazy9, "");
        Intrinsics.checkNotNullParameter(lazy10, "");
        Intrinsics.checkNotNullParameter(lazy11, "");
        Intrinsics.checkNotNullParameter(lazy12, "");
        Intrinsics.checkNotNullParameter(lazy13, "");
        Intrinsics.checkNotNullParameter(lazy14, "");
        Intrinsics.checkNotNullParameter(lazy15, "");
        Intrinsics.checkNotNullParameter(lazy16, "");
        this.PrepareContext = view;
        this.getErrorConfigVersion = lazy;
        this.initRecordTimeStamp = lazy2;
        this.DatabaseTableConfigUtil = lazy3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = lazy4;
        this.getAuthRequestContext = lazy5;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = lazy6;
        this.lookAheadTest = lazy7;
        this.moveToNextValue = lazy8;
        this.PlaceComponentResult = lazy9;
        this.BuiltInFictitiousFunctionClassFactory = lazy10;
        this.scheduleImpl = lazy11;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = lazy12;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = lazy13;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = lazy14;
        this.MyBillsEntityDataFactory = lazy15;
        this.GetContactSyncConfig = lazy16;
    }

    @Override // id.dana.home.presenter.HomeTabContract.Presenter
    public final void NetworkUserEntityData$$ExternalSyntheticLambda0() {
        GetMixpanelStorageConfig getMixpanelStorageConfig = this.getErrorConfigVersion.get();
        Intrinsics.checkNotNullExpressionValue(getMixpanelStorageConfig, "");
        BaseUseCase.execute$default(getMixpanelStorageConfig, NoParams.INSTANCE, new Function1<Boolean, Unit>() { // from class: id.dana.home.presenter.HomeTabPresenter$getMixpanelStorageConfig$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                HomeTabContract.View view;
                view = HomeTabPresenter.this.PrepareContext;
                view.MyBillsEntityDataFactory(z);
            }
        }, null, 4, null);
    }

    @Override // id.dana.home.presenter.HomeTabContract.Presenter
    public final void NetworkUserEntityData$$ExternalSyntheticLambda2() {
        GetVoiceAssistantConfig getVoiceAssistantConfig = this.initRecordTimeStamp.get();
        Intrinsics.checkNotNullExpressionValue(getVoiceAssistantConfig, "");
        BaseUseCase.execute$default(getVoiceAssistantConfig, NoParams.INSTANCE, new Function1<Boolean, Unit>() { // from class: id.dana.home.presenter.HomeTabPresenter$getVoiceAssistantConfig$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                HomeTabContract.View view;
                view = HomeTabPresenter.this.PrepareContext;
                view.BuiltInFictitiousFunctionClassFactory(z);
            }
        }, null, 4, null);
    }

    @Override // id.dana.home.presenter.HomeTabContract.Presenter
    public final void NetworkUserEntityData$$ExternalSyntheticLambda1() {
        GetUserCohort getUserCohort = this.DatabaseTableConfigUtil.get();
        Intrinsics.checkNotNullExpressionValue(getUserCohort, "");
        CompletableUseCase.execute$default(getUserCohort, NoParams.INSTANCE, null, null, 6, null);
    }

    @Override // id.dana.home.presenter.HomeTabContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(String p0, Function0<Unit> p1, Function0<Unit> p2, Function1<? super Boolean, Unit> p3) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.get().getAuthRequestContext(p0, p1, p2, p3);
    }

    @Override // id.dana.home.presenter.HomeTabContract.Presenter
    public final void MyBillsEntityDataFactory(final Function1<? super BiometricDataSize, Unit> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p0, "");
        final long BuiltInFictitiousFunctionClassFactory = this.NetworkUserEntityData$$ExternalSyntheticLambda1.get().BuiltInFictitiousFunctionClassFactory();
        CheckHomePassiveBioTracked checkHomePassiveBioTracked = this.getAuthRequestContext.get();
        Intrinsics.checkNotNullExpressionValue(checkHomePassiveBioTracked, "");
        BaseUseCase.execute$default(checkHomePassiveBioTracked, NoParams.INSTANCE, new Function1<Long, Unit>() { // from class: id.dana.home.presenter.HomeTabPresenter$checkLastTimeTracked$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Long l) {
                invoke(l.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j) {
                boolean z;
                Lazy lazy;
                if (HomeTabPresenter.KClassImpl$Data$declaredNonStaticMembers$2(j, BuiltInFictitiousFunctionClassFactory)) {
                    z = HomeTabPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (z) {
                        return;
                    }
                    lazy = HomeTabPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    ((RiskTracker) lazy.get()).MyBillsEntityDataFactory(p0);
                    SavePassiveBioTracked savePassiveBioTracked = HomeTabPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda8.get();
                    Intrinsics.checkNotNullExpressionValue(savePassiveBioTracked, "");
                    BaseUseCase.execute$default(savePassiveBioTracked, Long.valueOf(DateTimeUtil.BuiltInFictitiousFunctionClassFactory()), new Function1<Unit, Unit>() { // from class: id.dana.home.presenter.HomeTabPresenter$saveLastTimeCheck$1
                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(Unit unit) {
                            Intrinsics.checkNotNullParameter(unit, "");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                            invoke2(unit);
                            return Unit.INSTANCE;
                        }
                    }, null, 4, null);
                    HomeTabPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                }
            }
        }, null, 4, null);
    }

    @Override // id.dana.home.presenter.HomeTabContract.Presenter
    public final void moveToNextValue() {
        this.lookAheadTest.get().execute(new GetPasswordLastModifiedWithConfigChecking.Params(false, true), new Function1<QueryCredentialInfoModel, Unit>() { // from class: id.dana.home.presenter.HomeTabPresenter$getPasswordLastModifiedWithConfigChecking$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(QueryCredentialInfoModel queryCredentialInfoModel) {
                invoke2(queryCredentialInfoModel);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(QueryCredentialInfoModel queryCredentialInfoModel) {
                HomeTabContract.View view;
                HomeTabContract.View view2;
                Intrinsics.checkNotNullParameter(queryCredentialInfoModel, "");
                if (queryCredentialInfoModel.shouldChangePin()) {
                    view2 = HomeTabPresenter.this.PrepareContext;
                    view2.getAuthRequestContext();
                    return;
                }
                view = HomeTabPresenter.this.PrepareContext;
                view.MyBillsEntityDataFactory();
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.home.presenter.HomeTabPresenter$getPasswordLastModifiedWithConfigChecking$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                HomeTabContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = HomeTabPresenter.this.PrepareContext;
                view.MyBillsEntityDataFactory();
            }
        });
    }

    @Override // id.dana.home.presenter.HomeTabContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.lookAheadTest.get().execute(new GetPasswordLastModifiedWithConfigChecking.Params(true, false), new Function1<QueryCredentialInfoModel, Unit>() { // from class: id.dana.home.presenter.HomeTabPresenter$checkIsPasswordHasBeenChanged$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(QueryCredentialInfoModel queryCredentialInfoModel) {
                invoke2(queryCredentialInfoModel);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(QueryCredentialInfoModel queryCredentialInfoModel) {
                HomeTabContract.View view;
                Intrinsics.checkNotNullParameter(queryCredentialInfoModel, "");
                if (queryCredentialInfoModel.shouldChangePin()) {
                    return;
                }
                view = HomeTabPresenter.this.PrepareContext;
                view.KClassImpl$Data$declaredNonStaticMembers$2();
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.home.presenter.HomeTabPresenter$checkIsPasswordHasBeenChanged$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                HomeTabContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = HomeTabPresenter.this.PrepareContext;
                view.KClassImpl$Data$declaredNonStaticMembers$2();
            }
        });
    }

    @Override // id.dana.home.presenter.HomeTabContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.PrepareContext.showProgress();
        this.scheduleImpl.get().execute(NoParams.INSTANCE, new Function1<ResetAndChangePinNativeEntryConfig, Unit>() { // from class: id.dana.home.presenter.HomeTabPresenter$getChangePinNativeEntryConfig$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(ResetAndChangePinNativeEntryConfig resetAndChangePinNativeEntryConfig) {
                invoke2(resetAndChangePinNativeEntryConfig);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(ResetAndChangePinNativeEntryConfig resetAndChangePinNativeEntryConfig) {
                HomeTabContract.View view;
                HomeTabContract.View view2;
                Intrinsics.checkNotNullParameter(resetAndChangePinNativeEntryConfig, "");
                view = HomeTabPresenter.this.PrepareContext;
                view.PlaceComponentResult(resetAndChangePinNativeEntryConfig.getFeaturePinRegularChanges());
                view2 = HomeTabPresenter.this.PrepareContext;
                view2.dismissProgress();
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.home.presenter.HomeTabPresenter$getChangePinNativeEntryConfig$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                HomeTabContract.View view;
                HomeTabContract.View view2;
                Intrinsics.checkNotNullParameter(th, "");
                view = HomeTabPresenter.this.PrepareContext;
                view.PlaceComponentResult(false);
                view2 = HomeTabPresenter.this.PrepareContext;
                view2.dismissProgress();
            }
        });
    }

    public static boolean KClassImpl$Data$declaredNonStaticMembers$2(long p0, long p1) {
        return DateTimeUtil.PlaceComponentResult(new Date(), new Date(p0)) >= p1;
    }

    @Override // id.dana.home.presenter.HomeTabContract.Presenter
    public final void getErrorConfigVersion() {
        GetQueryUserDataConfig getQueryUserDataConfig = this.moveToNextValue.get();
        Intrinsics.checkNotNullExpressionValue(getQueryUserDataConfig, "");
        BaseUseCase.execute$default(getQueryUserDataConfig, NoParams.INSTANCE, new Function1<QueryUserDataConfig, Unit>() { // from class: id.dana.home.presenter.HomeTabPresenter$getQueryUserDataConfig$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(QueryUserDataConfig queryUserDataConfig) {
                Intrinsics.checkNotNullParameter(queryUserDataConfig, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(QueryUserDataConfig queryUserDataConfig) {
                invoke2(queryUserDataConfig);
                return Unit.INSTANCE;
            }
        }, null, 4, null);
    }

    @Override // id.dana.home.presenter.HomeTabContract.Presenter
    public final void getAuthRequestContext() {
        ConsultForceDanaVizEnroll consultForceDanaVizEnroll = this.BuiltInFictitiousFunctionClassFactory.get();
        Intrinsics.checkNotNullExpressionValue(consultForceDanaVizEnroll, "");
        BaseUseCase.execute$default(consultForceDanaVizEnroll, NoParams.INSTANCE, new Function1<ConsultDanaVizModel, Unit>() { // from class: id.dana.home.presenter.HomeTabPresenter$checkUserInfoDanaViz$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(ConsultDanaVizModel consultDanaVizModel) {
                invoke2(consultDanaVizModel);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(ConsultDanaVizModel consultDanaVizModel) {
                HomeTabContract.View view;
                Intrinsics.checkNotNullParameter(consultDanaVizModel, "");
                if (consultDanaVizModel.getIsShowDanaVizPrompt()) {
                    view = HomeTabPresenter.this.PrepareContext;
                    view.getAuthRequestContext(consultDanaVizModel.getIsForced());
                }
            }
        }, null, 4, null);
    }

    @Override // id.dana.home.presenter.HomeTabContract.Presenter
    public final void lookAheadTest() {
        GetFeatureHoldLoginConfig getFeatureHoldLoginConfig = this.PlaceComponentResult.get();
        Intrinsics.checkNotNullExpressionValue(getFeatureHoldLoginConfig, "");
        CompletableUseCase.execute$default(getFeatureHoldLoginConfig, Unit.INSTANCE, null, null, 6, null);
    }

    @Override // id.dana.home.presenter.HomeTabContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Function0<Unit> p0, Function0<Unit> p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda7.get().execute(new ScheduleDeviceStatsReport.Param(p0, p1), new Function0<Unit>() { // from class: id.dana.home.presenter.HomeTabPresenter$scheduleDeviceStatsReport$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.home.presenter.HomeTabPresenter$scheduleDeviceStatsReport$2
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // id.dana.home.presenter.HomeTabContract.Presenter
    public final void scheduleImpl() {
        this.GetContactSyncConfig.get().execute(new DefaultObserver<Boolean>() { // from class: id.dana.home.presenter.HomeTabPresenter$getIsSessionChecked$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                HomeTabContract.View view;
                if (((Boolean) obj).booleanValue()) {
                    view = HomeTabPresenter.this.PrepareContext;
                    view.scheduleImpl(true);
                    return;
                }
                r2.NetworkUserEntityData$$ExternalSyntheticLambda0.get().execute(NoParams.INSTANCE, new Function1<Boolean, Unit>() { // from class: id.dana.home.presenter.HomeTabPresenter$checkIsSessionChecked$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z) {
                        HomeTabContract.View view2;
                        view2 = HomeTabPresenter.this.PrepareContext;
                        view2.scheduleImpl(z);
                    }
                }, new Function1<Throwable, Unit>() { // from class: id.dana.home.presenter.HomeTabPresenter$checkIsSessionChecked$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                        invoke2(th);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable th) {
                        Intrinsics.checkNotNullParameter(th, "");
                        HomeTabPresenter.this.PlaceComponentResult();
                    }
                });
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                r2.NetworkUserEntityData$$ExternalSyntheticLambda0.get().execute(NoParams.INSTANCE, new Function1<Boolean, Unit>() { // from class: id.dana.home.presenter.HomeTabPresenter$checkIsSessionChecked$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z) {
                        HomeTabContract.View view2;
                        view2 = HomeTabPresenter.this.PrepareContext;
                        view2.scheduleImpl(z);
                    }
                }, new Function1<Throwable, Unit>() { // from class: id.dana.home.presenter.HomeTabPresenter$checkIsSessionChecked$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                        invoke2(th);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable th) {
                        Intrinsics.checkNotNullParameter(th, "");
                        HomeTabPresenter.this.PlaceComponentResult();
                    }
                });
            }
        });
    }

    @Override // id.dana.home.presenter.HomeTabContract.Presenter
    public final void MyBillsEntityDataFactory() {
        SaveIsSessionChecked saveIsSessionChecked = this.NetworkUserEntityData$$ExternalSyntheticLambda2.get();
        Intrinsics.checkNotNullExpressionValue(saveIsSessionChecked, "");
        BaseUseCase.execute$default(saveIsSessionChecked, new SaveIsSessionChecked.Params(false), new Function1<Boolean, Unit>() { // from class: id.dana.home.presenter.HomeTabPresenter$clearIsSessionChecked$1
            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                AppReadyMixpanelTracker.BuiltInFictitiousFunctionClassFactory.DatabaseTableConfigUtil();
            }
        }, null, 4, null);
    }

    @Override // id.dana.home.presenter.HomeTabContract.Presenter
    public final void PlaceComponentResult() {
        this.MyBillsEntityDataFactory.get().execute(NoParams.INSTANCE, new Function1<Boolean, Unit>() { // from class: id.dana.home.presenter.HomeTabPresenter$checkSession$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                HomeTabContract.View view;
                view = HomeTabPresenter.this.PrepareContext;
                view.KClassImpl$Data$declaredNonStaticMembers$2(z);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.home.presenter.HomeTabPresenter$checkSession$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                HomeTabContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = HomeTabPresenter.this.PrepareContext;
                view.KClassImpl$Data$declaredNonStaticMembers$2(false);
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        AbstractContractKt.AbstractPresenter.CC.BuiltInFictitiousFunctionClassFactory();
        this.getErrorConfigVersion.get().dispose();
        this.initRecordTimeStamp.get().dispose();
        this.getAuthRequestContext.get().dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda8.get().dispose();
        this.lookAheadTest.get().dispose();
        this.moveToNextValue.get().dispose();
        this.scheduleImpl.get().dispose();
        this.PlaceComponentResult.get().dispose();
        this.BuiltInFictitiousFunctionClassFactory.get().dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda7.get().dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.get().dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.get().dispose();
        this.MyBillsEntityDataFactory.get().dispose();
        this.GetContactSyncConfig.get().dispose();
    }
}
