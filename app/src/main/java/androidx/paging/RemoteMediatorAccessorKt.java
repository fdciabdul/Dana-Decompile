package androidx.paging;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aK\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005H\u0000¢\u0006\u0004\b\b\u0010\t"}, d2 = {"", "Key", "Value", "Lkotlinx/coroutines/CoroutineScope;", "p0", "Landroidx/paging/RemoteMediator;", "p1", "Landroidx/paging/RemoteMediatorAccessor;", "PlaceComponentResult", "(Lkotlinx/coroutines/CoroutineScope;Landroidx/paging/RemoteMediator;)Landroidx/paging/RemoteMediatorAccessor;"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class RemoteMediatorAccessorKt {
    public static final <Key, Value> RemoteMediatorAccessor<Key, Value> PlaceComponentResult(CoroutineScope coroutineScope, RemoteMediator<Key, Value> remoteMediator) {
        Intrinsics.checkNotNullParameter(coroutineScope, "");
        Intrinsics.checkNotNullParameter(remoteMediator, "");
        return new RemoteMediatorAccessImpl(coroutineScope, remoteMediator);
    }
}
