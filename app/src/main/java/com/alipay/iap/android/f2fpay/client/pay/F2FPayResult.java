package com.alipay.iap.android.f2fpay.client.pay;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class F2FPayResult implements Parcelable {
    public static final Parcelable.Creator<F2FPayResult> CREATOR = new Parcelable.Creator<F2FPayResult>() { // from class: com.alipay.iap.android.f2fpay.client.pay.F2FPayResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public F2FPayResult createFromParcel(Parcel parcel) {
            return new F2FPayResult(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public F2FPayResult[] newArray(int i) {
            return new F2FPayResult[i];
        }
    };
    public F2fPayOrderInfo orderInfo;
    public Object originalOrderInfo;
    public F2FPayResultStatus status;

    public F2FPayResult() {
    }

    protected F2FPayResult(Parcel parcel) {
        this.status = F2FPayResultStatus.valueOf(parcel.readString());
        this.orderInfo = (F2fPayOrderInfo) parcel.readParcelable(F2fPayOrderInfo.class.getClassLoader());
    }

    public F2FPayResult(F2FPayResultStatus f2FPayResultStatus, F2fPayOrderInfo f2fPayOrderInfo) {
        this.status = f2FPayResultStatus;
        this.orderInfo = f2fPayOrderInfo;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.status.name());
        parcel.writeParcelable(this.orderInfo, i);
    }
}
