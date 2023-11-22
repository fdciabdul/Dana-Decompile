package id.dana.maintenance;

import dagger.Lazy;
import id.dana.domain.DefaultObserver;
import id.dana.domain.carrieridentification.interactor.CheckIpificationCoverage;
import id.dana.domain.carrieridentification.model.CheckCoverageResponse;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.featureconfig.model.EmergencyNotificationConfig;
import id.dana.domain.maintenance.interactor.GetEmergencyNotifConfig;
import id.dana.domain.model.rpc.response.CheckRegistrationResponse;
import id.dana.domain.registration.interactor.CheckRegisteredPhoneNumber;
import id.dana.domain.registration.model.CheckRegistrationRequest;
import id.dana.maintenance.EmergencyNotifContract;
import id.dana.network.exception.NetworkException;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.subjects.PublishSubject;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u001d\u0012\u0006\u0010\b\u001a\u00020\u0019\u0012\u0006\u0010\u001f\u001a\u00020\u0016\u0012\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\u0004\b!\u0010\"J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u000fJ\u000f\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\u000fJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\u000fJ\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u000fR\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0015R\u0014\u0010\f\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0017R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0018R\u0014\u0010\u0011\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001aR\u001c\u0010\u0005\u001a\f\u0012\b\u0012\u0006*\u00020\u000b0\u000b0\u001bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0011\u0010\u001cR\u0014\u0010\u0012\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u001e"}, d2 = {"Lid/dana/maintenance/EmergencyNotifPresenter;", "Lid/dana/maintenance/EmergencyNotifContract$Presenter;", "", "p0", "", "PlaceComponentResult", "(Ljava/lang/String;)V", "", "p1", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Z)V", "Lid/dana/maintenance/EmergencyState;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/maintenance/EmergencyState;)V", "onDestroy", "()V", "MyBillsEntityDataFactory", "getAuthRequestContext", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Ldagger/Lazy;", "Lid/dana/domain/carrieridentification/interactor/CheckIpificationCoverage;", "Ldagger/Lazy;", "Lid/dana/domain/registration/interactor/CheckRegisteredPhoneNumber;", "Lid/dana/domain/registration/interactor/CheckRegisteredPhoneNumber;", "Lid/dana/maintenance/EmergencyState;", "Lid/dana/domain/maintenance/interactor/GetEmergencyNotifConfig;", "Lid/dana/domain/maintenance/interactor/GetEmergencyNotifConfig;", "Lio/reactivex/subjects/PublishSubject;", "Lio/reactivex/subjects/PublishSubject;", "Lid/dana/maintenance/EmergencyNotifContract$View;", "Lid/dana/maintenance/EmergencyNotifContract$View;", "p2", "p3", "<init>", "(Lid/dana/maintenance/EmergencyNotifContract$View;Lid/dana/domain/maintenance/interactor/GetEmergencyNotifConfig;Lid/dana/domain/registration/interactor/CheckRegisteredPhoneNumber;Ldagger/Lazy;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EmergencyNotifPresenter implements EmergencyNotifContract.Presenter {
    private final Lazy<CheckIpificationCoverage> BuiltInFictitiousFunctionClassFactory;
    private final CheckRegisteredPhoneNumber KClassImpl$Data$declaredNonStaticMembers$2;
    private EmergencyState MyBillsEntityDataFactory;
    private final EmergencyNotifContract.View NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    final GetEmergencyNotifConfig getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public PublishSubject<EmergencyState> PlaceComponentResult;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] KClassImpl$Data$declaredNonStaticMembers$2;

        static {
            int[] iArr = new int[EmergencyState.values().length];
            iArr[EmergencyState.CONFIG_COUNTDOWN_RUNNING.ordinal()] = 1;
            iArr[EmergencyState.CONFIG_COUNTDOWN_FINISHED.ordinal()] = 2;
            iArr[EmergencyState.CONFIG_COUNTDOWN_INVALID.ordinal()] = 3;
            iArr[EmergencyState.DEFAULT_COUNTDOWN_RUNNING.ordinal()] = 4;
            KClassImpl$Data$declaredNonStaticMembers$2 = iArr;
        }
    }

    @Inject
    public EmergencyNotifPresenter(EmergencyNotifContract.View view, GetEmergencyNotifConfig getEmergencyNotifConfig, CheckRegisteredPhoneNumber checkRegisteredPhoneNumber, Lazy<CheckIpificationCoverage> lazy) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(getEmergencyNotifConfig, "");
        Intrinsics.checkNotNullParameter(checkRegisteredPhoneNumber, "");
        Intrinsics.checkNotNullParameter(lazy, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = view;
        this.getAuthRequestContext = getEmergencyNotifConfig;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = checkRegisteredPhoneNumber;
        this.BuiltInFictitiousFunctionClassFactory = lazy;
        PublishSubject<EmergencyState> PlaceComponentResult = PublishSubject.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        this.PlaceComponentResult = PlaceComponentResult;
        PlaceComponentResult.subscribeOn(AndroidSchedulers.PlaceComponentResult()).subscribe(new DefaultObserver<EmergencyState>() { // from class: id.dana.maintenance.EmergencyNotifPresenter$getCountdownObserver$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                EmergencyState emergencyState = (EmergencyState) obj;
                Intrinsics.checkNotNullParameter(emergencyState, "");
                EmergencyNotifPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2(emergencyState);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.EMERGENCY_NOTIF, "Emergency publish subject error: ", p0);
            }
        });
    }

    @Override // id.dana.maintenance.EmergencyNotifContract.Presenter
    public final void getAuthRequestContext() {
        this.MyBillsEntityDataFactory = EmergencyState.CONFIG_COUNTDOWN_RUNNING;
        this.PlaceComponentResult.onNext(EmergencyState.CONFIG_COUNTDOWN_RUNNING);
    }

    @Override // id.dana.maintenance.EmergencyNotifContract.Presenter
    public final void PlaceComponentResult() {
        this.MyBillsEntityDataFactory = EmergencyState.CONFIG_COUNTDOWN_FINISHED;
        this.PlaceComponentResult.onNext(EmergencyState.CONFIG_COUNTDOWN_FINISHED);
    }

    @Override // id.dana.maintenance.EmergencyNotifContract.Presenter
    public final void MyBillsEntityDataFactory() {
        this.MyBillsEntityDataFactory = EmergencyState.CONFIG_COUNTDOWN_INVALID;
        this.PlaceComponentResult.onNext(EmergencyState.CONFIG_COUNTDOWN_INVALID);
    }

    @Override // id.dana.maintenance.EmergencyNotifContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.MyBillsEntityDataFactory = EmergencyState.DEFAULT_COUNTDOWN_RUNNING;
        this.PlaceComponentResult.onNext(EmergencyState.DEFAULT_COUNTDOWN_RUNNING);
    }

    @Override // id.dana.maintenance.EmergencyNotifContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.MyBillsEntityDataFactory = EmergencyState.DEFAULT_COUNTDOWN_FINISHED;
        this.PlaceComponentResult.onNext(EmergencyState.DEFAULT_COUNTDOWN_FINISHED);
    }

    @Override // id.dana.maintenance.EmergencyNotifContract.Presenter
    public final void NetworkUserEntityData$$ExternalSyntheticLambda0() {
        EmergencyState emergencyState = this.MyBillsEntityDataFactory;
        Intrinsics.checkNotNull(emergencyState);
        KClassImpl$Data$declaredNonStaticMembers$2(emergencyState);
    }

    @Override // id.dana.maintenance.EmergencyNotifContract.Presenter
    public final void PlaceComponentResult(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.BuiltInFictitiousFunctionClassFactory.get().execute(p0, new Function1<CheckCoverageResponse, Unit>() { // from class: id.dana.maintenance.EmergencyNotifPresenter$checkIPificationCoverage$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(CheckCoverageResponse checkCoverageResponse) {
                invoke2(checkCoverageResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(CheckCoverageResponse checkCoverageResponse) {
                Intrinsics.checkNotNullParameter(checkCoverageResponse, "");
                EmergencyNotifPresenter.this.BuiltInFictitiousFunctionClassFactory(p0, checkCoverageResponse.getSuccess());
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.maintenance.EmergencyNotifPresenter$checkIPificationCoverage$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                EmergencyNotifPresenter.this.BuiltInFictitiousFunctionClassFactory(p0, false);
            }
        });
    }

    public final void BuiltInFictitiousFunctionClassFactory(String p0, boolean p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2.execute(new CheckRegistrationRequest(p0, "", "", "", null, false, Boolean.valueOf(p1), false, 176, null), new Function1<CheckRegistrationResponse, Unit>() { // from class: id.dana.maintenance.EmergencyNotifPresenter$checkPhoneNumber$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(CheckRegistrationResponse checkRegistrationResponse) {
                invoke2(checkRegistrationResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(CheckRegistrationResponse checkRegistrationResponse) {
                EmergencyNotifContract.View view;
                Intrinsics.checkNotNullParameter(checkRegistrationResponse, "");
                view = EmergencyNotifPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                view.moveToNextValue();
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.maintenance.EmergencyNotifPresenter$checkPhoneNumber$2
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
                EmergencyNotifContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                if (th instanceof NetworkException) {
                    view = EmergencyNotifPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    view.moveToNextValue();
                    return;
                }
                final EmergencyNotifPresenter emergencyNotifPresenter = EmergencyNotifPresenter.this;
                emergencyNotifPresenter.getAuthRequestContext.execute(NoParams.INSTANCE, new Function1<EmergencyNotificationConfig, Unit>() { // from class: id.dana.maintenance.EmergencyNotifPresenter$checkEmergencyNotifFeature$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(EmergencyNotificationConfig emergencyNotificationConfig) {
                        invoke2(emergencyNotificationConfig);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(EmergencyNotificationConfig emergencyNotificationConfig) {
                        EmergencyNotifContract.View view2;
                        EmergencyNotifContract.View view3;
                        Intrinsics.checkNotNullParameter(emergencyNotificationConfig, "");
                        if (emergencyNotificationConfig.getEnable()) {
                            view3 = EmergencyNotifPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                            view3.getAuthRequestContext(emergencyNotificationConfig);
                            return;
                        }
                        view2 = EmergencyNotifPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                        view2.KClassImpl$Data$declaredNonStaticMembers$2();
                    }
                }, new Function1<Throwable, Unit>() { // from class: id.dana.maintenance.EmergencyNotifPresenter$checkEmergencyNotifFeature$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(Throwable th2) {
                        invoke2(th2);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable th2) {
                        EmergencyNotifContract.View view2;
                        Intrinsics.checkNotNullParameter(th2, "");
                        view2 = EmergencyNotifPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                        view2.KClassImpl$Data$declaredNonStaticMembers$2();
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void KClassImpl$Data$declaredNonStaticMembers$2(EmergencyState p0) {
        int i = WhenMappings.KClassImpl$Data$declaredNonStaticMembers$2[p0.ordinal()];
        if (i == 1) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.PlaceComponentResult();
        } else if (i == 2) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.MyBillsEntityDataFactory();
        } else if (i == 3) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2();
        } else if (i == 4) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.BuiltInFictitiousFunctionClassFactory();
        } else {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext();
        }
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.getAuthRequestContext.dispose();
        this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
        this.BuiltInFictitiousFunctionClassFactory.get().dispose();
    }
}
