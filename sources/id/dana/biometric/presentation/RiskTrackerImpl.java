package id.dana.biometric.presentation;

import android.app.Activity;
import android.app.Application;
import android.hardware.Sensor;
import androidx.fragment.app.FragmentActivity;
import androidx.view.Lifecycle;
import com.alipay.zoloz.toyger.blob.BlobStatic;
import dagger.Lazy;
import id.dana.biometric.domain.model.BiometricDataSize;
import id.dana.biometric.domain.model.RiskActionConstant;
import id.dana.biometric.domain.model.RiskEventMapper;
import id.dana.biometric.domain.model.RiskTrackerConfig;
import id.dana.biometric.domain.model.RiskType;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.utils.foundation.logger.log.DanaLog;
import io.reactivex.internal.util.NotificationLite;
import java.lang.ref.WeakReference;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.concurrent.ThreadsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0017\b\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017¢\u0006\u0004\b \u0010!J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J#\u0010\t\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0016¢\u0006\u0004\b\t\u0010\nJI\u0010\u0011\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\f2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\t\u0010\u0014R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0019R\u0016\u0010\t\u001a\u00020\u001a8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0011\u0010\u001bR\u001e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f"}, d2 = {"Lid/dana/biometric/presentation/RiskTrackerImpl;", "Lid/dana/biometric/presentation/RiskTracker;", "", "BuiltInFictitiousFunctionClassFactory", "()I", "Lkotlin/Function1;", "Lid/dana/biometric/domain/model/BiometricDataSize;", "", "p0", "MyBillsEntityDataFactory", "(Lkotlin/jvm/functions/Function1;)V", "", "Lkotlin/Function0;", "p1", "p2", "", "p3", "getAuthRequestContext", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "Lid/dana/biometric/domain/model/RiskEventMapper;", "(Lid/dana/biometric/domain/model/RiskEventMapper;)V", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "Ldagger/Lazy;", "Lid/dana/biometric/presentation/RiskClient;", "Ldagger/Lazy;", "Lid/dana/biometric/presentation/RiskLifecycleCallback;", "Lid/dana/biometric/presentation/RiskLifecycleCallback;", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "PlaceComponentResult", "Ljava/lang/ref/WeakReference;", "<init>", "(Ldagger/Lazy;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RiskTrackerImpl implements RiskTracker {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Lazy<RiskClient> getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private WeakReference<Activity> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private RiskLifecycleCallback MyBillsEntityDataFactory;

    @Inject
    public RiskTrackerImpl(Lazy<RiskClient> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "");
        this.getAuthRequestContext = lazy;
    }

    @Override // id.dana.biometric.presentation.RiskTracker
    public final void getAuthRequestContext(String p0, Function0<Unit> p1, Function0<Unit> p2, Function1<? super Boolean, Unit> p3) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        if (!Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, p0)) {
            p1.invoke();
            this.getAuthRequestContext.get().MyBillsEntityDataFactory(p0, p3);
            p2.invoke();
        } else {
            this.getAuthRequestContext.get().MyBillsEntityDataFactory(p0, p3);
        }
        this.BuiltInFictitiousFunctionClassFactory = p0;
    }

    @Override // id.dana.biometric.presentation.RiskTracker
    public final int BuiltInFictitiousFunctionClassFactory() {
        Integer num = this.getAuthRequestContext.get().moveToNextValue;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // id.dana.biometric.presentation.RiskTracker
    public final void MyBillsEntityDataFactory(final Function1<? super BiometricDataSize, Unit> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        ThreadsKt.thread((r12 & 1) != 0, (r12 & 2) != 0 ? false : false, (r12 & 4) != 0 ? null : null, (r12 & 8) != 0 ? null : null, (r12 & 16) != 0 ? -1 : 0, new Function0<Unit>() { // from class: id.dana.biometric.presentation.RiskTrackerImpl$onPageEndAndZip$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                Lazy lazy;
                RiskTrackerConfig riskTrackerConfig;
                lazy = RiskTrackerImpl.this.getAuthRequestContext;
                RiskClient riskClient = (RiskClient) lazy.get();
                final Function1<BiometricDataSize, Unit> function1 = p0;
                Intrinsics.checkNotNullParameter(function1, "");
                Object obj = null;
                riskClient.KClassImpl$Data$declaredNonStaticMembers$2 = null;
                riskClient.getAuthRequestContext = null;
                riskClient.PlaceComponentResult((Sensor) riskClient.PlaceComponentResult.getValue());
                riskClient.PlaceComponentResult((Sensor) riskClient.NetworkUserEntityData$$ExternalSyntheticLambda0.getValue());
                RiskTrackerPresenter riskTrackerPresenter = riskClient.trackerPresenter;
                if (riskTrackerPresenter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    riskTrackerPresenter = null;
                }
                Object obj2 = riskClient.lookAheadTest.getErrorConfigVersion.get();
                if (!NotificationLite.isComplete(obj2) && !NotificationLite.isError(obj2)) {
                    obj = NotificationLite.getValue(obj2);
                }
                RiskTrackerState riskTrackerState = (RiskTrackerState) obj;
                boolean placeComponentResult = (riskTrackerState == null || (riskTrackerConfig = riskTrackerState.getAuthRequestContext) == null) ? false : riskTrackerConfig.getPlaceComponentResult();
                Intrinsics.checkNotNullParameter(function1, "");
                if (placeComponentResult) {
                    BaseUseCase.execute$default(riskTrackerPresenter.KClassImpl$Data$declaredNonStaticMembers$2, NoParams.INSTANCE, new Function1<BiometricDataSize, Unit>() { // from class: id.dana.biometric.presentation.RiskTrackerPresenter$onPageEndAndZip$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(BiometricDataSize biometricDataSize) {
                            invoke2(biometricDataSize);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(BiometricDataSize biometricDataSize) {
                            Intrinsics.checkNotNullParameter(biometricDataSize, "");
                            function1.invoke(biometricDataSize);
                        }
                    }, null, 4, null);
                }
            }
        });
    }

    @Override // id.dana.biometric.presentation.RiskTracker
    public final void MyBillsEntityDataFactory(RiskEventMapper p0) {
        RiskTrackerPresenter riskTrackerPresenter;
        Application application;
        Activity activity;
        Application application2;
        Class<?> cls;
        Activity activity2;
        Class<?> cls2;
        Application application3;
        Lifecycle lifecycle;
        Intrinsics.checkNotNullParameter(p0, "");
        String str = p0.MyBillsEntityDataFactory;
        RiskLifecycleCallback riskLifecycleCallback = null;
        if (!Intrinsics.areEqual(str, RiskActionConstant.ON_PAGE_TRACK)) {
            if (Intrinsics.areEqual(str, RiskActionConstant.ON_TOUCH)) {
                String str2 = p0.getAuthRequestContext;
                float f = p0.moveToNextValue;
                float f2 = p0.scheduleImpl;
                long j = p0.BuiltInFictitiousFunctionClassFactory;
                RiskClient riskClient = this.getAuthRequestContext.get();
                Intrinsics.checkNotNullParameter(str2, "");
                RiskTrackerPresenter riskTrackerPresenter2 = riskClient.trackerPresenter;
                if (riskTrackerPresenter2 != null) {
                    riskTrackerPresenter = riskTrackerPresenter2;
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    riskTrackerPresenter = null;
                }
                String str3 = riskClient.KClassImpl$Data$declaredNonStaticMembers$2;
                RiskTrackerPresenter.BuiltInFictitiousFunctionClassFactory(riskTrackerPresenter, str3 == null ? "" : str3, str2, RiskType.KEYSTROKE, f, f2, 0.0f, j, null, riskClient.scheduleImpl, BlobStatic.MONITOR_IMAGE_WIDTH);
                return;
            }
            return;
        }
        final String str4 = p0.getAuthRequestContext;
        FragmentActivity fragmentActivity = p0.KClassImpl$Data$declaredNonStaticMembers$2;
        Lifecycle.State PlaceComponentResult = (fragmentActivity == null || (lifecycle = fragmentActivity.getLifecycle()) == null) ? null : lifecycle.PlaceComponentResult();
        Boolean valueOf = PlaceComponentResult != null ? Boolean.valueOf(PlaceComponentResult.isAtLeast(Lifecycle.State.STARTED)) : null;
        final boolean z = PlaceComponentResult == Lifecycle.State.RESUMED;
        if (Intrinsics.areEqual(valueOf, Boolean.FALSE)) {
            DanaLog.BuiltInFictitiousFunctionClassFactory("RiskTracker", "Tracker should be started after onStart call and right before onPause call");
            return;
        }
        this.getAuthRequestContext.get().getAuthRequestContext(str4);
        FragmentActivity fragmentActivity2 = fragmentActivity;
        this.MyBillsEntityDataFactory = new RiskLifecycleCallback(new Function0<Unit>() { // from class: id.dana.biometric.presentation.RiskTrackerImpl$onPageTrack$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                Lazy lazy;
                if (z) {
                    lazy = this.getAuthRequestContext;
                    ((RiskClient) lazy.get()).getAuthRequestContext(str4);
                }
            }
        }, new Function0<Unit>() { // from class: id.dana.biometric.presentation.RiskTrackerImpl$onPageTrack$2
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
                Lazy lazy;
                lazy = RiskTrackerImpl.this.getAuthRequestContext;
                RiskClient riskClient2 = (RiskClient) lazy.get();
                riskClient2.getAuthRequestContext = null;
                riskClient2.PlaceComponentResult((Sensor) riskClient2.PlaceComponentResult.getValue());
                riskClient2.PlaceComponentResult((Sensor) riskClient2.NetworkUserEntityData$$ExternalSyntheticLambda0.getValue());
                Object obj = riskClient2.lookAheadTest.getErrorConfigVersion.get();
                RiskTrackerState riskTrackerState = (RiskTrackerState) ((NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) ? null : NotificationLite.getValue(obj));
                if (riskTrackerState != null) {
                    riskClient2.lookAheadTest.onNext(RiskTrackerState.getAuthRequestContext(riskTrackerState, null, null, null, 5));
                }
            }
        }, new Function0<Unit>() { // from class: id.dana.biometric.presentation.RiskTrackerImpl$onPageTrack$3
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
                WeakReference weakReference;
                Activity activity3;
                Application application4;
                RiskLifecycleCallback riskLifecycleCallback2;
                weakReference = RiskTrackerImpl.this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (weakReference != null && (activity3 = (Activity) weakReference.get()) != null && (application4 = activity3.getApplication()) != null) {
                    riskLifecycleCallback2 = RiskTrackerImpl.this.MyBillsEntityDataFactory;
                    if (riskLifecycleCallback2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        riskLifecycleCallback2 = null;
                    }
                    application4.unregisterActivityLifecycleCallbacks(riskLifecycleCallback2);
                }
                RiskTrackerImpl.this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
            }
        }, fragmentActivity2);
        WeakReference<Activity> weakReference = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if ((weakReference != null ? weakReference.get() : null) == null) {
            WeakReference<Activity> weakReference2 = new WeakReference<>(fragmentActivity);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = weakReference2;
            Activity activity3 = weakReference2.get();
            if (activity3 == null || (application3 = activity3.getApplication()) == null) {
                return;
            }
            RiskLifecycleCallback riskLifecycleCallback2 = this.MyBillsEntityDataFactory;
            if (riskLifecycleCallback2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                riskLifecycleCallback = riskLifecycleCallback2;
            }
            application3.registerActivityLifecycleCallbacks(riskLifecycleCallback);
            return;
        }
        WeakReference<Activity> weakReference3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (Intrinsics.areEqual((weakReference3 == null || (activity2 = weakReference3.get()) == null || (cls2 = activity2.getClass()) == null) ? null : cls2.getSimpleName(), (fragmentActivity == null || (cls = fragmentActivity.getClass()) == null) ? null : cls.getSimpleName())) {
            return;
        }
        WeakReference<Activity> weakReference4 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (weakReference4 != null && (activity = weakReference4.get()) != null && (application2 = activity.getApplication()) != null) {
            RiskLifecycleCallback riskLifecycleCallback3 = this.MyBillsEntityDataFactory;
            if (riskLifecycleCallback3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                riskLifecycleCallback3 = null;
            }
            application2.unregisterActivityLifecycleCallbacks(riskLifecycleCallback3);
        }
        WeakReference<Activity> weakReference5 = new WeakReference<>(fragmentActivity2);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = weakReference5;
        Activity activity4 = weakReference5.get();
        if (activity4 == null || (application = activity4.getApplication()) == null) {
            return;
        }
        RiskLifecycleCallback riskLifecycleCallback4 = this.MyBillsEntityDataFactory;
        if (riskLifecycleCallback4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            riskLifecycleCallback = riskLifecycleCallback4;
        }
        application.registerActivityLifecycleCallbacks(riskLifecycleCallback);
    }
}
