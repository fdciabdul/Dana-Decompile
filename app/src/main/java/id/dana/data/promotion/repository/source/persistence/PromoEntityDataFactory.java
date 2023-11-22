package id.dana.data.promotion.repository.source.persistence;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.promotion.repository.source.PromoEntityData;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class PromoEntityDataFactory extends AbstractEntityDataFactory<PromoEntityData> {
    private final PersistencePromoEntityData persistencePromoEntityData;

    @Inject
    public PromoEntityDataFactory(PersistencePromoEntityData persistencePromoEntityData) {
        this.persistencePromoEntityData = persistencePromoEntityData;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    public PromoEntityData createData(String str) {
        return this.persistencePromoEntityData;
    }
}
