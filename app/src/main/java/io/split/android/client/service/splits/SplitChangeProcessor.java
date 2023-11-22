package io.split.android.client.service.splits;

import io.split.android.client.dtos.Split;
import io.split.android.client.dtos.SplitChange;
import io.split.android.client.dtos.Status;
import io.split.android.client.storage.splits.ProcessedSplitChange;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes6.dex */
public class SplitChangeProcessor {
    public ProcessedSplitChange process(SplitChange splitChange) {
        if (splitChange == null || splitChange.splits == null) {
            return new ProcessedSplitChange(new ArrayList(), new ArrayList(), -1L, 0L);
        }
        return buildProcessedSplitChange(splitChange.splits, splitChange.till);
    }

    public ProcessedSplitChange process(Split split, long j) {
        return buildProcessedSplitChange(Collections.singletonList(split), j);
    }

    private static ProcessedSplitChange buildProcessedSplitChange(List<Split> list, long j) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Split split : list) {
            if (split.name != null) {
                if (split.status == Status.ACTIVE) {
                    arrayList.add(split);
                } else {
                    arrayList2.add(split);
                }
            }
        }
        return new ProcessedSplitChange(arrayList, arrayList2, j, System.currentTimeMillis() / 100);
    }
}
