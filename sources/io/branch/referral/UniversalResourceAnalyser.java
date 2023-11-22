package io.branch.referral;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class UniversalResourceAnalyser {
    private static JSONObject BuiltInFictitiousFunctionClassFactory;
    private static UniversalResourceAnalyser getAuthRequestContext;
    private final JSONObject KClassImpl$Data$declaredNonStaticMembers$2;
    private final ArrayList<String> MyBillsEntityDataFactory;

    public static UniversalResourceAnalyser KClassImpl$Data$declaredNonStaticMembers$2(Context context) {
        if (getAuthRequestContext == null) {
            getAuthRequestContext = new UniversalResourceAnalyser(context);
        }
        return getAuthRequestContext;
    }

    private UniversalResourceAnalyser(Context context) {
        JSONObject jSONObject = new JSONObject();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = jSONObject;
        try {
            jSONObject.putOpt("version", 0);
            JSONArray jSONArray = new JSONArray();
            jSONObject.putOpt("uri_skip_list", jSONArray);
            jSONArray.put("^fb\\d+:");
            jSONArray.put("^li\\d+:");
            jSONArray.put("^pdk\\d+:");
            jSONArray.put("^twitterkit-.*:");
            jSONArray.put("^com\\.googleusercontent\\.apps\\.\\d+-.*:\\/oauth");
            jSONArray.put("^(?i)(?!(http|https):).*(:|:.*\\b)(password|o?auth|o?auth.?token|access|access.?token)\\b");
            jSONArray.put("^(?i)((http|https):\\/\\/).*[\\/|?|#].*\\b(password|o?auth|o?auth.?token|access|access.?token)\\b");
        } catch (JSONException unused) {
        }
        BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(context);
        this.MyBillsEntityDataFactory = new ArrayList<>();
    }

    private JSONObject BuiltInFictitiousFunctionClassFactory(Context context) {
        PrefHelper.BuiltInFictitiousFunctionClassFactory(context);
        JSONObject jSONObject = new JSONObject();
        String lookAheadTest = PrefHelper.lookAheadTest("skip_url_format_key");
        if (TextUtils.isEmpty(lookAheadTest) || "bnc_no_value".equals(lookAheadTest)) {
            return this.KClassImpl$Data$declaredNonStaticMembers$2;
        }
        try {
            return new JSONObject(lookAheadTest);
        } catch (JSONException unused) {
            return jSONObject;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void getAuthRequestContext(Context context) {
        try {
            new UrlSkipListUpdateTask(context, (byte) 0).KClassImpl$Data$declaredNonStaticMembers$2(new Void[0]);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String MyBillsEntityDataFactory(String str) {
        String str2;
        try {
            JSONArray optJSONArray = BuiltInFictitiousFunctionClassFactory.optJSONArray("uri_skip_list");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    try {
                        str2 = optJSONArray.getString(i);
                    } catch (JSONException unused) {
                    }
                    if (Pattern.compile(str2).matcher(str).find()) {
                        break;
                    }
                }
            }
            str2 = null;
            if (str2 == null) {
                if (this.MyBillsEntityDataFactory.size() <= 0) {
                    return str;
                }
                Iterator<String> it = this.MyBillsEntityDataFactory.iterator();
                while (it.hasNext()) {
                    if (str.matches(it.next())) {
                        return str;
                    }
                }
            }
            return str2;
        } catch (Exception unused2) {
            return str;
        }
    }

    /* loaded from: classes6.dex */
    static class UrlSkipListUpdateTask extends BranchAsyncTask<Void, Void, JSONObject> {
        private final int KClassImpl$Data$declaredNonStaticMembers$2;
        private final PrefHelper MyBillsEntityDataFactory;

        /* synthetic */ UrlSkipListUpdateTask(Context context, byte b) {
            this(context);
        }

        @Override // android.os.AsyncTask
        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            Void[] voidArr = (Void[]) objArr;
            return BuiltInFictitiousFunctionClassFactory();
        }

        @Override // android.os.AsyncTask
        protected /* synthetic */ void onPostExecute(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            super.onPostExecute(jSONObject);
            if (jSONObject.optInt("version") > UniversalResourceAnalyser.BuiltInFictitiousFunctionClassFactory.optInt("version")) {
                JSONObject unused = UniversalResourceAnalyser.BuiltInFictitiousFunctionClassFactory = jSONObject;
                PrefHelper.getAuthRequestContext("skip_url_format_key", UniversalResourceAnalyser.BuiltInFictitiousFunctionClassFactory.toString());
            }
        }

        private UrlSkipListUpdateTask(Context context) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = 1500;
            this.MyBillsEntityDataFactory = PrefHelper.BuiltInFictitiousFunctionClassFactory(context);
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0065, code lost:
        
            if (r1 != null) goto L12;
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x0067, code lost:
        
            r1.disconnect();
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x006e, code lost:
        
            if (r1 == null) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0071, code lost:
        
            return r0;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static org.json.JSONObject BuiltInFictitiousFunctionClassFactory() {
            /*
                r0 = 0
                android.net.TrafficStats.setThreadStatsTag(r0)
                org.json.JSONObject r0 = new org.json.JSONObject
                r0.<init>()
                java.net.URL r1 = new java.net.URL     // Catch: java.lang.Throwable -> L6d
                java.lang.String r2 = "https://cdn.branch.io/sdk/uriskiplist_v#.json"
                java.lang.String r3 = "#"
                org.json.JSONObject r4 = io.branch.referral.UniversalResourceAnalyser.KClassImpl$Data$declaredNonStaticMembers$2()     // Catch: java.lang.Throwable -> L6d
                java.lang.String r5 = "version"
                int r4 = r4.optInt(r5)     // Catch: java.lang.Throwable -> L6d
                int r4 = r4 + 1
                java.lang.String r4 = java.lang.Integer.toString(r4)     // Catch: java.lang.Throwable -> L6d
                java.lang.String r2 = r2.replace(r3, r4)     // Catch: java.lang.Throwable -> L6d
                r1.<init>(r2)     // Catch: java.lang.Throwable -> L6d
                java.net.URLConnection r1 = r1.openConnection()     // Catch: java.lang.Throwable -> L6d
                java.net.URLConnection r1 = com.fullstory.instrumentation.InstrumentInjector.urlconnection_wrapInstance(r1)     // Catch: java.lang.Throwable -> L6d
                java.lang.Object r1 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r1)     // Catch: java.lang.Throwable -> L6d
                java.net.URLConnection r1 = (java.net.URLConnection) r1     // Catch: java.lang.Throwable -> L6d
                javax.net.ssl.HttpsURLConnection r1 = (javax.net.ssl.HttpsURLConnection) r1     // Catch: java.lang.Throwable -> L6d
                r2 = 1500(0x5dc, float:2.102E-42)
                r1.setConnectTimeout(r2)     // Catch: java.lang.Throwable -> L6b
                r1.setReadTimeout(r2)     // Catch: java.lang.Throwable -> L6b
                int r2 = r1.getResponseCode()     // Catch: java.lang.Throwable -> L6b
                r3 = 200(0xc8, float:2.8E-43)
                if (r2 != r3) goto L65
                java.io.InputStream r2 = r1.getInputStream()     // Catch: java.lang.Throwable -> L6b
                if (r2 == 0) goto L65
                java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L6b
                java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L6b
                java.io.InputStream r4 = r1.getInputStream()     // Catch: java.lang.Throwable -> L6b
                r3.<init>(r4)     // Catch: java.lang.Throwable -> L6b
                r2.<init>(r3)     // Catch: java.lang.Throwable -> L6b
                org.json.JSONObject r3 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L6b
                java.lang.String r2 = r2.readLine()     // Catch: java.lang.Throwable -> L6b
                r3.<init>(r2)     // Catch: java.lang.Throwable -> L6b
                r0 = r3
            L65:
                if (r1 == 0) goto L71
            L67:
                r1.disconnect()
                goto L71
            L6b:
                goto L6e
            L6d:
                r1 = 0
            L6e:
                if (r1 == 0) goto L71
                goto L67
            L71:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.UniversalResourceAnalyser.UrlSkipListUpdateTask.BuiltInFictitiousFunctionClassFactory():org.json.JSONObject");
        }
    }
}
