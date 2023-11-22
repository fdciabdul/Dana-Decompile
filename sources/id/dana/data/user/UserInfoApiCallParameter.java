package id.dana.data.user;

import id.dana.data.user.source.network.result.UserInfoRpcResult;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\u0012\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t\u0012\u0012\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t¢\u0006\u0004\b%\u0010&J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u001c\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u001c\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tHÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJZ\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00062\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0017\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0004R#\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t8\u0007¢\u0006\f\n\u0004\b\u0012\u0010\u001d\u001a\u0004\b\u001e\u0010\rR\u001a\u0010\u0011\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b \u0010\bR&\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001d\u001a\u0004\b!\u0010\rR\u001a\u0010\u0010\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\"\u001a\u0004\b#\u0010\u0004R\u001a\u0010\u000f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\"\u001a\u0004\b$\u0010\u0004"}, d2 = {"Lid/dana/data/user/UserInfoApiCallParameter;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Z", "Lkotlin/Function0;", "Lio/reactivex/Observable;", "Lid/dana/data/user/source/network/result/UserInfoRpcResult;", "component4", "()Lkotlin/jvm/functions/Function0;", "component5", "queryType", "preferenceKey", "needBackendUpdate", "localUserInfoApiCall", "networkUserInfoApiCall", "copy", "(Ljava/lang/String;Ljava/lang/String;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Lid/dana/data/user/UserInfoApiCallParameter;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Lkotlin/jvm/functions/Function0;", "getLocalUserInfoApiCall", "Z", "getNeedBackendUpdate", "getNetworkUserInfoApiCall", "Ljava/lang/String;", "getPreferenceKey", "getQueryType", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class UserInfoApiCallParameter {
    private final Function0<Observable<UserInfoRpcResult>> localUserInfoApiCall;
    private final boolean needBackendUpdate;
    private final Function0<Observable<UserInfoRpcResult>> networkUserInfoApiCall;
    private final String preferenceKey;
    private final String queryType;

    public static /* synthetic */ UserInfoApiCallParameter copy$default(UserInfoApiCallParameter userInfoApiCallParameter, String str, String str2, boolean z, Function0 function0, Function0 function02, int i, Object obj) {
        if ((i & 1) != 0) {
            str = userInfoApiCallParameter.queryType;
        }
        if ((i & 2) != 0) {
            str2 = userInfoApiCallParameter.preferenceKey;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            z = userInfoApiCallParameter.needBackendUpdate;
        }
        boolean z2 = z;
        Function0<Observable<UserInfoRpcResult>> function03 = function0;
        if ((i & 8) != 0) {
            function03 = userInfoApiCallParameter.localUserInfoApiCall;
        }
        Function0 function04 = function03;
        Function0<Observable<UserInfoRpcResult>> function05 = function02;
        if ((i & 16) != 0) {
            function05 = userInfoApiCallParameter.networkUserInfoApiCall;
        }
        return userInfoApiCallParameter.copy(str, str3, z2, function04, function05);
    }

    /* renamed from: component1  reason: from getter */
    public final String getQueryType() {
        return this.queryType;
    }

    /* renamed from: component2  reason: from getter */
    public final String getPreferenceKey() {
        return this.preferenceKey;
    }

    /* renamed from: component3  reason: from getter */
    public final boolean getNeedBackendUpdate() {
        return this.needBackendUpdate;
    }

    public final Function0<Observable<UserInfoRpcResult>> component4() {
        return this.localUserInfoApiCall;
    }

    public final Function0<Observable<UserInfoRpcResult>> component5() {
        return this.networkUserInfoApiCall;
    }

    public final UserInfoApiCallParameter copy(String queryType, String preferenceKey, boolean needBackendUpdate, Function0<? extends Observable<UserInfoRpcResult>> localUserInfoApiCall, Function0<? extends Observable<UserInfoRpcResult>> networkUserInfoApiCall) {
        Intrinsics.checkNotNullParameter(queryType, "");
        Intrinsics.checkNotNullParameter(preferenceKey, "");
        Intrinsics.checkNotNullParameter(localUserInfoApiCall, "");
        Intrinsics.checkNotNullParameter(networkUserInfoApiCall, "");
        return new UserInfoApiCallParameter(queryType, preferenceKey, needBackendUpdate, localUserInfoApiCall, networkUserInfoApiCall);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof UserInfoApiCallParameter) {
            UserInfoApiCallParameter userInfoApiCallParameter = (UserInfoApiCallParameter) other;
            return Intrinsics.areEqual(this.queryType, userInfoApiCallParameter.queryType) && Intrinsics.areEqual(this.preferenceKey, userInfoApiCallParameter.preferenceKey) && this.needBackendUpdate == userInfoApiCallParameter.needBackendUpdate && Intrinsics.areEqual(this.localUserInfoApiCall, userInfoApiCallParameter.localUserInfoApiCall) && Intrinsics.areEqual(this.networkUserInfoApiCall, userInfoApiCallParameter.networkUserInfoApiCall);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.queryType.hashCode();
        int hashCode2 = this.preferenceKey.hashCode();
        boolean z = this.needBackendUpdate;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return (((((((hashCode * 31) + hashCode2) * 31) + i) * 31) + this.localUserInfoApiCall.hashCode()) * 31) + this.networkUserInfoApiCall.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UserInfoApiCallParameter(queryType=");
        sb.append(this.queryType);
        sb.append(", preferenceKey=");
        sb.append(this.preferenceKey);
        sb.append(", needBackendUpdate=");
        sb.append(this.needBackendUpdate);
        sb.append(", localUserInfoApiCall=");
        sb.append(this.localUserInfoApiCall);
        sb.append(", networkUserInfoApiCall=");
        sb.append(this.networkUserInfoApiCall);
        sb.append(')');
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UserInfoApiCallParameter(String str, String str2, boolean z, Function0<? extends Observable<UserInfoRpcResult>> function0, Function0<? extends Observable<UserInfoRpcResult>> function02) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(function0, "");
        Intrinsics.checkNotNullParameter(function02, "");
        this.queryType = str;
        this.preferenceKey = str2;
        this.needBackendUpdate = z;
        this.localUserInfoApiCall = function0;
        this.networkUserInfoApiCall = function02;
    }

    @JvmName(name = "getQueryType")
    public final String getQueryType() {
        return this.queryType;
    }

    @JvmName(name = "getPreferenceKey")
    public final String getPreferenceKey() {
        return this.preferenceKey;
    }

    @JvmName(name = "getNeedBackendUpdate")
    public final boolean getNeedBackendUpdate() {
        return this.needBackendUpdate;
    }

    @JvmName(name = "getLocalUserInfoApiCall")
    public final Function0<Observable<UserInfoRpcResult>> getLocalUserInfoApiCall() {
        return this.localUserInfoApiCall;
    }

    @JvmName(name = "getNetworkUserInfoApiCall")
    public final Function0<Observable<UserInfoRpcResult>> getNetworkUserInfoApiCall() {
        return this.networkUserInfoApiCall;
    }
}
