package com.iap.ac.config.lite.endcomputing.audience;

import java.util.Map;

/* loaded from: classes3.dex */
public class EqualsIgnoreCaseAudience extends BaseAudience {
    private String target;
    private String variable;

    @Override // com.iap.ac.config.lite.endcomputing.audience.BaseAudience
    public boolean evaluate(Map<String, Object> map) {
        String str;
        if (map == null || this.target == null || (str = this.variable) == null) {
            return false;
        }
        Object obj = map.get(str);
        return this.target.equalsIgnoreCase(obj == null ? null : obj.toString());
    }
}
