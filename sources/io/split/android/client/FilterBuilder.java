package io.split.android.client;

import com.huawei.hms.framework.common.ContainerUtils;
import io.split.android.client.SplitFilter;
import io.split.android.client.utils.StringHelper;
import io.split.android.client.utils.logger.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/* loaded from: classes6.dex */
public class FilterBuilder {
    private static final int MAX_BY_NAME_VALUES = 400;
    private static final int MAX_BY_PREFIX_VALUES = 50;
    private final List<SplitFilter> mFilters = new ArrayList();
    private final FilterGrouper mFilterGrouper = new FilterGrouper();

    /* loaded from: classes6.dex */
    static class SplitFilterComparator implements Comparator<SplitFilter> {
        private SplitFilterComparator() {
        }

        @Override // java.util.Comparator
        public int compare(SplitFilter splitFilter, SplitFilter splitFilter2) {
            return splitFilter.getType().compareTo(splitFilter2.getType());
        }
    }

    public FilterBuilder addFilters(List<SplitFilter> list) {
        this.mFilters.addAll(list);
        return this;
    }

    public String build() {
        if (this.mFilters.size() == 0) {
            return "";
        }
        StringHelper stringHelper = new StringHelper();
        StringBuilder sb = new StringBuilder("");
        ArrayList<SplitFilter> arrayList = new ArrayList(this.mFilterGrouper.group(this.mFilters));
        Collections.sort(arrayList, new SplitFilterComparator());
        for (SplitFilter splitFilter : arrayList) {
            SplitFilter.Type type = splitFilter.getType();
            TreeSet treeSet = new TreeSet(splitFilter.getValues());
            if (treeSet.size() < splitFilter.getValues().size()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Warning: Some duplicated values for ");
                sb2.append(type.toString());
                sb2.append(" filter  were removed.");
                Logger.w(sb2.toString());
            }
            if (treeSet.size() != 0) {
                validateFilterSize(type, treeSet.size());
                sb.append(ContainerUtils.FIELD_DELIMITER);
                sb.append(type.queryStringField());
                sb.append("=");
                sb.append(stringHelper.join(",", treeSet));
            }
        }
        return sb.toString();
    }

    private void validateFilterSize(SplitFilter.Type type, int i) {
        if (i <= type.maxValuesCount()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Error: ");
        sb.append(type.maxValuesCount());
        sb.append(" different split ");
        sb.append(type.queryStringField());
        sb.append(" can be specified at most. You passed ");
        sb.append(i);
        sb.append(". Please consider reducing the amount or using prefixes to target specific groups of splits.");
        throw new IllegalArgumentException(sb.toString());
    }
}
