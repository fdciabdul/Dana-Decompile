package id.dana.kyb.domain.interactor;

import id.dana.domain.user.UserInfoResponse;
import id.dana.kyb.domain.model.KybMerchantInfo;
import io.reactivex.functions.Function;

/* loaded from: classes5.dex */
public final /* synthetic */ class GetKybMerchantInfo$$ExternalSyntheticLambda2 implements Function {
    public final /* synthetic */ UserInfoResponse BuiltInFictitiousFunctionClassFactory;

    public /* synthetic */ GetKybMerchantInfo$$ExternalSyntheticLambda2(UserInfoResponse userInfoResponse) {
        this.BuiltInFictitiousFunctionClassFactory = userInfoResponse;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object obj) {
        return GetKybMerchantInfo.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory, (KybMerchantInfo) obj);
    }
}
