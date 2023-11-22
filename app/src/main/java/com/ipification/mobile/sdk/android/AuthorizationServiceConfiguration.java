package com.ipification.mobile.sdk.android;

import android.content.Context;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.ipification.mobile.sdk.android.IPConfiguration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\bJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0012\u0010\u0007\u001a\u00020\u0002X\u0086\"¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0012\u0010\f\u001a\u00020\u0004X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0007\u0010\u000b"}, d2 = {"Lcom/ipification/mobile/sdk/android/AuthorizationServiceConfiguration;", "", "Landroid/content/Context;", "p0", "", "p1", "", "BuiltInFictitiousFunctionClassFactory", "(Landroid/content/Context;)V", "getAuthRequestContext", "Landroid/content/Context;", "Ljava/lang/String;", "MyBillsEntityDataFactory", "<init>"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class AuthorizationServiceConfiguration {
    private static int MyBillsEntityDataFactory = 0;
    private static int moveToNextValue = 1;

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public String MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public Context BuiltInFictitiousFunctionClassFactory;
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {TarHeader.LF_DIR, -98, 98, -100, 15, -8, 11, 6, -4, 0, -16, 14, 7, -1, 7, -9, -4, 9, -8};
    public static final int PlaceComponentResult = 170;

    private static void a(int i, int i2, short s, Object[] objArr) {
        int i3 = i + 4;
        byte[] bArr = KClassImpl$Data$declaredNonStaticMembers$2;
        int i4 = 115 - (i2 * 2);
        int i5 = 16 - (s * 2);
        byte[] bArr2 = new byte[i5];
        int i6 = -1;
        int i7 = i5 - 1;
        if (bArr == null) {
            i7 = i7;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i6 = -1;
            i4 = i4 + (-i3) + 1;
            i3 = i3;
        }
        while (true) {
            int i8 = i6 + 1;
            int i9 = i3 + 1;
            bArr2[i8] = (byte) i4;
            if (i8 == i7) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            byte b = bArr[i9];
            i7 = i7;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i6 = i8;
            i4 = i4 + (-b) + 1;
            i3 = i9;
        }
    }

    public AuthorizationServiceConfiguration(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "");
        IPConfiguration.Companion companion = IPConfiguration.INSTANCE;
        this.MyBillsEntityDataFactory = IPConfiguration.Companion.MyBillsEntityDataFactory().readMicros;
        Intrinsics.checkParameterIsNotNull(context, "");
        this.BuiltInFictitiousFunctionClassFactory = context;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00e9, code lost:
    
        if ((!r15) != false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00f6, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r8.getString("authorization_url"), "") == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00f8, code lost:
    
        r15 = android.net.Uri.parse(r8.getString("authorization_url"));
        r1 = com.ipification.mobile.sdk.android.IPConfiguration.INSTANCE;
        com.ipification.mobile.sdk.android.IPConfiguration.Companion.MyBillsEntityDataFactory().KClassImpl$Data$declaredNonStaticMembers$2 = r15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void BuiltInFictitiousFunctionClassFactory(android.content.Context r15) {
        /*
            Method dump skipped, instructions count: 491
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ipification.mobile.sdk.android.AuthorizationServiceConfiguration.BuiltInFictitiousFunctionClassFactory(android.content.Context):void");
    }
}
