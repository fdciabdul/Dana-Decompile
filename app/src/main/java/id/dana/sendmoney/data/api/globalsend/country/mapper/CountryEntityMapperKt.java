package id.dana.sendmoney.data.api.globalsend.country.mapper;

import id.dana.sendmoney.data.api.globalsend.country.model.CountryEntity;
import id.dana.sendmoney.domain.globalsend.model.country.Country;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004*\b\u0012\u0004\u0012\u00020\u00000\u0004¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/sendmoney/data/api/globalsend/country/model/CountryEntity;", "Lid/dana/sendmoney/domain/globalsend/model/country/Country;", "toCountry", "(Lid/dana/sendmoney/data/api/globalsend/country/model/CountryEntity;)Lid/dana/sendmoney/domain/globalsend/model/country/Country;", "", "toCountryList", "(Ljava/util/List;)Ljava/util/List;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CountryEntityMapperKt {
    public static final Country toCountry(CountryEntity countryEntity) {
        Intrinsics.checkNotNullParameter(countryEntity, "");
        String countryNameID = countryEntity.getCountryNameID();
        String str = countryNameID == null ? "" : countryNameID;
        String countryNameEN = countryEntity.getCountryNameEN();
        String str2 = countryNameEN == null ? "" : countryNameEN;
        String countryISOAlpha3Code = countryEntity.getCountryISOAlpha3Code();
        String str3 = countryISOAlpha3Code == null ? "" : countryISOAlpha3Code;
        String countryISONumericCode = countryEntity.getCountryISONumericCode();
        String str4 = countryISONumericCode == null ? "" : countryISONumericCode;
        String currencyCode = countryEntity.getCurrencyCode();
        String str5 = currencyCode == null ? "" : currencyCode;
        String sendMoneyEstimationTimeValue = countryEntity.getSendMoneyEstimationTimeValue();
        String str6 = sendMoneyEstimationTimeValue == null ? "" : sendMoneyEstimationTimeValue;
        String sendMoneyEstimationTimeUnit = countryEntity.getSendMoneyEstimationTimeUnit();
        String str7 = sendMoneyEstimationTimeUnit == null ? "" : sendMoneyEstimationTimeUnit;
        String otherKeys = countryEntity.getOtherKeys();
        String str8 = otherKeys == null ? "" : otherKeys;
        Boolean inMaintenance = countryEntity.getInMaintenance();
        boolean booleanValue = inMaintenance != null ? inMaintenance.booleanValue() : true;
        Boolean isActive = countryEntity.getIsActive();
        return new Country(str, str2, str3, str4, str5, str6, str7, str8, booleanValue, isActive != null ? isActive.booleanValue() : false);
    }

    public static final List<Country> toCountryList(List<CountryEntity> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<CountryEntity> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toCountry((CountryEntity) it.next()));
        }
        return arrayList;
    }
}
