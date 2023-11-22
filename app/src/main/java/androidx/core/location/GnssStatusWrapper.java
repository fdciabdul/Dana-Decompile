package androidx.core.location;

import android.location.GnssStatus;
import androidx.core.util.Preconditions;

/* loaded from: classes6.dex */
class GnssStatusWrapper extends GnssStatusCompat {
    private final GnssStatus getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GnssStatusWrapper(Object obj) {
        this.getAuthRequestContext = (GnssStatus) Preconditions.KClassImpl$Data$declaredNonStaticMembers$2((GnssStatus) obj);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GnssStatusWrapper) {
            return this.getAuthRequestContext.equals(((GnssStatusWrapper) obj).getAuthRequestContext);
        }
        return false;
    }

    public int hashCode() {
        return this.getAuthRequestContext.hashCode();
    }

    /* loaded from: classes6.dex */
    static class Api26Impl {
        private Api26Impl() {
        }
    }

    /* loaded from: classes6.dex */
    static class Api30Impl {
        private Api30Impl() {
        }
    }
}
