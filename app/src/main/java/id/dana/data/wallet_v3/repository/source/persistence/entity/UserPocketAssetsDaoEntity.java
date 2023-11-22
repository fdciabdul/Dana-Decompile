package id.dana.data.wallet_v3.repository.source.persistence.entity;

import com.alipay.iap.android.aplog.util.CrashCombineUtils;
import com.alipay.mobile.security.faceauth.api.AntDetector;
import com.google.firebase.messaging.Constants;
import id.dana.domain.qrbarcode.DecodedScanBizInfoKey;
import java.util.Map;
import javax.annotation.Nonnull;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.sqlcipher.database.SQLiteDatabase;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b2\n\u0002\u0010\b\n\u0002\b*\b\u0086\b\u0018\u00002\u00020\u0001Bó\u0002\u0012\b\b\u0003\u0010'\u001a\u00020\u0002\u0012\b\b\u0002\u0010(\u001a\u00020\u0002\u0012\b\b\u0002\u0010)\u001a\u00020\u0002\u0012\b\b\u0002\u0010*\u001a\u00020\u0002\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u000e\u0012\u0016\b\u0002\u0010<\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u0002\u0012\u0016\b\u0002\u0010B\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\br\u0010sJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0004J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0004J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0010J\u001e\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0004J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0004J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0004J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0004J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0004J\u001e\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u0018J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u001f\u0010\u0010J\u0010\u0010 \u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b \u0010\u0004J\u0010\u0010!\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b!\u0010\u0004J\u0012\u0010\"\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\"\u0010\u0004J\u0012\u0010#\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b#\u0010\u0004J\u0012\u0010$\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b$\u0010\u0010J\u0012\u0010%\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b%\u0010\u0004J\u0012\u0010&\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b&\u0010\u0004Jü\u0002\u0010D\u001a\u00020\u00002\b\b\u0003\u0010'\u001a\u00020\u00022\b\b\u0002\u0010(\u001a\u00020\u00022\b\b\u0002\u0010)\u001a\u00020\u00022\b\b\u0002\u0010*\u001a\u00020\u00022\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00103\u001a\u0004\u0018\u00010\b2\n\b\u0002\u00104\u001a\u0004\u0018\u00010\b2\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u000e2\u0016\b\u0002\u0010<\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00162\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u00022\u0016\b\u0002\u0010B\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00162\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0004\bD\u0010EJ\u001a\u0010G\u001a\u00020\b2\b\u0010F\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\bG\u0010HJ\u0010\u0010J\u001a\u00020IHÖ\u0001¢\u0006\u0004\bJ\u0010KJ\u0010\u0010L\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\bL\u0010\u0004R\u0019\u0010-\u001a\u0004\u0018\u00010\u000e8\u0007¢\u0006\f\n\u0004\b-\u0010M\u001a\u0004\bN\u0010\u0010R\u001c\u0010>\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b>\u0010O\u001a\u0004\bP\u0010\u0004R\u001a\u0010*\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010O\u001a\u0004\bQ\u0010\u0004R(\u0010B\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00168\u0007X\u0087\u0004¢\u0006\f\n\u0004\bB\u0010R\u001a\u0004\bS\u0010\u0018R$\u0010C\u001a\u0004\u0018\u00010\u000e8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bC\u0010M\u001a\u0004\bT\u0010\u0010\"\u0004\bU\u0010VR\u001c\u0010A\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\bA\u0010O\u001a\u0004\bW\u0010\u0004R\u001c\u00108\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b8\u0010O\u001a\u0004\bX\u0010\u0004R\u001c\u00107\u001a\u0004\u0018\u00010\u000e8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b7\u0010M\u001a\u0004\bY\u0010\u0010R(\u0010<\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00168\u0007X\u0087\u0004¢\u0006\f\n\u0004\b<\u0010R\u001a\u0004\bZ\u0010\u0018R\u001c\u0010?\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b?\u0010O\u001a\u0004\b[\u0010\u0004R\u001c\u00105\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b5\u0010O\u001a\u0004\b\\\u0010\u0004R\u001c\u0010.\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010O\u001a\u0004\b]\u0010\u0004R\u001a\u0010)\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010O\u001a\u0004\b^\u0010\u0004R\u001c\u00100\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b0\u0010O\u001a\u0004\b_\u0010\u0004R\u001c\u00102\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b2\u0010O\u001a\u0004\b`\u0010\u0004R\u001c\u0010/\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b/\u0010O\u001a\u0004\ba\u0010\u0004R\u001c\u0010@\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b@\u0010O\u001a\u0004\bb\u0010\u0004R\"\u0010'\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010O\u001a\u0004\bc\u0010\u0004\"\u0004\bd\u0010eR\u001a\u0010(\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010O\u001a\u0004\bf\u0010\u0004R\u001c\u0010+\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010O\u001a\u0004\bg\u0010\u0004R\u001c\u0010=\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b=\u0010O\u001a\u0004\bh\u0010\u0004R\u001c\u00104\u001a\u0004\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b4\u0010i\u001a\u0004\bj\u0010\nR\u001c\u00109\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b9\u0010O\u001a\u0004\bk\u0010\u0004R\u001c\u0010:\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b:\u0010O\u001a\u0004\bl\u0010\u0004R\u001c\u0010;\u001a\u0004\u0018\u00010\u000e8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b;\u0010M\u001a\u0004\bm\u0010\u0010R\u001c\u00101\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b1\u0010O\u001a\u0004\bn\u0010\u0004R\u001c\u00106\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b6\u0010O\u001a\u0004\bo\u0010\u0004R\u001c\u00103\u001a\u0004\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b3\u0010i\u001a\u0004\bp\u0010\nR\u001c\u0010,\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010O\u001a\u0004\bq\u0010\u0004"}, d2 = {"Lid/dana/data/wallet_v3/repository/source/persistence/entity/UserPocketAssetsDaoEntity;", "", "", "component1", "()Ljava/lang/String;", "component10", "component11", "component12", "", "component13", "()Ljava/lang/Boolean;", "component14", "component15", "component16", "", "component17", "()Ljava/lang/Long;", "component18", "component19", "component2", "component20", "component21", "", "component22", "()Ljava/util/Map;", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "pocketId", "pocketStatus", "iconUrl", "backgroundUrl", "pocketType", "userPocketStatus", "activateDate", "howTo", "merchantId", Constants.ScionAnalytics.PARAM_LABEL, "subLabel", DecodedScanBizInfoKey.LOGO_URL, "usable", "shareable", "goodsId", "tcUrl", "expirationDate", "createdDate", "shareableRpcInfoReceiverInfo", "shareableRpcInfoReceiverUserId", "shareableRpcInfoSharedDate", "extendInfo", "primaryCTA", "backgroundColor", "fontColor", "minTransaction", "categoryIconUrl", "bizInfo", "cacheTimestamp", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/Long;)Lid/dana/data/wallet_v3/repository/source/persistence/entity/UserPocketAssetsDaoEntity;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/Long;", "getActivateDate", "Ljava/lang/String;", "getBackgroundColor", "getBackgroundUrl", "Ljava/util/Map;", "getBizInfo", "getCacheTimestamp", "setCacheTimestamp", "(Ljava/lang/Long;)V", "getCategoryIconUrl", "getCreatedDate", "getExpirationDate", "getExtendInfo", "getFontColor", "getGoodsId", "getHowTo", "getIconUrl", "getLabel", "getLogoUrl", "getMerchantId", "getMinTransaction", "getPocketId", "setPocketId", "(Ljava/lang/String;)V", "getPocketStatus", "getPocketType", "getPrimaryCTA", "Ljava/lang/Boolean;", "getShareable", "getShareableRpcInfoReceiverInfo", "getShareableRpcInfoReceiverUserId", "getShareableRpcInfoSharedDate", "getSubLabel", "getTcUrl", "getUsable", "getUserPocketStatus", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/Long;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class UserPocketAssetsDaoEntity {
    private final Long activateDate;
    private final String backgroundColor;
    private final String backgroundUrl;
    private final Map<String, Object> bizInfo;
    private Long cacheTimestamp;
    private final String categoryIconUrl;
    private final String createdDate;
    private final Long expirationDate;
    private final Map<String, Object> extendInfo;
    private final String fontColor;
    private final String goodsId;
    private final String howTo;
    private final String iconUrl;
    private final String label;
    private final String logoUrl;
    private final String merchantId;
    private final String minTransaction;
    private String pocketId;
    private final String pocketStatus;
    private final String pocketType;
    private final String primaryCTA;
    private final Boolean shareable;
    private final String shareableRpcInfoReceiverInfo;
    private final String shareableRpcInfoReceiverUserId;
    private final Long shareableRpcInfoSharedDate;
    private final String subLabel;
    private final String tcUrl;
    private final Boolean usable;
    private final String userPocketStatus;

    public UserPocketAssetsDaoEntity() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 536870911, null);
    }

    /* renamed from: component1  reason: from getter */
    public final String getPocketId() {
        return this.pocketId;
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
    public final String getLogoUrl() {
        return this.logoUrl;
    }

    /* renamed from: component13  reason: from getter */
    public final Boolean getUsable() {
        return this.usable;
    }

    /* renamed from: component14  reason: from getter */
    public final Boolean getShareable() {
        return this.shareable;
    }

    /* renamed from: component15  reason: from getter */
    public final String getGoodsId() {
        return this.goodsId;
    }

    /* renamed from: component16  reason: from getter */
    public final String getTcUrl() {
        return this.tcUrl;
    }

    /* renamed from: component17  reason: from getter */
    public final Long getExpirationDate() {
        return this.expirationDate;
    }

    /* renamed from: component18  reason: from getter */
    public final String getCreatedDate() {
        return this.createdDate;
    }

    /* renamed from: component19  reason: from getter */
    public final String getShareableRpcInfoReceiverInfo() {
        return this.shareableRpcInfoReceiverInfo;
    }

    /* renamed from: component2  reason: from getter */
    public final String getPocketStatus() {
        return this.pocketStatus;
    }

    /* renamed from: component20  reason: from getter */
    public final String getShareableRpcInfoReceiverUserId() {
        return this.shareableRpcInfoReceiverUserId;
    }

    /* renamed from: component21  reason: from getter */
    public final Long getShareableRpcInfoSharedDate() {
        return this.shareableRpcInfoSharedDate;
    }

    public final Map<String, Object> component22() {
        return this.extendInfo;
    }

    /* renamed from: component23  reason: from getter */
    public final String getPrimaryCTA() {
        return this.primaryCTA;
    }

    /* renamed from: component24  reason: from getter */
    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    /* renamed from: component25  reason: from getter */
    public final String getFontColor() {
        return this.fontColor;
    }

    /* renamed from: component26  reason: from getter */
    public final String getMinTransaction() {
        return this.minTransaction;
    }

    /* renamed from: component27  reason: from getter */
    public final String getCategoryIconUrl() {
        return this.categoryIconUrl;
    }

    public final Map<String, Object> component28() {
        return this.bizInfo;
    }

    /* renamed from: component29  reason: from getter */
    public final Long getCacheTimestamp() {
        return this.cacheTimestamp;
    }

    /* renamed from: component3  reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    /* renamed from: component4  reason: from getter */
    public final String getBackgroundUrl() {
        return this.backgroundUrl;
    }

    /* renamed from: component5  reason: from getter */
    public final String getPocketType() {
        return this.pocketType;
    }

    /* renamed from: component6  reason: from getter */
    public final String getUserPocketStatus() {
        return this.userPocketStatus;
    }

    /* renamed from: component7  reason: from getter */
    public final Long getActivateDate() {
        return this.activateDate;
    }

    /* renamed from: component8  reason: from getter */
    public final String getHowTo() {
        return this.howTo;
    }

    /* renamed from: component9  reason: from getter */
    public final String getMerchantId() {
        return this.merchantId;
    }

    public final UserPocketAssetsDaoEntity copy(@Nonnull String pocketId, String pocketStatus, String iconUrl, String backgroundUrl, String pocketType, String userPocketStatus, Long activateDate, String howTo, String merchantId, String label, String subLabel, String logoUrl, Boolean usable, Boolean shareable, String goodsId, String tcUrl, Long expirationDate, String createdDate, String shareableRpcInfoReceiverInfo, String shareableRpcInfoReceiverUserId, Long shareableRpcInfoSharedDate, Map<String, ? extends Object> extendInfo, String primaryCTA, String backgroundColor, String fontColor, String minTransaction, String categoryIconUrl, Map<String, ? extends Object> bizInfo, Long cacheTimestamp) {
        Intrinsics.checkNotNullParameter(pocketId, "");
        Intrinsics.checkNotNullParameter(pocketStatus, "");
        Intrinsics.checkNotNullParameter(iconUrl, "");
        Intrinsics.checkNotNullParameter(backgroundUrl, "");
        return new UserPocketAssetsDaoEntity(pocketId, pocketStatus, iconUrl, backgroundUrl, pocketType, userPocketStatus, activateDate, howTo, merchantId, label, subLabel, logoUrl, usable, shareable, goodsId, tcUrl, expirationDate, createdDate, shareableRpcInfoReceiverInfo, shareableRpcInfoReceiverUserId, shareableRpcInfoSharedDate, extendInfo, primaryCTA, backgroundColor, fontColor, minTransaction, categoryIconUrl, bizInfo, cacheTimestamp);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof UserPocketAssetsDaoEntity) {
            UserPocketAssetsDaoEntity userPocketAssetsDaoEntity = (UserPocketAssetsDaoEntity) other;
            return Intrinsics.areEqual(this.pocketId, userPocketAssetsDaoEntity.pocketId) && Intrinsics.areEqual(this.pocketStatus, userPocketAssetsDaoEntity.pocketStatus) && Intrinsics.areEqual(this.iconUrl, userPocketAssetsDaoEntity.iconUrl) && Intrinsics.areEqual(this.backgroundUrl, userPocketAssetsDaoEntity.backgroundUrl) && Intrinsics.areEqual(this.pocketType, userPocketAssetsDaoEntity.pocketType) && Intrinsics.areEqual(this.userPocketStatus, userPocketAssetsDaoEntity.userPocketStatus) && Intrinsics.areEqual(this.activateDate, userPocketAssetsDaoEntity.activateDate) && Intrinsics.areEqual(this.howTo, userPocketAssetsDaoEntity.howTo) && Intrinsics.areEqual(this.merchantId, userPocketAssetsDaoEntity.merchantId) && Intrinsics.areEqual(this.label, userPocketAssetsDaoEntity.label) && Intrinsics.areEqual(this.subLabel, userPocketAssetsDaoEntity.subLabel) && Intrinsics.areEqual(this.logoUrl, userPocketAssetsDaoEntity.logoUrl) && Intrinsics.areEqual(this.usable, userPocketAssetsDaoEntity.usable) && Intrinsics.areEqual(this.shareable, userPocketAssetsDaoEntity.shareable) && Intrinsics.areEqual(this.goodsId, userPocketAssetsDaoEntity.goodsId) && Intrinsics.areEqual(this.tcUrl, userPocketAssetsDaoEntity.tcUrl) && Intrinsics.areEqual(this.expirationDate, userPocketAssetsDaoEntity.expirationDate) && Intrinsics.areEqual(this.createdDate, userPocketAssetsDaoEntity.createdDate) && Intrinsics.areEqual(this.shareableRpcInfoReceiverInfo, userPocketAssetsDaoEntity.shareableRpcInfoReceiverInfo) && Intrinsics.areEqual(this.shareableRpcInfoReceiverUserId, userPocketAssetsDaoEntity.shareableRpcInfoReceiverUserId) && Intrinsics.areEqual(this.shareableRpcInfoSharedDate, userPocketAssetsDaoEntity.shareableRpcInfoSharedDate) && Intrinsics.areEqual(this.extendInfo, userPocketAssetsDaoEntity.extendInfo) && Intrinsics.areEqual(this.primaryCTA, userPocketAssetsDaoEntity.primaryCTA) && Intrinsics.areEqual(this.backgroundColor, userPocketAssetsDaoEntity.backgroundColor) && Intrinsics.areEqual(this.fontColor, userPocketAssetsDaoEntity.fontColor) && Intrinsics.areEqual(this.minTransaction, userPocketAssetsDaoEntity.minTransaction) && Intrinsics.areEqual(this.categoryIconUrl, userPocketAssetsDaoEntity.categoryIconUrl) && Intrinsics.areEqual(this.bizInfo, userPocketAssetsDaoEntity.bizInfo) && Intrinsics.areEqual(this.cacheTimestamp, userPocketAssetsDaoEntity.cacheTimestamp);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.pocketId.hashCode();
        int hashCode2 = this.pocketStatus.hashCode();
        int hashCode3 = this.iconUrl.hashCode();
        int hashCode4 = this.backgroundUrl.hashCode();
        String str = this.pocketType;
        int hashCode5 = str == null ? 0 : str.hashCode();
        String str2 = this.userPocketStatus;
        int hashCode6 = str2 == null ? 0 : str2.hashCode();
        Long l = this.activateDate;
        int hashCode7 = l == null ? 0 : l.hashCode();
        String str3 = this.howTo;
        int hashCode8 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.merchantId;
        int hashCode9 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.label;
        int hashCode10 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.subLabel;
        int hashCode11 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.logoUrl;
        int hashCode12 = str7 == null ? 0 : str7.hashCode();
        Boolean bool = this.usable;
        int hashCode13 = bool == null ? 0 : bool.hashCode();
        Boolean bool2 = this.shareable;
        int hashCode14 = bool2 == null ? 0 : bool2.hashCode();
        String str8 = this.goodsId;
        int hashCode15 = str8 == null ? 0 : str8.hashCode();
        String str9 = this.tcUrl;
        int hashCode16 = str9 == null ? 0 : str9.hashCode();
        Long l2 = this.expirationDate;
        int hashCode17 = l2 == null ? 0 : l2.hashCode();
        String str10 = this.createdDate;
        int hashCode18 = str10 == null ? 0 : str10.hashCode();
        String str11 = this.shareableRpcInfoReceiverInfo;
        int hashCode19 = str11 == null ? 0 : str11.hashCode();
        String str12 = this.shareableRpcInfoReceiverUserId;
        int hashCode20 = str12 == null ? 0 : str12.hashCode();
        Long l3 = this.shareableRpcInfoSharedDate;
        int hashCode21 = l3 == null ? 0 : l3.hashCode();
        Map<String, Object> map = this.extendInfo;
        int hashCode22 = map == null ? 0 : map.hashCode();
        String str13 = this.primaryCTA;
        int hashCode23 = str13 == null ? 0 : str13.hashCode();
        String str14 = this.backgroundColor;
        int hashCode24 = str14 == null ? 0 : str14.hashCode();
        String str15 = this.fontColor;
        int hashCode25 = str15 == null ? 0 : str15.hashCode();
        String str16 = this.minTransaction;
        int hashCode26 = str16 == null ? 0 : str16.hashCode();
        String str17 = this.categoryIconUrl;
        int hashCode27 = str17 == null ? 0 : str17.hashCode();
        Map<String, Object> map2 = this.bizInfo;
        int hashCode28 = map2 == null ? 0 : map2.hashCode();
        Long l4 = this.cacheTimestamp;
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + hashCode14) * 31) + hashCode15) * 31) + hashCode16) * 31) + hashCode17) * 31) + hashCode18) * 31) + hashCode19) * 31) + hashCode20) * 31) + hashCode21) * 31) + hashCode22) * 31) + hashCode23) * 31) + hashCode24) * 31) + hashCode25) * 31) + hashCode26) * 31) + hashCode27) * 31) + hashCode28) * 31) + (l4 != null ? l4.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UserPocketAssetsDaoEntity(pocketId=");
        sb.append(this.pocketId);
        sb.append(", pocketStatus=");
        sb.append(this.pocketStatus);
        sb.append(", iconUrl=");
        sb.append(this.iconUrl);
        sb.append(", backgroundUrl=");
        sb.append(this.backgroundUrl);
        sb.append(", pocketType=");
        sb.append(this.pocketType);
        sb.append(", userPocketStatus=");
        sb.append(this.userPocketStatus);
        sb.append(", activateDate=");
        sb.append(this.activateDate);
        sb.append(", howTo=");
        sb.append(this.howTo);
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
        sb.append(", goodsId=");
        sb.append(this.goodsId);
        sb.append(", tcUrl=");
        sb.append(this.tcUrl);
        sb.append(", expirationDate=");
        sb.append(this.expirationDate);
        sb.append(", createdDate=");
        sb.append(this.createdDate);
        sb.append(", shareableRpcInfoReceiverInfo=");
        sb.append(this.shareableRpcInfoReceiverInfo);
        sb.append(", shareableRpcInfoReceiverUserId=");
        sb.append(this.shareableRpcInfoReceiverUserId);
        sb.append(", shareableRpcInfoSharedDate=");
        sb.append(this.shareableRpcInfoSharedDate);
        sb.append(", extendInfo=");
        sb.append(this.extendInfo);
        sb.append(", primaryCTA=");
        sb.append(this.primaryCTA);
        sb.append(", backgroundColor=");
        sb.append(this.backgroundColor);
        sb.append(", fontColor=");
        sb.append(this.fontColor);
        sb.append(", minTransaction=");
        sb.append(this.minTransaction);
        sb.append(", categoryIconUrl=");
        sb.append(this.categoryIconUrl);
        sb.append(", bizInfo=");
        sb.append(this.bizInfo);
        sb.append(", cacheTimestamp=");
        sb.append(this.cacheTimestamp);
        sb.append(')');
        return sb.toString();
    }

    public UserPocketAssetsDaoEntity(@Nonnull String str, String str2, String str3, String str4, String str5, String str6, Long l, String str7, String str8, String str9, String str10, String str11, Boolean bool, Boolean bool2, String str12, String str13, Long l2, String str14, String str15, String str16, Long l3, Map<String, ? extends Object> map, String str17, String str18, String str19, String str20, String str21, Map<String, ? extends Object> map2, Long l4) {
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
        this.shareableRpcInfoReceiverInfo = str15;
        this.shareableRpcInfoReceiverUserId = str16;
        this.shareableRpcInfoSharedDate = l3;
        this.extendInfo = map;
        this.primaryCTA = str17;
        this.backgroundColor = str18;
        this.fontColor = str19;
        this.minTransaction = str20;
        this.categoryIconUrl = str21;
        this.bizInfo = map2;
        this.cacheTimestamp = l4;
    }

    public /* synthetic */ UserPocketAssetsDaoEntity(String str, String str2, String str3, String str4, String str5, String str6, Long l, String str7, String str8, String str9, String str10, String str11, Boolean bool, Boolean bool2, String str12, String str13, Long l2, String str14, String str15, String str16, Long l3, Map map, String str17, String str18, String str19, String str20, String str21, Map map2, Long l4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) == 0 ? str4 : "", (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : l, (i & 128) != 0 ? null : str7, (i & 256) != 0 ? null : str8, (i & 512) != 0 ? null : str9, (i & 1024) != 0 ? null : str10, (i & 2048) != 0 ? null : str11, (i & 4096) != 0 ? null : bool, (i & 8192) != 0 ? null : bool2, (i & 16384) != 0 ? null : str12, (i & 32768) != 0 ? null : str13, (i & 65536) != 0 ? null : l2, (i & AntDetector.SCENE_ID_LOGIN_REGIST) != 0 ? null : str14, (i & 262144) != 0 ? null : str15, (i & 524288) != 0 ? null : str16, (i & CrashCombineUtils.DEFAULT_MAX_INFO_LEN) != 0 ? null : l3, (i & 2097152) != 0 ? null : map, (i & 4194304) != 0 ? null : str17, (i & 8388608) != 0 ? null : str18, (i & 16777216) != 0 ? null : str19, (i & 33554432) != 0 ? null : str20, (i & 67108864) != 0 ? null : str21, (i & 134217728) != 0 ? null : map2, (i & SQLiteDatabase.CREATE_IF_NECESSARY) != 0 ? null : l4);
    }

    @JvmName(name = "getPocketId")
    public final String getPocketId() {
        return this.pocketId;
    }

    @JvmName(name = "setPocketId")
    public final void setPocketId(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.pocketId = str;
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

    @JvmName(name = "getShareableRpcInfoReceiverInfo")
    public final String getShareableRpcInfoReceiverInfo() {
        return this.shareableRpcInfoReceiverInfo;
    }

    @JvmName(name = "getShareableRpcInfoReceiverUserId")
    public final String getShareableRpcInfoReceiverUserId() {
        return this.shareableRpcInfoReceiverUserId;
    }

    @JvmName(name = "getShareableRpcInfoSharedDate")
    public final Long getShareableRpcInfoSharedDate() {
        return this.shareableRpcInfoSharedDate;
    }

    @JvmName(name = "getExtendInfo")
    public final Map<String, Object> getExtendInfo() {
        return this.extendInfo;
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
}
