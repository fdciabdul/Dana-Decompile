package com.google.android.play.core.install;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import java.util.Locale;

/* loaded from: classes3.dex */
public class InstallException extends ApiException {
    public int getErrorCode() {
        return super.getStatusCode();
    }

    public InstallException(int i) {
        super(new Status(i, String.format(Locale.getDefault(), "Install Error(%d): %s", Integer.valueOf(i), com.google.android.play.core.install.model.zza.zza(i))));
        if (i == 0) {
            throw new IllegalArgumentException("errorCode should not be 0.");
        }
    }
}
