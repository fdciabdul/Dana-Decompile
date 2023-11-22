package id.dana.sendmoney.data.api.globalsend.province.mapper;

import id.dana.sendmoney.data.api.globalsend.province.model.CityEntity;
import id.dana.sendmoney.data.api.globalsend.province.model.ProvinceEntity;
import id.dana.sendmoney.domain.globalsend.model.province.City;
import id.dana.sendmoney.domain.globalsend.model.province.Province;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004*\b\u0012\u0004\u0012\u00020\u00000\u0004¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0011\u0010\t\u001a\u00020\b*\u00020\u0007¢\u0006\u0004\b\t\u0010\n\u001a\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0004*\b\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0004\b\u000b\u0010\u0006"}, d2 = {"Lid/dana/sendmoney/data/api/globalsend/province/model/CityEntity;", "Lid/dana/sendmoney/domain/globalsend/model/province/City;", "toCity", "(Lid/dana/sendmoney/data/api/globalsend/province/model/CityEntity;)Lid/dana/sendmoney/domain/globalsend/model/province/City;", "", "toCityList", "(Ljava/util/List;)Ljava/util/List;", "Lid/dana/sendmoney/data/api/globalsend/province/model/ProvinceEntity;", "Lid/dana/sendmoney/domain/globalsend/model/province/Province;", "toProvince", "(Lid/dana/sendmoney/data/api/globalsend/province/model/ProvinceEntity;)Lid/dana/sendmoney/domain/globalsend/model/province/Province;", "toProvinceList"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ProvinceEntityMapperKt {
    public static final City toCity(CityEntity cityEntity) {
        Intrinsics.checkNotNullParameter(cityEntity, "");
        String cityName = cityEntity.getCityName();
        if (cityName == null) {
            cityName = "";
        }
        String cityCode = cityEntity.getCityCode();
        return new City(cityName, cityCode != null ? cityCode : "");
    }

    public static final List<City> toCityList(List<CityEntity> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<CityEntity> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toCity((CityEntity) it.next()));
        }
        return arrayList;
    }

    public static final Province toProvince(ProvinceEntity provinceEntity) {
        Intrinsics.checkNotNullParameter(provinceEntity, "");
        String provinceName = provinceEntity.getProvinceName();
        if (provinceName == null) {
            provinceName = "";
        }
        String provinceCode = provinceEntity.getProvinceCode();
        return new Province(provinceName, provinceCode != null ? provinceCode : "", provinceEntity.getCities() == null ? CollectionsKt.emptyList() : toCityList(provinceEntity.getCities()));
    }

    public static final List<Province> toProvinceList(List<ProvinceEntity> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<ProvinceEntity> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toProvince((ProvinceEntity) it.next()));
        }
        return arrayList;
    }
}
