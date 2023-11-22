package o;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.android.phone.mobilesdk.socketcraft.api.WSContextConstant;
import com.alipay.zoloz.toyger.blob.BlobStatic;

/* loaded from: classes4.dex */
public class SubmitReceiptRequest {
    public int BuiltInFictitiousFunctionClassFactory;
    private final long[] DatabaseTableConfigUtil;
    private int GetContactSyncConfig;
    public long KClassImpl$Data$declaredNonStaticMembers$2;
    public int MyBillsEntityDataFactory;
    public Object NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final float[] NetworkUserEntityData$$ExternalSyntheticLambda1;
    private int NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final double[] NetworkUserEntityData$$ExternalSyntheticLambda7;
    private final Object[] NetworkUserEntityData$$ExternalSyntheticLambda8;
    public float PlaceComponentResult;
    public long getAuthRequestContext;
    public Object getErrorConfigVersion;
    private final int[] initRecordTimeStamp;
    public float lookAheadTest;
    public double moveToNextValue;
    public double scheduleImpl;

    public SubmitReceiptRequest(Object obj) {
        this.initRecordTimeStamp = new int[15];
        this.DatabaseTableConfigUtil = new long[15];
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new float[15];
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = new double[15];
        Object[] objArr = new Object[15];
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = objArr;
        objArr[8] = obj;
        this.GetContactSyncConfig = 0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = -1;
    }

    public SubmitReceiptRequest(Object obj, Object obj2) {
        this.initRecordTimeStamp = new int[15];
        this.DatabaseTableConfigUtil = new long[15];
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new float[15];
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = new double[15];
        Object[] objArr = new Object[15];
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = objArr;
        objArr[8] = obj;
        objArr[9] = obj2;
        this.GetContactSyncConfig = 0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = -1;
    }

    public SubmitReceiptRequest(Object obj, Object obj2, Object obj3, int i) {
        int[] iArr = new int[15];
        this.initRecordTimeStamp = iArr;
        this.DatabaseTableConfigUtil = new long[15];
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new float[15];
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = new double[15];
        Object[] objArr = new Object[15];
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = objArr;
        objArr[8] = obj;
        objArr[9] = obj2;
        objArr[10] = obj3;
        iArr[11] = i;
        this.GetContactSyncConfig = 0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = -1;
    }

