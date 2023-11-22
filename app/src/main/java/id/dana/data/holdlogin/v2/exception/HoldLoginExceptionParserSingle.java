package id.dana.data.holdlogin.v2.exception;

import id.dana.data.foundation.DanaErrorCode;
import id.dana.data.foundation.RpcException;
import id.dana.data.login.source.network.HoldLoginException;
import id.dana.network.base.ExceptionParserSingle;
import id.dana.network.response.login.LoginRpcResult;
import io.reactivex.Single;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/data/holdlogin/v2/exception/HoldLoginExceptionParserSingle;", "Lid/dana/network/base/ExceptionParserSingle;", "Lid/dana/network/response/login/LoginRpcResult;", "p0", "Lio/reactivex/Single;", "PlaceComponentResult", "(Lid/dana/network/response/login/LoginRpcResult;)Lio/reactivex/Single;", "", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)Z", "", "BuiltInFictitiousFunctionClassFactory", "Ljava/util/List;", "MyBillsEntityDataFactory", "<init>", "(Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HoldLoginExceptionParserSingle extends ExceptionParserSingle<LoginRpcResult> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final List<String> MyBillsEntityDataFactory;

    public HoldLoginExceptionParserSingle(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.MyBillsEntityDataFactory = list;
    }

    @Override // id.dana.network.base.ExceptionParserSingle, io.reactivex.functions.Function
    /* renamed from: PlaceComponentResult  reason: merged with bridge method [inline-methods] */
    public final Single<LoginRpcResult> apply(LoginRpcResult p0) throws Exception {
        HoldLoginException holdLoginException;
        Intrinsics.checkNotNullParameter(p0, "");
        if (p0.success) {
            Single<LoginRpcResult> apply = super.apply((HoldLoginExceptionParserSingle) p0);
            Intrinsics.checkNotNullExpressionValue(apply, "");
            return apply;
        }
        if (DanaErrorCode.isHoldLoginError(p0) || KClassImpl$Data$declaredNonStaticMembers$2(p0.errorCode)) {
            holdLoginException = new HoldLoginException(p0);
        } else {
            String str = p0.errorCode;
            String str2 = p0.errorMessage;
            String str3 = str2;
            if ((!(str3 == null || str3.length() == 0)) == false) {
                str2 = null;
            }
            if (str2 == null) {
                str2 = p0.getErrorMsg();
            }
            holdLoginException = new RpcException(str, str2);
        }
        Single<LoginRpcResult> authRequestContext = Single.getAuthRequestContext(holdLoginException);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    private final boolean KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        boolean z;
        String str = p0;
        if (!(str == null || str.length() == 0) && (!this.MyBillsEntityDataFactory.isEmpty()) != false) {
            List<String> list = this.MyBillsEntityDataFactory;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    if (Intrinsics.areEqual((String) it.next(), p0)) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            if (z) {
                return true;
            }
        }
        return false;
    }
}
