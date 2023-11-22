package id.dana.data.investment.repository.source.network.response;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import com.appsflyer.AppsFlyerProperties;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f"}, d2 = {"Lid/dana/data/investment/repository/source/network/response/MultiCurrencyMoneyResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "amount", "Ljava/lang/Long;", "getAmount", "()Ljava/lang/Long;", "cent", "getCent", "centFactor", "getCentFactor", "", FirebaseAnalytics.Param.CURRENCY, "Ljava/lang/String;", "getCurrency", "()Ljava/lang/String;", AppsFlyerProperties.CURRENCY_CODE, "getCurrencyCode", "currencyValue", "getCurrencyValue", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MultiCurrencyMoneyResult extends BaseRpcResult {
    private final Long amount;
    private final Long cent;
    private final Long centFactor;
    private final String currency;
    private final String currencyCode;
    private final String currencyValue;

    public MultiCurrencyMoneyResult() {
        this(null, null, null, null, null, null, 63, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ MultiCurrencyMoneyResult(java.lang.Long r5, java.lang.Long r6, java.lang.Long r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, int r11, kotlin.jvm.internal.DefaultConstructorMarker r12) {
        /*
            r4 = this;
            r0 = 0
            java.lang.Long r12 = java.lang.Long.valueOf(r0)
            r0 = r11 & 1
            if (r0 == 0) goto Lc
            r0 = r12
            goto Ld
        Lc:
            r0 = r5
        Ld:
            r5 = r11 & 2
            if (r5 == 0) goto L13
            r1 = r12
            goto L14
        L13:
            r1 = r6
        L14:
            r5 = r11 & 4
            if (r5 != 0) goto L19
            r12 = r7
        L19:
            r5 = r11 & 8
            java.lang.String r6 = ""
            if (r5 == 0) goto L21
            r2 = r6
            goto L22
        L21:
            r2 = r8
        L22:
            r5 = r11 & 16
            if (r5 == 0) goto L28
            r3 = r6
            goto L29
        L28:
            r3 = r9
        L29:
            r5 = r11 & 32
            if (r5 == 0) goto L2f
            r11 = r6
            goto L30
        L2f:
            r11 = r10
        L30:
            r5 = r4
            r6 = r0
            r7 = r1
            r8 = r12
            r9 = r2
            r10 = r3
            r5.<init>(r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.investment.repository.source.network.response.MultiCurrencyMoneyResult.<init>(java.lang.Long, java.lang.Long, java.lang.Long, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @JvmName(name = "getAmount")
    public final Long getAmount() {
        return this.amount;
    }

    @JvmName(name = "getCent")
    public final Long getCent() {
        return this.cent;
    }

    @JvmName(name = "getCentFactor")
    public final Long getCentFactor() {
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

    public MultiCurrencyMoneyResult(Long l, Long l2, Long l3, String str, String str2, String str3) {
        this.amount = l;
        this.cent = l2;
        this.centFactor = l3;
        this.currency = str;
        this.currencyCode = str2;
        this.currencyValue = str3;
    }
}
