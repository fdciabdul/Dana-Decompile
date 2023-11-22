package id.dana.domain.useremailaddress.model;

import com.appsflyer.AppsFlyerProperties;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004R\u0017\u0010\u0006\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0014\u0010\u0004"}, d2 = {"Lid/dana/domain/useremailaddress/model/UserEmailAddress;", "", "", "component1", "()Ljava/lang/String;", "component2", AppsFlyerProperties.USER_EMAIL, "verifyStatus", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/useremailaddress/model/UserEmailAddress;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getUserEmail", "getVerifyStatus", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class UserEmailAddress {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String UNVERIFIED_EMAIL = "0";
    private final String userEmail;
    private final String verifyStatus;

    public static /* synthetic */ UserEmailAddress copy$default(UserEmailAddress userEmailAddress, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = userEmailAddress.userEmail;
        }
        if ((i & 2) != 0) {
            str2 = userEmailAddress.verifyStatus;
        }
        return userEmailAddress.copy(str, str2);
    }

    /* renamed from: component1  reason: from getter */
    public final String getUserEmail() {
        return this.userEmail;
    }

    /* renamed from: component2  reason: from getter */
    public final String getVerifyStatus() {
        return this.verifyStatus;
    }

    public final UserEmailAddress copy(String userEmail, String verifyStatus) {
        Intrinsics.checkNotNullParameter(userEmail, "");
        Intrinsics.checkNotNullParameter(verifyStatus, "");
        return new UserEmailAddress(userEmail, verifyStatus);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof UserEmailAddress) {
            UserEmailAddress userEmailAddress = (UserEmailAddress) other;
            return Intrinsics.areEqual(this.userEmail, userEmailAddress.userEmail) && Intrinsics.areEqual(this.verifyStatus, userEmailAddress.verifyStatus);
        }
        return false;
    }

    public final int hashCode() {
        return (this.userEmail.hashCode() * 31) + this.verifyStatus.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UserEmailAddress(userEmail=");
        sb.append(this.userEmail);
        sb.append(", verifyStatus=");
        sb.append(this.verifyStatus);
        sb.append(')');
        return sb.toString();
    }

    public UserEmailAddress(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.userEmail = str;
        this.verifyStatus = str2;
    }

    @JvmName(name = "getUserEmail")
    public final String getUserEmail() {
        return this.userEmail;
    }

    @JvmName(name = "getVerifyStatus")
    public final String getVerifyStatus() {
        return this.verifyStatus;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0003\u001a\u00020\u00028\u0007X\u0086D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/domain/useremailaddress/model/UserEmailAddress$Companion;", "", "", "UNVERIFIED_EMAIL", "Ljava/lang/String;", "getUNVERIFIED_EMAIL", "()Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmName(name = "getUNVERIFIED_EMAIL")
        public final String getUNVERIFIED_EMAIL() {
            return UserEmailAddress.UNVERIFIED_EMAIL;
        }
    }
}
