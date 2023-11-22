package io.split.android.client.impressions;

import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public interface ImpressionListener {

    /* loaded from: classes9.dex */
    public static final class NoopImpressionListener implements ImpressionListener {
        @Override // io.split.android.client.impressions.ImpressionListener
        public final void close() {
        }

        @Override // io.split.android.client.impressions.ImpressionListener
        public final void log(Impression impression) {
        }
    }

    void close();

    void log(Impression impression);

    /* loaded from: classes6.dex */
    public static final class FederatedImpressionListener implements ImpressionListener {
        private List<ImpressionListener> _delegates;

        public FederatedImpressionListener(List<ImpressionListener> list) {
            this._delegates = list;
        }

        @Override // io.split.android.client.impressions.ImpressionListener
        public final void log(Impression impression) {
            Iterator<ImpressionListener> it = this._delegates.iterator();
            while (it.hasNext()) {
                it.next().log(impression);
            }
        }

        @Override // io.split.android.client.impressions.ImpressionListener
        public final void close() {
            Iterator<ImpressionListener> it = this._delegates.iterator();
            while (it.hasNext()) {
                it.next().close();
            }
        }
    }
}
