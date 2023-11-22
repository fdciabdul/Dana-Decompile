package id.dana.sendmoney.mapper;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class TransferConfigModelMapper_Factory implements Factory<TransferConfigModelMapper> {
    private final Provider<CurrencyAmountModelMapper> BuiltInFictitiousFunctionClassFactory;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new TransferConfigModelMapper(this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
