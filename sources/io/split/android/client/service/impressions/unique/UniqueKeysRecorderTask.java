package io.split.android.client.service.impressions.unique;

import com.google.common.base.Preconditions;
import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskExecutionStatus;
import io.split.android.client.service.executor.SplitTaskType;
import io.split.android.client.service.http.HttpRecorder;
import io.split.android.client.service.http.HttpRecorderException;
import io.split.android.client.storage.impressions.PersistentImpressionsUniqueStorage;
import io.split.android.client.utils.logger.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes6.dex */
public class UniqueKeysRecorderTask implements SplitTask {
    private final UniqueKeysRecorderTaskConfig mConfig;
    private final HttpRecorder<MTK> mHttpRecorder;
    private final PersistentImpressionsUniqueStorage mStorage;

    public UniqueKeysRecorderTask(HttpRecorder<MTK> httpRecorder, PersistentImpressionsUniqueStorage persistentImpressionsUniqueStorage, UniqueKeysRecorderTaskConfig uniqueKeysRecorderTaskConfig) {
        this.mHttpRecorder = (HttpRecorder) Preconditions.checkNotNull(httpRecorder);
        this.mStorage = (PersistentImpressionsUniqueStorage) Preconditions.checkNotNull(persistentImpressionsUniqueStorage);
        this.mConfig = (UniqueKeysRecorderTaskConfig) Preconditions.checkNotNull(uniqueKeysRecorderTaskConfig);
    }

    @Override // io.split.android.client.service.executor.SplitTask
    public SplitTaskExecutionInfo execute() {
        List<UniqueKey> pop;
        SplitTaskExecutionStatus splitTaskExecutionStatus = SplitTaskExecutionStatus.SUCCESS;
        ArrayList arrayList = new ArrayList();
        long j = 0;
        int i = 0;
        do {
            pop = this.mStorage.pop(this.mConfig.getElementsPerPush());
            if (pop.size() > 0) {
                try {
                    Logger.d("Posting %d Split MTKs", Integer.valueOf(pop.size()));
                    this.mHttpRecorder.execute(buildMTK(pop));
                    this.mStorage.delete(pop);
                    Logger.d("%d split MTKs sent", Integer.valueOf(pop.size()));
                } catch (HttpRecorderException e) {
                    SplitTaskExecutionStatus splitTaskExecutionStatus2 = SplitTaskExecutionStatus.ERROR;
                    i += this.mConfig.getElementsPerPush();
                    j += sumImpressionsBytes(pop);
                    StringBuilder sb = new StringBuilder();
                    sb.append("MTKs recorder task: Some keys couldn't be sent.Saving to send them in a new iteration");
                    sb.append(e.getLocalizedMessage());
                    Logger.e(sb.toString());
                    arrayList.addAll(pop);
                    splitTaskExecutionStatus = splitTaskExecutionStatus2;
                }
            }
        } while (pop.size() == this.mConfig.getElementsPerPush());
        if (arrayList.size() > 0) {
            this.mStorage.setActive(arrayList);
        }
        if (splitTaskExecutionStatus == SplitTaskExecutionStatus.ERROR) {
            HashMap hashMap = new HashMap();
            hashMap.put(SplitTaskExecutionInfo.NON_SENT_RECORDS, Integer.valueOf(i));
            hashMap.put(SplitTaskExecutionInfo.NON_SENT_BYTES, Long.valueOf(j));
            return SplitTaskExecutionInfo.error(SplitTaskType.UNIQUE_KEYS_RECORDER_TASK, hashMap);
        }
        return SplitTaskExecutionInfo.success(SplitTaskType.UNIQUE_KEYS_RECORDER_TASK);
    }

    private static MTK buildMTK(List<UniqueKey> list) {
        HashMap hashMap = new HashMap();
        for (UniqueKey uniqueKey : list) {
            String key = uniqueKey.getKey();
            if (!hashMap.containsKey(key)) {
                hashMap.put(key, new UniqueKey(key, new HashSet()));
            }
            UniqueKey uniqueKey2 = (UniqueKey) hashMap.get(key);
            if (uniqueKey2 != null) {
                Set<String> features = uniqueKey2.getFeatures();
                Set<String> features2 = uniqueKey.getFeatures();
                features2.addAll(features);
                hashMap.put(key, new UniqueKey(key, features2));
            }
        }
        return new MTK(new ArrayList(hashMap.values()));
    }

    private long sumImpressionsBytes(List<UniqueKey> list) {
        long j = 0;
        for (UniqueKey uniqueKey : list) {
            j += this.mConfig.getEstimatedSizeInBytes();
        }
        return j;
    }
}
