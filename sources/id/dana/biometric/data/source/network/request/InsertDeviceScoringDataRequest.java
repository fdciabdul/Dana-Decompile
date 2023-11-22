package id.dana.biometric.data.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import id.dana.domain.foundation.logger.PerformanceConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0011B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0003\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/biometric/data/source/network/request/InsertDeviceScoringDataRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "scheme", "Ljava/lang/String;", "getScheme", "()Ljava/lang/String;", "type", "getType", "", "Lid/dana/biometric/data/source/network/request/InsertDeviceScoringDataRequest$ScoringDataInfo;", "value", "Ljava/util/List;", "getValue", "()Ljava/util/List;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "ScoringDataInfo"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class InsertDeviceScoringDataRequest extends BaseRpcRequest {
    private final String scheme;
    private final String type;
    private final List<ScoringDataInfo> value;

    @JvmName(name = "getScheme")
    public final String getScheme() {
        return this.scheme;
    }

    @JvmName(name = "getType")
    public final String getType() {
        return this.type;
    }

    @JvmName(name = "getValue")
    public final List<ScoringDataInfo> getValue() {
        return this.value;
    }

    public InsertDeviceScoringDataRequest(String str, String str2, List<ScoringDataInfo> list) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(list, "");
        this.scheme = str;
        this.type = str2;
        this.value = list;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/biometric/data/source/network/request/InsertDeviceScoringDataRequest$ScoringDataInfo;", "", "", "data", "Ljava/lang/String;", "getData", "()Ljava/lang/String;", PerformanceConstant.PERFORMANCE_PHASE, "getPhase", "", "timestamp", "J", "getTimestamp", "()J", "<init>", "(JLjava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class ScoringDataInfo {
        private final String data;
        private final String phase;
        private final long timestamp;

        public ScoringDataInfo(long j, String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            this.timestamp = j;
            this.data = str;
            this.phase = str2;
        }

        @JvmName(name = "getTimestamp")
        public final long getTimestamp() {
            return this.timestamp;
        }

        @JvmName(name = "getData")
        public final String getData() {
            return this.data;
        }

        @JvmName(name = "getPhase")
        public final String getPhase() {
            return this.phase;
        }
    }
}
