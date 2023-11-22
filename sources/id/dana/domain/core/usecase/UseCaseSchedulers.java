package id.dana.domain.core.usecase;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\bR \u0010\u0003\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R \u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u0012\u0004\b\u000b\u0010\b\u001a\u0004\b\n\u0010\u0006"}, d2 = {"Lid/dana/domain/core/usecase/UseCaseSchedulers;", "", "Lio/reactivex/Scheduler;", "jobScheduler", "Lio/reactivex/Scheduler;", "getJobScheduler", "()Lio/reactivex/Scheduler;", "getJobScheduler$annotations", "()V", "postScheduler", "getPostScheduler", "getPostScheduler$annotations", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class UseCaseSchedulers {
    public static final UseCaseSchedulers INSTANCE = new UseCaseSchedulers();
    private static final Scheduler jobScheduler;
    private static final Scheduler postScheduler;

    @JvmStatic
    public static /* synthetic */ void getJobScheduler$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getPostScheduler$annotations() {
    }

    private UseCaseSchedulers() {
    }

    @JvmName(name = "getJobScheduler")
    public static final Scheduler getJobScheduler() {
        return jobScheduler;
    }

    static {
        Scheduler MyBillsEntityDataFactory = Schedulers.MyBillsEntityDataFactory();
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        jobScheduler = MyBillsEntityDataFactory;
        Scheduler PlaceComponentResult = AndroidSchedulers.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        postScheduler = PlaceComponentResult;
    }

    @JvmName(name = "getPostScheduler")
    public static final Scheduler getPostScheduler() {
        return postScheduler;
    }
}
