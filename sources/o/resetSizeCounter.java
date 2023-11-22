package o;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.image.framework.utils.FileUtils;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.android.phone.mobilesdk.socketcraft.api.WSContextConstant;
import com.alipay.mobile.verifyidentity.business.securitycommon.widget.WheelView;
import com.alipay.zoloz.toyger.blob.BlobStatic;

/* loaded from: classes4.dex */
public class resetSizeCounter {
    public int BuiltInFictitiousFunctionClassFactory;
    private int DatabaseTableConfigUtil;
    private final long[] GetContactSyncConfig;
    public long KClassImpl$Data$declaredNonStaticMembers$2;
    public long MyBillsEntityDataFactory;
    public double NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final int[] NetworkUserEntityData$$ExternalSyntheticLambda1;
    private int NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final double[] NetworkUserEntityData$$ExternalSyntheticLambda8;
    public float PlaceComponentResult;
    public int getAuthRequestContext;
    public double getErrorConfigVersion;
    private final float[] initRecordTimeStamp;
    private final Object[] isLayoutRequested;
    public Object lookAheadTest;
    public float moveToNextValue;
    public Object scheduleImpl;

    public resetSizeCounter(Object obj) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new int[12];
        this.GetContactSyncConfig = new long[12];
        this.initRecordTimeStamp = new float[12];
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = new double[12];
        Object[] objArr = new Object[12];
        this.isLayoutRequested = objArr;
        objArr[8] = obj;
        this.DatabaseTableConfigUtil = 0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = -1;
    }

    public resetSizeCounter(Object obj, Object obj2) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new int[12];
        this.GetContactSyncConfig = new long[12];
        this.initRecordTimeStamp = new float[12];
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = new double[12];
        Object[] objArr = new Object[12];
        this.isLayoutRequested = objArr;
        objArr[8] = obj;
        objArr[9] = obj2;
        this.DatabaseTableConfigUtil = 0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = -1;
    }

    public resetSizeCounter(Object obj, Object obj2, Object obj3) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new int[12];
        this.GetContactSyncConfig = new long[12];
        this.initRecordTimeStamp = new float[12];
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = new double[12];
        Object[] objArr = new Object[12];
        this.isLayoutRequested = objArr;
        objArr[8] = obj;
        objArr[9] = obj2;
        objArr[10] = obj3;
        this.DatabaseTableConfigUtil = 0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = -1;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public int KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        switch (i) {
            case 1:
                Object[] objArr = this.isLayoutRequested;
                int i2 = this.DatabaseTableConfigUtil;
                Object obj = objArr[i2 - 1];
                objArr[i2 - 1] = null;
                this.lookAheadTest = obj;
                return 0;
            case 2:
                break;
            case 3:
                int[] iArr = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i3 = this.DatabaseTableConfigUtil;
                this.DatabaseTableConfigUtil = i3 + 1;
                iArr[i3] = this.getAuthRequestContext;
                break;
            case 4:
                int[] iArr2 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i4 = this.DatabaseTableConfigUtil;
                int i5 = i4 + 1;
                this.DatabaseTableConfigUtil = i5;
                iArr2[i4] = 83;
                int i6 = i5 + 2;
                this.DatabaseTableConfigUtil = i6;
                iArr2[i6 - 1] = iArr2[i6 - 3];
                iArr2[i5] = iArr2[i6 - 4];
                return 0;
            case 5:
                int[] iArr3 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i7 = this.DatabaseTableConfigUtil;
                int i8 = i7 + 2;
                this.DatabaseTableConfigUtil = i8;
                iArr3[i8 - 1] = iArr3[i8 - 3];
                iArr3[i7] = iArr3[i8 - 4];
                this.DatabaseTableConfigUtil = i8 + 1;
                iArr3[i8] = -1;
                return 0;
            case 6:
                int i9 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i9;
                int[] iArr4 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr4[i9 - 1] = iArr4[i9 - 1] ^ iArr4[i9];
                int i10 = i9 - 1;
                this.DatabaseTableConfigUtil = i10;
                iArr4[i10 - 1] = iArr4[i10] & iArr4[i10 - 1];
                return 0;
            case 7:
                int[] iArr5 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i11 = this.DatabaseTableConfigUtil;
                int i12 = i11 + 1;
                this.DatabaseTableConfigUtil = i12;
                int i13 = iArr5[i12 - 2];
                iArr5[i11] = i13;
                iArr5[i12 - 2] = iArr5[i12 - 3];
                iArr5[i12 - 3] = iArr5[i12 - 4];
                iArr5[i12 - 4] = i13;
                return 0;
            case 8:
                int i14 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i14;
                this.isLayoutRequested[i14] = null;
                return 0;
            case 9:
                int[] iArr6 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i15 = this.DatabaseTableConfigUtil;
                int i16 = iArr6[i15 - 1];
                iArr6[i15 - 1] = iArr6[i15 - 2];
                iArr6[i15 - 2] = i16;
                return 0;
            case 10:
                int[] iArr7 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i17 = this.DatabaseTableConfigUtil;
                this.DatabaseTableConfigUtil = i17 + 1;
                iArr7[i17] = -1;
                return 0;
            case 11:
                int i18 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i18;
                int[] iArr8 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr8[i18 - 1] = iArr8[i18] ^ iArr8[i18 - 1];
                return 0;
            case 12:
                int i19 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i19;
                int[] iArr9 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr9[i19 - 1] = iArr9[i19 - 1] & iArr9[i19];
                int i20 = i19 - 1;
                this.DatabaseTableConfigUtil = i20;
                iArr9[i20 - 1] = iArr9[i20 - 1] | iArr9[i20];
                int i21 = i20 + 1;
                this.DatabaseTableConfigUtil = i21;
                int i22 = iArr9[i21 - 2];
                iArr9[i20] = i22;
                iArr9[i21 - 2] = iArr9[i21 - 3];
                iArr9[i21 - 3] = iArr9[i21 - 4];
                iArr9[i21 - 4] = i22;
                return 0;
            case 13:
                int i23 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i23;
                this.isLayoutRequested[i23] = null;
                int[] iArr10 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i24 = i23 + 2;
                this.DatabaseTableConfigUtil = i24;
                iArr10[i24 - 1] = iArr10[i24 - 3];
                iArr10[i23] = iArr10[i24 - 4];
                this.DatabaseTableConfigUtil = i24 + 1;
                iArr10[i24] = -1;
                return 0;
            case 14:
                int i25 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i25;
                int[] iArr11 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr11[i25 - 1] = iArr11[i25 - 1] ^ iArr11[i25];
                int i26 = i25 - 1;
                this.DatabaseTableConfigUtil = i26;
                this.isLayoutRequested[i26] = null;
                return 0;
            case 15:
                int i27 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i27;
                int[] iArr12 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr12[i27 - 1] = iArr12[i27 - 1] & iArr12[i27];
                this.DatabaseTableConfigUtil = i27 + 1;
                iArr12[i27] = 1;
                return 0;
            case 16:
                int i28 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i28;
                int[] iArr13 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr13[i28 - 1] = iArr13[i28 - 1] << iArr13[i28];
                iArr13[i28 - 1] = -iArr13[i28 - 1];
                int i29 = i28 + 2;
                this.DatabaseTableConfigUtil = i29;
                iArr13[i29 - 1] = iArr13[i29 - 3];
                iArr13[i28] = iArr13[i29 - 4];
                return 0;
            case 17:
                int[] iArr14 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i30 = this.DatabaseTableConfigUtil;
                iArr14[i30 - 1] = -iArr14[i30 - 1];
                int i31 = i30 - 1;
                this.DatabaseTableConfigUtil = i31;
                iArr14[i31 - 1] = iArr14[i31] & iArr14[i31 - 1];
                return 0;
            case 18:
                int[] iArr15 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i32 = this.DatabaseTableConfigUtil;
                int i33 = i32 + 1;
                this.DatabaseTableConfigUtil = i33;
                int i34 = iArr15[i33 - 2];
                iArr15[i32] = i34;
                iArr15[i33 - 2] = iArr15[i33 - 3];
                iArr15[i33 - 3] = iArr15[i33 - 4];
                iArr15[i33 - 4] = i34;
                int i35 = i33 - 1;
                this.DatabaseTableConfigUtil = i35;
                this.isLayoutRequested[i35] = null;
                iArr15[i35 - 1] = -iArr15[i35 - 1];
                return 0;
            case 19:
                int i36 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i36;
                int[] iArr16 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr16[i36 - 1] = iArr16[i36 - 1] | iArr16[i36];
                int i37 = i36 - 1;
                this.DatabaseTableConfigUtil = i37;
                iArr16[i37 - 1] = iArr16[i37 - 1] + iArr16[i37];
                int i38 = i37 + 1;
                this.DatabaseTableConfigUtil = i38;
                iArr16[i37] = iArr16[i38 - 2];
                return 0;
            case 20:
                int i39 = this.DatabaseTableConfigUtil - this.getAuthRequestContext;
                this.DatabaseTableConfigUtil = i39;
                this.NetworkUserEntityData$$ExternalSyntheticLambda2 = i39;
                return 0;
            case 21:
                int[] iArr17 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i40 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                this.NetworkUserEntityData$$ExternalSyntheticLambda2 = i40 + 1;
                this.BuiltInFictitiousFunctionClassFactory = iArr17[i40];
                return 0;
            case 22:
                int[] iArr18 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i41 = this.DatabaseTableConfigUtil;
                int i42 = i41 + 1;
                this.DatabaseTableConfigUtil = i42;
                iArr18[i41] = 128;
                int i43 = i42 - 1;
                this.DatabaseTableConfigUtil = i43;
                iArr18[i43 - 1] = iArr18[i43 - 1] % iArr18[i43];
                return 0;
            case 23:
                int i44 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i44;
                this.BuiltInFictitiousFunctionClassFactory = this.NetworkUserEntityData$$ExternalSyntheticLambda1[i44] != 0 ? 1 : 0;
                return 0;
            case 24:
                int[] iArr19 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i45 = this.DatabaseTableConfigUtil;
                int i46 = i45 + 1;
                this.DatabaseTableConfigUtil = i46;
                iArr19[i45] = 2;
                int i47 = i46 - 1;
                this.DatabaseTableConfigUtil = i47;
                iArr19[i47 - 1] = iArr19[i47 - 1] % iArr19[i47];
                return 0;
            case 25:
                int[] iArr20 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i48 = this.DatabaseTableConfigUtil;
                this.DatabaseTableConfigUtil = i48 + 1;
                iArr20[i48] = 0;
                return 0;
            case 26:
                int[] iArr21 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i49 = this.DatabaseTableConfigUtil;
                this.DatabaseTableConfigUtil = i49 + 1;
                iArr21[i49] = 1;
                return 0;
            case 27:
                Object[] objArr2 = this.isLayoutRequested;
                int i50 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                this.NetworkUserEntityData$$ExternalSyntheticLambda2 = i50 + 1;
                Object obj2 = objArr2[i50];
                objArr2[i50] = null;
                this.lookAheadTest = obj2;
                return 0;
            case 28:
                Object[] objArr3 = this.isLayoutRequested;
                int i51 = this.DatabaseTableConfigUtil;
                this.DatabaseTableConfigUtil = i51 + 1;
                objArr3[i51] = this.scheduleImpl;
                return 0;
            case 29:
                Object[] objArr4 = this.isLayoutRequested;
                int i52 = this.DatabaseTableConfigUtil;
                this.DatabaseTableConfigUtil = i52 + 1;
                objArr4[i52] = objArr4[8];
                return 0;
            case 30:
                Object[] objArr5 = this.isLayoutRequested;
                int i53 = this.DatabaseTableConfigUtil;
                int i54 = i53 + 1;
                this.DatabaseTableConfigUtil = i54;
                objArr5[i53] = null;
                Object obj3 = objArr5[i54 - 1];
                objArr5[i54 - 1] = null;
                this.NetworkUserEntityData$$ExternalSyntheticLambda1[i54 - 1] = ((int[]) obj3).length;
                int i55 = i54 - 1;
                this.DatabaseTableConfigUtil = i55;
                objArr5[i55] = null;
                return 0;
            case 31:
                int[] iArr22 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i56 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i56;
                this.BuiltInFictitiousFunctionClassFactory = iArr22[i56];
                return 0;
            case 32:
                int[] iArr23 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i57 = this.DatabaseTableConfigUtil;
                int i58 = i57 + 1;
                this.DatabaseTableConfigUtil = i58;
                iArr23[i57] = 105;
                iArr23[i58 - 1] = -iArr23[i58 - 1];
                return 0;
            case 33:
                int[] iArr24 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i59 = this.DatabaseTableConfigUtil;
                int i60 = i59 + 2;
                this.DatabaseTableConfigUtil = i60;
                iArr24[i60 - 1] = iArr24[i60 - 3];
                iArr24[i59] = iArr24[i60 - 4];
                iArr24[i60 - 1] = -iArr24[i60 - 1];
                int i61 = i60 - 1;
                this.DatabaseTableConfigUtil = i61;
                iArr24[i61 - 1] = iArr24[i61] | iArr24[i61 - 1];
                return 0;
            case 34:
                int i62 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i62;
                int[] iArr25 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr25[i62 - 1] = iArr25[i62 - 1] << iArr25[i62];
                int i63 = i62 + 1;
                this.DatabaseTableConfigUtil = i63;
                int i64 = iArr25[i63 - 2];
                iArr25[i62] = i64;
                iArr25[i63 - 2] = iArr25[i63 - 3];
                iArr25[i63 - 3] = iArr25[i63 - 4];
                iArr25[i63 - 4] = i64;
                return 0;
            case 35:
                int[] iArr26 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i65 = this.DatabaseTableConfigUtil;
                iArr26[i65 - 1] = -iArr26[i65 - 1];
                return 0;
            case 36:
                int i66 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i66;
                int[] iArr27 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr27[i66 - 1] = iArr27[i66 - 1] - iArr27[i66];
                int i67 = i66 + 1;
                this.DatabaseTableConfigUtil = i67;
                iArr27[i66] = iArr27[i67 - 2];
                return 0;
            case 37:
                int[] iArr28 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i68 = this.DatabaseTableConfigUtil;
                this.DatabaseTableConfigUtil = i68 + 1;
                iArr28[i68] = 128;
                return 0;
            case 38:
                int i69 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i69;
                int[] iArr29 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr29[i69 - 1] = iArr29[i69 - 1] % iArr29[i69];
                return 0;
            case 39:
                int[] iArr30 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i70 = this.DatabaseTableConfigUtil;
                this.DatabaseTableConfigUtil = i70 + 1;
                iArr30[i70] = 2;
                return 0;
            case 40:
                int[] iArr31 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i71 = this.DatabaseTableConfigUtil;
                int i72 = i71 + 1;
                this.DatabaseTableConfigUtil = i72;
                iArr31[i71] = 2;
                int i73 = i72 + 1;
                this.DatabaseTableConfigUtil = i73;
                iArr31[i72] = 2;
                int i74 = i73 - 1;
                this.DatabaseTableConfigUtil = i74;
                iArr31[i74 - 1] = iArr31[i74 - 1] % iArr31[i74];
                return 0;
            case 41:
                for (int i75 = this.DatabaseTableConfigUtil - 1; i75 >= 0; i75--) {
                    this.isLayoutRequested[i75] = null;
                }
                this.DatabaseTableConfigUtil = 0;
                Object[] objArr6 = this.isLayoutRequested;
                this.DatabaseTableConfigUtil = 0 + 1;
                objArr6[0] = this.scheduleImpl;
                return 0;
            case 42:
                int[] iArr32 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i76 = this.DatabaseTableConfigUtil;
                this.DatabaseTableConfigUtil = i76 + 1;
                iArr32[i76] = 43;
                return 0;
            case 43:
                int[] iArr33 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i77 = this.DatabaseTableConfigUtil;
                int i78 = i77 + 2;
                this.DatabaseTableConfigUtil = i78;
                iArr33[i78 - 1] = iArr33[i78 - 3];
                iArr33[i77] = iArr33[i78 - 4];
                int i79 = i78 + 2;
                this.DatabaseTableConfigUtil = i79;
                iArr33[i79 - 1] = iArr33[i79 - 3];
                iArr33[i78] = iArr33[i79 - 4];
                this.DatabaseTableConfigUtil = i79 + 1;
                iArr33[i79] = -1;
                return 0;
            case 44:
                int i80 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i80;
                int[] iArr34 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr34[i80 - 1] = iArr34[i80 - 1] ^ iArr34[i80];
                int i81 = i80 - 1;
                this.DatabaseTableConfigUtil = i81;
                iArr34[i81 - 1] = iArr34[i81 - 1] ^ iArr34[i81];
                int i82 = i81 - 1;
                this.DatabaseTableConfigUtil = i82;
                this.isLayoutRequested[i82] = null;
                return 0;
            case 45:
                int i83 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i83;
                int[] iArr35 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr35[i83 - 1] = iArr35[i83] & iArr35[i83 - 1];
                return 0;
            case 46:
                int[] iArr36 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i84 = this.DatabaseTableConfigUtil;
                int i85 = i84 + 1;
                this.DatabaseTableConfigUtil = i85;
                int i86 = iArr36[i85 - 2];
                iArr36[i84] = i86;
                iArr36[i85 - 2] = iArr36[i85 - 3];
                iArr36[i85 - 3] = iArr36[i85 - 4];
                iArr36[i85 - 4] = i86;
                int i87 = i85 - 1;
                this.DatabaseTableConfigUtil = i87;
                this.isLayoutRequested[i87] = null;
                int i88 = i87 + 2;
                this.DatabaseTableConfigUtil = i88;
                iArr36[i88 - 1] = iArr36[i88 - 3];
                iArr36[i87] = iArr36[i88 - 4];
                return 0;
            case 47:
                int i89 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i89;
                int[] iArr37 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr37[i89 - 1] = iArr37[i89 - 1] ^ iArr37[i89];
                int i90 = i89 + 1;
                this.DatabaseTableConfigUtil = i90;
                int i91 = iArr37[i90 - 2];
                iArr37[i89] = i91;
                iArr37[i90 - 2] = iArr37[i90 - 3];
                iArr37[i90 - 3] = iArr37[i90 - 4];
                iArr37[i90 - 4] = i91;
                return 0;
            case 48:
                int i92 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i92;
                int[] iArr38 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr38[i92 - 1] = iArr38[i92 - 1] & iArr38[i92];
                int i93 = i92 - 1;
                this.DatabaseTableConfigUtil = i93;
                iArr38[i93 - 1] = iArr38[i93] | iArr38[i93 - 1];
                return 0;
            case 49:
                int i94 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i94;
                int[] iArr39 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr39[i94 - 1] = iArr39[i94 - 1] + iArr39[i94];
                int i95 = i94 + 1;
                this.DatabaseTableConfigUtil = i95;
                iArr39[i94] = iArr39[i95 - 2];
                return 0;
            case 50:
                int[] iArr40 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i96 = this.DatabaseTableConfigUtil;
                this.DatabaseTableConfigUtil = i96 + 1;
                iArr40[i96] = 35;
                return 0;
            case 51:
                int[] iArr41 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i97 = this.DatabaseTableConfigUtil;
                int i98 = i97 + 2;
                this.DatabaseTableConfigUtil = i98;
                iArr41[i98 - 1] = iArr41[i98 - 3];
                iArr41[i97] = iArr41[i98 - 4];
                int i99 = i98 + 2;
                this.DatabaseTableConfigUtil = i99;
                iArr41[i99 - 1] = iArr41[i99 - 3];
                iArr41[i98] = iArr41[i99 - 4];
                return 0;
            case 52:
                int[] iArr42 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i100 = this.DatabaseTableConfigUtil;
                int i101 = i100 + 1;
                this.DatabaseTableConfigUtil = i101;
                iArr42[i100] = -1;
                int i102 = i101 - 1;
                this.DatabaseTableConfigUtil = i102;
                iArr42[i102 - 1] = iArr42[i102 - 1] ^ iArr42[i102];
                int i103 = i102 - 1;
                this.DatabaseTableConfigUtil = i103;
                iArr42[i103 - 1] = iArr42[i103] ^ iArr42[i103 - 1];
                return 0;
            case 53:
                int i104 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i104;
                this.isLayoutRequested[i104] = null;
                int i105 = i104 - 1;
                this.DatabaseTableConfigUtil = i105;
                int[] iArr43 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr43[i105 - 1] = iArr43[i105 - 1] & iArr43[i105];
                int i106 = i105 + 1;
                this.DatabaseTableConfigUtil = i106;
                int i107 = iArr43[i106 - 2];
                iArr43[i105] = i107;
                iArr43[i106 - 2] = iArr43[i106 - 3];
                iArr43[i106 - 3] = iArr43[i106 - 4];
                iArr43[i106 - 4] = i107;
                return 0;
            case 54:
                int i108 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i108;
                this.isLayoutRequested[i108] = null;
                int i109 = i108 - 1;
                this.DatabaseTableConfigUtil = i109;
                int[] iArr44 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr44[i109 - 1] = iArr44[i109 - 1] | iArr44[i109];
                int i110 = i109 + 2;
                this.DatabaseTableConfigUtil = i110;
                iArr44[i110 - 1] = iArr44[i110 - 3];
                iArr44[i109] = iArr44[i110 - 4];
                return 0;
            case 55:
                int i111 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i111;
                int[] iArr45 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr45[i111 - 1] = iArr45[i111 - 1] & iArr45[i111];
                int i112 = i111 + 1;
                this.DatabaseTableConfigUtil = i112;
                int i113 = iArr45[i112 - 2];
                iArr45[i111] = i113;
                iArr45[i112 - 2] = iArr45[i112 - 3];
                iArr45[i112 - 3] = iArr45[i112 - 4];
                iArr45[i112 - 4] = i113;
                return 0;
            case 56:
                int i114 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i114;
                int[] iArr46 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr46[i114 - 1] = iArr46[i114] | iArr46[i114 - 1];
                return 0;
            case 57:
                int i115 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i115;
                this.BuiltInFictitiousFunctionClassFactory = this.NetworkUserEntityData$$ExternalSyntheticLambda1[i115] == 0 ? 1 : 0;
                return 0;
            case 58:
                int[] iArr47 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i116 = this.DatabaseTableConfigUtil;
                this.DatabaseTableConfigUtil = i116 + 1;
                iArr47[i116] = 44;
                return 0;
            case 59:
                int[] iArr48 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i117 = this.DatabaseTableConfigUtil;
                int i118 = i117 + 1;
                this.DatabaseTableConfigUtil = i118;
                iArr48[i117] = 30;
                this.DatabaseTableConfigUtil = i118 + 1;
                iArr48[i118] = 0;
                return 0;
            case 60:
                int i119 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i119;
                int[] iArr49 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr49[i119 - 1] = iArr49[i119 - 1] / iArr49[i119];
                int i120 = i119 - 1;
                this.DatabaseTableConfigUtil = i120;
                this.isLayoutRequested[i120] = null;
                return 0;
            case 61:
                int[] iArr50 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i121 = this.DatabaseTableConfigUtil;
                this.DatabaseTableConfigUtil = i121 + 1;
                iArr50[i121] = 68;
                return 0;
            case 62:
                int[] iArr51 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i122 = this.DatabaseTableConfigUtil;
                this.DatabaseTableConfigUtil = i122 + 1;
                iArr51[i122] = 25;
                return 0;
            case 63:
                int[] iArr52 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i123 = this.DatabaseTableConfigUtil;
                this.DatabaseTableConfigUtil = i123 + 1;
                iArr52[i123] = 111;
                return 0;
            case 64:
                int[] iArr53 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i124 = this.DatabaseTableConfigUtil;
                iArr53[i124 - 1] = -iArr53[i124 - 1];
                int i125 = i124 + 2;
                this.DatabaseTableConfigUtil = i125;
                iArr53[i125 - 1] = iArr53[i125 - 3];
                iArr53[i124] = iArr53[i125 - 4];
                iArr53[i125 - 1] = -iArr53[i125 - 1];
                return 0;
            case 65:
                int[] iArr54 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i126 = this.DatabaseTableConfigUtil;
                int i127 = i126 + 2;
                this.DatabaseTableConfigUtil = i127;
                iArr54[i127 - 1] = iArr54[i127 - 3];
                iArr54[i126] = iArr54[i127 - 4];
                return 0;
            case 66:
                int i128 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i128;
                int[] iArr55 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr55[i128 - 1] = iArr55[i128 - 1] ^ iArr55[i128];
                int i129 = i128 - 1;
                this.DatabaseTableConfigUtil = i129;
                iArr55[i129 - 1] = iArr55[i129] ^ iArr55[i129 - 1];
                return 0;
            case 67:
                int i130 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i130;
                int[] iArr56 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr56[i130 - 1] = iArr56[i130 - 1] & iArr56[i130];
                int i131 = i130 + 1;
                this.DatabaseTableConfigUtil = i131;
                int i132 = iArr56[i131 - 2];
                iArr56[i130] = i132;
                iArr56[i131 - 2] = iArr56[i131 - 3];
                iArr56[i131 - 3] = iArr56[i131 - 4];
                iArr56[i131 - 4] = i132;
                int i133 = i131 - 1;
                this.DatabaseTableConfigUtil = i133;
                this.isLayoutRequested[i133] = null;
                return 0;
            case 68:
                int[] iArr57 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i134 = this.DatabaseTableConfigUtil;
                iArr57[i134 - 1] = -iArr57[i134 - 1];
                int i135 = i134 + 2;
                this.DatabaseTableConfigUtil = i135;
                iArr57[i135 - 1] = iArr57[i135 - 3];
                iArr57[i134] = iArr57[i135 - 4];
                return 0;
            case 69:
                int i136 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i136;
                this.isLayoutRequested[i136] = null;
                int i137 = i136 - 1;
                this.DatabaseTableConfigUtil = i137;
                int[] iArr58 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr58[i137 - 1] = iArr58[i137] & iArr58[i137 - 1];
                return 0;
            case 70:
                int[] iArr59 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i138 = this.DatabaseTableConfigUtil;
                int i139 = i138 + 2;
                this.DatabaseTableConfigUtil = i139;
                iArr59[i139 - 1] = iArr59[i139 - 3];
                iArr59[i138] = iArr59[i139 - 4];
                int i140 = i139 - 1;
                this.DatabaseTableConfigUtil = i140;
                iArr59[i140 - 1] = iArr59[i140 - 1] ^ iArr59[i140];
                int i141 = i140 + 1;
                this.DatabaseTableConfigUtil = i141;
                int i142 = iArr59[i141 - 2];
                iArr59[i140] = i142;
                iArr59[i141 - 2] = iArr59[i141 - 3];
                iArr59[i141 - 3] = iArr59[i141 - 4];
                iArr59[i141 - 4] = i142;
                return 0;
            case 71:
                int i143 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i143;
                int[] iArr60 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr60[i143 - 1] = iArr60[i143 - 1] & iArr60[i143];
                int i144 = i143 + 1;
                this.DatabaseTableConfigUtil = i144;
                iArr60[i143] = 1;
                int i145 = i144 - 1;
                this.DatabaseTableConfigUtil = i145;
                iArr60[i145 - 1] = iArr60[i145 - 1] << iArr60[i145];
                return 0;
            case 72:
                int i146 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i146;
                int[] iArr61 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr61[i146 - 1] = iArr61[i146 - 1] + iArr61[i146];
                return 0;
            case 73:
                int[] iArr62 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i147 = this.DatabaseTableConfigUtil;
                int i148 = i147 + 1;
                this.DatabaseTableConfigUtil = i148;
                iArr62[i147] = iArr62[i148 - 2];
                this.DatabaseTableConfigUtil = i148 + 1;
                iArr62[i148] = 128;
                return 0;
            case 74:
                Object[] objArr7 = this.isLayoutRequested;
                int i149 = this.DatabaseTableConfigUtil;
                this.DatabaseTableConfigUtil = i149 + 1;
                objArr7[i149] = null;
                return 0;
            case 75:
                Object[] objArr8 = this.isLayoutRequested;
                int i150 = this.DatabaseTableConfigUtil;
                int i151 = i150 + 1;
                this.DatabaseTableConfigUtil = i151;
                objArr8[i150] = objArr8[8];
                this.DatabaseTableConfigUtil = i151 + 1;
                objArr8[i151] = objArr8[9];
                return 0;
            case 76:
                int[] iArr63 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i152 = this.DatabaseTableConfigUtil;
                this.DatabaseTableConfigUtil = i152 + 1;
                iArr63[i152] = 23;
                return 0;
            case 77:
                Object[] objArr9 = this.isLayoutRequested;
                int i153 = this.DatabaseTableConfigUtil;
                this.DatabaseTableConfigUtil = i153 + 1;
                objArr9[i153] = objArr9[9];
                return 0;
            case 78:
                int i154 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i154;
                int[] iArr64 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr64[i154 - 1] = iArr64[i154 - 1] % iArr64[i154];
                int i155 = i154 - 1;
                this.DatabaseTableConfigUtil = i155;
                this.isLayoutRequested[i155] = null;
                return 0;
            case 79:
                int[] iArr65 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i156 = this.DatabaseTableConfigUtil;
                int i157 = i156 + 1;
                this.DatabaseTableConfigUtil = i157;
                iArr65[i156] = 29;
                int i158 = i157 + 2;
                this.DatabaseTableConfigUtil = i158;
                iArr65[i158 - 1] = iArr65[i158 - 3];
                iArr65[i157] = iArr65[i158 - 4];
                return 0;
            case 80:
                int i159 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i159;
                this.isLayoutRequested[i159] = null;
                int[] iArr66 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i160 = iArr66[i159 - 1];
                iArr66[i159 - 1] = iArr66[i159 - 2];
                iArr66[i159 - 2] = i160;
                this.DatabaseTableConfigUtil = i159 + 1;
                iArr66[i159] = -1;
                return 0;
            case 81:
                int i161 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i161;
                int[] iArr67 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr67[i161 - 1] = iArr67[i161 - 1] | iArr67[i161];
                int i162 = i161 + 1;
                this.DatabaseTableConfigUtil = i162;
                int i163 = iArr67[i162 - 2];
                iArr67[i161] = i163;
                iArr67[i162 - 2] = iArr67[i162 - 3];
                iArr67[i162 - 3] = iArr67[i162 - 4];
                iArr67[i162 - 4] = i163;
                int i164 = i162 - 1;
                this.DatabaseTableConfigUtil = i164;
                this.isLayoutRequested[i164] = null;
                return 0;
            case 82:
                Object[] objArr10 = this.isLayoutRequested;
                int i165 = this.DatabaseTableConfigUtil;
                int i166 = i165 + 1;
                this.DatabaseTableConfigUtil = i166;
                objArr10[i165] = objArr10[9];
                int i167 = i166 + 1;
                this.DatabaseTableConfigUtil = i167;
                objArr10[i166] = objArr10[8];
                this.DatabaseTableConfigUtil = i167 + 1;
                objArr10[i167] = objArr10[9];
                return 0;
            case 83:
                int[] iArr68 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i168 = this.DatabaseTableConfigUtil;
                this.DatabaseTableConfigUtil = i168 + 1;
                iArr68[i168] = 109;
                return 0;
            case 84:
                int[] iArr69 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i169 = this.DatabaseTableConfigUtil;
                int i170 = i169 + 1;
                this.DatabaseTableConfigUtil = i170;
                iArr69[i169] = iArr69[i170 - 2];
                return 0;
            case 85:
                int[] iArr70 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i171 = this.DatabaseTableConfigUtil;
                int i172 = i171 + 1;
                this.DatabaseTableConfigUtil = i172;
                iArr70[i171] = -1;
                int i173 = i172 - 1;
                this.DatabaseTableConfigUtil = i173;
                iArr70[i173 - 1] = iArr70[i173] ^ iArr70[i173 - 1];
                return 0;
            case 86:
                int[] iArr71 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i174 = this.DatabaseTableConfigUtil;
                int i175 = i174 + 1;
                this.DatabaseTableConfigUtil = i175;
                int i176 = iArr71[i175 - 2];
                iArr71[i174] = i176;
                iArr71[i175 - 2] = iArr71[i175 - 3];
                iArr71[i175 - 3] = iArr71[i175 - 4];
                iArr71[i175 - 4] = i176;
                int i177 = i175 - 1;
                this.DatabaseTableConfigUtil = i177;
                this.isLayoutRequested[i177] = null;
                int i178 = i177 - 1;
                this.DatabaseTableConfigUtil = i178;
                iArr71[i178 - 1] = iArr71[i178] | iArr71[i178 - 1];
                return 0;
            case 87:
                int i179 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i179;
                int[] iArr72 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr72[i179 - 1] = iArr72[i179 - 1] & iArr72[i179];
                int i180 = iArr72[i179 - 1];
                iArr72[i179 - 1] = iArr72[i179 - 2];
                iArr72[i179 - 2] = i180;
                return 0;
            case 88:
                int i181 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i181;
                this.isLayoutRequested[i181] = null;
                int[] iArr73 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i182 = i181 + 2;
                this.DatabaseTableConfigUtil = i182;
                iArr73[i182 - 1] = iArr73[i182 - 3];
                iArr73[i181] = iArr73[i182 - 4];
                iArr73[i182 - 1] = -iArr73[i182 - 1];
                return 0;
            case 89:
                int i183 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i183;
                int[] iArr74 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr74[i183 - 1] = iArr74[i183 - 1] << iArr74[i183];
                int i184 = i183 - 1;
                this.DatabaseTableConfigUtil = i184;
                iArr74[i184 - 1] = iArr74[i184 - 1] + iArr74[i184];
                this.DatabaseTableConfigUtil = i184 + 1;
                iArr74[i184] = 1;
                return 0;
            case 90:
                int[] iArr75 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i185 = this.DatabaseTableConfigUtil;
                int i186 = i185 + 1;
                this.DatabaseTableConfigUtil = i186;
                iArr75[i185] = iArr75[i186 - 2];
                int i187 = i186 + 1;
                this.DatabaseTableConfigUtil = i187;
                iArr75[i186] = 128;
                int i188 = i187 - 1;
                this.DatabaseTableConfigUtil = i188;
                iArr75[i188 - 1] = iArr75[i188 - 1] % iArr75[i188];
                return 0;
            case 91:
                int[] iArr76 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i189 = this.DatabaseTableConfigUtil;
                int i190 = i189 + 1;
                this.DatabaseTableConfigUtil = i190;
                iArr76[i189] = 19;
                iArr76[i190 - 1] = -iArr76[i190 - 1];
                return 0;
            case 92:
                int[] iArr77 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i191 = this.DatabaseTableConfigUtil;
                iArr77[i191 - 1] = -iArr77[i191 - 1];
                this.DatabaseTableConfigUtil = i191 + 1;
                iArr77[i191] = -1;
                return 0;
            case 93:
                int i192 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i192;
                int[] iArr78 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr78[i192 - 1] = iArr78[i192 - 1] & iArr78[i192];
                this.DatabaseTableConfigUtil = i192 + 1;
                iArr78[i192] = -1;
                return 0;
            case 94:
                int i193 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i193;
                this.isLayoutRequested[i193] = null;
                int i194 = i193 - 1;
                this.DatabaseTableConfigUtil = i194;
                int[] iArr79 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr79[i194 - 1] = iArr79[i194 - 1] | iArr79[i194];
                int i195 = i194 - 1;
                this.DatabaseTableConfigUtil = i195;
                iArr79[i195 - 1] = iArr79[i195] & iArr79[i195 - 1];
                return 0;
            case 95:
                int[] iArr80 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i196 = this.DatabaseTableConfigUtil;
                int i197 = iArr80[i196 - 1];
                iArr80[i196 - 1] = iArr80[i196 - 2];
                iArr80[i196 - 2] = i197;
                int i198 = i196 - 1;
                this.DatabaseTableConfigUtil = i198;
                this.isLayoutRequested[i198] = null;
                return 0;
            case 96:
                int[] iArr81 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i199 = this.DatabaseTableConfigUtil;
                int i200 = i199 + 1;
                this.DatabaseTableConfigUtil = i200;
                iArr81[i199] = iArr81[i200 - 2];
                iArr81[i200 - 1] = -iArr81[i200 - 1];
                this.DatabaseTableConfigUtil = i200 + 1;
                iArr81[i200] = -1;
                return 0;
            case 97:
                int i201 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i201;
                int[] iArr82 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr82[i201 - 1] = iArr82[i201 - 1] ^ iArr82[i201];
                int i202 = iArr82[i201 - 1];
                iArr82[i201 - 1] = iArr82[i201 - 2];
                iArr82[i201 - 2] = i202;
                return 0;
            case 98:
                int i203 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i203;
                this.isLayoutRequested[i203] = null;
                int i204 = i203 - 1;
                this.DatabaseTableConfigUtil = i204;
                int[] iArr83 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr83[i204 - 1] = iArr83[i204 - 1] - iArr83[i204];
                return 0;
            case 99:
                int[] iArr84 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i205 = this.DatabaseTableConfigUtil;
                int i206 = i205 + 1;
                this.DatabaseTableConfigUtil = i206;
                iArr84[i205] = 1;
                int i207 = i206 - 1;
                this.DatabaseTableConfigUtil = i207;
                iArr84[i207 - 1] = iArr84[i207 - 1] - iArr84[i207];
                return 0;
            case 100:
                int[] iArr85 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i208 = this.DatabaseTableConfigUtil;
                int i209 = i208 + 1;
                this.DatabaseTableConfigUtil = i209;
                iArr85[i208] = 1;
                int i210 = i209 - 1;
                this.DatabaseTableConfigUtil = i210;
                iArr85[i210 - 1] = iArr85[i210 - 1] - iArr85[i210];
                int i211 = i210 + 1;
                this.DatabaseTableConfigUtil = i211;
                iArr85[i210] = iArr85[i211 - 2];
                return 0;
            case 101:
                int[] iArr86 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i212 = this.DatabaseTableConfigUtil;
                Object[] objArr11 = this.isLayoutRequested;
                Object obj4 = objArr11[i212 - 1];
                objArr11[i212 - 1] = null;
                iArr86[i212 - 1] = ((int[]) obj4).length;
                return 0;
            case 102:
                int[] iArr87 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i213 = this.DatabaseTableConfigUtil;
                this.DatabaseTableConfigUtil = i213 + 1;
                iArr87[i213] = 86;
                return 0;
            case 103:
                int[] iArr88 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i214 = this.DatabaseTableConfigUtil;
                this.DatabaseTableConfigUtil = i214 + 1;
                iArr88[i214] = 10;
                return 0;
            case 104:
                int[] iArr89 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i215 = this.DatabaseTableConfigUtil;
                this.DatabaseTableConfigUtil = i215 + 1;
                iArr89[i215] = 75;
                return 0;
            case 105:
                int[] iArr90 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i216 = this.DatabaseTableConfigUtil;
                int i217 = i216 + 2;
                this.DatabaseTableConfigUtil = i217;
                iArr90[i217 - 1] = iArr90[i217 - 3];
                iArr90[i216] = iArr90[i217 - 4];
                int i218 = i217 - 1;
                this.DatabaseTableConfigUtil = i218;
                iArr90[i218 - 1] = iArr90[i218] & iArr90[i218 - 1];
                return 0;
            case 106:
                int[] iArr91 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i219 = this.DatabaseTableConfigUtil;
                int i220 = i219 + 1;
                this.DatabaseTableConfigUtil = i220;
                int i221 = iArr91[i220 - 2];
                iArr91[i219] = i221;
                iArr91[i220 - 2] = iArr91[i220 - 3];
                iArr91[i220 - 3] = iArr91[i220 - 4];
                iArr91[i220 - 4] = i221;
                int i222 = i220 - 1;
                this.DatabaseTableConfigUtil = i222;
                this.isLayoutRequested[i222] = null;
                return 0;
            case 107:
                int[] iArr92 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i223 = this.DatabaseTableConfigUtil;
                this.DatabaseTableConfigUtil = i223 + 1;
                iArr92[i223] = 0;
                return 0;
            case 108:
                int i224 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i224;
                int[] iArr93 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr93[i224 - 1] = iArr93[i224 - 1] / iArr93[i224];
                return 0;
            case 109:
                int[] iArr94 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i225 = this.DatabaseTableConfigUtil;
                this.DatabaseTableConfigUtil = i225 + 1;
                iArr94[i225] = 24;
                return 0;
            case 110:
                int[] iArr95 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i226 = this.DatabaseTableConfigUtil;
                this.DatabaseTableConfigUtil = i226 + 1;
                iArr95[i226] = 11;
                return 0;
            case 111:
                int[] iArr96 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i227 = this.DatabaseTableConfigUtil;
                iArr96[i227 - 1] = -iArr96[i227 - 1];
                int i228 = i227 + 1;
                this.DatabaseTableConfigUtil = i228;
                iArr96[i227] = iArr96[i228 - 2];
                iArr96[i228 - 1] = -iArr96[i228 - 1];
                return 0;
            case 112:
                int i229 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i229;
                int[] iArr97 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr97[i229 - 1] = iArr97[i229 - 1] ^ iArr97[i229];
                int i230 = iArr97[i229 - 1];
                iArr97[i229 - 1] = iArr97[i229 - 2];
                iArr97[i229 - 2] = i230;
                int i231 = i229 - 1;
                this.DatabaseTableConfigUtil = i231;
                this.isLayoutRequested[i231] = null;
                return 0;
            case 113:
                int i232 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i232;
                int[] iArr98 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr98[i232 - 1] = iArr98[i232 - 1] - iArr98[i232];
                return 0;
            case 114:
                int[] iArr99 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i233 = this.DatabaseTableConfigUtil;
                int i234 = i233 + 1;
                this.DatabaseTableConfigUtil = i234;
                iArr99[i233] = 2;
                this.DatabaseTableConfigUtil = i234 + 1;
                iArr99[i234] = 2;
                return 0;
            case 115:
                int[] iArr100 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i235 = this.DatabaseTableConfigUtil;
                this.DatabaseTableConfigUtil = i235 + 1;
                iArr100[i235] = 103;
                return 0;
            case 116:
                int i236 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i236;
                int[] iArr101 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr101[i236 - 1] = iArr101[i236 - 1] | iArr101[i236];
                this.DatabaseTableConfigUtil = i236 + 1;
                iArr101[i236] = 1;
                return 0;
            case 117:
                int i237 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i237;
                int[] iArr102 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr102[i237 - 1] = iArr102[i237 - 1] << iArr102[i237];
                return 0;
            case 118:
                int[] iArr103 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i238 = this.DatabaseTableConfigUtil;
                int i239 = i238 + 2;
                this.DatabaseTableConfigUtil = i239;
                iArr103[i239 - 1] = iArr103[i239 - 3];
                iArr103[i238] = iArr103[i239 - 4];
                int i240 = i239 + 1;
                this.DatabaseTableConfigUtil = i240;
                iArr103[i239] = -1;
                int i241 = i240 - 1;
                this.DatabaseTableConfigUtil = i241;
                iArr103[i241 - 1] = iArr103[i241] ^ iArr103[i241 - 1];
                return 0;
            case 119:
                int[] iArr104 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i242 = this.DatabaseTableConfigUtil;
                int i243 = iArr104[i242 - 1];
                iArr104[i242 - 1] = iArr104[i242 - 2];
                iArr104[i242 - 2] = i243;
                int i244 = i242 + 1;
                this.DatabaseTableConfigUtil = i244;
                iArr104[i242] = -1;
                int i245 = i244 - 1;
                this.DatabaseTableConfigUtil = i245;
                iArr104[i245 - 1] = iArr104[i245] ^ iArr104[i245 - 1];
                return 0;
            case 120:
                int[] iArr105 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i246 = this.DatabaseTableConfigUtil;
                iArr105[i246 - 1] = -iArr105[i246 - 1];
                int i247 = i246 + 2;
                this.DatabaseTableConfigUtil = i247;
                iArr105[i247 - 1] = iArr105[i247 - 3];
                iArr105[i246] = iArr105[i247 - 4];
                int i248 = i247 - 1;
                this.DatabaseTableConfigUtil = i248;
                iArr105[i248 - 1] = iArr105[i248] & iArr105[i248 - 1];
                return 0;
            case 121:
                int i249 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i249;
                this.isLayoutRequested[i249] = null;
                int i250 = i249 - 1;
                this.DatabaseTableConfigUtil = i250;
                int[] iArr106 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr106[i250 - 1] = iArr106[i250] | iArr106[i250 - 1];
                return 0;
            case 122:
                int[] iArr107 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i251 = this.DatabaseTableConfigUtil;
                int i252 = i251 + 1;
                this.DatabaseTableConfigUtil = i252;
                iArr107[i251] = 59;
                int i253 = i252 + 2;
                this.DatabaseTableConfigUtil = i253;
                iArr107[i253 - 1] = iArr107[i253 - 3];
                iArr107[i252] = iArr107[i253 - 4];
                return 0;
            case 123:
                int i254 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i254;
                int[] iArr108 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr108[i254 - 1] = iArr108[i254 - 1] & iArr108[i254];
                int i255 = i254 - 1;
                this.DatabaseTableConfigUtil = i255;
                iArr108[i255 - 1] = iArr108[i255 - 1] | iArr108[i255];
                this.DatabaseTableConfigUtil = i255 + 1;
                iArr108[i255] = 1;
                return 0;
            case 124:
                int[] iArr109 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i256 = this.DatabaseTableConfigUtil;
                int i257 = i256 + 1;
                this.DatabaseTableConfigUtil = i257;
                iArr109[i256] = -1;
                int i258 = i257 - 1;
                this.DatabaseTableConfigUtil = i258;
                iArr109[i258 - 1] = iArr109[i258 - 1] ^ iArr109[i258];
                int i259 = i258 + 1;
                this.DatabaseTableConfigUtil = i259;
                int i260 = iArr109[i259 - 2];
                iArr109[i258] = i260;
                iArr109[i259 - 2] = iArr109[i259 - 3];
                iArr109[i259 - 3] = iArr109[i259 - 4];
                iArr109[i259 - 4] = i260;
                return 0;
            case 125:
                int i261 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i261;
                int[] iArr110 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr110[i261 - 1] = iArr110[i261 - 1] & iArr110[i261];
                iArr110[i261 - 1] = -iArr110[i261 - 1];
                return 0;
            case 126:
                int[] iArr111 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i262 = this.DatabaseTableConfigUtil;
                int i263 = i262 + 1;
                this.DatabaseTableConfigUtil = i263;
                iArr111[i262] = iArr111[i263 - 2];
                this.DatabaseTableConfigUtil = i263 + 1;
                iArr111[i263] = -1;
                return 0;
            case 127:
                int i264 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i264;
                int[] iArr112 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr112[i264 - 1] = iArr112[i264 - 1] - iArr112[i264];
                this.DatabaseTableConfigUtil = i264 + 1;
                iArr112[i264] = 1;
                return 0;
            case 128:
                int[] iArr113 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i265 = this.DatabaseTableConfigUtil;
                this.DatabaseTableConfigUtil = i265 + 1;
                iArr113[i265] = 77;
                return 0;
            case 129:
                int[] iArr114 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i266 = this.DatabaseTableConfigUtil;
                int i267 = i266 + 2;
                this.DatabaseTableConfigUtil = i267;
                iArr114[i267 - 1] = iArr114[i267 - 3];
                iArr114[i266] = iArr114[i267 - 4];
                int i268 = i267 - 1;
                this.DatabaseTableConfigUtil = i268;
                iArr114[i268 - 1] = iArr114[i268] ^ iArr114[i268 - 1];
                return 0;
            case 130:
                int i269 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i269;
                this.isLayoutRequested[i269] = null;
                int i270 = i269 - 1;
                this.DatabaseTableConfigUtil = i270;
                int[] iArr115 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr115[i270 - 1] = iArr115[i270 - 1] & iArr115[i270];
                this.DatabaseTableConfigUtil = i270 + 1;
                iArr115[i270] = 1;
                return 0;
            case 131:
                int[] iArr116 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i271 = this.DatabaseTableConfigUtil;
                Object[] objArr12 = this.isLayoutRequested;
                Object obj5 = objArr12[i271 - 1];
                objArr12[i271 - 1] = null;
                iArr116[i271 - 1] = ((int[]) obj5).length;
                int i272 = i271 - 1;
                this.DatabaseTableConfigUtil = i272;
                objArr12[i272] = null;
                return 0;
            case 132:
                int[] iArr117 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i273 = this.DatabaseTableConfigUtil;
                this.DatabaseTableConfigUtil = i273 + 1;
                iArr117[i273] = 29;
                return 0;
            case 133:
                int[] iArr118 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i274 = this.DatabaseTableConfigUtil;
                int i275 = i274 + 1;
                this.DatabaseTableConfigUtil = i275;
                iArr118[i274] = iArr118[i275 - 2];
                int i276 = i275 + 1;
                this.DatabaseTableConfigUtil = i276;
                iArr118[i275] = -1;
                int i277 = i276 - 1;
                this.DatabaseTableConfigUtil = i277;
                iArr118[i277 - 1] = iArr118[i277] ^ iArr118[i277 - 1];
                return 0;
            case 134:
                int[] iArr119 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i278 = this.DatabaseTableConfigUtil;
                int i279 = i278 + 1;
                this.DatabaseTableConfigUtil = i279;
                int i280 = iArr119[i279 - 2];
                iArr119[i278] = i280;
                iArr119[i279 - 2] = iArr119[i279 - 3];
                iArr119[i279 - 3] = iArr119[i279 - 4];
                iArr119[i279 - 4] = i280;
                int i281 = i279 - 1;
                this.DatabaseTableConfigUtil = i281;
                this.isLayoutRequested[i281] = null;
                int i282 = i281 - 1;
                this.DatabaseTableConfigUtil = i282;
                iArr119[i282 - 1] = iArr119[i282] & iArr119[i282 - 1];
                return 0;
            case 135:
                int i283 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i283;
                this.isLayoutRequested[i283] = null;
                int i284 = i283 - 1;
                this.DatabaseTableConfigUtil = i284;
                int[] iArr120 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr120[i284 - 1] = iArr120[i284 - 1] ^ iArr120[i284];
                int i285 = i284 - 1;
                this.DatabaseTableConfigUtil = i285;
                iArr120[i285 - 1] = iArr120[i285 - 1] - iArr120[i285];
                return 0;
            case 136:
                int[] iArr121 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i286 = this.DatabaseTableConfigUtil;
                int i287 = i286 + 1;
                this.DatabaseTableConfigUtil = i287;
                iArr121[i286] = 13;
                int i288 = i287 + 2;
                this.DatabaseTableConfigUtil = i288;
                iArr121[i288 - 1] = iArr121[i288 - 3];
                iArr121[i287] = iArr121[i288 - 4];
                int i289 = i288 - 1;
                this.DatabaseTableConfigUtil = i289;
                iArr121[i289 - 1] = iArr121[i289] | iArr121[i289 - 1];
                return 0;
            case 137:
                int i290 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i290;
                int[] iArr122 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr122[i290 - 1] = iArr122[i290 - 1] ^ iArr122[i290];
                int i291 = i290 - 1;
                this.DatabaseTableConfigUtil = i291;
                iArr122[i291 - 1] = iArr122[i291 - 1] - iArr122[i291];
                return 0;
            case 138:
                int[] iArr123 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i292 = this.DatabaseTableConfigUtil;
                this.DatabaseTableConfigUtil = i292 + 1;
                iArr123[i292] = 70;
                return 0;
            case 139:
                int[] iArr124 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i293 = this.DatabaseTableConfigUtil;
                this.DatabaseTableConfigUtil = i293 + 1;
                iArr124[i293] = 79;
                return 0;
            case 140:
                int i294 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i294;
                this.isLayoutRequested[i294] = null;
                int i295 = i294 - 1;
                this.DatabaseTableConfigUtil = i295;
                int[] iArr125 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr125[i295 - 1] = iArr125[i295 - 1] & iArr125[i295];
                int i296 = i295 - 1;
                this.DatabaseTableConfigUtil = i296;
                iArr125[i296 - 1] = iArr125[i296] | iArr125[i296 - 1];
                return 0;
            case 141:
                int[] iArr126 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i297 = this.DatabaseTableConfigUtil;
                this.DatabaseTableConfigUtil = i297 + 1;
                iArr126[i297] = 42;
                return 0;
            case 142:
                int[] iArr127 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i298 = this.DatabaseTableConfigUtil;
                int i299 = i298 + 1;
                this.DatabaseTableConfigUtil = i299;
                iArr127[i298] = 95;
                int i300 = i299 + 2;
                this.DatabaseTableConfigUtil = i300;
                iArr127[i300 - 1] = iArr127[i300 - 3];
                iArr127[i299] = iArr127[i300 - 4];
                return 0;
            case 143:
                int[] iArr128 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i301 = this.DatabaseTableConfigUtil;
                int i302 = i301 + 2;
                this.DatabaseTableConfigUtil = i302;
                iArr128[i302 - 1] = iArr128[i302 - 3];
                iArr128[i301] = iArr128[i302 - 4];
                int i303 = i302 - 1;
                this.DatabaseTableConfigUtil = i303;
                iArr128[i303 - 1] = iArr128[i303 - 1] & iArr128[i303];
                this.DatabaseTableConfigUtil = i303 + 1;
                iArr128[i303] = -1;
                return 0;
            case 144:
                int[] iArr129 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i304 = this.DatabaseTableConfigUtil;
                int i305 = i304 + 1;
                this.DatabaseTableConfigUtil = i305;
                iArr129[i304] = 71;
                int i306 = i305 + 2;
                this.DatabaseTableConfigUtil = i306;
                iArr129[i306 - 1] = iArr129[i306 - 3];
                iArr129[i305] = iArr129[i306 - 4];
                return 0;
            case 145:
                int i307 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i307;
                int[] iArr130 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr130[i307 - 1] = iArr130[i307 - 1] | iArr130[i307];
                int i308 = i307 + 1;
                this.DatabaseTableConfigUtil = i308;
                iArr130[i307] = 1;
                int i309 = i308 - 1;
                this.DatabaseTableConfigUtil = i309;
                iArr130[i309 - 1] = iArr130[i309 - 1] << iArr130[i309];
                return 0;
            case 146:
                int i310 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i310;
                int[] iArr131 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr131[i310 - 1] = iArr131[i310 - 1] + iArr131[i310];
                int i311 = i310 + 1;
                this.DatabaseTableConfigUtil = i311;
                iArr131[i310] = iArr131[i311 - 2];
                this.DatabaseTableConfigUtil = i311 + 1;
                iArr131[i311] = 128;
                return 0;
            case 147:
                int i312 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i312;
                Object[] objArr13 = this.isLayoutRequested;
                Object obj6 = objArr13[i312];
                objArr13[i312] = null;
                objArr13[9] = obj6;
                this.DatabaseTableConfigUtil = i312 + 1;
                objArr13[i312] = objArr13[8];
                return 0;
            case 148:
                Object[] objArr14 = this.isLayoutRequested;
                int i313 = this.DatabaseTableConfigUtil;
                int i314 = i313 + 1;
                this.DatabaseTableConfigUtil = i314;
                objArr14[i313] = objArr14[i314 - 2];
                return 0;
            case 149:
                int i315 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i315;
                Object[] objArr15 = this.isLayoutRequested;
                Object obj7 = objArr15[i315];
                objArr15[i315] = null;
                objArr15[10] = obj7;
                return 0;
            case 150:
                Object[] objArr16 = this.isLayoutRequested;
                int i316 = this.DatabaseTableConfigUtil;
                this.DatabaseTableConfigUtil = i316 + 1;
                objArr16[i316] = objArr16[10];
                return 0;
            case 151:
                int[] iArr132 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i317 = this.DatabaseTableConfigUtil;
                int i318 = i317 + 1;
                this.DatabaseTableConfigUtil = i318;
                iArr132[i317] = 81;
                int i319 = i318 + 2;
                this.DatabaseTableConfigUtil = i319;
                iArr132[i319 - 1] = iArr132[i319 - 3];
                iArr132[i318] = iArr132[i319 - 4];
                return 0;
            case 152:
                int[] iArr133 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i320 = this.DatabaseTableConfigUtil;
                int i321 = i320 + 1;
                this.DatabaseTableConfigUtil = i321;
                iArr133[i320] = 19;
                this.DatabaseTableConfigUtil = i321 + 1;
                iArr133[i321] = 0;
                return 0;
            case 153:
                int i322 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i322;
                Object[] objArr17 = this.isLayoutRequested;
                objArr17[i322] = null;
                this.DatabaseTableConfigUtil = i322 + 1;
                objArr17[i322] = objArr17[9];
                return 0;
            case 154:
                int i323 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i323;
                Object[] objArr18 = this.isLayoutRequested;
                Object obj8 = objArr18[i323];
                objArr18[i323] = null;
                objArr18[9] = obj8;
                return 0;
            case TarHeader.USTAR_FILENAME_PREFIX /* 155 */:
                int[] iArr134 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i324 = this.DatabaseTableConfigUtil;
                this.DatabaseTableConfigUtil = i324 + 1;
                iArr134[i324] = 13;
                return 0;
            case 156:
                int[] iArr135 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i325 = this.DatabaseTableConfigUtil;
                int i326 = i325 + 2;
                this.DatabaseTableConfigUtil = i326;
                iArr135[i326 - 1] = iArr135[i326 - 3];
                iArr135[i325] = iArr135[i326 - 4];
                int i327 = i326 - 1;
                this.DatabaseTableConfigUtil = i327;
                iArr135[i327 - 1] = iArr135[i327] | iArr135[i327 - 1];
                return 0;
            case 157:
                int i328 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i328;
                int[] iArr136 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr136[i328 - 1] = iArr136[i328 - 1] ^ iArr136[i328];
                int i329 = i328 - 1;
                this.DatabaseTableConfigUtil = i329;
                iArr136[i329 - 1] = iArr136[i329 - 1] & iArr136[i329];
                int i330 = i329 + 1;
                this.DatabaseTableConfigUtil = i330;
                int i331 = iArr136[i330 - 2];
                iArr136[i329] = i331;
                iArr136[i330 - 2] = iArr136[i330 - 3];
                iArr136[i330 - 3] = iArr136[i330 - 4];
                iArr136[i330 - 4] = i331;
                return 0;
            case 158:
                int i332 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i332;
                int[] iArr137 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr137[i332 - 1] = iArr137[i332 - 1] & iArr137[i332];
                int i333 = i332 - 1;
                this.DatabaseTableConfigUtil = i333;
                iArr137[i333 - 1] = iArr137[i333 - 1] | iArr137[i333];
                iArr137[i333 - 1] = -iArr137[i333 - 1];
                return 0;
            case 159:
                int i334 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i334;
                int[] iArr138 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr138[i334 - 1] = iArr138[i334 - 1] << iArr138[i334];
                int i335 = i334 - 1;
                this.DatabaseTableConfigUtil = i335;
                iArr138[i335 - 1] = iArr138[i335 - 1] + iArr138[i335];
                return 0;
            case BlobStatic.MONITOR_IMAGE_WIDTH /* 160 */:
                int[] iArr139 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i336 = this.DatabaseTableConfigUtil;
                this.DatabaseTableConfigUtil = i336 + 1;
                iArr139[i336] = 49;
                return 0;
            case 161:
                int[] iArr140 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i337 = this.DatabaseTableConfigUtil;
                int i338 = i337 + 2;
                this.DatabaseTableConfigUtil = i338;
                iArr140[i338 - 1] = iArr140[i338 - 3];
                iArr140[i337] = iArr140[i338 - 4];
                int i339 = i338 + 2;
                this.DatabaseTableConfigUtil = i339;
                iArr140[i339 - 1] = iArr140[i339 - 3];
                iArr140[i338] = iArr140[i339 - 4];
                int i340 = i339 - 1;
                this.DatabaseTableConfigUtil = i340;
                iArr140[i340 - 1] = iArr140[i340] & iArr140[i340 - 1];
                return 0;
            case 162:
                int i341 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i341;
                this.isLayoutRequested[i341] = null;
                int[] iArr141 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i342 = i341 + 2;
                this.DatabaseTableConfigUtil = i342;
                iArr141[i342 - 1] = iArr141[i342 - 3];
                iArr141[i341] = iArr141[i342 - 4];
                return 0;
            case 163:
                int[] iArr142 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i343 = this.DatabaseTableConfigUtil;
                iArr142[i343 - 1] = -iArr142[i343 - 1];
                int i344 = i343 - 1;
                this.DatabaseTableConfigUtil = i344;
                iArr142[i344 - 1] = iArr142[i344 - 1] | iArr142[i344];
                this.DatabaseTableConfigUtil = i344 + 1;
                iArr142[i344] = 1;
                return 0;
            case 164:
                int i345 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i345;
                int[] iArr143 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr143[i345 - 1] = iArr143[i345 - 1] << iArr143[i345];
                int i346 = i345 + 1;
                this.DatabaseTableConfigUtil = i346;
                int i347 = iArr143[i346 - 2];
                iArr143[i345] = i347;
                iArr143[i346 - 2] = iArr143[i346 - 3];
                iArr143[i346 - 3] = iArr143[i346 - 4];
                iArr143[i346 - 4] = i347;
                int i348 = i346 - 1;
                this.DatabaseTableConfigUtil = i348;
                this.isLayoutRequested[i348] = null;
                return 0;
            case 165:
                int[] iArr144 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i349 = this.DatabaseTableConfigUtil;
                iArr144[i349 - 1] = -iArr144[i349 - 1];
                int i350 = i349 - 1;
                this.DatabaseTableConfigUtil = i350;
                iArr144[i350 - 1] = iArr144[i350 - 1] ^ iArr144[i350];
                int i351 = i350 - 1;
                this.DatabaseTableConfigUtil = i351;
                iArr144[i351 - 1] = iArr144[i351 - 1] - iArr144[i351];
                return 0;
            case 166:
                int[] iArr145 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i352 = this.DatabaseTableConfigUtil;
                int i353 = i352 + 1;
                this.DatabaseTableConfigUtil = i353;
                iArr145[i352] = 2;
                int i354 = i353 - 1;
                this.DatabaseTableConfigUtil = i354;
                iArr145[i354 - 1] = iArr145[i354 - 1] % iArr145[i354];
                int i355 = i354 - 1;
                this.DatabaseTableConfigUtil = i355;
                this.isLayoutRequested[i355] = null;
                return 0;
            case 167:
                int[] iArr146 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i356 = this.DatabaseTableConfigUtil;
                this.DatabaseTableConfigUtil = i356 + 1;
                iArr146[i356] = 61;
                return 0;
            case 168:
                int[] iArr147 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i357 = this.DatabaseTableConfigUtil;
                int i358 = i357 + 1;
                this.DatabaseTableConfigUtil = i358;
                iArr147[i357] = -1;
                int i359 = i358 - 1;
                this.DatabaseTableConfigUtil = i359;
                iArr147[i359 - 1] = iArr147[i359 - 1] ^ iArr147[i359];
                int i360 = i359 - 1;
                this.DatabaseTableConfigUtil = i360;
                iArr147[i360 - 1] = iArr147[i360] & iArr147[i360 - 1];
                return 0;
            case 169:
                int i361 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i361;
                int[] iArr148 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr148[i361 - 1] = iArr148[i361 - 1] ^ iArr148[i361];
                int i362 = i361 - 1;
                this.DatabaseTableConfigUtil = i362;
                this.isLayoutRequested[i362] = null;
                int i363 = i362 - 1;
                this.DatabaseTableConfigUtil = i363;
                iArr148[i363 - 1] = iArr148[i363] & iArr148[i363 - 1];
                return 0;
            case 170:
                int[] iArr149 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i364 = this.DatabaseTableConfigUtil;
                iArr149[i364 - 1] = -iArr149[i364 - 1];
                int i365 = i364 - 1;
                this.DatabaseTableConfigUtil = i365;
                iArr149[i365 - 1] = iArr149[i365] | iArr149[i365 - 1];
                return 0;
            case 171:
                Object[] objArr19 = this.isLayoutRequested;
                int i366 = this.DatabaseTableConfigUtil;
                int i367 = i366 + 1;
                this.DatabaseTableConfigUtil = i367;
                objArr19[i366] = objArr19[8];
                int i368 = i367 + 1;
                this.DatabaseTableConfigUtil = i368;
                objArr19[i367] = objArr19[i368 - 2];
                return 0;
            case 172:
                int i369 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i369;
                Object[] objArr20 = this.isLayoutRequested;
                Object obj9 = objArr20[i369];
                objArr20[i369] = null;
                objArr20[10] = obj9;
                int i370 = i369 + 1;
                this.DatabaseTableConfigUtil = i370;
                objArr20[i369] = objArr20[9];
                this.DatabaseTableConfigUtil = i370 + 1;
                objArr20[i370] = objArr20[10];
                return 0;
            case 173:
                int[] iArr150 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i371 = this.DatabaseTableConfigUtil;
                int i372 = i371 + 1;
                this.DatabaseTableConfigUtil = i372;
                iArr150[i371] = 9;
                int i373 = i372 + 2;
                this.DatabaseTableConfigUtil = i373;
                iArr150[i373 - 1] = iArr150[i373 - 3];
                iArr150[i372] = iArr150[i373 - 4];
                return 0;
            case 174:
                int[] iArr151 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i374 = this.DatabaseTableConfigUtil;
                int i375 = i374 + 1;
                this.DatabaseTableConfigUtil = i375;
                iArr151[i374] = 111;
                int i376 = i375 + 1;
                this.DatabaseTableConfigUtil = i376;
                iArr151[i375] = iArr151[i376 - 2];
                this.DatabaseTableConfigUtil = i376 + 1;
                iArr151[i376] = -1;
                return 0;
            case 175:
                int i377 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i377;
                int[] iArr152 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr152[i377 - 1] = iArr152[i377 - 1] & iArr152[i377];
                int i378 = iArr152[i377 - 1];
                iArr152[i377 - 1] = iArr152[i377 - 2];
                iArr152[i377 - 2] = i378;
                int i379 = i377 - 1;
                this.DatabaseTableConfigUtil = i379;
                this.isLayoutRequested[i379] = null;
                return 0;
            case 176:
                int[] iArr153 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i380 = this.DatabaseTableConfigUtil;
                int i381 = i380 + 1;
                this.DatabaseTableConfigUtil = i381;
                iArr153[i380] = 1;
                int i382 = i381 + 2;
                this.DatabaseTableConfigUtil = i382;
                iArr153[i382 - 1] = iArr153[i382 - 3];
                iArr153[i381] = iArr153[i382 - 4];
                return 0;
            case 177:
                int i383 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i383;
                this.isLayoutRequested[i383] = null;
                int[] iArr154 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr154[i383 - 1] = -iArr154[i383 - 1];
                return 0;
            case 178:
                Object[] objArr21 = this.isLayoutRequested;
                int i384 = this.DatabaseTableConfigUtil;
                int i385 = i384 + 1;
                this.DatabaseTableConfigUtil = i385;
                objArr21[i384] = objArr21[9];
                this.DatabaseTableConfigUtil = i385 + 1;
                objArr21[i385] = objArr21[10];
                return 0;
            case 179:
                int[] iArr155 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i386 = this.DatabaseTableConfigUtil;
                int i387 = i386 + 1;
                this.DatabaseTableConfigUtil = i387;
                iArr155[i386] = 79;
                int i388 = i387 + 2;
                this.DatabaseTableConfigUtil = i388;
                iArr155[i388 - 1] = iArr155[i388 - 3];
                iArr155[i387] = iArr155[i388 - 4];
                int i389 = i388 - 1;
                this.DatabaseTableConfigUtil = i389;
                iArr155[i389 - 1] = iArr155[i389] ^ iArr155[i389 - 1];
                return 0;
            case 180:
                int[] iArr156 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i390 = this.DatabaseTableConfigUtil;
                int i391 = i390 + 1;
                this.DatabaseTableConfigUtil = i391;
                iArr156[i390] = 1;
                int i392 = i391 - 1;
                this.DatabaseTableConfigUtil = i392;
                iArr156[i392 - 1] = iArr156[i392 - 1] << iArr156[i392];
                return 0;
            case 181:
                int[] iArr157 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i393 = this.DatabaseTableConfigUtil;
                int i394 = i393 + 1;
                this.DatabaseTableConfigUtil = i394;
                iArr157[i393] = 55;
                iArr157[i394 - 1] = -iArr157[i394 - 1];
                int i395 = i394 + 2;
                this.DatabaseTableConfigUtil = i395;
                iArr157[i395 - 1] = iArr157[i395 - 3];
                iArr157[i394] = iArr157[i395 - 4];
                return 0;
            case 182:
                int[] iArr158 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i396 = this.DatabaseTableConfigUtil;
                int i397 = i396 + 1;
                this.DatabaseTableConfigUtil = i397;
                iArr158[i396] = -1;
                int i398 = i397 - 1;
                this.DatabaseTableConfigUtil = i398;
                iArr158[i398 - 1] = iArr158[i398 - 1] ^ iArr158[i398];
                int i399 = iArr158[i398 - 1];
                iArr158[i398 - 1] = iArr158[i398 - 2];
                iArr158[i398 - 2] = i399;
                return 0;
            case 183:
                int[] iArr159 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i400 = this.DatabaseTableConfigUtil;
                this.DatabaseTableConfigUtil = i400 + 1;
                iArr159[i400] = 60;
                return 0;
            case 184:
                int[] iArr160 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i401 = this.DatabaseTableConfigUtil;
                int i402 = i401 + 1;
                this.DatabaseTableConfigUtil = i402;
                iArr160[i401] = 0;
                int i403 = i402 - 1;
                this.DatabaseTableConfigUtil = i403;
                iArr160[i403 - 1] = iArr160[i403 - 1] / iArr160[i403];
                return 0;
            case WSContextConstant.HANDSHAKE_RECEIVE_SIZE /* 185 */:
                int[] iArr161 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i404 = this.DatabaseTableConfigUtil;
                this.DatabaseTableConfigUtil = i404 + 1;
                iArr161[i404] = 71;
                return 0;
            case 186:
                int[] iArr162 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i405 = this.DatabaseTableConfigUtil;
                int i406 = i405 + 1;
                this.DatabaseTableConfigUtil = i406;
                iArr162[i405] = 37;
                int i407 = i406 + 1;
                this.DatabaseTableConfigUtil = i407;
                iArr162[i406] = iArr162[i407 - 2];
                return 0;
            case 187:
                int i408 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i408;
                int[] iArr163 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr163[i408 - 1] = iArr163[i408 - 1] - iArr163[i408];
                int i409 = i408 + 1;
                this.DatabaseTableConfigUtil = i409;
                iArr163[i408] = 1;
                iArr163[i409 - 1] = -iArr163[i409 - 1];
                return 0;
            case 188:
                int[] iArr164 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i410 = this.DatabaseTableConfigUtil;
                int i411 = i410 + 1;
                this.DatabaseTableConfigUtil = i411;
                iArr164[i410] = 53;
                int i412 = i411 + 2;
                this.DatabaseTableConfigUtil = i412;
                iArr164[i412 - 1] = iArr164[i412 - 3];
                iArr164[i411] = iArr164[i412 - 4];
                return 0;
            case WSContextConstant.HANDSHAKE_SEND_SIZE /* 189 */:
                int i413 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i413;
                int[] iArr165 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr165[i413 - 1] = iArr165[i413 - 1] ^ iArr165[i413];
                int i414 = i413 + 1;
                this.DatabaseTableConfigUtil = i414;
                int i415 = iArr165[i414 - 2];
                iArr165[i413] = i415;
                iArr165[i414 - 2] = iArr165[i414 - 3];
                iArr165[i414 - 3] = iArr165[i414 - 4];
                iArr165[i414 - 4] = i415;
                int i416 = i414 - 1;
                this.DatabaseTableConfigUtil = i416;
                this.isLayoutRequested[i416] = null;
                return 0;
            case 190:
                int[] iArr166 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i417 = this.DatabaseTableConfigUtil;
                int i418 = i417 + 1;
                this.DatabaseTableConfigUtil = i418;
                iArr166[i417] = 49;
                iArr166[i418 - 1] = -iArr166[i418 - 1];
                int i419 = i418 + 2;
                this.DatabaseTableConfigUtil = i419;
                iArr166[i419 - 1] = iArr166[i419 - 3];
                iArr166[i418] = iArr166[i419 - 4];
                return 0;
            case 191:
                int[] iArr167 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i420 = this.DatabaseTableConfigUtil;
                int i421 = i420 + 2;
                this.DatabaseTableConfigUtil = i421;
                iArr167[i421 - 1] = iArr167[i421 - 3];
                iArr167[i420] = iArr167[i421 - 4];
                int i422 = i421 - 1;
                this.DatabaseTableConfigUtil = i422;
                iArr167[i422 - 1] = iArr167[i422 - 1] & iArr167[i422];
                int i423 = i422 + 1;
                this.DatabaseTableConfigUtil = i423;
                int i424 = iArr167[i423 - 2];
                iArr167[i422] = i424;
                iArr167[i423 - 2] = iArr167[i423 - 3];
                iArr167[i423 - 3] = iArr167[i423 - 4];
                iArr167[i423 - 4] = i424;
                return 0;
            case 192:
                int[] iArr168 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i425 = this.DatabaseTableConfigUtil;
                int i426 = i425 + 1;
                this.DatabaseTableConfigUtil = i426;
                iArr168[i425] = 75;
                iArr168[i426 - 1] = -iArr168[i426 - 1];
                int i427 = i426 + 2;
                this.DatabaseTableConfigUtil = i427;
                iArr168[i427 - 1] = iArr168[i427 - 3];
                iArr168[i426] = iArr168[i427 - 4];
                return 0;
            case 193:
                int i428 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i428;
                Object[] objArr22 = this.isLayoutRequested;
                Object obj10 = objArr22[i428];
                objArr22[i428] = null;
                objArr22[11] = obj10;
                return 0;
            case 194:
                Object[] objArr23 = this.isLayoutRequested;
                int i429 = this.DatabaseTableConfigUtil;
                int i430 = i429 + 1;
                this.DatabaseTableConfigUtil = i430;
                objArr23[i429] = objArr23[10];
                this.DatabaseTableConfigUtil = i430 + 1;
                objArr23[i430] = objArr23[11];
                return 0;
            case 195:
                int i431 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i431;
                Object[] objArr24 = this.isLayoutRequested;
                Object obj11 = objArr24[i431];
                objArr24[i431] = null;
                objArr24[10] = obj11;
                this.DatabaseTableConfigUtil = i431 + 1;
                objArr24[i431] = objArr24[8];
                return 0;
            case 196:
                int[] iArr169 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i432 = this.DatabaseTableConfigUtil;
                int i433 = i432 + 1;
                this.DatabaseTableConfigUtil = i433;
                iArr169[i432] = 35;
                int i434 = i433 + 2;
                this.DatabaseTableConfigUtil = i434;
                iArr169[i434 - 1] = iArr169[i434 - 3];
                iArr169[i433] = iArr169[i434 - 4];
                return 0;
            case 197:
                int i435 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i435;
                int[] iArr170 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr170[i435 - 1] = iArr170[i435 - 1] << iArr170[i435];
                int i436 = i435 - 1;
                this.DatabaseTableConfigUtil = i436;
                iArr170[i436 - 1] = iArr170[i436 - 1] + iArr170[i436];
                int i437 = i436 + 1;
                this.DatabaseTableConfigUtil = i437;
                iArr170[i436] = iArr170[i437 - 2];
                return 0;
            case 198:
                int i438 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i438;
                Object[] objArr25 = this.isLayoutRequested;
                Object obj12 = objArr25[i438];
                objArr25[i438] = null;
                objArr25[9] = obj12;
                int i439 = i438 + 1;
                this.DatabaseTableConfigUtil = i439;
                objArr25[i438] = objArr25[10];
                this.DatabaseTableConfigUtil = i439 + 1;
                objArr25[i439] = objArr25[9];
                return 0;
            case SecExceptionCode.SEC_ERROR_INIT_UNKNOWN_ERROR /* 199 */:
                int[] iArr171 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i440 = this.DatabaseTableConfigUtil;
                this.DatabaseTableConfigUtil = i440 + 1;
                iArr171[i440] = 58;
                return 0;
            case 200:
                int[] iArr172 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i441 = this.DatabaseTableConfigUtil;
                this.DatabaseTableConfigUtil = i441 + 1;
                iArr172[i441] = 5;
                return 0;
            case 201:
                int i442 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i442;
                Object[] objArr26 = this.isLayoutRequested;
                Object obj13 = objArr26[i442];
                objArr26[i442] = null;
                objArr26[9] = obj13;
                this.DatabaseTableConfigUtil = i442 + 1;
                objArr26[i442] = objArr26[10];
                return 0;
            case 202:
                int[] iArr173 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i443 = this.DatabaseTableConfigUtil;
                int i444 = i443 + 1;
                this.DatabaseTableConfigUtil = i444;
                iArr173[i443] = 117;
                iArr173[i444 - 1] = -iArr173[i444 - 1];
                return 0;
            case 203:
                int[] iArr174 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i445 = this.DatabaseTableConfigUtil;
                int i446 = i445 + 2;
                this.DatabaseTableConfigUtil = i446;
                iArr174[i446 - 1] = iArr174[i446 - 3];
                iArr174[i445] = iArr174[i446 - 4];
                iArr174[i446 - 1] = -iArr174[i446 - 1];
                int i447 = i446 - 1;
                this.DatabaseTableConfigUtil = i447;
                iArr174[i447 - 1] = iArr174[i447] ^ iArr174[i447 - 1];
                return 0;
            case 204:
                int[] iArr175 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i448 = this.DatabaseTableConfigUtil;
                this.DatabaseTableConfigUtil = i448 + 1;
                iArr175[i448] = 91;
                return 0;
            case 205:
                int[] iArr176 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i449 = this.DatabaseTableConfigUtil;
                this.DatabaseTableConfigUtil = i449 + 1;
                iArr176[i449] = 87;
                return 0;
            case 206:
                int i450 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i450;
                int[] iArr177 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr177[i450 - 1] = iArr177[i450 - 1] | iArr177[i450];
                int i451 = i450 + 2;
                this.DatabaseTableConfigUtil = i451;
                iArr177[i451 - 1] = iArr177[i451 - 3];
                iArr177[i450] = iArr177[i451 - 4];
                int i452 = i451 - 1;
                this.DatabaseTableConfigUtil = i452;
                iArr177[i452 - 1] = iArr177[i452] ^ iArr177[i452 - 1];
                return 0;
            case 207:
                int[] iArr178 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i453 = this.DatabaseTableConfigUtil;
                this.DatabaseTableConfigUtil = i453 + 1;
                iArr178[i453] = 7;
                return 0;
            case 208:
                int i454 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i454;
                int[] iArr179 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr179[i454 - 1] = iArr179[i454 - 1] << iArr179[i454];
                int i455 = i454 + 2;
                this.DatabaseTableConfigUtil = i455;
                iArr179[i455 - 1] = iArr179[i455 - 3];
                iArr179[i454] = iArr179[i455 - 4];
                return 0;
            case 209:
                Object[] objArr27 = this.isLayoutRequested;
                int i456 = this.DatabaseTableConfigUtil;
                int i457 = i456 + 1;
                this.DatabaseTableConfigUtil = i457;
                objArr27[i456] = objArr27[9];
                int[] iArr180 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                this.DatabaseTableConfigUtil = i457 + 1;
                iArr180[i457] = 60;
                return 0;
            case 210:
                int[] iArr181 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i458 = this.DatabaseTableConfigUtil;
                this.DatabaseTableConfigUtil = i458 + 1;
                iArr181[i458] = 3;
                return 0;
            case 211:
                int[] iArr182 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i459 = this.DatabaseTableConfigUtil;
                int i460 = i459 + 1;
                this.DatabaseTableConfigUtil = i460;
                iArr182[i459] = 1;
                int i461 = i460 - 1;
                this.DatabaseTableConfigUtil = i461;
                iArr182[i461 - 1] = iArr182[i461 - 1] << iArr182[i461];
                int i462 = i461 + 1;
                this.DatabaseTableConfigUtil = i462;
                int i463 = iArr182[i462 - 2];
                iArr182[i461] = i463;
                iArr182[i462 - 2] = iArr182[i462 - 3];
                iArr182[i462 - 3] = iArr182[i462 - 4];
                iArr182[i462 - 4] = i463;
                return 0;
            case SecExceptionCode.SEC_ERROR_STA_STORE_LOW_VERSION_DATA_FILE /* 212 */:
                int[] iArr183 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i464 = this.DatabaseTableConfigUtil;
                this.DatabaseTableConfigUtil = i464 + 1;
                iArr183[i464] = 19;
                return 0;
            case 213:
                int i465 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i465;
                int[] iArr184 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr184[i465 - 1] = iArr184[i465 - 1] << iArr184[i465];
                int i466 = i465 + 1;
                this.DatabaseTableConfigUtil = i466;
                iArr184[i465] = iArr184[i466 - 2];
                this.DatabaseTableConfigUtil = i466 + 1;
                iArr184[i466] = -1;
                return 0;
            case 214:
                Object[] objArr28 = this.isLayoutRequested;
                int i467 = this.DatabaseTableConfigUtil;
                int i468 = i467 + 1;
                this.DatabaseTableConfigUtil = i468;
                objArr28[i467] = objArr28[9];
                int[] iArr185 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                this.DatabaseTableConfigUtil = i468 + 1;
                iArr185[i468] = 84;
                return 0;
            case 215:
                int[] iArr186 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i469 = this.DatabaseTableConfigUtil;
                int i470 = i469 + 1;
                this.DatabaseTableConfigUtil = i470;
                iArr186[i469] = 123;
                int i471 = i470 + 2;
                this.DatabaseTableConfigUtil = i471;
                iArr186[i471 - 1] = iArr186[i471 - 3];
                iArr186[i470] = iArr186[i471 - 4];
                return 0;
            case 216:
                int i472 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i472;
                int[] iArr187 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr187[i472 - 1] = iArr187[i472 - 1] | iArr187[i472];
                iArr187[i472 - 1] = -iArr187[i472 - 1];
                int i473 = i472 + 2;
                this.DatabaseTableConfigUtil = i473;
                iArr187[i473 - 1] = iArr187[i473 - 3];
                iArr187[i472] = iArr187[i473 - 4];
                return 0;
            case FileUtils.JPEG_MARKER_EOI /* 217 */:
                Object[] objArr29 = this.isLayoutRequested;
                int i474 = this.DatabaseTableConfigUtil;
                int i475 = i474 + 1;
                this.DatabaseTableConfigUtil = i475;
                objArr29[i474] = objArr29[9];
                int[] iArr188 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                this.DatabaseTableConfigUtil = i475 + 1;
                iArr188[i475] = 8;
                return 0;
            case 218:
                Object[] objArr30 = this.isLayoutRequested;
                int i476 = this.DatabaseTableConfigUtil;
                int i477 = i476 + 1;
                this.DatabaseTableConfigUtil = i477;
                objArr30[i476] = objArr30[9];
                int i478 = i477 + 1;
                this.DatabaseTableConfigUtil = i478;
                objArr30[i477] = objArr30[10];
                int[] iArr189 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                this.DatabaseTableConfigUtil = i478 + 1;
                iArr189[i478] = 38;
                return 0;
            case 219:
                int[] iArr190 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i479 = this.DatabaseTableConfigUtil;
                int i480 = i479 + 1;
                this.DatabaseTableConfigUtil = i480;
                iArr190[i479] = 67;
                int i481 = i480 + 2;
                this.DatabaseTableConfigUtil = i481;
                iArr190[i481 - 1] = iArr190[i481 - 3];
                iArr190[i480] = iArr190[i481 - 4];
                return 0;
            case WheelView.DIVIDER_ALPHA /* 220 */:
                int[] iArr191 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i482 = this.DatabaseTableConfigUtil;
                int i483 = i482 + 1;
                this.DatabaseTableConfigUtil = i483;
                iArr191[i482] = 95;
                iArr191[i483 - 1] = -iArr191[i483 - 1];
                return 0;
            case 221:
                int[] iArr192 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i484 = this.DatabaseTableConfigUtil;
                iArr192[i484 - 1] = -iArr192[i484 - 1];
                int i485 = i484 + 1;
                this.DatabaseTableConfigUtil = i485;
                iArr192[i484] = -1;
                int i486 = i485 + 2;
                this.DatabaseTableConfigUtil = i486;
                iArr192[i486 - 1] = iArr192[i486 - 3];
                iArr192[i485] = iArr192[i486 - 4];
                return 0;
            case 222:
                int[] iArr193 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i487 = this.DatabaseTableConfigUtil;
                int i488 = iArr193[i487 - 1];
                iArr193[i487 - 1] = iArr193[i487 - 2];
                iArr193[i487 - 2] = i488;
                this.DatabaseTableConfigUtil = i487 + 1;
                iArr193[i487] = -1;
                return 0;
            case 223:
                int i489 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i489;
                int[] iArr194 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr194[i489 - 1] = iArr194[i489 - 1] ^ iArr194[i489];
                int i490 = i489 - 1;
                this.DatabaseTableConfigUtil = i490;
                iArr194[i490 - 1] = iArr194[i490 - 1] & iArr194[i490];
                int i491 = i490 - 1;
                this.DatabaseTableConfigUtil = i491;
                iArr194[i491 - 1] = iArr194[i491] | iArr194[i491 - 1];
                return 0;
            case 224:
                Object[] objArr31 = this.isLayoutRequested;
                int i492 = this.DatabaseTableConfigUtil;
                int i493 = i492 + 1;
                this.DatabaseTableConfigUtil = i493;
                objArr31[i492] = objArr31[10];
                int[] iArr195 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                this.DatabaseTableConfigUtil = i493 + 1;
                iArr195[i493] = 60;
                return 0;
            case 225:
                int[] iArr196 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i494 = this.DatabaseTableConfigUtil;
                this.DatabaseTableConfigUtil = i494 + 1;
                iArr196[i494] = 81;
                return 0;
            case 226:
                int[] iArr197 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i495 = this.DatabaseTableConfigUtil;
                int i496 = i495 + 1;
                this.DatabaseTableConfigUtil = i496;
                iArr197[i495] = 81;
                iArr197[i496 - 1] = -iArr197[i496 - 1];
                int i497 = i496 + 2;
                this.DatabaseTableConfigUtil = i497;
                iArr197[i497 - 1] = iArr197[i497 - 3];
                iArr197[i496] = iArr197[i497 - 4];
                return 0;
            case 227:
                int[] iArr198 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i498 = this.DatabaseTableConfigUtil;
                iArr198[i498 - 1] = -iArr198[i498 - 1];
                int i499 = i498 - 1;
                this.DatabaseTableConfigUtil = i499;
                iArr198[i499 - 1] = iArr198[i499 - 1] ^ iArr198[i499];
                int i500 = i499 + 1;
                this.DatabaseTableConfigUtil = i500;
                int i501 = iArr198[i500 - 2];
                iArr198[i499] = i501;
                iArr198[i500 - 2] = iArr198[i500 - 3];
                iArr198[i500 - 3] = iArr198[i500 - 4];
                iArr198[i500 - 4] = i501;
                return 0;
            case 228:
                int[] iArr199 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i502 = this.DatabaseTableConfigUtil;
                int i503 = iArr199[i502 - 1];
                iArr199[i502 - 1] = iArr199[i502 - 2];
                iArr199[i502 - 2] = i503;
                int i504 = i502 - 1;
                this.DatabaseTableConfigUtil = i504;
                this.isLayoutRequested[i504] = null;
                iArr199[i504 - 1] = -iArr199[i504 - 1];
                return 0;
            case 229:
                int i505 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i505;
                int[] iArr200 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr200[i505 - 1] = iArr200[i505 - 1] + iArr200[i505];
                this.DatabaseTableConfigUtil = i505 + 1;
                iArr200[i505] = 1;
                return 0;
            case 230:
                int[] iArr201 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i506 = this.DatabaseTableConfigUtil;
                iArr201[i506 - 1] = -iArr201[i506 - 1];
                int i507 = i506 + 1;
                this.DatabaseTableConfigUtil = i507;
                iArr201[i506] = iArr201[i507 - 2];
                this.DatabaseTableConfigUtil = i507 + 1;
                iArr201[i507] = -1;
                return 0;
            case 231:
                int i508 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i508;
                this.isLayoutRequested[i508] = null;
                int i509 = i508 - 1;
                this.DatabaseTableConfigUtil = i509;
                int[] iArr202 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr202[i509 - 1] = iArr202[i509 - 1] - iArr202[i509];
                this.DatabaseTableConfigUtil = i509 + 1;
                iArr202[i509] = 1;
                return 0;
            case 232:
                int[] iArr203 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i510 = this.DatabaseTableConfigUtil;
                this.DatabaseTableConfigUtil = i510 + 1;
                iArr203[i510] = 17;
                return 0;
            case 233:
                int[] iArr204 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i511 = this.DatabaseTableConfigUtil;
                this.DatabaseTableConfigUtil = i511 + 1;
                iArr204[i511] = 115;
                return 0;
            case 234:
                int[] iArr205 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i512 = this.DatabaseTableConfigUtil;
                this.DatabaseTableConfigUtil = i512 + 1;
                iArr205[i512] = 32;
                return 0;
            case 235:
                int i513 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i513;
                this.isLayoutRequested[i513] = null;
                int[] iArr206 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i514 = i513 + 2;
                this.DatabaseTableConfigUtil = i514;
                iArr206[i514 - 1] = iArr206[i514 - 3];
                iArr206[i513] = iArr206[i514 - 4];
                int i515 = i514 - 1;
                this.DatabaseTableConfigUtil = i515;
                iArr206[i515 - 1] = iArr206[i515] ^ iArr206[i515 - 1];
                return 0;
            case 236:
                int[] iArr207 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i516 = this.DatabaseTableConfigUtil;
                int i517 = i516 + 1;
                this.DatabaseTableConfigUtil = i517;
                iArr207[i516] = 121;
                iArr207[i517 - 1] = -iArr207[i517 - 1];
                int i518 = i517 + 2;
                this.DatabaseTableConfigUtil = i518;
                iArr207[i518 - 1] = iArr207[i518 - 3];
                iArr207[i517] = iArr207[i518 - 4];
                return 0;
            case 237:
                int i519 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i519;
                int[] iArr208 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr208[i519 - 1] = iArr208[i519 - 1] | iArr208[i519];
                iArr208[i519 - 1] = -iArr208[i519 - 1];
                int i520 = i519 + 1;
                this.DatabaseTableConfigUtil = i520;
                iArr208[i519] = iArr208[i520 - 2];
                return 0;
            case 238:
                int i521 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i521;
                int[] iArr209 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr209[i521 - 1] = iArr209[i521 - 1] - iArr209[i521];
                int i522 = i521 + 1;
                this.DatabaseTableConfigUtil = i522;
                iArr209[i521] = 1;
                int i523 = i522 - 1;
                this.DatabaseTableConfigUtil = i523;
                iArr209[i523 - 1] = iArr209[i523 - 1] - iArr209[i523];
                return 0;
            case 239:
                int[] iArr210 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i524 = this.DatabaseTableConfigUtil;
                this.DatabaseTableConfigUtil = i524 + 1;
                iArr210[i524] = 51;
                return 0;
            case 240:
                int i525 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i525;
                int[] iArr211 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr211[i525 - 1] = iArr211[i525 - 1] | iArr211[i525];
                int i526 = i525 - 1;
                this.DatabaseTableConfigUtil = i526;
                iArr211[i526 - 1] = iArr211[i526 - 1] & iArr211[i526];
                int i527 = i526 + 2;
                this.DatabaseTableConfigUtil = i527;
                iArr211[i527 - 1] = iArr211[i527 - 3];
                iArr211[i526] = iArr211[i527 - 4];
                return 0;
            case 241:
                int i528 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i528;
                int[] iArr212 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr212[i528 - 1] = iArr212[i528 - 1] | iArr212[i528];
                int i529 = i528 - 1;
                this.DatabaseTableConfigUtil = i529;
                iArr212[i529 - 1] = iArr212[i529 - 1] & iArr212[i529];
                int i530 = i529 + 1;
                this.DatabaseTableConfigUtil = i530;
                int i531 = iArr212[i530 - 2];
                iArr212[i529] = i531;
                iArr212[i530 - 2] = iArr212[i530 - 3];
                iArr212[i530 - 3] = iArr212[i530 - 4];
                iArr212[i530 - 4] = i531;
                return 0;
            case 242:
                int i532 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i532;
                this.isLayoutRequested[i532] = null;
                int i533 = i532 - 1;
                this.DatabaseTableConfigUtil = i533;
                int[] iArr213 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr213[i533 - 1] = iArr213[i533 - 1] | iArr213[i533];
                int i534 = i533 - 1;
                this.DatabaseTableConfigUtil = i534;
                iArr213[i534 - 1] = iArr213[i534 - 1] + iArr213[i534];
                return 0;
            case 243:
                int[] iArr214 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i535 = this.DatabaseTableConfigUtil;
                int i536 = i535 + 1;
                this.DatabaseTableConfigUtil = i536;
                iArr214[i535] = 27;
                int i537 = i536 + 2;
                this.DatabaseTableConfigUtil = i537;
                iArr214[i537 - 1] = iArr214[i537 - 3];
                iArr214[i536] = iArr214[i537 - 4];
                return 0;
            case 244:
                int i538 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i538;
                int[] iArr215 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr215[i538 - 1] = iArr215[i538 - 1] - iArr215[i538];
                int i539 = i538 + 1;
                this.DatabaseTableConfigUtil = i539;
                iArr215[i538] = iArr215[i539 - 2];
                this.DatabaseTableConfigUtil = i539 + 1;
                iArr215[i539] = 128;
                return 0;
            case 245:
                int[] iArr216 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i540 = this.DatabaseTableConfigUtil;
                int i541 = i540 + 2;
                this.DatabaseTableConfigUtil = i541;
                iArr216[i541 - 1] = iArr216[i541 - 3];
                iArr216[i540] = iArr216[i541 - 4];
                iArr216[i541 - 1] = -iArr216[i541 - 1];
                int i542 = i541 + 2;
                this.DatabaseTableConfigUtil = i542;
                iArr216[i542 - 1] = iArr216[i542 - 3];
                iArr216[i541] = iArr216[i542 - 4];
                return 0;
            case 246:
                int i543 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i543;
                int[] iArr217 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr217[i543 - 1] = iArr217[i543 - 1] | iArr217[i543];
                int i544 = i543 + 2;
                this.DatabaseTableConfigUtil = i544;
                iArr217[i544 - 1] = iArr217[i544 - 3];
                iArr217[i543] = iArr217[i544 - 4];
                return 0;
            case 247:
                int i545 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i545;
                this.isLayoutRequested[i545] = null;
                int[] iArr218 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr218[i545 - 1] = -iArr218[i545 - 1];
                int i546 = i545 - 1;
                this.DatabaseTableConfigUtil = i546;
                iArr218[i546 - 1] = iArr218[i546] ^ iArr218[i546 - 1];
                return 0;
            case 248:
                Object[] objArr32 = this.isLayoutRequested;
                int i547 = this.DatabaseTableConfigUtil;
                int i548 = i547 + 1;
                this.DatabaseTableConfigUtil = i548;
                objArr32[i547] = objArr32[10];
                this.DatabaseTableConfigUtil = i548 + 1;
                objArr32[i548] = objArr32[9];
                return 0;
            case 249:
                int[] iArr219 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i549 = this.DatabaseTableConfigUtil;
                int i550 = i549 + 1;
                this.DatabaseTableConfigUtil = i550;
                iArr219[i549] = 93;
                int i551 = i550 + 2;
                this.DatabaseTableConfigUtil = i551;
                iArr219[i551 - 1] = iArr219[i551 - 3];
                iArr219[i550] = iArr219[i551 - 4];
                int i552 = i551 + 2;
                this.DatabaseTableConfigUtil = i552;
                iArr219[i552 - 1] = iArr219[i552 - 3];
                iArr219[i551] = iArr219[i552 - 4];
                return 0;
            case 250:
                int[] iArr220 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i553 = this.DatabaseTableConfigUtil;
                int i554 = i553 + 1;
                this.DatabaseTableConfigUtil = i554;
                iArr220[i553] = 39;
                iArr220[i554 - 1] = -iArr220[i554 - 1];
                int i555 = i554 + 2;
                this.DatabaseTableConfigUtil = i555;
                iArr220[i555 - 1] = iArr220[i555 - 3];
                iArr220[i554] = iArr220[i555 - 4];
                return 0;
            case 251:
                int[] iArr221 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i556 = this.DatabaseTableConfigUtil;
                this.DatabaseTableConfigUtil = i556 + 1;
                iArr221[i556] = 90;
                return 0;
            case 252:
                int[] iArr222 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i557 = this.DatabaseTableConfigUtil;
                this.DatabaseTableConfigUtil = i557 + 1;
                iArr222[i557] = 95;
                return 0;
            case 253:
                Object[] objArr33 = this.isLayoutRequested;
                int i558 = this.DatabaseTableConfigUtil;
                int i559 = i558 + 1;
                this.DatabaseTableConfigUtil = i559;
                objArr33[i558] = null;
                Object obj14 = objArr33[i559 - 1];
                objArr33[i559 - 1] = null;
                this.NetworkUserEntityData$$ExternalSyntheticLambda1[i559 - 1] = ((int[]) obj14).length;
                return 0;
            case 254:
                int[] iArr223 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i560 = this.DatabaseTableConfigUtil;
                int i561 = i560 + 1;
                this.DatabaseTableConfigUtil = i561;
                iArr223[i560] = 25;
                iArr223[i561 - 1] = -iArr223[i561 - 1];
                return 0;
            case 255:
                int i562 = this.DatabaseTableConfigUtil - 1;
                this.DatabaseTableConfigUtil = i562;
                this.isLayoutRequested[i562] = null;
                int[] iArr224 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                iArr224[i562 - 1] = -iArr224[i562 - 1];
                int i563 = i562 - 1;
                this.DatabaseTableConfigUtil = i563;
                iArr224[i563 - 1] = iArr224[i563] & iArr224[i563 - 1];
                return 0;
            case 256:
                int[] iArr225 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i564 = this.DatabaseTableConfigUtil;
                int i565 = i564 + 1;
                this.DatabaseTableConfigUtil = i565;
                iArr225[i564] = 1;
                int i566 = i565 - 1;
                this.DatabaseTableConfigUtil = i566;
                iArr225[i566 - 1] = iArr225[i566 - 1] << iArr225[i566];
                int i567 = i566 - 1;
                this.DatabaseTableConfigUtil = i567;
                iArr225[i567 - 1] = iArr225[i567 - 1] + iArr225[i567];
                return 0;
            default:
                return i;
        }
        return 0;
    }
}
