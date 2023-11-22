package id.dana.sync_engine.domain.model;

import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\u00038\u0007¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000eR\u001a\u0010\u0011\u001a\u00020\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\f\u001a\u00020\u0012X\u0007¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014"}, d2 = {"Lid/dana/sync_engine/domain/model/SyncPermissionAndChangeConfig;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "Z", "()Z", "getAuthRequestContext", "PlaceComponentResult", "BuiltInFictitiousFunctionClassFactory", "", "MyBillsEntityDataFactory", "J", "p1", "p2", "<init>", "(JZZ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SyncPermissionAndChangeConfig {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final boolean getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final long KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final boolean BuiltInFictitiousFunctionClassFactory;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof SyncPermissionAndChangeConfig) {
            SyncPermissionAndChangeConfig syncPermissionAndChangeConfig = (SyncPermissionAndChangeConfig) p0;
            return this.KClassImpl$Data$declaredNonStaticMembers$2 == syncPermissionAndChangeConfig.KClassImpl$Data$declaredNonStaticMembers$2 && this.getAuthRequestContext == syncPermissionAndChangeConfig.getAuthRequestContext && this.BuiltInFictitiousFunctionClassFactory == syncPermissionAndChangeConfig.BuiltInFictitiousFunctionClassFactory;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int m = Cbor$Arg$$ExternalSyntheticBackport0.m(this.KClassImpl$Data$declaredNonStaticMembers$2);
        boolean z = this.getAuthRequestContext;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        boolean z2 = this.BuiltInFictitiousFunctionClassFactory;
        return (((m * 31) + i) * 31) + (z2 ? 1 : z2 ? 1 : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SyncPermissionAndChangeConfig(KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(')');
        return sb.toString();
    }

    public SyncPermissionAndChangeConfig(long j, boolean z, boolean z2) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = j;
        this.getAuthRequestContext = z;
        this.BuiltInFictitiousFunctionClassFactory = z2;
    }

    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
    public final boolean getGetAuthRequestContext() {
        return this.getAuthRequestContext;
    }

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    public final boolean getBuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
