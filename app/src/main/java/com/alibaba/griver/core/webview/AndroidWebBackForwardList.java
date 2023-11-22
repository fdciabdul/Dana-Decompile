package com.alibaba.griver.core.webview;

import android.webkit.WebBackForwardList;
import com.alibaba.griver.base.api.APWebBackForwardList;
import com.alibaba.griver.base.api.APWebHistoryItem;
import com.alibaba.griver.base.nebula.DynamicProxy;

/* loaded from: classes6.dex */
public class AndroidWebBackForwardList implements APWebBackForwardList {

    /* renamed from: a  reason: collision with root package name */
    private WebBackForwardList f6484a;

    public AndroidWebBackForwardList(WebBackForwardList webBackForwardList) {
        this.f6484a = webBackForwardList;
    }

    @Override // com.alibaba.griver.base.api.APWebBackForwardList
    public int getCurrentIndex() {
        WebBackForwardList webBackForwardList = this.f6484a;
        if (webBackForwardList == null) {
            return -1;
        }
        return webBackForwardList.getCurrentIndex();
    }

    @Override // com.alibaba.griver.base.api.APWebBackForwardList
    public APWebHistoryItem getCurrentItem() {
        WebBackForwardList webBackForwardList = this.f6484a;
        if (webBackForwardList == null || webBackForwardList.getCurrentItem() == null) {
            return null;
        }
        return (APWebHistoryItem) DynamicProxy.dynamicProxy(APWebHistoryItem.class, this.f6484a.getCurrentItem());
    }

    @Override // com.alibaba.griver.base.api.APWebBackForwardList
    public APWebHistoryItem getItemAtIndex(int i) {
        WebBackForwardList webBackForwardList = this.f6484a;
        if (webBackForwardList == null || webBackForwardList.getItemAtIndex(i) == null) {
            return null;
        }
        return (APWebHistoryItem) DynamicProxy.dynamicProxy(APWebHistoryItem.class, this.f6484a.getItemAtIndex(i));
    }

    @Override // com.alibaba.griver.base.api.APWebBackForwardList
    public int getSize() {
        WebBackForwardList webBackForwardList = this.f6484a;
        if (webBackForwardList == null) {
            return 0;
        }
        return webBackForwardList.getSize();
    }

    public String toString() {
        return super.toString();
    }
}
