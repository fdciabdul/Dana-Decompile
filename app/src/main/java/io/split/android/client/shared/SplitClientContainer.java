package io.split.android.client.shared;

import io.split.android.client.SplitClient;
import io.split.android.client.api.Key;
import java.util.Set;

/* loaded from: classes6.dex */
public interface SplitClientContainer {
    Set<SplitClient> getAll();

    SplitClient getClient(Key key);

    void remove(Key key);
}
