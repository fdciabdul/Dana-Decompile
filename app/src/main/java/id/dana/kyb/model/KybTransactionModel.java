package id.dana.kyb.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\t\u0012\u0006\u0010\u001a\u001a\u00020\u0016\u0012\u0006\u0010\u001b\u001a\u00020\t\u0012\u0006\u0010\u001c\u001a\u00020\t\u0012\u0006\u0010\u001d\u001a\u00020\t\u0012\u0006\u0010\u001e\u001a\u00020\t\u0012\u0006\u0010\u001f\u001a\u00020\t¢\u0006\u0004\b \u0010!J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00038\u0007¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\u0010R\u0011\u0010\u0013\u001a\u00020\tX\u0007¢\u0006\u0006\n\u0004\b\u0012\u0010\rR\u0011\u0010\u0014\u001a\u00020\tX\u0007¢\u0006\u0006\n\u0004\b\u0014\u0010\rR\u0011\u0010\u0012\u001a\u00020\tX\u0007¢\u0006\u0006\n\u0004\b\u0013\u0010\rR\u0011\u0010\u0015\u001a\u00020\tX\u0007¢\u0006\u0006\n\u0004\b\u0011\u0010\rR\u0011\u0010\u0017\u001a\u00020\u0016X\u0007¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000e\u001a\u00020\tX\u0007¢\u0006\u0006\n\u0004\b\u0015\u0010\r"}, d2 = {"Lid/dana/kyb/model/KybTransactionModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "getErrorConfigVersion", "Z", "()Z", "KClassImpl$Data$declaredNonStaticMembers$2", "getAuthRequestContext", "MyBillsEntityDataFactory", "PlaceComponentResult", "scheduleImpl", "Lid/dana/kyb/model/KybOrderTypeModel;", "lookAheadTest", "Lid/dana/kyb/model/KybOrderTypeModel;", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "<init>", "(ZLjava/lang/String;Lid/dana/kyb/model/KybOrderTypeModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class KybTransactionModel {
    public final String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final String scheduleImpl;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final String getAuthRequestContext;
    public final String PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String MyBillsEntityDataFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final boolean KClassImpl$Data$declaredNonStaticMembers$2;
    public final KybOrderTypeModel lookAheadTest;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public final String getErrorConfigVersion;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof KybTransactionModel) {
            KybTransactionModel kybTransactionModel = (KybTransactionModel) p0;
            return this.KClassImpl$Data$declaredNonStaticMembers$2 == kybTransactionModel.KClassImpl$Data$declaredNonStaticMembers$2 && Intrinsics.areEqual(this.MyBillsEntityDataFactory, kybTransactionModel.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.lookAheadTest, kybTransactionModel.lookAheadTest) && Intrinsics.areEqual(this.scheduleImpl, kybTransactionModel.scheduleImpl) && Intrinsics.areEqual(this.getAuthRequestContext, kybTransactionModel.getAuthRequestContext) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, kybTransactionModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.getErrorConfigVersion, kybTransactionModel.getErrorConfigVersion) && Intrinsics.areEqual(this.PlaceComponentResult, kybTransactionModel.PlaceComponentResult);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    public final int hashCode() {
        boolean z = this.KClassImpl$Data$declaredNonStaticMembers$2;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (((((((((((((r0 * 31) + this.MyBillsEntityDataFactory.hashCode()) * 31) + this.lookAheadTest.hashCode()) * 31) + this.scheduleImpl.hashCode()) * 31) + this.getAuthRequestContext.hashCode()) * 31) + this.BuiltInFictitiousFunctionClassFactory.hashCode()) * 31) + this.getErrorConfigVersion.hashCode()) * 31) + this.PlaceComponentResult.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KybTransactionModel(KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", lookAheadTest=");
        sb.append(this.lookAheadTest);
        sb.append(", scheduleImpl=");
        sb.append(this.scheduleImpl);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", getErrorConfigVersion=");
        sb.append(this.getErrorConfigVersion);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(')');
        return sb.toString();
    }

    public KybTransactionModel(boolean z, String str, KybOrderTypeModel kybOrderTypeModel, String str2, String str3, String str4, String str5, String str6) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(kybOrderTypeModel, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
        this.MyBillsEntityDataFactory = str;
        this.lookAheadTest = kybOrderTypeModel;
        this.scheduleImpl = str2;
        this.getAuthRequestContext = str3;
        this.BuiltInFictitiousFunctionClassFactory = str4;
        this.getErrorConfigVersion = str5;
        this.PlaceComponentResult = str6;
    }

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    public final boolean getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
