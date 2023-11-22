package com.alipay.iap.android.common.syncintegration.api;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes6.dex */
public class IAPSyncCommand implements Parcelable {
    public static final String COMMAND_FULL_UPDATE = "fullUpdate";
    public static final String COMMAND_INIT = "init";
    public static final Parcelable.Creator<IAPSyncCommand> CREATOR = new Parcelable.Creator<IAPSyncCommand>() { // from class: com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final IAPSyncCommand createFromParcel(Parcel parcel) {
            return new IAPSyncCommand(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final IAPSyncCommand[] newArray(int i) {
            return new IAPSyncCommand[i];
        }
    };
    public String biz;
    public String command;
    public String commandData;

    /* renamed from: id  reason: collision with root package name */
    public String f6942id;
    public String userId;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public IAPSyncCommand() {
    }

    protected IAPSyncCommand(Parcel parcel) {
        this.userId = parcel.readString();
        this.biz = parcel.readString();
        this.command = parcel.readString();
        this.f6942id = parcel.readString();
        this.commandData = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.userId);
        parcel.writeString(this.biz);
        parcel.writeString(this.command);
        parcel.writeString(this.f6942id);
        parcel.writeString(this.commandData);
    }
}
