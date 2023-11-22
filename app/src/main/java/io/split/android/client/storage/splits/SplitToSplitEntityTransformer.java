package io.split.android.client.storage.splits;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import io.split.android.client.dtos.Split;
import io.split.android.client.service.executor.parallel.SplitDeferredTaskItem;
import io.split.android.client.service.executor.parallel.SplitParallelTaskExecutor;
import io.split.android.client.storage.cipher.SplitCipher;
import io.split.android.client.storage.db.SplitEntity;
import io.split.android.client.utils.Json;
import io.split.android.client.utils.logger.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes6.dex */
public class SplitToSplitEntityTransformer implements SplitListTransformer<Split, SplitEntity> {
    private final SplitCipher mSplitCipher;
    private final SplitParallelTaskExecutor<List<SplitEntity>> mTaskExecutor;

    public SplitToSplitEntityTransformer(SplitParallelTaskExecutor<List<SplitEntity>> splitParallelTaskExecutor, SplitCipher splitCipher) {
        this.mTaskExecutor = (SplitParallelTaskExecutor) Preconditions.checkNotNull(splitParallelTaskExecutor);
        this.mSplitCipher = (SplitCipher) Preconditions.checkNotNull(splitCipher);
    }

    @Override // io.split.android.client.storage.splits.SplitListTransformer
    public List<SplitEntity> transform(List<Split> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        int size = list.size();
        if (size > this.mTaskExecutor.getAvailableThreads()) {
            Iterator<List<SplitEntity>> it = this.mTaskExecutor.execute(getSplitEntityTasks(list, size)).iterator();
            while (it.hasNext()) {
                arrayList.addAll(it.next());
            }
            return arrayList;
        }
        return getSplitEntities(list, this.mSplitCipher);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<SplitEntity> getSplitEntities(List<Split> list, SplitCipher splitCipher) {
        ArrayList arrayList = new ArrayList();
        for (Split split : list) {
            String encrypt = splitCipher.encrypt(split.name);
            String encrypt2 = splitCipher.encrypt(Json.toJson(split));
            if (encrypt == null || encrypt2 == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Error encrypting split: ");
                sb.append(split.name);
                Logger.e(sb.toString());
            } else {
                SplitEntity splitEntity = new SplitEntity();
                splitEntity.setName(encrypt);
                splitEntity.setBody(encrypt2);
                splitEntity.setUpdatedAt(System.currentTimeMillis() / 1000);
                arrayList.add(splitEntity);
            }
        }
        return arrayList;
    }

    private List<SplitDeferredTaskItem<List<SplitEntity>>> getSplitEntityTasks(List<Split> list, int i) {
        List<List> partition = Lists.partition(list, i / this.mTaskExecutor.getAvailableThreads());
        ArrayList arrayList = new ArrayList(partition.size());
        for (final List list2 : partition) {
            arrayList.add(new SplitDeferredTaskItem(new Callable<List<SplitEntity>>() { // from class: io.split.android.client.storage.splits.SplitToSplitEntityTransformer.1
                @Override // java.util.concurrent.Callable
                public List<SplitEntity> call() {
                    return SplitToSplitEntityTransformer.getSplitEntities(list2, SplitToSplitEntityTransformer.this.mSplitCipher);
                }
            }));
        }
        return arrayList;
    }
}
