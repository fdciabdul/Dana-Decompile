package id.dana.sendmoney.domain.globalsend.model.beneficiary.response;

import id.dana.sendmoney.domain.globalsend.model.validate.BeneficiaryInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B+\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0007\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0011\u0010\f\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/sendmoney/domain/globalsend/model/beneficiary/response/QueryBeneficiaryResult;", "", "", "Lid/dana/sendmoney/domain/globalsend/model/validate/BeneficiaryInfo;", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/util/List;", "", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "", "getAuthRequestContext", "I", "PlaceComponentResult", "p0", "p1", "p2", "<init>", "(Ljava/util/List;ILjava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class QueryBeneficiaryResult {
    public final String BuiltInFictitiousFunctionClassFactory;
    public final List<BeneficiaryInfo> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final int PlaceComponentResult;

    public QueryBeneficiaryResult() {
        this(null, 0, null, 7, null);
    }

    public QueryBeneficiaryResult(List<BeneficiaryInfo> list, int i, String str) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(str, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = list;
        this.PlaceComponentResult = i;
        this.BuiltInFictitiousFunctionClassFactory = str;
    }

    public /* synthetic */ QueryBeneficiaryResult(ArrayList arrayList, int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? new ArrayList() : arrayList, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? "" : str);
    }
}
