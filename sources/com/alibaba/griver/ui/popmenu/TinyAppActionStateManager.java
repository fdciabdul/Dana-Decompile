package com.alibaba.griver.ui.popmenu;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.Page;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class TinyAppActionStateManager {

    /* renamed from: a  reason: collision with root package name */
    private Map<Integer, TinyAppActionStateController> f6726a;

    private TinyAppActionStateManager() {
        this.f6726a = new ConcurrentHashMap();
    }

    public static TinyAppActionStateManager getInstance() {
        return Holder.f6727a;
    }

    public void registerStateListener(Page page, TinyAppActionStateListener tinyAppActionStateListener) {
        if (tinyAppActionStateListener == null || page == null) {
            return;
        }
        TinyAppActionStateController tinyAppActionStateController = this.f6726a.get(Integer.valueOf(page.getPageId()));
        if (tinyAppActionStateController == null) {
            tinyAppActionStateController = new TinyAppActionStateController();
            this.f6726a.put(Integer.valueOf(page.getPageId()), tinyAppActionStateController);
        }
        tinyAppActionStateController.registerListener(tinyAppActionStateListener);
    }

    public void setActionOn(Page page, String str) {
        setActionOn(page, str, "");
    }

    public void setActionOff(Page page, String str) {
        setActionOff(page, str, "");
    }

    public void setActionOn(Page page, String str, String str2) {
        TinyAppActionStateController tinyAppActionStateController;
        if (page == null || TextUtils.isEmpty(str) || (tinyAppActionStateController = this.f6726a.get(Integer.valueOf(page.getPageId()))) == null) {
            return;
        }
        tinyAppActionStateController.setStateOn(str, str2);
    }

    public void removeAction(Page page, String str) {
        TinyAppActionStateController tinyAppActionStateController;
        if (page == null || TextUtils.isEmpty(str) || (tinyAppActionStateController = this.f6726a.get(Integer.valueOf(page.getPageId()))) == null) {
            return;
        }
        tinyAppActionStateController.removeAction(str);
    }

    public void setActionOff(Page page, String str, String str2) {
        TinyAppActionStateController tinyAppActionStateController;
        if (page == null || TextUtils.isEmpty(str) || (tinyAppActionStateController = this.f6726a.get(Integer.valueOf(page.getPageId()))) == null) {
            return;
        }
        tinyAppActionStateController.setStateOff(str, str2);
    }

    public TinyAppActionState getCurrentState(Page page) {
        TinyAppActionStateController tinyAppActionStateController;
        if (page == null || (tinyAppActionStateController = this.f6726a.get(Integer.valueOf(page.getPageId()))) == null) {
            return null;
        }
        return tinyAppActionStateController.getCurrentState();
    }

    public void destroy(Page page) {
        TinyAppActionStateController remove;
        if (page == null || (remove = this.f6726a.remove(Integer.valueOf(page.getPageId()))) == null) {
            return;
        }
        remove.destroy();
    }

    /* loaded from: classes6.dex */
    static class Holder {

        /* renamed from: a  reason: collision with root package name */
        private static TinyAppActionStateManager f6727a = new TinyAppActionStateManager();

        private Holder() {
        }
    }
}
