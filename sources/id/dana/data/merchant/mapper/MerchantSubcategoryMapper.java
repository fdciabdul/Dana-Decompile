package id.dana.data.merchant.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.merchant.model.MerchantSubcategoryEntity;
import id.dana.domain.merchant.model.MerchantSubcategory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class MerchantSubcategoryMapper extends BaseMapper<List<MerchantSubcategoryEntity>, List<MerchantSubcategory>> {
    @Inject
    public MerchantSubcategoryMapper() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public List<MerchantSubcategory> map(List<MerchantSubcategoryEntity> list) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            Iterator<MerchantSubcategoryEntity> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(transform(it.next()));
            }
            return arrayList;
        }
        return new ArrayList();
    }

    private MerchantSubcategory transform(MerchantSubcategoryEntity merchantSubcategoryEntity) {
        if (merchantSubcategoryEntity != null) {
            MerchantSubcategory merchantSubcategory = new MerchantSubcategory();
            merchantSubcategory.setMcc(merchantSubcategoryEntity.mcc);
            merchantSubcategory.setName(merchantSubcategoryEntity.Name);
            merchantSubcategory.setCategoryIds(getCategoryIds(merchantSubcategoryEntity));
            return merchantSubcategory;
        }
        return null;
    }

    private List<String> getCategoryIds(MerchantSubcategoryEntity merchantSubcategoryEntity) {
        ArrayList arrayList = new ArrayList();
        if (merchantSubcategoryEntity.categoryId != null) {
            arrayList.add(merchantSubcategoryEntity.categoryId);
        }
        if (merchantSubcategoryEntity.categoryIds != null) {
            arrayList.addAll(merchantSubcategoryEntity.categoryIds);
        }
        return arrayList;
    }

    public List<MerchantSubcategory> transform(Map<String, MerchantSubcategoryEntity> map) {
        ArrayList arrayList = new ArrayList();
        if (map != null) {
            Iterator<Map.Entry<String, MerchantSubcategoryEntity>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                arrayList.add(transform(it.next().getValue()));
            }
        }
        return arrayList;
    }
}
