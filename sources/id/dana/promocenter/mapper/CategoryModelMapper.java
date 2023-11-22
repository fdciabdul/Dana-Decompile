package id.dana.promocenter.mapper;

import android.content.Context;
import id.dana.R;
import id.dana.common.model.OptionModel;
import id.dana.data.base.BaseMapper;
import id.dana.domain.promocenter.model.PromoCategory;
import id.dana.richview.category.model.CategoryModel;
import id.dana.utils.StringWrapper;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public class CategoryModelMapper extends BaseMapper<List<PromoCategory>, List<CategoryModel>> {
    private final Context MyBillsEntityDataFactory;

    @Override // id.dana.data.base.BaseMapper
    public /* synthetic */ List<CategoryModel> map(List<PromoCategory> list) {
        List<PromoCategory> list2 = list;
        ArrayList arrayList = new ArrayList();
        if (list2 != null) {
            for (PromoCategory promoCategory : list2) {
                CategoryModel categoryModel = new CategoryModel();
                categoryModel.MyBillsEntityDataFactory = promoCategory.getCategoryId();
                categoryModel.KClassImpl$Data$declaredNonStaticMembers$2 = promoCategory.getCategoryName();
                categoryModel.moveToNextValue = new StringWrapper.StringValue(promoCategory.getCategoryName());
                categoryModel.BuiltInFictitiousFunctionClassFactory = new StringWrapper.StringValue(promoCategory.getCategoryName());
                categoryModel.PlaceComponentResult = false;
                categoryModel.scheduleImpl = 1;
                List<OptionModel> PlaceComponentResult = PlaceComponentResult(promoCategory.getCategoryFilter(), "filter");
                Intrinsics.checkNotNullParameter(PlaceComponentResult, "");
                categoryModel.getAuthRequestContext = PlaceComponentResult;
                List<OptionModel> PlaceComponentResult2 = PlaceComponentResult(promoCategory.getCategorySorting(), "sort");
                Intrinsics.checkNotNullParameter(PlaceComponentResult2, "");
                categoryModel.getErrorConfigVersion = PlaceComponentResult2;
                arrayList.add(categoryModel);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public CategoryModelMapper(Context context) {
        this.MyBillsEntityDataFactory = context;
    }

    private List<OptionModel> PlaceComponentResult(List<String> list, String str) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (String str2 : list) {
                String str3 = "";
                if ("filter".equals(str)) {
                    if ("NEAREST_LOCATION".equalsIgnoreCase(str2)) {
                        str3 = this.MyBillsEntityDataFactory.getString(R.string.near_merchant);
                    }
                } else {
                    str2.hashCode();
                    if (str2.equals("NEW")) {
                        str3 = this.MyBillsEntityDataFactory.getString(R.string.new_promo);
                    } else if (str2.equals("NEAR_EXPIRED")) {
                        str3 = this.MyBillsEntityDataFactory.getString(R.string.near_expired);
                    }
                }
                arrayList.add(new OptionModel(str3, str2));
            }
        }
        return arrayList;
    }
}
