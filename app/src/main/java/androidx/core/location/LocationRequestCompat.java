package androidx.core.location;

import androidx.core.util.TimeUtils;
import com.alibaba.griver.ui.ant.utils.AUScreenAdaptTool;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.jvm.internal.LongCompanionObject;

/* loaded from: classes6.dex */
public final class LocationRequestCompat {
    final int BuiltInFictitiousFunctionClassFactory;
    final float KClassImpl$Data$declaredNonStaticMembers$2;
    final long MyBillsEntityDataFactory;
    final long PlaceComponentResult;
    final long getAuthRequestContext;
    final long getErrorConfigVersion;
    final int scheduleImpl;

    /* loaded from: classes6.dex */
    public static final class Builder {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface Quality {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LocationRequestCompat) {
            LocationRequestCompat locationRequestCompat = (LocationRequestCompat) obj;
            return this.scheduleImpl == locationRequestCompat.scheduleImpl && this.MyBillsEntityDataFactory == locationRequestCompat.MyBillsEntityDataFactory && this.getErrorConfigVersion == locationRequestCompat.getErrorConfigVersion && this.PlaceComponentResult == locationRequestCompat.PlaceComponentResult && this.BuiltInFictitiousFunctionClassFactory == locationRequestCompat.BuiltInFictitiousFunctionClassFactory && Float.compare(locationRequestCompat.KClassImpl$Data$declaredNonStaticMembers$2, this.KClassImpl$Data$declaredNonStaticMembers$2) == 0 && this.getAuthRequestContext == locationRequestCompat.getAuthRequestContext;
        }
        return false;
    }

    public final int hashCode() {
        int i = this.scheduleImpl;
        long j = this.MyBillsEntityDataFactory;
        int i2 = (int) (j ^ (j >>> 32));
        long j2 = this.getErrorConfigVersion;
        return (((i * 31) + i2) * 31) + ((int) ((j2 >>> 32) ^ j2));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request[");
        if (this.MyBillsEntityDataFactory != LongCompanionObject.MAX_VALUE) {
            sb.append(AUScreenAdaptTool.PREFIX_ID);
            TimeUtils.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory, sb);
            int i = this.scheduleImpl;
            if (i == 100) {
                sb.append(" HIGH_ACCURACY");
            } else if (i == 102) {
                sb.append(" BALANCED");
            } else if (i == 104) {
                sb.append(" LOW_POWER");
            }
        } else {
            sb.append("PASSIVE");
        }
        if (this.PlaceComponentResult != LongCompanionObject.MAX_VALUE) {
            sb.append(", duration=");
            TimeUtils.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, sb);
        }
        if (this.BuiltInFictitiousFunctionClassFactory != Integer.MAX_VALUE) {
            sb.append(", maxUpdates=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
        }
        long j = this.getErrorConfigVersion;
        if (j != -1 && j < this.MyBillsEntityDataFactory) {
            sb.append(", minUpdateInterval=");
            TimeUtils.KClassImpl$Data$declaredNonStaticMembers$2(this.getErrorConfigVersion, sb);
        }
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            sb.append(", minUpdateDistance=");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        if (this.getAuthRequestContext / 2 > this.MyBillsEntityDataFactory) {
            sb.append(", maxUpdateDelay=");
            TimeUtils.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext, sb);
        }
        sb.append(']');
        return sb.toString();
    }

    /* loaded from: classes6.dex */
    static class Api31Impl {
        private Api31Impl() {
        }
    }

    /* loaded from: classes6.dex */
    static class Api19Impl {
        private Api19Impl() {
        }
    }
}
