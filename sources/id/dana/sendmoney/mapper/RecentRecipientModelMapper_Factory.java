package id.dana.sendmoney.mapper;

import dagger.internal.Factory;

/* loaded from: classes5.dex */
public final class RecentRecipientModelMapper_Factory implements Factory<RecentRecipientModelMapper> {
    public static RecentRecipientModelMapper_Factory PlaceComponentResult() {
        return InstanceHolder.BuiltInFictitiousFunctionClassFactory;
    }

    /* loaded from: classes5.dex */
    static final class InstanceHolder {
        private static final RecentRecipientModelMapper_Factory BuiltInFictitiousFunctionClassFactory = new RecentRecipientModelMapper_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new RecentRecipientModelMapper();
    }
}
