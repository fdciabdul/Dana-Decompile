package id.dana.sendmoney.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\t\u0012\b\b\u0002\u0010\u0017\u001a\u00020\t\u0012\b\b\u0002\u0010\u0018\u001a\u00020\t\u0012\b\b\u0002\u0010\u0019\u001a\u00020\t\u0012\b\b\u0002\u0010\u001a\u001a\u00020\t\u0012\b\b\u0002\u0010\u001b\u001a\u00020\t\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0012\u0010\u000e\u001a\u00020\tX\u0086\u0002¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0012\u0010\u0010\u001a\u00020\tX\u0086\u0002¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0012\u0010\f\u001a\u00020\tX\u0086\u0002¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0012\u0010\u000f\u001a\u00020\tX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0011\u0010\rR\u0012\u0010\u0011\u001a\u00020\tX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0012\u0010\u0013\u001a\u00020\tX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0012\u0010\rR\u0012\u0010\u0016\u001a\u00020\u0003X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015"}, d2 = {"Lid/dana/sendmoney/model/DigitalMoneyModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "PlaceComponentResult", "MyBillsEntityDataFactory", "getAuthRequestContext", "KClassImpl$Data$declaredNonStaticMembers$2", "getErrorConfigVersion", "lookAheadTest", "scheduleImpl", "Z", "moveToNextValue", "p1", "p2", "p3", "p4", "p5", "p6", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final /* data */ class DigitalMoneyModel {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public String PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public String MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public String getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public String lookAheadTest;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public boolean moveToNextValue;

    public DigitalMoneyModel() {
        this(null, null, null, null, null, null, false, 127, null);
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof DigitalMoneyModel) {
            DigitalMoneyModel digitalMoneyModel = (DigitalMoneyModel) p0;
            return Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, digitalMoneyModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, digitalMoneyModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.PlaceComponentResult, digitalMoneyModel.PlaceComponentResult) && Intrinsics.areEqual(this.getAuthRequestContext, digitalMoneyModel.getAuthRequestContext) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, digitalMoneyModel.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.lookAheadTest, digitalMoneyModel.lookAheadTest) && this.moveToNextValue == digitalMoneyModel.moveToNextValue;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode();
        int hashCode2 = this.BuiltInFictitiousFunctionClassFactory.hashCode();
        int hashCode3 = this.PlaceComponentResult.hashCode();
        int hashCode4 = this.getAuthRequestContext.hashCode();
        int hashCode5 = this.MyBillsEntityDataFactory.hashCode();
        int hashCode6 = this.lookAheadTest.hashCode();
        boolean z = this.moveToNextValue;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return (((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DigitalMoneyModel(KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", lookAheadTest=");
        sb.append(this.lookAheadTest);
        sb.append(", moveToNextValue=");
        sb.append(this.moveToNextValue);
        sb.append(')');
        return sb.toString();
    }

    private DigitalMoneyModel(String str, String str2, String str3, String str4, String str5, String str6, boolean z) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        this.BuiltInFictitiousFunctionClassFactory = str2;
        this.PlaceComponentResult = str3;
        this.getAuthRequestContext = str4;
        this.MyBillsEntityDataFactory = str5;
        this.lookAheadTest = str6;
        this.moveToNextValue = z;
    }

    public /* synthetic */ DigitalMoneyModel(String str, String str2, String str3, String str4, String str5, String str6, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) == 0 ? str6 : "", (i & 64) != 0 ? false : z);
    }
}
