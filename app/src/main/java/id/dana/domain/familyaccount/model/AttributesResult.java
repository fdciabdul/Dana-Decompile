package id.dana.domain.familyaccount.model;

import com.alipay.iap.android.aplog.util.CrashCombineUtils;
import com.alipay.mobile.security.faceauth.api.AntDetector;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.cashier.utils.CashierKeyParams;
import id.dana.domain.deeplink.ParamConstantsKt;
import id.dana.domain.nearbyme.model.MoneyView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\b\n\u0002\b!\b\u0086\b\u0018\u00002\u00020\u0001BÉ\u0002\u0012\u0012\b\u0002\u0010(\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010!\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\f\u0012\u0012\b\u0002\u00105\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0002\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u0018\u0012\u0010\b\u0002\u0010=\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0002\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\f¢\u0006\u0004\bf\u0010gJ\u001a\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000eJ\u001a\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0005J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\u0011\u0010\u000eJ\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0012\u0010\bJ\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0013\u0010\bJ\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0014\u0010\bJ\u0012\u0010\u0015\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\u0015\u0010\u000eJ\u0012\u0010\u0016\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\u0016\u0010\u000eJ\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0017\u0010\bJ\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0005J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\u001c\u0010\u000eJ\u0012\u0010\u001d\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\u001d\u0010\u000eJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\u001e\u0010\u000eJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\u001f\u0010\u000eJ\u0012\u0010 \u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b \u0010\bJ\u0012\u0010\"\u001a\u0004\u0018\u00010!HÆ\u0003¢\u0006\u0004\b\"\u0010#J\u0012\u0010$\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b$\u0010\bJ\u0012\u0010%\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b%\u0010\bJ\u0012\u0010&\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b&\u0010\u000eJ\u0012\u0010'\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b'\u0010\u000eJÒ\u0002\u0010A\u001a\u00020\u00002\u0012\b\u0002\u0010(\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00022\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010,\u001a\u0004\u0018\u00010!2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\f2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\f2\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u00102\u001a\u0004\u0018\u00010\t2\n\b\u0002\u00103\u001a\u0004\u0018\u00010\f2\n\b\u0002\u00104\u001a\u0004\u0018\u00010\f2\u0012\b\u0002\u00105\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00022\n\b\u0002\u00106\u001a\u0004\u0018\u00010\f2\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u00182\u0010\b\u0002\u0010=\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00022\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0004\bA\u0010BJ\u001a\u0010D\u001a\u00020\u00062\b\u0010C\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\bD\u0010EJ\u0010\u0010G\u001a\u00020FHÖ\u0001¢\u0006\u0004\bG\u0010HJ\u0010\u0010I\u001a\u00020\fHÖ\u0001¢\u0006\u0004\bI\u0010\u000eR\u0019\u00106\u001a\u0004\u0018\u00010\f8\u0007¢\u0006\f\n\u0004\b6\u0010J\u001a\u0004\bK\u0010\u000eR$\u00105\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b5\u0010L\u001a\u0004\bM\u0010\u0005R\u001c\u0010;\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b;\u0010N\u001a\u0004\bO\u0010\bR\u001c\u0010*\u001a\u0004\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010J\u001a\u0004\bP\u0010\u000eR\u001c\u0010-\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010N\u001a\u0004\b-\u0010\bR\u001c\u00108\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b8\u0010N\u001a\u0004\b8\u0010\bR\u001c\u0010+\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010N\u001a\u0004\b+\u0010\bR\u001c\u0010.\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010N\u001a\u0004\bQ\u0010\bR\u001c\u0010@\u001a\u0004\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b@\u0010J\u001a\u0004\bR\u0010\u000eR\u001c\u00109\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b9\u0010N\u001a\u0004\bS\u0010\bR\u001c\u0010)\u001a\u0004\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010J\u001a\u0004\bT\u0010\u000eR\u001c\u00100\u001a\u0004\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b0\u0010J\u001a\u0004\bU\u0010\u000eR\u001c\u00101\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b1\u0010N\u001a\u0004\bV\u0010\bR\u001c\u0010/\u001a\u0004\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b/\u0010J\u001a\u0004\bW\u0010\u000eR\u001c\u0010?\u001a\u0004\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b?\u0010J\u001a\u0004\bX\u0010\u000eR\u001c\u0010>\u001a\u0004\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b>\u0010J\u001a\u0004\bY\u0010\u000eR$\u0010(\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010L\u001a\u0004\bZ\u0010\u0005R\u001c\u0010<\u001a\u0004\u0018\u00010\u00188\u0007X\u0087\u0004¢\u0006\f\n\u0004\b<\u0010[\u001a\u0004\b\\\u0010\u001aR\u001c\u00103\u001a\u0004\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b3\u0010J\u001a\u0004\b]\u0010\u000eR\u001c\u00107\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b7\u0010N\u001a\u0004\b^\u0010\bR\"\u0010=\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b=\u0010L\u001a\u0004\b_\u0010\u0005R\u001c\u0010,\u001a\u0004\u0018\u00010!8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010`\u001a\u0004\ba\u0010#R\u001c\u0010:\u001a\u0004\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b:\u0010J\u001a\u0004\bb\u0010\u000eR\u001c\u00102\u001a\u0004\u0018\u00010\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b2\u0010c\u001a\u0004\bd\u0010\u000bR\u001c\u00104\u001a\u0004\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b4\u0010J\u001a\u0004\be\u0010\u000e"}, d2 = {"Lid/dana/domain/familyaccount/model/AttributesResult;", "", "", "Lid/dana/domain/familyaccount/model/PayChannelsItem;", "component1", "()Ljava/util/List;", "", "component10", "()Ljava/lang/Boolean;", "Lid/dana/domain/nearbyme/model/MoneyView;", "component11", "()Lid/dana/domain/nearbyme/model/MoneyView;", "", "component12", "()Ljava/lang/String;", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "Lid/dana/domain/familyaccount/model/PayMethodRiskResult;", "component21", "()Lid/dana/domain/familyaccount/model/PayMethodRiskResult;", "component22", "component23", "component24", "component25", "component3", "component4", "Lid/dana/domain/familyaccount/model/SecurityContextAttributes;", "component5", "()Lid/dana/domain/familyaccount/model/SecurityContextAttributes;", "component6", "component7", "component8", "component9", "payChannels", "maskedLoginId", "extendInfoList", "isSupportMixPayment", "securityContextAttributes", ParamConstantsKt.IS_DEEPLINK_PAYMENT, "loginStatus", "networkScenario", "merchantName", "merchantReturnUrlDeeplink", "totalAmount", "processingStatus", "transType", CashierKeyParams.CASHIER_ORDER_GOODS, "bizOrderId", "queryAgain", TrackerKey.CashierProperties.IS_MIX_PAYMENT, "mainAppPayReturnUrlDeeplink", "sourcePlatform", "displayMerchantOrder", "payMethodRiskResult", "riskVerificationMethods", "orderTitle", "orderCreatedTime", "lzdTopupType", "copy", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lid/dana/domain/familyaccount/model/SecurityContextAttributes;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Lid/dana/domain/familyaccount/model/PayMethodRiskResult;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/familyaccount/model/AttributesResult;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getBizOrderId", "Ljava/util/List;", "getCashierOrderGoods", "Ljava/lang/Boolean;", "getDisplayMerchantOrder", "getExtendInfoList", "getLoginStatus", "getLzdTopupType", "getMainAppPayReturnUrlDeeplink", "getMaskedLoginId", "getMerchantName", "getMerchantReturnUrlDeeplink", "getNetworkScenario", "getOrderCreatedTime", CashierKeyParams.GET_ORDER_TITLE, "getPayChannels", "Lid/dana/domain/familyaccount/model/PayMethodRiskResult;", "getPayMethodRiskResult", "getProcessingStatus", "getQueryAgain", "getRiskVerificationMethods", "Lid/dana/domain/familyaccount/model/SecurityContextAttributes;", "getSecurityContextAttributes", "getSourcePlatform", "Lid/dana/domain/nearbyme/model/MoneyView;", "getTotalAmount", "getTransType", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lid/dana/domain/familyaccount/model/SecurityContextAttributes;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Lid/dana/domain/familyaccount/model/PayMethodRiskResult;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class AttributesResult {
    private final String bizOrderId;
    private final List<Object> cashierOrderGoods;
    private final Boolean displayMerchantOrder;
    private final String extendInfoList;
    private final Boolean isDeeplinkPayment;
    private final Boolean isMixPayment;
    private final Boolean isSupportMixPayment;
    private final Boolean loginStatus;
    private final String lzdTopupType;
    private final Boolean mainAppPayReturnUrlDeeplink;
    private final String maskedLoginId;
    private final String merchantName;
    private final Boolean merchantReturnUrlDeeplink;
    private final String networkScenario;
    private final String orderCreatedTime;
    private final String orderTitle;
    private final List<PayChannelsItem> payChannels;
    private final PayMethodRiskResult payMethodRiskResult;
    private final String processingStatus;
    private final Boolean queryAgain;
    private final List<PayMethodRiskResult> riskVerificationMethods;
    private final SecurityContextAttributes securityContextAttributes;
    private final String sourcePlatform;
    private final MoneyView totalAmount;
    private final String transType;

    public AttributesResult() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 33554431, null);
    }

    public final List<PayChannelsItem> component1() {
        return this.payChannels;
    }

    /* renamed from: component10  reason: from getter */
    public final Boolean getMerchantReturnUrlDeeplink() {
        return this.merchantReturnUrlDeeplink;
    }

    /* renamed from: component11  reason: from getter */
    public final MoneyView getTotalAmount() {
        return this.totalAmount;
    }

    /* renamed from: component12  reason: from getter */
    public final String getProcessingStatus() {
        return this.processingStatus;
    }

    /* renamed from: component13  reason: from getter */
    public final String getTransType() {
        return this.transType;
    }

    public final List<Object> component14() {
        return this.cashierOrderGoods;
    }

    /* renamed from: component15  reason: from getter */
    public final String getBizOrderId() {
        return this.bizOrderId;
    }

    /* renamed from: component16  reason: from getter */
    public final Boolean getQueryAgain() {
        return this.queryAgain;
    }

    /* renamed from: component17  reason: from getter */
    public final Boolean getIsMixPayment() {
        return this.isMixPayment;
    }

    /* renamed from: component18  reason: from getter */
    public final Boolean getMainAppPayReturnUrlDeeplink() {
        return this.mainAppPayReturnUrlDeeplink;
    }

    /* renamed from: component19  reason: from getter */
    public final String getSourcePlatform() {
        return this.sourcePlatform;
    }

    /* renamed from: component2  reason: from getter */
    public final String getMaskedLoginId() {
        return this.maskedLoginId;
    }

    /* renamed from: component20  reason: from getter */
    public final Boolean getDisplayMerchantOrder() {
        return this.displayMerchantOrder;
    }

    /* renamed from: component21  reason: from getter */
    public final PayMethodRiskResult getPayMethodRiskResult() {
        return this.payMethodRiskResult;
    }

    public final List<PayMethodRiskResult> component22() {
        return this.riskVerificationMethods;
    }

    /* renamed from: component23  reason: from getter */
    public final String getOrderTitle() {
        return this.orderTitle;
    }

    /* renamed from: component24  reason: from getter */
    public final String getOrderCreatedTime() {
        return this.orderCreatedTime;
    }

    /* renamed from: component25  reason: from getter */
    public final String getLzdTopupType() {
        return this.lzdTopupType;
    }

    /* renamed from: component3  reason: from getter */
    public final String getExtendInfoList() {
        return this.extendInfoList;
    }

    /* renamed from: component4  reason: from getter */
    public final Boolean getIsSupportMixPayment() {
        return this.isSupportMixPayment;
    }

    /* renamed from: component5  reason: from getter */
    public final SecurityContextAttributes getSecurityContextAttributes() {
        return this.securityContextAttributes;
    }

    /* renamed from: component6  reason: from getter */
    public final Boolean getIsDeeplinkPayment() {
        return this.isDeeplinkPayment;
    }

    /* renamed from: component7  reason: from getter */
    public final Boolean getLoginStatus() {
        return this.loginStatus;
    }

    /* renamed from: component8  reason: from getter */
    public final String getNetworkScenario() {
        return this.networkScenario;
    }

    /* renamed from: component9  reason: from getter */
    public final String getMerchantName() {
        return this.merchantName;
    }

    public final AttributesResult copy(List<PayChannelsItem> payChannels, String maskedLoginId, String extendInfoList, Boolean isSupportMixPayment, SecurityContextAttributes securityContextAttributes, Boolean isDeeplinkPayment, Boolean loginStatus, String networkScenario, String merchantName, Boolean merchantReturnUrlDeeplink, MoneyView totalAmount, String processingStatus, String transType, List<? extends Object> cashierOrderGoods, String bizOrderId, Boolean queryAgain, Boolean isMixPayment, Boolean mainAppPayReturnUrlDeeplink, String sourcePlatform, Boolean displayMerchantOrder, PayMethodRiskResult payMethodRiskResult, List<PayMethodRiskResult> riskVerificationMethods, String orderTitle, String orderCreatedTime, String lzdTopupType) {
        return new AttributesResult(payChannels, maskedLoginId, extendInfoList, isSupportMixPayment, securityContextAttributes, isDeeplinkPayment, loginStatus, networkScenario, merchantName, merchantReturnUrlDeeplink, totalAmount, processingStatus, transType, cashierOrderGoods, bizOrderId, queryAgain, isMixPayment, mainAppPayReturnUrlDeeplink, sourcePlatform, displayMerchantOrder, payMethodRiskResult, riskVerificationMethods, orderTitle, orderCreatedTime, lzdTopupType);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof AttributesResult) {
            AttributesResult attributesResult = (AttributesResult) other;
            return Intrinsics.areEqual(this.payChannels, attributesResult.payChannels) && Intrinsics.areEqual(this.maskedLoginId, attributesResult.maskedLoginId) && Intrinsics.areEqual(this.extendInfoList, attributesResult.extendInfoList) && Intrinsics.areEqual(this.isSupportMixPayment, attributesResult.isSupportMixPayment) && Intrinsics.areEqual(this.securityContextAttributes, attributesResult.securityContextAttributes) && Intrinsics.areEqual(this.isDeeplinkPayment, attributesResult.isDeeplinkPayment) && Intrinsics.areEqual(this.loginStatus, attributesResult.loginStatus) && Intrinsics.areEqual(this.networkScenario, attributesResult.networkScenario) && Intrinsics.areEqual(this.merchantName, attributesResult.merchantName) && Intrinsics.areEqual(this.merchantReturnUrlDeeplink, attributesResult.merchantReturnUrlDeeplink) && Intrinsics.areEqual(this.totalAmount, attributesResult.totalAmount) && Intrinsics.areEqual(this.processingStatus, attributesResult.processingStatus) && Intrinsics.areEqual(this.transType, attributesResult.transType) && Intrinsics.areEqual(this.cashierOrderGoods, attributesResult.cashierOrderGoods) && Intrinsics.areEqual(this.bizOrderId, attributesResult.bizOrderId) && Intrinsics.areEqual(this.queryAgain, attributesResult.queryAgain) && Intrinsics.areEqual(this.isMixPayment, attributesResult.isMixPayment) && Intrinsics.areEqual(this.mainAppPayReturnUrlDeeplink, attributesResult.mainAppPayReturnUrlDeeplink) && Intrinsics.areEqual(this.sourcePlatform, attributesResult.sourcePlatform) && Intrinsics.areEqual(this.displayMerchantOrder, attributesResult.displayMerchantOrder) && Intrinsics.areEqual(this.payMethodRiskResult, attributesResult.payMethodRiskResult) && Intrinsics.areEqual(this.riskVerificationMethods, attributesResult.riskVerificationMethods) && Intrinsics.areEqual(this.orderTitle, attributesResult.orderTitle) && Intrinsics.areEqual(this.orderCreatedTime, attributesResult.orderCreatedTime) && Intrinsics.areEqual(this.lzdTopupType, attributesResult.lzdTopupType);
        }
        return false;
    }

    public final int hashCode() {
        List<PayChannelsItem> list = this.payChannels;
        int hashCode = list == null ? 0 : list.hashCode();
        String str = this.maskedLoginId;
        int hashCode2 = str == null ? 0 : str.hashCode();
        String str2 = this.extendInfoList;
        int hashCode3 = str2 == null ? 0 : str2.hashCode();
        Boolean bool = this.isSupportMixPayment;
        int hashCode4 = bool == null ? 0 : bool.hashCode();
        SecurityContextAttributes securityContextAttributes = this.securityContextAttributes;
        int hashCode5 = securityContextAttributes == null ? 0 : securityContextAttributes.hashCode();
        Boolean bool2 = this.isDeeplinkPayment;
        int hashCode6 = bool2 == null ? 0 : bool2.hashCode();
        Boolean bool3 = this.loginStatus;
        int hashCode7 = bool3 == null ? 0 : bool3.hashCode();
        String str3 = this.networkScenario;
        int hashCode8 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.merchantName;
        int hashCode9 = str4 == null ? 0 : str4.hashCode();
        Boolean bool4 = this.merchantReturnUrlDeeplink;
        int hashCode10 = bool4 == null ? 0 : bool4.hashCode();
        MoneyView moneyView = this.totalAmount;
        int hashCode11 = moneyView == null ? 0 : moneyView.hashCode();
        String str5 = this.processingStatus;
        int hashCode12 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.transType;
        int hashCode13 = str6 == null ? 0 : str6.hashCode();
        List<Object> list2 = this.cashierOrderGoods;
        int hashCode14 = list2 == null ? 0 : list2.hashCode();
        String str7 = this.bizOrderId;
        int hashCode15 = str7 == null ? 0 : str7.hashCode();
        Boolean bool5 = this.queryAgain;
        int hashCode16 = bool5 == null ? 0 : bool5.hashCode();
        Boolean bool6 = this.isMixPayment;
        int hashCode17 = bool6 == null ? 0 : bool6.hashCode();
        Boolean bool7 = this.mainAppPayReturnUrlDeeplink;
        int hashCode18 = bool7 == null ? 0 : bool7.hashCode();
        String str8 = this.sourcePlatform;
        int hashCode19 = str8 == null ? 0 : str8.hashCode();
        Boolean bool8 = this.displayMerchantOrder;
        int hashCode20 = bool8 == null ? 0 : bool8.hashCode();
        PayMethodRiskResult payMethodRiskResult = this.payMethodRiskResult;
        int hashCode21 = payMethodRiskResult == null ? 0 : payMethodRiskResult.hashCode();
        List<PayMethodRiskResult> list3 = this.riskVerificationMethods;
        int hashCode22 = list3 == null ? 0 : list3.hashCode();
        String str9 = this.orderTitle;
        int hashCode23 = str9 == null ? 0 : str9.hashCode();
        String str10 = this.orderCreatedTime;
        int hashCode24 = str10 == null ? 0 : str10.hashCode();
        String str11 = this.lzdTopupType;
        return (((((((((((((((((((((((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + hashCode14) * 31) + hashCode15) * 31) + hashCode16) * 31) + hashCode17) * 31) + hashCode18) * 31) + hashCode19) * 31) + hashCode20) * 31) + hashCode21) * 31) + hashCode22) * 31) + hashCode23) * 31) + hashCode24) * 31) + (str11 != null ? str11.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AttributesResult(payChannels=");
        sb.append(this.payChannels);
        sb.append(", maskedLoginId=");
        sb.append(this.maskedLoginId);
        sb.append(", extendInfoList=");
        sb.append(this.extendInfoList);
        sb.append(", isSupportMixPayment=");
        sb.append(this.isSupportMixPayment);
        sb.append(", securityContextAttributes=");
        sb.append(this.securityContextAttributes);
        sb.append(", isDeeplinkPayment=");
        sb.append(this.isDeeplinkPayment);
        sb.append(", loginStatus=");
        sb.append(this.loginStatus);
        sb.append(", networkScenario=");
        sb.append(this.networkScenario);
        sb.append(", merchantName=");
        sb.append(this.merchantName);
        sb.append(", merchantReturnUrlDeeplink=");
        sb.append(this.merchantReturnUrlDeeplink);
        sb.append(", totalAmount=");
        sb.append(this.totalAmount);
        sb.append(", processingStatus=");
        sb.append(this.processingStatus);
        sb.append(", transType=");
        sb.append(this.transType);
        sb.append(", cashierOrderGoods=");
        sb.append(this.cashierOrderGoods);
        sb.append(", bizOrderId=");
        sb.append(this.bizOrderId);
        sb.append(", queryAgain=");
        sb.append(this.queryAgain);
        sb.append(", isMixPayment=");
        sb.append(this.isMixPayment);
        sb.append(", mainAppPayReturnUrlDeeplink=");
        sb.append(this.mainAppPayReturnUrlDeeplink);
        sb.append(", sourcePlatform=");
        sb.append(this.sourcePlatform);
        sb.append(", displayMerchantOrder=");
        sb.append(this.displayMerchantOrder);
        sb.append(", payMethodRiskResult=");
        sb.append(this.payMethodRiskResult);
        sb.append(", riskVerificationMethods=");
        sb.append(this.riskVerificationMethods);
        sb.append(", orderTitle=");
        sb.append(this.orderTitle);
        sb.append(", orderCreatedTime=");
        sb.append(this.orderCreatedTime);
        sb.append(", lzdTopupType=");
        sb.append(this.lzdTopupType);
        sb.append(')');
        return sb.toString();
    }

    public AttributesResult(List<PayChannelsItem> list, String str, String str2, Boolean bool, SecurityContextAttributes securityContextAttributes, Boolean bool2, Boolean bool3, String str3, String str4, Boolean bool4, MoneyView moneyView, String str5, String str6, List<? extends Object> list2, String str7, Boolean bool5, Boolean bool6, Boolean bool7, String str8, Boolean bool8, PayMethodRiskResult payMethodRiskResult, List<PayMethodRiskResult> list3, String str9, String str10, String str11) {
        this.payChannels = list;
        this.maskedLoginId = str;
        this.extendInfoList = str2;
        this.isSupportMixPayment = bool;
        this.securityContextAttributes = securityContextAttributes;
        this.isDeeplinkPayment = bool2;
        this.loginStatus = bool3;
        this.networkScenario = str3;
        this.merchantName = str4;
        this.merchantReturnUrlDeeplink = bool4;
        this.totalAmount = moneyView;
        this.processingStatus = str5;
        this.transType = str6;
        this.cashierOrderGoods = list2;
        this.bizOrderId = str7;
        this.queryAgain = bool5;
        this.isMixPayment = bool6;
        this.mainAppPayReturnUrlDeeplink = bool7;
        this.sourcePlatform = str8;
        this.displayMerchantOrder = bool8;
        this.payMethodRiskResult = payMethodRiskResult;
        this.riskVerificationMethods = list3;
        this.orderTitle = str9;
        this.orderCreatedTime = str10;
        this.lzdTopupType = str11;
    }

    public /* synthetic */ AttributesResult(List list, String str, String str2, Boolean bool, SecurityContextAttributes securityContextAttributes, Boolean bool2, Boolean bool3, String str3, String str4, Boolean bool4, MoneyView moneyView, String str5, String str6, List list2, String str7, Boolean bool5, Boolean bool6, Boolean bool7, String str8, Boolean bool8, PayMethodRiskResult payMethodRiskResult, List list3, String str9, String str10, String str11, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : bool, (i & 16) != 0 ? null : securityContextAttributes, (i & 32) != 0 ? null : bool2, (i & 64) != 0 ? null : bool3, (i & 128) != 0 ? null : str3, (i & 256) != 0 ? null : str4, (i & 512) != 0 ? null : bool4, (i & 1024) != 0 ? null : moneyView, (i & 2048) != 0 ? null : str5, (i & 4096) != 0 ? null : str6, (i & 8192) != 0 ? null : list2, (i & 16384) != 0 ? null : str7, (i & 32768) != 0 ? null : bool5, (i & 65536) != 0 ? null : bool6, (i & AntDetector.SCENE_ID_LOGIN_REGIST) != 0 ? null : bool7, (i & 262144) != 0 ? null : str8, (i & 524288) != 0 ? null : bool8, (i & CrashCombineUtils.DEFAULT_MAX_INFO_LEN) != 0 ? null : payMethodRiskResult, (i & 2097152) != 0 ? null : list3, (i & 4194304) != 0 ? null : str9, (i & 8388608) != 0 ? null : str10, (i & 16777216) != 0 ? null : str11);
    }

    @JvmName(name = "getPayChannels")
    public final List<PayChannelsItem> getPayChannels() {
        return this.payChannels;
    }

    @JvmName(name = "getMaskedLoginId")
    public final String getMaskedLoginId() {
        return this.maskedLoginId;
    }

    @JvmName(name = "getExtendInfoList")
    public final String getExtendInfoList() {
        return this.extendInfoList;
    }

    @JvmName(name = "isSupportMixPayment")
    public final Boolean isSupportMixPayment() {
        return this.isSupportMixPayment;
    }

    @JvmName(name = "getSecurityContextAttributes")
    public final SecurityContextAttributes getSecurityContextAttributes() {
        return this.securityContextAttributes;
    }

    @JvmName(name = ParamConstantsKt.IS_DEEPLINK_PAYMENT)
    public final Boolean isDeeplinkPayment() {
        return this.isDeeplinkPayment;
    }

    @JvmName(name = "getLoginStatus")
    public final Boolean getLoginStatus() {
        return this.loginStatus;
    }

    @JvmName(name = "getNetworkScenario")
    public final String getNetworkScenario() {
        return this.networkScenario;
    }

    @JvmName(name = "getMerchantName")
    public final String getMerchantName() {
        return this.merchantName;
    }

    @JvmName(name = "getMerchantReturnUrlDeeplink")
    public final Boolean getMerchantReturnUrlDeeplink() {
        return this.merchantReturnUrlDeeplink;
    }

    @JvmName(name = "getTotalAmount")
    public final MoneyView getTotalAmount() {
        return this.totalAmount;
    }

    @JvmName(name = "getProcessingStatus")
    public final String getProcessingStatus() {
        return this.processingStatus;
    }

    @JvmName(name = "getTransType")
    public final String getTransType() {
        return this.transType;
    }

    @JvmName(name = "getCashierOrderGoods")
    public final List<Object> getCashierOrderGoods() {
        return this.cashierOrderGoods;
    }

    @JvmName(name = "getBizOrderId")
    public final String getBizOrderId() {
        return this.bizOrderId;
    }

    @JvmName(name = "getQueryAgain")
    public final Boolean getQueryAgain() {
        return this.queryAgain;
    }

    @JvmName(name = TrackerKey.CashierProperties.IS_MIX_PAYMENT)
    public final Boolean isMixPayment() {
        return this.isMixPayment;
    }

    @JvmName(name = "getMainAppPayReturnUrlDeeplink")
    public final Boolean getMainAppPayReturnUrlDeeplink() {
        return this.mainAppPayReturnUrlDeeplink;
    }

    @JvmName(name = "getSourcePlatform")
    public final String getSourcePlatform() {
        return this.sourcePlatform;
    }

    @JvmName(name = "getDisplayMerchantOrder")
    public final Boolean getDisplayMerchantOrder() {
        return this.displayMerchantOrder;
    }

    @JvmName(name = "getPayMethodRiskResult")
    public final PayMethodRiskResult getPayMethodRiskResult() {
        return this.payMethodRiskResult;
    }

    @JvmName(name = "getRiskVerificationMethods")
    public final List<PayMethodRiskResult> getRiskVerificationMethods() {
        return this.riskVerificationMethods;
    }

    @JvmName(name = CashierKeyParams.GET_ORDER_TITLE)
    public final String getOrderTitle() {
        return this.orderTitle;
    }

    @JvmName(name = "getOrderCreatedTime")
    public final String getOrderCreatedTime() {
        return this.orderCreatedTime;
    }

    @JvmName(name = "getLzdTopupType")
    public final String getLzdTopupType() {
        return this.lzdTopupType;
    }
}
