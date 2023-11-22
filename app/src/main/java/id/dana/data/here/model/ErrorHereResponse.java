package id.dana.data.here.model;

import id.dana.oauth.OauthConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004JL\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0004R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0018\u001a\u0004\b\u001a\u0010\u0004R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u001b\u0010\u0004R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u001c\u0010\u0004R\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u001d\u0010\u0004"}, d2 = {"Lid/dana/data/here/model/ErrorHereResponse;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "errorCode", "message", "status", "title", OauthConstant.PathParams.ERROR_DESCRIPTION, "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/data/here/model/ErrorHereResponse;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getErrorCode", "getErrorDescription", "getMessage", "getStatus", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ErrorHereResponse {
    public String errorCode;
    public String errorDescription;
    public String message;
    public String status;
    public String title;

    public /* synthetic */ ErrorHereResponse() {
    }

    public static /* synthetic */ ErrorHereResponse copy$default(ErrorHereResponse errorHereResponse, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = errorHereResponse.errorCode;
        }
        if ((i & 2) != 0) {
            str2 = errorHereResponse.message;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = errorHereResponse.status;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = errorHereResponse.title;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = errorHereResponse.errorDescription;
        }
        return errorHereResponse.copy(str, str6, str7, str8, str5);
    }

    /* renamed from: component1  reason: from getter */
    public final String getErrorCode() {
        return this.errorCode;
    }

    /* renamed from: component2  reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* renamed from: component3  reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component4  reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component5  reason: from getter */
    public final String getErrorDescription() {
        return this.errorDescription;
    }

    public final ErrorHereResponse copy(String errorCode, String message, String status, String title, String errorDescription) {
        return new ErrorHereResponse(errorCode, message, status, title, errorDescription);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ErrorHereResponse) {
            ErrorHereResponse errorHereResponse = (ErrorHereResponse) other;
            return Intrinsics.areEqual(this.errorCode, errorHereResponse.errorCode) && Intrinsics.areEqual(this.message, errorHereResponse.message) && Intrinsics.areEqual(this.status, errorHereResponse.status) && Intrinsics.areEqual(this.title, errorHereResponse.title) && Intrinsics.areEqual(this.errorDescription, errorHereResponse.errorDescription);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.errorCode;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.message;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.status;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.title;
        int hashCode4 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.errorDescription;
        return (((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + (str5 != null ? str5.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ErrorHereResponse(errorCode=");
        sb.append(this.errorCode);
        sb.append(", message=");
        sb.append(this.message);
        sb.append(", status=");
        sb.append(this.status);
        sb.append(", title=");
        sb.append(this.title);
        sb.append(", errorDescription=");
        sb.append(this.errorDescription);
        sb.append(')');
        return sb.toString();
    }

    public ErrorHereResponse(String str, String str2, String str3, String str4, String str5) {
        this.errorCode = str;
        this.message = str2;
        this.status = str3;
        this.title = str4;
        this.errorDescription = str5;
    }

    @JvmName(name = "getErrorCode")
    public final String getErrorCode() {
        return this.errorCode;
    }

    @JvmName(name = "getMessage")
    public final String getMessage() {
        return this.message;
    }

    @JvmName(name = "getStatus")
    public final String getStatus() {
        return this.status;
    }

    @JvmName(name = "getTitle")
    public final String getTitle() {
        return this.title;
    }

    @JvmName(name = "getErrorDescription")
    public final String getErrorDescription() {
        return this.errorDescription;
    }
}
