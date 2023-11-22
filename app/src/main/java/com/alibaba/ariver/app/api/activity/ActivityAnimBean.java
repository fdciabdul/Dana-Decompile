package com.alibaba.ariver.app.api.activity;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class ActivityAnimBean implements Parcelable {
    public static final Parcelable.Creator<ActivityAnimBean> CREATOR = new Parcelable.Creator<ActivityAnimBean>() { // from class: com.alibaba.ariver.app.api.activity.ActivityAnimBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ActivityAnimBean createFromParcel(Parcel parcel) {
            return new ActivityAnimBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ActivityAnimBean[] newArray(int i) {
            return new ActivityAnimBean[i];
        }
    };
    public int enter;
    public int enterFast;
    public int exit;
    public int exitFast;
    public boolean needPopAnim;
    public boolean needRestartAnim;
    public int popEnter;
    public int popExit;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ActivityAnimBean() {
    }

    protected ActivityAnimBean(Parcel parcel) {
        this.enter = parcel.readInt();
        this.exit = parcel.readInt();
        this.needRestartAnim = parcel.readByte() != 0;
        this.enterFast = parcel.readInt();
        this.exitFast = parcel.readInt();
        this.needPopAnim = parcel.readByte() != 0;
        this.popEnter = parcel.readInt();
        this.popExit = parcel.readInt();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ActivityAnimBean{enter=");
        sb.append(this.enter);
        sb.append(", exit=");
        sb.append(this.exit);
        sb.append(", needPopAnim=");
        sb.append(this.needPopAnim);
        sb.append(", popEnter=");
        sb.append(this.popEnter);
        sb.append(", popExit=");
        sb.append(this.popExit);
        sb.append('}');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.enter);
        parcel.writeInt(this.exit);
        parcel.writeByte(this.needRestartAnim ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.enterFast);
        parcel.writeInt(this.exitFast);
        parcel.writeByte(this.needPopAnim ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.popEnter);
        parcel.writeInt(this.popExit);
    }
}
