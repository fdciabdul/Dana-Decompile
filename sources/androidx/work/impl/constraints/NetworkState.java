package androidx.work.impl.constraints;

/* loaded from: classes3.dex */
public class NetworkState {
    private boolean BuiltInFictitiousFunctionClassFactory;
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;
    private boolean MyBillsEntityDataFactory;
    private boolean PlaceComponentResult;

    public NetworkState(boolean z, boolean z2, boolean z3, boolean z4) {
        this.BuiltInFictitiousFunctionClassFactory = z;
        this.PlaceComponentResult = z2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = z3;
        this.MyBillsEntityDataFactory = z4;
    }

    public final boolean getAuthRequestContext() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    public final boolean PlaceComponentResult() {
        return this.PlaceComponentResult;
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public final boolean MyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NetworkState) {
            NetworkState networkState = (NetworkState) obj;
            return this.BuiltInFictitiousFunctionClassFactory == networkState.BuiltInFictitiousFunctionClassFactory && this.PlaceComponentResult == networkState.PlaceComponentResult && this.KClassImpl$Data$declaredNonStaticMembers$2 == networkState.KClassImpl$Data$declaredNonStaticMembers$2 && this.MyBillsEntityDataFactory == networkState.MyBillsEntityDataFactory;
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public int hashCode() {
        ?? r0 = this.BuiltInFictitiousFunctionClassFactory;
        int i = r0;
        if (this.PlaceComponentResult) {
            i = r0 + 16;
        }
        int i2 = i;
        if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            i2 = i + 256;
        }
        return this.MyBillsEntityDataFactory ? i2 + 4096 : i2;
    }

    public String toString() {
        return String.format("[ Connected=%b Validated=%b Metered=%b NotRoaming=%b ]", Boolean.valueOf(this.BuiltInFictitiousFunctionClassFactory), Boolean.valueOf(this.PlaceComponentResult), Boolean.valueOf(this.KClassImpl$Data$declaredNonStaticMembers$2), Boolean.valueOf(this.MyBillsEntityDataFactory));
    }
}
