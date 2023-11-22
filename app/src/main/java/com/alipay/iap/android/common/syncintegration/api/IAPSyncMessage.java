package com.alipay.iap.android.common.syncintegration.api;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class IAPSyncMessage implements Parcelable {
    public static final Parcelable.Creator<IAPSyncMessage> CREATOR = new Parcelable.Creator<IAPSyncMessage>() { // from class: com.alipay.iap.android.common.syncintegration.api.IAPSyncMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final IAPSyncMessage createFromParcel(Parcel parcel) {
            return new IAPSyncMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final IAPSyncMessage[] newArray(int i) {
            return new IAPSyncMessage[i];
        }
    };
    public String biz;
    public boolean hasMore;
    public String messageId;
    public String msgData;
    public String userId;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public IAPSyncMessage() {
    }

    protected IAPSyncMessage(Parcel parcel) {
        this.biz = parcel.readString();
        this.hasMore = parcel.readByte() != 0;
        this.messageId = parcel.readString();
        this.msgData = parcel.readString();
        this.userId = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.biz);
        parcel.writeByte(this.hasMore ? (byte) 1 : (byte) 0);
        parcel.writeString(this.messageId);
        parcel.writeString(this.msgData);
        parcel.writeString(this.userId);
    }
}
