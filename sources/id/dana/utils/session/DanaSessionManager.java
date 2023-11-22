package id.dana.utils.session;

import android.content.Context;
import com.appsflyer.AppsFlyerLib;
import dagger.Lazy;
import id.dana.DanaApplication;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.danapoly.domain.clear.interactor.ClearAllDanapolyData;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.domain.DefaultObserver;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.CompletableUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.login.interactor.ForceLogout;
import id.dana.domain.login.interactor.Logout;
import id.dana.domain.services.interactor.ClearCacheFavoriteServices;
import id.dana.electronicmoney.RxEmoneyBus;
import id.dana.feeds.domain.activation.ClearAllFeedsUsecase;
import id.dana.kyb.domain.interactor.ClearKybData;
import id.dana.riskChallenges.ui.passkey.launcher.enrollment.EnrollPasskeyLauncher;
import id.dana.social.utils.SaveContactSyncManagerKt;
import id.dana.social.utils.SocialSyncManagerKt;
import id.dana.social.utils.SyncContactsEngineWorker;
import id.dana.sync_engine.domain.interactor.ClearAllSyncEngineUseCase;
import id.dana.sync_engine.permission.workmanager.SyncPermissionWorker;
import id.dana.tracker.EventConfig;
import id.dana.tracker.EventConfigFactory;
import id.dana.tracker.EventConfigProperty;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.tracker.constant.TrackerType;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import id.dana.utils.log.CrashlyticsLogUtil;
import id.dana.utils.session.DanaSessionManager;
import java.util.Iterator;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001*B{\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0016\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u001a0\f\u0012\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001c0\f\u0012\u0006\u0010\"\u001a\u00020\u001e\u0012\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00130\f\u0012\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00100\f\u0012\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00140\f\u0012\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00150\f¢\u0006\u0004\b(\u0010)J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J1\u0010\u0005\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00020\bH\u0016¢\u0006\u0004\b\u0005\u0010\u000bJ1\u0010\u0003\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00020\bH\u0016¢\u0006\u0004\b\u0003\u0010\u000bR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000fR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00140\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000fR\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00150\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u000fR\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u000fR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u000fR\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 "}, d2 = {"Lid/dana/utils/session/DanaSessionManager;", "Lid/dana/utils/session/SessionManager;", "", "BuiltInFictitiousFunctionClassFactory", "()V", "getAuthRequestContext", "Lkotlin/Function0;", "p0", "Lkotlin/Function1;", "", "p1", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "Ldagger/Lazy;", "Lid/dana/danapoly/domain/clear/interactor/ClearAllDanapolyData;", "PlaceComponentResult", "Ldagger/Lazy;", "Lid/dana/feeds/domain/activation/ClearAllFeedsUsecase;", "MyBillsEntityDataFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/sync_engine/domain/interactor/ClearAllSyncEngineUseCase;", "Lid/dana/domain/services/interactor/ClearCacheFavoriteServices;", "Lid/dana/kyb/domain/interactor/ClearKybData;", "Landroid/content/Context;", "getErrorConfigVersion", "Landroid/content/Context;", "scheduleImpl", "Lid/dana/data/config/DeviceInformationProvider;", "moveToNextValue", "Lid/dana/domain/login/interactor/ForceLogout;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/domain/login/interactor/Logout;", "lookAheadTest", "Lid/dana/domain/login/interactor/Logout;", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "<init>", "(Landroid/content/Context;Ldagger/Lazy;Ldagger/Lazy;Lid/dana/domain/login/interactor/Logout;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;)V", "Type"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DanaSessionManager implements SessionManager {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Lazy<ClearAllSyncEngineUseCase> MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Lazy<ClearKybData> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Lazy<ClearAllFeedsUsecase> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Lazy<ClearAllDanapolyData> PlaceComponentResult;
    private final Lazy<ClearCacheFavoriteServices> getAuthRequestContext;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final Context scheduleImpl;
    private final Logout lookAheadTest;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final Lazy<ForceLogout> NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final Lazy<DeviceInformationProvider> moveToNextValue;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005"}, d2 = {"Lid/dana/utils/session/DanaSessionManager$Type;", "", "<init>", "(Ljava/lang/String;I)V", "NORMAL", "FORCE"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public enum Type {
        NORMAL,
        FORCE
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] getAuthRequestContext;

        static {
            int[] iArr = new int[Type.values().length];
            iArr[Type.NORMAL.ordinal()] = 1;
            iArr[Type.FORCE.ordinal()] = 2;
            getAuthRequestContext = iArr;
        }
    }

    @Inject
    public DanaSessionManager(Context context, Lazy<DeviceInformationProvider> lazy, Lazy<ForceLogout> lazy2, Logout logout, Lazy<ClearAllSyncEngineUseCase> lazy3, Lazy<ClearAllFeedsUsecase> lazy4, Lazy<ClearCacheFavoriteServices> lazy5, Lazy<ClearAllDanapolyData> lazy6, Lazy<ClearKybData> lazy7) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(lazy, "");
        Intrinsics.checkNotNullParameter(lazy2, "");
        Intrinsics.checkNotNullParameter(logout, "");
        Intrinsics.checkNotNullParameter(lazy3, "");
        Intrinsics.checkNotNullParameter(lazy4, "");
        Intrinsics.checkNotNullParameter(lazy5, "");
        Intrinsics.checkNotNullParameter(lazy6, "");
        Intrinsics.checkNotNullParameter(lazy7, "");
        this.scheduleImpl = context;
        this.moveToNextValue = lazy;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = lazy2;
        this.lookAheadTest = logout;
        this.MyBillsEntityDataFactory = lazy3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = lazy4;
        this.getAuthRequestContext = lazy5;
        this.PlaceComponentResult = lazy6;
        this.BuiltInFictitiousFunctionClassFactory = lazy7;
    }

    @Override // id.dana.utils.session.SessionManager
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.get().dispose();
        this.MyBillsEntityDataFactory.get().dispose();
        this.KClassImpl$Data$declaredNonStaticMembers$2.get().dispose();
        this.getAuthRequestContext.get().dispose();
        this.PlaceComponentResult.get().dispose();
        this.BuiltInFictitiousFunctionClassFactory.get().dispose();
        this.lookAheadTest.dispose();
    }

    public static final /* synthetic */ void PlaceComponentResult(DanaSessionManager danaSessionManager, Type type) {
        String str;
        int i = WhenMappings.getAuthRequestContext[type.ordinal()];
        if (i == 1) {
            str = "Normal";
        } else if (i != 2) {
            throw new NoWhenBranchMatchedException();
        } else {
            str = "Force";
        }
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(danaSessionManager.scheduleImpl);
        builder.MyBillsEntityDataFactory = TrackerKey.Event.LOGOUT;
        EventTrackerModel.Builder MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory(TrackerKey.Property.LOGOUT_TYPE, str);
        MyBillsEntityDataFactory.PlaceComponentResult();
        byte b = 0;
        EventTracker.PlaceComponentResult(new EventTrackerModel(MyBillsEntityDataFactory, b));
        EventConfigProperty.Builder builder2 = new EventConfigProperty.Builder();
        builder2.KClassImpl$Data$declaredNonStaticMembers$2 = danaSessionManager.scheduleImpl;
        Iterator<EventConfig> it = EventConfigFactory.getAuthRequestContext(new EventConfigProperty(builder2, b), danaSessionManager.moveToNextValue.get(), TrackerType.MIXPANEL).iterator();
        while (it.hasNext()) {
            it.next().getAuthRequestContext();
        }
    }

    public final void getAuthRequestContext() {
        AppsFlyerLib.getInstance().setCustomerUserId(null);
        Context applicationContext = this.scheduleImpl.getApplicationContext();
        DanaApplication danaApplication = applicationContext instanceof DanaApplication ? (DanaApplication) applicationContext : null;
        if (danaApplication != null) {
            danaApplication.servicesData = null;
        }
        ClearCacheFavoriteServices clearCacheFavoriteServices = this.getAuthRequestContext.get();
        Intrinsics.checkNotNullExpressionValue(clearCacheFavoriteServices, "");
        CompletableUseCase.execute$default(clearCacheFavoriteServices, NoParams.INSTANCE, new Function0<Unit>() { // from class: id.dana.utils.session.DanaSessionManager$clearFavoriteServices$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        }, null, 4, null);
        ClearAllSyncEngineUseCase clearAllSyncEngineUseCase = this.MyBillsEntityDataFactory.get();
        Intrinsics.checkNotNullExpressionValue(clearAllSyncEngineUseCase, "");
        BaseUseCase.executeInBackground$default(clearAllSyncEngineUseCase, NoParams.INSTANCE, new Function1<Unit, Unit>() { // from class: id.dana.utils.session.DanaSessionManager$clearAllForSyncEngine$1
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
        SocialSyncManagerKt.KClassImpl$Data$declaredNonStaticMembers$2(this.scheduleImpl);
        SyncPermissionWorker.Companion companion = SyncPermissionWorker.INSTANCE;
        SyncPermissionWorker.Companion.getAuthRequestContext(this.scheduleImpl);
        SaveContactSyncManagerKt.KClassImpl$Data$declaredNonStaticMembers$2(this.scheduleImpl);
        SyncContactsEngineWorker.Companion companion2 = SyncContactsEngineWorker.INSTANCE;
        SyncContactsEngineWorker.Companion.PlaceComponentResult(this.scheduleImpl);
        ClearAllFeedsUsecase clearAllFeedsUsecase = this.KClassImpl$Data$declaredNonStaticMembers$2.get();
        Intrinsics.checkNotNullExpressionValue(clearAllFeedsUsecase, "");
        BaseUseCase.executeInBackground$default(clearAllFeedsUsecase, NoParams.INSTANCE, new Function1<Unit, Unit>() { // from class: id.dana.utils.session.DanaSessionManager$clearAllFeedsUsecase$1
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
        ClearAllDanapolyData clearAllDanapolyData = this.PlaceComponentResult.get();
        Intrinsics.checkNotNullExpressionValue(clearAllDanapolyData, "");
        BaseUseCase.executeInBackground$default(clearAllDanapolyData, NoParams.INSTANCE, new Function1<Unit, Unit>() { // from class: id.dana.utils.session.DanaSessionManager$clearDanapolyData$1
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
        ClearKybData clearKybData = this.BuiltInFictitiousFunctionClassFactory.get();
        Intrinsics.checkNotNullExpressionValue(clearKybData, "");
        CompletableUseCase.executeInBackground$default(clearKybData, NoParams.INSTANCE, new Function0<Unit>() { // from class: id.dana.utils.session.DanaSessionManager$clearKybData$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        }, null, 4, null);
        EnrollPasskeyLauncher.Companion companion3 = EnrollPasskeyLauncher.INSTANCE;
        EnrollPasskeyLauncher.Companion.MyBillsEntityDataFactory(this.scheduleImpl);
        RxEmoneyBus.PlaceComponentResult().onNext(Boolean.FALSE);
    }

    @Override // id.dana.utils.session.SessionManager
    public final void getAuthRequestContext(final Function0<Unit> p0, final Function1<? super Throwable, Unit> p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.get().execute(new DefaultObserver<Boolean>() { // from class: id.dana.utils.session.DanaSessionManager$doForceLogout$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                Boolean bool = (Boolean) obj;
                DanaSessionManager.PlaceComponentResult(DanaSessionManager.this, DanaSessionManager.Type.FORCE);
                DanaSessionManager.this.getAuthRequestContext();
                p0.invoke();
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p02) {
                Intrinsics.checkNotNullParameter(p02, "");
                DanaSessionManager.PlaceComponentResult(DanaSessionManager.this, DanaSessionManager.Type.FORCE);
                DanaSessionManager.this.getAuthRequestContext();
                p1.invoke(p02);
            }
        });
    }

    @Override // id.dana.utils.session.SessionManager
    public final void BuiltInFictitiousFunctionClassFactory(final Function0<Unit> p0, final Function1<? super Throwable, Unit> p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        this.lookAheadTest.execute(new DefaultObserver<Boolean>() { // from class: id.dana.utils.session.DanaSessionManager$doLogout$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                Boolean bool = (Boolean) obj;
                DanaSessionManager.PlaceComponentResult(DanaSessionManager.this, DanaSessionManager.Type.NORMAL);
                DanaSessionManager.this.getAuthRequestContext();
                p0.invoke();
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p02) {
                Intrinsics.checkNotNullParameter(p02, "");
                CrashlyticsLogUtil.BuiltInFictitiousFunctionClassFactory("logout", DanaLogConstants.ExceptionType.LOGOUT_EXCEPTION, p02);
                p1.invoke(p02);
            }
        });
    }
}
