package id.dana.data.merchant;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.merchant.repository.source.MerchantCategoriesEntityData;
import id.dana.data.merchant.repository.source.amcs.NetworkMerchantCategoriesEntityData;
import id.dana.data.merchant.repository.source.local.DefaultMerchantCategoriesEntityData;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class MerchantCategoriesEntityDataFactory extends AbstractEntityDataFactory<MerchantCategoriesEntityData> {
    private final DefaultMerchantCategoriesEntityData defaultMerchantCategoriesEntityData;
    private final NetworkMerchantCategoriesEntityData networkMerchantCategoriesEntityData;

    @Inject
    public MerchantCategoriesEntityDataFactory(NetworkMerchantCategoriesEntityData networkMerchantCategoriesEntityData, DefaultMerchantCategoriesEntityData defaultMerchantCategoriesEntityData) {
        this.networkMerchantCategoriesEntityData = networkMerchantCategoriesEntityData;
        this.defaultMerchantCategoriesEntityData = defaultMerchantCategoriesEntityData;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public MerchantCategoriesEntityData createData2(String str) {
        if ("local".equals(str)) {
            return this.defaultMerchantCategoriesEntityData;
        }
        return this.networkMerchantCategoriesEntityData;
    }
}
