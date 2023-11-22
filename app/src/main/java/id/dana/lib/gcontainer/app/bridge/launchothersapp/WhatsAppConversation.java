package id.dana.lib.gcontainer.app.bridge.launchothersapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.telephony.PhoneNumberUtils;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.fastjson.JSONObject;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.lib.gcontainer.extension.ContentExtKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import net.sqlcipher.database.SQLiteDatabase;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\tJ-\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u0002*\u00020\u0002H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u0002*\u00020\u0002H\u0002¢\u0006\u0004\b\u0013\u0010\u0012"}, d2 = {"Lid/dana/lib/gcontainer/app/bridge/launchothersapp/WhatsAppConversation;", "", "", "targetPhoneNumber", "message", "generateChatWhatsAppUrl", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "Landroid/content/Intent;", "getWhatsAppChatIntent", "(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", "", "openApp", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;)V", "formatPhoneNumber", "(Ljava/lang/String;)Ljava/lang/String;", "getIndoPhoneNumber", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class WhatsAppConversation {
    public static final WhatsAppConversation INSTANCE = new WhatsAppConversation();

    private WhatsAppConversation() {
    }

    public final void openApp(Context context, String targetPhoneNumber, String message, BridgeCallback bridgeCallback) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(targetPhoneNumber, "");
        Intrinsics.checkNotNullParameter(message, "");
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        ContentExtKt.startActivitySafely(context, getWhatsAppChatIntent(formatPhoneNumber(targetPhoneNumber), message));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put((JSONObject) "success", (String) Boolean.TRUE);
        Unit unit = Unit.INSTANCE;
        bridgeCallback.sendJSONResponse(jSONObject);
    }

    private final String formatPhoneNumber(String str) {
        String stripSeparators = PhoneNumberUtils.stripSeparators(StringsKt.replace$default(StringsKt.replace$default(str, " ", "", false, 4, (Object) null), "+", "", false, 4, (Object) null));
        Intrinsics.checkNotNullExpressionValue(stripSeparators, "");
        return stripSeparators;
    }

    private final String getIndoPhoneNumber(String str) {
        if (str.charAt(0) == '0') {
            return new Regex("0").replaceFirst(str, "62");
        }
        return str;
    }

    private final String generateChatWhatsAppUrl(String targetPhoneNumber, String message) {
        String obj = Uri.parse("https://wa.me/").buildUpon().appendPath(getIndoPhoneNumber(targetPhoneNumber)).appendQueryParameter("text", message).build().toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        return obj;
    }

    private final Intent getWhatsAppChatIntent(String targetPhoneNumber, String message) {
        Intent data = new Intent("android.intent.action.VIEW").setFlags(SQLiteDatabase.CREATE_IF_NECESSARY).setPackage("com.whatsapp").setData(Uri.parse(generateChatWhatsAppUrl(targetPhoneNumber, message)));
        Intrinsics.checkNotNullExpressionValue(data, "");
        return data;
    }
}
