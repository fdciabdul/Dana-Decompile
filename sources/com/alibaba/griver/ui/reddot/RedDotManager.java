package com.alibaba.griver.ui.reddot;

import android.text.TextUtils;
import com.alibaba.griver.ui.reddot.model.RedDotModel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes6.dex */
public class RedDotManager implements IRedDotManager {

    /* renamed from: a  reason: collision with root package name */
    private static IRedDotManager f6744a;
    private Map<String, RedDotModel> b = new HashMap();
    private final Object c = new Object();

    private RedDotManager() {
    }

    public static IRedDotManager getInstance() {
        if (f6744a == null) {
            synchronized (RedDotManager.class) {
                if (f6744a == null) {
                    f6744a = new RedDotManager();
                }
            }
        }
        return f6744a;
    }

    @Override // com.alibaba.griver.ui.reddot.IRedDotManager
    public void registerNode(String str, String str2) {
        synchronized (this.c) {
            if (str.equals(str2)) {
                return;
            }
            if (!this.b.containsKey(str)) {
                RedDotModel redDotModel = new RedDotModel();
                this.b.put(str, redDotModel);
                if (!TextUtils.isEmpty(str2) && this.b.containsKey(str2)) {
                    redDotModel.setRedDotParentModelKey(str2);
                    this.b.get(str2).addChild(str);
                }
            }
        }
    }

    @Override // com.alibaba.griver.ui.reddot.IRedDotManager
    public void removeNode(String str) {
        synchronized (this.c) {
            if (this.b.containsKey(str)) {
                RedDotModel remove = this.b.remove(str);
                String redDotParentModelKey = remove.getRedDotParentModelKey();
                if (!TextUtils.isEmpty(redDotParentModelKey) && this.b.containsKey(redDotParentModelKey)) {
                    this.b.get(redDotParentModelKey).removeChild(str);
                }
                if (remove.childSize() != 0) {
                    Iterator<String> it = remove.getChildren().iterator();
                    while (it.hasNext()) {
                        removeNode(it.next());
                    }
                }
            }
        }
    }

    @Override // com.alibaba.griver.ui.reddot.IRedDotManager
    public void setStateDidChangeHandler(String str, OnStateChangeListener onStateChangeListener) {
        synchronized (this.c) {
            if (this.b.containsKey(str)) {
                this.b.get(str).setListener(onStateChangeListener);
            }
        }
    }

    @Override // com.alibaba.griver.ui.reddot.IRedDotManager
    public void removeStateDidChangeHandler(String str) {
        synchronized (this.c) {
            if (this.b.containsKey(str)) {
                this.b.get(str).setListener(null);
            }
        }
    }

    @Override // com.alibaba.griver.ui.reddot.IRedDotManager
    public void addParentStateDidChangeHandler(String str, OnStateChangeListener onStateChangeListener) {
        synchronized (this.c) {
            if (this.b.containsKey(str)) {
                this.b.get(str).addParentChangeListener(onStateChangeListener);
            }
        }
    }

    @Override // com.alibaba.griver.ui.reddot.IRedDotManager
    public void resetState(String str, boolean z) {
        boolean z2;
        synchronized (this.c) {
            if (this.b.containsKey(str)) {
                RedDotModel redDotModel = this.b.get(str);
                if (redDotModel == null) {
                    return;
                }
                if (redDotModel.childSize() == 0) {
                    redDotModel.setShow(z);
                } else {
                    Iterator<String> it = redDotModel.getChildren().iterator();
                    while (true) {
                        z2 = false;
                        if (!it.hasNext()) {
                            break;
                        }
                        RedDotModel redDotModel2 = this.b.get(it.next());
                        if (redDotModel2 != null && redDotModel2.isShow()) {
                            z2 = true;
                            break;
                        }
                    }
                    redDotModel.setShow(z2);
                }
                if (redDotModel.getListener() != null) {
                    redDotModel.getListener().onStateChange(str, redDotModel.isShow());
                }
                Iterator<OnStateChangeListener> it2 = redDotModel.getParentChangeListener().iterator();
                while (it2.hasNext()) {
                    it2.next().onStateChange(str, redDotModel.isShow());
                }
                if (!TextUtils.isEmpty(redDotModel.getRedDotParentModelKey())) {
                    resetState(redDotModel.getRedDotParentModelKey(), redDotModel.isShow());
                }
            }
        }
    }
}
