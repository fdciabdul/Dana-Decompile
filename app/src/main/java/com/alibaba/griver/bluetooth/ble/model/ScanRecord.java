package com.alibaba.griver.bluetooth.ble.model;

import android.util.SparseArray;
import com.alibaba.griver.bluetooth.ble.utils.BluetoothHelper;
import com.alibaba.griver.bluetooth.ble.utils.BluetoothLeUtils;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public final class ScanRecord {
    private static final int DATA_TYPE_FLAGS = 1;
    private static final int DATA_TYPE_LOCAL_NAME_COMPLETE = 9;
    private static final int DATA_TYPE_LOCAL_NAME_SHORT = 8;
    private static final int DATA_TYPE_MANUFACTURER_SPECIFIC_DATA = 255;
    private static final int DATA_TYPE_SERVICE_DATA = 22;
    private static final int DATA_TYPE_SERVICE_UUIDS_128_BIT_COMPLETE = 7;
    private static final int DATA_TYPE_SERVICE_UUIDS_128_BIT_PARTIAL = 6;
    private static final int DATA_TYPE_SERVICE_UUIDS_16_BIT_COMPLETE = 3;
    private static final int DATA_TYPE_SERVICE_UUIDS_16_BIT_PARTIAL = 2;
    private static final int DATA_TYPE_SERVICE_UUIDS_32_BIT_COMPLETE = 5;
    private static final int DATA_TYPE_SERVICE_UUIDS_32_BIT_PARTIAL = 4;
    private static final int DATA_TYPE_TX_POWER_LEVEL = 10;
    private static final String TAG = "ScanRecord";
    private final int mAdvertiseFlags;
    private final byte[] mBytes;
    private final String mDeviceName;
    private final SparseArray<byte[]> mManufacturerSpecificData;
    private final Map<String, String> mServiceData;
    private final List<String> mServiceUuids;
    private final int mTxPowerLevel;

    private ScanRecord(List<String> list, SparseArray<byte[]> sparseArray, Map<String, String> map, int i, int i2, String str, byte[] bArr) {
        this.mServiceUuids = list;
        this.mManufacturerSpecificData = sparseArray;
        this.mServiceData = map;
        this.mDeviceName = str;
        this.mAdvertiseFlags = i;
        this.mTxPowerLevel = i2;
        this.mBytes = bArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0092  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.alibaba.griver.bluetooth.ble.model.ScanRecord parseFromBytes(byte[] r14) {
        /*
            r0 = 0
            if (r14 != 0) goto L4
            return r0
        L4:
            r1 = 0
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            android.util.SparseArray r5 = new android.util.SparseArray
            r5.<init>()
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = -1
            r9 = r0
            r7 = -1
            r8 = -2147483648(0xffffffff80000000, float:-0.0)
        L1b:
            int r3 = r14.length     // Catch: java.lang.Exception -> L9b
            if (r1 >= r3) goto L8a
            int r3 = r1 + 1
            r1 = r14[r1]     // Catch: java.lang.Exception -> L9b
            r4 = 255(0xff, float:3.57E-43)
            r1 = r1 & r4
            if (r1 == 0) goto L8a
            int r1 = r1 + (-1)
            int r10 = r3 + 1
            r3 = r14[r3]     // Catch: java.lang.Exception -> L9b
            r3 = r3 & r4
            r11 = 22
            r12 = 2
            if (r3 == r11) goto L71
            if (r3 == r4) goto L5a
            switch(r3) {
                case 1: goto L55;
                case 2: goto L51;
                case 3: goto L51;
                case 4: goto L4c;
                case 5: goto L4c;
                case 6: goto L46;
                case 7: goto L46;
                case 8: goto L3c;
                case 9: goto L3c;
                case 10: goto L39;
                default: goto L38;
            }     // Catch: java.lang.Exception -> L9b
        L38:
            goto L88
        L39:
            r8 = r14[r10]     // Catch: java.lang.Exception -> L9b
            goto L88
        L3c:
            java.lang.String r9 = new java.lang.String     // Catch: java.lang.Exception -> L9b
            byte[] r3 = extractBytes(r14, r10, r1)     // Catch: java.lang.Exception -> L9b
            r9.<init>(r3)     // Catch: java.lang.Exception -> L9b
            goto L88
        L46:
            r3 = 16
            parseServiceUuid(r14, r10, r1, r3, r2)     // Catch: java.lang.Exception -> L9b
            goto L88
        L4c:
            r3 = 4
            parseServiceUuid(r14, r10, r1, r3, r2)     // Catch: java.lang.Exception -> L9b
            goto L88
        L51:
            parseServiceUuid(r14, r10, r1, r12, r2)     // Catch: java.lang.Exception -> L9b
            goto L88
        L55:
            r3 = r14[r10]     // Catch: java.lang.Exception -> L9b
            r7 = r3 & 255(0xff, float:3.57E-43)
            goto L88
        L5a:
            int r3 = r10 + 1
            r3 = r14[r3]     // Catch: java.lang.Exception -> L9b
            r11 = r14[r10]     // Catch: java.lang.Exception -> L9b
            int r12 = r10 + 2
            int r13 = r1 + (-2)
            byte[] r12 = extractBytes(r14, r12, r13)     // Catch: java.lang.Exception -> L9b
            r3 = r3 & r4
            int r3 = r3 << 8
            r4 = r4 & r11
            int r3 = r3 + r4
            r5.put(r3, r12)     // Catch: java.lang.Exception -> L9b
            goto L88
        L71:
            byte[] r3 = extractBytes(r14, r10, r12)     // Catch: java.lang.Exception -> L9b
            int r4 = r10 + 2
            int r11 = r1 + (-2)
            byte[] r4 = extractBytes(r14, r4, r11)     // Catch: java.lang.Exception -> L9b
            java.lang.String r3 = com.alibaba.griver.bluetooth.ble.utils.BluetoothHelper.bytesToHexStringInReverse(r3)     // Catch: java.lang.Exception -> L9b
            java.lang.String r4 = com.alibaba.griver.bluetooth.ble.utils.BluetoothHelper.bytesToHexString(r4)     // Catch: java.lang.Exception -> L9b
            r6.put(r3, r4)     // Catch: java.lang.Exception -> L9b
        L88:
            int r1 = r1 + r10
            goto L1b
        L8a:
            boolean r1 = r2.isEmpty()     // Catch: java.lang.Exception -> L9b
            if (r1 == 0) goto L92
            r4 = r0
            goto L93
        L92:
            r4 = r2
        L93:
            com.alibaba.griver.bluetooth.ble.model.ScanRecord r0 = new com.alibaba.griver.bluetooth.ble.model.ScanRecord     // Catch: java.lang.Exception -> L9b
            r3 = r0
            r10 = r14
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Exception -> L9b
            return r0
        L9b:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "unable to parse scan record: "
            r0.append(r1)
            java.lang.String r1 = java.util.Arrays.toString(r14)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "ScanRecord"
            com.alibaba.griver.base.common.logger.GriverLogger.e(r1, r0)
            com.alibaba.griver.bluetooth.ble.model.ScanRecord r0 = new com.alibaba.griver.bluetooth.ble.model.ScanRecord
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = -1
            r7 = -2147483648(0xffffffff80000000, float:-0.0)
            r8 = 0
            r2 = r0
            r9 = r14
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.bluetooth.ble.model.ScanRecord.parseFromBytes(byte[]):com.alibaba.griver.bluetooth.ble.model.ScanRecord");
    }

    private static int parseServiceUuid(byte[] bArr, int i, int i2, int i3, List<String> list) {
        while (i2 > 0) {
            byte[] extractBytes = extractBytes(bArr, i, i3);
            if (i3 == 2 || i3 == 4) {
                list.add(BluetoothHelper.bytesToHexStringInReverse(extractBytes));
            } else {
                list.add(BluetoothUuid.parseUuidFrom(extractBytes).toString());
            }
            i2 -= i3;
            i += i3;
        }
        return i;
    }

    private static byte[] extractBytes(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }

    public final int getAdvertiseFlags() {
        return this.mAdvertiseFlags;
    }

    public final List<String> getServiceUuids() {
        return this.mServiceUuids;
    }

    public final SparseArray<byte[]> getManufacturerSpecificData() {
        return this.mManufacturerSpecificData;
    }

    public final byte[] getManufacturerSpecificData(int i) {
        return this.mManufacturerSpecificData.get(i);
    }

    public final Map<String, String> getServiceData() {
        return this.mServiceData;
    }

    public final int getTxPowerLevel() {
        return this.mTxPowerLevel;
    }

    public final String getDeviceName() {
        return this.mDeviceName;
    }

    public final byte[] getBytes() {
        return this.mBytes;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ScanRecord [mAdvertiseFlags=");
        sb.append(this.mAdvertiseFlags);
        sb.append(", mServiceUuids=");
        sb.append(BluetoothLeUtils.toString(this.mServiceUuids));
        sb.append(", mManufacturerSpecificData=");
        sb.append(BluetoothLeUtils.toString(this.mManufacturerSpecificData));
        sb.append(", mServiceData=");
        sb.append(BluetoothLeUtils.toString(this.mServiceData));
        sb.append(", mTxPowerLevel=");
        sb.append(this.mTxPowerLevel);
        sb.append(", mDeviceName=");
        sb.append(this.mDeviceName);
        sb.append("]");
        return sb.toString();
    }
}
