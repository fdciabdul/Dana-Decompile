package id.dana.domain.familyaccount.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/domain/familyaccount/model/OrganizerSummaryResult;", "", "", "memo", "Ljava/lang/String;", "getMemo", "()Ljava/lang/String;", "Lid/dana/domain/familyaccount/model/SummaryResult;", "result", "Lid/dana/domain/familyaccount/model/SummaryResult;", "getResult", "()Lid/dana/domain/familyaccount/model/SummaryResult;", "", "resultStatus", "I", "getResultStatus", "()I", "<init>", "(Lid/dana/domain/familyaccount/model/SummaryResult;ILjava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class OrganizerSummaryResult {
    private final String memo;
    private final SummaryResult result;
    private final int resultStatus;

    public OrganizerSummaryResult(SummaryResult summaryResult, int i, String str) {
        Intrinsics.checkNotNullParameter(summaryResult, "");
        Intrinsics.checkNotNullParameter(str, "");
        this.result = summaryResult;
        this.resultStatus = i;
        this.memo = str;
    }

    @JvmName(name = "getResult")
    public final SummaryResult getResult() {
        return this.result;
    }

    @JvmName(name = "getResultStatus")
    public final int getResultStatus() {
        return this.resultStatus;
    }

    @JvmName(name = "getMemo")
    public final String getMemo() {
        return this.memo;
    }
}
