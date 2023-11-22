package com.jakewharton.rxbinding2.view;

import android.view.View;

/* loaded from: classes8.dex */
final class AutoValue_ViewScrollChangeEvent extends ViewScrollChangeEvent {
    private final int oldScrollX;
    private final int oldScrollY;
    private final int scrollX;
    private final int scrollY;
    private final View view;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_ViewScrollChangeEvent(View view, int i, int i2, int i3, int i4) {
        if (view == null) {
            throw new NullPointerException("Null view");
        }
        this.view = view;
        this.scrollX = i;
        this.scrollY = i2;
        this.oldScrollX = i3;
        this.oldScrollY = i4;
    }

    @Override // com.jakewharton.rxbinding2.view.ViewScrollChangeEvent
    public final View view() {
        return this.view;
    }

    @Override // com.jakewharton.rxbinding2.view.ViewScrollChangeEvent
    public final int scrollX() {
        return this.scrollX;
    }

    @Override // com.jakewharton.rxbinding2.view.ViewScrollChangeEvent
    public final int scrollY() {
        return this.scrollY;
    }

    @Override // com.jakewharton.rxbinding2.view.ViewScrollChangeEvent
    public final int oldScrollX() {
        return this.oldScrollX;
    }

    @Override // com.jakewharton.rxbinding2.view.ViewScrollChangeEvent
    public final int oldScrollY() {
        return this.oldScrollY;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ViewScrollChangeEvent{view=");
        sb.append(this.view);
        sb.append(", scrollX=");
        sb.append(this.scrollX);
        sb.append(", scrollY=");
        sb.append(this.scrollY);
        sb.append(", oldScrollX=");
        sb.append(this.oldScrollX);
        sb.append(", oldScrollY=");
        sb.append(this.oldScrollY);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ViewScrollChangeEvent) {
            ViewScrollChangeEvent viewScrollChangeEvent = (ViewScrollChangeEvent) obj;
            return this.view.equals(viewScrollChangeEvent.view()) && this.scrollX == viewScrollChangeEvent.scrollX() && this.scrollY == viewScrollChangeEvent.scrollY() && this.oldScrollX == viewScrollChangeEvent.oldScrollX() && this.oldScrollY == viewScrollChangeEvent.oldScrollY();
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.view.hashCode();
        int i = this.scrollX;
        return ((((((((hashCode ^ 1000003) * 1000003) ^ i) * 1000003) ^ this.scrollY) * 1000003) ^ this.oldScrollX) * 1000003) ^ this.oldScrollY;
    }
}
