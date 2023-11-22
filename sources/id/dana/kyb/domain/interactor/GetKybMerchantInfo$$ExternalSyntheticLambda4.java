package id.dana.kyb.domain.interactor;

import id.dana.domain.user.UserInfoResponse;
import io.reactivex.functions.Function;

/* loaded from: classes5.dex */
public final /* synthetic */ class GetKybMerchantInfo$$ExternalSyntheticLambda4 implements Function {
    public final /* synthetic */ GetKybMerchantInfo BuiltInFictitiousFunctionClassFactory;

    public /* synthetic */ GetKybMerchantInfo$$ExternalSyntheticLambda4(GetKybMerchantInfo getKybMerchantInfo) {
        this.BuiltInFictitiousFunctionClassFactory = getKybMerchantInfo;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object obj) {
        return GetKybMerchantInfo.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory, (UserInfoResponse) obj);
    }
}
