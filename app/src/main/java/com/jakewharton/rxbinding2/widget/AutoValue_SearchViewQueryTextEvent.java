package com.jakewharton.rxbinding2.widget;

import android.widget.SearchView;

/* loaded from: classes8.dex */
final class AutoValue_SearchViewQueryTextEvent extends SearchViewQueryTextEvent {
    private final boolean isSubmitted;
    private final CharSequence queryText;
    private final SearchView view;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_SearchViewQueryTextEvent(SearchView searchView, CharSequence charSequence, boolean z) {
        if (searchView == null) {
            throw new NullPointerException("Null view");
        }
        this.view = searchView;
        if (charSequence == null) {
            throw new NullPointerException("Null queryText");
        }
        this.queryText = charSequence;
        this.isSubmitted = z;
    }

    @Override // com.jakewharton.rxbinding2.widget.SearchViewQueryTextEvent
    public final SearchView view() {
        return this.view;
    }

    @Override // com.jakewharton.rxbinding2.widget.SearchViewQueryTextEvent
    public final CharSequence queryText() {
        return this.queryText;
    }

    @Override // com.jakewharton.rxbinding2.widget.SearchViewQueryTextEvent
    public final boolean isSubmitted() {
        return this.isSubmitted;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SearchViewQueryTextEvent{view=");
        sb.append(this.view);
        sb.append(", queryText=");
        sb.append((Object) this.queryText);
        sb.append(", isSubmitted=");
        sb.append(this.isSubmitted);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SearchViewQueryTextEvent) {
            SearchViewQueryTextEvent searchViewQueryTextEvent = (SearchViewQueryTextEvent) obj;
            return this.view.equals(searchViewQueryTextEvent.view()) && this.queryText.equals(searchViewQueryTextEvent.queryText()) && this.isSubmitted == searchViewQueryTextEvent.isSubmitted();
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.view.hashCode();
        return ((((hashCode ^ 1000003) * 1000003) ^ this.queryText.hashCode()) * 1000003) ^ (this.isSubmitted ? 1231 : 1237);
    }
}
