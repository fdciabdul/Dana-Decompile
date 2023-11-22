package androidx.core.view.accessibility;

import android.view.accessibility.AccessibilityManager;

/* loaded from: classes6.dex */
public final class AccessibilityManagerCompat {

    @Deprecated
    /* loaded from: classes6.dex */
    public interface AccessibilityStateChangeListener {
        @Deprecated
        void getAuthRequestContext(boolean z);
    }

    @Deprecated
    /* loaded from: classes6.dex */
    public static abstract class AccessibilityStateChangeListenerCompat implements AccessibilityStateChangeListener {
    }

    /* loaded from: classes6.dex */
    public interface TouchExplorationStateChangeListener {
        void getAuthRequestContext(boolean z);
    }

    /* loaded from: classes6.dex */
    static class AccessibilityStateChangeListenerWrapper implements AccessibilityManager.AccessibilityStateChangeListener {
        AccessibilityStateChangeListener PlaceComponentResult;

        public int hashCode() {
            return this.PlaceComponentResult.hashCode();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof AccessibilityStateChangeListenerWrapper) {
                return this.PlaceComponentResult.equals(((AccessibilityStateChangeListenerWrapper) obj).PlaceComponentResult);
            }
            return false;
        }

        @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
        public void onAccessibilityStateChanged(boolean z) {
            this.PlaceComponentResult.getAuthRequestContext(z);
        }
    }

    /* loaded from: classes6.dex */
    static final class TouchExplorationStateChangeListenerWrapper implements AccessibilityManager.TouchExplorationStateChangeListener {
        final TouchExplorationStateChangeListener PlaceComponentResult;

        public final int hashCode() {
            return this.PlaceComponentResult.hashCode();
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof TouchExplorationStateChangeListenerWrapper) {
                return this.PlaceComponentResult.equals(((TouchExplorationStateChangeListenerWrapper) obj).PlaceComponentResult);
            }
            return false;
        }

        @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
        public final void onTouchExplorationStateChanged(boolean z) {
            this.PlaceComponentResult.getAuthRequestContext(z);
        }
    }

    private AccessibilityManagerCompat() {
    }

    /* loaded from: classes6.dex */
    static class Api19Impl {
        private Api19Impl() {
        }
    }
}
