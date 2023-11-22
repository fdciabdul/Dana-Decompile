package androidx.paging;

import androidx.paging.AccessorState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Add missing generic type declarations: [Value, Key] */
@Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0006\u001a\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003H\n"}, d2 = {"", "Key", "Value", "Landroidx/paging/AccessorState$PendingRequest;", "it", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
final class AccessorState$clearPendingRequest$1<Key, Value> extends Lambda implements Function1<AccessorState.PendingRequest<Key, Value>, Boolean> {
    final /* synthetic */ LoadType $loadType;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccessorState$clearPendingRequest$1(LoadType loadType) {
        super(1);
        this.$loadType = loadType;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
        return invoke((AccessorState.PendingRequest) ((AccessorState.PendingRequest) obj));
    }

    public final Boolean invoke(AccessorState.PendingRequest<Key, Value> pendingRequest) {
        Intrinsics.checkNotNullParameter(pendingRequest, "");
        return Boolean.valueOf(pendingRequest.PlaceComponentResult == this.$loadType);
    }
}
