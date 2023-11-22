package id.dana.data.profilemenu.repository.source.network;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.profilemenu.repository.source.PaymentAuthenticationEntityData;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class PaymentAuthenticationDataFactory extends AbstractEntityDataFactory<PaymentAuthenticationEntityData> {
    private final NetworkPaymentAuthenticationEntityData networkPaymentAuthenticationEntityData;

    @Inject
    public PaymentAuthenticationDataFactory(NetworkPaymentAuthenticationEntityData networkPaymentAuthenticationEntityData) {
        this.networkPaymentAuthenticationEntityData = networkPaymentAuthenticationEntityData;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public PaymentAuthenticationEntityData createData2(String str) {
        return this.networkPaymentAuthenticationEntityData;
    }
}
