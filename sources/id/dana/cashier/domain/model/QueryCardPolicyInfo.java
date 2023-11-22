package id.dana.cashier.domain.model;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\b\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001B¯\u0001\u0012\u0014\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f\u0012\b\u0010(\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010)\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\bG\u0010HJ\u001e\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0018\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0012\u0010\nJ\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0013\u0010\nJ\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0014\u0010\nJ\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0015\u0010\nJ\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0016\u0010\nJ\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0017\u0010\nJ\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0018\u0010\bJ\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0019\u0010\nJ\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u001a\u0010\nJÖ\u0001\u0010*\u001a\u00020\u00002\u0016\b\u0002\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0004\b*\u0010+J\u001a\u0010-\u001a\u00020\u00062\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b-\u0010.J\u0010\u00100\u001a\u00020/HÖ\u0001¢\u0006\u0004\b0\u00101J\u0010\u00102\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b2\u0010\nR%\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u001b\u00103\u001a\u0004\b4\u0010\u0005R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u00105\u001a\u0004\b6\u0010\nR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u00105\u001a\u0004\b7\u0010\nR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u00105\u001a\u0004\b8\u0010\nR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u00105\u001a\u0004\b9\u0010\nR\u001c\u0010 \u001a\u0004\u0018\u00010\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b \u00105\u001a\u0004\b:\u0010\nR\u001c\u0010(\u001a\u0004\u0018\u00010\u000f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010;\u001a\u0004\b<\u0010\u0011R\u001c\u0010!\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010=\u001a\u0004\b>\u0010\bR\u001c\u0010\"\u001a\u0004\u0018\u00010\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\"\u00105\u001a\u0004\b?\u0010\nR\u001c\u0010#\u001a\u0004\u0018\u00010\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b#\u00105\u001a\u0004\b@\u0010\nR\u001c\u0010$\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010=\u001a\u0004\bA\u0010\bR\u001c\u0010&\u001a\u0004\u0018\u00010\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b&\u00105\u001a\u0004\bB\u0010\nR\u001c\u0010%\u001a\u0004\u0018\u00010\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b%\u00105\u001a\u0004\bC\u0010\nR\"\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010D\u001a\u0004\bE\u0010\u000eR\u001c\u0010)\u001a\u0004\u0018\u00010\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b)\u00105\u001a\u0004\bF\u0010\n"}, d2 = {"Lid/dana/cashier/domain/model/QueryCardPolicyInfo;", "", "", "", "component1", "()Ljava/util/Map;", "", "component10", "()Ljava/lang/Boolean;", "component11", "()Ljava/lang/String;", "component12", "", "component13", "()Ljava/util/List;", "Lid/dana/cashier/domain/model/DailyLimitAmountConf;", "component14", "()Lid/dana/cashier/domain/model/DailyLimitAmountConf;", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "actions", "cardBin", "cardScheme", "cardType", "channelIndex", "countryIssuer", "directDebit", "instId", "instName", "normalPay", "payOption", "payMethod", "verifyElements", "dailyLimitAmountConf", "warnMessage", "copy", "(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lid/dana/cashier/domain/model/DailyLimitAmountConf;Ljava/lang/String;)Lid/dana/cashier/domain/model/QueryCardPolicyInfo;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/util/Map;", "getActions", "Ljava/lang/String;", "getCardBin", "getCardScheme", "getCardType", "getChannelIndex", "getCountryIssuer", "Lid/dana/cashier/domain/model/DailyLimitAmountConf;", "getDailyLimitAmountConf", "Ljava/lang/Boolean;", "getDirectDebit", "getInstId", "getInstName", "getNormalPay", "getPayMethod", "getPayOption", "Ljava/util/List;", "getVerifyElements", "getWarnMessage", "<init>", "(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lid/dana/cashier/domain/model/DailyLimitAmountConf;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class QueryCardPolicyInfo {
    private final Map<String, String> actions;
    private final String cardBin;
    private final String cardScheme;
    private final String cardType;
    private final String channelIndex;
    private final String countryIssuer;
    private final DailyLimitAmountConf dailyLimitAmountConf;
    private final Boolean directDebit;
    private final String instId;
    private final String instName;
    private final Boolean normalPay;
    private final String payMethod;
    private final String payOption;
    private final List<String> verifyElements;
    private final String warnMessage;

    public final Map<String, String> component1() {
        return this.actions;
    }

    /* renamed from: component10  reason: from getter */
    public final Boolean getNormalPay() {
        return this.normalPay;
    }

    /* renamed from: component11  reason: from getter */
    public final String getPayOption() {
        return this.payOption;
    }

    /* renamed from: component12  reason: from getter */
    public final String getPayMethod() {
        return this.payMethod;
    }

    public final List<String> component13() {
        return this.verifyElements;
    }

    /* renamed from: component14  reason: from getter */
    public final DailyLimitAmountConf getDailyLimitAmountConf() {
        return this.dailyLimitAmountConf;
    }

    /* renamed from: component15  reason: from getter */
    public final String getWarnMessage() {
        return this.warnMessage;
    }

    /* renamed from: component2  reason: from getter */
    public final String getCardBin() {
        return this.cardBin;
    }

    /* renamed from: component3  reason: from getter */
    public final String getCardScheme() {
        return this.cardScheme;
    }

    /* renamed from: component4  reason: from getter */
    public final String getCardType() {
        return this.cardType;
    }

    /* renamed from: component5  reason: from getter */
    public final String getChannelIndex() {
        return this.channelIndex;
    }

    /* renamed from: component6  reason: from getter */
    public final String getCountryIssuer() {
        return this.countryIssuer;
    }

    /* renamed from: component7  reason: from getter */
    public final Boolean getDirectDebit() {
        return this.directDebit;
    }

    /* renamed from: component8  reason: from getter */
    public final String getInstId() {
        return this.instId;
    }

    /* renamed from: component9  reason: from getter */
    public final String getInstName() {
        return this.instName;
    }

    public final QueryCardPolicyInfo copy(Map<String, String> actions, String cardBin, String cardScheme, String cardType, String channelIndex, String countryIssuer, Boolean directDebit, String instId, String instName, Boolean normalPay, String payOption, String payMethod, List<String> verifyElements, DailyLimitAmountConf dailyLimitAmountConf, String warnMessage) {
        return new QueryCardPolicyInfo(actions, cardBin, cardScheme, cardType, channelIndex, countryIssuer, directDebit, instId, instName, normalPay, payOption, payMethod, verifyElements, dailyLimitAmountConf, warnMessage);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof QueryCardPolicyInfo) {
            QueryCardPolicyInfo queryCardPolicyInfo = (QueryCardPolicyInfo) other;
            return Intrinsics.areEqual(this.actions, queryCardPolicyInfo.actions) && Intrinsics.areEqual(this.cardBin, queryCardPolicyInfo.cardBin) && Intrinsics.areEqual(this.cardScheme, queryCardPolicyInfo.cardScheme) && Intrinsics.areEqual(this.cardType, queryCardPolicyInfo.cardType) && Intrinsics.areEqual(this.channelIndex, queryCardPolicyInfo.channelIndex) && Intrinsics.areEqual(this.countryIssuer, queryCardPolicyInfo.countryIssuer) && Intrinsics.areEqual(this.directDebit, queryCardPolicyInfo.directDebit) && Intrinsics.areEqual(this.instId, queryCardPolicyInfo.instId) && Intrinsics.areEqual(this.instName, queryCardPolicyInfo.instName) && Intrinsics.areEqual(this.normalPay, queryCardPolicyInfo.normalPay) && Intrinsics.areEqual(this.payOption, queryCardPolicyInfo.payOption) && Intrinsics.areEqual(this.payMethod, queryCardPolicyInfo.payMethod) && Intrinsics.areEqual(this.verifyElements, queryCardPolicyInfo.verifyElements) && Intrinsics.areEqual(this.dailyLimitAmountConf, queryCardPolicyInfo.dailyLimitAmountConf) && Intrinsics.areEqual(this.warnMessage, queryCardPolicyInfo.warnMessage);
        }
        return false;
    }

    public final int hashCode() {
        Map<String, String> map = this.actions;
        int hashCode = map == null ? 0 : map.hashCode();
        String str = this.cardBin;
        int hashCode2 = str == null ? 0 : str.hashCode();
        String str2 = this.cardScheme;
        int hashCode3 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.cardType;
        int hashCode4 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.channelIndex;
        int hashCode5 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.countryIssuer;
        int hashCode6 = str5 == null ? 0 : str5.hashCode();
        Boolean bool = this.directDebit;
        int hashCode7 = bool == null ? 0 : bool.hashCode();
        String str6 = this.instId;
        int hashCode8 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.instName;
        int hashCode9 = str7 == null ? 0 : str7.hashCode();
        Boolean bool2 = this.normalPay;
        int hashCode10 = bool2 == null ? 0 : bool2.hashCode();
        String str8 = this.payOption;
        int hashCode11 = str8 == null ? 0 : str8.hashCode();
        String str9 = this.payMethod;
        int hashCode12 = str9 == null ? 0 : str9.hashCode();
        List<String> list = this.verifyElements;
        int hashCode13 = list == null ? 0 : list.hashCode();
        DailyLimitAmountConf dailyLimitAmountConf = this.dailyLimitAmountConf;
        int hashCode14 = dailyLimitAmountConf == null ? 0 : dailyLimitAmountConf.hashCode();
        String str10 = this.warnMessage;
        return (((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + hashCode14) * 31) + (str10 != null ? str10.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("QueryCardPolicyInfo(actions=");
        sb.append(this.actions);
        sb.append(", cardBin=");
        sb.append(this.cardBin);
        sb.append(", cardScheme=");
        sb.append(this.cardScheme);
        sb.append(", cardType=");
        sb.append(this.cardType);
        sb.append(", channelIndex=");
        sb.append(this.channelIndex);
        sb.append(", countryIssuer=");
        sb.append(this.countryIssuer);
        sb.append(", directDebit=");
        sb.append(this.directDebit);
        sb.append(", instId=");
        sb.append(this.instId);
        sb.append(", instName=");
        sb.append(this.instName);
        sb.append(", normalPay=");
        sb.append(this.normalPay);
        sb.append(", payOption=");
        sb.append(this.payOption);
        sb.append(", payMethod=");
        sb.append(this.payMethod);
        sb.append(", verifyElements=");
        sb.append(this.verifyElements);
        sb.append(", dailyLimitAmountConf=");
        sb.append(this.dailyLimitAmountConf);
        sb.append(", warnMessage=");
        sb.append(this.warnMessage);
        sb.append(')');
        return sb.toString();
    }

    public QueryCardPolicyInfo(Map<String, String> map, String str, String str2, String str3, String str4, String str5, Boolean bool, String str6, String str7, Boolean bool2, String str8, String str9, List<String> list, DailyLimitAmountConf dailyLimitAmountConf, String str10) {
        this.actions = map;
        this.cardBin = str;
        this.cardScheme = str2;
        this.cardType = str3;
        this.channelIndex = str4;
        this.countryIssuer = str5;
        this.directDebit = bool;
        this.instId = str6;
        this.instName = str7;
        this.normalPay = bool2;
        this.payOption = str8;
        this.payMethod = str9;
        this.verifyElements = list;
        this.dailyLimitAmountConf = dailyLimitAmountConf;
        this.warnMessage = str10;
    }

    @JvmName(name = "getActions")
    public final Map<String, String> getActions() {
        return this.actions;
    }

    @JvmName(name = "getCardBin")
    public final String getCardBin() {
        return this.cardBin;
    }

    @JvmName(name = "getCardScheme")
    public final String getCardScheme() {
        return this.cardScheme;
    }

    @JvmName(name = "getCardType")
    public final String getCardType() {
        return this.cardType;
    }

    @JvmName(name = "getChannelIndex")
    public final String getChannelIndex() {
        return this.channelIndex;
    }

    @JvmName(name = "getCountryIssuer")
    public final String getCountryIssuer() {
        return this.countryIssuer;
    }

    @JvmName(name = "getDirectDebit")
    public final Boolean getDirectDebit() {
        return this.directDebit;
    }

    @JvmName(name = "getInstId")
    public final String getInstId() {
        return this.instId;
    }

    @JvmName(name = "getInstName")
    public final String getInstName() {
        return this.instName;
    }

    @JvmName(name = "getNormalPay")
    public final Boolean getNormalPay() {
        return this.normalPay;
    }

    @JvmName(name = "getPayOption")
    public final String getPayOption() {
        return this.payOption;
    }

    @JvmName(name = "getPayMethod")
    public final String getPayMethod() {
        return this.payMethod;
    }

    @JvmName(name = "getVerifyElements")
    public final List<String> getVerifyElements() {
        return this.verifyElements;
    }

    @JvmName(name = "getDailyLimitAmountConf")
    public final DailyLimitAmountConf getDailyLimitAmountConf() {
        return this.dailyLimitAmountConf;
    }

    @JvmName(name = "getWarnMessage")
    public final String getWarnMessage() {
        return this.warnMessage;
    }
}
