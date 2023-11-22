package id.dana.utils.config.model;

import com.alibaba.fastjson.annotation.JSONField;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0011\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0012\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0013\u001a\u00020\u0006¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0011\u0010\u000f\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0011\u0010\f\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\r"}, d2 = {"Lid/dana/utils/config/model/Display;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "PlaceComponentResult", "I", "KClassImpl$Data$declaredNonStaticMembers$2", "BuiltInFictitiousFunctionClassFactory", "MyBillsEntityDataFactory", "p1", "p2", "p3", "<init>", "(IIII)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class Display {
    public int BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public int PlaceComponentResult;
    public int MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public int KClassImpl$Data$declaredNonStaticMembers$2;

    public /* synthetic */ Display() {
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof Display) {
            Display display = (Display) p0;
            return this.KClassImpl$Data$declaredNonStaticMembers$2 == display.KClassImpl$Data$declaredNonStaticMembers$2 && this.BuiltInFictitiousFunctionClassFactory == display.BuiltInFictitiousFunctionClassFactory && this.MyBillsEntityDataFactory == display.MyBillsEntityDataFactory && this.PlaceComponentResult == display.PlaceComponentResult;
        }
        return false;
    }

    public final int hashCode() {
        return (((((this.KClassImpl$Data$declaredNonStaticMembers$2 * 31) + this.BuiltInFictitiousFunctionClassFactory) * 31) + this.MyBillsEntityDataFactory) * 31) + this.PlaceComponentResult;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Display(KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(')');
        return sb.toString();
    }

    public Display(@JSONField(name = "density") int i, @JSONField(name = "dpi") int i2, @JSONField(name = "height") int i3, @JSONField(name = "width") int i4) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        this.BuiltInFictitiousFunctionClassFactory = i2;
        this.MyBillsEntityDataFactory = i3;
        this.PlaceComponentResult = i4;
    }
}
