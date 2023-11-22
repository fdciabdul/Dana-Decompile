package com.alibaba.griver.bluetooth.altbeacon.beacon;

import android.bluetooth.BluetoothDevice;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.bluetooth.altbeacon.beacon.logging.LogManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes6.dex */
public class BeaconParser implements Serializable {
    public static final String ALTBEACON_LAYOUT = "m:2-3=beac,i:4-19,i:20-21,i:22-23,p:24-24,d:25-25";
    public static final String EDDYSTONE_TLM_LAYOUT = "x,s:0-1=feaa,m:2-2=20,d:3-3,d:4-5,d:6-7,d:8-11,d:12-15";
    public static final String EDDYSTONE_UID_LAYOUT = "s:0-1=feaa,m:2-2=00,p:3-3:-41,i:4-13,i:14-19";
    public static final String EDDYSTONE_URL_LAYOUT = "s:0-1=feaa,m:2-2=10,p:3-3:-41,i:4-21v";
    private static final String LITTLE_ENDIAN_SUFFIX = "l";
    private static final String TAG = "BeaconParser";
    public static final String URI_BEACON_LAYOUT = "s:0-1=fed8,m:2-2=00,p:3-3:-41,i:4-21v";
    private static final String VARIABLE_LENGTH_SUFFIX = "v";
    protected String mBeaconLayout;
    protected Integer mDBmCorrection;
    protected Boolean mExtraFrame;
    protected String mIdentifier;
    protected Integer mLayoutSize;
    private Long mMatchingBeaconTypeCode;
    protected Integer mMatchingBeaconTypeCodeEndOffset;
    protected Integer mMatchingBeaconTypeCodeStartOffset;
    protected Integer mPowerEndOffset;
    protected Integer mPowerStartOffset;
    protected Long mServiceUuid;
    protected Integer mServiceUuidEndOffset;
    protected Integer mServiceUuidStartOffset;
    private static final Pattern I_PATTERN = Pattern.compile("i\\:(\\d+)\\-(\\d+)([blv]*)?");
    private static final Pattern M_PATTERN = Pattern.compile("m\\:(\\d+)-(\\d+)\\=([0-9A-Fa-f]+)");
    private static final Pattern S_PATTERN = Pattern.compile("s\\:(\\d+)-(\\d+)\\=([0-9A-Fa-f]+)");
    private static final Pattern D_PATTERN = Pattern.compile("d\\:(\\d+)\\-(\\d+)([bl]*)?");
    private static final Pattern P_PATTERN = Pattern.compile("p\\:(\\d+)\\-(\\d+)\\:?([\\-\\d]+)?");
    private static final Pattern X_PATTERN = Pattern.compile("x");
    private static final char[] HEX_ARRAY = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    protected final List<Integer> mIdentifierStartOffsets = new ArrayList();
    protected final List<Integer> mIdentifierEndOffsets = new ArrayList();
    protected final List<Boolean> mIdentifierLittleEndianFlags = new ArrayList();
    protected final List<Integer> mDataStartOffsets = new ArrayList();
    protected final List<Integer> mDataEndOffsets = new ArrayList();
    protected final List<Boolean> mDataLittleEndianFlags = new ArrayList();
    protected final List<Boolean> mIdentifierVariableLengthFlags = new ArrayList();
    protected Boolean mAllowPduOverflow = Boolean.TRUE;
    protected int[] mHardwareAssistManufacturers = {76};
    protected List<BeaconParser> extraParsers = new ArrayList();

    public BeaconParser() {
    }

    public BeaconParser(String str) {
        this.mIdentifier = str;
    }

