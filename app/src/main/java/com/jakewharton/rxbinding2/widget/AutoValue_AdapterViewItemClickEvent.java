package com.jakewharton.rxbinding2.widget;

import android.view.View;
import android.widget.AdapterView;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class AutoValue_AdapterViewItemClickEvent extends AdapterViewItemClickEvent {
    private final View clickedView;

    /* renamed from: id  reason: collision with root package name */
    private final long f7667id;
    private final int position;
    private final AdapterView<?> view;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_AdapterViewItemClickEvent(AdapterView<?> adapterView, View view, int i, long j) {
        if (adapterView == null) {
            throw new NullPointerException("Null view");
        }
        this.view = adapterView;
        if (view == null) {
            throw new NullPointerException("Null clickedView");
        }
        this.clickedView = view;
        this.position = i;
        this.f7667id = j;
    }

    @Override // com.jakewharton.rxbinding2.widget.AdapterViewItemClickEvent
    public final AdapterView<?> view() {
        return this.view;
    }

    @Override // com.jakewharton.rxbinding2.widget.AdapterViewItemClickEvent
    public final View clickedView() {
        return this.clickedView;
    }

    @Override // com.jakewharton.rxbinding2.widget.AdapterViewItemClickEvent
    public final int position() {
        return this.position;
    }

    @Override // com.jakewharton.rxbinding2.widget.AdapterViewItemClickEvent
    public final long id() {
        return this.f7667id;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AdapterViewItemClickEvent{view=");
        sb.append(this.view);
        sb.append(", clickedView=");
        sb.append(this.clickedView);
        sb.append(", position=");
        sb.append(this.position);
        sb.append(", id=");
        sb.append(this.f7667id);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AdapterViewItemClickEvent) {
            AdapterViewItemClickEvent adapterViewItemClickEvent = (AdapterViewItemClickEvent) obj;
            return this.view.equals(adapterViewItemClickEvent.view()) && this.clickedView.equals(adapterViewItemClickEvent.clickedView()) && this.position == adapterViewItemClickEvent.position() && this.f7667id == adapterViewItemClickEvent.id();
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.view.hashCode();
        int hashCode2 = this.clickedView.hashCode();
        int i = this.position;
        long j = this.f7667id;
        return ((((((hashCode ^ 1000003) * 1000003) ^ hashCode2) * 1000003) ^ i) * 1000003) ^ ((int) ((j >>> 32) ^ j));
    }
}
