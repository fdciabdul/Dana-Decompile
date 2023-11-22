package id.dana.data.registration;

import id.dana.data.registration.source.RegistrationMapper;
import id.dana.data.registration.source.network.result.CheckUserRegistrationStatusResult;
import io.reactivex.functions.Function;

/* loaded from: classes4.dex */
public final /* synthetic */ class RegistrationEntityRepository$$ExternalSyntheticLambda16 implements Function {
    public final /* synthetic */ RegistrationMapper f$0;

    @Override // io.reactivex.functions.Function
    public final Object apply(Object obj) {
        return this.f$0.transform((CheckUserRegistrationStatusResult) obj);
    }
}
