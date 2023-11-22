package id.dana.nearbyme.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.domain.merchant.model.MerchantCategory;
import id.dana.nearbyme.model.MerchantCategoryModel;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class MerchantCategoriesMapper extends BaseMapper<List<MerchantCategory>, List<MerchantCategoryModel>> {
    @Override // id.dana.data.base.BaseMapper
    public /* synthetic */ List<MerchantCategoryModel> map(List<MerchantCategory> list) {
        MerchantCategoryModel merchantCategoryModel;
        List<MerchantCategory> list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (MerchantCategory merchantCategory : list2) {
                if (merchantCategory != null) {
                    merchantCategoryModel = new MerchantCategoryModel();
                    merchantCategoryModel.MyBillsEntityDataFactory = merchantCategory.getId();
                    merchantCategoryModel.getAuthRequestContext = merchantCategory.getName();
                } else {
                    merchantCategoryModel = null;
                }
                arrayList.add(merchantCategoryModel);
            }
            return arrayList;
        }
        return new ArrayList();
    }

    @Inject
    public MerchantCategoriesMapper() {
    }
}
