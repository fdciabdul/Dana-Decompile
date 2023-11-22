package id.dana.danah5.danacicil;

import android.app.Application;
import android.content.Context;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.DanaApplication;
import id.dana.analytics.firebase.Crashlytics;
import id.dana.danah5.base.UrlTransportEventHandler;
import id.dana.data.installedapp.repository.source.model.AppInfoModel;
import id.dana.data.installedapp.repository.source.model.DefaultInstalledApp;
import id.dana.di.component.InstalledAppComponent;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.creditscore.interactor.InsertInstalledAppsCreditScore;
import id.dana.domain.creditscore.model.InsertInstalledAppsScoringData;
import id.dana.domain.installedapp.interactor.IsNeedToSendInstalledApp;
import id.dana.domain.installedapp.interactor.SaveNeedToSendInstalledApp;
import id.dana.lib.gcontainer.GContainer;
import id.dana.utils.android.AppUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 02\u00020\u0001:\u00010B\u0007¢\u0006\u0004\b/\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\n\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\rJ#\u0010\u0014\u001a\u00020\u00132\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\rJ\u000f\u0010\u0017\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\rR\"\u0010\u0019\u001a\u00020\u00188\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0016\u0010 \u001a\u00020\u001f8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b \u0010!R\"\u0010#\u001a\u00020\"8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b#\u0010%\"\u0004\b&\u0010'R\"\u0010)\u001a\u00020(8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010."}, d2 = {"Lid/dana/danah5/danacicil/DanaCicilWebViewEventHandler;", "Lid/dana/danah5/base/UrlTransportEventHandler;", "Landroid/content/Context;", HummerConstants.CONTEXT, "", "checkInstalledApp", "(Landroid/content/Context;)V", "", "Lid/dana/domain/creditscore/model/InsertInstalledAppsScoringData$InstalledAppDataInfo;", "collectedInstalledAppData", "doInsertInstalledAppsCreditScore", "(Ljava/util/List;)V", "doSaveRunWorkerInstalledApp", "()V", "handleInstalledAppWorker", "Lcom/alibaba/ariver/app/api/Page;", "page", "", "url", "", "interceptUrl", "(Lcom/alibaba/ariver/app/api/Page;Ljava/lang/String;)Z", "onFinalized", "onInitialized", "Lid/dana/domain/creditscore/interactor/InsertInstalledAppsCreditScore;", "insertInstalledAppsCreditScore", "Lid/dana/domain/creditscore/interactor/InsertInstalledAppsCreditScore;", "getInsertInstalledAppsCreditScore", "()Lid/dana/domain/creditscore/interactor/InsertInstalledAppsCreditScore;", "setInsertInstalledAppsCreditScore", "(Lid/dana/domain/creditscore/interactor/InsertInstalledAppsCreditScore;)V", "Lid/dana/di/component/InstalledAppComponent;", "installedAppComponent", "Lid/dana/di/component/InstalledAppComponent;", "Lid/dana/domain/installedapp/interactor/IsNeedToSendInstalledApp;", "isNeedToSendInstalledApp", "Lid/dana/domain/installedapp/interactor/IsNeedToSendInstalledApp;", "()Lid/dana/domain/installedapp/interactor/IsNeedToSendInstalledApp;", "setNeedToSendInstalledApp", "(Lid/dana/domain/installedapp/interactor/IsNeedToSendInstalledApp;)V", "Lid/dana/domain/installedapp/interactor/SaveNeedToSendInstalledApp;", "saveNeedToSendInstalledApp", "Lid/dana/domain/installedapp/interactor/SaveNeedToSendInstalledApp;", "getSaveNeedToSendInstalledApp", "()Lid/dana/domain/installedapp/interactor/SaveNeedToSendInstalledApp;", "setSaveNeedToSendInstalledApp", "(Lid/dana/domain/installedapp/interactor/SaveNeedToSendInstalledApp;)V", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DanaCicilWebViewEventHandler extends UrlTransportEventHandler {
    private static final String TAG = "SendDataInstalledApp";
    @Inject
    public InsertInstalledAppsCreditScore insertInstalledAppsCreditScore;
    private InstalledAppComponent installedAppComponent;
    @Inject
    public IsNeedToSendInstalledApp isNeedToSendInstalledApp;
    @Inject
    public SaveNeedToSendInstalledApp saveNeedToSendInstalledApp;

    @JvmName(name = "isNeedToSendInstalledApp")
    public final IsNeedToSendInstalledApp isNeedToSendInstalledApp() {
        IsNeedToSendInstalledApp isNeedToSendInstalledApp = this.isNeedToSendInstalledApp;
        if (isNeedToSendInstalledApp != null) {
            return isNeedToSendInstalledApp;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setNeedToSendInstalledApp")
    public final void setNeedToSendInstalledApp(IsNeedToSendInstalledApp isNeedToSendInstalledApp) {
        Intrinsics.checkNotNullParameter(isNeedToSendInstalledApp, "");
        this.isNeedToSendInstalledApp = isNeedToSendInstalledApp;
    }

    @JvmName(name = "getSaveNeedToSendInstalledApp")
    public final SaveNeedToSendInstalledApp getSaveNeedToSendInstalledApp() {
        SaveNeedToSendInstalledApp saveNeedToSendInstalledApp = this.saveNeedToSendInstalledApp;
        if (saveNeedToSendInstalledApp != null) {
            return saveNeedToSendInstalledApp;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setSaveNeedToSendInstalledApp")
    public final void setSaveNeedToSendInstalledApp(SaveNeedToSendInstalledApp saveNeedToSendInstalledApp) {
        Intrinsics.checkNotNullParameter(saveNeedToSendInstalledApp, "");
        this.saveNeedToSendInstalledApp = saveNeedToSendInstalledApp;
    }

    @JvmName(name = "getInsertInstalledAppsCreditScore")
    public final InsertInstalledAppsCreditScore getInsertInstalledAppsCreditScore() {
        InsertInstalledAppsCreditScore insertInstalledAppsCreditScore = this.insertInstalledAppsCreditScore;
        if (insertInstalledAppsCreditScore != null) {
            return insertInstalledAppsCreditScore;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setInsertInstalledAppsCreditScore")
    public final void setInsertInstalledAppsCreditScore(InsertInstalledAppsCreditScore insertInstalledAppsCreditScore) {
        Intrinsics.checkNotNullParameter(insertInstalledAppsCreditScore, "");
        this.insertInstalledAppsCreditScore = insertInstalledAppsCreditScore;
    }

    @Override // id.dana.danah5.base.UrlTransportEventHandler, com.alibaba.ariver.kernel.api.extension.Extension
    public final void onInitialized() {
        super.onInitialized();
        Application applicationContext = GriverEnv.getApplicationContext();
        if (applicationContext == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.DanaApplication");
        }
        InstalledAppComponent MyBillsEntityDataFactory = ((DanaApplication) applicationContext).provideInstalledAppComponent().MyBillsEntityDataFactory();
        this.installedAppComponent = MyBillsEntityDataFactory;
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0039  */
    @Override // id.dana.danah5.base.UrlTransportEventHandler, com.alibaba.griver.api.common.page.GriverInterceptUrlEvent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean interceptUrl(com.alibaba.ariver.app.api.Page r6, java.lang.String r7) {
        /*
            r5 = this;
            r6 = 0
            if (r7 == 0) goto L3c
            android.net.Uri r7 = android.net.Uri.parse(r7)
            java.lang.String r0 = r7.getPath()
            r1 = 1
            if (r0 == 0) goto L1f
            java.lang.String r2 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            r2 = 2
            r3 = 0
            java.lang.String r4 = "/credit/cicil"
            boolean r0 = kotlin.text.StringsKt.endsWith$default(r0, r4, r6, r2, r3)
            if (r0 != r1) goto L1f
            r0 = 1
            goto L20
        L1f:
            r0 = 0
        L20:
            java.lang.String r7 = r7.getHost()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            if (r7 == 0) goto L30
            boolean r7 = kotlin.text.StringsKt.isBlank(r7)
            if (r7 != 0) goto L30
            r7 = 0
            goto L31
        L30:
            r7 = 1
        L31:
            if (r7 != 0) goto L36
            if (r0 == 0) goto L36
            goto L37
        L36:
            r1 = 0
        L37:
            if (r1 == 0) goto L3c
            r5.handleInstalledAppWorker()
        L3c:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.danah5.danacicil.DanaCicilWebViewEventHandler.interceptUrl(com.alibaba.ariver.app.api.Page, java.lang.String):boolean");
    }

    private final void handleInstalledAppWorker() {
        isNeedToSendInstalledApp().execute(NoParams.INSTANCE, new Function1<Boolean, Unit>() { // from class: id.dana.danah5.danacicil.DanaCicilWebViewEventHandler$handleInstalledAppWorker$1
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
                if (z) {
                    DanaCicilWebViewEventHandler.this.checkInstalledApp(GContainer.getApplicationContext());
                }
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.danah5.danacicil.DanaCicilWebViewEventHandler$handleInstalledAppWorker$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                Crashlytics.Companion companion = Crashlytics.INSTANCE;
                Crashlytics authRequestContext = Crashlytics.Companion.getAuthRequestContext();
                Intrinsics.checkNotNullParameter("case", "");
                Intrinsics.checkNotNullParameter("SendDataInstalledApp", "");
                authRequestContext.getAuthRequestContext.setCustomKey("case", "SendDataInstalledApp");
                Intrinsics.checkNotNullParameter("SendDataInstalledApp isNeedToSendInstalledApp onError", "");
                authRequestContext.getAuthRequestContext.log("SendDataInstalledApp isNeedToSendInstalledApp onError");
                Intrinsics.checkNotNullParameter(th, "");
                authRequestContext.getAuthRequestContext.recordException(th);
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.ExceptionType.INSTALLED_APP, th.getMessage(), th);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkInstalledApp(Context context) {
        try {
            DefaultInstalledApp defaultInstalledApp = DefaultInstalledApp.INSTANCE;
            List<AppInfoModel> BuiltInFictitiousFunctionClassFactory = DefaultInstalledApp.BuiltInFictitiousFunctionClassFactory();
            ArrayList arrayList = new ArrayList();
            for (Object obj : BuiltInFictitiousFunctionClassFactory) {
                AppUtil appUtil = AppUtil.MyBillsEntityDataFactory;
                if (AppUtil.getAuthRequestContext(context, ((AppInfoModel) obj).PlaceComponentResult)) {
                    arrayList.add(obj);
                }
            }
            ArrayList<AppInfoModel> arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
            for (AppInfoModel appInfoModel : arrayList2) {
                AppUtil appUtil2 = AppUtil.MyBillsEntityDataFactory;
                Long KClassImpl$Data$declaredNonStaticMembers$2 = AppUtil.KClassImpl$Data$declaredNonStaticMembers$2(context, appInfoModel.PlaceComponentResult);
                long longValue = KClassImpl$Data$declaredNonStaticMembers$2 != null ? KClassImpl$Data$declaredNonStaticMembers$2.longValue() : 0L;
                AppUtil appUtil3 = AppUtil.MyBillsEntityDataFactory;
                String PlaceComponentResult = AppUtil.PlaceComponentResult(context, appInfoModel.PlaceComponentResult);
                if (PlaceComponentResult == null) {
                    PlaceComponentResult = appInfoModel.getAuthRequestContext;
                }
                arrayList3.add(new InsertInstalledAppsScoringData.InstalledAppDataInfo(longValue, PlaceComponentResult, null));
            }
            doInsertInstalledAppsCreditScore(arrayList3);
        } catch (Exception e) {
            Crashlytics.Companion companion = Crashlytics.INSTANCE;
            Crashlytics authRequestContext = Crashlytics.Companion.getAuthRequestContext();
            Intrinsics.checkNotNullParameter("case", "");
            Intrinsics.checkNotNullParameter(TAG, "");
            authRequestContext.getAuthRequestContext.setCustomKey("case", TAG);
            Exception exc = e;
            Intrinsics.checkNotNullParameter(exc, "");
            authRequestContext.getAuthRequestContext.recordException(exc);
            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.INSTALLED_APP, "[InstalledApp]SendDataInstalledAppinstalled_app", exc);
        }
    }

    private final void doInsertInstalledAppsCreditScore(List<InsertInstalledAppsScoringData.InstalledAppDataInfo> collectedInstalledAppData) {
        getInsertInstalledAppsCreditScore().execute(InsertInstalledAppsCreditScore.Params.INSTANCE.createDashboardDanaCicilCreditScoring(collectedInstalledAppData), new Function1<Boolean, Unit>() { // from class: id.dana.danah5.danacicil.DanaCicilWebViewEventHandler$doInsertInstalledAppsCreditScore$1
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
                if (z) {
                    DanaCicilWebViewEventHandler.this.doSaveRunWorkerInstalledApp();
                    return;
                }
                Crashlytics.Companion companion = Crashlytics.INSTANCE;
                Crashlytics authRequestContext = Crashlytics.Companion.getAuthRequestContext();
                Intrinsics.checkNotNullParameter("case", "");
                Intrinsics.checkNotNullParameter("SendDataInstalledApp", "");
                authRequestContext.getAuthRequestContext.setCustomKey("case", "SendDataInstalledApp");
                Intrinsics.checkNotNullParameter("InsertInstalledAppsCreditScore data not inserted", "");
                authRequestContext.getAuthRequestContext.log("InsertInstalledAppsCreditScore data not inserted");
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.danah5.danacicil.DanaCicilWebViewEventHandler$doInsertInstalledAppsCreditScore$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                Crashlytics.Companion companion = Crashlytics.INSTANCE;
                Crashlytics authRequestContext = Crashlytics.Companion.getAuthRequestContext();
                Intrinsics.checkNotNullParameter("case", "");
                Intrinsics.checkNotNullParameter("SendDataInstalledApp", "");
                authRequestContext.getAuthRequestContext.setCustomKey("case", "SendDataInstalledApp");
                Intrinsics.checkNotNullParameter("InsertInstalledAppsCreditScore failed", "");
                authRequestContext.getAuthRequestContext.log("InsertInstalledAppsCreditScore failed");
                Intrinsics.checkNotNullParameter(th, "");
                authRequestContext.getAuthRequestContext.recordException(th);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doSaveRunWorkerInstalledApp() {
        getSaveNeedToSendInstalledApp().execute(NoParams.INSTANCE, new Function0<Unit>() { // from class: id.dana.danah5.danacicil.DanaCicilWebViewEventHandler$doSaveRunWorkerInstalledApp$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.danah5.danacicil.DanaCicilWebViewEventHandler$doSaveRunWorkerInstalledApp$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                Crashlytics.Companion companion = Crashlytics.INSTANCE;
                Crashlytics authRequestContext = Crashlytics.Companion.getAuthRequestContext();
                Intrinsics.checkNotNullParameter("case", "");
                Intrinsics.checkNotNullParameter("SendDataInstalledApp", "");
                authRequestContext.getAuthRequestContext.setCustomKey("case", "SendDataInstalledApp");
                Intrinsics.checkNotNullParameter("SendDataInstalledApp saveNeedToSendInstalledApp onError", "");
                authRequestContext.getAuthRequestContext.log("SendDataInstalledApp saveNeedToSendInstalledApp onError");
                Intrinsics.checkNotNullParameter(th, "");
                authRequestContext.getAuthRequestContext.recordException(th);
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.INSTALLED_APP, "[InstalledApp]SendDataInstalledAppinstalled_app", th);
            }
        });
    }

    @Override // id.dana.danah5.base.UrlTransportEventHandler, com.alibaba.ariver.kernel.api.extension.Extension
    public final void onFinalized() {
        super.onFinalized();
        isNeedToSendInstalledApp().dispose();
        getSaveNeedToSendInstalledApp().dispose();
        getInsertInstalledAppsCreditScore().dispose();
    }
}