    public SubmitReceiptRequest(Object obj, Object obj2, Object obj3, Object obj4) {
        this.initRecordTimeStamp = new int[15];
        this.DatabaseTableConfigUtil = new long[15];
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new float[15];
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = new double[15];
        Object[] objArr = new Object[15];
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = objArr;
        objArr[8] = obj;
        objArr[9] = obj2;
        objArr[10] = obj3;
        objArr[11] = obj4;
        this.GetContactSyncConfig = 0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = -1;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public int getAuthRequestContext(int i) {
        switch (i) {
            case 1:
                break;
            case 2:
                Object[] objArr = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                int i2 = this.GetContactSyncConfig;
                Object obj = objArr[i2 - 1];
                objArr[i2 - 1] = null;
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = obj;
                break;
            case 3:
                int[] iArr = this.initRecordTimeStamp;
                int i3 = this.GetContactSyncConfig;
                int i4 = i3 + 1;
                this.GetContactSyncConfig = i4;
                iArr[i3] = 2;
                int i5 = i4 + 1;
                this.GetContactSyncConfig = i5;
                iArr[i4] = 2;
                int i6 = i5 - 1;
                this.GetContactSyncConfig = i6;
                iArr[i6 - 1] = iArr[i6 - 1] % iArr[i6];
                return 0;
            case 4:
                int i7 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i7;
                this.NetworkUserEntityData$$ExternalSyntheticLambda8[i7] = null;
                return 0;
            case 5:
                int[] iArr2 = this.initRecordTimeStamp;
                int i8 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i8 + 1;
                iArr2[i8] = this.BuiltInFictitiousFunctionClassFactory;
                return 0;
            case 6:
                int[] iArr3 = this.initRecordTimeStamp;
                int i9 = this.GetContactSyncConfig;
                int i10 = i9 + 1;
                this.GetContactSyncConfig = i10;
                iArr3[i9] = 9;
                int i11 = i10 + 2;
                this.GetContactSyncConfig = i11;
                iArr3[i11 - 1] = iArr3[i11 - 3];
                iArr3[i10] = iArr3[i11 - 4];
                int i12 = i11 - 1;
                this.GetContactSyncConfig = i12;
                iArr3[i12 - 1] = iArr3[i12] & iArr3[i12 - 1];
                return 0;
            case 7:
                int[] iArr4 = this.initRecordTimeStamp;
                int i13 = this.GetContactSyncConfig;
                int i14 = i13 + 1;
                this.GetContactSyncConfig = i14;
                int i15 = iArr4[i14 - 2];
                iArr4[i13] = i15;
                iArr4[i14 - 2] = iArr4[i14 - 3];
                iArr4[i14 - 3] = iArr4[i14 - 4];
                iArr4[i14 - 4] = i15;
                int i16 = i14 - 1;
                this.GetContactSyncConfig = i16;
                this.NetworkUserEntityData$$ExternalSyntheticLambda8[i16] = null;
                return 0;
            case 8:
                int[] iArr5 = this.initRecordTimeStamp;
                int i17 = this.GetContactSyncConfig;
                int i18 = i17 + 2;
                this.GetContactSyncConfig = i18;
                iArr5[i18 - 1] = iArr5[i18 - 3];
                iArr5[i17] = iArr5[i18 - 4];
                return 0;
            case 9:
                int i19 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i19;
                int[] iArr6 = this.initRecordTimeStamp;
                iArr6[i19 - 1] = iArr6[i19] ^ iArr6[i19 - 1];
                return 0;
            case 10:
                int i20 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i20;
                int[] iArr7 = this.initRecordTimeStamp;
                iArr7[i20 - 1] = iArr7[i20 - 1] & iArr7[i20];
                int i21 = i20 - 1;
                this.GetContactSyncConfig = i21;
                iArr7[i21 - 1] = iArr7[i21 - 1] | iArr7[i21];
                int i22 = i21 + 2;
                this.GetContactSyncConfig = i22;
                iArr7[i22 - 1] = iArr7[i22 - 3];
                iArr7[i21] = iArr7[i22 - 4];
                return 0;
            case 11:
                int i23 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i23;
                int[] iArr8 = this.initRecordTimeStamp;
                iArr8[i23 - 1] = iArr8[i23] & iArr8[i23 - 1];
                return 0;
            case 12:
                int[] iArr9 = this.initRecordTimeStamp;
                int i24 = this.GetContactSyncConfig;
                int i25 = i24 + 1;
                this.GetContactSyncConfig = i25;
                int i26 = iArr9[i25 - 2];
                iArr9[i24] = i26;
                iArr9[i25 - 2] = iArr9[i25 - 3];
                iArr9[i25 - 3] = iArr9[i25 - 4];
                iArr9[i25 - 4] = i26;
                return 0;
            case 13:
                int i27 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i27;
                this.NetworkUserEntityData$$ExternalSyntheticLambda8[i27] = null;
                int i28 = i27 - 1;
                this.GetContactSyncConfig = i28;
                int[] iArr10 = this.initRecordTimeStamp;
                iArr10[i28 - 1] = iArr10[i28] | iArr10[i28 - 1];
                return 0;
            case 14:
                int i29 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i29;
                int[] iArr11 = this.initRecordTimeStamp;
                iArr11[i29 - 1] = iArr11[i29 - 1] + iArr11[i29];
                int i30 = i29 + 1;
                this.GetContactSyncConfig = i30;
                iArr11[i29] = iArr11[i30 - 2];
                this.GetContactSyncConfig = i30 + 1;
                iArr11[i30] = 128;
                return 0;
            case 15:
                int i31 = this.GetContactSyncConfig - this.BuiltInFictitiousFunctionClassFactory;
                this.GetContactSyncConfig = i31;
                this.NetworkUserEntityData$$ExternalSyntheticLambda2 = i31;
                return 0;
            case 16:
                int[] iArr12 = this.initRecordTimeStamp;
                int i32 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                this.NetworkUserEntityData$$ExternalSyntheticLambda2 = i32 + 1;
                this.MyBillsEntityDataFactory = iArr12[i32];
                return 0;
            case 17:
                int i33 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i33;
                int[] iArr13 = this.initRecordTimeStamp;
                iArr13[i33 - 1] = iArr13[i33 - 1] % iArr13[i33];
                return 0;
            case 18:
                int i34 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i34;
                this.MyBillsEntityDataFactory = this.initRecordTimeStamp[i34] != 0 ? 1 : 0;
                return 0;
            case 19:
                int[] iArr14 = this.initRecordTimeStamp;
                int i35 = this.GetContactSyncConfig;
                int i36 = i35 + 1;
                this.GetContactSyncConfig = i36;
                iArr14[i35] = 2;
                int i37 = i36 - 1;
                this.GetContactSyncConfig = i37;
                iArr14[i37 - 1] = iArr14[i37 - 1] % iArr14[i37];
                return 0;
            case 20:
                int[] iArr15 = this.initRecordTimeStamp;
                int i38 = this.GetContactSyncConfig;
                int i39 = i38 + 1;
                this.GetContactSyncConfig = i39;
                iArr15[i38] = 3;
                int i40 = i39 - 1;
                this.GetContactSyncConfig = i40;
                iArr15[i40 - 1] = iArr15[i40 - 1] + iArr15[i40];
                int i41 = i40 + 1;
                this.GetContactSyncConfig = i41;
                iArr15[i40] = iArr15[i41 - 2];
                return 0;
            case 21:
                int[] iArr16 = this.initRecordTimeStamp;
                int i42 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i42 + 1;
                iArr16[i42] = 128;
                return 0;
            case 22:
                int[] iArr17 = this.initRecordTimeStamp;
                int i43 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i43 + 1;
                iArr17[i43] = 2;
                return 0;
            case 23:
                int i44 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i44;
                this.MyBillsEntityDataFactory = this.initRecordTimeStamp[i44] == 0 ? 1 : 0;
                return 0;
            case 24:
                Object[] objArr2 = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                int i45 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i45 + 1;
                objArr2[i45] = objArr2[8];
                return 0;
            case 25:
                Object[] objArr3 = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                int i46 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                this.NetworkUserEntityData$$ExternalSyntheticLambda2 = i46 + 1;
                Object obj2 = objArr3[i46];
                objArr3[i46] = null;
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = obj2;
                return 0;
            case 26:
                Object[] objArr4 = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                int i47 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i47 + 1;
                objArr4[i47] = this.getErrorConfigVersion;
                return 0;
            case 27:
                for (int i48 = this.GetContactSyncConfig - 1; i48 >= 0; i48--) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda8[i48] = null;
                }
                this.GetContactSyncConfig = 0;
                Object[] objArr5 = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                this.GetContactSyncConfig = 0 + 1;
                objArr5[0] = this.getErrorConfigVersion;
                return 0;
            case 28:
                int[] iArr18 = this.initRecordTimeStamp;
                int i49 = this.GetContactSyncConfig;
                int i50 = i49 + 1;
                this.GetContactSyncConfig = i50;
                iArr18[i49] = 2;
                this.GetContactSyncConfig = i50 + 1;
                iArr18[i50] = 2;
                return 0;
            case 29:
                int i51 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i51;
                int[] iArr19 = this.initRecordTimeStamp;
                iArr19[i51 - 1] = iArr19[i51 - 1] % iArr19[i51];
                int i52 = i51 - 1;
                this.GetContactSyncConfig = i52;
                this.NetworkUserEntityData$$ExternalSyntheticLambda8[i52] = null;
                return 0;
            case 30:
                int[] iArr20 = this.initRecordTimeStamp;
                int i53 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i53 + 1;
                iArr20[i53] = 1;
                return 0;
            case 31:
                int[] iArr21 = this.initRecordTimeStamp;
                int i54 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i54 + 1;
                iArr21[i54] = 115;
                return 0;
            case 32:
                int[] iArr22 = this.initRecordTimeStamp;
                int i55 = this.GetContactSyncConfig;
                iArr22[i55 - 1] = -iArr22[i55 - 1];
                int i56 = i55 + 2;
                this.GetContactSyncConfig = i56;
                iArr22[i56 - 1] = iArr22[i56 - 3];
                iArr22[i55] = iArr22[i56 - 4];
                return 0;
            case 33:
                int[] iArr23 = this.initRecordTimeStamp;
                int i57 = this.GetContactSyncConfig;
                iArr23[i57 - 1] = -iArr23[i57 - 1];
                int i58 = i57 - 1;
                this.GetContactSyncConfig = i58;
                iArr23[i58 - 1] = iArr23[i58] ^ iArr23[i58 - 1];
                return 0;
            case 34:
                int[] iArr24 = this.initRecordTimeStamp;
                int i59 = this.GetContactSyncConfig;
                iArr24[i59 - 1] = -iArr24[i59 - 1];
                return 0;
            case 35:
                int i60 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i60;
                int[] iArr25 = this.initRecordTimeStamp;
                iArr25[i60 - 1] = iArr25[i60 - 1] << iArr25[i60];
                int i61 = i60 - 1;
                this.GetContactSyncConfig = i61;
                iArr25[i61 - 1] = iArr25[i61 - 1] + iArr25[i61];
                int i62 = i61 + 1;
                this.GetContactSyncConfig = i62;
                iArr25[i61] = iArr25[i62 - 2];
                return 0;
            case 36:
                int[] iArr26 = this.initRecordTimeStamp;
                int i63 = this.GetContactSyncConfig;
                int i64 = i63 + 1;
                this.GetContactSyncConfig = i64;
                iArr26[i63] = 37;
                int i65 = i64 + 1;
                this.GetContactSyncConfig = i65;
                iArr26[i64] = 0;
                int i66 = i65 - 1;
                this.GetContactSyncConfig = i66;
                iArr26[i66 - 1] = iArr26[i66 - 1] / iArr26[i66];
                return 0;
            case 37:
                int[] iArr27 = this.initRecordTimeStamp;
                int i67 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i67 + 1;
                iArr27[i67] = 0;
                return 0;
            case 38:
                int[] iArr28 = this.initRecordTimeStamp;
                int i68 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i68;
                this.MyBillsEntityDataFactory = iArr28[i68];
                return 0;
            case 39:
                int[] iArr29 = this.initRecordTimeStamp;
                int i69 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i69 + 1;
                iArr29[i69] = 60;
                return 0;
            case 40:
                int[] iArr30 = this.initRecordTimeStamp;
                int i70 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i70 + 1;
                iArr30[i70] = 111;
                return 0;
            case 41:
                int[] iArr31 = this.initRecordTimeStamp;
                int i71 = this.GetContactSyncConfig;
                iArr31[i71 - 1] = -iArr31[i71 - 1];
                int i72 = i71 + 2;
                this.GetContactSyncConfig = i72;
                iArr31[i72 - 1] = iArr31[i72 - 3];
                iArr31[i71] = iArr31[i72 - 4];
                iArr31[i72 - 1] = -iArr31[i72 - 1];
                return 0;
            case 42:
                int i73 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i73;
                int[] iArr32 = this.initRecordTimeStamp;
                iArr32[i73 - 1] = iArr32[i73 - 1] & iArr32[i73];
                int i74 = i73 - 1;
                this.GetContactSyncConfig = i74;
                iArr32[i74 - 1] = iArr32[i74 - 1] | iArr32[i74];
                this.GetContactSyncConfig = i74 + 1;
                iArr32[i74] = 1;
                return 0;
            case 43:
                int i75 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i75;
                int[] iArr33 = this.initRecordTimeStamp;
                iArr33[i75 - 1] = iArr33[i75 - 1] << iArr33[i75];
                int i76 = i75 + 1;
                this.GetContactSyncConfig = i76;
                int i77 = iArr33[i76 - 2];
                iArr33[i75] = i77;
                iArr33[i76 - 2] = iArr33[i76 - 3];
                iArr33[i76 - 3] = iArr33[i76 - 4];
                iArr33[i76 - 4] = i77;
                return 0;
            case 44:
                int i78 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i78;
                this.NetworkUserEntityData$$ExternalSyntheticLambda8[i78] = null;
                int[] iArr34 = this.initRecordTimeStamp;
                iArr34[i78 - 1] = -iArr34[i78 - 1];
                int i79 = i78 + 2;
                this.GetContactSyncConfig = i79;
                iArr34[i79 - 1] = iArr34[i79 - 3];
                iArr34[i78] = iArr34[i79 - 4];
                return 0;
            case 45:
                int[] iArr35 = this.initRecordTimeStamp;
                int i80 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i80 + 1;
                iArr35[i80] = -1;
                return 0;
            case 46:
                int i81 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i81;
                int[] iArr36 = this.initRecordTimeStamp;
                iArr36[i81 - 1] = iArr36[i81 - 1] & iArr36[i81];
                int i82 = i81 + 1;
                this.GetContactSyncConfig = i82;
                int i83 = iArr36[i82 - 2];
                iArr36[i81] = i83;
                iArr36[i82 - 2] = iArr36[i82 - 3];
                iArr36[i82 - 3] = iArr36[i82 - 4];
                iArr36[i82 - 4] = i83;
                int i84 = i82 - 1;
                this.GetContactSyncConfig = i84;
                this.NetworkUserEntityData$$ExternalSyntheticLambda8[i84] = null;
                return 0;
            case 47:
                int[] iArr37 = this.initRecordTimeStamp;
                int i85 = this.GetContactSyncConfig;
                int i86 = iArr37[i85 - 1];
                iArr37[i85 - 1] = iArr37[i85 - 2];
                iArr37[i85 - 2] = i86;
                return 0;
            case 48:
                int i87 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i87;
                int[] iArr38 = this.initRecordTimeStamp;
                iArr38[i87 - 1] = iArr38[i87 - 1] & iArr38[i87];
                int i88 = i87 - 1;
                this.GetContactSyncConfig = i88;
                iArr38[i88 - 1] = iArr38[i88 - 1] | iArr38[i88];
                iArr38[i88 - 1] = -iArr38[i88 - 1];
                return 0;
            case 49:
                int[] iArr39 = this.initRecordTimeStamp;
                int i89 = this.GetContactSyncConfig;
                int i90 = i89 + 1;
                this.GetContactSyncConfig = i90;
                iArr39[i89] = iArr39[i90 - 2];
                return 0;
            case 50:
                int[] iArr40 = this.initRecordTimeStamp;
                int i91 = this.GetContactSyncConfig;
                int i92 = iArr40[i91 - 1];
                iArr40[i91 - 1] = iArr40[i91 - 2];
                iArr40[i91 - 2] = i92;
                int i93 = i91 - 1;
                this.GetContactSyncConfig = i93;
                this.NetworkUserEntityData$$ExternalSyntheticLambda8[i93] = null;
                int i94 = i93 - 1;
                this.GetContactSyncConfig = i94;
                iArr40[i94 - 1] = iArr40[i94 - 1] - iArr40[i94];
                return 0;
            case 51:
                int i95 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i95;
                int[] iArr41 = this.initRecordTimeStamp;
                iArr41[i95 - 1] = iArr41[i95 - 1] - iArr41[i95];
                return 0;
            case 52:
                int[] iArr42 = this.initRecordTimeStamp;
                int i96 = this.GetContactSyncConfig;
                int i97 = i96 + 1;
                this.GetContactSyncConfig = i97;
                iArr42[i96] = 128;
                int i98 = i97 - 1;
                this.GetContactSyncConfig = i98;
                iArr42[i98 - 1] = iArr42[i98 - 1] % iArr42[i98];
                return 0;
            case 53:
                int[] iArr43 = this.initRecordTimeStamp;
                int i99 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i99 + 1;
                iArr43[i99] = 33;
                return 0;
            case 54:
                int[] iArr44 = this.initRecordTimeStamp;
                int i100 = this.GetContactSyncConfig;
                int i101 = i100 + 1;
                this.GetContactSyncConfig = i101;
                iArr44[i100] = 49;
                iArr44[i101 - 1] = -iArr44[i101 - 1];
                int i102 = i101 + 1;
                this.GetContactSyncConfig = i102;
                iArr44[i101] = iArr44[i102 - 2];
                return 0;
            case 55:
                int[] iArr45 = this.initRecordTimeStamp;
                int i103 = this.GetContactSyncConfig;
                iArr45[i103 - 1] = -iArr45[i103 - 1];
                this.GetContactSyncConfig = i103 + 1;
                iArr45[i103] = -1;
                return 0;
            case 56:
                int[] iArr46 = this.initRecordTimeStamp;
                int i104 = this.GetContactSyncConfig;
                int i105 = iArr46[i104 - 1];
                iArr46[i104 - 1] = iArr46[i104 - 2];
                iArr46[i104 - 2] = i105;
                int i106 = i104 - 1;
                this.GetContactSyncConfig = i106;
                this.NetworkUserEntityData$$ExternalSyntheticLambda8[i106] = null;
                return 0;
            case 57:
                int i107 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i107;
                int[] iArr47 = this.initRecordTimeStamp;
                iArr47[i107 - 1] = iArr47[i107 - 1] - iArr47[i107];
                this.GetContactSyncConfig = i107 + 1;
                iArr47[i107] = 1;
                return 0;
            case 58:
                int i108 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i108;
                int[] iArr48 = this.initRecordTimeStamp;
                iArr48[i108 - 1] = iArr48[i108 - 1] - iArr48[i108];
                int i109 = i108 + 1;
                this.GetContactSyncConfig = i109;
                iArr48[i108] = iArr48[i109 - 2];
                return 0;
            case 59:
                int[] iArr49 = this.initRecordTimeStamp;
                int i110 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i110 + 1;
                iArr49[i110] = 5;
                return 0;
            case 60:
                int[] iArr50 = this.initRecordTimeStamp;
                int i111 = this.GetContactSyncConfig;
                int i112 = i111 + 1;
                this.GetContactSyncConfig = i112;
                iArr50[i111] = 2;
                iArr50[i112 - 1] = -iArr50[i112 - 1];
                return 0;
            case 61:
                int[] iArr51 = this.initRecordTimeStamp;
                int i113 = this.GetContactSyncConfig;
                int i114 = i113 + 2;
                this.GetContactSyncConfig = i114;
                iArr51[i114 - 1] = iArr51[i114 - 3];
                iArr51[i113] = iArr51[i114 - 4];
                int i115 = i114 - 1;
                this.GetContactSyncConfig = i115;
                iArr51[i115 - 1] = iArr51[i115] ^ iArr51[i115 - 1];
                return 0;
            case 62:
                int[] iArr52 = this.initRecordTimeStamp;
                int i116 = this.GetContactSyncConfig;
                int i117 = i116 + 1;
                this.GetContactSyncConfig = i117;
                int i118 = iArr52[i117 - 2];
                iArr52[i116] = i118;
                iArr52[i117 - 2] = iArr52[i117 - 3];
                iArr52[i117 - 3] = iArr52[i117 - 4];
                iArr52[i117 - 4] = i118;
                int i119 = i117 - 1;
                this.GetContactSyncConfig = i119;
                this.NetworkUserEntityData$$ExternalSyntheticLambda8[i119] = null;
                int i120 = i119 + 2;
                this.GetContactSyncConfig = i120;
                iArr52[i120 - 1] = iArr52[i120 - 3];
                iArr52[i119] = iArr52[i120 - 4];
                return 0;
            case 63:
                int[] iArr53 = this.initRecordTimeStamp;
                int i121 = this.GetContactSyncConfig;
                int i122 = i121 + 1;
                this.GetContactSyncConfig = i122;
                iArr53[i121] = -1;
                int i123 = i122 - 1;
                this.GetContactSyncConfig = i123;
                iArr53[i123 - 1] = iArr53[i123] ^ iArr53[i123 - 1];
                return 0;
            case 64:
                int i124 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i124;
                int[] iArr54 = this.initRecordTimeStamp;
                iArr54[i124 - 1] = iArr54[i124 - 1] ^ iArr54[i124];
                int i125 = i124 - 1;
                this.GetContactSyncConfig = i125;
                this.NetworkUserEntityData$$ExternalSyntheticLambda8[i125] = null;
                return 0;
            case 65:
                int[] iArr55 = this.initRecordTimeStamp;
                int i126 = this.GetContactSyncConfig;
                int i127 = i126 + 1;
                this.GetContactSyncConfig = i127;
                iArr55[i126] = 1;
                int i128 = i127 - 1;
                this.GetContactSyncConfig = i128;
                iArr55[i128 - 1] = iArr55[i128 - 1] << iArr55[i128];
                int i129 = i128 - 1;
                this.GetContactSyncConfig = i129;
                iArr55[i129 - 1] = iArr55[i129 - 1] + iArr55[i129];
                return 0;
            case 66:
                Object[] objArr6 = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                int i130 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i130 + 1;
                objArr6[i130] = objArr6[9];
                return 0;
            case 67:
                int i131 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i131;
                Object[] objArr7 = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                Object obj3 = objArr7[i131];
                objArr7[i131] = null;
                objArr7[9] = obj3;
                return 0;
            case 68:
                int[] iArr56 = this.initRecordTimeStamp;
                int i132 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i132 + 1;
                iArr56[i132] = 19;
                return 0;
            case 69:
                int[] iArr57 = this.initRecordTimeStamp;
                int i133 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i133 + 1;
                iArr57[i133] = 21;
                return 0;
            case 70:
                int[] iArr58 = this.initRecordTimeStamp;
                int i134 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i134 + 1;
                iArr58[i134] = 0;
                return 0;
            case 71:
                int i135 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i135;
                int[] iArr59 = this.initRecordTimeStamp;
                iArr59[i135 - 1] = iArr59[i135 - 1] / iArr59[i135];
                return 0;
            case 72:
                int[] iArr60 = this.initRecordTimeStamp;
                int i136 = this.GetContactSyncConfig;
                int i137 = i136 + 1;
                this.GetContactSyncConfig = i137;
                iArr60[i136] = 21;
                int i138 = i137 + 1;
                this.GetContactSyncConfig = i138;
                iArr60[i137] = iArr60[i138 - 2];
                return 0;
            case 73:
                int[] iArr61 = this.initRecordTimeStamp;
                int i139 = this.GetContactSyncConfig;
                int i140 = i139 + 1;
                this.GetContactSyncConfig = i140;
                iArr61[i139] = -1;
                int i141 = i140 + 2;
                this.GetContactSyncConfig = i141;
                iArr61[i141 - 1] = iArr61[i141 - 3];
                iArr61[i140] = iArr61[i141 - 4];
                int i142 = i141 - 1;
                this.GetContactSyncConfig = i142;
                iArr61[i142 - 1] = iArr61[i142] & iArr61[i142 - 1];
                return 0;
            case 74:
                int[] iArr62 = this.initRecordTimeStamp;
                int i143 = this.GetContactSyncConfig;
                int i144 = i143 + 1;
                this.GetContactSyncConfig = i144;
                iArr62[i143] = iArr62[i144 - 2];
                iArr62[i144 - 1] = -iArr62[i144 - 1];
                return 0;
            case 75:
                int i145 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i145;
                int[] iArr63 = this.initRecordTimeStamp;
                iArr63[i145 - 1] = iArr63[i145 - 1] ^ iArr63[i145];
                int i146 = iArr63[i145 - 1];
                iArr63[i145 - 1] = iArr63[i145 - 2];
                iArr63[i145 - 2] = i146;
                int i147 = i145 - 1;
                this.GetContactSyncConfig = i147;
                this.NetworkUserEntityData$$ExternalSyntheticLambda8[i147] = null;
                return 0;
            case 76:
                int[] iArr64 = this.initRecordTimeStamp;
                int i148 = this.GetContactSyncConfig;
                int i149 = i148 + 1;
                this.GetContactSyncConfig = i149;
                iArr64[i148] = 1;
                int i150 = i149 - 1;
                this.GetContactSyncConfig = i150;
                iArr64[i150 - 1] = iArr64[i150 - 1] - iArr64[i150];
                return 0;
            case 77:
                int[] iArr65 = this.initRecordTimeStamp;
                int i151 = this.GetContactSyncConfig;
                int i152 = i151 + 1;
                this.GetContactSyncConfig = i152;
                iArr65[i151] = 1;
                int i153 = i152 - 1;
                this.GetContactSyncConfig = i153;
                iArr65[i153 - 1] = iArr65[i153 - 1] - iArr65[i153];
                int i154 = i153 + 1;
                this.GetContactSyncConfig = i154;
                iArr65[i153] = iArr65[i154 - 2];
                return 0;
            case 78:
                int[] iArr66 = this.initRecordTimeStamp;
                int i155 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i155 + 1;
                iArr66[i155] = 38;
                return 0;
            case 79:
                int i156 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i156;
                Object[] objArr8 = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                Object obj4 = objArr8[i156];
                objArr8[i156] = null;
                this.MyBillsEntityDataFactory = obj4 == null ? 1 : 0;
                return 0;
            case 80:
                Object[] objArr9 = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                int i157 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i157 + 1;
                objArr9[i157] = null;
                return 0;
            case 81:
                int[] iArr67 = this.initRecordTimeStamp;
                int i158 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i158 + 1;
                iArr67[i158] = 29;
                return 0;
            case 82:
                int i159 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i159;
                int[] iArr68 = this.initRecordTimeStamp;
                iArr68[i159 - 1] = iArr68[i159 - 1] & iArr68[i159];
                int i160 = i159 - 1;
                this.GetContactSyncConfig = i160;
                iArr68[i160 - 1] = iArr68[i160] | iArr68[i160 - 1];
                return 0;
            case 83:
                int i161 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i161;
                int[] iArr69 = this.initRecordTimeStamp;
                iArr69[i161 - 1] = iArr69[i161 - 1] << iArr69[i161];
                int i162 = i161 + 1;
                this.GetContactSyncConfig = i162;
                int i163 = iArr69[i162 - 2];
                iArr69[i161] = i163;
                iArr69[i162 - 2] = iArr69[i162 - 3];
                iArr69[i162 - 3] = iArr69[i162 - 4];
                iArr69[i162 - 4] = i163;
                int i164 = i162 - 1;
                this.GetContactSyncConfig = i164;
                this.NetworkUserEntityData$$ExternalSyntheticLambda8[i164] = null;
                return 0;
            case 84:
                int[] iArr70 = this.initRecordTimeStamp;
                int i165 = this.GetContactSyncConfig;
                iArr70[i165 - 1] = -iArr70[i165 - 1];
                int i166 = i165 - 1;
                this.GetContactSyncConfig = i166;
                iArr70[i166 - 1] = iArr70[i166 - 1] ^ iArr70[i166];
                int i167 = i166 - 1;
                this.GetContactSyncConfig = i167;
                iArr70[i167 - 1] = iArr70[i167 - 1] - iArr70[i167];
                return 0;
            case 85:
                int[] iArr71 = this.initRecordTimeStamp;
                int i168 = this.GetContactSyncConfig;
                int i169 = i168 + 1;
                this.GetContactSyncConfig = i169;
                iArr71[i168] = iArr71[i169 - 2];
                this.GetContactSyncConfig = i169 + 1;
                iArr71[i169] = 128;
                return 0;
            case 86:
                int[] iArr72 = this.initRecordTimeStamp;
                int i170 = this.GetContactSyncConfig;
                int i171 = i170 + 1;
                this.GetContactSyncConfig = i171;
                iArr72[i170] = 119;
                int i172 = i171 - 1;
                this.GetContactSyncConfig = i172;
                iArr72[i172 - 1] = iArr72[i172 - 1] + iArr72[i172];
                int i173 = i172 + 1;
                this.GetContactSyncConfig = i173;
                iArr72[i172] = iArr72[i173 - 2];
                return 0;
            case 87:
                long[] jArr = this.DatabaseTableConfigUtil;
                int i174 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i174 + 1;
                jArr[i174] = this.KClassImpl$Data$declaredNonStaticMembers$2;
                return 0;
            case 88:
                int i175 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i175;
                long[] jArr2 = this.DatabaseTableConfigUtil;
                jArr2[11] = jArr2[i175];
                Object[] objArr10 = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                this.GetContactSyncConfig = i175 + 1;
                objArr10[i175] = objArr10[9];
                return 0;
            case 89:
                int i176 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i176;
                long[] jArr3 = this.DatabaseTableConfigUtil;
                jArr3[13] = jArr3[i176];
                return 0;
            case 90:
                long[] jArr4 = this.DatabaseTableConfigUtil;
                int i177 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i177 + 1;
                jArr4[i177] = jArr4[11];
                return 0;
            case 91:
                long[] jArr5 = this.DatabaseTableConfigUtil;
                int i178 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                this.NetworkUserEntityData$$ExternalSyntheticLambda2 = i178 + 1;
                this.getAuthRequestContext = jArr5[i178];
                return 0;
            case 92:
                long[] jArr6 = this.DatabaseTableConfigUtil;
                int i179 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i179 + 1;
                jArr6[i179] = jArr6[13];
                return 0;
            case 93:
                int i180 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i180;
                long[] jArr7 = this.DatabaseTableConfigUtil;
                this.initRecordTimeStamp[i180 - 1] = (jArr7[i180 - 1] > jArr7[i180] ? 1 : (jArr7[i180 - 1] == jArr7[i180] ? 0 : -1));
                return 0;
            case 94:
                int i181 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i181;
                this.MyBillsEntityDataFactory = this.initRecordTimeStamp[i181] <= 0 ? 1 : 0;
                return 0;
            case 95:
                int[] iArr73 = this.initRecordTimeStamp;
                int i182 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i182 + 1;
                iArr73[i182] = 51;
                return 0;
            case 96:
                int[] iArr74 = this.initRecordTimeStamp;
                int i183 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i183 + 1;
                iArr74[i183] = 98;
                return 0;
            case 97:
                this.MyBillsEntityDataFactory = this.initRecordTimeStamp[this.GetContactSyncConfig - 1];
                return 0;
            case 98:
                int i184 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i184;
                Object[] objArr11 = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                Object obj5 = objArr11[i184];
                objArr11[i184] = null;
                objArr11[11] = obj5;
                int[] iArr75 = this.initRecordTimeStamp;
                this.GetContactSyncConfig = i184 + 1;
                iArr75[i184] = 0;
                return 0;
            case 99:
                int i185 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i185;
                int[] iArr76 = this.initRecordTimeStamp;
                iArr76[10] = iArr76[i185];
                Object[] objArr12 = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                this.GetContactSyncConfig = i185 + 1;
                objArr12[i185] = objArr12[11];
                return 0;
            case 100:
                int[] iArr77 = this.initRecordTimeStamp;
                int i186 = this.GetContactSyncConfig;
                int i187 = i186 + 1;
                this.GetContactSyncConfig = i187;
                iArr77[i186] = 61;
                iArr77[i187 - 1] = -iArr77[i187 - 1];
                int i188 = i187 + 2;
                this.GetContactSyncConfig = i188;
                iArr77[i188 - 1] = iArr77[i188 - 3];
                iArr77[i187] = iArr77[i188 - 4];
                return 0;
            case 101:
                int[] iArr78 = this.initRecordTimeStamp;
                int i189 = this.GetContactSyncConfig;
                iArr78[i189 - 1] = -iArr78[i189 - 1];
                int i190 = i189 - 1;
                this.GetContactSyncConfig = i190;
                iArr78[i190 - 1] = iArr78[i190 - 1] ^ iArr78[i190];
                int i191 = i190 + 1;
                this.GetContactSyncConfig = i191;
                int i192 = iArr78[i191 - 2];
                iArr78[i190] = i192;
                iArr78[i191 - 2] = iArr78[i191 - 3];
                iArr78[i191 - 3] = iArr78[i191 - 4];
                iArr78[i191 - 4] = i192;
                return 0;
            case 102:
                int i193 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i193;
                this.NetworkUserEntityData$$ExternalSyntheticLambda8[i193] = null;
                int[] iArr79 = this.initRecordTimeStamp;
                iArr79[i193 - 1] = -iArr79[i193 - 1];
                return 0;
            case 103:
                int[] iArr80 = this.initRecordTimeStamp;
                int i194 = this.GetContactSyncConfig;
                int i195 = i194 + 1;
                this.GetContactSyncConfig = i195;
                iArr80[i194] = 1;
                int i196 = i195 - 1;
                this.GetContactSyncConfig = i196;
                iArr80[i196 - 1] = iArr80[i196 - 1] << iArr80[i196];
                return 0;
            case 104:
                int i197 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i197;
                int[] iArr81 = this.initRecordTimeStamp;
                iArr81[i197 - 1] = iArr81[i197 - 1] + iArr81[i197];
                return 0;
            case 105:
                int[] iArr82 = this.initRecordTimeStamp;
                int i198 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i198 + 1;
                iArr82[i198] = 4;
                return 0;
            case 106:
                int[] iArr83 = this.initRecordTimeStamp;
                int i199 = this.GetContactSyncConfig;
                int i200 = i199 + 1;
                this.GetContactSyncConfig = i200;
                iArr83[i199] = 2;
                int i201 = i200 - 1;
                this.GetContactSyncConfig = i201;
                iArr83[i201 - 1] = iArr83[i201 - 1] >> iArr83[i201];
                int i202 = i201 - 1;
                this.GetContactSyncConfig = i202;
                this.NetworkUserEntityData$$ExternalSyntheticLambda8[i202] = null;
                return 0;
            case 107:
                int i203 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i203;
                Object[] objArr13 = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                Object obj6 = objArr13[i203];
                objArr13[i203] = null;
                objArr13[11] = obj6;
                int[] iArr84 = this.initRecordTimeStamp;
                int i204 = i203 + 1;
                this.GetContactSyncConfig = i204;
                iArr84[i203] = 0;
                int i205 = i204 - 1;
                this.GetContactSyncConfig = i205;
                iArr84[10] = iArr84[i205];
                return 0;
            case 108:
                Object[] objArr14 = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                int i206 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i206 + 1;
                objArr14[i206] = objArr14[11];
                return 0;
            case 109:
                int[] iArr85 = this.initRecordTimeStamp;
                int i207 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i207 + 1;
                iArr85[i207] = 117;
                return 0;
            case 110:
                int[] iArr86 = this.initRecordTimeStamp;
                int i208 = this.GetContactSyncConfig;
                int i209 = i208 + 2;
                this.GetContactSyncConfig = i209;
                iArr86[i209 - 1] = iArr86[i209 - 3];
                iArr86[i208] = iArr86[i209 - 4];
                int i210 = i209 + 2;
                this.GetContactSyncConfig = i210;
                iArr86[i210 - 1] = iArr86[i210 - 3];
                iArr86[i209] = iArr86[i210 - 4];
                int i211 = i210 - 1;
                this.GetContactSyncConfig = i211;
                iArr86[i211 - 1] = iArr86[i211] ^ iArr86[i211 - 1];
                return 0;
            case 111:
                int[] iArr87 = this.initRecordTimeStamp;
                int i212 = this.GetContactSyncConfig;
                int i213 = i212 + 1;
                this.GetContactSyncConfig = i213;
                int i214 = iArr87[i213 - 2];
                iArr87[i212] = i214;
                iArr87[i213 - 2] = iArr87[i213 - 3];
                iArr87[i213 - 3] = iArr87[i213 - 4];
                iArr87[i213 - 4] = i214;
                int i215 = i213 - 1;
                this.GetContactSyncConfig = i215;
                this.NetworkUserEntityData$$ExternalSyntheticLambda8[i215] = null;
                int i216 = i215 - 1;
                this.GetContactSyncConfig = i216;
                iArr87[i216 - 1] = iArr87[i216] & iArr87[i216 - 1];
                return 0;
            case 112:
                int i217 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i217;
                int[] iArr88 = this.initRecordTimeStamp;
                iArr88[i217 - 1] = iArr88[i217 - 1] | iArr88[i217];
                int i218 = i217 + 1;
                this.GetContactSyncConfig = i218;
                iArr88[i217] = 1;
                int i219 = i218 - 1;
                this.GetContactSyncConfig = i219;
                iArr88[i219 - 1] = iArr88[i219 - 1] << iArr88[i219];
                return 0;
            case 113:
                int i220 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i220;
                this.NetworkUserEntityData$$ExternalSyntheticLambda8[i220] = null;
                int[] iArr89 = this.initRecordTimeStamp;
                int i221 = i220 + 2;
                this.GetContactSyncConfig = i221;
                iArr89[i221 - 1] = iArr89[i221 - 3];
                iArr89[i220] = iArr89[i221 - 4];
                return 0;
            case 114:
                int[] iArr90 = this.initRecordTimeStamp;
                int i222 = this.GetContactSyncConfig;
                int i223 = i222 + 1;
                this.GetContactSyncConfig = i223;
                iArr90[i222] = -1;
                int i224 = i223 - 1;
                this.GetContactSyncConfig = i224;
                iArr90[i224 - 1] = iArr90[i224 - 1] ^ iArr90[i224];
                int i225 = i224 + 1;
                this.GetContactSyncConfig = i225;
                int i226 = iArr90[i225 - 2];
                iArr90[i224] = i226;
                iArr90[i225 - 2] = iArr90[i225 - 3];
                iArr90[i225 - 3] = iArr90[i225 - 4];
                iArr90[i225 - 4] = i226;
                return 0;
            case 115:
                int i227 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i227;
                this.NetworkUserEntityData$$ExternalSyntheticLambda8[i227] = null;
                int i228 = i227 - 1;
                this.GetContactSyncConfig = i228;
                int[] iArr91 = this.initRecordTimeStamp;
                iArr91[i228 - 1] = iArr91[i228 - 1] | iArr91[i228];
                int i229 = i228 - 1;
                this.GetContactSyncConfig = i229;
                iArr91[i229 - 1] = iArr91[i229] & iArr91[i229 - 1];
                return 0;
            case 116:
                int i230 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i230;
                int[] iArr92 = this.initRecordTimeStamp;
                iArr92[i230 - 1] = iArr92[i230] | iArr92[i230 - 1];
                return 0;
            case 117:
                int[] iArr93 = this.initRecordTimeStamp;
                int i231 = this.GetContactSyncConfig;
                int i232 = i231 + 1;
                this.GetContactSyncConfig = i232;
                iArr93[i231] = 1;
                int i233 = i232 - 1;
                this.GetContactSyncConfig = i233;
                iArr93[i233 - 1] = iArr93[i233 - 1] << iArr93[i233];
                int i234 = i233 + 1;
                this.GetContactSyncConfig = i234;
                int i235 = iArr93[i234 - 2];
                iArr93[i233] = i235;
                iArr93[i234 - 2] = iArr93[i234 - 3];
                iArr93[i234 - 3] = iArr93[i234 - 4];
                iArr93[i234 - 4] = i235;
                return 0;
            case 118:
                int i236 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i236;
                this.NetworkUserEntityData$$ExternalSyntheticLambda8[i236] = null;
                int i237 = i236 - 1;
                this.GetContactSyncConfig = i237;
                int[] iArr94 = this.initRecordTimeStamp;
                iArr94[i237 - 1] = iArr94[i237 - 1] ^ iArr94[i237];
                int i238 = i237 - 1;
                this.GetContactSyncConfig = i238;
                iArr94[i238 - 1] = iArr94[i238 - 1] - iArr94[i238];
                return 0;
            case 119:
                int[] iArr95 = this.initRecordTimeStamp;
                int i239 = this.GetContactSyncConfig;
                int i240 = i239 + 1;
                this.GetContactSyncConfig = i240;
                iArr95[i239] = iArr95[i240 - 2];
                int i241 = i240 + 1;
                this.GetContactSyncConfig = i241;
                iArr95[i240] = 128;
                int i242 = i241 - 1;
                this.GetContactSyncConfig = i242;
                iArr95[i242 - 1] = iArr95[i242 - 1] % iArr95[i242];
                return 0;
            case 120:
                int[] iArr96 = this.initRecordTimeStamp;
                int i243 = this.GetContactSyncConfig;
                int i244 = i243 + 1;
                this.GetContactSyncConfig = i244;
                iArr96[i243] = 27;
                int i245 = i244 + 2;
                this.GetContactSyncConfig = i245;
                iArr96[i245 - 1] = iArr96[i245 - 3];
                iArr96[i244] = iArr96[i245 - 4];
                return 0;
            case 121:
                int i246 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i246;
                this.NetworkUserEntityData$$ExternalSyntheticLambda8[i246] = null;
                int[] iArr97 = this.initRecordTimeStamp;
                int i247 = iArr97[i246 - 1];
                iArr97[i246 - 1] = iArr97[i246 - 2];
                iArr97[i246 - 2] = i247;
                return 0;
            case 122:
                int i248 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i248;
                int[] iArr98 = this.initRecordTimeStamp;
                iArr98[i248 - 1] = iArr98[i248 - 1] ^ iArr98[i248];
                int i249 = i248 - 1;
                this.GetContactSyncConfig = i249;
                iArr98[i249 - 1] = iArr98[i249 - 1] & iArr98[i249];
                int i250 = i249 - 1;
                this.GetContactSyncConfig = i250;
                iArr98[i250 - 1] = iArr98[i250] | iArr98[i250 - 1];
                return 0;
            case 123:
                int i251 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i251;
                int[] iArr99 = this.initRecordTimeStamp;
                iArr99[i251 - 1] = iArr99[i251 - 1] ^ iArr99[i251];
                int i252 = i251 - 1;
                this.GetContactSyncConfig = i252;
                iArr99[i252 - 1] = iArr99[i252] ^ iArr99[i252 - 1];
                return 0;
            case 124:
                int i253 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i253;
                int[] iArr100 = this.initRecordTimeStamp;
                iArr100[i253 - 1] = iArr100[i253 - 1] & iArr100[i253];
                this.GetContactSyncConfig = i253 + 1;
                iArr100[i253] = 1;
                return 0;
            case 125:
                int i254 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i254;
                int[] iArr101 = this.initRecordTimeStamp;
                iArr101[i254 - 1] = iArr101[i254 - 1] << iArr101[i254];
                int i255 = i254 + 2;
                this.GetContactSyncConfig = i255;
                iArr101[i255 - 1] = iArr101[i255 - 3];
                iArr101[i254] = iArr101[i255 - 4];
                int i256 = i255 - 1;
                this.GetContactSyncConfig = i256;
                iArr101[i256 - 1] = iArr101[i256] & iArr101[i256 - 1];
                return 0;
            case 126:
                int i257 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i257;
                int[] iArr102 = this.initRecordTimeStamp;
                iArr102[i257 - 1] = iArr102[i257 - 1] + iArr102[i257];
                int i258 = i257 + 1;
                this.GetContactSyncConfig = i258;
                iArr102[i257] = iArr102[i258 - 2];
                return 0;
            case 127:
                int[] iArr103 = this.initRecordTimeStamp;
                int i259 = this.GetContactSyncConfig;
                int i260 = i259 + 1;
                this.GetContactSyncConfig = i260;
                iArr103[i259] = 74;
                this.GetContactSyncConfig = i260 + 1;
                iArr103[i260] = 0;
                return 0;
            case 128:
                int[] iArr104 = this.initRecordTimeStamp;
                int i261 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i261 + 1;
                iArr104[i261] = 31;
                return 0;
            case 129:
                int[] iArr105 = this.initRecordTimeStamp;
                int i262 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i262 + 1;
                iArr105[i262] = 41;
                return 0;
            case 130:
                int i263 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i263;
                int[] iArr106 = this.initRecordTimeStamp;
                iArr106[i263 - 1] = iArr106[i263 - 1] & iArr106[i263];
                int i264 = i263 + 1;
                this.GetContactSyncConfig = i264;
                int i265 = iArr106[i264 - 2];
                iArr106[i263] = i265;
                iArr106[i264 - 2] = iArr106[i264 - 3];
                iArr106[i264 - 3] = iArr106[i264 - 4];
                iArr106[i264 - 4] = i265;
                return 0;
            case 131:
                int[] iArr107 = this.initRecordTimeStamp;
                int i266 = this.GetContactSyncConfig;
                int i267 = i266 + 2;
                this.GetContactSyncConfig = i267;
                iArr107[i267 - 1] = iArr107[i267 - 3];
                iArr107[i266] = iArr107[i267 - 4];
                int i268 = i267 - 1;
                this.GetContactSyncConfig = i268;
                iArr107[i268 - 1] = iArr107[i268 - 1] ^ iArr107[i268];
                int i269 = i268 + 1;
                this.GetContactSyncConfig = i269;
                int i270 = iArr107[i269 - 2];
                iArr107[i268] = i270;
                iArr107[i269 - 2] = iArr107[i269 - 3];
                iArr107[i269 - 3] = iArr107[i269 - 4];
                iArr107[i269 - 4] = i270;
                return 0;
            case 132:
                int i271 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i271;
                int[] iArr108 = this.initRecordTimeStamp;
                iArr108[i271 - 1] = iArr108[i271 - 1] ^ iArr108[i271];
                int i272 = i271 + 1;
                this.GetContactSyncConfig = i272;
                int i273 = iArr108[i272 - 2];
                iArr108[i271] = i273;
                iArr108[i272 - 2] = iArr108[i272 - 3];
                iArr108[i272 - 3] = iArr108[i272 - 4];
                iArr108[i272 - 4] = i273;
                return 0;
            case 133:
                int i274 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i274;
                int[] iArr109 = this.initRecordTimeStamp;
                iArr109[i274 - 1] = iArr109[i274 - 1] << iArr109[i274];
                int i275 = i274 - 1;
                this.GetContactSyncConfig = i275;
                iArr109[i275 - 1] = iArr109[i275 - 1] + iArr109[i275];
                return 0;
            case 134:
                int[] iArr110 = this.initRecordTimeStamp;
                int i276 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i276 + 1;
                iArr110[i276] = 75;
                return 0;
            case 135:
                int[] iArr111 = this.initRecordTimeStamp;
                int i277 = this.GetContactSyncConfig;
                int i278 = i277 + 1;
                this.GetContactSyncConfig = i278;
                iArr111[i277] = iArr111[i278 - 2];
                this.GetContactSyncConfig = i278 + 1;
                iArr111[i278] = -1;
                return 0;
            case 136:
                int i279 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i279;
                int[] iArr112 = this.initRecordTimeStamp;
                iArr112[i279 - 1] = iArr112[i279 - 1] ^ iArr112[i279];
                int i280 = iArr112[i279 - 1];
                iArr112[i279 - 1] = iArr112[i279 - 2];
                iArr112[i279 - 2] = i280;
                return 0;
            case 137:
                int i281 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i281;
                int[] iArr113 = this.initRecordTimeStamp;
                iArr113[i281 - 1] = iArr113[i281 - 1] - iArr113[i281];
                int i282 = i281 + 1;
                this.GetContactSyncConfig = i282;
                iArr113[i281] = iArr113[i282 - 2];
                this.GetContactSyncConfig = i282 + 1;
                iArr113[i282] = 128;
                return 0;
            case 138:
                int[] iArr114 = this.initRecordTimeStamp;
                int i283 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i283 + 1;
                iArr114[i283] = 7;
                return 0;
            case 139:
                int[] iArr115 = this.initRecordTimeStamp;
                int i284 = this.GetContactSyncConfig;
                int i285 = i284 + 2;
                this.GetContactSyncConfig = i285;
                iArr115[i285 - 1] = iArr115[i285 - 3];
                iArr115[i284] = iArr115[i285 - 4];
                int i286 = i285 + 1;
                this.GetContactSyncConfig = i286;
                iArr115[i285] = -1;
                int i287 = i286 - 1;
                this.GetContactSyncConfig = i287;
                iArr115[i287 - 1] = iArr115[i287] ^ iArr115[i287 - 1];
                return 0;
            case 140:
                int i288 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i288;
                int[] iArr116 = this.initRecordTimeStamp;
                iArr116[i288 - 1] = iArr116[i288 - 1] ^ iArr116[i288];
                int i289 = i288 - 1;
                this.GetContactSyncConfig = i289;
                iArr116[i289 - 1] = iArr116[i289] & iArr116[i289 - 1];
                return 0;
            case 141:
                int[] iArr117 = this.initRecordTimeStamp;
                int i290 = this.GetContactSyncConfig;
                int i291 = i290 + 1;
                this.GetContactSyncConfig = i291;
                iArr117[i290] = -1;
                int i292 = i291 - 1;
                this.GetContactSyncConfig = i292;
                iArr117[i292 - 1] = iArr117[i292 - 1] ^ iArr117[i292];
                int i293 = i292 - 1;
                this.GetContactSyncConfig = i293;
                iArr117[i293 - 1] = iArr117[i293] ^ iArr117[i293 - 1];
                return 0;
            case 142:
                int[] iArr118 = this.initRecordTimeStamp;
                int i294 = this.GetContactSyncConfig;
                int i295 = i294 + 1;
                this.GetContactSyncConfig = i295;
                iArr118[i294] = 1;
                int i296 = i295 - 1;
                this.GetContactSyncConfig = i296;
                iArr118[i296 - 1] = iArr118[i296 - 1] << iArr118[i296];
                iArr118[i296 - 1] = -iArr118[i296 - 1];
                return 0;
            case 143:
                int[] iArr119 = this.initRecordTimeStamp;
                int i297 = this.GetContactSyncConfig;
                int i298 = i297 + 1;
                this.GetContactSyncConfig = i298;
                int i299 = iArr119[i298 - 2];
                iArr119[i297] = i299;
                iArr119[i298 - 2] = iArr119[i298 - 3];
                iArr119[i298 - 3] = iArr119[i298 - 4];
                iArr119[i298 - 4] = i299;
                int i300 = i298 - 1;
                this.GetContactSyncConfig = i300;
                this.NetworkUserEntityData$$ExternalSyntheticLambda8[i300] = null;
                iArr119[i300 - 1] = -iArr119[i300 - 1];
                return 0;
            case 144:
                int i301 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i301;
                int[] iArr120 = this.initRecordTimeStamp;
                iArr120[i301 - 1] = iArr120[i301 - 1] & iArr120[i301];
                int i302 = i301 + 1;
                this.GetContactSyncConfig = i302;
                iArr120[i301] = 1;
                int i303 = i302 - 1;
                this.GetContactSyncConfig = i303;
                iArr120[i303 - 1] = iArr120[i303 - 1] << iArr120[i303];
                return 0;
            case 145:
                int[] iArr121 = this.initRecordTimeStamp;
                int i304 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i304 + 1;
                iArr121[i304] = 28;
                return 0;
            case 146:
                int[] iArr122 = this.initRecordTimeStamp;
                int i305 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i305 + 1;
                iArr122[i305] = 11;
                return 0;
            case 147:
                int[] iArr123 = this.initRecordTimeStamp;
                int i306 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i306 + 1;
                iArr123[i306] = iArr123[10];
                return 0;
            case 148:
                int i307 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i307;
                int[] iArr124 = this.initRecordTimeStamp;
                iArr124[10] = iArr124[i307];
                return 0;
            case 149:
                int[] iArr125 = this.initRecordTimeStamp;
                int i308 = this.GetContactSyncConfig;
                int i309 = i308 + 1;
                this.GetContactSyncConfig = i309;
                iArr125[i308] = 11;
                iArr125[i309 - 1] = -iArr125[i309 - 1];
                return 0;
            case 150:
                int[] iArr126 = this.initRecordTimeStamp;
                int i310 = this.GetContactSyncConfig;
                iArr126[i310 - 1] = -iArr126[i310 - 1];
                int i311 = i310 + 2;
                this.GetContactSyncConfig = i311;
                iArr126[i311 - 1] = iArr126[i311 - 3];
                iArr126[i310] = iArr126[i311 - 4];
                int i312 = i311 - 1;
                this.GetContactSyncConfig = i312;
                iArr126[i312 - 1] = iArr126[i312] ^ iArr126[i312 - 1];
                return 0;
            case 151:
                int i313 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i313;
                this.NetworkUserEntityData$$ExternalSyntheticLambda8[i313] = null;
                int[] iArr127 = this.initRecordTimeStamp;
                int i314 = iArr127[i313 - 1];
                iArr127[i313 - 1] = iArr127[i313 - 2];
                iArr127[i313 - 2] = i314;
                this.GetContactSyncConfig = i313 + 1;
                iArr127[i313] = -1;
                return 0;
            case 152:
                int i315 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i315;
                this.NetworkUserEntityData$$ExternalSyntheticLambda8[i315] = null;
                int i316 = i315 - 1;
                this.GetContactSyncConfig = i316;
                int[] iArr128 = this.initRecordTimeStamp;
                iArr128[i316 - 1] = iArr128[i316 - 1] | iArr128[i316];
                int i317 = i316 - 1;
                this.GetContactSyncConfig = i317;
                iArr128[i317 - 1] = iArr128[i317 - 1] + iArr128[i317];
                return 0;
            case 153:
                int[] iArr129 = this.initRecordTimeStamp;
                int i318 = this.GetContactSyncConfig;
                int i319 = i318 + 1;
                this.GetContactSyncConfig = i319;
                iArr129[i318] = 38;
                this.GetContactSyncConfig = i319 + 1;
                iArr129[i319] = 0;
                return 0;
            case 154:
                int i320 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i320;
                int[] iArr130 = this.initRecordTimeStamp;
                iArr130[i320 - 1] = iArr130[i320 - 1] / iArr130[i320];
                int i321 = i320 - 1;
                this.GetContactSyncConfig = i321;
                this.NetworkUserEntityData$$ExternalSyntheticLambda8[i321] = null;
                return 0;
            case TarHeader.USTAR_FILENAME_PREFIX /* 155 */:
                int[] iArr131 = this.initRecordTimeStamp;
                int i322 = this.GetContactSyncConfig;
                int i323 = i322 + 1;
                this.GetContactSyncConfig = i323;
                iArr131[i322] = 43;
                int i324 = i323 + 2;
                this.GetContactSyncConfig = i324;
                iArr131[i324 - 1] = iArr131[i324 - 3];
                iArr131[i323] = iArr131[i324 - 4];
                int i325 = i324 - 1;
                this.GetContactSyncConfig = i325;
                iArr131[i325 - 1] = iArr131[i325] & iArr131[i325 - 1];
                return 0;
            case 156:
                Object[] objArr15 = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                int i326 = this.GetContactSyncConfig;
                int i327 = i326 + 1;
                this.GetContactSyncConfig = i327;
                objArr15[i326] = objArr15[i327 - 2];
                int i328 = i327 - 1;
                this.GetContactSyncConfig = i328;
                Object obj7 = objArr15[i328];
                objArr15[i328] = null;
                objArr15[10] = obj7;
                return 0;
            case 157:
                int i329 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i329;
                Object[] objArr16 = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                objArr16[i329] = null;
                int i330 = i329 + 1;
                this.GetContactSyncConfig = i330;
                objArr16[i329] = objArr16[9];
                this.GetContactSyncConfig = i330 + 1;
                objArr16[i330] = objArr16[10];
                return 0;
            case 158:
                int i331 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i331;
                Object[] objArr17 = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                Object obj8 = objArr17[i331];
                objArr17[i331] = null;
                objArr17[12] = obj8;
                this.GetContactSyncConfig = i331 + 1;
                objArr17[i331] = objArr17[8];
                return 0;
            case 159:
                Object[] objArr18 = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                int i332 = this.GetContactSyncConfig;
                int i333 = i332 + 1;
                this.GetContactSyncConfig = i333;
                objArr18[i332] = objArr18[10];
                int i334 = i333 + 1;
                this.GetContactSyncConfig = i334;
                objArr18[i333] = objArr18[11];
                this.GetContactSyncConfig = i334 + 1;
                objArr18[i334] = objArr18[9];
                return 0;
            case BlobStatic.MONITOR_IMAGE_WIDTH /* 160 */:
                int i335 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i335;
                Object[] objArr19 = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                Object obj9 = objArr19[i335];
                objArr19[i335] = null;
                objArr19[9] = obj9;
                int i336 = i335 + 1;
                this.GetContactSyncConfig = i336;
                objArr19[i335] = objArr19[12];
                this.GetContactSyncConfig = i336 + 1;
                objArr19[i336] = objArr19[9];
                return 0;
            case 161:
                int[] iArr132 = this.initRecordTimeStamp;
                int i337 = this.GetContactSyncConfig;
                int i338 = i337 + 1;
                this.GetContactSyncConfig = i338;
                iArr132[i337] = 125;
                int i339 = i338 + 2;
                this.GetContactSyncConfig = i339;
                iArr132[i339 - 1] = iArr132[i339 - 3];
                iArr132[i338] = iArr132[i339 - 4];
                int i340 = i339 + 2;
                this.GetContactSyncConfig = i340;
                iArr132[i340 - 1] = iArr132[i340 - 3];
                iArr132[i339] = iArr132[i340 - 4];
                return 0;
            case 162:
                int i341 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i341;
                int[] iArr133 = this.initRecordTimeStamp;
                iArr133[i341 - 1] = iArr133[i341 - 1] ^ iArr133[i341];
                int i342 = i341 + 1;
                this.GetContactSyncConfig = i342;
                int i343 = iArr133[i342 - 2];
                iArr133[i341] = i343;
                iArr133[i342 - 2] = iArr133[i342 - 3];
                iArr133[i342 - 3] = iArr133[i342 - 4];
                iArr133[i342 - 4] = i343;
                int i344 = i342 - 1;
                this.GetContactSyncConfig = i344;
                this.NetworkUserEntityData$$ExternalSyntheticLambda8[i344] = null;
                return 0;
            case 163:
                int i345 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i345;
                int[] iArr134 = this.initRecordTimeStamp;
                iArr134[i345 - 1] = iArr134[i345 - 1] << iArr134[i345];
                int i346 = i345 + 2;
                this.GetContactSyncConfig = i346;
                iArr134[i346 - 1] = iArr134[i346 - 3];
                iArr134[i345] = iArr134[i346 - 4];
                return 0;
            case 164:
                int[] iArr135 = this.initRecordTimeStamp;
                int i347 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i347 + 1;
                iArr135[i347] = 43;
                return 0;
            case 165:
                int[] iArr136 = this.initRecordTimeStamp;
                int i348 = this.GetContactSyncConfig;
                int i349 = i348 + 2;
                this.GetContactSyncConfig = i349;
                iArr136[i349 - 1] = iArr136[i349 - 3];
                iArr136[i348] = iArr136[i349 - 4];
                iArr136[i349 - 1] = -iArr136[i349 - 1];
                return 0;
            case 166:
                int i350 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i350;
                int[] iArr137 = this.initRecordTimeStamp;
                iArr137[i350 - 1] = iArr137[i350 - 1] | iArr137[i350];
                int i351 = i350 + 2;
                this.GetContactSyncConfig = i351;
                iArr137[i351 - 1] = iArr137[i351 - 3];
                iArr137[i350] = iArr137[i351 - 4];
                int i352 = i351 - 1;
                this.GetContactSyncConfig = i352;
                iArr137[i352 - 1] = iArr137[i352] | iArr137[i352 - 1];
                return 0;
            case 167:
                int i353 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i353;
                this.NetworkUserEntityData$$ExternalSyntheticLambda8[i353] = null;
                int i354 = i353 - 1;
                this.GetContactSyncConfig = i354;
                int[] iArr138 = this.initRecordTimeStamp;
                iArr138[i354 - 1] = iArr138[i354] ^ iArr138[i354 - 1];
                return 0;
            case 168:
                Object[] objArr20 = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                int i355 = this.GetContactSyncConfig;
                int i356 = i355 + 1;
                this.GetContactSyncConfig = i356;
                objArr20[i355] = null;
                Object obj10 = objArr20[i356 - 1];
                objArr20[i356 - 1] = null;
                this.initRecordTimeStamp[i356 - 1] = ((int[]) obj10).length;
                int i357 = i356 - 1;
                this.GetContactSyncConfig = i357;
                objArr20[i357] = null;
                return 0;
            case 169:
                int[] iArr139 = this.initRecordTimeStamp;
                int i358 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i358 + 1;
                iArr139[i358] = 95;
                return 0;
            case 170:
                int i359 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i359;
                int[] iArr140 = this.initRecordTimeStamp;
                iArr140[i359 - 1] = iArr140[i359 - 1] << iArr140[i359];
                return 0;
            case 171:
                int[] iArr141 = this.initRecordTimeStamp;
                int i360 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i360 + 1;
                iArr141[i360] = 90;
                return 0;
            case 172:
                int[] iArr142 = this.initRecordTimeStamp;
                int i361 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i361 + 1;
                iArr142[i361] = 63;
                return 0;
            case 173:
                int[] iArr143 = this.initRecordTimeStamp;
                int i362 = this.GetContactSyncConfig;
                int i363 = i362 + 1;
                this.GetContactSyncConfig = i363;
                iArr143[i362] = 89;
                iArr143[i363 - 1] = -iArr143[i363 - 1];
                int i364 = i363 + 1;
                this.GetContactSyncConfig = i364;
                iArr143[i363] = iArr143[i364 - 2];
                return 0;
            case 174:
                int[] iArr144 = this.initRecordTimeStamp;
                int i365 = this.GetContactSyncConfig;
                iArr144[i365 - 1] = -iArr144[i365 - 1];
                int i366 = i365 + 1;
                this.GetContactSyncConfig = i366;
                iArr144[i365] = -1;
                int i367 = i366 - 1;
                this.GetContactSyncConfig = i367;
                iArr144[i367 - 1] = iArr144[i367] ^ iArr144[i367 - 1];
                return 0;
            case 175:
                int i368 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i368;
                this.NetworkUserEntityData$$ExternalSyntheticLambda8[i368] = null;
                int i369 = i368 - 1;
                this.GetContactSyncConfig = i369;
                int[] iArr145 = this.initRecordTimeStamp;
                iArr145[i369 - 1] = iArr145[i369 - 1] - iArr145[i369];
                return 0;
            case 176:
                int[] iArr146 = this.initRecordTimeStamp;
                int i370 = this.GetContactSyncConfig;
                int i371 = i370 + 1;
                this.GetContactSyncConfig = i371;
                iArr146[i370] = 1;
                int i372 = i371 + 2;
                this.GetContactSyncConfig = i372;
                iArr146[i372 - 1] = iArr146[i372 - 3];
                iArr146[i371] = iArr146[i372 - 4];
                return 0;
            case 177:
                int i373 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i373;
                int[] iArr147 = this.initRecordTimeStamp;
                iArr147[i373 - 1] = iArr147[i373 - 1] ^ iArr147[i373];
                int i374 = i373 - 1;
                this.GetContactSyncConfig = i374;
                iArr147[i374 - 1] = iArr147[i374 - 1] - iArr147[i374];
                return 0;
            case 178:
                int[] iArr148 = this.initRecordTimeStamp;
                int i375 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i375 + 1;
                iArr148[i375] = 18;
                return 0;
            case 179:
                int[] iArr149 = this.initRecordTimeStamp;
                int i376 = this.GetContactSyncConfig;
                int i377 = i376 + 1;
                this.GetContactSyncConfig = i377;
                iArr149[i376] = 83;
                iArr149[i377 - 1] = -iArr149[i377 - 1];
                return 0;
            case 180:
                int[] iArr150 = this.initRecordTimeStamp;
                int i378 = this.GetContactSyncConfig;
                int i379 = iArr150[i378 - 1];
                iArr150[i378 - 1] = iArr150[i378 - 2];
                iArr150[i378 - 2] = i379;
                int i380 = i378 + 1;
                this.GetContactSyncConfig = i380;
                iArr150[i378] = -1;
                int i381 = i380 - 1;
                this.GetContactSyncConfig = i381;
                iArr150[i381 - 1] = iArr150[i381] ^ iArr150[i381 - 1];
                return 0;
            case 181:
                int[] iArr151 = this.initRecordTimeStamp;
                int i382 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i382 + 1;
                iArr151[i382] = 77;
                return 0;
            case 182:
                int[] iArr152 = this.initRecordTimeStamp;
                int i383 = this.GetContactSyncConfig;
                int i384 = i383 + 2;
                this.GetContactSyncConfig = i384;
                iArr152[i384 - 1] = iArr152[i384 - 3];
                iArr152[i383] = iArr152[i384 - 4];
                this.GetContactSyncConfig = i384 + 1;
                iArr152[i384] = -1;
                return 0;
            case 183:
                int[] iArr153 = this.initRecordTimeStamp;
                int i385 = this.GetContactSyncConfig;
                int i386 = i385 + 1;
                this.GetContactSyncConfig = i386;
                iArr153[i385] = -1;
                int i387 = i386 - 1;
                this.GetContactSyncConfig = i387;
                iArr153[i387 - 1] = iArr153[i387 - 1] ^ iArr153[i387];
                int i388 = i387 - 1;
                this.GetContactSyncConfig = i388;
                iArr153[i388 - 1] = iArr153[i388] & iArr153[i388 - 1];
                return 0;
            case 184:
                int[] iArr154 = this.initRecordTimeStamp;
                int i389 = this.GetContactSyncConfig;
                iArr154[i389 - 1] = -iArr154[i389 - 1];
                int i390 = i389 + 1;
                this.GetContactSyncConfig = i390;
                iArr154[i389] = iArr154[i390 - 2];
                return 0;
            case WSContextConstant.HANDSHAKE_RECEIVE_SIZE /* 185 */:
                int[] iArr155 = this.initRecordTimeStamp;
                int i391 = this.GetContactSyncConfig;
                int i392 = i391 + 1;
                this.GetContactSyncConfig = i392;
                iArr155[i391] = 1;
                iArr155[i392 - 1] = -iArr155[i392 - 1];
                return 0;
            case 186:
                int[] iArr156 = this.initRecordTimeStamp;
                int i393 = this.GetContactSyncConfig;
                Object[] objArr21 = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                Object obj11 = objArr21[i393 - 1];
                objArr21[i393 - 1] = null;
                iArr156[i393 - 1] = ((int[]) obj11).length;
                int i394 = i393 - 1;
                this.GetContactSyncConfig = i394;
                objArr21[i394] = null;
                return 0;
            case 187:
                int[] iArr157 = this.initRecordTimeStamp;
                int i395 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i395 + 1;
                iArr157[i395] = 61;
                return 0;
            case 188:
                int[] iArr158 = this.initRecordTimeStamp;
                int i396 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i396 + 1;
                iArr158[i396] = 48;
                return 0;
            case WSContextConstant.HANDSHAKE_SEND_SIZE /* 189 */:
                int[] iArr159 = this.initRecordTimeStamp;
                int i397 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i397 + 1;
                iArr159[i397] = iArr159[11];
                return 0;
            case 190:
                int i398 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i398;
                Object[] objArr22 = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                Object obj12 = objArr22[i398];
                objArr22[i398] = null;
                objArr22[9] = obj12;
                this.GetContactSyncConfig = i398 + 1;
                objArr22[i398] = objArr22[12];
                return 0;
            case 191:
                Object[] objArr23 = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                int i399 = this.GetContactSyncConfig;
                int i400 = i399 + 1;
                this.GetContactSyncConfig = i400;
                objArr23[i399] = objArr23[i400 - 2];
                return 0;
            case 192:
                int i401 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i401;
                Object[] objArr24 = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                Object obj13 = objArr24[i401];
                objArr24[i401] = null;
                objArr24[10] = obj13;
                return 0;
            case 193:
                int[] iArr160 = this.initRecordTimeStamp;
                int i402 = this.GetContactSyncConfig;
                int i403 = i402 + 1;
                this.GetContactSyncConfig = i403;
                iArr160[i402] = 98;
                int i404 = i403 + 1;
                this.GetContactSyncConfig = i404;
                iArr160[i403] = 0;
                int i405 = i404 - 1;
                this.GetContactSyncConfig = i405;
                iArr160[i405 - 1] = iArr160[i405 - 1] / iArr160[i405];
                return 0;
            case 194:
                int[] iArr161 = this.initRecordTimeStamp;
                int i406 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i406 + 1;
                iArr161[i406] = 9;
                return 0;
            case 195:
                int[] iArr162 = this.initRecordTimeStamp;
                int i407 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i407 + 1;
                iArr162[i407] = 4;
                return 0;
            case 196:
                int[] iArr163 = this.initRecordTimeStamp;
                int i408 = this.GetContactSyncConfig;
                int i409 = i408 + 1;
                this.GetContactSyncConfig = i409;
                iArr163[i408] = 109;
                int i410 = i409 - 1;
                this.GetContactSyncConfig = i410;
                iArr163[i410 - 1] = iArr163[i410 - 1] + iArr163[i410];
                return 0;
            case 197:
                Object[] objArr25 = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                int i411 = this.GetContactSyncConfig;
                int i412 = i411 + 1;
                this.GetContactSyncConfig = i412;
                objArr25[i411] = objArr25[8];
                this.GetContactSyncConfig = i412 + 1;
                objArr25[i412] = objArr25[10];
                return 0;
            case 198:
                int i413 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i413;
                Object[] objArr26 = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                Object obj14 = objArr26[i413];
                objArr26[i413] = null;
                objArr26[12] = obj14;
                return 0;
            case SecExceptionCode.SEC_ERROR_INIT_UNKNOWN_ERROR /* 199 */:
                Object[] objArr27 = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                int i414 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i414 + 1;
                objArr27[i414] = objArr27[12];
                return 0;
            case 200:
                int i415 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i415;
                Object[] objArr28 = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                Object obj15 = objArr28[i415];
                objArr28[i415] = null;
                objArr28[9] = obj15;
                this.GetContactSyncConfig = i415 + 1;
                objArr28[i415] = objArr28[8];
                return 0;
            case 201:
                int[] iArr164 = this.initRecordTimeStamp;
                int i416 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i416 + 1;
                iArr164[i416] = 125;
                return 0;
            case 202:
                int[] iArr165 = this.initRecordTimeStamp;
                int i417 = this.GetContactSyncConfig;
                int i418 = i417 + 2;
                this.GetContactSyncConfig = i418;
                iArr165[i418 - 1] = iArr165[i418 - 3];
                iArr165[i417] = iArr165[i418 - 4];
                int i419 = i418 + 2;
                this.GetContactSyncConfig = i419;
                iArr165[i419 - 1] = iArr165[i419 - 3];
                iArr165[i418] = iArr165[i419 - 4];
                this.GetContactSyncConfig = i419 + 1;
                iArr165[i419] = -1;
                return 0;
            case 203:
                int i420 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i420;
                int[] iArr166 = this.initRecordTimeStamp;
                iArr166[i420 - 1] = iArr166[i420 - 1] ^ iArr166[i420];
                int i421 = i420 - 1;
                this.GetContactSyncConfig = i421;
                this.NetworkUserEntityData$$ExternalSyntheticLambda8[i421] = null;
                int i422 = i421 - 1;
                this.GetContactSyncConfig = i422;
                iArr166[i422 - 1] = iArr166[i422] & iArr166[i422 - 1];
                return 0;
            case 204:
                int i423 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i423;
                int[] iArr167 = this.initRecordTimeStamp;
                iArr167[i423 - 1] = iArr167[i423 - 1] | iArr167[i423];
                iArr167[i423 - 1] = -iArr167[i423 - 1];
                int i424 = i423 + 2;
                this.GetContactSyncConfig = i424;
                iArr167[i424 - 1] = iArr167[i424 - 3];
                iArr167[i423] = iArr167[i424 - 4];
                return 0;
            case 205:
                int[] iArr168 = this.initRecordTimeStamp;
                int i425 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i425 + 1;
                iArr168[i425] = 49;
                return 0;
            case 206:
                int[] iArr169 = this.initRecordTimeStamp;
                int i426 = this.GetContactSyncConfig;
                Object[] objArr29 = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                Object obj16 = objArr29[i426 - 1];
                objArr29[i426 - 1] = null;
                iArr169[i426 - 1] = ((int[]) obj16).length;
                return 0;
            case 207:
                Object[] objArr30 = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                int i427 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i427 + 1;
                objArr30[i427] = objArr30[10];
                return 0;
            case 208:
                int[] iArr170 = this.initRecordTimeStamp;
                int i428 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i428 + 1;
                iArr170[i428] = 55;
                return 0;
            case 209:
                int[] iArr171 = this.initRecordTimeStamp;
                int i429 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i429 + 1;
                iArr171[i429] = 57;
                return 0;
            case 210:
                int i430 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i430;
                int[] iArr172 = this.initRecordTimeStamp;
                iArr172[i430 - 1] = iArr172[i430 - 1] | iArr172[i430];
                int i431 = i430 - 1;
                this.GetContactSyncConfig = i431;
                iArr172[i431 - 1] = iArr172[i431] & iArr172[i431 - 1];
                return 0;
            case 211:
                Object[] objArr31 = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                int i432 = this.GetContactSyncConfig;
                int i433 = i432 + 1;
                this.GetContactSyncConfig = i433;
                objArr31[i432] = objArr31[9];
                this.GetContactSyncConfig = i433 + 1;
                objArr31[i433] = objArr31[10];
                return 0;
            default:
                return i;
        }
        return 0;
    }
}
