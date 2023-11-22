package id.dana.data.recurring.subscription.source.network.response;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u000eX\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u0012\u0010\rR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u0013\u0010\rR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\rR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u0014\u0010\rR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u0016\u0010\rR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u0017\u0010\rR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u000eX\u0006¢\u0006\u0006\n\u0004\b\u0015\u0010\u0010R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u0018\u0010\r"}, d2 = {"Lid/dana/data/recurring/subscription/source/network/response/BillView;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "Lid/dana/data/recurring/subscription/source/network/response/Amount;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/data/recurring/subscription/source/network/response/Amount;", "getAuthRequestContext", "PlaceComponentResult", "MyBillsEntityDataFactory", "getErrorConfigVersion", "lookAheadTest", "scheduleImpl", "moveToNextValue", "NetworkUserEntityData$$ExternalSyntheticLambda0"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class BillView {
    public final String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final Amount getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final String PlaceComponentResult;
    public final String NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final String MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public final String lookAheadTest;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public final Amount getErrorConfigVersion;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public final String scheduleImpl;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public final String moveToNextValue;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof BillView) {
            BillView billView = (BillView) p0;
            return Intrinsics.areEqual(this.scheduleImpl, billView.scheduleImpl) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, billView.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, billView.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.PlaceComponentResult, billView.PlaceComponentResult) && Intrinsics.areEqual(this.lookAheadTest, billView.lookAheadTest) && Intrinsics.areEqual(this.getAuthRequestContext, billView.getAuthRequestContext) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda0, billView.NetworkUserEntityData$$ExternalSyntheticLambda0) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, billView.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.getErrorConfigVersion, billView.getErrorConfigVersion) && Intrinsics.areEqual(this.moveToNextValue, billView.moveToNextValue);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.scheduleImpl;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.BuiltInFictitiousFunctionClassFactory;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.MyBillsEntityDataFactory;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.PlaceComponentResult;
        int hashCode4 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.lookAheadTest;
        int hashCode5 = str5 == null ? 0 : str5.hashCode();
        Amount amount = this.getAuthRequestContext;
        int hashCode6 = amount == null ? 0 : amount.hashCode();
        String str6 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        int hashCode7 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int hashCode8 = str7 == null ? 0 : str7.hashCode();
        Amount amount2 = this.getErrorConfigVersion;
        int hashCode9 = amount2 == null ? 0 : amount2.hashCode();
        String str8 = this.moveToNextValue;
        return (((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + (str8 != null ? str8.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BillView(scheduleImpl=");
        sb.append(this.scheduleImpl);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", lookAheadTest=");
        sb.append(this.lookAheadTest);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda0=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", getErrorConfigVersion=");
        sb.append(this.getErrorConfigVersion);
        sb.append(", moveToNextValue=");
        sb.append(this.moveToNextValue);
        sb.append(')');
        return sb.toString();
    }
}
