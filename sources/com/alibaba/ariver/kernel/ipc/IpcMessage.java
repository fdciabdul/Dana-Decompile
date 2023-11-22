package com.alibaba.ariver.kernel.ipc;

import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.alibaba.exthub.common.ExtHubLogger;

/* loaded from: classes3.dex */
public class IpcMessage implements Parcelable {
    public static final Parcelable.Creator<IpcMessage> CREATOR = new Parcelable.Creator<IpcMessage>() { // from class: com.alibaba.ariver.kernel.ipc.IpcMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final IpcMessage createFromParcel(Parcel parcel) {
            return new IpcMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final IpcMessage[] newArray(int i) {
            return new IpcMessage[i];
        }
    };
    public String biz;
    public Message bizMsg;
    public String clientId;
    public int lpid;
    public int pid;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public static byte[] marshall(IpcMessage ipcMessage) {
        Parcel obtain = Parcel.obtain();
        try {
            try {
                obtain.writeValue(ipcMessage);
                return obtain.marshall();
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("IpcMsg marshall error ");
                sb.append(Log.getStackTraceString(e));
                ExtHubLogger.e("Ariver", sb.toString());
                obtain.recycle();
                return null;
            }
        } finally {
            obtain.recycle();
        }
    }

    public static IpcMessage unmarshall(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            obtain.unmarshall(bArr, 0, bArr.length);
            obtain.setDataPosition(0);
            return (IpcMessage) obtain.readValue(IpcMessage.class.getClassLoader());
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("IpcMsg unmarshall error ");
            sb.append(Log.getStackTraceString(e));
            ExtHubLogger.e("Ariver", sb.toString());
            return null;
        } finally {
            obtain.recycle();
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.pid);
        parcel.writeInt(this.lpid);
        parcel.writeString(this.clientId);
        parcel.writeString(this.biz);
        parcel.writeParcelable(this.bizMsg, i);
    }

    public IpcMessage() {
    }

    protected IpcMessage(Parcel parcel) {
        this.pid = parcel.readInt();
        this.lpid = parcel.readInt();
        this.clientId = parcel.readString();
        this.biz = parcel.readString();
        this.bizMsg = (Message) parcel.readParcelable(Message.class.getClassLoader());
    }
}
