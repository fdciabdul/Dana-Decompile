package id.dana.sendmoney.domain.groupsend.model.init;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\t\u0012\u0006\u0010\u0019\u001a\u00020\t\u0012\u0006\u0010\u001a\u001a\u00020\t\u0012\u0006\u0010\u001b\u001a\u00020\t\u0012\u0006\u0010\u001c\u001a\u00020\t\u0012\u0006\u0010\u001d\u001a\u00020\t\u0012\u0006\u0010\u001e\u001a\u00020\t\u0012\u0006\u0010\u001f\u001a\u00020\u0003\u0012\b\u0010 \u001a\u0004\u0018\u00010\t¢\u0006\u0004\b!\u0010\"J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00038\u0007¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0010\u001a\u00020\tX\u0007¢\u0006\u0006\n\u0004\b\u0013\u0010\rR\u0011\u0010\u0013\u001a\u00020\tX\u0007¢\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0011\u0010\u0014\u001a\u00020\tX\u0007¢\u0006\u0006\n\u0004\b\u0012\u0010\rR\u0011\u0010\u0015\u001a\u00020\tX\u0007¢\u0006\u0006\n\u0004\b\u0014\u0010\rR\u0011\u0010\u000e\u001a\u00020\tX\u0007¢\u0006\u0006\n\u0004\b\u0016\u0010\rR\u0011\u0010\u0016\u001a\u00020\tX\u0007¢\u0006\u0006\n\u0004\b\u0017\u0010\rR\u0011\u0010\u0018\u001a\u00020\tX\u0007¢\u0006\u0006\n\u0004\b\u0015\u0010\r"}, d2 = {"Lid/dana/sendmoney/domain/groupsend/model/init/PayeeUserInfo;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "getAuthRequestContext", "Ljava/lang/String;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Z", "BuiltInFictitiousFunctionClassFactory", "()Z", "MyBillsEntityDataFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "PlaceComponentResult", "moveToNextValue", "lookAheadTest", "getErrorConfigVersion", "scheduleImpl", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PayeeUserInfo {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final String PlaceComponentResult;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final boolean MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final String moveToNextValue;
    public final String getAuthRequestContext;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public final String lookAheadTest;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public final String scheduleImpl;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof PayeeUserInfo) {
            PayeeUserInfo payeeUserInfo = (PayeeUserInfo) p0;
            return Intrinsics.areEqual(this.scheduleImpl, payeeUserInfo.scheduleImpl) && Intrinsics.areEqual(this.moveToNextValue, payeeUserInfo.moveToNextValue) && Intrinsics.areEqual(this.PlaceComponentResult, payeeUserInfo.PlaceComponentResult) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, payeeUserInfo.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, payeeUserInfo.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.lookAheadTest, payeeUserInfo.lookAheadTest) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda0, payeeUserInfo.NetworkUserEntityData$$ExternalSyntheticLambda0) && this.MyBillsEntityDataFactory == payeeUserInfo.MyBillsEntityDataFactory && Intrinsics.areEqual(this.getAuthRequestContext, payeeUserInfo.getAuthRequestContext);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.scheduleImpl.hashCode();
        int hashCode2 = this.moveToNextValue.hashCode();
        int hashCode3 = this.PlaceComponentResult.hashCode();
        int hashCode4 = this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode();
        int hashCode5 = this.BuiltInFictitiousFunctionClassFactory.hashCode();
        int hashCode6 = this.lookAheadTest.hashCode();
        int hashCode7 = this.NetworkUserEntityData$$ExternalSyntheticLambda0.hashCode();
        boolean z = this.MyBillsEntityDataFactory;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        String str = this.getAuthRequestContext;
        return (((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + i) * 31) + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PayeeUserInfo(scheduleImpl=");
        sb.append(this.scheduleImpl);
        sb.append(", moveToNextValue=");
        sb.append(this.moveToNextValue);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", lookAheadTest=");
        sb.append(this.lookAheadTest);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda0=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(')');
        return sb.toString();
    }

    public PayeeUserInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z, String str8) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        Intrinsics.checkNotNullParameter(str7, "");
        this.scheduleImpl = str;
        this.moveToNextValue = str2;
        this.PlaceComponentResult = str3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str4;
        this.BuiltInFictitiousFunctionClassFactory = str5;
        this.lookAheadTest = str6;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str7;
        this.MyBillsEntityDataFactory = z;
        this.getAuthRequestContext = str8;
    }

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    public final boolean getMyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }
}
