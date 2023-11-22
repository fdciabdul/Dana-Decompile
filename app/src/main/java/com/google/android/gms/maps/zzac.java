package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.ViewConfiguration;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLngBounds;
import id.dana.DanaApplication;
import id.dana.analytics.firebase.Crashlytics;
import id.dana.onboarding.unsafe.UnsafeDeviceActivity;
import id.dana.util.RaspUtils;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import o.A;

/* loaded from: classes3.dex */
public final class zzac implements Parcelable.Creator {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 269894667;
    private static int MyBillsEntityDataFactory = 0;
    private static int getAuthRequestContext = 1;

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i = getAuthRequestContext + 111;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        CameraPosition cameraPosition = null;
        Float f = null;
        Float f2 = null;
        LatLngBounds latLngBounds = null;
        Integer num = null;
        String str = null;
        byte b = -1;
        byte b2 = -1;
        int i3 = 0;
        byte b3 = -1;
        byte b4 = -1;
        byte b5 = -1;
        byte b6 = -1;
        byte b7 = -1;
        byte b8 = -1;
        byte b9 = -1;
        byte b10 = -1;
        byte b11 = -1;
        byte b12 = -1;
        while (true) {
            if ((parcel.dataPosition() < validateObjectHeader ? Typography.amp : (char) 16) == '&') {
                int i4 = getAuthRequestContext + 91;
                MyBillsEntityDataFactory = i4 % 128;
                int i5 = i4 % 2;
                int readHeader = SafeParcelReader.readHeader(parcel);
                switch (SafeParcelReader.getFieldId(readHeader)) {
                    case 2:
                        b = SafeParcelReader.readByte(parcel, readHeader);
                        break;
                    case 3:
                        b2 = SafeParcelReader.readByte(parcel, readHeader);
                        break;
                    case 4:
                        i3 = SafeParcelReader.readInt(parcel, readHeader);
                        break;
                    case 5:
                        cameraPosition = (CameraPosition) SafeParcelReader.createParcelable(parcel, readHeader, CameraPosition.CREATOR);
                        break;
                    case 6:
                        b3 = SafeParcelReader.readByte(parcel, readHeader);
                        break;
                    case 7:
                        b4 = SafeParcelReader.readByte(parcel, readHeader);
                        break;
                    case 8:
                        b5 = SafeParcelReader.readByte(parcel, readHeader);
                        break;
                    case 9:
                        b6 = SafeParcelReader.readByte(parcel, readHeader);
                        break;
                    case 10:
                        b7 = SafeParcelReader.readByte(parcel, readHeader);
                        break;
                    case 11:
                        b8 = SafeParcelReader.readByte(parcel, readHeader);
                        break;
                    case 12:
                        b9 = SafeParcelReader.readByte(parcel, readHeader);
                        break;
                    case 13:
                    default:
                        SafeParcelReader.skipUnknownField(parcel, readHeader);
                        break;
                    case 14:
                        b10 = SafeParcelReader.readByte(parcel, readHeader);
                        break;
                    case 15:
                        b11 = SafeParcelReader.readByte(parcel, readHeader);
                        break;
                    case 16:
                        f = SafeParcelReader.readFloatObject(parcel, readHeader);
                        int i6 = getAuthRequestContext + 65;
                        MyBillsEntityDataFactory = i6 % 128;
                        int i7 = i6 % 2;
                        break;
                    case 17:
                        f2 = SafeParcelReader.readFloatObject(parcel, readHeader);
                        break;
                    case 18:
                        latLngBounds = (LatLngBounds) SafeParcelReader.createParcelable(parcel, readHeader, LatLngBounds.CREATOR);
                        break;
                    case 19:
                        try {
                            b12 = SafeParcelReader.readByte(parcel, readHeader);
                            break;
                        } catch (Exception e) {
                            throw e;
                        }
                    case 20:
                        num = SafeParcelReader.readIntegerObject(parcel, readHeader);
                        break;
                    case 21:
                        str = SafeParcelReader.createString(parcel, readHeader);
                        break;
                }
            } else {
                SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
                return new GoogleMapOptions(b, b2, i3, cameraPosition, b3, b4, b5, b6, b7, b8, b9, b10, b11, f, f2, latLngBounds, b12, num, str);
            }
        }
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        int i2 = getAuthRequestContext + 81;
        MyBillsEntityDataFactory = i2 % 128;
        int i3 = i2 % 2;
        try {
            GoogleMapOptions[] googleMapOptionsArr = new GoogleMapOptions[i];
            int i4 = getAuthRequestContext + 115;
            MyBillsEntityDataFactory = i4 % 128;
            int i5 = i4 % 2;
            return googleMapOptionsArr;
        } catch (Exception e) {
            throw e;
        }
    }

    public static void $$a(long j, long j2) {
        long j3 = j ^ (j2 << 32);
        Crashlytics BuiltInFictitiousFunctionClassFactory2 = Crashlytics.BuiltInFictitiousFunctionClassFactory();
        StringBuilder sb = new StringBuilder();
        Object[] objArr = new Object[1];
        a(new char[]{19, 65482, 65508, 25, 16, 24}, TextUtils.indexOf("", "") + 132, (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 5, true, (ViewConfiguration.getDoubleTapTimeout() >> 16) + 1, objArr);
        sb.append((String) objArr[0]);
        sb.append(j3);
        String obj = sb.toString();
        Intrinsics.checkNotNullParameter(obj, "");
        BuiltInFictitiousFunctionClassFactory2.getAuthRequestContext.log(obj);
        RaspUtils.DexguardException dexguardException = new RaspUtils.DexguardException();
        Intrinsics.checkNotNullParameter(dexguardException, "");
        BuiltInFictitiousFunctionClassFactory2.getAuthRequestContext.recordException(dexguardException);
        RaspUtils.PlaceComponentResult(UnsafeDeviceActivity.UnsafeStatus.ROOTED);
        UnsafeDeviceActivity.show(DanaApplication.application, UnsafeDeviceActivity.UnsafeStatus.ROOTED);
        int i = MyBillsEntityDataFactory + 33;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
    }

    private static void a(char[] cArr, int i, int i2, boolean z, int i3, Object[] objArr) {
        int i4;
        A a2 = new A();
        char[] cArr2 = new char[i2];
        a2.MyBillsEntityDataFactory = 0;
        while (true) {
            if ((a2.MyBillsEntityDataFactory < i2 ? ';' : (char) 22) == 22) {
                break;
            }
            try {
                int i5 = $10 + 35;
                try {
                    $11 = i5 % 128;
                    int i6 = i5 % 2;
                    a2.KClassImpl$Data$declaredNonStaticMembers$2 = cArr[a2.MyBillsEntityDataFactory];
                    cArr2[a2.MyBillsEntityDataFactory] = (char) (a2.KClassImpl$Data$declaredNonStaticMembers$2 + i);
                    int i7 = a2.MyBillsEntityDataFactory;
                    cArr2[i7] = (char) (cArr2[i7] - ((int) (BuiltInFictitiousFunctionClassFactory ^ (-5694784870793460699L))));
                    a2.MyBillsEntityDataFactory++;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        if (i3 > 0) {
            a2.BuiltInFictitiousFunctionClassFactory = i3;
            char[] cArr3 = new char[i2];
            System.arraycopy(cArr2, 0, cArr3, 0, i2);
            System.arraycopy(cArr3, 0, cArr2, i2 - a2.BuiltInFictitiousFunctionClassFactory, a2.BuiltInFictitiousFunctionClassFactory);
            System.arraycopy(cArr3, a2.BuiltInFictitiousFunctionClassFactory, cArr2, 0, i2 - a2.BuiltInFictitiousFunctionClassFactory);
        }
        if (z) {
            int i8 = $11 + 9;
            $10 = i8 % 128;
            int i9 = i8 % 2;
            char[] cArr4 = new char[i2];
            a2.MyBillsEntityDataFactory = 0;
            while (a2.MyBillsEntityDataFactory < i2) {
                int i10 = $11 + 123;
                $10 = i10 % 128;
                if (i10 % 2 != 0) {
                    cArr4[a2.MyBillsEntityDataFactory] = cArr2[(i2 >>> a2.MyBillsEntityDataFactory) / 1];
                    i4 = a2.MyBillsEntityDataFactory / 0;
                } else {
                    cArr4[a2.MyBillsEntityDataFactory] = cArr2[(i2 - a2.MyBillsEntityDataFactory) - 1];
                    i4 = a2.MyBillsEntityDataFactory + 1;
                }
                a2.MyBillsEntityDataFactory = i4;
            }
            int i11 = $11 + 85;
            $10 = i11 % 128;
            int i12 = i11 % 2;
            cArr2 = cArr4;
        }
        objArr[0] = new String(cArr2);
    }
}
