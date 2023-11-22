package com.zhuinden.simplestack;

import android.content.Context;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public class StateChange {
    public static final int BACKWARD = -1;
    public static final int FORWARD = 1;
    public static final int REPLACE = 0;
    Backstack backstack;
    int direction;
    List<Object> newKeys;
    List<Object> previousKeys;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    @interface StateChangeDirection {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public StateChange(Backstack backstack, List<Object> list, List<Object> list2, int i) {
        this.backstack = backstack;
        this.previousKeys = list;
        this.newKeys = list2;
        this.direction = i;
    }

    @Nonnull
    public Backstack getBackstack() {
        return this.backstack;
    }

    public final boolean isTopNewKeyEqualToPrevious() {
        return topNewKey().equals(topPreviousKey());
    }

    private <T> History<T> createParametricCopyList(List<Object> list) {
        LinkedList linkedList = new LinkedList();
        Iterator<Object> it = list.iterator();
        while (it.hasNext()) {
            linkedList.add(it.next());
        }
        return History.from(linkedList);
    }

    @Nonnull
    public <T> History<T> getPreviousKeys() {
        return createParametricCopyList(this.previousKeys);
    }

    @Nonnull
    public <T> History<T> getNewKeys() {
        return createParametricCopyList(this.newKeys);
    }

    public int getDirection() {
        return this.direction;
    }

    @Nullable
    public <T> T topPreviousKey() {
        if (this.previousKeys.size() > 0) {
            return (T) this.previousKeys.get(r0.size() - 1);
        }
        return null;
    }

    @Nonnull
    public <T> T topNewKey() {
        return (T) this.newKeys.get(r0.size() - 1);
    }

    @Nonnull
    public Context createContext(@Nonnull Context context, @Nonnull Object obj) {
        return new KeyContextWrapper(context, obj);
    }
}
