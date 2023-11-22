package id.dana.contract.payasset;

import com.alibaba.ariver.engine.common.track.recovery.DeepRecoverARiverProxy;
import com.alibaba.wireless.security.SecExceptionCode;
import id.dana.contract.payasset.ChangePayMethodContract;
import id.dana.contract.payasset.ChangePayMethodPresenter;
import id.dana.di.PerActivity;
import id.dana.domain.DefaultObserver;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.payasset.interactor.ChangePayMethod;
import id.dana.domain.payasset.model.ChangePayMethodResponse;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import o.isTmpDetached;

@PerActivity
/* loaded from: classes4.dex */
public class ChangePayMethodPresenter implements ChangePayMethodContract.Presenter {
    public static final int BuiltInFictitiousFunctionClassFactory;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda0;
    public static final byte[] PlaceComponentResult;
    private static int moveToNextValue;
    private final ChangePayMethodContract.View KClassImpl$Data$declaredNonStaticMembers$2;
    private final IsOfflineF2FPay MyBillsEntityDataFactory;
    private final ChangePayMethod getAuthRequestContext;

    static {
        byte[] bArr = new byte[1303];
        System.arraycopy("%Qz\u000fõ\u0013éË<ó\u000b÷Å%\u0017\u0003\u0000ùþý\u0001\u0000ïýé\u001fó\u000bí\u0011ó\u0004ýÕ1é\u0000\t\u0002ó\u0004ýõ\u0013éË<ó\u000b÷Å\u0019#ôÿ\u0011Õ$ýÙ\u0015Ú+\u0004÷ô\rÐ1é\u0000\t\u0002ó\u0004ýõ\u0013éË<ó\u000b÷Å\u0019!þ÷\u0000ø\tå\u001fë\u0011ïÞ1é\u0000\t\u0002ó\u0004ý\u0002ùÿ\u0003ø\tú÷ÿ\u0004÷\u0005\u0001ôÿ\u0005öÿ\u0006õ\tûö\tüõ\týô\u0003þù\u0003\u0003ô\tþó\tÿò\u0007\u0000ó\u0003þù\u0007ùú\u0003þù\u0007ýö\t\u0000ñ\u0005\u0003ò\u0005\u0004ñ\u0004ÿ÷ÿ\u0007ô\u0004\u0002ôÿ\bóÿ\tòÿ\nñÿ\u0002ýúÿ\u0003øÿ\u0005ö\u0006üøÿ\u0002þù\nöú\n÷ùÿ\u0002ÿøÿ\u0002\u0000÷\u0004\u0005ñÿ\u0002\u0001öÿ\nñÿ\u0002\u0002õÿ\u0002\u0003ô\nøø\u0005\u0003ò\u0003\u0003ô\tó\u0003\u0003ô\nù÷\u0003\u0001ö\núö\nù÷\u0007ýö\nûõ\nüô\u0007þõ\u0003ýú\u0003\u0004ó\u0004ýù\nýó\nþòÿ\u0002\u0004ó\tùø\u0004ÿ÷ÿ\u0002\u0005òÿ\u0002\u0006ñÿ\u0003üú\nÿñ\u0005\u0001ôÿ\u0003ýù\u000bõúÿ\u0003þøÿ\u0002ýúÿ\u0002ýú\u000böùÿ\u0003þé\t\u0007îè\u0015\u0003\u0004à\t\t\u0007îõ\u0013éË<ó\u000b÷Å\u001e%öó\u0001\u000bÒ'\u0001ùò\u0011Ï1é\u0000\t\u0002ó\u0004ýõ\u0013éË<ó\u000b÷Å\"!÷\u0004ó\u0002öÞ1é\u0000\t\u0002ó\u0004ýõ\u0013éË<ó\u000b÷Å\u0019!þ÷\u0000ø\tÓ/ó\föö\u0007\u0004Ï1é\u0000\t\u0002ó\u0004ýõ\u0013éË<ó\u000b÷Å\u0019#\u0004ï\u0000ü\u000b\u0002ùÿ\u0003øÿ\u0004÷\u0006\u0001ó\u0003þù\u0006\u0002ò\u0003\u0003ô\u0006\u0003ñ\u0003\u0004ó\u0007ùú\u0007úù\u0003ÿø\u0003\u0000÷\u0007ûø\u0007ü÷\tó\u0007ýö\u0007þõ\u0007ÿô\u0007\u0000ó\u0003\u0006ñ\u0006ö\u0007\u0001ò\u0007\u0002ñ\bøú\u0005\u0004ñ\u0004ÿ÷ÿ\u0005ö\u0004\u0002ôÿ\u0006õÿ\u0007ôÿ\bóÿ\tò\búø\u0003þù\tó\bû÷\u0003\u0003ô\büö\býõ\bþô\bÿó\u0005\u0001ô\u0003\u0005ò\b\u0000ò\u0003\u0004ó\b\u0001ñ\t÷ú\tøù\u0004ÿ÷ÿ\nñ\tùø\u0004ÿ÷ÿ\u0002ýúÿ\u0002þùÿ\u0002ÿø\u0006üøÿ\u0002\u0000÷ÿ\u0002\u0001öÿ\bóÿ\u0003ø\u0004\u0005ñÿ\u0002\u0002õÿ\u0002ÿø\u0006þö\u0006ÿõÿ\u0002\u0003õ\u0013éË<ó\u000b÷Å\u0013'ó\u0010þÎ\u001c\u0010ÿÏ1é\u0000\t\u0002ó\u0004ýõ\u0013éË<ó\u000b÷Å\u001e%õþâ\u001dø\u0003\u0004ï\u000bÑ1é\u0000\t\u0002ó\u0004ýõ\u0013éË<ó\u000b÷Å\u00151é\u0000\t\u0002ó\u0004ýûúû\t\u0002ùÿ\u0003ø\u000b÷ø\bû÷\u0004üú\u0003ýú\u000bø÷\u000bùö\u0005\u0004ñ\u0004ÿ÷ÿ\u0004÷\u0004\u0002ôÿ\u0005öÿ\u0006õÿ\u0007ô\u0006üøÿ\bóÿ\tò\u0006üøÿ\nñÿ\u0002ýúÿ\u0002þùÿ\u0002ÿø\tùø\u000búõÿ\u0002\u0000÷ÿ\u0003ø\u000bûô\u000büó\u0003\u0003ô\tó\u0003\u0000÷\u000býò\u000bþñ\u0003\u0000÷\u0003ýþú\u0004ýù\u0003ýÿù\u0003\u0003ô\u0003\u0004ó\u0003ýþú\u0003ý\u0000ø\u0004ýù\nþòÿ\u0004÷\tùø\u0004ÿ÷ÿ\u0002\u0001öÿ\u0002\u0002õÿ\u0002\u0003ô\u0003ý\u0001÷ÿ\u0002\u0004ó\u0003ý\u0002öÿ\u0002\u0004óÿ\u0002ÿø\u0004\u0005ñÿ\u0002\u0005òÿ\u0002\u0006ñÿ\u0002ÿøÿ\u0003üúÿ\u0002ÿø\u0004\u0005ñ\u0003ý\u0003õ\u0005\u0001ôÿ\u0002\u0005ò\u0006üøÿ\bóÿ\tò\u0006üøÿ\nñÿ\u0002ýú\u0003ý\u0004ô\u0003ý\u0005ó\u0005\u0001ôÿ\u0002þù\u0006\u0001óÿ\u0003ýù\u0003ý\u0006òÿ\u0003ýõ\u0013éË<ó\u000b÷Å#\u001füõ\u0003÷õ\u0013éË<ó\u000b÷Å\u0011/þí\u0016Ø\u001fù\u0001ñÞ1é\u0000\t\u0002ó\u0004ý\u0002ùÿ\u0003ø\u0004øÿ\u0004÷ÿ\u0005öÿ\u0006õ\u0006öÿ\u0007ôÿ\u0005öÿ\u0005öÿ\bó\bô\tó\nò\u000bñ\u0003ýú\u0003þù\tó\u0003ÿø\u0003\u0000÷\u0003\u0001ö\u0003\u0002õ\u0003\u0003ô\u0003\u0004ó\u0003\u0005ò\tó\u0003\u0006ñ\u0006ö\u000bñ\u0003ýú\u0004üú\u0004ýù\u0004þø\u0004ÿ÷ÿ\tò\u0004\u0002ôÿ\nñÿ\u0002ýúÿ\u0002þù\u0004\u0004òÿ\u0007ô\u0004\u0005ñ\u0005ûúÿ\u0002ÿøÿ\bó\u0005üù\u0005ýø\u0003\u0003ô\u0003\u0004ó\u0003ýú\u0005þ÷\u0005ÿö\u0003\u0004ó\u0003\u0004ó\u0005\u0000õ\u000bñ\tó\u0003\u0004ó\u0003\u0001ö\u0005\u0001ô\u0003\u0000÷\u0005\u0002ó\u0005\u0003ò\u0005\u0004ñ\u0004ÿ÷ÿ\tò\u0004\u0002ôÿ\u0002\u0000÷ÿ\u0002\u0001öÿ\u0002\u0002õ\u0006üøÿ\u0002\u0003ôÿ\u0002\u0004ó\u0006üøÿ\u0002\u0003ô\u0005ûúÿ\u0002\u0004ó\u0006ý÷ÿ\u0004÷ÿ\u0005ö\u0004\u0005ñÿ\u0002ÿø\u0006þö\u0006ÿõÿ\u0002\u0005".getBytes("ISO-8859-1"), 0, bArr, 0, 1303);
        PlaceComponentResult = bArr;
        BuiltInFictitiousFunctionClassFactory = 35;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = 0;
        moveToNextValue = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0206, code lost:
    
        if (r10 <= 11) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x02ac, code lost:
    
        if (r10 <= 73) goto L70;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ id.dana.contract.payasset.ChangePayMethodContract.View KClassImpl$Data$declaredNonStaticMembers$2(id.dana.contract.payasset.ChangePayMethodPresenter r17) {
        /*
            Method dump skipped, instructions count: 798
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.contract.payasset.ChangePayMethodPresenter.KClassImpl$Data$declaredNonStaticMembers$2(id.dana.contract.payasset.ChangePayMethodPresenter):id.dana.contract.payasset.ChangePayMethodContract$View");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x0030). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r6, short r7, int r8, java.lang.Object[] r9) {
        /*
            int r8 = 265 - r8
            int r7 = 1049 - r7
            int r6 = r6 + 44
            byte[] r0 = id.dana.contract.payasset.ChangePayMethodPresenter.PlaceComponentResult
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L15
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L30
        L15:
            r3 = 0
        L16:
            byte r4 = (byte) r6
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r8) goto L25
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L25:
            int r7 = r7 + 1
            r3 = r0[r7]
            r5 = r8
            r8 = r6
            r6 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L30:
            int r8 = r8 + r6
            int r6 = r8 + 2
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.contract.payasset.ChangePayMethodPresenter.a(int, short, int, java.lang.Object[]):void");
    }

    static /* synthetic */ ChangePayMethod getAuthRequestContext(ChangePayMethodPresenter changePayMethodPresenter) {
        isTmpDetached istmpdetached = new isTmpDetached(changePayMethodPresenter);
        byte b = PlaceComponentResult[20];
        Object[] objArr = new Object[1];
        a(b, (short) (b | 588), r0[8], objArr);
        String str = (String) objArr[0];
        byte b2 = PlaceComponentResult[16];
        Object[] objArr2 = new Object[1];
        a(b2, (short) (b2 | 638), (short) 264, objArr2);
        try {
            Object[] objArr3 = {(String) objArr2[0]};
            byte b3 = (byte) 62;
            short s = (short) 249;
            Object[] objArr4 = new Object[1];
            a(b3, PlaceComponentResult[62], s, objArr4);
            Class<?> cls = Class.forName((String) objArr4[0]);
            short s2 = (short) (BuiltInFictitiousFunctionClassFactory | 276);
            Object[] objArr5 = new Object[1];
            a((byte) 71, s2, (short) (s2 & 1996), objArr5);
            String str2 = (String) objArr5[0];
            Object[] objArr6 = new Object[1];
            a(b3, PlaceComponentResult[62], s, objArr6);
            Object[] objArr7 = (Object[]) cls.getMethod(str2, Class.forName((String) objArr6[0])).invoke(str, objArr3);
            int[] iArr = new int[objArr7.length];
            for (int i = 0; i < objArr7.length; i++) {
                try {
                    Object[] objArr8 = {objArr7[i]};
                    short s3 = (short) SecExceptionCode.SEC_ERROR_SIGNATURE_CONFUSE_FAILED;
                    short s4 = (short) 248;
                    Object[] objArr9 = new Object[1];
                    a(b3, s3, s4, objArr9);
                    Class<?> cls2 = Class.forName((String) objArr9[0]);
                    Object[] objArr10 = new Object[1];
                    a((byte) 74, (short) 706, (short) DeepRecoverARiverProxy.TYPE_ENTITY_TEMPLATE, objArr10);
                    String str3 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(b3, PlaceComponentResult[62], s, objArr11);
                    Object invoke = cls2.getMethod(str3, Class.forName((String) objArr11[0])).invoke(null, objArr8);
                    try {
                        Object[] objArr12 = new Object[1];
                        a(b3, s3, s4, objArr12);
                        Class<?> cls3 = Class.forName((String) objArr12[0]);
                        Object[] objArr13 = new Object[1];
                        a((byte) (PlaceComponentResult[8] + 1), (short) 700, (short) DeepRecoverARiverProxy.TYPE_ENTITY_APP, objArr13);
                        iArr[i] = ((Integer) cls3.getMethod((String) objArr13[0], null).invoke(invoke, null)).intValue();
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause != null) {
                            throw cause;
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    Throwable cause2 = th2.getCause();
                    if (cause2 != null) {
                        throw cause2;
                    }
                    throw th2;
                }
            }
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                try {
                    switch (istmpdetached.MyBillsEntityDataFactory(iArr[i2])) {
                        case -16:
                            i2 = 32;
                            break;
                        case -15:
                            istmpdetached.MyBillsEntityDataFactory(3);
                            return (ChangePayMethod) istmpdetached.moveToNextValue;
                        case -14:
                            i2 = 2;
                            break;
                        case -13:
                            istmpdetached.getAuthRequestContext = 1;
                            istmpdetached.MyBillsEntityDataFactory(24);
                            istmpdetached.MyBillsEntityDataFactory(40);
                            istmpdetached.lookAheadTest = ((ChangePayMethodPresenter) istmpdetached.moveToNextValue).getAuthRequestContext;
                            istmpdetached.MyBillsEntityDataFactory(41);
                            i2 = i3;
                            break;
                        case -12:
                            i2 = 56;
                            break;
                        case -11:
                            i2 = 63;
                            break;
                        case -10:
                            istmpdetached.MyBillsEntityDataFactory(27);
                            if (istmpdetached.MyBillsEntityDataFactory == 0) {
                                i2 = 55;
                                break;
                            } else {
                                i2 = i3;
                                break;
                            }
                        case -9:
                            istmpdetached.getAuthRequestContext = 1;
                            istmpdetached.MyBillsEntityDataFactory(24);
                            istmpdetached.MyBillsEntityDataFactory(25);
                            moveToNextValue = istmpdetached.MyBillsEntityDataFactory;
                            i2 = i3;
                            break;
                        case -8:
                            istmpdetached.getAuthRequestContext = NetworkUserEntityData$$ExternalSyntheticLambda0;
                            istmpdetached.MyBillsEntityDataFactory(5);
                            i2 = i3;
                            break;
                        case -7:
                            i2 = 61;
                            break;
                        case -6:
                            i2 = 59;
                            break;
                        case -5:
                            istmpdetached.MyBillsEntityDataFactory(61);
                            if (istmpdetached.MyBillsEntityDataFactory == 0) {
                                i2 = 31;
                                break;
                            } else {
                                i2 = i3;
                                break;
                            }
                        case -4:
                            istmpdetached.getAuthRequestContext = 1;
                            istmpdetached.MyBillsEntityDataFactory(24);
                            istmpdetached.MyBillsEntityDataFactory(25);
                            NetworkUserEntityData$$ExternalSyntheticLambda0 = istmpdetached.MyBillsEntityDataFactory;
                            i2 = i3;
                            break;
                        case -3:
                            istmpdetached.getAuthRequestContext = moveToNextValue;
                            istmpdetached.MyBillsEntityDataFactory(5);
                            i2 = i3;
                            break;
                        case -2:
                            istmpdetached.MyBillsEntityDataFactory(3);
                            throw ((Throwable) istmpdetached.moveToNextValue);
                        case -1:
                            i2 = 64;
                            break;
                        default:
                            i2 = i3;
                            break;
                    }
                } catch (Throwable th3) {
                    Object[] objArr14 = new Object[1];
                    a(b3, (short) 385, (short) 237, objArr14);
                    int i4 = 60;
                    if (!Class.forName((String) objArr14[0]).isInstance(th3) || i3 < 2 || i3 > 32) {
                        Object[] objArr15 = new Object[1];
                        a(b3, (short) 1008, (short) 230, objArr15);
                        if (!Class.forName((String) objArr15[0]).isInstance(th3) || i3 < 27 || i3 > 28) {
                            Object[] objArr16 = new Object[1];
                            a(b3, (short) 974, (short) 234, objArr16);
                            if (!Class.forName((String) objArr16[0]).isInstance(th3) || i3 < 32 || i3 > 33) {
                                Object[] objArr17 = new Object[1];
                                a(b3, (short) 329, (short) 246, objArr17);
                                if (!Class.forName((String) objArr17[0]).isInstance(th3) || i3 < 50 || i3 > 51) {
                                    Object[] objArr18 = new Object[1];
                                    a(b3, PlaceComponentResult[680], (short) 236, objArr18);
                                    if (!Class.forName((String) objArr18[0]).isInstance(th3) || i3 < 57 || i3 > 59) {
                                        throw th3;
                                    }
                                }
                            }
                            istmpdetached.lookAheadTest = th3;
                            istmpdetached.MyBillsEntityDataFactory(46);
                            i2 = i4;
                        }
                    }
                    i4 = 1;
                    istmpdetached.lookAheadTest = th3;
                    istmpdetached.MyBillsEntityDataFactory(46);
                    i2 = i4;
                }
            }
            throw th3;
        } catch (Throwable th4) {
            Throwable cause3 = th4.getCause();
            if (cause3 != null) {
                throw cause3;
            }
            throw th4;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:95:0x02df, code lost:
    
        if (r11 <= 31) goto L76;
     */
    @Override // id.dana.contract.payasset.ChangePayMethodContract.Presenter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void BuiltInFictitiousFunctionClassFactory(java.lang.String r18, java.lang.String r19, java.lang.String r20) {
        /*
            Method dump skipped, instructions count: 910
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.contract.payasset.ChangePayMethodPresenter.BuiltInFictitiousFunctionClassFactory(java.lang.String, java.lang.String, java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:85:0x0291, code lost:
    
        if (r5 <= 22) goto L79;
     */
    @Override // id.dana.base.AbstractContract.AbstractPresenter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onDestroy() {
        /*
            Method dump skipped, instructions count: 976
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.contract.payasset.ChangePayMethodPresenter.onDestroy():void");
    }

    @Inject
    public ChangePayMethodPresenter(ChangePayMethodContract.View view, ChangePayMethod changePayMethod, IsOfflineF2FPay isOfflineF2FPay) {
        try {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
            try {
                this.getAuthRequestContext = changePayMethod;
                try {
                    this.MyBillsEntityDataFactory = isOfflineF2FPay;
                } catch (Exception e) {
                }
            } catch (IllegalStateException e2) {
                throw e2;
            }
        } catch (NullPointerException e3) {
            throw e3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: id.dana.contract.payasset.ChangePayMethodPresenter$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass1 extends DefaultObserver<Boolean> {
        final /* synthetic */ String BuiltInFictitiousFunctionClassFactory;
        final /* synthetic */ String PlaceComponentResult;
        final /* synthetic */ String getAuthRequestContext;

        AnonymousClass1(String str, String str2, String str3) {
            this.BuiltInFictitiousFunctionClassFactory = str;
            this.getAuthRequestContext = str2;
            this.PlaceComponentResult = str3;
        }

        @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
        public /* synthetic */ void onNext(Object obj) {
            if (((Boolean) obj).booleanValue()) {
                return;
            }
            ChangePayMethodPresenter.KClassImpl$Data$declaredNonStaticMembers$2(ChangePayMethodPresenter.this).showProgress();
            ChangePayMethod authRequestContext = ChangePayMethodPresenter.getAuthRequestContext(ChangePayMethodPresenter.this);
            String str = this.BuiltInFictitiousFunctionClassFactory;
            if (str == null) {
                str = "";
            }
            authRequestContext.execute(ChangePayMethod.Params.forChangePayMethod(str, this.getAuthRequestContext, this.PlaceComponentResult), new Function1() { // from class: id.dana.contract.payasset.ChangePayMethodPresenter$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    ChangePayMethodContract.View KClassImpl$Data$declaredNonStaticMembers$2 = ChangePayMethodPresenter.KClassImpl$Data$declaredNonStaticMembers$2(ChangePayMethodPresenter.this);
                    ((ChangePayMethodResponse) obj2).isSuccess();
                    KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult();
                    return Unit.INSTANCE;
                }
            }, new Function1() { // from class: id.dana.contract.payasset.ChangePayMethodPresenter$1$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return ChangePayMethodPresenter.AnonymousClass1.this.BuiltInFictitiousFunctionClassFactory((Throwable) obj2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final /* synthetic */ Unit BuiltInFictitiousFunctionClassFactory(Throwable th) {
            super.onError(th);
            ChangePayMethodPresenter.KClassImpl$Data$declaredNonStaticMembers$2(ChangePayMethodPresenter.this).dismissProgress();
            ChangePayMethodPresenter.KClassImpl$Data$declaredNonStaticMembers$2(ChangePayMethodPresenter.this).onError(th.getMessage());
            StringBuilder sb = new StringBuilder();
            sb.append(DanaLogConstants.Prefix.QRCODE_CHANGE_PAY_METHOD_PREFIX);
            sb.append(getClass().getName());
            sb.append(":onError");
            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.QRCODE_TAG, sb.toString(), th);
            return Unit.INSTANCE;
        }
    }
}
