package com.huawei.hms.common.api;

import com.huawei.hms.common.Feature;

@Deprecated
/* loaded from: classes7.dex */
public final class UnsupportedApiCallException extends UnsupportedOperationException {
    private final Feature feature;

    public UnsupportedApiCallException(Feature feature) {
        this.feature = feature;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.feature);
        sb.append(" is unsupported");
        return sb.toString();
    }
}
