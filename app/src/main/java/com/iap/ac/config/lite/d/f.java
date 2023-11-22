package com.iap.ac.config.lite.d;

import com.iap.ac.config.lite.listener.sectionconfig.ChangedDetails;
import com.iap.ac.config.lite.listener.sectionconfig.ISectionConfigListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class f extends c<ISectionConfigListener> {
    static {
        e.b("SectionConfigListener");
    }

    @Override // com.iap.ac.config.lite.d.c
    public void a(String str, JSONObject jSONObject, ChangedDetails changedDetails) {
        synchronized (this) {
            List list = (List) this.f7630a.get(str);
            if (list != null) {
                Iterator it = new ArrayList(list).iterator();
                while (it.hasNext()) {
                    ((ISectionConfigListener) it.next()).onConfigChanged(str, jSONObject, changedDetails);
                }
            }
        }
    }
}
