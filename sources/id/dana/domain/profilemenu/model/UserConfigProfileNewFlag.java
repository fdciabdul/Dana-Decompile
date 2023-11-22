package id.dana.domain.profilemenu.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0003\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b"}, d2 = {"Lid/dana/domain/profilemenu/model/UserConfigProfileNewFlag;", "Ljava/io/Serializable;", "", "shouldShowResolutionCenterFlag", "Z", "getShouldShowResolutionCenterFlag", "()Z", "setShouldShowResolutionCenterFlag", "(Z)V", "shouldShowSmartPayFlag", "getShouldShowSmartPayFlag", "setShouldShowSmartPayFlag", "<init>", "(ZZ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class UserConfigProfileNewFlag implements Serializable {
    private boolean shouldShowResolutionCenterFlag;
    private boolean shouldShowSmartPayFlag;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public UserConfigProfileNewFlag() {
        /*
            r3 = this;
            r0 = 0
            r1 = 3
            r2 = 0
            r3.<init>(r0, r0, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.profilemenu.model.UserConfigProfileNewFlag.<init>():void");
    }

    public UserConfigProfileNewFlag(boolean z, boolean z2) {
        this.shouldShowSmartPayFlag = z;
        this.shouldShowResolutionCenterFlag = z2;
    }

    public /* synthetic */ UserConfigProfileNewFlag(boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2);
    }

    @JvmName(name = "getShouldShowSmartPayFlag")
    public final boolean getShouldShowSmartPayFlag() {
        return this.shouldShowSmartPayFlag;
    }

    @JvmName(name = "setShouldShowSmartPayFlag")
    public final void setShouldShowSmartPayFlag(boolean z) {
        this.shouldShowSmartPayFlag = z;
    }

    @JvmName(name = "getShouldShowResolutionCenterFlag")
    public final boolean getShouldShowResolutionCenterFlag() {
        return this.shouldShowResolutionCenterFlag;
    }

    @JvmName(name = "setShouldShowResolutionCenterFlag")
    public final void setShouldShowResolutionCenterFlag(boolean z) {
        this.shouldShowResolutionCenterFlag = z;
    }
}
