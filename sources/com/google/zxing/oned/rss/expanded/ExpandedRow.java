package com.google.zxing.oned.rss.expanded;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
final class ExpandedRow {
    private final List<ExpandedPair> pairs;
    private final int rowNumber;
    private final boolean wasReversed;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ExpandedRow(List<ExpandedPair> list, int i, boolean z) {
        this.pairs = new ArrayList(list);
        this.rowNumber = i;
        this.wasReversed = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List<ExpandedPair> getPairs() {
        return this.pairs;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int getRowNumber() {
        return this.rowNumber;
    }

    final boolean isReversed() {
        return this.wasReversed;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean isEquivalent(List<ExpandedPair> list) {
        return this.pairs.equals(list);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("{ ");
        sb.append(this.pairs);
        sb.append(" }");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ExpandedRow) {
            ExpandedRow expandedRow = (ExpandedRow) obj;
            return this.pairs.equals(expandedRow.getPairs()) && this.wasReversed == expandedRow.wasReversed;
        }
        return false;
    }

    public final int hashCode() {
        return this.pairs.hashCode() ^ Boolean.valueOf(this.wasReversed).hashCode();
    }
}
