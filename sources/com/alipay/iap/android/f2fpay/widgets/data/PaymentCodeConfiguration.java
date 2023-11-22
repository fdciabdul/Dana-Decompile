package com.alipay.iap.android.f2fpay.widgets.data;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes6.dex */
public class PaymentCodeConfiguration implements Parcelable {
    public static final Parcelable.Creator<PaymentCodeConfiguration> CREATOR = new Parcelable.Creator<PaymentCodeConfiguration>() { // from class: com.alipay.iap.android.f2fpay.widgets.data.PaymentCodeConfiguration.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PaymentCodeConfiguration createFromParcel(Parcel parcel) {
            return new PaymentCodeConfiguration(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PaymentCodeConfiguration[] newArray(int i) {
            return new PaymentCodeConfiguration[i];
        }
    };
    public int backgroundColor;
    public int paymentCodeColor;

    public PaymentCodeConfiguration() {
        this.paymentCodeColor = -16777216;
        this.backgroundColor = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PaymentCodeConfiguration(Parcel parcel) {
        this.paymentCodeColor = -16777216;
        this.backgroundColor = 0;
        this.paymentCodeColor = parcel.readInt();
        this.backgroundColor = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.paymentCodeColor);
        parcel.writeInt(this.backgroundColor);
    }
}
