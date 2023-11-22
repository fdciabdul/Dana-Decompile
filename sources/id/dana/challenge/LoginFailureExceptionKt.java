package id.dana.challenge;

import id.dana.analytics.firebase.Crashlytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/challenge/LoginFailureException;", "", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/challenge/LoginFailureException;)V"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LoginFailureExceptionKt {
    public static final void BuiltInFictitiousFunctionClassFactory(LoginFailureException loginFailureException) {
        Intrinsics.checkNotNullParameter(loginFailureException, "");
        try {
            Crashlytics.Companion companion = Crashlytics.INSTANCE;
            Crashlytics authRequestContext = Crashlytics.Companion.getAuthRequestContext();
            Intrinsics.checkNotNullParameter("case", "");
            Intrinsics.checkNotNullParameter("LoginFailure", "");
            authRequestContext.getAuthRequestContext.setCustomKey("case", "LoginFailure");
            LoginFailureException loginFailureException2 = loginFailureException;
            Intrinsics.checkNotNullParameter(loginFailureException2, "");
            authRequestContext.getAuthRequestContext.recordException(loginFailureException2);
        } catch (Exception unused) {
        }
    }
}
