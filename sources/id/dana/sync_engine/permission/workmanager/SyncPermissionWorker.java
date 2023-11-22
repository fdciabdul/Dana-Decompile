package id.dana.sync_engine.permission.workmanager;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkManagerImpl;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.sync_engine.permission.PermissionUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0017\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/sync_engine/permission/workmanager/SyncPermissionWorker;", "Landroidx/work/Worker;", "Landroidx/work/ListenableWorker$Result;", "doWork", "()Landroidx/work/ListenableWorker$Result;", "Landroid/content/Context;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/content/Context;", "BuiltInFictitiousFunctionClassFactory", HummerConstants.CONTEXT, "Landroidx/work/WorkerParameters;", "params", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SyncPermissionWorker extends Worker {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Context BuiltInFictitiousFunctionClassFactory;

    @JvmStatic
    public static final void BuiltInFictitiousFunctionClassFactory(Context context) {
        Companion.getAuthRequestContext(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SyncPermissionWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(workerParameters, "");
        this.BuiltInFictitiousFunctionClassFactory = context;
    }

    @Override // androidx.work.Worker
    public final ListenableWorker.Result doWork() {
        PermissionUtil permissionUtil = PermissionUtil.INSTANCE;
        PermissionUtil.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory);
        ListenableWorker.Result BuiltInFictitiousFunctionClassFactory = ListenableWorker.Result.BuiltInFictitiousFunctionClassFactory();
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/sync_engine/permission/workmanager/SyncPermissionWorker$Companion;", "", "Landroid/content/Context;", "p0", "", "getAuthRequestContext", "(Landroid/content/Context;)V", "", "MyBillsEntityDataFactory", "(Landroid/content/Context;)Z", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] MyBillsEntityDataFactory;

            static {
                int[] iArr = new int[WorkInfo.State.values().length];
                iArr[WorkInfo.State.RUNNING.ordinal()] = 1;
                iArr[WorkInfo.State.ENQUEUED.ordinal()] = 2;
                MyBillsEntityDataFactory = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static void getAuthRequestContext(Context p0) {
            WorkManager PlaceComponentResult;
            Intrinsics.checkNotNullParameter(p0, "");
            PlaceComponentResult = WorkManagerImpl.PlaceComponentResult(p0);
            PlaceComponentResult.MyBillsEntityDataFactory("SYNC_PERMISSION_TRACKER_KEY");
        }

        public static boolean MyBillsEntityDataFactory(Context p0) {
            WorkManager PlaceComponentResult;
            try {
                PlaceComponentResult = WorkManagerImpl.PlaceComponentResult(p0);
                List<WorkInfo> list = PlaceComponentResult.PlaceComponentResult("SYNC_PERMISSION_TRACKER_KEY").get();
                Intrinsics.checkNotNullExpressionValue(list, "");
                Iterator<T> it = list.iterator();
                if (it.hasNext()) {
                    int i = WhenMappings.MyBillsEntityDataFactory[((WorkInfo) it.next()).KClassImpl$Data$declaredNonStaticMembers$2.ordinal()];
                    return i == 1 || i == 2;
                }
            } catch (Exception e) {
                DanaLog.BuiltInFictitiousFunctionClassFactory("SyncPermissionWorker", e.getMessage());
            }
            return false;
        }
    }
}
