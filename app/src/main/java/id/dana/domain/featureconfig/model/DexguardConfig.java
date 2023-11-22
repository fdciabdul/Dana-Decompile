package id.dana.domain.featureconfig.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0003\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b"}, d2 = {"Lid/dana/domain/featureconfig/model/DexguardConfig;", "", "", "dexguardHookCheckEnabled", "Z", "getDexguardHookCheckEnabled", "()Z", "setDexguardHookCheckEnabled", "(Z)V", "dexguardRootCheckEnabled", "getDexguardRootCheckEnabled", "setDexguardRootCheckEnabled", "dexguardTamperCheckEnabled", "getDexguardTamperCheckEnabled", "setDexguardTamperCheckEnabled", "whitelistedDevice", "getWhitelistedDevice", "setWhitelistedDevice", "<init>", "(ZZZZ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class DexguardConfig {
    private boolean dexguardHookCheckEnabled;
    private boolean dexguardRootCheckEnabled;
    private boolean dexguardTamperCheckEnabled;
    private boolean whitelistedDevice;

    public DexguardConfig() {
        this(false, false, false, false, 15, null);
    }

    public DexguardConfig(boolean z, boolean z2, boolean z3, boolean z4) {
        this.dexguardRootCheckEnabled = z;
        this.dexguardHookCheckEnabled = z2;
        this.dexguardTamperCheckEnabled = z3;
        this.whitelistedDevice = z4;
    }

    public /* synthetic */ DexguardConfig(boolean z, boolean z2, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3, (i & 8) != 0 ? false : z4);
    }

    @JvmName(name = "getDexguardRootCheckEnabled")
    public final boolean getDexguardRootCheckEnabled() {
        return this.dexguardRootCheckEnabled;
    }

    @JvmName(name = "setDexguardRootCheckEnabled")
    public final void setDexguardRootCheckEnabled(boolean z) {
        this.dexguardRootCheckEnabled = z;
    }

    @JvmName(name = "getDexguardHookCheckEnabled")
    public final boolean getDexguardHookCheckEnabled() {
        return this.dexguardHookCheckEnabled;
    }

    @JvmName(name = "setDexguardHookCheckEnabled")
    public final void setDexguardHookCheckEnabled(boolean z) {
        this.dexguardHookCheckEnabled = z;
    }

    @JvmName(name = "getDexguardTamperCheckEnabled")
    public final boolean getDexguardTamperCheckEnabled() {
        return this.dexguardTamperCheckEnabled;
    }

    @JvmName(name = "setDexguardTamperCheckEnabled")
    public final void setDexguardTamperCheckEnabled(boolean z) {
        this.dexguardTamperCheckEnabled = z;
    }

    @JvmName(name = "getWhitelistedDevice")
    public final boolean getWhitelistedDevice() {
        return this.whitelistedDevice;
    }

    @JvmName(name = "setWhitelistedDevice")
    public final void setWhitelistedDevice(boolean z) {
        this.whitelistedDevice = z;
    }
}
