package id.dana.domain.sendmoney.model;

import com.alibaba.griver.api.common.config.GriverConfigConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b3\b\u0086\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\b\u0012\b\u0010 \u001a\u0004\u0018\u00010\b\u0012\b\u0010!\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b:\u0010;J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\f\u0010\nJ\u0012\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\r\u0010\nJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0007J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u000f\u0010\nJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u0010\u0010\nJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u0011\u0010\nJ\u0012\u0010\u0012\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u0012\u0010\nJ\u0012\u0010\u0013\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u0013\u0010\nJ\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0007J¬\u0001\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\"\u0010#J\u001a\u0010%\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b'\u0010(J\u0010\u0010)\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b)\u0010\nR\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0015\u0010*\u001a\u0004\b+\u0010\u0004R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010,\u001a\u0004\b-\u0010\nR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010.\u001a\u0004\b/\u0010\u0007R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010,\u001a\u0004\b0\u0010\nR\u001c\u0010 \u001a\u0004\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b \u0010,\u001a\u0004\b1\u0010\nR\u001c\u0010!\u001a\u0004\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010,\u001a\u0004\b2\u0010\nR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010,\u001a\u0004\b3\u0010\nR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010,\u001a\u0004\b4\u0010\nR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010,\u001a\u0004\b5\u0010\nR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010,\u001a\u0004\b6\u0010\nR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010,\u001a\u0004\b7\u0010\nR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010.\u001a\u0004\b8\u0010\u0007R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010.\u001a\u0004\b9\u0010\u0007"}, d2 = {"Lid/dana/domain/sendmoney/model/WithdrawInitChannelOption;", "", "", "component1", "()Ljava/lang/Integer;", "", "component10", "()Ljava/lang/Boolean;", "", "component11", "()Ljava/lang/String;", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "cardNoLength", "channelIndex", GriverConfigConstants.KEY_PRESET_APP_CONFIG_DISABLE, "instId", "instLocalName", "instName", "payMethod", "payOption", "selected", "validData", "disableReason", "errorCode", "errorMsg", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/sendmoney/model/WithdrawInitChannelOption;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "Ljava/lang/Integer;", "getCardNoLength", "Ljava/lang/String;", "getChannelIndex", "Ljava/lang/Boolean;", "getDisable", "getDisableReason", "getErrorCode", "getErrorMsg", "getInstId", "getInstLocalName", "getInstName", "getPayMethod", "getPayOption", "getSelected", "getValidData", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class WithdrawInitChannelOption {
    private final Integer cardNoLength;
    private final String channelIndex;
    private final Boolean disable;
    private final String disableReason;
    private final String errorCode;
    private final String errorMsg;
    private final String instId;
    private final String instLocalName;
    private final String instName;
    private final String payMethod;
    private final String payOption;
    private final Boolean selected;
    private final Boolean validData;

    /* renamed from: component1  reason: from getter */
    public final Integer getCardNoLength() {
        return this.cardNoLength;
    }

    /* renamed from: component10  reason: from getter */
    public final Boolean getValidData() {
        return this.validData;
    }

    /* renamed from: component11  reason: from getter */
    public final String getDisableReason() {
        return this.disableReason;
    }

    /* renamed from: component12  reason: from getter */
    public final String getErrorCode() {
        return this.errorCode;
    }

    /* renamed from: component13  reason: from getter */
    public final String getErrorMsg() {
        return this.errorMsg;
    }

    /* renamed from: component2  reason: from getter */
    public final String getChannelIndex() {
        return this.channelIndex;
    }

    /* renamed from: component3  reason: from getter */
    public final Boolean getDisable() {
        return this.disable;
    }

    /* renamed from: component4  reason: from getter */
    public final String getInstId() {
        return this.instId;
    }

    /* renamed from: component5  reason: from getter */
    public final String getInstLocalName() {
        return this.instLocalName;
    }

    /* renamed from: component6  reason: from getter */
    public final String getInstName() {
        return this.instName;
    }

    /* renamed from: component7  reason: from getter */
    public final String getPayMethod() {
        return this.payMethod;
    }

    /* renamed from: component8  reason: from getter */
    public final String getPayOption() {
        return this.payOption;
    }

    /* renamed from: component9  reason: from getter */
    public final Boolean getSelected() {
        return this.selected;
    }

    public final WithdrawInitChannelOption copy(Integer cardNoLength, String channelIndex, Boolean disable, String instId, String instLocalName, String instName, String payMethod, String payOption, Boolean selected, Boolean validData, String disableReason, String errorCode, String errorMsg) {
        return new WithdrawInitChannelOption(cardNoLength, channelIndex, disable, instId, instLocalName, instName, payMethod, payOption, selected, validData, disableReason, errorCode, errorMsg);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof WithdrawInitChannelOption) {
            WithdrawInitChannelOption withdrawInitChannelOption = (WithdrawInitChannelOption) other;
            return Intrinsics.areEqual(this.cardNoLength, withdrawInitChannelOption.cardNoLength) && Intrinsics.areEqual(this.channelIndex, withdrawInitChannelOption.channelIndex) && Intrinsics.areEqual(this.disable, withdrawInitChannelOption.disable) && Intrinsics.areEqual(this.instId, withdrawInitChannelOption.instId) && Intrinsics.areEqual(this.instLocalName, withdrawInitChannelOption.instLocalName) && Intrinsics.areEqual(this.instName, withdrawInitChannelOption.instName) && Intrinsics.areEqual(this.payMethod, withdrawInitChannelOption.payMethod) && Intrinsics.areEqual(this.payOption, withdrawInitChannelOption.payOption) && Intrinsics.areEqual(this.selected, withdrawInitChannelOption.selected) && Intrinsics.areEqual(this.validData, withdrawInitChannelOption.validData) && Intrinsics.areEqual(this.disableReason, withdrawInitChannelOption.disableReason) && Intrinsics.areEqual(this.errorCode, withdrawInitChannelOption.errorCode) && Intrinsics.areEqual(this.errorMsg, withdrawInitChannelOption.errorMsg);
        }
        return false;
    }

    public final int hashCode() {
        Integer num = this.cardNoLength;
        int hashCode = num == null ? 0 : num.hashCode();
        String str = this.channelIndex;
        int hashCode2 = str == null ? 0 : str.hashCode();
        Boolean bool = this.disable;
        int hashCode3 = bool == null ? 0 : bool.hashCode();
        String str2 = this.instId;
        int hashCode4 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.instLocalName;
        int hashCode5 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.instName;
        int hashCode6 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.payMethod;
        int hashCode7 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.payOption;
        int hashCode8 = str6 == null ? 0 : str6.hashCode();
        Boolean bool2 = this.selected;
        int hashCode9 = bool2 == null ? 0 : bool2.hashCode();
        Boolean bool3 = this.validData;
        int hashCode10 = bool3 == null ? 0 : bool3.hashCode();
        String str7 = this.disableReason;
        int hashCode11 = str7 == null ? 0 : str7.hashCode();
        String str8 = this.errorCode;
        int hashCode12 = str8 == null ? 0 : str8.hashCode();
        String str9 = this.errorMsg;
        return (((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + (str9 != null ? str9.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WithdrawInitChannelOption(cardNoLength=");
        sb.append(this.cardNoLength);
        sb.append(", channelIndex=");
        sb.append(this.channelIndex);
        sb.append(", disable=");
        sb.append(this.disable);
        sb.append(", instId=");
        sb.append(this.instId);
        sb.append(", instLocalName=");
        sb.append(this.instLocalName);
        sb.append(", instName=");
        sb.append(this.instName);
        sb.append(", payMethod=");
        sb.append(this.payMethod);
        sb.append(", payOption=");
        sb.append(this.payOption);
        sb.append(", selected=");
        sb.append(this.selected);
        sb.append(", validData=");
        sb.append(this.validData);
        sb.append(", disableReason=");
        sb.append(this.disableReason);
        sb.append(", errorCode=");
        sb.append(this.errorCode);
        sb.append(", errorMsg=");
        sb.append(this.errorMsg);
        sb.append(')');
        return sb.toString();
    }

    public WithdrawInitChannelOption(Integer num, String str, Boolean bool, String str2, String str3, String str4, String str5, String str6, Boolean bool2, Boolean bool3, String str7, String str8, String str9) {
        this.cardNoLength = num;
        this.channelIndex = str;
        this.disable = bool;
        this.instId = str2;
        this.instLocalName = str3;
        this.instName = str4;
        this.payMethod = str5;
        this.payOption = str6;
        this.selected = bool2;
        this.validData = bool3;
        this.disableReason = str7;
        this.errorCode = str8;
        this.errorMsg = str9;
    }

    @JvmName(name = "getCardNoLength")
    public final Integer getCardNoLength() {
        return this.cardNoLength;
    }

    @JvmName(name = "getChannelIndex")
    public final String getChannelIndex() {
        return this.channelIndex;
    }

    @JvmName(name = "getDisable")
    public final Boolean getDisable() {
        return this.disable;
    }

    @JvmName(name = "getInstId")
    public final String getInstId() {
        return this.instId;
    }

    @JvmName(name = "getInstLocalName")
    public final String getInstLocalName() {
        return this.instLocalName;
    }

    @JvmName(name = "getInstName")
    public final String getInstName() {
        return this.instName;
    }

    @JvmName(name = "getPayMethod")
    public final String getPayMethod() {
        return this.payMethod;
    }

    @JvmName(name = "getPayOption")
    public final String getPayOption() {
        return this.payOption;
    }

    @JvmName(name = "getSelected")
    public final Boolean getSelected() {
        return this.selected;
    }

    @JvmName(name = "getValidData")
    public final Boolean getValidData() {
        return this.validData;
    }

    @JvmName(name = "getDisableReason")
    public final String getDisableReason() {
        return this.disableReason;
    }

    @JvmName(name = "getErrorCode")
    public final String getErrorCode() {
        return this.errorCode;
    }

    @JvmName(name = "getErrorMsg")
    public final String getErrorMsg() {
        return this.errorMsg;
    }
}
