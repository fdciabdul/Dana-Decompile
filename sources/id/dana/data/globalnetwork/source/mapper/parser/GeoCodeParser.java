package id.dana.data.globalnetwork.source.mapper.parser;

import id.dana.data.geocode.mapper.GeocoderResultMapperKt;
import id.dana.data.geocode.model.GeocoderResult;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/data/globalnetwork/source/mapper/parser/GeoCodeParser;", "", "Lid/dana/data/geocode/model/GeocoderResult;", "geocoderResult", "", "getCountryCode", "(Lid/dana/data/geocode/model/GeocoderResult;)Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GeoCodeParser {
    public static final GeoCodeParser INSTANCE = new GeoCodeParser();

    private GeoCodeParser() {
    }

    public final String getCountryCode(GeocoderResult geocoderResult) {
        Intrinsics.checkNotNullParameter(geocoderResult, "");
        for (GeocoderResult.AddressComponent addressComponent : geocoderResult.getResults()[0].getAddress_components()) {
            if (ArraysKt.contains(addressComponent.getTypes(), GeocoderResultMapperKt.COUNTRY)) {
                return addressComponent.getShort_name();
            }
        }
        return "";
    }
}
