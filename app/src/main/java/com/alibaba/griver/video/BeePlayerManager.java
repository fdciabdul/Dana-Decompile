package com.alibaba.griver.video;

import android.content.Context;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.video.BeeVideoPlayerViewWrapper;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes6.dex */
public class BeePlayerManager {
    private static volatile BeePlayerManager b;

    /* renamed from: a  reason: collision with root package name */
    private final ConcurrentHashMap<String, BeeVideoPlayerViewWrapper> f6780a = new ConcurrentHashMap<>();

    public static String generateKey(String str) {
        return str == null ? "" : str;
    }

    public static BeePlayerManager getInstance() {
        if (b == null) {
            synchronized (BeePlayerManager.class) {
                if (b == null) {
                    b = new BeePlayerManager();
                }
            }
        }
        return b;
    }

    private BeePlayerManager() {
    }

    public BeeVideoPlayerViewWrapper createView(Context context, String str, String str2, BeeVideoPlayerViewWrapper.IEventListener iEventListener, boolean z) {
        synchronized (this) {
            StringBuilder sb = new StringBuilder();
            sb.append("createView start, viewId=");
            sb.append(str);
            sb.append(", size=");
            sb.append(this.f6780a.size());
            GriverLogger.d("BeePlayerManager", sb.toString());
            if (this.f6780a.containsKey(str)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("createView finished, already exist, viewId=");
                sb2.append(str);
                GriverLogger.d("BeePlayerManager", sb2.toString());
                return this.f6780a.get(str);
            } else if (this.f6780a.size() >= 5) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("createView error, reach max instance, maxPlayerInstance");
                sb3.append(5);
                sb3.append(", currentSize=");
                sb3.append(this.f6780a.size());
                GriverLogger.e("BeePlayerManager", sb3.toString());
                return null;
            } else {
                BeeVideoPlayerViewWrapper beeVideoPlayerViewWrapper = new BeeVideoPlayerViewWrapper(context, str2, z);
                beeVideoPlayerViewWrapper.setEventListener(iEventListener);
                this.f6780a.put(str, beeVideoPlayerViewWrapper);
                StringBuilder sb4 = new StringBuilder();
                sb4.append("createView finished, viewId=");
                sb4.append(str);
                sb4.append(", size=");
                sb4.append(this.f6780a.size());
                sb4.append(", player=");
                sb4.append(beeVideoPlayerViewWrapper.hashCode());
                GriverLogger.d("BeePlayerManager", sb4.toString());
                return beeVideoPlayerViewWrapper;
            }
        }
    }

    public void destroyView(String str) {
        synchronized (this) {
            synchronized (this) {
                StringBuilder sb = new StringBuilder();
                sb.append("destroyView start, key=");
                sb.append(str);
                sb.append(", size=");
                sb.append(this.f6780a.size());
                GriverLogger.d("BeePlayerManager", sb.toString());
                if (this.f6780a.containsKey(str)) {
                    BeeVideoPlayerViewWrapper beeVideoPlayerViewWrapper = this.f6780a.get(str);
                    this.f6780a.remove(str);
                    if (beeVideoPlayerViewWrapper != null) {
                        beeVideoPlayerViewWrapper.destroyPlay();
                    }
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("destroyView finished, key=");
                sb2.append(str);
                sb2.append(", size=");
                sb2.append(this.f6780a.size());
                GriverLogger.d("BeePlayerManager", sb2.toString());
            }
        }
    }

    public boolean exitFullScreen() {
        synchronized (this) {
            Iterator<Map.Entry<String, BeeVideoPlayerViewWrapper>> it = this.f6780a.entrySet().iterator();
            while (it.hasNext()) {
                BeeVideoPlayerViewWrapper value = it.next().getValue();
                if (value != null && value.mIsFullScreen) {
                    value.exitFullScreen();
                    return true;
                }
            }
            return false;
        }
    }
}
