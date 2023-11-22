package com.alibaba.ariver.resource.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class TemplateConfigModel implements Parcelable, Serializable {
    public static final Parcelable.Creator<TemplateConfigModel> CREATOR = new Parcelable.Creator<TemplateConfigModel>() { // from class: com.alibaba.ariver.resource.api.models.TemplateConfigModel.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TemplateConfigModel createFromParcel(Parcel parcel) {
            return new TemplateConfigModel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TemplateConfigModel[] newArray(int i) {
            return new TemplateConfigModel[i];
        }
    };
    private static final long serialVersionUID = 1908013183340485762L;
    @JSONField
    private String appKey;
    @JSONField(name = "ext")
    private TemplateExtModel extModel;
    @JSONField(name = "extUrl")
    private String extUrl;
    @JSONField(name = RVStartParams.KEY_TEMPLATE_ID)
    private String templateId;
    @JSONField
    private String templateVersion;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public TemplateConfigModel() {
    }

    @JSONField(deserialize = false, serialize = false)
    public boolean isTemplateValid() {
        return !TextUtils.isEmpty(this.templateId);
    }

    protected TemplateConfigModel(Parcel parcel) {
        this.extUrl = parcel.readString();
        this.extModel = (TemplateExtModel) parcel.readParcelable(TemplateConfigModel.class.getClassLoader());
        this.templateId = parcel.readString();
        this.templateVersion = parcel.readString();
        this.appKey = parcel.readString();
    }

    public String getExtUrl() {
        return this.extUrl;
    }

    public void setExtUrl(String str) {
        this.extUrl = str;
    }

    public String getAppKey() {
        return this.appKey;
    }

    public void setAppKey(String str) {
        this.appKey = str;
    }

    public String getTemplateId() {
        return this.templateId;
    }

    public void setTemplateId(String str) {
        this.templateId = str;
    }

    public String getTemplateVersion() {
        return this.templateVersion;
    }

    public void setTemplateVersion(String str) {
        this.templateVersion = str;
    }

    public TemplateExtModel getExtModel() {
        return this.extModel;
    }

    public void setExtModel(TemplateExtModel templateExtModel) {
        this.extModel = templateExtModel;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.extUrl);
        parcel.writeParcelable(this.extModel, 0);
        parcel.writeString(this.templateId);
        parcel.writeString(this.templateVersion);
        parcel.writeString(this.appKey);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TemplateConfigModel{ext=");
        sb.append(this.extModel);
        sb.append(", extUrl=");
        sb.append(this.extUrl);
        sb.append(", templateId='");
        sb.append(this.templateId);
        sb.append('\'');
        sb.append(", templateVersion='");
        sb.append(this.templateVersion);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
