package id.dana.domain.nearbyme.model;

import com.alipay.iap.android.aplog.util.CrashCombineUtils;
import com.alipay.mobile.security.faceauth.api.AntDetector;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import id.dana.biometric.domain.model.BiometricDataSize$$ExternalSyntheticBackport0;
import id.dana.contract.deeplink.path.FeatureParams;
import id.dana.domain.merchant.model.MerchantSubcategory;
import id.dana.domain.qrbarcode.DecodedScanBizInfoKey;
import id.dana.kybcpm.constant.KybCpmConstants;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.sqlcipher.database.SQLiteDatabase;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\bv\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\b\u0018\u0000 §\u00012\u00020\u0001:\u0002§\u0001B±\u0003\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\n\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f\u0012\b\b\u0002\u0010\u0014\u001a\u00020\n\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u001c\u001a\u00020\n\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u001e\u001a\u00020\n\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u0007\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u0007\u0012\b\b\u0002\u0010(\u001a\u00020\u0010\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+\u0012\b\b\u0002\u0010,\u001a\u00020\u0010¢\u0006\u0002\u0010-J\u000b\u0010}\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010~\u001a\u00020\nHÆ\u0003J\u000b\u0010\u007f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0018\u0010\u0080\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fHÆ\u0003J\n\u0010\u0081\u0001\u001a\u00020\nHÆ\u0003J\f\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0012\u0010\u0083\u0001\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007HÆ\u0003J\f\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0012\u0010\u0086\u0001\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007HÆ\u0003J\u0012\u0010\u0087\u0001\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0007HÆ\u0003J\f\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010\u0089\u0001\u001a\u00020\nHÆ\u0003J\f\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010\u008b\u0001\u001a\u00020\nHÆ\u0003J\f\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0012\u0010\u008e\u0001\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u0007HÆ\u0003J\f\u0010\u008f\u0001\u001a\u0004\u0018\u00010$HÆ\u0003J\f\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0012\u0010\u0091\u0001\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u0007HÆ\u0003J\n\u0010\u0092\u0001\u001a\u00020\u0010HÆ\u0003J\f\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0095\u0001\u001a\u0004\u0018\u00010+HÆ\u0003¢\u0006\u0002\u0010yJ\n\u0010\u0096\u0001\u001a\u00020\u0010HÆ\u0003J\u0012\u0010\u0097\u0001\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\n\u0010\u0098\u0001\u001a\u00020\nHÆ\u0003J\u0018\u0010\u0099\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fHÆ\u0003J\f\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010\u009c\u0001\u001a\u00020\u0010HÆ\u0003J¼\u0003\u0010\u009d\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\n2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f2\b\b\u0002\u0010\u0014\u001a\u00020\n2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00072\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00072\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u00072\b\b\u0002\u0010\u001c\u001a\u00020\n2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u001e\u001a\u00020\n2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u00072\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u00072\b\b\u0002\u0010(\u001a\u00020\u00102\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+2\b\b\u0002\u0010,\u001a\u00020\u0010HÆ\u0001¢\u0006\u0003\u0010\u009e\u0001J\u0015\u0010\u009f\u0001\u001a\u00020\u00102\t\u0010 \u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u000b\u0010¡\u0001\u001a\u00030¢\u0001HÖ\u0001J\u0007\u0010£\u0001\u001a\u00020\u0010J\u0010\u0010¤\u0001\u001a\u00020\u00102\u0007\u0010¥\u0001\u001a\u00020\nJ\n\u0010¦\u0001\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010/\"\u0004\b3\u00101R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010/\"\u0004\b5\u00101R\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R(\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010/\"\u0004\bC\u00101R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001a\u0010,\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010E\"\u0004\bI\u0010GR\u001a\u0010(\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010E\"\u0004\bK\u0010GR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010/\"\u0004\bM\u00101R\u001a\u0010\u0011\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010;\"\u0004\bO\u0010=R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010/\"\u0004\bQ\u00101R(\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010?\"\u0004\bS\u0010AR\u001a\u0010\u0014\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010;\"\u0004\bU\u0010=R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010/\"\u0004\bW\u00101R\"\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u00107\"\u0004\bY\u00109R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010/\"\u0004\b[\u00101R\u001c\u0010)\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010/\"\u0004\b]\u00101R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010/\"\u0004\b_\u00101R\"\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u00107\"\u0004\ba\u00109R\"\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u00107\"\u0004\bc\u00109R\u001a\u0010\u001c\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010;\"\u0004\be\u0010=R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010/\"\u0004\bg\u00101R\u001a\u0010\u001e\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010;\"\u0004\bi\u0010=R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010/\"\u0004\bk\u00101R\u001c\u0010 \u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010/\"\u0004\bm\u00101R\"\u0010!\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u00107\"\u0004\bo\u00109R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR\u001c\u0010%\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010/\"\u0004\bu\u00101R\"\u0010&\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u00107\"\u0004\bw\u00109R\u001e\u0010*\u001a\u0004\u0018\u00010+X\u0086\u000e¢\u0006\u0010\n\u0002\u0010|\u001a\u0004\bx\u0010y\"\u0004\bz\u0010{¨\u0006¨\u0001"}, d2 = {"Lid/dana/domain/nearbyme/model/Shop;", "", "branchName", "", "brandName", "certStatus", "contactAddresses", "", "Lid/dana/domain/nearbyme/model/ContactAddress;", "distance", "", "extInfo", "", "externalShopId", "instId", "fullDay", "", "latitude", DecodedScanBizInfoKey.LOGO_URL, "logoUrlMap", "longtitude", "mainName", "mccCodes", "merchantId", "merchantSizeType", "officeNumbers", "promoInfos", "Lid/dana/domain/nearbyme/model/PromoInfo;", "rating", "registerSource", "reviewNumbers", "shopDesc", FeatureParams.SHOP_ID, "shopOpenHours", "Lid/dana/domain/nearbyme/model/ShopOpenHour;", "shopStatus", "Lid/dana/domain/nearbyme/model/MerchantStatusEnum;", "shopType", "subcategories", "Lid/dana/domain/merchant/model/MerchantSubcategory;", "hasMoreShop", "merchantName", KybCpmConstants.TRANSACTION_DATE_PARAM, "", "hasDeals", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;DLjava/util/Map;Ljava/lang/String;Ljava/lang/String;ZDLjava/lang/String;Ljava/util/Map;DLjava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;DLjava/lang/String;DLjava/lang/String;Ljava/lang/String;Ljava/util/List;Lid/dana/domain/nearbyme/model/MerchantStatusEnum;Ljava/lang/String;Ljava/util/List;ZLjava/lang/String;Ljava/lang/Long;Z)V", "getBranchName", "()Ljava/lang/String;", "setBranchName", "(Ljava/lang/String;)V", "getBrandName", "setBrandName", "getCertStatus", "setCertStatus", "getContactAddresses", "()Ljava/util/List;", "setContactAddresses", "(Ljava/util/List;)V", "getDistance", "()D", "setDistance", "(D)V", "getExtInfo", "()Ljava/util/Map;", "setExtInfo", "(Ljava/util/Map;)V", "getExternalShopId", "setExternalShopId", "getFullDay", "()Z", "setFullDay", "(Z)V", "getHasDeals", "setHasDeals", "getHasMoreShop", "setHasMoreShop", "getInstId", "setInstId", "getLatitude", "setLatitude", "getLogoUrl", "setLogoUrl", "getLogoUrlMap", "setLogoUrlMap", "getLongtitude", "setLongtitude", "getMainName", "setMainName", "getMccCodes", "setMccCodes", "getMerchantId", "setMerchantId", "getMerchantName", "setMerchantName", "getMerchantSizeType", "setMerchantSizeType", "getOfficeNumbers", "setOfficeNumbers", "getPromoInfos", "setPromoInfos", "getRating", "setRating", "getRegisterSource", "setRegisterSource", "getReviewNumbers", "setReviewNumbers", "getShopDesc", "setShopDesc", "getShopId", "setShopId", "getShopOpenHours", "setShopOpenHours", "getShopStatus", "()Lid/dana/domain/nearbyme/model/MerchantStatusEnum;", "setShopStatus", "(Lid/dana/domain/nearbyme/model/MerchantStatusEnum;)V", "getShopType", "setShopType", "getSubcategories", "setSubcategories", "getTransactionDate", "()Ljava/lang/Long;", "setTransactionDate", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;DLjava/util/Map;Ljava/lang/String;Ljava/lang/String;ZDLjava/lang/String;Ljava/util/Map;DLjava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;DLjava/lang/String;DLjava/lang/String;Ljava/lang/String;Ljava/util/List;Lid/dana/domain/nearbyme/model/MerchantStatusEnum;Ljava/lang/String;Ljava/util/List;ZLjava/lang/String;Ljava/lang/Long;Z)Lid/dana/domain/nearbyme/model/Shop;", "equals", "other", "hashCode", "", "isMerchantIdIrrelevant", "isReviewCountNotValid", "reviewCount", "toString", "Companion", "domain_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class Shop {
    public static final String KYB_EXT_SHOP_ID = "KYB-";
    public static final String QRIS_MERCHANT_ID = "216620000020928274717";
    public static final String XENDIT_MERCHANT_ID = "216620000035833566172";
    public static final String XENDIT_QRIS_MERCHANT_ID = "216620000258073885924";
    private String branchName;
    private String brandName;
    private String certStatus;
    private List<ContactAddress> contactAddresses;
    private double distance;
    private Map<String, String> extInfo;
    private String externalShopId;
    private boolean fullDay;
    private boolean hasDeals;
    private boolean hasMoreShop;
    private String instId;
    private double latitude;
    private String logoUrl;
    private Map<String, String> logoUrlMap;
    private double longtitude;
    private String mainName;
    private List<String> mccCodes;
    private String merchantId;
    private String merchantName;
    private String merchantSizeType;
    private List<String> officeNumbers;
    private List<PromoInfo> promoInfos;
    private double rating;
    private String registerSource;
    private double reviewNumbers;
    private String shopDesc;
    private String shopId;
    private List<ShopOpenHour> shopOpenHours;
    private MerchantStatusEnum shopStatus;
    private String shopType;
    private List<? extends MerchantSubcategory> subcategories;
    private Long transactionDate;

    public Shop() {
        this(null, null, null, null, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, null, null, null, false, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, null, null, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, null, null, null, null, null, null, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, null, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, null, null, null, null, null, null, false, null, null, false, -1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Shop copy$default(Shop shop, String str, String str2, String str3, List list, double d, Map map, String str4, String str5, boolean z, double d2, String str6, Map map2, double d3, String str7, List list2, String str8, String str9, List list3, List list4, double d4, String str10, double d5, String str11, String str12, List list5, MerchantStatusEnum merchantStatusEnum, String str13, List list6, boolean z2, String str14, Long l, boolean z3, int i, Object obj) {
        String str15 = (i & 1) != 0 ? shop.branchName : str;
        String str16 = (i & 2) != 0 ? shop.brandName : str2;
        String str17 = (i & 4) != 0 ? shop.certStatus : str3;
        List<ContactAddress> list7 = (i & 8) != 0 ? shop.contactAddresses : list;
        double d6 = (i & 16) != 0 ? shop.distance : d;
        Map<String, String> map3 = (i & 32) != 0 ? shop.extInfo : map;
        String str18 = (i & 64) != 0 ? shop.externalShopId : str4;
        String str19 = (i & 128) != 0 ? shop.instId : str5;
        boolean z4 = (i & 256) != 0 ? shop.fullDay : z;
        double d7 = (i & 512) != 0 ? shop.latitude : d2;
        String str20 = (i & 1024) != 0 ? shop.logoUrl : str6;
        return shop.copy(str15, str16, str17, list7, d6, map3, str18, str19, z4, d7, str20, (i & 2048) != 0 ? shop.logoUrlMap : map2, (i & 4096) != 0 ? shop.longtitude : d3, (i & 8192) != 0 ? shop.mainName : str7, (i & 16384) != 0 ? shop.mccCodes : list2, (i & 32768) != 0 ? shop.merchantId : str8, (i & 65536) != 0 ? shop.merchantSizeType : str9, (i & AntDetector.SCENE_ID_LOGIN_REGIST) != 0 ? shop.officeNumbers : list3, (i & 262144) != 0 ? shop.promoInfos : list4, (i & 524288) != 0 ? shop.rating : d4, (i & CrashCombineUtils.DEFAULT_MAX_INFO_LEN) != 0 ? shop.registerSource : str10, (2097152 & i) != 0 ? shop.reviewNumbers : d5, (i & 4194304) != 0 ? shop.shopDesc : str11, (8388608 & i) != 0 ? shop.shopId : str12, (i & 16777216) != 0 ? shop.shopOpenHours : list5, (i & 33554432) != 0 ? shop.shopStatus : merchantStatusEnum, (i & 67108864) != 0 ? shop.shopType : str13, (i & 134217728) != 0 ? shop.subcategories : list6, (i & SQLiteDatabase.CREATE_IF_NECESSARY) != 0 ? shop.hasMoreShop : z2, (i & 536870912) != 0 ? shop.merchantName : str14, (i & 1073741824) != 0 ? shop.transactionDate : l, (i & Integer.MIN_VALUE) != 0 ? shop.hasDeals : z3);
    }

    /* renamed from: component1  reason: from getter */
    public final String getBranchName() {
        return this.branchName;
    }

    /* renamed from: component10  reason: from getter */
    public final double getLatitude() {
        return this.latitude;
    }

    /* renamed from: component11  reason: from getter */
    public final String getLogoUrl() {
        return this.logoUrl;
    }

    public final Map<String, String> component12() {
        return this.logoUrlMap;
    }

    /* renamed from: component13  reason: from getter */
    public final double getLongtitude() {
        return this.longtitude;
    }

    /* renamed from: component14  reason: from getter */
    public final String getMainName() {
        return this.mainName;
    }

    public final List<String> component15() {
        return this.mccCodes;
    }

    /* renamed from: component16  reason: from getter */
    public final String getMerchantId() {
        return this.merchantId;
    }

    /* renamed from: component17  reason: from getter */
    public final String getMerchantSizeType() {
        return this.merchantSizeType;
    }

    public final List<String> component18() {
        return this.officeNumbers;
    }

    public final List<PromoInfo> component19() {
        return this.promoInfos;
    }

    /* renamed from: component2  reason: from getter */
    public final String getBrandName() {
        return this.brandName;
    }

    /* renamed from: component20  reason: from getter */
    public final double getRating() {
        return this.rating;
    }

    /* renamed from: component21  reason: from getter */
    public final String getRegisterSource() {
        return this.registerSource;
    }

    /* renamed from: component22  reason: from getter */
    public final double getReviewNumbers() {
        return this.reviewNumbers;
    }

    /* renamed from: component23  reason: from getter */
    public final String getShopDesc() {
        return this.shopDesc;
    }

    /* renamed from: component24  reason: from getter */
    public final String getShopId() {
        return this.shopId;
    }

    public final List<ShopOpenHour> component25() {
        return this.shopOpenHours;
    }

    /* renamed from: component26  reason: from getter */
    public final MerchantStatusEnum getShopStatus() {
        return this.shopStatus;
    }

    /* renamed from: component27  reason: from getter */
    public final String getShopType() {
        return this.shopType;
    }

    public final List<MerchantSubcategory> component28() {
        return this.subcategories;
    }

    /* renamed from: component29  reason: from getter */
    public final boolean getHasMoreShop() {
        return this.hasMoreShop;
    }

    /* renamed from: component3  reason: from getter */
    public final String getCertStatus() {
        return this.certStatus;
    }

    /* renamed from: component30  reason: from getter */
    public final String getMerchantName() {
        return this.merchantName;
    }

    /* renamed from: component31  reason: from getter */
    public final Long getTransactionDate() {
        return this.transactionDate;
    }

    /* renamed from: component32  reason: from getter */
    public final boolean getHasDeals() {
        return this.hasDeals;
    }

    public final List<ContactAddress> component4() {
        return this.contactAddresses;
    }

    /* renamed from: component5  reason: from getter */
    public final double getDistance() {
        return this.distance;
    }

    public final Map<String, String> component6() {
        return this.extInfo;
    }

    /* renamed from: component7  reason: from getter */
    public final String getExternalShopId() {
        return this.externalShopId;
    }

    /* renamed from: component8  reason: from getter */
    public final String getInstId() {
        return this.instId;
    }

    /* renamed from: component9  reason: from getter */
    public final boolean getFullDay() {
        return this.fullDay;
    }

    public final Shop copy(String branchName, String brandName, String certStatus, List<ContactAddress> contactAddresses, double distance, Map<String, String> extInfo, String externalShopId, String instId, boolean fullDay, double latitude, String logoUrl, Map<String, String> logoUrlMap, double longtitude, String mainName, List<String> mccCodes, String merchantId, String merchantSizeType, List<String> officeNumbers, List<PromoInfo> promoInfos, double rating, String registerSource, double reviewNumbers, String shopDesc, String shopId, List<ShopOpenHour> shopOpenHours, MerchantStatusEnum shopStatus, String shopType, List<? extends MerchantSubcategory> subcategories, boolean hasMoreShop, String merchantName, Long transactionDate, boolean hasDeals) {
        return new Shop(branchName, brandName, certStatus, contactAddresses, distance, extInfo, externalShopId, instId, fullDay, latitude, logoUrl, logoUrlMap, longtitude, mainName, mccCodes, merchantId, merchantSizeType, officeNumbers, promoInfos, rating, registerSource, reviewNumbers, shopDesc, shopId, shopOpenHours, shopStatus, shopType, subcategories, hasMoreShop, merchantName, transactionDate, hasDeals);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof Shop) {
            Shop shop = (Shop) other;
            return Intrinsics.areEqual(this.branchName, shop.branchName) && Intrinsics.areEqual(this.brandName, shop.brandName) && Intrinsics.areEqual(this.certStatus, shop.certStatus) && Intrinsics.areEqual(this.contactAddresses, shop.contactAddresses) && Intrinsics.areEqual((Object) Double.valueOf(this.distance), (Object) Double.valueOf(shop.distance)) && Intrinsics.areEqual(this.extInfo, shop.extInfo) && Intrinsics.areEqual(this.externalShopId, shop.externalShopId) && Intrinsics.areEqual(this.instId, shop.instId) && this.fullDay == shop.fullDay && Intrinsics.areEqual((Object) Double.valueOf(this.latitude), (Object) Double.valueOf(shop.latitude)) && Intrinsics.areEqual(this.logoUrl, shop.logoUrl) && Intrinsics.areEqual(this.logoUrlMap, shop.logoUrlMap) && Intrinsics.areEqual((Object) Double.valueOf(this.longtitude), (Object) Double.valueOf(shop.longtitude)) && Intrinsics.areEqual(this.mainName, shop.mainName) && Intrinsics.areEqual(this.mccCodes, shop.mccCodes) && Intrinsics.areEqual(this.merchantId, shop.merchantId) && Intrinsics.areEqual(this.merchantSizeType, shop.merchantSizeType) && Intrinsics.areEqual(this.officeNumbers, shop.officeNumbers) && Intrinsics.areEqual(this.promoInfos, shop.promoInfos) && Intrinsics.areEqual((Object) Double.valueOf(this.rating), (Object) Double.valueOf(shop.rating)) && Intrinsics.areEqual(this.registerSource, shop.registerSource) && Intrinsics.areEqual((Object) Double.valueOf(this.reviewNumbers), (Object) Double.valueOf(shop.reviewNumbers)) && Intrinsics.areEqual(this.shopDesc, shop.shopDesc) && Intrinsics.areEqual(this.shopId, shop.shopId) && Intrinsics.areEqual(this.shopOpenHours, shop.shopOpenHours) && this.shopStatus == shop.shopStatus && Intrinsics.areEqual(this.shopType, shop.shopType) && Intrinsics.areEqual(this.subcategories, shop.subcategories) && this.hasMoreShop == shop.hasMoreShop && Intrinsics.areEqual(this.merchantName, shop.merchantName) && Intrinsics.areEqual(this.transactionDate, shop.transactionDate) && this.hasDeals == shop.hasDeals;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode;
        int i;
        int hashCode2;
        int i2;
        int i3;
        int i4;
        int hashCode3;
        String str = this.branchName;
        int hashCode4 = str == null ? 0 : str.hashCode();
        String str2 = this.brandName;
        int hashCode5 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.certStatus;
        int hashCode6 = str3 == null ? 0 : str3.hashCode();
        List<ContactAddress> list = this.contactAddresses;
        int hashCode7 = list == null ? 0 : list.hashCode();
        int KClassImpl$Data$declaredNonStaticMembers$2 = BiometricDataSize$$ExternalSyntheticBackport0.KClassImpl$Data$declaredNonStaticMembers$2(this.distance);
        Map<String, String> map = this.extInfo;
        int hashCode8 = map == null ? 0 : map.hashCode();
        String str4 = this.externalShopId;
        int hashCode9 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.instId;
        int hashCode10 = str5 == null ? 0 : str5.hashCode();
        boolean z = this.fullDay;
        int i5 = z;
        if (z != 0) {
            i5 = 1;
        }
        int KClassImpl$Data$declaredNonStaticMembers$22 = BiometricDataSize$$ExternalSyntheticBackport0.KClassImpl$Data$declaredNonStaticMembers$2(this.latitude);
        String str6 = this.logoUrl;
        int hashCode11 = str6 == null ? 0 : str6.hashCode();
        Map<String, String> map2 = this.logoUrlMap;
        if (map2 == null) {
            i = KClassImpl$Data$declaredNonStaticMembers$22;
            hashCode = 0;
        } else {
            hashCode = map2.hashCode();
            i = KClassImpl$Data$declaredNonStaticMembers$22;
        }
        int KClassImpl$Data$declaredNonStaticMembers$23 = BiometricDataSize$$ExternalSyntheticBackport0.KClassImpl$Data$declaredNonStaticMembers$2(this.longtitude);
        String str7 = this.mainName;
        int hashCode12 = str7 == null ? 0 : str7.hashCode();
        List<String> list2 = this.mccCodes;
        int hashCode13 = list2 == null ? 0 : list2.hashCode();
        String str8 = this.merchantId;
        int hashCode14 = str8 == null ? 0 : str8.hashCode();
        String str9 = this.merchantSizeType;
        int hashCode15 = str9 == null ? 0 : str9.hashCode();
        List<String> list3 = this.officeNumbers;
        int hashCode16 = list3 == null ? 0 : list3.hashCode();
        List<PromoInfo> list4 = this.promoInfos;
        if (list4 == null) {
            i2 = KClassImpl$Data$declaredNonStaticMembers$23;
            i3 = hashCode12;
            hashCode2 = 0;
        } else {
            hashCode2 = list4.hashCode();
            i2 = KClassImpl$Data$declaredNonStaticMembers$23;
            i3 = hashCode12;
        }
        int KClassImpl$Data$declaredNonStaticMembers$24 = BiometricDataSize$$ExternalSyntheticBackport0.KClassImpl$Data$declaredNonStaticMembers$2(this.rating);
        String str10 = this.registerSource;
        if (str10 == null) {
            i4 = KClassImpl$Data$declaredNonStaticMembers$24;
            hashCode3 = 0;
        } else {
            i4 = KClassImpl$Data$declaredNonStaticMembers$24;
            hashCode3 = str10.hashCode();
        }
        int KClassImpl$Data$declaredNonStaticMembers$25 = BiometricDataSize$$ExternalSyntheticBackport0.KClassImpl$Data$declaredNonStaticMembers$2(this.reviewNumbers);
        String str11 = this.shopDesc;
        int hashCode17 = str11 == null ? 0 : str11.hashCode();
        String str12 = this.shopId;
        int hashCode18 = str12 == null ? 0 : str12.hashCode();
        List<ShopOpenHour> list5 = this.shopOpenHours;
        int hashCode19 = list5 == null ? 0 : list5.hashCode();
        MerchantStatusEnum merchantStatusEnum = this.shopStatus;
        int hashCode20 = merchantStatusEnum == null ? 0 : merchantStatusEnum.hashCode();
        String str13 = this.shopType;
        int hashCode21 = str13 == null ? 0 : str13.hashCode();
        List<? extends MerchantSubcategory> list6 = this.subcategories;
        int hashCode22 = list6 == null ? 0 : list6.hashCode();
        boolean z2 = this.hasMoreShop;
        int i6 = z2 ? 1 : z2 ? 1 : 0;
        String str14 = this.merchantName;
        int hashCode23 = str14 == null ? 0 : str14.hashCode();
        Long l = this.transactionDate;
        int hashCode24 = l != null ? l.hashCode() : 0;
        boolean z3 = this.hasDeals;
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((hashCode4 * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + KClassImpl$Data$declaredNonStaticMembers$2) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + i5) * 31) + i) * 31) + hashCode11) * 31) + hashCode) * 31) + i2) * 31) + i3) * 31) + hashCode13) * 31) + hashCode14) * 31) + hashCode15) * 31) + hashCode16) * 31) + hashCode2) * 31) + i4) * 31) + hashCode3) * 31) + KClassImpl$Data$declaredNonStaticMembers$25) * 31) + hashCode17) * 31) + hashCode18) * 31) + hashCode19) * 31) + hashCode20) * 31) + hashCode21) * 31) + hashCode22) * 31) + i6) * 31) + hashCode23) * 31) + hashCode24) * 31) + (!z3 ? z3 ? 1 : 0 : 1);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Shop(branchName=");
        sb.append(this.branchName);
        sb.append(", brandName=");
        sb.append(this.brandName);
        sb.append(", certStatus=");
        sb.append(this.certStatus);
        sb.append(", contactAddresses=");
        sb.append(this.contactAddresses);
        sb.append(", distance=");
        sb.append(this.distance);
        sb.append(", extInfo=");
        sb.append(this.extInfo);
        sb.append(", externalShopId=");
        sb.append(this.externalShopId);
        sb.append(", instId=");
        sb.append(this.instId);
        sb.append(", fullDay=");
        sb.append(this.fullDay);
        sb.append(", latitude=");
        sb.append(this.latitude);
        sb.append(", logoUrl=");
        sb.append(this.logoUrl);
        sb.append(", logoUrlMap=");
        sb.append(this.logoUrlMap);
        sb.append(", longtitude=");
        sb.append(this.longtitude);
        sb.append(", mainName=");
        sb.append(this.mainName);
        sb.append(", mccCodes=");
        sb.append(this.mccCodes);
        sb.append(", merchantId=");
        sb.append(this.merchantId);
        sb.append(", merchantSizeType=");
        sb.append(this.merchantSizeType);
        sb.append(", officeNumbers=");
        sb.append(this.officeNumbers);
        sb.append(", promoInfos=");
        sb.append(this.promoInfos);
        sb.append(", rating=");
        sb.append(this.rating);
        sb.append(", registerSource=");
        sb.append(this.registerSource);
        sb.append(", reviewNumbers=");
        sb.append(this.reviewNumbers);
        sb.append(", shopDesc=");
        sb.append(this.shopDesc);
        sb.append(", shopId=");
        sb.append(this.shopId);
        sb.append(", shopOpenHours=");
        sb.append(this.shopOpenHours);
        sb.append(", shopStatus=");
        sb.append(this.shopStatus);
        sb.append(", shopType=");
        sb.append(this.shopType);
        sb.append(", subcategories=");
        sb.append(this.subcategories);
        sb.append(", hasMoreShop=");
        sb.append(this.hasMoreShop);
        sb.append(", merchantName=");
        sb.append(this.merchantName);
        sb.append(", transactionDate=");
        sb.append(this.transactionDate);
        sb.append(", hasDeals=");
        sb.append(this.hasDeals);
        sb.append(')');
        return sb.toString();
    }

    public Shop(String str, String str2, String str3, List<ContactAddress> list, double d, Map<String, String> map, String str4, String str5, boolean z, double d2, String str6, Map<String, String> map2, double d3, String str7, List<String> list2, String str8, String str9, List<String> list3, List<PromoInfo> list4, double d4, String str10, double d5, String str11, String str12, List<ShopOpenHour> list5, MerchantStatusEnum merchantStatusEnum, String str13, List<? extends MerchantSubcategory> list6, boolean z2, String str14, Long l, boolean z3) {
        this.branchName = str;
        this.brandName = str2;
        this.certStatus = str3;
        this.contactAddresses = list;
        this.distance = d;
        this.extInfo = map;
        this.externalShopId = str4;
        this.instId = str5;
        this.fullDay = z;
        this.latitude = d2;
        this.logoUrl = str6;
        this.logoUrlMap = map2;
        this.longtitude = d3;
        this.mainName = str7;
        this.mccCodes = list2;
        this.merchantId = str8;
        this.merchantSizeType = str9;
        this.officeNumbers = list3;
        this.promoInfos = list4;
        this.rating = d4;
        this.registerSource = str10;
        this.reviewNumbers = d5;
        this.shopDesc = str11;
        this.shopId = str12;
        this.shopOpenHours = list5;
        this.shopStatus = merchantStatusEnum;
        this.shopType = str13;
        this.subcategories = list6;
        this.hasMoreShop = z2;
        this.merchantName = str14;
        this.transactionDate = l;
        this.hasDeals = z3;
    }

    public final String getBranchName() {
        return this.branchName;
    }

    public final void setBranchName(String str) {
        this.branchName = str;
    }

    public final String getBrandName() {
        return this.brandName;
    }

    public final void setBrandName(String str) {
        this.brandName = str;
    }

    public final String getCertStatus() {
        return this.certStatus;
    }

    public final void setCertStatus(String str) {
        this.certStatus = str;
    }

    public /* synthetic */ Shop(String str, String str2, String str3, List list, double d, Map map, String str4, String str5, boolean z, double d2, String str6, Map map2, double d3, String str7, List list2, String str8, String str9, List list3, List list4, double d4, String str10, double d5, String str11, String str12, List list5, MerchantStatusEnum merchantStatusEnum, String str13, List list6, boolean z2, String str14, Long l, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? CollectionsKt.emptyList() : list, (i & 16) != 0 ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE : d, (i & 32) != 0 ? MapsKt.emptyMap() : map, (i & 64) != 0 ? "" : str4, (i & 128) != 0 ? "" : str5, (i & 256) != 0 ? false : z, (i & 512) != 0 ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE : d2, (i & 1024) != 0 ? "" : str6, (i & 2048) != 0 ? MapsKt.emptyMap() : map2, (i & 4096) != 0 ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE : d3, (i & 8192) != 0 ? "" : str7, (i & 16384) != 0 ? CollectionsKt.emptyList() : list2, (i & 32768) != 0 ? "" : str8, (i & 65536) != 0 ? "" : str9, (i & AntDetector.SCENE_ID_LOGIN_REGIST) != 0 ? CollectionsKt.emptyList() : list3, (i & 262144) != 0 ? CollectionsKt.emptyList() : list4, (i & 524288) != 0 ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE : d4, (i & CrashCombineUtils.DEFAULT_MAX_INFO_LEN) != 0 ? "" : str10, (i & 2097152) != 0 ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE : d5, (i & 4194304) != 0 ? "" : str11, (i & 8388608) != 0 ? "" : str12, (i & 16777216) != 0 ? CollectionsKt.emptyList() : list5, (i & 33554432) != 0 ? MerchantStatusEnum.FROZEN : merchantStatusEnum, (i & 67108864) != 0 ? "" : str13, (i & 134217728) != 0 ? CollectionsKt.emptyList() : list6, (i & SQLiteDatabase.CREATE_IF_NECESSARY) != 0 ? false : z2, (i & 536870912) != 0 ? "" : str14, (i & 1073741824) != 0 ? 0L : l, (i & Integer.MIN_VALUE) != 0 ? false : z3);
    }

    public final List<ContactAddress> getContactAddresses() {
        return this.contactAddresses;
    }

    public final void setContactAddresses(List<ContactAddress> list) {
        this.contactAddresses = list;
    }

    public final double getDistance() {
        return this.distance;
    }

    public final void setDistance(double d) {
        this.distance = d;
    }

    public final Map<String, String> getExtInfo() {
        return this.extInfo;
    }

    public final void setExtInfo(Map<String, String> map) {
        this.extInfo = map;
    }

    public final String getExternalShopId() {
        return this.externalShopId;
    }

    public final void setExternalShopId(String str) {
        this.externalShopId = str;
    }

    public final String getInstId() {
        return this.instId;
    }

    public final void setInstId(String str) {
        this.instId = str;
    }

    public final boolean getFullDay() {
        return this.fullDay;
    }

    public final void setFullDay(boolean z) {
        this.fullDay = z;
    }

    public final double getLatitude() {
        return this.latitude;
    }

    public final void setLatitude(double d) {
        this.latitude = d;
    }

    public final String getLogoUrl() {
        return this.logoUrl;
    }

    public final void setLogoUrl(String str) {
        this.logoUrl = str;
    }

    public final Map<String, String> getLogoUrlMap() {
        return this.logoUrlMap;
    }

    public final void setLogoUrlMap(Map<String, String> map) {
        this.logoUrlMap = map;
    }

    public final double getLongtitude() {
        return this.longtitude;
    }

    public final void setLongtitude(double d) {
        this.longtitude = d;
    }

    public final String getMainName() {
        return this.mainName;
    }

    public final void setMainName(String str) {
        this.mainName = str;
    }

    public final List<String> getMccCodes() {
        return this.mccCodes;
    }

    public final void setMccCodes(List<String> list) {
        this.mccCodes = list;
    }

    public final String getMerchantId() {
        return this.merchantId;
    }

    public final void setMerchantId(String str) {
        this.merchantId = str;
    }

    public final String getMerchantSizeType() {
        return this.merchantSizeType;
    }

    public final void setMerchantSizeType(String str) {
        this.merchantSizeType = str;
    }

    public final List<String> getOfficeNumbers() {
        return this.officeNumbers;
    }

    public final void setOfficeNumbers(List<String> list) {
        this.officeNumbers = list;
    }

    public final List<PromoInfo> getPromoInfos() {
        return this.promoInfos;
    }

    public final void setPromoInfos(List<PromoInfo> list) {
        this.promoInfos = list;
    }

    public final double getRating() {
        return this.rating;
    }

    public final void setRating(double d) {
        this.rating = d;
    }

    public final String getRegisterSource() {
        return this.registerSource;
    }

    public final void setRegisterSource(String str) {
        this.registerSource = str;
    }

    public final double getReviewNumbers() {
        return this.reviewNumbers;
    }

    public final void setReviewNumbers(double d) {
        this.reviewNumbers = d;
    }

    public final String getShopDesc() {
        return this.shopDesc;
    }

    public final void setShopDesc(String str) {
        this.shopDesc = str;
    }

    public final String getShopId() {
        return this.shopId;
    }

    public final void setShopId(String str) {
        this.shopId = str;
    }

    public final List<ShopOpenHour> getShopOpenHours() {
        return this.shopOpenHours;
    }

    public final void setShopOpenHours(List<ShopOpenHour> list) {
        this.shopOpenHours = list;
    }

    public final MerchantStatusEnum getShopStatus() {
        return this.shopStatus;
    }

    public final void setShopStatus(MerchantStatusEnum merchantStatusEnum) {
        this.shopStatus = merchantStatusEnum;
    }

    public final String getShopType() {
        return this.shopType;
    }

    public final void setShopType(String str) {
        this.shopType = str;
    }

    public final List<MerchantSubcategory> getSubcategories() {
        return this.subcategories;
    }

    public final void setSubcategories(List<? extends MerchantSubcategory> list) {
        this.subcategories = list;
    }

    public final boolean getHasMoreShop() {
        return this.hasMoreShop;
    }

    public final void setHasMoreShop(boolean z) {
        this.hasMoreShop = z;
    }

    public final String getMerchantName() {
        return this.merchantName;
    }

    public final void setMerchantName(String str) {
        this.merchantName = str;
    }

    public final Long getTransactionDate() {
        return this.transactionDate;
    }

    public final void setTransactionDate(Long l) {
        this.transactionDate = l;
    }

    public final boolean getHasDeals() {
        return this.hasDeals;
    }

    public final void setHasDeals(boolean z) {
        this.hasDeals = z;
    }

    public final boolean isMerchantIdIrrelevant() {
        if (!Intrinsics.areEqual("216620000020928274717", this.merchantId)) {
            String str = this.externalShopId;
            if (!(str != null && StringsKt.contains$default((CharSequence) str, (CharSequence) KYB_EXT_SHOP_ID, false, 2, (Object) null)) && !Intrinsics.areEqual(XENDIT_MERCHANT_ID, this.merchantId) && !Intrinsics.areEqual(XENDIT_QRIS_MERCHANT_ID, this.merchantId)) {
                return false;
            }
        }
        return true;
    }

    public final boolean isReviewCountNotValid(double reviewCount) {
        return this.reviewNumbers < reviewCount;
    }
}
