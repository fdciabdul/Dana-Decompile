package io.split.android.client.validators;

import io.split.android.client.SplitResult;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public interface TreatmentManager {
    String getTreatment(String str, Map<String, Object> map, boolean z);

    SplitResult getTreatmentWithConfig(String str, Map<String, Object> map, boolean z);

    Map<String, String> getTreatments(List<String> list, Map<String, Object> map, boolean z);

    Map<String, SplitResult> getTreatmentsWithConfig(List<String> list, Map<String, Object> map, boolean z);
}
