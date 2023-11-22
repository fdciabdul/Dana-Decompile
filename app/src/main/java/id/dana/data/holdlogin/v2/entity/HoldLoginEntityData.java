package id.dana.data.holdlogin.v2.entity;

import id.dana.network.response.login.LoginRpcResult;
import io.reactivex.Observable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J-\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H&¢\u0006\u0004\b\u000b\u0010\fJ-\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H&¢\u0006\u0004\b\r\u0010\fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/holdlogin/v2/entity/HoldLoginEntityData;", "", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "", "p0", "p1", "p2", "Lio/reactivex/Observable;", "Lid/dana/network/response/login/LoginRpcResult;", "getAuthRequestContext", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "BuiltInFictitiousFunctionClassFactory"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface HoldLoginEntityData {
    Observable<LoginRpcResult> BuiltInFictitiousFunctionClassFactory(String p0, String p1, String p2);

    void KClassImpl$Data$declaredNonStaticMembers$2();

    Observable<LoginRpcResult> getAuthRequestContext(String p0, String p1, String p2);
}
