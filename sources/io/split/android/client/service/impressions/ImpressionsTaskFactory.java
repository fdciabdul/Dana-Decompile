package io.split.android.client.service.impressions;

import io.split.android.client.service.impressions.unique.SaveUniqueImpressionsTask;
import io.split.android.client.service.impressions.unique.UniqueKeysRecorderTask;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes6.dex */
public interface ImpressionsTaskFactory {
    ImpressionsCountRecorderTask createImpressionsCountRecorderTask();

    ImpressionsRecorderTask createImpressionsRecorderTask();

    SaveImpressionsCountTask createSaveImpressionsCountTask(List<ImpressionsCountPerFeature> list);

    SaveUniqueImpressionsTask createSaveUniqueImpressionsTask(Map<String, Set<String>> map);

    UniqueKeysRecorderTask createUniqueImpressionsRecorderTask();
}
