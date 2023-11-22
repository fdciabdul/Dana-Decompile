package id.dana.domain.social.core;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\bR \u0010\u0003\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R \u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u0012\u0004\b\u000b\u0010\b\u001a\u0004\b\n\u0010\u0006"}, d2 = {"Lid/dana/domain/social/core/UseCaseDispatchers;", "", "Lkotlinx/coroutines/CoroutineDispatcher;", "jobDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "getJobDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "getJobDispatcher$annotations", "()V", "postDispatcher", "getPostDispatcher", "getPostDispatcher$annotations", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class UseCaseDispatchers {
    public static final UseCaseDispatchers INSTANCE = new UseCaseDispatchers();
    private static final CoroutineDispatcher jobDispatcher = Dispatchers.getIO();
    private static final CoroutineDispatcher postDispatcher = Dispatchers.getMain();

    @JvmStatic
    public static /* synthetic */ void getJobDispatcher$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getPostDispatcher$annotations() {
    }

    private UseCaseDispatchers() {
    }

    @JvmName(name = "getJobDispatcher")
    public static final CoroutineDispatcher getJobDispatcher() {
        return jobDispatcher;
    }

    @JvmName(name = "getPostDispatcher")
    public static final CoroutineDispatcher getPostDispatcher() {
        return postDispatcher;
    }
}
