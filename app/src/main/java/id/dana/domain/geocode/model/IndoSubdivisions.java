package id.dana.domain.geocode.model;

import com.alibaba.ariver.engine.common.track.watchdog.ARiverTrackWatchDogEventConstant;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001:\u00011Bc\b\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\f¢\u0006\u0004\b/\u00100J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJj\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\fHÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001b\u001a\u00020\f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b \u0010\u0004R\u0017\u0010\u0012\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0012\u0010!\u001a\u0004\b\"\u0010\u0004R\u001a\u0010\u000f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010!\u001a\u0004\b#\u0010\u0004R\u001a\u0010\u0010\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010!\u001a\u0004\b$\u0010\u0004R\u001a\u0010\u0013\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010!\u001a\u0004\b%\u0010\u0004R\u0011\u0010&\u001a\u00020\f8G¢\u0006\u0006\u001a\u0004\b&\u0010\u000eR\"\u0010\u0017\u001a\u00020\f8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010'\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b(\u0010)R\u0011\u0010*\u001a\u00020\f8G¢\u0006\u0006\u001a\u0004\b*\u0010\u000eR\u001a\u0010\u0016\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010!\u001a\u0004\b+\u0010\u0004R\u001a\u0010\u0011\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010!\u001a\u0004\b,\u0010\u0004R\u001a\u0010\u0015\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010!\u001a\u0004\b-\u0010\u0004R\u001a\u0010\u0014\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010!\u001a\u0004\b.\u0010\u0004"}, d2 = {"Lid/dana/domain/geocode/model/IndoSubdivisions;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "", "component9", "()Z", RemoteConfigConstants.RequestFieldKey.COUNTRY_CODE, "countryName", "proviceName", "cityName", "districtName", "subdistrictName", "streetName", "postalCode", "isMockLocation", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lid/dana/domain/geocode/model/IndoSubdivisions;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getCityName", "getCountryCode", "getCountryName", "getDistrictName", "isEmpty", "Z", "setMockLocation", "(Z)V", "isThereAnyEmptyField", "getPostalCode", "getProviceName", "getStreetName", "getSubdistrictName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "Builder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class IndoSubdivisions {
    private final String cityName;
    private final String countryCode;
    private final String countryName;
    private final String districtName;
    private boolean isMockLocation;
    private final String postalCode;
    private final String proviceName;
    private final String streetName;
    private final String subdistrictName;

    /* renamed from: component1  reason: from getter */
    public final String getCountryCode() {
        return this.countryCode;
    }

    /* renamed from: component2  reason: from getter */
    public final String getCountryName() {
        return this.countryName;
    }

    /* renamed from: component3  reason: from getter */
    public final String getProviceName() {
        return this.proviceName;
    }

    /* renamed from: component4  reason: from getter */
    public final String getCityName() {
        return this.cityName;
    }

    /* renamed from: component5  reason: from getter */
    public final String getDistrictName() {
        return this.districtName;
    }

    /* renamed from: component6  reason: from getter */
    public final String getSubdistrictName() {
        return this.subdistrictName;
    }

    /* renamed from: component7  reason: from getter */
    public final String getStreetName() {
        return this.streetName;
    }

    /* renamed from: component8  reason: from getter */
    public final String getPostalCode() {
        return this.postalCode;
    }

    /* renamed from: component9  reason: from getter */
    public final boolean getIsMockLocation() {
        return this.isMockLocation;
    }

    public final IndoSubdivisions copy(String countryCode, String countryName, String proviceName, String cityName, String districtName, String subdistrictName, String streetName, String postalCode, boolean isMockLocation) {
        Intrinsics.checkNotNullParameter(countryCode, "");
        Intrinsics.checkNotNullParameter(countryName, "");
        Intrinsics.checkNotNullParameter(proviceName, "");
        Intrinsics.checkNotNullParameter(cityName, "");
        Intrinsics.checkNotNullParameter(districtName, "");
        Intrinsics.checkNotNullParameter(subdistrictName, "");
        Intrinsics.checkNotNullParameter(streetName, "");
        Intrinsics.checkNotNullParameter(postalCode, "");
        return new IndoSubdivisions(countryCode, countryName, proviceName, cityName, districtName, subdistrictName, streetName, postalCode, isMockLocation);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof IndoSubdivisions) {
            IndoSubdivisions indoSubdivisions = (IndoSubdivisions) other;
            return Intrinsics.areEqual(this.countryCode, indoSubdivisions.countryCode) && Intrinsics.areEqual(this.countryName, indoSubdivisions.countryName) && Intrinsics.areEqual(this.proviceName, indoSubdivisions.proviceName) && Intrinsics.areEqual(this.cityName, indoSubdivisions.cityName) && Intrinsics.areEqual(this.districtName, indoSubdivisions.districtName) && Intrinsics.areEqual(this.subdistrictName, indoSubdivisions.subdistrictName) && Intrinsics.areEqual(this.streetName, indoSubdivisions.streetName) && Intrinsics.areEqual(this.postalCode, indoSubdivisions.postalCode) && this.isMockLocation == indoSubdivisions.isMockLocation;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.countryCode.hashCode();
        int hashCode2 = this.countryName.hashCode();
        int hashCode3 = this.proviceName.hashCode();
        int hashCode4 = this.cityName.hashCode();
        int hashCode5 = this.districtName.hashCode();
        int hashCode6 = this.subdistrictName.hashCode();
        int hashCode7 = this.streetName.hashCode();
        int hashCode8 = this.postalCode.hashCode();
        boolean z = this.isMockLocation;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return (((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("IndoSubdivisions(countryCode=");
        sb.append(this.countryCode);
        sb.append(", countryName=");
        sb.append(this.countryName);
        sb.append(", proviceName=");
        sb.append(this.proviceName);
        sb.append(", cityName=");
        sb.append(this.cityName);
        sb.append(", districtName=");
        sb.append(this.districtName);
        sb.append(", subdistrictName=");
        sb.append(this.subdistrictName);
        sb.append(", streetName=");
        sb.append(this.streetName);
        sb.append(", postalCode=");
        sb.append(this.postalCode);
        sb.append(", isMockLocation=");
        sb.append(this.isMockLocation);
        sb.append(')');
        return sb.toString();
    }

    private IndoSubdivisions(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z) {
        this.countryCode = str;
        this.countryName = str2;
        this.proviceName = str3;
        this.cityName = str4;
        this.districtName = str5;
        this.subdistrictName = str6;
        this.streetName = str7;
        this.postalCode = str8;
        this.isMockLocation = z;
    }

    /* synthetic */ IndoSubdivisions(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "" : str6, (i & 64) != 0 ? "" : str7, (i & 128) == 0 ? str8 : "", (i & 256) != 0 ? false : z);
    }

    @JvmName(name = "getCountryCode")
    public final String getCountryCode() {
        return this.countryCode;
    }

    @JvmName(name = "getCountryName")
    public final String getCountryName() {
        return this.countryName;
    }

    @JvmName(name = "getProviceName")
    public final String getProviceName() {
        return this.proviceName;
    }

    @JvmName(name = "getCityName")
    public final String getCityName() {
        return this.cityName;
    }

    @JvmName(name = "getDistrictName")
    public final String getDistrictName() {
        return this.districtName;
    }

    @JvmName(name = "getSubdistrictName")
    public final String getSubdistrictName() {
        return this.subdistrictName;
    }

    @JvmName(name = "getStreetName")
    public final String getStreetName() {
        return this.streetName;
    }

    @JvmName(name = "getPostalCode")
    public final String getPostalCode() {
        return this.postalCode;
    }

    @JvmName(name = "isMockLocation")
    public final boolean isMockLocation() {
        return this.isMockLocation;
    }

    @JvmName(name = "setMockLocation")
    public final void setMockLocation(boolean z) {
        this.isMockLocation = z;
    }

    @JvmName(name = "isEmpty")
    public final boolean isEmpty() {
        if (this.countryCode.length() == 0) {
            if (this.countryName.length() == 0) {
                if (this.proviceName.length() == 0) {
                    if (this.cityName.length() == 0) {
                        if (this.districtName.length() == 0) {
                            if (this.subdistrictName.length() == 0) {
                                if (this.streetName.length() == 0) {
                                    return this.postalCode.length() == 0;
                                }
                                return false;
                            }
                            return false;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    @JvmName(name = "isThereAnyEmptyField")
    public final boolean isThereAnyEmptyField() {
        if (!(this.countryCode.length() == 0)) {
            if (!(this.countryName.length() == 0)) {
                if (!(this.proviceName.length() == 0)) {
                    if (!(this.cityName.length() == 0)) {
                        if (!(this.districtName.length() == 0)) {
                            if (!(this.subdistrictName.length() == 0)) {
                                if (!(this.streetName.length() == 0)) {
                                    if (!(this.postalCode.length() == 0)) {
                                        return false;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0016\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0018\u0010\u0019B\u0011\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u001bJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\n\u0010\bJ\u0017\u0010\f\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\f\u0010\bJ\u0017\u0010\u000e\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000e\u0010\bJ\u0017\u0010\u0010\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0010\u0010\bJ\u0017\u0010\u0012\u001a\u00020\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0012\u0010\bJ\u0017\u0010\u0014\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0014\u0010\bJ\u0017\u0010\u0016\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0016\u0010\bR\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0017R\u0016\u0010\t\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0017R\u0016\u0010\u000b\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0017R\u0016\u0010\r\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0017R\u0016\u0010\u000f\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0017R\u0016\u0010\u0011\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0017R\u0016\u0010\u0013\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0017R\u0016\u0010\u0015\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0017"}, d2 = {"Lid/dana/domain/geocode/model/IndoSubdivisions$Builder;", "", "Lid/dana/domain/geocode/model/IndoSubdivisions;", ARiverTrackWatchDogEventConstant.FLAG_START_UP_CREATE, "()Lid/dana/domain/geocode/model/IndoSubdivisions;", "", "cityName", "withCityName", "(Ljava/lang/String;)Lid/dana/domain/geocode/model/IndoSubdivisions$Builder;", RemoteConfigConstants.RequestFieldKey.COUNTRY_CODE, "withCountryCode", "countryName", "withCountryName", "districtName", "withDistrictName", "postalCode", "withPostalCode", "proviceName", "withProvinceName", "streetName", "withStreetName", "subdistrictName", "withSubdistrictName", "Ljava/lang/String;", "<init>", "()V", "indoSubdivisions", "(Lid/dana/domain/geocode/model/IndoSubdivisions;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Builder {
        private String cityName;
        private String countryCode;
        private String countryName;
        private String districtName;
        private String postalCode;
        private String proviceName;
        private String streetName;
        private String subdistrictName;

        public Builder() {
            this.countryCode = "";
            this.countryName = "";
            this.proviceName = "";
            this.cityName = "";
            this.districtName = "";
            this.subdistrictName = "";
            this.streetName = "";
            this.postalCode = "";
        }

        public Builder(IndoSubdivisions indoSubdivisions) {
            Intrinsics.checkNotNullParameter(indoSubdivisions, "");
            this.countryCode = "";
            this.countryName = "";
            this.proviceName = "";
            this.cityName = "";
            this.districtName = "";
            this.subdistrictName = "";
            this.streetName = "";
            this.postalCode = "";
            if (indoSubdivisions.getCountryCode().length() > 0) {
                withCountryCode(indoSubdivisions.getCountryCode());
            }
            if (indoSubdivisions.getCountryName().length() > 0) {
                withCountryName(indoSubdivisions.getCountryName());
            }
            if (indoSubdivisions.getProviceName().length() > 0) {
                withProvinceName(indoSubdivisions.getProviceName());
            }
            if (indoSubdivisions.getCityName().length() > 0) {
                withCityName(indoSubdivisions.getCityName());
            }
            if (indoSubdivisions.getDistrictName().length() > 0) {
                withDistrictName(indoSubdivisions.getDistrictName());
            }
            if (indoSubdivisions.getSubdistrictName().length() > 0) {
                withSubdistrictName(indoSubdivisions.getSubdistrictName());
            }
            if (indoSubdivisions.getStreetName().length() > 0) {
                withStreetName(indoSubdivisions.getStreetName());
            }
            if (indoSubdivisions.getPostalCode().length() > 0) {
                withPostalCode(indoSubdivisions.getPostalCode());
            }
        }

        public final Builder withCountryCode(String countryCode) {
            if (countryCode != null) {
                this.countryCode = countryCode;
            }
            return this;
        }

        public final Builder withCountryName(String countryName) {
            if (countryName != null) {
                this.countryName = countryName;
            }
            return this;
        }

        public final Builder withProvinceName(String proviceName) {
            if (proviceName != null) {
                this.proviceName = proviceName;
            }
            return this;
        }

        public final Builder withCityName(String cityName) {
            if (cityName != null) {
                this.cityName = cityName;
            }
            return this;
        }

        public final Builder withDistrictName(String districtName) {
            if (districtName != null) {
                this.districtName = districtName;
            }
            return this;
        }

        public final Builder withSubdistrictName(String subdistrictName) {
            if (subdistrictName != null) {
                this.subdistrictName = subdistrictName;
            }
            return this;
        }

        public final Builder withStreetName(String streetName) {
            if (streetName != null) {
                this.streetName = streetName;
            }
            return this;
        }

        public final Builder withPostalCode(String postalCode) {
            if (postalCode != null) {
                this.postalCode = postalCode;
            }
            return this;
        }

        public final IndoSubdivisions create() {
            return new IndoSubdivisions(this.countryCode, this.countryName, this.proviceName, this.cityName, this.districtName, this.subdistrictName, this.streetName, this.postalCode, false, 256, null);
        }
    }
}
