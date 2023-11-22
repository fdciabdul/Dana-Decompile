package id.dana.data.login;

import id.dana.rum.Rum;
import id.dana.utils.foundation.logger.log.DanaLog;
import io.reactivex.Observable;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.subjects.BehaviorSubject;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0002\u0016\u0017B\t\b\u0007¢\u0006\u0004\b\u0015\u0010\u0004J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fR6\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\r8\u0007@GX\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014"}, d2 = {"Lid/dana/data/login/LoginLogoutSubject;", "", "", "loggingOut", "()V", "", "userId", "setUserId", "(Ljava/lang/String;)V", "Lio/reactivex/Observable;", "Lid/dana/data/login/LoginLogoutSubject$UserLogin;", "toObservable", "()Lio/reactivex/Observable;", "Lio/reactivex/subjects/BehaviorSubject;", "<set-?>", "subject", "Lio/reactivex/subjects/BehaviorSubject;", "getSubject", "()Lio/reactivex/subjects/BehaviorSubject;", "setSubject", "(Lio/reactivex/subjects/BehaviorSubject;)V", "<init>", "Companion", "UserLogin"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LoginLogoutSubject {
    public static final String TAG = "DanaLogin";
    private BehaviorSubject<UserLogin> subject;

    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Inject
    public LoginLogoutSubject() {
        ?? r1 = 0;
        BehaviorSubject<UserLogin> authRequestContext = BehaviorSubject.getAuthRequestContext(new UserLogin(r1, false, 3, r1));
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        this.subject = authRequestContext;
    }

    @JvmName(name = "getSubject")
    public final BehaviorSubject<UserLogin> getSubject() {
        return this.subject;
    }

    @JvmName(name = "setSubject")
    public final void setSubject(BehaviorSubject<UserLogin> behaviorSubject) {
        Intrinsics.checkNotNullParameter(behaviorSubject, "");
        this.subject = behaviorSubject;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    public final void loggingOut() {
        DanaLog.getAuthRequestContext("DanaLogin", "Logging-out");
        ?? r2 = 0;
        this.subject.onNext(new UserLogin(r2, false, 3, r2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v3, types: [kotlin.Unit] */
    /* JADX WARN: Type inference failed for: r2v4 */
    public final void setUserId(String userId) {
        StringBuilder sb = new StringBuilder();
        sb.append("Logging-in with userId ");
        sb.append(userId);
        DanaLog.getAuthRequestContext("DanaLogin", sb.toString());
        ?? r2 = 0;
        r2 = 0;
        UserLogin userLogin = new UserLogin(r2, false, 3, r2);
        String str = userId;
        if (str == null || str.length() == 0) {
            this.subject.onNext(userLogin);
            return;
        }
        Rum.Companion companion = Rum.getAuthRequestContext;
        Rum.Companion.KClassImpl$Data$declaredNonStaticMembers$2(TuplesKt.to("dana.userId", userId));
        if (!this.subject.KClassImpl$Data$declaredNonStaticMembers$2()) {
            this.subject.onNext(userLogin);
        }
        UserLogin userLogin2 = new UserLogin(userId, true);
        Object obj = this.subject.getErrorConfigVersion.get();
        UserLogin userLogin3 = (UserLogin) ((NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) ? null : NotificationLite.getValue(obj));
        if (userLogin3 != null) {
            if (!(userLogin3.getUserId().length() > 0)) {
                userLogin3 = null;
            }
            if (userLogin3 != null) {
                if (userLogin3.isLoggedIn() != userLogin2.isLoggedIn() || !Intrinsics.areEqual(userLogin3.getUserId(), userLogin2.getUserId())) {
                    this.subject.onNext(userLogin2);
                }
                r2 = Unit.INSTANCE;
            }
        }
        if (r2 == 0) {
            this.subject.onNext(userLogin2);
        }
    }

    public final Observable<UserLogin> toObservable() {
        return this.subject;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\r\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0004R\u0017\u0010\t\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\t\u0010\u0013\u001a\u0004\b\t\u0010\u0007R\u001a\u0010\b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004"}, d2 = {"Lid/dana/data/login/LoginLogoutSubject$UserLogin;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Z", "userId", "isLoggedIn", "copy", "(Ljava/lang/String;Z)Lid/dana/data/login/LoginLogoutSubject$UserLogin;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Z", "Ljava/lang/String;", "getUserId", "<init>", "(Ljava/lang/String;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class UserLogin {
        private final boolean isLoggedIn;
        private final String userId;

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public UserLogin() {
            /*
                r3 = this;
                r0 = 0
                r1 = 0
                r2 = 3
                r3.<init>(r0, r1, r2, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.data.login.LoginLogoutSubject.UserLogin.<init>():void");
        }

        public static /* synthetic */ UserLogin copy$default(UserLogin userLogin, String str, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = userLogin.userId;
            }
            if ((i & 2) != 0) {
                z = userLogin.isLoggedIn;
            }
            return userLogin.copy(str, z);
        }

        /* renamed from: component1  reason: from getter */
        public final String getUserId() {
            return this.userId;
        }

        /* renamed from: component2  reason: from getter */
        public final boolean getIsLoggedIn() {
            return this.isLoggedIn;
        }

        public final UserLogin copy(String userId, boolean isLoggedIn) {
            Intrinsics.checkNotNullParameter(userId, "");
            return new UserLogin(userId, isLoggedIn);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof UserLogin) {
                UserLogin userLogin = (UserLogin) other;
                return Intrinsics.areEqual(this.userId, userLogin.userId) && this.isLoggedIn == userLogin.isLoggedIn;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final int hashCode() {
            int hashCode = this.userId.hashCode();
            boolean z = this.isLoggedIn;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            return (hashCode * 31) + i;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("UserLogin(userId=");
            sb.append(this.userId);
            sb.append(", isLoggedIn=");
            sb.append(this.isLoggedIn);
            sb.append(')');
            return sb.toString();
        }

        public UserLogin(String str, boolean z) {
            Intrinsics.checkNotNullParameter(str, "");
            this.userId = str;
            this.isLoggedIn = z;
        }

        public /* synthetic */ UserLogin(String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? false : z);
        }

        @JvmName(name = "getUserId")
        public final String getUserId() {
            return this.userId;
        }

        @JvmName(name = "isLoggedIn")
        public final boolean isLoggedIn() {
            return this.isLoggedIn;
        }
    }
}
