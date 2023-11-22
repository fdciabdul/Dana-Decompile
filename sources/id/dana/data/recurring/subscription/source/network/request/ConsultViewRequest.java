package id.dana.data.recurring.subscription.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0012\u0018\u00002\u00020\u0001BY\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\t\u001a\u0004\b\u0017\u0010\u000b"}, d2 = {"Lid/dana/data/recurring/subscription/source/network/request/ConsultViewRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "countOnly", "Ljava/lang/Boolean;", "getCountOnly", "()Ljava/lang/Boolean;", "", "divisionId", "Ljava/lang/String;", "getDivisionId", "()Ljava/lang/String;", "goodsType", "getGoodsType", "ipRoleId", "getIpRoleId", "merchantId", "getMerchantId", "needScheduleInfo", "Z", "getNeedScheduleInfo", "()Z", "recurringType", "getRecurringType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ConsultViewRequest extends BaseRpcRequest {
    private final Boolean countOnly;
    private final String divisionId;
    private final String goodsType;
    private final String ipRoleId;
    private final String merchantId;
    private final boolean needScheduleInfo;
    private final String recurringType;

    public ConsultViewRequest() {
        this(null, null, null, null, null, null, false, 127, null);
    }

    public /* synthetic */ ConsultViewRequest(String str, String str2, String str3, String str4, String str5, Boolean bool, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) == 0 ? bool : null, (i & 64) != 0 ? false : z);
    }

    @JvmName(name = "getIpRoleId")
    public final String getIpRoleId() {
        return this.ipRoleId;
    }

    @JvmName(name = "getRecurringType")
    public final String getRecurringType() {
        return this.recurringType;
    }

    @JvmName(name = "getGoodsType")
    public final String getGoodsType() {
        return this.goodsType;
    }

    @JvmName(name = "getMerchantId")
    public final String getMerchantId() {
        return this.merchantId;
    }

    @JvmName(name = "getDivisionId")
    public final String getDivisionId() {
        return this.divisionId;
    }

    @JvmName(name = "getCountOnly")
    public final Boolean getCountOnly() {
        return this.countOnly;
    }

    @JvmName(name = "getNeedScheduleInfo")
    public final boolean getNeedScheduleInfo() {
        return this.needScheduleInfo;
    }

    public ConsultViewRequest(String str, String str2, String str3, String str4, String str5, Boolean bool, boolean z) {
        this.ipRoleId = str;
        this.recurringType = str2;
        this.goodsType = str3;
        this.merchantId = str4;
        this.divisionId = str5;
        this.countOnly = bool;
        this.needScheduleInfo = z;
    }
}
