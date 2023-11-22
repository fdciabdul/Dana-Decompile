package id.dana.sendmoney.mapper;

import dagger.internal.Factory;

/* loaded from: classes5.dex */
public final class ContactPayMethodMapper_Factory implements Factory<ContactPayMethodMapper> {
    public static ContactPayMethodMapper_Factory BuiltInFictitiousFunctionClassFactory() {
        return InstanceHolder.PlaceComponentResult;
    }

    /* loaded from: classes5.dex */
    static final class InstanceHolder {
        private static final ContactPayMethodMapper_Factory PlaceComponentResult = new ContactPayMethodMapper_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ContactPayMethodMapper();
    }
}
