package id.dana.network.response.login;

import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\b\u0018\u0000 #2\u00020\u0001:\u0001#B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\"\u0010\t\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004\"\u0004\b\u0019\u0010\u001aR\"\u0010\n\u001a\u00020\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u001b\u001a\u0004\b\u001c\u0010\u0007\"\u0004\b\u001d\u0010\u001eR\"\u0010\u000b\u001a\u00020\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u001b\u001a\u0004\b\u001f\u0010\u0007\"\u0004\b \u0010\u001e"}, d2 = {"Lid/dana/network/response/login/EvUrlStatusResult;", "", "", "component1", "()J", "", "component2", "()Z", "component3", "callTime", "called", "complete", "copy", "(JZZ)Lid/dana/network/response/login/EvUrlStatusResult;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "J", "getCallTime", "setCallTime", "(J)V", "Z", "getCalled", "setCalled", "(Z)V", "getComplete", "setComplete", "<init>", "(JZZ)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class EvUrlStatusResult {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private long callTime;
    private boolean called;
    private boolean complete;

    public static /* synthetic */ EvUrlStatusResult copy$default(EvUrlStatusResult evUrlStatusResult, long j, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = evUrlStatusResult.callTime;
        }
        if ((i & 2) != 0) {
            z = evUrlStatusResult.called;
        }
        if ((i & 4) != 0) {
            z2 = evUrlStatusResult.complete;
        }
        return evUrlStatusResult.copy(j, z, z2);
    }

    /* renamed from: component1  reason: from getter */
    public final long getCallTime() {
        return this.callTime;
    }

    /* renamed from: component2  reason: from getter */
    public final boolean getCalled() {
        return this.called;
    }

    /* renamed from: component3  reason: from getter */
    public final boolean getComplete() {
        return this.complete;
    }

    public final EvUrlStatusResult copy(long callTime, boolean called, boolean complete) {
        return new EvUrlStatusResult(callTime, called, complete);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof EvUrlStatusResult) {
            EvUrlStatusResult evUrlStatusResult = (EvUrlStatusResult) other;
            return this.callTime == evUrlStatusResult.callTime && this.called == evUrlStatusResult.called && this.complete == evUrlStatusResult.complete;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int m = Cbor$Arg$$ExternalSyntheticBackport0.m(this.callTime);
        boolean z = this.called;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        boolean z2 = this.complete;
        return (((m * 31) + i) * 31) + (z2 ? 1 : z2 ? 1 : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EvUrlStatusResult(callTime=");
        sb.append(this.callTime);
        sb.append(", called=");
        sb.append(this.called);
        sb.append(", complete=");
        sb.append(this.complete);
        sb.append(')');
        return sb.toString();
    }

    public EvUrlStatusResult(long j, boolean z, boolean z2) {
        this.callTime = j;
        this.called = z;
        this.complete = z2;
    }

    @JvmName(name = "getCallTime")
    public final long getCallTime() {
        return this.callTime;
    }

    @JvmName(name = "getCalled")
    public final boolean getCalled() {
        return this.called;
    }

    @JvmName(name = "getComplete")
    public final boolean getComplete() {
        return this.complete;
    }

    @JvmName(name = "setCallTime")
    public final void setCallTime(long j) {
        this.callTime = j;
    }

    @JvmName(name = "setCalled")
    public final void setCalled(boolean z) {
        this.called = z;
    }

    @JvmName(name = "setComplete")
    public final void setComplete(boolean z) {
        this.complete = z;
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/network/response/login/EvUrlStatusResult$Companion;", "", "", "callTime", "Lid/dana/network/response/login/EvUrlStatusResult;", "createNewHitEvUrl", "(J)Lid/dana/network/response/login/EvUrlStatusResult;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final EvUrlStatusResult createNewHitEvUrl(long callTime) {
            return new EvUrlStatusResult(callTime, true, false);
        }
    }
}
