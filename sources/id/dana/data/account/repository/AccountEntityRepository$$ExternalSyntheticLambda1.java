package id.dana.data.account.repository;

import id.dana.data.account.AccountEntity;
import id.dana.data.account.mapper.AccountMapper;
import io.reactivex.functions.Function;

/* loaded from: classes4.dex */
public final /* synthetic */ class AccountEntityRepository$$ExternalSyntheticLambda1 implements Function {
    public final /* synthetic */ AccountMapper f$0;

    @Override // io.reactivex.functions.Function
    public final Object apply(Object obj) {
        return this.f$0.transform((AccountEntity) obj);
    }
}
