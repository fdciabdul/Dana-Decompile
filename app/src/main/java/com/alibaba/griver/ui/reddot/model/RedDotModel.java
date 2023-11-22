package com.alibaba.griver.ui.reddot.model;

import com.alibaba.griver.ui.reddot.OnStateChangeListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/* loaded from: classes6.dex */
public class RedDotModel {

    /* renamed from: a  reason: collision with root package name */
    private String f6745a;
    private boolean c;
    private OnStateChangeListener d;
    private Set<String> b = new HashSet();
    private List<WeakReference<OnStateChangeListener>> e = new LinkedList();

    public boolean isShow() {
        return this.c;
    }

    public void setShow(boolean z) {
        this.c = z;
    }

    public String getRedDotParentModelKey() {
        return this.f6745a;
    }

    public void setRedDotParentModelKey(String str) {
        this.f6745a = str;
    }

    public void addChild(String str) {
        this.b.add(str);
    }

    public boolean removeChild(String str) {
        return this.b.remove(str);
    }

    public int childSize() {
        return this.b.size();
    }

    public Set<String> getChildren() {
        return this.b;
    }

    public OnStateChangeListener getListener() {
        return this.d;
    }

    public void setListener(OnStateChangeListener onStateChangeListener) {
        this.d = onStateChangeListener;
    }

    public List<OnStateChangeListener> getParentChangeListener() {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList();
            Iterator<WeakReference<OnStateChangeListener>> it = this.e.iterator();
            while (it.hasNext()) {
                OnStateChangeListener onStateChangeListener = it.next().get();
                if (onStateChangeListener != null) {
                    arrayList.add(onStateChangeListener);
                }
            }
        }
        return arrayList;
    }

    public void addParentChangeListener(OnStateChangeListener onStateChangeListener) {
        synchronized (this) {
            if (onStateChangeListener != null) {
                this.e.add(new WeakReference<>(onStateChangeListener));
            }
        }
    }
}
