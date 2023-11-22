package id.dana.data.login.source;

import id.dana.network.response.login.LoginRpcResult;
import io.reactivex.Observable;

@Deprecated
/* loaded from: classes2.dex */
public interface HoldLoginEntityData {
    Observable<LoginRpcResult> holdLogin(String str, String str2, String str3);
}
