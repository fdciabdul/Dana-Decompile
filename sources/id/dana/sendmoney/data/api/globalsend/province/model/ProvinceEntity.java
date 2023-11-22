package id.dana.sendmoney.data.api.globalsend.province.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\f"}, d2 = {"Lid/dana/sendmoney/data/api/globalsend/province/model/ProvinceEntity;", "", "", "Lid/dana/sendmoney/data/api/globalsend/province/model/CityEntity;", "cities", "Ljava/util/List;", "getCities", "()Ljava/util/List;", "", "provinceCode", "Ljava/lang/String;", "getProvinceCode", "()Ljava/lang/String;", "provinceName", "getProvinceName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ProvinceEntity {
    @SerializedName("cities")
    private final List<CityEntity> cities;
    @SerializedName("province_code")
    private final String provinceCode;
    @SerializedName("province_name")
    private final String provinceName;

    public ProvinceEntity() {
        this(null, null, null, 7, null);
    }

    public ProvinceEntity(String str, String str2, List<CityEntity> list) {
        this.provinceName = str;
        this.provinceCode = str2;
        this.cities = list;
    }

    public /* synthetic */ ProvinceEntity(String str, String str2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : list);
    }

    @JvmName(name = "getProvinceName")
    public final String getProvinceName() {
        return this.provinceName;
    }

    @JvmName(name = "getProvinceCode")
    public final String getProvinceCode() {
        return this.provinceCode;
    }

    @JvmName(name = "getCities")
    public final List<CityEntity> getCities() {
        return this.cities;
    }
}
