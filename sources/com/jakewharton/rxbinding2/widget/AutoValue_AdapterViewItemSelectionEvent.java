package com.jakewharton.rxbinding2.widget;

import android.view.View;
import android.widget.AdapterView;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class AutoValue_AdapterViewItemSelectionEvent extends AdapterViewItemSelectionEvent {

    /* renamed from: id  reason: collision with root package name */
    private final long f7669id;
    private final int position;
    private final View selectedView;
    private final AdapterView<?> view;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_AdapterViewItemSelectionEvent(AdapterView<?> adapterView, View view, int i, long j) {
        if (adapterView == null) {
            throw new NullPointerException("Null view");
        }
        this.view = adapterView;
        if (view == null) {
            throw new NullPointerException("Null selectedView");
        }
        this.selectedView = view;
        this.position = i;
        this.f7669id = j;
    }

    @Override // com.jakewharton.rxbinding2.widget.AdapterViewSelectionEvent
    public final AdapterView<?> view() {
        return this.view;
    }

    @Override // com.jakewharton.rxbinding2.widget.AdapterViewItemSelectionEvent
    public final View selectedView() {
        return this.selectedView;
    }

    @Override // com.jakewharton.rxbinding2.widget.AdapterViewItemSelectionEvent
    public final int position() {
        return this.position;
    }

    @Override // com.jakewharton.rxbinding2.widget.AdapterViewItemSelectionEvent
    public final long id() {
        return this.f7669id;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AdapterViewItemSelectionEvent{view=");
        sb.append(this.view);
        sb.append(", selectedView=");
        sb.append(this.selectedView);
        sb.append(", position=");
        sb.append(this.position);
        sb.append(", id=");
        sb.append(this.f7669id);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AdapterViewItemSelectionEvent) {
            AdapterViewItemSelectionEvent adapterViewItemSelectionEvent = (AdapterViewItemSelectionEvent) obj;
            return this.view.equals(adapterViewItemSelectionEvent.view()) && this.selectedView.equals(adapterViewItemSelectionEvent.selectedView()) && this.position == adapterViewItemSelectionEvent.position() && this.f7669id == adapterViewItemSelectionEvent.id();
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.view.hashCode();
        int hashCode2 = this.selectedView.hashCode();
        int i = this.position;
        long j = this.f7669id;
        return ((((((hashCode ^ 1000003) * 1000003) ^ hashCode2) * 1000003) ^ i) * 1000003) ^ ((int) ((j >>> 32) ^ j));
    }
}
