package id.dana.promoquest.mapper;

import dagger.internal.Factory;

/* loaded from: classes5.dex */
public final class PromoQuestMapper_Factory implements Factory<PromoQuestMapper> {
    public static PromoQuestMapper_Factory MyBillsEntityDataFactory() {
        return InstanceHolder.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    /* loaded from: classes5.dex */
    static final class InstanceHolder {
        private static final PromoQuestMapper_Factory KClassImpl$Data$declaredNonStaticMembers$2 = new PromoQuestMapper_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PromoQuestMapper();
    }
}
