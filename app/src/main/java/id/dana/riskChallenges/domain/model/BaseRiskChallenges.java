package id.dana.riskChallenges.domain.model;

import id.dana.riskChallenges.domain.forgetpassword.model.SecurityInfo;
import id.dana.riskChallenges.domain.forgetpassword.model.VerificationMethods;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\b\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0007\u001a\u00020\u00028\u0017X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\t\u001a\u00020\b8\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0007\u0010\u0010"}, d2 = {"Lid/dana/riskChallenges/domain/model/BaseRiskChallenges;", "", "", "PlaceComponentResult", "Ljava/lang/String;", "getAuthRequestContext", "()Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/riskChallenges/domain/forgetpassword/model/SecurityInfo;", "MyBillsEntityDataFactory", "Lid/dana/riskChallenges/domain/forgetpassword/model/SecurityInfo;", "()Lid/dana/riskChallenges/domain/forgetpassword/model/SecurityInfo;", "", "Lid/dana/riskChallenges/domain/forgetpassword/model/VerificationMethods;", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/util/List;", "()Ljava/util/List;", "p0", "p1", "p2", "<init>", "(Ljava/lang/String;Lid/dana/riskChallenges/domain/forgetpassword/model/SecurityInfo;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public class BaseRiskChallenges {
    private final List<VerificationMethods> KClassImpl$Data$declaredNonStaticMembers$2;
    private final SecurityInfo MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final String BuiltInFictitiousFunctionClassFactory;

    public BaseRiskChallenges(String str, SecurityInfo securityInfo, List<VerificationMethods> list) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(securityInfo, "");
        Intrinsics.checkNotNullParameter(list, "");
        this.BuiltInFictitiousFunctionClassFactory = str;
        this.MyBillsEntityDataFactory = securityInfo;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = list;
    }

    @JvmName(name = "getAuthRequestContext")
    /* renamed from: getAuthRequestContext  reason: from getter */
    public String getBuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @JvmName(name = "MyBillsEntityDataFactory")
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public SecurityInfo getMyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    public List<VerificationMethods> BuiltInFictitiousFunctionClassFactory() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
