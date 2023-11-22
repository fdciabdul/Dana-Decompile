package com.iap.ac.config.lite.endcomputing.audience;

import java.io.Serializable;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class BaseAudience implements Serializable {
    public abstract boolean evaluate(Map<String, Object> map);
}
