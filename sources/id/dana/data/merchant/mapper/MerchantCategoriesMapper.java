package id.dana.data.merchant.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.merchant.model.MerchantCategoryEntity;
import id.dana.domain.merchant.model.MerchantCategory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class MerchantCategoriesMapper extends BaseMapper<List<MerchantCategoryEntity>, List<MerchantCategory>> {
    @Inject
    public MerchantCategoriesMapper() {
    }

    public MerchantCategory transform(MerchantCategoryEntity merchantCategoryEntity) {
        if (merchantCategoryEntity != null) {
            MerchantCategory merchantCategory = new MerchantCategory();
            merchantCategory.setId(merchantCategoryEntity.f8069id);
            merchantCategory.setName(merchantCategoryEntity.name);
            return merchantCategory;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public List<MerchantCategory> map(List<MerchantCategoryEntity> list) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            Iterator<MerchantCategoryEntity> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(transform(it.next()));
            }
            return arrayList;
        }
        return new ArrayList();
    }
}
