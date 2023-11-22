package id.dana.cashier.data.repository.source.network.result;

import id.dana.data.content.source.network.result.SpaceRpcResult;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/cashier/data/repository/source/network/result/TimedSpaceRpcResult;", "", "Lid/dana/data/content/source/network/result/SpaceRpcResult;", "spaceRpcResult", "Lid/dana/data/content/source/network/result/SpaceRpcResult;", "getSpaceRpcResult", "()Lid/dana/data/content/source/network/result/SpaceRpcResult;", "", "time", "J", "getTime", "()J", "<init>", "(Lid/dana/data/content/source/network/result/SpaceRpcResult;J)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TimedSpaceRpcResult {
    private final SpaceRpcResult spaceRpcResult;
    private final long time;

    public TimedSpaceRpcResult(SpaceRpcResult spaceRpcResult, long j) {
        Intrinsics.checkNotNullParameter(spaceRpcResult, "");
        this.spaceRpcResult = spaceRpcResult;
        this.time = j;
    }

    @JvmName(name = "getSpaceRpcResult")
    public final SpaceRpcResult getSpaceRpcResult() {
        return this.spaceRpcResult;
    }

    public /* synthetic */ TimedSpaceRpcResult(SpaceRpcResult spaceRpcResult, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(spaceRpcResult, (i & 2) != 0 ? System.currentTimeMillis() : j);
    }

    @JvmName(name = "getTime")
    public final long getTime() {
        return this.time;
    }
}
