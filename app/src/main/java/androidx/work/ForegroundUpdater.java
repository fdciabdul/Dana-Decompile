package androidx.work;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;

/* loaded from: classes3.dex */
public interface ForegroundUpdater {
    ListenableFuture<Void> getAuthRequestContext(Context context, UUID uuid, ForegroundInfo foregroundInfo);
}
