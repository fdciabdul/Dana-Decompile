package com.alibaba.griver.api.common.menu;

import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class GRVMPMoreMenuItem extends GriverMenuItem {

    /* renamed from: a  reason: collision with root package name */
    private List<WeakReference<GRVMPMoreMenuItemChangeListener>> f6273a = new LinkedList();
    public Map<String, ItemInfo> itemInfos;
    public boolean showBadge;
    public Map<String, ItemInfo> titleInfos;
    public String uniqueKey;

    /* loaded from: classes3.dex */
    public static class ItemInfo {
        public String iconName;
        public String iconUrl;
    }

    public void enableBadge(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(this.identifier);
        this.uniqueKey = sb.toString();
    }

    public boolean isShowBadge() {
        return !TextUtils.isEmpty(this.uniqueKey);
    }

    public void setItemInfos(Map<String, ItemInfo> map) {
        this.itemInfos = map;
    }

    public void setTitleInfos(Map<String, ItemInfo> map) {
        this.titleInfos = map;
    }

    public void notifyDataSetChanged() {
        Iterator it = new LinkedList(this.f6273a).iterator();
        while (it.hasNext()) {
            GRVMPMoreMenuItemChangeListener gRVMPMoreMenuItemChangeListener = (GRVMPMoreMenuItemChangeListener) ((WeakReference) it.next()).get();
            if (gRVMPMoreMenuItemChangeListener != null) {
                gRVMPMoreMenuItemChangeListener.onMenuItemChange(this);
            }
        }
    }

    public void addDataChangeListener(GRVMPMoreMenuItemChangeListener gRVMPMoreMenuItemChangeListener) {
        this.f6273a.add(new WeakReference<>(gRVMPMoreMenuItemChangeListener));
    }
}
