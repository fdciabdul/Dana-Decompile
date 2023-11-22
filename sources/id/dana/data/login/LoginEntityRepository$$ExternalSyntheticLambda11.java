package id.dana.data.login;

import id.dana.data.login.source.LoginMapper;
import id.dana.network.response.login.LoginRpcResult;
import io.reactivex.functions.Function;

/* loaded from: classes4.dex */
public final /* synthetic */ class LoginEntityRepository$$ExternalSyntheticLambda11 implements Function {
    public final /* synthetic */ LoginMapper f$0;

    @Override // io.reactivex.functions.Function
    public final Object apply(Object obj) {
        return this.f$0.transform((LoginRpcResult) obj);
    }
}
