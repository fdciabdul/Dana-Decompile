package kotlinx.coroutines.debug.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.Symbol;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u0015\u0010\u0005\u001a\u00020\u0004*\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u0005\u0010\u0006\"\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b\"\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\b\"\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"", "noImpl", "()Ljava/lang/Void;", "", "Lkotlinx/coroutines/debug/internal/Marked;", "mark", "(Ljava/lang/Object;)Lkotlinx/coroutines/debug/internal/Marked;", "MARKED_NULL", "Lkotlinx/coroutines/debug/internal/Marked;", "MARKED_TRUE", "Lkotlinx/coroutines/internal/Symbol;", "REHASH", "Lkotlinx/coroutines/internal/Symbol;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class ConcurrentWeakMapKt {
    private static final Symbol REHASH = new Symbol("REHASH");
    private static final Marked MARKED_NULL = new Marked(null);
    private static final Marked MARKED_TRUE = new Marked(Boolean.TRUE);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Marked mark(Object obj) {
        if (obj == null) {
            return MARKED_NULL;
        }
        return Intrinsics.areEqual(obj, Boolean.TRUE) ? MARKED_TRUE : new Marked(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void noImpl() {
        throw new UnsupportedOperationException("not implemented");
    }
}
