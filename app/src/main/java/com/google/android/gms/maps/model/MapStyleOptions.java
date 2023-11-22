package com.google.android.gms.maps.model;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.ViewConfiguration;
import com.alibaba.fastjson.parser.JSONLexer;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.IOUtils;
import java.io.IOException;
import o.E;

/* loaded from: classes3.dex */
public final class MapStyleOptions extends AbstractSafeParcelable {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 1;
    public static final Parcelable.Creator<MapStyleOptions> CREATOR;
    private static long KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static int MyBillsEntityDataFactory = 0;
    private static char PlaceComponentResult = 0;
    private static int getAuthRequestContext = 0;
    private static final String zza = "MapStyleOptions";
    private final String zzb;

    static {
        PlaceComponentResult();
        CREATOR = new zzk();
        try {
            int i = BuiltInFictitiousFunctionClassFactory + 87;
            try {
                getAuthRequestContext = i % 128;
                int i2 = i % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public MapStyleOptions(String str) {
        Preconditions.checkNotNull(str, "json must not be null");
        this.zzb = str;
    }

    static void PlaceComponentResult() {
        PlaceComponentResult = (char) 13492;
        KClassImpl$Data$declaredNonStaticMembers$2 = -3095986239510888410L;
        MyBillsEntityDataFactory = -956812108;
    }

    public static MapStyleOptions loadRawResourceStyle(Context context, int i) throws Resources.NotFoundException {
        try {
            byte[] readInputStreamFully = IOUtils.readInputStreamFully(context.getResources().openRawResource(i));
            Object[] objArr = new Object[1];
            a(new char[]{47041, 63821, 2355, 45861, 43724}, new char[]{11061, 31439, 63988, 39310}, (char) (Drawable.resolveOpacity(0, 0) + 36601), new char[]{62610, 55948, 33517, 59789}, (-193278165) - (ViewConfiguration.getScrollBarSize() >> 8), objArr);
            MapStyleOptions mapStyleOptions = new MapStyleOptions(new String(readInputStreamFully, ((String) objArr[0]).intern()));
            int i2 = getAuthRequestContext + 31;
            BuiltInFictitiousFunctionClassFactory = i2 % 128;
            int i3 = i2 % 2;
            return mapStyleOptions;
        } catch (IOException e) {
            String obj = e.toString();
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to read resource ");
            sb.append(i);
            sb.append(": ");
            sb.append(obj);
            throw new Resources.NotFoundException(sb.toString());
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = BuiltInFictitiousFunctionClassFactory + 115;
        getAuthRequestContext = i2 % 128;
        if (i2 % 2 != 0) {
            String str = this.zzb;
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeString(parcel, 2, str, true);
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
            return;
        }
        try {
            String str2 = this.zzb;
            try {
                int beginObjectHeader2 = SafeParcelWriter.beginObjectHeader(parcel);
                SafeParcelWriter.writeString(parcel, 2, str2, false);
                SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader2);
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static void a(char[] cArr, char[] cArr2, char c, char[] cArr3, int i, Object[] objArr) {
        E e = new E();
        int length = cArr2.length;
        char[] cArr4 = new char[length];
        int length2 = cArr3.length;
        char[] cArr5 = new char[length2];
        System.arraycopy(cArr2, 0, cArr4, 0, length);
        System.arraycopy(cArr3, 0, cArr5, 0, length2);
        cArr4[0] = (char) (cArr4[0] ^ c);
        cArr5[2] = (char) (cArr5[2] + ((char) i));
        int length3 = cArr.length;
        char[] cArr6 = new char[length3];
        e.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        while (true) {
            if ((e.KClassImpl$Data$declaredNonStaticMembers$2 < length3 ? JSONLexer.EOI : 'B') == 26) {
                int i2 = $10 + 9;
                $11 = i2 % 128;
                int i3 = i2 % 2;
                int i4 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 2) % 4;
                int i5 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 3) % 4;
                e.MyBillsEntityDataFactory = (char) (((cArr4[e.KClassImpl$Data$declaredNonStaticMembers$2 % 4] * 32718) + cArr5[i4]) % 65535);
                cArr5[i5] = (char) (((cArr4[i5] * 32718) + cArr5[i4]) / 65535);
                cArr4[i5] = e.MyBillsEntityDataFactory;
                cArr6[e.KClassImpl$Data$declaredNonStaticMembers$2] = (char) ((((cArr4[i5] ^ cArr[e.KClassImpl$Data$declaredNonStaticMembers$2]) ^ (KClassImpl$Data$declaredNonStaticMembers$2 ^ 4360990799332652212L)) ^ ((int) (MyBillsEntityDataFactory ^ 4360990799332652212L))) ^ ((char) (PlaceComponentResult ^ 4360990799332652212L)));
                e.KClassImpl$Data$declaredNonStaticMembers$2++;
                int i6 = $10 + 99;
                $11 = i6 % 128;
                int i7 = i6 % 2;
            } else {
                objArr[0] = new String(cArr6);
                return;
            }
        }
    }
}
