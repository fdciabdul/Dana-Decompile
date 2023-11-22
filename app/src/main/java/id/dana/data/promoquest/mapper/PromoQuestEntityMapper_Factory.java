package id.dana.data.promoquest.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class PromoQuestEntityMapper_Factory implements Factory<PromoQuestEntityMapper> {
    @Override // javax.inject.Provider
    public final PromoQuestEntityMapper get() {
        return newInstance();
    }

    public static PromoQuestEntityMapper_Factory create() {
        return InstanceHolder.getAuthRequestContext;
    }

    public static PromoQuestEntityMapper newInstance() {
        return new PromoQuestEntityMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final PromoQuestEntityMapper_Factory getAuthRequestContext = new PromoQuestEntityMapper_Factory();

        private InstanceHolder() {
        }
    }
}
