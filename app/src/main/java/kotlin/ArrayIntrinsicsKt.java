package kotlin;

import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u001a#\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u000b\b\u0000\u0010\u0001\u0018\u0001¢\u0006\u0002\b\u0000H\u0086\b¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlin/internal/PureReifiable;", "T", "", "emptyArray", "()[Ljava/lang/Object;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class ArrayIntrinsicsKt {
    public static final /* synthetic */ <T> T[] emptyArray() {
        Intrinsics.reifiedOperationMarker(0, "T?");
        return (T[]) new Object[0];
    }
}
