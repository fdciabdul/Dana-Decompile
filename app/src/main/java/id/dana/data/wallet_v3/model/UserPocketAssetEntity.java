package id.dana.data.wallet_v3.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.alipay.iap.android.aplog.util.CrashCombineUtils;
import com.alipay.mobile.security.faceauth.api.AntDetector;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import com.google.firebase.messaging.Constants;
import com.google.gson.annotations.SerializedName;
import id.dana.data.pocket.model.ShareableRpcInfoEntity;
import id.dana.domain.qrbarcode.DecodedScanBizInfoKey;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b(\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001BÛ\u0002\u0012\b\b\u0003\u00100\u001a\u00020\u0007\u0012\b\b\u0003\u00102\u001a\u00020\u0007\u0012\b\b\u0003\u0010&\u001a\u00020\u0007\u0012\b\b\u0003\u0010\f\u001a\u00020\u0007\u0012\n\b\u0003\u00104\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010H\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0003\u0010$\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010,\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010(\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010B\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010*\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010F\u001a\u0004\u0018\u000108\u0012\n\b\u0003\u00109\u001a\u0004\u0018\u000108\u0012\n\b\u0003\u0010\"\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010D\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010>\u001a\u0004\u0018\u00010=\u0012\u0016\b\u0003\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\n\b\u0003\u00106\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010 \u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010.\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\u0007\u0012\u0016\b\u0003\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\bJ\u0010KR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR(\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R$\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\t\u001a\u0004\b\u0019\u0010\u000bR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\t\u001a\u0004\b\u001b\u0010\u000bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006R(\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u0011\u001a\u0004\b\u001f\u0010\u0013R\u001c\u0010 \u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b \u0010\t\u001a\u0004\b!\u0010\u000bR\u001c\u0010\"\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010\t\u001a\u0004\b#\u0010\u000bR\u001c\u0010$\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010\t\u001a\u0004\b%\u0010\u000bR\u001a\u0010&\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010\t\u001a\u0004\b'\u0010\u000bR\u001c\u0010(\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010\t\u001a\u0004\b)\u0010\u000bR\u001c\u0010*\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010\t\u001a\u0004\b+\u0010\u000bR\u001c\u0010,\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010\t\u001a\u0004\b-\u0010\u000bR\u001c\u0010.\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010\t\u001a\u0004\b/\u0010\u000bR\u001a\u00100\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b0\u0010\t\u001a\u0004\b1\u0010\u000bR\u001a\u00102\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b2\u0010\t\u001a\u0004\b3\u0010\u000bR\u001c\u00104\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b4\u0010\t\u001a\u0004\b5\u0010\u000bR\u001c\u00106\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b6\u0010\t\u001a\u0004\b7\u0010\u000bR\u001c\u00109\u001a\u0004\u0018\u0001088\u0007X\u0087\u0004¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u001c\u0010>\u001a\u0004\u0018\u00010=8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u001c\u0010B\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\bB\u0010\t\u001a\u0004\bC\u0010\u000bR\u001c\u0010D\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\bD\u0010\t\u001a\u0004\bE\u0010\u000bR\u001c\u0010F\u001a\u0004\u0018\u0001088\u0007X\u0087\u0004¢\u0006\f\n\u0004\bF\u0010:\u001a\u0004\bG\u0010<R\u001c\u0010H\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\bH\u0010\t\u001a\u0004\bI\u0010\u000b"}, d2 = {"Lid/dana/data/wallet_v3/model/UserPocketAssetEntity;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "activateDate", "Ljava/lang/Long;", "getActivateDate", "()Ljava/lang/Long;", "", "backgroundColor", "Ljava/lang/String;", "getBackgroundColor", "()Ljava/lang/String;", "backgroundUrl", "getBackgroundUrl", "", "", "bizInfo", "Ljava/util/Map;", "getBizInfo", "()Ljava/util/Map;", "cacheTimestamp", "getCacheTimestamp", "setCacheTimestamp", "(Ljava/lang/Long;)V", "categoryIconUrl", "getCategoryIconUrl", "createdDate", "getCreatedDate", "expirationDate", "getExpirationDate", "extInfo", "getExtInfo", "fontColor", "getFontColor", "goodsId", "getGoodsId", "howTo", "getHowTo", "iconUrl", "getIconUrl", Constants.ScionAnalytics.PARAM_LABEL, "getLabel", DecodedScanBizInfoKey.LOGO_URL, "getLogoUrl", "merchantId", "getMerchantId", "minTransaction", "getMinTransaction", "pocketId", "getPocketId", "pocketStatus", "getPocketStatus", "pocketType", "getPocketType", "primaryCTA", "getPrimaryCTA", "", "shareable", "Ljava/lang/Boolean;", "getShareable", "()Ljava/lang/Boolean;", "Lid/dana/data/pocket/model/ShareableRpcInfoEntity;", "shareableRpcInfo", "Lid/dana/data/pocket/model/ShareableRpcInfoEntity;", "getShareableRpcInfo", "()Lid/dana/data/pocket/model/ShareableRpcInfoEntity;", "subLabel", "getSubLabel", "tcUrl", "getTcUrl", "usable", "getUsable", "userPocketStatus", "getUserPocketStatus", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Lid/dana/data/pocket/model/ShareableRpcInfoEntity;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/Long;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class UserPocketAssetEntity extends BaseRpcResult {
    @SerializedName("activateDate")
    private final Long activateDate;
    @SerializedName("backgroundColor")
    private final String backgroundColor;
    @SerializedName("backgroundUrl")
    private final String backgroundUrl;
    @SerializedName("bizInfo")
    private final Map<String, Object> bizInfo;
    @SerializedName("cacheTimestamp")
    private Long cacheTimestamp;
    @SerializedName("categoryIconUrl")
    private final String categoryIconUrl;
    @SerializedName("createdDate")
    private final String createdDate;
    @SerializedName("expirationDate")
    private final Long expirationDate;
    @SerializedName("extendInfo")
    private final Map<String, Object> extInfo;
    @SerializedName("fontColor")
    private final String fontColor;
    @SerializedName("goodsId")
    private final String goodsId;
    @SerializedName("howTo")
    private final String howTo;
    @SerializedName("iconUrl")
    private final String iconUrl;
    @SerializedName(Constants.ScionAnalytics.PARAM_LABEL)
    private final String label;
    @SerializedName(DecodedScanBizInfoKey.LOGO_URL)
    private final String logoUrl;
    @SerializedName("merchantId")
    private final String merchantId;
    @SerializedName("minTransaction")
    private final String minTransaction;
    @SerializedName("pocketId")
    private final String pocketId;
    @SerializedName("pocketStatus")
    private final String pocketStatus;
    @SerializedName("pocketType")
    private final String pocketType;
    @SerializedName("primaryCTA")
    private final String primaryCTA;
    @SerializedName("shareable")
    private final Boolean shareable;
    @SerializedName("shareableRpcInfo")
    private final ShareableRpcInfoEntity shareableRpcInfo;
    @SerializedName("subLabel")
    private final String subLabel;
    @SerializedName("tcUrl")
    private final String tcUrl;
    @SerializedName("usable")
    private final Boolean usable;
    @SerializedName("userPocketStatus")
    private final String userPocketStatus;

    public UserPocketAssetEntity() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 134217727, null);
    }

    public /* synthetic */ UserPocketAssetEntity(String str, String str2, String str3, String str4, String str5, String str6, Long l, String str7, String str8, String str9, String str10, String str11, Boolean bool, Boolean bool2, String str12, String str13, Long l2, String str14, ShareableRpcInfoEntity shareableRpcInfoEntity, Map map, String str15, String str16, String str17, String str18, String str19, Map map2, Long l3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) == 0 ? str4 : "", (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : l, (i & 128) != 0 ? null : str7, (i & 256) != 0 ? null : str8, (i & 512) != 0 ? null : str9, (i & 1024) != 0 ? null : str10, (i & 2048) != 0 ? null : str11, (i & 4096) != 0 ? null : bool, (i & 8192) != 0 ? null : bool2, (i & 16384) != 0 ? null : str12, (i & 32768) != 0 ? null : str13, (i & 65536) != 0 ? null : l2, (i & AntDetector.SCENE_ID_LOGIN_REGIST) != 0 ? null : str14, (i & 262144) != 0 ? null : shareableRpcInfoEntity, (i & 524288) != 0 ? null : map, (i & CrashCombineUtils.DEFAULT_MAX_INFO_LEN) != 0 ? null : str15, (i & 2097152) != 0 ? null : str16, (i & 4194304) != 0 ? null : str17, (i & 8388608) != 0 ? null : str18, (i & 16777216) != 0 ? null : str19, (i & 33554432) != 0 ? null : map2, (i & 67108864) != 0 ? null : l3);
    }

    @JvmName(name = "getPocketId")
    public final String getPocketId() {
        return this.pocketId;
    }

    @JvmName(name = "getPocketStatus")
    public final String getPocketStatus() {
        return this.pocketStatus;
    }

    @JvmName(name = "getIconUrl")
    public final String getIconUrl() {
        return this.iconUrl;
    }

    @JvmName(name = "getBackgroundUrl")
    public final String getBackgroundUrl() {
        return this.backgroundUrl;
    }

    @JvmName(name = "getPocketType")
    public final String getPocketType() {
        return this.pocketType;
    }

    @JvmName(name = "getUserPocketStatus")
    public final String getUserPocketStatus() {
        return this.userPocketStatus;
    }

    @JvmName(name = "getActivateDate")
    public final Long getActivateDate() {
        return this.activateDate;
    }

    @JvmName(name = "getHowTo")
    public final String getHowTo() {
        return this.howTo;
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

    @JvmName(name = "getLogoUrl")
    public final String getLogoUrl() {
        return this.logoUrl;
    }

    @JvmName(name = "getUsable")
    public final Boolean getUsable() {
        return this.usable;
    }

    @JvmName(name = "getShareable")
    public final Boolean getShareable() {
        return this.shareable;
    }

    @JvmName(name = "getGoodsId")
    public final String getGoodsId() {
        return this.goodsId;
    }

    @JvmName(name = "getTcUrl")
    public final String getTcUrl() {
        return this.tcUrl;
    }

    @JvmName(name = "getExpirationDate")
    public final Long getExpirationDate() {
        return this.expirationDate;
    }

    @JvmName(name = "getCreatedDate")
    public final String getCreatedDate() {
        return this.createdDate;
    }

    @JvmName(name = "getShareableRpcInfo")
    public final ShareableRpcInfoEntity getShareableRpcInfo() {
        return this.shareableRpcInfo;
    }

    @JvmName(name = "getExtInfo")
    public final Map<String, Object> getExtInfo() {
        return this.extInfo;
    }

    @JvmName(name = "getPrimaryCTA")
    public final String getPrimaryCTA() {
        return this.primaryCTA;
    }

    @JvmName(name = "getBackgroundColor")
    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    @JvmName(name = "getFontColor")
    public final String getFontColor() {
        return this.fontColor;
    }

    @JvmName(name = "getMinTransaction")
    public final String getMinTransaction() {
        return this.minTransaction;
    }

    @JvmName(name = "getCategoryIconUrl")
    public final String getCategoryIconUrl() {
        return this.categoryIconUrl;
    }

    @JvmName(name = "getBizInfo")
    public final Map<String, Object> getBizInfo() {
        return this.bizInfo;
    }

    @JvmName(name = "getCacheTimestamp")
    public final Long getCacheTimestamp() {
        return this.cacheTimestamp;
    }

    @JvmName(name = "setCacheTimestamp")
    public final void setCacheTimestamp(Long l) {
        this.cacheTimestamp = l;
    }

    public UserPocketAssetEntity(@JSONField(name = "pocketId") String str, @JSONField(name = "pocketStatus") String str2, @JSONField(name = "iconUrl") String str3, @JSONField(name = "backgroundUrl") String str4, @JSONField(name = "pocketType") String str5, @JSONField(name = "userPocketStatus") String str6, @JSONField(name = "activateDate") Long l, @JSONField(name = "howTo") String str7, @JSONField(name = "merchantId") String str8, @JSONField(name = "label") String str9, @JSONField(name = "subLabel") String str10, @JSONField(name = "logoUrl") String str11, @JSONField(name = "usable") Boolean bool, @JSONField(name = "shareable") Boolean bool2, @JSONField(name = "goodsId") String str12, @JSONField(name = "tcUrl") String str13, @JSONField(name = "expirationDate") Long l2, @JSONField(name = "createdDate") String str14, @JSONField(name = "shareableRpcInfo") ShareableRpcInfoEntity shareableRpcInfoEntity, @JSONField(name = "extendInfo") Map<String, ? extends Object> map, @JSONField(name = "primaryCTA") String str15, @JSONField(name = "backgroundColor") String str16, @JSONField(name = "fontColor") String str17, @JSONField(name = "minTransaction") String str18, @JSONField(name = "categoryIconUrl") String str19, @JSONField(name = "bizInfo") Map<String, ? extends Object> map2, @JSONField(name = "cacheTimestamp") Long l3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        this.pocketId = str;
        this.pocketStatus = str2;
        this.iconUrl = str3;
        this.backgroundUrl = str4;
        this.pocketType = str5;
        this.userPocketStatus = str6;
        this.activateDate = l;
        this.howTo = str7;
        this.merchantId = str8;
        this.label = str9;
        this.subLabel = str10;
        this.logoUrl = str11;
        this.usable = bool;
        this.shareable = bool2;
        this.goodsId = str12;
        this.tcUrl = str13;
        this.expirationDate = l2;
        this.createdDate = str14;
        this.shareableRpcInfo = shareableRpcInfoEntity;
        this.extInfo = map;
        this.primaryCTA = str15;
        this.backgroundColor = str16;
        this.fontColor = str17;
        this.minTransaction = str18;
        this.categoryIconUrl = str19;
        this.bizInfo = map2;
        this.cacheTimestamp = l3;
    }
}
