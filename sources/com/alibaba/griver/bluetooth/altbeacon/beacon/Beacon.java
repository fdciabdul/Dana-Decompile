package com.alibaba.griver.bluetooth.altbeacon.beacon;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.griver.bluetooth.altbeacon.beacon.client.BeaconDataFactory;
import com.alibaba.griver.bluetooth.altbeacon.beacon.client.NullBeaconDataFactory;
import com.alibaba.griver.bluetooth.altbeacon.beacon.distance.DistanceCalculator;
import com.alibaba.griver.bluetooth.altbeacon.beacon.logging.LogManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public class Beacon implements Parcelable, Serializable {
    private static final String TAG = "Beacon";
    protected int mBeaconTypeCode;
    protected String mBluetoothAddress;
    protected String mBluetoothName;
    protected List<Long> mDataFields;
    protected Double mDistance;
    protected List<Long> mExtraDataFields;
    protected List<Identifier> mIdentifiers;
    protected int mManufacturer;
    protected boolean mMultiFrameBeacon;
    protected String mParserIdentifier;
    protected int mRssi;
    private Double mRunningAverageRssi;
    protected int mServiceUuid;
    protected int mTxPower;
    @Deprecated
    public static final Parcelable.Creator<Beacon> CREATOR = new Parcelable.Creator<Beacon>() { // from class: com.alibaba.griver.bluetooth.altbeacon.beacon.Beacon.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Beacon createFromParcel(Parcel parcel) {
            return new Beacon(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Beacon[] newArray(int i) {
            return new Beacon[i];
        }
    };
    private static final List<Long> UNMODIFIABLE_LIST_OF_LONG = Collections.unmodifiableList(new ArrayList());
    private static final List<Identifier> UNMODIFIABLE_LIST_OF_IDENTIFIER = Collections.unmodifiableList(new ArrayList());
    protected static boolean sHardwareEqualityEnforced = false;
    protected static DistanceCalculator sDistanceCalculator = null;
    protected static BeaconDataFactory beaconDataFactory = new NullBeaconDataFactory();

    @Override // android.os.Parcelable
    @Deprecated
    public int describeContents() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Deprecated
    public Beacon(Parcel parcel) {
        this.mServiceUuid = -1;
        this.mMultiFrameBeacon = false;
        this.mRunningAverageRssi = null;
        int readInt = parcel.readInt();
        this.mIdentifiers = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            this.mIdentifiers.add(Identifier.parse(parcel.readString()));
        }
        this.mDistance = Double.valueOf(parcel.readDouble());
        this.mRssi = parcel.readInt();
        this.mTxPower = parcel.readInt();
        this.mBluetoothAddress = parcel.readString();
        this.mBeaconTypeCode = parcel.readInt();
        this.mServiceUuid = parcel.readInt();
        int readInt2 = parcel.readInt();
        this.mDataFields = new ArrayList(readInt2);
        for (int i2 = 0; i2 < readInt2; i2++) {
            this.mDataFields.add(Long.valueOf(parcel.readLong()));
        }
        int readInt3 = parcel.readInt();
        this.mExtraDataFields = new ArrayList(readInt3);
        for (int i3 = 0; i3 < readInt3; i3++) {
            this.mExtraDataFields.add(Long.valueOf(parcel.readLong()));
        }
        this.mManufacturer = parcel.readInt();
        this.mBluetoothName = parcel.readString();
        this.mParserIdentifier = parcel.readString();
        this.mMultiFrameBeacon = parcel.readByte() != 0;
    }

    protected Beacon(Beacon beacon) {
        this.mServiceUuid = -1;
        this.mMultiFrameBeacon = false;
        this.mRunningAverageRssi = null;
        this.mIdentifiers = new ArrayList(beacon.mIdentifiers);
        this.mDataFields = new ArrayList(beacon.mDataFields);
        this.mExtraDataFields = new ArrayList(beacon.mExtraDataFields);
        this.mDistance = beacon.mDistance;
        this.mRunningAverageRssi = beacon.mRunningAverageRssi;
        this.mRssi = beacon.mRssi;
        this.mTxPower = beacon.mTxPower;
        this.mBluetoothAddress = beacon.mBluetoothAddress;
        this.mBeaconTypeCode = beacon.getBeaconTypeCode();
        this.mServiceUuid = beacon.getServiceUuid();
        this.mBluetoothName = beacon.mBluetoothName;
        this.mParserIdentifier = beacon.mParserIdentifier;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Beacon() {
        this.mServiceUuid = -1;
        this.mMultiFrameBeacon = false;
        this.mRunningAverageRssi = null;
        this.mIdentifiers = new ArrayList(1);
        this.mDataFields = new ArrayList(1);
        this.mExtraDataFields = new ArrayList(1);
    }

    public static DistanceCalculator getDistanceCalculator() {
        return sDistanceCalculator;
    }

    public static void setDistanceCalculator(DistanceCalculator distanceCalculator) {
        sDistanceCalculator = distanceCalculator;
    }

    public static boolean getHardwareEqualityEnforced() {
        return sHardwareEqualityEnforced;
    }

    public static void setHardwareEqualityEnforced(boolean z) {
        sHardwareEqualityEnforced = z;
    }

    protected static Double calculateDistance(int i, double d) {
        if (getDistanceCalculator() != null) {
            return Double.valueOf(getDistanceCalculator().calculateDistance(i, d));
        }
        LogManager.e(TAG, "Distance calculator not set.  Distance will bet set to -1", new Object[0]);
        return Double.valueOf(-1.0d);
    }

    @Deprecated
    public double getRunningAverageRssi(double d) {
        Double valueOf = Double.valueOf(d);
        this.mRunningAverageRssi = valueOf;
        return valueOf.doubleValue();
    }

    public double getRunningAverageRssi() {
        Double d = this.mRunningAverageRssi;
        if (d != null) {
            return d.doubleValue();
        }
        return this.mRssi;
    }

    public void setRunningAverageRssi(double d) {
        this.mRunningAverageRssi = Double.valueOf(d);
        this.mDistance = null;
    }

    public int getManufacturer() {
        return this.mManufacturer;
    }

    public int getServiceUuid() {
        return this.mServiceUuid;
    }

    public Identifier getIdentifier(int i) {
        return this.mIdentifiers.get(i);
    }

    public Identifier getId1() {
        return this.mIdentifiers.get(0);
    }

    public Identifier getId2() {
        return this.mIdentifiers.get(1);
    }

    public Identifier getId3() {
        return this.mIdentifiers.get(2);
    }

    public List<Long> getDataFields() {
        if (this.mDataFields.getClass().isInstance(UNMODIFIABLE_LIST_OF_LONG)) {
            return this.mDataFields;
        }
        return Collections.unmodifiableList(this.mDataFields);
    }

    public List<Long> getExtraDataFields() {
        if (this.mExtraDataFields.getClass().isInstance(UNMODIFIABLE_LIST_OF_LONG)) {
            return this.mExtraDataFields;
        }
        return Collections.unmodifiableList(this.mExtraDataFields);
    }

    public void setExtraDataFields(List<Long> list) {
        this.mExtraDataFields = list;
    }

    public List<Identifier> getIdentifiers() {
        if (this.mIdentifiers.getClass().isInstance(UNMODIFIABLE_LIST_OF_IDENTIFIER)) {
            return this.mIdentifiers;
        }
        return Collections.unmodifiableList(this.mIdentifiers);
    }

    public double getDistance() {
        if (this.mDistance == null) {
            double d = this.mRssi;
            Double d2 = this.mRunningAverageRssi;
            if (d2 != null) {
                d = d2.doubleValue();
            } else {
                LogManager.d(TAG, "Not using running average RSSI because it is null", new Object[0]);
            }
            this.mDistance = calculateDistance(this.mTxPower, d);
        }
        return this.mDistance.doubleValue();
    }

    public int getRssi() {
        return this.mRssi;
    }

    public void setRssi(int i) {
        this.mRssi = i;
    }

    public int getTxPower() {
        return this.mTxPower;
    }

    public int getBeaconTypeCode() {
        return this.mBeaconTypeCode;
    }

    public String getBluetoothAddress() {
        return this.mBluetoothAddress;
    }

    public String getBluetoothName() {
        return this.mBluetoothName;
    }

    public String getParserIdentifier() {
        return this.mParserIdentifier;
    }

    public boolean isMultiFrameBeacon() {
        return this.mMultiFrameBeacon;
    }

    public int hashCode() {
        StringBuilder stringBuilder = toStringBuilder();
        if (sHardwareEqualityEnforced) {
            stringBuilder.append(this.mBluetoothAddress);
        }
        return stringBuilder.toString().hashCode();
    }

    public boolean equals(Object obj) {
        if (obj instanceof Beacon) {
            Beacon beacon = (Beacon) obj;
            if (this.mIdentifiers.equals(beacon.mIdentifiers)) {
                if (sHardwareEqualityEnforced) {
                    return getBluetoothAddress().equals(beacon.getBluetoothAddress());
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public void requestData(BeaconDataNotifier beaconDataNotifier) {
        beaconDataFactory.requestBeaconData(this, beaconDataNotifier);
    }

    public String toString() {
        return toStringBuilder().toString();
    }

    private StringBuilder toStringBuilder() {
        StringBuilder sb = new StringBuilder();
        Iterator<Identifier> it = this.mIdentifiers.iterator();
        int i = 1;
        while (it.hasNext()) {
            Identifier next = it.next();
            if (i > 1) {
                sb.append(" ");
            }
            sb.append("id");
            sb.append(i);
            sb.append(": ");
            sb.append(next == null ? "null" : next.toString());
            i++;
        }
        if (this.mParserIdentifier != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(" type ");
            sb2.append(this.mParserIdentifier);
            sb.append(sb2.toString());
        }
        return sb;
    }

    @Override // android.os.Parcelable
    @Deprecated
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mIdentifiers.size());
        Iterator<Identifier> it = this.mIdentifiers.iterator();
        while (it.hasNext()) {
            Identifier next = it.next();
            parcel.writeString(next == null ? null : next.toString());
        }
        parcel.writeDouble(getDistance());
        parcel.writeInt(this.mRssi);
        parcel.writeInt(this.mTxPower);
        parcel.writeString(this.mBluetoothAddress);
        parcel.writeInt(this.mBeaconTypeCode);
        parcel.writeInt(this.mServiceUuid);
        parcel.writeInt(this.mDataFields.size());
        Iterator<Long> it2 = this.mDataFields.iterator();
        while (it2.hasNext()) {
            parcel.writeLong(it2.next().longValue());
        }
        parcel.writeInt(this.mExtraDataFields.size());
        Iterator<Long> it3 = this.mExtraDataFields.iterator();
        while (it3.hasNext()) {
            parcel.writeLong(it3.next().longValue());
        }
        parcel.writeInt(this.mManufacturer);
        parcel.writeString(this.mBluetoothName);
        parcel.writeString(this.mParserIdentifier);
        parcel.writeByte(this.mMultiFrameBeacon ? (byte) 1 : (byte) 0);
    }

    public boolean isExtraBeaconData() {
        return this.mIdentifiers.size() == 0 && this.mDataFields.size() != 0;
    }

    /* loaded from: classes6.dex */
    public static class Builder {
        protected final Beacon mBeacon = new Beacon();
        private Identifier mId1;
        private Identifier mId2;
        private Identifier mId3;

        public Beacon build() {
            if (this.mId1 != null) {
                this.mBeacon.mIdentifiers.add(this.mId1);
                if (this.mId2 != null) {
                    this.mBeacon.mIdentifiers.add(this.mId2);
                    if (this.mId3 != null) {
                        this.mBeacon.mIdentifiers.add(this.mId3);
                    }
                }
            }
            return this.mBeacon;
        }

        public Builder copyBeaconFields(Beacon beacon) {
            setIdentifiers(beacon.getIdentifiers());
            setBeaconTypeCode(beacon.getBeaconTypeCode());
            setDataFields(beacon.getDataFields());
            setBluetoothAddress(beacon.getBluetoothAddress());
            setBluetoothName(beacon.getBluetoothName());
            setExtraDataFields(beacon.getExtraDataFields());
            setManufacturer(beacon.getManufacturer());
            setTxPower(beacon.getTxPower());
            setRssi(beacon.getRssi());
            setServiceUuid(beacon.getServiceUuid());
            setMultiFrameBeacon(beacon.isMultiFrameBeacon());
            return this;
        }

        public Builder setIdentifiers(List<Identifier> list) {
            this.mId1 = null;
            this.mId2 = null;
            this.mId3 = null;
            this.mBeacon.mIdentifiers = list;
            return this;
        }

        public Builder setId1(String str) {
            this.mId1 = Identifier.parse(str);
            return this;
        }

        public Builder setId2(String str) {
            this.mId2 = Identifier.parse(str);
            return this;
        }

        public Builder setId3(String str) {
            this.mId3 = Identifier.parse(str);
            return this;
        }

        public Builder setRssi(int i) {
            this.mBeacon.mRssi = i;
            return this;
        }

        public Builder setRunningAverageRssi(double d) {
            this.mBeacon.mRunningAverageRssi = Double.valueOf(d);
            return this;
        }

        public Builder setTxPower(int i) {
            this.mBeacon.mTxPower = i;
            return this;
        }

        public Builder setBeaconTypeCode(int i) {
            this.mBeacon.mBeaconTypeCode = i;
            return this;
        }

        public Builder setServiceUuid(int i) {
            this.mBeacon.mServiceUuid = i;
            return this;
        }

        public Builder setBluetoothAddress(String str) {
            this.mBeacon.mBluetoothAddress = str;
            return this;
        }

        public Builder setDataFields(List<Long> list) {
            this.mBeacon.mDataFields = list;
            return this;
        }

        public Builder setExtraDataFields(List<Long> list) {
            this.mBeacon.mExtraDataFields = list;
            return this;
        }

        public Builder setManufacturer(int i) {
            this.mBeacon.mManufacturer = i;
            return this;
        }

        public Builder setBluetoothName(String str) {
            this.mBeacon.mBluetoothName = str;
            return this;
        }

        public Builder setParserIdentifier(String str) {
            this.mBeacon.mParserIdentifier = str;
            return this;
        }

        public Builder setMultiFrameBeacon(boolean z) {
            this.mBeacon.mMultiFrameBeacon = z;
            return this;
        }
    }
}
