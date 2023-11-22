package id.dana.social.utils;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.RxWorker;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkManagerImpl;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.DanaApplication;
import id.dana.analytics.firebase.Crashlytics;
import id.dana.base.extension.WorkManagerFailure;
import id.dana.di.component.ApplicationComponent;
import id.dana.sendmoney.domain.groupsend.GroupSendOperationType;
import id.dana.sync_engine.domain.interactor.GetContactsUseCase;
import id.dana.sync_engine.domain.model.ContactResult;
import id.dana.sync_engine.domain.model.SyncForFeature;
import id.dana.util.AndroidComponentUtilsKt;
import id.dana.utils.foundation.logger.log.DanaLog;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0017\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0007\u001a\u00020\u0006X\u0087\"¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/social/utils/SyncContactsEngineWorker;", "Landroidx/work/RxWorker;", "Lio/reactivex/Single;", "Landroidx/work/ListenableWorker$Result;", "createWork", "()Lio/reactivex/Single;", "Lid/dana/sync_engine/domain/interactor/GetContactsUseCase;", GroupSendOperationType.GROUP_GET_CONTACT_USE_CASE, "Lid/dana/sync_engine/domain/interactor/GetContactsUseCase;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroidx/work/WorkerParameters;", "params", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SyncContactsEngineWorker extends RxWorker {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    @Inject
    public GetContactsUseCase getContactsUseCase;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SyncContactsEngineWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(workerParameters, "");
    }

    @Override // androidx.work.RxWorker
    public final Single<ListenableWorker.Result> createWork() {
        DanaApplication BuiltInFictitiousFunctionClassFactory = AndroidComponentUtilsKt.BuiltInFictitiousFunctionClassFactory(this);
        GetContactsUseCase getContactsUseCase = null;
        ApplicationComponent applicationComponent = BuiltInFictitiousFunctionClassFactory != null ? BuiltInFictitiousFunctionClassFactory.getApplicationComponent() : null;
        if (applicationComponent != null) {
            Intrinsics.checkNotNullParameter(applicationComponent, "");
            applicationComponent.PlaceComponentResult(this);
            GetContactsUseCase.Params params = new GetContactsUseCase.Params(SyncForFeature.BackgroundJob, null, null, true, false, 22, null);
            DanaLog.MyBillsEntityDataFactory("SyncContactEngine", "SyncContactsEngineWorker : createWork");
            GetContactsUseCase getContactsUseCase2 = this.getContactsUseCase;
            if (getContactsUseCase2 != null) {
                getContactsUseCase = getContactsUseCase2;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            Single<ListenableWorker.Result> firstOrError = getContactsUseCase.buildUseCase(params).filter(new Predicate() { // from class: id.dana.social.utils.SyncContactsEngineWorker$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Predicate
                public final boolean test(Object obj) {
                    boolean KClassImpl$Data$declaredNonStaticMembers$2;
                    KClassImpl$Data$declaredNonStaticMembers$2 = SyncContactsEngineWorker.KClassImpl$Data$declaredNonStaticMembers$2((ContactResult) obj);
                    return KClassImpl$Data$declaredNonStaticMembers$2;
                }
            }).map(new Function() { // from class: id.dana.social.utils.SyncContactsEngineWorker$$ExternalSyntheticLambda1
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return SyncContactsEngineWorker.PlaceComponentResult((ContactResult) obj);
                }
            }).firstOrError();
            Intrinsics.checkNotNullExpressionValue(firstOrError, "");
            return firstOrError;
        }
        Single<ListenableWorker.Result> MyBillsEntityDataFactory = Single.MyBillsEntityDataFactory(ListenableWorker.Result.getAuthRequestContext());
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    public static final boolean KClassImpl$Data$declaredNonStaticMembers$2(ContactResult contactResult) {
        Intrinsics.checkNotNullParameter(contactResult, "");
        return (contactResult instanceof ContactResult.Finished) || (contactResult instanceof ContactResult.Error);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/social/utils/SyncContactsEngineWorker$Companion;", "", "Landroid/content/Context;", "p0", "", "PlaceComponentResult", "(Landroid/content/Context;)V", "", "BuiltInFictitiousFunctionClassFactory", "(Landroid/content/Context;)Z", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static boolean BuiltInFictitiousFunctionClassFactory(Context p0) {
            WorkManager PlaceComponentResult;
            Intrinsics.checkNotNullParameter(p0, "");
            PlaceComponentResult = WorkManagerImpl.PlaceComponentResult(p0);
            List<WorkInfo> list = PlaceComponentResult.PlaceComponentResult("SYNC_CONTACTS_WORKER_KEY").get();
            try {
                Intrinsics.checkNotNullExpressionValue(list, "");
                List<WorkInfo> list2 = list;
                if ((list2 instanceof Collection) && list2.isEmpty()) {
                    return false;
                }
                for (WorkInfo workInfo : list2) {
                    if (WorkInfo.State.RUNNING == workInfo.KClassImpl$Data$declaredNonStaticMembers$2 || WorkInfo.State.ENQUEUED == workInfo.KClassImpl$Data$declaredNonStaticMembers$2) {
                        return true;
                    }
                }
                return false;
            } catch (Exception e) {
                DanaLog.BuiltInFictitiousFunctionClassFactory("SyncContactsEngineWorker", e.getMessage(), e);
                return false;
            }
        }

        @JvmStatic
        public static void PlaceComponentResult(Context p0) {
            WorkManager PlaceComponentResult;
            Intrinsics.checkNotNullParameter(p0, "");
            try {
                PlaceComponentResult = WorkManagerImpl.PlaceComponentResult(p0);
                Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
                PlaceComponentResult.MyBillsEntityDataFactory("SYNC_CONTACTS_WORKER_KEY");
            } catch (Exception e) {
                try {
                    Crashlytics.Companion companion = Crashlytics.INSTANCE;
                    Crashlytics authRequestContext = Crashlytics.Companion.getAuthRequestContext();
                    WorkManagerFailure workManagerFailure = new WorkManagerFailure(e);
                    Intrinsics.checkNotNullParameter(workManagerFailure, "");
                    authRequestContext.getAuthRequestContext.recordException(workManagerFailure);
                } catch (Exception unused) {
                }
            }
        }
    }

    public static /* synthetic */ ListenableWorker.Result PlaceComponentResult(ContactResult contactResult) {
        Intrinsics.checkNotNullParameter(contactResult, "");
        StringBuilder sb = new StringBuilder();
        sb.append("SyncContactsEngineWorker : ");
        sb.append(contactResult);
        DanaLog.MyBillsEntityDataFactory("SyncContactEngine", sb.toString());
        return contactResult instanceof ContactResult.Finished ? ListenableWorker.Result.BuiltInFictitiousFunctionClassFactory() : ListenableWorker.Result.getAuthRequestContext();
    }
}
