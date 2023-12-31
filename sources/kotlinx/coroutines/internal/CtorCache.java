package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ1\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0005j\u0002`\u00062\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lkotlinx/coroutines/internal/CtorCache;", "", "Ljava/lang/Class;", "", "key", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/Ctor;", "get", "(Ljava/lang/Class;)Lkotlin/jvm/functions/Function1;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public abstract class CtorCache {
    public abstract Function1<Throwable, Throwable> get(Class<? extends Throwable> key);
}
