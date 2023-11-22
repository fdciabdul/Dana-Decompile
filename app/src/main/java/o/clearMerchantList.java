package o;

import com.alibaba.ariver.engine.common.track.recovery.DeepRecoverARiverProxy;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.image.framework.utils.FileUtils;
import com.alibaba.griver.ui.ant.utils.AUScreenAdaptTool;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.android.phone.mobilesdk.socketcraft.WebSocket;
import com.alipay.android.phone.mobilesdk.socketcraft.api.WSContextConstant;
import com.alipay.iap.android.aplog.util.zip.LZMA_Base;
import com.alipay.mobile.verifyidentity.business.securitycommon.widget.WheelView;
import com.alipay.zoloz.toyger.blob.BlobStatic;
import id.dana.data.here.HereOauthManager;

/* loaded from: classes4.dex */
public class clearMerchantList {
    public int BuiltInFictitiousFunctionClassFactory;
    private final long[] DatabaseTableConfigUtil;
    private int GetContactSyncConfig;
    public long KClassImpl$Data$declaredNonStaticMembers$2;
    public int MyBillsEntityDataFactory;
    public Object NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final float[] NetworkUserEntityData$$ExternalSyntheticLambda1;
    private int NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final double[] NetworkUserEntityData$$ExternalSyntheticLambda7;
    public float PlaceComponentResult;
    private final Object[] PrepareContext;
    public long getAuthRequestContext;
    public double getErrorConfigVersion;
    private final int[] initRecordTimeStamp;
    public Object lookAheadTest;
    public float moveToNextValue;
    public double scheduleImpl;

    public clearMerchantList() {
        this.initRecordTimeStamp = new int[20];
        this.DatabaseTableConfigUtil = new long[20];
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new float[20];
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = new double[20];
        this.PrepareContext = new Object[20];
        this.GetContactSyncConfig = 0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = -1;
    }

    public clearMerchantList(Object obj) {
        this.initRecordTimeStamp = new int[20];
        this.DatabaseTableConfigUtil = new long[20];
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new float[20];
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = new double[20];
        Object[] objArr = new Object[20];
        this.PrepareContext = objArr;
        objArr[10] = obj;
        this.GetContactSyncConfig = 0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = -1;
    }

    public clearMerchantList(Object obj, Object obj2) {
        this.initRecordTimeStamp = new int[20];
        this.DatabaseTableConfigUtil = new long[20];
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new float[20];
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = new double[20];
        Object[] objArr = new Object[20];
        this.PrepareContext = objArr;
        objArr[10] = obj;
        objArr[11] = obj2;
        this.GetContactSyncConfig = 0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = -1;
    }

    public clearMerchantList(Object obj, Object obj2, int i) {
        int[] iArr = new int[20];
        this.initRecordTimeStamp = iArr;
        this.DatabaseTableConfigUtil = new long[20];
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new float[20];
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = new double[20];
        Object[] objArr = new Object[20];
        this.PrepareContext = objArr;
        objArr[10] = obj;
        objArr[11] = obj2;
        iArr[12] = i;
        this.GetContactSyncConfig = 0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = -1;
    }

    public clearMerchantList(Object obj, Object obj2, int i, Object obj3) {
        int[] iArr = new int[20];
        this.initRecordTimeStamp = iArr;
        this.DatabaseTableConfigUtil = new long[20];
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new float[20];
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = new double[20];
        Object[] objArr = new Object[20];
        this.PrepareContext = objArr;
        objArr[10] = obj;
        objArr[11] = obj2;
        iArr[12] = i;
        objArr[13] = obj3;
        this.GetContactSyncConfig = 0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = -1;
    }

    public clearMerchantList(Object obj, Object obj2, Object obj3) {
        this.initRecordTimeStamp = new int[20];
        this.DatabaseTableConfigUtil = new long[20];
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new float[20];
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = new double[20];
        Object[] objArr = new Object[20];
        this.PrepareContext = objArr;
        objArr[10] = obj;
        objArr[11] = obj2;
        objArr[12] = obj3;
        this.GetContactSyncConfig = 0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = -1;
    }

    public clearMerchantList(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        this.initRecordTimeStamp = new int[20];
        this.DatabaseTableConfigUtil = new long[20];
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new float[20];
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = new double[20];
        Object[] objArr = new Object[20];
        this.PrepareContext = objArr;
        objArr[10] = obj;
        objArr[11] = obj2;
        objArr[12] = obj3;
        objArr[13] = obj4;
        objArr[14] = obj5;
        objArr[15] = obj6;
        this.GetContactSyncConfig = 0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = -1;
    }

    public clearMerchantList(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        this.initRecordTimeStamp = new int[20];
        this.DatabaseTableConfigUtil = new long[20];
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new float[20];
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = new double[20];
        Object[] objArr = new Object[20];
        this.PrepareContext = objArr;
        objArr[10] = obj;
        objArr[11] = obj2;
        objArr[12] = obj3;
        objArr[13] = obj4;
        objArr[14] = obj5;
        objArr[15] = obj6;
        objArr[16] = obj7;
        this.GetContactSyncConfig = 0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = -1;
    }

