package com.alibaba.griver.bluetooth.ble.utils;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.location.LocationManager;
import android.os.Build;
import com.alibaba.griver.bluetooth.ble.model.BluetoothState;
import com.alibaba.griver.bluetooth.ble.model.BluetoothUuid;
import java.util.UUID;

/* loaded from: classes6.dex */
public class BluetoothHelper {
    public static boolean isSupportBLE(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    }

    public static boolean supportAdvertise() {
        BluetoothAdapter defaultAdapter;
        return Build.VERSION.SDK_INT >= 21 && (defaultAdapter = BluetoothAdapter.getDefaultAdapter()) != null && defaultAdapter.getBluetoothLeAdvertiser() != null && defaultAdapter.isMultipleAdvertisementSupported();
    }

    public static BluetoothState getBluetoothState() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null) {
            return BluetoothState.UNKNOWN;
        }
        int state = defaultAdapter.getState();
        if (state == 12) {
            return BluetoothState.ON;
        }
        if (state == 11) {
            return BluetoothState.RESETTING;
        }
        return BluetoothState.OFF;
    }

    public static boolean openBluetooth() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter != null) {
            return defaultAdapter.enable();
        }
        return false;
    }

    public static boolean closeBluetooth() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter != null) {
            return defaultAdapter.disable();
        }
        return false;
    }

    public static String bytesToHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder("");
        if (bArr == null || bArr.length <= 0) {
            return "";
        }
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString.toUpperCase());
        }
        return sb.toString();
    }

    public static String bytesToHexStringInReverse(byte[] bArr) {
        return bytesToHexString(littleToBig(bArr));
    }

    public static byte[] hexStringToBytes(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        String upperCase = str.toUpperCase();
        if (upperCase.startsWith("0X") || upperCase.startsWith("0x")) {
            upperCase = upperCase.substring(2);
        }
        int length = upperCase.length() / 2;
        char[] charArray = upperCase.toCharArray();
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) (charToByte(charArray[i2 + 1]) | (charToByte(charArray[i2]) << 4));
        }
        return bArr;
    }

    public static byte[] hexStringToBytesInReverse(String str) {
        return littleToBig(hexStringToBytes(str));
    }

    private static byte[] littleToBig(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        for (int length = bArr.length - 1; length >= 0; length--) {
            bArr2[length] = bArr[(bArr.length - 1) - length];
        }
        return bArr2;
    }

    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }

    public static String getManufacturerData(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        int i = 0;
        while (i < bArr.length) {
            try {
                int i2 = i + 1;
                int i3 = bArr[i] & 255;
                if (i3 == 0) {
                    break;
                }
                int i4 = i3 - 1;
                int i5 = i2 + 1;
                if ((bArr[i2] & 255) == 255) {
                    return bytesToHexString(extractBytes(bArr, i5, i4));
                }
                i = i4 + i5;
            } catch (Exception unused) {
            }
        }
        return "";
    }

    private static byte[] extractBytes(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }

    public static UUID getUUIDFromString(String str) {
        try {
            try {
                return UUID.fromString(str);
            } catch (Exception unused) {
                return null;
            }
        } catch (Exception unused2) {
            return BluetoothUuid.parseUuidFrom(hexStringToBytesInReverse(str)).getUuid();
        }
    }

    public static boolean isLocationEnable(Context context) {
        LocationManager locationManager = (LocationManager) context.getSystemService("location");
        if (locationManager == null) {
            return false;
        }
        return locationManager.isProviderEnabled("network") || locationManager.isProviderEnabled("gps");
    }
}
