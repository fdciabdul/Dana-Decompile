package com.iap.ac.config.lite.endcomputing.audience;

import java.util.Map;

/* loaded from: classes3.dex */
public class InvalidAudience extends BaseAudience {
    @Override // com.iap.ac.config.lite.endcomputing.audience.BaseAudience
    public boolean evaluate(Map<String, Object> map) {
        return false;
    }
}
