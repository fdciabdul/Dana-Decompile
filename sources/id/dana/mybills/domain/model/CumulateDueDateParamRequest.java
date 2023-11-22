package id.dana.mybills.domain.model;

import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.zoloz.android.phone.zdoc.service.ZdocRecordService;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B%\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\u00020\u00078\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000b"}, d2 = {"Lid/dana/mybills/domain/model/CumulateDueDateParamRequest;", "", "", "cumulateDueDateType", "Ljava/lang/String;", "getCumulateDueDateType", "()Ljava/lang/String;", "", ZdocRecordService.PAGE_NUMBER, "I", "getPageNumber", "()I", "setPageNumber", "(I)V", SecurityConstants.KEY_PAGE_SIZE, "getPageSize", "<init>", "(Ljava/lang/String;II)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CumulateDueDateParamRequest {
    private static final String CUMULATE_DUE_DATE_TYPE_OVERDUE = "'OVERDUE'";
    private static final String CUMULATE_DUE_DATE_TYPE_UNPAID = "'UNPAID'";
    private static final int DEFAULT_PAGE_NUMBER = 1;
    private static final int DEFAULT_PAGE_SIZE = 10;
    private final String cumulateDueDateType;
    private int pageNumber;
    private final int pageSize;

    public CumulateDueDateParamRequest() {
        this(null, 0, 0, 7, null);
    }

    public CumulateDueDateParamRequest(String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "");
        this.cumulateDueDateType = str;
        this.pageNumber = i;
        this.pageSize = i2;
    }

    public /* synthetic */ CumulateDueDateParamRequest(String str, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "['OVERDUE','UNPAID']" : str, (i3 & 2) != 0 ? 1 : i, (i3 & 4) != 0 ? 10 : i2);
    }

    @JvmName(name = "getCumulateDueDateType")
    public final String getCumulateDueDateType() {
        return this.cumulateDueDateType;
    }

    @JvmName(name = "getPageNumber")
    public final int getPageNumber() {
        return this.pageNumber;
    }

    @JvmName(name = "setPageNumber")
    public final void setPageNumber(int i) {
        this.pageNumber = i;
    }

    @JvmName(name = "getPageSize")
    public final int getPageSize() {
        return this.pageSize;
    }
}
