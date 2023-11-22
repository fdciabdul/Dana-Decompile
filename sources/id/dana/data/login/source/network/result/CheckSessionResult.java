package id.dana.data.login.source.network.result;

import com.alibaba.fastjson.annotation.JSONField;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0003\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/data/login/source/network/result/CheckSessionResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "activeSession", "Z", "getActiveSession", "()Z", "<init>", "(Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CheckSessionResult extends BaseRpcResult {
    @SerializedName("activeSession")
    private final boolean activeSession;

    @JvmName(name = "getActiveSession")
    public final boolean getActiveSession() {
        return this.activeSession;
    }

    public CheckSessionResult(@JSONField(name = "activeSession") boolean z) {
        this.activeSession = z;
    }
}
