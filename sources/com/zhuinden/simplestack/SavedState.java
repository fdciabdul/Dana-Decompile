package com.zhuinden.simplestack;

import android.os.Parcelable;
import android.util.SparseArray;
import com.zhuinden.statebundle.StateBundle;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public class SavedState {
    private StateBundle bundle;
    private Object key;
    private StateBundle viewBundle;
    private SparseArray<Parcelable> viewHierarchyState;

    private SavedState() {
    }

    @Nonnull
    public Object getKey() {
        return this.key;
    }

    @Nonnull
    public SparseArray<Parcelable> getViewHierarchyState() {
        return this.viewHierarchyState;
    }

    public void setViewHierarchyState(SparseArray<Parcelable> sparseArray) {
        this.viewHierarchyState = sparseArray;
    }

    @Nullable
    public StateBundle getBundle() {
        return this.bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public StateBundle getViewBundle() {
        return this.viewBundle;
    }

    public void setBundle(@Nullable StateBundle stateBundle) {
        this.bundle = stateBundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setViewBundle(@Nullable StateBundle stateBundle) {
        this.viewBundle = stateBundle;
    }

    public static Builder builder() {
        return new Builder();
    }

    /* loaded from: classes2.dex */
    public static class Builder {
        private Object key;
        private StateBundle viewBundle;
        private SparseArray<Parcelable> viewHierarchyState = new SparseArray<>();
        private StateBundle bundle = new StateBundle();

        Builder() {
        }

        public Builder setKey(@Nonnull Object obj) {
            if (obj == null) {
                throw new IllegalArgumentException("Key cannot be null");
            }
            this.key = obj;
            return this;
        }

        public Builder setViewHierarchyState(@Nonnull SparseArray<Parcelable> sparseArray) {
            if (sparseArray == null) {
                throw new IllegalArgumentException("Provided sparse array for view hierarchy state cannot be null");
            }
            this.viewHierarchyState = sparseArray;
            return this;
        }

        public Builder setBundle(@Nullable StateBundle stateBundle) {
            this.bundle = stateBundle;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder setViewBundle(@Nullable StateBundle stateBundle) {
            this.viewBundle = stateBundle;
            return this;
        }

        public SavedState build() {
            if (this.key == null) {
                throw new IllegalStateException("You cannot create a SavedState without associating a Key with it.");
            }
            SavedState savedState = new SavedState();
            savedState.key = this.key;
            savedState.viewHierarchyState = this.viewHierarchyState;
            savedState.bundle = this.bundle;
            savedState.viewBundle = this.viewBundle;
            return savedState;
        }
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof SavedState)) {
            return ((SavedState) obj).getKey().equals(this.key);
        }
        return false;
    }

    public int hashCode() {
        return this.key.hashCode();
    }
}
