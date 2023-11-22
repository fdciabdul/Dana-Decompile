package id.dana.data.user;

import id.dana.data.user.source.network.result.UserInfoRpcResult;
import io.reactivex.functions.Function;

/* loaded from: classes4.dex */
public final /* synthetic */ class UserEntityRepository$$ExternalSyntheticLambda42 implements Function {
    public final /* synthetic */ UserInfoMapper f$0;

    @Override // io.reactivex.functions.Function
    public final Object apply(Object obj) {
        return this.f$0.transform((UserInfoRpcResult) obj);
    }
}
