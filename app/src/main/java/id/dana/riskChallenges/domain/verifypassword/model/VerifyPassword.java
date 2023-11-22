package id.dana.riskChallenges.domain.verifypassword.model;

import id.dana.riskChallenges.domain.model.BaseRiskChallenges;
import id.dana.riskChallenges.domain.model.RiskResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0001\u0010\u001b\u001a\u00020\t\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0006X\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0013\u0010\f\u001a\u0004\u0018\u00010\u000fX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u0010R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u000fX\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0006X\u0006¢\u0006\u0006\n\u0004\b\u0012\u0010\rR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0014X\u0006¢\u0006\u0006\n\u0004\b\u0013\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017"}, d2 = {"Lid/dana/riskChallenges/domain/verifypassword/model/VerifyPassword;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "MyBillsEntityDataFactory", "Ljava/lang/Integer;", "BuiltInFictitiousFunctionClassFactory", "", "Ljava/lang/Long;", "getAuthRequestContext", "PlaceComponentResult", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/riskChallenges/domain/model/BaseRiskChallenges;", "Lid/dana/riskChallenges/domain/model/BaseRiskChallenges;", "getErrorConfigVersion", "Ljava/lang/String;", "p1", "p2", "p3", "p4", "p5", "<init>", "(Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Lid/dana/riskChallenges/domain/model/BaseRiskChallenges;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class VerifyPassword {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final Long MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final BaseRiskChallenges getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final Integer BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final Integer KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final Long PlaceComponentResult;
    public final String getErrorConfigVersion;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof VerifyPassword) {
            VerifyPassword verifyPassword = (VerifyPassword) p0;
            return Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, verifyPassword.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, verifyPassword.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.PlaceComponentResult, verifyPassword.PlaceComponentResult) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, verifyPassword.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.getErrorConfigVersion, verifyPassword.getErrorConfigVersion) && Intrinsics.areEqual(this.getAuthRequestContext, verifyPassword.getAuthRequestContext);
        }
        return false;
    }

    public final int hashCode() {
        Integer num = this.BuiltInFictitiousFunctionClassFactory;
        int hashCode = num == null ? 0 : num.hashCode();
        Long l = this.MyBillsEntityDataFactory;
        int hashCode2 = l == null ? 0 : l.hashCode();
        Long l2 = this.PlaceComponentResult;
        int hashCode3 = l2 == null ? 0 : l2.hashCode();
        Integer num2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int hashCode4 = num2 == null ? 0 : num2.hashCode();
        int hashCode5 = this.getErrorConfigVersion.hashCode();
        BaseRiskChallenges baseRiskChallenges = this.getAuthRequestContext;
        return (((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + (baseRiskChallenges != null ? baseRiskChallenges.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VerifyPassword(BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", getErrorConfigVersion=");
        sb.append(this.getErrorConfigVersion);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(')');
        return sb.toString();
    }

    public VerifyPassword(Integer num, Long l, Long l2, Integer num2, @RiskResult String str, BaseRiskChallenges baseRiskChallenges) {
        Intrinsics.checkNotNullParameter(str, "");
        this.BuiltInFictitiousFunctionClassFactory = num;
        this.MyBillsEntityDataFactory = l;
        this.PlaceComponentResult = l2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = num2;
        this.getErrorConfigVersion = str;
        this.getAuthRequestContext = baseRiskChallenges;
    }
}
