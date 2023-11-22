package io.split.android.client.service.splits;

import com.google.common.base.Preconditions;
import io.split.android.client.SplitFilter;
import io.split.android.client.dtos.Split;
import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskType;
import io.split.android.client.storage.splits.PersistentSplitsStorage;
import io.split.android.client.utils.logger.Logger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* loaded from: classes6.dex */
public class FilterSplitsInCacheTask implements SplitTask {
    private static final String PREFIX_SEPARATOR = "__";
    private final List<SplitFilter> mSplitsFilter;
    private final String mSplitsFilterQueryString;
    private final PersistentSplitsStorage mSplitsStorage;

    private String sanitizeString(String str) {
        return str == null ? "" : str;
    }

    public FilterSplitsInCacheTask(PersistentSplitsStorage persistentSplitsStorage, List<SplitFilter> list, String str) {
        this.mSplitsStorage = (PersistentSplitsStorage) Preconditions.checkNotNull(persistentSplitsStorage);
        this.mSplitsFilter = (List) Preconditions.checkNotNull(list);
        this.mSplitsFilterQueryString = str;
    }

    @Override // io.split.android.client.service.executor.SplitTask
    public SplitTaskExecutionInfo execute() {
        if (!queryStringHasChanged()) {
            return SplitTaskExecutionInfo.success(SplitTaskType.FILTER_SPLITS_CACHE);
        }
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (SplitFilter splitFilter : this.mSplitsFilter) {
            int i = AnonymousClass1.$SwitchMap$io$split$android$client$SplitFilter$Type[splitFilter.getType().ordinal()];
            if (i == 1) {
                hashSet.addAll(splitFilter.getValues());
            } else if (i == 2) {
                hashSet2.addAll(splitFilter.getValues());
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Unknown filter type");
                sb.append(splitFilter.getType().toString());
                Logger.e(sb.toString());
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Split split : this.mSplitsStorage.getAll()) {
            String str = split.name;
            String prefix = getPrefix(str);
            if (!hashSet.contains(split.name) && (prefix == null || !hashSet2.contains(prefix))) {
                arrayList.add(str);
            }
        }
        if (arrayList.size() > 0) {
            this.mSplitsStorage.delete(arrayList);
        }
        return SplitTaskExecutionInfo.success(SplitTaskType.FILTER_SPLITS_CACHE);
    }

    /* renamed from: io.split.android.client.service.splits.FilterSplitsInCacheTask$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$split$android$client$SplitFilter$Type;

        static {
            int[] iArr = new int[SplitFilter.Type.values().length];
            $SwitchMap$io$split$android$client$SplitFilter$Type = iArr;
            try {
                iArr[SplitFilter.Type.BY_NAME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$split$android$client$SplitFilter$Type[SplitFilter.Type.BY_PREFIX.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private String getPrefix(String str) {
        int indexOf = str.indexOf("__");
        if (indexOf <= 0) {
            return null;
        }
        return str.substring(0, indexOf);
    }

    private boolean queryStringHasChanged() {
        return !sanitizeString(this.mSplitsStorage.getFilterQueryString()).equals(sanitizeString(this.mSplitsFilterQueryString));
    }
}
