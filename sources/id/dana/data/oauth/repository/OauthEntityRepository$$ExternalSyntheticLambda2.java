package id.dana.data.oauth.repository;

import id.dana.data.authcode.AuthCodeEntity;
import id.dana.data.authcode.mapper.AuthMapper;
import io.reactivex.functions.Function;

/* loaded from: classes4.dex */
public final /* synthetic */ class OauthEntityRepository$$ExternalSyntheticLambda2 implements Function {
    public final /* synthetic */ AuthMapper f$0;

    @Override // io.reactivex.functions.Function
    public final Object apply(Object obj) {
        return this.f$0.transform((AuthCodeEntity) obj);
    }
}
