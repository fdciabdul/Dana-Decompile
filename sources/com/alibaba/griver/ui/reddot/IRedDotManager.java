package com.alibaba.griver.ui.reddot;

/* loaded from: classes6.dex */
public interface IRedDotManager {
    void addParentStateDidChangeHandler(String str, OnStateChangeListener onStateChangeListener);

    void registerNode(String str, String str2);

    void removeNode(String str);

    void removeStateDidChangeHandler(String str);

    void resetState(String str, boolean z);

    void setStateDidChangeHandler(String str, OnStateChangeListener onStateChangeListener);
}
