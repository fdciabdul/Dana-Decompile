package io.split.android.client;

import io.split.android.client.utils.logger.Logger;
import io.split.android.client.validators.SplitValidator;
import io.split.android.client.validators.SplitValidatorImpl;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class SyncConfig {
    private final List<SplitFilter> mFilters;

    private SyncConfig(List<SplitFilter> list) {
        this.mFilters = list;
    }

    public List<SplitFilter> getFilters() {
        return this.mFilters;
    }

    public static Builder builder() {
        return new Builder();
    }

    /* loaded from: classes6.dex */
    public static class Builder {
        private List<SplitFilter> mBuilderFilters = new ArrayList();
        private final SplitValidator mSplitValidator = new SplitValidatorImpl();

        public SyncConfig build() {
            ArrayList arrayList = new ArrayList();
            for (SplitFilter splitFilter : this.mBuilderFilters) {
                List<String> values = splitFilter.getValues();
                ArrayList arrayList2 = new ArrayList();
                for (String str : values) {
                    if (this.mSplitValidator.validateName(str) != null) {
                        Logger.w(String.format("Warning: Malformed %s value. Filter ignored: %s", splitFilter.getType().toString(), str));
                    } else {
                        arrayList2.add(str);
                    }
                }
                if (arrayList2.size() > 0) {
                    arrayList.add(new SplitFilter(splitFilter.getType(), arrayList2));
                }
            }
            return new SyncConfig(arrayList);
        }

        public Builder addSplitFilter(SplitFilter splitFilter) {
            if (splitFilter == null) {
                throw new IllegalArgumentException("Filter can't be null");
            }
            this.mBuilderFilters.add(splitFilter);
            return this;
        }
    }
}
