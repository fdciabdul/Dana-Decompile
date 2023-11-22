package id.dana.data.login.source.network.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B%\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0001\u0010\t\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0003\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006"}, d2 = {"Lid/dana/data/login/source/network/request/VerifyPasswordRpcRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "loginTokenId", "Ljava/lang/String;", "getLoginTokenId", "()Ljava/lang/String;", "password", "getPassword", "scene", "getScene", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class VerifyPasswordRpcRequest extends BaseRpcRequest {
    @SerializedName("loginTokenId")
    private final String loginTokenId;
    @SerializedName("password")
    private final String password;
    @SerializedName("scene")
    private final String scene;

    @JvmName(name = "getPassword")
    public final String getPassword() {
        return this.password;
    }

    @JvmName(name = "getScene")
    public final String getScene() {
        return this.scene;
    }

    @JvmName(name = "getLoginTokenId")
    public final String getLoginTokenId() {
        return this.loginTokenId;
    }

    public VerifyPasswordRpcRequest(@JSONField(name = "password") String str, @JSONField(name = "scene") String str2, @JSONField(name = "loginTokenId") String str3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        this.password = str;
        this.scene = str2;
        this.loginTokenId = str3;
    }
}
