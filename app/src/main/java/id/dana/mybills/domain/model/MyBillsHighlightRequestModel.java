package id.dana.mybills.domain.model;

import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001Bk\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0016\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\u001f\u0010 R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0010\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0013\u0010\u000bR\u001a\u0010\u0014\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u001a\u0010\u0017\u001a\u00020\u00168\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u00168\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001c\u0010\u001aR\u001a\u0010\u001d\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\t\u001a\u0004\b\u001e\u0010\u000b"}, d2 = {"Lid/dana/mybills/domain/model/MyBillsHighlightRequestModel;", "", "", "countOnly", "Z", "getCountOnly", "()Z", "", "divisionId", "Ljava/lang/String;", "getDivisionId", "()Ljava/lang/String;", "dueType", "getDueType", "goodsType", "getGoodsType", "ipRoleId", "getIpRoleId", "merchantId", "getMerchantId", "needScheduleInfo", "getNeedScheduleInfo", "", "pageNum", "I", "getPageNum", "()I", SecurityConstants.KEY_PAGE_SIZE, "getPageSize", "recurringType", "getRecurringType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZIILjava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MyBillsHighlightRequestModel {
    private final boolean countOnly;
    private final String divisionId;
    private final String dueType;
    private final String goodsType;
    private final String ipRoleId;
    private final String merchantId;
    private final boolean needScheduleInfo;
    private final int pageNum;
    private final int pageSize;
    private final String recurringType;

    public MyBillsHighlightRequestModel() {
        this(null, null, null, null, false, null, false, 0, 0, null, 1023, null);
    }

    public MyBillsHighlightRequestModel(String str, String str2, String str3, String str4, boolean z, String str5, boolean z2, int i, int i2, String str6) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        this.divisionId = str;
        this.goodsType = str2;
        this.ipRoleId = str3;
        this.merchantId = str4;
        this.needScheduleInfo = z;
        this.recurringType = str5;
        this.countOnly = z2;
        this.pageNum = i;
        this.pageSize = i2;
        this.dueType = str6;
    }

    public /* synthetic */ MyBillsHighlightRequestModel(String str, String str2, String str3, String str4, boolean z, String str5, boolean z2, int i, int i2, String str6, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? "" : str4, (i3 & 16) != 0 ? false : z, (i3 & 32) != 0 ? "" : str5, (i3 & 64) == 0 ? z2 : false, (i3 & 128) != 0 ? 1 : i, (i3 & 256) == 0 ? i2 : 1, (i3 & 512) == 0 ? str6 : "");
    }

    @JvmName(name = "getDivisionId")
    public final String getDivisionId() {
        return this.divisionId;
    }

    @JvmName(name = "getGoodsType")
    public final String getGoodsType() {
        return this.goodsType;
    }

    @JvmName(name = "getIpRoleId")
    public final String getIpRoleId() {
        return this.ipRoleId;
    }

    @JvmName(name = "getMerchantId")
    public final String getMerchantId() {
        return this.merchantId;
    }

    @JvmName(name = "getNeedScheduleInfo")
    public final boolean getNeedScheduleInfo() {
        return this.needScheduleInfo;
    }

    @JvmName(name = "getRecurringType")
    public final String getRecurringType() {
        return this.recurringType;
    }

    @JvmName(name = "getCountOnly")
    public final boolean getCountOnly() {
        return this.countOnly;
    }

    @JvmName(name = "getPageNum")
    public final int getPageNum() {
        return this.pageNum;
    }

    @JvmName(name = "getPageSize")
    public final int getPageSize() {
        return this.pageSize;
    }

    @JvmName(name = "getDueType")
    public final String getDueType() {
        return this.dueType;
    }
}
