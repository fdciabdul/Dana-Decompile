package id.dana.network.rpc;

import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0003\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b"}, d2 = {"Lid/dana/network/rpc/RpcLogging;", "", "", "enableNetworkTrace", "Z", "getEnableNetworkTrace", "()Z", "setEnableNetworkTrace", "(Z)V", "enabled", "getEnabled", "setEnabled", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RpcLogging {
    public static final RpcLogging INSTANCE = new RpcLogging();
    private static boolean enableNetworkTrace;
    private static boolean enabled;

    private RpcLogging() {
    }

    @JvmName(name = "getEnabled")
    public final boolean getEnabled() {
        return enabled;
    }

    @JvmName(name = "setEnabled")
    public final void setEnabled(boolean z) {
        enabled = z;
    }

    @JvmName(name = "getEnableNetworkTrace")
    public final boolean getEnableNetworkTrace() {
        return enableNetworkTrace;
    }

    @JvmName(name = "setEnableNetworkTrace")
    public final void setEnableNetworkTrace(boolean z) {
        enableNetworkTrace = z;
    }
}
