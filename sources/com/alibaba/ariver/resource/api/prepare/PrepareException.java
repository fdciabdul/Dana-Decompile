package com.alibaba.ariver.resource.api.prepare;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes6.dex */
public class PrepareException extends Exception implements Parcelable {
    public static final Parcelable.Creator<PrepareException> CREATOR = new Parcelable.Creator<PrepareException>() { // from class: com.alibaba.ariver.resource.api.prepare.PrepareException.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PrepareException createFromParcel(Parcel parcel) {
            return new PrepareException(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PrepareException[] newArray(int i) {
            return new PrepareException[i];
        }
    };
    public static final String ERROR_APPX_CHECK_FAILED = "7";
    public static final String ERROR_AUTH_FAIL = "8";
    public static final String ERROR_DOWNLOAD_EXCEPTION = "4";
    public static final String ERROR_NO_APPINFO = "1";
    public static final String ERROR_NO_URL = "6";
    public static final String ERROR_OFFLINE_APP = "9";
    public static final String ERROR_RPC_EXCEPTION = "2";
    public static final String ERROR_TIMEOUT = "3";
    public static final String ERROR_UNKNOWN = "0";
    public static final String ERROR_UNZIP_EXCEPTION = "5";
    private String code;
    private boolean needShowFail;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PrepareException(String str) {
        this("0", str, null);
    }

    public PrepareException(String str, String str2) {
        this(str, str2, null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public PrepareException(String str, String str2, Throwable th) {
        super(str2, th);
        char c;
        this.code = str;
        str.hashCode();
        switch (str.hashCode()) {
            case 50:
                if (str.equals("2")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 51:
                if (str.equals("3")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 52:
                if (str.equals("4")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 53:
                if (str.equals("5")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        if (c == 0 || c == 1 || c == 2 || c == 3) {
            this.needShowFail = true;
        }
    }

    protected PrepareException(Parcel parcel) {
        this.code = parcel.readString();
    }

    public String getCode() {
        return this.code;
    }

    public boolean isNeedShowFail() {
        return this.needShowFail;
    }

    public void setNeedShowFail(boolean z) {
        this.needShowFail = z;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.code);
    }
}
