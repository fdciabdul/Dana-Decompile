package id.dana.animation.worker;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.RxWorker;
import androidx.work.WorkerParameters;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.analytics.mixpanel.MixPanelEvent;
import id.dana.analytics.tracker.TrackerDataKey;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J-\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0010X\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/home/worker/GetStorageInfoWorker;", "Landroidx/work/RxWorker;", "Ljava/io/File;", "p0", "Lid/dana/analytics/mixpanel/MixPanelEvent$Builder;", "p1", "", "", "p2", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/io/File;Lid/dana/analytics/mixpanel/MixPanelEvent$Builder;Ljava/util/List;)J", "Lio/reactivex/Single;", "Landroidx/work/ListenableWorker$Result;", "createWork", "()Lio/reactivex/Single;", "Landroid/content/Context;", "getAuthRequestContext", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroidx/work/WorkerParameters;", "workerParams", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GetStorageInfoWorker extends RxWorker {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final Context BuiltInFictitiousFunctionClassFactory;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetStorageInfoWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(workerParameters, "");
        this.BuiltInFictitiousFunctionClassFactory = context;
    }

    @Override // androidx.work.RxWorker
    public final Single<ListenableWorker.Result> createWork() {
        Single<ListenableWorker.Result> MyBillsEntityDataFactory = Single.MyBillsEntityDataFactory(new SingleOnSubscribe() { // from class: id.dana.home.worker.GetStorageInfoWorker$$ExternalSyntheticLambda0
            @Override // io.reactivex.SingleOnSubscribe
            public final void subscribe(SingleEmitter singleEmitter) {
                GetStorageInfoWorker.getAuthRequestContext(GetStorageInfoWorker.this, singleEmitter);
            }
        });
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    private final long BuiltInFictitiousFunctionClassFactory(File p0, MixPanelEvent.Builder p1, List<String> p2) {
        File[] listFiles = p0.listFiles();
        Intrinsics.checkNotNullExpressionValue(listFiles, "");
        long j = 0;
        for (File file : listFiles) {
            j += file.length();
            StringBuilder sb = new StringBuilder();
            sb.append('\'');
            sb.append(p0.getAbsolutePath());
            sb.append('/');
            sb.append(file.getName());
            sb.append(" uses ");
            sb.append(file.length());
            sb.append(" bytes'");
            p2.add(sb.toString());
            if (file.isDirectory()) {
                Intrinsics.checkNotNullExpressionValue(file, "");
                j += BuiltInFictitiousFunctionClassFactory(file, p1, p2);
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append('\'');
        sb2.append(p0.getAbsolutePath());
        sb2.append(" uses ");
        sb2.append(j);
        sb2.append(" bytes'");
        p2.add(sb2.toString());
        return j;
    }

    public static /* synthetic */ void getAuthRequestContext(GetStorageInfoWorker getStorageInfoWorker, SingleEmitter singleEmitter) {
        Intrinsics.checkNotNullParameter(getStorageInfoWorker, "");
        Intrinsics.checkNotNullParameter(singleEmitter, "");
        Context context = getStorageInfoWorker.BuiltInFictitiousFunctionClassFactory;
        File parentFile = context.getFilesDir().getParentFile();
        Intrinsics.checkNotNullExpressionValue(parentFile, "");
        MixPanelEvent.Builder builder = new MixPanelEvent.Builder(context);
        builder.KClassImpl$Data$declaredNonStaticMembers$2 = TrackerDataKey.Event.STORAGE_TAG;
        ArrayList arrayList = new ArrayList();
        builder.PlaceComponentResult(TrackerDataKey.Property.STORAGE_INFO, Long.valueOf(getStorageInfoWorker.BuiltInFictitiousFunctionClassFactory(parentFile, builder, arrayList)));
        builder.getAuthRequestContext(TrackerDataKey.Property.STORAGE_LOG, arrayList);
        new MixPanelEvent(builder, (byte) 0).PlaceComponentResult();
        singleEmitter.onSuccess(ListenableWorker.Result.BuiltInFictitiousFunctionClassFactory());
    }
}
