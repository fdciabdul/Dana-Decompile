package id.dana.data.senddigitalmoney.repository.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class CardPrefixQueryResultMapper_Factory implements Factory<CardPrefixQueryResultMapper> {
    public static CardPrefixQueryResultMapper_Factory MyBillsEntityDataFactory() {
        return InstanceHolder.PlaceComponentResult;
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final CardPrefixQueryResultMapper_Factory PlaceComponentResult = new CardPrefixQueryResultMapper_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new CardPrefixQueryResultMapper();
    }
}
