package id.dana.mybills.data.model.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import id.dana.lib.drawbitmap.invoice.InvoiceConstant;
import id.dana.mybills.danah5.BillerPortalBridge;
import id.dana.network.response.expresspurchase.MoneyViewEntity;
import id.dana.wallet_v3.constant.WalletConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b \u0010!R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001d\u0010\rR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006"}, d2 = {"Lid/dana/mybills/data/model/request/CreateSubscriptionExtendInfoEntity;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", BillerPortalBridge.Event.Info.KEY_BILLER_DENOM_TEXT, "Ljava/lang/String;", "getBillerDenomText", "()Ljava/lang/String;", WalletConstant.CARD_INDEX_NO, "getCardIndexNo", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", UpdateSubscriptionRequest.KEY_EXTEND_INFO_DENOM, "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "getDenom", "()Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "payMode", "getPayMode", InvoiceConstant.PAYMENT_METHOD, "getPaymentMethod", "productTitle", "getProductTitle", "provider", "getProvider", BillerPortalBridge.Event.Info.KEY_QUERY_URL_PROVIDER, "getQueryUrlProvider", "timezone", "getTimezone", "title", "getTitle", "totalAmount", "getTotalAmount", "type", "getType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CreateSubscriptionExtendInfoEntity extends BaseRpcRequest {
    public String billerDenomText;
    public String cardIndexNo;
    public MoneyViewEntity denom;
    public String payMode;
    public String paymentMethod;
    public String productTitle;
    public String provider;
    public String queryUrlProvider;
    public String timezone;
    public String title;
    public MoneyViewEntity totalAmount;
    public String type;

    public /* synthetic */ CreateSubscriptionExtendInfoEntity() {
    }

    @JvmName(name = "getCardIndexNo")
    public final String getCardIndexNo() {
        return this.cardIndexNo;
    }

    @JvmName(name = "getProvider")
    public final String getProvider() {
        return this.provider;
    }

    @JvmName(name = "getPaymentMethod")
    public final String getPaymentMethod() {
        return this.paymentMethod;
    }

    @JvmName(name = "getPayMode")
    public final String getPayMode() {
        return this.payMode;
    }

    @JvmName(name = "getDenom")
    public final MoneyViewEntity getDenom() {
        return this.denom;
    }

    @JvmName(name = "getTimezone")
    public final String getTimezone() {
        return this.timezone;
    }

    @JvmName(name = "getType")
    public final String getType() {
        return this.type;
    }

    @JvmName(name = "getTitle")
    public final String getTitle() {
        return this.title;
    }

    @JvmName(name = "getTotalAmount")
    public final MoneyViewEntity getTotalAmount() {
        return this.totalAmount;
    }

    @JvmName(name = "getProductTitle")
    public final String getProductTitle() {
        return this.productTitle;
    }

    @JvmName(name = "getQueryUrlProvider")
    public final String getQueryUrlProvider() {
        return this.queryUrlProvider;
    }

    @JvmName(name = "getBillerDenomText")
    public final String getBillerDenomText() {
        return this.billerDenomText;
    }

    public CreateSubscriptionExtendInfoEntity(@JSONField(name = "CARD_INDEX_NO") String str, String str2, @JSONField(name = "PAYMENT_METHOD") String str3, @JSONField(name = "PAY_MODE") String str4, MoneyViewEntity moneyViewEntity, @JSONField(name = "TIMEZONE") String str5, String str6, String str7, MoneyViewEntity moneyViewEntity2, String str8, String str9, String str10) {
        this.cardIndexNo = str;
        this.provider = str2;
        this.paymentMethod = str3;
        this.payMode = str4;
        this.denom = moneyViewEntity;
        this.timezone = str5;
        this.type = str6;
        this.title = str7;
        this.totalAmount = moneyViewEntity2;
        this.productTitle = str8;
        this.queryUrlProvider = str9;
        this.billerDenomText = str10;
    }
}
