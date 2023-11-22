package io.split.android.client;

import io.split.android.client.attributes.AttributesManager;
import io.split.android.client.events.SplitEvent;
import io.split.android.client.events.SplitEventTask;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public interface SplitClient extends AttributesManager {
    void destroy();

    void flush();

    String getTreatment(String str);

    String getTreatment(String str, Map<String, Object> map);

    SplitResult getTreatmentWithConfig(String str, Map<String, Object> map);

    Map<String, String> getTreatments(List<String> list, Map<String, Object> map);

    Map<String, SplitResult> getTreatmentsWithConfig(List<String> list, Map<String, Object> map);

    boolean isReady();

    void on(SplitEvent splitEvent, SplitEventTask splitEventTask);

    boolean track(String str);

    boolean track(String str, double d);

    boolean track(String str, double d, Map<String, Object> map);

    boolean track(String str, String str2);

    boolean track(String str, String str2, double d);

    boolean track(String str, String str2, double d, Map<String, Object> map);

    boolean track(String str, String str2, Map<String, Object> map);

    boolean track(String str, Map<String, Object> map);
}
