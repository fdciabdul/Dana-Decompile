package id.dana.data.expresspurchase.source.network.pojo.response;

import com.alibaba.ariver.kernel.RVParams;
import com.alipay.iap.android.aplog.util.CrashCombineUtils;
import com.appsflyer.AppsFlyerProperties;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import com.iap.ac.android.region.cdp.util.CdpConstants;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.network.base.BaseRpcResultAphome;
import id.dana.sendmoney.summary.SummaryActivity;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0005\u0015\u0016\u0017\u0018\u0019B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0003\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001a\u0010\u000f\u001a\u00020\u000e8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/data/expresspurchase/source/network/pojo/response/GetExpressPurchaseResponse;", "Lid/dana/network/base/BaseRpcResultAphome;", "", "addonType", "Ljava/lang/String;", "getAddonType", "()Ljava/lang/String;", "Lid/dana/data/expresspurchase/source/network/pojo/response/GetExpressPurchaseResponse$Content;", "content", "Lid/dana/data/expresspurchase/source/network/pojo/response/GetExpressPurchaseResponse$Content;", "getContent", "()Lid/dana/data/expresspurchase/source/network/pojo/response/GetExpressPurchaseResponse$Content;", "goodsId", "getGoodsId", "Lid/dana/data/expresspurchase/source/network/pojo/response/GetExpressPurchaseResponse$AddonProductInfo;", "productInfo", "Lid/dana/data/expresspurchase/source/network/pojo/response/GetExpressPurchaseResponse$AddonProductInfo;", "getProductInfo", "()Lid/dana/data/expresspurchase/source/network/pojo/response/GetExpressPurchaseResponse$AddonProductInfo;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lid/dana/data/expresspurchase/source/network/pojo/response/GetExpressPurchaseResponse$AddonProductInfo;Lid/dana/data/expresspurchase/source/network/pojo/response/GetExpressPurchaseResponse$Content;)V", "AddonProductInfo", TrackerKey.Property.CONTENT, "PriceEntity", "VoucherColorCodeResponse", "VoucherExpressInfoEntity"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetExpressPurchaseResponse extends BaseRpcResultAphome {
    @SerializedName("addonType")
    private final String addonType;
    private final Content content;
    private final String goodsId;
    private final AddonProductInfo productInfo;

    @JvmName(name = "getAddonType")
    public final String getAddonType() {
        return this.addonType;
    }

    @JvmName(name = "getGoodsId")
    public final String getGoodsId() {
        return this.goodsId;
    }

    @JvmName(name = "getProductInfo")
    public final AddonProductInfo getProductInfo() {
        return this.productInfo;
    }

    @JvmName(name = "getContent")
    public final Content getContent() {
        return this.content;
    }

    public GetExpressPurchaseResponse(String str, String str2, AddonProductInfo addonProductInfo, Content content) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(addonProductInfo, "");
        Intrinsics.checkNotNullParameter(content, "");
        this.addonType = str;
        this.goodsId = str2;
        this.productInfo = addonProductInfo;
        this.content = content;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001d\u0018\u00002\u00020\u0001Bw\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b,\u0010-R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R$\u0010\u001a\u001a\u0004\u0018\u00010\u00108\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R$\u0010\u001d\u001a\u0004\u0018\u00010\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001e\u0010\r\"\u0004\b\u001f\u0010\u000fR$\u0010 \u001a\u0004\u0018\u00010\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u000b\u001a\u0004\b!\u0010\r\"\u0004\b\"\u0010\u000fR$\u0010#\u001a\u0004\u0018\u00010\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u000b\u001a\u0004\b$\u0010\r\"\u0004\b%\u0010\u000fR$\u0010&\u001a\u0004\u0018\u00010\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u000b\u001a\u0004\b'\u0010\r\"\u0004\b(\u0010\u000fR$\u0010)\u001a\u0004\u0018\u00010\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010\u000b\u001a\u0004\b*\u0010\r\"\u0004\b+\u0010\u000f"}, d2 = {"Lid/dana/data/expresspurchase/source/network/pojo/response/GetExpressPurchaseResponse$VoucherExpressInfoEntity;", "", "Lid/dana/data/expresspurchase/source/network/pojo/response/GetExpressPurchaseResponse$VoucherColorCodeResponse;", "colorCode", "Lid/dana/data/expresspurchase/source/network/pojo/response/GetExpressPurchaseResponse$VoucherColorCodeResponse;", "getColorCode", "()Lid/dana/data/expresspurchase/source/network/pojo/response/GetExpressPurchaseResponse$VoucherColorCodeResponse;", "setColorCode", "(Lid/dana/data/expresspurchase/source/network/pojo/response/GetExpressPurchaseResponse$VoucherColorCodeResponse;)V", "", "discountOffRate", "Ljava/lang/String;", "getDiscountOffRate", "()Ljava/lang/String;", "setDiscountOffRate", "(Ljava/lang/String;)V", "Lid/dana/data/expresspurchase/source/network/pojo/response/GetExpressPurchaseResponse$PriceEntity;", "displayStrikethroughPrice", "Lid/dana/data/expresspurchase/source/network/pojo/response/GetExpressPurchaseResponse$PriceEntity;", "getDisplayStrikethroughPrice", "()Lid/dana/data/expresspurchase/source/network/pojo/response/GetExpressPurchaseResponse$PriceEntity;", "setDisplayStrikethroughPrice", "(Lid/dana/data/expresspurchase/source/network/pojo/response/GetExpressPurchaseResponse$PriceEntity;)V", "displayVoucherPrice", "getDisplayVoucherPrice", "setDisplayVoucherPrice", "displayVoucherValue", "getDisplayVoucherValue", "setDisplayVoucherValue", "minTransaction", "getMinTransaction", "setMinTransaction", "validityPeriod", "getValidityPeriod", "setValidityPeriod", "voucherBackGround", "getVoucherBackGround", "setVoucherBackGround", "voucherIcon", "getVoucherIcon", "setVoucherIcon", "voucherName", "getVoucherName", "setVoucherName", "<init>", "(Ljava/lang/String;Lid/dana/data/expresspurchase/source/network/pojo/response/GetExpressPurchaseResponse$PriceEntity;Lid/dana/data/expresspurchase/source/network/pojo/response/GetExpressPurchaseResponse$PriceEntity;Lid/dana/data/expresspurchase/source/network/pojo/response/GetExpressPurchaseResponse$PriceEntity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/data/expresspurchase/source/network/pojo/response/GetExpressPurchaseResponse$VoucherColorCodeResponse;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class VoucherExpressInfoEntity {
        private VoucherColorCodeResponse colorCode;
        @SerializedName("discountValue")
        private String discountOffRate;
        private PriceEntity displayStrikethroughPrice;
        private PriceEntity displayVoucherPrice;
        private PriceEntity displayVoucherValue;
        private String minTransaction;
        private String validityPeriod;
        private String voucherBackGround;
        private String voucherIcon;
        private String voucherName;

        public VoucherExpressInfoEntity(String str, PriceEntity priceEntity, PriceEntity priceEntity2, PriceEntity priceEntity3, String str2, String str3, String str4, String str5, String str6, VoucherColorCodeResponse voucherColorCodeResponse) {
            this.discountOffRate = str;
            this.displayStrikethroughPrice = priceEntity;
            this.displayVoucherPrice = priceEntity2;
            this.displayVoucherValue = priceEntity3;
            this.voucherBackGround = str2;
            this.voucherIcon = str3;
            this.voucherName = str4;
            this.minTransaction = str5;
            this.validityPeriod = str6;
            this.colorCode = voucherColorCodeResponse;
        }

        @JvmName(name = "getDiscountOffRate")
        public final String getDiscountOffRate() {
            return this.discountOffRate;
        }

        @JvmName(name = "setDiscountOffRate")
        public final void setDiscountOffRate(String str) {
            this.discountOffRate = str;
        }

        @JvmName(name = "getDisplayStrikethroughPrice")
        public final PriceEntity getDisplayStrikethroughPrice() {
            return this.displayStrikethroughPrice;
        }

        @JvmName(name = "setDisplayStrikethroughPrice")
        public final void setDisplayStrikethroughPrice(PriceEntity priceEntity) {
            this.displayStrikethroughPrice = priceEntity;
        }

        @JvmName(name = "getDisplayVoucherPrice")
        public final PriceEntity getDisplayVoucherPrice() {
            return this.displayVoucherPrice;
        }

        @JvmName(name = "setDisplayVoucherPrice")
        public final void setDisplayVoucherPrice(PriceEntity priceEntity) {
            this.displayVoucherPrice = priceEntity;
        }

        @JvmName(name = "getDisplayVoucherValue")
        public final PriceEntity getDisplayVoucherValue() {
            return this.displayVoucherValue;
        }

        @JvmName(name = "setDisplayVoucherValue")
        public final void setDisplayVoucherValue(PriceEntity priceEntity) {
            this.displayVoucherValue = priceEntity;
        }

        @JvmName(name = "getVoucherBackGround")
        public final String getVoucherBackGround() {
            return this.voucherBackGround;
        }

        @JvmName(name = "setVoucherBackGround")
        public final void setVoucherBackGround(String str) {
            this.voucherBackGround = str;
        }

        @JvmName(name = "getVoucherIcon")
        public final String getVoucherIcon() {
            return this.voucherIcon;
        }

        @JvmName(name = "setVoucherIcon")
        public final void setVoucherIcon(String str) {
            this.voucherIcon = str;
        }

        @JvmName(name = "getVoucherName")
        public final String getVoucherName() {
            return this.voucherName;
        }

        @JvmName(name = "setVoucherName")
        public final void setVoucherName(String str) {
            this.voucherName = str;
        }

        @JvmName(name = "getMinTransaction")
        public final String getMinTransaction() {
            return this.minTransaction;
        }

        @JvmName(name = "setMinTransaction")
        public final void setMinTransaction(String str) {
            this.minTransaction = str;
        }

        @JvmName(name = "getValidityPeriod")
        public final String getValidityPeriod() {
            return this.validityPeriod;
        }

        @JvmName(name = "setValidityPeriod")
        public final void setValidityPeriod(String str) {
            this.validityPeriod = str;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public /* synthetic */ VoucherExpressInfoEntity(java.lang.String r15, id.dana.data.expresspurchase.source.network.pojo.response.GetExpressPurchaseResponse.PriceEntity r16, id.dana.data.expresspurchase.source.network.pojo.response.GetExpressPurchaseResponse.PriceEntity r17, id.dana.data.expresspurchase.source.network.pojo.response.GetExpressPurchaseResponse.PriceEntity r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, id.dana.data.expresspurchase.source.network.pojo.response.GetExpressPurchaseResponse.VoucherColorCodeResponse r24, int r25, kotlin.jvm.internal.DefaultConstructorMarker r26) {
            /*
                r14 = this;
                r0 = r25
                r1 = r0 & 16
                java.lang.String r2 = ""
                if (r1 == 0) goto La
                r8 = r2
                goto Lc
            La:
                r8 = r19
            Lc:
                r1 = r0 & 32
                if (r1 == 0) goto L12
                r9 = r2
                goto L14
            L12:
                r9 = r20
            L14:
                r1 = r0 & 64
                if (r1 == 0) goto L1a
                r10 = r2
                goto L1c
            L1a:
                r10 = r21
            L1c:
                r1 = r0 & 128(0x80, float:1.794E-43)
                if (r1 == 0) goto L22
                r11 = r2
                goto L24
            L22:
                r11 = r22
            L24:
                r1 = r0 & 256(0x100, float:3.59E-43)
                if (r1 == 0) goto L2a
                r12 = r2
                goto L2c
            L2a:
                r12 = r23
            L2c:
                r0 = r0 & 512(0x200, float:7.175E-43)
                if (r0 == 0) goto L39
                id.dana.data.expresspurchase.source.network.pojo.response.GetExpressPurchaseResponse$VoucherColorCodeResponse r0 = new id.dana.data.expresspurchase.source.network.pojo.response.GetExpressPurchaseResponse$VoucherColorCodeResponse
                r1 = 3
                r2 = 0
                r0.<init>(r2, r2, r1, r2)
                r13 = r0
                goto L3b
            L39:
                r13 = r24
            L3b:
                r3 = r14
                r4 = r15
                r5 = r16
                r6 = r17
                r7 = r18
                r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.data.expresspurchase.source.network.pojo.response.GetExpressPurchaseResponse.VoucherExpressInfoEntity.<init>(java.lang.String, id.dana.data.expresspurchase.source.network.pojo.response.GetExpressPurchaseResponse$PriceEntity, id.dana.data.expresspurchase.source.network.pojo.response.GetExpressPurchaseResponse$PriceEntity, id.dana.data.expresspurchase.source.network.pojo.response.GetExpressPurchaseResponse$PriceEntity, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, id.dana.data.expresspurchase.source.network.pojo.response.GetExpressPurchaseResponse$VoucherColorCodeResponse, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        @JvmName(name = "getColorCode")
        public final VoucherColorCodeResponse getColorCode() {
            return this.colorCode;
        }

        @JvmName(name = "setColorCode")
        public final void setColorCode(VoucherColorCodeResponse voucherColorCodeResponse) {
            this.colorCode = voucherColorCodeResponse;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006"}, d2 = {"Lid/dana/data/expresspurchase/source/network/pojo/response/GetExpressPurchaseResponse$VoucherColorCodeResponse;", "", "", "backgroundColorCode", "Ljava/lang/String;", "getBackgroundColorCode", "()Ljava/lang/String;", "fontColorCode", "getFontColorCode", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class VoucherColorCodeResponse {
        private final String backgroundColorCode;
        private final String fontColorCode;

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public VoucherColorCodeResponse() {
            /*
                r2 = this;
                r0 = 0
                r1 = 3
                r2.<init>(r0, r0, r1, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.data.expresspurchase.source.network.pojo.response.GetExpressPurchaseResponse.VoucherColorCodeResponse.<init>():void");
        }

        public VoucherColorCodeResponse(String str, String str2) {
            this.fontColorCode = str;
            this.backgroundColorCode = str2;
        }

        public /* synthetic */ VoucherColorCodeResponse(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
        }

        @JvmName(name = "getFontColorCode")
        public final String getFontColorCode() {
            return this.fontColorCode;
        }

        @JvmName(name = "getBackgroundColorCode")
        public final String getBackgroundColorCode() {
            return this.backgroundColorCode;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0003\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b"}, d2 = {"Lid/dana/data/expresspurchase/source/network/pojo/response/GetExpressPurchaseResponse$PriceEntity;", "", "", "amount", "Ljava/lang/String;", "getAmount", "()Ljava/lang/String;", "setAmount", "(Ljava/lang/String;)V", FirebaseAnalytics.Param.CURRENCY, "getCurrency", "setCurrency", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class PriceEntity {
        private String amount;
        private String currency;

        public PriceEntity(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            this.amount = str;
            this.currency = str2;
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

        @JvmName(name = "getCurrency")
        public final String getCurrency() {
            return this.currency;
        }

        @JvmName(name = "setCurrency")
        public final void setCurrency(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.currency = str;
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0002JKBÿ\u0001\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010-\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u000e\u0010:\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u000109\u0012\u0014\u00107\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b\u0012\b\u0010D\u001a\u0004\u0018\u00010C\u0012\b\u00100\u001a\u0004\u0018\u00010/\u0012\b\u00104\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010)\u001a\u0004\u0018\u00010\u0002\u0012\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000b\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010>\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\bH\u0010IR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R(\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001a\u0010\u0015\u001a\u00020\u00148\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001e\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006R\u001c\u0010#\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\u0006R\u001c\u0010%\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006R\u001c\u0010'\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010\u0004\u001a\u0004\b(\u0010\u0006R$\u0010)\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010\u0004\u001a\u0004\b*\u0010\u0006\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010\u0004\u001a\u0004\b.\u0010\u0006R\u001c\u00100\u001a\u0004\u0018\u00010/8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R$\u00104\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b4\u0010\u0004\u001a\u0004\b5\u0010\u0006\"\u0004\b6\u0010,R(\u00107\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b7\u0010\r\u001a\u0004\b8\u0010\u000fR\"\u0010:\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001098\u0007X\u0087\u0004¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u001c\u0010?\u001a\u0004\u0018\u00010>8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u001c\u0010D\u001a\u0004\u0018\u00010C8\u0007X\u0087\u0004¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G"}, d2 = {"Lid/dana/data/expresspurchase/source/network/pojo/response/GetExpressPurchaseResponse$AddonProductInfo;", "", "", "aggregatorGoodsId", "Ljava/lang/String;", "getAggregatorGoodsId", "()Ljava/lang/String;", "aggregatorId", "getAggregatorId", "aggregatorName", "getAggregatorName", "", "extendInfo", "Ljava/util/Map;", "getExtendInfo", "()Ljava/util/Map;", "finType", "getFinType", "goodsDescription", "getGoodsDescription", "Lid/dana/data/expresspurchase/source/network/pojo/response/GetExpressPurchaseResponse$AddonProductInfo$MultiCurrencyMoney;", "goodsPrice", "Lid/dana/data/expresspurchase/source/network/pojo/response/GetExpressPurchaseResponse$AddonProductInfo$MultiCurrencyMoney;", "getGoodsPrice", "()Lid/dana/data/expresspurchase/source/network/pojo/response/GetExpressPurchaseResponse$AddonProductInfo$MultiCurrencyMoney;", "goodsTitle", "getGoodsTitle", "goodsType", "getGoodsType", "", "isOnlineMerchant", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "merchantId", "getMerchantId", "merchantName", "getMerchantName", "providerCategory", "getProviderCategory", "providerName", "getProviderName", "refId", "getRefId", "setRefId", "(Ljava/lang/String;)V", "templateType", "getTemplateType", "", "totalDiscountValue", "Ljava/lang/Double;", "getTotalDiscountValue", "()Ljava/lang/Double;", "type", "getType", "setType", "validationInfo", "getValidationInfo", "", "validationTypes", "Ljava/util/List;", "getValidationTypes", "()Ljava/util/List;", "Lid/dana/data/expresspurchase/source/network/pojo/response/GetExpressPurchaseResponse$AddonProductInfo$VoucherBundleInfoResponse;", "voucherBundleInfo", "Lid/dana/data/expresspurchase/source/network/pojo/response/GetExpressPurchaseResponse$AddonProductInfo$VoucherBundleInfoResponse;", "getVoucherBundleInfo", "()Lid/dana/data/expresspurchase/source/network/pojo/response/GetExpressPurchaseResponse$AddonProductInfo$VoucherBundleInfoResponse;", "Lid/dana/data/expresspurchase/source/network/pojo/response/GetExpressPurchaseResponse$VoucherExpressInfoEntity;", "voucherInfo", "Lid/dana/data/expresspurchase/source/network/pojo/response/GetExpressPurchaseResponse$VoucherExpressInfoEntity;", "getVoucherInfo", "()Lid/dana/data/expresspurchase/source/network/pojo/response/GetExpressPurchaseResponse$VoucherExpressInfoEntity;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/data/expresspurchase/source/network/pojo/response/GetExpressPurchaseResponse$AddonProductInfo$MultiCurrencyMoney;Ljava/util/List;Ljava/util/Map;Lid/dana/data/expresspurchase/source/network/pojo/response/GetExpressPurchaseResponse$VoucherExpressInfoEntity;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/Boolean;Lid/dana/data/expresspurchase/source/network/pojo/response/GetExpressPurchaseResponse$AddonProductInfo$VoucherBundleInfoResponse;Ljava/lang/String;)V", "MultiCurrencyMoney", "VoucherBundleInfoResponse"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class AddonProductInfo {
        private final String aggregatorGoodsId;
        private final String aggregatorId;
        private final String aggregatorName;
        private final Map<String, String> extendInfo;
        private final String finType;
        private final String goodsDescription;
        private final MultiCurrencyMoney goodsPrice;
        @SerializedName("goodsTitle")
        private final String goodsTitle;
        private final String goodsType;
        private final Boolean isOnlineMerchant;
        private final String merchantId;
        private final String merchantName;
        private final String providerCategory;
        private final String providerName;
        private String refId;
        private final String templateType;
        private final Double totalDiscountValue;
        private String type;
        private final Map<String, Object> validationInfo;
        private final List<String> validationTypes;
        private final VoucherBundleInfoResponse voucherBundleInfo;
        private final VoucherExpressInfoEntity voucherInfo;

        public AddonProductInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, MultiCurrencyMoney multiCurrencyMoney, List<String> list, Map<String, ? extends Object> map, VoucherExpressInfoEntity voucherExpressInfoEntity, Double d, String str12, String str13, Map<String, String> map2, Boolean bool, VoucherBundleInfoResponse voucherBundleInfoResponse, String str14) {
            Intrinsics.checkNotNullParameter(str11, "");
            Intrinsics.checkNotNullParameter(multiCurrencyMoney, "");
            this.goodsTitle = str;
            this.goodsDescription = str2;
            this.goodsType = str3;
            this.aggregatorGoodsId = str4;
            this.aggregatorId = str5;
            this.finType = str6;
            this.merchantId = str7;
            this.merchantName = str8;
            this.providerName = str9;
            this.providerCategory = str10;
            this.templateType = str11;
            this.goodsPrice = multiCurrencyMoney;
            this.validationTypes = list;
            this.validationInfo = map;
            this.voucherInfo = voucherExpressInfoEntity;
            this.totalDiscountValue = d;
            this.type = str12;
            this.refId = str13;
            this.extendInfo = map2;
            this.isOnlineMerchant = bool;
            this.voucherBundleInfo = voucherBundleInfoResponse;
            this.aggregatorName = str14;
        }

        public /* synthetic */ AddonProductInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, MultiCurrencyMoney multiCurrencyMoney, List list, Map map, VoucherExpressInfoEntity voucherExpressInfoEntity, Double d, String str12, String str13, Map map2, Boolean bool, VoucherBundleInfoResponse voucherBundleInfoResponse, String str14, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, multiCurrencyMoney, list, map, voucherExpressInfoEntity, d, str12, str13, map2, bool, (i & CrashCombineUtils.DEFAULT_MAX_INFO_LEN) != 0 ? null : voucherBundleInfoResponse, str14);
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

        @JvmName(name = "getAggregatorGoodsId")
        public final String getAggregatorGoodsId() {
            return this.aggregatorGoodsId;
        }

        @JvmName(name = "getAggregatorId")
        public final String getAggregatorId() {
            return this.aggregatorId;
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

        @JvmName(name = "getTemplateType")
        public final String getTemplateType() {
            return this.templateType;
        }

        @JvmName(name = "getGoodsPrice")
        public final MultiCurrencyMoney getGoodsPrice() {
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

        @JvmName(name = "getVoucherInfo")
        public final VoucherExpressInfoEntity getVoucherInfo() {
            return this.voucherInfo;
        }

        @JvmName(name = "getTotalDiscountValue")
        public final Double getTotalDiscountValue() {
            return this.totalDiscountValue;
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

        @JvmName(name = "getExtendInfo")
        public final Map<String, String> getExtendInfo() {
            return this.extendInfo;
        }

        @JvmName(name = "isOnlineMerchant")
        /* renamed from: isOnlineMerchant  reason: from getter */
        public final Boolean getIsOnlineMerchant() {
            return this.isOnlineMerchant;
        }

        @JvmName(name = "getVoucherBundleInfo")
        public final VoucherBundleInfoResponse getVoucherBundleInfo() {
            return this.voucherBundleInfo;
        }

        @JvmName(name = "getAggregatorName")
        public final String getAggregatorName() {
            return this.aggregatorName;
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0015\u001a\u00020\u000e¢\u0006\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0003\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u000e8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000e8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0015\u001a\u00020\u000e8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012"}, d2 = {"Lid/dana/data/expresspurchase/source/network/pojo/response/GetExpressPurchaseResponse$AddonProductInfo$MultiCurrencyMoney;", "", "", "amount", SummaryActivity.DAYS, "getAmount", "()D", "", "cent", "J", "getCent", "()J", "centFactor", "getCentFactor", "", FirebaseAnalytics.Param.CURRENCY, "Ljava/lang/String;", "getCurrency", "()Ljava/lang/String;", AppsFlyerProperties.CURRENCY_CODE, "getCurrencyCode", "currencyValue", "getCurrencyValue", "<init>", "(DJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class MultiCurrencyMoney {
            @SerializedName("amount")
            private final double amount;
            private final long cent;
            private final long centFactor;
            private final String currency;
            private final String currencyCode;
            private final String currencyValue;

            public MultiCurrencyMoney(double d, long j, long j2, String str, String str2, String str3) {
                Intrinsics.checkNotNullParameter(str, "");
                Intrinsics.checkNotNullParameter(str2, "");
                Intrinsics.checkNotNullParameter(str3, "");
                this.amount = d;
                this.cent = j;
                this.centFactor = j2;
                this.currency = str;
                this.currencyCode = str2;
                this.currencyValue = str3;
            }

            @JvmName(name = "getAmount")
            public final double getAmount() {
                return this.amount;
            }

            @JvmName(name = "getCent")
            public final long getCent() {
                return this.cent;
            }

            @JvmName(name = "getCentFactor")
            public final long getCentFactor() {
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

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/data/expresspurchase/source/network/pojo/response/GetExpressPurchaseResponse$AddonProductInfo$VoucherBundleInfoResponse;", "", "", "multiMerchant", "Ljava/lang/Boolean;", "getMultiMerchant", "()Ljava/lang/Boolean;", "<init>", "(Ljava/lang/Boolean;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class VoucherBundleInfoResponse {
            private final Boolean multiMerchant;

            /* JADX WARN: Illegal instructions before constructor call */
            /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.Boolean] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public VoucherBundleInfoResponse() {
                /*
                    r2 = this;
                    r0 = 0
                    r1 = 1
                    r2.<init>(r0, r1, r0)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: id.dana.data.expresspurchase.source.network.pojo.response.GetExpressPurchaseResponse.AddonProductInfo.VoucherBundleInfoResponse.<init>():void");
            }

            public VoucherBundleInfoResponse(Boolean bool) {
                this.multiMerchant = bool;
            }

            public /* synthetic */ VoucherBundleInfoResponse(Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? Boolean.FALSE : bool);
            }

            @JvmName(name = "getMultiMerchant")
            public final Boolean getMultiMerchant() {
                return this.multiMerchant;
            }
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u001a\u0018\u00002\u00020\u0001:\u0002,-B£\u0001\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b*\u0010+R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00138\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0015\u001a\u0004\b\u001d\u0010\u0017R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006R\u001c\u0010 \u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006R\u001c\u0010\"\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010\u0004\u001a\u0004\b#\u0010\u0006R\u001c\u0010$\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010\u0004\u001a\u0004\b%\u0010\u0006R\u001c\u0010&\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010\u0004\u001a\u0004\b'\u0010\u0006R\u001c\u0010(\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010\u0004\u001a\u0004\b)\u0010\u0006"}, d2 = {"Lid/dana/data/expresspurchase/source/network/pojo/response/GetExpressPurchaseResponse$Content;", "", "", "benefitDescription", "Ljava/lang/String;", "getBenefitDescription", "()Ljava/lang/String;", "", "Lid/dana/data/expresspurchase/source/network/pojo/response/GetExpressPurchaseResponse$Content$Benefit;", "benefits", "Ljava/util/List;", "getBenefits", "()Ljava/util/List;", "buyButtonLabel", "getBuyButtonLabel", "buyButtonRedirectionUrl", "getBuyButtonRedirectionUrl", CdpConstants.CONTENT_IMAGE_URL, "getImgUrl", "Lid/dana/data/expresspurchase/source/network/pojo/response/GetExpressPurchaseResponse$Content$ResultConfirmation;", "onBalanceNotEnough", "Lid/dana/data/expresspurchase/source/network/pojo/response/GetExpressPurchaseResponse$Content$ResultConfirmation;", "getOnBalanceNotEnough", "()Lid/dana/data/expresspurchase/source/network/pojo/response/GetExpressPurchaseResponse$Content$ResultConfirmation;", "onFailed", "getOnFailed", "onPending", "getOnPending", "onSuccess", "getOnSuccess", "purchaseInformation", "getPurchaseInformation", RVParams.LONG_SUB_TITLE, "getSubTitle", "supervision", "getSupervision", "title", "getTitle", "tncContent", "getTncContent", "tncUrl", "getTncUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/data/expresspurchase/source/network/pojo/response/GetExpressPurchaseResponse$Content$ResultConfirmation;Lid/dana/data/expresspurchase/source/network/pojo/response/GetExpressPurchaseResponse$Content$ResultConfirmation;Lid/dana/data/expresspurchase/source/network/pojo/response/GetExpressPurchaseResponse$Content$ResultConfirmation;Lid/dana/data/expresspurchase/source/network/pojo/response/GetExpressPurchaseResponse$Content$ResultConfirmation;Ljava/lang/String;)V", "Benefit", "ResultConfirmation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Content {
        private final String benefitDescription;
        private final List<Benefit> benefits;
        private final String buyButtonLabel;
        private final String buyButtonRedirectionUrl;
        @SerializedName(CdpConstants.CONTENT_IMAGE_URL)
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
            this.imgUrl = str;
            this.title = str2;
            this.subTitle = str3;
            this.benefits = list;
            this.tncUrl = str4;
            this.supervision = str5;
            this.benefitDescription = str6;
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

        @JvmName(name = "getTncUrl")
        public final String getTncUrl() {
            return this.tncUrl;
        }

        @JvmName(name = "getSupervision")
        public final String getSupervision() {
            return this.supervision;
        }

        @JvmName(name = "getBenefitDescription")
        public final String getBenefitDescription() {
            return this.benefitDescription;
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

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006"}, d2 = {"Lid/dana/data/expresspurchase/source/network/pojo/response/GetExpressPurchaseResponse$Content$Benefit;", "", "", "description", "Ljava/lang/String;", "getDescription", "()Ljava/lang/String;", CdpConstants.CONTENT_IMAGE_URL, "getImgUrl", "title", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Benefit {
            private final String description;
            @SerializedName(CdpConstants.CONTENT_IMAGE_URL)
            private final String imgUrl;
            private final String title;

            public Benefit(String str, String str2, String str3) {
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

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006"}, d2 = {"Lid/dana/data/expresspurchase/source/network/pojo/response/GetExpressPurchaseResponse$Content$ResultConfirmation;", "", "", "actionLabel", "Ljava/lang/String;", "getActionLabel", "()Ljava/lang/String;", CdpConstants.CONTENT_IMAGE_URL, "getImgUrl", "infoLabel", "getInfoLabel", "infoTitle", "getInfoTitle", "redirectUrl", "getRedirectUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class ResultConfirmation {
            private final String actionLabel;
            @SerializedName(CdpConstants.CONTENT_IMAGE_URL)
            private final String imgUrl;
            private final String infoLabel;
            private final String infoTitle;
            private final String redirectUrl;

            public ResultConfirmation(String str, String str2, String str3, String str4, String str5) {
                Intrinsics.checkNotNullParameter(str, "");
                Intrinsics.checkNotNullParameter(str2, "");
                Intrinsics.checkNotNullParameter(str3, "");
                Intrinsics.checkNotNullParameter(str5, "");
                this.imgUrl = str;
                this.infoTitle = str2;
                this.infoLabel = str3;
                this.redirectUrl = str4;
                this.actionLabel = str5;
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
