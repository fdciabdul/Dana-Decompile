package id.dana.riskChallenges.domain.danaprotection.model;

import id.dana.riskChallenges.ui.resetpin.model.VerificationMethodModel;
import id.dana.riskChallenges.ui.util.model.BasicRiskChallengesModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0003\u001a\u00020\n\u0012\b\b\u0002\u0010\u0018\u001a\u00020\n\u0012\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u001a\u001a\u00020\n\u0012\b\b\u0002\u0010\u001b\u001a\u00020\n\u0012\b\b\u0002\u0010\u001c\u001a\u00020\n¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u000f\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0011\u0010\r\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0010\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0011\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0012\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\u0012\u0010\u000eR\u0019\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0006¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016"}, d2 = {"Lid/dana/riskChallenges/domain/danaprotection/model/RiskChallengeStatusModel;", "Lid/dana/riskChallenges/ui/util/model/BasicRiskChallengesModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "PlaceComponentResult", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "MyBillsEntityDataFactory", "getAuthRequestContext", "", "Lid/dana/riskChallenges/ui/resetpin/model/VerificationMethodModel;", "getErrorConfigVersion", "Ljava/util/List;", "moveToNextValue", "p1", "p2", "p3", "p4", "p5", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final /* data */ class RiskChallengeStatusModel extends BasicRiskChallengesModel {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final String PlaceComponentResult;
    public final String MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final String BuiltInFictitiousFunctionClassFactory;
    public final String getAuthRequestContext;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public final List<VerificationMethodModel> moveToNextValue;

    public RiskChallengeStatusModel() {
        this(null, null, null, null, null, null, 63, null);
    }

    @Override // id.dana.riskChallenges.ui.util.model.BasicRiskChallengesModel
    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof RiskChallengeStatusModel) {
            RiskChallengeStatusModel riskChallengeStatusModel = (RiskChallengeStatusModel) p0;
            return Intrinsics.areEqual(this.MyBillsEntityDataFactory, riskChallengeStatusModel.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.getAuthRequestContext, riskChallengeStatusModel.getAuthRequestContext) && Intrinsics.areEqual(this.moveToNextValue, riskChallengeStatusModel.moveToNextValue) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, riskChallengeStatusModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, riskChallengeStatusModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.PlaceComponentResult, riskChallengeStatusModel.PlaceComponentResult);
        }
        return false;
    }

    @Override // id.dana.riskChallenges.ui.util.model.BasicRiskChallengesModel
    public final int hashCode() {
        int hashCode = this.MyBillsEntityDataFactory.hashCode();
        int hashCode2 = this.getAuthRequestContext.hashCode();
        List<VerificationMethodModel> list = this.moveToNextValue;
        return (((((((((hashCode * 31) + hashCode2) * 31) + (list == null ? 0 : list.hashCode())) * 31) + this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode()) * 31) + this.BuiltInFictitiousFunctionClassFactory.hashCode()) * 31) + this.PlaceComponentResult.hashCode();
    }

    @Override // id.dana.riskChallenges.ui.util.model.BasicRiskChallengesModel
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RiskChallengeStatusModel(MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", moveToNextValue=");
        sb.append(this.moveToNextValue);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ RiskChallengeStatusModel(String str, String str2, List list, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? null : list, (i & 8) != 0 ? "" : str3, (i & 16) != 0 ? "" : str4, (i & 32) != 0 ? "" : str5);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public RiskChallengeStatusModel(java.lang.String r4, java.lang.String r5, java.util.List<id.dana.riskChallenges.ui.resetpin.model.VerificationMethodModel> r6, java.lang.String r7, java.lang.String r8, java.lang.String r9) {
        /*
            r3 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            if (r6 == 0) goto L21
            r1 = 0
            java.lang.Object r1 = kotlin.collections.CollectionsKt.getOrNull(r6, r1)
            id.dana.riskChallenges.ui.resetpin.model.VerificationMethodModel r1 = (id.dana.riskChallenges.ui.resetpin.model.VerificationMethodModel) r1
            if (r1 == 0) goto L21
            java.lang.String r1 = r1.getVerificationMethod()
            goto L22
        L21:
            r1 = 0
        L22:
            if (r1 != 0) goto L25
            r1 = r0
        L25:
            id.dana.riskChallenges.ui.resetpin.model.SecurityInfoModel r2 = new id.dana.riskChallenges.ui.resetpin.model.SecurityInfoModel
            r2.<init>(r5, r1, r0)
            if (r6 != 0) goto L31
            java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
            goto L32
        L31:
            r1 = r6
        L32:
            r3.<init>(r0, r2, r1)
            r3.MyBillsEntityDataFactory = r4
            r3.getAuthRequestContext = r5
            r3.moveToNextValue = r6
            r3.KClassImpl$Data$declaredNonStaticMembers$2 = r7
            r3.BuiltInFictitiousFunctionClassFactory = r8
            r3.PlaceComponentResult = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.riskChallenges.domain.danaprotection.model.RiskChallengeStatusModel.<init>(java.lang.String, java.lang.String, java.util.List, java.lang.String, java.lang.String, java.lang.String):void");
    }
}
