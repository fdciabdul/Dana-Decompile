package com.alibaba.griver.ui.popmenu;

import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes6.dex */
public class TinyAppActionStateController {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f6725a = {TinyAppActionState.ACTION_BLUE_TOOTH, "location", TinyAppActionState.ACTION_RECORD};
    private final Object d = new Object();
    private final List<WeakReference<TinyAppActionStateListener>> b = new ArrayList();
    private final List<TinyAppActionState> c = new LinkedList();

    public void setStateOn(String str, String str2) {
        a(str, str2, 1);
    }

    public void setStateOff(String str, String str2) {
        a(str, str2, 0);
    }

    public void removeAction(String str) {
        synchronized (this.d) {
            Iterator<TinyAppActionState> it = this.c.iterator();
            while (it.hasNext()) {
                TinyAppActionState next = it.next();
                if (next != null && TextUtils.equals(str, next.getAction())) {
                    it.remove();
                }
            }
        }
        a();
    }

    private void a(String str, String str2, int i) {
        TinyAppActionState tinyAppActionState;
        if (a(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append("setStateInner action[");
            sb.append(str);
            sb.append("] type[");
            sb.append(str2);
            sb.append("] state ");
            sb.append(i);
            RVLogger.d("TinyAppActionStateContr", sb.toString());
            synchronized (this.d) {
                int i2 = 0;
                while (true) {
                    tinyAppActionState = null;
                    if (i2 >= this.c.size()) {
                        break;
                    }
                    tinyAppActionState = this.c.get(i2);
                    if (TextUtils.equals(tinyAppActionState.getAction(), str)) {
                        break;
                    }
                    i2++;
                }
                if (i == 1) {
                    if (tinyAppActionState == null) {
                        i2 = this.c.size();
                        tinyAppActionState = b(str);
                        this.c.add(tinyAppActionState);
                    }
                    a(tinyAppActionState, i2, str2);
                } else if (i == 0) {
                    a(tinyAppActionState, str2);
                }
            }
        }
    }

    private void a(TinyAppActionState tinyAppActionState, int i, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("handleStateIncreaseCount before action ");
        sb.append(tinyAppActionState.getAction());
        sb.append(" count ");
        sb.append(tinyAppActionState.getCount());
        sb.append(" type ");
        sb.append(str);
        RVLogger.d("TinyAppActionStateContr", sb.toString());
        tinyAppActionState.increaseCount(str);
        if (i != 0) {
            List<TinyAppActionState> list = this.c;
            list.add(0, list.remove(i));
        }
        if (tinyAppActionState.getCount() == 1) {
            a();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("handleStateIncreaseCount after action ");
        sb2.append(tinyAppActionState.getAction());
        sb2.append(" count ");
        sb2.append(tinyAppActionState.getCount());
        sb2.append(" type ");
        sb2.append(str);
        RVLogger.d("TinyAppActionStateContr", sb2.toString());
    }

    private void a(TinyAppActionState tinyAppActionState, String str) {
        if (tinyAppActionState == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("handleStateDecreaseCount before action ");
        sb.append(tinyAppActionState.getAction());
        sb.append(" count ");
        sb.append(tinyAppActionState.getCount());
        sb.append(" type ");
        sb.append(str);
        RVLogger.d("TinyAppActionStateContr", sb.toString());
        if (tinyAppActionState.getCount() <= 0) {
            return;
        }
        tinyAppActionState.decreaseCount(str);
        if (tinyAppActionState.getCount() == 0) {
            this.c.remove(tinyAppActionState);
            a();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("handleStateDecreaseCount after action ");
        sb2.append(tinyAppActionState.getAction());
        sb2.append(" count ");
        sb2.append(tinyAppActionState.getCount());
        sb2.append(" type ");
        sb2.append(str);
        RVLogger.d("TinyAppActionStateContr", sb2.toString());
    }

    private boolean a(String str) {
        for (String str2 : f6725a) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public void registerListener(TinyAppActionStateListener tinyAppActionStateListener) {
        synchronized (this) {
            if (tinyAppActionStateListener != null) {
                this.b.add(new WeakReference<>(tinyAppActionStateListener));
                tinyAppActionStateListener.onStateChanged(getCurrentState());
            }
        }
    }

    private void a() {
        synchronized (this) {
            Iterator<WeakReference<TinyAppActionStateListener>> it = this.b.iterator();
            TinyAppActionState currentState = getCurrentState();
            StringBuilder sb = new StringBuilder();
            sb.append("notifyStateChanged  currentState: ");
            sb.append(currentState);
            RVLogger.d("TinyAppActionStateContr", sb.toString());
            while (it.hasNext()) {
                TinyAppActionStateListener tinyAppActionStateListener = it.next().get();
                if (tinyAppActionStateListener != null) {
                    tinyAppActionStateListener.onStateChanged(currentState);
                } else {
                    it.remove();
                }
            }
        }
    }

    public TinyAppActionState getCurrentState() {
        if (this.c.size() > 0) {
            return this.c.get(0);
        }
        return null;
    }

    public void destroy() {
        this.c.clear();
        this.b.clear();
    }

    private TinyAppActionState b(String str) {
        char c;
        int hashCode = str.hashCode();
        if (hashCode == -934908847) {
            if (str.equals(TinyAppActionState.ACTION_RECORD)) {
                c = 2;
            }
            c = 65535;
        } else if (hashCode != 1901043637) {
            if (hashCode == 1968882350 && str.equals(TinyAppActionState.ACTION_BLUE_TOOTH)) {
                c = 0;
            }
            c = 65535;
        } else {
            if (str.equals("location")) {
                c = 1;
            }
            c = 65535;
        }
        if (c == 0) {
            return new TinyAppActionState(str, false);
        }
        return new TinyAppActionState(str, true);
    }
}
