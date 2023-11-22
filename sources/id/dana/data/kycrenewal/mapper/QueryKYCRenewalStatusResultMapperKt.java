package id.dana.data.kycrenewal.mapper;

import id.dana.data.kycrenewal.repository.source.network.result.QueryKYCRenewalStatusResult;
import id.dana.domain.kycrenewal.model.QueryKYCRenewalStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/data/kycrenewal/repository/source/network/result/QueryKYCRenewalStatusResult;", "Lid/dana/domain/kycrenewal/model/QueryKYCRenewalStatus;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/data/kycrenewal/repository/source/network/result/QueryKYCRenewalStatusResult;)Lid/dana/domain/kycrenewal/model/QueryKYCRenewalStatus;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class QueryKYCRenewalStatusResultMapperKt {
    public static final QueryKYCRenewalStatus BuiltInFictitiousFunctionClassFactory(QueryKYCRenewalStatusResult queryKYCRenewalStatusResult) {
        Intrinsics.checkNotNullParameter(queryKYCRenewalStatusResult, "");
        Boolean renewKYC = queryKYCRenewalStatusResult.getRenewKYC();
        boolean booleanValue = renewKYC != null ? renewKYC.booleanValue() : false;
        String verificationId = queryKYCRenewalStatusResult.getVerificationId();
        return new QueryKYCRenewalStatus(booleanValue, verificationId != null ? verificationId : "");
    }
}
