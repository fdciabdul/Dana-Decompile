package id.dana.sendmoney.domain.groupsend.model.submit;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0006X\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\r"}, d2 = {"Lid/dana/sendmoney/domain/groupsend/model/submit/Milestone;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "PlaceComponentResult", "Ljava/lang/String;", "MyBillsEntityDataFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/Integer;", "BuiltInFictitiousFunctionClassFactory", "getAuthRequestContext", "p1", "p2", "p3", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class Milestone {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final String getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final Integer BuiltInFictitiousFunctionClassFactory;
    public final String MyBillsEntityDataFactory;
    public final String PlaceComponentResult;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof Milestone) {
            Milestone milestone = (Milestone) p0;
            return Intrinsics.areEqual(this.getAuthRequestContext, milestone.getAuthRequestContext) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, milestone.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.PlaceComponentResult, milestone.PlaceComponentResult) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, milestone.MyBillsEntityDataFactory);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.getAuthRequestContext;
        int hashCode = str == null ? 0 : str.hashCode();
        Integer num = this.BuiltInFictitiousFunctionClassFactory;
        int hashCode2 = num == null ? 0 : num.hashCode();
        String str2 = this.PlaceComponentResult;
        int hashCode3 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.MyBillsEntityDataFactory;
        return (((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Milestone(getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(')');
        return sb.toString();
    }

    public Milestone(String str, Integer num, String str2, String str3) {
        this.getAuthRequestContext = str;
        this.BuiltInFictitiousFunctionClassFactory = num;
        this.PlaceComponentResult = str2;
        this.MyBillsEntityDataFactory = str3;
    }
}
