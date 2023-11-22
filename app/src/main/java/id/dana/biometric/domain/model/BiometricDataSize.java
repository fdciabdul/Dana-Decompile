package id.dana.biometric.domain.model;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import id.dana.sendmoney.summary.SummaryActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\f\u0012\b\b\u0002\u0010\u0013\u001a\u00020\f\u0012\b\b\u0002\u0010\u0014\u001a\u00020\f¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u000f\u001a\u00020\fX\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0011\u0010\u0010\u001a\u00020\fX\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0012\u001a\u00020\fX\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\u000e"}, d2 = {"Lid/dana/biometric/domain/model/BiometricDataSize;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "", "getAuthRequestContext", SummaryActivity.DAYS, "BuiltInFictitiousFunctionClassFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "PlaceComponentResult", "MyBillsEntityDataFactory", "p1", "p2", "<init>", "(DDD)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class BiometricDataSize {
    public final double KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final double MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final double BuiltInFictitiousFunctionClassFactory;

    public BiometricDataSize() {
        this(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 7, null);
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof BiometricDataSize) {
            BiometricDataSize biometricDataSize = (BiometricDataSize) p0;
            return Intrinsics.areEqual((Object) Double.valueOf(this.KClassImpl$Data$declaredNonStaticMembers$2), (Object) Double.valueOf(biometricDataSize.KClassImpl$Data$declaredNonStaticMembers$2)) && Intrinsics.areEqual((Object) Double.valueOf(this.BuiltInFictitiousFunctionClassFactory), (Object) Double.valueOf(biometricDataSize.BuiltInFictitiousFunctionClassFactory)) && Intrinsics.areEqual((Object) Double.valueOf(this.MyBillsEntityDataFactory), (Object) Double.valueOf(biometricDataSize.MyBillsEntityDataFactory));
        }
        return false;
    }

    public final int hashCode() {
        return (((BiometricDataSize$$ExternalSyntheticBackport0.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2) * 31) + BiometricDataSize$$ExternalSyntheticBackport0.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory)) * 31) + BiometricDataSize$$ExternalSyntheticBackport0.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BiometricDataSize(KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(')');
        return sb.toString();
    }

    public BiometricDataSize(double d, double d2, double d3) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = d;
        this.BuiltInFictitiousFunctionClassFactory = d2;
        this.MyBillsEntityDataFactory = d3;
    }

    public /* synthetic */ BiometricDataSize(double d, double d2, double d3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0.0d : d, (i & 2) != 0 ? 0.0d : d2, (i & 4) != 0 ? 0.0d : d3);
    }
}
