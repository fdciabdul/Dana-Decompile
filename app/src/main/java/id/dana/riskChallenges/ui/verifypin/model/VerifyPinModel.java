package id.dana.riskChallenges.ui.verifypin.model;

import id.dana.riskChallenges.domain.model.RiskResult;
import id.dana.riskChallenges.ui.util.model.BasicRiskChallengesModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0001\u0010\u001b\u001a\u00020\t\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0006X\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u000fX\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u000fX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u0011R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0006X\u0006¢\u0006\u0006\n\u0004\b\u0012\u0010\rR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0014X\u0006¢\u0006\u0006\n\u0004\b\u0013\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017"}, d2 = {"Lid/dana/riskChallenges/ui/verifypin/model/VerifyPinModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "PlaceComponentResult", "Ljava/lang/Integer;", "getAuthRequestContext", "", "MyBillsEntityDataFactory", "Ljava/lang/Long;", "BuiltInFictitiousFunctionClassFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/riskChallenges/ui/util/model/BasicRiskChallengesModel;", "Lid/dana/riskChallenges/ui/util/model/BasicRiskChallengesModel;", "scheduleImpl", "Ljava/lang/String;", "p1", "p2", "p3", "p4", "p5", "<init>", "(Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Lid/dana/riskChallenges/ui/util/model/BasicRiskChallengesModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class VerifyPinModel {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final Integer MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final BasicRiskChallengesModel PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final Long BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final Integer getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final Long KClassImpl$Data$declaredNonStaticMembers$2;
    public final String scheduleImpl;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof VerifyPinModel) {
            VerifyPinModel verifyPinModel = (VerifyPinModel) p0;
            return Intrinsics.areEqual(this.getAuthRequestContext, verifyPinModel.getAuthRequestContext) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, verifyPinModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, verifyPinModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, verifyPinModel.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.scheduleImpl, verifyPinModel.scheduleImpl) && Intrinsics.areEqual(this.PlaceComponentResult, verifyPinModel.PlaceComponentResult);
        }
        return false;
    }

    public final int hashCode() {
        Integer num = this.getAuthRequestContext;
        int hashCode = num == null ? 0 : num.hashCode();
        Long l = this.BuiltInFictitiousFunctionClassFactory;
        int hashCode2 = l == null ? 0 : l.hashCode();
        Long l2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int hashCode3 = l2 == null ? 0 : l2.hashCode();
        Integer num2 = this.MyBillsEntityDataFactory;
        int hashCode4 = num2 == null ? 0 : num2.hashCode();
        int hashCode5 = this.scheduleImpl.hashCode();
        BasicRiskChallengesModel basicRiskChallengesModel = this.PlaceComponentResult;
        return (((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + (basicRiskChallengesModel != null ? basicRiskChallengesModel.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VerifyPinModel(getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", scheduleImpl=");
        sb.append(this.scheduleImpl);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(')');
        return sb.toString();
    }

    public VerifyPinModel(Integer num, Long l, Long l2, Integer num2, @RiskResult String str, BasicRiskChallengesModel basicRiskChallengesModel) {
        Intrinsics.checkNotNullParameter(str, "");
        this.getAuthRequestContext = num;
        this.BuiltInFictitiousFunctionClassFactory = l;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = l2;
        this.MyBillsEntityDataFactory = num2;
        this.scheduleImpl = str;
        this.PlaceComponentResult = basicRiskChallengesModel;
    }

    public /* synthetic */ VerifyPinModel(Integer num, Long l, Long l2, Integer num2, String str, BasicRiskChallengesModel basicRiskChallengesModel, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : l2, (i & 8) != 0 ? null : num2, str, (i & 32) != 0 ? null : basicRiskChallengesModel);
    }
}
