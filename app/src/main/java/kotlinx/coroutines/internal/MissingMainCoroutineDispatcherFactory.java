package kotlinx.coroutines.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.internal.MainDispatcherFactory;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t"}, d2 = {"Lkotlinx/coroutines/internal/MissingMainCoroutineDispatcherFactory;", "Lkotlinx/coroutines/internal/MainDispatcherFactory;", "", "allFactories", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "createDispatcher", "(Ljava/util/List;)Lkotlinx/coroutines/MainCoroutineDispatcher;", "", "getLoadPriority", "()I", "loadPriority", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class MissingMainCoroutineDispatcherFactory implements MainDispatcherFactory {
    public static final MissingMainCoroutineDispatcherFactory INSTANCE = new MissingMainCoroutineDispatcherFactory();

    @Override // kotlinx.coroutines.internal.MainDispatcherFactory
    @JvmName(name = "getLoadPriority")
    public final int getLoadPriority() {
        return -1;
    }

    private MissingMainCoroutineDispatcherFactory() {
    }

    @Override // kotlinx.coroutines.internal.MainDispatcherFactory
    public final String hintOnError() {
        return MainDispatcherFactory.DefaultImpls.hintOnError(this);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // kotlinx.coroutines.internal.MainDispatcherFactory
    public final MainCoroutineDispatcher createDispatcher(List<? extends MainDispatcherFactory> allFactories) {
        ?? r0 = 0;
        return new MissingMainCoroutineDispatcher(r0, r0, 2, r0);
    }
}
