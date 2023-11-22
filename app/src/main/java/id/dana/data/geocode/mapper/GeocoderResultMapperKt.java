package id.dana.data.geocode.mapper;

import id.dana.data.geocode.model.GeocoderResult;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0004\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0011\u0010\u0005\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0006\u0010\u0003\u001a\u0011\u0010\u0007\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0007\u0010\u0003\u001a\u0011\u0010\b\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\b\u0010\u0003\u001a\u0011\u0010\t\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\t\u0010\u0003\"\u0014\u0010\n\u001a\u00020\u00018\u0000X\u0080T¢\u0006\u0006\n\u0004\b\n\u0010\u000b\"\u0014\u0010\f\u001a\u00020\u00018\u0000X\u0080T¢\u0006\u0006\n\u0004\b\f\u0010\u000b\"\u0014\u0010\r\u001a\u00020\u00018\u0000X\u0080T¢\u0006\u0006\n\u0004\b\r\u0010\u000b\"\u0014\u0010\u000e\u001a\u00020\u00018\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000b\"\u0014\u0010\u000f\u001a\u00020\u00018\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000b"}, d2 = {"Lid/dana/data/geocode/model/GeocoderResult;", "", "toCityName", "(Lid/dana/data/geocode/model/GeocoderResult;)Ljava/lang/String;", "toCountryCode", "toCountryName", "toDistrictName", "toDistrictName2", "toProvinceName", "toSubDistrictName", "ADMINISTRATIVE_LEVEL_1", "Ljava/lang/String;", "ADMINISTRATIVE_LEVEL_2", "ADMINISTRATIVE_LEVEL_3", "ADMINISTRATIVE_LEVEL_4", "COUNTRY"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GeocoderResultMapperKt {
    public static final String ADMINISTRATIVE_LEVEL_1 = "administrative_area_level_1";
    public static final String ADMINISTRATIVE_LEVEL_2 = "administrative_area_level_2";
    public static final String ADMINISTRATIVE_LEVEL_3 = "administrative_area_level_3";
    public static final String ADMINISTRATIVE_LEVEL_4 = "administrative_area_level_4";
    public static final String COUNTRY = "country";

    public static final String toDistrictName(GeocoderResult geocoderResult) {
        Intrinsics.checkNotNullParameter(geocoderResult, "");
        GeocoderResult.AddressComponent[] address_components = geocoderResult.getResults()[0].getAddress_components();
        ArrayList arrayList = new ArrayList();
        for (GeocoderResult.AddressComponent addressComponent : address_components) {
            if (ArraysKt.contains(addressComponent.getTypes(), ADMINISTRATIVE_LEVEL_4)) {
                arrayList.add(addressComponent);
            }
        }
        GeocoderResult.AddressComponent addressComponent2 = (GeocoderResult.AddressComponent) CollectionsKt.firstOrNull((List) arrayList);
        String short_name = addressComponent2 != null ? addressComponent2.getShort_name() : null;
        return short_name == null ? "" : short_name;
    }

    public static final String toSubDistrictName(GeocoderResult geocoderResult) {
        GeocoderResult.AddressComponent addressComponent;
        Intrinsics.checkNotNullParameter(geocoderResult, "");
        int i = 0;
        GeocoderResult.AddressComponent[] address_components = geocoderResult.getResults()[0].getAddress_components();
        int length = address_components.length;
        while (true) {
            if (i >= length) {
                addressComponent = null;
                break;
            }
            addressComponent = address_components[i];
            if (ArraysKt.contains(addressComponent.getTypes(), ADMINISTRATIVE_LEVEL_4)) {
                break;
            }
            i++;
        }
        String short_name = addressComponent != null ? addressComponent.getShort_name() : null;
        return short_name == null ? "" : short_name;
    }

    public static final String toDistrictName2(GeocoderResult geocoderResult) {
        GeocoderResult.AddressComponent addressComponent;
        Intrinsics.checkNotNullParameter(geocoderResult, "");
        int i = 0;
        GeocoderResult.AddressComponent[] address_components = geocoderResult.getResults()[0].getAddress_components();
        int length = address_components.length;
        while (true) {
            if (i >= length) {
                addressComponent = null;
                break;
            }
            addressComponent = address_components[i];
            if (ArraysKt.contains(addressComponent.getTypes(), ADMINISTRATIVE_LEVEL_3)) {
                break;
            }
            i++;
        }
        String short_name = addressComponent != null ? addressComponent.getShort_name() : null;
        return short_name == null ? "" : short_name;
    }

    public static final String toCityName(GeocoderResult geocoderResult) {
        GeocoderResult.AddressComponent addressComponent;
        Intrinsics.checkNotNullParameter(geocoderResult, "");
        int i = 0;
        GeocoderResult.AddressComponent[] address_components = geocoderResult.getResults()[0].getAddress_components();
        int length = address_components.length;
        while (true) {
            if (i >= length) {
                addressComponent = null;
                break;
            }
            addressComponent = address_components[i];
            if (ArraysKt.contains(addressComponent.getTypes(), ADMINISTRATIVE_LEVEL_2)) {
                break;
            }
            i++;
        }
        String short_name = addressComponent != null ? addressComponent.getShort_name() : null;
        return short_name == null ? "" : short_name;
    }

    public static final String toProvinceName(GeocoderResult geocoderResult) {
        GeocoderResult.AddressComponent addressComponent;
        Intrinsics.checkNotNullParameter(geocoderResult, "");
        int i = 0;
        GeocoderResult.AddressComponent[] address_components = geocoderResult.getResults()[0].getAddress_components();
        int length = address_components.length;
        while (true) {
            if (i >= length) {
                addressComponent = null;
                break;
            }
            addressComponent = address_components[i];
            if (ArraysKt.contains(addressComponent.getTypes(), ADMINISTRATIVE_LEVEL_1)) {
                break;
            }
            i++;
        }
        String short_name = addressComponent != null ? addressComponent.getShort_name() : null;
        return short_name == null ? "" : short_name;
    }

    public static final String toCountryName(GeocoderResult geocoderResult) {
        GeocoderResult.AddressComponent addressComponent;
        Intrinsics.checkNotNullParameter(geocoderResult, "");
        int i = 0;
        GeocoderResult.AddressComponent[] address_components = geocoderResult.getResults()[0].getAddress_components();
        int length = address_components.length;
        while (true) {
            if (i >= length) {
                addressComponent = null;
                break;
            }
            addressComponent = address_components[i];
            if (ArraysKt.contains(addressComponent.getTypes(), COUNTRY)) {
                break;
            }
            i++;
        }
        String long_name = addressComponent != null ? addressComponent.getLong_name() : null;
        return long_name == null ? "" : long_name;
    }

    public static final String toCountryCode(GeocoderResult geocoderResult) {
        GeocoderResult.AddressComponent addressComponent;
        Intrinsics.checkNotNullParameter(geocoderResult, "");
        int i = 0;
        GeocoderResult.AddressComponent[] address_components = geocoderResult.getResults()[0].getAddress_components();
        int length = address_components.length;
        while (true) {
            if (i >= length) {
                addressComponent = null;
                break;
            }
            addressComponent = address_components[i];
            if (ArraysKt.contains(addressComponent.getTypes(), COUNTRY)) {
                break;
            }
            i++;
        }
        String short_name = addressComponent != null ? addressComponent.getShort_name() : null;
        return short_name == null ? "" : short_name;
    }
}
