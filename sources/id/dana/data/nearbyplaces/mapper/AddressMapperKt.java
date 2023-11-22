package id.dana.data.nearbyplaces.mapper;

import id.dana.data.here.model.Address;
import id.dana.domain.geocode.model.IndoSubdivisions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/data/here/model/Address;", "Lid/dana/domain/geocode/model/IndoSubdivisions;", "generateSubdivision", "(Lid/dana/data/here/model/Address;)Lid/dana/domain/geocode/model/IndoSubdivisions;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AddressMapperKt {
    public static final IndoSubdivisions generateSubdivision(Address address) {
        Intrinsics.checkNotNullParameter(address, "");
        IndoSubdivisions.Builder builder = new IndoSubdivisions.Builder();
        String countryCode = address.getCountryCode();
        if (countryCode == null) {
            countryCode = "";
        }
        builder.withCountryCode(countryCode);
        String countryName = address.getCountryName();
        if (countryName == null) {
            countryName = "";
        }
        builder.withCountryName(countryName);
        String county = address.getCounty();
        if (county == null) {
            county = "";
        }
        builder.withProvinceName(county);
        String city = address.getCity();
        if (city == null) {
            city = "";
        }
        builder.withCityName(city);
        String district = address.getDistrict();
        if (district == null) {
            district = "";
        }
        builder.withDistrictName(district);
        String subdistrict = address.getSubdistrict();
        if (subdistrict == null) {
            subdistrict = "";
        }
        builder.withSubdistrictName(subdistrict);
        String street = address.getStreet();
        if (street == null) {
            street = "";
        }
        builder.withStreetName(street);
        Integer postalCode = address.getPostalCode();
        String obj = postalCode != null ? postalCode.toString() : null;
        builder.withPostalCode(obj != null ? obj : "");
        return builder.create();
    }
}