    protected static String bytesToHex(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            int i3 = i * 2;
            char[] cArr2 = HEX_ARRAY;
            cArr[i3] = cArr2[i2 >>> 4];
            cArr[i3 + 1] = cArr2[i2 & 15];
        }
        return new String(cArr);
    }

    public static byte[] longToByteArray(long j, int i) {
        return longToByteArray(j, i, true);
    }

    public static byte[] longToByteArray(long j, int i, boolean z) {
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = ((i - (z ? i2 : (i - i2) - 1)) - 1) * 8;
            bArr[i2] = (byte) (((255 << i3) & j) >> i3);
        }
        return bArr;
    }

    public BeaconParser setBeaconLayout(String str) {
        this.mBeaconLayout = str;
        StringBuilder sb = new StringBuilder();
        sb.append("Parsing beacon layout: ");
        sb.append(str);
        GriverLogger.d(TAG, sb.toString());
        String[] split = str.split(",");
        this.mExtraFrame = Boolean.FALSE;
        for (String str2 : split) {
            Matcher matcher = I_PATTERN.matcher(str2);
            boolean z = false;
            while (matcher.find()) {
                try {
                    int parseInt = Integer.parseInt(matcher.group(1));
                    int parseInt2 = Integer.parseInt(matcher.group(2));
                    this.mIdentifierLittleEndianFlags.add(Boolean.valueOf(matcher.group(3).contains(LITTLE_ENDIAN_SUFFIX)));
                    this.mIdentifierVariableLengthFlags.add(Boolean.valueOf(matcher.group(3).contains("v")));
                    this.mIdentifierStartOffsets.add(Integer.valueOf(parseInt));
                    this.mIdentifierEndOffsets.add(Integer.valueOf(parseInt2));
                    z = true;
                } catch (NumberFormatException unused) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Cannot parse integer byte offset in term: ");
                    sb2.append(str2);
                    throw new BeaconLayoutException(sb2.toString());
                }
            }
            Matcher matcher2 = D_PATTERN.matcher(str2);
            while (matcher2.find()) {
                try {
                    int parseInt3 = Integer.parseInt(matcher2.group(1));
                    int parseInt4 = Integer.parseInt(matcher2.group(2));
                    this.mDataLittleEndianFlags.add(Boolean.valueOf(matcher2.group(3).contains(LITTLE_ENDIAN_SUFFIX)));
                    this.mDataStartOffsets.add(Integer.valueOf(parseInt3));
                    this.mDataEndOffsets.add(Integer.valueOf(parseInt4));
                    z = true;
                } catch (NumberFormatException unused2) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Cannot parse integer byte offset in term: ");
                    sb3.append(str2);
                    throw new BeaconLayoutException(sb3.toString());
                }
            }
            Matcher matcher3 = P_PATTERN.matcher(str2);
            while (matcher3.find()) {
                try {
                    int parseInt5 = Integer.parseInt(matcher3.group(1));
                    int parseInt6 = Integer.parseInt(matcher3.group(2));
                    this.mDBmCorrection = Integer.valueOf(matcher3.group(3) != null ? Integer.parseInt(matcher3.group(3)) : 0);
                    this.mPowerStartOffset = Integer.valueOf(parseInt5);
                    this.mPowerEndOffset = Integer.valueOf(parseInt6);
                    z = true;
                } catch (NumberFormatException unused3) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("Cannot parse integer power byte offset in term: ");
                    sb4.append(str2);
                    throw new BeaconLayoutException(sb4.toString());
                }
            }
            Matcher matcher4 = M_PATTERN.matcher(str2);
            while (matcher4.find()) {
                try {
                    int parseInt7 = Integer.parseInt(matcher4.group(1));
                    int parseInt8 = Integer.parseInt(matcher4.group(2));
                    this.mMatchingBeaconTypeCodeStartOffset = Integer.valueOf(parseInt7);
                    this.mMatchingBeaconTypeCodeEndOffset = Integer.valueOf(parseInt8);
                    String group = matcher4.group(3);
                    try {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("0x");
                        sb5.append(group);
                        this.mMatchingBeaconTypeCode = Long.decode(sb5.toString());
                        z = true;
                    } catch (NumberFormatException unused4) {
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("Cannot parse beacon type code: ");
                        sb6.append(group);
                        sb6.append(" in term: ");
                        sb6.append(str2);
                        throw new BeaconLayoutException(sb6.toString());
                    }
                } catch (NumberFormatException unused5) {
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append("Cannot parse integer byte offset in term: ");
                    sb7.append(str2);
                    throw new BeaconLayoutException(sb7.toString());
                }
            }
            Matcher matcher5 = S_PATTERN.matcher(str2);
            while (matcher5.find()) {
                try {
                    int parseInt9 = Integer.parseInt(matcher5.group(1));
                    int parseInt10 = Integer.parseInt(matcher5.group(2));
                    this.mServiceUuidStartOffset = Integer.valueOf(parseInt9);
                    this.mServiceUuidEndOffset = Integer.valueOf(parseInt10);
                    String group2 = matcher5.group(3);
                    try {
                        StringBuilder sb8 = new StringBuilder();
                        sb8.append("0x");
                        sb8.append(group2);
                        this.mServiceUuid = Long.decode(sb8.toString());
                        z = true;
                    } catch (NumberFormatException unused6) {
                        StringBuilder sb9 = new StringBuilder();
                        sb9.append("Cannot parse serviceUuid: ");
                        sb9.append(group2);
                        sb9.append(" in term: ");
                        sb9.append(str2);
                        throw new BeaconLayoutException(sb9.toString());
                    }
                } catch (NumberFormatException unused7) {
                    StringBuilder sb10 = new StringBuilder();
                    sb10.append("Cannot parse integer byte offset in term: ");
                    sb10.append(str2);
                    throw new BeaconLayoutException(sb10.toString());
                }
            }
            Matcher matcher6 = X_PATTERN.matcher(str2);
            while (matcher6.find()) {
                this.mExtraFrame = Boolean.TRUE;
                z = true;
            }
            if (!z) {
                LogManager.d(TAG, "cannot parse term %s", str2);
                StringBuilder sb11 = new StringBuilder();
                sb11.append("Cannot parse beacon layout term: ");
                sb11.append(str2);
                throw new BeaconLayoutException(sb11.toString());
            }
        }
        if (!this.mExtraFrame.booleanValue()) {
            if (this.mIdentifierStartOffsets.size() == 0 || this.mIdentifierEndOffsets.size() == 0) {
                throw new BeaconLayoutException("You must supply at least one identifier offset with a prefix of 'i'");
            }
            if (this.mPowerStartOffset == null || this.mPowerEndOffset == null) {
                throw new BeaconLayoutException("You must supply a power byte offset with a prefix of 'p'");
            }
        }
        if (this.mMatchingBeaconTypeCodeStartOffset == null || this.mMatchingBeaconTypeCodeEndOffset == null) {
            throw new BeaconLayoutException("You must supply a matching beacon type expression with a prefix of 'm'");
        }
        this.mLayoutSize = Integer.valueOf(calculateLayoutSize());
        return this;
    }

    public boolean addExtraDataParser(BeaconParser beaconParser) {
        return beaconParser != null && beaconParser.mExtraFrame.booleanValue() && this.extraParsers.add(beaconParser);
    }

    public List<BeaconParser> getExtraDataParsers() {
        return new ArrayList(this.extraParsers);
    }

    public String getIdentifier() {
        return this.mIdentifier;
    }

    public int[] getHardwareAssistManufacturers() {
        return this.mHardwareAssistManufacturers;
    }

    public void setHardwareAssistManufacturerCodes(int[] iArr) {
        this.mHardwareAssistManufacturers = iArr;
    }

    public void setAllowPduOverflow(Boolean bool) {
        this.mAllowPduOverflow = bool;
    }

    public Long getMatchingBeaconTypeCode() {
        return this.mMatchingBeaconTypeCode;
    }

    public BeaconParser setMatchingBeaconTypeCode(Long l) {
        this.mMatchingBeaconTypeCode = l;
        return this;
    }

    public int getMatchingBeaconTypeCodeStartOffset() {
        return this.mMatchingBeaconTypeCodeStartOffset.intValue();
    }

    public int getMatchingBeaconTypeCodeEndOffset() {
        return this.mMatchingBeaconTypeCodeEndOffset.intValue();
    }

    public Long getServiceUuid() {
        return this.mServiceUuid;
    }

    public int getMServiceUuidStartOffset() {
        return this.mServiceUuidStartOffset.intValue();
    }

    public int getServiceUuidEndOffset() {
        return this.mServiceUuidEndOffset.intValue();
    }

    public Beacon fromScanData(byte[] bArr, int i, BluetoothDevice bluetoothDevice) {
        return fromScanData(bArr, i, bluetoothDevice, new Beacon());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:112:0x03a5 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x03a7  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.alibaba.griver.bluetooth.altbeacon.beacon.Beacon fromScanData(byte[] r19, int r20, android.bluetooth.BluetoothDevice r21, com.alibaba.griver.bluetooth.altbeacon.beacon.Beacon r22) {
        /*
            Method dump skipped, instructions count: 1041
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.bluetooth.altbeacon.beacon.BeaconParser.fromScanData(byte[], int, android.bluetooth.BluetoothDevice, com.alibaba.griver.bluetooth.altbeacon.beacon.Beacon):com.alibaba.griver.bluetooth.altbeacon.beacon.Beacon");
    }

    public byte[] getBeaconAdvertisementData(Beacon beacon) {
        if (beacon.getIdentifiers().size() != getIdentifierCount()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Beacon has ");
            sb.append(beacon.getIdentifiers().size());
            sb.append(" identifiers but format requires ");
            sb.append(getIdentifierCount());
            throw new IllegalArgumentException(sb.toString());
        }
        Integer num = this.mMatchingBeaconTypeCodeEndOffset;
        int i = -1;
        if (num != null && num.intValue() >= 0) {
            i = this.mMatchingBeaconTypeCodeEndOffset.intValue();
        }
        Integer num2 = this.mPowerEndOffset;
        if (num2 != null && num2.intValue() > i) {
            i = this.mPowerEndOffset.intValue();
        }
        for (int i2 = 0; i2 < this.mIdentifierEndOffsets.size(); i2++) {
            if (this.mIdentifierEndOffsets.get(i2) != null && this.mIdentifierEndOffsets.get(i2).intValue() > i) {
                i = this.mIdentifierEndOffsets.get(i2).intValue();
            }
        }
        for (int i3 = 0; i3 < this.mDataEndOffsets.size(); i3++) {
            if (this.mDataEndOffsets.get(i3) != null && this.mDataEndOffsets.get(i3).intValue() > i) {
                i = this.mDataEndOffsets.get(i3).intValue();
            }
        }
        int i4 = 0;
        for (int i5 = 0; i5 < this.mIdentifierStartOffsets.size(); i5++) {
            if (this.mIdentifierVariableLengthFlags.get(i5).booleanValue()) {
                i4 = (i4 + beacon.getIdentifier(i5).getByteCount()) - ((this.mIdentifierEndOffsets.get(i5).intValue() - this.mIdentifierStartOffsets.get(i5).intValue()) + 1);
            }
        }
        byte[] bArr = new byte[((i + i4) + 1) - 2];
        getMatchingBeaconTypeCode();
        for (int intValue = this.mMatchingBeaconTypeCodeStartOffset.intValue(); intValue <= this.mMatchingBeaconTypeCodeEndOffset.intValue(); intValue++) {
            bArr[intValue - 2] = (byte) (255 & (getMatchingBeaconTypeCode().longValue() >> ((this.mMatchingBeaconTypeCodeEndOffset.intValue() - intValue) * 8)));
        }
        for (int i6 = 0; i6 < this.mIdentifierStartOffsets.size(); i6++) {
            byte[] byteArrayOfSpecifiedEndianness = beacon.getIdentifier(i6).toByteArrayOfSpecifiedEndianness(!this.mIdentifierLittleEndianFlags.get(i6).booleanValue());
            if (byteArrayOfSpecifiedEndianness.length < getIdentifierByteCount(i6)) {
                if (!this.mIdentifierVariableLengthFlags.get(i6).booleanValue()) {
                    if (this.mIdentifierLittleEndianFlags.get(i6).booleanValue()) {
                        byteArrayOfSpecifiedEndianness = Arrays.copyOf(byteArrayOfSpecifiedEndianness, getIdentifierByteCount(i6));
                    } else {
                        byte[] bArr2 = new byte[getIdentifierByteCount(i6)];
                        System.arraycopy(byteArrayOfSpecifiedEndianness, 0, bArr2, getIdentifierByteCount(i6) - byteArrayOfSpecifiedEndianness.length, byteArrayOfSpecifiedEndianness.length);
                        byteArrayOfSpecifiedEndianness = bArr2;
                    }
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Expanded identifier because it is too short.  It is now: ");
                sb2.append(byteArrayToString(byteArrayOfSpecifiedEndianness));
                LogManager.d(TAG, sb2.toString(), new Object[0]);
            } else if (byteArrayOfSpecifiedEndianness.length > getIdentifierByteCount(i6)) {
                if (this.mIdentifierLittleEndianFlags.get(i6).booleanValue()) {
                    byteArrayOfSpecifiedEndianness = Arrays.copyOfRange(byteArrayOfSpecifiedEndianness, getIdentifierByteCount(i6) - byteArrayOfSpecifiedEndianness.length, getIdentifierByteCount(i6));
                } else {
                    byteArrayOfSpecifiedEndianness = Arrays.copyOf(byteArrayOfSpecifiedEndianness, getIdentifierByteCount(i6));
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Truncated identifier because it is too long.  It is now: ");
                sb3.append(byteArrayToString(byteArrayOfSpecifiedEndianness));
                LogManager.d(TAG, sb3.toString(), new Object[0]);
            } else {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Identifier size is just right: ");
                sb4.append(byteArrayToString(byteArrayOfSpecifiedEndianness));
                LogManager.d(TAG, sb4.toString(), new Object[0]);
            }
            for (int intValue2 = this.mIdentifierStartOffsets.get(i6).intValue(); intValue2 <= (this.mIdentifierStartOffsets.get(i6).intValue() + byteArrayOfSpecifiedEndianness.length) - 1; intValue2++) {
                bArr[intValue2 - 2] = byteArrayOfSpecifiedEndianness[intValue2 - this.mIdentifierStartOffsets.get(i6).intValue()];
            }
        }
        Integer num3 = this.mPowerStartOffset;
        if (num3 != null && this.mPowerEndOffset != null) {
            for (int intValue3 = num3.intValue(); intValue3 <= this.mPowerEndOffset.intValue(); intValue3++) {
                bArr[intValue3 - 2] = (byte) ((beacon.getTxPower() >> ((intValue3 - this.mPowerStartOffset.intValue()) * 8)) & 255);
            }
        }
        for (int i7 = 0; i7 < this.mDataStartOffsets.size(); i7++) {
            long longValue = beacon.getDataFields().get(i7).longValue();
            int intValue4 = this.mDataEndOffsets.get(i7).intValue() - this.mDataStartOffsets.get(i7).intValue();
            for (int i8 = 0; i8 <= intValue4; i8++) {
                bArr[(this.mDataStartOffsets.get(i7).intValue() - 2) + (!this.mDataLittleEndianFlags.get(i7).booleanValue() ? intValue4 - i8 : i8)] = (byte) ((longValue >> (i8 * 8)) & 255);
            }
        }
        return bArr;
    }

    public int getIdentifierByteCount(int i) {
        return (this.mIdentifierEndOffsets.get(i).intValue() - this.mIdentifierStartOffsets.get(i).intValue()) + 1;
    }

    public int getIdentifierCount() {
        return this.mIdentifierStartOffsets.size();
    }

    public int getDataFieldCount() {
        return this.mDataStartOffsets.size();
    }

    public String getLayout() {
        return this.mBeaconLayout;
    }

    public int getPowerCorrection() {
        return this.mDBmCorrection.intValue();
    }

    private int calculateLayoutSize() {
        List<Integer> list = this.mIdentifierEndOffsets;
        int i = 0;
        if (list != null) {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                if (intValue > i) {
                    i = intValue;
                }
            }
        }
        List<Integer> list2 = this.mDataEndOffsets;
        if (list2 != null) {
            Iterator<Integer> it2 = list2.iterator();
            while (it2.hasNext()) {
                int intValue2 = it2.next().intValue();
                if (intValue2 > i) {
                    i = intValue2;
                }
            }
        }
        Integer num = this.mPowerEndOffset;
        if (num != null && num.intValue() > i) {
            i = this.mPowerEndOffset.intValue();
        }
        Integer num2 = this.mServiceUuidEndOffset;
        if (num2 != null && num2.intValue() > i) {
            i = this.mServiceUuidEndOffset.intValue();
        }
        return i + 1;
    }

    private boolean byteArraysMatch(byte[] bArr, int i, byte[] bArr2) {
        int length = bArr2.length;
        if (bArr.length - i < length) {
            return false;
        }
        for (int i2 = 0; i2 < length; i2++) {
            if (bArr[i + i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    private String byteArrayToString(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            sb.append(String.format("%02x", Byte.valueOf(b)));
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    private String byteArrayToFormattedString(byte[] bArr, int i, int i2, boolean z) {
        int i3 = i2 - i;
        int i4 = i3 + 1;
        byte[] bArr2 = new byte[i4];
        if (z) {
            for (int i5 = 0; i5 <= i3; i5++) {
                bArr2[i5] = bArr[((i + i4) - 1) - i5];
            }
        } else {
            for (int i6 = 0; i6 <= i3; i6++) {
                bArr2[i6] = bArr[i + i6];
            }
        }
        if (i4 < 5) {
            long j = 0;
            for (int i7 = 0; i7 < i4; i7++) {
                long j2 = bArr2[(i4 - i7) - 1] & 255;
                double d = i7;
                Double.isNaN(d);
                j += j2 * ((long) Math.pow(256.0d, d * 1.0d));
            }
            return Long.toString(j);
        }
        String bytesToHex = bytesToHex(bArr2);
        if (i4 == 16) {
            StringBuilder sb = new StringBuilder();
            sb.append(bytesToHex.substring(0, 8));
            sb.append("-");
            sb.append(bytesToHex.substring(8, 12));
            sb.append("-");
            sb.append(bytesToHex.substring(12, 16));
            sb.append("-");
            sb.append(bytesToHex.substring(16, 20));
            sb.append("-");
            sb.append(bytesToHex.substring(20, 32));
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("0x");
        sb2.append(bytesToHex);
        return sb2.toString();
    }

    private byte[] ensureMaxSize(byte[] bArr, int i) {
        return bArr.length >= i ? bArr : Arrays.copyOf(bArr, i);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.mMatchingBeaconTypeCode, this.mIdentifierStartOffsets, this.mIdentifierEndOffsets, this.mIdentifierLittleEndianFlags, this.mDataStartOffsets, this.mDataEndOffsets, this.mDataLittleEndianFlags, this.mIdentifierVariableLengthFlags, this.mMatchingBeaconTypeCodeStartOffset, this.mMatchingBeaconTypeCodeEndOffset, this.mServiceUuidStartOffset, this.mServiceUuidEndOffset, this.mServiceUuid, this.mExtraFrame, this.mPowerStartOffset, this.mPowerEndOffset, this.mDBmCorrection, this.mLayoutSize, this.mAllowPduOverflow, this.mIdentifier, this.mHardwareAssistManufacturers, this.extraParsers});
    }

    public boolean equals(Object obj) {
        String str;
        try {
            BeaconParser beaconParser = (BeaconParser) obj;
            String str2 = beaconParser.mBeaconLayout;
            if (str2 == null || !str2.equals(this.mBeaconLayout) || (str = beaconParser.mIdentifier) == null) {
                return false;
            }
            return str.equals(this.mIdentifier);
        } catch (ClassCastException unused) {
            return false;
        }
    }

    /* loaded from: classes6.dex */
    public static class BeaconLayoutException extends RuntimeException {
        public BeaconLayoutException(String str) {
            super(str);
        }
    }
}
