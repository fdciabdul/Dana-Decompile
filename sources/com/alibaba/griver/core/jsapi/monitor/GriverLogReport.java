package com.alibaba.griver.core.jsapi.monitor;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.api.common.network.GriverTransportExtension;
import com.alibaba.griver.api.common.network.HttpRequest;
import com.alibaba.griver.api.common.network.HttpResponse;
import com.alibaba.griver.base.common.executor.GriverExecutors;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.monitor.GriverMonitor;
import com.alipay.iap.android.aplog.core.layout.mas.MasLog;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes6.dex */
public class GriverLogReport implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private String f6415a;
    private String b;
    private JSONObject d;
    private int f;
    private int g;
    private Handler e = new Handler(Looper.getMainLooper());
    private List<String> c = new LinkedList();

    public GriverLogReport(String str, String str2, int i, int i2) {
        this.f = 30;
        this.g = 30;
        this.f6415a = str;
        this.b = str2;
        this.f = i2;
        this.g = i;
    }

    public void addData(String str, String str2, JSONObject jSONObject) {
        if ("behavior".equals(str2)) {
            this.e.removeCallbacksAndMessages(null);
            this.c.add(str);
            if (this.c.size() >= this.g) {
                uploadData();
            } else {
                this.e.postDelayed(this, this.f * 1000);
            }
            this.d = jSONObject;
        } else if ("error".equals(str2)) {
            this.e.removeCallbacksAndMessages(null);
            this.c.add(str);
            uploadData();
            this.d = jSONObject;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        uploadData();
    }

    public JSONObject getCacheData() {
        return this.d;
    }

    public void uploadData() {
        if (this.c.size() == 0) {
            return;
        }
        final ArrayList arrayList = new ArrayList(this.c);
        this.c = new LinkedList();
        GriverExecutors.getExecutor(ExecutorType.IDLE).execute(new Runnable() { // from class: com.alibaba.griver.core.jsapi.monitor.GriverLogReport.1
            private static int $10 = 0;
            private static int $11 = 1;
            private static short[] BuiltInFictitiousFunctionClassFactory = null;
            private static int KClassImpl$Data$declaredNonStaticMembers$2 = 1394614873;
            private static int MyBillsEntityDataFactory = 1257195663;
            private static int NetworkUserEntityData$$ExternalSyntheticLambda0 = 1;
            private static int scheduleImpl;
            private static byte[] getAuthRequestContext = {106, -82, -110, -121, -70};
            private static int PlaceComponentResult = 2115708125;

            @Override // java.lang.Runnable
            public void run() {
                StringBuilder sb = new StringBuilder();
                int i = 0;
                while (true) {
                    if (i < arrayList.size()) {
                        int i2 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 87;
                        scheduleImpl = i2 % 128;
                        int i3 = i2 % 2;
                        sb.append((String) arrayList.get(i));
                        sb.append(MasLog.Constant.GAP);
                        i++;
                        int i4 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 65;
                        scheduleImpl = i4 % 128;
                        int i5 = i4 % 2;
                    } else {
                        try {
                            break;
                        } catch (Throwable th) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("upload data error, e=");
                            sb2.append(th);
                            GriverLogger.w("GriverLogReport", sb2.toString());
                            GriverLogReport griverLogReport = GriverLogReport.this;
                            griverLogReport.a(griverLogReport.b, GriverLogReport.this.f6415a, th.getMessage());
                            return;
                        }
                    }
                }
                GriverTransportExtension griverTransportExtension = (GriverTransportExtension) RVProxy.get(GriverTransportExtension.class);
                HttpRequest httpRequest = new HttpRequest();
                HashMap hashMap = new HashMap();
                hashMap.put("Content-Type", "application/x-www-form-urlencoded");
                httpRequest.setHeaders(hashMap);
                httpRequest.setUrl(GriverLogReport.this.f6415a);
                httpRequest.setMethod("POST");
                StringBuilder sb3 = new StringBuilder();
                sb3.append("data=");
                sb3.append(Uri.encode(sb.toString()));
                String obj = sb3.toString();
                Object[] objArr = new Object[1];
                a((-888433730) - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (-18) - TextUtils.lastIndexOf("", '0', 0), (short) (ExpandableListView.getPackedPositionChild(0L) - 37), (KeyEvent.getMaxKeyCode() >> 16) - 433023601, (byte) (TextUtils.indexOf((CharSequence) "", '0', 0) + 1), objArr);
                httpRequest.setRequestData(obj.getBytes(Charset.forName(((String) objArr[0]).intern())));
                HttpResponse request = griverTransportExtension.request(httpRequest);
                if (request.getStatusCode() != 200) {
                    GriverLogReport griverLogReport2 = GriverLogReport.this;
                    String str = griverLogReport2.b;
                    String str2 = GriverLogReport.this.f6415a;
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(request.getStatusCode());
                    griverLogReport2.a(str, str2, sb4.toString());
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:43:0x00d4  */
            /* JADX WARN: Removed duplicated region for block: B:51:0x00ee  */
            /* JADX WARN: Removed duplicated region for block: B:52:0x00f0  */
            /* JADX WARN: Removed duplicated region for block: B:56:0x00f7  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            private static void a(int r14, int r15, short r16, int r17, byte r18, java.lang.Object[] r19) {
                /*
                    Method dump skipped, instructions count: 372
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.jsapi.monitor.GriverLogReport.AnonymousClass1.a(int, int, short, int, byte, java.lang.Object[]):void");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("bizType", str);
        hashMap.put("url", str2);
        hashMap.put("errorCode", "-1");
        hashMap.put("errorMessage", str3);
        GriverMonitor.event(GriverMonitorConstants.KEY_GRIVER_LOG_REPORT_ERROR, "GriverAppContainer", hashMap);
    }

    public static String getReportId(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }
}
