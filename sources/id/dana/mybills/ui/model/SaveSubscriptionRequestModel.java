package id.dana.mybills.ui.model;

import com.alibaba.griver.api.constants.GriverEvents;
import com.alipay.iap.android.aplog.util.CrashCombineUtils;
import com.alipay.mobile.security.faceauth.api.AntDetector;
import id.dana.cashier.utils.CashierKeyParams;
import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.lib.drawbitmap.invoice.InvoiceConstant;
import id.dana.mybills.data.model.request.UpdateSubscriptionRequest;
import id.dana.wallet_v3.constant.WalletConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b'\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\bA\b\u0086\b\u0018\u00002\u00020\u0001B×\u0002\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u0002\u0012\u0014\b\u0002\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0019¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0004J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0004J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0013J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0004J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0004J\u001c\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0019HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0004J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0004J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u0004J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u0004J\u0012\u0010 \u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b \u0010\u0004J\u0012\u0010!\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b!\u0010\u0004J\u0012\u0010\"\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\"\u0010\u0004JÞ\u0002\u0010>\u001a\u00020\u00002\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u00022\u0014\b\u0002\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0019HÆ\u0001¢\u0006\u0004\b>\u0010?J\u001a\u0010B\u001a\u00020A2\b\u0010@\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\bB\u0010CJ\u0010\u0010E\u001a\u00020DHÖ\u0001¢\u0006\u0004\bE\u0010FJ\u0010\u0010G\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\bG\u0010\u0004R$\u0010&\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010H\u001a\u0004\bI\u0010\u0004\"\u0004\bJ\u0010KR$\u0010'\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010H\u001a\u0004\bL\u0010\u0004\"\u0004\bM\u0010KR$\u00103\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b3\u0010H\u001a\u0004\bN\u0010\u0004\"\u0004\bO\u0010KR$\u00107\u001a\u0004\u0018\u00010\u00118\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b7\u0010P\u001a\u0004\bQ\u0010\u0013\"\u0004\bR\u0010SR.\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u00198\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b=\u0010T\u001a\u0004\bU\u0010\u001b\"\u0004\bV\u0010WR$\u0010<\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b<\u0010H\u001a\u0004\bX\u0010\u0004\"\u0004\bY\u0010KR$\u0010%\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010H\u001a\u0004\bZ\u0010\u0004\"\u0004\b[\u0010KR$\u0010-\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010H\u001a\u0004\b\\\u0010\u0004\"\u0004\b]\u0010KR$\u00106\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b6\u0010H\u001a\u0004\b^\u0010\u0004\"\u0004\b_\u0010KR$\u00105\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b5\u0010H\u001a\u0004\b`\u0010\u0004\"\u0004\ba\u0010KR$\u00102\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u0010H\u001a\u0004\bb\u0010\u0004\"\u0004\bc\u0010KR$\u0010;\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b;\u0010H\u001a\u0004\bd\u0010\u0004\"\u0004\be\u0010KR$\u00104\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b4\u0010H\u001a\u0004\bf\u0010\u0004\"\u0004\bg\u0010KR$\u0010(\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010H\u001a\u0004\bh\u0010\u0004\"\u0004\bi\u0010KR$\u0010.\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010H\u001a\u0004\bj\u0010\u0004\"\u0004\bk\u0010KR$\u00101\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b1\u0010H\u001a\u0004\bl\u0010\u0004\"\u0004\bm\u0010KR$\u0010$\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010H\u001a\u0004\bn\u0010\u0004\"\u0004\bo\u0010KR$\u0010+\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010H\u001a\u0004\bp\u0010\u0004\"\u0004\bq\u0010KR$\u0010)\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010H\u001a\u0004\br\u0010\u0004\"\u0004\bs\u0010KR$\u0010*\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010H\u001a\u0004\bt\u0010\u0004\"\u0004\bu\u0010KR$\u0010,\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010H\u001a\u0004\bv\u0010\u0004\"\u0004\bw\u0010KR$\u00108\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b8\u0010H\u001a\u0004\bx\u0010\u0004\"\u0004\by\u0010KR$\u0010#\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010H\u001a\u0004\bz\u0010\u0004\"\u0004\b{\u0010KR$\u0010:\u001a\u0004\u0018\u00010\u00118\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b:\u0010P\u001a\u0004\b|\u0010\u0013\"\u0004\b}\u0010SR$\u00109\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b9\u0010H\u001a\u0004\b~\u0010\u0004\"\u0004\b\u007f\u0010KR&\u0010/\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\b/\u0010H\u001a\u0005\b\u0080\u0001\u0010\u0004\"\u0005\b\u0081\u0001\u0010KR&\u00100\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\b0\u0010H\u001a\u0005\b\u0082\u0001\u0010\u0004\"\u0005\b\u0083\u0001\u0010K"}, d2 = {"Lid/dana/mybills/ui/model/SaveSubscriptionRequestModel;", "", "", "component1", "()Ljava/lang/String;", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "Lid/dana/mybills/ui/model/MoneyViewModel;", "component21", "()Lid/dana/mybills/ui/model/MoneyViewModel;", "component22", "component23", "component24", "component25", "component26", "", "component27", "()Ljava/util/Map;", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "title", "subscriptionDayOfMonth", "goodsId", "billerId", "bizType", "recurringType", "subscriptionIntervalType", "subscriptionIntervalValue", "subscriptionHourOfDay", "subscriptionMonthOfYear", "message", BioUtilityBridge.SECURITY_ID, "validateData", CashierKeyParams.VERIFICATION_METHOD, "sendStrategy", "phoneNumber", WalletConstant.CARD_INDEX_NO, "provider", InvoiceConstant.PAYMENT_METHOD, "payMode", UpdateSubscriptionRequest.KEY_EXTEND_INFO_DENOM, "timezone", "type", "totalAmount", "productTitle", "extendInfoTitle", "extendInfo", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/mybills/ui/model/MoneyViewModel;Ljava/lang/String;Ljava/lang/String;Lid/dana/mybills/ui/model/MoneyViewModel;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Lid/dana/mybills/ui/model/SaveSubscriptionRequestModel;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getBillerId", "setBillerId", "(Ljava/lang/String;)V", "getBizType", "setBizType", "getCardIndexNo", "setCardIndexNo", "Lid/dana/mybills/ui/model/MoneyViewModel;", "getDenom", "setDenom", "(Lid/dana/mybills/ui/model/MoneyViewModel;)V", "Ljava/util/Map;", "getExtendInfo", "setExtendInfo", "(Ljava/util/Map;)V", "getExtendInfoTitle", "setExtendInfoTitle", "getGoodsId", "setGoodsId", "getMessage", "setMessage", "getPayMode", "setPayMode", "getPaymentMethod", "setPaymentMethod", "getPhoneNumber", "setPhoneNumber", "getProductTitle", "setProductTitle", "getProvider", "setProvider", "getRecurringType", "setRecurringType", "getSecurityId", "setSecurityId", "getSendStrategy", "setSendStrategy", "getSubscriptionDayOfMonth", "setSubscriptionDayOfMonth", "getSubscriptionHourOfDay", "setSubscriptionHourOfDay", "getSubscriptionIntervalType", "setSubscriptionIntervalType", "getSubscriptionIntervalValue", "setSubscriptionIntervalValue", "getSubscriptionMonthOfYear", "setSubscriptionMonthOfYear", "getTimezone", "setTimezone", "getTitle", GriverEvents.EVENT_SET_TITLE, "getTotalAmount", "setTotalAmount", "getType", "setType", "getValidateData", "setValidateData", "getVerificationMethod", "setVerificationMethod", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/mybills/ui/model/MoneyViewModel;Ljava/lang/String;Ljava/lang/String;Lid/dana/mybills/ui/model/MoneyViewModel;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final /* data */ class SaveSubscriptionRequestModel {
    private String billerId;
    private String bizType;
    private String cardIndexNo;
    private MoneyViewModel denom;
    private Map<String, ? extends Object> extendInfo;
    private String extendInfoTitle;
    private String goodsId;
    private String message;
    private String payMode;
    private String paymentMethod;
    private String phoneNumber;
    private String productTitle;
    private String provider;
    private String recurringType;
    private String securityId;
    private String sendStrategy;
    private String subscriptionDayOfMonth;
    private String subscriptionHourOfDay;
    private String subscriptionIntervalType;
    private String subscriptionIntervalValue;
    private String subscriptionMonthOfYear;
    private String timezone;
    private String title;
    private MoneyViewModel totalAmount;
    private String type;
    private String validateData;
    private String verificationMethod;

    public SaveSubscriptionRequestModel() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 134217727, null);
    }

    /* renamed from: component1  reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component10  reason: from getter */
    public final String getSubscriptionMonthOfYear() {
        return this.subscriptionMonthOfYear;
    }

    /* renamed from: component11  reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* renamed from: component12  reason: from getter */
    public final String getSecurityId() {
        return this.securityId;
    }

    /* renamed from: component13  reason: from getter */
    public final String getValidateData() {
        return this.validateData;
    }

    /* renamed from: component14  reason: from getter */
    public final String getVerificationMethod() {
        return this.verificationMethod;
    }

    /* renamed from: component15  reason: from getter */
    public final String getSendStrategy() {
        return this.sendStrategy;
    }

    /* renamed from: component16  reason: from getter */
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    /* renamed from: component17  reason: from getter */
    public final String getCardIndexNo() {
        return this.cardIndexNo;
    }

    /* renamed from: component18  reason: from getter */
    public final String getProvider() {
        return this.provider;
    }

    /* renamed from: component19  reason: from getter */
    public final String getPaymentMethod() {
        return this.paymentMethod;
    }

    /* renamed from: component2  reason: from getter */
    public final String getSubscriptionDayOfMonth() {
        return this.subscriptionDayOfMonth;
    }

    /* renamed from: component20  reason: from getter */
    public final String getPayMode() {
        return this.payMode;
    }

    /* renamed from: component21  reason: from getter */
    public final MoneyViewModel getDenom() {
        return this.denom;
    }

    /* renamed from: component22  reason: from getter */
    public final String getTimezone() {
        return this.timezone;
    }

    /* renamed from: component23  reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component24  reason: from getter */
    public final MoneyViewModel getTotalAmount() {
        return this.totalAmount;
    }

    /* renamed from: component25  reason: from getter */
    public final String getProductTitle() {
        return this.productTitle;
    }

    /* renamed from: component26  reason: from getter */
    public final String getExtendInfoTitle() {
        return this.extendInfoTitle;
    }

    public final Map<String, Object> component27() {
        return this.extendInfo;
    }

    /* renamed from: component3  reason: from getter */
    public final String getGoodsId() {
        return this.goodsId;
    }

    /* renamed from: component4  reason: from getter */
    public final String getBillerId() {
        return this.billerId;
    }

    /* renamed from: component5  reason: from getter */
    public final String getBizType() {
        return this.bizType;
    }

    /* renamed from: component6  reason: from getter */
    public final String getRecurringType() {
        return this.recurringType;
    }

    /* renamed from: component7  reason: from getter */
    public final String getSubscriptionIntervalType() {
        return this.subscriptionIntervalType;
    }

    /* renamed from: component8  reason: from getter */
    public final String getSubscriptionIntervalValue() {
        return this.subscriptionIntervalValue;
    }

    /* renamed from: component9  reason: from getter */
    public final String getSubscriptionHourOfDay() {
        return this.subscriptionHourOfDay;
    }

    public final SaveSubscriptionRequestModel copy(String title, String subscriptionDayOfMonth, String goodsId, String billerId, String bizType, String recurringType, String subscriptionIntervalType, String subscriptionIntervalValue, String subscriptionHourOfDay, String subscriptionMonthOfYear, String message, String securityId, String validateData, String verificationMethod, String sendStrategy, String phoneNumber, String cardIndexNo, String provider, String paymentMethod, String payMode, MoneyViewModel denom, String timezone, String type, MoneyViewModel totalAmount, String productTitle, String extendInfoTitle, Map<String, ? extends Object> extendInfo) {
        Intrinsics.checkNotNullParameter(extendInfo, "");
        return new SaveSubscriptionRequestModel(title, subscriptionDayOfMonth, goodsId, billerId, bizType, recurringType, subscriptionIntervalType, subscriptionIntervalValue, subscriptionHourOfDay, subscriptionMonthOfYear, message, securityId, validateData, verificationMethod, sendStrategy, phoneNumber, cardIndexNo, provider, paymentMethod, payMode, denom, timezone, type, totalAmount, productTitle, extendInfoTitle, extendInfo);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof SaveSubscriptionRequestModel) {
            SaveSubscriptionRequestModel saveSubscriptionRequestModel = (SaveSubscriptionRequestModel) other;
            return Intrinsics.areEqual(this.title, saveSubscriptionRequestModel.title) && Intrinsics.areEqual(this.subscriptionDayOfMonth, saveSubscriptionRequestModel.subscriptionDayOfMonth) && Intrinsics.areEqual(this.goodsId, saveSubscriptionRequestModel.goodsId) && Intrinsics.areEqual(this.billerId, saveSubscriptionRequestModel.billerId) && Intrinsics.areEqual(this.bizType, saveSubscriptionRequestModel.bizType) && Intrinsics.areEqual(this.recurringType, saveSubscriptionRequestModel.recurringType) && Intrinsics.areEqual(this.subscriptionIntervalType, saveSubscriptionRequestModel.subscriptionIntervalType) && Intrinsics.areEqual(this.subscriptionIntervalValue, saveSubscriptionRequestModel.subscriptionIntervalValue) && Intrinsics.areEqual(this.subscriptionHourOfDay, saveSubscriptionRequestModel.subscriptionHourOfDay) && Intrinsics.areEqual(this.subscriptionMonthOfYear, saveSubscriptionRequestModel.subscriptionMonthOfYear) && Intrinsics.areEqual(this.message, saveSubscriptionRequestModel.message) && Intrinsics.areEqual(this.securityId, saveSubscriptionRequestModel.securityId) && Intrinsics.areEqual(this.validateData, saveSubscriptionRequestModel.validateData) && Intrinsics.areEqual(this.verificationMethod, saveSubscriptionRequestModel.verificationMethod) && Intrinsics.areEqual(this.sendStrategy, saveSubscriptionRequestModel.sendStrategy) && Intrinsics.areEqual(this.phoneNumber, saveSubscriptionRequestModel.phoneNumber) && Intrinsics.areEqual(this.cardIndexNo, saveSubscriptionRequestModel.cardIndexNo) && Intrinsics.areEqual(this.provider, saveSubscriptionRequestModel.provider) && Intrinsics.areEqual(this.paymentMethod, saveSubscriptionRequestModel.paymentMethod) && Intrinsics.areEqual(this.payMode, saveSubscriptionRequestModel.payMode) && Intrinsics.areEqual(this.denom, saveSubscriptionRequestModel.denom) && Intrinsics.areEqual(this.timezone, saveSubscriptionRequestModel.timezone) && Intrinsics.areEqual(this.type, saveSubscriptionRequestModel.type) && Intrinsics.areEqual(this.totalAmount, saveSubscriptionRequestModel.totalAmount) && Intrinsics.areEqual(this.productTitle, saveSubscriptionRequestModel.productTitle) && Intrinsics.areEqual(this.extendInfoTitle, saveSubscriptionRequestModel.extendInfoTitle) && Intrinsics.areEqual(this.extendInfo, saveSubscriptionRequestModel.extendInfo);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.title;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.subscriptionDayOfMonth;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.goodsId;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.billerId;
        int hashCode4 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.bizType;
        int hashCode5 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.recurringType;
        int hashCode6 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.subscriptionIntervalType;
        int hashCode7 = str7 == null ? 0 : str7.hashCode();
        String str8 = this.subscriptionIntervalValue;
        int hashCode8 = str8 == null ? 0 : str8.hashCode();
        String str9 = this.subscriptionHourOfDay;
        int hashCode9 = str9 == null ? 0 : str9.hashCode();
        String str10 = this.subscriptionMonthOfYear;
        int hashCode10 = str10 == null ? 0 : str10.hashCode();
        String str11 = this.message;
        int hashCode11 = str11 == null ? 0 : str11.hashCode();
        String str12 = this.securityId;
        int hashCode12 = str12 == null ? 0 : str12.hashCode();
        String str13 = this.validateData;
        int hashCode13 = str13 == null ? 0 : str13.hashCode();
        String str14 = this.verificationMethod;
        int hashCode14 = str14 == null ? 0 : str14.hashCode();
        String str15 = this.sendStrategy;
        int hashCode15 = str15 == null ? 0 : str15.hashCode();
        String str16 = this.phoneNumber;
        int hashCode16 = str16 == null ? 0 : str16.hashCode();
        String str17 = this.cardIndexNo;
        int hashCode17 = str17 == null ? 0 : str17.hashCode();
        String str18 = this.provider;
        int hashCode18 = str18 == null ? 0 : str18.hashCode();
        String str19 = this.paymentMethod;
        int hashCode19 = str19 == null ? 0 : str19.hashCode();
        String str20 = this.payMode;
        int hashCode20 = str20 == null ? 0 : str20.hashCode();
        MoneyViewModel moneyViewModel = this.denom;
        int hashCode21 = moneyViewModel == null ? 0 : moneyViewModel.hashCode();
        String str21 = this.timezone;
        int hashCode22 = str21 == null ? 0 : str21.hashCode();
        String str22 = this.type;
        int hashCode23 = str22 == null ? 0 : str22.hashCode();
        MoneyViewModel moneyViewModel2 = this.totalAmount;
        int hashCode24 = moneyViewModel2 == null ? 0 : moneyViewModel2.hashCode();
        String str23 = this.productTitle;
        int hashCode25 = str23 == null ? 0 : str23.hashCode();
        String str24 = this.extendInfoTitle;
        return (((((((((((((((((((((((((((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + hashCode14) * 31) + hashCode15) * 31) + hashCode16) * 31) + hashCode17) * 31) + hashCode18) * 31) + hashCode19) * 31) + hashCode20) * 31) + hashCode21) * 31) + hashCode22) * 31) + hashCode23) * 31) + hashCode24) * 31) + hashCode25) * 31) + (str24 != null ? str24.hashCode() : 0)) * 31) + this.extendInfo.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SaveSubscriptionRequestModel(title=");
        sb.append(this.title);
        sb.append(", subscriptionDayOfMonth=");
        sb.append(this.subscriptionDayOfMonth);
        sb.append(", goodsId=");
        sb.append(this.goodsId);
        sb.append(", billerId=");
        sb.append(this.billerId);
        sb.append(", bizType=");
        sb.append(this.bizType);
        sb.append(", recurringType=");
        sb.append(this.recurringType);
        sb.append(", subscriptionIntervalType=");
        sb.append(this.subscriptionIntervalType);
        sb.append(", subscriptionIntervalValue=");
        sb.append(this.subscriptionIntervalValue);
        sb.append(", subscriptionHourOfDay=");
        sb.append(this.subscriptionHourOfDay);
        sb.append(", subscriptionMonthOfYear=");
        sb.append(this.subscriptionMonthOfYear);
        sb.append(", message=");
        sb.append(this.message);
        sb.append(", securityId=");
        sb.append(this.securityId);
        sb.append(", validateData=");
        sb.append(this.validateData);
        sb.append(", verificationMethod=");
        sb.append(this.verificationMethod);
        sb.append(", sendStrategy=");
        sb.append(this.sendStrategy);
        sb.append(", phoneNumber=");
        sb.append(this.phoneNumber);
        sb.append(", cardIndexNo=");
        sb.append(this.cardIndexNo);
        sb.append(", provider=");
        sb.append(this.provider);
        sb.append(", paymentMethod=");
        sb.append(this.paymentMethod);
        sb.append(", payMode=");
        sb.append(this.payMode);
        sb.append(", denom=");
        sb.append(this.denom);
        sb.append(", timezone=");
        sb.append(this.timezone);
        sb.append(", type=");
        sb.append(this.type);
        sb.append(", totalAmount=");
        sb.append(this.totalAmount);
        sb.append(", productTitle=");
        sb.append(this.productTitle);
        sb.append(", extendInfoTitle=");
        sb.append(this.extendInfoTitle);
        sb.append(", extendInfo=");
        sb.append(this.extendInfo);
        sb.append(')');
        return sb.toString();
    }

    public SaveSubscriptionRequestModel(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, MoneyViewModel moneyViewModel, String str21, String str22, MoneyViewModel moneyViewModel2, String str23, String str24, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "");
        this.title = str;
        this.subscriptionDayOfMonth = str2;
        this.goodsId = str3;
        this.billerId = str4;
        this.bizType = str5;
        this.recurringType = str6;
        this.subscriptionIntervalType = str7;
        this.subscriptionIntervalValue = str8;
        this.subscriptionHourOfDay = str9;
        this.subscriptionMonthOfYear = str10;
        this.message = str11;
        this.securityId = str12;
        this.validateData = str13;
        this.verificationMethod = str14;
        this.sendStrategy = str15;
        this.phoneNumber = str16;
        this.cardIndexNo = str17;
        this.provider = str18;
        this.paymentMethod = str19;
        this.payMode = str20;
        this.denom = moneyViewModel;
        this.timezone = str21;
        this.type = str22;
        this.totalAmount = moneyViewModel2;
        this.productTitle = str23;
        this.extendInfoTitle = str24;
        this.extendInfo = map;
    }

    @JvmName(name = "getTitle")
    public final String getTitle() {
        return this.title;
    }

    @JvmName(name = GriverEvents.EVENT_SET_TITLE)
    public final void setTitle(String str) {
        this.title = str;
    }

    @JvmName(name = "getSubscriptionDayOfMonth")
    public final String getSubscriptionDayOfMonth() {
        return this.subscriptionDayOfMonth;
    }

    @JvmName(name = "setSubscriptionDayOfMonth")
    public final void setSubscriptionDayOfMonth(String str) {
        this.subscriptionDayOfMonth = str;
    }

    @JvmName(name = "getGoodsId")
    public final String getGoodsId() {
        return this.goodsId;
    }

    @JvmName(name = "setGoodsId")
    public final void setGoodsId(String str) {
        this.goodsId = str;
    }

    @JvmName(name = "getBillerId")
    public final String getBillerId() {
        return this.billerId;
    }

    @JvmName(name = "setBillerId")
    public final void setBillerId(String str) {
        this.billerId = str;
    }

    @JvmName(name = "getBizType")
    public final String getBizType() {
        return this.bizType;
    }

    @JvmName(name = "setBizType")
    public final void setBizType(String str) {
        this.bizType = str;
    }

    @JvmName(name = "getRecurringType")
    public final String getRecurringType() {
        return this.recurringType;
    }

    @JvmName(name = "setRecurringType")
    public final void setRecurringType(String str) {
        this.recurringType = str;
    }

    @JvmName(name = "getSubscriptionIntervalType")
    public final String getSubscriptionIntervalType() {
        return this.subscriptionIntervalType;
    }

    @JvmName(name = "setSubscriptionIntervalType")
    public final void setSubscriptionIntervalType(String str) {
        this.subscriptionIntervalType = str;
    }

    @JvmName(name = "getSubscriptionIntervalValue")
    public final String getSubscriptionIntervalValue() {
        return this.subscriptionIntervalValue;
    }

    @JvmName(name = "setSubscriptionIntervalValue")
    public final void setSubscriptionIntervalValue(String str) {
        this.subscriptionIntervalValue = str;
    }

    @JvmName(name = "getSubscriptionHourOfDay")
    public final String getSubscriptionHourOfDay() {
        return this.subscriptionHourOfDay;
    }

    @JvmName(name = "setSubscriptionHourOfDay")
    public final void setSubscriptionHourOfDay(String str) {
        this.subscriptionHourOfDay = str;
    }

    @JvmName(name = "getSubscriptionMonthOfYear")
    public final String getSubscriptionMonthOfYear() {
        return this.subscriptionMonthOfYear;
    }

    @JvmName(name = "setSubscriptionMonthOfYear")
    public final void setSubscriptionMonthOfYear(String str) {
        this.subscriptionMonthOfYear = str;
    }

    @JvmName(name = "getMessage")
    public final String getMessage() {
        return this.message;
    }

    @JvmName(name = "setMessage")
    public final void setMessage(String str) {
        this.message = str;
    }

    @JvmName(name = "getSecurityId")
    public final String getSecurityId() {
        return this.securityId;
    }

    @JvmName(name = "setSecurityId")
    public final void setSecurityId(String str) {
        this.securityId = str;
    }

    @JvmName(name = "getValidateData")
    public final String getValidateData() {
        return this.validateData;
    }

    @JvmName(name = "setValidateData")
    public final void setValidateData(String str) {
        this.validateData = str;
    }

    @JvmName(name = "getVerificationMethod")
    public final String getVerificationMethod() {
        return this.verificationMethod;
    }

    @JvmName(name = "setVerificationMethod")
    public final void setVerificationMethod(String str) {
        this.verificationMethod = str;
    }

    @JvmName(name = "getSendStrategy")
    public final String getSendStrategy() {
        return this.sendStrategy;
    }

    @JvmName(name = "setSendStrategy")
    public final void setSendStrategy(String str) {
        this.sendStrategy = str;
    }

    @JvmName(name = "getPhoneNumber")
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    @JvmName(name = "setPhoneNumber")
    public final void setPhoneNumber(String str) {
        this.phoneNumber = str;
    }

    @JvmName(name = "getCardIndexNo")
    public final String getCardIndexNo() {
        return this.cardIndexNo;
    }

    @JvmName(name = "setCardIndexNo")
    public final void setCardIndexNo(String str) {
        this.cardIndexNo = str;
    }

    @JvmName(name = "getProvider")
    public final String getProvider() {
        return this.provider;
    }

    @JvmName(name = "setProvider")
    public final void setProvider(String str) {
        this.provider = str;
    }

    @JvmName(name = "getPaymentMethod")
    public final String getPaymentMethod() {
        return this.paymentMethod;
    }

    @JvmName(name = "setPaymentMethod")
    public final void setPaymentMethod(String str) {
        this.paymentMethod = str;
    }

    @JvmName(name = "getPayMode")
    public final String getPayMode() {
        return this.payMode;
    }

    @JvmName(name = "setPayMode")
    public final void setPayMode(String str) {
        this.payMode = str;
    }

    @JvmName(name = "getDenom")
    public final MoneyViewModel getDenom() {
        return this.denom;
    }

    @JvmName(name = "setDenom")
    public final void setDenom(MoneyViewModel moneyViewModel) {
        this.denom = moneyViewModel;
    }

    @JvmName(name = "getTimezone")
    public final String getTimezone() {
        return this.timezone;
    }

    @JvmName(name = "setTimezone")
    public final void setTimezone(String str) {
        this.timezone = str;
    }

    @JvmName(name = "getType")
    public final String getType() {
        return this.type;
    }

    @JvmName(name = "setType")
    public final void setType(String str) {
        this.type = str;
    }

    @JvmName(name = "getTotalAmount")
    public final MoneyViewModel getTotalAmount() {
        return this.totalAmount;
    }

    @JvmName(name = "setTotalAmount")
    public final void setTotalAmount(MoneyViewModel moneyViewModel) {
        this.totalAmount = moneyViewModel;
    }

    @JvmName(name = "getProductTitle")
    public final String getProductTitle() {
        return this.productTitle;
    }

    @JvmName(name = "setProductTitle")
    public final void setProductTitle(String str) {
        this.productTitle = str;
    }

    @JvmName(name = "getExtendInfoTitle")
    public final String getExtendInfoTitle() {
        return this.extendInfoTitle;
    }

    @JvmName(name = "setExtendInfoTitle")
    public final void setExtendInfoTitle(String str) {
        this.extendInfoTitle = str;
    }

    public /* synthetic */ SaveSubscriptionRequestModel(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, MoneyViewModel moneyViewModel, String str21, String str22, MoneyViewModel moneyViewModel2, String str23, String str24, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "" : str6, (i & 64) != 0 ? "" : str7, (i & 128) != 0 ? "1" : str8, (i & 256) != 0 ? "" : str9, (i & 512) != 0 ? "" : str10, (i & 1024) != 0 ? "" : str11, (i & 2048) != 0 ? "" : str12, (i & 4096) != 0 ? "" : str13, (i & 8192) != 0 ? "" : str14, (i & 16384) != 0 ? "" : str15, (i & 32768) != 0 ? "" : str16, (i & 65536) != 0 ? "" : str17, (i & AntDetector.SCENE_ID_LOGIN_REGIST) != 0 ? "" : str18, (i & 262144) != 0 ? "" : str19, (i & 524288) != 0 ? "" : str20, (i & CrashCombineUtils.DEFAULT_MAX_INFO_LEN) != 0 ? null : moneyViewModel, (i & 2097152) != 0 ? "" : str21, (i & 4194304) != 0 ? "" : str22, (i & 8388608) == 0 ? moneyViewModel2 : null, (i & 16777216) != 0 ? "" : str23, (i & 33554432) != 0 ? "" : str24, (i & 67108864) != 0 ? MapsKt.emptyMap() : map);
    }

    @JvmName(name = "getExtendInfo")
    public final Map<String, Object> getExtendInfo() {
        return this.extendInfo;
    }

    @JvmName(name = "setExtendInfo")
    public final void setExtendInfo(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "");
        this.extendInfo = map;
    }
}
