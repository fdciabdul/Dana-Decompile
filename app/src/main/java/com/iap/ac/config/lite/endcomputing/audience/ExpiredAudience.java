package com.iap.ac.config.lite.endcomputing.audience;

import java.util.Map;

/* loaded from: classes3.dex */
public class ExpiredAudience extends TimeBaseAudience {
    public ExpiredAudience(long j) {
        super(j);
    }

    @Override // com.iap.ac.config.lite.endcomputing.audience.BaseAudience
    public boolean evaluate(Map<String, Object> map) {
        return System.currentTimeMillis() <= this.time;
    }
}
