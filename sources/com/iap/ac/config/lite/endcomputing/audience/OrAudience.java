package com.iap.ac.config.lite.endcomputing.audience;

import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class OrAudience extends BaseAudienceSets {
    @Override // com.iap.ac.config.lite.endcomputing.audience.BaseAudience
    public boolean evaluate(Map<String, Object> map) {
        List<BaseAudience> list = this.subAudiences;
        if (list == null || list.isEmpty()) {
            return true;
        }
        for (BaseAudience baseAudience : this.subAudiences) {
            if (baseAudience == null || baseAudience.evaluate(map)) {
                return true;
            }
        }
        return false;
    }
}
