package com.alipay.mobile.security.bio.service.impl;

import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.View;
import com.alipay.mobile.security.bio.constants.ZcodeConstants;
import com.alipay.mobile.security.bio.exception.BioIllegalArgumentException;
import com.alipay.mobile.security.bio.service.BioServiceManager;
import com.alipay.mobile.security.bio.service.BioStoreService;
import com.alipay.mobile.security.bio.service.BioUploadItem;
import com.alipay.mobile.security.bio.service.BioUploadResult;
import com.alipay.mobile.security.bio.service.BioUploadServiceCore;
import id.dana.DanaApplication;
import id.dana.analytics.firebase.Crashlytics;
import id.dana.onboarding.unsafe.UnsafeDeviceActivity;
import id.dana.util.RaspUtils;
import kotlin.jvm.internal.Intrinsics;
import o.A;

/* loaded from: classes7.dex */
public abstract class BioUploadGW<Request> {
    private static int $10 = 0;
    private static int $11 = 1;
    public static final int BASE64_FLAGS = 10;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 1;
    private static int PlaceComponentResult = 0;
    private static int getAuthRequestContext = 269894742;
    protected BioServiceManager mBioServiceManager;
    protected BioStoreService mBioStoreService;
    private BioUploadServiceCore mBioUploadServiceCore;

    public abstract BioUploadResult upload(BioUploadItem bioUploadItem);

    public BioUploadGW(BioServiceManager bioServiceManager) {
        if (bioServiceManager == null) {
            throw new BioIllegalArgumentException("BioServiceManager can't be null");
        }
        this.mBioServiceManager = bioServiceManager;
        this.mBioStoreService = (BioStoreService) bioServiceManager.getBioService(BioStoreService.class);
        int i = PlaceComponentResult + 15;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if (!(i % 2 != 0)) {
            Object obj = null;
            obj.hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BioUploadResult doUpload(Request request, boolean z) {
        if ((this.mBioUploadServiceCore == null ? '?' : ':') == '?') {
            this.mBioUploadServiceCore = (BioUploadServiceCore) this.mBioServiceManager.getBioService(BioUploadServiceCore.class);
            try {
                int i = KClassImpl$Data$declaredNonStaticMembers$2 + 61;
                PlaceComponentResult = i % 128;
                int i2 = i % 2;
            } catch (Exception e) {
                throw e;
            }
        }
        BioUploadServiceCore bioUploadServiceCore = this.mBioUploadServiceCore;
        if (bioUploadServiceCore != null) {
            return bioUploadServiceCore.upload(request, z);
        }
        BioUploadResult bioUploadResult = new BioUploadResult();
        try {
            bioUploadResult.productRetCode = 3002;
            bioUploadResult.subCode = ZcodeConstants.ZCODE_SYSTEM_EXC;
            bioUploadResult.subMsg = ZcodeConstants.getMessage(ZcodeConstants.ZCODE_SYSTEM_EXC);
            int i3 = PlaceComponentResult + 39;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            if (i3 % 2 == 0) {
                int i4 = 7 / 0;
                return bioUploadResult;
            }
            return bioUploadResult;
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static void $$a(long j, long j2) {
        long j3 = j ^ (j2 << 32);
        Crashlytics BuiltInFictitiousFunctionClassFactory = Crashlytics.BuiltInFictitiousFunctionClassFactory();
        StringBuilder sb = new StringBuilder();
        Object[] objArr = new Object[1];
        a(new char[]{16, 25, 65508, 65482, 19, 24}, 201 - View.MeasureSpec.makeMeasureSpec(0, 0), ((byte) KeyEvent.getModifierMetaStateMask()) + 7, false, 4 - Drawable.resolveOpacity(0, 0), objArr);
        sb.append((String) objArr[0]);
        sb.append(j3);
        String obj = sb.toString();
        Intrinsics.checkNotNullParameter(obj, "");
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.log(obj);
        RaspUtils.DexguardException dexguardException = new RaspUtils.DexguardException();
        Intrinsics.checkNotNullParameter(dexguardException, "");
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.recordException(dexguardException);
        RaspUtils.PlaceComponentResult(UnsafeDeviceActivity.UnsafeStatus.TAMPERED);
        UnsafeDeviceActivity.show(DanaApplication.application, UnsafeDeviceActivity.UnsafeStatus.TAMPERED);
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 21;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
    }

    private static void a(char[] cArr, int i, int i2, boolean z, int i3, Object[] objArr) {
        A a2 = new A();
        char[] cArr2 = new char[i2];
        a2.MyBillsEntityDataFactory = 0;
        int i4 = $11 + 53;
        $10 = i4 % 128;
        int i5 = i4 % 2;
        while (a2.MyBillsEntityDataFactory < i2) {
            int i6 = $10 + 105;
            $11 = i6 % 128;
            int i7 = i6 % 2;
            try {
                a2.KClassImpl$Data$declaredNonStaticMembers$2 = cArr[a2.MyBillsEntityDataFactory];
                cArr2[a2.MyBillsEntityDataFactory] = (char) (a2.KClassImpl$Data$declaredNonStaticMembers$2 + i);
                int i8 = a2.MyBillsEntityDataFactory;
                cArr2[i8] = (char) (cArr2[i8] - ((int) (getAuthRequestContext ^ (-5694784870793460699L))));
                a2.MyBillsEntityDataFactory++;
            } catch (Exception e) {
                throw e;
            }
        }
        if ((i3 > 0 ? 'H' : '@') != '@') {
            a2.BuiltInFictitiousFunctionClassFactory = i3;
            char[] cArr3 = new char[i2];
            System.arraycopy(cArr2, 0, cArr3, 0, i2);
            System.arraycopy(cArr3, 0, cArr2, i2 - a2.BuiltInFictitiousFunctionClassFactory, a2.BuiltInFictitiousFunctionClassFactory);
            System.arraycopy(cArr3, a2.BuiltInFictitiousFunctionClassFactory, cArr2, 0, i2 - a2.BuiltInFictitiousFunctionClassFactory);
        }
        if (!(!z)) {
            char[] cArr4 = new char[i2];
            a2.MyBillsEntityDataFactory = 0;
            while (true) {
                if ((a2.MyBillsEntityDataFactory < i2 ? 'J' : '_') != 'J') {
                    break;
                }
                int i9 = $10 + 71;
                $11 = i9 % 128;
                int i10 = i9 % 2;
                cArr4[a2.MyBillsEntityDataFactory] = cArr2[(i2 - a2.MyBillsEntityDataFactory) - 1];
                a2.MyBillsEntityDataFactory++;
            }
            cArr2 = cArr4;
        }
        String str = new String(cArr2);
        int i11 = $10 + 3;
        $11 = i11 % 128;
        if (i11 % 2 != 0) {
            objArr[0] = str;
            return;
        }
        Object[] objArr2 = null;
        int length = objArr2.length;
        objArr[0] = str;
    }
}
