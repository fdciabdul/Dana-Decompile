package id.dana.data.statement.repository.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/data/statement/repository/source/network/request/StatementDetailRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "timeEnd", "J", "getTimeEnd", "()J", "timeStart", "getTimeStart", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "<init>", "(JJLjava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StatementDetailRequest extends BaseRpcRequest {
    private final long timeEnd;
    private final long timeStart;
    private final String type;

    @JvmName(name = "getTimeStart")
    public final long getTimeStart() {
        return this.timeStart;
    }

    @JvmName(name = "getTimeEnd")
    public final long getTimeEnd() {
        return this.timeEnd;
    }

    @JvmName(name = "getType")
    public final String getType() {
        return this.type;
    }

    public StatementDetailRequest(long j, long j2, String str) {
        this.timeStart = j;
        this.timeEnd = j2;
        this.type = str;
    }
}
