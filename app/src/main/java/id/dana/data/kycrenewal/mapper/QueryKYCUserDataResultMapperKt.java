package id.dana.data.kycrenewal.mapper;

import id.dana.data.kycrenewal.repository.source.network.result.KYCRenewalUserInfoResult;
import id.dana.data.kycrenewal.repository.source.network.result.QueryKYCUserDataResult;
import id.dana.domain.kycrenewal.model.KYCRenewalUserInfo;
import id.dana.domain.kycrenewal.model.QueryKYCUserData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/data/kycrenewal/repository/source/network/result/QueryKYCUserDataResult;", "Lid/dana/domain/kycrenewal/model/QueryKYCUserData;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/data/kycrenewal/repository/source/network/result/QueryKYCUserDataResult;)Lid/dana/domain/kycrenewal/model/QueryKYCUserData;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class QueryKYCUserDataResultMapperKt {
    public static final QueryKYCUserData BuiltInFictitiousFunctionClassFactory(QueryKYCUserDataResult queryKYCUserDataResult) {
        KYCRenewalUserInfo kYCRenewalUserInfo;
        Intrinsics.checkNotNullParameter(queryKYCUserDataResult, "");
        boolean succes = queryKYCUserDataResult.getSucces();
        KYCRenewalUserInfoResult userInfoResult = queryKYCUserDataResult.getUserInfoResult();
        if (userInfoResult != null) {
            Intrinsics.checkNotNullParameter(userInfoResult, "");
            kYCRenewalUserInfo = new KYCRenewalUserInfo(userInfoResult.moveToNextValue, userInfoResult.getErrorConfigVersion, userInfoResult.KClassImpl$Data$declaredNonStaticMembers$2, userInfoResult.scheduleImpl, userInfoResult.NetworkUserEntityData$$ExternalSyntheticLambda0, userInfoResult.BuiltInFictitiousFunctionClassFactory, userInfoResult.MyBillsEntityDataFactory, userInfoResult.PlaceComponentResult, userInfoResult.getAuthRequestContext, userInfoResult.lookAheadTest, userInfoResult.NetworkUserEntityData$$ExternalSyntheticLambda2);
        } else {
            kYCRenewalUserInfo = null;
        }
        return new QueryKYCUserData(succes, kYCRenewalUserInfo);
    }
}
