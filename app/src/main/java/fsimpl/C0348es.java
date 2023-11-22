package fsimpl;

import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.remotedebug.utils.TinyAppLogUtil;
import com.alipay.mobile.verifyidentity.base.message.Message;
import com.google.common.net.HttpHeaders;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.sendmoney.summary.SummaryActivity;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: fsimpl.es  reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C0348es {

    /* renamed from: a  reason: collision with root package name */
    private final URL f7976a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;
    private final String h;
    private final boolean i;

    public C0348es(URL url, String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z) {
        this.f7976a = url;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = str5;
        this.g = str6;
        this.h = str7;
        this.i = z;
    }

    private String a(String str, StackTraceElement[] stackTraceElementArr) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Message.TAG, str);
            jSONObject.put("Context", this.e);
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            JSONObject jSONObject4 = new JSONObject();
            jSONObject3.put("version", this.f);
            jSONObject3.put("orgId", this.g);
            jSONObject3.put("sessionUrl", this.h);
            jSONObject3.put("isHans", this.i);
            jSONObject3.put(TinyAppLogUtil.TINY_APP_STANDARD_EXTRA_PLATFORM, "android");
            jSONObject4.put("osName", this.c);
            jSONObject4.put("osVersion", this.d);
            jSONObject4.put("device", this.b);
            jSONObject2.put(RVStartParams.KEY_FULLSCREEN_SHORT, jSONObject3);
            jSONObject2.put("device", jSONObject4);
            jSONObject.put("MetaData", jSONObject2);
            JSONArray jSONArray = new JSONArray();
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put(TrackerKey.DeeplinkProperty.METHOD, stackTraceElement.getMethodName());
                if (stackTraceElement.getFileName() != null) {
                    jSONObject5.put("File", stackTraceElement.getFileName());
                }
                if (stackTraceElement.getLineNumber() >= 0) {
                    jSONObject5.put("LineNumber", Integer.toString(stackTraceElement.getLineNumber()));
                }
                if (stackTraceElement.isNativeMethod()) {
                    jSONObject5.put("Native", SummaryActivity.CHECKED);
                    if (stackTraceElement.getFileName() == null) {
                        jSONObject5.put("File", "[native code]");
                    }
                }
                jSONArray.put(jSONObject5);
            }
            jSONObject.put("StackTrace", jSONArray);
            jSONObject.put("Type", "java");
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    public void a(Throwable th) {
        if (this.f7976a == null) {
            return;
        }
        try {
            String a2 = a(th.getMessage(), th.getStackTrace());
            HttpURLConnection httpURLConnection = (HttpURLConnection) this.f7976a.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_LENGTH, Integer.toString(a2.getBytes().length));
            httpURLConnection.setDoOutput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            WritableByteChannel newChannel = Channels.newChannel(outputStream);
            newChannel.write(ByteBuffer.wrap(a2.getBytes()));
            httpURLConnection.getResponseCode();
            outputStream.close();
            newChannel.close();
        } catch (Throwable unused) {
        }
    }
}
