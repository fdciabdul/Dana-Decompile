package com.alibaba.ariver.resource.api.appinfo;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Map;

/* loaded from: classes3.dex */
public class UpdateAppException extends RuntimeException implements Parcelable {
    public static final Parcelable.Creator<UpdateAppException> CREATOR = new Parcelable.Creator<UpdateAppException>() { // from class: com.alibaba.ariver.resource.api.appinfo.UpdateAppException.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final UpdateAppException createFromParcel(Parcel parcel) {
            return new UpdateAppException(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final UpdateAppException[] newArray(int i) {
            return new UpdateAppException[i];
        }
    };
    public static final String ERROR_NO_APPINFO = "1";
    public static final String ERROR_OFFLINE_APP = "2";
    public static final String ERROR_UNKNOWN = "0";
    private String code;
    private Map<String, String> extras;
    private boolean needShowError;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public UpdateAppException(String str, String str2) {
        this(str, str2, null);
    }

    public UpdateAppException(String str, String str2, Map<String, String> map) {
        super(str2);
        this.needShowError = true;
        this.code = str;
        this.extras = map;
    }

    protected UpdateAppException(Parcel parcel) {
        this.extras = null;
        this.needShowError = true;
        this.code = parcel.readString();
        if (parcel.readByte() == 1) {
            parcel.readMap(this.extras, UpdateAppException.class.getClassLoader());
        }
        this.needShowError = parcel.readByte() == 1;
    }

    public boolean isNeedShowError() {
        return this.needShowError;
    }

    public void setNeedShowError(boolean z) {
        this.needShowError = z;
    }

    public String getCode() {
        return this.code;
    }

    public Map<String, String> getExtras() {
        return this.extras;
    }

    public UpdateAppException(Throwable th) {
        super(th);
        this.extras = null;
        this.needShowError = true;
        this.code = "0";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.code);
        int i2 = this.extras != null ? 1 : 0;
        parcel.writeByte((byte) i2);
        if (i2 != 0) {
            parcel.writeMap(this.extras);
        }
        parcel.writeByte(this.needShowError ? (byte) 1 : (byte) 0);
    }
}
