package id.dana.riskChallenges.domain.forgetpassword.model;

import id.dana.riskChallenges.domain.model.BaseRiskChallenges;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u001f\u001a\u00020\n\u0012\u0006\u0010 \u001a\u00020\u0013\u0012\u0006\u0010!\u001a\u00020\u0004\u0012\u0006\u0010\"\u001a\u00020\u0019\u0012\u000e\b\u0002\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b¢\u0006\u0004\b$\u0010%J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\u00020\u00048\u0007¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000fR\u001a\u0010\u0012\u001a\u00020\n8\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\fR\u001a\u0010\u0016\u001a\u00020\u00138\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0014\u001a\u0004\b\u0012\u0010\u0015R\u001a\u0010\u0018\u001a\u00020\u00048\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u000e\u001a\u0004\b\u0018\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0019X\u0007¢\u0006\u0006\n\u0004\b\u0018\u0010\u001aR \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u001d\u001a\u0004\b\u0016\u0010\u001e"}, d2 = {"Lid/dana/riskChallenges/domain/forgetpassword/model/RiskChallenges;", "Lid/dana/riskChallenges/domain/model/BaseRiskChallenges;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "PlaceComponentResult", "Z", "()Z", "getAuthRequestContext", "Ljava/lang/String;", "MyBillsEntityDataFactory", "Lid/dana/riskChallenges/domain/forgetpassword/model/SecurityInfo;", "Lid/dana/riskChallenges/domain/forgetpassword/model/SecurityInfo;", "()Lid/dana/riskChallenges/domain/forgetpassword/model/SecurityInfo;", "BuiltInFictitiousFunctionClassFactory", "getErrorConfigVersion", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/riskChallenges/domain/forgetpassword/model/UserInfo;", "Lid/dana/riskChallenges/domain/forgetpassword/model/UserInfo;", "", "Lid/dana/riskChallenges/domain/forgetpassword/model/VerificationMethods;", "Ljava/util/List;", "()Ljava/util/List;", "p1", "p2", "p3", "p4", "p5", "<init>", "(ZLjava/lang/String;Lid/dana/riskChallenges/domain/forgetpassword/model/SecurityInfo;ZLid/dana/riskChallenges/domain/forgetpassword/model/UserInfo;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class RiskChallenges extends BaseRiskChallenges {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final List<VerificationMethods> getErrorConfigVersion;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final UserInfo getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final SecurityInfo BuiltInFictitiousFunctionClassFactory;
    private final boolean PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String MyBillsEntityDataFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final boolean KClassImpl$Data$declaredNonStaticMembers$2;

    @JvmName(name = "PlaceComponentResult")
    /* renamed from: PlaceComponentResult  reason: from getter */
    public final boolean getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }

    @Override // id.dana.riskChallenges.domain.model.BaseRiskChallenges
    @JvmName(name = "getAuthRequestContext")
    /* renamed from: getAuthRequestContext  reason: from getter */
    public final String getMyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }

    @Override // id.dana.riskChallenges.domain.model.BaseRiskChallenges
    @JvmName(name = "MyBillsEntityDataFactory")
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final SecurityInfo getBuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
    public final boolean getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // id.dana.riskChallenges.domain.model.BaseRiskChallenges
    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    public final List<VerificationMethods> BuiltInFictitiousFunctionClassFactory() {
        return this.getErrorConfigVersion;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RiskChallenges(boolean z, String str, SecurityInfo securityInfo, boolean z2, UserInfo userInfo, List<VerificationMethods> list) {
        super(str, securityInfo, list);
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(securityInfo, "");
        Intrinsics.checkNotNullParameter(userInfo, "");
        Intrinsics.checkNotNullParameter(list, "");
        this.PlaceComponentResult = z;
        this.MyBillsEntityDataFactory = str;
        this.BuiltInFictitiousFunctionClassFactory = securityInfo;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = z2;
        this.getAuthRequestContext = userInfo;
        this.getErrorConfigVersion = list;
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof RiskChallenges) {
            RiskChallenges riskChallenges = (RiskChallenges) p0;
            return this.PlaceComponentResult == riskChallenges.PlaceComponentResult && Intrinsics.areEqual(this.MyBillsEntityDataFactory, riskChallenges.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, riskChallenges.BuiltInFictitiousFunctionClassFactory) && this.KClassImpl$Data$declaredNonStaticMembers$2 == riskChallenges.KClassImpl$Data$declaredNonStaticMembers$2 && Intrinsics.areEqual(this.getAuthRequestContext, riskChallenges.getAuthRequestContext) && Intrinsics.areEqual(this.getErrorConfigVersion, riskChallenges.getErrorConfigVersion);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    public final int hashCode() {
        boolean z = this.PlaceComponentResult;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int hashCode = this.MyBillsEntityDataFactory.hashCode();
        int hashCode2 = this.BuiltInFictitiousFunctionClassFactory.hashCode();
        boolean z2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        return (((((((((r0 * 31) + hashCode) * 31) + hashCode2) * 31) + (z2 ? 1 : z2 ? 1 : 0)) * 31) + this.getAuthRequestContext.hashCode()) * 31) + this.getErrorConfigVersion.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RiskChallenges(PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", getErrorConfigVersion=");
        sb.append(this.getErrorConfigVersion);
        sb.append(')');
        return sb.toString();
    }
}
