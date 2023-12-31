package com.alibaba.ariver.kernel.ipc.uniform;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes3.dex */
public class IPCParameter implements Parcelable {
    public static final Parcelable.Creator<IPCParameter> CREATOR = new Parcelable.Creator<IPCParameter>() { // from class: com.alibaba.ariver.kernel.ipc.uniform.IPCParameter.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final IPCParameter createFromParcel(Parcel parcel) {
            return new IPCParameter(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final IPCParameter[] newArray(int i) {
            return new IPCParameter[i];
        }
    };
    public static final byte SER_TYPE_PARCELABLE = 2;
    public static final byte SER_TYPE_SERIALIZE = 1;
    public String className;
    public String methodName;
    public String[] paramTypes;
    public List<byte[]> paramValues;
    public Parcelable parcelable;
    public String returnType;
    public byte serType;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public IPCParameter() {
        this.className = "";
        this.methodName = "";
        this.serType = (byte) 1;
    }

    public IPCParameter(Parcel parcel) {
        this.className = "";
        this.methodName = "";
        readFromParcel(parcel);
    }

    public void readFromParcel(Parcel parcel) {
        try {
            this.serType = parcel.readByte();
            this.className = parcel.readString();
            this.methodName = parcel.readString();
            this.returnType = parcel.readString();
            String[] createStringArray = parcel.createStringArray();
            this.paramTypes = createStringArray;
            if (createStringArray == null || createStringArray.length == 0) {
                return;
            }
            if (this.serType == 2) {
                this.parcelable = parcel.readParcelable(getClass().getClassLoader());
                return;
            }
            this.paramValues = new ArrayList(this.paramTypes.length);
            for (int i = 0; i < this.paramTypes.length; i++) {
                this.paramValues.add(parcel.createByteArray());
            }
        } catch (Exception e) {
            RVLogger.e("IPCParameter", "readFromParcel exception occurs", e);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        try {
            parcel.writeByte(this.serType);
            parcel.writeString(this.className);
            parcel.writeString(this.methodName);
            parcel.writeString(this.returnType);
            String[] strArr = this.paramTypes;
            if (strArr == null || strArr.length == 0) {
                this.paramTypes = new String[0];
            }
            parcel.writeStringArray(this.paramTypes);
            if (this.serType == 2) {
                parcel.writeParcelable(this.parcelable, i);
                return;
            }
            for (int i2 = 0; i2 < this.paramTypes.length; i2++) {
                parcel.writeByteArray(this.paramValues.get(i2));
            }
        } catch (Exception e) {
            RVLogger.e("IPCParameter", "writeToParcel exception occurs", e);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("IPCParameter{className='");
        sb.append(this.className);
        sb.append('\'');
        sb.append(", methodName='");
        sb.append(this.methodName);
        sb.append('\'');
        sb.append(", paramTypes=");
        sb.append(Arrays.toString(this.paramTypes));
        sb.append('}');
        return sb.toString();
    }
}
