package com.alibaba.griver.bluetooth.altbeacon.bluetooth;

/* loaded from: classes6.dex */
public class Pdu {
    public static final byte GATT_SERVICE_UUID_PDU_TYPE = 22;
    public static final byte MANUFACTURER_DATA_PDU_TYPE = -1;
    private static final String TAG = "Pdu";
    private byte[] mBytes;
    private int mDeclaredLength;
    private int mEndIndex;
    private int mStartIndex;
    private byte mType;

    public static Pdu parse(byte[] bArr, int i) {
        int i2;
        if (bArr.length - i >= 2 && (i2 = bArr[i]) > 0) {
            byte b = bArr[i + 1];
            int i3 = i + 2;
            if (i3 < bArr.length) {
                Pdu pdu = new Pdu();
                int i4 = i + i2;
                pdu.mEndIndex = i4;
                if (i4 >= bArr.length) {
                    pdu.mEndIndex = bArr.length - 1;
                }
                pdu.mType = b;
                pdu.mDeclaredLength = i2;
                pdu.mStartIndex = i3;
                pdu.mBytes = bArr;
                return pdu;
            }
        }
        return null;
    }

    public byte getType() {
        return this.mType;
    }

    public int getDeclaredLength() {
        return this.mDeclaredLength;
    }

    public int getActualLength() {
        return (this.mEndIndex - this.mStartIndex) + 1;
    }

    public int getStartIndex() {
        return this.mStartIndex;
    }

    public int getEndIndex() {
        return this.mEndIndex;
    }
}
