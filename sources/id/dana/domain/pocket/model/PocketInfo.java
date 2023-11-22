package id.dana.domain.pocket.model;

import com.google.firebase.messaging.Constants;
import id.dana.domain.qrbarcode.DecodedScanBizInfoKey;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001B¹\u0001\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0002\u0012\b\b\u0002\u0010.\u001a\u00020\u0002\u0012\b\b\u0002\u0010!\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u0012\b\b\u0002\u0010*\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010#\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0002\u0012\b\b\u0002\u0010,\u001a\u00020%\u0012\b\b\u0002\u0010&\u001a\u00020%\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\f¢\u0006\u0004\b0\u00101R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR&\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001a\u0010\u0013\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001a\u0010\u0015\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\u001a\u0010\u0017\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u001a\u0010\u0019\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006R\u001a\u0010\u001b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006R\u001a\u0010\u001d\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006R\u001a\u0010\u001f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006R\u001a\u0010!\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006R\u001a\u0010#\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\u0006R\u001a\u0010&\u001a\u00020%8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010\u0004\u001a\u0004\b+\u0010\u0006R\u001a\u0010,\u001a\u00020%8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010'\u001a\u0004\b-\u0010)R\u001a\u0010.\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010\u0004\u001a\u0004\b/\u0010\u0006"}, d2 = {"Lid/dana/domain/pocket/model/PocketInfo;", "", "", "backgroundUrl", "Ljava/lang/String;", "getBackgroundUrl", "()Ljava/lang/String;", "", "expirationDate", "J", "getExpirationDate", "()J", "", "extendInfo", "Ljava/util/Map;", "getExtendInfo", "()Ljava/util/Map;", "goodsId", "getGoodsId", "iconUrl", "getIconUrl", Constants.ScionAnalytics.PARAM_LABEL, "getLabel", DecodedScanBizInfoKey.LOGO_URL, "getLogoUrl", "merchantId", "getMerchantId", "number", "getNumber", "pocketId", "getPocketId", "pocketStatus", "getPocketStatus", "pocketType", "getPocketType", "points", "getPoints", "", "shareable", "Z", "getShareable", "()Z", "subLabel", "getSubLabel", "usable", "getUsable", "userPocketStatus", "getUserPocketStatus", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZJLjava/util/Map;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class PocketInfo {
    private final String backgroundUrl;
    private final long expirationDate;
    private final Map<String, String> extendInfo;
    private final String goodsId;
    private final String iconUrl;
    private final String label;
    private final String logoUrl;
    private final String merchantId;
    private final String number;
    private final String pocketId;
    private final String pocketStatus;
    private final String pocketType;
    private final String points;
    private final boolean shareable;
    private final String subLabel;
    private final boolean usable;
    private final String userPocketStatus;

    public PocketInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, boolean z, boolean z2, long j, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        Intrinsics.checkNotNullParameter(str7, "");
        Intrinsics.checkNotNullParameter(str8, "");
        Intrinsics.checkNotNullParameter(str9, "");
        Intrinsics.checkNotNullParameter(str10, "");
        Intrinsics.checkNotNullParameter(str11, "");
        Intrinsics.checkNotNullParameter(str12, "");
        Intrinsics.checkNotNullParameter(str13, "");
        Intrinsics.checkNotNullParameter(map, "");
        this.pocketId = str;
        this.pocketStatus = str2;
        this.userPocketStatus = str3;
        this.pocketType = str4;
        this.goodsId = str5;
        this.merchantId = str6;
        this.label = str7;
        this.subLabel = str8;
        this.iconUrl = str9;
        this.logoUrl = str10;
        this.backgroundUrl = str11;
        this.points = str12;
        this.number = str13;
        this.usable = z;
        this.shareable = z2;
        this.expirationDate = j;
        this.extendInfo = map;
    }

    public /* synthetic */ PocketInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, boolean z, boolean z2, long j, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "" : str6, (i & 64) != 0 ? "" : str7, (i & 128) != 0 ? "" : str8, (i & 256) != 0 ? "" : str9, (i & 512) != 0 ? "" : str10, (i & 1024) != 0 ? "" : str11, (i & 2048) != 0 ? "" : str12, (i & 4096) != 0 ? "" : str13, (i & 8192) != 0 ? false : z, (i & 16384) != 0 ? false : z2, j, map);
    }

    @JvmName(name = "getPocketId")
    public final String getPocketId() {
        return this.pocketId;
    }

    @JvmName(name = "getPocketStatus")
    public final String getPocketStatus() {
        return this.pocketStatus;
    }

    @JvmName(name = "getUserPocketStatus")
    public final String getUserPocketStatus() {
        return this.userPocketStatus;
    }

    @JvmName(name = "getPocketType")
    public final String getPocketType() {
        return this.pocketType;
    }

    @JvmName(name = "getGoodsId")
    public final String getGoodsId() {
        return this.goodsId;
    }

    @JvmName(name = "getMerchantId")
    public final String getMerchantId() {
        return this.merchantId;
    }

    @JvmName(name = "getLabel")
    public final String getLabel() {
        return this.label;
    }

    @JvmName(name = "getSubLabel")
    public final String getSubLabel() {
        return this.subLabel;
    }

    @JvmName(name = "getIconUrl")
    public final String getIconUrl() {
        return this.iconUrl;
    }

    @JvmName(name = "getLogoUrl")
    public final String getLogoUrl() {
        return this.logoUrl;
    }

    @JvmName(name = "getBackgroundUrl")
    public final String getBackgroundUrl() {
        return this.backgroundUrl;
    }

    @JvmName(name = "getPoints")
    public final String getPoints() {
        return this.points;
    }

    @JvmName(name = "getNumber")
    public final String getNumber() {
        return this.number;
    }

    @JvmName(name = "getUsable")
    public final boolean getUsable() {
        return this.usable;
    }

    @JvmName(name = "getShareable")
    public final boolean getShareable() {
        return this.shareable;
    }

    @JvmName(name = "getExpirationDate")
    public final long getExpirationDate() {
        return this.expirationDate;
    }

    @JvmName(name = "getExtendInfo")
    public final Map<String, String> getExtendInfo() {
        return this.extendInfo;
    }
}
