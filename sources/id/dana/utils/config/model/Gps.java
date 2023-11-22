package id.dana.utils.config.model;

import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import com.alibaba.fastjson.annotation.JSONField;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0001\u0010\u0002\u001a\u00020\t\u0012\b\b\u0001\u0010\u0015\u001a\u00020\t\u0012\b\b\u0001\u0010\u0016\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0017\u001a\u00020\u0012¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0011\u0010\u0010\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0011\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0013\u001a\u00020\u0012X\u0006¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014"}, d2 = {"Lid/dana/utils/config/model/Gps;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "I", "MyBillsEntityDataFactory", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "getAuthRequestContext", "", "PlaceComponentResult", "J", "p1", "p2", "p3", "<init>", "(Ljava/lang/String;Ljava/lang/String;IJ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class Gps {
    public int KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public String BuiltInFictitiousFunctionClassFactory;
    public long PlaceComponentResult;
    public String getAuthRequestContext;

    public /* synthetic */ Gps() {
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof Gps) {
            Gps gps = (Gps) p0;
            return Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, gps.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.getAuthRequestContext, gps.getAuthRequestContext) && this.KClassImpl$Data$declaredNonStaticMembers$2 == gps.KClassImpl$Data$declaredNonStaticMembers$2 && this.PlaceComponentResult == gps.PlaceComponentResult;
        }
        return false;
    }

    public final int hashCode() {
        return (((((this.BuiltInFictitiousFunctionClassFactory.hashCode() * 31) + this.getAuthRequestContext.hashCode()) * 31) + this.KClassImpl$Data$declaredNonStaticMembers$2) * 31) + Cbor$Arg$$ExternalSyntheticBackport0.m(this.PlaceComponentResult);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Gps(BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(')');
        return sb.toString();
    }

    public Gps(@JSONField(name = "latitude") String str, @JSONField(name = "longitude") String str2, @JSONField(name = "error") int i, @JSONField(name = "time") long j) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.BuiltInFictitiousFunctionClassFactory = str;
        this.getAuthRequestContext = str2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        this.PlaceComponentResult = j;
    }
}
