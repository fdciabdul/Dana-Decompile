package id.dana.kyb.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0003¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u0003X\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0011\u001a\u00020\u0003X\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\rR\u0017\u0010\u0010\u001a\u00020\u00038\u0007¢\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0012\u0010\u0014R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\tX\u0007¢\u0006\u0006\n\u0004\b\u0012\u0010\rR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\tX\u0007¢\u0006\u0006\n\u0004\b\u0015\u0010\rR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\tX\u0007¢\u0006\u0006\n\u0004\b\u0017\u0010\r"}, d2 = {"Lid/dana/kyb/model/UserInfoKybModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "PlaceComponentResult", "Z", "KClassImpl$Data$declaredNonStaticMembers$2", "MyBillsEntityDataFactory", "getAuthRequestContext", "NetworkUserEntityData$$ExternalSyntheticLambda0", "()Z", "getErrorConfigVersion", "lookAheadTest", "moveToNextValue", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class UserInfoKybModel {
    public final String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final boolean MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final String getAuthRequestContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final boolean KClassImpl$Data$declaredNonStaticMembers$2;
    public final boolean PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String getErrorConfigVersion;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public final String lookAheadTest;
    public final String moveToNextValue;

    public UserInfoKybModel() {
        this(null, null, null, false, false, null, null, false, 255, null);
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof UserInfoKybModel) {
            UserInfoKybModel userInfoKybModel = (UserInfoKybModel) p0;
            return Intrinsics.areEqual(this.moveToNextValue, userInfoKybModel.moveToNextValue) && Intrinsics.areEqual(this.getAuthRequestContext, userInfoKybModel.getAuthRequestContext) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, userInfoKybModel.BuiltInFictitiousFunctionClassFactory) && this.MyBillsEntityDataFactory == userInfoKybModel.MyBillsEntityDataFactory && this.PlaceComponentResult == userInfoKybModel.PlaceComponentResult && Intrinsics.areEqual(this.getErrorConfigVersion, userInfoKybModel.getErrorConfigVersion) && Intrinsics.areEqual(this.lookAheadTest, userInfoKybModel.lookAheadTest) && this.KClassImpl$Data$declaredNonStaticMembers$2 == userInfoKybModel.KClassImpl$Data$declaredNonStaticMembers$2;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        String str = this.moveToNextValue;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.getAuthRequestContext;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.BuiltInFictitiousFunctionClassFactory;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        boolean z = this.MyBillsEntityDataFactory;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        boolean z2 = this.PlaceComponentResult;
        int i2 = z2;
        if (z2 != 0) {
            i2 = 1;
        }
        String str4 = this.getErrorConfigVersion;
        int hashCode4 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.lookAheadTest;
        int hashCode5 = str5 != null ? str5.hashCode() : 0;
        boolean z3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        return (((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + i) * 31) + i2) * 31) + hashCode4) * 31) + hashCode5) * 31) + (z3 ? 1 : z3 ? 1 : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UserInfoKybModel(moveToNextValue=");
        sb.append(this.moveToNextValue);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", getErrorConfigVersion=");
        sb.append(this.getErrorConfigVersion);
        sb.append(", lookAheadTest=");
        sb.append(this.lookAheadTest);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(')');
        return sb.toString();
    }

    public UserInfoKybModel(String str, String str2, String str3, boolean z, boolean z2, String str4, String str5, boolean z3) {
        this.moveToNextValue = str;
        this.getAuthRequestContext = str2;
        this.BuiltInFictitiousFunctionClassFactory = str3;
        this.MyBillsEntityDataFactory = z;
        this.PlaceComponentResult = z2;
        this.getErrorConfigVersion = str4;
        this.lookAheadTest = str5;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = z3;
    }

    public /* synthetic */ UserInfoKybModel(String str, String str2, String str3, boolean z, boolean z2, String str4, String str5, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? false : z, (i & 16) != 0 ? false : z2, (i & 32) != 0 ? null : str4, (i & 64) == 0 ? str5 : null, (i & 128) == 0 ? z3 : false);
    }

    @JvmName(name = "getAuthRequestContext")
    /* renamed from: getAuthRequestContext  reason: from getter */
    public final boolean getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
