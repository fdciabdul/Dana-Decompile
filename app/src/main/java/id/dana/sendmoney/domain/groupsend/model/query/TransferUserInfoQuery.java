package id.dana.sendmoney.domain.groupsend.model.query;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\t¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0011\u0010\u0010\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\r"}, d2 = {"Lid/dana/sendmoney/domain/groupsend/model/query/TransferUserInfoQuery;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "getAuthRequestContext", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "MyBillsEntityDataFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "p1", "p2", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final /* data */ class TransferUserInfoQuery {
    public final String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final String KClassImpl$Data$declaredNonStaticMembers$2;
    public final String getAuthRequestContext;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof TransferUserInfoQuery) {
            TransferUserInfoQuery transferUserInfoQuery = (TransferUserInfoQuery) p0;
            return Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, transferUserInfoQuery.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, transferUserInfoQuery.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.getAuthRequestContext, transferUserInfoQuery.getAuthRequestContext);
        }
        return false;
    }

    public final int hashCode() {
        return (((this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode() * 31) + this.BuiltInFictitiousFunctionClassFactory.hashCode()) * 31) + this.getAuthRequestContext.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TransferUserInfoQuery(KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(')');
        return sb.toString();
    }

    public TransferUserInfoQuery(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        this.BuiltInFictitiousFunctionClassFactory = str2;
        this.getAuthRequestContext = str3;
    }
}
