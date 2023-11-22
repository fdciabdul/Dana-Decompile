package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000,\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0017\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002*\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\"\u001a\u0010\u0005\u001a\u00020\u00008\u0001X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u001a\u0010\t\u001a\u00020\u00008\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\b*\n\u0010\f\"\u00020\u000b2\u00020\u000b*\u001c\u0010\u000f\u001a\u0004\b\u0000\u0010\r\"\b\u0012\u0004\u0012\u00028\u00000\u000e2\b\u0012\u0004\u0012\u00028\u00000\u000e*\f\b\u0002\u0010\u0010\"\u00020\u00012\u00020\u0001*\n\u0010\u0012\"\u00020\u00112\u00020\u0011*\u001c\u0010\u0014\u001a\u0004\b\u0000\u0010\r\"\b\u0012\u0004\u0012\u00028\u00000\u00132\b\u0012\u0004\u0012\u00028\u00000\u0013"}, d2 = {"", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "unwrap", "(Ljava/lang/Object;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "CONDITION_FALSE", "Ljava/lang/Object;", "getCONDITION_FALSE", "()Ljava/lang/Object;", "LIST_EMPTY", "getLIST_EMPTY", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AbstractAtomicDesc;", "AbstractAtomicDesc", "T", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "AddLastDesc", "Node", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "PrepareOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "RemoveFirstDesc"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class LockFreeLinkedListKt {
    private static final Object CONDITION_FALSE = new Symbol("CONDITION_FALSE");
    private static final Object LIST_EMPTY = new Symbol("LIST_EMPTY");

    @JvmName(name = "getCONDITION_FALSE")
    public static final Object getCONDITION_FALSE() {
        return CONDITION_FALSE;
    }

    @JvmName(name = "getLIST_EMPTY")
    public static final Object getLIST_EMPTY() {
        return LIST_EMPTY;
    }

    public static final LockFreeLinkedListNode unwrap(Object obj) {
        LockFreeLinkedListNode lockFreeLinkedListNode;
        Removed removed = obj instanceof Removed ? (Removed) obj : null;
        return (removed == null || (lockFreeLinkedListNode = removed.ref) == null) ? (LockFreeLinkedListNode) obj : lockFreeLinkedListNode;
    }
}
