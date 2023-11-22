package id.dana.cashier.domain.model;

import id.dana.cashier.utils.CashierKeyParams;
import id.dana.domain.investment.model.DanaPlusMethodConfig;
import id.dana.domain.payasset.model.Institution;
import id.dana.domain.payasset.model.PayMethod;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u001e\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b>\u0010?J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0007J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\u0007J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0007J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013Jn\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u001a\u001a\u00020\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0011HÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010\u001f\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\"\u001a\u00020!HÖ\u0001¢\u0006\u0004\b\"\u0010#J\r\u0010$\u001a\u00020\b¢\u0006\u0004\b$\u0010%J\r\u0010&\u001a\u00020\b¢\u0006\u0004\b&\u0010%J\r\u0010'\u001a\u00020\b¢\u0006\u0004\b'\u0010%J\r\u0010(\u001a\u00020\b¢\u0006\u0004\b(\u0010%J\r\u0010)\u001a\u00020\b¢\u0006\u0004\b)\u0010%J\u0010\u0010*\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b*\u0010\u0007R$\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010+\u001a\u0004\b,\u0010\u0004\"\u0004\b-\u0010.R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010/\u001a\u0004\b0\u0010\u0007R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u00101\u001a\u0004\b2\u0010\u000fR$\u0010\u001b\u001a\u0004\u0018\u00010\u00118\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u00103\u001a\u0004\b4\u0010\u0013\"\u0004\b5\u00106R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010/\u001a\u0004\b7\u0010\u0007R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010/\u001a\u0004\b8\u0010\u0007R\"\u0010\u001a\u001a\u00020\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010/\u001a\u0004\b9\u0010\u0007\"\u0004\b:\u0010;R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010<\u001a\u0004\b=\u0010\n"}, d2 = {"Lid/dana/cashier/domain/model/CashierPay;", "", "Lid/dana/cashier/domain/model/Attribute;", "component1", "()Lid/dana/cashier/domain/model/Attribute;", "", "component2", "()Ljava/lang/String;", "", "component3", "()Ljava/lang/Boolean;", "component4", "component5", "Lid/dana/cashier/domain/model/ConfigCashierInfo;", "component6", "()Lid/dana/cashier/domain/model/ConfigCashierInfo;", "component7", "Lid/dana/domain/investment/model/DanaPlusMethodConfig;", "component8", "()Lid/dana/domain/investment/model/DanaPlusMethodConfig;", "attributes", CashierKeyParams.CASHIER_ORDER_ID, "success", "errorMessage", "errorCode", "config", "paylaterCicilMid", "danaPlusMethodConfig", "copy", "(Lid/dana/cashier/domain/model/Attribute;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lid/dana/cashier/domain/model/ConfigCashierInfo;Ljava/lang/String;Lid/dana/domain/investment/model/DanaPlusMethodConfig;)Lid/dana/cashier/domain/model/CashierPay;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "isMixPaymentAssetExist", "()Z", "isNeedToShowDialog", "isNeedToShowMixPayTooltip", "isSomeCardNotSupportedForMixPay", "isSupportMixPay", "toString", "Lid/dana/cashier/domain/model/Attribute;", "getAttributes", "setAttributes", "(Lid/dana/cashier/domain/model/Attribute;)V", "Ljava/lang/String;", "getCashierOrderId", "Lid/dana/cashier/domain/model/ConfigCashierInfo;", "getConfig", "Lid/dana/domain/investment/model/DanaPlusMethodConfig;", "getDanaPlusMethodConfig", "setDanaPlusMethodConfig", "(Lid/dana/domain/investment/model/DanaPlusMethodConfig;)V", "getErrorCode", "getErrorMessage", "getPaylaterCicilMid", "setPaylaterCicilMid", "(Ljava/lang/String;)V", "Ljava/lang/Boolean;", "getSuccess", "<init>", "(Lid/dana/cashier/domain/model/Attribute;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lid/dana/cashier/domain/model/ConfigCashierInfo;Ljava/lang/String;Lid/dana/domain/investment/model/DanaPlusMethodConfig;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class CashierPay {
    private Attribute attributes;
    private final String cashierOrderId;
    private final ConfigCashierInfo config;
    private DanaPlusMethodConfig danaPlusMethodConfig;
    private final String errorCode;
    private final String errorMessage;
    private String paylaterCicilMid;
    private final Boolean success;

    /* renamed from: component1  reason: from getter */
    public final Attribute getAttributes() {
        return this.attributes;
    }

    /* renamed from: component2  reason: from getter */
    public final String getCashierOrderId() {
        return this.cashierOrderId;
    }

    /* renamed from: component3  reason: from getter */
    public final Boolean getSuccess() {
        return this.success;
    }

    /* renamed from: component4  reason: from getter */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    /* renamed from: component5  reason: from getter */
    public final String getErrorCode() {
        return this.errorCode;
    }

    /* renamed from: component6  reason: from getter */
    public final ConfigCashierInfo getConfig() {
        return this.config;
    }

    /* renamed from: component7  reason: from getter */
    public final String getPaylaterCicilMid() {
        return this.paylaterCicilMid;
    }

    /* renamed from: component8  reason: from getter */
    public final DanaPlusMethodConfig getDanaPlusMethodConfig() {
        return this.danaPlusMethodConfig;
    }

    public final CashierPay copy(Attribute attributes, String cashierOrderId, Boolean success, String errorMessage, String errorCode, ConfigCashierInfo config, String paylaterCicilMid, DanaPlusMethodConfig danaPlusMethodConfig) {
        Intrinsics.checkNotNullParameter(paylaterCicilMid, "");
        return new CashierPay(attributes, cashierOrderId, success, errorMessage, errorCode, config, paylaterCicilMid, danaPlusMethodConfig);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof CashierPay) {
            CashierPay cashierPay = (CashierPay) other;
            return Intrinsics.areEqual(this.attributes, cashierPay.attributes) && Intrinsics.areEqual(this.cashierOrderId, cashierPay.cashierOrderId) && Intrinsics.areEqual(this.success, cashierPay.success) && Intrinsics.areEqual(this.errorMessage, cashierPay.errorMessage) && Intrinsics.areEqual(this.errorCode, cashierPay.errorCode) && Intrinsics.areEqual(this.config, cashierPay.config) && Intrinsics.areEqual(this.paylaterCicilMid, cashierPay.paylaterCicilMid) && Intrinsics.areEqual(this.danaPlusMethodConfig, cashierPay.danaPlusMethodConfig);
        }
        return false;
    }

    public final int hashCode() {
        Attribute attribute = this.attributes;
        int hashCode = attribute == null ? 0 : attribute.hashCode();
        String str = this.cashierOrderId;
        int hashCode2 = str == null ? 0 : str.hashCode();
        Boolean bool = this.success;
        int hashCode3 = bool == null ? 0 : bool.hashCode();
        String str2 = this.errorMessage;
        int hashCode4 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.errorCode;
        int hashCode5 = str3 == null ? 0 : str3.hashCode();
        ConfigCashierInfo configCashierInfo = this.config;
        int hashCode6 = configCashierInfo == null ? 0 : configCashierInfo.hashCode();
        int hashCode7 = this.paylaterCicilMid.hashCode();
        DanaPlusMethodConfig danaPlusMethodConfig = this.danaPlusMethodConfig;
        return (((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + (danaPlusMethodConfig != null ? danaPlusMethodConfig.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CashierPay(attributes=");
        sb.append(this.attributes);
        sb.append(", cashierOrderId=");
        sb.append(this.cashierOrderId);
        sb.append(", success=");
        sb.append(this.success);
        sb.append(", errorMessage=");
        sb.append(this.errorMessage);
        sb.append(", errorCode=");
        sb.append(this.errorCode);
        sb.append(", config=");
        sb.append(this.config);
        sb.append(", paylaterCicilMid=");
        sb.append(this.paylaterCicilMid);
        sb.append(", danaPlusMethodConfig=");
        sb.append(this.danaPlusMethodConfig);
        sb.append(')');
        return sb.toString();
    }

    public CashierPay(Attribute attribute, String str, Boolean bool, String str2, String str3, ConfigCashierInfo configCashierInfo, String str4, DanaPlusMethodConfig danaPlusMethodConfig) {
        Intrinsics.checkNotNullParameter(str4, "");
        this.attributes = attribute;
        this.cashierOrderId = str;
        this.success = bool;
        this.errorMessage = str2;
        this.errorCode = str3;
        this.config = configCashierInfo;
        this.paylaterCicilMid = str4;
        this.danaPlusMethodConfig = danaPlusMethodConfig;
    }

    public /* synthetic */ CashierPay(Attribute attribute, String str, Boolean bool, String str2, String str3, ConfigCashierInfo configCashierInfo, String str4, DanaPlusMethodConfig danaPlusMethodConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(attribute, str, bool, str2, str3, configCashierInfo, (i & 64) != 0 ? "" : str4, (i & 128) != 0 ? null : danaPlusMethodConfig);
    }

    @JvmName(name = "getAttributes")
    public final Attribute getAttributes() {
        return this.attributes;
    }

    @JvmName(name = "setAttributes")
    public final void setAttributes(Attribute attribute) {
        this.attributes = attribute;
    }

    @JvmName(name = "getCashierOrderId")
    public final String getCashierOrderId() {
        return this.cashierOrderId;
    }

    @JvmName(name = "getSuccess")
    public final Boolean getSuccess() {
        return this.success;
    }

    @JvmName(name = "getErrorMessage")
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    @JvmName(name = "getErrorCode")
    public final String getErrorCode() {
        return this.errorCode;
    }

    @JvmName(name = "getConfig")
    public final ConfigCashierInfo getConfig() {
        return this.config;
    }

    @JvmName(name = "getPaylaterCicilMid")
    public final String getPaylaterCicilMid() {
        return this.paylaterCicilMid;
    }

    @JvmName(name = "setPaylaterCicilMid")
    public final void setPaylaterCicilMid(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.paylaterCicilMid = str;
    }

    @JvmName(name = "getDanaPlusMethodConfig")
    public final DanaPlusMethodConfig getDanaPlusMethodConfig() {
        return this.danaPlusMethodConfig;
    }

    @JvmName(name = "setDanaPlusMethodConfig")
    public final void setDanaPlusMethodConfig(DanaPlusMethodConfig danaPlusMethodConfig) {
        this.danaPlusMethodConfig = danaPlusMethodConfig;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0032 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean isMixPaymentAssetExist() {
        /*
            r4 = this;
            id.dana.cashier.domain.model.Attribute r0 = r4.attributes
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L33
            java.util.List r3 = r0.getPayChannels()
            java.util.Collection r3 = (java.util.Collection) r3
            if (r3 == 0) goto L16
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L16
            r3 = 0
            goto L17
        L16:
            r3 = 1
        L17:
            if (r3 != 0) goto L2e
            java.util.List r0 = r0.getAssetCards()
            java.util.Collection r0 = (java.util.Collection) r0
            if (r0 == 0) goto L29
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L29
            r0 = 0
            goto L2a
        L29:
            r0 = 1
        L2a:
            if (r0 != 0) goto L2e
            r0 = 1
            goto L2f
        L2e:
            r0 = 0
        L2f:
            if (r0 == r2) goto L32
            goto L33
        L32:
            r1 = 1
        L33:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.domain.model.CashierPay.isMixPaymentAssetExist():boolean");
    }

    public final boolean isSupportMixPay() {
        Attribute attribute = this.attributes;
        return attribute != null && Intrinsics.areEqual(attribute.isSupportMixPayment(), Boolean.TRUE);
    }

    public final boolean isNeedToShowMixPayTooltip() {
        Attribute attribute = this.attributes;
        if (attribute != null) {
            List<AssetCard> mixPayAutoroutedPayChannels = attribute.getMixPayAutoroutedPayChannels();
            return !(mixPayAutoroutedPayChannels == null || mixPayAutoroutedPayChannels.isEmpty());
        }
        return false;
    }

    public final boolean isNeedToShowDialog() {
        Object obj;
        Attribute attribute = this.attributes;
        if (attribute != null) {
            List<CashierPayChannelInfo> payChannels = attribute.getPayChannels();
            if (!(payChannels == null || payChannels.isEmpty())) {
                List<CashierPayChannelInfo> payChannels2 = attribute.getPayChannels();
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : payChannels2) {
                    CashierPayChannelInfo cashierPayChannelInfo = (CashierPayChannelInfo) obj2;
                    Boolean pivotCard = cashierPayChannelInfo.getPivotCard();
                    if ((pivotCard != null ? pivotCard.booleanValue() : false) || StringsKt.equals(Institution.BCA_ONEKLIK, cashierPayChannelInfo.getInstId(), true) || Intrinsics.areEqual(cashierPayChannelInfo.getPayMethod(), "ONLINE_CREDIT") || Intrinsics.areEqual(cashierPayChannelInfo.getPayMethod(), PayMethod.LOAN_CREDIT)) {
                        arrayList.add(obj2);
                    }
                }
                Iterator it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (Intrinsics.areEqual(((CashierPayChannelInfo) obj).getCanUse(), Boolean.TRUE)) {
                        break;
                    }
                }
                if (obj == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean isSomeCardNotSupportedForMixPay() {
        List<AssetCard> assetCards;
        Attribute attribute = this.attributes;
        if (attribute == null || (assetCards = attribute.getAssetCards()) == null) {
            return false;
        }
        List<AssetCard> list = assetCards;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(((AssetCard) it.next()).getCanUse(), Boolean.FALSE)) {
                return true;
            }
        }
        return false;
    }
}
