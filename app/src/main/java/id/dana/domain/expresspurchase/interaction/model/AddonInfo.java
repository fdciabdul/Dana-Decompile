package id.dana.domain.expresspurchase.interaction.model;

import com.alibaba.ariver.kernel.RVParams;
import com.alipay.iap.android.aplog.util.CrashCombineUtils;
import com.alipay.mobile.security.faceauth.api.AntDetector;
import com.appsflyer.AppsFlyerProperties;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.iap.ac.android.region.cdp.util.CdpConstants;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.sendmoney.summary.SummaryActivity;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0002&'BE\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010!\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0010¢\u0006\u0004\b$\u0010%R\"\u0010\u0003\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR.\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00108\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\bR\"\u0010\u001b\u001a\u00020\u001a8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010!\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\b"}, d2 = {"Lid/dana/domain/expresspurchase/interaction/model/AddonInfo;", "", "", "addonType", "Ljava/lang/String;", "getAddonType", "()Ljava/lang/String;", "setAddonType", "(Ljava/lang/String;)V", "Lid/dana/domain/expresspurchase/interaction/model/AddonInfo$Content;", "content", "Lid/dana/domain/expresspurchase/interaction/model/AddonInfo$Content;", "getContent", "()Lid/dana/domain/expresspurchase/interaction/model/AddonInfo$Content;", "setContent", "(Lid/dana/domain/expresspurchase/interaction/model/AddonInfo$Content;)V", "", "extendInfo", "Ljava/util/Map;", "getExtendInfo", "()Ljava/util/Map;", "setExtendInfo", "(Ljava/util/Map;)V", "goodsId", "getGoodsId", "setGoodsId", "Lid/dana/domain/expresspurchase/interaction/model/AddonInfo$ProductInfo;", "productInfo", "Lid/dana/domain/expresspurchase/interaction/model/AddonInfo$ProductInfo;", "getProductInfo", "()Lid/dana/domain/expresspurchase/interaction/model/AddonInfo$ProductInfo;", "setProductInfo", "(Lid/dana/domain/expresspurchase/interaction/model/AddonInfo$ProductInfo;)V", "templateType", "getTemplateType", "setTemplateType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/expresspurchase/interaction/model/AddonInfo$ProductInfo;Lid/dana/domain/expresspurchase/interaction/model/AddonInfo$Content;Ljava/util/Map;)V", TrackerKey.Property.CONTENT, "ProductInfo"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AddonInfo {
    private String addonType;
    private Content content;
    private Map<String, String> extendInfo;
    private String goodsId;
    private ProductInfo productInfo;
    private String templateType;

    public AddonInfo(String str, String str2, String str3, ProductInfo productInfo, Content content, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(productInfo, "");
        Intrinsics.checkNotNullParameter(content, "");
        Intrinsics.checkNotNullParameter(map, "");
        this.addonType = str;
        this.goodsId = str2;
        this.templateType = str3;
        this.productInfo = productInfo;
        this.content = content;
        this.extendInfo = map;
    }

    @JvmName(name = "getAddonType")
    public final String getAddonType() {
        return this.addonType;
    }

    @JvmName(name = "setAddonType")
    public final void setAddonType(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.addonType = str;
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

    @JvmName(name = "getTemplateType")
    public final String getTemplateType() {
        return this.templateType;
    }

    @JvmName(name = "setTemplateType")
    public final void setTemplateType(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.templateType = str;
    }

    @JvmName(name = "getProductInfo")
    public final ProductInfo getProductInfo() {
        return this.productInfo;
    }

    @JvmName(name = "setProductInfo")
    public final void setProductInfo(ProductInfo productInfo) {
        Intrinsics.checkNotNullParameter(productInfo, "");
        this.productInfo = productInfo;
    }

    @JvmName(name = "getContent")
    public final Content getContent() {
        return this.content;
    }

    @JvmName(name = "setContent")
    public final void setContent(Content content) {
        Intrinsics.checkNotNullParameter(content, "");
        this.content = content;
    }

    public /* synthetic */ AddonInfo(String str, String str2, String str3, ProductInfo productInfo, Content content, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, productInfo, content, (i & 32) != 0 ? MapsKt.emptyMap() : map);
    }

    @JvmName(name = "getExtendInfo")
    public final Map<String, String> getExtendInfo() {
        return this.extendInfo;
    }

    @JvmName(name = "setExtendInfo")
    public final void setExtendInfo(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "");
        this.extendInfo = map;
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0002JKBß\u0001\u0012\u0006\u0010\u001e\u001a\u00020\u0005\u0012\u0006\u0010\u0017\u001a\u00020\u0005\u0012\u0006\u0010 \u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010$\u001a\u00020\u0005\u0012\u0006\u0010&\u001a\u00020\u0005\u0012\u0006\u0010*\u001a\u00020\u0005\u0012\u0006\u0010(\u001a\u00020\u0005\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u000509\u0012\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0010\u0012\b\u00104\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010,\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010D\u001a\u0004\u0018\u00010C\u0012\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0010\u0012\b\b\u0002\u0010\"\u001a\u00020\u0002\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010>\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010/¢\u0006\u0004\bH\u0010IJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\"\u0010\u0006\u001a\u00020\u00058\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\tR\u001a\u0010\u000e\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000f\u0010\tR(\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00108\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0007\u001a\u0004\b\u0016\u0010\tR\u001a\u0010\u0017\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0007\u001a\u0004\b\u0018\u0010\tR\u001a\u0010\u001a\u001a\u00020\u00198\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u0007\u001a\u0004\b\u001f\u0010\tR\u001a\u0010 \u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b \u0010\u0007\u001a\u0004\b!\u0010\tR\u001a\u0010\"\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b\"\u0010\u0004R\u001a\u0010$\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010\u0007\u001a\u0004\b%\u0010\tR\u001a\u0010&\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010\u0007\u001a\u0004\b'\u0010\tR\u001a\u0010(\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010\u0007\u001a\u0004\b)\u0010\tR\u001a\u0010*\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010\u0007\u001a\u0004\b+\u0010\tR$\u0010,\u001a\u0004\u0018\u00010\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010\u0007\u001a\u0004\b-\u0010\t\"\u0004\b.\u0010\u000bR\u001c\u00100\u001a\u0004\u0018\u00010/8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R$\u00104\u001a\u0004\u0018\u00010\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b4\u0010\u0007\u001a\u0004\b5\u0010\t\"\u0004\b6\u0010\u000bR&\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00108\u0007X\u0087\u0004¢\u0006\f\n\u0004\b7\u0010\u0012\u001a\u0004\b8\u0010\u0014R \u0010:\u001a\b\u0012\u0004\u0012\u00020\u0005098\u0007X\u0087\u0004¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u001c\u0010?\u001a\u0004\u0018\u00010>8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u001c\u0010D\u001a\u0004\u0018\u00010C8\u0007X\u0087\u0004¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G"}, d2 = {"Lid/dana/domain/expresspurchase/interaction/model/AddonInfo$ProductInfo;", "", "", "isVoucherBundle", "()Z", "", "aggregatorGoodsId", "Ljava/lang/String;", "getAggregatorGoodsId", "()Ljava/lang/String;", "setAggregatorGoodsId", "(Ljava/lang/String;)V", "aggregatorId", "getAggregatorId", "aggregatorName", "getAggregatorName", "", "extendInfo", "Ljava/util/Map;", "getExtendInfo", "()Ljava/util/Map;", "finType", "getFinType", "goodsDescription", "getGoodsDescription", "Lid/dana/domain/expresspurchase/interaction/model/AddonInfo$ProductInfo$GoodsPrice;", "goodsPrice", "Lid/dana/domain/expresspurchase/interaction/model/AddonInfo$ProductInfo$GoodsPrice;", "getGoodsPrice", "()Lid/dana/domain/expresspurchase/interaction/model/AddonInfo$ProductInfo$GoodsPrice;", "goodsTitle", "getGoodsTitle", "goodsType", "getGoodsType", "isOnlineMerchant", "Z", "merchantId", "getMerchantId", "merchantName", "getMerchantName", "providerCategory", "getProviderCategory", "providerName", "getProviderName", "refId", "getRefId", "setRefId", "", "totalDiscountValue", "Ljava/lang/Double;", "getTotalDiscountValue", "()Ljava/lang/Double;", "type", "getType", "setType", "validationInfo", "getValidationInfo", "", "validationTypes", "Ljava/util/List;", "getValidationTypes", "()Ljava/util/List;", "Lid/dana/domain/expresspurchase/interaction/model/AddonInfo$ProductInfo$VoucherBundleInfo;", "voucherBundleInfo", "Lid/dana/domain/expresspurchase/interaction/model/AddonInfo$ProductInfo$VoucherBundleInfo;", "getVoucherBundleInfo", "()Lid/dana/domain/expresspurchase/interaction/model/AddonInfo$ProductInfo$VoucherBundleInfo;", "Lid/dana/domain/expresspurchase/interaction/model/VoucherExpressInfo;", "voucherInfo", "Lid/dana/domain/expresspurchase/interaction/model/VoucherExpressInfo;", "getVoucherInfo", "()Lid/dana/domain/expresspurchase/interaction/model/VoucherExpressInfo;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/expresspurchase/interaction/model/AddonInfo$ProductInfo$GoodsPrice;Ljava/util/List;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/expresspurchase/interaction/model/VoucherExpressInfo;Ljava/util/Map;ZLid/dana/domain/expresspurchase/interaction/model/AddonInfo$ProductInfo$VoucherBundleInfo;Ljava/lang/String;Ljava/lang/Double;)V", "GoodsPrice", "VoucherBundleInfo"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class ProductInfo {
        private String aggregatorGoodsId;
        private final String aggregatorId;
        private final String aggregatorName;
        private final Map<String, String> extendInfo;
        private final String finType;
        private final String goodsDescription;
        private final GoodsPrice goodsPrice;
        private final String goodsTitle;
        private final String goodsType;
        private final boolean isOnlineMerchant;
        private final String merchantId;
        private final String merchantName;
        private final String providerCategory;
        private final String providerName;
        private String refId;
        private final Double totalDiscountValue;
        private String type;
        private final Map<String, Object> validationInfo;
        private final List<String> validationTypes;
        private final VoucherBundleInfo voucherBundleInfo;
        private final VoucherExpressInfo voucherInfo;

        public ProductInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, GoodsPrice goodsPrice, List<String> list, Map<String, ? extends Object> map, String str11, String str12, VoucherExpressInfo voucherExpressInfo, Map<String, String> map2, boolean z, VoucherBundleInfo voucherBundleInfo, String str13, Double d) {
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
            Intrinsics.checkNotNullParameter(goodsPrice, "");
            Intrinsics.checkNotNullParameter(list, "");
            Intrinsics.checkNotNullParameter(map, "");
            Intrinsics.checkNotNullParameter(str13, "");
            this.goodsTitle = str;
            this.goodsDescription = str2;
            this.goodsType = str3;
            this.aggregatorId = str4;
            this.aggregatorGoodsId = str5;
            this.finType = str6;
            this.merchantId = str7;
            this.merchantName = str8;
            this.providerName = str9;
            this.providerCategory = str10;
            this.goodsPrice = goodsPrice;
            this.validationTypes = list;
            this.validationInfo = map;
            this.type = str11;
            this.refId = str12;
            this.voucherInfo = voucherExpressInfo;
            this.extendInfo = map2;
            this.isOnlineMerchant = z;
            this.voucherBundleInfo = voucherBundleInfo;
            this.aggregatorName = str13;
            this.totalDiscountValue = d;
        }

        public /* synthetic */ ProductInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, GoodsPrice goodsPrice, List list, Map map, String str11, String str12, VoucherExpressInfo voucherExpressInfo, Map map2, boolean z, VoucherBundleInfo voucherBundleInfo, String str13, Double d, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, goodsPrice, list, map, str11, str12, voucherExpressInfo, map2, (i & AntDetector.SCENE_ID_LOGIN_REGIST) != 0 ? false : z, (i & 262144) != 0 ? null : voucherBundleInfo, str13, (i & CrashCombineUtils.DEFAULT_MAX_INFO_LEN) != 0 ? null : d);
        }

        @JvmName(name = "getGoodsTitle")
        public final String getGoodsTitle() {
            return this.goodsTitle;
        }

        @JvmName(name = "getGoodsDescription")
        public final String getGoodsDescription() {
            return this.goodsDescription;
        }

        @JvmName(name = "getGoodsType")
        public final String getGoodsType() {
            return this.goodsType;
        }

        @JvmName(name = "getAggregatorId")
        public final String getAggregatorId() {
            return this.aggregatorId;
        }

        @JvmName(name = "getAggregatorGoodsId")
        public final String getAggregatorGoodsId() {
            return this.aggregatorGoodsId;
        }

        @JvmName(name = "setAggregatorGoodsId")
        public final void setAggregatorGoodsId(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.aggregatorGoodsId = str;
        }

        @JvmName(name = "getFinType")
        public final String getFinType() {
            return this.finType;
        }

        @JvmName(name = "getMerchantId")
        public final String getMerchantId() {
            return this.merchantId;
        }

        @JvmName(name = "getMerchantName")
        public final String getMerchantName() {
            return this.merchantName;
        }

        @JvmName(name = "getProviderName")
        public final String getProviderName() {
            return this.providerName;
        }

        @JvmName(name = "getProviderCategory")
        public final String getProviderCategory() {
            return this.providerCategory;
        }

        @JvmName(name = "getGoodsPrice")
        public final GoodsPrice getGoodsPrice() {
            return this.goodsPrice;
        }

        @JvmName(name = "getValidationTypes")
        public final List<String> getValidationTypes() {
            return this.validationTypes;
        }

        @JvmName(name = "getValidationInfo")
        public final Map<String, Object> getValidationInfo() {
            return this.validationInfo;
        }

        @JvmName(name = "getType")
        public final String getType() {
            return this.type;
        }

        @JvmName(name = "setType")
        public final void setType(String str) {
            this.type = str;
        }

        @JvmName(name = "getRefId")
        public final String getRefId() {
            return this.refId;
        }

        @JvmName(name = "setRefId")
        public final void setRefId(String str) {
            this.refId = str;
        }

        @JvmName(name = "getVoucherInfo")
        public final VoucherExpressInfo getVoucherInfo() {
            return this.voucherInfo;
        }

        @JvmName(name = "getExtendInfo")
        public final Map<String, String> getExtendInfo() {
            return this.extendInfo;
        }

        @JvmName(name = "isOnlineMerchant")
        /* renamed from: isOnlineMerchant  reason: from getter */
        public final boolean getIsOnlineMerchant() {
            return this.isOnlineMerchant;
        }

        @JvmName(name = "getVoucherBundleInfo")
        public final VoucherBundleInfo getVoucherBundleInfo() {
            return this.voucherBundleInfo;
        }

        @JvmName(name = "getAggregatorName")
        public final String getAggregatorName() {
            return this.aggregatorName;
        }

        @JvmName(name = "getTotalDiscountValue")
        public final Double getTotalDiscountValue() {
            return this.totalDiscountValue;
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0010\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0013\u0010\u000b"}, d2 = {"Lid/dana/domain/expresspurchase/interaction/model/AddonInfo$ProductInfo$GoodsPrice;", "", "", "amount", SummaryActivity.DAYS, "getAmount", "()D", "", "cent", "Ljava/lang/String;", "getCent", "()Ljava/lang/String;", "centFactor", "getCentFactor", FirebaseAnalytics.Param.CURRENCY, "getCurrency", AppsFlyerProperties.CURRENCY_CODE, "getCurrencyCode", "currencyValue", "getCurrencyValue", "<init>", "(DLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class GoodsPrice {
            private final double amount;
            private final String cent;
            private final String centFactor;
            private final String currency;
            private final String currencyCode;
            private final String currencyValue;

            public GoodsPrice(double d, String str, String str2, String str3, String str4, String str5) {
                Intrinsics.checkNotNullParameter(str, "");
                Intrinsics.checkNotNullParameter(str2, "");
                Intrinsics.checkNotNullParameter(str3, "");
                Intrinsics.checkNotNullParameter(str4, "");
                Intrinsics.checkNotNullParameter(str5, "");
                this.amount = d;
                this.cent = str;
                this.centFactor = str2;
                this.currency = str3;
                this.currencyCode = str4;
                this.currencyValue = str5;
            }

            @JvmName(name = "getAmount")
            public final double getAmount() {
                return this.amount;
            }

            @JvmName(name = "getCent")
            public final String getCent() {
                return this.cent;
            }

            @JvmName(name = "getCentFactor")
            public final String getCentFactor() {
                return this.centFactor;
            }

            @JvmName(name = "getCurrency")
            public final String getCurrency() {
                return this.currency;
            }

            @JvmName(name = "getCurrencyCode")
            public final String getCurrencyCode() {
                return this.currencyCode;
            }

            @JvmName(name = "getCurrencyValue")
            public final String getCurrencyValue() {
                return this.currencyValue;
            }
        }

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/domain/expresspurchase/interaction/model/AddonInfo$ProductInfo$VoucherBundleInfo;", "", "", "multiMerchant", "Ljava/lang/Boolean;", "getMultiMerchant", "()Ljava/lang/Boolean;", "<init>", "(Ljava/lang/Boolean;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class VoucherBundleInfo {
            private final Boolean multiMerchant;

            /* JADX WARN: Illegal instructions before constructor call */
            /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.Boolean] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public VoucherBundleInfo() {
                /*
                    r2 = this;
                    r0 = 0
                    r1 = 1
                    r2.<init>(r0, r1, r0)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.expresspurchase.interaction.model.AddonInfo.ProductInfo.VoucherBundleInfo.<init>():void");
            }

            public VoucherBundleInfo(Boolean bool) {
                this.multiMerchant = bool;
            }

            public /* synthetic */ VoucherBundleInfo(Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? Boolean.FALSE : bool);
            }

            @JvmName(name = "getMultiMerchant")
            public final Boolean getMultiMerchant() {
                return this.multiMerchant;
            }
        }

        public final boolean isVoucherBundle() {
            return this.voucherBundleInfo != null;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u001a\u0018\u00002\u00020\u0001:\u0002,-B\u008d\u0001\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010$\u001a\u00020\u0002\u0012\u0006\u0010 \u001a\u00020\u0002\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\"\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010(\u001a\u00020\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010&\u001a\u00020\u0002¢\u0006\u0004\b*\u0010+R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u000f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001a\u0010\u0011\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00138\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0015\u001a\u0004\b\u001d\u0010\u0017R\u001a\u0010\u001e\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006R\u001a\u0010 \u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006R\u001a\u0010\"\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010\u0004\u001a\u0004\b#\u0010\u0006R\u001a\u0010$\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010\u0004\u001a\u0004\b%\u0010\u0006R\u001a\u0010&\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010\u0004\u001a\u0004\b'\u0010\u0006R\u001a\u0010(\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010\u0004\u001a\u0004\b)\u0010\u0006"}, d2 = {"Lid/dana/domain/expresspurchase/interaction/model/AddonInfo$Content;", "", "", "benefitDescription", "Ljava/lang/String;", "getBenefitDescription", "()Ljava/lang/String;", "", "Lid/dana/domain/expresspurchase/interaction/model/AddonInfo$Content$Benefit;", "benefits", "Ljava/util/List;", "getBenefits", "()Ljava/util/List;", "buyButtonLabel", "getBuyButtonLabel", "buyButtonRedirectionUrl", "getBuyButtonRedirectionUrl", CdpConstants.CONTENT_IMAGE_URL, "getImgUrl", "Lid/dana/domain/expresspurchase/interaction/model/AddonInfo$Content$ResultConfirmation;", "onBalanceNotEnough", "Lid/dana/domain/expresspurchase/interaction/model/AddonInfo$Content$ResultConfirmation;", "getOnBalanceNotEnough", "()Lid/dana/domain/expresspurchase/interaction/model/AddonInfo$Content$ResultConfirmation;", "onFailed", "getOnFailed", "onPending", "getOnPending", "onSuccess", "getOnSuccess", "purchaseInformation", "getPurchaseInformation", RVParams.LONG_SUB_TITLE, "getSubTitle", "supervision", "getSupervision", "title", "getTitle", "tncContent", "getTncContent", "tncUrl", "getTncUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/expresspurchase/interaction/model/AddonInfo$Content$ResultConfirmation;Lid/dana/domain/expresspurchase/interaction/model/AddonInfo$Content$ResultConfirmation;Lid/dana/domain/expresspurchase/interaction/model/AddonInfo$Content$ResultConfirmation;Lid/dana/domain/expresspurchase/interaction/model/AddonInfo$Content$ResultConfirmation;Ljava/lang/String;)V", "Benefit", "ResultConfirmation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Content {
        private final String benefitDescription;
        private final List<Benefit> benefits;
        private final String buyButtonLabel;
        private final String buyButtonRedirectionUrl;
        private final String imgUrl;
        private final ResultConfirmation onBalanceNotEnough;
        private final ResultConfirmation onFailed;
        private final ResultConfirmation onPending;
        private final ResultConfirmation onSuccess;
        private final String purchaseInformation;
        private final String subTitle;
        private final String supervision;
        private final String title;
        private final String tncContent;
        private final String tncUrl;

        public Content(String str, String str2, String str3, List<Benefit> list, String str4, String str5, String str6, String str7, String str8, String str9, ResultConfirmation resultConfirmation, ResultConfirmation resultConfirmation2, ResultConfirmation resultConfirmation3, ResultConfirmation resultConfirmation4, String str10) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str3, "");
            Intrinsics.checkNotNullParameter(list, "");
            Intrinsics.checkNotNullParameter(str4, "");
            Intrinsics.checkNotNullParameter(str5, "");
            Intrinsics.checkNotNullParameter(str6, "");
            Intrinsics.checkNotNullParameter(str7, "");
            Intrinsics.checkNotNullParameter(str8, "");
            Intrinsics.checkNotNullParameter(str9, "");
            Intrinsics.checkNotNullParameter(str10, "");
            this.imgUrl = str;
            this.title = str2;
            this.subTitle = str3;
            this.benefits = list;
            this.supervision = str4;
            this.benefitDescription = str5;
            this.tncUrl = str6;
            this.purchaseInformation = str7;
            this.buyButtonLabel = str8;
            this.buyButtonRedirectionUrl = str9;
            this.onSuccess = resultConfirmation;
            this.onPending = resultConfirmation2;
            this.onFailed = resultConfirmation3;
            this.onBalanceNotEnough = resultConfirmation4;
            this.tncContent = str10;
        }

        @JvmName(name = "getImgUrl")
        public final String getImgUrl() {
            return this.imgUrl;
        }

        @JvmName(name = "getTitle")
        public final String getTitle() {
            return this.title;
        }

        @JvmName(name = "getSubTitle")
        public final String getSubTitle() {
            return this.subTitle;
        }

        @JvmName(name = "getBenefits")
        public final List<Benefit> getBenefits() {
            return this.benefits;
        }

        @JvmName(name = "getSupervision")
        public final String getSupervision() {
            return this.supervision;
        }

        @JvmName(name = "getBenefitDescription")
        public final String getBenefitDescription() {
            return this.benefitDescription;
        }

        @JvmName(name = "getTncUrl")
        public final String getTncUrl() {
            return this.tncUrl;
        }

        @JvmName(name = "getPurchaseInformation")
        public final String getPurchaseInformation() {
            return this.purchaseInformation;
        }

        @JvmName(name = "getBuyButtonLabel")
        public final String getBuyButtonLabel() {
            return this.buyButtonLabel;
        }

        @JvmName(name = "getBuyButtonRedirectionUrl")
        public final String getBuyButtonRedirectionUrl() {
            return this.buyButtonRedirectionUrl;
        }

        @JvmName(name = "getOnSuccess")
        public final ResultConfirmation getOnSuccess() {
            return this.onSuccess;
        }

        @JvmName(name = "getOnPending")
        public final ResultConfirmation getOnPending() {
            return this.onPending;
        }

        @JvmName(name = "getOnFailed")
        public final ResultConfirmation getOnFailed() {
            return this.onFailed;
        }

        @JvmName(name = "getOnBalanceNotEnough")
        public final ResultConfirmation getOnBalanceNotEnough() {
            return this.onBalanceNotEnough;
        }

        @JvmName(name = "getTncContent")
        public final String getTncContent() {
            return this.tncContent;
        }

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006"}, d2 = {"Lid/dana/domain/expresspurchase/interaction/model/AddonInfo$Content$Benefit;", "", "", "description", "Ljava/lang/String;", "getDescription", "()Ljava/lang/String;", CdpConstants.CONTENT_IMAGE_URL, "getImgUrl", "title", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Benefit {
            private final String description;
            private final String imgUrl;
            private final String title;

            public Benefit(String str, String str2, String str3) {
                Intrinsics.checkNotNullParameter(str, "");
                Intrinsics.checkNotNullParameter(str2, "");
                Intrinsics.checkNotNullParameter(str3, "");
                this.imgUrl = str;
                this.title = str2;
                this.description = str3;
            }

            @JvmName(name = "getImgUrl")
            public final String getImgUrl() {
                return this.imgUrl;
            }

            @JvmName(name = "getTitle")
            public final String getTitle() {
                return this.title;
            }

            @JvmName(name = "getDescription")
            public final String getDescription() {
                return this.description;
            }
        }

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006"}, d2 = {"Lid/dana/domain/expresspurchase/interaction/model/AddonInfo$Content$ResultConfirmation;", "", "", "actionLabel", "Ljava/lang/String;", "getActionLabel", "()Ljava/lang/String;", CdpConstants.CONTENT_IMAGE_URL, "getImgUrl", "infoLabel", "getInfoLabel", "infoTitle", "getInfoTitle", "redirectUrl", "getRedirectUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class ResultConfirmation {
            private final String actionLabel;
            private final String imgUrl;
            private final String infoLabel;
            private final String infoTitle;
            private final String redirectUrl;

            public ResultConfirmation(String str, String str2, String str3, String str4, String str5) {
                Intrinsics.checkNotNullParameter(str, "");
                Intrinsics.checkNotNullParameter(str2, "");
                Intrinsics.checkNotNullParameter(str3, "");
                Intrinsics.checkNotNullParameter(str4, "");
                Intrinsics.checkNotNullParameter(str5, "");
                this.imgUrl = str;
                this.infoTitle = str2;
                this.infoLabel = str3;
                this.redirectUrl = str4;
                this.actionLabel = str5;
            }

            public /* synthetic */ ResultConfirmation(String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, str2, str3, (i & 8) != 0 ? "" : str4, str5);
            }

            @JvmName(name = "getImgUrl")
            public final String getImgUrl() {
                return this.imgUrl;
            }

            @JvmName(name = "getInfoTitle")
            public final String getInfoTitle() {
                return this.infoTitle;
            }

            @JvmName(name = "getInfoLabel")
            public final String getInfoLabel() {
                return this.infoLabel;
            }

            @JvmName(name = "getRedirectUrl")
            public final String getRedirectUrl() {
                return this.redirectUrl;
            }

            @JvmName(name = "getActionLabel")
            public final String getActionLabel() {
                return this.actionLabel;
            }
        }
    }
}
