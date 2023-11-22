package id.dana.kycrenewal.mapper;

import id.dana.domain.kycrenewal.model.QueryKYCRenewalStatus;
import id.dana.kycrenewal.model.QueryKYCRenewalStatusResponseModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/domain/kycrenewal/model/QueryKYCRenewalStatus;", "Lid/dana/kycrenewal/model/QueryKYCRenewalStatusResponseModel;", "getAuthRequestContext", "(Lid/dana/domain/kycrenewal/model/QueryKYCRenewalStatus;)Lid/dana/kycrenewal/model/QueryKYCRenewalStatusResponseModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KYCRenewalStatusToKYCRenewalStatusModelMapperKt {
    public static final QueryKYCRenewalStatusResponseModel getAuthRequestContext(QueryKYCRenewalStatus queryKYCRenewalStatus) {
        Intrinsics.checkNotNullParameter(queryKYCRenewalStatus, "");
        return new QueryKYCRenewalStatusResponseModel(queryKYCRenewalStatus.getRenewKYC(), queryKYCRenewalStatus.getVerificationId());
    }
}
