package id.dana.data.authcode.repository.source.network;

import id.dana.network.base.ConnectionExceptionParser;
import io.reactivex.functions.Function;

/* loaded from: classes2.dex */
public final /* synthetic */ class NetworkAuthEntityData$$ExternalSyntheticLambda2 implements Function {
    public final /* synthetic */ ConnectionExceptionParser f$0;

    public /* synthetic */ NetworkAuthEntityData$$ExternalSyntheticLambda2(ConnectionExceptionParser connectionExceptionParser) {
        this.f$0 = connectionExceptionParser;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object obj) {
        return this.f$0.apply((Throwable) obj);
    }
}
