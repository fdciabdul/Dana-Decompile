package id.dana.data.holdlogin;

import android.content.Context;
import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.alipay.iap.android.common.product.delegate.IAPLoginUserInfo;
import com.alipay.iap.android.common.product.delegate.UserInfoManager;
import id.dana.analytics.firebase.Crashlytics;
import id.dana.data.login.VerifyChallengeManager;
import id.dana.data.login.source.network.HoldLoginException;
import id.dana.network.response.login.LoginRpcResult;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\r\u0010\u0006J\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\r\u0010\u0010J\u001f\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/data/holdlogin/HoldLoginUtils;", "", "", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/Throwable;)V", "Lid/dana/network/response/login/LoginRpcResult;", "", "PlaceComponentResult", "(Lid/dana/network/response/login/LoginRpcResult;)Ljava/lang/String;", "", "p1", "getAuthRequestContext", "(Lid/dana/network/response/login/LoginRpcResult;)V", "Landroid/content/Context;", "(Landroid/content/Context;)V", "BuiltInFictitiousFunctionClassFactory", "(Landroid/content/Context;Ljava/lang/String;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HoldLoginUtils {
    public static final HoldLoginUtils INSTANCE = new HoldLoginUtils();

    private HoldLoginUtils() {
    }

    @JvmStatic
    public static final void BuiltInFictitiousFunctionClassFactory(Context p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intent intent = new Intent();
        intent.setAction(p1);
        LocalBroadcastManager.getInstance(p0).sendBroadcast(intent);
    }

    @JvmStatic
    public static final void getAuthRequestContext(Context p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intent intent = new Intent();
        intent.setAction("id.dana.splash");
        LocalBroadcastManager.getInstance(p0).sendBroadcast(intent);
    }

    @JvmStatic
    public static final void KClassImpl$Data$declaredNonStaticMembers$2(Throwable p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        if (p0 instanceof HoldLoginException) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.Prefix.HOLDLOGIN_PREFIX, DanaLogConstants.ExceptionType.HOLDLOGIN_EXCEPTION, p0.getMessage());
        } else {
            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.Prefix.HOLDLOGIN_PREFIX, DanaLogConstants.ExceptionType.HOLDLOGIN_EXCEPTION, p0.toString());
        }
    }

    @JvmStatic
    public static final void getAuthRequestContext(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        try {
            Crashlytics.Companion companion = Crashlytics.INSTANCE;
            Crashlytics authRequestContext = Crashlytics.Companion.getAuthRequestContext();
            StringBuilder sb = new StringBuilder();
            sb.append("holdLogin ");
            sb.append(2);
            sb.append(" failed");
            String obj = sb.toString();
            Intrinsics.checkNotNullParameter(obj, "");
            authRequestContext.getAuthRequestContext.log(obj);
            Throwable cause = th.getCause();
            if (cause instanceof HoldLoginException) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("rootCause: [");
                sb2.append(((HoldLoginException) cause).getErrorCode());
                sb2.append("] ");
                sb2.append(((HoldLoginException) cause).getMessage());
                String obj2 = sb2.toString();
                Intrinsics.checkNotNullParameter(obj2, "");
                authRequestContext.getAuthRequestContext.log(obj2);
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("rootCause: ");
                sb3.append(th);
                sb3.append(" -> ");
                sb3.append(th.getMessage());
                String obj3 = sb3.toString();
                Intrinsics.checkNotNullParameter(obj3, "");
                authRequestContext.getAuthRequestContext.log(obj3);
                if (cause != null) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("cause: ");
                    sb4.append(cause);
                    sb4.append(" -> ");
                    sb4.append(cause.getMessage());
                    String obj4 = sb4.toString();
                    Intrinsics.checkNotNullParameter(obj4, "");
                    authRequestContext.getAuthRequestContext.log(obj4);
                }
            }
            Intrinsics.checkNotNullParameter(th, "");
            authRequestContext.getAuthRequestContext.recordException(th);
        } catch (Exception unused) {
        }
    }

    @JvmStatic
    public static final void getAuthRequestContext(LoginRpcResult p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        if (!p0.success || VerifyChallengeManager.isNeedChallenge(p0.verificationMethods)) {
            return;
        }
        IAPLoginUserInfo iAPLoginUserInfo = new IAPLoginUserInfo();
        iAPLoginUserInfo.userID = p0.userId;
        iAPLoginUserInfo.sessionID = p0.sessionId;
        UserInfoManager.instance().loginNotify(iAPLoginUserInfo);
    }

    @JvmStatic
    public static final String PlaceComponentResult(LoginRpcResult p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        if (!p0.success || VerifyChallengeManager.isNeedChallenge(p0.verificationMethods)) {
            return null;
        }
        return p0.userId;
    }
}
