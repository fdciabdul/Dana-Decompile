package id.dana.sendmoney.ui.globalsend.form.mapper;

import id.dana.sendmoney.domain.globalsend.model.province.City;
import id.dana.sendmoney.domain.globalsend.model.province.Province;
import id.dana.sendmoney.ui.globalsend.form.model.form.receiver.CityModel;
import id.dana.sendmoney.ui.globalsend.form.model.form.receiver.ProvinceModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/sendmoney/domain/globalsend/model/province/Province;", "Lid/dana/sendmoney/ui/globalsend/form/model/form/receiver/ProvinceModel;", "getAuthRequestContext", "(Lid/dana/sendmoney/domain/globalsend/model/province/Province;)Lid/dana/sendmoney/ui/globalsend/form/model/form/receiver/ProvinceModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ProvinceModelMapperKt {
    public static final ProvinceModel getAuthRequestContext(Province province) {
        Intrinsics.checkNotNullParameter(province, "");
        String str = province.getAuthRequestContext;
        String str2 = province.BuiltInFictitiousFunctionClassFactory;
        List<City> list = province.KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullParameter(list, "");
        List<City> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (City city : list2) {
            Intrinsics.checkNotNullParameter(city, "");
            arrayList.add(new CityModel(city.getAuthRequestContext, city.MyBillsEntityDataFactory));
        }
        return new ProvinceModel(str, str2, arrayList);
    }
}
