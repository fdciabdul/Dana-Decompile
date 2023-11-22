package id.dana.data.miniprogram.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\t\u0012\b\b\u0002\u0010\u0012\u001a\u00020\t\u0012\b\b\u0002\u0010\u0013\u001a\u00020\t\u0012\b\b\u0002\u0010\u0014\u001a\u00020\t¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\tX\u0086\u0002¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0012\u0010\u000f\u001a\u00020\tX\u0086\u0002¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0012\u0010\u0011\u001a\u00020\tX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0012\u0010\u000e\u001a\u00020\tX\u0086\u0002¢\u0006\u0006\n\u0004\b\u000f\u0010\r"}, d2 = {"Lid/dana/data/miniprogram/model/MiniProgramEntity;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "getAuthRequestContext", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "PlaceComponentResult", "BuiltInFictitiousFunctionClassFactory", "MyBillsEntityDataFactory", "p1", "p2", "p3", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class MiniProgramEntity {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public String MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public String PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public String KClassImpl$Data$declaredNonStaticMembers$2;
    public String getAuthRequestContext;

    public MiniProgramEntity() {
        this(null, null, null, null, 15, null);
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof MiniProgramEntity) {
            MiniProgramEntity miniProgramEntity = (MiniProgramEntity) p0;
            return Intrinsics.areEqual(this.getAuthRequestContext, miniProgramEntity.getAuthRequestContext) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, miniProgramEntity.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.PlaceComponentResult, miniProgramEntity.PlaceComponentResult) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, miniProgramEntity.MyBillsEntityDataFactory);
        }
        return false;
    }

    public final int hashCode() {
        return (((((this.getAuthRequestContext.hashCode() * 31) + this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode()) * 31) + this.PlaceComponentResult.hashCode()) * 31) + this.MyBillsEntityDataFactory.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MiniProgramEntity(getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(')');
        return sb.toString();
    }

    public MiniProgramEntity(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        this.getAuthRequestContext = str;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str2;
        this.PlaceComponentResult = str3;
        this.MyBillsEntityDataFactory = str4;
    }

    public /* synthetic */ MiniProgramEntity(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4);
    }
}
