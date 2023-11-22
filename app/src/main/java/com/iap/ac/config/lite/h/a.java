package com.iap.ac.config.lite.h;

import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.config.lite.common.AmcsConstants;
import com.iap.ac.config.lite.d.e;
import com.iap.ac.config.lite.listener.sectionconfig.ChangedDetails;
import com.iap.ac.config.lite.listener.sectionconfig.ISectionConfigListener;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class a implements ISectionConfigListener {
    private static final String b = e.b("ConfigPollingListener");

    /* renamed from: a  reason: collision with root package name */
    private InterfaceC0142a f7643a;

    /* renamed from: com.iap.ac.config.lite.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0142a {
        void startConfigPolling();

        void stopConfigPolling();
    }

    public a(InterfaceC0142a interfaceC0142a) {
        this.f7643a = interfaceC0142a;
    }

    @Override // com.iap.ac.config.lite.listener.sectionconfig.ISectionConfigListener
    public void onConfigChanged(String str, JSONObject jSONObject, ChangedDetails changedDetails) {
        if ("amcs".equalsIgnoreCase(str)) {
            String str2 = b;
            ACLog.d(str2, "notice amcs section has changed!");
            if (jSONObject == null) {
                return;
            }
            long optInt = jSONObject.optInt(AmcsConstants.AMCS_SYNC_INTERVAL, 300);
            if (optInt <= 0) {
                ACLog.d(str2, "notice dns sync interval close");
                this.f7643a.stopConfigPolling();
                return;
            }
            ACLog.d(str2, String.format("notice dns sync interval changed,now is [%s]", Long.valueOf(optInt)));
            this.f7643a.startConfigPolling();
        }
    }
}
