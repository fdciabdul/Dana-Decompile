package androidx.work;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;

/* loaded from: classes3.dex */
public interface ProgressUpdater {
    ListenableFuture<Void> getAuthRequestContext(UUID uuid, Data data);
}
