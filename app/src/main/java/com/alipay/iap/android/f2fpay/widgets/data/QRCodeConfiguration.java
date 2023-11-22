package com.alipay.iap.android.f2fpay.widgets.data;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes6.dex */
public class QRCodeConfiguration extends PaymentCodeConfiguration {
    public static final Parcelable.Creator<QRCodeConfiguration> CREATOR = new Parcelable.Creator<QRCodeConfiguration>() { // from class: com.alipay.iap.android.f2fpay.widgets.data.QRCodeConfiguration.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public QRCodeConfiguration createFromParcel(Parcel parcel) {
            return new QRCodeConfiguration(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public QRCodeConfiguration[] newArray(int i) {
            return new QRCodeConfiguration[i];
        }
    };
    public Bitmap logo;
    public boolean showMargin;

    public QRCodeConfiguration() {
        this.showMargin = true;
    }

    protected QRCodeConfiguration(Parcel parcel) {
        super(parcel);
        this.showMargin = true;
        this.logo = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
        this.showMargin = parcel.readByte() != 0;
    }

    @Override // com.alipay.iap.android.f2fpay.widgets.data.PaymentCodeConfiguration, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.logo, i);
        parcel.writeByte(this.showMargin ? (byte) 1 : (byte) 0);
    }
}
