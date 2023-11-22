package id.dana.data.network.exception;

import android.content.Context;
import id.dana.data.R;
import java.io.IOException;

/* loaded from: classes4.dex */
public class NoNetworkException extends IOException {
    private final Context context;

    public NoNetworkException(Context context) {
        this.context = context;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.context.getString(R.string.no_network);
    }
}
