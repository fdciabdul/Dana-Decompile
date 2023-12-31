package com.alipay.mobile.rome.longlinkservice.syncmodel;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class SyncMessage implements Parcelable {
    public static final Parcelable.Creator<SyncMessage> CREATOR = new Parcelable.Creator<SyncMessage>() { // from class: com.alipay.mobile.rome.longlinkservice.syncmodel.SyncMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SyncMessage createFromParcel(Parcel parcel) {
            return new SyncMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SyncMessage[] newArray(int i) {
            return new SyncMessage[i];
        }
    };
    public String biz;
    public boolean hasMore;

    /* renamed from: id  reason: collision with root package name */
    public String f7210id;
    public String msgData;
    public String pushData;
    public int sOpcode;
    public String userId;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public SyncMessage() {
    }

    public SyncMessage clone(SyncMessage syncMessage) {
        if (syncMessage == null) {
            return null;
        }
        SyncMessage syncMessage2 = new SyncMessage();
        syncMessage2.f7210id = syncMessage.f7210id;
        syncMessage2.biz = syncMessage.biz;
        syncMessage2.hasMore = syncMessage.hasMore;
        syncMessage2.msgData = syncMessage.msgData;
        syncMessage2.pushData = syncMessage.pushData;
        syncMessage2.sOpcode = syncMessage.sOpcode;
        syncMessage2.userId = syncMessage.userId;
        return syncMessage2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SyncMessage [userId=");
        sb.append(this.userId);
        sb.append(", biz=");
        sb.append(this.biz);
        sb.append(", msgData=");
        sb.append(this.msgData);
        sb.append(", pushData=");
        sb.append(this.pushData);
        sb.append(", id=");
        sb.append(this.f7210id);
        sb.append(", hasMore=");
        sb.append(this.hasMore);
        sb.append("], sOpcode=");
        sb.append(this.sOpcode);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.userId);
        parcel.writeString(this.biz);
        parcel.writeString(this.msgData);
        parcel.writeString(this.pushData);
        parcel.writeInt(this.sOpcode);
        parcel.writeString(this.f7210id);
        if (this.hasMore) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
        }
    }

    private SyncMessage(Parcel parcel) {
        this.userId = parcel.readString();
        this.biz = parcel.readString();
        this.msgData = parcel.readString();
        this.pushData = parcel.readString();
        this.sOpcode = parcel.readInt();
        this.f7210id = parcel.readString();
        if (parcel.readInt() == 0) {
            this.hasMore = false;
        } else {
            this.hasMore = true;
        }
    }
}
