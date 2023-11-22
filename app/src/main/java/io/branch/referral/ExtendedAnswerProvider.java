package io.branch.referral;

import android.text.TextUtils;
import com.crashlytics.android.answers.shim.AnswersOptionalLogger;
import com.crashlytics.android.answers.shim.KitEvent;
import io.branch.referral.Defines;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class ExtendedAnswerProvider {
    public final void PlaceComponentResult(String str, JSONObject jSONObject, String str2) {
        try {
            KitEvent kitEvent = new KitEvent(str);
            if (jSONObject != null) {
                MyBillsEntityDataFactory(kitEvent, jSONObject, "");
                kitEvent.putAttribute(Defines.Jsonkey.BranchIdentity.getKey(), str2);
                AnswersOptionalLogger.get().logKitEvent(kitEvent);
            }
        } catch (Throwable unused) {
        }
    }

    private void MyBillsEntityDataFactory(KitEvent kitEvent, JSONObject jSONObject, String str) throws JSONException {
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if (!next.startsWith("+")) {
                if (obj instanceof JSONObject) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append(next);
                    sb.append(".");
                    MyBillsEntityDataFactory(kitEvent, (JSONObject) obj, sb.toString());
                } else if (obj instanceof JSONArray) {
                    JSONArray jSONArray = (JSONArray) obj;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(next);
                    sb2.append(".");
                    String obj2 = sb2.toString();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("~");
                        sb3.append(Integer.toString(i));
                        BuiltInFictitiousFunctionClassFactory(kitEvent, obj2, sb3.toString(), jSONArray.getString(i));
                    }
                } else {
                    BuiltInFictitiousFunctionClassFactory(kitEvent, str, next, jSONObject.getString(next));
                }
            }
        }
    }

    private static void BuiltInFictitiousFunctionClassFactory(KitEvent kitEvent, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        if (str2.startsWith("~")) {
            StringBuilder sb = new StringBuilder();
            sb.append(str.replaceFirst("~", ""));
            sb.append(str2.replaceFirst("~", ""));
            kitEvent.putAttribute(sb.toString(), str3);
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("$");
        sb2.append(Defines.Jsonkey.IdentityID.getKey());
        if (str2.equals(sb2.toString())) {
            kitEvent.putAttribute(Defines.Jsonkey.ReferringBranchIdentity.getKey(), str3);
        }
    }
}
