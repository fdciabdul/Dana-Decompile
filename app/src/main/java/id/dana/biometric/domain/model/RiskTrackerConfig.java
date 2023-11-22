package id.dana.biometric.domain.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0006¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u0010\u001a\u00020\u00038\u0007X\u0086\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\f\u001a\u00020\u00038\u0007X\u0087\u0006¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0012\u001a\u00020\u00038\u0007X\u0087\u0006¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0010\u0010\u000fR\u001a\u0010\u0011\u001a\u00020\u00038\u0007X\u0087\u0006¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0012\u0010\u000fR\u0012\u0010\u000e\u001a\u00020\u0006X\u0087\u0002¢\u0006\u0006\n\u0004\b\u000e\u0010\u0013"}, d2 = {"Lid/dana/biometric/domain/model/RiskTrackerConfig;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "Z", "BuiltInFictitiousFunctionClassFactory", "()Z", "PlaceComponentResult", "getAuthRequestContext", "MyBillsEntityDataFactory", "I", "p1", "p2", "p3", "p4", "<init>", "(ZZZZI)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class RiskTrackerConfig {
    public int BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private boolean PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private boolean getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private boolean MyBillsEntityDataFactory;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof RiskTrackerConfig) {
            RiskTrackerConfig riskTrackerConfig = (RiskTrackerConfig) p0;
            return this.PlaceComponentResult == riskTrackerConfig.PlaceComponentResult && this.MyBillsEntityDataFactory == riskTrackerConfig.MyBillsEntityDataFactory && this.KClassImpl$Data$declaredNonStaticMembers$2 == riskTrackerConfig.KClassImpl$Data$declaredNonStaticMembers$2 && this.getAuthRequestContext == riskTrackerConfig.getAuthRequestContext && this.BuiltInFictitiousFunctionClassFactory == riskTrackerConfig.BuiltInFictitiousFunctionClassFactory;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v0, types: [boolean] */
    public final int hashCode() {
        boolean z = this.PlaceComponentResult;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        ?? r2 = this.MyBillsEntityDataFactory;
        int i = r2;
        if (r2 != 0) {
            i = 1;
        }
        ?? r3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int i2 = r3;
        if (r3 != 0) {
            i2 = 1;
        }
        boolean z2 = this.getAuthRequestContext;
        return (((((((r0 * 31) + i) * 31) + i2) * 31) + (z2 ? 1 : z2 ? 1 : 0)) * 31) + this.BuiltInFictitiousFunctionClassFactory;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RiskTrackerConfig(PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(')');
        return sb.toString();
    }

    public RiskTrackerConfig(boolean z, boolean z2, boolean z3, boolean z4, int i) {
        this.PlaceComponentResult = z;
        this.MyBillsEntityDataFactory = z2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = z3;
        this.getAuthRequestContext = z4;
        this.BuiltInFictitiousFunctionClassFactory = i;
    }

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    public final boolean getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }

    @JvmName(name = "PlaceComponentResult")
    /* renamed from: PlaceComponentResult  reason: from getter */
    public final boolean getMyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }

    @JvmName(name = "getAuthRequestContext")
    /* renamed from: getAuthRequestContext  reason: from getter */
    public final boolean getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @JvmName(name = "MyBillsEntityDataFactory")
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final boolean getGetAuthRequestContext() {
        return this.getAuthRequestContext;
    }
}
