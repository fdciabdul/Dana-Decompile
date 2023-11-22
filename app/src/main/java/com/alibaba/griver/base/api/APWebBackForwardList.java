package com.alibaba.griver.base.api;

/* loaded from: classes6.dex */
public interface APWebBackForwardList {
    int getCurrentIndex();

    APWebHistoryItem getCurrentItem();

    APWebHistoryItem getItemAtIndex(int i);

    int getSize();
}
