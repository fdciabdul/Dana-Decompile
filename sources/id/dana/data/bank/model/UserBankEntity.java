package id.dana.data.bank.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0011\u0010\u0010\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0011\u0010\u0011\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\rR\u0011\u0010\u000f\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0011\u0010\u0013\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u0012\u0010\rR\u0011\u0010\u0012\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u0014\u0010\r"}, d2 = {"Lid/dana/data/bank/model/UserBankEntity;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "getAuthRequestContext", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "MyBillsEntityDataFactory", "PlaceComponentResult", "BuiltInFictitiousFunctionClassFactory", "moveToNextValue", "lookAheadTest", "getErrorConfigVersion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final /* data */ class UserBankEntity {
    public final String BuiltInFictitiousFunctionClassFactory;
    public final String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final String PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final String MyBillsEntityDataFactory;
    public final String getAuthRequestContext;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public final String moveToNextValue;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public final String lookAheadTest;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof UserBankEntity) {
            UserBankEntity userBankEntity = (UserBankEntity) p0;
            return Intrinsics.areEqual(this.PlaceComponentResult, userBankEntity.PlaceComponentResult) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, userBankEntity.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.getAuthRequestContext, userBankEntity.getAuthRequestContext) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, userBankEntity.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.lookAheadTest, userBankEntity.lookAheadTest) && Intrinsics.areEqual(this.moveToNextValue, userBankEntity.moveToNextValue) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, userBankEntity.MyBillsEntityDataFactory);
        }
        return false;
    }

    public final int hashCode() {
        return (((((((((((this.PlaceComponentResult.hashCode() * 31) + this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode()) * 31) + this.getAuthRequestContext.hashCode()) * 31) + this.BuiltInFictitiousFunctionClassFactory.hashCode()) * 31) + this.lookAheadTest.hashCode()) * 31) + this.moveToNextValue.hashCode()) * 31) + this.MyBillsEntityDataFactory.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UserBankEntity(PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", lookAheadTest=");
        sb.append(this.lookAheadTest);
        sb.append(", moveToNextValue=");
        sb.append(this.moveToNextValue);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(')');
        return sb.toString();
    }
}
