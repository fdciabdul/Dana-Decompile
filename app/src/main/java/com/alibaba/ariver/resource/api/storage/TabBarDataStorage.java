package com.alibaba.ariver.resource.api.storage;

import com.alibaba.ariver.app.api.ui.tabbar.model.TabBarModel;

/* loaded from: classes2.dex */
public class TabBarDataStorage {

    /* renamed from: a  reason: collision with root package name */
    private TabBarModel f6220a;
    private Listener b = null;

    /* loaded from: classes3.dex */
    public interface Listener {
        void onGetData(TabBarModel tabBarModel);
    }

    public boolean hasData() {
        boolean z;
        synchronized (this) {
            z = this.f6220a != null;
        }
        return z;
    }

    public void onGetData(TabBarModel tabBarModel) {
        synchronized (this) {
            this.f6220a = tabBarModel;
            Listener listener = this.b;
            if (listener != null) {
                listener.onGetData(tabBarModel);
                this.b = null;
            }
        }
    }

    public void retrieveData(Listener listener) {
        synchronized (this) {
            TabBarModel tabBarModel = this.f6220a;
            if (tabBarModel != null) {
                listener.onGetData(tabBarModel);
            } else {
                this.b = listener;
            }
        }
    }
}