    public clearMerchantList(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
        this.initRecordTimeStamp = new int[20];
        this.DatabaseTableConfigUtil = new long[20];
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new float[20];
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = new double[20];
        Object[] objArr = new Object[20];
        this.PrepareContext = objArr;
        objArr[10] = obj;
        objArr[11] = obj2;
        objArr[12] = obj3;
        objArr[13] = obj4;
        objArr[14] = obj5;
        objArr[15] = obj6;
        objArr[16] = obj7;
        objArr[17] = obj8;
        this.GetContactSyncConfig = 0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = -1;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public int PlaceComponentResult(int i) {
        switch (i) {
            case 1:
                int[] iArr = this.initRecordTimeStamp;
                int i2 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i2 + 1;
                iArr[i2] = 99;
                return 0;
            case 2:
                Object[] objArr = this.PrepareContext;
                int i3 = this.GetContactSyncConfig;
                Object obj = objArr[i3 - 1];
                objArr[i3 - 1] = null;
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = obj;
                return 0;
            case 3:
                int[] iArr2 = this.initRecordTimeStamp;
                int i4 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i4 + 1;
                iArr2[i4] = 2;
                return 0;
            case 4:
                int i5 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i5;
                int[] iArr3 = this.initRecordTimeStamp;
                iArr3[i5 - 1] = iArr3[i5 - 1] % iArr3[i5];
                int i6 = i5 - 1;
                this.GetContactSyncConfig = i6;
                this.PrepareContext[i6] = null;
                return 0;
            case 5:
                int[] iArr4 = this.initRecordTimeStamp;
                int i7 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i7;
                this.BuiltInFictitiousFunctionClassFactory = iArr4[i7];
                return 0;
            case 6:
                break;
            case 7:
                Object[] objArr2 = this.PrepareContext;
                int i8 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i8 + 1;
                objArr2[i8] = objArr2[10];
                break;
            case 8:
                int i9 = this.GetContactSyncConfig - this.MyBillsEntityDataFactory;
                this.GetContactSyncConfig = i9;
                this.NetworkUserEntityData$$ExternalSyntheticLambda2 = i9;
                return 0;
            case 9:
                Object[] objArr3 = this.PrepareContext;
                int i10 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                this.NetworkUserEntityData$$ExternalSyntheticLambda2 = i10 + 1;
                Object obj2 = objArr3[i10];
                objArr3[i10] = null;
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = obj2;
                return 0;
            case 10:
                Object[] objArr4 = this.PrepareContext;
                int i11 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i11 + 1;
                objArr4[i11] = this.lookAheadTest;
                return 0;
            case 11:
                Object[] objArr5 = this.PrepareContext;
                int i12 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i12 + 1;
                objArr5[i12] = objArr5[11];
                return 0;
            case 12:
                Object[] objArr6 = this.PrepareContext;
                int i13 = this.GetContactSyncConfig;
                int i14 = i13 + 1;
                this.GetContactSyncConfig = i14;
                objArr6[i13] = objArr6[10];
                this.GetContactSyncConfig = i14 + 1;
                objArr6[i14] = objArr6[11];
                return 0;
            case 13:
                Object[] objArr7 = this.PrepareContext;
                int i15 = this.GetContactSyncConfig;
                int i16 = i15 + 1;
                this.GetContactSyncConfig = i16;
                objArr7[i15] = null;
                Object obj3 = objArr7[i16 - 1];
                objArr7[i16 - 1] = null;
                this.initRecordTimeStamp[i16 - 1] = ((int[]) obj3).length;
                return 0;
            case 14:
                int i17 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i17;
                this.PrepareContext[i17] = null;
                return 0;
            case 15:
                int[] iArr5 = this.initRecordTimeStamp;
                int i18 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i18 + 1;
                iArr5[i18] = 48;
                return 0;
            case 16:
                int[] iArr6 = this.initRecordTimeStamp;
                int i19 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i19 + 1;
                iArr6[i19] = this.MyBillsEntityDataFactory;
                return 0;
            case 17:
                int[] iArr7 = this.initRecordTimeStamp;
                int i20 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i20 + 1;
                iArr7[i20] = 53;
                return 0;
            case 18:
                int[] iArr8 = this.initRecordTimeStamp;
                int i21 = this.GetContactSyncConfig;
                int i22 = i21 + 2;
                this.GetContactSyncConfig = i22;
                iArr8[i22 - 1] = iArr8[i22 - 3];
                iArr8[i21] = iArr8[i22 - 4];
                int i23 = i22 - 1;
                this.GetContactSyncConfig = i23;
                iArr8[i23 - 1] = iArr8[i23 - 1] ^ iArr8[i23];
                int i24 = i23 + 1;
                this.GetContactSyncConfig = i24;
                int i25 = iArr8[i24 - 2];
                iArr8[i23] = i25;
                iArr8[i24 - 2] = iArr8[i24 - 3];
                iArr8[i24 - 3] = iArr8[i24 - 4];
                iArr8[i24 - 4] = i25;
                return 0;
            case 19:
                int[] iArr9 = this.initRecordTimeStamp;
                int i26 = this.GetContactSyncConfig;
                int i27 = i26 + 2;
                this.GetContactSyncConfig = i27;
                iArr9[i27 - 1] = iArr9[i27 - 3];
                iArr9[i26] = iArr9[i27 - 4];
                this.GetContactSyncConfig = i27 + 1;
                iArr9[i27] = -1;
                return 0;
            case 20:
                int i28 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i28;
                int[] iArr10 = this.initRecordTimeStamp;
                iArr10[i28 - 1] = iArr10[i28] ^ iArr10[i28 - 1];
                return 0;
            case 21:
                int i29 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i29;
                int[] iArr11 = this.initRecordTimeStamp;
                iArr11[i29 - 1] = iArr11[i29 - 1] ^ iArr11[i29];
                int i30 = i29 - 1;
                this.GetContactSyncConfig = i30;
                this.PrepareContext[i30] = null;
                int i31 = i30 - 1;
                this.GetContactSyncConfig = i31;
                iArr11[i31 - 1] = iArr11[i31] & iArr11[i31 - 1];
                return 0;
            case 22:
                int[] iArr12 = this.initRecordTimeStamp;
                int i32 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i32 + 1;
                iArr12[i32] = 1;
                return 0;
            case 23:
                int i33 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i33;
                int[] iArr13 = this.initRecordTimeStamp;
                iArr13[i33 - 1] = iArr13[i33 - 1] << iArr13[i33];
                iArr13[i33 - 1] = -iArr13[i33 - 1];
                int i34 = i33 + 2;
                this.GetContactSyncConfig = i34;
                iArr13[i34 - 1] = iArr13[i34 - 3];
                iArr13[i33] = iArr13[i34 - 4];
                return 0;
            case 24:
                int[] iArr14 = this.initRecordTimeStamp;
                int i35 = this.GetContactSyncConfig;
                iArr14[i35 - 1] = -iArr14[i35 - 1];
                return 0;
            case 25:
                int i36 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i36;
                int[] iArr15 = this.initRecordTimeStamp;
                iArr15[i36 - 1] = iArr15[i36 - 1] ^ iArr15[i36];
                int i37 = i36 + 1;
                this.GetContactSyncConfig = i37;
                int i38 = iArr15[i37 - 2];
                iArr15[i36] = i38;
                iArr15[i37 - 2] = iArr15[i37 - 3];
                iArr15[i37 - 3] = iArr15[i37 - 4];
                iArr15[i37 - 4] = i38;
                int i39 = i37 - 1;
                this.GetContactSyncConfig = i39;
                this.PrepareContext[i39] = null;
                return 0;
            case 26:
                int i40 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i40;
                int[] iArr16 = this.initRecordTimeStamp;
                iArr16[i40 - 1] = iArr16[i40] & iArr16[i40 - 1];
                return 0;
            case 27:
                int[] iArr17 = this.initRecordTimeStamp;
                int i41 = this.GetContactSyncConfig;
                int i42 = i41 + 1;
                this.GetContactSyncConfig = i42;
                iArr17[i41] = 1;
                int i43 = i42 - 1;
                this.GetContactSyncConfig = i43;
                iArr17[i43 - 1] = iArr17[i43 - 1] << iArr17[i43];
                int i44 = i43 - 1;
                this.GetContactSyncConfig = i44;
                iArr17[i44 - 1] = iArr17[i44 - 1] + iArr17[i44];
                return 0;
            case 28:
                int[] iArr18 = this.initRecordTimeStamp;
                int i45 = this.GetContactSyncConfig;
                int i46 = i45 + 1;
                this.GetContactSyncConfig = i46;
                iArr18[i45] = iArr18[i46 - 2];
                return 0;
            case 29:
                int[] iArr19 = this.initRecordTimeStamp;
                int i47 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                this.NetworkUserEntityData$$ExternalSyntheticLambda2 = i47 + 1;
                this.BuiltInFictitiousFunctionClassFactory = iArr19[i47];
                return 0;
            case 30:
                int[] iArr20 = this.initRecordTimeStamp;
                int i48 = this.GetContactSyncConfig;
                int i49 = i48 + 1;
                this.GetContactSyncConfig = i49;
                iArr20[i48] = 128;
                int i50 = i49 - 1;
                this.GetContactSyncConfig = i50;
                iArr20[i50 - 1] = iArr20[i50 - 1] % iArr20[i50];
                return 0;
            case 31:
                int i51 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i51;
                int[] iArr21 = this.initRecordTimeStamp;
                iArr21[i51 - 1] = iArr21[i51 - 1] % iArr21[i51];
                return 0;
            case 32:
                int i52 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i52;
                this.BuiltInFictitiousFunctionClassFactory = this.initRecordTimeStamp[i52] != 0 ? 1 : 0;
                return 0;
            case 33:
                int[] iArr22 = this.initRecordTimeStamp;
                int i53 = this.GetContactSyncConfig;
                int i54 = i53 + 1;
                this.GetContactSyncConfig = i54;
                iArr22[i53] = 73;
                int i55 = i54 + 2;
                this.GetContactSyncConfig = i55;
                iArr22[i55 - 1] = iArr22[i55 - 3];
                iArr22[i54] = iArr22[i55 - 4];
                int i56 = i55 + 2;
                this.GetContactSyncConfig = i56;
                iArr22[i56 - 1] = iArr22[i56 - 3];
                iArr22[i55] = iArr22[i56 - 4];
                return 0;
            case 34:
                int i57 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i57;
                int[] iArr23 = this.initRecordTimeStamp;
                iArr23[i57 - 1] = iArr23[i57 - 1] & iArr23[i57];
                int i58 = i57 - 1;
                this.GetContactSyncConfig = i58;
                iArr23[i58 - 1] = iArr23[i58] | iArr23[i58 - 1];
                return 0;
            case 35:
                int i59 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i59;
                int[] iArr24 = this.initRecordTimeStamp;
                iArr24[i59 - 1] = iArr24[i59 - 1] << iArr24[i59];
                return 0;
            case 36:
                int[] iArr25 = this.initRecordTimeStamp;
                int i60 = this.GetContactSyncConfig;
                int i61 = i60 + 1;
                this.GetContactSyncConfig = i61;
                int i62 = iArr25[i61 - 2];
                iArr25[i60] = i62;
                iArr25[i61 - 2] = iArr25[i61 - 3];
                iArr25[i61 - 3] = iArr25[i61 - 4];
                iArr25[i61 - 4] = i62;
                int i63 = i61 - 1;
                this.GetContactSyncConfig = i63;
                this.PrepareContext[i63] = null;
                return 0;
            case 37:
                int[] iArr26 = this.initRecordTimeStamp;
                int i64 = this.GetContactSyncConfig;
                int i65 = i64 + 2;
                this.GetContactSyncConfig = i65;
                iArr26[i65 - 1] = iArr26[i65 - 3];
                iArr26[i64] = iArr26[i65 - 4];
                int i66 = i65 - 1;
                this.GetContactSyncConfig = i66;
                iArr26[i66 - 1] = iArr26[i66 - 1] & iArr26[i66];
                this.GetContactSyncConfig = i66 + 1;
                iArr26[i66] = -1;
                return 0;
            case 38:
                int[] iArr27 = this.initRecordTimeStamp;
                int i67 = this.GetContactSyncConfig;
                int i68 = i67 + 1;
                this.GetContactSyncConfig = i68;
                int i69 = iArr27[i68 - 2];
                iArr27[i67] = i69;
                iArr27[i68 - 2] = iArr27[i68 - 3];
                iArr27[i68 - 3] = iArr27[i68 - 4];
                iArr27[i68 - 4] = i69;
                return 0;
            case 39:
                int i70 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i70;
                this.PrepareContext[i70] = null;
                int i71 = i70 - 1;
                this.GetContactSyncConfig = i71;
                int[] iArr28 = this.initRecordTimeStamp;
                iArr28[i71 - 1] = iArr28[i71 - 1] | iArr28[i71];
                int i72 = i71 - 1;
                this.GetContactSyncConfig = i72;
                iArr28[i72 - 1] = iArr28[i72] & iArr28[i72 - 1];
                return 0;
            case 40:
                int i73 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i73;
                int[] iArr29 = this.initRecordTimeStamp;
                iArr29[i73 - 1] = iArr29[i73 - 1] - iArr29[i73];
                int i74 = i73 + 1;
                this.GetContactSyncConfig = i74;
                iArr29[i73] = iArr29[i74 - 2];
                this.GetContactSyncConfig = i74 + 1;
                iArr29[i74] = 128;
                return 0;
            case 41:
                int[] iArr30 = this.initRecordTimeStamp;
                int i75 = this.GetContactSyncConfig;
                int i76 = i75 + 1;
                this.GetContactSyncConfig = i76;
                iArr30[i75] = 2;
                int i77 = i76 - 1;
                this.GetContactSyncConfig = i77;
                iArr30[i77 - 1] = iArr30[i77 - 1] % iArr30[i77];
                return 0;
            case 42:
                for (int i78 = this.GetContactSyncConfig - 1; i78 >= 0; i78--) {
                    this.PrepareContext[i78] = null;
                }
                this.GetContactSyncConfig = 0;
                Object[] objArr8 = this.PrepareContext;
                this.GetContactSyncConfig = 0 + 1;
                objArr8[0] = this.lookAheadTest;
                return 0;
            case 43:
                int[] iArr31 = this.initRecordTimeStamp;
                int i79 = this.GetContactSyncConfig;
                int i80 = i79 + 1;
                this.GetContactSyncConfig = i80;
                iArr31[i79] = 2;
                this.GetContactSyncConfig = i80 + 1;
                iArr31[i80] = 2;
                return 0;
            case 44:
                int[] iArr32 = this.initRecordTimeStamp;
                int i81 = this.GetContactSyncConfig;
                int i82 = i81 + 1;
                this.GetContactSyncConfig = i82;
                iArr32[i81] = 67;
                iArr32[i82 - 1] = -iArr32[i82 - 1];
                int i83 = i82 + 1;
                this.GetContactSyncConfig = i83;
                iArr32[i82] = iArr32[i83 - 2];
                return 0;
            case 45:
                int[] iArr33 = this.initRecordTimeStamp;
                int i84 = this.GetContactSyncConfig;
                iArr33[i84 - 1] = -iArr33[i84 - 1];
                this.GetContactSyncConfig = i84 + 1;
                iArr33[i84] = -1;
                return 0;
            case 46:
                int[] iArr34 = this.initRecordTimeStamp;
                int i85 = this.GetContactSyncConfig;
                int i86 = iArr34[i85 - 1];
                iArr34[i85 - 1] = iArr34[i85 - 2];
                iArr34[i85 - 2] = i86;
                return 0;
            case 47:
                int[] iArr35 = this.initRecordTimeStamp;
                int i87 = this.GetContactSyncConfig;
                iArr35[i87 - 1] = -iArr35[i87 - 1];
                int i88 = i87 + 2;
                this.GetContactSyncConfig = i88;
                iArr35[i88 - 1] = iArr35[i88 - 3];
                iArr35[i87] = iArr35[i88 - 4];
                int i89 = i88 - 1;
                this.GetContactSyncConfig = i89;
                iArr35[i89 - 1] = iArr35[i89] ^ iArr35[i89 - 1];
                return 0;
            case 48:
                int i90 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i90;
                this.PrepareContext[i90] = null;
                int i91 = i90 - 1;
                this.GetContactSyncConfig = i91;
                int[] iArr36 = this.initRecordTimeStamp;
                iArr36[i91 - 1] = iArr36[i91] & iArr36[i91 - 1];
                return 0;
            case 49:
                int i92 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i92;
                int[] iArr37 = this.initRecordTimeStamp;
                iArr37[i92 - 1] = iArr37[i92 - 1] + iArr37[i92];
                return 0;
            case 50:
                int i93 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i93;
                int[] iArr38 = this.initRecordTimeStamp;
                iArr38[i93 - 1] = iArr38[i93 - 1] - iArr38[i93];
                return 0;
            case 51:
                int i94 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i94;
                this.BuiltInFictitiousFunctionClassFactory = this.initRecordTimeStamp[i94] == 0 ? 1 : 0;
                return 0;
            case 52:
                int[] iArr39 = this.initRecordTimeStamp;
                int i95 = this.GetContactSyncConfig;
                int i96 = i95 + 1;
                this.GetContactSyncConfig = i96;
                iArr39[i95] = 31;
                int i97 = i96 + 2;
                this.GetContactSyncConfig = i97;
                iArr39[i97 - 1] = iArr39[i97 - 3];
                iArr39[i96] = iArr39[i97 - 4];
                return 0;
            case 53:
                int i98 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i98;
                int[] iArr40 = this.initRecordTimeStamp;
                iArr40[i98 - 1] = iArr40[i98 - 1] ^ iArr40[i98];
                int i99 = i98 + 1;
                this.GetContactSyncConfig = i99;
                int i100 = iArr40[i99 - 2];
                iArr40[i98] = i100;
                iArr40[i99 - 2] = iArr40[i99 - 3];
                iArr40[i99 - 3] = iArr40[i99 - 4];
                iArr40[i99 - 4] = i100;
                return 0;
            case 54:
                int i101 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i101;
                int[] iArr41 = this.initRecordTimeStamp;
                iArr41[i101 - 1] = iArr41[i101 - 1] & iArr41[i101];
                this.GetContactSyncConfig = i101 + 1;
                iArr41[i101] = 1;
                return 0;
            case 55:
                int i102 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i102;
                int[] iArr42 = this.initRecordTimeStamp;
                iArr42[i102 - 1] = iArr42[i102 - 1] + iArr42[i102];
                int i103 = i102 + 1;
                this.GetContactSyncConfig = i103;
                iArr42[i102] = iArr42[i103 - 2];
                return 0;
            case 56:
                int[] iArr43 = this.initRecordTimeStamp;
                int i104 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i104 + 1;
                iArr43[i104] = 128;
                return 0;
            case 57:
                int[] iArr44 = this.initRecordTimeStamp;
                int i105 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i105 + 1;
                iArr44[i105] = 97;
                return 0;
            case 58:
                int[] iArr45 = this.initRecordTimeStamp;
                int i106 = this.GetContactSyncConfig;
                int i107 = i106 + 1;
                this.GetContactSyncConfig = i107;
                iArr45[i106] = iArr45[i107 - 2];
                this.GetContactSyncConfig = i107 + 1;
                iArr45[i107] = -1;
                return 0;
            case 59:
                int[] iArr46 = this.initRecordTimeStamp;
                int i108 = this.GetContactSyncConfig;
                int i109 = iArr46[i108 - 1];
                iArr46[i108 - 1] = iArr46[i108 - 2];
                iArr46[i108 - 2] = i109;
                int i110 = i108 - 1;
                this.GetContactSyncConfig = i110;
                this.PrepareContext[i110] = null;
                return 0;
            case 60:
                int[] iArr47 = this.initRecordTimeStamp;
                int i111 = this.GetContactSyncConfig;
                int i112 = i111 + 2;
                this.GetContactSyncConfig = i112;
                iArr47[i112 - 1] = iArr47[i112 - 3];
                iArr47[i111] = iArr47[i112 - 4];
                return 0;
            case 61:
                int[] iArr48 = this.initRecordTimeStamp;
                int i113 = this.GetContactSyncConfig;
                iArr48[i113 - 1] = -iArr48[i113 - 1];
                int i114 = i113 - 1;
                this.GetContactSyncConfig = i114;
                iArr48[i114 - 1] = iArr48[i114 - 1] ^ iArr48[i114];
                int i115 = i114 + 1;
                this.GetContactSyncConfig = i115;
                int i116 = iArr48[i115 - 2];
                iArr48[i114] = i116;
                iArr48[i115 - 2] = iArr48[i115 - 3];
                iArr48[i115 - 3] = iArr48[i115 - 4];
                iArr48[i115 - 4] = i116;
                return 0;
            case 62:
                int[] iArr49 = this.initRecordTimeStamp;
                int i117 = this.GetContactSyncConfig;
                iArr49[i117 - 1] = -iArr49[i117 - 1];
                int i118 = i117 - 1;
                this.GetContactSyncConfig = i118;
                iArr49[i118 - 1] = iArr49[i118] & iArr49[i118 - 1];
                return 0;
            case 63:
                int[] iArr50 = this.initRecordTimeStamp;
                int i119 = this.GetContactSyncConfig;
                int i120 = i119 + 1;
                this.GetContactSyncConfig = i120;
                iArr50[i119] = -1;
                int i121 = i120 - 1;
                this.GetContactSyncConfig = i121;
                iArr50[i121 - 1] = iArr50[i121] ^ iArr50[i121 - 1];
                return 0;
            case 64:
                int[] iArr51 = this.initRecordTimeStamp;
                int i122 = this.GetContactSyncConfig;
                int i123 = i122 + 1;
                this.GetContactSyncConfig = i123;
                iArr51[i122] = 1;
                int i124 = i123 - 1;
                this.GetContactSyncConfig = i124;
                iArr51[i124 - 1] = iArr51[i124 - 1] - iArr51[i124];
                return 0;
            case 65:
                int[] iArr52 = this.initRecordTimeStamp;
                int i125 = this.GetContactSyncConfig;
                int i126 = i125 + 1;
                this.GetContactSyncConfig = i126;
                iArr52[i125] = 2;
                int i127 = i126 + 1;
                this.GetContactSyncConfig = i127;
                iArr52[i126] = 2;
                int i128 = i127 - 1;
                this.GetContactSyncConfig = i128;
                iArr52[i128 - 1] = iArr52[i128 - 1] % iArr52[i128];
                return 0;
            case 66:
                int[] iArr53 = this.initRecordTimeStamp;
                int i129 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i129 + 1;
                iArr53[i129] = 35;
                return 0;
            case 67:
                int[] iArr54 = this.initRecordTimeStamp;
                int i130 = this.GetContactSyncConfig;
                iArr54[i130 - 1] = -iArr54[i130 - 1];
                int i131 = i130 + 2;
                this.GetContactSyncConfig = i131;
                iArr54[i131 - 1] = iArr54[i131 - 3];
                iArr54[i130] = iArr54[i131 - 4];
                return 0;
            case 68:
                int[] iArr55 = this.initRecordTimeStamp;
                int i132 = this.GetContactSyncConfig;
                iArr55[i132 - 1] = -iArr55[i132 - 1];
                int i133 = i132 + 2;
                this.GetContactSyncConfig = i133;
                iArr55[i133 - 1] = iArr55[i133 - 3];
                iArr55[i132] = iArr55[i133 - 4];
                int i134 = i133 - 1;
                this.GetContactSyncConfig = i134;
                iArr55[i134 - 1] = iArr55[i134] & iArr55[i134 - 1];
                return 0;
            case 69:
                int i135 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i135;
                int[] iArr56 = this.initRecordTimeStamp;
                iArr56[i135 - 1] = iArr56[i135] | iArr56[i135 - 1];
                return 0;
            case 70:
                int[] iArr57 = this.initRecordTimeStamp;
                int i136 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i136 + 1;
                iArr57[i136] = -1;
                return 0;
            case 71:
                int i137 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i137;
                int[] iArr58 = this.initRecordTimeStamp;
                iArr58[i137 - 1] = iArr58[i137 - 1] ^ iArr58[i137];
                int i138 = i137 - 1;
                this.GetContactSyncConfig = i138;
                this.PrepareContext[i138] = null;
                return 0;
            case 72:
                int i139 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i139;
                int[] iArr59 = this.initRecordTimeStamp;
                iArr59[i139 - 1] = iArr59[i139 - 1] & iArr59[i139];
                int i140 = i139 + 1;
                this.GetContactSyncConfig = i140;
                iArr59[i139] = 1;
                int i141 = i140 - 1;
                this.GetContactSyncConfig = i141;
                iArr59[i141 - 1] = iArr59[i141 - 1] << iArr59[i141];
                return 0;
            case 73:
                int i142 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i142;
                this.PrepareContext[i142] = null;
                int i143 = i142 - 1;
                this.GetContactSyncConfig = i143;
                int[] iArr60 = this.initRecordTimeStamp;
                iArr60[i143 - 1] = iArr60[i143 - 1] & iArr60[i143];
                this.GetContactSyncConfig = i143 + 1;
                iArr60[i143] = 1;
                return 0;
            case 74:
                int i144 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i144;
                int[] iArr61 = this.initRecordTimeStamp;
                iArr61[i144 - 1] = iArr61[i144 - 1] << iArr61[i144];
                int i145 = i144 - 1;
                this.GetContactSyncConfig = i145;
                iArr61[i145 - 1] = iArr61[i145 - 1] + iArr61[i145];
                int i146 = i145 + 1;
                this.GetContactSyncConfig = i146;
                iArr61[i145] = iArr61[i146 - 2];
                return 0;
            case 75:
                int[] iArr62 = this.initRecordTimeStamp;
                int i147 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i147 + 1;
                iArr62[i147] = 57;
                return 0;
            case 76:
                int[] iArr63 = this.initRecordTimeStamp;
                int i148 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i148 + 1;
                iArr63[i148] = 61;
                return 0;
            case 77:
                int[] iArr64 = this.initRecordTimeStamp;
                int i149 = this.GetContactSyncConfig;
                iArr64[i149 - 1] = -iArr64[i149 - 1];
                int i150 = i149 - 1;
                this.GetContactSyncConfig = i150;
                iArr64[i150 - 1] = iArr64[i150] ^ iArr64[i150 - 1];
                return 0;
            case 78:
                int[] iArr65 = this.initRecordTimeStamp;
                int i151 = this.GetContactSyncConfig;
                int i152 = i151 + 1;
                this.GetContactSyncConfig = i152;
                iArr65[i151] = -1;
                int i153 = i152 - 1;
                this.GetContactSyncConfig = i153;
                iArr65[i153 - 1] = iArr65[i153 - 1] ^ iArr65[i153];
                int i154 = i153 - 1;
                this.GetContactSyncConfig = i154;
                iArr65[i154 - 1] = iArr65[i154] ^ iArr65[i154 - 1];
                return 0;
            case 79:
                int[] iArr66 = this.initRecordTimeStamp;
                int i155 = this.GetContactSyncConfig;
                int i156 = i155 + 1;
                this.GetContactSyncConfig = i156;
                iArr66[i155] = 1;
                int i157 = i156 - 1;
                this.GetContactSyncConfig = i157;
                iArr66[i157 - 1] = iArr66[i157 - 1] << iArr66[i157];
                int i158 = i157 + 2;
                this.GetContactSyncConfig = i158;
                iArr66[i158 - 1] = iArr66[i158 - 3];
                iArr66[i157] = iArr66[i158 - 4];
                return 0;
            case 80:
                int[] iArr67 = this.initRecordTimeStamp;
                int i159 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i159 + 1;
                iArr67[i159] = 59;
                return 0;
            case 81:
                int[] iArr68 = this.initRecordTimeStamp;
                int i160 = this.GetContactSyncConfig;
                int i161 = i160 + 1;
                this.GetContactSyncConfig = i161;
                iArr68[i160] = 33;
                int i162 = i161 + 2;
                this.GetContactSyncConfig = i162;
                iArr68[i162 - 1] = iArr68[i162 - 3];
                iArr68[i161] = iArr68[i162 - 4];
                int i163 = i162 - 1;
                this.GetContactSyncConfig = i163;
                iArr68[i163 - 1] = iArr68[i163] & iArr68[i163 - 1];
                return 0;
            case 82:
                int i164 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i164;
                this.PrepareContext[i164] = null;
                int i165 = i164 - 1;
                this.GetContactSyncConfig = i165;
                int[] iArr69 = this.initRecordTimeStamp;
                iArr69[i165 - 1] = iArr69[i165 - 1] | iArr69[i165];
                int i166 = i165 - 1;
                this.GetContactSyncConfig = i166;
                iArr69[i166 - 1] = iArr69[i166 - 1] + iArr69[i166];
                return 0;
            case 83:
                int[] iArr70 = this.initRecordTimeStamp;
                int i167 = this.GetContactSyncConfig;
                int i168 = i167 + 1;
                this.GetContactSyncConfig = i168;
                iArr70[i167] = iArr70[i168 - 2];
                int i169 = i168 + 1;
                this.GetContactSyncConfig = i169;
                iArr70[i168] = 128;
                int i170 = i169 - 1;
                this.GetContactSyncConfig = i170;
                iArr70[i170 - 1] = iArr70[i170 - 1] % iArr70[i170];
                return 0;
            case 84:
                Object[] objArr9 = this.PrepareContext;
                int i171 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i171 + 1;
                objArr9[i171] = null;
                return 0;
            case 85:
                int[] iArr71 = this.initRecordTimeStamp;
                int i172 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i172 + 1;
                iArr71[i172] = 73;
                return 0;
            case 86:
                int[] iArr72 = this.initRecordTimeStamp;
                int i173 = this.GetContactSyncConfig;
                iArr72[i173 - 1] = -iArr72[i173 - 1];
                int i174 = i173 + 1;
                this.GetContactSyncConfig = i174;
                iArr72[i173] = iArr72[i174 - 2];
                iArr72[i174 - 1] = -iArr72[i174 - 1];
                return 0;
            case 87:
                int i175 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i175;
                int[] iArr73 = this.initRecordTimeStamp;
                iArr73[i175 - 1] = iArr73[i175 - 1] ^ iArr73[i175];
                int i176 = iArr73[i175 - 1];
                iArr73[i175 - 1] = iArr73[i175 - 2];
                iArr73[i175 - 2] = i176;
                int i177 = i175 - 1;
                this.GetContactSyncConfig = i177;
                this.PrepareContext[i177] = null;
                return 0;
            case 88:
                int i178 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i178;
                this.PrepareContext[i178] = null;
                int i179 = i178 - 1;
                this.GetContactSyncConfig = i179;
                int[] iArr74 = this.initRecordTimeStamp;
                iArr74[i179 - 1] = iArr74[i179] | iArr74[i179 - 1];
                return 0;
            case 89:
                int i180 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i180;
                int[] iArr75 = this.initRecordTimeStamp;
                iArr75[i180 - 1] = iArr75[i180 - 1] + iArr75[i180];
                this.GetContactSyncConfig = i180 + 1;
                iArr75[i180] = 1;
                return 0;
            case 90:
                int i181 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i181;
                int[] iArr76 = this.initRecordTimeStamp;
                iArr76[i181 - 1] = iArr76[i181 - 1] - iArr76[i181];
                int i182 = i181 + 1;
                this.GetContactSyncConfig = i182;
                iArr76[i181] = iArr76[i182 - 2];
                return 0;
            case 91:
                int[] iArr77 = this.initRecordTimeStamp;
                int i183 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i183 + 1;
                iArr77[i183] = 2;
                return 0;
            case 92:
                int[] iArr78 = this.initRecordTimeStamp;
                int i184 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i184 + 1;
                iArr78[i184] = 89;
                return 0;
            case 93:
                int[] iArr79 = this.initRecordTimeStamp;
                int i185 = this.GetContactSyncConfig;
                int i186 = i185 + 1;
                this.GetContactSyncConfig = i186;
                iArr79[i185] = 119;
                iArr79[i186 - 1] = -iArr79[i186 - 1];
                int i187 = i186 + 2;
                this.GetContactSyncConfig = i187;
                iArr79[i187 - 1] = iArr79[i187 - 3];
                iArr79[i186] = iArr79[i187 - 4];
                return 0;
            case 94:
                int[] iArr80 = this.initRecordTimeStamp;
                int i188 = this.GetContactSyncConfig;
                int i189 = i188 + 1;
                this.GetContactSyncConfig = i189;
                iArr80[i188] = 31;
                iArr80[i189 - 1] = -iArr80[i189 - 1];
                int i190 = i189 + 2;
                this.GetContactSyncConfig = i190;
                iArr80[i190 - 1] = iArr80[i190 - 3];
                iArr80[i189] = iArr80[i190 - 4];
                return 0;
            case 95:
                int[] iArr81 = this.initRecordTimeStamp;
                int i191 = this.GetContactSyncConfig;
                int i192 = i191 + 2;
                this.GetContactSyncConfig = i192;
                iArr81[i192 - 1] = iArr81[i192 - 3];
                iArr81[i191] = iArr81[i192 - 4];
                int i193 = i192 - 1;
                this.GetContactSyncConfig = i193;
                iArr81[i193 - 1] = iArr81[i193] & iArr81[i193 - 1];
                return 0;
            case 96:
                int i194 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i194;
                int[] iArr82 = this.initRecordTimeStamp;
                iArr82[i194 - 1] = iArr82[i194 - 1] | iArr82[i194];
                int i195 = i194 - 1;
                this.GetContactSyncConfig = i195;
                iArr82[i195 - 1] = iArr82[i195] & iArr82[i195 - 1];
                return 0;
            case 97:
                int i196 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i196;
                this.PrepareContext[i196] = null;
                int[] iArr83 = this.initRecordTimeStamp;
                iArr83[i196 - 1] = -iArr83[i196 - 1];
                return 0;
            case 98:
                int i197 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i197;
                int[] iArr84 = this.initRecordTimeStamp;
                iArr84[i197 - 1] = iArr84[i197 - 1] ^ iArr84[i197];
                int i198 = i197 - 1;
                this.GetContactSyncConfig = i198;
                iArr84[i198 - 1] = iArr84[i198 - 1] ^ iArr84[i198];
                int i199 = i198 - 1;
                this.GetContactSyncConfig = i199;
                this.PrepareContext[i199] = null;
                return 0;
            case 99:
                int i200 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i200;
                int[] iArr85 = this.initRecordTimeStamp;
                iArr85[i200 - 1] = iArr85[i200 - 1] + iArr85[i200];
                int i201 = i200 + 1;
                this.GetContactSyncConfig = i201;
                iArr85[i200] = iArr85[i201 - 2];
                this.GetContactSyncConfig = i201 + 1;
                iArr85[i201] = 128;
                return 0;
            case 100:
                int[] iArr86 = this.initRecordTimeStamp;
                int i202 = this.GetContactSyncConfig;
                int i203 = i202 + 1;
                this.GetContactSyncConfig = i203;
                iArr86[i202] = 77;
                iArr86[i203 - 1] = -iArr86[i203 - 1];
                return 0;
            case 101:
                int[] iArr87 = this.initRecordTimeStamp;
                int i204 = this.GetContactSyncConfig;
                int i205 = i204 + 2;
                this.GetContactSyncConfig = i205;
                iArr87[i205 - 1] = iArr87[i205 - 3];
                iArr87[i204] = iArr87[i205 - 4];
                iArr87[i205 - 1] = -iArr87[i205 - 1];
                return 0;
            case 102:
                int i206 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i206;
                int[] iArr88 = this.initRecordTimeStamp;
                iArr88[i206 - 1] = iArr88[i206 - 1] ^ iArr88[i206];
                int i207 = i206 - 1;
                this.GetContactSyncConfig = i207;
                iArr88[i207 - 1] = iArr88[i207] & iArr88[i207 - 1];
                return 0;
            case 103:
                int[] iArr89 = this.initRecordTimeStamp;
                int i208 = this.GetContactSyncConfig;
                int i209 = iArr89[i208 - 1];
                iArr89[i208 - 1] = iArr89[i208 - 2];
                iArr89[i208 - 2] = i209;
                int i210 = i208 + 1;
                this.GetContactSyncConfig = i210;
                iArr89[i208] = -1;
                int i211 = i210 - 1;
                this.GetContactSyncConfig = i211;
                iArr89[i211 - 1] = iArr89[i211] ^ iArr89[i211 - 1];
                return 0;
            case 104:
                int[] iArr90 = this.initRecordTimeStamp;
                int i212 = this.GetContactSyncConfig;
                int i213 = i212 + 2;
                this.GetContactSyncConfig = i213;
                iArr90[i213 - 1] = iArr90[i213 - 3];
                iArr90[i212] = iArr90[i213 - 4];
                int i214 = i213 + 1;
                this.GetContactSyncConfig = i214;
                iArr90[i213] = -1;
                int i215 = i214 - 1;
                this.GetContactSyncConfig = i215;
                iArr90[i215 - 1] = iArr90[i215] ^ iArr90[i215 - 1];
                return 0;
            case 105:
                int i216 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i216;
                int[] iArr91 = this.initRecordTimeStamp;
                iArr91[i216 - 1] = iArr91[i216 - 1] << iArr91[i216];
                int i217 = i216 - 1;
                this.GetContactSyncConfig = i217;
                iArr91[i217 - 1] = iArr91[i217 - 1] + iArr91[i217];
                return 0;
            case 106:
                int[] iArr92 = this.initRecordTimeStamp;
                int i218 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i218 + 1;
                iArr92[i218] = 64;
                return 0;
            case 107:
                int[] iArr93 = this.initRecordTimeStamp;
                int i219 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i219 + 1;
                iArr93[i219] = 0;
                return 0;
            case 108:
                int i220 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i220;
                int[] iArr94 = this.initRecordTimeStamp;
                iArr94[i220 - 1] = iArr94[i220 - 1] / iArr94[i220];
                int i221 = i220 - 1;
                this.GetContactSyncConfig = i221;
                this.PrepareContext[i221] = null;
                return 0;
            case 109:
                Object[] objArr10 = this.PrepareContext;
                int i222 = this.GetContactSyncConfig;
                int i223 = i222 + 1;
                this.GetContactSyncConfig = i223;
                objArr10[i222] = null;
                Object obj4 = objArr10[i223 - 1];
                objArr10[i223 - 1] = null;
                this.initRecordTimeStamp[i223 - 1] = ((int[]) obj4).length;
                int i224 = i223 - 1;
                this.GetContactSyncConfig = i224;
                objArr10[i224] = null;
                return 0;
            case 110:
                int[] iArr95 = this.initRecordTimeStamp;
                int i225 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i225 + 1;
                iArr95[i225] = 21;
                return 0;
            case 111:
                int[] iArr96 = this.initRecordTimeStamp;
                int i226 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i226 + 1;
                iArr96[i226] = 103;
                return 0;
            case 112:
                int i227 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i227;
                int[] iArr97 = this.initRecordTimeStamp;
                iArr97[i227 - 1] = iArr97[i227 - 1] ^ iArr97[i227];
                int i228 = i227 - 1;
                this.GetContactSyncConfig = i228;
                iArr97[i228 - 1] = iArr97[i228 - 1] & iArr97[i228];
                int i229 = i228 + 1;
                this.GetContactSyncConfig = i229;
                int i230 = iArr97[i229 - 2];
                iArr97[i228] = i230;
                iArr97[i229 - 2] = iArr97[i229 - 3];
                iArr97[i229 - 3] = iArr97[i229 - 4];
                iArr97[i229 - 4] = i230;
                return 0;
            case 113:
                int i231 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i231;
                int[] iArr98 = this.initRecordTimeStamp;
                iArr98[i231 - 1] = iArr98[i231 - 1] & iArr98[i231];
                int i232 = i231 - 1;
                this.GetContactSyncConfig = i232;
                iArr98[i232 - 1] = iArr98[i232 - 1] | iArr98[i232];
                int i233 = i232 + 1;
                this.GetContactSyncConfig = i233;
                int i234 = iArr98[i233 - 2];
                iArr98[i232] = i234;
                iArr98[i233 - 2] = iArr98[i233 - 3];
                iArr98[i233 - 3] = iArr98[i233 - 4];
                iArr98[i233 - 4] = i234;
                return 0;
            case 114:
                int[] iArr99 = this.initRecordTimeStamp;
                int i235 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i235 + 1;
                iArr99[i235] = 58;
                return 0;
            case 115:
                int[] iArr100 = this.initRecordTimeStamp;
                int i236 = this.GetContactSyncConfig;
                int i237 = i236 + 1;
                this.GetContactSyncConfig = i237;
                iArr100[i236] = iArr100[i237 - 2];
                this.GetContactSyncConfig = i237 + 1;
                iArr100[i237] = 128;
                return 0;
            case 116:
                int[] iArr101 = this.initRecordTimeStamp;
                int i238 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i238 + 1;
                iArr101[i238] = 87;
                return 0;
            case 117:
                int[] iArr102 = this.initRecordTimeStamp;
                int i239 = this.GetContactSyncConfig;
                iArr102[i239 - 1] = -iArr102[i239 - 1];
                int i240 = i239 - 1;
                this.GetContactSyncConfig = i240;
                iArr102[i240 - 1] = iArr102[i240 - 1] | iArr102[i240];
                int i241 = i240 - 1;
                this.GetContactSyncConfig = i241;
                iArr102[i241 - 1] = iArr102[i241 - 1] + iArr102[i241];
                return 0;
            case 118:
                int[] iArr103 = this.initRecordTimeStamp;
                int i242 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i242 + 1;
                iArr103[i242] = 0;
                return 0;
            case 119:
                int[] iArr104 = this.initRecordTimeStamp;
                int i243 = this.GetContactSyncConfig;
                int i244 = i243 + 1;
                this.GetContactSyncConfig = i244;
                iArr104[i243] = 93;
                int i245 = i244 + 2;
                this.GetContactSyncConfig = i245;
                iArr104[i245 - 1] = iArr104[i245 - 3];
                iArr104[i244] = iArr104[i245 - 4];
                int i246 = i245 - 1;
                this.GetContactSyncConfig = i246;
                iArr104[i246 - 1] = iArr104[i246] ^ iArr104[i246 - 1];
                return 0;
            case 120:
                int[] iArr105 = this.initRecordTimeStamp;
                int i247 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i247 + 1;
                iArr105[i247] = 83;
                return 0;
            case 121:
                int i248 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i248;
                int[] iArr106 = this.initRecordTimeStamp;
                iArr106[i248 - 1] = iArr106[i248 - 1] / iArr106[i248];
                return 0;
            case 122:
                int[] iArr107 = this.initRecordTimeStamp;
                int i249 = this.GetContactSyncConfig;
                int i250 = i249 + 1;
                this.GetContactSyncConfig = i250;
                iArr107[i249] = 57;
                iArr107[i250 - 1] = -iArr107[i250 - 1];
                return 0;
            case 123:
                int[] iArr108 = this.initRecordTimeStamp;
                int i251 = this.GetContactSyncConfig;
                int i252 = i251 + 1;
                this.GetContactSyncConfig = i252;
                int i253 = iArr108[i252 - 2];
                iArr108[i251] = i253;
                iArr108[i252 - 2] = iArr108[i252 - 3];
                iArr108[i252 - 3] = iArr108[i252 - 4];
                iArr108[i252 - 4] = i253;
                int i254 = i252 - 1;
                this.GetContactSyncConfig = i254;
                this.PrepareContext[i254] = null;
                iArr108[i254 - 1] = -iArr108[i254 - 1];
                return 0;
            case 124:
                int[] iArr109 = this.initRecordTimeStamp;
                int i255 = this.GetContactSyncConfig;
                int i256 = i255 + 1;
                this.GetContactSyncConfig = i256;
                iArr109[i255] = 1;
                int i257 = i256 - 1;
                this.GetContactSyncConfig = i257;
                iArr109[i257 - 1] = iArr109[i257 - 1] << iArr109[i257];
                return 0;
            case 125:
                int[] iArr110 = this.initRecordTimeStamp;
                int i258 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i258 + 1;
                iArr110[i258] = 98;
                return 0;
            case 126:
                int[] iArr111 = this.initRecordTimeStamp;
                int i259 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i259 + 1;
                iArr111[i259] = 24;
                return 0;
            case 127:
                int[] iArr112 = this.initRecordTimeStamp;
                int i260 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i260 + 1;
                iArr112[i260] = 19;
                return 0;
            case 128:
                int[] iArr113 = this.initRecordTimeStamp;
                int i261 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i261 + 1;
                iArr113[i261] = 121;
                return 0;
            case 129:
                int[] iArr114 = this.initRecordTimeStamp;
                int i262 = this.GetContactSyncConfig;
                int i263 = i262 + 2;
                this.GetContactSyncConfig = i263;
                iArr114[i263 - 1] = iArr114[i263 - 3];
                iArr114[i262] = iArr114[i263 - 4];
                iArr114[i263 - 1] = -iArr114[i263 - 1];
                int i264 = i263 + 2;
                this.GetContactSyncConfig = i264;
                iArr114[i264 - 1] = iArr114[i264 - 3];
                iArr114[i263] = iArr114[i264 - 4];
                return 0;
            case 130:
                int[] iArr115 = this.initRecordTimeStamp;
                int i265 = this.GetContactSyncConfig;
                int i266 = i265 + 1;
                this.GetContactSyncConfig = i266;
                int i267 = iArr115[i266 - 2];
                iArr115[i265] = i267;
                iArr115[i266 - 2] = iArr115[i266 - 3];
                iArr115[i266 - 3] = iArr115[i266 - 4];
                iArr115[i266 - 4] = i267;
                int i268 = i266 - 1;
                this.GetContactSyncConfig = i268;
                this.PrepareContext[i268] = null;
                int i269 = iArr115[i268 - 1];
                iArr115[i268 - 1] = iArr115[i268 - 2];
                iArr115[i268 - 2] = i269;
                return 0;
            case 131:
                int[] iArr116 = this.initRecordTimeStamp;
                int i270 = this.GetContactSyncConfig;
                int i271 = i270 + 1;
                this.GetContactSyncConfig = i271;
                iArr116[i270] = -1;
                int i272 = i271 - 1;
                this.GetContactSyncConfig = i272;
                iArr116[i272 - 1] = iArr116[i272 - 1] ^ iArr116[i272];
                int i273 = i272 - 1;
                this.GetContactSyncConfig = i273;
                iArr116[i273 - 1] = iArr116[i273] & iArr116[i273 - 1];
                return 0;
            case 132:
                int[] iArr117 = this.initRecordTimeStamp;
                int i274 = this.GetContactSyncConfig;
                int i275 = i274 + 1;
                this.GetContactSyncConfig = i275;
                iArr117[i274] = 1;
                int i276 = i275 - 1;
                this.GetContactSyncConfig = i276;
                iArr117[i276 - 1] = iArr117[i276 - 1] << iArr117[i276];
                iArr117[i276 - 1] = -iArr117[i276 - 1];
                return 0;
            case 133:
                int i277 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i277;
                int[] iArr118 = this.initRecordTimeStamp;
                iArr118[i277 - 1] = iArr118[i277 - 1] ^ iArr118[i277];
                int i278 = i277 - 1;
                this.GetContactSyncConfig = i278;
                iArr118[i278 - 1] = iArr118[i278 - 1] - iArr118[i278];
                int i279 = i278 + 1;
                this.GetContactSyncConfig = i279;
                iArr118[i278] = iArr118[i279 - 2];
                return 0;
            case 134:
                int[] iArr119 = this.initRecordTimeStamp;
                int i280 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i280 + 1;
                iArr119[i280] = 37;
                return 0;
            case 135:
                int[] iArr120 = this.initRecordTimeStamp;
                int i281 = this.GetContactSyncConfig;
                int i282 = i281 + 2;
                this.GetContactSyncConfig = i282;
                iArr120[i282 - 1] = iArr120[i282 - 3];
                iArr120[i281] = iArr120[i282 - 4];
                int i283 = i282 + 2;
                this.GetContactSyncConfig = i283;
                iArr120[i283 - 1] = iArr120[i283 - 3];
                iArr120[i282] = iArr120[i283 - 4];
                return 0;
            case 136:
                int[] iArr121 = this.initRecordTimeStamp;
                int i284 = this.GetContactSyncConfig;
                int i285 = i284 + 2;
                this.GetContactSyncConfig = i285;
                iArr121[i285 - 1] = iArr121[i285 - 3];
                iArr121[i284] = iArr121[i285 - 4];
                int i286 = i285 - 1;
                this.GetContactSyncConfig = i286;
                iArr121[i286 - 1] = iArr121[i286] ^ iArr121[i286 - 1];
                return 0;
            case 137:
                int i287 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i287;
                this.PrepareContext[i287] = null;
                int i288 = i287 - 1;
                this.GetContactSyncConfig = i288;
                int[] iArr122 = this.initRecordTimeStamp;
                iArr122[i288 - 1] = iArr122[i288 - 1] & iArr122[i288];
                int i289 = i288 - 1;
                this.GetContactSyncConfig = i289;
                iArr122[i289 - 1] = iArr122[i289] | iArr122[i289 - 1];
                return 0;
            case 138:
                int i290 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i290;
                int[] iArr123 = this.initRecordTimeStamp;
                iArr123[i290 - 1] = iArr123[i290 - 1] << iArr123[i290];
                int i291 = i290 + 1;
                this.GetContactSyncConfig = i291;
                int i292 = iArr123[i291 - 2];
                iArr123[i290] = i292;
                iArr123[i291 - 2] = iArr123[i291 - 3];
                iArr123[i291 - 3] = iArr123[i291 - 4];
                iArr123[i291 - 4] = i292;
                return 0;
            case 139:
                int i293 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i293;
                this.PrepareContext[i293] = null;
                int[] iArr124 = this.initRecordTimeStamp;
                iArr124[i293 - 1] = -iArr124[i293 - 1];
                int i294 = i293 - 1;
                this.GetContactSyncConfig = i294;
                iArr124[i294 - 1] = iArr124[i294] ^ iArr124[i294 - 1];
                return 0;
            case 140:
                int[] iArr125 = this.initRecordTimeStamp;
                int i295 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i295 + 1;
                iArr125[i295] = 36;
                return 0;
            case 141:
                int[] iArr126 = this.initRecordTimeStamp;
                int i296 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i296 + 1;
                iArr126[i296] = 82;
                return 0;
            case 142:
                int[] iArr127 = this.initRecordTimeStamp;
                int i297 = this.GetContactSyncConfig;
                int i298 = i297 + 1;
                this.GetContactSyncConfig = i298;
                iArr127[i297] = 0;
                int i299 = i298 - 1;
                this.GetContactSyncConfig = i299;
                iArr127[i299 - 1] = iArr127[i299 - 1] / iArr127[i299];
                int i300 = i299 - 1;
                this.GetContactSyncConfig = i300;
                this.PrepareContext[i300] = null;
                return 0;
            case 143:
                int[] iArr128 = this.initRecordTimeStamp;
                int i301 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i301 + 1;
                iArr128[i301] = 1;
                return 0;
            case 144:
                int i302 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i302;
                int[] iArr129 = this.initRecordTimeStamp;
                iArr129[i302 - 1] = iArr129[i302 - 1] & iArr129[i302];
                int i303 = i302 + 2;
                this.GetContactSyncConfig = i303;
                iArr129[i303 - 1] = iArr129[i303 - 3];
                iArr129[i302] = iArr129[i303 - 4];
                iArr129[i303 - 1] = -iArr129[i303 - 1];
                return 0;
            case 145:
                int[] iArr130 = this.initRecordTimeStamp;
                int i304 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i304 + 1;
                iArr130[i304] = 44;
                return 0;
            case 146:
                int[] iArr131 = this.initRecordTimeStamp;
                int i305 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i305 + 1;
                iArr131[i305] = 63;
                return 0;
            case 147:
                int i306 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i306;
                int[] iArr132 = this.initRecordTimeStamp;
                iArr132[i306 - 1] = iArr132[i306 - 1] | iArr132[i306];
                int i307 = i306 - 1;
                this.GetContactSyncConfig = i307;
                iArr132[i307 - 1] = iArr132[i307 - 1] & iArr132[i307];
                int i308 = i307 + 1;
                this.GetContactSyncConfig = i308;
                int i309 = iArr132[i308 - 2];
                iArr132[i307] = i309;
                iArr132[i308 - 2] = iArr132[i308 - 3];
                iArr132[i308 - 3] = iArr132[i308 - 4];
                iArr132[i308 - 4] = i309;
                return 0;
            case 148:
                int i310 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i310;
                this.PrepareContext[i310] = null;
                int[] iArr133 = this.initRecordTimeStamp;
                iArr133[i310 - 1] = -iArr133[i310 - 1];
                int i311 = i310 - 1;
                this.GetContactSyncConfig = i311;
                iArr133[i311 - 1] = iArr133[i311] & iArr133[i311 - 1];
                return 0;
            case 149:
                int[] iArr134 = this.initRecordTimeStamp;
                int i312 = this.GetContactSyncConfig;
                int i313 = i312 + 1;
                this.GetContactSyncConfig = i313;
                iArr134[i312] = 119;
                int i314 = i313 + 2;
                this.GetContactSyncConfig = i314;
                iArr134[i314 - 1] = iArr134[i314 - 3];
                iArr134[i313] = iArr134[i314 - 4];
                int i315 = i314 + 2;
                this.GetContactSyncConfig = i315;
                iArr134[i315 - 1] = iArr134[i315 - 3];
                iArr134[i314] = iArr134[i315 - 4];
                return 0;
            case 150:
                int i316 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i316;
                int[] iArr135 = this.initRecordTimeStamp;
                iArr135[i316 - 1] = iArr135[i316 - 1] & iArr135[i316];
                int i317 = i316 + 1;
                this.GetContactSyncConfig = i317;
                iArr135[i316] = -1;
                int i318 = i317 - 1;
                this.GetContactSyncConfig = i318;
                iArr135[i318 - 1] = iArr135[i318] ^ iArr135[i318 - 1];
                return 0;
            case 151:
                int i319 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i319;
                this.PrepareContext[i319] = null;
                int[] iArr136 = this.initRecordTimeStamp;
                int i320 = i319 + 2;
                this.GetContactSyncConfig = i320;
                iArr136[i320 - 1] = iArr136[i320 - 3];
                iArr136[i319] = iArr136[i320 - 4];
                this.GetContactSyncConfig = i320 + 1;
                iArr136[i320] = -1;
                return 0;
            case 152:
                int i321 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i321;
                int[] iArr137 = this.initRecordTimeStamp;
                iArr137[i321 - 1] = iArr137[i321 - 1] ^ iArr137[i321];
                int i322 = i321 - 1;
                this.GetContactSyncConfig = i322;
                iArr137[i322 - 1] = iArr137[i322] ^ iArr137[i322 - 1];
                return 0;
            case 153:
                int i323 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i323;
                int[] iArr138 = this.initRecordTimeStamp;
                iArr138[i323 - 1] = iArr138[i323 - 1] << iArr138[i323];
                int i324 = i323 + 2;
                this.GetContactSyncConfig = i324;
                iArr138[i324 - 1] = iArr138[i324 - 3];
                iArr138[i323] = iArr138[i324 - 4];
                return 0;
            case 154:
                int i325 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i325;
                this.PrepareContext[i325] = null;
                int i326 = i325 - 1;
                this.GetContactSyncConfig = i326;
                int[] iArr139 = this.initRecordTimeStamp;
                iArr139[i326 - 1] = iArr139[i326 - 1] ^ iArr139[i326];
                int i327 = i326 - 1;
                this.GetContactSyncConfig = i327;
                iArr139[i327 - 1] = iArr139[i327 - 1] - iArr139[i327];
                return 0;
            case TarHeader.USTAR_FILENAME_PREFIX /* 155 */:
                int[] iArr140 = this.initRecordTimeStamp;
                int i328 = this.GetContactSyncConfig;
                int i329 = i328 + 1;
                this.GetContactSyncConfig = i329;
                iArr140[i328] = 113;
                int i330 = i329 + 1;
                this.GetContactSyncConfig = i330;
                iArr140[i329] = iArr140[i330 - 2];
                return 0;
            case 156:
                int[] iArr141 = this.initRecordTimeStamp;
                int i331 = this.GetContactSyncConfig;
                int i332 = i331 + 1;
                this.GetContactSyncConfig = i332;
                iArr141[i331] = -1;
                int i333 = i332 - 1;
                this.GetContactSyncConfig = i333;
                iArr141[i333 - 1] = iArr141[i333 - 1] ^ iArr141[i333];
                int i334 = i333 + 1;
                this.GetContactSyncConfig = i334;
                int i335 = iArr141[i334 - 2];
                iArr141[i333] = i335;
                iArr141[i334 - 2] = iArr141[i334 - 3];
                iArr141[i334 - 3] = iArr141[i334 - 4];
                iArr141[i334 - 4] = i335;
                return 0;
            case 157:
                int[] iArr142 = this.initRecordTimeStamp;
                int i336 = this.GetContactSyncConfig;
                int i337 = i336 + 1;
                this.GetContactSyncConfig = i337;
                iArr142[i336] = 1;
                iArr142[i337 - 1] = -iArr142[i337 - 1];
                int i338 = i337 + 2;
                this.GetContactSyncConfig = i338;
                iArr142[i338 - 1] = iArr142[i338 - 3];
                iArr142[i337] = iArr142[i338 - 4];
                return 0;
            case 158:
                int[] iArr143 = this.initRecordTimeStamp;
                int i339 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i339 + 1;
                iArr143[i339] = 85;
                return 0;
            case 159:
                int[] iArr144 = this.initRecordTimeStamp;
                int i340 = this.GetContactSyncConfig;
                int i341 = i340 + 1;
                this.GetContactSyncConfig = i341;
                iArr144[i340] = 2;
                int i342 = i341 - 1;
                this.GetContactSyncConfig = i342;
                iArr144[i342 - 1] = iArr144[i342 - 1] % iArr144[i342];
                int i343 = i342 - 1;
                this.GetContactSyncConfig = i343;
                this.PrepareContext[i343] = null;
                return 0;
            case BlobStatic.MONITOR_IMAGE_WIDTH /* 160 */:
                int[] iArr145 = this.initRecordTimeStamp;
                int i344 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i344 + 1;
                iArr145[i344] = 60;
                return 0;
            case 161:
                int[] iArr146 = this.initRecordTimeStamp;
                int i345 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i345 + 1;
                iArr146[i345] = 5;
                return 0;
            case 162:
                int[] iArr147 = this.initRecordTimeStamp;
                int i346 = this.GetContactSyncConfig;
                iArr147[i346 - 1] = -iArr147[i346 - 1];
                int i347 = i346 + 2;
                this.GetContactSyncConfig = i347;
                iArr147[i347 - 1] = iArr147[i347 - 3];
                iArr147[i346] = iArr147[i347 - 4];
                iArr147[i347 - 1] = -iArr147[i347 - 1];
                return 0;
            case 163:
                int i348 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i348;
                int[] iArr148 = this.initRecordTimeStamp;
                iArr148[i348 - 1] = iArr148[i348 - 1] | iArr148[i348];
                int i349 = i348 + 1;
                this.GetContactSyncConfig = i349;
                int i350 = iArr148[i349 - 2];
                iArr148[i348] = i350;
                iArr148[i349 - 2] = iArr148[i349 - 3];
                iArr148[i349 - 3] = iArr148[i349 - 4];
                iArr148[i349 - 4] = i350;
                int i351 = i349 - 1;
                this.GetContactSyncConfig = i351;
                this.PrepareContext[i351] = null;
                return 0;
            case 164:
                int[] iArr149 = this.initRecordTimeStamp;
                int i352 = this.GetContactSyncConfig;
                int i353 = i352 + 1;
                this.GetContactSyncConfig = i353;
                iArr149[i352] = iArr149[i353 - 2];
                int i354 = i353 + 1;
                this.GetContactSyncConfig = i354;
                iArr149[i353] = -1;
                int i355 = i354 + 2;
                this.GetContactSyncConfig = i355;
                iArr149[i355 - 1] = iArr149[i355 - 3];
                iArr149[i354] = iArr149[i355 - 4];
                return 0;
            case 165:
                int i356 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i356;
                int[] iArr150 = this.initRecordTimeStamp;
                iArr150[i356 - 1] = iArr150[i356 - 1] & iArr150[i356];
                int i357 = i356 + 1;
                this.GetContactSyncConfig = i357;
                int i358 = iArr150[i357 - 2];
                iArr150[i356] = i358;
                iArr150[i357 - 2] = iArr150[i357 - 3];
                iArr150[i357 - 3] = iArr150[i357 - 4];
                iArr150[i357 - 4] = i358;
                return 0;
            case 166:
                int i359 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i359;
                this.PrepareContext[i359] = null;
                int[] iArr151 = this.initRecordTimeStamp;
                int i360 = i359 + 2;
                this.GetContactSyncConfig = i360;
                iArr151[i360 - 1] = iArr151[i360 - 3];
                iArr151[i359] = iArr151[i360 - 4];
                return 0;
            case 167:
                int[] iArr152 = this.initRecordTimeStamp;
                int i361 = this.GetContactSyncConfig;
                iArr152[i361 - 1] = -iArr152[i361 - 1];
                int i362 = i361 - 1;
                this.GetContactSyncConfig = i362;
                iArr152[i362 - 1] = iArr152[i362] | iArr152[i362 - 1];
                return 0;
            case 168:
                int[] iArr153 = this.initRecordTimeStamp;
                int i363 = this.GetContactSyncConfig;
                int i364 = i363 + 1;
                this.GetContactSyncConfig = i364;
                iArr153[i363] = 1;
                int i365 = i364 + 2;
                this.GetContactSyncConfig = i365;
                iArr153[i365 - 1] = iArr153[i365 - 3];
                iArr153[i364] = iArr153[i365 - 4];
                iArr153[i365 - 1] = -iArr153[i365 - 1];
                return 0;
            case 169:
                int[] iArr154 = this.initRecordTimeStamp;
                int i366 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i366 + 1;
                iArr154[i366] = 115;
                return 0;
            case 170:
                int i367 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i367;
                int[] iArr155 = this.initRecordTimeStamp;
                iArr155[i367 - 1] = iArr155[i367 - 1] & iArr155[i367];
                int i368 = i367 - 1;
                this.GetContactSyncConfig = i368;
                iArr155[i368 - 1] = iArr155[i368 - 1] | iArr155[i368];
                this.GetContactSyncConfig = i368 + 1;
                iArr155[i368] = 1;
                return 0;
            case 171:
                int[] iArr156 = this.initRecordTimeStamp;
                int i369 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i369 + 1;
                iArr156[i369] = 12;
                return 0;
            case 172:
                int[] iArr157 = this.initRecordTimeStamp;
                int i370 = this.GetContactSyncConfig;
                int i371 = i370 + 1;
                this.GetContactSyncConfig = i371;
                iArr157[i370] = 101;
                iArr157[i371 - 1] = -iArr157[i371 - 1];
                return 0;
            case 173:
                int[] iArr158 = this.initRecordTimeStamp;
                int i372 = this.GetContactSyncConfig;
                int i373 = i372 + 1;
                this.GetContactSyncConfig = i373;
                iArr158[i372] = -1;
                int i374 = i373 + 2;
                this.GetContactSyncConfig = i374;
                iArr158[i374 - 1] = iArr158[i374 - 3];
                iArr158[i373] = iArr158[i374 - 4];
                int i375 = i374 - 1;
                this.GetContactSyncConfig = i375;
                iArr158[i375 - 1] = iArr158[i375] & iArr158[i375 - 1];
                return 0;
            case 174:
                int[] iArr159 = this.initRecordTimeStamp;
                int i376 = this.GetContactSyncConfig;
                int i377 = i376 + 1;
                this.GetContactSyncConfig = i377;
                int i378 = iArr159[i377 - 2];
                iArr159[i376] = i378;
                iArr159[i377 - 2] = iArr159[i377 - 3];
                iArr159[i377 - 3] = iArr159[i377 - 4];
                iArr159[i377 - 4] = i378;
                int i379 = i377 - 1;
                this.GetContactSyncConfig = i379;
                this.PrepareContext[i379] = null;
                int i380 = i379 - 1;
                this.GetContactSyncConfig = i380;
                iArr159[i380 - 1] = iArr159[i380] | iArr159[i380 - 1];
                return 0;
            case 175:
                int[] iArr160 = this.initRecordTimeStamp;
                int i381 = this.GetContactSyncConfig;
                int i382 = iArr160[i381 - 1];
                iArr160[i381 - 1] = iArr160[i381 - 2];
                iArr160[i381 - 2] = i382;
                int i383 = i381 - 1;
                this.GetContactSyncConfig = i383;
                this.PrepareContext[i383] = null;
                int i384 = i383 - 1;
                this.GetContactSyncConfig = i384;
                iArr160[i384 - 1] = iArr160[i384 - 1] - iArr160[i384];
                return 0;
            case 176:
                int i385 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i385;
                this.PrepareContext[i385] = null;
                int[] iArr161 = this.initRecordTimeStamp;
                iArr161[i385 - 1] = -iArr161[i385 - 1];
                int i386 = i385 - 1;
                this.GetContactSyncConfig = i386;
                iArr161[i386 - 1] = iArr161[i386] | iArr161[i386 - 1];
                return 0;
            case 177:
                int[] iArr162 = this.initRecordTimeStamp;
                int i387 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i387 + 1;
                iArr162[i387] = 91;
                return 0;
            case 178:
                int[] iArr163 = this.initRecordTimeStamp;
                int i388 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i388 + 1;
                iArr163[i388] = 75;
                return 0;
            case 179:
                Object[] objArr11 = this.PrepareContext;
                int i389 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i389 + 1;
                objArr11[i389] = objArr11[14];
                return 0;
            case 180:
                Object[] objArr12 = this.PrepareContext;
                int i390 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i390 + 1;
                objArr12[i390] = objArr12[16];
                return 0;
            case 181:
                int[] iArr164 = this.initRecordTimeStamp;
                int i391 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i391 + 1;
                iArr164[i391] = 42;
                return 0;
            case 182:
                int i392 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i392;
                Object[] objArr13 = this.PrepareContext;
                Object obj5 = objArr13[i392];
                objArr13[i392] = null;
                objArr13[11] = obj5;
                int i393 = i392 + 1;
                this.GetContactSyncConfig = i393;
                objArr13[i392] = objArr13[14];
                this.GetContactSyncConfig = i393 + 1;
                objArr13[i393] = objArr13[11];
                return 0;
            case 183:
                Object[] objArr14 = this.PrepareContext;
                int i394 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i394 + 1;
                objArr14[i394] = objArr14[17];
                return 0;
            case 184:
                int i395 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i395;
                Object[] objArr15 = this.PrepareContext;
                Object obj6 = objArr15[i395];
                objArr15[i395] = null;
                objArr15[14] = obj6;
                this.GetContactSyncConfig = i395 + 1;
                objArr15[i395] = objArr15[10];
                return 0;
            case WSContextConstant.HANDSHAKE_RECEIVE_SIZE /* 185 */:
                Object[] objArr16 = this.PrepareContext;
                int i396 = this.GetContactSyncConfig;
                int i397 = i396 + 1;
                this.GetContactSyncConfig = i397;
                objArr16[i396] = objArr16[12];
                this.GetContactSyncConfig = i397 + 1;
                objArr16[i397] = objArr16[13];
                return 0;
            case 186:
                Object[] objArr17 = this.PrepareContext;
                int i398 = this.GetContactSyncConfig;
                int i399 = i398 + 1;
                this.GetContactSyncConfig = i399;
                objArr17[i398] = objArr17[15];
                this.GetContactSyncConfig = i399 + 1;
                objArr17[i399] = objArr17[16];
                return 0;
            case 187:
                int i400 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i400;
                Object[] objArr18 = this.PrepareContext;
                Object obj7 = objArr18[i400];
                objArr18[i400] = null;
                objArr18[14] = obj7;
                return 0;
            case 188:
                int i401 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i401;
                Object[] objArr19 = this.PrepareContext;
                Object obj8 = objArr19[i401];
                objArr19[i401] = null;
                objArr19[17] = obj8;
                this.GetContactSyncConfig = i401 + 1;
                objArr19[i401] = objArr19[14];
                return 0;
            case WSContextConstant.HANDSHAKE_SEND_SIZE /* 189 */:
                int[] iArr165 = this.initRecordTimeStamp;
                int i402 = this.GetContactSyncConfig;
                int i403 = i402 + 1;
                this.GetContactSyncConfig = i403;
                iArr165[i402] = 25;
                iArr165[i403 - 1] = -iArr165[i403 - 1];
                return 0;
            case 190:
                int i404 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i404;
                int[] iArr166 = this.initRecordTimeStamp;
                iArr166[i404 - 1] = iArr166[i404 - 1] | iArr166[i404];
                int i405 = i404 + 1;
                this.GetContactSyncConfig = i405;
                iArr166[i404] = 1;
                int i406 = i405 - 1;
                this.GetContactSyncConfig = i406;
                iArr166[i406 - 1] = iArr166[i406 - 1] << iArr166[i406];
                return 0;
            case 191:
                int[] iArr167 = this.initRecordTimeStamp;
                int i407 = this.GetContactSyncConfig;
                int i408 = i407 + 1;
                this.GetContactSyncConfig = i408;
                int i409 = iArr167[i408 - 2];
                iArr167[i407] = i409;
                iArr167[i408 - 2] = iArr167[i408 - 3];
                iArr167[i408 - 3] = iArr167[i408 - 4];
                iArr167[i408 - 4] = i409;
                int i410 = i408 - 1;
                this.GetContactSyncConfig = i410;
                this.PrepareContext[i410] = null;
                int i411 = i410 - 1;
                this.GetContactSyncConfig = i411;
                iArr167[i411 - 1] = iArr167[i411] ^ iArr167[i411 - 1];
                return 0;
            case 192:
                int i412 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i412;
                int[] iArr168 = this.initRecordTimeStamp;
                iArr168[i412 - 1] = iArr168[i412 - 1] - iArr168[i412];
                int i413 = i412 + 1;
                this.GetContactSyncConfig = i413;
                iArr168[i412] = 1;
                iArr168[i413 - 1] = -iArr168[i413 - 1];
                return 0;
            case 193:
                int i414 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i414;
                int[] iArr169 = this.initRecordTimeStamp;
                iArr169[i414 - 1] = iArr169[i414 - 1] ^ iArr169[i414];
                int i415 = i414 - 1;
                this.GetContactSyncConfig = i415;
                iArr169[i415 - 1] = iArr169[i415 - 1] - iArr169[i415];
                return 0;
            case 194:
                int[] iArr170 = this.initRecordTimeStamp;
                int i416 = this.GetContactSyncConfig;
                int i417 = i416 + 1;
                this.GetContactSyncConfig = i417;
                iArr170[i416] = 121;
                int i418 = i417 - 1;
                this.GetContactSyncConfig = i418;
                iArr170[i418 - 1] = iArr170[i418 - 1] + iArr170[i418];
                return 0;
            case 195:
                int[] iArr171 = this.initRecordTimeStamp;
                int i419 = this.GetContactSyncConfig;
                int i420 = i419 + 1;
                this.GetContactSyncConfig = i420;
                iArr171[i419] = 117;
                int i421 = i420 + 2;
                this.GetContactSyncConfig = i421;
                iArr171[i421 - 1] = iArr171[i421 - 3];
                iArr171[i420] = iArr171[i421 - 4];
                return 0;
            case 196:
                int i422 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i422;
                this.PrepareContext[i422] = null;
                int i423 = i422 - 1;
                this.GetContactSyncConfig = i423;
                int[] iArr172 = this.initRecordTimeStamp;
                iArr172[i423 - 1] = iArr172[i423 - 1] & iArr172[i423];
                int i424 = i423 + 1;
                this.GetContactSyncConfig = i424;
                int i425 = iArr172[i424 - 2];
                iArr172[i423] = i425;
                iArr172[i424 - 2] = iArr172[i424 - 3];
                iArr172[i424 - 3] = iArr172[i424 - 4];
                iArr172[i424 - 4] = i425;
                return 0;
            case 197:
                int i426 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i426;
                int[] iArr173 = this.initRecordTimeStamp;
                iArr173[i426 - 1] = iArr173[i426 - 1] & iArr173[i426];
                int i427 = i426 + 1;
                this.GetContactSyncConfig = i427;
                int i428 = iArr173[i427 - 2];
                iArr173[i426] = i428;
                iArr173[i427 - 2] = iArr173[i427 - 3];
                iArr173[i427 - 3] = iArr173[i427 - 4];
                iArr173[i427 - 4] = i428;
                int i429 = i427 - 1;
                this.GetContactSyncConfig = i429;
                this.PrepareContext[i429] = null;
                return 0;
            case 198:
                int i430 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i430;
                int[] iArr174 = this.initRecordTimeStamp;
                iArr174[i430 - 1] = iArr174[i430 - 1] | iArr174[i430];
                int i431 = i430 - 1;
                this.GetContactSyncConfig = i431;
                iArr174[i431 - 1] = iArr174[i431 - 1] + iArr174[i431];
                int i432 = i431 + 1;
                this.GetContactSyncConfig = i432;
                iArr174[i431] = iArr174[i432 - 2];
                return 0;
            case SecExceptionCode.SEC_ERROR_INIT_UNKNOWN_ERROR /* 199 */:
                Object[] objArr20 = this.PrepareContext;
                int i433 = this.GetContactSyncConfig;
                int i434 = i433 + 1;
                this.GetContactSyncConfig = i434;
                objArr20[i433] = objArr20[14];
                this.GetContactSyncConfig = i434 + 1;
                objArr20[i434] = objArr20[16];
                return 0;
            case 200:
                int[] iArr175 = this.initRecordTimeStamp;
                int i435 = this.GetContactSyncConfig;
                int i436 = i435 + 1;
                this.GetContactSyncConfig = i436;
                iArr175[i435] = 96;
                this.GetContactSyncConfig = i436 + 1;
                iArr175[i436] = 0;
                return 0;
            case 201:
                int[] iArr176 = this.initRecordTimeStamp;
                int i437 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i437 + 1;
                iArr176[i437] = 71;
                return 0;
            case 202:
                int i438 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i438;
                int[] iArr177 = this.initRecordTimeStamp;
                iArr177[i438 - 1] = iArr177[i438 - 1] | iArr177[i438];
                int i439 = i438 - 1;
                this.GetContactSyncConfig = i439;
                iArr177[i439 - 1] = iArr177[i439 - 1] + iArr177[i439];
                return 0;
            case 203:
                int[] iArr178 = this.initRecordTimeStamp;
                int i440 = this.GetContactSyncConfig;
                int i441 = i440 + 1;
                this.GetContactSyncConfig = i441;
                iArr178[i440] = 7;
                iArr178[i441 - 1] = -iArr178[i441 - 1];
                return 0;
            case 204:
                int i442 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i442;
                this.PrepareContext[i442] = null;
                int i443 = i442 - 1;
                this.GetContactSyncConfig = i443;
                int[] iArr179 = this.initRecordTimeStamp;
                iArr179[i443 - 1] = iArr179[i443 - 1] - iArr179[i443];
                this.GetContactSyncConfig = i443 + 1;
                iArr179[i443] = 1;
                return 0;
            case 205:
                int[] iArr180 = this.initRecordTimeStamp;
                int i444 = this.GetContactSyncConfig;
                int i445 = i444 + 1;
                this.GetContactSyncConfig = i445;
                iArr180[i444] = 95;
                int i446 = i445 + 1;
                this.GetContactSyncConfig = i446;
                iArr180[i445] = iArr180[i446 - 2];
                this.GetContactSyncConfig = i446 + 1;
                iArr180[i446] = -1;
                return 0;
            case 206:
                int i447 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i447;
                this.PrepareContext[i447] = null;
                int[] iArr181 = this.initRecordTimeStamp;
                int i448 = iArr181[i447 - 1];
                iArr181[i447 - 1] = iArr181[i447 - 2];
                iArr181[i447 - 2] = i448;
                this.GetContactSyncConfig = i447 + 1;
                iArr181[i447] = -1;
                return 0;
            case 207:
                int i449 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i449;
                int[] iArr182 = this.initRecordTimeStamp;
                iArr182[i449 - 1] = iArr182[i449 - 1] << iArr182[i449];
                int i450 = i449 - 1;
                this.GetContactSyncConfig = i450;
                iArr182[i450 - 1] = iArr182[i450 - 1] + iArr182[i450];
                this.GetContactSyncConfig = i450 + 1;
                iArr182[i450] = 1;
                return 0;
            case 208:
                int[] iArr183 = this.initRecordTimeStamp;
                int i451 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i451 + 1;
                iArr183[i451] = 20;
                return 0;
            case 209:
                int[] iArr184 = this.initRecordTimeStamp;
                int i452 = this.GetContactSyncConfig;
                int i453 = i452 + 1;
                this.GetContactSyncConfig = i453;
                iArr184[i452] = 105;
                int i454 = i453 + 2;
                this.GetContactSyncConfig = i454;
                iArr184[i454 - 1] = iArr184[i454 - 3];
                iArr184[i453] = iArr184[i454 - 4];
                int i455 = i454 + 2;
                this.GetContactSyncConfig = i455;
                iArr184[i455 - 1] = iArr184[i455 - 3];
                iArr184[i454] = iArr184[i455 - 4];
                return 0;
            case 210:
                int i456 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i456;
                int[] iArr185 = this.initRecordTimeStamp;
                iArr185[i456 - 1] = iArr185[i456 - 1] & iArr185[i456];
                this.GetContactSyncConfig = i456 + 1;
                iArr185[i456] = -1;
                return 0;
            case 211:
                int[] iArr186 = this.initRecordTimeStamp;
                int i457 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i457 + 1;
                iArr186[i457] = 6;
                return 0;
            case SecExceptionCode.SEC_ERROR_STA_STORE_LOW_VERSION_DATA_FILE /* 212 */:
                int[] iArr187 = this.initRecordTimeStamp;
                int i458 = this.GetContactSyncConfig;
                int i459 = i458 + 1;
                this.GetContactSyncConfig = i459;
                iArr187[i458] = 63;
                int i460 = i459 + 2;
                this.GetContactSyncConfig = i460;
                iArr187[i460 - 1] = iArr187[i460 - 3];
                iArr187[i459] = iArr187[i460 - 4];
                return 0;
            case 213:
                int[] iArr188 = this.initRecordTimeStamp;
                int i461 = this.GetContactSyncConfig;
                int i462 = i461 + 1;
                this.GetContactSyncConfig = i462;
                iArr188[i461] = 38;
                int i463 = i462 + 1;
                this.GetContactSyncConfig = i463;
                iArr188[i462] = 0;
                int i464 = i463 - 1;
                this.GetContactSyncConfig = i464;
                iArr188[i464 - 1] = iArr188[i464 - 1] / iArr188[i464];
                return 0;
            case 214:
                Object[] objArr21 = this.PrepareContext;
                int i465 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i465 + 1;
                objArr21[i465] = objArr21[13];
                return 0;
            case 215:
                int[] iArr189 = this.initRecordTimeStamp;
                int i466 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i466 + 1;
                iArr189[i466] = 77;
                return 0;
            case 216:
                int[] iArr190 = this.initRecordTimeStamp;
                int i467 = this.GetContactSyncConfig;
                int i468 = i467 + 1;
                this.GetContactSyncConfig = i468;
                iArr190[i467] = 1;
                int i469 = i468 - 1;
                this.GetContactSyncConfig = i469;
                iArr190[i469 - 1] = iArr190[i469 - 1] << iArr190[i469];
                int i470 = i469 + 1;
                this.GetContactSyncConfig = i470;
                int i471 = iArr190[i470 - 2];
                iArr190[i469] = i471;
                iArr190[i470 - 2] = iArr190[i470 - 3];
                iArr190[i470 - 3] = iArr190[i470 - 4];
                iArr190[i470 - 4] = i471;
                return 0;
            case FileUtils.JPEG_MARKER_EOI /* 217 */:
                int i472 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i472;
                Object[] objArr22 = this.PrepareContext;
                Object obj9 = objArr22[i472];
                objArr22[i472] = null;
                objArr22[11] = obj9;
                return 0;
            case 218:
                int[] iArr191 = this.initRecordTimeStamp;
                int i473 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i473 + 1;
                iArr191[i473] = 43;
                return 0;
            case 219:
                int[] iArr192 = this.initRecordTimeStamp;
                int i474 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i474 + 1;
                iArr192[i474] = 80;
                return 0;
            case WheelView.DIVIDER_ALPHA /* 220 */:
                int[] iArr193 = this.initRecordTimeStamp;
                int i475 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i475 + 1;
                iArr193[i475] = 119;
                return 0;
            case 221:
                int i476 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i476;
                int[] iArr194 = this.initRecordTimeStamp;
                iArr194[i476 - 1] = iArr194[i476 - 1] | iArr194[i476];
                this.GetContactSyncConfig = i476 + 1;
                iArr194[i476] = 1;
                return 0;
            case 222:
                int i477 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i477;
                this.PrepareContext[i477] = null;
                int[] iArr195 = this.initRecordTimeStamp;
                iArr195[i477 - 1] = -iArr195[i477 - 1];
                int i478 = i477 + 2;
                this.GetContactSyncConfig = i478;
                iArr195[i478 - 1] = iArr195[i478 - 3];
                iArr195[i477] = iArr195[i478 - 4];
                return 0;
            case 223:
                Object[] objArr23 = this.PrepareContext;
                int i479 = this.GetContactSyncConfig;
                int i480 = i479 + 1;
                this.GetContactSyncConfig = i480;
                objArr23[i479] = objArr23[i480 - 2];
                return 0;
            case 224:
                int[] iArr196 = this.initRecordTimeStamp;
                int i481 = this.GetContactSyncConfig;
                int i482 = i481 + 1;
                this.GetContactSyncConfig = i482;
                iArr196[i481] = 50;
                int i483 = i482 + 1;
                this.GetContactSyncConfig = i483;
                iArr196[i482] = 0;
                int i484 = i483 - 1;
                this.GetContactSyncConfig = i484;
                iArr196[i484 - 1] = iArr196[i484 - 1] / iArr196[i484];
                return 0;
            case 225:
                int i485 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i485;
                Object[] objArr24 = this.PrepareContext;
                Object obj10 = objArr24[i485];
                objArr24[i485] = null;
                objArr24[13] = obj10;
                return 0;
            case 226:
                int[] iArr197 = this.initRecordTimeStamp;
                int i486 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i486 + 1;
                iArr197[i486] = 94;
                return 0;
            case 227:
                int[] iArr198 = this.initRecordTimeStamp;
                int i487 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i487 + 1;
                iArr198[i487] = 27;
                return 0;
            case 228:
                Object[] objArr25 = this.PrepareContext;
                int i488 = this.GetContactSyncConfig;
                int i489 = i488 + 1;
                this.GetContactSyncConfig = i489;
                objArr25[i488] = objArr25[i489 - 2];
                int i490 = i489 - 1;
                this.GetContactSyncConfig = i490;
                Object obj11 = objArr25[i490];
                objArr25[i490] = null;
                objArr25[14] = obj11;
                return 0;
            case 229:
                int[] iArr199 = this.initRecordTimeStamp;
                int i491 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i491 + 1;
                iArr199[i491] = 7;
                return 0;
            case 230:
                Object[] objArr26 = this.PrepareContext;
                int i492 = this.GetContactSyncConfig;
                int i493 = i492 + 1;
                this.GetContactSyncConfig = i493;
                objArr26[i492] = objArr26[14];
                this.GetContactSyncConfig = i493 + 1;
                objArr26[i493] = objArr26[12];
                return 0;
            case 231:
                int[] iArr200 = this.initRecordTimeStamp;
                int i494 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i494 + 1;
                iArr200[i494] = 5;
                return 0;
            case 232:
                int i495 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i495;
                int[] iArr201 = this.initRecordTimeStamp;
                iArr201[i495 - 1] = iArr201[i495 - 1] >>> iArr201[i495];
                return 0;
            case 233:
                int[] iArr202 = this.initRecordTimeStamp;
                int i496 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i496 + 1;
                iArr202[i496] = 11;
                return 0;
            case 234:
                int i497 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i497;
                int[] iArr203 = this.initRecordTimeStamp;
                iArr203[i497 - 1] = iArr203[i497 - 1] << iArr203[i497];
                int i498 = i497 + 1;
                this.GetContactSyncConfig = i498;
                int i499 = iArr203[i498 - 2];
                iArr203[i497] = i499;
                iArr203[i498 - 2] = iArr203[i498 - 3];
                iArr203[i498 - 3] = iArr203[i498 - 4];
                iArr203[i498 - 4] = i499;
                int i500 = i498 - 1;
                this.GetContactSyncConfig = i500;
                this.PrepareContext[i500] = null;
                return 0;
            case 235:
                int i501 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i501;
                this.PrepareContext[i501] = null;
                int[] iArr204 = this.initRecordTimeStamp;
                int i502 = iArr204[i501 - 1];
                iArr204[i501 - 1] = iArr204[i501 - 2];
                iArr204[i501 - 2] = i502;
                return 0;
            case 236:
                int i503 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i503;
                int[] iArr205 = this.initRecordTimeStamp;
                iArr205[i503 - 1] = iArr205[i503 - 1] | iArr205[i503];
                iArr205[i503 - 1] = -iArr205[i503 - 1];
                int i504 = i503 + 2;
                this.GetContactSyncConfig = i504;
                iArr205[i504 - 1] = iArr205[i504 - 3];
                iArr205[i503] = iArr205[i504 - 4];
                return 0;
            case 237:
                int[] iArr206 = this.initRecordTimeStamp;
                int i505 = this.GetContactSyncConfig;
                int i506 = i505 + 1;
                this.GetContactSyncConfig = i506;
                iArr206[i505] = 17;
                iArr206[i506 - 1] = -iArr206[i506 - 1];
                int i507 = i506 + 2;
                this.GetContactSyncConfig = i507;
                iArr206[i507 - 1] = iArr206[i507 - 3];
                iArr206[i506] = iArr206[i507 - 4];
                return 0;
            case 238:
                int[] iArr207 = this.initRecordTimeStamp;
                int i508 = this.GetContactSyncConfig;
                iArr207[i508 - 1] = -iArr207[i508 - 1];
                int i509 = i508 - 1;
                this.GetContactSyncConfig = i509;
                iArr207[i509 - 1] = iArr207[i509 - 1] & iArr207[i509];
                int i510 = i509 + 1;
                this.GetContactSyncConfig = i510;
                int i511 = iArr207[i510 - 2];
                iArr207[i509] = i511;
                iArr207[i510 - 2] = iArr207[i510 - 3];
                iArr207[i510 - 3] = iArr207[i510 - 4];
                iArr207[i510 - 4] = i511;
                return 0;
            case 239:
                int i512 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i512;
                int[] iArr208 = this.initRecordTimeStamp;
                iArr208[i512 - 1] = iArr208[i512 - 1] & iArr208[i512];
                int i513 = i512 - 1;
                this.GetContactSyncConfig = i513;
                iArr208[i513 - 1] = iArr208[i513 - 1] | iArr208[i513];
                int i514 = i513 + 1;
                this.GetContactSyncConfig = i514;
                iArr208[i513] = iArr208[i514 - 2];
                return 0;
            case 240:
                int[] iArr209 = this.initRecordTimeStamp;
                int i515 = this.GetContactSyncConfig;
                int i516 = i515 + 1;
                this.GetContactSyncConfig = i516;
                iArr209[i515] = -1;
                int i517 = i516 - 1;
                this.GetContactSyncConfig = i517;
                iArr209[i517 - 1] = iArr209[i517 - 1] ^ iArr209[i517];
                int i518 = iArr209[i517 - 1];
                iArr209[i517 - 1] = iArr209[i517 - 2];
                iArr209[i517 - 2] = i518;
                return 0;
            case 241:
                int[] iArr210 = this.initRecordTimeStamp;
                int i519 = this.GetContactSyncConfig;
                int i520 = i519 + 1;
                this.GetContactSyncConfig = i520;
                iArr210[i519] = 55;
                iArr210[i520 - 1] = -iArr210[i520 - 1];
                int i521 = i520 + 2;
                this.GetContactSyncConfig = i521;
                iArr210[i521 - 1] = iArr210[i521 - 3];
                iArr210[i520] = iArr210[i521 - 4];
                return 0;
            case 242:
                int[] iArr211 = this.initRecordTimeStamp;
                int i522 = this.GetContactSyncConfig;
                iArr211[i522 - 1] = -iArr211[i522 - 1];
                int i523 = i522 - 1;
                this.GetContactSyncConfig = i523;
                iArr211[i523 - 1] = iArr211[i523 - 1] & iArr211[i523];
                this.GetContactSyncConfig = i523 + 1;
                iArr211[i523] = 1;
                return 0;
            case 243:
                Object[] objArr27 = this.PrepareContext;
                int i524 = this.GetContactSyncConfig;
                int i525 = i524 + 1;
                this.GetContactSyncConfig = i525;
                objArr27[i524] = objArr27[14];
                this.GetContactSyncConfig = i525 + 1;
                objArr27[i525] = objArr27[13];
                return 0;
            case 244:
                int i526 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i526;
                Object[] objArr28 = this.PrepareContext;
                objArr28[i526] = null;
                this.GetContactSyncConfig = i526 + 1;
                objArr28[i526] = objArr28[14];
                return 0;
            case 245:
                int[] iArr212 = this.initRecordTimeStamp;
                int i527 = this.GetContactSyncConfig;
                iArr212[i527 - 1] = -iArr212[i527 - 1];
                int i528 = i527 - 1;
                this.GetContactSyncConfig = i528;
                iArr212[i528 - 1] = iArr212[i528 - 1] ^ iArr212[i528];
                int i529 = i528 - 1;
                this.GetContactSyncConfig = i529;
                iArr212[i529 - 1] = iArr212[i529 - 1] - iArr212[i529];
                return 0;
            case 246:
                int[] iArr213 = this.initRecordTimeStamp;
                int i530 = this.GetContactSyncConfig;
                int i531 = i530 + 1;
                this.GetContactSyncConfig = i531;
                iArr213[i530] = 13;
                iArr213[i531 - 1] = -iArr213[i531 - 1];
                int i532 = i531 + 2;
                this.GetContactSyncConfig = i532;
                iArr213[i532 - 1] = iArr213[i532 - 3];
                iArr213[i531] = iArr213[i532 - 4];
                return 0;
            case 247:
                int[] iArr214 = this.initRecordTimeStamp;
                int i533 = this.GetContactSyncConfig;
                iArr214[i533 - 1] = -iArr214[i533 - 1];
                int i534 = i533 + 2;
                this.GetContactSyncConfig = i534;
                iArr214[i534 - 1] = iArr214[i534 - 3];
                iArr214[i533] = iArr214[i534 - 4];
                this.GetContactSyncConfig = i534 + 1;
                iArr214[i534] = -1;
                return 0;
            case 248:
                int[] iArr215 = this.initRecordTimeStamp;
                int i535 = this.GetContactSyncConfig;
                int i536 = i535 + 1;
                this.GetContactSyncConfig = i536;
                iArr215[i535] = 1;
                int i537 = i536 - 1;
                this.GetContactSyncConfig = i537;
                iArr215[i537 - 1] = iArr215[i537 - 1] << iArr215[i537];
                int i538 = i537 + 1;
                this.GetContactSyncConfig = i538;
                iArr215[i537] = iArr215[i538 - 2];
                return 0;
            case 249:
                int[] iArr216 = this.initRecordTimeStamp;
                int i539 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i539 + 1;
                iArr216[i539] = 33;
                return 0;
            case 250:
                int[] iArr217 = this.initRecordTimeStamp;
                int i540 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i540 + 1;
                iArr217[i540] = 93;
                return 0;
            case 251:
                int i541 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i541;
                int[] iArr218 = this.initRecordTimeStamp;
                iArr218[i541 - 1] = iArr218[i541 - 1] | iArr218[i541];
                int i542 = i541 - 1;
                this.GetContactSyncConfig = i542;
                iArr218[i542 - 1] = iArr218[i542 - 1] + iArr218[i542];
                this.GetContactSyncConfig = i542 + 1;
                iArr218[i542] = 1;
                return 0;
            case 252:
                int[] iArr219 = this.initRecordTimeStamp;
                int i543 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i543 + 1;
                iArr219[i543] = 96;
                return 0;
            case 253:
                int[] iArr220 = this.initRecordTimeStamp;
                int i544 = this.GetContactSyncConfig;
                Object[] objArr29 = this.PrepareContext;
                Object obj12 = objArr29[i544 - 1];
                objArr29[i544 - 1] = null;
                iArr220[i544 - 1] = ((int[]) obj12).length;
                int i545 = i544 - 1;
                this.GetContactSyncConfig = i545;
                objArr29[i545] = null;
                return 0;
            case 254:
                int[] iArr221 = this.initRecordTimeStamp;
                int i546 = this.GetContactSyncConfig;
                int i547 = i546 + 1;
                this.GetContactSyncConfig = i547;
                iArr221[i546] = 27;
                iArr221[i547 - 1] = -iArr221[i547 - 1];
                int i548 = i547 + 2;
                this.GetContactSyncConfig = i548;
                iArr221[i548 - 1] = iArr221[i548 - 3];
                iArr221[i547] = iArr221[i548 - 4];
                return 0;
            case 255:
                int[] iArr222 = this.initRecordTimeStamp;
                int i549 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i549 + 1;
                iArr222[i549] = 26;
                return 0;
            case 256:
                int[] iArr223 = this.initRecordTimeStamp;
                int i550 = this.GetContactSyncConfig;
                int i551 = i550 + 1;
                this.GetContactSyncConfig = i551;
                iArr223[i550] = 95;
                iArr223[i551 - 1] = -iArr223[i551 - 1];
                return 0;
            case DeepRecoverARiverProxy.TYPE_ENTITY_APP /* 257 */:
                int[] iArr224 = this.initRecordTimeStamp;
                int i552 = this.GetContactSyncConfig;
                int i553 = i552 + 1;
                this.GetContactSyncConfig = i553;
                iArr224[i552] = 5;
                int i554 = i553 + 2;
                this.GetContactSyncConfig = i554;
                iArr224[i554 - 1] = iArr224[i554 - 3];
                iArr224[i553] = iArr224[i554 - 4];
                return 0;
            case DeepRecoverARiverProxy.TYPE_ENTITY_TEMPLATE /* 258 */:
                int[] iArr225 = this.initRecordTimeStamp;
                int i555 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i555 + 1;
                iArr225[i555] = 56;
                return 0;
            case DeepRecoverARiverProxy.TYPE_ENTITY_PLUGIN /* 259 */:
                int[] iArr226 = this.initRecordTimeStamp;
                int i556 = this.GetContactSyncConfig;
                int i557 = i556 + 1;
                this.GetContactSyncConfig = i557;
                iArr226[i556] = 73;
                iArr226[i557 - 1] = -iArr226[i557 - 1];
                return 0;
            case DeepRecoverARiverProxy.TYPE_ENTITY_TA_PAGE /* 260 */:
                int[] iArr227 = this.initRecordTimeStamp;
                int i558 = this.GetContactSyncConfig;
                int i559 = i558 + 1;
                this.GetContactSyncConfig = i559;
                iArr227[i558] = iArr227[i559 - 2];
                iArr227[i559 - 1] = -iArr227[i559 - 1];
                return 0;
            case DeepRecoverARiverProxy.TYPE_ENTITY_ONLINE_PAGE /* 261 */:
                int[] iArr228 = this.initRecordTimeStamp;
                int i560 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i560 + 1;
                iArr228[i560] = 39;
                return 0;
            case 262:
                int i561 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i561;
                Object[] objArr30 = this.PrepareContext;
                Object obj13 = objArr30[i561];
                objArr30[i561] = null;
                objArr30[12] = obj13;
                int i562 = i561 + 1;
                this.GetContactSyncConfig = i562;
                objArr30[i561] = objArr30[10];
                this.GetContactSyncConfig = i562 + 1;
                objArr30[i562] = objArr30[11];
                return 0;
            case 263:
                int[] iArr229 = this.initRecordTimeStamp;
                int i563 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i563 + 1;
                iArr229[i563] = 51;
                return 0;
            case 264:
                int[] iArr230 = this.initRecordTimeStamp;
                int i564 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i564 + 1;
                iArr230[i564] = 47;
                return 0;
            case 265:
                Object[] objArr31 = this.PrepareContext;
                int i565 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i565 + 1;
                objArr31[i565] = objArr31[12];
                return 0;
            case 266:
                int[] iArr231 = this.initRecordTimeStamp;
                int i566 = this.GetContactSyncConfig;
                Object[] objArr32 = this.PrepareContext;
                Object obj14 = objArr32[i566 - 1];
                objArr32[i566 - 1] = null;
                iArr231[i566 - 1] = ((int[]) obj14).length;
                return 0;
            case 267:
                int[] iArr232 = this.initRecordTimeStamp;
                int i567 = this.GetContactSyncConfig;
                iArr232[i567 - 1] = -iArr232[i567 - 1];
                int i568 = i567 + 1;
                this.GetContactSyncConfig = i568;
                iArr232[i567] = iArr232[i568 - 2];
                return 0;
            case 268:
                int i569 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i569;
                int[] iArr233 = this.initRecordTimeStamp;
                iArr233[i569 - 1] = iArr233[i569 - 1] ^ iArr233[i569];
                int i570 = iArr233[i569 - 1];
                iArr233[i569 - 1] = iArr233[i569 - 2];
                iArr233[i569 - 2] = i570;
                return 0;
            case 269:
                int i571 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i571;
                this.PrepareContext[i571] = null;
                int i572 = i571 - 1;
                this.GetContactSyncConfig = i572;
                int[] iArr234 = this.initRecordTimeStamp;
                iArr234[i572 - 1] = iArr234[i572 - 1] - iArr234[i572];
                return 0;
            case 270:
                int i573 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i573;
                Object[] objArr33 = this.PrepareContext;
                Object obj15 = objArr33[i573];
                objArr33[i573] = null;
                objArr33[13] = obj15;
                this.GetContactSyncConfig = i573 + 1;
                objArr33[i573] = objArr33[12];
                return 0;
            case 271:
                int i574 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i574;
                Object[] objArr34 = this.PrepareContext;
                Object obj16 = objArr34[i574];
                objArr34[i574] = null;
                objArr34[12] = obj16;
                this.GetContactSyncConfig = i574 + 1;
                objArr34[i574] = objArr34[11];
                return 0;
            case LZMA_Base.kNumLenSymbols /* 272 */:
                int[] iArr235 = this.initRecordTimeStamp;
                int i575 = this.GetContactSyncConfig;
                int i576 = i575 + 1;
                this.GetContactSyncConfig = i576;
                iArr235[i575] = 41;
                iArr235[i576 - 1] = -iArr235[i576 - 1];
                int i577 = i576 + 2;
                this.GetContactSyncConfig = i577;
                iArr235[i577 - 1] = iArr235[i577 - 3];
                iArr235[i576] = iArr235[i577 - 4];
                return 0;
            case LZMA_Base.kMatchMaxLen /* 273 */:
                int i578 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i578;
                int[] iArr236 = this.initRecordTimeStamp;
                iArr236[i578 - 1] = iArr236[i578 - 1] ^ iArr236[i578];
                int i579 = i578 - 1;
                this.GetContactSyncConfig = i579;
                iArr236[i579 - 1] = iArr236[i579 - 1] & iArr236[i579];
                int i580 = i579 - 1;
                this.GetContactSyncConfig = i580;
                iArr236[i580 - 1] = iArr236[i580] | iArr236[i580 - 1];
                return 0;
            case 274:
                int[] iArr237 = this.initRecordTimeStamp;
                int i581 = this.GetContactSyncConfig;
                int i582 = i581 + 2;
                this.GetContactSyncConfig = i582;
                iArr237[i582 - 1] = iArr237[i582 - 3];
                iArr237[i581] = iArr237[i582 - 4];
                int i583 = i582 - 1;
                this.GetContactSyncConfig = i583;
                iArr237[i583 - 1] = iArr237[i583 - 1] & iArr237[i583];
                int i584 = i583 + 1;
                this.GetContactSyncConfig = i584;
                int i585 = iArr237[i584 - 2];
                iArr237[i583] = i585;
                iArr237[i584 - 2] = iArr237[i584 - 3];
                iArr237[i584 - 3] = iArr237[i584 - 4];
                iArr237[i584 - 4] = i585;
                return 0;
            case 275:
                int i586 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i586;
                Object[] objArr35 = this.PrepareContext;
                Object obj17 = objArr35[i586];
                objArr35[i586] = null;
                objArr35[11] = obj17;
                this.GetContactSyncConfig = i586 + 1;
                objArr35[i586] = objArr35[12];
                return 0;
            case 276:
                int[] iArr238 = this.initRecordTimeStamp;
                int i587 = this.GetContactSyncConfig;
                int i588 = i587 + 1;
                this.GetContactSyncConfig = i588;
                iArr238[i587] = 79;
                iArr238[i588 - 1] = -iArr238[i588 - 1];
                int i589 = i588 + 2;
                this.GetContactSyncConfig = i589;
                iArr238[i589 - 1] = iArr238[i589 - 3];
                iArr238[i588] = iArr238[i589 - 4];
                return 0;
            case 277:
                int[] iArr239 = this.initRecordTimeStamp;
                int i590 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i590 + 1;
                iArr239[i590] = 52;
                return 0;
            case 278:
                int[] iArr240 = this.initRecordTimeStamp;
                int i591 = this.GetContactSyncConfig;
                int i592 = i591 + 1;
                this.GetContactSyncConfig = i592;
                iArr240[i591] = 3;
                iArr240[i592 - 1] = -iArr240[i592 - 1];
                int i593 = i592 + 2;
                this.GetContactSyncConfig = i593;
                iArr240[i593 - 1] = iArr240[i593 - 3];
                iArr240[i592] = iArr240[i593 - 4];
                return 0;
            case 279:
                int[] iArr241 = this.initRecordTimeStamp;
                int i594 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i594 + 1;
                iArr241[i594] = 14;
                return 0;
            case 280:
                int[] iArr242 = this.initRecordTimeStamp;
                int i595 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i595 + 1;
                iArr242[i595] = 81;
                return 0;
            case 281:
                int i596 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i596;
                int[] iArr243 = this.initRecordTimeStamp;
                iArr243[i596 - 1] = iArr243[i596 - 1] | iArr243[i596];
                int i597 = iArr243[i596 - 1];
                iArr243[i596 - 1] = iArr243[i596 - 2];
                iArr243[i596 - 2] = i597;
                return 0;
            case 282:
                int i598 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i598;
                this.PrepareContext[i598] = null;
                int[] iArr244 = this.initRecordTimeStamp;
                int i599 = i598 + 1;
                this.GetContactSyncConfig = i599;
                iArr244[i598] = iArr244[i599 - 2];
                iArr244[i599 - 1] = -iArr244[i599 - 1];
                return 0;
            case 283:
                int[] iArr245 = this.initRecordTimeStamp;
                int i600 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i600 + 1;
                iArr245[i600] = 111;
                return 0;
            case 284:
                int i601 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i601;
                int[] iArr246 = this.initRecordTimeStamp;
                iArr246[i601 - 1] = iArr246[i601 - 1] | iArr246[i601];
                int i602 = i601 + 1;
                this.GetContactSyncConfig = i602;
                int i603 = iArr246[i602 - 2];
                iArr246[i601] = i603;
                iArr246[i602 - 2] = iArr246[i602 - 3];
                iArr246[i602 - 3] = iArr246[i602 - 4];
                iArr246[i602 - 4] = i603;
                return 0;
            case 285:
                int i604 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i604;
                int[] iArr247 = this.initRecordTimeStamp;
                iArr247[i604 - 1] = iArr247[i604 - 1] << iArr247[i604];
                int i605 = i604 + 2;
                this.GetContactSyncConfig = i605;
                iArr247[i605 - 1] = iArr247[i605 - 3];
                iArr247[i604] = iArr247[i605 - 4];
                int i606 = i605 - 1;
                this.GetContactSyncConfig = i606;
                iArr247[i606 - 1] = iArr247[i606] & iArr247[i606 - 1];
                return 0;
            case 286:
                Object[] objArr36 = this.PrepareContext;
                int i607 = this.GetContactSyncConfig;
                int i608 = i607 + 1;
                this.GetContactSyncConfig = i608;
                objArr36[i607] = objArr36[12];
                this.GetContactSyncConfig = i608 + 1;
                objArr36[i608] = objArr36[11];
                return 0;
            case 287:
                int[] iArr248 = this.initRecordTimeStamp;
                int i609 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i609 + 1;
                iArr248[i609] = 22;
                return 0;
            case 288:
                int[] iArr249 = this.initRecordTimeStamp;
                int i610 = this.GetContactSyncConfig;
                int i611 = i610 + 1;
                this.GetContactSyncConfig = i611;
                iArr249[i610] = 21;
                int i612 = i611 + 2;
                this.GetContactSyncConfig = i612;
                iArr249[i612 - 1] = iArr249[i612 - 3];
                iArr249[i611] = iArr249[i612 - 4];
                return 0;
            case 289:
                int[] iArr250 = this.initRecordTimeStamp;
                int i613 = this.GetContactSyncConfig;
                int i614 = i613 + 1;
                this.GetContactSyncConfig = i614;
                int i615 = iArr250[i614 - 2];
                iArr250[i613] = i615;
                iArr250[i614 - 2] = iArr250[i614 - 3];
                iArr250[i614 - 3] = iArr250[i614 - 4];
                iArr250[i614 - 4] = i615;
                int i616 = i614 - 1;
                this.GetContactSyncConfig = i616;
                this.PrepareContext[i616] = null;
                int i617 = i616 + 2;
                this.GetContactSyncConfig = i617;
                iArr250[i617 - 1] = iArr250[i617 - 3];
                iArr250[i616] = iArr250[i617 - 4];
                return 0;
            case 290:
                int i618 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i618;
                int[] iArr251 = this.initRecordTimeStamp;
                iArr251[i618 - 1] = iArr251[i618 - 1] & iArr251[i618];
                int i619 = i618 - 1;
                this.GetContactSyncConfig = i619;
                iArr251[i619 - 1] = iArr251[i619 - 1] | iArr251[i619];
                iArr251[i619 - 1] = -iArr251[i619 - 1];
                return 0;
            case 291:
                int[] iArr252 = this.initRecordTimeStamp;
                int i620 = this.GetContactSyncConfig;
                int i621 = i620 + 1;
                this.GetContactSyncConfig = i621;
                iArr252[i620] = 3;
                iArr252[i621 - 1] = -iArr252[i621 - 1];
                return 0;
            case 292:
                int[] iArr253 = this.initRecordTimeStamp;
                int i622 = this.GetContactSyncConfig;
                int i623 = i622 + 1;
                this.GetContactSyncConfig = i623;
                int i624 = iArr253[i623 - 2];
                iArr253[i622] = i624;
                iArr253[i623 - 2] = iArr253[i623 - 3];
                iArr253[i623 - 3] = iArr253[i623 - 4];
                iArr253[i623 - 4] = i624;
                int i625 = i623 - 1;
                this.GetContactSyncConfig = i625;
                this.PrepareContext[i625] = null;
                int i626 = i625 - 1;
                this.GetContactSyncConfig = i626;
                iArr253[i626 - 1] = iArr253[i626] & iArr253[i626 - 1];
                return 0;
            case 293:
                int[] iArr254 = this.initRecordTimeStamp;
                int i627 = this.GetContactSyncConfig;
                int i628 = i627 + 1;
                this.GetContactSyncConfig = i628;
                iArr254[i627] = 7;
                int i629 = i628 + 2;
                this.GetContactSyncConfig = i629;
                iArr254[i629 - 1] = iArr254[i629 - 3];
                iArr254[i628] = iArr254[i629 - 4];
                return 0;
            case 294:
                long[] jArr = this.DatabaseTableConfigUtil;
                int i630 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i630 + 1;
                jArr[i630] = this.getAuthRequestContext;
                return 0;
            case 295:
                int i631 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i631;
                long[] jArr2 = this.DatabaseTableConfigUtil;
                jArr2[11] = jArr2[i631];
                int i632 = i631 + 1;
                this.GetContactSyncConfig = i632;
                jArr2[i631] = jArr2[11];
                Object[] objArr37 = this.PrepareContext;
                this.GetContactSyncConfig = i632 + 1;
                objArr37[i632] = objArr37[10];
                return 0;
            case 296:
                long[] jArr3 = this.DatabaseTableConfigUtil;
                int i633 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                this.NetworkUserEntityData$$ExternalSyntheticLambda2 = i633 + 1;
                this.KClassImpl$Data$declaredNonStaticMembers$2 = jArr3[i633];
                return 0;
            case 297:
                int[] iArr255 = this.initRecordTimeStamp;
                int i634 = this.GetContactSyncConfig;
                int i635 = i634 + 1;
                this.GetContactSyncConfig = i635;
                iArr255[i634] = 77;
                int i636 = i635 + 2;
                this.GetContactSyncConfig = i636;
                iArr255[i636 - 1] = iArr255[i636 - 3];
                iArr255[i635] = iArr255[i636 - 4];
                return 0;
            case 298:
                int[] iArr256 = this.initRecordTimeStamp;
                int i637 = this.GetContactSyncConfig;
                iArr256[i637 - 1] = -iArr256[i637 - 1];
                int i638 = i637 + 1;
                this.GetContactSyncConfig = i638;
                iArr256[i637] = iArr256[i638 - 2];
                this.GetContactSyncConfig = i638 + 1;
                iArr256[i638] = -1;
                return 0;
            case SecExceptionCode.SEC_ERROR_STA_STORE_UNKNOWN_ERROR /* 299 */:
                int i639 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i639;
                int[] iArr257 = this.initRecordTimeStamp;
                iArr257[i639 - 1] = iArr257[i639 - 1] - iArr257[i639];
                int i640 = i639 + 1;
                this.GetContactSyncConfig = i640;
                iArr257[i639] = 1;
                int i641 = i640 - 1;
                this.GetContactSyncConfig = i641;
                iArr257[i641 - 1] = iArr257[i641 - 1] - iArr257[i641];
                return 0;
            case 300:
                int[] iArr258 = this.initRecordTimeStamp;
                int i642 = this.GetContactSyncConfig;
                int i643 = i642 + 1;
                this.GetContactSyncConfig = i643;
                iArr258[i642] = 43;
                iArr258[i643 - 1] = -iArr258[i643 - 1];
                int i644 = i643 + 2;
                this.GetContactSyncConfig = i644;
                iArr258[i644 - 1] = iArr258[i644 - 3];
                iArr258[i643] = iArr258[i644 - 4];
                return 0;
            case 301:
                int[] iArr259 = this.initRecordTimeStamp;
                int i645 = this.GetContactSyncConfig;
                int i646 = i645 + 1;
                this.GetContactSyncConfig = i646;
                iArr259[i645] = 1;
                int i647 = i646 - 1;
                this.GetContactSyncConfig = i647;
                iArr259[i647 - 1] = iArr259[i647 - 1] - iArr259[i647];
                int i648 = i647 + 1;
                this.GetContactSyncConfig = i648;
                iArr259[i647] = iArr259[i648 - 2];
                return 0;
            case 302:
                int[] iArr260 = this.initRecordTimeStamp;
                int i649 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i649 + 1;
                iArr260[i649] = 15;
                return 0;
            case 303:
                int[] iArr261 = this.initRecordTimeStamp;
                int i650 = this.GetContactSyncConfig;
                int i651 = i650 + 1;
                this.GetContactSyncConfig = i651;
                iArr261[i650] = iArr261[i651 - 2];
                int i652 = i651 + 1;
                this.GetContactSyncConfig = i652;
                iArr261[i651] = -1;
                int i653 = i652 - 1;
                this.GetContactSyncConfig = i653;
                iArr261[i653 - 1] = iArr261[i653] ^ iArr261[i653 - 1];
                return 0;
            case SecExceptionCode.SEC_ERROR_STA_INCORRECT_DATA_FILE /* 304 */:
                int i654 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i654;
                int[] iArr262 = this.initRecordTimeStamp;
                iArr262[i654 - 1] = iArr262[i654 - 1] + iArr262[i654];
                int i655 = i654 + 1;
                this.GetContactSyncConfig = i655;
                iArr262[i654] = 1;
                iArr262[i655 - 1] = -iArr262[i655 - 1];
                return 0;
            case SecExceptionCode.SEC_ERROR_STA_INCORRECT_DATA_FILE_DATA /* 305 */:
                int[] iArr263 = this.initRecordTimeStamp;
                int i656 = this.GetContactSyncConfig;
                int i657 = i656 + 1;
                this.GetContactSyncConfig = i657;
                iArr263[i656] = 16;
                this.GetContactSyncConfig = i657 + 1;
                iArr263[i657] = 0;
                return 0;
            case SecExceptionCode.SEC_ERROR_STA_KEY_NOT_EXISTED /* 306 */:
                int i658 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i658;
                int[] iArr264 = this.initRecordTimeStamp;
                iArr264[i658 - 1] = iArr264[i658 - 1] | iArr264[i658];
                int i659 = iArr264[i658 - 1];
                iArr264[i658 - 1] = iArr264[i658 - 2];
                iArr264[i658 - 2] = i659;
                int i660 = i658 - 1;
                this.GetContactSyncConfig = i660;
                this.PrepareContext[i660] = null;
                return 0;
            case 307:
                int[] iArr265 = this.initRecordTimeStamp;
                int i661 = this.GetContactSyncConfig;
                int i662 = i661 + 1;
                this.GetContactSyncConfig = i662;
                iArr265[i661] = 29;
                int i663 = i662 + 2;
                this.GetContactSyncConfig = i663;
                iArr265[i663 - 1] = iArr265[i663 - 3];
                iArr265[i662] = iArr265[i663 - 4];
                return 0;
            case 308:
                Object[] objArr38 = this.PrepareContext;
                int i664 = this.GetContactSyncConfig;
                int i665 = i664 + 1;
                this.GetContactSyncConfig = i665;
                objArr38[i664] = objArr38[i665 - 2];
                int i666 = i665 - 1;
                this.GetContactSyncConfig = i666;
                Object obj18 = objArr38[i666];
                objArr38[i666] = null;
                objArr38[12] = obj18;
                return 0;
            case SecExceptionCode.SEC_ERROR_STA_NO_SUCH_INDEX /* 309 */:
                int[] iArr266 = this.initRecordTimeStamp;
                int i667 = this.GetContactSyncConfig;
                int i668 = i667 + 1;
                this.GetContactSyncConfig = i668;
                iArr266[i667] = 125;
                int i669 = i668 - 1;
                this.GetContactSyncConfig = i669;
                iArr266[i669 - 1] = iArr266[i669 - 1] + iArr266[i669];
                int i670 = i669 + 1;
                this.GetContactSyncConfig = i670;
                iArr266[i669] = iArr266[i670 - 2];
                return 0;
            case SecExceptionCode.SEC_ERROR_STA_INVALID_ENCRYPTED_DATA /* 310 */:
                Object[] objArr39 = this.PrepareContext;
                int i671 = this.GetContactSyncConfig;
                int i672 = i671 + 1;
                this.GetContactSyncConfig = i672;
                objArr39[i671] = objArr39[12];
                this.GetContactSyncConfig = i672 + 1;
                objArr39[i672] = objArr39[10];
                return 0;
            case SecExceptionCode.SEC_ERROR_STA_DECRYPT_MISMATCH_KEY_DATA /* 311 */:
                int[] iArr267 = this.initRecordTimeStamp;
                int i673 = this.GetContactSyncConfig;
                int i674 = i673 + 1;
                this.GetContactSyncConfig = i674;
                iArr267[i673] = 1;
                iArr267[i674 - 1] = -iArr267[i674 - 1];
                return 0;
            case SecExceptionCode.SEC_ERROR_STA_LOW_VERSION_DATA_FILE /* 312 */:
                int i675 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i675;
                int[] iArr268 = this.initRecordTimeStamp;
                iArr268[i675 - 1] = iArr268[i675 - 1] << iArr268[i675];
                int i676 = i675 + 1;
                this.GetContactSyncConfig = i676;
                iArr268[i675] = iArr268[i676 - 2];
                this.GetContactSyncConfig = i676 + 1;
                iArr268[i676] = -1;
                return 0;
            case 313:
                int i677 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i677;
                int[] iArr269 = this.initRecordTimeStamp;
                iArr269[i677 - 1] = iArr269[i677 - 1] - iArr269[i677];
                this.GetContactSyncConfig = i677 + 1;
                iArr269[i677] = 1;
                return 0;
            case 314:
                int[] iArr270 = this.initRecordTimeStamp;
                int i678 = this.GetContactSyncConfig;
                int i679 = i678 + 1;
                this.GetContactSyncConfig = i679;
                iArr270[i678] = 17;
                iArr270[i679 - 1] = -iArr270[i679 - 1];
                return 0;
            case 315:
                int[] iArr271 = this.initRecordTimeStamp;
                int i680 = this.GetContactSyncConfig;
                int i681 = i680 + 1;
                this.GetContactSyncConfig = i681;
                iArr271[i680] = iArr271[i681 - 2];
                iArr271[i681 - 1] = -iArr271[i681 - 1];
                this.GetContactSyncConfig = i681 + 1;
                iArr271[i681] = -1;
                return 0;
            case 316:
                int[] iArr272 = this.initRecordTimeStamp;
                int i682 = this.GetContactSyncConfig;
                int i683 = i682 + 1;
                this.GetContactSyncConfig = i683;
                iArr272[i682] = 1;
                iArr272[i683 - 1] = -iArr272[i683 - 1];
                return 0;
            case 317:
                int i684 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i684;
                int[] iArr273 = this.initRecordTimeStamp;
                iArr273[i684 - 1] = iArr273[i684 - 1] | iArr273[i684];
                int i685 = i684 + 1;
                this.GetContactSyncConfig = i685;
                iArr273[i684] = iArr273[i685 - 2];
                this.GetContactSyncConfig = i685 + 1;
                iArr273[i685] = -1;
                return 0;
            case 318:
                int[] iArr274 = this.initRecordTimeStamp;
                int i686 = this.GetContactSyncConfig;
                int i687 = i686 + 1;
                this.GetContactSyncConfig = i687;
                iArr274[i686] = 109;
                iArr274[i687 - 1] = -iArr274[i687 - 1];
                int i688 = i687 + 1;
                this.GetContactSyncConfig = i688;
                iArr274[i687] = iArr274[i688 - 2];
                return 0;
            case 319:
                int[] iArr275 = this.initRecordTimeStamp;
                int i689 = this.GetContactSyncConfig;
                int i690 = i689 + 1;
                this.GetContactSyncConfig = i690;
                iArr275[i689] = 9;
                int i691 = i690 + 1;
                this.GetContactSyncConfig = i691;
                iArr275[i690] = iArr275[i691 - 2];
                return 0;
            case 320:
                int[] iArr276 = this.initRecordTimeStamp;
                int i692 = this.GetContactSyncConfig;
                int i693 = i692 + 1;
                this.GetContactSyncConfig = i693;
                iArr276[i692] = -1;
                int i694 = i693 + 2;
                this.GetContactSyncConfig = i694;
                iArr276[i694 - 1] = iArr276[i694 - 3];
                iArr276[i693] = iArr276[i694 - 4];
                return 0;
            case 321:
                int i695 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i695;
                int[] iArr277 = this.initRecordTimeStamp;
                iArr277[i695 - 1] = iArr277[i695 - 1] & iArr277[i695];
                int i696 = iArr277[i695 - 1];
                iArr277[i695 - 1] = iArr277[i695 - 2];
                iArr277[i695 - 2] = i696;
                int i697 = i695 - 1;
                this.GetContactSyncConfig = i697;
                this.PrepareContext[i697] = null;
                return 0;
            case 322:
                Object[] objArr40 = this.PrepareContext;
                int i698 = this.GetContactSyncConfig;
                int i699 = i698 + 1;
                this.GetContactSyncConfig = i699;
                objArr40[i698] = objArr40[i699 - 2];
                int i700 = i699 - 1;
                this.GetContactSyncConfig = i700;
                Object obj19 = objArr40[i700];
                objArr40[i700] = null;
                objArr40[11] = obj19;
                this.GetContactSyncConfig = i700 + 1;
                objArr40[i700] = objArr40[10];
                return 0;
            case 323:
                int[] iArr278 = this.initRecordTimeStamp;
                int i701 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i701 + 1;
                iArr278[i701] = 113;
                return 0;
            case 324:
                int[] iArr279 = this.initRecordTimeStamp;
                int i702 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i702 + 1;
                iArr279[i702] = 40;
                return 0;
            case 325:
                int[] iArr280 = this.initRecordTimeStamp;
                int i703 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i703 + 1;
                iArr280[i703] = 76;
                return 0;
            case 326:
                int[] iArr281 = this.initRecordTimeStamp;
                int i704 = this.GetContactSyncConfig;
                int i705 = i704 + 1;
                this.GetContactSyncConfig = i705;
                iArr281[i704] = 123;
                int i706 = i705 + 1;
                this.GetContactSyncConfig = i706;
                iArr281[i705] = iArr281[i706 - 2];
                return 0;
            case 327:
                int[] iArr282 = this.initRecordTimeStamp;
                int i707 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i707 + 1;
                iArr282[i707] = 49;
                return 0;
            case 328:
                int[] iArr283 = this.initRecordTimeStamp;
                int i708 = this.GetContactSyncConfig;
                int i709 = i708 + 1;
                this.GetContactSyncConfig = i709;
                iArr283[i708] = 4;
                this.GetContactSyncConfig = i709 + 1;
                iArr283[i709] = 3;
                return 0;
            case 329:
                int i710 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i710;
                int[] iArr284 = this.initRecordTimeStamp;
                iArr284[i710 - 1] = iArr284[i710 - 1] & iArr284[i710];
                int i711 = iArr284[i710 - 1];
                iArr284[i710 - 1] = iArr284[i710 - 2];
                iArr284[i710 - 2] = i711;
                return 0;
            case 330:
                int[] iArr285 = this.initRecordTimeStamp;
                int i712 = this.GetContactSyncConfig;
                int i713 = i712 + 2;
                this.GetContactSyncConfig = i713;
                iArr285[i713 - 1] = iArr285[i713 - 3];
                iArr285[i712] = iArr285[i713 - 4];
                iArr285[i713 - 1] = -iArr285[i713 - 1];
                int i714 = i713 - 1;
                this.GetContactSyncConfig = i714;
                iArr285[i714 - 1] = iArr285[i714] ^ iArr285[i714 - 1];
                return 0;
            case 331:
                int[] iArr286 = this.initRecordTimeStamp;
                int i715 = this.GetContactSyncConfig;
                int i716 = i715 + 1;
                this.GetContactSyncConfig = i716;
                iArr286[i715] = -1;
                int i717 = i716 + 2;
                this.GetContactSyncConfig = i717;
                iArr286[i717 - 1] = iArr286[i717 - 3];
                iArr286[i716] = iArr286[i717 - 4];
                this.GetContactSyncConfig = i717 + 1;
                iArr286[i717] = -1;
                return 0;
            case 332:
                int i718 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i718;
                this.PrepareContext[i718] = null;
                int[] iArr287 = this.initRecordTimeStamp;
                int i719 = i718 + 1;
                this.GetContactSyncConfig = i719;
                iArr287[i718] = iArr287[i719 - 2];
                return 0;
            case 333:
                int[] iArr288 = this.initRecordTimeStamp;
                int i720 = this.GetContactSyncConfig;
                int i721 = i720 + 1;
                this.GetContactSyncConfig = i721;
                iArr288[i720] = 1;
                int i722 = i721 - 1;
                this.GetContactSyncConfig = i722;
                iArr288[i722 - 1] = iArr288[i722 - 1] - iArr288[i722];
                this.GetContactSyncConfig = i722 + 1;
                iArr288[i722] = 1;
                return 0;
            case 334:
                int[] iArr289 = this.initRecordTimeStamp;
                int i723 = this.GetContactSyncConfig;
                int i724 = i723 + 1;
                this.GetContactSyncConfig = i724;
                iArr289[i723] = 33;
                iArr289[i724 - 1] = -iArr289[i724 - 1];
                int i725 = i724 + 2;
                this.GetContactSyncConfig = i725;
                iArr289[i725 - 1] = iArr289[i725 - 3];
                iArr289[i724] = iArr289[i725 - 4];
                return 0;
            case 335:
                int[] iArr290 = this.initRecordTimeStamp;
                int i726 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i726 + 1;
                iArr290[i726] = 29;
                return 0;
            case 336:
                int[] iArr291 = this.initRecordTimeStamp;
                int i727 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i727 + 1;
                iArr291[i727] = 16;
                return 0;
            case 337:
                int[] iArr292 = this.initRecordTimeStamp;
                int i728 = this.GetContactSyncConfig;
                int i729 = i728 + 1;
                this.GetContactSyncConfig = i729;
                iArr292[i728] = 75;
                iArr292[i729 - 1] = -iArr292[i729 - 1];
                int i730 = i729 + 1;
                this.GetContactSyncConfig = i730;
                iArr292[i729] = iArr292[i730 - 2];
                return 0;
            case 338:
                int[] iArr293 = this.initRecordTimeStamp;
                int i731 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i731 + 1;
                iArr293[i731] = 31;
                return 0;
            case 339:
                int[] iArr294 = this.initRecordTimeStamp;
                int i732 = this.GetContactSyncConfig;
                int i733 = i732 + 1;
                this.GetContactSyncConfig = i733;
                iArr294[i732] = 40;
                int i734 = i733 + 1;
                this.GetContactSyncConfig = i734;
                iArr294[i733] = 0;
                int i735 = i734 - 1;
                this.GetContactSyncConfig = i735;
                iArr294[i735 - 1] = iArr294[i735 - 1] / iArr294[i735];
                return 0;
            case 340:
                int[] iArr295 = this.initRecordTimeStamp;
                int i736 = this.GetContactSyncConfig;
                int i737 = i736 + 1;
                this.GetContactSyncConfig = i737;
                iArr295[i736] = 89;
                int i738 = i737 + 2;
                this.GetContactSyncConfig = i738;
                iArr295[i738 - 1] = iArr295[i738 - 3];
                iArr295[i737] = iArr295[i738 - 4];
                int i739 = i738 + 2;
                this.GetContactSyncConfig = i739;
                iArr295[i739 - 1] = iArr295[i739 - 3];
                iArr295[i738] = iArr295[i739 - 4];
                return 0;
            case 341:
                int i740 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i740;
                int[] iArr296 = this.initRecordTimeStamp;
                iArr296[i740 - 1] = iArr296[i740 - 1] << iArr296[i740];
                iArr296[i740 - 1] = -iArr296[i740 - 1];
                return 0;
            case 342:
                int[] iArr297 = this.initRecordTimeStamp;
                int i741 = this.GetContactSyncConfig;
                int i742 = i741 + 2;
                this.GetContactSyncConfig = i742;
                iArr297[i742 - 1] = iArr297[i742 - 3];
                iArr297[i741] = iArr297[i742 - 4];
                iArr297[i742 - 1] = -iArr297[i742 - 1];
                int i743 = i742 - 1;
                this.GetContactSyncConfig = i743;
                iArr297[i743 - 1] = iArr297[i743] | iArr297[i743 - 1];
                return 0;
            case 343:
                int[] iArr298 = this.initRecordTimeStamp;
                int i744 = this.GetContactSyncConfig;
                int i745 = i744 + 1;
                this.GetContactSyncConfig = i745;
                iArr298[i744] = 31;
                iArr298[i745 - 1] = -iArr298[i745 - 1];
                return 0;
            case 344:
                int[] iArr299 = this.initRecordTimeStamp;
                int i746 = this.GetContactSyncConfig;
                int i747 = iArr299[i746 - 1];
                iArr299[i746 - 1] = iArr299[i746 - 2];
                iArr299[i746 - 2] = i747;
                int i748 = i746 - 1;
                this.GetContactSyncConfig = i748;
                this.PrepareContext[i748] = null;
                iArr299[i748 - 1] = -iArr299[i748 - 1];
                return 0;
            case 345:
                int[] iArr300 = this.initRecordTimeStamp;
                int i749 = this.GetContactSyncConfig;
                int i750 = i749 + 2;
                this.GetContactSyncConfig = i750;
                iArr300[i750 - 1] = iArr300[i750 - 3];
                iArr300[i749] = iArr300[i750 - 4];
                int i751 = i750 - 1;
                this.GetContactSyncConfig = i751;
                iArr300[i751 - 1] = iArr300[i751 - 1] | iArr300[i751];
                this.GetContactSyncConfig = i751 + 1;
                iArr300[i751] = 1;
                return 0;
            case 346:
                int i752 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i752;
                int[] iArr301 = this.initRecordTimeStamp;
                iArr301[i752 - 1] = iArr301[i752 - 1] ^ iArr301[i752];
                int i753 = i752 - 1;
                this.GetContactSyncConfig = i753;
                iArr301[i753 - 1] = iArr301[i753 - 1] - iArr301[i753];
                this.GetContactSyncConfig = i753 + 1;
                iArr301[i753] = 1;
                return 0;
            case 347:
                int[] iArr302 = this.initRecordTimeStamp;
                int i754 = this.GetContactSyncConfig;
                int i755 = i754 + 1;
                this.GetContactSyncConfig = i755;
                iArr302[i754] = 9;
                int i756 = i755 + 2;
                this.GetContactSyncConfig = i756;
                iArr302[i756 - 1] = iArr302[i756 - 3];
                iArr302[i755] = iArr302[i756 - 4];
                return 0;
            case 348:
                int i757 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i757;
                Object[] objArr41 = this.PrepareContext;
                Object obj20 = objArr41[i757];
                objArr41[i757] = null;
                objArr41[12] = obj20;
                return 0;
            case 349:
                int[] iArr303 = this.initRecordTimeStamp;
                int i758 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i758 + 1;
                iArr303[i758] = 34;
                return 0;
            case 350:
                Object[] objArr42 = this.PrepareContext;
                int i759 = this.GetContactSyncConfig;
                int i760 = i759 + 1;
                this.GetContactSyncConfig = i760;
                objArr42[i759] = objArr42[13];
                this.GetContactSyncConfig = i760 + 1;
                objArr42[i760] = objArr42[14];
                return 0;
            case 351:
                Object[] objArr43 = this.PrepareContext;
                int i761 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i761 + 1;
                objArr43[i761] = objArr43[15];
                return 0;
            case 352:
                int[] iArr304 = this.initRecordTimeStamp;
                int i762 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i762 + 1;
                iArr304[i762] = 123;
                return 0;
            case 353:
                int i763 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i763;
                int[] iArr305 = this.initRecordTimeStamp;
                iArr305[i763 - 1] = iArr305[i763 - 1] & iArr305[i763];
                int i764 = i763 - 1;
                this.GetContactSyncConfig = i764;
                iArr305[i764 - 1] = iArr305[i764 - 1] | iArr305[i764];
                int i765 = i764 + 2;
                this.GetContactSyncConfig = i765;
                iArr305[i765 - 1] = iArr305[i765 - 3];
                iArr305[i764] = iArr305[i765 - 4];
                return 0;
            case 354:
                int i766 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i766;
                Object[] objArr44 = this.PrepareContext;
                Object obj21 = objArr44[i766];
                objArr44[i766] = null;
                objArr44[11] = obj21;
                this.GetContactSyncConfig = i766 + 1;
                objArr44[i766] = objArr44[17];
                return 0;
            case 355:
                int i767 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i767;
                Object[] objArr45 = this.PrepareContext;
                Object obj22 = objArr45[i767];
                objArr45[i767] = null;
                objArr45[17] = obj22;
                return 0;
            case 356:
                Object[] objArr46 = this.PrepareContext;
                int i768 = this.GetContactSyncConfig;
                int i769 = i768 + 1;
                this.GetContactSyncConfig = i769;
                objArr46[i768] = objArr46[10];
                int i770 = i769 + 1;
                this.GetContactSyncConfig = i770;
                objArr46[i769] = objArr46[11];
                this.GetContactSyncConfig = i770 + 1;
                objArr46[i770] = objArr46[12];
                return 0;
            case 357:
                int[] iArr306 = this.initRecordTimeStamp;
                int i771 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i771 + 1;
                iArr306[i771] = 67;
                return 0;
            case 358:
                int[] iArr307 = this.initRecordTimeStamp;
                int i772 = this.GetContactSyncConfig;
                int i773 = i772 + 1;
                this.GetContactSyncConfig = i773;
                iArr307[i772] = 15;
                int i774 = i773 + 1;
                this.GetContactSyncConfig = i774;
                iArr307[i773] = iArr307[i774 - 2];
                return 0;
            case 359:
                int[] iArr308 = this.initRecordTimeStamp;
                int i775 = this.GetContactSyncConfig;
                int i776 = iArr308[i775 - 1];
                iArr308[i775 - 1] = iArr308[i775 - 2];
                iArr308[i775 - 2] = i776;
                int i777 = i775 - 1;
                this.GetContactSyncConfig = i777;
                this.PrepareContext[i777] = null;
                int i778 = i777 + 1;
                this.GetContactSyncConfig = i778;
                iArr308[i777] = iArr308[i778 - 2];
                return 0;
            case AUScreenAdaptTool.WIDTH_BASE /* 360 */:
                int i779 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i779;
                int[] iArr309 = this.initRecordTimeStamp;
                iArr309[i779 - 1] = iArr309[i779 - 1] - iArr309[i779];
                int i780 = i779 + 1;
                this.GetContactSyncConfig = i780;
                iArr309[i779] = 1;
                int i781 = i780 + 2;
                this.GetContactSyncConfig = i781;
                iArr309[i781 - 1] = iArr309[i781 - 3];
                iArr309[i780] = iArr309[i781 - 4];
                return 0;
            case 361:
                int[] iArr310 = this.initRecordTimeStamp;
                int i782 = this.GetContactSyncConfig;
                iArr310[i782 - 1] = -iArr310[i782 - 1];
                int i783 = i782 - 1;
                this.GetContactSyncConfig = i783;
                iArr310[i783 - 1] = iArr310[i783 - 1] | iArr310[i783];
                this.GetContactSyncConfig = i783 + 1;
                iArr310[i783] = 1;
                return 0;
            case 362:
                int[] iArr311 = this.initRecordTimeStamp;
                int i784 = this.GetContactSyncConfig;
                int i785 = i784 + 1;
                this.GetContactSyncConfig = i785;
                iArr311[i784] = 1;
                int i786 = i785 + 1;
                this.GetContactSyncConfig = i786;
                iArr311[i785] = iArr311[i786 - 2];
                return 0;
            case 363:
                int i787 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i787;
                Object[] objArr47 = this.PrepareContext;
                objArr47[i787] = null;
                this.GetContactSyncConfig = i787 + 1;
                objArr47[i787] = objArr47[18];
                return 0;
            case 364:
                Object[] objArr48 = this.PrepareContext;
                int i788 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i788 + 1;
                objArr48[i788] = objArr48[18];
                return 0;
            case 365:
                Object[] objArr49 = this.PrepareContext;
                int i789 = this.GetContactSyncConfig;
                int i790 = i789 + 1;
                this.GetContactSyncConfig = i790;
                objArr49[i789] = objArr49[11];
                this.GetContactSyncConfig = i790 + 1;
                objArr49[i790] = objArr49[12];
                return 0;
            case 366:
                int i791 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i791;
                Object[] objArr50 = this.PrepareContext;
                Object obj23 = objArr50[i791];
                objArr50[i791] = null;
                objArr50[11] = obj23;
                int i792 = i791 + 1;
                this.GetContactSyncConfig = i792;
                objArr50[i791] = objArr50[17];
                this.GetContactSyncConfig = i792 + 1;
                objArr50[i792] = objArr50[11];
                return 0;
            case 367:
                int i793 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i793;
                Object[] objArr51 = this.PrepareContext;
                objArr51[i793] = null;
                int i794 = i793 + 1;
                this.GetContactSyncConfig = i794;
                objArr51[i793] = objArr51[18];
                this.GetContactSyncConfig = i794 + 1;
                objArr51[i794] = objArr51[14];
                return 0;
            case 368:
                Object[] objArr52 = this.PrepareContext;
                int i795 = this.GetContactSyncConfig;
                int i796 = i795 + 1;
                this.GetContactSyncConfig = i796;
                objArr52[i795] = objArr52[18];
                int[] iArr312 = this.initRecordTimeStamp;
                this.GetContactSyncConfig = i796 + 1;
                iArr312[i796] = 1;
                return 0;
            case 369:
                int i797 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i797;
                Object[] objArr53 = this.PrepareContext;
                Object obj24 = objArr53[i797];
                objArr53[i797] = null;
                objArr53[11] = obj24;
                this.GetContactSyncConfig = i797 + 1;
                objArr53[i797] = objArr53[10];
                return 0;
            case 370:
                Object[] objArr54 = this.PrepareContext;
                int i798 = this.GetContactSyncConfig;
                int i799 = i798 + 1;
                this.GetContactSyncConfig = i799;
                objArr54[i798] = objArr54[13];
                int i800 = i799 + 1;
                this.GetContactSyncConfig = i800;
                objArr54[i799] = objArr54[14];
                this.GetContactSyncConfig = i800 + 1;
                objArr54[i800] = objArr54[18];
                return 0;
            case 371:
                int i801 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i801;
                Object[] objArr55 = this.PrepareContext;
                Object obj25 = objArr55[i801];
                objArr55[i801] = null;
                objArr55[13] = obj25;
                int i802 = i801 + 1;
                this.GetContactSyncConfig = i802;
                objArr55[i801] = objArr55[12];
                this.GetContactSyncConfig = i802 + 1;
                objArr55[i802] = objArr55[13];
                return 0;
            case 372:
                int i803 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i803;
                Object[] objArr56 = this.PrepareContext;
                Object obj26 = objArr56[i803];
                objArr56[i803] = null;
                objArr56[12] = obj26;
                this.GetContactSyncConfig = i803 + 1;
                objArr56[i803] = objArr56[10];
                return 0;
            case 373:
                int i804 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i804;
                Object[] objArr57 = this.PrepareContext;
                Object obj27 = objArr57[i804];
                objArr57[i804] = null;
                objArr57[18] = obj27;
                this.GetContactSyncConfig = i804 + 1;
                objArr57[i804] = objArr57[10];
                return 0;
            case 374:
                int i805 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i805;
                Object[] objArr58 = this.PrepareContext;
                Object obj28 = objArr58[i805];
                objArr58[i805] = null;
                objArr58[17] = obj28;
                this.GetContactSyncConfig = i805 + 1;
                objArr58[i805] = objArr58[10];
                return 0;
            case 375:
                Object[] objArr59 = this.PrepareContext;
                int i806 = this.GetContactSyncConfig;
                int i807 = i806 + 1;
                this.GetContactSyncConfig = i807;
                objArr59[i806] = objArr59[11];
                int i808 = i807 + 1;
                this.GetContactSyncConfig = i808;
                objArr59[i807] = objArr59[12];
                this.GetContactSyncConfig = i808 + 1;
                objArr59[i808] = objArr59[13];
                return 0;
            case 376:
                Object[] objArr60 = this.PrepareContext;
                int i809 = this.GetContactSyncConfig;
                int i810 = i809 + 1;
                this.GetContactSyncConfig = i810;
                objArr60[i809] = objArr60[10];
                this.GetContactSyncConfig = i810 + 1;
                objArr60[i810] = objArr60[15];
                return 0;
            case 377:
                int i811 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i811;
                Object[] objArr61 = this.PrepareContext;
                Object obj29 = objArr61[i811];
                objArr61[i811] = null;
                objArr61[18] = obj29;
                return 0;
            case 378:
                int i812 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i812;
                Object[] objArr62 = this.PrepareContext;
                Object obj30 = objArr62[i812];
                objArr62[i812] = null;
                objArr62[17] = obj30;
                this.GetContactSyncConfig = i812 + 1;
                objArr62[i812] = objArr62[18];
                return 0;
            case 379:
                int i813 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i813;
                Object[] objArr63 = this.PrepareContext;
                Object obj31 = objArr63[i813];
                objArr63[i813] = null;
                objArr63[18] = obj31;
                this.GetContactSyncConfig = i813 + 1;
                objArr63[i813] = objArr63[18];
                return 0;
            case 380:
                int[] iArr313 = this.initRecordTimeStamp;
                int i814 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i814 + 1;
                iArr313[i814] = 65;
                return 0;
            case 381:
                Object[] objArr64 = this.PrepareContext;
                int i815 = this.GetContactSyncConfig;
                int i816 = i815 + 1;
                this.GetContactSyncConfig = i816;
                objArr64[i815] = objArr64[i816 - 2];
                int i817 = i816 - 1;
                this.GetContactSyncConfig = i817;
                Object obj32 = objArr64[i817];
                objArr64[i817] = null;
                objArr64[18] = obj32;
                return 0;
            case 382:
                int i818 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i818;
                Object[] objArr65 = this.PrepareContext;
                objArr65[i818] = null;
                int i819 = i818 + 1;
                this.GetContactSyncConfig = i819;
                objArr65[i818] = objArr65[18];
                this.GetContactSyncConfig = i819 + 1;
                objArr65[i819] = objArr65[12];
                return 0;
            case 383:
                int[] iArr314 = this.initRecordTimeStamp;
                int i820 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i820 + 1;
                iArr314[i820] = 95;
                return 0;
            case 384:
                int i821 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i821;
                int[] iArr315 = this.initRecordTimeStamp;
                iArr315[i821 - 1] = iArr315[i821 - 1] | iArr315[i821];
                int i822 = i821 - 1;
                this.GetContactSyncConfig = i822;
                iArr315[i822 - 1] = iArr315[i822 - 1] & iArr315[i822];
                iArr315[i822 - 1] = -iArr315[i822 - 1];
                return 0;
            case 385:
                int[] iArr316 = this.initRecordTimeStamp;
                int i823 = this.GetContactSyncConfig;
                int i824 = i823 + 2;
                this.GetContactSyncConfig = i824;
                iArr316[i824 - 1] = iArr316[i824 - 3];
                iArr316[i823] = iArr316[i824 - 4];
                int i825 = i824 - 1;
                this.GetContactSyncConfig = i825;
                iArr316[i825 - 1] = iArr316[i825] | iArr316[i825 - 1];
                return 0;
            case 386:
                int[] iArr317 = this.initRecordTimeStamp;
                int i826 = this.GetContactSyncConfig;
                int i827 = iArr317[i826 - 1];
                iArr317[i826 - 1] = iArr317[i826 - 2];
                iArr317[i826 - 2] = i827;
                this.GetContactSyncConfig = i826 + 1;
                iArr317[i826] = -1;
                return 0;
            case 387:
                int[] iArr318 = this.initRecordTimeStamp;
                int i828 = this.GetContactSyncConfig;
                int i829 = i828 + 1;
                this.GetContactSyncConfig = i829;
                iArr318[i828] = 51;
                int i830 = i829 + 2;
                this.GetContactSyncConfig = i830;
                iArr318[i830 - 1] = iArr318[i830 - 3];
                iArr318[i829] = iArr318[i830 - 4];
                return 0;
            case 388:
                int[] iArr319 = this.initRecordTimeStamp;
                int i831 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i831 + 1;
                iArr319[i831] = 55;
                return 0;
            case 389:
                int[] iArr320 = this.initRecordTimeStamp;
                int i832 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i832 + 1;
                iArr320[i832] = 79;
                return 0;
            case 390:
                int[] iArr321 = this.initRecordTimeStamp;
                int i833 = this.GetContactSyncConfig;
                int i834 = i833 + 1;
                this.GetContactSyncConfig = i834;
                iArr321[i833] = 101;
                iArr321[i834 - 1] = -iArr321[i834 - 1];
                int i835 = i834 + 1;
                this.GetContactSyncConfig = i835;
                iArr321[i834] = iArr321[i835 - 2];
                return 0;
            case 391:
                int[] iArr322 = this.initRecordTimeStamp;
                int i836 = this.GetContactSyncConfig;
                int i837 = i836 + 1;
                this.GetContactSyncConfig = i837;
                iArr322[i836] = 1;
                int i838 = i837 + 2;
                this.GetContactSyncConfig = i838;
                iArr322[i838 - 1] = iArr322[i838 - 3];
                iArr322[i837] = iArr322[i838 - 4];
                return 0;
            case 392:
                int[] iArr323 = this.initRecordTimeStamp;
                int i839 = this.GetContactSyncConfig;
                int i840 = i839 + 1;
                this.GetContactSyncConfig = i840;
                iArr323[i839] = 99;
                int i841 = i840 + 2;
                this.GetContactSyncConfig = i841;
                iArr323[i841 - 1] = iArr323[i841 - 3];
                iArr323[i840] = iArr323[i841 - 4];
                return 0;
            case 393:
                int[] iArr324 = this.initRecordTimeStamp;
                int i842 = this.GetContactSyncConfig;
                int i843 = i842 + 1;
                this.GetContactSyncConfig = i843;
                iArr324[i842] = 0;
                int i844 = i843 - 1;
                this.GetContactSyncConfig = i844;
                iArr324[i844 - 1] = iArr324[i844 - 1] / iArr324[i844];
                return 0;
            case 394:
                int i845 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i845;
                Object[] objArr66 = this.PrepareContext;
                Object obj33 = objArr66[i845];
                objArr66[i845] = null;
                this.BuiltInFictitiousFunctionClassFactory = obj33 == null ? 1 : 0;
                return 0;
            case 395:
                int i846 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i846;
                long[] jArr4 = this.DatabaseTableConfigUtil;
                jArr4[11] = jArr4[i846];
                Object[] objArr67 = this.PrepareContext;
                this.GetContactSyncConfig = i846 + 1;
                objArr67[i846] = objArr67[10];
                return 0;
            case 396:
                long[] jArr5 = this.DatabaseTableConfigUtil;
                int i847 = this.GetContactSyncConfig;
                int i848 = i847 + 1;
                this.GetContactSyncConfig = i848;
                jArr5[i847] = jArr5[11];
                Object[] objArr68 = this.PrepareContext;
                this.GetContactSyncConfig = i848 + 1;
                objArr68[i848] = objArr68[13];
                return 0;
            case 397:
                int[] iArr325 = this.initRecordTimeStamp;
                int i849 = this.GetContactSyncConfig;
                int i850 = i849 + 1;
                this.GetContactSyncConfig = i850;
                iArr325[i849] = 87;
                iArr325[i850 - 1] = -iArr325[i850 - 1];
                int i851 = i850 + 2;
                this.GetContactSyncConfig = i851;
                iArr325[i851 - 1] = iArr325[i851 - 3];
                iArr325[i850] = iArr325[i851 - 4];
                return 0;
            case 398:
                int[] iArr326 = this.initRecordTimeStamp;
                int i852 = this.GetContactSyncConfig;
                int i853 = i852 + 1;
                this.GetContactSyncConfig = i853;
                iArr326[i852] = 31;
                int i854 = i853 + 2;
                this.GetContactSyncConfig = i854;
                iArr326[i854 - 1] = iArr326[i854 - 3];
                iArr326[i853] = iArr326[i854 - 4];
                int i855 = i854 + 2;
                this.GetContactSyncConfig = i855;
                iArr326[i855 - 1] = iArr326[i855 - 3];
                iArr326[i854] = iArr326[i855 - 4];
                return 0;
            case SecExceptionCode.SEC_ERROR_STA_UNKNOWN_ERROR /* 399 */:
                int[] iArr327 = this.initRecordTimeStamp;
                int i856 = this.GetContactSyncConfig;
                int i857 = i856 + 1;
                this.GetContactSyncConfig = i857;
                iArr327[i856] = 13;
                iArr327[i857 - 1] = -iArr327[i857 - 1];
                return 0;
            case 400:
                int i858 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i858;
                Object[] objArr69 = this.PrepareContext;
                Object obj34 = objArr69[i858];
                objArr69[i858] = null;
                objArr69[11] = obj34;
                this.GetContactSyncConfig = i858 + 1;
                objArr69[i858] = objArr69[13];
                return 0;
            case 401:
                int[] iArr328 = this.initRecordTimeStamp;
                int i859 = this.GetContactSyncConfig;
                int i860 = i859 + 2;
                this.GetContactSyncConfig = i860;
                iArr328[i860 - 1] = iArr328[i860 - 3];
                iArr328[i859] = iArr328[i860 - 4];
                int i861 = i860 + 2;
                this.GetContactSyncConfig = i861;
                iArr328[i861 - 1] = iArr328[i861 - 3];
                iArr328[i860] = iArr328[i861 - 4];
                int i862 = i861 - 1;
                this.GetContactSyncConfig = i862;
                iArr328[i862 - 1] = iArr328[i862] ^ iArr328[i862 - 1];
                return 0;
            case SecExceptionCode.SEC_ERROR_DYN_ENC_NO_MEMORY /* 402 */:
                int i863 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i863;
                int[] iArr329 = this.initRecordTimeStamp;
                iArr329[i863 - 1] = iArr329[i863 - 1] | iArr329[i863];
                iArr329[i863 - 1] = -iArr329[i863 - 1];
                return 0;
            case 403:
                int[] iArr330 = this.initRecordTimeStamp;
                int i864 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i864 + 1;
                iArr330[i864] = 78;
                return 0;
            case 404:
                int[] iArr331 = this.initRecordTimeStamp;
                int i865 = this.GetContactSyncConfig;
                int i866 = i865 + 1;
                this.GetContactSyncConfig = i866;
                iArr331[i865] = 1;
                int i867 = i866 + 2;
                this.GetContactSyncConfig = i867;
                iArr331[i867 - 1] = iArr331[i867 - 3];
                iArr331[i866] = iArr331[i867 - 4];
                int i868 = i867 - 1;
                this.GetContactSyncConfig = i868;
                iArr331[i868 - 1] = iArr331[i868] | iArr331[i868 - 1];
                return 0;
            case SecExceptionCode.SEC_ERROR_DYN_ENC_GET_ENCRYPT_KEY_FAILED /* 405 */:
                Object[] objArr70 = this.PrepareContext;
                int i869 = this.GetContactSyncConfig;
                int i870 = i869 + 1;
                this.GetContactSyncConfig = i870;
                objArr70[i869] = objArr70[i870 - 2];
                int i871 = i870 - 1;
                this.GetContactSyncConfig = i871;
                Object obj35 = objArr70[i871];
                objArr70[i871] = null;
                objArr70[16] = obj35;
                return 0;
            case SecExceptionCode.SEC_ERROR_DYN_ENC_INVALID_ENCRYPTED_DATA /* 406 */:
                int i872 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i872;
                Object[] objArr71 = this.PrepareContext;
                objArr71[i872] = null;
                this.GetContactSyncConfig = i872 + 1;
                objArr71[i872] = objArr71[16];
                return 0;
            case SecExceptionCode.SEC_ERROR_DYN_ENC_DECRYPT_MISMATCH_KEY_DATA /* 407 */:
                int[] iArr332 = this.initRecordTimeStamp;
                int i873 = this.GetContactSyncConfig;
                int i874 = i873 + 1;
                this.GetContactSyncConfig = i874;
                iArr332[i873] = 11;
                iArr332[i874 - 1] = -iArr332[i874 - 1];
                int i875 = i874 + 2;
                this.GetContactSyncConfig = i875;
                iArr332[i875 - 1] = iArr332[i875 - 3];
                iArr332[i874] = iArr332[i875 - 4];
                return 0;
            case 408:
                int[] iArr333 = this.initRecordTimeStamp;
                int i876 = this.GetContactSyncConfig;
                int i877 = i876 + 1;
                this.GetContactSyncConfig = i877;
                iArr333[i876] = 43;
                int i878 = i877 + 2;
                this.GetContactSyncConfig = i878;
                iArr333[i878 - 1] = iArr333[i878 - 3];
                iArr333[i877] = iArr333[i878 - 4];
                int i879 = i878 - 1;
                this.GetContactSyncConfig = i879;
                iArr333[i879 - 1] = iArr333[i879] & iArr333[i879 - 1];
                return 0;
            case 409:
                int[] iArr334 = this.initRecordTimeStamp;
                int i880 = this.GetContactSyncConfig;
                int i881 = i880 + 1;
                this.GetContactSyncConfig = i881;
                iArr334[i880] = 7;
                this.GetContactSyncConfig = i881 + 1;
                iArr334[i881] = 0;
                return 0;
            case 410:
                int i882 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i882;
                Object[] objArr72 = this.PrepareContext;
                objArr72[i882] = null;
                this.GetContactSyncConfig = i882 + 1;
                objArr72[i882] = objArr72[11];
                return 0;
            case 411:
                int i883 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i883;
                int[] iArr335 = this.initRecordTimeStamp;
                iArr335[i883 - 1] = iArr335[i883 - 1] | iArr335[i883];
                int i884 = i883 + 2;
                this.GetContactSyncConfig = i884;
                iArr335[i884 - 1] = iArr335[i884 - 3];
                iArr335[i883] = iArr335[i884 - 4];
                int i885 = i884 - 1;
                this.GetContactSyncConfig = i885;
                iArr335[i885 - 1] = iArr335[i885] | iArr335[i885 - 1];
                return 0;
            case 412:
                Object[] objArr73 = this.PrepareContext;
                int i886 = this.GetContactSyncConfig;
                int i887 = i886 + 1;
                this.GetContactSyncConfig = i887;
                objArr73[i886] = objArr73[i887 - 2];
                int i888 = i887 - 1;
                this.GetContactSyncConfig = i888;
                Object obj36 = objArr73[i888];
                objArr73[i888] = null;
                objArr73[11] = obj36;
                return 0;
            case 413:
                int[] iArr336 = this.initRecordTimeStamp;
                int i889 = this.GetContactSyncConfig;
                int i890 = i889 + 1;
                this.GetContactSyncConfig = i890;
                iArr336[i889] = 65;
                iArr336[i890 - 1] = -iArr336[i890 - 1];
                int i891 = i890 + 2;
                this.GetContactSyncConfig = i891;
                iArr336[i891 - 1] = iArr336[i891 - 3];
                iArr336[i890] = iArr336[i891 - 4];
                return 0;
            case 414:
                int[] iArr337 = this.initRecordTimeStamp;
                int i892 = this.GetContactSyncConfig;
                int i893 = i892 + 2;
                this.GetContactSyncConfig = i893;
                iArr337[i893 - 1] = iArr337[i893 - 3];
                iArr337[i892] = iArr337[i893 - 4];
                iArr337[i893 - 1] = -iArr337[i893 - 1];
                int i894 = i893 - 1;
                this.GetContactSyncConfig = i894;
                iArr337[i894 - 1] = iArr337[i894] & iArr337[i894 - 1];
                return 0;
            case 415:
                int[] iArr338 = this.initRecordTimeStamp;
                int i895 = this.GetContactSyncConfig;
                int i896 = i895 + 1;
                this.GetContactSyncConfig = i896;
                iArr338[i895] = 111;
                int i897 = i896 + 2;
                this.GetContactSyncConfig = i897;
                iArr338[i897 - 1] = iArr338[i897 - 3];
                iArr338[i896] = iArr338[i897 - 4];
                return 0;
            case 416:
                int[] iArr339 = this.initRecordTimeStamp;
                int i898 = this.GetContactSyncConfig;
                int i899 = i898 + 1;
                this.GetContactSyncConfig = i899;
                iArr339[i898] = 7;
                int i900 = i899 + 1;
                this.GetContactSyncConfig = i900;
                iArr339[i899] = iArr339[i900 - 2];
                this.GetContactSyncConfig = i900 + 1;
                iArr339[i900] = -1;
                return 0;
            case 417:
                int i901 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i901;
                Object[] objArr74 = this.PrepareContext;
                Object obj37 = objArr74[i901];
                objArr74[i901] = null;
                objArr74[12] = obj37;
                int i902 = i901 - 1;
                this.GetContactSyncConfig = i902;
                Object obj38 = objArr74[i902];
                objArr74[i902] = null;
                objArr74[11] = obj38;
                return 0;
            case 418:
                int[] iArr340 = this.initRecordTimeStamp;
                int i903 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i903 + 1;
                iArr340[i903] = 30;
                return 0;
            case 419:
                int[] iArr341 = this.initRecordTimeStamp;
                int i904 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i904 + 1;
                iArr341[i904] = 3;
                return 0;
            case 420:
                int i905 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i905;
                this.PrepareContext[i905] = null;
                int[] iArr342 = this.initRecordTimeStamp;
                int i906 = i905 + 2;
                this.GetContactSyncConfig = i906;
                iArr342[i906 - 1] = iArr342[i906 - 3];
                iArr342[i905] = iArr342[i906 - 4];
                int i907 = i906 - 1;
                this.GetContactSyncConfig = i907;
                iArr342[i907 - 1] = iArr342[i907] ^ iArr342[i907 - 1];
                return 0;
            case 421:
                int[] iArr343 = this.initRecordTimeStamp;
                int i908 = this.GetContactSyncConfig;
                int i909 = i908 + 1;
                this.GetContactSyncConfig = i909;
                iArr343[i908] = 103;
                int i910 = i909 + 2;
                this.GetContactSyncConfig = i910;
                iArr343[i910 - 1] = iArr343[i910 - 3];
                iArr343[i909] = iArr343[i910 - 4];
                return 0;
            case SecExceptionCode.SEC_ERROR_DYN_ENC_DECRYPT_FAILED /* 422 */:
                int[] iArr344 = this.initRecordTimeStamp;
                int i911 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i911 + 1;
                iArr344[i911] = 3;
                return 0;
            case SecExceptionCode.SEC_ERROR_DYN_ENC_BASE64_DECODE_FAILED /* 423 */:
                int[] iArr345 = this.initRecordTimeStamp;
                int i912 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i912 + 1;
                iArr345[i912] = 69;
                return 0;
            case 424:
                int[] iArr346 = this.initRecordTimeStamp;
                int i913 = this.GetContactSyncConfig;
                int i914 = i913 + 1;
                this.GetContactSyncConfig = i914;
                iArr346[i913] = 55;
                iArr346[i914 - 1] = -iArr346[i914 - 1];
                return 0;
            case 425:
                int[] iArr347 = this.initRecordTimeStamp;
                int i915 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i915 + 1;
                iArr347[i915] = 32;
                return 0;
            case 426:
                int[] iArr348 = this.initRecordTimeStamp;
                int i916 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i916 + 1;
                iArr348[i916] = 41;
                return 0;
            case 427:
                int[] iArr349 = this.initRecordTimeStamp;
                int i917 = this.GetContactSyncConfig;
                int i918 = i917 + 1;
                this.GetContactSyncConfig = i918;
                iArr349[i917] = 43;
                int i919 = i918 + 2;
                this.GetContactSyncConfig = i919;
                iArr349[i919 - 1] = iArr349[i919 - 3];
                iArr349[i918] = iArr349[i919 - 4];
                return 0;
            case 428:
                int[] iArr350 = this.initRecordTimeStamp;
                int i920 = this.GetContactSyncConfig;
                int i921 = i920 + 1;
                this.GetContactSyncConfig = i921;
                iArr350[i920] = 2;
                this.GetContactSyncConfig = i921 + 1;
                iArr350[i921] = 3;
                return 0;
            case HereOauthManager.TOO_MANY_REQUEST_CODE /* 429 */:
                int i922 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i922;
                int[] iArr351 = this.initRecordTimeStamp;
                iArr351[i922 - 1] = iArr351[i922 - 1] | iArr351[i922];
                int i923 = i922 - 1;
                this.GetContactSyncConfig = i923;
                iArr351[i923 - 1] = iArr351[i923 - 1] + iArr351[i923];
                int i924 = i923 - 1;
                this.GetContactSyncConfig = i924;
                this.PrepareContext[i924] = null;
                return 0;
            case 430:
                int i925 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i925;
                int[] iArr352 = this.initRecordTimeStamp;
                iArr352[i925 - 1] = iArr352[i925 - 1] ^ iArr352[i925];
                iArr352[i925 - 1] = -iArr352[i925 - 1];
                return 0;
            case 431:
                int[] iArr353 = this.initRecordTimeStamp;
                int i926 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i926 + 1;
                iArr353[i926] = 17;
                return 0;
            case 432:
                int[] iArr354 = this.initRecordTimeStamp;
                int i927 = this.GetContactSyncConfig;
                int i928 = i927 + 1;
                this.GetContactSyncConfig = i928;
                iArr354[i927] = 25;
                iArr354[i928 - 1] = -iArr354[i928 - 1];
                int i929 = i928 + 2;
                this.GetContactSyncConfig = i929;
                iArr354[i929 - 1] = iArr354[i929 - 3];
                iArr354[i928] = iArr354[i929 - 4];
                return 0;
            case 433:
                Object[] objArr75 = this.PrepareContext;
                int i930 = this.GetContactSyncConfig;
                int i931 = i930 + 1;
                this.GetContactSyncConfig = i931;
                objArr75[i930] = objArr75[14];
                this.GetContactSyncConfig = i931 + 1;
                objArr75[i931] = objArr75[15];
                return 0;
            case 434:
                int[] iArr355 = this.initRecordTimeStamp;
                int i932 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i932 + 1;
                iArr355[i932] = 4;
                return 0;
            case 435:
                int[] iArr356 = this.initRecordTimeStamp;
                int i933 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i933 + 1;
                iArr356[i933] = 101;
                return 0;
            case 436:
                int i934 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i934;
                Object[] objArr76 = this.PrepareContext;
                Object obj39 = objArr76[i934];
                objArr76[i934] = null;
                this.BuiltInFictitiousFunctionClassFactory = obj39 != null ? 1 : 0;
                return 0;
            case 437:
                int[] iArr357 = this.initRecordTimeStamp;
                int i935 = this.GetContactSyncConfig;
                int i936 = i935 + 1;
                this.GetContactSyncConfig = i936;
                iArr357[i935] = 19;
                int i937 = i936 - 1;
                this.GetContactSyncConfig = i937;
                iArr357[i937 - 1] = iArr357[i937 - 1] + iArr357[i937];
                int i938 = i937 + 1;
                this.GetContactSyncConfig = i938;
                iArr357[i937] = iArr357[i938 - 2];
                return 0;
            case 438:
                int i939 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i939;
                this.PrepareContext[i939] = null;
                long[] jArr6 = this.DatabaseTableConfigUtil;
                this.GetContactSyncConfig = i939 + 1;
                jArr6[i939] = jArr6[13];
                return 0;
            case 439:
                int i940 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i940;
                this.PrepareContext[i940] = null;
                int i941 = i940 - 1;
                this.GetContactSyncConfig = i941;
                int[] iArr358 = this.initRecordTimeStamp;
                iArr358[i941 - 1] = iArr358[i941] ^ iArr358[i941 - 1];
                return 0;
            case 440:
                int[] iArr359 = this.initRecordTimeStamp;
                int i942 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i942 + 1;
                iArr359[i942] = 46;
                return 0;
            case 441:
                int i943 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i943;
                long[] jArr7 = this.DatabaseTableConfigUtil;
                jArr7[13] = jArr7[i943];
                return 0;
            case 442:
                Object[] objArr77 = this.PrepareContext;
                int i944 = this.GetContactSyncConfig;
                int i945 = i944 + 1;
                this.GetContactSyncConfig = i945;
                objArr77[i944] = objArr77[11];
                long[] jArr8 = this.DatabaseTableConfigUtil;
                this.GetContactSyncConfig = i945 + 1;
                jArr8[i945] = jArr8[13];
                return 0;
            case WebSocket.DEFAULT_WSS_PORT /* 443 */:
                int[] iArr360 = this.initRecordTimeStamp;
                int i946 = this.GetContactSyncConfig;
                int i947 = i946 + 1;
                this.GetContactSyncConfig = i947;
                iArr360[i946] = 57;
                this.GetContactSyncConfig = i947 + 1;
                iArr360[i947] = 0;
                return 0;
            case 444:
                int[] iArr361 = this.initRecordTimeStamp;
                int i948 = this.GetContactSyncConfig;
                int i949 = i948 + 1;
                this.GetContactSyncConfig = i949;
                iArr361[i948] = 79;
                iArr361[i949 - 1] = -iArr361[i949 - 1];
                return 0;
            case 445:
                int[] iArr362 = this.initRecordTimeStamp;
                int i950 = this.GetContactSyncConfig;
                int i951 = iArr362[i950 - 1];
                iArr362[i950 - 1] = iArr362[i950 - 2];
                iArr362[i950 - 2] = i951;
                int i952 = i950 - 1;
                this.GetContactSyncConfig = i952;
                this.PrepareContext[i952] = null;
                int i953 = i952 + 2;
                this.GetContactSyncConfig = i953;
                iArr362[i953 - 1] = iArr362[i953 - 3];
                iArr362[i952] = iArr362[i953 - 4];
                return 0;
            case 446:
                int i954 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i954;
                int[] iArr363 = this.initRecordTimeStamp;
                iArr363[i954 - 1] = iArr363[i954 - 1] & iArr363[i954];
                int i955 = i954 - 1;
                this.GetContactSyncConfig = i955;
                iArr363[i955 - 1] = iArr363[i955 - 1] | iArr363[i955];
                int i956 = i955 - 1;
                this.GetContactSyncConfig = i956;
                iArr363[i956 - 1] = iArr363[i956 - 1] - iArr363[i956];
                return 0;
            case 447:
                int[] iArr364 = this.initRecordTimeStamp;
                int i957 = this.GetContactSyncConfig;
                int i958 = i957 + 1;
                this.GetContactSyncConfig = i958;
                iArr364[i957] = 115;
                iArr364[i958 - 1] = -iArr364[i958 - 1];
                int i959 = i958 + 2;
                this.GetContactSyncConfig = i959;
                iArr364[i959 - 1] = iArr364[i959 - 3];
                iArr364[i958] = iArr364[i959 - 4];
                return 0;
            case 448:
                int i960 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i960;
                int[] iArr365 = this.initRecordTimeStamp;
                iArr365[i960 - 1] = iArr365[i960 - 1] & iArr365[i960];
                int i961 = i960 - 1;
                this.GetContactSyncConfig = i961;
                iArr365[i961 - 1] = iArr365[i961 - 1] | iArr365[i961];
                int i962 = iArr365[i961 - 1];
                iArr365[i961 - 1] = iArr365[i961 - 2];
                iArr365[i961 - 2] = i962;
                return 0;
            case 449:
                int[] iArr366 = this.initRecordTimeStamp;
                int i963 = this.GetContactSyncConfig;
                int i964 = i963 + 1;
                this.GetContactSyncConfig = i964;
                iArr366[i963] = 97;
                iArr366[i964 - 1] = -iArr366[i964 - 1];
                int i965 = i964 + 2;
                this.GetContactSyncConfig = i965;
                iArr366[i965 - 1] = iArr366[i965 - 3];
                iArr366[i964] = iArr366[i965 - 4];
                return 0;
            case 450:
                int[] iArr367 = this.initRecordTimeStamp;
                int i966 = this.GetContactSyncConfig;
                int i967 = i966 + 1;
                this.GetContactSyncConfig = i967;
                iArr367[i966] = 99;
                iArr367[i967 - 1] = -iArr367[i967 - 1];
                int i968 = i967 + 2;
                this.GetContactSyncConfig = i968;
                iArr367[i968 - 1] = iArr367[i968 - 3];
                iArr367[i967] = iArr367[i968 - 4];
                return 0;
            case 451:
                int[] iArr368 = this.initRecordTimeStamp;
                int i969 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i969 + 1;
                iArr368[i969] = 107;
                return 0;
            case 452:
                int[] iArr369 = this.initRecordTimeStamp;
                int i970 = this.GetContactSyncConfig;
                int i971 = i970 + 1;
                this.GetContactSyncConfig = i971;
                iArr369[i970] = 17;
                iArr369[i971 - 1] = -iArr369[i971 - 1];
                int i972 = i971 + 1;
                this.GetContactSyncConfig = i972;
                iArr369[i971] = iArr369[i972 - 2];
                return 0;
            case 453:
                int[] iArr370 = this.initRecordTimeStamp;
                int i973 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i973 + 1;
                iArr370[i973] = 28;
                return 0;
            case 454:
                int[] iArr371 = this.initRecordTimeStamp;
                int i974 = this.GetContactSyncConfig;
                int i975 = i974 + 1;
                this.GetContactSyncConfig = i975;
                iArr371[i974] = 3;
                int i976 = i975 + 1;
                this.GetContactSyncConfig = i976;
                iArr371[i975] = 3;
                iArr371[i976 - 1] = -iArr371[i976 - 1];
                return 0;
            case 455:
                int i977 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i977;
                int[] iArr372 = this.initRecordTimeStamp;
                iArr372[i977 - 1] = iArr372[i977 - 1] - iArr372[i977];
                int i978 = i977 - 1;
                this.GetContactSyncConfig = i978;
                this.PrepareContext[i978] = null;
                return 0;
            case 456:
                int i979 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i979;
                this.PrepareContext[i979] = null;
                int i980 = i979 - 1;
                this.GetContactSyncConfig = i980;
                int[] iArr373 = this.initRecordTimeStamp;
                iArr373[i980 - 1] = iArr373[i980 - 1] ^ iArr373[i980];
                int i981 = i980 + 1;
                this.GetContactSyncConfig = i981;
                iArr373[i980] = iArr373[i981 - 2];
                return 0;
            case 457:
                int[] iArr374 = this.initRecordTimeStamp;
                int i982 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i982 + 1;
                iArr374[i982] = 45;
                return 0;
            case 458:
                int[] iArr375 = this.initRecordTimeStamp;
                int i983 = this.GetContactSyncConfig;
                int i984 = i983 + 1;
                this.GetContactSyncConfig = i984;
                iArr375[i983] = 37;
                int i985 = i984 + 1;
                this.GetContactSyncConfig = i985;
                iArr375[i984] = 0;
                int i986 = i985 - 1;
                this.GetContactSyncConfig = i986;
                iArr375[i986 - 1] = iArr375[i986 - 1] / iArr375[i986];
                return 0;
            case 459:
                int[] iArr376 = this.initRecordTimeStamp;
                int i987 = this.GetContactSyncConfig;
                int i988 = i987 + 1;
                this.GetContactSyncConfig = i988;
                iArr376[i987] = 73;
                int i989 = i988 + 1;
                this.GetContactSyncConfig = i989;
                iArr376[i988] = iArr376[i989 - 2];
                this.GetContactSyncConfig = i989 + 1;
                iArr376[i989] = -1;
                return 0;
            case 460:
                int[] iArr377 = this.initRecordTimeStamp;
                int i990 = this.GetContactSyncConfig;
                int i991 = i990 + 1;
                this.GetContactSyncConfig = i991;
                iArr377[i990] = 47;
                iArr377[i991 - 1] = -iArr377[i991 - 1];
                int i992 = i991 + 2;
                this.GetContactSyncConfig = i992;
                iArr377[i992 - 1] = iArr377[i992 - 3];
                iArr377[i991] = iArr377[i992 - 4];
                return 0;
            case 461:
                int[] iArr378 = this.initRecordTimeStamp;
                int i993 = this.GetContactSyncConfig;
                int i994 = i993 + 1;
                this.GetContactSyncConfig = i994;
                iArr378[i993] = 15;
                int i995 = i994 + 2;
                this.GetContactSyncConfig = i995;
                iArr378[i995 - 1] = iArr378[i995 - 3];
                iArr378[i994] = iArr378[i995 - 4];
                return 0;
            case 462:
                int[] iArr379 = this.initRecordTimeStamp;
                int i996 = this.GetContactSyncConfig;
                int i997 = i996 + 1;
                this.GetContactSyncConfig = i997;
                iArr379[i996] = 61;
                iArr379[i997 - 1] = -iArr379[i997 - 1];
                return 0;
            case 463:
                int i998 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i998;
                int[] iArr380 = this.initRecordTimeStamp;
                iArr380[i998 - 1] = iArr380[i998 - 1] | iArr380[i998];
                int i999 = i998 - 1;
                this.GetContactSyncConfig = i999;
                iArr380[i999 - 1] = iArr380[i999 - 1] - iArr380[i999];
                int i1000 = i999 + 1;
                this.GetContactSyncConfig = i1000;
                iArr380[i999] = iArr380[i1000 - 2];
                return 0;
            case 464:
                int[] iArr381 = this.initRecordTimeStamp;
                int i1001 = this.GetContactSyncConfig;
                int i1002 = i1001 + 1;
                this.GetContactSyncConfig = i1002;
                iArr381[i1001] = 3;
                this.GetContactSyncConfig = i1002 + 1;
                iArr381[i1002] = 4;
                return 0;
            case 465:
                int i1003 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i1003;
                int[] iArr382 = this.initRecordTimeStamp;
                iArr382[i1003 - 1] = iArr382[i1003 - 1] | iArr382[i1003];
                int i1004 = i1003 + 1;
                this.GetContactSyncConfig = i1004;
                iArr382[i1003] = iArr382[i1004 - 2];
                return 0;
            case 466:
                this.DatabaseTableConfigUtil[this.GetContactSyncConfig - 1] = this.initRecordTimeStamp[r2 - 1];
                return 0;
            case 467:
                int i1005 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i1005;
                long[] jArr9 = this.DatabaseTableConfigUtil;
                jArr9[15] = jArr9[i1005];
                return 0;
            case 468:
                int i1006 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i1006;
                int[] iArr383 = this.initRecordTimeStamp;
                iArr383[i1006 - 1] = iArr383[i1006 - 1] << iArr383[i1006];
                int i1007 = i1006 - 1;
                this.GetContactSyncConfig = i1007;
                this.PrepareContext[i1007] = null;
                return 0;
            case 469:
                int i1008 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i1008;
                int[] iArr384 = this.initRecordTimeStamp;
                iArr384[i1008 - 1] = iArr384[i1008 - 1] + iArr384[i1008];
                int i1009 = i1008 + 1;
                this.GetContactSyncConfig = i1009;
                iArr384[i1008] = 1;
                int i1010 = i1009 + 1;
                this.GetContactSyncConfig = i1010;
                iArr384[i1009] = iArr384[i1010 - 2];
                return 0;
            case 470:
                int[] iArr385 = this.initRecordTimeStamp;
                int i1011 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i1011 + 1;
                iArr385[i1011] = 68;
                return 0;
            case 471:
                int[] iArr386 = this.initRecordTimeStamp;
                int i1012 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i1012 + 1;
                iArr386[i1012] = 72;
                return 0;
            case 472:
                long[] jArr10 = this.DatabaseTableConfigUtil;
                int i1013 = this.GetContactSyncConfig;
                int i1014 = i1013 + 1;
                this.GetContactSyncConfig = i1014;
                jArr10[i1013] = jArr10[13];
                this.GetContactSyncConfig = i1014 + 1;
                jArr10[i1014] = jArr10[15];
                return 0;
            case 473:
                int i1015 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i1015;
                long[] jArr11 = this.DatabaseTableConfigUtil;
                jArr11[i1015 - 1] = jArr11[i1015 - 1] + jArr11[i1015];
                return 0;
            case 474:
                int i1016 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i1016;
                int[] iArr387 = this.initRecordTimeStamp;
                iArr387[i1016 - 1] = iArr387[i1016 - 1] | iArr387[i1016];
                int i1017 = i1016 + 2;
                this.GetContactSyncConfig = i1017;
                iArr387[i1017 - 1] = iArr387[i1017 - 3];
                iArr387[i1016] = iArr387[i1017 - 4];
                int i1018 = i1017 - 1;
                this.GetContactSyncConfig = i1018;
                iArr387[i1018 - 1] = iArr387[i1018] ^ iArr387[i1018 - 1];
                return 0;
            case 475:
                int[] iArr388 = this.initRecordTimeStamp;
                int i1019 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i1019 + 1;
                iArr388[i1019] = 66;
                return 0;
            case 476:
                long[] jArr12 = this.DatabaseTableConfigUtil;
                int i1020 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i1020 + 1;
                jArr12[i1020] = jArr12[13];
                return 0;
            case 477:
                long[] jArr13 = this.DatabaseTableConfigUtil;
                int i1021 = this.GetContactSyncConfig;
                int i1022 = i1021 + 1;
                this.GetContactSyncConfig = i1022;
                jArr13[i1021] = jArr13[15];
                int i1023 = i1022 - 1;
                this.GetContactSyncConfig = i1023;
                jArr13[i1023 - 1] = jArr13[i1023 - 1] & jArr13[i1023];
                return 0;
            case 478:
                int[] iArr389 = this.initRecordTimeStamp;
                int i1024 = this.GetContactSyncConfig;
                int i1025 = i1024 + 1;
                this.GetContactSyncConfig = i1025;
                iArr389[i1024] = 35;
                iArr389[i1025 - 1] = -iArr389[i1025 - 1];
                int i1026 = i1025 + 2;
                this.GetContactSyncConfig = i1026;
                iArr389[i1026 - 1] = iArr389[i1026 - 3];
                iArr389[i1025] = iArr389[i1026 - 4];
                return 0;
            case 479:
                int[] iArr390 = this.initRecordTimeStamp;
                int i1027 = this.GetContactSyncConfig;
                int i1028 = i1027 + 1;
                this.GetContactSyncConfig = i1028;
                iArr390[i1027] = 86;
                int i1029 = i1028 + 1;
                this.GetContactSyncConfig = i1029;
                iArr390[i1028] = 0;
                int i1030 = i1029 - 1;
                this.GetContactSyncConfig = i1030;
                iArr390[i1030 - 1] = iArr390[i1030 - 1] / iArr390[i1030];
                return 0;
            case 480:
                Object[] objArr78 = this.PrepareContext;
                int i1031 = this.GetContactSyncConfig;
                int i1032 = i1031 + 1;
                this.GetContactSyncConfig = i1032;
                objArr78[i1031] = objArr78[11];
                int[] iArr391 = this.initRecordTimeStamp;
                int i1033 = i1032 + 1;
                this.GetContactSyncConfig = i1033;
                iArr391[i1032] = iArr391[12];
                this.GetContactSyncConfig = i1033 + 1;
                objArr78[i1033] = objArr78[13];
                return 0;
            case 481:
                int[] iArr392 = this.initRecordTimeStamp;
                int i1034 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i1034 + 1;
                iArr392[i1034] = 125;
                return 0;
            case 482:
                int[] iArr393 = this.initRecordTimeStamp;
                int i1035 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i1035 + 1;
                iArr393[i1035] = 62;
                return 0;
            case 483:
                int[] iArr394 = this.initRecordTimeStamp;
                int i1036 = this.GetContactSyncConfig;
                int i1037 = i1036 + 1;
                this.GetContactSyncConfig = i1037;
                iArr394[i1036] = iArr394[12];
                Object[] objArr79 = this.PrepareContext;
                this.GetContactSyncConfig = i1037 + 1;
                objArr79[i1037] = objArr79[13];
                return 0;
            case 484:
                int[] iArr395 = this.initRecordTimeStamp;
                int i1038 = this.GetContactSyncConfig;
                int i1039 = i1038 + 1;
                this.GetContactSyncConfig = i1039;
                iArr395[i1038] = 81;
                iArr395[i1039 - 1] = -iArr395[i1039 - 1];
                int i1040 = i1039 + 2;
                this.GetContactSyncConfig = i1040;
                iArr395[i1040 - 1] = iArr395[i1040 - 3];
                iArr395[i1039] = iArr395[i1040 - 4];
                return 0;
            case 485:
                int i1041 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i1041;
                Object[] objArr80 = this.PrepareContext;
                Object obj40 = objArr80[i1041];
                objArr80[i1041] = null;
                objArr80[13] = obj40;
                this.GetContactSyncConfig = i1041 + 1;
                objArr80[i1041] = objArr80[10];
                return 0;
            case 486:
                int[] iArr396 = this.initRecordTimeStamp;
                int i1042 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i1042 + 1;
                iArr396[i1042] = iArr396[12];
                return 0;
            case 487:
                int[] iArr397 = this.initRecordTimeStamp;
                int i1043 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i1043 + 1;
                iArr397[i1043] = 13;
                return 0;
            case 488:
                int[] iArr398 = this.initRecordTimeStamp;
                int i1044 = this.GetContactSyncConfig;
                iArr398[i1044 - 1] = -iArr398[i1044 - 1];
                int i1045 = i1044 + 2;
                this.GetContactSyncConfig = i1045;
                iArr398[i1045 - 1] = iArr398[i1045 - 3];
                iArr398[i1044] = iArr398[i1045 - 4];
                int i1046 = i1045 - 1;
                this.GetContactSyncConfig = i1046;
                iArr398[i1046 - 1] = iArr398[i1046] | iArr398[i1046 - 1];
                return 0;
            case 489:
                int i1047 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i1047;
                Object[] objArr81 = this.PrepareContext;
                Object obj41 = objArr81[i1047];
                objArr81[i1047] = null;
                objArr81[19] = obj41;
                this.GetContactSyncConfig = i1047 + 1;
                objArr81[i1047] = objArr81[16];
                return 0;
            case 490:
                int i1048 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i1048;
                Object[] objArr82 = this.PrepareContext;
                Object obj42 = objArr82[i1048];
                objArr82[i1048] = null;
                objArr82[16] = obj42;
                return 0;
            case 491:
                int i1049 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i1049;
                Object[] objArr83 = this.PrepareContext;
                Object obj43 = objArr83[i1049];
                objArr83[i1049] = null;
                objArr83[18] = obj43;
                int i1050 = i1049 + 1;
                this.GetContactSyncConfig = i1050;
                objArr83[i1049] = objArr83[10];
                this.GetContactSyncConfig = i1050 + 1;
                objArr83[i1050] = objArr83[11];
                return 0;
            case 492:
                int[] iArr399 = this.initRecordTimeStamp;
                int i1051 = this.GetContactSyncConfig;
                int i1052 = i1051 + 1;
                this.GetContactSyncConfig = i1052;
                iArr399[i1051] = 105;
                iArr399[i1052 - 1] = -iArr399[i1052 - 1];
                return 0;
            case 493:
                int[] iArr400 = this.initRecordTimeStamp;
                int i1053 = this.GetContactSyncConfig;
                int i1054 = i1053 + 1;
                this.GetContactSyncConfig = i1054;
                iArr400[i1053] = 9;
                int i1055 = i1054 - 1;
                this.GetContactSyncConfig = i1055;
                iArr400[i1055 - 1] = iArr400[i1055 - 1] + iArr400[i1055];
                int i1056 = i1055 + 1;
                this.GetContactSyncConfig = i1056;
                iArr400[i1055] = iArr400[i1056 - 2];
                return 0;
            case 494:
                int i1057 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i1057;
                Object[] objArr84 = this.PrepareContext;
                Object obj44 = objArr84[i1057];
                objArr84[i1057] = null;
                objArr84[19] = obj44;
                return 0;
            case 495:
                int i1058 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i1058;
                Object[] objArr85 = this.PrepareContext;
                Object obj45 = objArr85[i1058];
                objArr85[i1058] = null;
                objArr85[16] = obj45;
                this.GetContactSyncConfig = i1058 + 1;
                objArr85[i1058] = objArr85[18];
                return 0;
            case 496:
                int[] iArr401 = this.initRecordTimeStamp;
                int i1059 = this.GetContactSyncConfig;
                int i1060 = i1059 + 1;
                this.GetContactSyncConfig = i1060;
                iArr401[i1059] = 49;
                int i1061 = i1060 + 1;
                this.GetContactSyncConfig = i1061;
                iArr401[i1060] = 0;
                int i1062 = i1061 - 1;
                this.GetContactSyncConfig = i1062;
                iArr401[i1062 - 1] = iArr401[i1062 - 1] / iArr401[i1062];
                return 0;
            case 497:
                Object[] objArr86 = this.PrepareContext;
                int i1063 = this.GetContactSyncConfig;
                int i1064 = i1063 + 1;
                this.GetContactSyncConfig = i1064;
                objArr86[i1063] = objArr86[12];
                int i1065 = i1064 + 1;
                this.GetContactSyncConfig = i1065;
                objArr86[i1064] = objArr86[17];
                this.GetContactSyncConfig = i1065 + 1;
                objArr86[i1065] = objArr86[13];
                return 0;
            case 498:
                Object[] objArr87 = this.PrepareContext;
                int i1066 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i1066 + 1;
                objArr87[i1066] = objArr87[19];
                return 0;
            case SecExceptionCode.SEC_ERROR_DYN_ENC_UNKNOWN_ERROR /* 499 */:
                Object[] objArr88 = this.PrepareContext;
                int i1067 = this.GetContactSyncConfig;
                int i1068 = i1067 + 1;
                this.GetContactSyncConfig = i1068;
                objArr88[i1067] = objArr88[10];
                int i1069 = i1068 + 1;
                this.GetContactSyncConfig = i1069;
                objArr88[i1068] = objArr88[15];
                this.GetContactSyncConfig = i1069 + 1;
                objArr88[i1069] = objArr88[11];
                return 0;
            case 500:
                Object[] objArr89 = this.PrepareContext;
                int i1070 = this.GetContactSyncConfig;
                int i1071 = i1070 + 1;
                this.GetContactSyncConfig = i1071;
                objArr89[i1070] = objArr89[15];
                this.GetContactSyncConfig = i1071 + 1;
                objArr89[i1071] = objArr89[11];
                return 0;
            case 501:
                int i1072 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i1072;
                int[] iArr402 = this.initRecordTimeStamp;
                iArr402[i1072 - 1] = iArr402[i1072 - 1] ^ iArr402[i1072];
                int i1073 = i1072 + 2;
                this.GetContactSyncConfig = i1073;
                iArr402[i1073 - 1] = iArr402[i1073 - 3];
                iArr402[i1072] = iArr402[i1073 - 4];
                return 0;
            case 502:
                int i1074 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i1074;
                int[] iArr403 = this.initRecordTimeStamp;
                iArr403[i1074 - 1] = iArr403[i1074 - 1] << iArr403[i1074];
                iArr403[i1074 - 1] = -iArr403[i1074 - 1];
                int i1075 = i1074 + 1;
                this.GetContactSyncConfig = i1075;
                iArr403[i1074] = iArr403[i1075 - 2];
                return 0;
            case 503:
                int[] iArr404 = this.initRecordTimeStamp;
                int i1076 = this.GetContactSyncConfig;
                int i1077 = i1076 + 1;
                this.GetContactSyncConfig = i1077;
                iArr404[i1076] = 14;
                int i1078 = i1077 + 1;
                this.GetContactSyncConfig = i1078;
                iArr404[i1077] = 0;
                int i1079 = i1078 - 1;
                this.GetContactSyncConfig = i1079;
                iArr404[i1079 - 1] = iArr404[i1079 - 1] / iArr404[i1079];
                return 0;
            case SecExceptionCode.SEC_ERROR_DYN_STORE_GET_DATA_FILE_KEY_FAILED /* 504 */:
                int[] iArr405 = this.initRecordTimeStamp;
                int i1080 = this.GetContactSyncConfig;
                int i1081 = i1080 + 1;
                this.GetContactSyncConfig = i1081;
                iArr405[i1080] = 99;
                iArr405[i1081 - 1] = -iArr405[i1081 - 1];
                return 0;
            case SecExceptionCode.SEC_ERROR_DYN_STORE_GET_ENCRYPT_KEY_FAILED /* 505 */:
                int[] iArr406 = this.initRecordTimeStamp;
                int i1082 = this.GetContactSyncConfig;
                int i1083 = i1082 + 1;
                this.GetContactSyncConfig = i1083;
                iArr406[i1082] = 23;
                iArr406[i1083 - 1] = -iArr406[i1083 - 1];
                return 0;
            case 506:
                int[] iArr407 = this.initRecordTimeStamp;
                int i1084 = this.GetContactSyncConfig;
                int i1085 = i1084 + 1;
                this.GetContactSyncConfig = i1085;
                iArr407[i1084] = 40;
                this.GetContactSyncConfig = i1085 + 1;
                iArr407[i1085] = 0;
                return 0;
            case 507:
                int[] iArr408 = this.initRecordTimeStamp;
                int i1086 = this.GetContactSyncConfig;
                int i1087 = i1086 + 1;
                this.GetContactSyncConfig = i1087;
                iArr408[i1086] = 85;
                iArr408[i1087 - 1] = -iArr408[i1087 - 1];
                return 0;
            case SecExceptionCode.SEC_ERROR_DYN_STORE_DDPEX_KEY_VALUE_NOT_EXSIT /* 508 */:
                int[] iArr409 = this.initRecordTimeStamp;
                int i1088 = this.GetContactSyncConfig;
                int i1089 = i1088 + 1;
                this.GetContactSyncConfig = i1089;
                iArr409[i1088] = 81;
                int i1090 = i1089 + 2;
                this.GetContactSyncConfig = i1090;
                iArr409[i1090 - 1] = iArr409[i1090 - 3];
                iArr409[i1089] = iArr409[i1090 - 4];
                return 0;
            case 509:
                int i1091 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i1091;
                this.PrepareContext[i1091] = null;
                int i1092 = i1091 - 1;
                this.GetContactSyncConfig = i1092;
                int[] iArr410 = this.initRecordTimeStamp;
                iArr410[i1092 - 1] = iArr410[i1092 - 1] | iArr410[i1092];
                iArr410[i1092 - 1] = -iArr410[i1092 - 1];
                return 0;
            case 510:
                int[] iArr411 = this.initRecordTimeStamp;
                int i1093 = this.GetContactSyncConfig;
                int i1094 = i1093 + 1;
                this.GetContactSyncConfig = i1094;
                iArr411[i1093] = 75;
                iArr411[i1094 - 1] = -iArr411[i1094 - 1];
                return 0;
            case 511:
                int[] iArr412 = this.initRecordTimeStamp;
                int i1095 = this.GetContactSyncConfig;
                iArr412[i1095 - 1] = -iArr412[i1095 - 1];
                int i1096 = i1095 + 1;
                this.GetContactSyncConfig = i1096;
                iArr412[i1095] = -1;
                int i1097 = i1096 + 2;
                this.GetContactSyncConfig = i1097;
                iArr412[i1097 - 1] = iArr412[i1097 - 3];
                iArr412[i1096] = iArr412[i1097 - 4];
                return 0;
            case 512:
                int i1098 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i1098;
                int[] iArr413 = this.initRecordTimeStamp;
                iArr413[i1098 - 1] = iArr413[i1098 - 1] | iArr413[i1098];
                int i1099 = i1098 - 1;
                this.GetContactSyncConfig = i1099;
                iArr413[i1099 - 1] = iArr413[i1099 - 1] & iArr413[i1099];
                int i1100 = iArr413[i1099 - 1];
                iArr413[i1099 - 1] = iArr413[i1099 - 2];
                iArr413[i1099 - 2] = i1100;
                return 0;
            case DeepRecoverARiverProxy.TYPE_EXCEPTION_WHITE_SCREEN /* 513 */:
                int[] iArr414 = this.initRecordTimeStamp;
                int i1101 = this.GetContactSyncConfig;
                int i1102 = i1101 + 1;
                this.GetContactSyncConfig = i1102;
                iArr414[i1101] = 15;
                iArr414[i1102 - 1] = -iArr414[i1102 - 1];
                return 0;
            case DeepRecoverARiverProxy.TYPE_EXCEPTION_CANNOT_OPEN_APP /* 514 */:
                int[] iArr415 = this.initRecordTimeStamp;
                int i1103 = this.GetContactSyncConfig;
                int i1104 = i1103 + 1;
                this.GetContactSyncConfig = i1104;
                iArr415[i1103] = 69;
                int i1105 = i1104 + 2;
                this.GetContactSyncConfig = i1105;
                iArr415[i1105 - 1] = iArr415[i1105 - 3];
                iArr415[i1104] = iArr415[i1105 - 4];
                return 0;
            case DeepRecoverARiverProxy.TYPE_EXCEPTION_CANNOT_OPEN_PAGE /* 515 */:
                int[] iArr416 = this.initRecordTimeStamp;
                int i1106 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i1106 + 1;
                iArr416[i1106] = 8;
                return 0;
            case DeepRecoverARiverProxy.TYPE_EXCEPTION_CANNOT_CRASH_PAGE /* 516 */:
                int[] iArr417 = this.initRecordTimeStamp;
                int i1107 = this.GetContactSyncConfig;
                int i1108 = i1107 + 1;
                this.GetContactSyncConfig = i1108;
                iArr417[i1107] = 77;
                int i1109 = i1108 + 2;
                this.GetContactSyncConfig = i1109;
                iArr417[i1109 - 1] = iArr417[i1109 - 3];
                iArr417[i1108] = iArr417[i1109 - 4];
                int i1110 = i1109 + 2;
                this.GetContactSyncConfig = i1110;
                iArr417[i1110 - 1] = iArr417[i1110 - 3];
                iArr417[i1109] = iArr417[i1110 - 4];
                return 0;
            case DeepRecoverARiverProxy.TYPE_EXCEPTION_CANNOT_CRASH_APP /* 517 */:
                int[] iArr418 = this.initRecordTimeStamp;
                int i1111 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i1111 + 1;
                iArr418[i1111] = 4;
                return 0;
            case 518:
                Object[] objArr90 = this.PrepareContext;
                int i1112 = this.GetContactSyncConfig;
                int i1113 = i1112 + 1;
                this.GetContactSyncConfig = i1113;
                objArr90[i1112] = objArr90[13];
                int i1114 = i1113 + 1;
                this.GetContactSyncConfig = i1114;
                objArr90[i1113] = objArr90[14];
                this.GetContactSyncConfig = i1114 + 1;
                objArr90[i1114] = objArr90[15];
                return 0;
            case 519:
                int i1115 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i1115;
                Object[] objArr91 = this.PrepareContext;
                Object obj46 = objArr91[i1115];
                objArr91[i1115] = null;
                objArr91[12] = obj46;
                int i1116 = i1115 + 1;
                this.GetContactSyncConfig = i1116;
                objArr91[i1115] = objArr91[18];
                this.GetContactSyncConfig = i1116 + 1;
                objArr91[i1116] = objArr91[12];
                return 0;
            case 520:
                int i1117 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i1117;
                Object[] objArr92 = this.PrepareContext;
                Object obj47 = objArr92[i1117];
                objArr92[i1117] = null;
                objArr92[15] = obj47;
                this.GetContactSyncConfig = i1117 + 1;
                objArr92[i1117] = objArr92[12];
                return 0;
            case 521:
                int[] iArr419 = this.initRecordTimeStamp;
                int i1118 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i1118 + 1;
                iArr419[i1118] = 74;
                return 0;
            case 522:
                Object[] objArr93 = this.PrepareContext;
                int i1119 = this.GetContactSyncConfig;
                int i1120 = i1119 + 1;
                this.GetContactSyncConfig = i1120;
                objArr93[i1119] = objArr93[10];
                int i1121 = i1120 + 1;
                this.GetContactSyncConfig = i1121;
                objArr93[i1120] = objArr93[11];
                this.GetContactSyncConfig = i1121 + 1;
                objArr93[i1121] = objArr93[13];
                return 0;
            case 523:
                int i1122 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i1122;
                int[] iArr420 = this.initRecordTimeStamp;
                iArr420[i1122 - 1] = iArr420[i1122 - 1] | iArr420[i1122];
                int i1123 = i1122 - 1;
                this.GetContactSyncConfig = i1123;
                iArr420[i1123 - 1] = iArr420[i1123 - 1] - iArr420[i1123];
                return 0;
            case 524:
                int[] iArr421 = this.initRecordTimeStamp;
                int i1124 = this.GetContactSyncConfig;
                int i1125 = i1124 + 1;
                this.GetContactSyncConfig = i1125;
                iArr421[i1124] = 125;
                iArr421[i1125 - 1] = -iArr421[i1125 - 1];
                int i1126 = i1125 + 2;
                this.GetContactSyncConfig = i1126;
                iArr421[i1126 - 1] = iArr421[i1126 - 3];
                iArr421[i1125] = iArr421[i1126 - 4];
                return 0;
            case 525:
                int[] iArr422 = this.initRecordTimeStamp;
                int i1127 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i1127 + 1;
                iArr422[i1127] = 38;
                return 0;
            case 526:
                int[] iArr423 = this.initRecordTimeStamp;
                int i1128 = this.GetContactSyncConfig;
                int i1129 = i1128 + 1;
                this.GetContactSyncConfig = i1129;
                iArr423[i1128] = 4;
                this.GetContactSyncConfig = i1129 + 1;
                iArr423[i1129] = 0;
                return 0;
            case 527:
                int[] iArr424 = this.initRecordTimeStamp;
                int i1130 = this.GetContactSyncConfig;
                int i1131 = i1130 + 1;
                this.GetContactSyncConfig = i1131;
                iArr424[i1130] = 1;
                int i1132 = i1131 + 2;
                this.GetContactSyncConfig = i1132;
                iArr424[i1132 - 1] = iArr424[i1132 - 3];
                iArr424[i1131] = iArr424[i1132 - 4];
                return 0;
            case 528:
                int[] iArr425 = this.initRecordTimeStamp;
                int i1133 = this.GetContactSyncConfig;
                int i1134 = i1133 + 1;
                this.GetContactSyncConfig = i1134;
                iArr425[i1133] = 105;
                int i1135 = i1134 - 1;
                this.GetContactSyncConfig = i1135;
                iArr425[i1135 - 1] = iArr425[i1135 - 1] + iArr425[i1135];
                int i1136 = i1135 + 1;
                this.GetContactSyncConfig = i1136;
                iArr425[i1135] = iArr425[i1136 - 2];
                return 0;
            case 529:
                int[] iArr426 = this.initRecordTimeStamp;
                int i1137 = this.GetContactSyncConfig;
                int i1138 = i1137 + 1;
                this.GetContactSyncConfig = i1138;
                iArr426[i1137] = 113;
                int i1139 = i1138 - 1;
                this.GetContactSyncConfig = i1139;
                iArr426[i1139 - 1] = iArr426[i1139 - 1] + iArr426[i1139];
                return 0;
            case 530:
                int[] iArr427 = this.initRecordTimeStamp;
                int i1140 = this.GetContactSyncConfig;
                int i1141 = i1140 + 1;
                this.GetContactSyncConfig = i1141;
                iArr427[i1140] = 83;
                iArr427[i1141 - 1] = -iArr427[i1141 - 1];
                int i1142 = i1141 + 2;
                this.GetContactSyncConfig = i1142;
                iArr427[i1142 - 1] = iArr427[i1142 - 3];
                iArr427[i1141] = iArr427[i1142 - 4];
                return 0;
            case 531:
                int i1143 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i1143;
                Object[] objArr94 = this.PrepareContext;
                Object obj48 = objArr94[i1143];
                objArr94[i1143] = null;
                objArr94[16] = obj48;
                this.GetContactSyncConfig = i1143 + 1;
                objArr94[i1143] = objArr94[15];
                return 0;
            case 532:
                int i1144 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i1144;
                Object[] objArr95 = this.PrepareContext;
                Object obj49 = objArr95[i1144];
                objArr95[i1144] = null;
                objArr95[17] = obj49;
                this.GetContactSyncConfig = i1144 + 1;
                objArr95[i1144] = objArr95[15];
                return 0;
            case 533:
                int i1145 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i1145;
                Object[] objArr96 = this.PrepareContext;
                Object obj50 = objArr96[i1145];
                objArr96[i1145] = null;
                objArr96[16] = obj50;
                this.GetContactSyncConfig = i1145 + 1;
                objArr96[i1145] = objArr96[10];
                return 0;
            case 534:
                int[] iArr428 = this.initRecordTimeStamp;
                int i1146 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i1146 + 1;
                iArr428[i1146] = 10;
                return 0;
            case 535:
                int[] iArr429 = this.initRecordTimeStamp;
                int i1147 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i1147 + 1;
                iArr429[i1147] = 18;
                return 0;
            case 536:
                Object[] objArr97 = this.PrepareContext;
                int i1148 = this.GetContactSyncConfig;
                int i1149 = i1148 + 1;
                this.GetContactSyncConfig = i1149;
                objArr97[i1148] = objArr97[13];
                int i1150 = i1149 + 1;
                this.GetContactSyncConfig = i1150;
                objArr97[i1149] = objArr97[14];
                this.GetContactSyncConfig = i1150 + 1;
                objArr97[i1150] = objArr97[16];
                return 0;
            case 537:
                Object[] objArr98 = this.PrepareContext;
                int i1151 = this.GetContactSyncConfig;
                int i1152 = i1151 + 1;
                this.GetContactSyncConfig = i1152;
                objArr98[i1151] = null;
                this.GetContactSyncConfig = i1152 + 1;
                objArr98[i1152] = objArr98[16];
                return 0;
            case 538:
                int[] iArr430 = this.initRecordTimeStamp;
                int i1153 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i1153 + 1;
                iArr430[i1153] = 25;
                return 0;
            case 539:
                int[] iArr431 = this.initRecordTimeStamp;
                int i1154 = this.GetContactSyncConfig;
                int i1155 = i1154 + 1;
                this.GetContactSyncConfig = i1155;
                iArr431[i1154] = 77;
                iArr431[i1155 - 1] = -iArr431[i1155 - 1];
                int i1156 = i1155 + 2;
                this.GetContactSyncConfig = i1156;
                iArr431[i1156 - 1] = iArr431[i1156 - 3];
                iArr431[i1155] = iArr431[i1156 - 4];
                return 0;
            case 540:
                int i1157 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i1157;
                int[] iArr432 = this.initRecordTimeStamp;
                iArr432[12] = iArr432[i1157];
                return 0;
            case 541:
                Object[] objArr99 = this.PrepareContext;
                int i1158 = this.GetContactSyncConfig;
                int i1159 = i1158 + 1;
                this.GetContactSyncConfig = i1159;
                objArr99[i1158] = objArr99[13];
                int i1160 = i1159 + 1;
                this.GetContactSyncConfig = i1160;
                objArr99[i1159] = objArr99[14];
                this.GetContactSyncConfig = i1160 + 1;
                objArr99[i1160] = objArr99[11];
                return 0;
            case 542:
                int i1161 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i1161;
                Object[] objArr100 = this.PrepareContext;
                Object obj51 = objArr100[i1161];
                objArr100[i1161] = null;
                objArr100[15] = obj51;
                return 0;
            case 543:
                Object[] objArr101 = this.PrepareContext;
                int i1162 = this.GetContactSyncConfig;
                int i1163 = i1162 + 1;
                this.GetContactSyncConfig = i1163;
                objArr101[i1162] = objArr101[15];
                int[] iArr433 = this.initRecordTimeStamp;
                this.GetContactSyncConfig = i1163 + 1;
                iArr433[i1163] = iArr433[12];
                return 0;
            case 544:
                Object[] objArr102 = this.PrepareContext;
                int i1164 = this.GetContactSyncConfig;
                int i1165 = i1164 + 1;
                this.GetContactSyncConfig = i1165;
                objArr102[i1164] = objArr102[i1165 - 2];
                int i1166 = i1165 - 1;
                this.GetContactSyncConfig = i1166;
                Object obj52 = objArr102[i1166];
                objArr102[i1166] = null;
                objArr102[13] = obj52;
                return 0;
            case 545:
                int i1167 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i1167;
                int[] iArr434 = this.initRecordTimeStamp;
                iArr434[12] = iArr434[i1167];
                Object[] objArr103 = this.PrepareContext;
                this.GetContactSyncConfig = i1167 + 1;
                objArr103[i1167] = objArr103[13];
                return 0;
            case 546:
                Object[] objArr104 = this.PrepareContext;
                int i1168 = this.GetContactSyncConfig;
                int i1169 = i1168 + 1;
                this.GetContactSyncConfig = i1169;
                objArr104[i1168] = objArr104[14];
                this.GetContactSyncConfig = i1169 + 1;
                objArr104[i1169] = objArr104[11];
                return 0;
            case 547:
                int[] iArr435 = this.initRecordTimeStamp;
                int i1170 = this.GetContactSyncConfig;
                int i1171 = i1170 + 1;
                this.GetContactSyncConfig = i1171;
                iArr435[i1170] = 123;
                int i1172 = i1171 + 2;
                this.GetContactSyncConfig = i1172;
                iArr435[i1172 - 1] = iArr435[i1172 - 3];
                iArr435[i1171] = iArr435[i1172 - 4];
                int i1173 = i1172 + 2;
                this.GetContactSyncConfig = i1173;
                iArr435[i1173 - 1] = iArr435[i1173 - 3];
                iArr435[i1172] = iArr435[i1173 - 4];
                return 0;
            case 548:
                int[] iArr436 = this.initRecordTimeStamp;
                int i1174 = this.GetContactSyncConfig;
                int i1175 = i1174 + 1;
                this.GetContactSyncConfig = i1175;
                iArr436[i1174] = 29;
                iArr436[i1175 - 1] = -iArr436[i1175 - 1];
                return 0;
            case 549:
                int i1176 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i1176;
                int[] iArr437 = this.initRecordTimeStamp;
                iArr437[i1176 - 1] = iArr437[i1176 - 1] ^ iArr437[i1176];
                iArr437[i1176 - 1] = -iArr437[i1176 - 1];
                int i1177 = i1176 + 1;
                this.GetContactSyncConfig = i1177;
                iArr437[i1176] = iArr437[i1177 - 2];
                return 0;
            case 550:
                int i1178 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i1178;
                Object[] objArr105 = this.PrepareContext;
                Object obj53 = objArr105[i1178];
                objArr105[i1178] = null;
                objArr105[11] = obj53;
                int i1179 = i1178 + 1;
                this.GetContactSyncConfig = i1179;
                objArr105[i1178] = objArr105[12];
                this.GetContactSyncConfig = i1179 + 1;
                objArr105[i1179] = objArr105[11];
                return 0;
            case 551:
                int[] iArr438 = this.initRecordTimeStamp;
                int i1180 = this.GetContactSyncConfig;
                int i1181 = i1180 + 1;
                this.GetContactSyncConfig = i1181;
                iArr438[i1180] = 19;
                int i1182 = i1181 + 1;
                this.GetContactSyncConfig = i1182;
                iArr438[i1181] = iArr438[i1182 - 2];
                return 0;
            case 552:
                int[] iArr439 = this.initRecordTimeStamp;
                int i1183 = this.GetContactSyncConfig;
                int i1184 = i1183 + 1;
                this.GetContactSyncConfig = i1184;
                iArr439[i1183] = 77;
                int i1185 = i1184 + 1;
                this.GetContactSyncConfig = i1185;
                iArr439[i1184] = iArr439[i1185 - 2];
                return 0;
            case 553:
                Object[] objArr106 = this.PrepareContext;
                int i1186 = this.GetContactSyncConfig;
                int i1187 = i1186 + 1;
                this.GetContactSyncConfig = i1187;
                objArr106[i1186] = objArr106[11];
                int[] iArr440 = this.initRecordTimeStamp;
                this.GetContactSyncConfig = i1187 + 1;
                iArr440[i1187] = iArr440[12];
                return 0;
            case 554:
                int i1188 = this.GetContactSyncConfig - 1;
                this.GetContactSyncConfig = i1188;
                Object[] objArr107 = this.PrepareContext;
                Object obj54 = objArr107[i1188];
                objArr107[i1188] = null;
                objArr107[11] = obj54;
                int i1189 = i1188 + 1;
                this.GetContactSyncConfig = i1189;
                objArr107[i1188] = objArr107[13];
                this.GetContactSyncConfig = i1189 + 1;
                objArr107[i1189] = objArr107[11];
                return 0;
            case 555:
                int[] iArr441 = this.initRecordTimeStamp;
                int i1190 = this.GetContactSyncConfig;
                this.GetContactSyncConfig = i1190 + 1;
                iArr441[i1190] = 54;
                return 0;
            case 556:
                int[] iArr442 = this.initRecordTimeStamp;
                int i1191 = this.GetContactSyncConfig;
                int i1192 = i1191 + 1;
                this.GetContactSyncConfig = i1192;
                iArr442[i1191] = 101;
                int i1193 = i1192 + 2;
                this.GetContactSyncConfig = i1193;
                iArr442[i1193 - 1] = iArr442[i1193 - 3];
                iArr442[i1192] = iArr442[i1193 - 4];
                int i1194 = i1193 + 2;
                this.GetContactSyncConfig = i1194;
                iArr442[i1194 - 1] = iArr442[i1194 - 3];
                iArr442[i1193] = iArr442[i1194 - 4];
                return 0;
            case 557:
                Object[] objArr108 = this.PrepareContext;
                int i1195 = this.GetContactSyncConfig;
                int i1196 = i1195 + 1;
                this.GetContactSyncConfig = i1196;
                objArr108[i1195] = objArr108[13];
                this.GetContactSyncConfig = i1196 + 1;
                objArr108[i1196] = objArr108[11];
                return 0;
            case 558:
                int[] iArr443 = this.initRecordTimeStamp;
                int i1197 = this.GetContactSyncConfig;
                int i1198 = i1197 + 1;
                this.GetContactSyncConfig = i1198;
                iArr443[i1197] = 3;
                int i1199 = i1198 + 1;
                this.GetContactSyncConfig = i1199;
                iArr443[i1198] = iArr443[i1199 - 2];
                return 0;
            case 559:
                Object[] objArr109 = this.PrepareContext;
                int i1200 = this.GetContactSyncConfig;
                int i1201 = i1200 + 1;
                this.GetContactSyncConfig = i1201;
                objArr109[i1200] = objArr109[10];
                int i1202 = i1201 + 1;
                this.GetContactSyncConfig = i1202;
                objArr109[i1201] = objArr109[11];
                int[] iArr444 = this.initRecordTimeStamp;
                this.GetContactSyncConfig = i1202 + 1;
                iArr444[i1202] = iArr444[12];
                return 0;
            default:
                return i;
        }
        return 0;
    }
}
