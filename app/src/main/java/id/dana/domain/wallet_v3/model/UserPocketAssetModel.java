package id.dana.domain.wallet_v3.model;

import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import com.alipay.iap.android.aplog.util.CrashCombineUtils;
import com.alipay.mobile.security.faceauth.api.AntDetector;
import com.google.firebase.messaging.Constants;
import id.dana.danah5.constant.BridgeName;
import id.dana.domain.pocket.model.AssetCategory;
import id.dana.domain.pocket.model.ShareableRpcInfo;
import id.dana.domain.qrbarcode.DecodedScanBizInfoKey;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.sqlcipher.database.SQLiteDatabase;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u00002\u00020\u0001:\u0007\u001e\u001f !\"#$B9\b\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u001c\u0010\u001dR\"\u0010\u0003\u001a\u00020\u00028\u0017@\u0017X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0017@\u0017X\u0097\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00028\u0017@\u0017X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\"\u0010\u0013\u001a\u00020\u00028\u0017@\u0017X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\"\u0010\u0016\u001a\u00020\u00028\u0017@\u0017X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\"\u0010\u0019\u001a\u00020\u00028\u0017@\u0017X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\b\u0082\u0001\u0007%&'()*+"}, d2 = {"Lid/dana/domain/wallet_v3/model/UserPocketAssetModel;", "", "", "backgroundUrl", "Ljava/lang/String;", "getBackgroundUrl", "()Ljava/lang/String;", "setBackgroundUrl", "(Ljava/lang/String;)V", "", "cacheTimestamp", "J", "getCacheTimestamp", "()J", "setCacheTimestamp", "(J)V", "iconUrl", "getIconUrl", "setIconUrl", "pocketId", "getPocketId", "setPocketId", "pocketStatus", "getPocketStatus", "setPocketStatus", "pocketType", "getPocketType", "setPocketType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "DealsAsset", "UserLoyaltyAsset", "UserMovieTicketAsset", "UserParkingTicketAsset", "UserTravelTicketAsset", "UserVoucherAsset", "UserVoucherCodeAsset", "Lid/dana/domain/wallet_v3/model/UserPocketAssetModel$UserVoucherAsset;", "Lid/dana/domain/wallet_v3/model/UserPocketAssetModel$UserVoucherCodeAsset;", "Lid/dana/domain/wallet_v3/model/UserPocketAssetModel$DealsAsset;", "Lid/dana/domain/wallet_v3/model/UserPocketAssetModel$UserTravelTicketAsset;", "Lid/dana/domain/wallet_v3/model/UserPocketAssetModel$UserParkingTicketAsset;", "Lid/dana/domain/wallet_v3/model/UserPocketAssetModel$UserLoyaltyAsset;", "Lid/dana/domain/wallet_v3/model/UserPocketAssetModel$UserMovieTicketAsset;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class UserPocketAssetModel {
    private String backgroundUrl;
    private long cacheTimestamp;
    private String iconUrl;
    private String pocketId;
    private String pocketStatus;
    private String pocketType;

    public /* synthetic */ UserPocketAssetModel(String str, String str2, String str3, String str4, String str5, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, j);
    }

    private UserPocketAssetModel(String str, String str2, String str3, String str4, String str5, long j) {
        this.pocketId = str;
        this.pocketStatus = str2;
        this.iconUrl = str3;
        this.backgroundUrl = str4;
        this.pocketType = str5;
        this.cacheTimestamp = j;
    }

    @JvmName(name = "getPocketId")
    public String getPocketId() {
        return this.pocketId;
    }

    @JvmName(name = "setPocketId")
    public void setPocketId(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.pocketId = str;
    }

    @JvmName(name = "getPocketStatus")
    public String getPocketStatus() {
        return this.pocketStatus;
    }

    @JvmName(name = "setPocketStatus")
    public void setPocketStatus(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.pocketStatus = str;
    }

    @JvmName(name = "getIconUrl")
    public String getIconUrl() {
        return this.iconUrl;
    }

    @JvmName(name = "setIconUrl")
    public void setIconUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.iconUrl = str;
    }

    @JvmName(name = "getBackgroundUrl")
    public String getBackgroundUrl() {
        return this.backgroundUrl;
    }

    @JvmName(name = "setBackgroundUrl")
    public void setBackgroundUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.backgroundUrl = str;
    }

    @JvmName(name = "getPocketType")
    public String getPocketType() {
        return this.pocketType;
    }

    @JvmName(name = "setPocketType")
    public void setPocketType(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.pocketType = str;
    }

    @JvmName(name = "getCacheTimestamp")
    public long getCacheTimestamp() {
        return this.cacheTimestamp;
    }

    @JvmName(name = "setCacheTimestamp")
    public void setCacheTimestamp(long j) {
        this.cacheTimestamp = j;
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b7\b\u0086\b\u0018\u00002\u00020\u0001BÙ\u0001\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0002\u0012\b\b\u0002\u0010 \u001a\u00020\u0002\u0012\b\b\u0002\u0010!\u001a\u00020\u0002\u0012\b\b\u0002\u0010\"\u001a\u00020\u0002\u0012\b\b\u0002\u0010#\u001a\u00020\u0002\u0012\b\b\u0002\u0010$\u001a\u00020\u0012\u0012\b\b\u0002\u0010%\u001a\u00020\u0012\u0012\b\b\u0002\u0010&\u001a\u00020\u0002\u0012\b\b\u0002\u0010'\u001a\u00020\u0002\u0012\b\b\u0002\u0010(\u001a\u00020\u0002\u0012\b\b\u0002\u0010)\u001a\u00020\u0002\u0012\b\b\u0002\u0010*\u001a\u00020\u0002\u0012\b\b\u0002\u0010+\u001a\u00020\u0002\u0012\b\b\u0002\u0010,\u001a\u00020\u0002\u0012\b\b\u0002\u0010-\u001a\u00020\u0002\u0012\b\b\u0002\u0010.\u001a\u00020\u0002\u0012\b\b\u0002\u0010/\u001a\u00020\u0002\u0012\b\b\u0002\u00100\u001a\u00020\r\u0012\b\b\u0002\u00101\u001a\u00020\r\u0012\b\b\u0002\u00102\u001a\u00020\u0012\u0012\b\u00103\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\bp\u0010qJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0004J\u0010\u0010\u0019\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0004J\u0010\u0010\u001a\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0004J\u0010\u0010\u001b\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0014J\u0010\u0010\u001c\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0014J\u0010\u0010\u001d\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0004J\u0010\u0010\u001e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u0004Jä\u0001\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u001f\u001a\u00020\u00022\b\b\u0002\u0010 \u001a\u00020\u00022\b\b\u0002\u0010!\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020\u00022\b\b\u0002\u0010#\u001a\u00020\u00022\b\b\u0002\u0010$\u001a\u00020\u00122\b\b\u0002\u0010%\u001a\u00020\u00122\b\b\u0002\u0010&\u001a\u00020\u00022\b\b\u0002\u0010'\u001a\u00020\u00022\b\b\u0002\u0010(\u001a\u00020\u00022\b\b\u0002\u0010)\u001a\u00020\u00022\b\b\u0002\u0010*\u001a\u00020\u00022\b\b\u0002\u0010+\u001a\u00020\u00022\b\b\u0002\u0010,\u001a\u00020\u00022\b\b\u0002\u0010-\u001a\u00020\u00022\b\b\u0002\u0010.\u001a\u00020\u00022\b\b\u0002\u0010/\u001a\u00020\u00022\b\b\u0002\u00100\u001a\u00020\r2\b\b\u0002\u00101\u001a\u00020\r2\b\b\u0002\u00102\u001a\u00020\u00122\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0015HÆ\u0001¢\u0006\u0004\b4\u00105J\u001a\u00108\u001a\u00020\r2\b\u00107\u001a\u0004\u0018\u000106HÖ\u0003¢\u0006\u0004\b8\u00109J\u0010\u0010;\u001a\u00020:HÖ\u0001¢\u0006\u0004\b;\u0010<J\u0010\u0010=\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b=\u0010\u0004R\"\u0010%\u001a\u00020\u00128\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010>\u001a\u0004\b?\u0010\u0014\"\u0004\b@\u0010AR\"\u0010&\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010B\u001a\u0004\bC\u0010\u0004\"\u0004\bD\u0010ER\"\u0010\"\u001a\u00020\u00028\u0017@\u0017X\u0097\u000e¢\u0006\u0012\n\u0004\b\"\u0010B\u001a\u0004\bF\u0010\u0004\"\u0004\bG\u0010ER\"\u0010$\u001a\u00020\u00128\u0017@\u0017X\u0097\u000e¢\u0006\u0012\n\u0004\b$\u0010>\u001a\u0004\bH\u0010\u0014\"\u0004\bI\u0010AR\"\u00102\u001a\u00020\u00128\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u0010>\u001a\u0004\bJ\u0010\u0014\"\u0004\bK\u0010AR\"\u0010*\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010B\u001a\u0004\bL\u0010\u0004\"\u0004\bM\u0010ER\"\u0010!\u001a\u00020\u00028\u0017@\u0017X\u0097\u000e¢\u0006\u0012\n\u0004\b!\u0010B\u001a\u0004\bN\u0010\u0004\"\u0004\bO\u0010ER\"\u0010-\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010B\u001a\u0004\bP\u0010\u0004\"\u0004\bQ\u0010ER\"\u0010/\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u0010B\u001a\u0004\bR\u0010\u0004\"\u0004\bS\u0010ER\"\u0010,\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010B\u001a\u0004\bT\u0010\u0004\"\u0004\bU\u0010ER\"\u0010\u001f\u001a\u00020\u00028\u0017@\u0017X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010B\u001a\u0004\bV\u0010\u0004\"\u0004\bW\u0010ER\"\u0010 \u001a\u00020\u00028\u0017@\u0017X\u0097\u000e¢\u0006\u0012\n\u0004\b \u0010B\u001a\u0004\bX\u0010\u0004\"\u0004\bY\u0010ER\"\u0010#\u001a\u00020\u00028\u0017@\u0017X\u0097\u000e¢\u0006\u0012\n\u0004\b#\u0010B\u001a\u0004\bZ\u0010\u0004\"\u0004\b[\u0010ER\"\u00101\u001a\u00020\r8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b1\u0010\\\u001a\u0004\b]\u0010\u000f\"\u0004\b^\u0010_R$\u00103\u001a\u0004\u0018\u00010\u00158\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b3\u0010`\u001a\u0004\ba\u0010\u0017\"\u0004\bb\u0010cR\"\u0010'\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010B\u001a\u0004\bd\u0010\u0004\"\u0004\be\u0010ER\"\u0010.\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010B\u001a\u0004\bf\u0010\u0004\"\u0004\bg\u0010ER\"\u0010(\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010B\u001a\u0004\bh\u0010\u0004\"\u0004\bi\u0010ER\"\u0010)\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010B\u001a\u0004\bj\u0010\u0004\"\u0004\bk\u0010ER\"\u00100\u001a\u00020\r8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u0010\\\u001a\u0004\bl\u0010\u000f\"\u0004\bm\u0010_R\"\u0010+\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010B\u001a\u0004\bn\u0010\u0004\"\u0004\bo\u0010E"}, d2 = {"Lid/dana/domain/wallet_v3/model/UserPocketAssetModel$UserVoucherAsset;", "Lid/dana/domain/wallet_v3/model/UserPocketAssetModel;", "", "component1", "()Ljava/lang/String;", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "", "component18", "()Z", "component19", "component2", "", "component20", "()J", "Lid/dana/domain/pocket/model/ShareableRpcInfo;", "component21", "()Lid/dana/domain/pocket/model/ShareableRpcInfo;", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "pocketId", "pocketStatus", "iconUrl", "backgroundUrl", "pocketType", "cacheTimestamp", "activateDate", "amount", "shortDescription", "templateId", "uniqueId", "howTo", "userPocketStatus", "merchantId", Constants.ScionAnalytics.PARAM_LABEL, "subLabel", DecodedScanBizInfoKey.LOGO_URL, "usable", "shareable", "expirationDate", "shareableRpcInfo", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZJLid/dana/domain/pocket/model/ShareableRpcInfo;)Lid/dana/domain/wallet_v3/model/UserPocketAssetModel$UserVoucherAsset;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "J", "getActivateDate", "setActivateDate", "(J)V", "Ljava/lang/String;", "getAmount", "setAmount", "(Ljava/lang/String;)V", "getBackgroundUrl", "setBackgroundUrl", "getCacheTimestamp", "setCacheTimestamp", "getExpirationDate", "setExpirationDate", "getHowTo", "setHowTo", "getIconUrl", "setIconUrl", "getLabel", "setLabel", "getLogoUrl", "setLogoUrl", "getMerchantId", "setMerchantId", "getPocketId", "setPocketId", "getPocketStatus", "setPocketStatus", "getPocketType", "setPocketType", "Z", "getShareable", "setShareable", "(Z)V", "Lid/dana/domain/pocket/model/ShareableRpcInfo;", "getShareableRpcInfo", "setShareableRpcInfo", "(Lid/dana/domain/pocket/model/ShareableRpcInfo;)V", "getShortDescription", "setShortDescription", "getSubLabel", "setSubLabel", "getTemplateId", "setTemplateId", "getUniqueId", "setUniqueId", "getUsable", "setUsable", "getUserPocketStatus", "setUserPocketStatus", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZJLid/dana/domain/pocket/model/ShareableRpcInfo;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class UserVoucherAsset extends UserPocketAssetModel {
        private long activateDate;
        private String amount;
        private String backgroundUrl;
        private long cacheTimestamp;
        private long expirationDate;
        private String howTo;
        private String iconUrl;
        private String label;
        private String logoUrl;
        private String merchantId;
        private String pocketId;
        private String pocketStatus;
        private String pocketType;
        private boolean shareable;
        private ShareableRpcInfo shareableRpcInfo;
        private String shortDescription;
        private String subLabel;
        private String templateId;
        private String uniqueId;
        private boolean usable;
        private String userPocketStatus;

        public final String component1() {
            return getPocketId();
        }

        /* renamed from: component10  reason: from getter */
        public final String getTemplateId() {
            return this.templateId;
        }

        /* renamed from: component11  reason: from getter */
        public final String getUniqueId() {
            return this.uniqueId;
        }

        /* renamed from: component12  reason: from getter */
        public final String getHowTo() {
            return this.howTo;
        }

        /* renamed from: component13  reason: from getter */
        public final String getUserPocketStatus() {
            return this.userPocketStatus;
        }

        /* renamed from: component14  reason: from getter */
        public final String getMerchantId() {
            return this.merchantId;
        }

        /* renamed from: component15  reason: from getter */
        public final String getLabel() {
            return this.label;
        }

        /* renamed from: component16  reason: from getter */
        public final String getSubLabel() {
            return this.subLabel;
        }

        /* renamed from: component17  reason: from getter */
        public final String getLogoUrl() {
            return this.logoUrl;
        }

        /* renamed from: component18  reason: from getter */
        public final boolean getUsable() {
            return this.usable;
        }

        /* renamed from: component19  reason: from getter */
        public final boolean getShareable() {
            return this.shareable;
        }

        public final String component2() {
            return getPocketStatus();
        }

        /* renamed from: component20  reason: from getter */
        public final long getExpirationDate() {
            return this.expirationDate;
        }

        /* renamed from: component21  reason: from getter */
        public final ShareableRpcInfo getShareableRpcInfo() {
            return this.shareableRpcInfo;
        }

        public final String component3() {
            return getIconUrl();
        }

        public final String component4() {
            return getBackgroundUrl();
        }

        public final String component5() {
            return getPocketType();
        }

        public final long component6() {
            return getCacheTimestamp();
        }

        /* renamed from: component7  reason: from getter */
        public final long getActivateDate() {
            return this.activateDate;
        }

        /* renamed from: component8  reason: from getter */
        public final String getAmount() {
            return this.amount;
        }

        /* renamed from: component9  reason: from getter */
        public final String getShortDescription() {
            return this.shortDescription;
        }

        public final UserVoucherAsset copy(String pocketId, String pocketStatus, String iconUrl, String backgroundUrl, String pocketType, long cacheTimestamp, long activateDate, String amount, String shortDescription, String templateId, String uniqueId, String howTo, String userPocketStatus, String merchantId, String label, String subLabel, String logoUrl, boolean usable, boolean shareable, long expirationDate, ShareableRpcInfo shareableRpcInfo) {
            Intrinsics.checkNotNullParameter(pocketId, "");
            Intrinsics.checkNotNullParameter(pocketStatus, "");
            Intrinsics.checkNotNullParameter(iconUrl, "");
            Intrinsics.checkNotNullParameter(backgroundUrl, "");
            Intrinsics.checkNotNullParameter(pocketType, "");
            Intrinsics.checkNotNullParameter(amount, "");
            Intrinsics.checkNotNullParameter(shortDescription, "");
            Intrinsics.checkNotNullParameter(templateId, "");
            Intrinsics.checkNotNullParameter(uniqueId, "");
            Intrinsics.checkNotNullParameter(howTo, "");
            Intrinsics.checkNotNullParameter(userPocketStatus, "");
            Intrinsics.checkNotNullParameter(merchantId, "");
            Intrinsics.checkNotNullParameter(label, "");
            Intrinsics.checkNotNullParameter(subLabel, "");
            Intrinsics.checkNotNullParameter(logoUrl, "");
            return new UserVoucherAsset(pocketId, pocketStatus, iconUrl, backgroundUrl, pocketType, cacheTimestamp, activateDate, amount, shortDescription, templateId, uniqueId, howTo, userPocketStatus, merchantId, label, subLabel, logoUrl, usable, shareable, expirationDate, shareableRpcInfo);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof UserVoucherAsset) {
                UserVoucherAsset userVoucherAsset = (UserVoucherAsset) other;
                return Intrinsics.areEqual(getPocketId(), userVoucherAsset.getPocketId()) && Intrinsics.areEqual(getPocketStatus(), userVoucherAsset.getPocketStatus()) && Intrinsics.areEqual(getIconUrl(), userVoucherAsset.getIconUrl()) && Intrinsics.areEqual(getBackgroundUrl(), userVoucherAsset.getBackgroundUrl()) && Intrinsics.areEqual(getPocketType(), userVoucherAsset.getPocketType()) && getCacheTimestamp() == userVoucherAsset.getCacheTimestamp() && this.activateDate == userVoucherAsset.activateDate && Intrinsics.areEqual(this.amount, userVoucherAsset.amount) && Intrinsics.areEqual(this.shortDescription, userVoucherAsset.shortDescription) && Intrinsics.areEqual(this.templateId, userVoucherAsset.templateId) && Intrinsics.areEqual(this.uniqueId, userVoucherAsset.uniqueId) && Intrinsics.areEqual(this.howTo, userVoucherAsset.howTo) && Intrinsics.areEqual(this.userPocketStatus, userVoucherAsset.userPocketStatus) && Intrinsics.areEqual(this.merchantId, userVoucherAsset.merchantId) && Intrinsics.areEqual(this.label, userVoucherAsset.label) && Intrinsics.areEqual(this.subLabel, userVoucherAsset.subLabel) && Intrinsics.areEqual(this.logoUrl, userVoucherAsset.logoUrl) && this.usable == userVoucherAsset.usable && this.shareable == userVoucherAsset.shareable && this.expirationDate == userVoucherAsset.expirationDate && Intrinsics.areEqual(this.shareableRpcInfo, userVoucherAsset.shareableRpcInfo);
            }
            return false;
        }

        public final int hashCode() {
            int hashCode = getPocketId().hashCode();
            int hashCode2 = getPocketStatus().hashCode();
            int hashCode3 = getIconUrl().hashCode();
            int hashCode4 = getBackgroundUrl().hashCode();
            int hashCode5 = getPocketType().hashCode();
            int m = Cbor$Arg$$ExternalSyntheticBackport0.m(getCacheTimestamp());
            int m2 = Cbor$Arg$$ExternalSyntheticBackport0.m(this.activateDate);
            int hashCode6 = this.amount.hashCode();
            int hashCode7 = this.shortDescription.hashCode();
            int hashCode8 = this.templateId.hashCode();
            int hashCode9 = this.uniqueId.hashCode();
            int hashCode10 = this.howTo.hashCode();
            int hashCode11 = this.userPocketStatus.hashCode();
            int hashCode12 = this.merchantId.hashCode();
            int hashCode13 = this.label.hashCode();
            int hashCode14 = this.subLabel.hashCode();
            int hashCode15 = this.logoUrl.hashCode();
            boolean z = this.usable;
            int i = z ? 1 : z ? 1 : 0;
            boolean z2 = this.shareable;
            int i2 = z2 ? 1 : z2 ? 1 : 0;
            int m3 = Cbor$Arg$$ExternalSyntheticBackport0.m(this.expirationDate);
            ShareableRpcInfo shareableRpcInfo = this.shareableRpcInfo;
            return (((((((((((((((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + m) * 31) + m2) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + hashCode14) * 31) + hashCode15) * 31) + i) * 31) + i2) * 31) + m3) * 31) + (shareableRpcInfo == null ? 0 : shareableRpcInfo.hashCode());
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("UserVoucherAsset(pocketId=");
            sb.append(getPocketId());
            sb.append(", pocketStatus=");
            sb.append(getPocketStatus());
            sb.append(", iconUrl=");
            sb.append(getIconUrl());
            sb.append(", backgroundUrl=");
            sb.append(getBackgroundUrl());
            sb.append(", pocketType=");
            sb.append(getPocketType());
            sb.append(", cacheTimestamp=");
            sb.append(getCacheTimestamp());
            sb.append(", activateDate=");
            sb.append(this.activateDate);
            sb.append(", amount=");
            sb.append(this.amount);
            sb.append(", shortDescription=");
            sb.append(this.shortDescription);
            sb.append(", templateId=");
            sb.append(this.templateId);
            sb.append(", uniqueId=");
            sb.append(this.uniqueId);
            sb.append(", howTo=");
            sb.append(this.howTo);
            sb.append(", userPocketStatus=");
            sb.append(this.userPocketStatus);
            sb.append(", merchantId=");
            sb.append(this.merchantId);
            sb.append(", label=");
            sb.append(this.label);
            sb.append(", subLabel=");
            sb.append(this.subLabel);
            sb.append(", logoUrl=");
            sb.append(this.logoUrl);
            sb.append(", usable=");
            sb.append(this.usable);
            sb.append(", shareable=");
            sb.append(this.shareable);
            sb.append(", expirationDate=");
            sb.append(this.expirationDate);
            sb.append(", shareableRpcInfo=");
            sb.append(this.shareableRpcInfo);
            sb.append(')');
            return sb.toString();
        }

        public /* synthetic */ UserVoucherAsset(String str, String str2, String str3, String str4, String str5, long j, long j2, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, boolean z, boolean z2, long j3, ShareableRpcInfo shareableRpcInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? -1L : j, (i & 64) != 0 ? -1L : j2, (i & 128) != 0 ? "" : str6, (i & 256) != 0 ? "" : str7, (i & 512) != 0 ? "" : str8, (i & 1024) != 0 ? "" : str9, (i & 2048) != 0 ? "" : str10, (i & 4096) != 0 ? "" : str11, (i & 8192) != 0 ? "" : str12, (i & 16384) != 0 ? "" : str13, (32768 & i) != 0 ? "" : str14, (65536 & i) == 0 ? str15 : "", (131072 & i) != 0 ? false : z, (262144 & i) != 0 ? false : z2, (i & 524288) != 0 ? -1L : j3, shareableRpcInfo);
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "getPocketId")
        public final String getPocketId() {
            return this.pocketId;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "setPocketId")
        public final void setPocketId(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.pocketId = str;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "getPocketStatus")
        public final String getPocketStatus() {
            return this.pocketStatus;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "setPocketStatus")
        public final void setPocketStatus(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.pocketStatus = str;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "getIconUrl")
        public final String getIconUrl() {
            return this.iconUrl;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "setIconUrl")
        public final void setIconUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.iconUrl = str;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "getBackgroundUrl")
        public final String getBackgroundUrl() {
            return this.backgroundUrl;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "setBackgroundUrl")
        public final void setBackgroundUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.backgroundUrl = str;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "getPocketType")
        public final String getPocketType() {
            return this.pocketType;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "setPocketType")
        public final void setPocketType(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.pocketType = str;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "getCacheTimestamp")
        public final long getCacheTimestamp() {
            return this.cacheTimestamp;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "setCacheTimestamp")
        public final void setCacheTimestamp(long j) {
            this.cacheTimestamp = j;
        }

        @JvmName(name = "getActivateDate")
        public final long getActivateDate() {
            return this.activateDate;
        }

        @JvmName(name = "setActivateDate")
        public final void setActivateDate(long j) {
            this.activateDate = j;
        }

        @JvmName(name = "getAmount")
        public final String getAmount() {
            return this.amount;
        }

        @JvmName(name = "setAmount")
        public final void setAmount(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.amount = str;
        }

        @JvmName(name = "getShortDescription")
        public final String getShortDescription() {
            return this.shortDescription;
        }

        @JvmName(name = "setShortDescription")
        public final void setShortDescription(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.shortDescription = str;
        }

        @JvmName(name = "getTemplateId")
        public final String getTemplateId() {
            return this.templateId;
        }

        @JvmName(name = "setTemplateId")
        public final void setTemplateId(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.templateId = str;
        }

        @JvmName(name = "getUniqueId")
        public final String getUniqueId() {
            return this.uniqueId;
        }

        @JvmName(name = "setUniqueId")
        public final void setUniqueId(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.uniqueId = str;
        }

        @JvmName(name = "getHowTo")
        public final String getHowTo() {
            return this.howTo;
        }

        @JvmName(name = "setHowTo")
        public final void setHowTo(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.howTo = str;
        }

        @JvmName(name = "getUserPocketStatus")
        public final String getUserPocketStatus() {
            return this.userPocketStatus;
        }

        @JvmName(name = "setUserPocketStatus")
        public final void setUserPocketStatus(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.userPocketStatus = str;
        }

        @JvmName(name = "getMerchantId")
        public final String getMerchantId() {
            return this.merchantId;
        }

        @JvmName(name = "setMerchantId")
        public final void setMerchantId(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.merchantId = str;
        }

        @JvmName(name = "getLabel")
        public final String getLabel() {
            return this.label;
        }

        @JvmName(name = "setLabel")
        public final void setLabel(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.label = str;
        }

        @JvmName(name = "getSubLabel")
        public final String getSubLabel() {
            return this.subLabel;
        }

        @JvmName(name = "setSubLabel")
        public final void setSubLabel(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.subLabel = str;
        }

        @JvmName(name = "getLogoUrl")
        public final String getLogoUrl() {
            return this.logoUrl;
        }

        @JvmName(name = "setLogoUrl")
        public final void setLogoUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.logoUrl = str;
        }

        @JvmName(name = "getUsable")
        public final boolean getUsable() {
            return this.usable;
        }

        @JvmName(name = "setUsable")
        public final void setUsable(boolean z) {
            this.usable = z;
        }

        @JvmName(name = "getShareable")
        public final boolean getShareable() {
            return this.shareable;
        }

        @JvmName(name = "setShareable")
        public final void setShareable(boolean z) {
            this.shareable = z;
        }

        @JvmName(name = "getExpirationDate")
        public final long getExpirationDate() {
            return this.expirationDate;
        }

        @JvmName(name = "setExpirationDate")
        public final void setExpirationDate(long j) {
            this.expirationDate = j;
        }

        @JvmName(name = "getShareableRpcInfo")
        public final ShareableRpcInfo getShareableRpcInfo() {
            return this.shareableRpcInfo;
        }

        @JvmName(name = "setShareableRpcInfo")
        public final void setShareableRpcInfo(ShareableRpcInfo shareableRpcInfo) {
            this.shareableRpcInfo = shareableRpcInfo;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UserVoucherAsset(String str, String str2, String str3, String str4, String str5, long j, long j2, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, boolean z, boolean z2, long j3, ShareableRpcInfo shareableRpcInfo) {
            super(str, str2, str3, str4, str5, j, null);
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
            Intrinsics.checkNotNullParameter(str14, "");
            Intrinsics.checkNotNullParameter(str15, "");
            this.pocketId = str;
            this.pocketStatus = str2;
            this.iconUrl = str3;
            this.backgroundUrl = str4;
            this.pocketType = str5;
            this.cacheTimestamp = j;
            this.activateDate = j2;
            this.amount = str6;
            this.shortDescription = str7;
            this.templateId = str8;
            this.uniqueId = str9;
            this.howTo = str10;
            this.userPocketStatus = str11;
            this.merchantId = str12;
            this.label = str13;
            this.subLabel = str14;
            this.logoUrl = str15;
            this.usable = z;
            this.shareable = z2;
            this.expirationDate = j3;
            this.shareableRpcInfo = shareableRpcInfo;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b5\b\u0086\b\u0018\u00002\u00020\u0001BÏ\u0001\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0002\u0012\b\b\u0002\u0010 \u001a\u00020\u0002\u0012\b\b\u0002\u0010!\u001a\u00020\u0002\u0012\b\b\u0002\u0010\"\u001a\u00020\u000e\u0012\b\b\u0002\u0010#\u001a\u00020\u0002\u0012\b\b\u0002\u0010$\u001a\u00020\u0002\u0012\b\b\u0002\u0010%\u001a\u00020\u0002\u0012\b\b\u0002\u0010&\u001a\u00020\u0002\u0012\b\b\u0002\u0010'\u001a\u00020\u0002\u0012\b\b\u0002\u0010(\u001a\u00020\u0002\u0012\b\b\u0002\u0010)\u001a\u00020\u0002\u0012\b\b\u0002\u0010*\u001a\u00020\u0002\u0012\b\b\u0002\u0010+\u001a\u00020\u0002\u0012\b\b\u0002\u0010,\u001a\u00020\u0002\u0012\b\b\u0002\u0010-\u001a\u00020\u0002\u0012\b\b\u0002\u0010.\u001a\u00020\u0002\u0012\b\u0010/\u001a\u0004\u0018\u00010\u000e\u0012\b\u00100\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\bl\u0010mJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0004J\u0010\u0010\u0016\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0004J\u0010\u0010\u0017\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0004J\u0010\u0010\u0018\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0004J\u0010\u0010\u001b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0004J\u0010\u0010\u001c\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0004JÜ\u0001\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u001d\u001a\u00020\u00022\b\b\u0002\u0010\u001e\u001a\u00020\u00022\b\b\u0002\u0010\u001f\u001a\u00020\u00022\b\b\u0002\u0010 \u001a\u00020\u00022\b\b\u0002\u0010!\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020\u000e2\b\b\u0002\u0010#\u001a\u00020\u00022\b\b\u0002\u0010$\u001a\u00020\u00022\b\b\u0002\u0010%\u001a\u00020\u00022\b\b\u0002\u0010&\u001a\u00020\u00022\b\b\u0002\u0010'\u001a\u00020\u00022\b\b\u0002\u0010(\u001a\u00020\u00022\b\b\u0002\u0010)\u001a\u00020\u00022\b\b\u0002\u0010*\u001a\u00020\u00022\b\b\u0002\u0010+\u001a\u00020\u00022\b\b\u0002\u0010,\u001a\u00020\u00022\b\b\u0002\u0010-\u001a\u00020\u00022\b\b\u0002\u0010.\u001a\u00020\u00022\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0012HÆ\u0001¢\u0006\u0004\b1\u00102J\u001a\u00106\u001a\u0002052\b\u00104\u001a\u0004\u0018\u000103HÖ\u0003¢\u0006\u0004\b6\u00107J\u0010\u00109\u001a\u000208HÖ\u0001¢\u0006\u0004\b9\u0010:J\u0010\u0010;\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b;\u0010\u0004R\"\u0010 \u001a\u00020\u00028\u0017@\u0017X\u0096\u000e¢\u0006\u0012\n\u0004\b \u0010<\u001a\u0004\b=\u0010\u0004\"\u0004\b>\u0010?R\"\u0010\"\u001a\u00020\u000e8\u0017@\u0017X\u0097\u000e¢\u0006\u0012\n\u0004\b\"\u0010@\u001a\u0004\bA\u0010\u0019\"\u0004\bB\u0010CR\"\u0010*\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010<\u001a\u0004\bD\u0010\u0004\"\u0004\bE\u0010?R$\u0010/\u001a\u0004\u0018\u00010\u000e8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u0010F\u001a\u0004\bG\u0010\u0010\"\u0004\bH\u0010IR\"\u0010(\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010<\u001a\u0004\bJ\u0010\u0004\"\u0004\bK\u0010?R\"\u0010#\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010<\u001a\u0004\bL\u0010\u0004\"\u0004\bM\u0010?R\"\u0010\u001f\u001a\u00020\u00028\u0017@\u0017X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010<\u001a\u0004\bN\u0010\u0004\"\u0004\bO\u0010?R\"\u0010&\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010<\u001a\u0004\bP\u0010\u0004\"\u0004\bQ\u0010?R\"\u0010+\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010<\u001a\u0004\bR\u0010\u0004\"\u0004\bS\u0010?R\"\u0010%\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010<\u001a\u0004\bT\u0010\u0004\"\u0004\bU\u0010?R\"\u0010\u001d\u001a\u00020\u00028\u0017@\u0017X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010<\u001a\u0004\bV\u0010\u0004\"\u0004\bW\u0010?R\"\u0010\u001e\u001a\u00020\u00028\u0017@\u0017X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010<\u001a\u0004\bX\u0010\u0004\"\u0004\bY\u0010?R\"\u0010!\u001a\u00020\u00028\u0017@\u0017X\u0097\u000e¢\u0006\u0012\n\u0004\b!\u0010<\u001a\u0004\bZ\u0010\u0004\"\u0004\b[\u0010?R\"\u0010,\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010<\u001a\u0004\b\\\u0010\u0004\"\u0004\b]\u0010?R\"\u0010.\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010<\u001a\u0004\b^\u0010\u0004\"\u0004\b_\u0010?R$\u00100\u001a\u0004\u0018\u00010\u00128\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u0010`\u001a\u0004\ba\u0010\u0014\"\u0004\bb\u0010cR\"\u0010-\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010<\u001a\u0004\bd\u0010\u0004\"\u0004\be\u0010?R\"\u0010'\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010<\u001a\u0004\bf\u0010\u0004\"\u0004\bg\u0010?R\"\u0010)\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010<\u001a\u0004\bh\u0010\u0004\"\u0004\bi\u0010?R\"\u0010$\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010<\u001a\u0004\bj\u0010\u0004\"\u0004\bk\u0010?"}, d2 = {"Lid/dana/domain/wallet_v3/model/UserPocketAssetModel$UserVoucherCodeAsset;", "Lid/dana/domain/wallet_v3/model/UserPocketAssetModel;", "", "component1", "()Ljava/lang/String;", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "", "component19", "()Ljava/lang/Long;", "component2", "Lid/dana/domain/pocket/model/ShareableRpcInfo;", "component20", "()Lid/dana/domain/pocket/model/ShareableRpcInfo;", "component3", "component4", "component5", "component6", "()J", "component7", "component8", "component9", "pocketId", "pocketStatus", "iconUrl", "backgroundUrl", "pocketType", "cacheTimestamp", "howTo", "userPocketStatus", "merchantId", Constants.ScionAnalytics.PARAM_LABEL, "subLabel", "goodsId", "tcUrl", "couponCode", "longDescription", "providerId", "shortDescription", "serialNumber", "expirationDate", "shareableRpcInfo", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lid/dana/domain/pocket/model/ShareableRpcInfo;)Lid/dana/domain/wallet_v3/model/UserPocketAssetModel$UserVoucherCodeAsset;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getBackgroundUrl", "setBackgroundUrl", "(Ljava/lang/String;)V", "J", "getCacheTimestamp", "setCacheTimestamp", "(J)V", "getCouponCode", "setCouponCode", "Ljava/lang/Long;", "getExpirationDate", "setExpirationDate", "(Ljava/lang/Long;)V", "getGoodsId", "setGoodsId", "getHowTo", "setHowTo", "getIconUrl", "setIconUrl", "getLabel", "setLabel", "getLongDescription", "setLongDescription", "getMerchantId", "setMerchantId", "getPocketId", "setPocketId", "getPocketStatus", "setPocketStatus", "getPocketType", "setPocketType", "getProviderId", "setProviderId", "getSerialNumber", "setSerialNumber", "Lid/dana/domain/pocket/model/ShareableRpcInfo;", "getShareableRpcInfo", "setShareableRpcInfo", "(Lid/dana/domain/pocket/model/ShareableRpcInfo;)V", "getShortDescription", "setShortDescription", "getSubLabel", "setSubLabel", "getTcUrl", "setTcUrl", "getUserPocketStatus", "setUserPocketStatus", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lid/dana/domain/pocket/model/ShareableRpcInfo;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class UserVoucherCodeAsset extends UserPocketAssetModel {
        private String backgroundUrl;
        private long cacheTimestamp;
        private String couponCode;
        private Long expirationDate;
        private String goodsId;
        private String howTo;
        private String iconUrl;
        private String label;
        private String longDescription;
        private String merchantId;
        private String pocketId;
        private String pocketStatus;
        private String pocketType;
        private String providerId;
        private String serialNumber;
        private ShareableRpcInfo shareableRpcInfo;
        private String shortDescription;
        private String subLabel;
        private String tcUrl;
        private String userPocketStatus;

        public final String component1() {
            return getPocketId();
        }

        /* renamed from: component10  reason: from getter */
        public final String getLabel() {
            return this.label;
        }

        /* renamed from: component11  reason: from getter */
        public final String getSubLabel() {
            return this.subLabel;
        }

        /* renamed from: component12  reason: from getter */
        public final String getGoodsId() {
            return this.goodsId;
        }

        /* renamed from: component13  reason: from getter */
        public final String getTcUrl() {
            return this.tcUrl;
        }

        /* renamed from: component14  reason: from getter */
        public final String getCouponCode() {
            return this.couponCode;
        }

        /* renamed from: component15  reason: from getter */
        public final String getLongDescription() {
            return this.longDescription;
        }

        /* renamed from: component16  reason: from getter */
        public final String getProviderId() {
            return this.providerId;
        }

        /* renamed from: component17  reason: from getter */
        public final String getShortDescription() {
            return this.shortDescription;
        }

        /* renamed from: component18  reason: from getter */
        public final String getSerialNumber() {
            return this.serialNumber;
        }

        /* renamed from: component19  reason: from getter */
        public final Long getExpirationDate() {
            return this.expirationDate;
        }

        public final String component2() {
            return getPocketStatus();
        }

        /* renamed from: component20  reason: from getter */
        public final ShareableRpcInfo getShareableRpcInfo() {
            return this.shareableRpcInfo;
        }

        public final String component3() {
            return getIconUrl();
        }

        public final String component4() {
            return getBackgroundUrl();
        }

        public final String component5() {
            return getPocketType();
        }

        public final long component6() {
            return getCacheTimestamp();
        }

        /* renamed from: component7  reason: from getter */
        public final String getHowTo() {
            return this.howTo;
        }

        /* renamed from: component8  reason: from getter */
        public final String getUserPocketStatus() {
            return this.userPocketStatus;
        }

        /* renamed from: component9  reason: from getter */
        public final String getMerchantId() {
            return this.merchantId;
        }

        public final UserVoucherCodeAsset copy(String pocketId, String pocketStatus, String iconUrl, String backgroundUrl, String pocketType, long cacheTimestamp, String howTo, String userPocketStatus, String merchantId, String label, String subLabel, String goodsId, String tcUrl, String couponCode, String longDescription, String providerId, String shortDescription, String serialNumber, Long expirationDate, ShareableRpcInfo shareableRpcInfo) {
            Intrinsics.checkNotNullParameter(pocketId, "");
            Intrinsics.checkNotNullParameter(pocketStatus, "");
            Intrinsics.checkNotNullParameter(iconUrl, "");
            Intrinsics.checkNotNullParameter(backgroundUrl, "");
            Intrinsics.checkNotNullParameter(pocketType, "");
            Intrinsics.checkNotNullParameter(howTo, "");
            Intrinsics.checkNotNullParameter(userPocketStatus, "");
            Intrinsics.checkNotNullParameter(merchantId, "");
            Intrinsics.checkNotNullParameter(label, "");
            Intrinsics.checkNotNullParameter(subLabel, "");
            Intrinsics.checkNotNullParameter(goodsId, "");
            Intrinsics.checkNotNullParameter(tcUrl, "");
            Intrinsics.checkNotNullParameter(couponCode, "");
            Intrinsics.checkNotNullParameter(longDescription, "");
            Intrinsics.checkNotNullParameter(providerId, "");
            Intrinsics.checkNotNullParameter(shortDescription, "");
            Intrinsics.checkNotNullParameter(serialNumber, "");
            return new UserVoucherCodeAsset(pocketId, pocketStatus, iconUrl, backgroundUrl, pocketType, cacheTimestamp, howTo, userPocketStatus, merchantId, label, subLabel, goodsId, tcUrl, couponCode, longDescription, providerId, shortDescription, serialNumber, expirationDate, shareableRpcInfo);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof UserVoucherCodeAsset) {
                UserVoucherCodeAsset userVoucherCodeAsset = (UserVoucherCodeAsset) other;
                return Intrinsics.areEqual(getPocketId(), userVoucherCodeAsset.getPocketId()) && Intrinsics.areEqual(getPocketStatus(), userVoucherCodeAsset.getPocketStatus()) && Intrinsics.areEqual(getIconUrl(), userVoucherCodeAsset.getIconUrl()) && Intrinsics.areEqual(getBackgroundUrl(), userVoucherCodeAsset.getBackgroundUrl()) && Intrinsics.areEqual(getPocketType(), userVoucherCodeAsset.getPocketType()) && getCacheTimestamp() == userVoucherCodeAsset.getCacheTimestamp() && Intrinsics.areEqual(this.howTo, userVoucherCodeAsset.howTo) && Intrinsics.areEqual(this.userPocketStatus, userVoucherCodeAsset.userPocketStatus) && Intrinsics.areEqual(this.merchantId, userVoucherCodeAsset.merchantId) && Intrinsics.areEqual(this.label, userVoucherCodeAsset.label) && Intrinsics.areEqual(this.subLabel, userVoucherCodeAsset.subLabel) && Intrinsics.areEqual(this.goodsId, userVoucherCodeAsset.goodsId) && Intrinsics.areEqual(this.tcUrl, userVoucherCodeAsset.tcUrl) && Intrinsics.areEqual(this.couponCode, userVoucherCodeAsset.couponCode) && Intrinsics.areEqual(this.longDescription, userVoucherCodeAsset.longDescription) && Intrinsics.areEqual(this.providerId, userVoucherCodeAsset.providerId) && Intrinsics.areEqual(this.shortDescription, userVoucherCodeAsset.shortDescription) && Intrinsics.areEqual(this.serialNumber, userVoucherCodeAsset.serialNumber) && Intrinsics.areEqual(this.expirationDate, userVoucherCodeAsset.expirationDate) && Intrinsics.areEqual(this.shareableRpcInfo, userVoucherCodeAsset.shareableRpcInfo);
            }
            return false;
        }

        public final int hashCode() {
            int hashCode = getPocketId().hashCode();
            int hashCode2 = getPocketStatus().hashCode();
            int hashCode3 = getIconUrl().hashCode();
            int hashCode4 = getBackgroundUrl().hashCode();
            int hashCode5 = getPocketType().hashCode();
            int m = Cbor$Arg$$ExternalSyntheticBackport0.m(getCacheTimestamp());
            int hashCode6 = this.howTo.hashCode();
            int hashCode7 = this.userPocketStatus.hashCode();
            int hashCode8 = this.merchantId.hashCode();
            int hashCode9 = this.label.hashCode();
            int hashCode10 = this.subLabel.hashCode();
            int hashCode11 = this.goodsId.hashCode();
            int hashCode12 = this.tcUrl.hashCode();
            int hashCode13 = this.couponCode.hashCode();
            int hashCode14 = this.longDescription.hashCode();
            int hashCode15 = this.providerId.hashCode();
            int hashCode16 = this.shortDescription.hashCode();
            int hashCode17 = this.serialNumber.hashCode();
            Long l = this.expirationDate;
            int hashCode18 = l == null ? 0 : l.hashCode();
            ShareableRpcInfo shareableRpcInfo = this.shareableRpcInfo;
            return (((((((((((((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + m) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + hashCode14) * 31) + hashCode15) * 31) + hashCode16) * 31) + hashCode17) * 31) + hashCode18) * 31) + (shareableRpcInfo != null ? shareableRpcInfo.hashCode() : 0);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("UserVoucherCodeAsset(pocketId=");
            sb.append(getPocketId());
            sb.append(", pocketStatus=");
            sb.append(getPocketStatus());
            sb.append(", iconUrl=");
            sb.append(getIconUrl());
            sb.append(", backgroundUrl=");
            sb.append(getBackgroundUrl());
            sb.append(", pocketType=");
            sb.append(getPocketType());
            sb.append(", cacheTimestamp=");
            sb.append(getCacheTimestamp());
            sb.append(", howTo=");
            sb.append(this.howTo);
            sb.append(", userPocketStatus=");
            sb.append(this.userPocketStatus);
            sb.append(", merchantId=");
            sb.append(this.merchantId);
            sb.append(", label=");
            sb.append(this.label);
            sb.append(", subLabel=");
            sb.append(this.subLabel);
            sb.append(", goodsId=");
            sb.append(this.goodsId);
            sb.append(", tcUrl=");
            sb.append(this.tcUrl);
            sb.append(", couponCode=");
            sb.append(this.couponCode);
            sb.append(", longDescription=");
            sb.append(this.longDescription);
            sb.append(", providerId=");
            sb.append(this.providerId);
            sb.append(", shortDescription=");
            sb.append(this.shortDescription);
            sb.append(", serialNumber=");
            sb.append(this.serialNumber);
            sb.append(", expirationDate=");
            sb.append(this.expirationDate);
            sb.append(", shareableRpcInfo=");
            sb.append(this.shareableRpcInfo);
            sb.append(')');
            return sb.toString();
        }

        public /* synthetic */ UserVoucherCodeAsset(String str, String str2, String str3, String str4, String str5, long j, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, Long l, ShareableRpcInfo shareableRpcInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? -1L : j, (i & 64) != 0 ? "" : str6, (i & 128) != 0 ? "" : str7, (i & 256) != 0 ? "" : str8, (i & 512) != 0 ? "" : str9, (i & 1024) != 0 ? "" : str10, (i & 2048) != 0 ? "" : str11, (i & 4096) != 0 ? "" : str12, (i & 8192) != 0 ? "" : str13, (i & 16384) != 0 ? "" : str14, (32768 & i) != 0 ? "" : str15, (65536 & i) != 0 ? "" : str16, (i & AntDetector.SCENE_ID_LOGIN_REGIST) != 0 ? "" : str17, l, shareableRpcInfo);
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "getPocketId")
        public final String getPocketId() {
            return this.pocketId;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "setPocketId")
        public final void setPocketId(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.pocketId = str;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "getPocketStatus")
        public final String getPocketStatus() {
            return this.pocketStatus;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "setPocketStatus")
        public final void setPocketStatus(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.pocketStatus = str;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "getIconUrl")
        public final String getIconUrl() {
            return this.iconUrl;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "setIconUrl")
        public final void setIconUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.iconUrl = str;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "getBackgroundUrl")
        public final String getBackgroundUrl() {
            return this.backgroundUrl;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "setBackgroundUrl")
        public final void setBackgroundUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.backgroundUrl = str;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "getPocketType")
        public final String getPocketType() {
            return this.pocketType;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "setPocketType")
        public final void setPocketType(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.pocketType = str;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "getCacheTimestamp")
        public final long getCacheTimestamp() {
            return this.cacheTimestamp;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "setCacheTimestamp")
        public final void setCacheTimestamp(long j) {
            this.cacheTimestamp = j;
        }

        @JvmName(name = "getHowTo")
        public final String getHowTo() {
            return this.howTo;
        }

        @JvmName(name = "setHowTo")
        public final void setHowTo(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.howTo = str;
        }

        @JvmName(name = "getUserPocketStatus")
        public final String getUserPocketStatus() {
            return this.userPocketStatus;
        }

        @JvmName(name = "setUserPocketStatus")
        public final void setUserPocketStatus(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.userPocketStatus = str;
        }

        @JvmName(name = "getMerchantId")
        public final String getMerchantId() {
            return this.merchantId;
        }

        @JvmName(name = "setMerchantId")
        public final void setMerchantId(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.merchantId = str;
        }

        @JvmName(name = "getLabel")
        public final String getLabel() {
            return this.label;
        }

        @JvmName(name = "setLabel")
        public final void setLabel(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.label = str;
        }

        @JvmName(name = "getSubLabel")
        public final String getSubLabel() {
            return this.subLabel;
        }

        @JvmName(name = "setSubLabel")
        public final void setSubLabel(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.subLabel = str;
        }

        @JvmName(name = "getGoodsId")
        public final String getGoodsId() {
            return this.goodsId;
        }

        @JvmName(name = "setGoodsId")
        public final void setGoodsId(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.goodsId = str;
        }

        @JvmName(name = "getTcUrl")
        public final String getTcUrl() {
            return this.tcUrl;
        }

        @JvmName(name = "setTcUrl")
        public final void setTcUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.tcUrl = str;
        }

        @JvmName(name = "getCouponCode")
        public final String getCouponCode() {
            return this.couponCode;
        }

        @JvmName(name = "setCouponCode")
        public final void setCouponCode(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.couponCode = str;
        }

        @JvmName(name = "getLongDescription")
        public final String getLongDescription() {
            return this.longDescription;
        }

        @JvmName(name = "setLongDescription")
        public final void setLongDescription(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.longDescription = str;
        }

        @JvmName(name = "getProviderId")
        public final String getProviderId() {
            return this.providerId;
        }

        @JvmName(name = "setProviderId")
        public final void setProviderId(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.providerId = str;
        }

        @JvmName(name = "getShortDescription")
        public final String getShortDescription() {
            return this.shortDescription;
        }

        @JvmName(name = "setShortDescription")
        public final void setShortDescription(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.shortDescription = str;
        }

        @JvmName(name = "getSerialNumber")
        public final String getSerialNumber() {
            return this.serialNumber;
        }

        @JvmName(name = "setSerialNumber")
        public final void setSerialNumber(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.serialNumber = str;
        }

        @JvmName(name = "getExpirationDate")
        public final Long getExpirationDate() {
            return this.expirationDate;
        }

        @JvmName(name = "setExpirationDate")
        public final void setExpirationDate(Long l) {
            this.expirationDate = l;
        }

        @JvmName(name = "getShareableRpcInfo")
        public final ShareableRpcInfo getShareableRpcInfo() {
            return this.shareableRpcInfo;
        }

        @JvmName(name = "setShareableRpcInfo")
        public final void setShareableRpcInfo(ShareableRpcInfo shareableRpcInfo) {
            this.shareableRpcInfo = shareableRpcInfo;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UserVoucherCodeAsset(String str, String str2, String str3, String str4, String str5, long j, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, Long l, ShareableRpcInfo shareableRpcInfo) {
            super(str, str2, str3, str4, str5, j, null);
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
            Intrinsics.checkNotNullParameter(str14, "");
            Intrinsics.checkNotNullParameter(str15, "");
            Intrinsics.checkNotNullParameter(str16, "");
            Intrinsics.checkNotNullParameter(str17, "");
            this.pocketId = str;
            this.pocketStatus = str2;
            this.iconUrl = str3;
            this.backgroundUrl = str4;
            this.pocketType = str5;
            this.cacheTimestamp = j;
            this.howTo = str6;
            this.userPocketStatus = str7;
            this.merchantId = str8;
            this.label = str9;
            this.subLabel = str10;
            this.goodsId = str11;
            this.tcUrl = str12;
            this.couponCode = str13;
            this.longDescription = str14;
            this.providerId = str15;
            this.shortDescription = str16;
            this.serialNumber = str17;
            this.expirationDate = l;
            this.shareableRpcInfo = shareableRpcInfo;
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\bH\b\u0086\b\u0018\u00002\u00020\u0001Bµ\u0002\u0012\b\b\u0002\u0010(\u001a\u00020\u0002\u0012\b\b\u0002\u0010)\u001a\u00020\u0002\u0012\b\b\u0002\u0010*\u001a\u00020\u0002\u0012\b\b\u0002\u0010+\u001a\u00020\u0002\u0012\b\b\u0002\u0010,\u001a\u00020\u0002\u0012\b\b\u0002\u0010-\u001a\u00020\u0012\u0012\b\b\u0002\u0010.\u001a\u00020\u0012\u0012\b\b\u0002\u0010/\u001a\u00020\u0002\u0012\b\b\u0002\u00100\u001a\u00020\u0002\u0012\b\b\u0002\u00101\u001a\u00020\u0002\u0012\b\b\u0002\u00102\u001a\u00020\u0002\u0012\b\b\u0002\u00103\u001a\u00020\u0002\u0012\b\b\u0002\u00104\u001a\u00020\u0002\u0012\b\b\u0002\u00105\u001a\u00020\u0002\u0012\b\b\u0002\u00106\u001a\u00020\u0002\u0012\b\b\u0002\u00107\u001a\u00020\u0002\u0012\b\b\u0002\u00108\u001a\u00020\u0002\u0012\b\b\u0002\u00109\u001a\u00020\r\u0012\b\b\u0002\u0010:\u001a\u00020\r\u0012\b\b\u0002\u0010;\u001a\u00020\u0012\u0012\b\b\u0002\u0010<\u001a\u00020\u0002\u0012\b\b\u0002\u0010=\u001a\u00020\u0002\u0012\b\b\u0002\u0010>\u001a\u00020\u0002\u0012\b\b\u0002\u0010?\u001a\u00020\u0002\u0012\b\b\u0002\u0010@\u001a\u00020\u0002\u0012\b\b\u0002\u0010A\u001a\u00020\r\u0012\b\b\u0002\u0010B\u001a\u00020\u0002\u0012\b\b\u0002\u0010C\u001a\u00020\u0002\u0012\b\b\u0002\u0010D\u001a\u00020\u0002\u0012\b\u0010E\u001a\u0004\u0018\u00010\u001f¢\u0006\u0006\b\u0093\u0001\u0010\u0094\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0004J\u0010\u0010\u0016\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0004J\u0010\u0010\u0017\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0004J\u0010\u0010\u0018\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0004J\u0010\u0010\u0019\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0004J\u0010\u0010\u001a\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u001a\u0010\u000fJ\u0010\u0010\u001b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0004J\u0010\u0010\u001c\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0004J\u0010\u0010\u001d\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0004J\u0010\u0010\u001e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u0004J\u0012\u0010 \u001a\u0004\u0018\u00010\u001fHÆ\u0003¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\"\u0010\u0004J\u0010\u0010#\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b#\u0010\u0004J\u0010\u0010$\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b$\u0010\u0014J\u0010\u0010%\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b%\u0010\u0014J\u0010\u0010&\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b&\u0010\u0004J\u0010\u0010'\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b'\u0010\u0004J¾\u0002\u0010F\u001a\u00020\u00002\b\b\u0002\u0010(\u001a\u00020\u00022\b\b\u0002\u0010)\u001a\u00020\u00022\b\b\u0002\u0010*\u001a\u00020\u00022\b\b\u0002\u0010+\u001a\u00020\u00022\b\b\u0002\u0010,\u001a\u00020\u00022\b\b\u0002\u0010-\u001a\u00020\u00122\b\b\u0002\u0010.\u001a\u00020\u00122\b\b\u0002\u0010/\u001a\u00020\u00022\b\b\u0002\u00100\u001a\u00020\u00022\b\b\u0002\u00101\u001a\u00020\u00022\b\b\u0002\u00102\u001a\u00020\u00022\b\b\u0002\u00103\u001a\u00020\u00022\b\b\u0002\u00104\u001a\u00020\u00022\b\b\u0002\u00105\u001a\u00020\u00022\b\b\u0002\u00106\u001a\u00020\u00022\b\b\u0002\u00107\u001a\u00020\u00022\b\b\u0002\u00108\u001a\u00020\u00022\b\b\u0002\u00109\u001a\u00020\r2\b\b\u0002\u0010:\u001a\u00020\r2\b\b\u0002\u0010;\u001a\u00020\u00122\b\b\u0002\u0010<\u001a\u00020\u00022\b\b\u0002\u0010=\u001a\u00020\u00022\b\b\u0002\u0010>\u001a\u00020\u00022\b\b\u0002\u0010?\u001a\u00020\u00022\b\b\u0002\u0010@\u001a\u00020\u00022\b\b\u0002\u0010A\u001a\u00020\r2\b\b\u0002\u0010B\u001a\u00020\u00022\b\b\u0002\u0010C\u001a\u00020\u00022\b\b\u0002\u0010D\u001a\u00020\u00022\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u001fHÆ\u0001¢\u0006\u0004\bF\u0010GJ\u001a\u0010J\u001a\u00020\r2\b\u0010I\u001a\u0004\u0018\u00010HHÖ\u0003¢\u0006\u0004\bJ\u0010KJ\u0010\u0010M\u001a\u00020LHÖ\u0001¢\u0006\u0004\bM\u0010NJ\u0010\u0010O\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\bO\u0010\u0004R\"\u0010.\u001a\u00020\u00128\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010P\u001a\u0004\bQ\u0010\u0014\"\u0004\bR\u0010SR\"\u0010/\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u0010T\u001a\u0004\bU\u0010\u0004\"\u0004\bV\u0010WR\"\u0010<\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b<\u0010T\u001a\u0004\bX\u0010\u0004\"\u0004\bY\u0010WR\"\u0010+\u001a\u00020\u00028\u0017@\u0017X\u0097\u000e¢\u0006\u0012\n\u0004\b+\u0010T\u001a\u0004\bZ\u0010\u0004\"\u0004\b[\u0010WR\"\u0010@\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b@\u0010T\u001a\u0004\b\\\u0010\u0004\"\u0004\b]\u0010WR\"\u0010-\u001a\u00020\u00128\u0017@\u0017X\u0097\u000e¢\u0006\u0012\n\u0004\b-\u0010P\u001a\u0004\b^\u0010\u0014\"\u0004\b_\u0010SR\"\u0010?\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b?\u0010T\u001a\u0004\b`\u0010\u0004\"\u0004\ba\u0010WR\"\u0010D\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bD\u0010T\u001a\u0004\bb\u0010\u0004\"\u0004\bc\u0010WR\"\u0010;\u001a\u00020\u00128\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b;\u0010P\u001a\u0004\bd\u0010\u0014\"\u0004\be\u0010SR\"\u0010=\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b=\u0010T\u001a\u0004\bf\u0010\u0004\"\u0004\bg\u0010WR\"\u00103\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b3\u0010T\u001a\u0004\bh\u0010\u0004\"\u0004\bi\u0010WR\"\u0010*\u001a\u00020\u00028\u0017@\u0017X\u0097\u000e¢\u0006\u0012\n\u0004\b*\u0010T\u001a\u0004\bj\u0010\u0004\"\u0004\bk\u0010WR\"\u0010A\u001a\u00020\r8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bA\u0010l\u001a\u0004\bA\u0010\u000f\"\u0004\bm\u0010nR\"\u00106\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b6\u0010T\u001a\u0004\bo\u0010\u0004\"\u0004\bp\u0010WR\"\u00108\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b8\u0010T\u001a\u0004\bq\u0010\u0004\"\u0004\br\u0010WR\"\u00105\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b5\u0010T\u001a\u0004\bs\u0010\u0004\"\u0004\bt\u0010WR\"\u0010>\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b>\u0010T\u001a\u0004\bu\u0010\u0004\"\u0004\bv\u0010WR\"\u0010(\u001a\u00020\u00028\u0017@\u0017X\u0097\u000e¢\u0006\u0012\n\u0004\b(\u0010T\u001a\u0004\bw\u0010\u0004\"\u0004\bx\u0010WR\"\u0010)\u001a\u00020\u00028\u0017@\u0017X\u0097\u000e¢\u0006\u0012\n\u0004\b)\u0010T\u001a\u0004\by\u0010\u0004\"\u0004\bz\u0010WR\"\u0010,\u001a\u00020\u00028\u0017@\u0017X\u0097\u000e¢\u0006\u0012\n\u0004\b,\u0010T\u001a\u0004\b{\u0010\u0004\"\u0004\b|\u0010WR\"\u0010C\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bC\u0010T\u001a\u0004\b}\u0010\u0004\"\u0004\b~\u0010WR#\u0010B\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0013\n\u0004\bB\u0010T\u001a\u0004\b\u007f\u0010\u0004\"\u0005\b\u0080\u0001\u0010WR$\u0010:\u001a\u00020\r8\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\b:\u0010l\u001a\u0005\b\u0081\u0001\u0010\u000f\"\u0005\b\u0082\u0001\u0010nR(\u0010E\u001a\u0004\u0018\u00010\u001f8\u0007@\u0007X\u0087\u000e¢\u0006\u0016\n\u0005\bE\u0010\u0083\u0001\u001a\u0005\b\u0084\u0001\u0010!\"\u0006\b\u0085\u0001\u0010\u0086\u0001R$\u00100\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\b0\u0010T\u001a\u0005\b\u0087\u0001\u0010\u0004\"\u0005\b\u0088\u0001\u0010WR$\u00107\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\b7\u0010T\u001a\u0005\b\u0089\u0001\u0010\u0004\"\u0005\b\u008a\u0001\u0010WR$\u00101\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\b1\u0010T\u001a\u0005\b\u008b\u0001\u0010\u0004\"\u0005\b\u008c\u0001\u0010WR$\u00102\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\b2\u0010T\u001a\u0005\b\u008d\u0001\u0010\u0004\"\u0005\b\u008e\u0001\u0010WR$\u00109\u001a\u00020\r8\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\b9\u0010l\u001a\u0005\b\u008f\u0001\u0010\u000f\"\u0005\b\u0090\u0001\u0010nR$\u00104\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\b4\u0010T\u001a\u0005\b\u0091\u0001\u0010\u0004\"\u0005\b\u0092\u0001\u0010W"}, d2 = {"Lid/dana/domain/wallet_v3/model/UserPocketAssetModel$DealsAsset;", "Lid/dana/domain/wallet_v3/model/UserPocketAssetModel;", "", "component1", "()Ljava/lang/String;", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "", "component18", "()Z", "component19", "component2", "", "component20", "()J", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "Lid/dana/domain/pocket/model/ShareableRpcInfo;", "component30", "()Lid/dana/domain/pocket/model/ShareableRpcInfo;", "component4", "component5", "component6", "component7", "component8", "component9", "pocketId", "pocketStatus", "iconUrl", "backgroundUrl", "pocketType", "cacheTimestamp", "activateDate", "amount", "shortDescription", "templateId", "uniqueId", "howTo", "userPocketStatus", "merchantId", Constants.ScionAnalytics.PARAM_LABEL, "subLabel", DecodedScanBizInfoKey.LOGO_URL, "usable", "shareable", "expirationDate", "backgroundColor", "fontColor", "minTransaction", "categoryIconUrl", "bizType", "isOnlineMerchant", "redemptionType", "providerCategory", "discountRate", "shareableRpcInfo", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/pocket/model/ShareableRpcInfo;)Lid/dana/domain/wallet_v3/model/UserPocketAssetModel$DealsAsset;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "J", "getActivateDate", "setActivateDate", "(J)V", "Ljava/lang/String;", "getAmount", "setAmount", "(Ljava/lang/String;)V", "getBackgroundColor", "setBackgroundColor", "getBackgroundUrl", "setBackgroundUrl", "getBizType", "setBizType", "getCacheTimestamp", "setCacheTimestamp", "getCategoryIconUrl", "setCategoryIconUrl", "getDiscountRate", "setDiscountRate", "getExpirationDate", "setExpirationDate", "getFontColor", "setFontColor", "getHowTo", "setHowTo", "getIconUrl", "setIconUrl", "Z", "setOnlineMerchant", "(Z)V", "getLabel", "setLabel", "getLogoUrl", "setLogoUrl", "getMerchantId", "setMerchantId", "getMinTransaction", "setMinTransaction", "getPocketId", "setPocketId", "getPocketStatus", "setPocketStatus", "getPocketType", "setPocketType", "getProviderCategory", "setProviderCategory", "getRedemptionType", "setRedemptionType", "getShareable", "setShareable", "Lid/dana/domain/pocket/model/ShareableRpcInfo;", "getShareableRpcInfo", "setShareableRpcInfo", "(Lid/dana/domain/pocket/model/ShareableRpcInfo;)V", "getShortDescription", "setShortDescription", "getSubLabel", "setSubLabel", "getTemplateId", "setTemplateId", "getUniqueId", "setUniqueId", "getUsable", "setUsable", "getUserPocketStatus", "setUserPocketStatus", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/pocket/model/ShareableRpcInfo;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class DealsAsset extends UserPocketAssetModel {
        private long activateDate;
        private String amount;
        private String backgroundColor;
        private String backgroundUrl;
        private String bizType;
        private long cacheTimestamp;
        private String categoryIconUrl;
        private String discountRate;
        private long expirationDate;
        private String fontColor;
        private String howTo;
        private String iconUrl;
        private boolean isOnlineMerchant;
        private String label;
        private String logoUrl;
        private String merchantId;
        private String minTransaction;
        private String pocketId;
        private String pocketStatus;
        private String pocketType;
        private String providerCategory;
        private String redemptionType;
        private boolean shareable;
        private ShareableRpcInfo shareableRpcInfo;
        private String shortDescription;
        private String subLabel;
        private String templateId;
        private String uniqueId;
        private boolean usable;
        private String userPocketStatus;

        public final String component1() {
            return getPocketId();
        }

        /* renamed from: component10  reason: from getter */
        public final String getTemplateId() {
            return this.templateId;
        }

        /* renamed from: component11  reason: from getter */
        public final String getUniqueId() {
            return this.uniqueId;
        }

        /* renamed from: component12  reason: from getter */
        public final String getHowTo() {
            return this.howTo;
        }

        /* renamed from: component13  reason: from getter */
        public final String getUserPocketStatus() {
            return this.userPocketStatus;
        }

        /* renamed from: component14  reason: from getter */
        public final String getMerchantId() {
            return this.merchantId;
        }

        /* renamed from: component15  reason: from getter */
        public final String getLabel() {
            return this.label;
        }

        /* renamed from: component16  reason: from getter */
        public final String getSubLabel() {
            return this.subLabel;
        }

        /* renamed from: component17  reason: from getter */
        public final String getLogoUrl() {
            return this.logoUrl;
        }

        /* renamed from: component18  reason: from getter */
        public final boolean getUsable() {
            return this.usable;
        }

        /* renamed from: component19  reason: from getter */
        public final boolean getShareable() {
            return this.shareable;
        }

        public final String component2() {
            return getPocketStatus();
        }

        /* renamed from: component20  reason: from getter */
        public final long getExpirationDate() {
            return this.expirationDate;
        }

        /* renamed from: component21  reason: from getter */
        public final String getBackgroundColor() {
            return this.backgroundColor;
        }

        /* renamed from: component22  reason: from getter */
        public final String getFontColor() {
            return this.fontColor;
        }

        /* renamed from: component23  reason: from getter */
        public final String getMinTransaction() {
            return this.minTransaction;
        }

        /* renamed from: component24  reason: from getter */
        public final String getCategoryIconUrl() {
            return this.categoryIconUrl;
        }

        /* renamed from: component25  reason: from getter */
        public final String getBizType() {
            return this.bizType;
        }

        /* renamed from: component26  reason: from getter */
        public final boolean getIsOnlineMerchant() {
            return this.isOnlineMerchant;
        }

        /* renamed from: component27  reason: from getter */
        public final String getRedemptionType() {
            return this.redemptionType;
        }

        /* renamed from: component28  reason: from getter */
        public final String getProviderCategory() {
            return this.providerCategory;
        }

        /* renamed from: component29  reason: from getter */
        public final String getDiscountRate() {
            return this.discountRate;
        }

        public final String component3() {
            return getIconUrl();
        }

        /* renamed from: component30  reason: from getter */
        public final ShareableRpcInfo getShareableRpcInfo() {
            return this.shareableRpcInfo;
        }

        public final String component4() {
            return getBackgroundUrl();
        }

        public final String component5() {
            return getPocketType();
        }

        public final long component6() {
            return getCacheTimestamp();
        }

        /* renamed from: component7  reason: from getter */
        public final long getActivateDate() {
            return this.activateDate;
        }

        /* renamed from: component8  reason: from getter */
        public final String getAmount() {
            return this.amount;
        }

        /* renamed from: component9  reason: from getter */
        public final String getShortDescription() {
            return this.shortDescription;
        }

        public final DealsAsset copy(String pocketId, String pocketStatus, String iconUrl, String backgroundUrl, String pocketType, long cacheTimestamp, long activateDate, String amount, String shortDescription, String templateId, String uniqueId, String howTo, String userPocketStatus, String merchantId, String label, String subLabel, String logoUrl, boolean usable, boolean shareable, long expirationDate, String backgroundColor, String fontColor, String minTransaction, String categoryIconUrl, String bizType, boolean isOnlineMerchant, String redemptionType, String providerCategory, String discountRate, ShareableRpcInfo shareableRpcInfo) {
            Intrinsics.checkNotNullParameter(pocketId, "");
            Intrinsics.checkNotNullParameter(pocketStatus, "");
            Intrinsics.checkNotNullParameter(iconUrl, "");
            Intrinsics.checkNotNullParameter(backgroundUrl, "");
            Intrinsics.checkNotNullParameter(pocketType, "");
            Intrinsics.checkNotNullParameter(amount, "");
            Intrinsics.checkNotNullParameter(shortDescription, "");
            Intrinsics.checkNotNullParameter(templateId, "");
            Intrinsics.checkNotNullParameter(uniqueId, "");
            Intrinsics.checkNotNullParameter(howTo, "");
            Intrinsics.checkNotNullParameter(userPocketStatus, "");
            Intrinsics.checkNotNullParameter(merchantId, "");
            Intrinsics.checkNotNullParameter(label, "");
            Intrinsics.checkNotNullParameter(subLabel, "");
            Intrinsics.checkNotNullParameter(logoUrl, "");
            Intrinsics.checkNotNullParameter(backgroundColor, "");
            Intrinsics.checkNotNullParameter(fontColor, "");
            Intrinsics.checkNotNullParameter(minTransaction, "");
            Intrinsics.checkNotNullParameter(categoryIconUrl, "");
            Intrinsics.checkNotNullParameter(bizType, "");
            Intrinsics.checkNotNullParameter(redemptionType, "");
            Intrinsics.checkNotNullParameter(providerCategory, "");
            Intrinsics.checkNotNullParameter(discountRate, "");
            return new DealsAsset(pocketId, pocketStatus, iconUrl, backgroundUrl, pocketType, cacheTimestamp, activateDate, amount, shortDescription, templateId, uniqueId, howTo, userPocketStatus, merchantId, label, subLabel, logoUrl, usable, shareable, expirationDate, backgroundColor, fontColor, minTransaction, categoryIconUrl, bizType, isOnlineMerchant, redemptionType, providerCategory, discountRate, shareableRpcInfo);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof DealsAsset) {
                DealsAsset dealsAsset = (DealsAsset) other;
                return Intrinsics.areEqual(getPocketId(), dealsAsset.getPocketId()) && Intrinsics.areEqual(getPocketStatus(), dealsAsset.getPocketStatus()) && Intrinsics.areEqual(getIconUrl(), dealsAsset.getIconUrl()) && Intrinsics.areEqual(getBackgroundUrl(), dealsAsset.getBackgroundUrl()) && Intrinsics.areEqual(getPocketType(), dealsAsset.getPocketType()) && getCacheTimestamp() == dealsAsset.getCacheTimestamp() && this.activateDate == dealsAsset.activateDate && Intrinsics.areEqual(this.amount, dealsAsset.amount) && Intrinsics.areEqual(this.shortDescription, dealsAsset.shortDescription) && Intrinsics.areEqual(this.templateId, dealsAsset.templateId) && Intrinsics.areEqual(this.uniqueId, dealsAsset.uniqueId) && Intrinsics.areEqual(this.howTo, dealsAsset.howTo) && Intrinsics.areEqual(this.userPocketStatus, dealsAsset.userPocketStatus) && Intrinsics.areEqual(this.merchantId, dealsAsset.merchantId) && Intrinsics.areEqual(this.label, dealsAsset.label) && Intrinsics.areEqual(this.subLabel, dealsAsset.subLabel) && Intrinsics.areEqual(this.logoUrl, dealsAsset.logoUrl) && this.usable == dealsAsset.usable && this.shareable == dealsAsset.shareable && this.expirationDate == dealsAsset.expirationDate && Intrinsics.areEqual(this.backgroundColor, dealsAsset.backgroundColor) && Intrinsics.areEqual(this.fontColor, dealsAsset.fontColor) && Intrinsics.areEqual(this.minTransaction, dealsAsset.minTransaction) && Intrinsics.areEqual(this.categoryIconUrl, dealsAsset.categoryIconUrl) && Intrinsics.areEqual(this.bizType, dealsAsset.bizType) && this.isOnlineMerchant == dealsAsset.isOnlineMerchant && Intrinsics.areEqual(this.redemptionType, dealsAsset.redemptionType) && Intrinsics.areEqual(this.providerCategory, dealsAsset.providerCategory) && Intrinsics.areEqual(this.discountRate, dealsAsset.discountRate) && Intrinsics.areEqual(this.shareableRpcInfo, dealsAsset.shareableRpcInfo);
            }
            return false;
        }

        public final int hashCode() {
            int hashCode = getPocketId().hashCode();
            int hashCode2 = getPocketStatus().hashCode();
            int hashCode3 = getIconUrl().hashCode();
            int hashCode4 = getBackgroundUrl().hashCode();
            int hashCode5 = getPocketType().hashCode();
            int m = Cbor$Arg$$ExternalSyntheticBackport0.m(getCacheTimestamp());
            int m2 = Cbor$Arg$$ExternalSyntheticBackport0.m(this.activateDate);
            int hashCode6 = this.amount.hashCode();
            int hashCode7 = this.shortDescription.hashCode();
            int hashCode8 = this.templateId.hashCode();
            int hashCode9 = this.uniqueId.hashCode();
            int hashCode10 = this.howTo.hashCode();
            int hashCode11 = this.userPocketStatus.hashCode();
            int hashCode12 = this.merchantId.hashCode();
            int hashCode13 = this.label.hashCode();
            int hashCode14 = this.subLabel.hashCode();
            int hashCode15 = this.logoUrl.hashCode();
            boolean z = this.usable;
            int i = z ? 1 : z ? 1 : 0;
            boolean z2 = this.shareable;
            int i2 = z2 ? 1 : z2 ? 1 : 0;
            int m3 = Cbor$Arg$$ExternalSyntheticBackport0.m(this.expirationDate);
            int hashCode16 = this.backgroundColor.hashCode();
            int hashCode17 = this.fontColor.hashCode();
            int hashCode18 = this.minTransaction.hashCode();
            int hashCode19 = this.categoryIconUrl.hashCode();
            int hashCode20 = this.bizType.hashCode();
            boolean z3 = this.isOnlineMerchant;
            int i3 = z3 ? 1 : z3 ? 1 : 0;
            int hashCode21 = this.redemptionType.hashCode();
            int hashCode22 = this.providerCategory.hashCode();
            int hashCode23 = this.discountRate.hashCode();
            ShareableRpcInfo shareableRpcInfo = this.shareableRpcInfo;
            return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + m) * 31) + m2) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + hashCode14) * 31) + hashCode15) * 31) + i) * 31) + i2) * 31) + m3) * 31) + hashCode16) * 31) + hashCode17) * 31) + hashCode18) * 31) + hashCode19) * 31) + hashCode20) * 31) + i3) * 31) + hashCode21) * 31) + hashCode22) * 31) + hashCode23) * 31) + (shareableRpcInfo == null ? 0 : shareableRpcInfo.hashCode());
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("DealsAsset(pocketId=");
            sb.append(getPocketId());
            sb.append(", pocketStatus=");
            sb.append(getPocketStatus());
            sb.append(", iconUrl=");
            sb.append(getIconUrl());
            sb.append(", backgroundUrl=");
            sb.append(getBackgroundUrl());
            sb.append(", pocketType=");
            sb.append(getPocketType());
            sb.append(", cacheTimestamp=");
            sb.append(getCacheTimestamp());
            sb.append(", activateDate=");
            sb.append(this.activateDate);
            sb.append(", amount=");
            sb.append(this.amount);
            sb.append(", shortDescription=");
            sb.append(this.shortDescription);
            sb.append(", templateId=");
            sb.append(this.templateId);
            sb.append(", uniqueId=");
            sb.append(this.uniqueId);
            sb.append(", howTo=");
            sb.append(this.howTo);
            sb.append(", userPocketStatus=");
            sb.append(this.userPocketStatus);
            sb.append(", merchantId=");
            sb.append(this.merchantId);
            sb.append(", label=");
            sb.append(this.label);
            sb.append(", subLabel=");
            sb.append(this.subLabel);
            sb.append(", logoUrl=");
            sb.append(this.logoUrl);
            sb.append(", usable=");
            sb.append(this.usable);
            sb.append(", shareable=");
            sb.append(this.shareable);
            sb.append(", expirationDate=");
            sb.append(this.expirationDate);
            sb.append(", backgroundColor=");
            sb.append(this.backgroundColor);
            sb.append(", fontColor=");
            sb.append(this.fontColor);
            sb.append(", minTransaction=");
            sb.append(this.minTransaction);
            sb.append(", categoryIconUrl=");
            sb.append(this.categoryIconUrl);
            sb.append(", bizType=");
            sb.append(this.bizType);
            sb.append(", isOnlineMerchant=");
            sb.append(this.isOnlineMerchant);
            sb.append(", redemptionType=");
            sb.append(this.redemptionType);
            sb.append(", providerCategory=");
            sb.append(this.providerCategory);
            sb.append(", discountRate=");
            sb.append(this.discountRate);
            sb.append(", shareableRpcInfo=");
            sb.append(this.shareableRpcInfo);
            sb.append(')');
            return sb.toString();
        }

        public /* synthetic */ DealsAsset(String str, String str2, String str3, String str4, String str5, long j, long j2, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, boolean z, boolean z2, long j3, String str16, String str17, String str18, String str19, String str20, boolean z3, String str21, String str22, String str23, ShareableRpcInfo shareableRpcInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? -1L : j, (i & 64) != 0 ? -1L : j2, (i & 128) != 0 ? "" : str6, (i & 256) != 0 ? "" : str7, (i & 512) != 0 ? "" : str8, (i & 1024) != 0 ? "" : str9, (i & 2048) != 0 ? "" : str10, (i & 4096) != 0 ? "" : str11, (i & 8192) != 0 ? "" : str12, (i & 16384) != 0 ? "" : str13, (32768 & i) != 0 ? "" : str14, (65536 & i) != 0 ? "" : str15, (131072 & i) != 0 ? false : z, (262144 & i) != 0 ? false : z2, (524288 & i) != 0 ? -1L : j3, (1048576 & i) != 0 ? "" : str16, (2097152 & i) != 0 ? "" : str17, (4194304 & i) != 0 ? "" : str18, (8388608 & i) != 0 ? "" : str19, (16777216 & i) != 0 ? "" : str20, (33554432 & i) != 0 ? false : z3, (67108864 & i) != 0 ? "" : str21, (134217728 & i) != 0 ? "" : str22, (i & SQLiteDatabase.CREATE_IF_NECESSARY) == 0 ? str23 : "", shareableRpcInfo);
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "getPocketId")
        public final String getPocketId() {
            return this.pocketId;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "setPocketId")
        public final void setPocketId(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.pocketId = str;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "getPocketStatus")
        public final String getPocketStatus() {
            return this.pocketStatus;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "setPocketStatus")
        public final void setPocketStatus(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.pocketStatus = str;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "getIconUrl")
        public final String getIconUrl() {
            return this.iconUrl;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "setIconUrl")
        public final void setIconUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.iconUrl = str;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "getBackgroundUrl")
        public final String getBackgroundUrl() {
            return this.backgroundUrl;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "setBackgroundUrl")
        public final void setBackgroundUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.backgroundUrl = str;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "getPocketType")
        public final String getPocketType() {
            return this.pocketType;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "setPocketType")
        public final void setPocketType(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.pocketType = str;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "getCacheTimestamp")
        public final long getCacheTimestamp() {
            return this.cacheTimestamp;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "setCacheTimestamp")
        public final void setCacheTimestamp(long j) {
            this.cacheTimestamp = j;
        }

        @JvmName(name = "getActivateDate")
        public final long getActivateDate() {
            return this.activateDate;
        }

        @JvmName(name = "setActivateDate")
        public final void setActivateDate(long j) {
            this.activateDate = j;
        }

        @JvmName(name = "getAmount")
        public final String getAmount() {
            return this.amount;
        }

        @JvmName(name = "setAmount")
        public final void setAmount(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.amount = str;
        }

        @JvmName(name = "getShortDescription")
        public final String getShortDescription() {
            return this.shortDescription;
        }

        @JvmName(name = "setShortDescription")
        public final void setShortDescription(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.shortDescription = str;
        }

        @JvmName(name = "getTemplateId")
        public final String getTemplateId() {
            return this.templateId;
        }

        @JvmName(name = "setTemplateId")
        public final void setTemplateId(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.templateId = str;
        }

        @JvmName(name = "getUniqueId")
        public final String getUniqueId() {
            return this.uniqueId;
        }

        @JvmName(name = "setUniqueId")
        public final void setUniqueId(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.uniqueId = str;
        }

        @JvmName(name = "getHowTo")
        public final String getHowTo() {
            return this.howTo;
        }

        @JvmName(name = "setHowTo")
        public final void setHowTo(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.howTo = str;
        }

        @JvmName(name = "getUserPocketStatus")
        public final String getUserPocketStatus() {
            return this.userPocketStatus;
        }

        @JvmName(name = "setUserPocketStatus")
        public final void setUserPocketStatus(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.userPocketStatus = str;
        }

        @JvmName(name = "getMerchantId")
        public final String getMerchantId() {
            return this.merchantId;
        }

        @JvmName(name = "setMerchantId")
        public final void setMerchantId(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.merchantId = str;
        }

        @JvmName(name = "getLabel")
        public final String getLabel() {
            return this.label;
        }

        @JvmName(name = "setLabel")
        public final void setLabel(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.label = str;
        }

        @JvmName(name = "getSubLabel")
        public final String getSubLabel() {
            return this.subLabel;
        }

        @JvmName(name = "setSubLabel")
        public final void setSubLabel(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.subLabel = str;
        }

        @JvmName(name = "getLogoUrl")
        public final String getLogoUrl() {
            return this.logoUrl;
        }

        @JvmName(name = "setLogoUrl")
        public final void setLogoUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.logoUrl = str;
        }

        @JvmName(name = "getUsable")
        public final boolean getUsable() {
            return this.usable;
        }

        @JvmName(name = "setUsable")
        public final void setUsable(boolean z) {
            this.usable = z;
        }

        @JvmName(name = "getShareable")
        public final boolean getShareable() {
            return this.shareable;
        }

        @JvmName(name = "setShareable")
        public final void setShareable(boolean z) {
            this.shareable = z;
        }

        @JvmName(name = "getExpirationDate")
        public final long getExpirationDate() {
            return this.expirationDate;
        }

        @JvmName(name = "setExpirationDate")
        public final void setExpirationDate(long j) {
            this.expirationDate = j;
        }

        @JvmName(name = "getBackgroundColor")
        public final String getBackgroundColor() {
            return this.backgroundColor;
        }

        @JvmName(name = "setBackgroundColor")
        public final void setBackgroundColor(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.backgroundColor = str;
        }

        @JvmName(name = "getFontColor")
        public final String getFontColor() {
            return this.fontColor;
        }

        @JvmName(name = "setFontColor")
        public final void setFontColor(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.fontColor = str;
        }

        @JvmName(name = "getMinTransaction")
        public final String getMinTransaction() {
            return this.minTransaction;
        }

        @JvmName(name = "setMinTransaction")
        public final void setMinTransaction(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.minTransaction = str;
        }

        @JvmName(name = "getCategoryIconUrl")
        public final String getCategoryIconUrl() {
            return this.categoryIconUrl;
        }

        @JvmName(name = "setCategoryIconUrl")
        public final void setCategoryIconUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.categoryIconUrl = str;
        }

        @JvmName(name = "getBizType")
        public final String getBizType() {
            return this.bizType;
        }

        @JvmName(name = "setBizType")
        public final void setBizType(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.bizType = str;
        }

        @JvmName(name = "isOnlineMerchant")
        public final boolean isOnlineMerchant() {
            return this.isOnlineMerchant;
        }

        @JvmName(name = "setOnlineMerchant")
        public final void setOnlineMerchant(boolean z) {
            this.isOnlineMerchant = z;
        }

        @JvmName(name = "getRedemptionType")
        public final String getRedemptionType() {
            return this.redemptionType;
        }

        @JvmName(name = "setRedemptionType")
        public final void setRedemptionType(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.redemptionType = str;
        }

        @JvmName(name = "getProviderCategory")
        public final String getProviderCategory() {
            return this.providerCategory;
        }

        @JvmName(name = "setProviderCategory")
        public final void setProviderCategory(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.providerCategory = str;
        }

        @JvmName(name = "getDiscountRate")
        public final String getDiscountRate() {
            return this.discountRate;
        }

        @JvmName(name = "setDiscountRate")
        public final void setDiscountRate(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.discountRate = str;
        }

        @JvmName(name = "getShareableRpcInfo")
        public final ShareableRpcInfo getShareableRpcInfo() {
            return this.shareableRpcInfo;
        }

        @JvmName(name = "setShareableRpcInfo")
        public final void setShareableRpcInfo(ShareableRpcInfo shareableRpcInfo) {
            this.shareableRpcInfo = shareableRpcInfo;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DealsAsset(String str, String str2, String str3, String str4, String str5, long j, long j2, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, boolean z, boolean z2, long j3, String str16, String str17, String str18, String str19, String str20, boolean z3, String str21, String str22, String str23, ShareableRpcInfo shareableRpcInfo) {
            super(str, str2, str3, str4, str5, j, null);
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
            Intrinsics.checkNotNullParameter(str14, "");
            Intrinsics.checkNotNullParameter(str15, "");
            Intrinsics.checkNotNullParameter(str16, "");
            Intrinsics.checkNotNullParameter(str17, "");
            Intrinsics.checkNotNullParameter(str18, "");
            Intrinsics.checkNotNullParameter(str19, "");
            Intrinsics.checkNotNullParameter(str20, "");
            Intrinsics.checkNotNullParameter(str21, "");
            Intrinsics.checkNotNullParameter(str22, "");
            Intrinsics.checkNotNullParameter(str23, "");
            this.pocketId = str;
            this.pocketStatus = str2;
            this.iconUrl = str3;
            this.backgroundUrl = str4;
            this.pocketType = str5;
            this.cacheTimestamp = j;
            this.activateDate = j2;
            this.amount = str6;
            this.shortDescription = str7;
            this.templateId = str8;
            this.uniqueId = str9;
            this.howTo = str10;
            this.userPocketStatus = str11;
            this.merchantId = str12;
            this.label = str13;
            this.subLabel = str14;
            this.logoUrl = str15;
            this.usable = z;
            this.shareable = z2;
            this.expirationDate = j3;
            this.backgroundColor = str16;
            this.fontColor = str17;
            this.minTransaction = str18;
            this.categoryIconUrl = str19;
            this.bizType = str20;
            this.isOnlineMerchant = z3;
            this.redemptionType = str21;
            this.providerCategory = str22;
            this.discountRate = str23;
            this.shareableRpcInfo = shareableRpcInfo;
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b \n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b=\b\u0086\b\u0018\u00002\u00020\u0001B³\u0002\u0012\b\b\u0002\u0010!\u001a\u00020\u0002\u0012\b\b\u0002\u0010\"\u001a\u00020\u0002\u0012\b\b\u0002\u0010#\u001a\u00020\u0002\u0012\b\b\u0002\u0010$\u001a\u00020\u0002\u0012\b\b\u0002\u0010%\u001a\u00020\u0002\u0012\b\b\u0002\u0010&\u001a\u00020\u001b\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0002\u0012\u0016\b\u0002\u00103\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000e\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b|\u0010}J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u001e\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0004J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0004J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0004J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0004J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0004J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0004J\u0010\u0010\u0018\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0004J\u0010\u0010\u0019\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0004J\u0010\u0010\u001a\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0004J\u0010\u0010\u001c\u001a\u00020\u001bHÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u0004J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u0004J\u0012\u0010 \u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b \u0010\u0004J¼\u0002\u0010:\u001a\u00020\u00002\b\b\u0002\u0010!\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020\u00022\b\b\u0002\u0010#\u001a\u00020\u00022\b\b\u0002\u0010$\u001a\u00020\u00022\b\b\u0002\u0010%\u001a\u00020\u00022\b\b\u0002\u0010&\u001a\u00020\u001b2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00022\u0016\b\u0002\u00103\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000e2\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b:\u0010;J\u001a\u0010>\u001a\u00020=2\b\u00103\u001a\u0004\u0018\u00010<HÖ\u0003¢\u0006\u0004\b>\u0010?J\u0010\u0010A\u001a\u00020@HÖ\u0001¢\u0006\u0004\bA\u0010BJ\u0010\u0010C\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\bC\u0010\u0004R$\u0010.\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010D\u001a\u0004\bE\u0010\u0004\"\u0004\bF\u0010GR$\u00101\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b1\u0010D\u001a\u0004\bH\u0010\u0004\"\u0004\bI\u0010GR\"\u0010$\u001a\u00020\u00028\u0017@\u0017X\u0097\u000e¢\u0006\u0012\n\u0004\b$\u0010D\u001a\u0004\bJ\u0010\u0004\"\u0004\bK\u0010GR$\u00104\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b4\u0010D\u001a\u0004\bL\u0010\u0004\"\u0004\bM\u0010GR\"\u0010&\u001a\u00020\u001b8\u0017@\u0017X\u0097\u000e¢\u0006\u0012\n\u0004\b&\u0010N\u001a\u0004\bO\u0010\u001d\"\u0004\bP\u0010QR$\u0010'\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010D\u001a\u0004\bR\u0010\u0004\"\u0004\bS\u0010GR$\u0010-\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010D\u001a\u0004\bT\u0010\u0004\"\u0004\bU\u0010GR$\u00100\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u0010D\u001a\u0004\bV\u0010\u0004\"\u0004\bW\u0010GR$\u00109\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b9\u0010D\u001a\u0004\bX\u0010\u0004\"\u0004\bY\u0010GR$\u00107\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b7\u0010D\u001a\u0004\bZ\u0010\u0004\"\u0004\b[\u0010GR\"\u0010#\u001a\u00020\u00028\u0017@\u0017X\u0097\u000e¢\u0006\u0012\n\u0004\b#\u0010D\u001a\u0004\b\\\u0010\u0004\"\u0004\b]\u0010GR$\u0010(\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010D\u001a\u0004\b^\u0010\u0004\"\u0004\b_\u0010GR$\u00102\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u0010D\u001a\u0004\b`\u0010\u0004\"\u0004\ba\u0010GR0\u00103\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000e8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b3\u0010b\u001a\u0004\bc\u0010\u0010\"\u0004\bd\u0010eR$\u0010)\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010D\u001a\u0004\bf\u0010\u0004\"\u0004\bg\u0010GR$\u0010*\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010D\u001a\u0004\bh\u0010\u0004\"\u0004\bi\u0010GR\"\u0010!\u001a\u00020\u00028\u0017@\u0017X\u0097\u000e¢\u0006\u0012\n\u0004\b!\u0010D\u001a\u0004\bj\u0010\u0004\"\u0004\bk\u0010GR\"\u0010\"\u001a\u00020\u00028\u0017@\u0017X\u0097\u000e¢\u0006\u0012\n\u0004\b\"\u0010D\u001a\u0004\bl\u0010\u0004\"\u0004\bm\u0010GR\"\u0010%\u001a\u00020\u00028\u0017@\u0017X\u0097\u000e¢\u0006\u0012\n\u0004\b%\u0010D\u001a\u0004\bn\u0010\u0004\"\u0004\bo\u0010GR$\u00108\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b8\u0010D\u001a\u0004\bp\u0010\u0004\"\u0004\bq\u0010GR$\u00105\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b5\u0010D\u001a\u0004\br\u0010\u0004\"\u0004\bs\u0010GR$\u0010+\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010D\u001a\u0004\bt\u0010\u0004\"\u0004\bu\u0010GR$\u0010,\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010D\u001a\u0004\bv\u0010\u0004\"\u0004\bw\u0010GR$\u0010/\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u0010D\u001a\u0004\bx\u0010\u0004\"\u0004\by\u0010GR$\u00106\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b6\u0010D\u001a\u0004\bz\u0010\u0004\"\u0004\b{\u0010G"}, d2 = {"Lid/dana/domain/wallet_v3/model/UserPocketAssetModel$UserTravelTicketAsset;", "Lid/dana/domain/wallet_v3/model/UserPocketAssetModel;", "", "component1", "()Ljava/lang/String;", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "", "component19", "()Ljava/util/Map;", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component3", "component4", "component5", "", "component6", "()J", "component7", "component8", "component9", "pocketId", "pocketStatus", "iconUrl", "backgroundUrl", "pocketType", "cacheTimestamp", "createdDate", DecodedScanBizInfoKey.LOGO_URL, "passengerName", "passengerType", "subPocketType", "ticketName", "departure", "arrival", "transportLogoUrl", "departureTime", "arrivalTime", "notes", "other", "bookingCode", "seatNumber", "transportName", "hexCode", "primaryCTA", "gateNumber", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/wallet_v3/model/UserPocketAssetModel$UserTravelTicketAsset;", "", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getArrival", "setArrival", "(Ljava/lang/String;)V", "getArrivalTime", "setArrivalTime", "getBackgroundUrl", "setBackgroundUrl", "getBookingCode", "setBookingCode", "J", "getCacheTimestamp", "setCacheTimestamp", "(J)V", "getCreatedDate", "setCreatedDate", "getDeparture", "setDeparture", "getDepartureTime", "setDepartureTime", "getGateNumber", "setGateNumber", "getHexCode", "setHexCode", "getIconUrl", "setIconUrl", "getLogoUrl", "setLogoUrl", "getNotes", "setNotes", "Ljava/util/Map;", "getOther", "setOther", "(Ljava/util/Map;)V", "getPassengerName", "setPassengerName", "getPassengerType", "setPassengerType", "getPocketId", "setPocketId", "getPocketStatus", "setPocketStatus", "getPocketType", "setPocketType", "getPrimaryCTA", "setPrimaryCTA", "getSeatNumber", "setSeatNumber", "getSubPocketType", "setSubPocketType", "getTicketName", "setTicketName", "getTransportLogoUrl", "setTransportLogoUrl", "getTransportName", "setTransportName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class UserTravelTicketAsset extends UserPocketAssetModel {
        private String arrival;
        private String arrivalTime;
        private String backgroundUrl;
        private String bookingCode;
        private long cacheTimestamp;
        private String createdDate;
        private String departure;
        private String departureTime;
        private String gateNumber;
        private String hexCode;
        private String iconUrl;
        private String logoUrl;
        private String notes;
        private Map<String, String> other;
        private String passengerName;
        private String passengerType;
        private String pocketId;
        private String pocketStatus;
        private String pocketType;
        private String primaryCTA;
        private String seatNumber;
        private String subPocketType;
        private String ticketName;
        private String transportLogoUrl;
        private String transportName;

        public UserTravelTicketAsset() {
            this(null, null, null, null, null, 0L, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 33554431, null);
        }

        public final String component1() {
            return getPocketId();
        }

        /* renamed from: component10  reason: from getter */
        public final String getPassengerType() {
            return this.passengerType;
        }

        /* renamed from: component11  reason: from getter */
        public final String getSubPocketType() {
            return this.subPocketType;
        }

        /* renamed from: component12  reason: from getter */
        public final String getTicketName() {
            return this.ticketName;
        }

        /* renamed from: component13  reason: from getter */
        public final String getDeparture() {
            return this.departure;
        }

        /* renamed from: component14  reason: from getter */
        public final String getArrival() {
            return this.arrival;
        }

        /* renamed from: component15  reason: from getter */
        public final String getTransportLogoUrl() {
            return this.transportLogoUrl;
        }

        /* renamed from: component16  reason: from getter */
        public final String getDepartureTime() {
            return this.departureTime;
        }

        /* renamed from: component17  reason: from getter */
        public final String getArrivalTime() {
            return this.arrivalTime;
        }

        /* renamed from: component18  reason: from getter */
        public final String getNotes() {
            return this.notes;
        }

        public final Map<String, String> component19() {
            return this.other;
        }

        public final String component2() {
            return getPocketStatus();
        }

        /* renamed from: component20  reason: from getter */
        public final String getBookingCode() {
            return this.bookingCode;
        }

        /* renamed from: component21  reason: from getter */
        public final String getSeatNumber() {
            return this.seatNumber;
        }

        /* renamed from: component22  reason: from getter */
        public final String getTransportName() {
            return this.transportName;
        }

        /* renamed from: component23  reason: from getter */
        public final String getHexCode() {
            return this.hexCode;
        }

        /* renamed from: component24  reason: from getter */
        public final String getPrimaryCTA() {
            return this.primaryCTA;
        }

        /* renamed from: component25  reason: from getter */
        public final String getGateNumber() {
            return this.gateNumber;
        }

        public final String component3() {
            return getIconUrl();
        }

        public final String component4() {
            return getBackgroundUrl();
        }

        public final String component5() {
            return getPocketType();
        }

        public final long component6() {
            return getCacheTimestamp();
        }

        /* renamed from: component7  reason: from getter */
        public final String getCreatedDate() {
            return this.createdDate;
        }

        /* renamed from: component8  reason: from getter */
        public final String getLogoUrl() {
            return this.logoUrl;
        }

        /* renamed from: component9  reason: from getter */
        public final String getPassengerName() {
            return this.passengerName;
        }

        public final UserTravelTicketAsset copy(String pocketId, String pocketStatus, String iconUrl, String backgroundUrl, String pocketType, long cacheTimestamp, String createdDate, String logoUrl, String passengerName, String passengerType, String subPocketType, String ticketName, String departure, String arrival, String transportLogoUrl, String departureTime, String arrivalTime, String notes, Map<String, String> other, String bookingCode, String seatNumber, String transportName, String hexCode, String primaryCTA, String gateNumber) {
            Intrinsics.checkNotNullParameter(pocketId, "");
            Intrinsics.checkNotNullParameter(pocketStatus, "");
            Intrinsics.checkNotNullParameter(iconUrl, "");
            Intrinsics.checkNotNullParameter(backgroundUrl, "");
            Intrinsics.checkNotNullParameter(pocketType, "");
            return new UserTravelTicketAsset(pocketId, pocketStatus, iconUrl, backgroundUrl, pocketType, cacheTimestamp, createdDate, logoUrl, passengerName, passengerType, subPocketType, ticketName, departure, arrival, transportLogoUrl, departureTime, arrivalTime, notes, other, bookingCode, seatNumber, transportName, hexCode, primaryCTA, gateNumber);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof UserTravelTicketAsset) {
                UserTravelTicketAsset userTravelTicketAsset = (UserTravelTicketAsset) other;
                return Intrinsics.areEqual(getPocketId(), userTravelTicketAsset.getPocketId()) && Intrinsics.areEqual(getPocketStatus(), userTravelTicketAsset.getPocketStatus()) && Intrinsics.areEqual(getIconUrl(), userTravelTicketAsset.getIconUrl()) && Intrinsics.areEqual(getBackgroundUrl(), userTravelTicketAsset.getBackgroundUrl()) && Intrinsics.areEqual(getPocketType(), userTravelTicketAsset.getPocketType()) && getCacheTimestamp() == userTravelTicketAsset.getCacheTimestamp() && Intrinsics.areEqual(this.createdDate, userTravelTicketAsset.createdDate) && Intrinsics.areEqual(this.logoUrl, userTravelTicketAsset.logoUrl) && Intrinsics.areEqual(this.passengerName, userTravelTicketAsset.passengerName) && Intrinsics.areEqual(this.passengerType, userTravelTicketAsset.passengerType) && Intrinsics.areEqual(this.subPocketType, userTravelTicketAsset.subPocketType) && Intrinsics.areEqual(this.ticketName, userTravelTicketAsset.ticketName) && Intrinsics.areEqual(this.departure, userTravelTicketAsset.departure) && Intrinsics.areEqual(this.arrival, userTravelTicketAsset.arrival) && Intrinsics.areEqual(this.transportLogoUrl, userTravelTicketAsset.transportLogoUrl) && Intrinsics.areEqual(this.departureTime, userTravelTicketAsset.departureTime) && Intrinsics.areEqual(this.arrivalTime, userTravelTicketAsset.arrivalTime) && Intrinsics.areEqual(this.notes, userTravelTicketAsset.notes) && Intrinsics.areEqual(this.other, userTravelTicketAsset.other) && Intrinsics.areEqual(this.bookingCode, userTravelTicketAsset.bookingCode) && Intrinsics.areEqual(this.seatNumber, userTravelTicketAsset.seatNumber) && Intrinsics.areEqual(this.transportName, userTravelTicketAsset.transportName) && Intrinsics.areEqual(this.hexCode, userTravelTicketAsset.hexCode) && Intrinsics.areEqual(this.primaryCTA, userTravelTicketAsset.primaryCTA) && Intrinsics.areEqual(this.gateNumber, userTravelTicketAsset.gateNumber);
            }
            return false;
        }

        public final int hashCode() {
            int hashCode = getPocketId().hashCode();
            int hashCode2 = getPocketStatus().hashCode();
            int hashCode3 = getIconUrl().hashCode();
            int hashCode4 = getBackgroundUrl().hashCode();
            int hashCode5 = getPocketType().hashCode();
            int m = Cbor$Arg$$ExternalSyntheticBackport0.m(getCacheTimestamp());
            String str = this.createdDate;
            int hashCode6 = str == null ? 0 : str.hashCode();
            String str2 = this.logoUrl;
            int hashCode7 = str2 == null ? 0 : str2.hashCode();
            String str3 = this.passengerName;
            int hashCode8 = str3 == null ? 0 : str3.hashCode();
            String str4 = this.passengerType;
            int hashCode9 = str4 == null ? 0 : str4.hashCode();
            String str5 = this.subPocketType;
            int hashCode10 = str5 == null ? 0 : str5.hashCode();
            String str6 = this.ticketName;
            int hashCode11 = str6 == null ? 0 : str6.hashCode();
            String str7 = this.departure;
            int hashCode12 = str7 == null ? 0 : str7.hashCode();
            String str8 = this.arrival;
            int hashCode13 = str8 == null ? 0 : str8.hashCode();
            String str9 = this.transportLogoUrl;
            int hashCode14 = str9 == null ? 0 : str9.hashCode();
            String str10 = this.departureTime;
            int hashCode15 = str10 == null ? 0 : str10.hashCode();
            String str11 = this.arrivalTime;
            int hashCode16 = str11 == null ? 0 : str11.hashCode();
            String str12 = this.notes;
            int hashCode17 = str12 == null ? 0 : str12.hashCode();
            Map<String, String> map = this.other;
            int hashCode18 = map == null ? 0 : map.hashCode();
            String str13 = this.bookingCode;
            int hashCode19 = str13 == null ? 0 : str13.hashCode();
            String str14 = this.seatNumber;
            int hashCode20 = str14 == null ? 0 : str14.hashCode();
            String str15 = this.transportName;
            int hashCode21 = str15 == null ? 0 : str15.hashCode();
            String str16 = this.hexCode;
            int hashCode22 = str16 == null ? 0 : str16.hashCode();
            String str17 = this.primaryCTA;
            int hashCode23 = str17 == null ? 0 : str17.hashCode();
            String str18 = this.gateNumber;
            return (((((((((((((((((((((((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + m) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + hashCode14) * 31) + hashCode15) * 31) + hashCode16) * 31) + hashCode17) * 31) + hashCode18) * 31) + hashCode19) * 31) + hashCode20) * 31) + hashCode21) * 31) + hashCode22) * 31) + hashCode23) * 31) + (str18 != null ? str18.hashCode() : 0);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("UserTravelTicketAsset(pocketId=");
            sb.append(getPocketId());
            sb.append(", pocketStatus=");
            sb.append(getPocketStatus());
            sb.append(", iconUrl=");
            sb.append(getIconUrl());
            sb.append(", backgroundUrl=");
            sb.append(getBackgroundUrl());
            sb.append(", pocketType=");
            sb.append(getPocketType());
            sb.append(", cacheTimestamp=");
            sb.append(getCacheTimestamp());
            sb.append(", createdDate=");
            sb.append(this.createdDate);
            sb.append(", logoUrl=");
            sb.append(this.logoUrl);
            sb.append(", passengerName=");
            sb.append(this.passengerName);
            sb.append(", passengerType=");
            sb.append(this.passengerType);
            sb.append(", subPocketType=");
            sb.append(this.subPocketType);
            sb.append(", ticketName=");
            sb.append(this.ticketName);
            sb.append(", departure=");
            sb.append(this.departure);
            sb.append(", arrival=");
            sb.append(this.arrival);
            sb.append(", transportLogoUrl=");
            sb.append(this.transportLogoUrl);
            sb.append(", departureTime=");
            sb.append(this.departureTime);
            sb.append(", arrivalTime=");
            sb.append(this.arrivalTime);
            sb.append(", notes=");
            sb.append(this.notes);
            sb.append(", other=");
            sb.append(this.other);
            sb.append(", bookingCode=");
            sb.append(this.bookingCode);
            sb.append(", seatNumber=");
            sb.append(this.seatNumber);
            sb.append(", transportName=");
            sb.append(this.transportName);
            sb.append(", hexCode=");
            sb.append(this.hexCode);
            sb.append(", primaryCTA=");
            sb.append(this.primaryCTA);
            sb.append(", gateNumber=");
            sb.append(this.gateNumber);
            sb.append(')');
            return sb.toString();
        }

        public /* synthetic */ UserTravelTicketAsset(String str, String str2, String str3, String str4, String str5, long j, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, Map map, String str18, String str19, String str20, String str21, String str22, String str23, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? -1L : j, (i & 64) != 0 ? "" : str6, (i & 128) != 0 ? "" : str7, (i & 256) != 0 ? "" : str8, (i & 512) != 0 ? "" : str9, (i & 1024) != 0 ? "" : str10, (i & 2048) != 0 ? "" : str11, (i & 4096) != 0 ? "" : str12, (i & 8192) != 0 ? "" : str13, (i & 16384) != 0 ? "" : str14, (i & 32768) != 0 ? "" : str15, (i & 65536) != 0 ? "" : str16, (i & AntDetector.SCENE_ID_LOGIN_REGIST) != 0 ? "" : str17, (i & 262144) != 0 ? null : map, (i & 524288) != 0 ? "" : str18, (i & CrashCombineUtils.DEFAULT_MAX_INFO_LEN) != 0 ? "" : str19, (i & 2097152) != 0 ? "" : str20, (i & 4194304) != 0 ? "" : str21, (i & 8388608) != 0 ? "" : str22, (i & 16777216) != 0 ? "" : str23);
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "getPocketId")
        public final String getPocketId() {
            return this.pocketId;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "setPocketId")
        public final void setPocketId(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.pocketId = str;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "getPocketStatus")
        public final String getPocketStatus() {
            return this.pocketStatus;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "setPocketStatus")
        public final void setPocketStatus(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.pocketStatus = str;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "getIconUrl")
        public final String getIconUrl() {
            return this.iconUrl;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "setIconUrl")
        public final void setIconUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.iconUrl = str;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "getBackgroundUrl")
        public final String getBackgroundUrl() {
            return this.backgroundUrl;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "setBackgroundUrl")
        public final void setBackgroundUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.backgroundUrl = str;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "getPocketType")
        public final String getPocketType() {
            return this.pocketType;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "setPocketType")
        public final void setPocketType(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.pocketType = str;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "getCacheTimestamp")
        public final long getCacheTimestamp() {
            return this.cacheTimestamp;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "setCacheTimestamp")
        public final void setCacheTimestamp(long j) {
            this.cacheTimestamp = j;
        }

        @JvmName(name = "getCreatedDate")
        public final String getCreatedDate() {
            return this.createdDate;
        }

        @JvmName(name = "setCreatedDate")
        public final void setCreatedDate(String str) {
            this.createdDate = str;
        }

        @JvmName(name = "getLogoUrl")
        public final String getLogoUrl() {
            return this.logoUrl;
        }

        @JvmName(name = "setLogoUrl")
        public final void setLogoUrl(String str) {
            this.logoUrl = str;
        }

        @JvmName(name = "getPassengerName")
        public final String getPassengerName() {
            return this.passengerName;
        }

        @JvmName(name = "setPassengerName")
        public final void setPassengerName(String str) {
            this.passengerName = str;
        }

        @JvmName(name = "getPassengerType")
        public final String getPassengerType() {
            return this.passengerType;
        }

        @JvmName(name = "setPassengerType")
        public final void setPassengerType(String str) {
            this.passengerType = str;
        }

        @JvmName(name = "getSubPocketType")
        public final String getSubPocketType() {
            return this.subPocketType;
        }

        @JvmName(name = "setSubPocketType")
        public final void setSubPocketType(String str) {
            this.subPocketType = str;
        }

        @JvmName(name = "getTicketName")
        public final String getTicketName() {
            return this.ticketName;
        }

        @JvmName(name = "setTicketName")
        public final void setTicketName(String str) {
            this.ticketName = str;
        }

        @JvmName(name = "getDeparture")
        public final String getDeparture() {
            return this.departure;
        }

        @JvmName(name = "setDeparture")
        public final void setDeparture(String str) {
            this.departure = str;
        }

        @JvmName(name = "getArrival")
        public final String getArrival() {
            return this.arrival;
        }

        @JvmName(name = "setArrival")
        public final void setArrival(String str) {
            this.arrival = str;
        }

        @JvmName(name = "getTransportLogoUrl")
        public final String getTransportLogoUrl() {
            return this.transportLogoUrl;
        }

        @JvmName(name = "setTransportLogoUrl")
        public final void setTransportLogoUrl(String str) {
            this.transportLogoUrl = str;
        }

        @JvmName(name = "getDepartureTime")
        public final String getDepartureTime() {
            return this.departureTime;
        }

        @JvmName(name = "setDepartureTime")
        public final void setDepartureTime(String str) {
            this.departureTime = str;
        }

        @JvmName(name = "getArrivalTime")
        public final String getArrivalTime() {
            return this.arrivalTime;
        }

        @JvmName(name = "setArrivalTime")
        public final void setArrivalTime(String str) {
            this.arrivalTime = str;
        }

        @JvmName(name = "getNotes")
        public final String getNotes() {
            return this.notes;
        }

        @JvmName(name = "setNotes")
        public final void setNotes(String str) {
            this.notes = str;
        }

        @JvmName(name = "getOther")
        public final Map<String, String> getOther() {
            return this.other;
        }

        @JvmName(name = "setOther")
        public final void setOther(Map<String, String> map) {
            this.other = map;
        }

        @JvmName(name = "getBookingCode")
        public final String getBookingCode() {
            return this.bookingCode;
        }

        @JvmName(name = "setBookingCode")
        public final void setBookingCode(String str) {
            this.bookingCode = str;
        }

        @JvmName(name = "getSeatNumber")
        public final String getSeatNumber() {
            return this.seatNumber;
        }

        @JvmName(name = "setSeatNumber")
        public final void setSeatNumber(String str) {
            this.seatNumber = str;
        }

        @JvmName(name = "getTransportName")
        public final String getTransportName() {
            return this.transportName;
        }

        @JvmName(name = "setTransportName")
        public final void setTransportName(String str) {
            this.transportName = str;
        }

        @JvmName(name = "getHexCode")
        public final String getHexCode() {
            return this.hexCode;
        }

        @JvmName(name = "setHexCode")
        public final void setHexCode(String str) {
            this.hexCode = str;
        }

        @JvmName(name = "getPrimaryCTA")
        public final String getPrimaryCTA() {
            return this.primaryCTA;
        }

        @JvmName(name = "setPrimaryCTA")
        public final void setPrimaryCTA(String str) {
            this.primaryCTA = str;
        }

        @JvmName(name = "getGateNumber")
        public final String getGateNumber() {
            return this.gateNumber;
        }

        @JvmName(name = "setGateNumber")
        public final void setGateNumber(String str) {
            this.gateNumber = str;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UserTravelTicketAsset(String str, String str2, String str3, String str4, String str5, long j, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, Map<String, String> map, String str18, String str19, String str20, String str21, String str22, String str23) {
            super(str, str2, str3, str4, str5, j, null);
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str3, "");
            Intrinsics.checkNotNullParameter(str4, "");
            Intrinsics.checkNotNullParameter(str5, "");
            this.pocketId = str;
            this.pocketStatus = str2;
            this.iconUrl = str3;
            this.backgroundUrl = str4;
            this.pocketType = str5;
            this.cacheTimestamp = j;
            this.createdDate = str6;
            this.logoUrl = str7;
            this.passengerName = str8;
            this.passengerType = str9;
            this.subPocketType = str10;
            this.ticketName = str11;
            this.departure = str12;
            this.arrival = str13;
            this.transportLogoUrl = str14;
            this.departureTime = str15;
            this.arrivalTime = str16;
            this.notes = str17;
            this.other = map;
            this.bookingCode = str18;
            this.seatNumber = str19;
            this.transportName = str20;
            this.hexCode = str21;
            this.primaryCTA = str22;
            this.gateNumber = str23;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b+\b\u0086\b\u0018\u00002\u00020\u0001B¹\u0001\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010'\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\bW\u0010XJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0004J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0004J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0004JÄ\u0001\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u00022\b\b\u0002\u0010\u001c\u001a\u00020\u00022\b\b\u0002\u0010\u001d\u001a\u00020\u00122\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0004\b(\u0010)J\u001a\u0010+\u001a\u00020*2\b\u0010'\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b+\u0010,J\u0010\u0010.\u001a\u00020-HÖ\u0001¢\u0006\u0004\b.\u0010/J\u0010\u00100\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b0\u0010\u0004R\"\u0010\u001b\u001a\u00020\u00028\u0017@\u0017X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001b\u00101\u001a\u0004\b2\u0010\u0004\"\u0004\b3\u00104R$\u0010#\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u00101\u001a\u0004\b5\u0010\u0004\"\u0004\b6\u00104R\"\u0010\u001d\u001a\u00020\u00128\u0017@\u0017X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001d\u00107\u001a\u0004\b8\u0010\u0014\"\u0004\b9\u0010:R$\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u00101\u001a\u0004\b;\u0010\u0004\"\u0004\b<\u00104R$\u0010$\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u00101\u001a\u0004\b=\u0010\u0004\"\u0004\b>\u00104R\"\u0010\u001a\u001a\u00020\u00028\u0017@\u0017X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001a\u00101\u001a\u0004\b?\u0010\u0004\"\u0004\b@\u00104R$\u0010\"\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u00101\u001a\u0004\bA\u0010\u0004\"\u0004\bB\u00104R$\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u00101\u001a\u0004\bC\u0010\u0004\"\u0004\bD\u00104R$\u0010!\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u00101\u001a\u0004\bE\u0010\u0004\"\u0004\bF\u00104R$\u0010&\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u00101\u001a\u0004\bG\u0010\u0004\"\u0004\bH\u00104R$\u0010'\u001a\u0004\u0018\u00010\u000b8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010I\u001a\u0004\bJ\u0010\r\"\u0004\bK\u0010LR\"\u0010\u0018\u001a\u00020\u00028\u0017@\u0017X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0018\u00101\u001a\u0004\bM\u0010\u0004\"\u0004\bN\u00104R\"\u0010\u0019\u001a\u00020\u00028\u0017@\u0017X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0019\u00101\u001a\u0004\bO\u0010\u0004\"\u0004\bP\u00104R\"\u0010\u001c\u001a\u00020\u00028\u0017@\u0017X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001c\u00101\u001a\u0004\bQ\u0010\u0004\"\u0004\bR\u00104R$\u0010%\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u00101\u001a\u0004\bS\u0010\u0004\"\u0004\bT\u00104R$\u0010 \u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b \u00101\u001a\u0004\bU\u0010\u0004\"\u0004\bV\u00104"}, d2 = {"Lid/dana/domain/wallet_v3/model/UserPocketAssetModel$UserParkingTicketAsset;", "Lid/dana/domain/wallet_v3/model/UserPocketAssetModel;", "", "component1", "()Ljava/lang/String;", "component10", "component11", "component12", "component13", "component14", "component15", "", "component16", "()Ljava/lang/Object;", "component2", "component3", "component4", "component5", "", "component6", "()J", "component7", "component8", "component9", "pocketId", "pocketStatus", "iconUrl", "backgroundUrl", "pocketType", "cacheTimestamp", "createdDate", DecodedScanBizInfoKey.LOGO_URL, "ticketId", "merchantId", "location", "benefit", "enterTime", "qrUrl", "merchantName", "other", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Lid/dana/domain/wallet_v3/model/UserPocketAssetModel$UserParkingTicketAsset;", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getBackgroundUrl", "setBackgroundUrl", "(Ljava/lang/String;)V", "getBenefit", "setBenefit", "J", "getCacheTimestamp", "setCacheTimestamp", "(J)V", "getCreatedDate", "setCreatedDate", "getEnterTime", "setEnterTime", "getIconUrl", "setIconUrl", "getLocation", "setLocation", "getLogoUrl", "setLogoUrl", "getMerchantId", "setMerchantId", "getMerchantName", "setMerchantName", "Ljava/lang/Object;", "getOther", "setOther", "(Ljava/lang/Object;)V", "getPocketId", "setPocketId", "getPocketStatus", "setPocketStatus", "getPocketType", "setPocketType", "getQrUrl", "setQrUrl", "getTicketId", "setTicketId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class UserParkingTicketAsset extends UserPocketAssetModel {
        private String backgroundUrl;
        private String benefit;
        private long cacheTimestamp;
        private String createdDate;
        private String enterTime;
        private String iconUrl;
        private String location;
        private String logoUrl;
        private String merchantId;
        private String merchantName;
        private Object other;
        private String pocketId;
        private String pocketStatus;
        private String pocketType;
        private String qrUrl;
        private String ticketId;

        public final String component1() {
            return getPocketId();
        }

        /* renamed from: component10  reason: from getter */
        public final String getMerchantId() {
            return this.merchantId;
        }

        /* renamed from: component11  reason: from getter */
        public final String getLocation() {
            return this.location;
        }

        /* renamed from: component12  reason: from getter */
        public final String getBenefit() {
            return this.benefit;
        }

        /* renamed from: component13  reason: from getter */
        public final String getEnterTime() {
            return this.enterTime;
        }

        /* renamed from: component14  reason: from getter */
        public final String getQrUrl() {
            return this.qrUrl;
        }

        /* renamed from: component15  reason: from getter */
        public final String getMerchantName() {
            return this.merchantName;
        }

        /* renamed from: component16  reason: from getter */
        public final Object getOther() {
            return this.other;
        }

        public final String component2() {
            return getPocketStatus();
        }

        public final String component3() {
            return getIconUrl();
        }

        public final String component4() {
            return getBackgroundUrl();
        }

        public final String component5() {
            return getPocketType();
        }

        public final long component6() {
            return getCacheTimestamp();
        }

        /* renamed from: component7  reason: from getter */
        public final String getCreatedDate() {
            return this.createdDate;
        }

        /* renamed from: component8  reason: from getter */
        public final String getLogoUrl() {
            return this.logoUrl;
        }

        /* renamed from: component9  reason: from getter */
        public final String getTicketId() {
            return this.ticketId;
        }

        public final UserParkingTicketAsset copy(String pocketId, String pocketStatus, String iconUrl, String backgroundUrl, String pocketType, long cacheTimestamp, String createdDate, String logoUrl, String ticketId, String merchantId, String location, String benefit, String enterTime, String qrUrl, String merchantName, Object other) {
            Intrinsics.checkNotNullParameter(pocketId, "");
            Intrinsics.checkNotNullParameter(pocketStatus, "");
            Intrinsics.checkNotNullParameter(iconUrl, "");
            Intrinsics.checkNotNullParameter(backgroundUrl, "");
            Intrinsics.checkNotNullParameter(pocketType, "");
            return new UserParkingTicketAsset(pocketId, pocketStatus, iconUrl, backgroundUrl, pocketType, cacheTimestamp, createdDate, logoUrl, ticketId, merchantId, location, benefit, enterTime, qrUrl, merchantName, other);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof UserParkingTicketAsset) {
                UserParkingTicketAsset userParkingTicketAsset = (UserParkingTicketAsset) other;
                return Intrinsics.areEqual(getPocketId(), userParkingTicketAsset.getPocketId()) && Intrinsics.areEqual(getPocketStatus(), userParkingTicketAsset.getPocketStatus()) && Intrinsics.areEqual(getIconUrl(), userParkingTicketAsset.getIconUrl()) && Intrinsics.areEqual(getBackgroundUrl(), userParkingTicketAsset.getBackgroundUrl()) && Intrinsics.areEqual(getPocketType(), userParkingTicketAsset.getPocketType()) && getCacheTimestamp() == userParkingTicketAsset.getCacheTimestamp() && Intrinsics.areEqual(this.createdDate, userParkingTicketAsset.createdDate) && Intrinsics.areEqual(this.logoUrl, userParkingTicketAsset.logoUrl) && Intrinsics.areEqual(this.ticketId, userParkingTicketAsset.ticketId) && Intrinsics.areEqual(this.merchantId, userParkingTicketAsset.merchantId) && Intrinsics.areEqual(this.location, userParkingTicketAsset.location) && Intrinsics.areEqual(this.benefit, userParkingTicketAsset.benefit) && Intrinsics.areEqual(this.enterTime, userParkingTicketAsset.enterTime) && Intrinsics.areEqual(this.qrUrl, userParkingTicketAsset.qrUrl) && Intrinsics.areEqual(this.merchantName, userParkingTicketAsset.merchantName) && Intrinsics.areEqual(this.other, userParkingTicketAsset.other);
            }
            return false;
        }

        public final int hashCode() {
            int hashCode = getPocketId().hashCode();
            int hashCode2 = getPocketStatus().hashCode();
            int hashCode3 = getIconUrl().hashCode();
            int hashCode4 = getBackgroundUrl().hashCode();
            int hashCode5 = getPocketType().hashCode();
            int m = Cbor$Arg$$ExternalSyntheticBackport0.m(getCacheTimestamp());
            String str = this.createdDate;
            int hashCode6 = str == null ? 0 : str.hashCode();
            String str2 = this.logoUrl;
            int hashCode7 = str2 == null ? 0 : str2.hashCode();
            String str3 = this.ticketId;
            int hashCode8 = str3 == null ? 0 : str3.hashCode();
            String str4 = this.merchantId;
            int hashCode9 = str4 == null ? 0 : str4.hashCode();
            String str5 = this.location;
            int hashCode10 = str5 == null ? 0 : str5.hashCode();
            String str6 = this.benefit;
            int hashCode11 = str6 == null ? 0 : str6.hashCode();
            String str7 = this.enterTime;
            int hashCode12 = str7 == null ? 0 : str7.hashCode();
            String str8 = this.qrUrl;
            int hashCode13 = str8 == null ? 0 : str8.hashCode();
            String str9 = this.merchantName;
            int hashCode14 = str9 == null ? 0 : str9.hashCode();
            Object obj = this.other;
            return (((((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + m) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + hashCode14) * 31) + (obj != null ? obj.hashCode() : 0);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("UserParkingTicketAsset(pocketId=");
            sb.append(getPocketId());
            sb.append(", pocketStatus=");
            sb.append(getPocketStatus());
            sb.append(", iconUrl=");
            sb.append(getIconUrl());
            sb.append(", backgroundUrl=");
            sb.append(getBackgroundUrl());
            sb.append(", pocketType=");
            sb.append(getPocketType());
            sb.append(", cacheTimestamp=");
            sb.append(getCacheTimestamp());
            sb.append(", createdDate=");
            sb.append(this.createdDate);
            sb.append(", logoUrl=");
            sb.append(this.logoUrl);
            sb.append(", ticketId=");
            sb.append(this.ticketId);
            sb.append(", merchantId=");
            sb.append(this.merchantId);
            sb.append(", location=");
            sb.append(this.location);
            sb.append(", benefit=");
            sb.append(this.benefit);
            sb.append(", enterTime=");
            sb.append(this.enterTime);
            sb.append(", qrUrl=");
            sb.append(this.qrUrl);
            sb.append(", merchantName=");
            sb.append(this.merchantName);
            sb.append(", other=");
            sb.append(this.other);
            sb.append(')');
            return sb.toString();
        }

        public /* synthetic */ UserParkingTicketAsset(String str, String str2, String str3, String str4, String str5, long j, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? -1L : j, (i & 64) != 0 ? "" : str6, (i & 128) != 0 ? "" : str7, (i & 256) != 0 ? "" : str8, (i & 512) != 0 ? "" : str9, (i & 1024) != 0 ? "" : str10, (i & 2048) != 0 ? "" : str11, (i & 4096) != 0 ? "" : str12, (i & 8192) != 0 ? "" : str13, (i & 16384) != 0 ? "" : str14, obj);
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "getPocketId")
        public final String getPocketId() {
            return this.pocketId;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "setPocketId")
        public final void setPocketId(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.pocketId = str;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "getPocketStatus")
        public final String getPocketStatus() {
            return this.pocketStatus;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "setPocketStatus")
        public final void setPocketStatus(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.pocketStatus = str;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "getIconUrl")
        public final String getIconUrl() {
            return this.iconUrl;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "setIconUrl")
        public final void setIconUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.iconUrl = str;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "getBackgroundUrl")
        public final String getBackgroundUrl() {
            return this.backgroundUrl;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "setBackgroundUrl")
        public final void setBackgroundUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.backgroundUrl = str;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "getPocketType")
        public final String getPocketType() {
            return this.pocketType;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "setPocketType")
        public final void setPocketType(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.pocketType = str;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "getCacheTimestamp")
        public final long getCacheTimestamp() {
            return this.cacheTimestamp;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "setCacheTimestamp")
        public final void setCacheTimestamp(long j) {
            this.cacheTimestamp = j;
        }

        @JvmName(name = "getCreatedDate")
        public final String getCreatedDate() {
            return this.createdDate;
        }

        @JvmName(name = "setCreatedDate")
        public final void setCreatedDate(String str) {
            this.createdDate = str;
        }

        @JvmName(name = "getLogoUrl")
        public final String getLogoUrl() {
            return this.logoUrl;
        }

        @JvmName(name = "setLogoUrl")
        public final void setLogoUrl(String str) {
            this.logoUrl = str;
        }

        @JvmName(name = "getTicketId")
        public final String getTicketId() {
            return this.ticketId;
        }

        @JvmName(name = "setTicketId")
        public final void setTicketId(String str) {
            this.ticketId = str;
        }

        @JvmName(name = "getMerchantId")
        public final String getMerchantId() {
            return this.merchantId;
        }

        @JvmName(name = "setMerchantId")
        public final void setMerchantId(String str) {
            this.merchantId = str;
        }

        @JvmName(name = "getLocation")
        public final String getLocation() {
            return this.location;
        }

        @JvmName(name = "setLocation")
        public final void setLocation(String str) {
            this.location = str;
        }

        @JvmName(name = "getBenefit")
        public final String getBenefit() {
            return this.benefit;
        }

        @JvmName(name = "setBenefit")
        public final void setBenefit(String str) {
            this.benefit = str;
        }

        @JvmName(name = "getEnterTime")
        public final String getEnterTime() {
            return this.enterTime;
        }

        @JvmName(name = "setEnterTime")
        public final void setEnterTime(String str) {
            this.enterTime = str;
        }

        @JvmName(name = "getQrUrl")
        public final String getQrUrl() {
            return this.qrUrl;
        }

        @JvmName(name = "setQrUrl")
        public final void setQrUrl(String str) {
            this.qrUrl = str;
        }

        @JvmName(name = "getMerchantName")
        public final String getMerchantName() {
            return this.merchantName;
        }

        @JvmName(name = "setMerchantName")
        public final void setMerchantName(String str) {
            this.merchantName = str;
        }

        @JvmName(name = "getOther")
        public final Object getOther() {
            return this.other;
        }

        @JvmName(name = "setOther")
        public final void setOther(Object obj) {
            this.other = obj;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UserParkingTicketAsset(String str, String str2, String str3, String str4, String str5, long j, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, Object obj) {
            super(str, str2, str3, str4, str5, j, null);
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str3, "");
            Intrinsics.checkNotNullParameter(str4, "");
            Intrinsics.checkNotNullParameter(str5, "");
            this.pocketId = str;
            this.pocketStatus = str2;
            this.iconUrl = str3;
            this.backgroundUrl = str4;
            this.pocketType = str5;
            this.cacheTimestamp = j;
            this.createdDate = str6;
            this.logoUrl = str7;
            this.ticketId = str8;
            this.merchantId = str9;
            this.location = str10;
            this.benefit = str11;
            this.enterTime = str12;
            this.qrUrl = str13;
            this.merchantName = str14;
            this.other = obj;
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b'\b\u0086\b\u0018\u00002\u00020\u0001B\u009f\u0001\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0002\u0012\b\b\u0002\u0010 \u001a\u00020\u0002\u0012\b\b\u0002\u0010!\u001a\u00020\u0002\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0002\u0012\u000e\b\u0002\u0010#\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\bR\u0010SJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0004J\u0010\u0010\u0015\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0004J\u0010\u0010\u0016\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0004J¨\u0001\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u00022\b\b\u0002\u0010\u001c\u001a\u00020\u00112\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u001e\u001a\u00020\u00022\b\b\u0002\u0010\u001f\u001a\u00020\u00022\b\b\u0002\u0010 \u001a\u00020\u00022\b\b\u0002\u0010!\u001a\u00020\u00022\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00022\u000e\b\u0002\u0010#\u001a\b\u0012\u0004\u0012\u00020\t0\b2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b%\u0010&J\u001a\u0010*\u001a\u00020)2\b\u0010(\u001a\u0004\u0018\u00010'HÖ\u0003¢\u0006\u0004\b*\u0010+J\u0010\u0010-\u001a\u00020,HÖ\u0001¢\u0006\u0004\b-\u0010.J\u0010\u0010/\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b/\u0010\u0004R\"\u0010\u001a\u001a\u00020\u00028\u0017@\u0017X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001a\u00100\u001a\u0004\b1\u0010\u0004\"\u0004\b2\u00103R\"\u0010\u001c\u001a\u00020\u00118\u0017@\u0017X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001c\u00104\u001a\u0004\b5\u0010\u0013\"\u0004\b6\u00107R\"\u0010 \u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b \u00100\u001a\u0004\b8\u0010\u0004\"\u0004\b9\u00103R(\u0010#\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010:\u001a\u0004\b;\u0010\u000b\"\u0004\b<\u0010=R$\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u00100\u001a\u0004\b>\u0010\u0004\"\u0004\b?\u00103R\"\u0010\u0019\u001a\u00020\u00028\u0017@\u0017X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0019\u00100\u001a\u0004\b@\u0010\u0004\"\u0004\bA\u00103R\"\u0010!\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u00100\u001a\u0004\bB\u0010\u0004\"\u0004\bC\u00103R$\u0010\"\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u00100\u001a\u0004\bD\u0010\u0004\"\u0004\bE\u00103R\"\u0010\u001f\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u00100\u001a\u0004\bF\u0010\u0004\"\u0004\bG\u00103R\"\u0010\u0017\u001a\u00020\u00028\u0017@\u0017X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0017\u00100\u001a\u0004\bH\u0010\u0004\"\u0004\bI\u00103R\"\u0010\u0018\u001a\u00020\u00028\u0017@\u0017X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0018\u00100\u001a\u0004\bJ\u0010\u0004\"\u0004\bK\u00103R\"\u0010\u001b\u001a\u00020\u00028\u0017@\u0017X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001b\u00100\u001a\u0004\bL\u0010\u0004\"\u0004\bM\u00103R\"\u0010\u001e\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u00100\u001a\u0004\bN\u0010\u0004\"\u0004\bO\u00103R$\u0010$\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u00100\u001a\u0004\bP\u0010\u0004\"\u0004\bQ\u00103"}, d2 = {"Lid/dana/domain/wallet_v3/model/UserPocketAssetModel$UserLoyaltyAsset;", "Lid/dana/domain/wallet_v3/model/UserPocketAssetModel;", "", "component1", "()Ljava/lang/String;", "component10", "component11", "component12", "", "Lid/dana/domain/pocket/model/AssetCategory;", "component13", "()Ljava/util/List;", "component14", "component2", "component3", "component4", "component5", "", "component6", "()J", "component7", "component8", "component9", "pocketId", "pocketStatus", "iconUrl", "backgroundUrl", "pocketType", "cacheTimestamp", "createdDate", "point", "merchantName", "cardNumber", DecodedScanBizInfoKey.LOGO_URL, "merchantId", "categories", "userPocketStatus", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)Lid/dana/domain/wallet_v3/model/UserPocketAssetModel$UserLoyaltyAsset;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getBackgroundUrl", "setBackgroundUrl", "(Ljava/lang/String;)V", "J", "getCacheTimestamp", "setCacheTimestamp", "(J)V", "getCardNumber", "setCardNumber", "Ljava/util/List;", "getCategories", "setCategories", "(Ljava/util/List;)V", "getCreatedDate", "setCreatedDate", "getIconUrl", "setIconUrl", "getLogoUrl", "setLogoUrl", "getMerchantId", "setMerchantId", "getMerchantName", "setMerchantName", "getPocketId", "setPocketId", "getPocketStatus", "setPocketStatus", "getPocketType", "setPocketType", "getPoint", "setPoint", "getUserPocketStatus", "setUserPocketStatus", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class UserLoyaltyAsset extends UserPocketAssetModel {
        private String backgroundUrl;
        private long cacheTimestamp;
        private String cardNumber;
        private List<AssetCategory> categories;
        private String createdDate;
        private String iconUrl;
        private String logoUrl;
        private String merchantId;
        private String merchantName;
        private String pocketId;
        private String pocketStatus;
        private String pocketType;
        private String point;
        private String userPocketStatus;

        public UserLoyaltyAsset() {
            this(null, null, null, null, null, 0L, null, null, null, null, null, null, null, null, 16383, null);
        }

        public final String component1() {
            return getPocketId();
        }

        /* renamed from: component10  reason: from getter */
        public final String getCardNumber() {
            return this.cardNumber;
        }

        /* renamed from: component11  reason: from getter */
        public final String getLogoUrl() {
            return this.logoUrl;
        }

        /* renamed from: component12  reason: from getter */
        public final String getMerchantId() {
            return this.merchantId;
        }

        public final List<AssetCategory> component13() {
            return this.categories;
        }

        /* renamed from: component14  reason: from getter */
        public final String getUserPocketStatus() {
            return this.userPocketStatus;
        }

        public final String component2() {
            return getPocketStatus();
        }

        public final String component3() {
            return getIconUrl();
        }

        public final String component4() {
            return getBackgroundUrl();
        }

        public final String component5() {
            return getPocketType();
        }

        public final long component6() {
            return getCacheTimestamp();
        }

        /* renamed from: component7  reason: from getter */
        public final String getCreatedDate() {
            return this.createdDate;
        }

        /* renamed from: component8  reason: from getter */
        public final String getPoint() {
            return this.point;
        }

        /* renamed from: component9  reason: from getter */
        public final String getMerchantName() {
            return this.merchantName;
        }

        public final UserLoyaltyAsset copy(String pocketId, String pocketStatus, String iconUrl, String backgroundUrl, String pocketType, long cacheTimestamp, String createdDate, String point, String merchantName, String cardNumber, String logoUrl, String merchantId, List<AssetCategory> categories, String userPocketStatus) {
            Intrinsics.checkNotNullParameter(pocketId, "");
            Intrinsics.checkNotNullParameter(pocketStatus, "");
            Intrinsics.checkNotNullParameter(iconUrl, "");
            Intrinsics.checkNotNullParameter(backgroundUrl, "");
            Intrinsics.checkNotNullParameter(pocketType, "");
            Intrinsics.checkNotNullParameter(point, "");
            Intrinsics.checkNotNullParameter(merchantName, "");
            Intrinsics.checkNotNullParameter(cardNumber, "");
            Intrinsics.checkNotNullParameter(logoUrl, "");
            Intrinsics.checkNotNullParameter(categories, "");
            return new UserLoyaltyAsset(pocketId, pocketStatus, iconUrl, backgroundUrl, pocketType, cacheTimestamp, createdDate, point, merchantName, cardNumber, logoUrl, merchantId, categories, userPocketStatus);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof UserLoyaltyAsset) {
                UserLoyaltyAsset userLoyaltyAsset = (UserLoyaltyAsset) other;
                return Intrinsics.areEqual(getPocketId(), userLoyaltyAsset.getPocketId()) && Intrinsics.areEqual(getPocketStatus(), userLoyaltyAsset.getPocketStatus()) && Intrinsics.areEqual(getIconUrl(), userLoyaltyAsset.getIconUrl()) && Intrinsics.areEqual(getBackgroundUrl(), userLoyaltyAsset.getBackgroundUrl()) && Intrinsics.areEqual(getPocketType(), userLoyaltyAsset.getPocketType()) && getCacheTimestamp() == userLoyaltyAsset.getCacheTimestamp() && Intrinsics.areEqual(this.createdDate, userLoyaltyAsset.createdDate) && Intrinsics.areEqual(this.point, userLoyaltyAsset.point) && Intrinsics.areEqual(this.merchantName, userLoyaltyAsset.merchantName) && Intrinsics.areEqual(this.cardNumber, userLoyaltyAsset.cardNumber) && Intrinsics.areEqual(this.logoUrl, userLoyaltyAsset.logoUrl) && Intrinsics.areEqual(this.merchantId, userLoyaltyAsset.merchantId) && Intrinsics.areEqual(this.categories, userLoyaltyAsset.categories) && Intrinsics.areEqual(this.userPocketStatus, userLoyaltyAsset.userPocketStatus);
            }
            return false;
        }

        public final int hashCode() {
            int hashCode = getPocketId().hashCode();
            int hashCode2 = getPocketStatus().hashCode();
            int hashCode3 = getIconUrl().hashCode();
            int hashCode4 = getBackgroundUrl().hashCode();
            int hashCode5 = getPocketType().hashCode();
            int m = Cbor$Arg$$ExternalSyntheticBackport0.m(getCacheTimestamp());
            String str = this.createdDate;
            int hashCode6 = str == null ? 0 : str.hashCode();
            int hashCode7 = this.point.hashCode();
            int hashCode8 = this.merchantName.hashCode();
            int hashCode9 = this.cardNumber.hashCode();
            int hashCode10 = this.logoUrl.hashCode();
            String str2 = this.merchantId;
            int hashCode11 = str2 == null ? 0 : str2.hashCode();
            int hashCode12 = this.categories.hashCode();
            String str3 = this.userPocketStatus;
            return (((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + m) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + (str3 != null ? str3.hashCode() : 0);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("UserLoyaltyAsset(pocketId=");
            sb.append(getPocketId());
            sb.append(", pocketStatus=");
            sb.append(getPocketStatus());
            sb.append(", iconUrl=");
            sb.append(getIconUrl());
            sb.append(", backgroundUrl=");
            sb.append(getBackgroundUrl());
            sb.append(", pocketType=");
            sb.append(getPocketType());
            sb.append(", cacheTimestamp=");
            sb.append(getCacheTimestamp());
            sb.append(", createdDate=");
            sb.append(this.createdDate);
            sb.append(", point=");
            sb.append(this.point);
            sb.append(", merchantName=");
            sb.append(this.merchantName);
            sb.append(", cardNumber=");
            sb.append(this.cardNumber);
            sb.append(", logoUrl=");
            sb.append(this.logoUrl);
            sb.append(", merchantId=");
            sb.append(this.merchantId);
            sb.append(", categories=");
            sb.append(this.categories);
            sb.append(", userPocketStatus=");
            sb.append(this.userPocketStatus);
            sb.append(')');
            return sb.toString();
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "getPocketId")
        public final String getPocketId() {
            return this.pocketId;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "setPocketId")
        public final void setPocketId(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.pocketId = str;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "getPocketStatus")
        public final String getPocketStatus() {
            return this.pocketStatus;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "setPocketStatus")
        public final void setPocketStatus(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.pocketStatus = str;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "getIconUrl")
        public final String getIconUrl() {
            return this.iconUrl;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "setIconUrl")
        public final void setIconUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.iconUrl = str;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "getBackgroundUrl")
        public final String getBackgroundUrl() {
            return this.backgroundUrl;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "setBackgroundUrl")
        public final void setBackgroundUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.backgroundUrl = str;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "getPocketType")
        public final String getPocketType() {
            return this.pocketType;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "setPocketType")
        public final void setPocketType(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.pocketType = str;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "getCacheTimestamp")
        public final long getCacheTimestamp() {
            return this.cacheTimestamp;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "setCacheTimestamp")
        public final void setCacheTimestamp(long j) {
            this.cacheTimestamp = j;
        }

        @JvmName(name = "getCreatedDate")
        public final String getCreatedDate() {
            return this.createdDate;
        }

        @JvmName(name = "setCreatedDate")
        public final void setCreatedDate(String str) {
            this.createdDate = str;
        }

        @JvmName(name = "getPoint")
        public final String getPoint() {
            return this.point;
        }

        @JvmName(name = "setPoint")
        public final void setPoint(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.point = str;
        }

        @JvmName(name = "getMerchantName")
        public final String getMerchantName() {
            return this.merchantName;
        }

        @JvmName(name = "setMerchantName")
        public final void setMerchantName(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.merchantName = str;
        }

        @JvmName(name = "getCardNumber")
        public final String getCardNumber() {
            return this.cardNumber;
        }

        @JvmName(name = "setCardNumber")
        public final void setCardNumber(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.cardNumber = str;
        }

        @JvmName(name = "getLogoUrl")
        public final String getLogoUrl() {
            return this.logoUrl;
        }

        @JvmName(name = "setLogoUrl")
        public final void setLogoUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.logoUrl = str;
        }

        @JvmName(name = "getMerchantId")
        public final String getMerchantId() {
            return this.merchantId;
        }

        @JvmName(name = "setMerchantId")
        public final void setMerchantId(String str) {
            this.merchantId = str;
        }

        public /* synthetic */ UserLoyaltyAsset(String str, String str2, String str3, String str4, String str5, long j, String str6, String str7, String str8, String str9, String str10, String str11, List list, String str12, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? -1L : j, (i & 64) != 0 ? "" : str6, (i & 128) != 0 ? "" : str7, (i & 256) != 0 ? "" : str8, (i & 512) != 0 ? "" : str9, (i & 1024) != 0 ? "" : str10, (i & 2048) != 0 ? "" : str11, (i & 4096) != 0 ? CollectionsKt.emptyList() : list, (i & 8192) == 0 ? str12 : "");
        }

        @JvmName(name = "getCategories")
        public final List<AssetCategory> getCategories() {
            return this.categories;
        }

        @JvmName(name = "setCategories")
        public final void setCategories(List<AssetCategory> list) {
            Intrinsics.checkNotNullParameter(list, "");
            this.categories = list;
        }

        @JvmName(name = "getUserPocketStatus")
        public final String getUserPocketStatus() {
            return this.userPocketStatus;
        }

        @JvmName(name = "setUserPocketStatus")
        public final void setUserPocketStatus(String str) {
            this.userPocketStatus = str;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UserLoyaltyAsset(String str, String str2, String str3, String str4, String str5, long j, String str6, String str7, String str8, String str9, String str10, String str11, List<AssetCategory> list, String str12) {
            super(str, str2, str3, str4, str5, j, null);
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str3, "");
            Intrinsics.checkNotNullParameter(str4, "");
            Intrinsics.checkNotNullParameter(str5, "");
            Intrinsics.checkNotNullParameter(str7, "");
            Intrinsics.checkNotNullParameter(str8, "");
            Intrinsics.checkNotNullParameter(str9, "");
            Intrinsics.checkNotNullParameter(str10, "");
            Intrinsics.checkNotNullParameter(list, "");
            this.pocketId = str;
            this.pocketStatus = str2;
            this.iconUrl = str3;
            this.backgroundUrl = str4;
            this.pocketType = str5;
            this.cacheTimestamp = j;
            this.createdDate = str6;
            this.point = str7;
            this.merchantName = str8;
            this.cardNumber = str9;
            this.logoUrl = str10;
            this.merchantId = str11;
            this.categories = list;
            this.userPocketStatus = str12;
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u001c\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b5\b\u0086\b\u0018\u00002\u00020\u0001B÷\u0001\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0002\u0012\b\b\u0002\u0010 \u001a\u00020\u0002\u0012\b\b\u0002\u0010!\u001a\u00020\u0002\u0012\b\b\u0002\u0010\"\u001a\u00020\u0016\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0002\u0012\u0016\b\u0002\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\r\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\bk\u0010lJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u001e\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0004J\u0010\u0010\u0015\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0004J\u0010\u0010\u0017\u001a\u00020\u0016HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0004J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0004J\u0080\u0002\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u001d\u001a\u00020\u00022\b\b\u0002\u0010\u001e\u001a\u00020\u00022\b\b\u0002\u0010\u001f\u001a\u00020\u00022\b\b\u0002\u0010 \u001a\u00020\u00022\b\b\u0002\u0010!\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020\u00162\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00022\u0016\b\u0002\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\r2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b1\u00102J\u001a\u00105\u001a\u0002042\b\u0010.\u001a\u0004\u0018\u000103HÖ\u0003¢\u0006\u0004\b5\u00106J\u0010\u00108\u001a\u000207HÖ\u0001¢\u0006\u0004\b8\u00109J\u0010\u0010:\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b:\u0010\u0004R\"\u0010 \u001a\u00020\u00028\u0017@\u0017X\u0096\u000e¢\u0006\u0012\n\u0004\b \u0010;\u001a\u0004\b<\u0010\u0004\"\u0004\b=\u0010>R$\u0010-\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010;\u001a\u0004\b?\u0010\u0004\"\u0004\b@\u0010>R\"\u0010\"\u001a\u00020\u00168\u0017@\u0017X\u0097\u000e¢\u0006\u0012\n\u0004\b\"\u0010A\u001a\u0004\bB\u0010\u0018\"\u0004\bC\u0010DR$\u0010#\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010;\u001a\u0004\bE\u0010\u0004\"\u0004\bF\u0010>R$\u0010$\u001a\u0004\u0018\u00010\u00168\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010G\u001a\u0004\bH\u0010\u001b\"\u0004\bI\u0010JR\"\u0010\u001f\u001a\u00020\u00028\u0017@\u0017X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010;\u001a\u0004\bK\u0010\u0004\"\u0004\bL\u0010>R$\u0010%\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010;\u001a\u0004\bM\u0010\u0004\"\u0004\bN\u0010>R$\u0010/\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u0010;\u001a\u0004\bO\u0010\u0004\"\u0004\bP\u0010>R$\u0010,\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010;\u001a\u0004\bQ\u0010\u0004\"\u0004\bR\u0010>R0\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\r8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010S\u001a\u0004\bT\u0010\u000f\"\u0004\bU\u0010VR\"\u0010\u001d\u001a\u00020\u00028\u0017@\u0017X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010;\u001a\u0004\bW\u0010\u0004\"\u0004\bX\u0010>R\"\u0010\u001e\u001a\u00020\u00028\u0017@\u0017X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010;\u001a\u0004\bY\u0010\u0004\"\u0004\bZ\u0010>R\"\u0010!\u001a\u00020\u00028\u0017@\u0017X\u0097\u000e¢\u0006\u0012\n\u0004\b!\u0010;\u001a\u0004\b[\u0010\u0004\"\u0004\b\\\u0010>R$\u0010+\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010;\u001a\u0004\b]\u0010\u0004\"\u0004\b^\u0010>R$\u00100\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u0010;\u001a\u0004\b_\u0010\u0004\"\u0004\b`\u0010>R$\u0010(\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010;\u001a\u0004\ba\u0010\u0004\"\u0004\bb\u0010>R$\u0010'\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010;\u001a\u0004\bc\u0010\u0004\"\u0004\bd\u0010>R$\u0010)\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010;\u001a\u0004\be\u0010\u0004\"\u0004\bf\u0010>R$\u0010*\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010;\u001a\u0004\bg\u0010\u0004\"\u0004\bh\u0010>R$\u0010&\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010;\u001a\u0004\bi\u0010\u0004\"\u0004\bj\u0010>"}, d2 = {"Lid/dana/domain/wallet_v3/model/UserPocketAssetModel$UserMovieTicketAsset;", "Lid/dana/domain/wallet_v3/model/UserPocketAssetModel;", "", "component1", "()Ljava/lang/String;", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "", "component18", "()Ljava/util/Map;", "component19", "component2", "component20", "component3", "component4", "component5", "", "component6", "()J", "component7", "component8", "()Ljava/lang/Long;", "component9", "pocketId", "pocketStatus", "iconUrl", "backgroundUrl", "pocketType", "cacheTimestamp", "createdDate", "expirationDate", BridgeName.LOCATION_NAME, "ticketClass", "showName", "seatNumber", "showTime", "studioNumber", "posterUrl", "merchantId", "bizType", "other", DecodedScanBizInfoKey.LOGO_URL, "primaryCTA", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/wallet_v3/model/UserPocketAssetModel$UserMovieTicketAsset;", "", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getBackgroundUrl", "setBackgroundUrl", "(Ljava/lang/String;)V", "getBizType", "setBizType", "J", "getCacheTimestamp", "setCacheTimestamp", "(J)V", "getCreatedDate", "setCreatedDate", "Ljava/lang/Long;", "getExpirationDate", "setExpirationDate", "(Ljava/lang/Long;)V", "getIconUrl", "setIconUrl", "getLocationName", "setLocationName", "getLogoUrl", "setLogoUrl", "getMerchantId", "setMerchantId", "Ljava/util/Map;", "getOther", "setOther", "(Ljava/util/Map;)V", "getPocketId", "setPocketId", "getPocketStatus", "setPocketStatus", "getPocketType", "setPocketType", "getPosterUrl", "setPosterUrl", "getPrimaryCTA", "setPrimaryCTA", "getSeatNumber", "setSeatNumber", "getShowName", "setShowName", "getShowTime", "setShowTime", "getStudioNumber", "setStudioNumber", "getTicketClass", "setTicketClass", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class UserMovieTicketAsset extends UserPocketAssetModel {
        private String backgroundUrl;
        private String bizType;
        private long cacheTimestamp;
        private String createdDate;
        private Long expirationDate;
        private String iconUrl;
        private String locationName;
        private String logoUrl;
        private String merchantId;
        private Map<String, String> other;
        private String pocketId;
        private String pocketStatus;
        private String pocketType;
        private String posterUrl;
        private String primaryCTA;
        private String seatNumber;
        private String showName;
        private String showTime;
        private String studioNumber;
        private String ticketClass;

        public UserMovieTicketAsset() {
            this(null, null, null, null, null, 0L, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 1048575, null);
        }

        public final String component1() {
            return getPocketId();
        }

        /* renamed from: component10  reason: from getter */
        public final String getTicketClass() {
            return this.ticketClass;
        }

        /* renamed from: component11  reason: from getter */
        public final String getShowName() {
            return this.showName;
        }

        /* renamed from: component12  reason: from getter */
        public final String getSeatNumber() {
            return this.seatNumber;
        }

        /* renamed from: component13  reason: from getter */
        public final String getShowTime() {
            return this.showTime;
        }

        /* renamed from: component14  reason: from getter */
        public final String getStudioNumber() {
            return this.studioNumber;
        }

        /* renamed from: component15  reason: from getter */
        public final String getPosterUrl() {
            return this.posterUrl;
        }

        /* renamed from: component16  reason: from getter */
        public final String getMerchantId() {
            return this.merchantId;
        }

        /* renamed from: component17  reason: from getter */
        public final String getBizType() {
            return this.bizType;
        }

        public final Map<String, String> component18() {
            return this.other;
        }

        /* renamed from: component19  reason: from getter */
        public final String getLogoUrl() {
            return this.logoUrl;
        }

        public final String component2() {
            return getPocketStatus();
        }

        /* renamed from: component20  reason: from getter */
        public final String getPrimaryCTA() {
            return this.primaryCTA;
        }

        public final String component3() {
            return getIconUrl();
        }

        public final String component4() {
            return getBackgroundUrl();
        }

        public final String component5() {
            return getPocketType();
        }

        public final long component6() {
            return getCacheTimestamp();
        }

        /* renamed from: component7  reason: from getter */
        public final String getCreatedDate() {
            return this.createdDate;
        }

        /* renamed from: component8  reason: from getter */
        public final Long getExpirationDate() {
            return this.expirationDate;
        }

        /* renamed from: component9  reason: from getter */
        public final String getLocationName() {
            return this.locationName;
        }

        public final UserMovieTicketAsset copy(String pocketId, String pocketStatus, String iconUrl, String backgroundUrl, String pocketType, long cacheTimestamp, String createdDate, Long expirationDate, String locationName, String ticketClass, String showName, String seatNumber, String showTime, String studioNumber, String posterUrl, String merchantId, String bizType, Map<String, String> other, String logoUrl, String primaryCTA) {
            Intrinsics.checkNotNullParameter(pocketId, "");
            Intrinsics.checkNotNullParameter(pocketStatus, "");
            Intrinsics.checkNotNullParameter(iconUrl, "");
            Intrinsics.checkNotNullParameter(backgroundUrl, "");
            Intrinsics.checkNotNullParameter(pocketType, "");
            return new UserMovieTicketAsset(pocketId, pocketStatus, iconUrl, backgroundUrl, pocketType, cacheTimestamp, createdDate, expirationDate, locationName, ticketClass, showName, seatNumber, showTime, studioNumber, posterUrl, merchantId, bizType, other, logoUrl, primaryCTA);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof UserMovieTicketAsset) {
                UserMovieTicketAsset userMovieTicketAsset = (UserMovieTicketAsset) other;
                return Intrinsics.areEqual(getPocketId(), userMovieTicketAsset.getPocketId()) && Intrinsics.areEqual(getPocketStatus(), userMovieTicketAsset.getPocketStatus()) && Intrinsics.areEqual(getIconUrl(), userMovieTicketAsset.getIconUrl()) && Intrinsics.areEqual(getBackgroundUrl(), userMovieTicketAsset.getBackgroundUrl()) && Intrinsics.areEqual(getPocketType(), userMovieTicketAsset.getPocketType()) && getCacheTimestamp() == userMovieTicketAsset.getCacheTimestamp() && Intrinsics.areEqual(this.createdDate, userMovieTicketAsset.createdDate) && Intrinsics.areEqual(this.expirationDate, userMovieTicketAsset.expirationDate) && Intrinsics.areEqual(this.locationName, userMovieTicketAsset.locationName) && Intrinsics.areEqual(this.ticketClass, userMovieTicketAsset.ticketClass) && Intrinsics.areEqual(this.showName, userMovieTicketAsset.showName) && Intrinsics.areEqual(this.seatNumber, userMovieTicketAsset.seatNumber) && Intrinsics.areEqual(this.showTime, userMovieTicketAsset.showTime) && Intrinsics.areEqual(this.studioNumber, userMovieTicketAsset.studioNumber) && Intrinsics.areEqual(this.posterUrl, userMovieTicketAsset.posterUrl) && Intrinsics.areEqual(this.merchantId, userMovieTicketAsset.merchantId) && Intrinsics.areEqual(this.bizType, userMovieTicketAsset.bizType) && Intrinsics.areEqual(this.other, userMovieTicketAsset.other) && Intrinsics.areEqual(this.logoUrl, userMovieTicketAsset.logoUrl) && Intrinsics.areEqual(this.primaryCTA, userMovieTicketAsset.primaryCTA);
            }
            return false;
        }

        public final int hashCode() {
            int hashCode = getPocketId().hashCode();
            int hashCode2 = getPocketStatus().hashCode();
            int hashCode3 = getIconUrl().hashCode();
            int hashCode4 = getBackgroundUrl().hashCode();
            int hashCode5 = getPocketType().hashCode();
            int m = Cbor$Arg$$ExternalSyntheticBackport0.m(getCacheTimestamp());
            String str = this.createdDate;
            int hashCode6 = str == null ? 0 : str.hashCode();
            Long l = this.expirationDate;
            int hashCode7 = l == null ? 0 : l.hashCode();
            String str2 = this.locationName;
            int hashCode8 = str2 == null ? 0 : str2.hashCode();
            String str3 = this.ticketClass;
            int hashCode9 = str3 == null ? 0 : str3.hashCode();
            String str4 = this.showName;
            int hashCode10 = str4 == null ? 0 : str4.hashCode();
            String str5 = this.seatNumber;
            int hashCode11 = str5 == null ? 0 : str5.hashCode();
            String str6 = this.showTime;
            int hashCode12 = str6 == null ? 0 : str6.hashCode();
            String str7 = this.studioNumber;
            int hashCode13 = str7 == null ? 0 : str7.hashCode();
            String str8 = this.posterUrl;
            int hashCode14 = str8 == null ? 0 : str8.hashCode();
            String str9 = this.merchantId;
            int hashCode15 = str9 == null ? 0 : str9.hashCode();
            String str10 = this.bizType;
            int hashCode16 = str10 == null ? 0 : str10.hashCode();
            Map<String, String> map = this.other;
            int hashCode17 = map == null ? 0 : map.hashCode();
            String str11 = this.logoUrl;
            int hashCode18 = str11 == null ? 0 : str11.hashCode();
            String str12 = this.primaryCTA;
            return (((((((((((((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + m) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + hashCode14) * 31) + hashCode15) * 31) + hashCode16) * 31) + hashCode17) * 31) + hashCode18) * 31) + (str12 != null ? str12.hashCode() : 0);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("UserMovieTicketAsset(pocketId=");
            sb.append(getPocketId());
            sb.append(", pocketStatus=");
            sb.append(getPocketStatus());
            sb.append(", iconUrl=");
            sb.append(getIconUrl());
            sb.append(", backgroundUrl=");
            sb.append(getBackgroundUrl());
            sb.append(", pocketType=");
            sb.append(getPocketType());
            sb.append(", cacheTimestamp=");
            sb.append(getCacheTimestamp());
            sb.append(", createdDate=");
            sb.append(this.createdDate);
            sb.append(", expirationDate=");
            sb.append(this.expirationDate);
            sb.append(", locationName=");
            sb.append(this.locationName);
            sb.append(", ticketClass=");
            sb.append(this.ticketClass);
            sb.append(", showName=");
            sb.append(this.showName);
            sb.append(", seatNumber=");
            sb.append(this.seatNumber);
            sb.append(", showTime=");
            sb.append(this.showTime);
            sb.append(", studioNumber=");
            sb.append(this.studioNumber);
            sb.append(", posterUrl=");
            sb.append(this.posterUrl);
            sb.append(", merchantId=");
            sb.append(this.merchantId);
            sb.append(", bizType=");
            sb.append(this.bizType);
            sb.append(", other=");
            sb.append(this.other);
            sb.append(", logoUrl=");
            sb.append(this.logoUrl);
            sb.append(", primaryCTA=");
            sb.append(this.primaryCTA);
            sb.append(')');
            return sb.toString();
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "getPocketId")
        public final String getPocketId() {
            return this.pocketId;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "setPocketId")
        public final void setPocketId(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.pocketId = str;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "getPocketStatus")
        public final String getPocketStatus() {
            return this.pocketStatus;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "setPocketStatus")
        public final void setPocketStatus(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.pocketStatus = str;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "getIconUrl")
        public final String getIconUrl() {
            return this.iconUrl;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "setIconUrl")
        public final void setIconUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.iconUrl = str;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "getBackgroundUrl")
        public final String getBackgroundUrl() {
            return this.backgroundUrl;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "setBackgroundUrl")
        public final void setBackgroundUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.backgroundUrl = str;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "getPocketType")
        public final String getPocketType() {
            return this.pocketType;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "setPocketType")
        public final void setPocketType(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.pocketType = str;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "getCacheTimestamp")
        public final long getCacheTimestamp() {
            return this.cacheTimestamp;
        }

        @Override // id.dana.domain.wallet_v3.model.UserPocketAssetModel
        @JvmName(name = "setCacheTimestamp")
        public final void setCacheTimestamp(long j) {
            this.cacheTimestamp = j;
        }

        @JvmName(name = "getCreatedDate")
        public final String getCreatedDate() {
            return this.createdDate;
        }

        @JvmName(name = "setCreatedDate")
        public final void setCreatedDate(String str) {
            this.createdDate = str;
        }

        public /* synthetic */ UserMovieTicketAsset(String str, String str2, String str3, String str4, String str5, long j, String str6, Long l, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, Map map, String str16, String str17, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? -1L : j, (i & 64) != 0 ? "" : str6, (i & 128) != 0 ? -1L : l, (i & 256) != 0 ? "" : str7, (i & 512) != 0 ? "" : str8, (i & 1024) != 0 ? "" : str9, (i & 2048) != 0 ? "" : str10, (i & 4096) != 0 ? "" : str11, (i & 8192) != 0 ? "" : str12, (i & 16384) != 0 ? "" : str13, (i & 32768) != 0 ? "" : str14, (i & 65536) != 0 ? "" : str15, (i & AntDetector.SCENE_ID_LOGIN_REGIST) != 0 ? null : map, (i & 262144) != 0 ? "" : str16, (i & 524288) != 0 ? "" : str17);
        }

        @JvmName(name = "getExpirationDate")
        public final Long getExpirationDate() {
            return this.expirationDate;
        }

        @JvmName(name = "setExpirationDate")
        public final void setExpirationDate(Long l) {
            this.expirationDate = l;
        }

        @JvmName(name = "getLocationName")
        public final String getLocationName() {
            return this.locationName;
        }

        @JvmName(name = "setLocationName")
        public final void setLocationName(String str) {
            this.locationName = str;
        }

        @JvmName(name = "getTicketClass")
        public final String getTicketClass() {
            return this.ticketClass;
        }

        @JvmName(name = "setTicketClass")
        public final void setTicketClass(String str) {
            this.ticketClass = str;
        }

        @JvmName(name = "getShowName")
        public final String getShowName() {
            return this.showName;
        }

        @JvmName(name = "setShowName")
        public final void setShowName(String str) {
            this.showName = str;
        }

        @JvmName(name = "getSeatNumber")
        public final String getSeatNumber() {
            return this.seatNumber;
        }

        @JvmName(name = "setSeatNumber")
        public final void setSeatNumber(String str) {
            this.seatNumber = str;
        }

        @JvmName(name = "getShowTime")
        public final String getShowTime() {
            return this.showTime;
        }

        @JvmName(name = "setShowTime")
        public final void setShowTime(String str) {
            this.showTime = str;
        }

        @JvmName(name = "getStudioNumber")
        public final String getStudioNumber() {
            return this.studioNumber;
        }

        @JvmName(name = "setStudioNumber")
        public final void setStudioNumber(String str) {
            this.studioNumber = str;
        }

        @JvmName(name = "getPosterUrl")
        public final String getPosterUrl() {
            return this.posterUrl;
        }

        @JvmName(name = "setPosterUrl")
        public final void setPosterUrl(String str) {
            this.posterUrl = str;
        }

        @JvmName(name = "getMerchantId")
        public final String getMerchantId() {
            return this.merchantId;
        }

        @JvmName(name = "setMerchantId")
        public final void setMerchantId(String str) {
            this.merchantId = str;
        }

        @JvmName(name = "getBizType")
        public final String getBizType() {
            return this.bizType;
        }

        @JvmName(name = "setBizType")
        public final void setBizType(String str) {
            this.bizType = str;
        }

        @JvmName(name = "getOther")
        public final Map<String, String> getOther() {
            return this.other;
        }

        @JvmName(name = "setOther")
        public final void setOther(Map<String, String> map) {
            this.other = map;
        }

        @JvmName(name = "getLogoUrl")
        public final String getLogoUrl() {
            return this.logoUrl;
        }

        @JvmName(name = "setLogoUrl")
        public final void setLogoUrl(String str) {
            this.logoUrl = str;
        }

        @JvmName(name = "getPrimaryCTA")
        public final String getPrimaryCTA() {
            return this.primaryCTA;
        }

        @JvmName(name = "setPrimaryCTA")
        public final void setPrimaryCTA(String str) {
            this.primaryCTA = str;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UserMovieTicketAsset(String str, String str2, String str3, String str4, String str5, long j, String str6, Long l, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, Map<String, String> map, String str16, String str17) {
            super(str, str2, str3, str4, str5, j, null);
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str3, "");
            Intrinsics.checkNotNullParameter(str4, "");
            Intrinsics.checkNotNullParameter(str5, "");
            this.pocketId = str;
            this.pocketStatus = str2;
            this.iconUrl = str3;
            this.backgroundUrl = str4;
            this.pocketType = str5;
            this.cacheTimestamp = j;
            this.createdDate = str6;
            this.expirationDate = l;
            this.locationName = str7;
            this.ticketClass = str8;
            this.showName = str9;
            this.seatNumber = str10;
            this.showTime = str11;
            this.studioNumber = str12;
            this.posterUrl = str13;
            this.merchantId = str14;
            this.bizType = str15;
            this.other = map;
            this.logoUrl = str16;
            this.primaryCTA = str17;
        }
    }
}
