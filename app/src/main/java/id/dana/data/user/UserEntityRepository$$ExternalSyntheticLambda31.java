package id.dana.data.user;

import id.dana.data.user.source.network.result.UserInfoRpcResult;
import io.reactivex.functions.Function;

/* loaded from: classes4.dex */
public final /* synthetic */ class UserEntityRepository$$ExternalSyntheticLambda31 implements Function {
    @Override // io.reactivex.functions.Function
    public final Object apply(Object obj) {
        return ((UserInfoRpcResult) obj).getBalance();
    }
}
