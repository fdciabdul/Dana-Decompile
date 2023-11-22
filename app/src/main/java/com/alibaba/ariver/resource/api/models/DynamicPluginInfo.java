package com.alibaba.ariver.resource.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public class DynamicPluginInfo implements Parcelable {
    public static final Parcelable.Creator<DynamicPluginInfo> CREATOR = new Parcelable.Creator<DynamicPluginInfo>() { // from class: com.alibaba.ariver.resource.api.models.DynamicPluginInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DynamicPluginInfo createFromParcel(Parcel parcel) {
            return new DynamicPluginInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DynamicPluginInfo[] newArray(int i) {
            return new DynamicPluginInfo[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private List<PluginModel> f6210a;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public DynamicPluginInfo() {
        this.f6210a = new ArrayList();
    }

    protected DynamicPluginInfo(Parcel parcel) {
        this.f6210a = new ArrayList();
        this.f6210a = parcel.createTypedArrayList(PluginModel.CREATOR);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.f6210a);
    }

    public boolean addPlugin(PluginModel pluginModel) {
        PluginModel pluginModel2;
        if (pluginModel != null) {
            Iterator<PluginModel> it = this.f6210a.iterator();
            while (true) {
                pluginModel2 = null;
                if (!it.hasNext()) {
                    break;
                }
                pluginModel2 = it.next();
                if (TextUtils.equals(pluginModel.getAppId(), pluginModel2.getAppId()) && TextUtils.equals(pluginModel.getVersion(), pluginModel2.getVersion())) {
                    break;
                }
            }
            if (pluginModel2 != null) {
                this.f6210a.remove(pluginModel2);
            }
            return this.f6210a.add(pluginModel);
        }
        return false;
    }

    public List<PluginModel> getPluginModels() {
        return this.f6210a;
    }
}
