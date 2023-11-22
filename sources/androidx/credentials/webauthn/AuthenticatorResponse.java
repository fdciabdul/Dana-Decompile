package androidx.credentials.webauthn;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004R\u001c\u0010\b\u001a\u00020\u00028'@'X¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0004\"\u0004\b\u0006\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Landroidx/credentials/webauthn/AuthenticatorResponse;", "", "Lorg/json/JSONObject;", "json", "()Lorg/json/JSONObject;", "getClientJson", "setClientJson", "(Lorg/json/JSONObject;)V", "clientJson"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public interface AuthenticatorResponse {
    @JvmName(name = "getClientJson")
    JSONObject getClientJson();

    JSONObject json();

    @JvmName(name = "setClientJson")
    void setClientJson(JSONObject jSONObject);
}
