package id.dana.nearbyme.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.domain.merchant.model.MerchantSubcategory;
import id.dana.nearbyme.model.MerchantSubcategoryModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class MerchantSubcategoriesMapper extends BaseMapper<List<MerchantSubcategory>, List<MerchantSubcategoryModel>> {
    @Override // id.dana.data.base.BaseMapper
    public /* synthetic */ List<MerchantSubcategoryModel> map(List<MerchantSubcategory> list) {
        return KClassImpl$Data$declaredNonStaticMembers$2(list);
    }

    @Inject
    public MerchantSubcategoriesMapper() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static List<MerchantSubcategoryModel> KClassImpl$Data$declaredNonStaticMembers$2(List<MerchantSubcategory> list) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            Iterator<MerchantSubcategory> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(PlaceComponentResult(it.next()));
            }
            return arrayList;
        }
        return new ArrayList();
    }

    private static MerchantSubcategoryModel PlaceComponentResult(MerchantSubcategory merchantSubcategory) {
        if (merchantSubcategory != null) {
            MerchantSubcategoryModel merchantSubcategoryModel = new MerchantSubcategoryModel();
            merchantSubcategoryModel.getAuthRequestContext = merchantSubcategory.getMcc();
            merchantSubcategoryModel.KClassImpl$Data$declaredNonStaticMembers$2 = merchantSubcategory.getName();
            merchantSubcategoryModel.BuiltInFictitiousFunctionClassFactory = merchantSubcategory.getCategoryIds();
            return merchantSubcategoryModel;
        }
        return null;
    }
}
