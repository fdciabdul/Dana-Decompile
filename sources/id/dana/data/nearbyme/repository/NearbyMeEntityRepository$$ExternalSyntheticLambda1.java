package id.dana.data.nearbyme.repository;

import id.dana.data.account.AccountEntity;
import io.reactivex.functions.Function;

/* loaded from: classes4.dex */
public final /* synthetic */ class NearbyMeEntityRepository$$ExternalSyntheticLambda1 implements Function {
    @Override // io.reactivex.functions.Function
    public final Object apply(Object obj) {
        return ((AccountEntity) obj).getPhoneNumber();
    }
}
