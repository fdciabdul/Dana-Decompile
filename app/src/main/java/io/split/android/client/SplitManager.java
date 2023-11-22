package io.split.android.client;

import io.split.android.client.api.SplitView;
import java.util.List;

/* loaded from: classes6.dex */
public interface SplitManager {
    void destroy();

    SplitView split(String str);

    List<String> splitNames();

    List<SplitView> splits();
}
