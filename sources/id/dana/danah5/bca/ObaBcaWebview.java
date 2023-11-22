package id.dana.danah5.bca;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0010\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B%\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\bR\"\u0010\n\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\u0004\"\u0004\b\r\u0010\bR\"\u0010\u000e\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\u0004\"\u0004\b\u0010\u0010\bR\"\u0010\u0011\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\u0004\"\u0004\b\u0013\u0010\b"}, d2 = {"Lid/dana/danah5/bca/ObaBcaWebview;", "", "", "constructBcaUrl", "()Ljava/lang/String;", "url", "", "parseBcaObaRegistraion", "(Ljava/lang/String;)V", "parseBcaObaRegistrationSuccess", ObaBcaWebview.PARAM_CONSTRUCT_APPDATAID, "Ljava/lang/String;", "getAppDataId", "setAppDataId", ObaBcaWebview.PARAM_BANKORDERID, "getBankOrderId", "setBankOrderId", "instId", "getInstId", "setInstId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ObaBcaWebview {
    public static final String PARAM_BANKORDERID = "bankOrderId";
    public static final String PARAM_BCA_APPDATAID = "AppDataId";
    public static final String PARAM_CONSTRUCT_APPDATAID = "appDataId";
    public static final String PARAM_INSTID = "instId";
    public static final String PARAM_STATUS = "status";
    public static final String PARAM_STATUS_VALUE = "SUBMIT";
    public static final String REDIRECT_PATH_OBA_BCA = "m/dbac/kyc-landing-page";
    private String appDataId;
    private String bankOrderId;
    private String instId;

    public ObaBcaWebview() {
        this(null, null, null, 7, null);
    }

    public ObaBcaWebview(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        this.instId = str;
        this.bankOrderId = str2;
        this.appDataId = str3;
    }

    public /* synthetic */ ObaBcaWebview(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3);
    }

    @JvmName(name = "getInstId")
    public final String getInstId() {
        return this.instId;
    }

    @JvmName(name = "setInstId")
    public final void setInstId(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.instId = str;
    }

    @JvmName(name = "getBankOrderId")
    public final String getBankOrderId() {
        return this.bankOrderId;
    }

    @JvmName(name = "setBankOrderId")
    public final void setBankOrderId(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.bankOrderId = str;
    }

    @JvmName(name = "getAppDataId")
    public final String getAppDataId() {
        return this.appDataId;
    }

    @JvmName(name = "setAppDataId")
    public final void setAppDataId(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.appDataId = str;
    }

    public final void parseBcaObaRegistraion(String url) {
        Intrinsics.checkNotNullParameter(url, "");
        Uri parse = Uri.parse(url);
        String queryParameter = parse.getQueryParameter("instId");
        if (queryParameter == null) {
            queryParameter = "";
        }
        this.instId = queryParameter;
        String queryParameter2 = parse.getQueryParameter(PARAM_BANKORDERID);
        this.bankOrderId = queryParameter2 != null ? queryParameter2 : "";
    }

    public final void parseBcaObaRegistrationSuccess(String url) {
        Intrinsics.checkNotNullParameter(url, "");
        String queryParameter = Uri.parse(url).getQueryParameter(PARAM_BCA_APPDATAID);
        this.appDataId = queryParameter != null ? queryParameter : "";
    }

    public final String constructBcaUrl() {
        String obj = Uri.parse("https://m.dana.id").buildUpon().encodedPath(REDIRECT_PATH_OBA_BCA).appendQueryParameter("instId", this.instId).appendQueryParameter(PARAM_BANKORDERID, this.bankOrderId).appendQueryParameter(PARAM_CONSTRUCT_APPDATAID, this.appDataId).appendQueryParameter("status", PARAM_STATUS_VALUE).build().toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        return obj;
    }
}
