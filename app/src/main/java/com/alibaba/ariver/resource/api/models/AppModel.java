package com.alibaba.ariver.resource.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.ariver.resource.api.RVResourceUtils;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import id.dana.data.constant.BranchLinkConstant;
import java.io.Serializable;
import java.util.Comparator;

/* loaded from: classes2.dex */
public class AppModel implements Parcelable, Serializable {
    @JSONField(serialize = false)
    public static final Comparator<AppModel> COMPARATOR = new Comparator<AppModel>() { // from class: com.alibaba.ariver.resource.api.models.AppModel.1
        @Override // java.util.Comparator
        public final int compare(AppModel appModel, AppModel appModel2) {
            if (appModel == null) {
                return appModel2 == null ? 0 : -1;
            } else if (appModel2 == null) {
                return 1;
            } else {
                return RVResourceUtils.compareVersion(appModel.getAppVersion(), appModel2.getAppVersion());
            }
        }
    };
    public static final Parcelable.Creator<AppModel> CREATOR = new Parcelable.Creator<AppModel>() { // from class: com.alibaba.ariver.resource.api.models.AppModel.2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AppModel createFromParcel(Parcel parcel) {
            return new AppModel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AppModel[] newArray(int i) {
            return new AppModel[i];
        }
    };
    private static final long serialVersionUID = 435160091756780155L;
    @JSONField(serialize = false)
    private String appId;
    @JSONField(name = "appInfo")
    private AppInfoModel appInfoModel;
    @JSONField(serialize = false)
    private String appVersion;
    @JSONField(name = BranchLinkConstant.PathTarget.CONTAINER)
    private ContainerModel containerInfo;
    @JSONField(name = "extendInfo")
    private JSONObject extendInfos;
    @JSONField(name = "permission")
    private PermissionModel permissionModel;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public AppModel() {
    }

    protected AppModel(Parcel parcel) {
        this.appId = parcel.readString();
        this.appVersion = parcel.readString();
        this.appInfoModel = (AppInfoModel) parcel.readParcelable(AppModel.class.getClassLoader());
        this.containerInfo = (ContainerModel) parcel.readParcelable(AppModel.class.getClassLoader());
        this.extendInfos = (JSONObject) parcel.readSerializable();
        this.permissionModel = (PermissionModel) parcel.readParcelable(AppModel.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeString(this.appVersion);
        parcel.writeParcelable(this.appInfoModel, 0);
        parcel.writeParcelable(this.containerInfo, 0);
        parcel.writeSerializable(this.extendInfos);
        parcel.writeParcelable(this.permissionModel, 0);
    }

    public AppInfoModel getAppInfoModel() {
        return this.appInfoModel;
    }

    public void setAppInfoModel(AppInfoModel appInfoModel) {
        this.appInfoModel = appInfoModel;
        this.appId = appInfoModel.getAppId();
        this.appVersion = appInfoModel.getVersion();
    }

    public ContainerModel getContainerInfo() {
        return this.containerInfo;
    }

    public void setContainerInfo(ContainerModel containerModel) {
        this.containerInfo = containerModel;
    }

    public JSONObject getExtendInfos() {
        return this.extendInfos;
    }

    public void setExtendInfos(JSONObject jSONObject) {
        this.extendInfos = jSONObject;
    }

    public PermissionModel getPermissionModel() {
        return this.permissionModel;
    }

    public void setPermissionModel(PermissionModel permissionModel) {
        this.permissionModel = permissionModel;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AppModel{appId='");
        sb.append(this.appId);
        sb.append('\'');
        sb.append(", appVersion='");
        sb.append(this.appVersion);
        sb.append('\'');
        sb.append(", appInfoModel=");
        sb.append(this.appInfoModel);
        sb.append(", containerInfo=");
        sb.append(this.containerInfo);
        sb.append(", extendInfos=");
        sb.append(this.extendInfos);
        sb.append('}');
        return sb.toString();
    }
}
