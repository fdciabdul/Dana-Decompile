package id.dana.danapoly.data.config.model.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/danapoly/data/config/model/request/GetPlayerRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "eventId", "Ljava/lang/String;", "getEventId", "()Ljava/lang/String;", "", "types", "Ljava/util/List;", "getTypes", "()Ljava/util/List;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetPlayerRequest extends BaseRpcRequest {
    private final String eventId;
    private final List<String> types;

    @JvmName(name = "getEventId")
    public final String getEventId() {
        return this.eventId;
    }

    @JvmName(name = "getTypes")
    public final List<String> getTypes() {
        return this.types;
    }

    public GetPlayerRequest(String str, List<String> list) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(list, "");
        this.eventId = str;
        this.types = list;
    }
}
