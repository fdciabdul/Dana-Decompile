package com.jakewharton.rxbinding2.widget;

import android.widget.RatingBar;

/* loaded from: classes8.dex */
final class AutoValue_RatingBarChangeEvent extends RatingBarChangeEvent {
    private final boolean fromUser;
    private final float rating;
    private final RatingBar view;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_RatingBarChangeEvent(RatingBar ratingBar, float f, boolean z) {
        if (ratingBar == null) {
            throw new NullPointerException("Null view");
        }
        this.view = ratingBar;
        this.rating = f;
        this.fromUser = z;
    }

    @Override // com.jakewharton.rxbinding2.widget.RatingBarChangeEvent
    public final RatingBar view() {
        return this.view;
    }

    @Override // com.jakewharton.rxbinding2.widget.RatingBarChangeEvent
    public final float rating() {
        return this.rating;
    }

    @Override // com.jakewharton.rxbinding2.widget.RatingBarChangeEvent
    public final boolean fromUser() {
        return this.fromUser;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RatingBarChangeEvent{view=");
        sb.append(this.view);
        sb.append(", rating=");
        sb.append(this.rating);
        sb.append(", fromUser=");
        sb.append(this.fromUser);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof RatingBarChangeEvent) {
            RatingBarChangeEvent ratingBarChangeEvent = (RatingBarChangeEvent) obj;
            return this.view.equals(ratingBarChangeEvent.view()) && Float.floatToIntBits(this.rating) == Float.floatToIntBits(ratingBarChangeEvent.rating()) && this.fromUser == ratingBarChangeEvent.fromUser();
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.view.hashCode();
        return ((((hashCode ^ 1000003) * 1000003) ^ Float.floatToIntBits(this.rating)) * 1000003) ^ (this.fromUser ? 1231 : 1237);
    }
}
