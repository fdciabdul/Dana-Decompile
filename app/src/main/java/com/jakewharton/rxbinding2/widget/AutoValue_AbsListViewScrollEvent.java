package com.jakewharton.rxbinding2.widget;

import android.widget.AbsListView;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class AutoValue_AbsListViewScrollEvent extends AbsListViewScrollEvent {
    private final int firstVisibleItem;
    private final int scrollState;
    private final int totalItemCount;
    private final AbsListView view;
    private final int visibleItemCount;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_AbsListViewScrollEvent(AbsListView absListView, int i, int i2, int i3, int i4) {
        if (absListView == null) {
            throw new NullPointerException("Null view");
        }
        this.view = absListView;
        this.scrollState = i;
        this.firstVisibleItem = i2;
        this.visibleItemCount = i3;
        this.totalItemCount = i4;
    }

    @Override // com.jakewharton.rxbinding2.widget.AbsListViewScrollEvent
    public final AbsListView view() {
        return this.view;
    }

    @Override // com.jakewharton.rxbinding2.widget.AbsListViewScrollEvent
    public final int scrollState() {
        return this.scrollState;
    }

    @Override // com.jakewharton.rxbinding2.widget.AbsListViewScrollEvent
    public final int firstVisibleItem() {
        return this.firstVisibleItem;
    }

    @Override // com.jakewharton.rxbinding2.widget.AbsListViewScrollEvent
    public final int visibleItemCount() {
        return this.visibleItemCount;
    }

    @Override // com.jakewharton.rxbinding2.widget.AbsListViewScrollEvent
    public final int totalItemCount() {
        return this.totalItemCount;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AbsListViewScrollEvent{view=");
        sb.append(this.view);
        sb.append(", scrollState=");
        sb.append(this.scrollState);
        sb.append(", firstVisibleItem=");
        sb.append(this.firstVisibleItem);
        sb.append(", visibleItemCount=");
        sb.append(this.visibleItemCount);
        sb.append(", totalItemCount=");
        sb.append(this.totalItemCount);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbsListViewScrollEvent) {
            AbsListViewScrollEvent absListViewScrollEvent = (AbsListViewScrollEvent) obj;
            return this.view.equals(absListViewScrollEvent.view()) && this.scrollState == absListViewScrollEvent.scrollState() && this.firstVisibleItem == absListViewScrollEvent.firstVisibleItem() && this.visibleItemCount == absListViewScrollEvent.visibleItemCount() && this.totalItemCount == absListViewScrollEvent.totalItemCount();
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.view.hashCode();
        int i = this.scrollState;
        return ((((((((hashCode ^ 1000003) * 1000003) ^ i) * 1000003) ^ this.firstVisibleItem) * 1000003) ^ this.visibleItemCount) * 1000003) ^ this.totalItemCount;
    }
}
