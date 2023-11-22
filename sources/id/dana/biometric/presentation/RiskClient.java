package id.dana.biometric.presentation;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import id.dana.biometric.domain.interactor.GetAccelerometerData;
import id.dana.biometric.domain.interactor.GetGyroscopeData;
import id.dana.biometric.domain.model.RiskTrackerConfig;
import id.dana.biometric.domain.model.RiskType;
import id.dana.biometric.domain.model.ScoringDeviceModel;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.utils.foundation.logger.log.DanaLog;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.subjects.BehaviorSubject;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 -2\u00020\u0001:\u0001-B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u001c¢\u0006\u0004\b+\u0010,J!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\t2\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0011\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0013\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0015\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0015\u0010\u0014R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0002X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u000e\u0010\u0016R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0017R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0014\u0010\u0013\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\f\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u0002X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\f\u0010\u0016R\u0016\u0010 \u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u001fR\u0018\u0010!\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020$0#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010%R\u0013\u0010'\u001a\u00020&X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b'\u0010\u0016R\u0012\u0010)\u001a\u00020(X\u0087\"¢\u0006\u0006\n\u0004\b)\u0010*"}, d2 = {"Lid/dana/biometric/presentation/RiskClient;", "Landroid/hardware/SensorEventListener;", "Landroid/hardware/Sensor;", "p0", "", "p1", "", "onAccuracyChanged", "(Landroid/hardware/Sensor;I)V", "", "Lkotlin/Function1;", "", "MyBillsEntityDataFactory", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getAuthRequestContext", "(Ljava/lang/String;)V", "Landroid/hardware/SensorEvent;", "onSensorChanged", "(Landroid/hardware/SensorEvent;)V", "BuiltInFictitiousFunctionClassFactory", "(Landroid/hardware/Sensor;)V", "PlaceComponentResult", "Lkotlin/Lazy;", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lio/reactivex/disposables/CompositeDisposable;", "lookAheadTest", "Lio/reactivex/disposables/CompositeDisposable;", "Landroid/content/Context;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Landroid/content/Context;", "Z", "scheduleImpl", "moveToNextValue", "Ljava/lang/Integer;", "Lio/reactivex/subjects/BehaviorSubject;", "Lid/dana/biometric/presentation/RiskTrackerState;", "Lio/reactivex/subjects/BehaviorSubject;", "Landroid/hardware/SensorManager;", "getErrorConfigVersion", "Lid/dana/biometric/presentation/RiskTrackerPresenter;", "trackerPresenter", "Lid/dana/biometric/presentation/RiskTrackerPresenter;", "<init>", "(Landroid/content/Context;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RiskClient implements SensorEventListener {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    boolean scheduleImpl;
    String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    final Lazy NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final Context MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    String getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    final Lazy PlaceComponentResult;
    private final Lazy getErrorConfigVersion;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final CompositeDisposable BuiltInFictitiousFunctionClassFactory;
    Integer moveToNextValue;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    final BehaviorSubject<RiskTrackerState> lookAheadTest;
    @Inject
    public RiskTrackerPresenter trackerPresenter;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] BuiltInFictitiousFunctionClassFactory;

        static {
            int[] iArr = new int[RiskType.values().length];
            iArr[RiskType.GYROSCOPE.ordinal()] = 1;
            iArr[RiskType.ACCELEROMETER.ordinal()] = 2;
            BuiltInFictitiousFunctionClassFactory = iArr;
        }
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor p0, int p1) {
    }

    @Inject
    public RiskClient(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.MyBillsEntityDataFactory = context;
        this.getErrorConfigVersion = LazyKt.lazy(new Function0<SensorManager>() { // from class: id.dana.biometric.presentation.RiskClient$sensorManager$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SensorManager invoke() {
                Context context2;
                context2 = RiskClient.this.MyBillsEntityDataFactory;
                Object systemService = context2.getSystemService("sensor");
                if (systemService != null) {
                    return (SensorManager) systemService;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.hardware.SensorManager");
            }
        });
        this.PlaceComponentResult = LazyKt.lazy(new Function0<Sensor>() { // from class: id.dana.biometric.presentation.RiskClient$accelerometerSensor$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Sensor invoke() {
                return RiskClient.getAuthRequestContext(RiskClient.this).getDefaultSensor(1);
            }
        });
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = LazyKt.lazy(new Function0<Sensor>() { // from class: id.dana.biometric.presentation.RiskClient$gyroscopeSensor$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Sensor invoke() {
                return RiskClient.getAuthRequestContext(RiskClient.this).getDefaultSensor(4);
            }
        });
        BehaviorSubject<RiskTrackerState> authRequestContext = BehaviorSubject.getAuthRequestContext(new RiskTrackerState(null, null, null, 7, null));
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        this.lookAheadTest = authRequestContext;
        this.BuiltInFictitiousFunctionClassFactory = new CompositeDisposable();
    }

    public final void MyBillsEntityDataFactory(String p0, final Function1<? super Boolean, Unit> p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        RiskTrackerPresenter riskTrackerPresenter = null;
        if (!Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, p0)) {
            RiskTrackerPresenter riskTrackerPresenter2 = this.trackerPresenter;
            if (riskTrackerPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                riskTrackerPresenter2 = null;
            }
            BaseUseCase.execute$default(riskTrackerPresenter2.PlaceComponentResult, NoParams.INSTANCE, new Function1<Unit, Unit>() { // from class: id.dana.biometric.presentation.RiskTrackerPresenter$onClearData$1
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
            this.KClassImpl$Data$declaredNonStaticMembers$2 = p0;
        }
        if (!this.lookAheadTest.PlaceComponentResult()) {
            this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(this.lookAheadTest.subscribe(new Consumer() { // from class: id.dana.biometric.presentation.RiskClient$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    RiskClient.MyBillsEntityDataFactory(RiskClient.this, (RiskTrackerState) obj);
                }
            }));
        }
        Object obj = this.lookAheadTest.getErrorConfigVersion.get();
        RiskTrackerState riskTrackerState = (RiskTrackerState) ((NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) ? null : NotificationLite.getValue(obj));
        if ((riskTrackerState != null ? riskTrackerState.getAuthRequestContext : null) == null) {
            RiskTrackerPresenter riskTrackerPresenter3 = this.trackerPresenter;
            if (riskTrackerPresenter3 != null) {
                riskTrackerPresenter = riskTrackerPresenter3;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            final Function1<RiskTrackerConfig, Unit> function1 = new Function1<RiskTrackerConfig, Unit>() { // from class: id.dana.biometric.presentation.RiskClient$onPageStart$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(RiskTrackerConfig riskTrackerConfig) {
                    invoke2(riskTrackerConfig);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(RiskTrackerConfig riskTrackerConfig) {
                    BehaviorSubject behaviorSubject;
                    BehaviorSubject behaviorSubject2;
                    Intrinsics.checkNotNullParameter(riskTrackerConfig, "");
                    behaviorSubject = RiskClient.this.lookAheadTest;
                    Object obj2 = behaviorSubject.getErrorConfigVersion.get();
                    RiskTrackerState riskTrackerState2 = (RiskTrackerState) ((NotificationLite.isComplete(obj2) || NotificationLite.isError(obj2)) ? null : NotificationLite.getValue(obj2));
                    if (riskTrackerState2 != null) {
                        behaviorSubject2 = RiskClient.this.lookAheadTest;
                        behaviorSubject2.onNext(RiskTrackerState.getAuthRequestContext(riskTrackerState2, riskTrackerConfig, null, null, 6));
                    }
                    Function1<Boolean, Unit> function12 = p1;
                    if (function12 != null) {
                        function12.invoke(Boolean.valueOf(riskTrackerConfig.getPlaceComponentResult()));
                    }
                }
            };
            Intrinsics.checkNotNullParameter(function1, "");
            BaseUseCase.execute$default(riskTrackerPresenter.BuiltInFictitiousFunctionClassFactory, NoParams.INSTANCE, new Function1<RiskTrackerConfig, Unit>() { // from class: id.dana.biometric.presentation.RiskTrackerPresenter$getRiskTrackerConfig$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(RiskTrackerConfig riskTrackerConfig) {
                    invoke2(riskTrackerConfig);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(RiskTrackerConfig riskTrackerConfig) {
                    Intrinsics.checkNotNullParameter(riskTrackerConfig, "");
                    function1.invoke(riskTrackerConfig);
                }
            }, null, 4, null);
        }
    }

    public final void getAuthRequestContext(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.getAuthRequestContext = p0;
        Object obj = this.lookAheadTest.getErrorConfigVersion.get();
        RiskTrackerState riskTrackerState = (RiskTrackerState) ((NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) ? null : NotificationLite.getValue(obj));
        if (riskTrackerState != null) {
            this.lookAheadTest.onNext(RiskTrackerState.getAuthRequestContext(riskTrackerState, null, p0, new RiskClient$onPageTrack$1$1(this), 1));
        }
    }

    private final void BuiltInFictitiousFunctionClassFactory(Sensor p0) {
        if (p0 == null) {
            DanaLog.PlaceComponentResult("RiskClient", "Unknown error when trying to get the sensor device");
        } else {
            ((SensorManager) this.getErrorConfigVersion.getValue()).registerListener(this, p0, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void PlaceComponentResult(Sensor p0) {
        if (p0 == null) {
            DanaLog.PlaceComponentResult("RiskClient", "Unknown error when trying to get the sensor device");
        } else {
            ((SensorManager) this.getErrorConfigVersion.getValue()).unregisterListener(this, p0);
        }
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent p0) {
        RiskTrackerPresenter riskTrackerPresenter;
        RiskTrackerPresenter riskTrackerPresenter2;
        if (p0 == null) {
            return;
        }
        Sensor sensor = p0.sensor;
        Integer valueOf = sensor != null ? Integer.valueOf(sensor.getType()) : null;
        if (valueOf == null || valueOf.intValue() != 1) {
            if (valueOf == null || valueOf.intValue() != 4) {
                return;
            }
            RiskTrackerPresenter riskTrackerPresenter3 = this.trackerPresenter;
            if (riskTrackerPresenter3 != null) {
                riskTrackerPresenter = riskTrackerPresenter3;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
                riskTrackerPresenter = null;
            }
            String str = this.KClassImpl$Data$declaredNonStaticMembers$2;
            String str2 = str == null ? "" : str;
            String str3 = this.getAuthRequestContext;
            RiskTrackerPresenter.BuiltInFictitiousFunctionClassFactory(riskTrackerPresenter, str2, str3 == null ? "" : str3, RiskType.GYROSCOPE, p0.values[0], p0.values[1], p0.values[2], System.currentTimeMillis(), new Function0<Unit>() { // from class: id.dana.biometric.presentation.RiskClient$onSensorChanged$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    RiskClient riskClient = RiskClient.this;
                    RiskClient.PlaceComponentResult(riskClient, RiskClient.BuiltInFictitiousFunctionClassFactory(riskClient));
                }
            }, false, 256);
            return;
        }
        RiskTrackerPresenter riskTrackerPresenter4 = this.trackerPresenter;
        if (riskTrackerPresenter4 != null) {
            riskTrackerPresenter2 = riskTrackerPresenter4;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
            riskTrackerPresenter2 = null;
        }
        String str4 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        String str5 = str4 == null ? "" : str4;
        String str6 = this.getAuthRequestContext;
        RiskTrackerPresenter.BuiltInFictitiousFunctionClassFactory(riskTrackerPresenter2, str5, str6 == null ? "" : str6, RiskType.ACCELEROMETER, p0.values[0], p0.values[1], p0.values[2], System.currentTimeMillis(), new Function0<Unit>() { // from class: id.dana.biometric.presentation.RiskClient$onSensorChanged$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                RiskClient riskClient = RiskClient.this;
                RiskClient.PlaceComponentResult(riskClient, RiskClient.KClassImpl$Data$declaredNonStaticMembers$2(riskClient));
            }
        }, false, 256);
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(RiskClient riskClient, RiskTrackerState riskTrackerState) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(riskClient, "");
        if (riskTrackerState.getAuthRequestContext == null || riskTrackerState.BuiltInFictitiousFunctionClassFactory == null) {
            return;
        }
        RiskTrackerConfig riskTrackerConfig = riskTrackerState.getAuthRequestContext;
        boolean z = false;
        if ((riskTrackerConfig == null || riskTrackerConfig.getPlaceComponentResult()) ? false : true) {
            return;
        }
        RiskTrackerConfig riskTrackerConfig2 = riskTrackerState.getAuthRequestContext;
        RiskTrackerPresenter riskTrackerPresenter = null;
        riskClient.moveToNextValue = riskTrackerConfig2 != null ? Integer.valueOf(riskTrackerConfig2.BuiltInFictitiousFunctionClassFactory) : null;
        RiskTrackerConfig riskTrackerConfig3 = riskTrackerState.getAuthRequestContext;
        if ((riskTrackerConfig3 != null && riskTrackerConfig3.getMyBillsEntityDataFactory()) && (str2 = riskTrackerState.BuiltInFictitiousFunctionClassFactory) != null) {
            RiskTrackerPresenter riskTrackerPresenter2 = riskClient.trackerPresenter;
            if (riskTrackerPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                riskTrackerPresenter2 = null;
            }
            final Function1<? super RiskType, Unit> function1 = riskTrackerState.PlaceComponentResult;
            Intrinsics.checkNotNullParameter(str2, "");
            BaseUseCase.execute$default(riskTrackerPresenter2.MyBillsEntityDataFactory, new GetGyroscopeData.Params(str2), new Function1<ScoringDeviceModel, Unit>() { // from class: id.dana.biometric.presentation.RiskTrackerPresenter$startGyroscope$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(ScoringDeviceModel scoringDeviceModel) {
                    invoke2(scoringDeviceModel);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(ScoringDeviceModel scoringDeviceModel) {
                    Function1<RiskType, Unit> function12;
                    Intrinsics.checkNotNullParameter(scoringDeviceModel, "");
                    if (scoringDeviceModel.getAuthRequestContext.size() == 100 || (function12 = function1) == null) {
                        return;
                    }
                    function12.invoke(RiskType.GYROSCOPE);
                }
            }, null, 4, null);
        }
        RiskTrackerConfig riskTrackerConfig4 = riskTrackerState.getAuthRequestContext;
        if ((riskTrackerConfig4 != null && riskTrackerConfig4.getKClassImpl$Data$declaredNonStaticMembers$2()) && (str = riskTrackerState.BuiltInFictitiousFunctionClassFactory) != null) {
            RiskTrackerPresenter riskTrackerPresenter3 = riskClient.trackerPresenter;
            if (riskTrackerPresenter3 != null) {
                riskTrackerPresenter = riskTrackerPresenter3;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            final Function1<? super RiskType, Unit> function12 = riskTrackerState.PlaceComponentResult;
            Intrinsics.checkNotNullParameter(str, "");
            BaseUseCase.execute$default(riskTrackerPresenter.getAuthRequestContext, new GetAccelerometerData.Params(str), new Function1<ScoringDeviceModel, Unit>() { // from class: id.dana.biometric.presentation.RiskTrackerPresenter$startAccelerometer$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(ScoringDeviceModel scoringDeviceModel) {
                    invoke2(scoringDeviceModel);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(ScoringDeviceModel scoringDeviceModel) {
                    Function1<RiskType, Unit> function13;
                    Intrinsics.checkNotNullParameter(scoringDeviceModel, "");
                    if (scoringDeviceModel.getAuthRequestContext.size() == 100 || (function13 = function12) == null) {
                        return;
                    }
                    function13.invoke(RiskType.ACCELEROMETER);
                }
            }, null, 4, null);
        }
        RiskTrackerConfig riskTrackerConfig5 = riskTrackerState.getAuthRequestContext;
        if (riskTrackerConfig5 != null && riskTrackerConfig5.getGetAuthRequestContext()) {
            z = true;
        }
        if (z) {
            riskClient.scheduleImpl = true;
        }
    }

    public static final /* synthetic */ Sensor KClassImpl$Data$declaredNonStaticMembers$2(RiskClient riskClient) {
        return (Sensor) riskClient.PlaceComponentResult.getValue();
    }

    public static final /* synthetic */ Sensor BuiltInFictitiousFunctionClassFactory(RiskClient riskClient) {
        return (Sensor) riskClient.NetworkUserEntityData$$ExternalSyntheticLambda0.getValue();
    }

    public static final /* synthetic */ SensorManager getAuthRequestContext(RiskClient riskClient) {
        return (SensorManager) riskClient.getErrorConfigVersion.getValue();
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(RiskClient riskClient, RiskType riskType) {
        int i = WhenMappings.BuiltInFictitiousFunctionClassFactory[riskType.ordinal()];
        if (i == 1) {
            riskClient.BuiltInFictitiousFunctionClassFactory((Sensor) riskClient.NetworkUserEntityData$$ExternalSyntheticLambda0.getValue());
        } else if (i == 2) {
            riskClient.BuiltInFictitiousFunctionClassFactory((Sensor) riskClient.PlaceComponentResult.getValue());
        }
    }

    public static final /* synthetic */ void PlaceComponentResult(RiskClient riskClient, Sensor sensor) {
        if (sensor == null) {
            DanaLog.PlaceComponentResult("RiskClient", "Unknown error when trying to get the sensor device");
        } else {
            ((SensorManager) riskClient.getErrorConfigVersion.getValue()).unregisterListener(riskClient, sensor);
        }
    }
}
