package kotlinx.coroutines;

import com.alibaba.ariver.kernel.common.service.executor.RVScheduleType;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\f\u001a\u00020\t8G¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/Dispatchers;", "", "Lkotlinx/coroutines/CoroutineDispatcher;", "Default", "Lkotlinx/coroutines/CoroutineDispatcher;", "getDefault", "()Lkotlinx/coroutines/CoroutineDispatcher;", RVScheduleType.IO, "getIO", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "getMain", "()Lkotlinx/coroutines/MainCoroutineDispatcher;", "Main", "Unconfined", "getUnconfined", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Dispatchers {
    public static final Dispatchers INSTANCE = new Dispatchers();
    private static final CoroutineDispatcher Default = DefaultScheduler.INSTANCE;
    private static final CoroutineDispatcher Unconfined = Unconfined.INSTANCE;
    private static final CoroutineDispatcher IO = DefaultIoScheduler.INSTANCE;

    private Dispatchers() {
    }

    @JvmName(name = "getDefault")
    public static final CoroutineDispatcher getDefault() {
        return Default;
    }

    @JvmName(name = "getMain")
    public static final MainCoroutineDispatcher getMain() {
        return MainDispatcherLoader.dispatcher;
    }

    @JvmName(name = "getUnconfined")
    public static final CoroutineDispatcher getUnconfined() {
        return Unconfined;
    }

    @JvmName(name = "getIO")
    public static final CoroutineDispatcher getIO() {
        return IO;
    }
}
