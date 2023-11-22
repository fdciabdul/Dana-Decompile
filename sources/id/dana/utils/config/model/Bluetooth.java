package id.dana.utils.config.model;

import com.alibaba.fastjson.annotation.JSONField;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0001\u0010\u0002\u001a\u00020\t\u0012\b\b\u0001\u0010\u0014\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0017\u001a\u00020\u0006¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0011\u001a\u00020\u0003X\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0011\u0010\f\u001a\u00020\u0003X\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u0013\u0010\u000f"}, d2 = {"Lid/dana/utils/config/model/Bluetooth;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "MyBillsEntityDataFactory", "Ljava/lang/String;", "PlaceComponentResult", "I", "getAuthRequestContext", "BuiltInFictitiousFunctionClassFactory", "Z", "KClassImpl$Data$declaredNonStaticMembers$2", "p1", "p2", "p3", "p4", "<init>", "(Ljava/lang/String;IZZI)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class Bluetooth {
    public boolean BuiltInFictitiousFunctionClassFactory;
    public int KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public String PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public int getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public boolean MyBillsEntityDataFactory;

    public /* synthetic */ Bluetooth() {
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof Bluetooth) {
            Bluetooth bluetooth = (Bluetooth) p0;
            return Intrinsics.areEqual(this.PlaceComponentResult, bluetooth.PlaceComponentResult) && this.getAuthRequestContext == bluetooth.getAuthRequestContext && this.BuiltInFictitiousFunctionClassFactory == bluetooth.BuiltInFictitiousFunctionClassFactory && this.MyBillsEntityDataFactory == bluetooth.MyBillsEntityDataFactory && this.KClassImpl$Data$declaredNonStaticMembers$2 == bluetooth.KClassImpl$Data$declaredNonStaticMembers$2;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.PlaceComponentResult.hashCode();
        int i = this.getAuthRequestContext;
        boolean z = this.BuiltInFictitiousFunctionClassFactory;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        boolean z2 = this.MyBillsEntityDataFactory;
        return (((((((hashCode * 31) + i) * 31) + i2) * 31) + (z2 ? 1 : z2 ? 1 : 0)) * 31) + this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Bluetooth(PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(')');
        return sb.toString();
    }

    public Bluetooth(@JSONField(name = "address") String str, @JSONField(name = "bondState") int i, @JSONField(name = "isBounded") boolean z, @JSONField(name = "isBounding") boolean z2, @JSONField(name = "type") int i2) {
        Intrinsics.checkNotNullParameter(str, "");
        this.PlaceComponentResult = str;
        this.getAuthRequestContext = i;
        this.BuiltInFictitiousFunctionClassFactory = z;
        this.MyBillsEntityDataFactory = z2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i2;
    }
}
