package com.alipay.iap.android.f2fpay.widgets.data;

import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes6.dex */
public class BarCodeConfiguration extends PaymentCodeConfiguration {
    public static final Parcelable.Creator<BarCodeConfiguration> CREATOR = new Parcelable.Creator<BarCodeConfiguration>() { // from class: com.alipay.iap.android.f2fpay.widgets.data.BarCodeConfiguration.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BarCodeConfiguration createFromParcel(Parcel parcel) {
            return new BarCodeConfiguration(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BarCodeConfiguration[] newArray(int i) {
            return new BarCodeConfiguration[i];
        }
    };
    public int gapBetweenBarcodeAndNumber;
    public int groupGap;
    public int hintColor;
    public boolean isDisplayTextOfPaymentCode;
    public int perGroupLengthOfText;
    public int textColor;
    public int textSize;
    public Typeface textTypeface;

    public BarCodeConfiguration() {
        this.hintColor = -592136;
        this.textTypeface = Typeface.DEFAULT_BOLD;
        this.isDisplayTextOfPaymentCode = true;
        this.perGroupLengthOfText = 4;
        this.textColor = -16185079;
    }

    protected BarCodeConfiguration(Parcel parcel) {
        super(parcel);
        this.hintColor = -592136;
        this.textTypeface = Typeface.DEFAULT_BOLD;
        this.isDisplayTextOfPaymentCode = true;
        this.perGroupLengthOfText = 4;
        this.textColor = -16185079;
        this.hintColor = parcel.readInt();
        this.isDisplayTextOfPaymentCode = parcel.readByte() != 0;
        this.gapBetweenBarcodeAndNumber = parcel.readInt();
        this.perGroupLengthOfText = parcel.readInt();
        this.groupGap = parcel.readInt();
        this.textSize = parcel.readInt();
        this.textColor = parcel.readInt();
    }

    @Override // com.alipay.iap.android.f2fpay.widgets.data.PaymentCodeConfiguration, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.hintColor);
        parcel.writeByte(this.isDisplayTextOfPaymentCode ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.gapBetweenBarcodeAndNumber);
        parcel.writeInt(this.perGroupLengthOfText);
        parcel.writeInt(this.groupGap);
        parcel.writeInt(this.textSize);
        parcel.writeInt(this.textColor);
    }
}
