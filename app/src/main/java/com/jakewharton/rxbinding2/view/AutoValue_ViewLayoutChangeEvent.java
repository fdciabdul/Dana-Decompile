package com.jakewharton.rxbinding2.view;

import android.view.View;

/* loaded from: classes8.dex */
final class AutoValue_ViewLayoutChangeEvent extends ViewLayoutChangeEvent {
    private final int bottom;
    private final int left;
    private final int oldBottom;
    private final int oldLeft;
    private final int oldRight;
    private final int oldTop;
    private final int right;
    private final int top;
    private final View view;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_ViewLayoutChangeEvent(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (view == null) {
            throw new NullPointerException("Null view");
        }
        this.view = view;
        this.left = i;
        this.top = i2;
        this.right = i3;
        this.bottom = i4;
        this.oldLeft = i5;
        this.oldTop = i6;
        this.oldRight = i7;
        this.oldBottom = i8;
    }

    @Override // com.jakewharton.rxbinding2.view.ViewLayoutChangeEvent
    public final View view() {
        return this.view;
    }

    @Override // com.jakewharton.rxbinding2.view.ViewLayoutChangeEvent
    public final int left() {
        return this.left;
    }

    @Override // com.jakewharton.rxbinding2.view.ViewLayoutChangeEvent
    public final int top() {
        return this.top;
    }

    @Override // com.jakewharton.rxbinding2.view.ViewLayoutChangeEvent
    public final int right() {
        return this.right;
    }

    @Override // com.jakewharton.rxbinding2.view.ViewLayoutChangeEvent
    public final int bottom() {
        return this.bottom;
    }

    @Override // com.jakewharton.rxbinding2.view.ViewLayoutChangeEvent
    public final int oldLeft() {
        return this.oldLeft;
    }

    @Override // com.jakewharton.rxbinding2.view.ViewLayoutChangeEvent
    public final int oldTop() {
        return this.oldTop;
    }

    @Override // com.jakewharton.rxbinding2.view.ViewLayoutChangeEvent
    public final int oldRight() {
        return this.oldRight;
    }

    @Override // com.jakewharton.rxbinding2.view.ViewLayoutChangeEvent
    public final int oldBottom() {
        return this.oldBottom;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ViewLayoutChangeEvent{view=");
        sb.append(this.view);
        sb.append(", left=");
        sb.append(this.left);
        sb.append(", top=");
        sb.append(this.top);
        sb.append(", right=");
        sb.append(this.right);
        sb.append(", bottom=");
        sb.append(this.bottom);
        sb.append(", oldLeft=");
        sb.append(this.oldLeft);
        sb.append(", oldTop=");
        sb.append(this.oldTop);
        sb.append(", oldRight=");
        sb.append(this.oldRight);
        sb.append(", oldBottom=");
        sb.append(this.oldBottom);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ViewLayoutChangeEvent) {
            ViewLayoutChangeEvent viewLayoutChangeEvent = (ViewLayoutChangeEvent) obj;
            return this.view.equals(viewLayoutChangeEvent.view()) && this.left == viewLayoutChangeEvent.left() && this.top == viewLayoutChangeEvent.top() && this.right == viewLayoutChangeEvent.right() && this.bottom == viewLayoutChangeEvent.bottom() && this.oldLeft == viewLayoutChangeEvent.oldLeft() && this.oldTop == viewLayoutChangeEvent.oldTop() && this.oldRight == viewLayoutChangeEvent.oldRight() && this.oldBottom == viewLayoutChangeEvent.oldBottom();
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.view.hashCode();
        int i = this.left;
        int i2 = this.top;
        int i3 = this.right;
        int i4 = this.bottom;
        int i5 = this.oldLeft;
        return ((((((((((((((((hashCode ^ 1000003) * 1000003) ^ i) * 1000003) ^ i2) * 1000003) ^ i3) * 1000003) ^ i4) * 1000003) ^ i5) * 1000003) ^ this.oldTop) * 1000003) ^ this.oldRight) * 1000003) ^ this.oldBottom;
    }
}
