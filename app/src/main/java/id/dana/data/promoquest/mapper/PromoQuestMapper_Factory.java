package id.dana.data.promoquest.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class PromoQuestMapper_Factory implements Factory<PromoQuestMapper> {
    @Override // javax.inject.Provider
    public final PromoQuestMapper get() {
        return newInstance();
    }

    public static PromoQuestMapper_Factory create() {
        return InstanceHolder.MyBillsEntityDataFactory;
    }

    public static PromoQuestMapper newInstance() {
        return new PromoQuestMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final PromoQuestMapper_Factory MyBillsEntityDataFactory = new PromoQuestMapper_Factory();

        private InstanceHolder() {
        }
    }
}
