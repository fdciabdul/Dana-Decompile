package com.iap.ac.config.lite.listener;

import com.iap.ac.config.lite.listener.sectionconfig.ChangedDetails;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public interface IAnyCommonConfigListener {
    void onConfigChanged(JSONObject jSONObject, ChangedDetails changedDetails);
}
