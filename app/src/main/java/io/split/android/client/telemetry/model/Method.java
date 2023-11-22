package io.split.android.client.telemetry.model;

import io.split.android.client.validators.TreatmentManagerImpl;

/* loaded from: classes6.dex */
public enum Method {
    TREATMENT(TreatmentManagerImpl.ValidationTag.GET_TREATMENT),
    TREATMENTS(TreatmentManagerImpl.ValidationTag.GET_TREATMENTS),
    TREATMENT_WITH_CONFIG(TreatmentManagerImpl.ValidationTag.GET_TREATMENT_WITH_CONFIG),
    TREATMENTS_WITH_CONFIG(TreatmentManagerImpl.ValidationTag.GET_TREATMENTS_WITH_CONFIG),
    TRACK("track");

    private final String _method;

    Method(String str) {
        this._method = str;
    }

    public final String getMethod() {
        return this._method;
    }
}
