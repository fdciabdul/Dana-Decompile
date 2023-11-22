package id.dana.data.merchant;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.merchant.repository.source.CacheMerchantCategoriesEntityData;
import id.dana.data.merchant.repository.source.local.DefaultMerchantCategoriesEntityData;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/data/merchant/CacheMerchantCategoriesEntityDataFactory;", "Lid/dana/data/AbstractEntityDataFactory;", "Lid/dana/data/merchant/repository/source/CacheMerchantCategoriesEntityData;", "", "source", "Lid/dana/data/merchant/repository/source/local/DefaultMerchantCategoriesEntityData;", "createData", "(Ljava/lang/String;)Lid/dana/data/merchant/repository/source/local/DefaultMerchantCategoriesEntityData;", "defaultMerchantCategoriesEntityData", "Lid/dana/data/merchant/repository/source/local/DefaultMerchantCategoriesEntityData;", "<init>", "(Lid/dana/data/merchant/repository/source/local/DefaultMerchantCategoriesEntityData;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CacheMerchantCategoriesEntityDataFactory extends AbstractEntityDataFactory<CacheMerchantCategoriesEntityData> {
    private final DefaultMerchantCategoriesEntityData defaultMerchantCategoriesEntityData;

    @Inject
    public CacheMerchantCategoriesEntityDataFactory(DefaultMerchantCategoriesEntityData defaultMerchantCategoriesEntityData) {
        Intrinsics.checkNotNullParameter(defaultMerchantCategoriesEntityData, "");
        this.defaultMerchantCategoriesEntityData = defaultMerchantCategoriesEntityData;
    }

    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public final CacheMerchantCategoriesEntityData createData2(String source) {
        return this.defaultMerchantCategoriesEntityData;
    }
}
