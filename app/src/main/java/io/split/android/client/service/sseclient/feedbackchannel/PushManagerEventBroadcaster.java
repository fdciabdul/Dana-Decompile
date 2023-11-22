package io.split.android.client.service.sseclient.feedbackchannel;

import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes6.dex */
public class PushManagerEventBroadcaster {
    private final List<WeakReference<BroadcastedEventListener>> mListeners = new CopyOnWriteArrayList();

    public void pushMessage(PushStatusEvent pushStatusEvent) {
        Iterator<WeakReference<BroadcastedEventListener>> it = this.mListeners.iterator();
        while (it.hasNext()) {
            BroadcastedEventListener broadcastedEventListener = it.next().get();
            if (broadcastedEventListener != null) {
                broadcastedEventListener.onEvent(pushStatusEvent);
            }
        }
    }

    public void register(BroadcastedEventListener broadcastedEventListener) {
        this.mListeners.add(new WeakReference<>(broadcastedEventListener));
    }

    public void close() {
        this.mListeners.clear();
    }
}
