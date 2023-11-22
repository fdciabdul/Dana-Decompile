package id.dana.di.workerfactory;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import id.dana.domain.pushverify.interactor.GetPushVerifyChallenge;
import id.dana.domain.pushverify.interactor.GetVerifyPushChallenge;
import id.dana.pushverify.tracker.PushVerifyTracker;
import id.dana.pushverify.worker.PushVerifyWorker;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\t\u0012\u0006\u0010\u0005\u001a\u00020\f\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\u000f8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/di/workerfactory/PushVerifyWorkerFactory;", "Lid/dana/di/workerfactory/ChildWorkerFactory;", "Landroid/content/Context;", "p0", "Landroidx/work/WorkerParameters;", "p1", "Landroidx/work/ListenableWorker;", "MyBillsEntityDataFactory", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)Landroidx/work/ListenableWorker;", "Lid/dana/domain/pushverify/interactor/GetPushVerifyChallenge;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/domain/pushverify/interactor/GetPushVerifyChallenge;", "Lid/dana/domain/pushverify/interactor/GetVerifyPushChallenge;", "PlaceComponentResult", "Lid/dana/domain/pushverify/interactor/GetVerifyPushChallenge;", "Lid/dana/pushverify/tracker/PushVerifyTracker;", "getAuthRequestContext", "Lid/dana/pushverify/tracker/PushVerifyTracker;", "p2", "<init>", "(Lid/dana/domain/pushverify/interactor/GetPushVerifyChallenge;Lid/dana/domain/pushverify/interactor/GetVerifyPushChallenge;Lid/dana/pushverify/tracker/PushVerifyTracker;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PushVerifyWorkerFactory implements ChildWorkerFactory {
    private final GetPushVerifyChallenge BuiltInFictitiousFunctionClassFactory;
    private final GetVerifyPushChallenge PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final PushVerifyTracker MyBillsEntityDataFactory;

    @Inject
    public PushVerifyWorkerFactory(GetPushVerifyChallenge getPushVerifyChallenge, GetVerifyPushChallenge getVerifyPushChallenge, PushVerifyTracker pushVerifyTracker) {
        Intrinsics.checkNotNullParameter(getPushVerifyChallenge, "");
        Intrinsics.checkNotNullParameter(getVerifyPushChallenge, "");
        Intrinsics.checkNotNullParameter(pushVerifyTracker, "");
        this.BuiltInFictitiousFunctionClassFactory = getPushVerifyChallenge;
        this.PlaceComponentResult = getVerifyPushChallenge;
        this.MyBillsEntityDataFactory = pushVerifyTracker;
    }

    @Override // id.dana.di.workerfactory.ChildWorkerFactory
    public final ListenableWorker MyBillsEntityDataFactory(Context p0, WorkerParameters p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        return new PushVerifyWorker(p0, p1, this.BuiltInFictitiousFunctionClassFactory, this.PlaceComponentResult, this.MyBillsEntityDataFactory);
    }
}
