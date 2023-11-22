package id.dana.familyaccount.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u00038\u0007X\u0086\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000eR\u0011\u0010\u0012\u001a\u00020\tX\u0007¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0010\u001a\u00020\tX\u0007¢\u0006\u0006\n\u0004\b\u000f\u0010\u0011"}, d2 = {"Lid/dana/familyaccount/model/TransactionHistoryModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "MyBillsEntityDataFactory", "Z", "()Z", "BuiltInFictitiousFunctionClassFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "getAuthRequestContext", "p1", "p2", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class TransactionHistoryModel {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final String getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public boolean BuiltInFictitiousFunctionClassFactory;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof TransactionHistoryModel) {
            TransactionHistoryModel transactionHistoryModel = (TransactionHistoryModel) p0;
            return Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, transactionHistoryModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.getAuthRequestContext, transactionHistoryModel.getAuthRequestContext) && this.BuiltInFictitiousFunctionClassFactory == transactionHistoryModel.BuiltInFictitiousFunctionClassFactory;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode();
        int hashCode2 = this.getAuthRequestContext.hashCode();
        boolean z = this.BuiltInFictitiousFunctionClassFactory;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return (((hashCode * 31) + hashCode2) * 31) + i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TransactionHistoryModel(KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(')');
        return sb.toString();
    }

    public TransactionHistoryModel(String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        this.getAuthRequestContext = str2;
        this.BuiltInFictitiousFunctionClassFactory = z;
    }

    @JvmName(name = "MyBillsEntityDataFactory")
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final boolean getBuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    public static /* synthetic */ TransactionHistoryModel KClassImpl$Data$declaredNonStaticMembers$2(TransactionHistoryModel transactionHistoryModel, boolean z) {
        String str = transactionHistoryModel.KClassImpl$Data$declaredNonStaticMembers$2;
        String str2 = transactionHistoryModel.getAuthRequestContext;
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        return new TransactionHistoryModel(str, str2, z);
    }
}
