package io.split.android.client.storage.splits;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.gson.JsonSyntaxException;
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
public class SplitEntityToSplitTransformer implements SplitListTransformer<SplitEntity, Split> {
    private final SplitCipher mSplitCipher;
    private final SplitParallelTaskExecutor<List<Split>> mTaskExecutor;

    public SplitEntityToSplitTransformer(SplitParallelTaskExecutor<List<Split>> splitParallelTaskExecutor, SplitCipher splitCipher) {
        this.mTaskExecutor = (SplitParallelTaskExecutor) Preconditions.checkNotNull(splitParallelTaskExecutor);
        this.mSplitCipher = (SplitCipher) Preconditions.checkNotNull(splitCipher);
    }

    @Override // io.split.android.client.storage.splits.SplitListTransformer
    public List<Split> transform(List<SplitEntity> list) {
        if (list == null) {
            return new ArrayList();
        }
        int size = list.size();
        if (size > this.mTaskExecutor.getAvailableThreads()) {
            List<List<Split>> execute = this.mTaskExecutor.execute(getSplitDeserializationTasks(list, size));
            ArrayList arrayList = new ArrayList();
            Iterator<List<Split>> it = execute.iterator();
            while (it.hasNext()) {
                arrayList.addAll(it.next());
            }
            return arrayList;
        }
        return convertEntitiesToSplitList(list, this.mSplitCipher);
    }

    private List<SplitDeferredTaskItem<List<Split>>> getSplitDeserializationTasks(List<SplitEntity> list, int i) {
        int availableThreads = this.mTaskExecutor.getAvailableThreads();
        List<List> partition = Lists.partition(list, availableThreads > 0 ? i / availableThreads : 1);
        ArrayList arrayList = new ArrayList(partition.size());
        for (final List list2 : partition) {
            arrayList.add(new SplitDeferredTaskItem(new Callable<List<Split>>() { // from class: io.split.android.client.storage.splits.SplitEntityToSplitTransformer.1
                @Override // java.util.concurrent.Callable
                public List<Split> call() {
                    return SplitEntityToSplitTransformer.convertEntitiesToSplitList(list2, SplitEntityToSplitTransformer.this.mSplitCipher);
                }
            }));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<Split> convertEntitiesToSplitList(List<SplitEntity> list, SplitCipher splitCipher) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        for (SplitEntity splitEntity : list) {
            try {
                String decrypt = splitCipher.decrypt(splitEntity.getName());
                String decrypt2 = splitCipher.decrypt(splitEntity.getBody());
                if (decrypt != null && decrypt2 != null) {
                    Split split = (Split) Json.fromJson(decrypt2, Split.class);
                    split.name = decrypt;
                    arrayList.add(split);
                }
            } catch (JsonSyntaxException unused) {
                StringBuilder sb = new StringBuilder();
                sb.append("Could not parse entity to split: ");
                sb.append(splitEntity.getName());
                Logger.e(sb.toString());
            }
        }
        return arrayList;
    }
}
