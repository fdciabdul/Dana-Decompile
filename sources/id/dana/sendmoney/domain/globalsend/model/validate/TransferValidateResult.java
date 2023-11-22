package id.dana.sendmoney.domain.globalsend.model.validate;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\r\u0010\u000eR\u0011\u0010\u0003\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\b\u001a\u00020\u0005X\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0006\u001a\u00020\u0005X\u0006¢\u0006\u0006\n\u0004\b\t\u0010\u0007"}, d2 = {"Lid/dana/sendmoney/domain/globalsend/model/validate/TransferValidateResult;", "", "Lid/dana/sendmoney/domain/globalsend/model/validate/BeneficiaryInfo;", "PlaceComponentResult", "Lid/dana/sendmoney/domain/globalsend/model/validate/BeneficiaryInfo;", "", "getAuthRequestContext", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "p1", "p2", "<init>", "(Lid/dana/sendmoney/domain/globalsend/model/validate/BeneficiaryInfo;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TransferValidateResult {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final String getAuthRequestContext;
    public final BeneficiaryInfo PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String BuiltInFictitiousFunctionClassFactory;

    public TransferValidateResult(BeneficiaryInfo beneficiaryInfo, String str, String str2) {
        Intrinsics.checkNotNullParameter(beneficiaryInfo, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.PlaceComponentResult = beneficiaryInfo;
        this.BuiltInFictitiousFunctionClassFactory = str;
        this.getAuthRequestContext = str2;
    }
}
