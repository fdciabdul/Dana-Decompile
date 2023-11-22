package id.dana.data.qriscrossborder;

import dagger.internal.Factory;
import id.dana.data.qriscrossborder.source.QrisCrossBorderEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class QrisCrossBorderEntityRepository_Factory implements Factory<QrisCrossBorderEntityRepository> {
    private final Provider<QrisCrossBorderEntityDataFactory> BuiltInFictitiousFunctionClassFactory;

    private QrisCrossBorderEntityRepository_Factory(Provider<QrisCrossBorderEntityDataFactory> provider) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static QrisCrossBorderEntityRepository_Factory MyBillsEntityDataFactory(Provider<QrisCrossBorderEntityDataFactory> provider) {
        return new QrisCrossBorderEntityRepository_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new QrisCrossBorderEntityRepository(this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
