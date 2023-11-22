package o;

import com.alibaba.ariver.engine.common.track.recovery.DeepRecoverARiverProxy;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.image.framework.utils.FileUtils;
import com.alibaba.griver.ui.ant.utils.AUScreenAdaptTool;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.android.phone.mobilesdk.socketcraft.api.WSContextConstant;
import com.alipay.iap.android.aplog.util.zip.LZMA_Base;
import com.alipay.mobile.verifyidentity.business.securitycommon.widget.WheelView;
import com.alipay.zoloz.toyger.blob.BlobStatic;

/* loaded from: classes4.dex */
public class murmurHash64WithSeed {
    public long BuiltInFictitiousFunctionClassFactory;
    private final float[] DatabaseTableConfigUtil;
    private final int[] GetContactSyncConfig;
    public int KClassImpl$Data$declaredNonStaticMembers$2;
    public long MyBillsEntityDataFactory;
    public double NetworkUserEntityData$$ExternalSyntheticLambda0;
    private int NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final long[] NetworkUserEntityData$$ExternalSyntheticLambda2;
    public float PlaceComponentResult;
    private final Object[] PrepareContext;
    public int getAuthRequestContext;
    public double getErrorConfigVersion;
    private int initRecordTimeStamp;
    private final double[] isLayoutRequested;
    public float lookAheadTest;
    public Object moveToNextValue;
    public Object scheduleImpl;

    public murmurHash64WithSeed(Object obj) {
        this.GetContactSyncConfig = new int[17];
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new long[17];
        this.DatabaseTableConfigUtil = new float[17];
        this.isLayoutRequested = new double[17];
        Object[] objArr = new Object[17];
        this.PrepareContext = objArr;
        objArr[10] = obj;
        this.initRecordTimeStamp = 0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = -1;
    }

    public murmurHash64WithSeed(Object obj, int i) {
        int[] iArr = new int[17];
        this.GetContactSyncConfig = iArr;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new long[17];
        this.DatabaseTableConfigUtil = new float[17];
        this.isLayoutRequested = new double[17];
        Object[] objArr = new Object[17];
        this.PrepareContext = objArr;
        objArr[10] = obj;
        iArr[11] = i;
        this.initRecordTimeStamp = 0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = -1;
    }

    public murmurHash64WithSeed(Object obj, Object obj2) {
        this.GetContactSyncConfig = new int[17];
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new long[17];
        this.DatabaseTableConfigUtil = new float[17];
        this.isLayoutRequested = new double[17];
        Object[] objArr = new Object[17];
        this.PrepareContext = objArr;
        objArr[10] = obj;
        objArr[11] = obj2;
        this.initRecordTimeStamp = 0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = -1;
    }

    public murmurHash64WithSeed(Object obj, Object obj2, Object obj3) {
        this.GetContactSyncConfig = new int[17];
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new long[17];
        this.DatabaseTableConfigUtil = new float[17];
        this.isLayoutRequested = new double[17];
        Object[] objArr = new Object[17];
        this.PrepareContext = objArr;
        objArr[10] = obj;
        objArr[11] = obj2;
        objArr[12] = obj3;
        this.initRecordTimeStamp = 0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = -1;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public int BuiltInFictitiousFunctionClassFactory(int i) {
        switch (i) {
            case 1:
                break;
            case 2:
                Object[] objArr = this.PrepareContext;
                int i2 = this.initRecordTimeStamp;
                Object obj = objArr[i2 - 1];
                objArr[i2 - 1] = null;
                this.scheduleImpl = obj;
                break;
            case 3:
                int[] iArr = this.GetContactSyncConfig;
                int i3 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i3 + 1;
                iArr[i3] = this.getAuthRequestContext;
                return 0;
            case 4:
                int[] iArr2 = this.GetContactSyncConfig;
                int i4 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i4 + 1;
                iArr2[i4] = 85;
                return 0;
            case 5:
                int[] iArr3 = this.GetContactSyncConfig;
                int i5 = this.initRecordTimeStamp;
                iArr3[i5 - 1] = -iArr3[i5 - 1];
                return 0;
            case 6:
                int[] iArr4 = this.GetContactSyncConfig;
                int i6 = this.initRecordTimeStamp;
                int i7 = i6 + 2;
                this.initRecordTimeStamp = i7;
                iArr4[i7 - 1] = iArr4[i7 - 3];
                iArr4[i6] = iArr4[i7 - 4];
                return 0;
            case 7:
                int[] iArr5 = this.GetContactSyncConfig;
                int i8 = this.initRecordTimeStamp;
                iArr5[i8 - 1] = -iArr5[i8 - 1];
                int i9 = i8 - 1;
                this.initRecordTimeStamp = i9;
                iArr5[i9 - 1] = iArr5[i9 - 1] & iArr5[i9];
                int i10 = i9 + 1;
                this.initRecordTimeStamp = i10;
                int i11 = iArr5[i10 - 2];
                iArr5[i9] = i11;
                iArr5[i10 - 2] = iArr5[i10 - 3];
                iArr5[i10 - 3] = iArr5[i10 - 4];
                iArr5[i10 - 4] = i11;
                return 0;
            case 8:
                int i12 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i12;
                this.PrepareContext[i12] = null;
                int[] iArr6 = this.GetContactSyncConfig;
                iArr6[i12 - 1] = -iArr6[i12 - 1];
                return 0;
            case 9:
                int i13 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i13;
                int[] iArr7 = this.GetContactSyncConfig;
                iArr7[i13 - 1] = iArr7[i13 - 1] | iArr7[i13];
                int i14 = i13 - 1;
                this.initRecordTimeStamp = i14;
                iArr7[i14 - 1] = iArr7[i14 - 1] + iArr7[i14];
                int i15 = i14 + 1;
                this.initRecordTimeStamp = i15;
                iArr7[i14] = iArr7[i15 - 2];
                return 0;
            case 10:
                int[] iArr8 = this.GetContactSyncConfig;
                int i16 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i16 + 1;
                iArr8[i16] = 128;
                return 0;
            case 11:
                int i17 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i17;
                int[] iArr9 = this.GetContactSyncConfig;
                iArr9[i17 - 1] = iArr9[i17 - 1] % iArr9[i17];
                return 0;
            case 12:
                int i18 = this.initRecordTimeStamp - this.getAuthRequestContext;
                this.initRecordTimeStamp = i18;
                this.NetworkUserEntityData$$ExternalSyntheticLambda1 = i18;
                return 0;
            case 13:
                int[] iArr10 = this.GetContactSyncConfig;
                int i19 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                this.NetworkUserEntityData$$ExternalSyntheticLambda1 = i19 + 1;
                this.KClassImpl$Data$declaredNonStaticMembers$2 = iArr10[i19];
                return 0;
            case 14:
                int i20 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i20;
                this.KClassImpl$Data$declaredNonStaticMembers$2 = this.GetContactSyncConfig[i20] != 0 ? 1 : 0;
                return 0;
            case 15:
                int[] iArr11 = this.GetContactSyncConfig;
                int i21 = this.initRecordTimeStamp;
                int i22 = i21 + 1;
                this.initRecordTimeStamp = i22;
                iArr11[i21] = 2;
                int i23 = i22 - 1;
                this.initRecordTimeStamp = i23;
                iArr11[i23 - 1] = iArr11[i23 - 1] % iArr11[i23];
                return 0;
            case 16:
                int[] iArr12 = this.GetContactSyncConfig;
                int i24 = this.initRecordTimeStamp;
                int i25 = i24 + 1;
                this.initRecordTimeStamp = i25;
                iArr12[i24] = 2;
                int i26 = i25 + 1;
                this.initRecordTimeStamp = i26;
                iArr12[i25] = 2;
                int i27 = i26 - 1;
                this.initRecordTimeStamp = i27;
                iArr12[i27 - 1] = iArr12[i27 - 1] % iArr12[i27];
                return 0;
            case 17:
                int i28 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i28;
                this.PrepareContext[i28] = null;
                return 0;
            case 18:
                int[] iArr13 = this.GetContactSyncConfig;
                int i29 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i29 + 1;
                iArr13[i29] = 81;
                return 0;
            case 19:
                Object[] objArr2 = this.PrepareContext;
                int i30 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i30 + 1;
                objArr2[i30] = objArr2[10];
                return 0;
            case 20:
                Object[] objArr3 = this.PrepareContext;
                int i31 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                this.NetworkUserEntityData$$ExternalSyntheticLambda1 = i31 + 1;
                Object obj2 = objArr3[i31];
                objArr3[i31] = null;
                this.scheduleImpl = obj2;
                return 0;
            case 21:
                Object[] objArr4 = this.PrepareContext;
                int i32 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i32 + 1;
                objArr4[i32] = this.moveToNextValue;
                return 0;
            case 22:
                int[] iArr14 = this.GetContactSyncConfig;
                int i33 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i33 + 1;
                iArr14[i33] = 56;
                return 0;
            case 23:
                int[] iArr15 = this.GetContactSyncConfig;
                int i34 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i34;
                this.KClassImpl$Data$declaredNonStaticMembers$2 = iArr15[i34];
                return 0;
            case 24:
                int[] iArr16 = this.GetContactSyncConfig;
                int i35 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i35 + 1;
                iArr16[i35] = 1;
                return 0;
            case 25:
                int[] iArr17 = this.GetContactSyncConfig;
                int i36 = this.initRecordTimeStamp;
                int i37 = i36 + 1;
                this.initRecordTimeStamp = i37;
                iArr17[i36] = 0;
                int i38 = i37 - 1;
                this.initRecordTimeStamp = i38;
                iArr17[i38 - 1] = iArr17[i38 - 1] / iArr17[i38];
                int i39 = i38 - 1;
                this.initRecordTimeStamp = i39;
                this.PrepareContext[i39] = null;
                return 0;
            case 26:
                int[] iArr18 = this.GetContactSyncConfig;
                int i40 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i40 + 1;
                iArr18[i40] = 67;
                return 0;
            case 27:
                int[] iArr19 = this.GetContactSyncConfig;
                int i41 = this.initRecordTimeStamp;
                iArr19[i41 - 1] = -iArr19[i41 - 1];
                int i42 = i41 + 1;
                this.initRecordTimeStamp = i42;
                iArr19[i41] = iArr19[i42 - 2];
                return 0;
            case 28:
                int[] iArr20 = this.GetContactSyncConfig;
                int i43 = this.initRecordTimeStamp;
                int i44 = i43 + 1;
                this.initRecordTimeStamp = i44;
                iArr20[i43] = -1;
                int i45 = i44 + 2;
                this.initRecordTimeStamp = i45;
                iArr20[i45 - 1] = iArr20[i45 - 3];
                iArr20[i44] = iArr20[i45 - 4];
                return 0;
            case 29:
                int i46 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i46;
                int[] iArr21 = this.GetContactSyncConfig;
                iArr21[i46 - 1] = iArr21[i46] & iArr21[i46 - 1];
                return 0;
            case 30:
                int[] iArr22 = this.GetContactSyncConfig;
                int i47 = this.initRecordTimeStamp;
                int i48 = i47 + 1;
                this.initRecordTimeStamp = i48;
                iArr22[i47] = -1;
                int i49 = i48 - 1;
                this.initRecordTimeStamp = i49;
                iArr22[i49 - 1] = iArr22[i49] ^ iArr22[i49 - 1];
                return 0;
            case 31:
                int[] iArr23 = this.GetContactSyncConfig;
                int i50 = this.initRecordTimeStamp;
                int i51 = i50 + 1;
                this.initRecordTimeStamp = i51;
                int i52 = iArr23[i51 - 2];
                iArr23[i50] = i52;
                iArr23[i51 - 2] = iArr23[i51 - 3];
                iArr23[i51 - 3] = iArr23[i51 - 4];
                iArr23[i51 - 4] = i52;
                return 0;
            case 32:
                int i53 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i53;
                this.PrepareContext[i53] = null;
                int i54 = i53 - 1;
                this.initRecordTimeStamp = i54;
                int[] iArr24 = this.GetContactSyncConfig;
                iArr24[i54 - 1] = iArr24[i54 - 1] | iArr24[i54];
                int i55 = i54 - 1;
                this.initRecordTimeStamp = i55;
                iArr24[i55 - 1] = iArr24[i55] & iArr24[i55 - 1];
                return 0;
            case 33:
                int[] iArr25 = this.GetContactSyncConfig;
                int i56 = this.initRecordTimeStamp;
                int i57 = iArr25[i56 - 1];
                iArr25[i56 - 1] = iArr25[i56 - 2];
                iArr25[i56 - 2] = i57;
                int i58 = i56 - 1;
                this.initRecordTimeStamp = i58;
                this.PrepareContext[i58] = null;
                int i59 = i58 - 1;
                this.initRecordTimeStamp = i59;
                iArr25[i59 - 1] = iArr25[i59 - 1] - iArr25[i59];
                return 0;
            case 34:
                int[] iArr26 = this.GetContactSyncConfig;
                int i60 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i60 + 1;
                iArr26[i60] = 1;
                return 0;
            case 35:
                int i61 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i61;
                int[] iArr27 = this.GetContactSyncConfig;
                iArr27[i61 - 1] = iArr27[i61 - 1] - iArr27[i61];
                int i62 = i61 + 1;
                this.initRecordTimeStamp = i62;
                iArr27[i61] = iArr27[i62 - 2];
                this.initRecordTimeStamp = i62 + 1;
                iArr27[i62] = 128;
                return 0;
            case 36:
                int[] iArr28 = this.GetContactSyncConfig;
                int i63 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i63 + 1;
                iArr28[i63] = 2;
                return 0;
            case 37:
                int i64 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i64;
                this.KClassImpl$Data$declaredNonStaticMembers$2 = this.GetContactSyncConfig[i64] == 0 ? 1 : 0;
                return 0;
            case 38:
                for (int i65 = this.initRecordTimeStamp - 1; i65 >= 0; i65--) {
                    this.PrepareContext[i65] = null;
                }
                this.initRecordTimeStamp = 0;
                Object[] objArr5 = this.PrepareContext;
                this.initRecordTimeStamp = 0 + 1;
                objArr5[0] = this.moveToNextValue;
                return 0;
            case 39:
                int[] iArr29 = this.GetContactSyncConfig;
                int i66 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i66 + 1;
                iArr29[i66] = 57;
                return 0;
            case 40:
                int[] iArr30 = this.GetContactSyncConfig;
                int i67 = this.initRecordTimeStamp;
                int i68 = i67 + 1;
                this.initRecordTimeStamp = i68;
                iArr30[i67] = 81;
                iArr30[i68 - 1] = -iArr30[i68 - 1];
                int i69 = i68 + 2;
                this.initRecordTimeStamp = i69;
                iArr30[i69 - 1] = iArr30[i69 - 3];
                iArr30[i68] = iArr30[i69 - 4];
                return 0;
            case 41:
                int[] iArr31 = this.GetContactSyncConfig;
                int i70 = this.initRecordTimeStamp;
                iArr31[i70 - 1] = -iArr31[i70 - 1];
                int i71 = i70 + 2;
                this.initRecordTimeStamp = i71;
                iArr31[i71 - 1] = iArr31[i71 - 3];
                iArr31[i70] = iArr31[i71 - 4];
                return 0;
            case 42:
                int i72 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i72;
                int[] iArr32 = this.GetContactSyncConfig;
                iArr32[i72 - 1] = iArr32[i72 - 1] & iArr32[i72];
                this.initRecordTimeStamp = i72 + 1;
                iArr32[i72] = -1;
                return 0;
            case 43:
                int i73 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i73;
                int[] iArr33 = this.GetContactSyncConfig;
                iArr33[i73 - 1] = iArr33[i73 - 1] ^ iArr33[i73];
                int i74 = i73 + 1;
                this.initRecordTimeStamp = i74;
                int i75 = iArr33[i74 - 2];
                iArr33[i73] = i75;
                iArr33[i74 - 2] = iArr33[i74 - 3];
                iArr33[i74 - 3] = iArr33[i74 - 4];
                iArr33[i74 - 4] = i75;
                int i76 = i74 - 1;
                this.initRecordTimeStamp = i76;
                this.PrepareContext[i76] = null;
                return 0;
            case 44:
                int i77 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i77;
                int[] iArr34 = this.GetContactSyncConfig;
                iArr34[i77 - 1] = iArr34[i77 - 1] | iArr34[i77];
                int i78 = i77 - 1;
                this.initRecordTimeStamp = i78;
                iArr34[i78 - 1] = iArr34[i78] & iArr34[i78 - 1];
                return 0;
            case 45:
                int[] iArr35 = this.GetContactSyncConfig;
                int i79 = this.initRecordTimeStamp;
                int i80 = i79 + 1;
                this.initRecordTimeStamp = i80;
                int i81 = iArr35[i80 - 2];
                iArr35[i79] = i81;
                iArr35[i80 - 2] = iArr35[i80 - 3];
                iArr35[i80 - 3] = iArr35[i80 - 4];
                iArr35[i80 - 4] = i81;
                int i82 = i80 - 1;
                this.initRecordTimeStamp = i82;
                this.PrepareContext[i82] = null;
                return 0;
            case 46:
                int[] iArr36 = this.GetContactSyncConfig;
                int i83 = this.initRecordTimeStamp;
                iArr36[i83 - 1] = -iArr36[i83 - 1];
                int i84 = i83 - 1;
                this.initRecordTimeStamp = i84;
                iArr36[i84 - 1] = iArr36[i84 - 1] & iArr36[i84];
                this.initRecordTimeStamp = i84 + 1;
                iArr36[i84] = 1;
                return 0;
            case 47:
                int i85 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i85;
                int[] iArr37 = this.GetContactSyncConfig;
                iArr37[i85 - 1] = iArr37[i85 - 1] << iArr37[i85];
                iArr37[i85 - 1] = -iArr37[i85 - 1];
                return 0;
            case 48:
                int[] iArr38 = this.GetContactSyncConfig;
                int i86 = this.initRecordTimeStamp;
                int i87 = i86 + 2;
                this.initRecordTimeStamp = i87;
                iArr38[i87 - 1] = iArr38[i87 - 3];
                iArr38[i86] = iArr38[i87 - 4];
                iArr38[i87 - 1] = -iArr38[i87 - 1];
                return 0;
            case 49:
                int i88 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i88;
                int[] iArr39 = this.GetContactSyncConfig;
                iArr39[i88 - 1] = iArr39[i88] ^ iArr39[i88 - 1];
                return 0;
            case 50:
                int i89 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i89;
                int[] iArr40 = this.GetContactSyncConfig;
                iArr40[i89 - 1] = iArr40[i89 - 1] << iArr40[i89];
                return 0;
            case 51:
                int i90 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i90;
                int[] iArr41 = this.GetContactSyncConfig;
                iArr41[i90 - 1] = iArr41[i90 - 1] + iArr41[i90];
                int i91 = i90 + 1;
                this.initRecordTimeStamp = i91;
                iArr41[i90] = iArr41[i91 - 2];
                return 0;
            case 52:
                int[] iArr42 = this.GetContactSyncConfig;
                int i92 = this.initRecordTimeStamp;
                int i93 = i92 + 1;
                this.initRecordTimeStamp = i93;
                iArr42[i92] = 128;
                int i94 = i93 - 1;
                this.initRecordTimeStamp = i94;
                iArr42[i94 - 1] = iArr42[i94 - 1] % iArr42[i94];
                return 0;
            case 53:
                int[] iArr43 = this.GetContactSyncConfig;
                int i95 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i95 + 1;
                iArr43[i95] = 51;
                return 0;
            case 54:
                int i96 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i96;
                int[] iArr44 = this.GetContactSyncConfig;
                iArr44[i96 - 1] = iArr44[i96 - 1] | iArr44[i96];
                this.initRecordTimeStamp = i96 + 1;
                iArr44[i96] = 1;
                return 0;
            case 55:
                int i97 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i97;
                int[] iArr45 = this.GetContactSyncConfig;
                iArr45[i97 - 1] = iArr45[i97 - 1] << iArr45[i97];
                int i98 = i97 + 1;
                this.initRecordTimeStamp = i98;
                int i99 = iArr45[i98 - 2];
                iArr45[i97] = i99;
                iArr45[i98 - 2] = iArr45[i98 - 3];
                iArr45[i98 - 3] = iArr45[i98 - 4];
                iArr45[i98 - 4] = i99;
                int i100 = i98 - 1;
                this.initRecordTimeStamp = i100;
                this.PrepareContext[i100] = null;
                return 0;
            case 56:
                int[] iArr46 = this.GetContactSyncConfig;
                int i101 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i101 + 1;
                iArr46[i101] = iArr46[11];
                return 0;
            case 57:
                int[] iArr47 = this.GetContactSyncConfig;
                int i102 = this.initRecordTimeStamp;
                int i103 = i102 + 1;
                this.initRecordTimeStamp = i103;
                iArr47[i102] = 6;
                this.initRecordTimeStamp = i103 + 1;
                iArr47[i103] = 0;
                return 0;
            case 58:
                int i104 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i104;
                int[] iArr48 = this.GetContactSyncConfig;
                iArr48[i104 - 1] = iArr48[i104 - 1] / iArr48[i104];
                return 0;
            case 59:
                int[] iArr49 = this.GetContactSyncConfig;
                int i105 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i105 + 1;
                iArr49[i105] = 28;
                return 0;
            case 60:
                int[] iArr50 = this.GetContactSyncConfig;
                int i106 = this.initRecordTimeStamp;
                int i107 = i106 + 1;
                this.initRecordTimeStamp = i107;
                iArr50[i106] = 39;
                iArr50[i107 - 1] = -iArr50[i107 - 1];
                return 0;
            case 61:
                int[] iArr51 = this.GetContactSyncConfig;
                int i108 = this.initRecordTimeStamp;
                int i109 = i108 + 1;
                this.initRecordTimeStamp = i109;
                iArr51[i108] = -1;
                int i110 = i109 - 1;
                this.initRecordTimeStamp = i110;
                iArr51[i110 - 1] = iArr51[i110 - 1] ^ iArr51[i110];
                int i111 = i110 + 1;
                this.initRecordTimeStamp = i111;
                int i112 = iArr51[i111 - 2];
                iArr51[i110] = i112;
                iArr51[i111 - 2] = iArr51[i111 - 3];
                iArr51[i111 - 3] = iArr51[i111 - 4];
                iArr51[i111 - 4] = i112;
                return 0;
            case 62:
                int[] iArr52 = this.GetContactSyncConfig;
                int i113 = this.initRecordTimeStamp;
                int i114 = i113 + 2;
                this.initRecordTimeStamp = i114;
                iArr52[i114 - 1] = iArr52[i114 - 3];
                iArr52[i113] = iArr52[i114 - 4];
                this.initRecordTimeStamp = i114 + 1;
                iArr52[i114] = -1;
                return 0;
            case 63:
                int i115 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i115;
                this.PrepareContext[i115] = null;
                int i116 = i115 - 1;
                this.initRecordTimeStamp = i116;
                int[] iArr53 = this.GetContactSyncConfig;
                iArr53[i116 - 1] = iArr53[i116 - 1] & iArr53[i116];
                this.initRecordTimeStamp = i116 + 1;
                iArr53[i116] = 1;
                return 0;
            case 64:
                int[] iArr54 = this.GetContactSyncConfig;
                int i117 = this.initRecordTimeStamp;
                int i118 = i117 + 1;
                this.initRecordTimeStamp = i118;
                iArr54[i117] = iArr54[i118 - 2];
                int i119 = i118 + 1;
                this.initRecordTimeStamp = i119;
                iArr54[i118] = -1;
                int i120 = i119 - 1;
                this.initRecordTimeStamp = i120;
                iArr54[i120 - 1] = iArr54[i120] ^ iArr54[i120 - 1];
                return 0;
            case 65:
                int[] iArr55 = this.GetContactSyncConfig;
                int i121 = this.initRecordTimeStamp;
                int i122 = iArr55[i121 - 1];
                iArr55[i121 - 1] = iArr55[i121 - 2];
                iArr55[i121 - 2] = i122;
                int i123 = i121 - 1;
                this.initRecordTimeStamp = i123;
                this.PrepareContext[i123] = null;
                return 0;
            case 66:
                int i124 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i124;
                int[] iArr56 = this.GetContactSyncConfig;
                iArr56[i124 - 1] = iArr56[i124 - 1] - iArr56[i124];
                int i125 = i124 + 1;
                this.initRecordTimeStamp = i125;
                iArr56[i124] = 1;
                int i126 = i125 - 1;
                this.initRecordTimeStamp = i126;
                iArr56[i126 - 1] = iArr56[i126 - 1] - iArr56[i126];
                return 0;
            case 67:
                int[] iArr57 = this.GetContactSyncConfig;
                int i127 = this.initRecordTimeStamp;
                int i128 = i127 + 1;
                this.initRecordTimeStamp = i128;
                iArr57[i127] = iArr57[i128 - 2];
                return 0;
            case 68:
                int[] iArr58 = this.GetContactSyncConfig;
                int i129 = this.initRecordTimeStamp;
                int i130 = i129 + 1;
                this.initRecordTimeStamp = i130;
                iArr58[i129] = 113;
                iArr58[i130 - 1] = -iArr58[i130 - 1];
                return 0;
            case 69:
                int[] iArr59 = this.GetContactSyncConfig;
                int i131 = this.initRecordTimeStamp;
                int i132 = i131 + 2;
                this.initRecordTimeStamp = i132;
                iArr59[i132 - 1] = iArr59[i132 - 3];
                iArr59[i131] = iArr59[i132 - 4];
                int i133 = i132 + 1;
                this.initRecordTimeStamp = i133;
                iArr59[i132] = -1;
                int i134 = i133 - 1;
                this.initRecordTimeStamp = i134;
                iArr59[i134 - 1] = iArr59[i134] ^ iArr59[i134 - 1];
                return 0;
            case 70:
                int i135 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i135;
                int[] iArr60 = this.GetContactSyncConfig;
                iArr60[i135 - 1] = iArr60[i135 - 1] ^ iArr60[i135];
                int i136 = i135 + 1;
                this.initRecordTimeStamp = i136;
                int i137 = iArr60[i136 - 2];
                iArr60[i135] = i137;
                iArr60[i136 - 2] = iArr60[i136 - 3];
                iArr60[i136 - 3] = iArr60[i136 - 4];
                iArr60[i136 - 4] = i137;
                return 0;
            case 71:
                int i138 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i138;
                int[] iArr61 = this.GetContactSyncConfig;
                iArr61[i138 - 1] = iArr61[i138] | iArr61[i138 - 1];
                return 0;
            case 72:
                int[] iArr62 = this.GetContactSyncConfig;
                int i139 = this.initRecordTimeStamp;
                iArr62[i139 - 1] = -iArr62[i139 - 1];
                int i140 = i139 - 1;
                this.initRecordTimeStamp = i140;
                iArr62[i140 - 1] = iArr62[i140] ^ iArr62[i140 - 1];
                return 0;
            case 73:
                int[] iArr63 = this.GetContactSyncConfig;
                int i141 = this.initRecordTimeStamp;
                iArr63[i141 - 1] = -iArr63[i141 - 1];
                int i142 = i141 - 1;
                this.initRecordTimeStamp = i142;
                iArr63[i142 - 1] = iArr63[i142] & iArr63[i142 - 1];
                return 0;
            case 74:
                int i143 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i143;
                int[] iArr64 = this.GetContactSyncConfig;
                iArr64[i143 - 1] = iArr64[i143 - 1] << iArr64[i143];
                int i144 = i143 - 1;
                this.initRecordTimeStamp = i144;
                iArr64[i144 - 1] = iArr64[i144 - 1] + iArr64[i144];
                int i145 = i144 + 1;
                this.initRecordTimeStamp = i145;
                iArr64[i144] = iArr64[i145 - 2];
                return 0;
            case 75:
                Object[] objArr6 = this.PrepareContext;
                int i146 = this.initRecordTimeStamp;
                int i147 = i146 + 1;
                this.initRecordTimeStamp = i147;
                objArr6[i146] = objArr6[10];
                this.initRecordTimeStamp = i147 + 1;
                objArr6[i147] = objArr6[11];
                return 0;
            case 76:
                Object[] objArr7 = this.PrepareContext;
                int i148 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i148 + 1;
                objArr7[i148] = null;
                return 0;
            case 77:
                int[] iArr65 = this.GetContactSyncConfig;
                int i149 = this.initRecordTimeStamp;
                Object[] objArr8 = this.PrepareContext;
                Object obj3 = objArr8[i149 - 1];
                objArr8[i149 - 1] = null;
                iArr65[i149 - 1] = ((int[]) obj3).length;
                return 0;
            case 78:
                int[] iArr66 = this.GetContactSyncConfig;
                int i150 = this.initRecordTimeStamp;
                int i151 = i150 + 2;
                this.initRecordTimeStamp = i151;
                iArr66[i151 - 1] = iArr66[i151 - 3];
                iArr66[i150] = iArr66[i151 - 4];
                int i152 = i151 + 2;
                this.initRecordTimeStamp = i152;
                iArr66[i152 - 1] = iArr66[i152 - 3];
                iArr66[i151] = iArr66[i152 - 4];
                return 0;
            case 79:
                int i153 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i153;
                int[] iArr67 = this.GetContactSyncConfig;
                iArr67[i153 - 1] = iArr67[i153 - 1] | iArr67[i153];
                int i154 = i153 - 1;
                this.initRecordTimeStamp = i154;
                iArr67[i154 - 1] = iArr67[i154 - 1] & iArr67[i154];
                int i155 = i154 + 1;
                this.initRecordTimeStamp = i155;
                int i156 = iArr67[i155 - 2];
                iArr67[i154] = i156;
                iArr67[i155 - 2] = iArr67[i155 - 3];
                iArr67[i155 - 3] = iArr67[i155 - 4];
                iArr67[i155 - 4] = i156;
                return 0;
            case 80:
                int i157 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i157;
                int[] iArr68 = this.GetContactSyncConfig;
                iArr68[i157 - 1] = iArr68[i157 - 1] ^ iArr68[i157];
                int i158 = i157 - 1;
                this.initRecordTimeStamp = i158;
                iArr68[i158 - 1] = iArr68[i158 - 1] ^ iArr68[i158];
                int i159 = i158 - 1;
                this.initRecordTimeStamp = i159;
                this.PrepareContext[i159] = null;
                return 0;
            case 81:
                int[] iArr69 = this.GetContactSyncConfig;
                int i160 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i160 + 1;
                iArr69[i160] = 0;
                return 0;
            case 82:
                int[] iArr70 = this.GetContactSyncConfig;
                int i161 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i161 + 1;
                iArr70[i161] = 33;
                return 0;
            case 83:
                int[] iArr71 = this.GetContactSyncConfig;
                int i162 = this.initRecordTimeStamp;
                int i163 = i162 + 2;
                this.initRecordTimeStamp = i163;
                iArr71[i163 - 1] = iArr71[i163 - 3];
                iArr71[i162] = iArr71[i163 - 4];
                int i164 = i163 - 1;
                this.initRecordTimeStamp = i164;
                iArr71[i164 - 1] = iArr71[i164] | iArr71[i164 - 1];
                return 0;
            case 84:
                int i165 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i165;
                int[] iArr72 = this.GetContactSyncConfig;
                iArr72[i165 - 1] = iArr72[i165 - 1] - iArr72[i165];
                return 0;
            case 85:
                int[] iArr73 = this.GetContactSyncConfig;
                int i166 = this.initRecordTimeStamp;
                int i167 = i166 + 1;
                this.initRecordTimeStamp = i167;
                iArr73[i166] = iArr73[i167 - 2];
                this.initRecordTimeStamp = i167 + 1;
                iArr73[i167] = 128;
                return 0;
            case 86:
                int i168 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i168;
                Object[] objArr9 = this.PrepareContext;
                Object obj4 = objArr9[i168];
                objArr9[i168] = null;
                objArr9[13] = obj4;
                return 0;
            case 87:
                int[] iArr74 = this.GetContactSyncConfig;
                int i169 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i169 + 1;
                iArr74[i169] = 6;
                return 0;
            case 88:
                int[] iArr75 = this.GetContactSyncConfig;
                int i170 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i170 + 1;
                iArr75[i170] = 119;
                return 0;
            case 89:
                int[] iArr76 = this.GetContactSyncConfig;
                int i171 = this.initRecordTimeStamp;
                int i172 = i171 + 2;
                this.initRecordTimeStamp = i172;
                iArr76[i172 - 1] = iArr76[i172 - 3];
                iArr76[i171] = iArr76[i172 - 4];
                int i173 = i172 - 1;
                this.initRecordTimeStamp = i173;
                iArr76[i173 - 1] = iArr76[i173] ^ iArr76[i173 - 1];
                return 0;
            case 90:
                int[] iArr77 = this.GetContactSyncConfig;
                int i174 = this.initRecordTimeStamp;
                int i175 = i174 + 1;
                this.initRecordTimeStamp = i175;
                int i176 = iArr77[i175 - 2];
                iArr77[i174] = i176;
                iArr77[i175 - 2] = iArr77[i175 - 3];
                iArr77[i175 - 3] = iArr77[i175 - 4];
                iArr77[i175 - 4] = i176;
                int i177 = i175 - 1;
                this.initRecordTimeStamp = i177;
                this.PrepareContext[i177] = null;
                int i178 = i177 + 2;
                this.initRecordTimeStamp = i178;
                iArr77[i178 - 1] = iArr77[i178 - 3];
                iArr77[i177] = iArr77[i178 - 4];
                return 0;
            case 91:
                int i179 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i179;
                int[] iArr78 = this.GetContactSyncConfig;
                iArr78[i179 - 1] = iArr78[i179 - 1] ^ iArr78[i179];
                int i180 = i179 - 1;
                this.initRecordTimeStamp = i180;
                this.PrepareContext[i180] = null;
                int i181 = i180 - 1;
                this.initRecordTimeStamp = i181;
                iArr78[i181 - 1] = iArr78[i181] & iArr78[i181 - 1];
                return 0;
            case 92:
                int[] iArr79 = this.GetContactSyncConfig;
                int i182 = this.initRecordTimeStamp;
                int i183 = i182 + 1;
                this.initRecordTimeStamp = i183;
                iArr79[i182] = 1;
                int i184 = i183 - 1;
                this.initRecordTimeStamp = i184;
                iArr79[i184 - 1] = iArr79[i184 - 1] << iArr79[i184];
                int i185 = i184 - 1;
                this.initRecordTimeStamp = i185;
                iArr79[i185 - 1] = iArr79[i185 - 1] + iArr79[i185];
                return 0;
            case 93:
                int[] iArr80 = this.GetContactSyncConfig;
                int i186 = this.initRecordTimeStamp;
                int i187 = i186 + 1;
                this.initRecordTimeStamp = i187;
                iArr80[i186] = iArr80[i187 - 2];
                int i188 = i187 + 1;
                this.initRecordTimeStamp = i188;
                iArr80[i187] = 128;
                int i189 = i188 - 1;
                this.initRecordTimeStamp = i189;
                iArr80[i189 - 1] = iArr80[i189 - 1] % iArr80[i189];
                return 0;
            case 94:
                int i190 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i190;
                Object[] objArr10 = this.PrepareContext;
                Object obj5 = objArr10[i190];
                objArr10[i190] = null;
                this.KClassImpl$Data$declaredNonStaticMembers$2 = obj5 != null ? 1 : 0;
                return 0;
            case 95:
                Object[] objArr11 = this.PrepareContext;
                int i191 = this.initRecordTimeStamp;
                int i192 = i191 + 1;
                this.initRecordTimeStamp = i192;
                objArr11[i191] = objArr11[i192 - 2];
                int i193 = i192 - 1;
                this.initRecordTimeStamp = i193;
                Object obj6 = objArr11[i193];
                objArr11[i193] = null;
                objArr11[15] = obj6;
                return 0;
            case 96:
                int[] iArr81 = this.GetContactSyncConfig;
                int i194 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i194 + 1;
                iArr81[i194] = 41;
                return 0;
            case 97:
                int i195 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i195;
                Object[] objArr12 = this.PrepareContext;
                Object obj7 = objArr12[i195];
                objArr12[i195] = null;
                objArr12[11] = obj7;
                this.initRecordTimeStamp = i195 + 1;
                objArr12[i195] = objArr12[10];
                return 0;
            case 98:
                int[] iArr82 = this.GetContactSyncConfig;
                int i196 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i196 + 1;
                iArr82[i196] = 24;
                return 0;
            case 99:
                int[] iArr83 = this.GetContactSyncConfig;
                int i197 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i197 + 1;
                iArr83[i197] = 82;
                return 0;
            case 100:
                int[] iArr84 = this.GetContactSyncConfig;
                int i198 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i198 + 1;
                iArr84[i198] = 86;
                return 0;
            case 101:
                int i199 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i199;
                Object[] objArr13 = this.PrepareContext;
                Object obj8 = objArr13[i199];
                objArr13[i199] = null;
                objArr13[14] = obj8;
                return 0;
            case 102:
                int i200 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i200;
                Object[] objArr14 = this.PrepareContext;
                Object obj9 = objArr14[i200];
                objArr14[i200] = null;
                objArr14[16] = obj9;
                return 0;
            case 103:
                int[] iArr85 = this.GetContactSyncConfig;
                int i201 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i201 + 1;
                iArr85[i201] = 20;
                return 0;
            case 104:
                int[] iArr86 = this.GetContactSyncConfig;
                int i202 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i202 + 1;
                iArr86[i202] = 59;
                return 0;
            case 105:
                int i203 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i203;
                Object[] objArr15 = this.PrepareContext;
                objArr15[i203] = null;
                this.initRecordTimeStamp = i203 + 1;
                objArr15[i203] = objArr15[13];
                return 0;
            case 106:
                Object[] objArr16 = this.PrepareContext;
                int i204 = this.initRecordTimeStamp;
                int i205 = i204 + 1;
                this.initRecordTimeStamp = i205;
                objArr16[i204] = objArr16[i205 - 2];
                return 0;
            case 107:
                int i206 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i206;
                Object[] objArr17 = this.PrepareContext;
                Object obj10 = objArr17[i206];
                objArr17[i206] = null;
                objArr17[15] = obj10;
                return 0;
            case 108:
                int[] iArr87 = this.GetContactSyncConfig;
                int i207 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i207 + 1;
                iArr87[i207] = 83;
                return 0;
            case 109:
                int[] iArr88 = this.GetContactSyncConfig;
                int i208 = this.initRecordTimeStamp;
                int i209 = i208 + 1;
                this.initRecordTimeStamp = i209;
                iArr88[i208] = 107;
                int i210 = i209 + 2;
                this.initRecordTimeStamp = i210;
                iArr88[i210 - 1] = iArr88[i210 - 3];
                iArr88[i209] = iArr88[i210 - 4];
                return 0;
            case 110:
                int i211 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i211;
                int[] iArr89 = this.GetContactSyncConfig;
                iArr89[i211 - 1] = iArr89[i211 - 1] << iArr89[i211];
                int i212 = i211 + 1;
                this.initRecordTimeStamp = i212;
                iArr89[i211] = iArr89[i212 - 2];
                this.initRecordTimeStamp = i212 + 1;
                iArr89[i212] = -1;
                return 0;
            case 111:
                int[] iArr90 = this.GetContactSyncConfig;
                int i213 = this.initRecordTimeStamp;
                int i214 = iArr90[i213 - 1];
                iArr90[i213 - 1] = iArr90[i213 - 2];
                iArr90[i213 - 2] = i214;
                return 0;
            case 112:
                int[] iArr91 = this.GetContactSyncConfig;
                int i215 = this.initRecordTimeStamp;
                int i216 = i215 + 1;
                this.initRecordTimeStamp = i216;
                iArr91[i215] = 1;
                int i217 = i216 - 1;
                this.initRecordTimeStamp = i217;
                iArr91[i217 - 1] = iArr91[i217 - 1] - iArr91[i217];
                int i218 = i217 + 1;
                this.initRecordTimeStamp = i218;
                iArr91[i217] = iArr91[i218 - 2];
                return 0;
            case 113:
                int[] iArr92 = this.GetContactSyncConfig;
                int i219 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i219 + 1;
                iArr92[i219] = 75;
                return 0;
            case 114:
                int[] iArr93 = this.GetContactSyncConfig;
                int i220 = this.initRecordTimeStamp;
                iArr93[i220 - 1] = -iArr93[i220 - 1];
                int i221 = i220 + 1;
                this.initRecordTimeStamp = i221;
                iArr93[i220] = iArr93[i221 - 2];
                iArr93[i221 - 1] = -iArr93[i221 - 1];
                return 0;
            case 115:
                int[] iArr94 = this.GetContactSyncConfig;
                int i222 = this.initRecordTimeStamp;
                int i223 = i222 + 1;
                this.initRecordTimeStamp = i223;
                iArr94[i222] = -1;
                int i224 = i223 + 2;
                this.initRecordTimeStamp = i224;
                iArr94[i224 - 1] = iArr94[i224 - 3];
                iArr94[i223] = iArr94[i224 - 4];
                this.initRecordTimeStamp = i224 + 1;
                iArr94[i224] = -1;
                return 0;
            case 116:
                int i225 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i225;
                int[] iArr95 = this.GetContactSyncConfig;
                iArr95[i225 - 1] = iArr95[i225 - 1] ^ iArr95[i225];
                int i226 = i225 - 1;
                this.initRecordTimeStamp = i226;
                iArr95[i226 - 1] = iArr95[i226] & iArr95[i226 - 1];
                return 0;
            case 117:
                int i227 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i227;
                this.PrepareContext[i227] = null;
                int[] iArr96 = this.GetContactSyncConfig;
                int i228 = iArr96[i227 - 1];
                iArr96[i227 - 1] = iArr96[i227 - 2];
                iArr96[i227 - 2] = i228;
                this.initRecordTimeStamp = i227 + 1;
                iArr96[i227] = -1;
                return 0;
            case 118:
                int i229 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i229;
                int[] iArr97 = this.GetContactSyncConfig;
                iArr97[i229 - 1] = iArr97[i229 - 1] & iArr97[i229];
                int i230 = i229 - 1;
                this.initRecordTimeStamp = i230;
                iArr97[i230 - 1] = iArr97[i230 - 1] | iArr97[i230];
                int i231 = iArr97[i230 - 1];
                iArr97[i230 - 1] = iArr97[i230 - 2];
                iArr97[i230 - 2] = i231;
                return 0;
            case 119:
                int i232 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i232;
                this.PrepareContext[i232] = null;
                int[] iArr98 = this.GetContactSyncConfig;
                iArr98[i232 - 1] = -iArr98[i232 - 1];
                int i233 = i232 + 2;
                this.initRecordTimeStamp = i233;
                iArr98[i233 - 1] = iArr98[i233 - 3];
                iArr98[i232] = iArr98[i233 - 4];
                return 0;
            case 120:
                int[] iArr99 = this.GetContactSyncConfig;
                int i234 = this.initRecordTimeStamp;
                int i235 = i234 + 1;
                this.initRecordTimeStamp = i235;
                int i236 = iArr99[i235 - 2];
                iArr99[i234] = i236;
                iArr99[i235 - 2] = iArr99[i235 - 3];
                iArr99[i235 - 3] = iArr99[i235 - 4];
                iArr99[i235 - 4] = i236;
                int i237 = i235 - 1;
                this.initRecordTimeStamp = i237;
                this.PrepareContext[i237] = null;
                int i238 = i237 - 1;
                this.initRecordTimeStamp = i238;
                iArr99[i238 - 1] = iArr99[i238] ^ iArr99[i238 - 1];
                return 0;
            case 121:
                int[] iArr100 = this.GetContactSyncConfig;
                int i239 = this.initRecordTimeStamp;
                iArr100[i239 - 1] = -iArr100[i239 - 1];
                int i240 = i239 + 2;
                this.initRecordTimeStamp = i240;
                iArr100[i240 - 1] = iArr100[i240 - 3];
                iArr100[i239] = iArr100[i240 - 4];
                int i241 = i240 - 1;
                this.initRecordTimeStamp = i241;
                iArr100[i241 - 1] = iArr100[i241] | iArr100[i241 - 1];
                return 0;
            case 122:
                int i242 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i242;
                int[] iArr101 = this.GetContactSyncConfig;
                iArr101[i242 - 1] = iArr101[i242 - 1] ^ iArr101[i242];
                int i243 = i242 - 1;
                this.initRecordTimeStamp = i243;
                iArr101[i243 - 1] = iArr101[i243 - 1] - iArr101[i243];
                return 0;
            case 123:
                int[] iArr102 = this.GetContactSyncConfig;
                int i244 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i244 + 1;
                iArr102[i244] = 35;
                return 0;
            case 124:
                int[] iArr103 = this.GetContactSyncConfig;
                int i245 = this.initRecordTimeStamp;
                int i246 = i245 + 2;
                this.initRecordTimeStamp = i246;
                iArr103[i246 - 1] = iArr103[i246 - 3];
                iArr103[i245] = iArr103[i246 - 4];
                int i247 = i246 + 2;
                this.initRecordTimeStamp = i247;
                iArr103[i247 - 1] = iArr103[i247 - 3];
                iArr103[i246] = iArr103[i247 - 4];
                this.initRecordTimeStamp = i247 + 1;
                iArr103[i247] = -1;
                return 0;
            case 125:
                int i248 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i248;
                int[] iArr104 = this.GetContactSyncConfig;
                iArr104[i248 - 1] = iArr104[i248 - 1] ^ iArr104[i248];
                int i249 = i248 - 1;
                this.initRecordTimeStamp = i249;
                iArr104[i249 - 1] = iArr104[i249] ^ iArr104[i249 - 1];
                return 0;
            case 126:
                int i250 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i250;
                this.PrepareContext[i250] = null;
                int i251 = i250 - 1;
                this.initRecordTimeStamp = i251;
                int[] iArr105 = this.GetContactSyncConfig;
                iArr105[i251 - 1] = iArr105[i251 - 1] & iArr105[i251];
                int i252 = i251 + 1;
                this.initRecordTimeStamp = i252;
                int i253 = iArr105[i252 - 2];
                iArr105[i251] = i253;
                iArr105[i252 - 2] = iArr105[i252 - 3];
                iArr105[i252 - 3] = iArr105[i252 - 4];
                iArr105[i252 - 4] = i253;
                return 0;
            case 127:
                int i254 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i254;
                this.PrepareContext[i254] = null;
                int[] iArr106 = this.GetContactSyncConfig;
                int i255 = i254 + 2;
                this.initRecordTimeStamp = i255;
                iArr106[i255 - 1] = iArr106[i255 - 3];
                iArr106[i254] = iArr106[i255 - 4];
                return 0;
            case 128:
                int i256 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i256;
                this.PrepareContext[i256] = null;
                int i257 = i256 - 1;
                this.initRecordTimeStamp = i257;
                int[] iArr107 = this.GetContactSyncConfig;
                iArr107[i257 - 1] = iArr107[i257 - 1] & iArr107[i257];
                int i258 = i257 - 1;
                this.initRecordTimeStamp = i258;
                iArr107[i258 - 1] = iArr107[i258] | iArr107[i258 - 1];
                return 0;
            case 129:
                int[] iArr108 = this.GetContactSyncConfig;
                int i259 = this.initRecordTimeStamp;
                int i260 = i259 + 2;
                this.initRecordTimeStamp = i260;
                iArr108[i260 - 1] = iArr108[i260 - 3];
                iArr108[i259] = iArr108[i260 - 4];
                int i261 = i260 - 1;
                this.initRecordTimeStamp = i261;
                iArr108[i261 - 1] = iArr108[i261 - 1] | iArr108[i261];
                this.initRecordTimeStamp = i261 + 1;
                iArr108[i261] = 1;
                return 0;
            case 130:
                int i262 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i262;
                int[] iArr109 = this.GetContactSyncConfig;
                iArr109[i262 - 1] = iArr109[i262 - 1] - iArr109[i262];
                int i263 = i262 + 1;
                this.initRecordTimeStamp = i263;
                iArr109[i262] = iArr109[i263 - 2];
                return 0;
            case 131:
                int i264 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i264;
                Object[] objArr18 = this.PrepareContext;
                Object obj11 = objArr18[i264];
                objArr18[i264] = null;
                objArr18[13] = obj11;
                this.initRecordTimeStamp = i264 + 1;
                objArr18[i264] = objArr18[10];
                return 0;
            case 132:
                int[] iArr110 = this.GetContactSyncConfig;
                int i265 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i265 + 1;
                iArr110[i265] = 49;
                return 0;
            case 133:
                int i266 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i266;
                this.PrepareContext[i266] = null;
                int i267 = i266 - 1;
                this.initRecordTimeStamp = i267;
                int[] iArr111 = this.GetContactSyncConfig;
                iArr111[i267 - 1] = iArr111[i267 - 1] - iArr111[i267];
                this.initRecordTimeStamp = i267 + 1;
                iArr111[i267] = 1;
                return 0;
            case 134:
                int[] iArr112 = this.GetContactSyncConfig;
                int i268 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i268 + 1;
                iArr112[i268] = 23;
                return 0;
            case 135:
                Object[] objArr19 = this.PrepareContext;
                int i269 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i269 + 1;
                objArr19[i269] = objArr19[15];
                return 0;
            case 136:
                int i270 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i270;
                Object[] objArr20 = this.PrepareContext;
                Object obj12 = objArr20[i270];
                objArr20[i270] = null;
                objArr20[13] = obj12;
                this.initRecordTimeStamp = i270 + 1;
                objArr20[i270] = objArr20[12];
                return 0;
            case 137:
                Object[] objArr21 = this.PrepareContext;
                int i271 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i271 + 1;
                objArr21[i271] = objArr21[11];
                return 0;
            case 138:
                Object[] objArr22 = this.PrepareContext;
                int i272 = this.initRecordTimeStamp;
                int i273 = i272 + 1;
                this.initRecordTimeStamp = i273;
                objArr22[i272] = objArr22[14];
                this.initRecordTimeStamp = i273 + 1;
                objArr22[i273] = objArr22[13];
                return 0;
            case 139:
                Object[] objArr23 = this.PrepareContext;
                int i274 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i274 + 1;
                objArr23[i274] = objArr23[13];
                return 0;
            case 140:
                int[] iArr113 = this.GetContactSyncConfig;
                int i275 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i275 + 1;
                iArr113[i275] = 13;
                return 0;
            case 141:
                int i276 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i276;
                int[] iArr114 = this.GetContactSyncConfig;
                iArr114[i276 - 1] = iArr114[i276 - 1] + iArr114[i276];
                return 0;
            case 142:
                int i277 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i277;
                Object[] objArr24 = this.PrepareContext;
                Object obj13 = objArr24[i277];
                objArr24[i277] = null;
                objArr24[12] = obj13;
                return 0;
            case 143:
                Object[] objArr25 = this.PrepareContext;
                int i278 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i278 + 1;
                objArr25[i278] = objArr25[14];
                return 0;
            case 144:
                Object[] objArr26 = this.PrepareContext;
                int i279 = this.initRecordTimeStamp;
                int i280 = i279 + 1;
                this.initRecordTimeStamp = i280;
                objArr26[i279] = null;
                int i281 = i280 - 1;
                this.initRecordTimeStamp = i281;
                Object obj14 = objArr26[i281];
                objArr26[i281] = null;
                objArr26[15] = obj14;
                return 0;
            case 145:
                int[] iArr115 = this.GetContactSyncConfig;
                int i282 = this.initRecordTimeStamp;
                int i283 = i282 + 1;
                this.initRecordTimeStamp = i283;
                iArr115[i282] = 51;
                iArr115[i283 - 1] = -iArr115[i283 - 1];
                int i284 = i283 + 2;
                this.initRecordTimeStamp = i284;
                iArr115[i284 - 1] = iArr115[i284 - 3];
                iArr115[i283] = iArr115[i284 - 4];
                return 0;
            case 146:
                int i285 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i285;
                int[] iArr116 = this.GetContactSyncConfig;
                iArr116[i285 - 1] = iArr116[i285 - 1] & iArr116[i285];
                int i286 = i285 + 1;
                this.initRecordTimeStamp = i286;
                iArr116[i285] = -1;
                int i287 = i286 - 1;
                this.initRecordTimeStamp = i287;
                iArr116[i287 - 1] = iArr116[i287] ^ iArr116[i287 - 1];
                return 0;
            case 147:
                int[] iArr117 = this.GetContactSyncConfig;
                int i288 = this.initRecordTimeStamp;
                int i289 = i288 + 1;
                this.initRecordTimeStamp = i289;
                int i290 = iArr117[i289 - 2];
                iArr117[i288] = i290;
                iArr117[i289 - 2] = iArr117[i289 - 3];
                iArr117[i289 - 3] = iArr117[i289 - 4];
                iArr117[i289 - 4] = i290;
                int i291 = i289 - 1;
                this.initRecordTimeStamp = i291;
                this.PrepareContext[i291] = null;
                int i292 = i291 - 1;
                this.initRecordTimeStamp = i292;
                iArr117[i292 - 1] = iArr117[i292] | iArr117[i292 - 1];
                return 0;
            case 148:
                int i293 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i293;
                int[] iArr118 = this.GetContactSyncConfig;
                iArr118[i293 - 1] = iArr118[i293 - 1] & iArr118[i293];
                int i294 = i293 + 1;
                this.initRecordTimeStamp = i294;
                int i295 = iArr118[i294 - 2];
                iArr118[i293] = i295;
                iArr118[i294 - 2] = iArr118[i294 - 3];
                iArr118[i294 - 3] = iArr118[i294 - 4];
                iArr118[i294 - 4] = i295;
                int i296 = i294 - 1;
                this.initRecordTimeStamp = i296;
                this.PrepareContext[i296] = null;
                return 0;
            case 149:
                int i297 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i297;
                int[] iArr119 = this.GetContactSyncConfig;
                iArr119[i297 - 1] = iArr119[i297 - 1] << iArr119[i297];
                int i298 = i297 + 2;
                this.initRecordTimeStamp = i298;
                iArr119[i298 - 1] = iArr119[i298 - 3];
                iArr119[i297] = iArr119[i298 - 4];
                return 0;
            case 150:
                Object[] objArr27 = this.PrepareContext;
                int i299 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i299 + 1;
                objArr27[i299] = objArr27[16];
                return 0;
            case 151:
                int[] iArr120 = this.GetContactSyncConfig;
                int i300 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i300 + 1;
                iArr120[i300] = 29;
                return 0;
            case 152:
                int[] iArr121 = this.GetContactSyncConfig;
                int i301 = this.initRecordTimeStamp;
                int i302 = i301 + 1;
                this.initRecordTimeStamp = i302;
                iArr121[i301] = 35;
                int i303 = i302 + 2;
                this.initRecordTimeStamp = i303;
                iArr121[i303 - 1] = iArr121[i303 - 3];
                iArr121[i302] = iArr121[i303 - 4];
                return 0;
            case 153:
                int i304 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i304;
                this.PrepareContext[i304] = null;
                int i305 = i304 - 1;
                this.initRecordTimeStamp = i305;
                int[] iArr122 = this.GetContactSyncConfig;
                iArr122[i305 - 1] = iArr122[i305] | iArr122[i305 - 1];
                return 0;
            case 154:
                int[] iArr123 = this.GetContactSyncConfig;
                int i306 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i306 + 1;
                iArr123[i306] = -1;
                return 0;
            case TarHeader.USTAR_FILENAME_PREFIX /* 155 */:
                int i307 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i307;
                this.PrepareContext[i307] = null;
                int i308 = i307 - 1;
                this.initRecordTimeStamp = i308;
                int[] iArr124 = this.GetContactSyncConfig;
                iArr124[i308 - 1] = iArr124[i308] & iArr124[i308 - 1];
                return 0;
            case 156:
                int[] iArr125 = this.GetContactSyncConfig;
                int i309 = this.initRecordTimeStamp;
                int i310 = i309 + 1;
                this.initRecordTimeStamp = i310;
                iArr125[i309] = 1;
                int i311 = i310 - 1;
                this.initRecordTimeStamp = i311;
                iArr125[i311 - 1] = iArr125[i311 - 1] << iArr125[i311];
                return 0;
            case 157:
                Object[] objArr28 = this.PrepareContext;
                int i312 = this.initRecordTimeStamp;
                int i313 = i312 + 1;
                this.initRecordTimeStamp = i313;
                objArr28[i312] = objArr28[10];
                this.initRecordTimeStamp = i313 + 1;
                objArr28[i313] = objArr28[12];
                return 0;
            case 158:
                int[] iArr126 = this.GetContactSyncConfig;
                int i314 = this.initRecordTimeStamp;
                int i315 = i314 + 1;
                this.initRecordTimeStamp = i315;
                iArr126[i314] = 61;
                int i316 = i315 + 1;
                this.initRecordTimeStamp = i316;
                iArr126[i315] = iArr126[i316 - 2];
                this.initRecordTimeStamp = i316 + 1;
                iArr126[i316] = -1;
                return 0;
            case 159:
                int i317 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i317;
                int[] iArr127 = this.GetContactSyncConfig;
                iArr127[i317 - 1] = iArr127[i317 - 1] ^ iArr127[i317];
                int i318 = iArr127[i317 - 1];
                iArr127[i317 - 1] = iArr127[i317 - 2];
                iArr127[i317 - 2] = i318;
                int i319 = i317 - 1;
                this.initRecordTimeStamp = i319;
                this.PrepareContext[i319] = null;
                return 0;
            case BlobStatic.MONITOR_IMAGE_WIDTH /* 160 */:
                int[] iArr128 = this.GetContactSyncConfig;
                int i320 = this.initRecordTimeStamp;
                int i321 = i320 + 1;
                this.initRecordTimeStamp = i321;
                iArr128[i320] = 1;
                int i322 = i321 - 1;
                this.initRecordTimeStamp = i322;
                iArr128[i322 - 1] = iArr128[i322 - 1] - iArr128[i322];
                return 0;
            case 161:
                int[] iArr129 = this.GetContactSyncConfig;
                int i323 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i323 + 1;
                iArr129[i323] = 46;
                return 0;
            case 162:
                int[] iArr130 = this.GetContactSyncConfig;
                int i324 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i324 + 1;
                iArr130[i324] = 21;
                return 0;
            case 163:
                int[] iArr131 = this.GetContactSyncConfig;
                int i325 = this.initRecordTimeStamp;
                iArr131[i325 - 1] = -iArr131[i325 - 1];
                int i326 = i325 + 2;
                this.initRecordTimeStamp = i326;
                iArr131[i326 - 1] = iArr131[i326 - 3];
                iArr131[i325] = iArr131[i326 - 4];
                this.initRecordTimeStamp = i326 + 1;
                iArr131[i326] = -1;
                return 0;
            case 164:
                int i327 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i327;
                int[] iArr132 = this.GetContactSyncConfig;
                iArr132[i327 - 1] = iArr132[i327 - 1] << iArr132[i327];
                int i328 = i327 + 1;
                this.initRecordTimeStamp = i328;
                int i329 = iArr132[i328 - 2];
                iArr132[i327] = i329;
                iArr132[i328 - 2] = iArr132[i328 - 3];
                iArr132[i328 - 3] = iArr132[i328 - 4];
                iArr132[i328 - 4] = i329;
                return 0;
            case 165:
                int i330 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i330;
                this.PrepareContext[i330] = null;
                int[] iArr133 = this.GetContactSyncConfig;
                iArr133[i330 - 1] = -iArr133[i330 - 1];
                int i331 = i330 - 1;
                this.initRecordTimeStamp = i331;
                iArr133[i331 - 1] = iArr133[i331] ^ iArr133[i331 - 1];
                return 0;
            case 166:
                Object[] objArr29 = this.PrepareContext;
                int i332 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i332 + 1;
                objArr29[i332] = objArr29[12];
                return 0;
            case 167:
                int[] iArr134 = this.GetContactSyncConfig;
                int i333 = this.initRecordTimeStamp;
                int i334 = i333 + 1;
                this.initRecordTimeStamp = i334;
                iArr134[i333] = 5;
                this.initRecordTimeStamp = i334 + 1;
                iArr134[i334] = 2;
                return 0;
            case 168:
                int[] iArr135 = this.GetContactSyncConfig;
                int i335 = this.initRecordTimeStamp;
                iArr135[i335 - 1] = -iArr135[i335 - 1];
                int i336 = i335 + 2;
                this.initRecordTimeStamp = i336;
                iArr135[i336 - 1] = iArr135[i336 - 3];
                iArr135[i335] = iArr135[i336 - 4];
                int i337 = i336 + 2;
                this.initRecordTimeStamp = i337;
                iArr135[i337 - 1] = iArr135[i337 - 3];
                iArr135[i336] = iArr135[i337 - 4];
                return 0;
            case 169:
                int[] iArr136 = this.GetContactSyncConfig;
                int i338 = this.initRecordTimeStamp;
                int i339 = i338 + 1;
                this.initRecordTimeStamp = i339;
                int i340 = iArr136[i339 - 2];
                iArr136[i338] = i340;
                iArr136[i339 - 2] = iArr136[i339 - 3];
                iArr136[i339 - 3] = iArr136[i339 - 4];
                iArr136[i339 - 4] = i340;
                int i341 = i339 - 1;
                this.initRecordTimeStamp = i341;
                this.PrepareContext[i341] = null;
                int i342 = iArr136[i341 - 1];
                iArr136[i341 - 1] = iArr136[i341 - 2];
                iArr136[i341 - 2] = i342;
                return 0;
            case 170:
                int[] iArr137 = this.GetContactSyncConfig;
                int i343 = this.initRecordTimeStamp;
                int i344 = i343 + 1;
                this.initRecordTimeStamp = i344;
                iArr137[i343] = -1;
                int i345 = i344 - 1;
                this.initRecordTimeStamp = i345;
                iArr137[i345 - 1] = iArr137[i345 - 1] ^ iArr137[i345];
                int i346 = i345 - 1;
                this.initRecordTimeStamp = i346;
                iArr137[i346 - 1] = iArr137[i346] & iArr137[i346 - 1];
                return 0;
            case 171:
                int i347 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i347;
                int[] iArr138 = this.GetContactSyncConfig;
                iArr138[i347 - 1] = iArr138[i347 - 1] | iArr138[i347];
                int i348 = i347 + 1;
                this.initRecordTimeStamp = i348;
                int i349 = iArr138[i348 - 2];
                iArr138[i347] = i349;
                iArr138[i348 - 2] = iArr138[i348 - 3];
                iArr138[i348 - 3] = iArr138[i348 - 4];
                iArr138[i348 - 4] = i349;
                int i350 = i348 - 1;
                this.initRecordTimeStamp = i350;
                this.PrepareContext[i350] = null;
                return 0;
            case 172:
                int i351 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i351;
                int[] iArr139 = this.GetContactSyncConfig;
                iArr139[i351 - 1] = iArr139[i351 - 1] & iArr139[i351];
                int i352 = i351 + 1;
                this.initRecordTimeStamp = i352;
                iArr139[i351] = 1;
                int i353 = i352 - 1;
                this.initRecordTimeStamp = i353;
                iArr139[i353 - 1] = iArr139[i353 - 1] << iArr139[i353];
                return 0;
            case 173:
                int i354 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i354;
                this.PrepareContext[i354] = null;
                int i355 = i354 - 1;
                this.initRecordTimeStamp = i355;
                int[] iArr140 = this.GetContactSyncConfig;
                iArr140[i355 - 1] = iArr140[i355 - 1] ^ iArr140[i355];
                int i356 = i355 - 1;
                this.initRecordTimeStamp = i356;
                iArr140[i356 - 1] = iArr140[i356 - 1] - iArr140[i356];
                return 0;
            case 174:
                int i357 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i357;
                int[] iArr141 = this.GetContactSyncConfig;
                iArr141[i357 - 1] = iArr141[i357 - 1] & iArr141[i357];
                this.initRecordTimeStamp = i357 + 1;
                iArr141[i357] = 1;
                return 0;
            case 175:
                int[] iArr142 = this.GetContactSyncConfig;
                int i358 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i358 + 1;
                iArr142[i358] = 121;
                return 0;
            case 176:
                int[] iArr143 = this.GetContactSyncConfig;
                int i359 = this.initRecordTimeStamp;
                iArr143[i359 - 1] = -iArr143[i359 - 1];
                int i360 = i359 + 2;
                this.initRecordTimeStamp = i360;
                iArr143[i360 - 1] = iArr143[i360 - 3];
                iArr143[i359] = iArr143[i360 - 4];
                iArr143[i360 - 1] = -iArr143[i360 - 1];
                return 0;
            case 177:
                int[] iArr144 = this.GetContactSyncConfig;
                int i361 = this.initRecordTimeStamp;
                iArr144[i361 - 1] = -iArr144[i361 - 1];
                int i362 = i361 - 1;
                this.initRecordTimeStamp = i362;
                iArr144[i362 - 1] = iArr144[i362] | iArr144[i362 - 1];
                return 0;
            case 178:
                int[] iArr145 = this.GetContactSyncConfig;
                int i363 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i363 + 1;
                iArr145[i363] = 12;
                return 0;
            case 179:
                int[] iArr146 = this.GetContactSyncConfig;
                int i364 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i364 + 1;
                iArr146[i364] = 38;
                return 0;
            case 180:
                int[] iArr147 = this.GetContactSyncConfig;
                int i365 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i365 + 1;
                iArr147[i365] = 10;
                return 0;
            case 181:
                int[] iArr148 = this.GetContactSyncConfig;
                int i366 = this.initRecordTimeStamp;
                int i367 = i366 + 1;
                this.initRecordTimeStamp = i367;
                iArr148[i366] = 2;
                this.initRecordTimeStamp = i367 + 1;
                iArr148[i367] = 2;
                return 0;
            case 182:
                int i368 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i368;
                int[] iArr149 = this.GetContactSyncConfig;
                iArr149[i368 - 1] = iArr149[i368 - 1] % iArr149[i368];
                int i369 = i368 - 1;
                this.initRecordTimeStamp = i369;
                this.PrepareContext[i369] = null;
                return 0;
            case 183:
                int[] iArr150 = this.GetContactSyncConfig;
                int i370 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i370 + 1;
                iArr150[i370] = 47;
                return 0;
            case 184:
                int[] iArr151 = this.GetContactSyncConfig;
                int i371 = this.initRecordTimeStamp;
                int i372 = i371 + 1;
                this.initRecordTimeStamp = i372;
                iArr151[i371] = -1;
                int i373 = i372 - 1;
                this.initRecordTimeStamp = i373;
                iArr151[i373 - 1] = iArr151[i373 - 1] ^ iArr151[i373];
                int i374 = i373 - 1;
                this.initRecordTimeStamp = i374;
                iArr151[i374 - 1] = iArr151[i374] ^ iArr151[i374 - 1];
                return 0;
            case WSContextConstant.HANDSHAKE_RECEIVE_SIZE /* 185 */:
                int i375 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i375;
                int[] iArr152 = this.GetContactSyncConfig;
                iArr152[i375 - 1] = iArr152[i375 - 1] & iArr152[i375];
                int i376 = i375 + 1;
                this.initRecordTimeStamp = i376;
                int i377 = iArr152[i376 - 2];
                iArr152[i375] = i377;
                iArr152[i376 - 2] = iArr152[i376 - 3];
                iArr152[i376 - 3] = iArr152[i376 - 4];
                iArr152[i376 - 4] = i377;
                return 0;
            case 186:
                int i378 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i378;
                int[] iArr153 = this.GetContactSyncConfig;
                iArr153[i378 - 1] = iArr153[i378 - 1] & iArr153[i378];
                int i379 = i378 - 1;
                this.initRecordTimeStamp = i379;
                iArr153[i379 - 1] = iArr153[i379 - 1] | iArr153[i379];
                int i380 = i379 + 2;
                this.initRecordTimeStamp = i380;
                iArr153[i380 - 1] = iArr153[i380 - 3];
                iArr153[i379] = iArr153[i380 - 4];
                return 0;
            case 187:
                int[] iArr154 = this.GetContactSyncConfig;
                int i381 = this.initRecordTimeStamp;
                int i382 = i381 + 1;
                this.initRecordTimeStamp = i382;
                iArr154[i381] = 1;
                int i383 = i382 - 1;
                this.initRecordTimeStamp = i383;
                iArr154[i383 - 1] = iArr154[i383 - 1] << iArr154[i383];
                int i384 = i383 + 1;
                this.initRecordTimeStamp = i384;
                int i385 = iArr154[i384 - 2];
                iArr154[i383] = i385;
                iArr154[i384 - 2] = iArr154[i384 - 3];
                iArr154[i384 - 3] = iArr154[i384 - 4];
                iArr154[i384 - 4] = i385;
                return 0;
            case 188:
                int[] iArr155 = this.GetContactSyncConfig;
                int i386 = this.initRecordTimeStamp;
                int i387 = i386 + 1;
                this.initRecordTimeStamp = i387;
                iArr155[i386] = 9;
                iArr155[i387 - 1] = -iArr155[i387 - 1];
                return 0;
            case WSContextConstant.HANDSHAKE_SEND_SIZE /* 189 */:
                int[] iArr156 = this.GetContactSyncConfig;
                int i388 = this.initRecordTimeStamp;
                int i389 = i388 + 1;
                this.initRecordTimeStamp = i389;
                iArr156[i388] = iArr156[i389 - 2];
                iArr156[i389 - 1] = -iArr156[i389 - 1];
                return 0;
            case 190:
                int i390 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i390;
                int[] iArr157 = this.GetContactSyncConfig;
                iArr157[i390 - 1] = iArr157[i390 - 1] | iArr157[i390];
                int i391 = iArr157[i390 - 1];
                iArr157[i390 - 1] = iArr157[i390 - 2];
                iArr157[i390 - 2] = i391;
                return 0;
            case 191:
                int[] iArr158 = this.GetContactSyncConfig;
                int i392 = this.initRecordTimeStamp;
                int i393 = i392 + 2;
                this.initRecordTimeStamp = i393;
                iArr158[i393 - 1] = iArr158[i393 - 3];
                iArr158[i392] = iArr158[i393 - 4];
                int i394 = i393 - 1;
                this.initRecordTimeStamp = i394;
                iArr158[i394 - 1] = iArr158[i394 - 1] & iArr158[i394];
                int i395 = i394 + 1;
                this.initRecordTimeStamp = i395;
                int i396 = iArr158[i395 - 2];
                iArr158[i394] = i396;
                iArr158[i395 - 2] = iArr158[i395 - 3];
                iArr158[i395 - 3] = iArr158[i395 - 4];
                iArr158[i395 - 4] = i396;
                return 0;
            case 192:
                int[] iArr159 = this.GetContactSyncConfig;
                int i397 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i397 + 1;
                iArr159[i397] = 77;
                return 0;
            case 193:
                int[] iArr160 = this.GetContactSyncConfig;
                int i398 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i398 + 1;
                iArr160[i398] = 0;
                return 0;
            case 194:
                int[] iArr161 = this.GetContactSyncConfig;
                int i399 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i399 + 1;
                iArr161[i399] = 101;
                return 0;
            case 195:
                int[] iArr162 = this.GetContactSyncConfig;
                int i400 = this.initRecordTimeStamp;
                int i401 = i400 + 2;
                this.initRecordTimeStamp = i401;
                iArr162[i401 - 1] = iArr162[i401 - 3];
                iArr162[i400] = iArr162[i401 - 4];
                int i402 = i401 - 1;
                this.initRecordTimeStamp = i402;
                iArr162[i402 - 1] = iArr162[i402 - 1] ^ iArr162[i402];
                int i403 = i402 + 1;
                this.initRecordTimeStamp = i403;
                int i404 = iArr162[i403 - 2];
                iArr162[i402] = i404;
                iArr162[i403 - 2] = iArr162[i403 - 3];
                iArr162[i403 - 3] = iArr162[i403 - 4];
                iArr162[i403 - 4] = i404;
                return 0;
            case 196:
                int i405 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i405;
                int[] iArr163 = this.GetContactSyncConfig;
                iArr163[i405 - 1] = iArr163[i405 - 1] | iArr163[i405];
                int i406 = i405 + 1;
                this.initRecordTimeStamp = i406;
                iArr163[i405] = 1;
                int i407 = i406 - 1;
                this.initRecordTimeStamp = i407;
                iArr163[i407 - 1] = iArr163[i407 - 1] << iArr163[i407];
                return 0;
            case 197:
                Object[] objArr30 = this.PrepareContext;
                int i408 = this.initRecordTimeStamp;
                int i409 = i408 + 1;
                this.initRecordTimeStamp = i409;
                objArr30[i408] = objArr30[i409 - 2];
                int i410 = i409 - 1;
                this.initRecordTimeStamp = i410;
                Object obj15 = objArr30[i410];
                objArr30[i410] = null;
                objArr30[13] = obj15;
                return 0;
            case 198:
                Object[] objArr31 = this.PrepareContext;
                int i411 = this.initRecordTimeStamp;
                int i412 = i411 + 1;
                this.initRecordTimeStamp = i412;
                objArr31[i411] = objArr31[10];
                this.initRecordTimeStamp = i412 + 1;
                objArr31[i412] = objArr31[13];
                return 0;
            case SecExceptionCode.SEC_ERROR_INIT_UNKNOWN_ERROR /* 199 */:
                int[] iArr164 = this.GetContactSyncConfig;
                int i413 = this.initRecordTimeStamp;
                int i414 = i413 + 1;
                this.initRecordTimeStamp = i414;
                iArr164[i413] = 47;
                int i415 = i414 + 1;
                this.initRecordTimeStamp = i415;
                iArr164[i414] = 0;
                int i416 = i415 - 1;
                this.initRecordTimeStamp = i416;
                iArr164[i416 - 1] = iArr164[i416 - 1] / iArr164[i416];
                return 0;
            case 200:
                int[] iArr165 = this.GetContactSyncConfig;
                int i417 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i417 + 1;
                iArr165[i417] = 8;
                return 0;
            case 201:
                int[] iArr166 = this.GetContactSyncConfig;
                int i418 = this.initRecordTimeStamp;
                int i419 = i418 + 1;
                this.initRecordTimeStamp = i419;
                iArr166[i418] = 15;
                iArr166[i419 - 1] = -iArr166[i419 - 1];
                return 0;
            case 202:
                int[] iArr167 = this.GetContactSyncConfig;
                int i420 = this.initRecordTimeStamp;
                int i421 = i420 + 1;
                this.initRecordTimeStamp = i421;
                iArr167[i420] = iArr167[i421 - 2];
                iArr167[i421 - 1] = -iArr167[i421 - 1];
                this.initRecordTimeStamp = i421 + 1;
                iArr167[i421] = -1;
                return 0;
            case 203:
                int i422 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i422;
                int[] iArr168 = this.GetContactSyncConfig;
                iArr168[i422 - 1] = iArr168[i422 - 1] ^ iArr168[i422];
                int i423 = i422 - 1;
                this.initRecordTimeStamp = i423;
                iArr168[i423 - 1] = iArr168[i423 - 1] & iArr168[i423];
                int i424 = i423 - 1;
                this.initRecordTimeStamp = i424;
                iArr168[i424 - 1] = iArr168[i424] | iArr168[i424 - 1];
                return 0;
            case 204:
                int i425 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i425;
                this.PrepareContext[i425] = null;
                int[] iArr169 = this.GetContactSyncConfig;
                int i426 = i425 + 2;
                this.initRecordTimeStamp = i426;
                iArr169[i426 - 1] = iArr169[i426 - 3];
                iArr169[i425] = iArr169[i426 - 4];
                iArr169[i426 - 1] = -iArr169[i426 - 1];
                return 0;
            case 205:
                int[] iArr170 = this.GetContactSyncConfig;
                int i427 = this.initRecordTimeStamp;
                iArr170[i427 - 1] = -iArr170[i427 - 1];
                int i428 = i427 - 1;
                this.initRecordTimeStamp = i428;
                iArr170[i428 - 1] = iArr170[i428 - 1] | iArr170[i428];
                int i429 = i428 - 1;
                this.initRecordTimeStamp = i429;
                iArr170[i429 - 1] = iArr170[i429 - 1] + iArr170[i429];
                return 0;
            case 206:
                int[] iArr171 = this.GetContactSyncConfig;
                int i430 = this.initRecordTimeStamp;
                iArr171[i430 - 1] = -iArr171[i430 - 1];
                int i431 = i430 - 1;
                this.initRecordTimeStamp = i431;
                iArr171[i431 - 1] = iArr171[i431 - 1] ^ iArr171[i431];
                int i432 = i431 + 1;
                this.initRecordTimeStamp = i432;
                int i433 = iArr171[i432 - 2];
                iArr171[i431] = i433;
                iArr171[i432 - 2] = iArr171[i432 - 3];
                iArr171[i432 - 3] = iArr171[i432 - 4];
                iArr171[i432 - 4] = i433;
                return 0;
            case 207:
                int i434 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i434;
                this.PrepareContext[i434] = null;
                int[] iArr172 = this.GetContactSyncConfig;
                iArr172[i434 - 1] = -iArr172[i434 - 1];
                int i435 = i434 - 1;
                this.initRecordTimeStamp = i435;
                iArr172[i435 - 1] = iArr172[i435] & iArr172[i435 - 1];
                return 0;
            case 208:
                int[] iArr173 = this.GetContactSyncConfig;
                int i436 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i436 + 1;
                iArr173[i436] = 107;
                return 0;
            case 209:
                int i437 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i437;
                this.PrepareContext[i437] = null;
                int[] iArr174 = this.GetContactSyncConfig;
                int i438 = iArr174[i437 - 1];
                iArr174[i437 - 1] = iArr174[i437 - 2];
                iArr174[i437 - 2] = i438;
                return 0;
            case 210:
                int i439 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i439;
                Object[] objArr32 = this.PrepareContext;
                Object obj16 = objArr32[i439];
                objArr32[i439] = null;
                objArr32[12] = obj16;
                this.initRecordTimeStamp = i439 + 1;
                objArr32[i439] = objArr32[11];
                return 0;
            case 211:
                int[] iArr175 = this.GetContactSyncConfig;
                int i440 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i440 + 1;
                iArr175[i440] = 63;
                return 0;
            case SecExceptionCode.SEC_ERROR_STA_STORE_LOW_VERSION_DATA_FILE /* 212 */:
                int i441 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i441;
                int[] iArr176 = this.GetContactSyncConfig;
                iArr176[i441 - 1] = iArr176[i441 - 1] ^ iArr176[i441];
                int i442 = i441 - 1;
                this.initRecordTimeStamp = i442;
                this.PrepareContext[i442] = null;
                return 0;
            case 213:
                int i443 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i443;
                int[] iArr177 = this.GetContactSyncConfig;
                iArr177[i443 - 1] = iArr177[i443 - 1] & iArr177[i443];
                int i444 = i443 - 1;
                this.initRecordTimeStamp = i444;
                iArr177[i444 - 1] = iArr177[i444 - 1] | iArr177[i444];
                int i445 = i444 - 1;
                this.initRecordTimeStamp = i445;
                iArr177[i445 - 1] = iArr177[i445 - 1] + iArr177[i445];
                return 0;
            case 214:
                int i446 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i446;
                Object[] objArr33 = this.PrepareContext;
                Object obj17 = objArr33[i446];
                objArr33[i446] = null;
                objArr33[11] = obj17;
                return 0;
            case 215:
                Object[] objArr34 = this.PrepareContext;
                int i447 = this.initRecordTimeStamp;
                int i448 = i447 + 1;
                this.initRecordTimeStamp = i448;
                objArr34[i447] = null;
                Object obj18 = objArr34[i448 - 1];
                objArr34[i448 - 1] = null;
                this.GetContactSyncConfig[i448 - 1] = ((int[]) obj18).length;
                int i449 = i448 - 1;
                this.initRecordTimeStamp = i449;
                objArr34[i449] = null;
                return 0;
            case 216:
                int[] iArr178 = this.GetContactSyncConfig;
                int i450 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i450 + 1;
                iArr178[i450] = 14;
                return 0;
            case FileUtils.JPEG_MARKER_EOI /* 217 */:
                int[] iArr179 = this.GetContactSyncConfig;
                int i451 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i451 + 1;
                iArr179[i451] = 87;
                return 0;
            case 218:
                int[] iArr180 = this.GetContactSyncConfig;
                int i452 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i452 + 1;
                iArr180[i452] = 65;
                return 0;
            case 219:
                int[] iArr181 = this.GetContactSyncConfig;
                int i453 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i453 + 1;
                iArr181[i453] = 25;
                return 0;
            case WheelView.DIVIDER_ALPHA /* 220 */:
                int[] iArr182 = this.GetContactSyncConfig;
                int i454 = this.initRecordTimeStamp;
                int i455 = i454 + 1;
                this.initRecordTimeStamp = i455;
                iArr182[i454] = 5;
                int i456 = i455 - 1;
                this.initRecordTimeStamp = i456;
                iArr182[i456 - 1] = iArr182[i456 - 1] + iArr182[i456];
                return 0;
            case 221:
                int[] iArr183 = this.GetContactSyncConfig;
                int i457 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i457 + 1;
                iArr183[i457] = 31;
                return 0;
            case 222:
                Object[] objArr35 = this.PrepareContext;
                int i458 = this.initRecordTimeStamp;
                int i459 = i458 + 1;
                this.initRecordTimeStamp = i459;
                objArr35[i458] = objArr35[12];
                this.initRecordTimeStamp = i459 + 1;
                objArr35[i459] = objArr35[13];
                return 0;
            case 223:
                int[] iArr184 = this.GetContactSyncConfig;
                int i460 = this.initRecordTimeStamp;
                int i461 = i460 + 1;
                this.initRecordTimeStamp = i461;
                iArr184[i460] = 93;
                int i462 = i461 + 1;
                this.initRecordTimeStamp = i462;
                iArr184[i461] = 0;
                int i463 = i462 - 1;
                this.initRecordTimeStamp = i463;
                iArr184[i463 - 1] = iArr184[i463 - 1] / iArr184[i463];
                return 0;
            case 224:
                int[] iArr185 = this.GetContactSyncConfig;
                int i464 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i464 + 1;
                iArr185[i464] = 16;
                return 0;
            case 225:
                int[] iArr186 = this.GetContactSyncConfig;
                int i465 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i465 + 1;
                iArr186[i465] = 37;
                return 0;
            case 226:
                int[] iArr187 = this.GetContactSyncConfig;
                int i466 = this.initRecordTimeStamp;
                int i467 = i466 + 2;
                this.initRecordTimeStamp = i467;
                iArr187[i467 - 1] = iArr187[i467 - 3];
                iArr187[i466] = iArr187[i467 - 4];
                int i468 = i467 - 1;
                this.initRecordTimeStamp = i468;
                iArr187[i468 - 1] = iArr187[i468] & iArr187[i468 - 1];
                return 0;
            case 227:
                int i469 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i469;
                int[] iArr188 = this.GetContactSyncConfig;
                iArr188[i469 - 1] = iArr188[i469 - 1] & iArr188[i469];
                iArr188[i469 - 1] = -iArr188[i469 - 1];
                return 0;
            case 228:
                int[] iArr189 = this.GetContactSyncConfig;
                int i470 = this.initRecordTimeStamp;
                int i471 = i470 + 1;
                this.initRecordTimeStamp = i471;
                int i472 = iArr189[i471 - 2];
                iArr189[i470] = i472;
                iArr189[i471 - 2] = iArr189[i471 - 3];
                iArr189[i471 - 3] = iArr189[i471 - 4];
                iArr189[i471 - 4] = i472;
                int i473 = i471 - 1;
                this.initRecordTimeStamp = i473;
                this.PrepareContext[i473] = null;
                int i474 = i473 - 1;
                this.initRecordTimeStamp = i474;
                iArr189[i474 - 1] = iArr189[i474] & iArr189[i474 - 1];
                return 0;
            case 229:
                int[] iArr190 = this.GetContactSyncConfig;
                int i475 = this.initRecordTimeStamp;
                Object[] objArr36 = this.PrepareContext;
                Object obj19 = objArr36[i475 - 1];
                objArr36[i475 - 1] = null;
                iArr190[i475 - 1] = ((int[]) obj19).length;
                int i476 = i475 - 1;
                this.initRecordTimeStamp = i476;
                objArr36[i476] = null;
                return 0;
            case 230:
                int[] iArr191 = this.GetContactSyncConfig;
                int i477 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i477 + 1;
                iArr191[i477] = 61;
                return 0;
            case 231:
                int[] iArr192 = this.GetContactSyncConfig;
                int i478 = this.initRecordTimeStamp;
                int i479 = i478 + 1;
                this.initRecordTimeStamp = i479;
                int i480 = iArr192[i479 - 2];
                iArr192[i478] = i480;
                iArr192[i479 - 2] = iArr192[i479 - 3];
                iArr192[i479 - 3] = iArr192[i479 - 4];
                iArr192[i479 - 4] = i480;
                int i481 = i479 - 1;
                this.initRecordTimeStamp = i481;
                this.PrepareContext[i481] = null;
                iArr192[i481 - 1] = -iArr192[i481 - 1];
                return 0;
            case 232:
                int i482 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i482;
                this.PrepareContext[i482] = null;
                int i483 = i482 - 1;
                this.initRecordTimeStamp = i483;
                int[] iArr193 = this.GetContactSyncConfig;
                iArr193[i483 - 1] = iArr193[i483 - 1] | iArr193[i483];
                int i484 = i483 - 1;
                this.initRecordTimeStamp = i484;
                iArr193[i484 - 1] = iArr193[i484 - 1] + iArr193[i484];
                return 0;
            case 233:
                int[] iArr194 = this.GetContactSyncConfig;
                int i485 = this.initRecordTimeStamp;
                int i486 = i485 + 1;
                this.initRecordTimeStamp = i486;
                iArr194[i485] = 55;
                int i487 = i486 + 2;
                this.initRecordTimeStamp = i487;
                iArr194[i487 - 1] = iArr194[i487 - 3];
                iArr194[i486] = iArr194[i487 - 4];
                return 0;
            case 234:
                int[] iArr195 = this.GetContactSyncConfig;
                int i488 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i488 + 1;
                iArr195[i488] = 99;
                return 0;
            case 235:
                int[] iArr196 = this.GetContactSyncConfig;
                int i489 = this.initRecordTimeStamp;
                int i490 = i489 + 1;
                this.initRecordTimeStamp = i490;
                iArr196[i489] = 43;
                iArr196[i490 - 1] = -iArr196[i490 - 1];
                return 0;
            case 236:
                int[] iArr197 = this.GetContactSyncConfig;
                int i491 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i491 + 1;
                iArr197[i491] = 19;
                return 0;
            case 237:
                int[] iArr198 = this.GetContactSyncConfig;
                int i492 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i492 + 1;
                iArr198[i492] = 60;
                return 0;
            case 238:
                int[] iArr199 = this.GetContactSyncConfig;
                int i493 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i493 + 1;
                iArr199[i493] = 113;
                return 0;
            case 239:
                int[] iArr200 = this.GetContactSyncConfig;
                int i494 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i494 + 1;
                iArr200[i494] = 4;
                return 0;
            case 240:
                int[] iArr201 = this.GetContactSyncConfig;
                int i495 = this.initRecordTimeStamp;
                int i496 = i495 + 1;
                this.initRecordTimeStamp = i496;
                iArr201[i495] = 2;
                int i497 = i496 - 1;
                this.initRecordTimeStamp = i497;
                iArr201[i497 - 1] = iArr201[i497 - 1] % iArr201[i497];
                int i498 = i497 - 1;
                this.initRecordTimeStamp = i498;
                this.PrepareContext[i498] = null;
                return 0;
            case 241:
                Object[] objArr37 = this.PrepareContext;
                int i499 = this.initRecordTimeStamp;
                int i500 = i499 + 1;
                this.initRecordTimeStamp = i500;
                objArr37[i499] = null;
                Object obj20 = objArr37[i500 - 1];
                objArr37[i500 - 1] = null;
                this.GetContactSyncConfig[i500 - 1] = ((int[]) obj20).length;
                return 0;
            case 242:
                int i501 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i501;
                int[] iArr202 = this.GetContactSyncConfig;
                iArr202[i501 - 1] = iArr202[i501 - 1] & iArr202[i501];
                int i502 = i501 - 1;
                this.initRecordTimeStamp = i502;
                iArr202[i502 - 1] = iArr202[i502] | iArr202[i502 - 1];
                return 0;
            case 243:
                int i503 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i503;
                int[] iArr203 = this.GetContactSyncConfig;
                iArr203[i503 - 1] = iArr203[i503 - 1] | iArr203[i503];
                iArr203[i503 - 1] = -iArr203[i503 - 1];
                return 0;
            case 244:
                int[] iArr204 = this.GetContactSyncConfig;
                int i504 = this.initRecordTimeStamp;
                iArr204[i504 - 1] = -iArr204[i504 - 1];
                int i505 = i504 + 2;
                this.initRecordTimeStamp = i505;
                iArr204[i505 - 1] = iArr204[i505 - 3];
                iArr204[i504] = iArr204[i505 - 4];
                int i506 = i505 - 1;
                this.initRecordTimeStamp = i506;
                iArr204[i506 - 1] = iArr204[i506] ^ iArr204[i506 - 1];
                return 0;
            case 245:
                int[] iArr205 = this.GetContactSyncConfig;
                int i507 = this.initRecordTimeStamp;
                int i508 = i507 + 1;
                this.initRecordTimeStamp = i508;
                iArr205[i507] = 79;
                int i509 = i508 - 1;
                this.initRecordTimeStamp = i509;
                iArr205[i509 - 1] = iArr205[i509 - 1] + iArr205[i509];
                int i510 = i509 + 1;
                this.initRecordTimeStamp = i510;
                iArr205[i509] = iArr205[i510 - 2];
                return 0;
            case 246:
                int[] iArr206 = this.GetContactSyncConfig;
                int i511 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i511 + 1;
                iArr206[i511] = 48;
                return 0;
            case 247:
                int[] iArr207 = this.GetContactSyncConfig;
                int i512 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i512 + 1;
                iArr207[i512] = 109;
                return 0;
            case 248:
                int[] iArr208 = this.GetContactSyncConfig;
                int i513 = this.initRecordTimeStamp;
                iArr208[i513 - 1] = -iArr208[i513 - 1];
                int i514 = i513 + 1;
                this.initRecordTimeStamp = i514;
                iArr208[i513] = -1;
                int i515 = i514 + 2;
                this.initRecordTimeStamp = i515;
                iArr208[i515 - 1] = iArr208[i515 - 3];
                iArr208[i514] = iArr208[i515 - 4];
                return 0;
            case 249:
                int i516 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i516;
                int[] iArr209 = this.GetContactSyncConfig;
                iArr209[i516 - 1] = iArr209[i516 - 1] ^ iArr209[i516];
                int i517 = i516 - 1;
                this.initRecordTimeStamp = i517;
                iArr209[i517 - 1] = iArr209[i517 - 1] & iArr209[i517];
                int i518 = i517 + 1;
                this.initRecordTimeStamp = i518;
                int i519 = iArr209[i518 - 2];
                iArr209[i517] = i519;
                iArr209[i518 - 2] = iArr209[i518 - 3];
                iArr209[i518 - 3] = iArr209[i518 - 4];
                iArr209[i518 - 4] = i519;
                return 0;
            case 250:
                int[] iArr210 = this.GetContactSyncConfig;
                int i520 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i520 + 1;
                iArr210[i520] = 4;
                return 0;
            case 251:
                int[] iArr211 = this.GetContactSyncConfig;
                int i521 = this.initRecordTimeStamp;
                int i522 = i521 + 1;
                this.initRecordTimeStamp = i522;
                iArr211[i521] = 61;
                int i523 = i522 + 2;
                this.initRecordTimeStamp = i523;
                iArr211[i523 - 1] = iArr211[i523 - 3];
                iArr211[i522] = iArr211[i523 - 4];
                int i524 = i523 + 2;
                this.initRecordTimeStamp = i524;
                iArr211[i524 - 1] = iArr211[i524 - 3];
                iArr211[i523] = iArr211[i524 - 4];
                return 0;
            case 252:
                int[] iArr212 = this.GetContactSyncConfig;
                int i525 = this.initRecordTimeStamp;
                int i526 = i525 + 1;
                this.initRecordTimeStamp = i526;
                iArr212[i525] = -1;
                int i527 = i526 - 1;
                this.initRecordTimeStamp = i527;
                iArr212[i527 - 1] = iArr212[i527 - 1] ^ iArr212[i527];
                int i528 = iArr212[i527 - 1];
                iArr212[i527 - 1] = iArr212[i527 - 2];
                iArr212[i527 - 2] = i528;
                return 0;
            case 253:
                Object[] objArr38 = this.PrepareContext;
                int i529 = this.initRecordTimeStamp;
                int i530 = i529 + 1;
                this.initRecordTimeStamp = i530;
                objArr38[i529] = objArr38[12];
                int[] iArr213 = this.GetContactSyncConfig;
                this.initRecordTimeStamp = i530 + 1;
                iArr213[i530] = 0;
                return 0;
            case 254:
                int[] iArr214 = this.GetContactSyncConfig;
                int i531 = this.initRecordTimeStamp;
                int i532 = i531 + 1;
                this.initRecordTimeStamp = i532;
                iArr214[i531] = 29;
                iArr214[i532 - 1] = -iArr214[i532 - 1];
                return 0;
            case 255:
                int[] iArr215 = this.GetContactSyncConfig;
                int i533 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i533 + 1;
                iArr215[i533] = 125;
                return 0;
            case 256:
                int i534 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i534;
                int[] iArr216 = this.GetContactSyncConfig;
                iArr216[i534 - 1] = iArr216[i534 - 1] & iArr216[i534];
                int i535 = iArr216[i534 - 1];
                iArr216[i534 - 1] = iArr216[i534 - 2];
                iArr216[i534 - 2] = i535;
                int i536 = i534 - 1;
                this.initRecordTimeStamp = i536;
                this.PrepareContext[i536] = null;
                return 0;
            case DeepRecoverARiverProxy.TYPE_ENTITY_APP /* 257 */:
                int[] iArr217 = this.GetContactSyncConfig;
                int i537 = this.initRecordTimeStamp;
                int i538 = i537 + 1;
                this.initRecordTimeStamp = i538;
                iArr217[i537] = iArr217[i538 - 2];
                this.initRecordTimeStamp = i538 + 1;
                iArr217[i538] = -1;
                return 0;
            case DeepRecoverARiverProxy.TYPE_ENTITY_TEMPLATE /* 258 */:
                int[] iArr218 = this.GetContactSyncConfig;
                int i539 = this.initRecordTimeStamp;
                int i540 = i539 + 1;
                this.initRecordTimeStamp = i540;
                iArr218[i539] = 1;
                int i541 = i540 - 1;
                this.initRecordTimeStamp = i541;
                iArr218[i541 - 1] = iArr218[i541 - 1] - iArr218[i541];
                this.initRecordTimeStamp = i541 + 1;
                iArr218[i541] = 1;
                return 0;
            case DeepRecoverARiverProxy.TYPE_ENTITY_PLUGIN /* 259 */:
                int[] iArr219 = this.GetContactSyncConfig;
                int i542 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i542 + 1;
                iArr219[i542] = 27;
                return 0;
            case DeepRecoverARiverProxy.TYPE_ENTITY_TA_PAGE /* 260 */:
                int[] iArr220 = this.GetContactSyncConfig;
                int i543 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i543 + 1;
                iArr220[i543] = 84;
                return 0;
            case DeepRecoverARiverProxy.TYPE_ENTITY_ONLINE_PAGE /* 261 */:
                int i544 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i544;
                int[] iArr221 = this.GetContactSyncConfig;
                iArr221[i544 - 1] = iArr221[i544 - 1] | iArr221[i544];
                int i545 = i544 - 1;
                this.initRecordTimeStamp = i545;
                iArr221[i545 - 1] = iArr221[i545 - 1] - iArr221[i545];
                int i546 = i545 + 1;
                this.initRecordTimeStamp = i546;
                iArr221[i545] = iArr221[i546 - 2];
                return 0;
            case 262:
                int[] iArr222 = this.GetContactSyncConfig;
                int i547 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i547 + 1;
                iArr222[i547] = 97;
                return 0;
            case 263:
                int i548 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i548;
                int[] iArr223 = this.GetContactSyncConfig;
                iArr223[i548 - 1] = iArr223[i548 - 1] & iArr223[i548];
                int i549 = iArr223[i548 - 1];
                iArr223[i548 - 1] = iArr223[i548 - 2];
                iArr223[i548 - 2] = i549;
                return 0;
            case 264:
                int[] iArr224 = this.GetContactSyncConfig;
                int i550 = this.initRecordTimeStamp;
                int i551 = i550 + 1;
                this.initRecordTimeStamp = i551;
                iArr224[i550] = 1;
                int i552 = i551 + 2;
                this.initRecordTimeStamp = i552;
                iArr224[i552 - 1] = iArr224[i552 - 3];
                iArr224[i551] = iArr224[i552 - 4];
                iArr224[i552 - 1] = -iArr224[i552 - 1];
                return 0;
            case 265:
                int[] iArr225 = this.GetContactSyncConfig;
                int i553 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i553 + 1;
                iArr225[i553] = 71;
                return 0;
            case 266:
                int i554 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i554;
                int[] iArr226 = this.GetContactSyncConfig;
                iArr226[i554 - 1] = iArr226[i554 - 1] & iArr226[i554];
                int i555 = i554 - 1;
                this.initRecordTimeStamp = i555;
                iArr226[i555 - 1] = iArr226[i555 - 1] | iArr226[i555];
                iArr226[i555 - 1] = -iArr226[i555 - 1];
                return 0;
            case 267:
                int[] iArr227 = this.GetContactSyncConfig;
                int i556 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i556 + 1;
                iArr227[i556] = 68;
                return 0;
            case 268:
                int i557 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i557;
                Object[] objArr39 = this.PrepareContext;
                Object obj21 = objArr39[i557];
                objArr39[i557] = null;
                objArr39[12] = obj21;
                this.initRecordTimeStamp = i557 + 1;
                objArr39[i557] = objArr39[10];
                return 0;
            case 269:
                int[] iArr228 = this.GetContactSyncConfig;
                int i558 = this.initRecordTimeStamp;
                int i559 = i558 + 1;
                this.initRecordTimeStamp = i559;
                iArr228[i558] = 5;
                int i560 = i559 + 2;
                this.initRecordTimeStamp = i560;
                iArr228[i560 - 1] = iArr228[i560 - 3];
                iArr228[i559] = iArr228[i560 - 4];
                return 0;
            case 270:
                int[] iArr229 = this.GetContactSyncConfig;
                int i561 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i561 + 1;
                iArr229[i561] = 15;
                return 0;
            case 271:
                int[] iArr230 = this.GetContactSyncConfig;
                int i562 = this.initRecordTimeStamp;
                int i563 = i562 + 1;
                this.initRecordTimeStamp = i563;
                iArr230[i562] = 103;
                iArr230[i563 - 1] = -iArr230[i563 - 1];
                return 0;
            case LZMA_Base.kNumLenSymbols /* 272 */:
                int i564 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i564;
                int[] iArr231 = this.GetContactSyncConfig;
                iArr231[i564 - 1] = iArr231[i564 - 1] & iArr231[i564];
                int i565 = i564 + 2;
                this.initRecordTimeStamp = i565;
                iArr231[i565 - 1] = iArr231[i565 - 3];
                iArr231[i564] = iArr231[i565 - 4];
                return 0;
            case LZMA_Base.kMatchMaxLen /* 273 */:
                int[] iArr232 = this.GetContactSyncConfig;
                int i566 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i566 + 1;
                iArr232[i566] = 7;
                return 0;
            case 274:
                int[] iArr233 = this.GetContactSyncConfig;
                int i567 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i567 + 1;
                iArr233[i567] = 5;
                return 0;
            case 275:
                int[] iArr234 = this.GetContactSyncConfig;
                int i568 = this.initRecordTimeStamp;
                int i569 = i568 + 2;
                this.initRecordTimeStamp = i569;
                iArr234[i569 - 1] = iArr234[i569 - 3];
                iArr234[i568] = iArr234[i569 - 4];
                int i570 = i569 + 2;
                this.initRecordTimeStamp = i570;
                iArr234[i570 - 1] = iArr234[i570 - 3];
                iArr234[i569] = iArr234[i570 - 4];
                int i571 = i570 - 1;
                this.initRecordTimeStamp = i571;
                iArr234[i571 - 1] = iArr234[i571] & iArr234[i571 - 1];
                return 0;
            case 276:
                int[] iArr235 = this.GetContactSyncConfig;
                int i572 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i572 + 1;
                iArr235[i572] = 36;
                return 0;
            case 277:
                int i573 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i573;
                int[] iArr236 = this.GetContactSyncConfig;
                iArr236[12] = iArr236[i573];
                return 0;
            case 278:
                int i574 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i574;
                int[] iArr237 = this.GetContactSyncConfig;
                iArr237[11] = iArr237[i574];
                return 0;
            case 279:
                int[] iArr238 = this.GetContactSyncConfig;
                int i575 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i575 + 1;
                iArr238[i575] = iArr238[12];
                return 0;
            case 280:
                int[] iArr239 = this.GetContactSyncConfig;
                int i576 = this.initRecordTimeStamp;
                int i577 = iArr239[i576 - 1];
                iArr239[i576 - 1] = iArr239[i576 - 2];
                iArr239[i576 - 2] = i577;
                int i578 = i576 + 1;
                this.initRecordTimeStamp = i578;
                iArr239[i576] = -1;
                int i579 = i578 - 1;
                this.initRecordTimeStamp = i579;
                iArr239[i579 - 1] = iArr239[i579] ^ iArr239[i579 - 1];
                return 0;
            case 281:
                int i580 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i580;
                int[] iArr240 = this.GetContactSyncConfig;
                iArr240[i580 - 1] = iArr240[i580 - 1] | iArr240[i580];
                int i581 = i580 - 1;
                this.initRecordTimeStamp = i581;
                iArr240[i581 - 1] = iArr240[i581 - 1] - iArr240[i581];
                return 0;
            case 282:
                int i582 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i582;
                int[] iArr241 = this.GetContactSyncConfig;
                iArr241[13] = iArr241[i582];
                return 0;
            case 283:
                int[] iArr242 = this.GetContactSyncConfig;
                int i583 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i583 + 1;
                iArr242[i583] = iArr242[13];
                return 0;
            case 284:
                int[] iArr243 = this.GetContactSyncConfig;
                int i584 = this.initRecordTimeStamp;
                int i585 = i584 + 1;
                this.initRecordTimeStamp = i585;
                iArr243[i584] = 0;
                int i586 = i585 - 1;
                this.initRecordTimeStamp = i586;
                iArr243[13] = iArr243[i586];
                return 0;
            case 285:
                int i587 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i587;
                int[] iArr244 = this.GetContactSyncConfig;
                iArr244[i587 - 1] = iArr244[i587 - 1] | iArr244[i587];
                int i588 = i587 - 1;
                this.initRecordTimeStamp = i588;
                iArr244[i588 - 1] = iArr244[i588 - 1] + iArr244[i588];
                return 0;
            case 286:
                int[] iArr245 = this.GetContactSyncConfig;
                int i589 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i589 + 1;
                iArr245[i589] = 103;
                return 0;
            case 287:
                int[] iArr246 = this.GetContactSyncConfig;
                int i590 = this.initRecordTimeStamp;
                int i591 = i590 + 2;
                this.initRecordTimeStamp = i591;
                iArr246[i591 - 1] = iArr246[i591 - 3];
                iArr246[i590] = iArr246[i591 - 4];
                int i592 = i591 - 1;
                this.initRecordTimeStamp = i592;
                iArr246[i592 - 1] = iArr246[i592 - 1] & iArr246[i592];
                this.initRecordTimeStamp = i592 + 1;
                iArr246[i592] = -1;
                return 0;
            case 288:
                int i593 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i593;
                int[] iArr247 = this.GetContactSyncConfig;
                iArr247[i593 - 1] = iArr247[i593 - 1] << iArr247[i593];
                int i594 = i593 - 1;
                this.initRecordTimeStamp = i594;
                iArr247[i594 - 1] = iArr247[i594 - 1] + iArr247[i594];
                this.initRecordTimeStamp = i594 + 1;
                iArr247[i594] = 1;
                return 0;
            case 289:
                int i595 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i595;
                int[] iArr248 = this.GetContactSyncConfig;
                iArr248[i595 - 1] = iArr248[i595 - 1] << iArr248[i595];
                int i596 = i595 - 1;
                this.initRecordTimeStamp = i596;
                iArr248[i596 - 1] = iArr248[i596 - 1] + iArr248[i596];
                return 0;
            case 290:
                this.KClassImpl$Data$declaredNonStaticMembers$2 = this.GetContactSyncConfig[this.initRecordTimeStamp - 1];
                return 0;
            case 291:
                int[] iArr249 = this.GetContactSyncConfig;
                int i597 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i597 + 1;
                iArr249[i597] = 70;
                return 0;
            case 292:
                int[] iArr250 = this.GetContactSyncConfig;
                int i598 = this.initRecordTimeStamp;
                int i599 = i598 + 1;
                this.initRecordTimeStamp = i599;
                iArr250[i598] = 23;
                this.initRecordTimeStamp = i599 + 1;
                iArr250[i599] = 0;
                return 0;
            case 293:
                int i600 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i600;
                int[] iArr251 = this.GetContactSyncConfig;
                iArr251[i600 - 1] = iArr251[i600 - 1] / iArr251[i600];
                int i601 = i600 - 1;
                this.initRecordTimeStamp = i601;
                this.PrepareContext[i601] = null;
                return 0;
            case 294:
                int[] iArr252 = this.GetContactSyncConfig;
                int i602 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i602 + 1;
                iArr252[i602] = 123;
                return 0;
            case 295:
                int[] iArr253 = this.GetContactSyncConfig;
                int i603 = this.initRecordTimeStamp;
                int i604 = i603 + 1;
                this.initRecordTimeStamp = i604;
                iArr253[i603] = 1;
                iArr253[i604 - 1] = -iArr253[i604 - 1];
                int i605 = i604 + 1;
                this.initRecordTimeStamp = i605;
                iArr253[i604] = iArr253[i605 - 2];
                return 0;
            case 296:
                int i606 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i606;
                int[] iArr254 = this.GetContactSyncConfig;
                iArr254[i606 - 1] = iArr254[i606 - 1] ^ iArr254[i606];
                int i607 = iArr254[i606 - 1];
                iArr254[i606 - 1] = iArr254[i606 - 2];
                iArr254[i606 - 2] = i607;
                return 0;
            case 297:
                int i608 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i608;
                int[] iArr255 = this.GetContactSyncConfig;
                iArr255[13] = iArr255[i608];
                this.initRecordTimeStamp = i608 + 1;
                iArr255[i608] = iArr255[11];
                return 0;
            case 298:
                int[] iArr256 = this.GetContactSyncConfig;
                int i609 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i609 + 1;
                iArr256[i609] = 88;
                return 0;
            case SecExceptionCode.SEC_ERROR_STA_STORE_UNKNOWN_ERROR /* 299 */:
                int i610 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i610;
                int[] iArr257 = this.GetContactSyncConfig;
                iArr257[i610 - 1] = iArr257[i610 - 1] + iArr257[i610];
                int i611 = i610 + 1;
                this.initRecordTimeStamp = i611;
                iArr257[i610] = iArr257[i611 - 2];
                this.initRecordTimeStamp = i611 + 1;
                iArr257[i611] = 128;
                return 0;
            case 300:
                int[] iArr258 = this.GetContactSyncConfig;
                int i612 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i612 + 1;
                iArr258[i612] = 92;
                return 0;
            case 301:
                int[] iArr259 = this.GetContactSyncConfig;
                int i613 = this.initRecordTimeStamp;
                int i614 = i613 + 1;
                this.initRecordTimeStamp = i614;
                iArr259[i613] = 73;
                int i615 = i614 + 2;
                this.initRecordTimeStamp = i615;
                iArr259[i615 - 1] = iArr259[i615 - 3];
                iArr259[i614] = iArr259[i615 - 4];
                return 0;
            case 302:
                int[] iArr260 = this.GetContactSyncConfig;
                int i616 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i616 + 1;
                iArr260[i616] = 55;
                return 0;
            case 303:
                int[] iArr261 = this.GetContactSyncConfig;
                int i617 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i617 + 1;
                iArr261[i617] = 76;
                return 0;
            case SecExceptionCode.SEC_ERROR_STA_INCORRECT_DATA_FILE /* 304 */:
                int[] iArr262 = this.GetContactSyncConfig;
                int i618 = this.initRecordTimeStamp;
                int i619 = i618 + 1;
                this.initRecordTimeStamp = i619;
                iArr262[i618] = 99;
                int i620 = i619 + 2;
                this.initRecordTimeStamp = i620;
                iArr262[i620 - 1] = iArr262[i620 - 3];
                iArr262[i619] = iArr262[i620 - 4];
                int i621 = i620 - 1;
                this.initRecordTimeStamp = i621;
                iArr262[i621 - 1] = iArr262[i621] ^ iArr262[i621 - 1];
                return 0;
            case SecExceptionCode.SEC_ERROR_STA_INCORRECT_DATA_FILE_DATA /* 305 */:
                int[] iArr263 = this.GetContactSyncConfig;
                int i622 = this.initRecordTimeStamp;
                int i623 = i622 + 1;
                this.initRecordTimeStamp = i623;
                iArr263[i622] = 89;
                int i624 = i623 + 1;
                this.initRecordTimeStamp = i624;
                iArr263[i623] = iArr263[i624 - 2];
                this.initRecordTimeStamp = i624 + 1;
                iArr263[i624] = -1;
                return 0;
            case SecExceptionCode.SEC_ERROR_STA_KEY_NOT_EXISTED /* 306 */:
                int[] iArr264 = this.GetContactSyncConfig;
                int i625 = this.initRecordTimeStamp;
                int i626 = i625 + 1;
                this.initRecordTimeStamp = i626;
                iArr264[i625] = 53;
                iArr264[i626 - 1] = -iArr264[i626 - 1];
                int i627 = i626 + 2;
                this.initRecordTimeStamp = i627;
                iArr264[i627 - 1] = iArr264[i627 - 3];
                iArr264[i626] = iArr264[i627 - 4];
                return 0;
            case 307:
                int i628 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i628;
                this.PrepareContext[i628] = null;
                int i629 = i628 - 1;
                this.initRecordTimeStamp = i629;
                int[] iArr265 = this.GetContactSyncConfig;
                iArr265[i629 - 1] = iArr265[i629 - 1] - iArr265[i629];
                return 0;
            case 308:
                int[] iArr266 = this.GetContactSyncConfig;
                int i630 = this.initRecordTimeStamp;
                int i631 = i630 + 1;
                this.initRecordTimeStamp = i631;
                iArr266[i630] = 87;
                int i632 = i631 + 2;
                this.initRecordTimeStamp = i632;
                iArr266[i632 - 1] = iArr266[i632 - 3];
                iArr266[i631] = iArr266[i632 - 4];
                return 0;
            case SecExceptionCode.SEC_ERROR_STA_NO_SUCH_INDEX /* 309 */:
                int i633 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i633;
                int[] iArr267 = this.GetContactSyncConfig;
                iArr267[i633 - 1] = iArr267[i633 - 1] & iArr267[i633];
                int i634 = i633 - 1;
                this.initRecordTimeStamp = i634;
                iArr267[i634 - 1] = iArr267[i634 - 1] - iArr267[i634];
                return 0;
            case SecExceptionCode.SEC_ERROR_STA_INVALID_ENCRYPTED_DATA /* 310 */:
                int[] iArr268 = this.GetContactSyncConfig;
                int i635 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i635 + 1;
                iArr268[i635] = 11;
                return 0;
            case SecExceptionCode.SEC_ERROR_STA_DECRYPT_MISMATCH_KEY_DATA /* 311 */:
                Object[] objArr40 = this.PrepareContext;
                int i636 = this.initRecordTimeStamp;
                int i637 = i636 + 1;
                this.initRecordTimeStamp = i637;
                objArr40[i636] = objArr40[11];
                this.initRecordTimeStamp = i637 + 1;
                objArr40[i637] = objArr40[12];
                return 0;
            case SecExceptionCode.SEC_ERROR_STA_LOW_VERSION_DATA_FILE /* 312 */:
                int[] iArr269 = this.GetContactSyncConfig;
                int i638 = this.initRecordTimeStamp;
                int i639 = i638 + 1;
                this.initRecordTimeStamp = i639;
                iArr269[i638] = 39;
                int i640 = i639 + 2;
                this.initRecordTimeStamp = i640;
                iArr269[i640 - 1] = iArr269[i640 - 3];
                iArr269[i639] = iArr269[i640 - 4];
                return 0;
            case 313:
                int i641 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i641;
                int[] iArr270 = this.GetContactSyncConfig;
                iArr270[i641 - 1] = iArr270[i641 - 1] | iArr270[i641];
                int i642 = i641 + 1;
                this.initRecordTimeStamp = i642;
                iArr270[i641] = iArr270[i642 - 2];
                return 0;
            case 314:
                int i643 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i643;
                Object[] objArr41 = this.PrepareContext;
                Object obj22 = objArr41[i643];
                objArr41[i643] = null;
                this.KClassImpl$Data$declaredNonStaticMembers$2 = obj22 == null ? 1 : 0;
                return 0;
            case 315:
                int[] iArr271 = this.GetContactSyncConfig;
                int i644 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i644 + 1;
                iArr271[i644] = 54;
                return 0;
            case 316:
                int[] iArr272 = this.GetContactSyncConfig;
                int i645 = this.initRecordTimeStamp;
                int i646 = i645 + 1;
                this.initRecordTimeStamp = i646;
                iArr272[i645] = 19;
                iArr272[i646 - 1] = -iArr272[i646 - 1];
                return 0;
            case 317:
                int[] iArr273 = this.GetContactSyncConfig;
                int i647 = this.initRecordTimeStamp;
                iArr273[i647 - 1] = -iArr273[i647 - 1];
                int i648 = i647 + 1;
                this.initRecordTimeStamp = i648;
                iArr273[i647] = iArr273[i648 - 2];
                this.initRecordTimeStamp = i648 + 1;
                iArr273[i648] = -1;
                return 0;
            case 318:
                int[] iArr274 = this.GetContactSyncConfig;
                int i649 = this.initRecordTimeStamp;
                int i650 = i649 + 1;
                this.initRecordTimeStamp = i650;
                iArr274[i649] = 47;
                iArr274[i650 - 1] = -iArr274[i650 - 1];
                int i651 = i650 + 1;
                this.initRecordTimeStamp = i651;
                iArr274[i650] = iArr274[i651 - 2];
                return 0;
            case 319:
                int[] iArr275 = this.GetContactSyncConfig;
                int i652 = this.initRecordTimeStamp;
                iArr275[i652 - 1] = -iArr275[i652 - 1];
                int i653 = i652 + 1;
                this.initRecordTimeStamp = i653;
                iArr275[i652] = -1;
                int i654 = i653 - 1;
                this.initRecordTimeStamp = i654;
                iArr275[i654 - 1] = iArr275[i654] ^ iArr275[i654 - 1];
                return 0;
            case 320:
                int[] iArr276 = this.GetContactSyncConfig;
                int i655 = this.initRecordTimeStamp;
                int i656 = i655 + 1;
                this.initRecordTimeStamp = i656;
                iArr276[i655] = 97;
                this.initRecordTimeStamp = i656 + 1;
                iArr276[i656] = 0;
                return 0;
            case 321:
                int[] iArr277 = this.GetContactSyncConfig;
                int i657 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i657 + 1;
                iArr277[i657] = 95;
                return 0;
            case 322:
                int i658 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i658;
                int[] iArr278 = this.GetContactSyncConfig;
                iArr278[i658 - 1] = iArr278[i658 - 1] | iArr278[i658];
                int i659 = i658 - 1;
                this.initRecordTimeStamp = i659;
                iArr278[i659 - 1] = iArr278[i659 - 1] & iArr278[i659];
                int i660 = iArr278[i659 - 1];
                iArr278[i659 - 1] = iArr278[i659 - 2];
                iArr278[i659 - 2] = i660;
                return 0;
            case 323:
                int[] iArr279 = this.GetContactSyncConfig;
                int i661 = this.initRecordTimeStamp;
                int i662 = i661 + 1;
                this.initRecordTimeStamp = i662;
                iArr279[i661] = 1;
                iArr279[i662 - 1] = -iArr279[i662 - 1];
                int i663 = i662 + 2;
                this.initRecordTimeStamp = i663;
                iArr279[i663 - 1] = iArr279[i663 - 3];
                iArr279[i662] = iArr279[i663 - 4];
                return 0;
            case 324:
                int[] iArr280 = this.GetContactSyncConfig;
                int i664 = this.initRecordTimeStamp;
                int i665 = i664 + 1;
                this.initRecordTimeStamp = i665;
                iArr280[i664] = 37;
                iArr280[i665 - 1] = -iArr280[i665 - 1];
                int i666 = i665 + 2;
                this.initRecordTimeStamp = i666;
                iArr280[i666 - 1] = iArr280[i666 - 3];
                iArr280[i665] = iArr280[i666 - 4];
                return 0;
            case 325:
                int[] iArr281 = this.GetContactSyncConfig;
                int i667 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i667 + 1;
                iArr281[i667] = 91;
                return 0;
            case 326:
                int[] iArr282 = this.GetContactSyncConfig;
                int i668 = this.initRecordTimeStamp;
                int i669 = i668 + 1;
                this.initRecordTimeStamp = i669;
                iArr282[i668] = 0;
                int i670 = i669 - 1;
                this.initRecordTimeStamp = i670;
                iArr282[i670 - 1] = iArr282[i670 - 1] / iArr282[i670];
                return 0;
            case 327:
                int[] iArr283 = this.GetContactSyncConfig;
                int i671 = this.initRecordTimeStamp;
                int i672 = i671 + 1;
                this.initRecordTimeStamp = i672;
                iArr283[i671] = 119;
                iArr283[i672 - 1] = -iArr283[i672 - 1];
                return 0;
            case 328:
                int[] iArr284 = this.GetContactSyncConfig;
                int i673 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i673 + 1;
                iArr284[i673] = 30;
                return 0;
            case 329:
                int[] iArr285 = this.GetContactSyncConfig;
                int i674 = this.initRecordTimeStamp;
                int i675 = i674 + 1;
                this.initRecordTimeStamp = i675;
                iArr285[i674] = 101;
                iArr285[i675 - 1] = -iArr285[i675 - 1];
                return 0;
            case 330:
                int[] iArr286 = this.GetContactSyncConfig;
                int i676 = this.initRecordTimeStamp;
                int i677 = i676 + 1;
                this.initRecordTimeStamp = i677;
                iArr286[i676] = 45;
                this.initRecordTimeStamp = i677 + 1;
                iArr286[i677] = 0;
                return 0;
            case 331:
                int[] iArr287 = this.GetContactSyncConfig;
                int i678 = this.initRecordTimeStamp;
                int i679 = i678 + 1;
                this.initRecordTimeStamp = i679;
                iArr287[i678] = iArr287[i679 - 2];
                int i680 = i679 + 1;
                this.initRecordTimeStamp = i680;
                iArr287[i679] = -1;
                int i681 = i680 + 2;
                this.initRecordTimeStamp = i681;
                iArr287[i681 - 1] = iArr287[i681 - 3];
                iArr287[i680] = iArr287[i681 - 4];
                return 0;
            case 332:
                int i682 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i682;
                this.PrepareContext[i682] = null;
                int[] iArr288 = this.GetContactSyncConfig;
                int i683 = i682 + 1;
                this.initRecordTimeStamp = i683;
                iArr288[i682] = iArr288[i683 - 2];
                return 0;
            case 333:
                int i684 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i684;
                int[] iArr289 = this.GetContactSyncConfig;
                iArr289[i684 - 1] = iArr289[i684 - 1] - iArr289[i684];
                int i685 = i684 + 1;
                this.initRecordTimeStamp = i685;
                iArr289[i684] = 1;
                int i686 = i685 + 2;
                this.initRecordTimeStamp = i686;
                iArr289[i686 - 1] = iArr289[i686 - 3];
                iArr289[i685] = iArr289[i686 - 4];
                return 0;
            case 334:
                int[] iArr290 = this.GetContactSyncConfig;
                int i687 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i687 + 1;
                iArr290[i687] = 78;
                return 0;
            case 335:
                int i688 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i688;
                int[] iArr291 = this.GetContactSyncConfig;
                iArr291[i688 - 1] = iArr291[i688 - 1] ^ iArr291[i688];
                int i689 = i688 + 2;
                this.initRecordTimeStamp = i689;
                iArr291[i689 - 1] = iArr291[i689 - 3];
                iArr291[i688] = iArr291[i689 - 4];
                return 0;
            case 336:
                int[] iArr292 = this.GetContactSyncConfig;
                int i690 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i690 + 1;
                iArr292[i690] = 39;
                return 0;
            case 337:
                int[] iArr293 = this.GetContactSyncConfig;
                int i691 = this.initRecordTimeStamp;
                int i692 = i691 + 1;
                this.initRecordTimeStamp = i692;
                iArr293[i691] = 13;
                int i693 = i692 + 1;
                this.initRecordTimeStamp = i693;
                iArr293[i692] = iArr293[i693 - 2];
                this.initRecordTimeStamp = i693 + 1;
                iArr293[i693] = -1;
                return 0;
            case 338:
                int[] iArr294 = this.GetContactSyncConfig;
                int i694 = this.initRecordTimeStamp;
                int i695 = i694 + 1;
                this.initRecordTimeStamp = i695;
                iArr294[i694] = 1;
                int i696 = i695 + 2;
                this.initRecordTimeStamp = i696;
                iArr294[i696 - 1] = iArr294[i696 - 3];
                iArr294[i695] = iArr294[i696 - 4];
                return 0;
            case 339:
                int[] iArr295 = this.GetContactSyncConfig;
                int i697 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i697 + 1;
                iArr295[i697] = 111;
                return 0;
            case 340:
                int[] iArr296 = this.GetContactSyncConfig;
                int i698 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i698 + 1;
                iArr296[i698] = 72;
                return 0;
            case 341:
                int[] iArr297 = this.GetContactSyncConfig;
                int i699 = this.initRecordTimeStamp;
                int i700 = i699 + 1;
                this.initRecordTimeStamp = i700;
                iArr297[i699] = 15;
                int i701 = i700 + 1;
                this.initRecordTimeStamp = i701;
                iArr297[i700] = 0;
                int i702 = i701 - 1;
                this.initRecordTimeStamp = i702;
                iArr297[i702 - 1] = iArr297[i702 - 1] / iArr297[i702];
                return 0;
            case 342:
                Object[] objArr42 = this.PrepareContext;
                int i703 = this.initRecordTimeStamp;
                int i704 = i703 + 1;
                this.initRecordTimeStamp = i704;
                objArr42[i703] = objArr42[10];
                int[] iArr298 = this.GetContactSyncConfig;
                this.initRecordTimeStamp = i704 + 1;
                iArr298[i704] = 0;
                return 0;
            case 343:
                int[] iArr299 = this.GetContactSyncConfig;
                int i705 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i705 + 1;
                iArr299[i705] = 2;
                return 0;
            case 344:
                int[] iArr300 = this.GetContactSyncConfig;
                int i706 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i706 + 1;
                iArr300[i706] = 89;
                return 0;
            case 345:
                int[] iArr301 = this.GetContactSyncConfig;
                int i707 = this.initRecordTimeStamp;
                int i708 = i707 + 1;
                this.initRecordTimeStamp = i708;
                iArr301[i707] = 37;
                int i709 = i708 + 1;
                this.initRecordTimeStamp = i709;
                iArr301[i708] = iArr301[i709 - 2];
                this.initRecordTimeStamp = i709 + 1;
                iArr301[i709] = -1;
                return 0;
            case 346:
                int[] iArr302 = this.GetContactSyncConfig;
                int i710 = this.initRecordTimeStamp;
                int i711 = i710 + 1;
                this.initRecordTimeStamp = i711;
                iArr302[i710] = 1;
                iArr302[i711 - 1] = -iArr302[i711 - 1];
                return 0;
            case 347:
                int[] iArr303 = this.GetContactSyncConfig;
                int i712 = this.initRecordTimeStamp;
                int i713 = i712 + 1;
                this.initRecordTimeStamp = i713;
                iArr303[i712] = 57;
                iArr303[i713 - 1] = -iArr303[i713 - 1];
                int i714 = i713 + 2;
                this.initRecordTimeStamp = i714;
                iArr303[i714 - 1] = iArr303[i714 - 3];
                iArr303[i713] = iArr303[i714 - 4];
                return 0;
            case 348:
                int[] iArr304 = this.GetContactSyncConfig;
                int i715 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i715 + 1;
                iArr304[i715] = 66;
                return 0;
            case 349:
                int[] iArr305 = this.GetContactSyncConfig;
                int i716 = this.initRecordTimeStamp;
                int i717 = i716 + 1;
                this.initRecordTimeStamp = i717;
                iArr305[i716] = 37;
                iArr305[i717 - 1] = -iArr305[i717 - 1];
                return 0;
            case 350:
                int i718 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i718;
                Object[] objArr43 = this.PrepareContext;
                Object obj23 = objArr43[i718];
                objArr43[i718] = null;
                objArr43[12] = obj23;
                this.initRecordTimeStamp = i718 + 1;
                objArr43[i718] = objArr43[13];
                return 0;
            case 351:
                int[] iArr306 = this.GetContactSyncConfig;
                int i719 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i719 + 1;
                iArr306[i719] = 50;
                return 0;
            case 352:
                int[] iArr307 = this.GetContactSyncConfig;
                int i720 = this.initRecordTimeStamp;
                int i721 = i720 + 1;
                this.initRecordTimeStamp = i721;
                iArr307[i720] = 97;
                iArr307[i721 - 1] = -iArr307[i721 - 1];
                return 0;
            case 353:
                int i722 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i722;
                int[] iArr308 = this.GetContactSyncConfig;
                iArr308[i722 - 1] = iArr308[i722 - 1] ^ iArr308[i722];
                int i723 = i722 - 1;
                this.initRecordTimeStamp = i723;
                iArr308[i723 - 1] = iArr308[i723 - 1] - iArr308[i723];
                int i724 = i723 + 1;
                this.initRecordTimeStamp = i724;
                iArr308[i723] = iArr308[i724 - 2];
                return 0;
            case 354:
                Object[] objArr44 = this.PrepareContext;
                int i725 = this.initRecordTimeStamp;
                int i726 = i725 + 1;
                this.initRecordTimeStamp = i726;
                objArr44[i725] = objArr44[12];
                this.initRecordTimeStamp = i726 + 1;
                objArr44[i726] = objArr44[11];
                return 0;
            case 355:
                int i727 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i727;
                Object[] objArr45 = this.PrepareContext;
                Object obj24 = objArr45[i727];
                objArr45[i727] = null;
                objArr45[13] = obj24;
                int i728 = i727 - 1;
                this.initRecordTimeStamp = i728;
                Object obj25 = objArr45[i728];
                objArr45[i728] = null;
                objArr45[12] = obj25;
                return 0;
            case 356:
                Object[] objArr46 = this.PrepareContext;
                int i729 = this.initRecordTimeStamp;
                int i730 = i729 + 1;
                this.initRecordTimeStamp = i730;
                objArr46[i729] = objArr46[12];
                int i731 = i730 + 1;
                this.initRecordTimeStamp = i731;
                objArr46[i730] = objArr46[11];
                int i732 = i731 - 1;
                this.initRecordTimeStamp = i732;
                Object obj26 = objArr46[i732];
                objArr46[i732] = null;
                objArr46[13] = obj26;
                return 0;
            case 357:
                int[] iArr309 = this.GetContactSyncConfig;
                int i733 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i733 + 1;
                iArr309[i733] = 69;
                return 0;
            case 358:
                int[] iArr310 = this.GetContactSyncConfig;
                int i734 = this.initRecordTimeStamp;
                int i735 = i734 + 1;
                this.initRecordTimeStamp = i735;
                iArr310[i734] = 85;
                iArr310[i735 - 1] = -iArr310[i735 - 1];
                return 0;
            case 359:
                int i736 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i736;
                this.PrepareContext[i736] = null;
                int[] iArr311 = this.GetContactSyncConfig;
                iArr311[i736 - 1] = -iArr311[i736 - 1];
                int i737 = i736 - 1;
                this.initRecordTimeStamp = i737;
                iArr311[i737 - 1] = iArr311[i737] | iArr311[i737 - 1];
                return 0;
            case AUScreenAdaptTool.WIDTH_BASE /* 360 */:
                int[] iArr312 = this.GetContactSyncConfig;
                int i738 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i738 + 1;
                iArr312[i738] = 58;
                return 0;
            case 361:
                int[] iArr313 = this.GetContactSyncConfig;
                int i739 = this.initRecordTimeStamp;
                int i740 = i739 + 1;
                this.initRecordTimeStamp = i740;
                iArr313[i739] = 64;
                int i741 = i740 + 1;
                this.initRecordTimeStamp = i741;
                iArr313[i740] = 0;
                int i742 = i741 - 1;
                this.initRecordTimeStamp = i742;
                iArr313[i742 - 1] = iArr313[i742 - 1] / iArr313[i742];
                return 0;
            case 362:
                int[] iArr314 = this.GetContactSyncConfig;
                int i743 = this.initRecordTimeStamp;
                int i744 = i743 + 1;
                this.initRecordTimeStamp = i744;
                iArr314[i743] = 11;
                int i745 = i744 + 2;
                this.initRecordTimeStamp = i745;
                iArr314[i745 - 1] = iArr314[i745 - 3];
                iArr314[i744] = iArr314[i745 - 4];
                return 0;
            case 363:
                Object[] objArr47 = this.PrepareContext;
                int i746 = this.initRecordTimeStamp;
                int i747 = i746 + 1;
                this.initRecordTimeStamp = i747;
                objArr47[i746] = objArr47[13];
                this.initRecordTimeStamp = i747 + 1;
                objArr47[i747] = objArr47[14];
                return 0;
            case 364:
                int[] iArr315 = this.GetContactSyncConfig;
                int i748 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i748 + 1;
                iArr315[i748] = 42;
                return 0;
            case 365:
                int[] iArr316 = this.GetContactSyncConfig;
                int i749 = this.initRecordTimeStamp;
                int i750 = i749 + 1;
                this.initRecordTimeStamp = i750;
                iArr316[i749] = 49;
                iArr316[i750 - 1] = -iArr316[i750 - 1];
                return 0;
            case 366:
                int[] iArr317 = this.GetContactSyncConfig;
                int i751 = this.initRecordTimeStamp;
                int i752 = i751 + 2;
                this.initRecordTimeStamp = i752;
                iArr317[i752 - 1] = iArr317[i752 - 3];
                iArr317[i751] = iArr317[i752 - 4];
                iArr317[i752 - 1] = -iArr317[i752 - 1];
                int i753 = i752 + 2;
                this.initRecordTimeStamp = i753;
                iArr317[i753 - 1] = iArr317[i753 - 3];
                iArr317[i752] = iArr317[i753 - 4];
                return 0;
            case 367:
                int i754 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i754;
                int[] iArr318 = this.GetContactSyncConfig;
                iArr318[i754 - 1] = iArr318[i754 - 1] & iArr318[i754];
                int i755 = i754 - 1;
                this.initRecordTimeStamp = i755;
                iArr318[i755 - 1] = iArr318[i755 - 1] | iArr318[i755];
                int i756 = i755 + 1;
                this.initRecordTimeStamp = i756;
                int i757 = iArr318[i756 - 2];
                iArr318[i755] = i757;
                iArr318[i756 - 2] = iArr318[i756 - 3];
                iArr318[i756 - 3] = iArr318[i756 - 4];
                iArr318[i756 - 4] = i757;
                return 0;
            case 368:
                int[] iArr319 = this.GetContactSyncConfig;
                int i758 = this.initRecordTimeStamp;
                int i759 = i758 + 1;
                this.initRecordTimeStamp = i759;
                iArr319[i758] = 1;
                int i760 = i759 - 1;
                this.initRecordTimeStamp = i760;
                iArr319[i760 - 1] = iArr319[i760 - 1] << iArr319[i760];
                iArr319[i760 - 1] = -iArr319[i760 - 1];
                return 0;
            case 369:
                int i761 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i761;
                Object[] objArr48 = this.PrepareContext;
                Object obj27 = objArr48[i761];
                objArr48[i761] = null;
                objArr48[14] = obj27;
                int i762 = i761 - 1;
                this.initRecordTimeStamp = i762;
                Object obj28 = objArr48[i762];
                objArr48[i762] = null;
                objArr48[13] = obj28;
                return 0;
            case 370:
                int[] iArr320 = this.GetContactSyncConfig;
                int i763 = this.initRecordTimeStamp;
                int i764 = i763 + 1;
                this.initRecordTimeStamp = i764;
                iArr320[i763] = 121;
                iArr320[i764 - 1] = -iArr320[i764 - 1];
                return 0;
            case 371:
                int[] iArr321 = this.GetContactSyncConfig;
                int i765 = this.initRecordTimeStamp;
                int i766 = i765 + 1;
                this.initRecordTimeStamp = i766;
                iArr321[i765] = 85;
                iArr321[i766 - 1] = -iArr321[i766 - 1];
                int i767 = i766 + 2;
                this.initRecordTimeStamp = i767;
                iArr321[i767 - 1] = iArr321[i767 - 3];
                iArr321[i766] = iArr321[i767 - 4];
                return 0;
            case 372:
                int[] iArr322 = this.GetContactSyncConfig;
                int i768 = this.initRecordTimeStamp;
                int i769 = i768 + 1;
                this.initRecordTimeStamp = i769;
                iArr322[i768] = 97;
                int i770 = i769 + 2;
                this.initRecordTimeStamp = i770;
                iArr322[i770 - 1] = iArr322[i770 - 3];
                iArr322[i769] = iArr322[i770 - 4];
                int i771 = i770 + 2;
                this.initRecordTimeStamp = i771;
                iArr322[i771 - 1] = iArr322[i771 - 3];
                iArr322[i770] = iArr322[i771 - 4];
                return 0;
            case 373:
                int i772 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i772;
                this.PrepareContext[i772] = null;
                int[] iArr323 = this.GetContactSyncConfig;
                int i773 = i772 + 2;
                this.initRecordTimeStamp = i773;
                iArr323[i773 - 1] = iArr323[i773 - 3];
                iArr323[i772] = iArr323[i773 - 4];
                this.initRecordTimeStamp = i773 + 1;
                iArr323[i773] = -1;
                return 0;
            case 374:
                int i774 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i774;
                int[] iArr324 = this.GetContactSyncConfig;
                iArr324[i774 - 1] = iArr324[i774 - 1] << iArr324[i774];
                iArr324[i774 - 1] = -iArr324[i774 - 1];
                int i775 = i774 + 2;
                this.initRecordTimeStamp = i775;
                iArr324[i775 - 1] = iArr324[i775 - 3];
                iArr324[i774] = iArr324[i775 - 4];
                return 0;
            case 375:
                int[] iArr325 = this.GetContactSyncConfig;
                int i776 = this.initRecordTimeStamp;
                int i777 = i776 + 1;
                this.initRecordTimeStamp = i777;
                iArr325[i776] = 53;
                int i778 = i777 + 2;
                this.initRecordTimeStamp = i778;
                iArr325[i778 - 1] = iArr325[i778 - 3];
                iArr325[i777] = iArr325[i778 - 4];
                return 0;
            case 376:
                int[] iArr326 = this.GetContactSyncConfig;
                int i779 = this.initRecordTimeStamp;
                int i780 = iArr326[i779 - 1];
                iArr326[i779 - 1] = iArr326[i779 - 2];
                iArr326[i779 - 2] = i780;
                this.initRecordTimeStamp = i779 + 1;
                iArr326[i779] = -1;
                return 0;
            case 377:
                int[] iArr327 = this.GetContactSyncConfig;
                int i781 = this.initRecordTimeStamp;
                int i782 = i781 + 1;
                this.initRecordTimeStamp = i782;
                iArr327[i781] = 85;
                iArr327[i782 - 1] = -iArr327[i782 - 1];
                int i783 = i782 + 1;
                this.initRecordTimeStamp = i783;
                iArr327[i782] = iArr327[i783 - 2];
                return 0;
            case 378:
                int[] iArr328 = this.GetContactSyncConfig;
                int i784 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i784 + 1;
                iArr328[i784] = 96;
                return 0;
            case 379:
                int i785 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i785;
                int[] iArr329 = this.GetContactSyncConfig;
                iArr329[11] = iArr329[i785];
                Object[] objArr49 = this.PrepareContext;
                int i786 = i785 + 1;
                this.initRecordTimeStamp = i786;
                objArr49[i785] = objArr49[12];
                this.initRecordTimeStamp = i786 + 1;
                iArr329[i786] = iArr329[11];
                return 0;
            case 380:
                int i787 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i787;
                Object[] objArr50 = this.PrepareContext;
                Object obj29 = objArr50[i787];
                objArr50[i787] = null;
                objArr50[11] = obj29;
                int i788 = i787 + 1;
                this.initRecordTimeStamp = i788;
                objArr50[i787] = objArr50[10];
                this.initRecordTimeStamp = i788 + 1;
                objArr50[i788] = objArr50[11];
                return 0;
            case 381:
                int[] iArr330 = this.GetContactSyncConfig;
                int i789 = this.initRecordTimeStamp;
                int i790 = i789 + 1;
                this.initRecordTimeStamp = i790;
                iArr330[i789] = 67;
                int i791 = i790 + 2;
                this.initRecordTimeStamp = i791;
                iArr330[i791 - 1] = iArr330[i791 - 3];
                iArr330[i790] = iArr330[i791 - 4];
                int i792 = i791 - 1;
                this.initRecordTimeStamp = i792;
                iArr330[i792 - 1] = iArr330[i792] ^ iArr330[i792 - 1];
                return 0;
            case 382:
                int i793 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i793;
                this.PrepareContext[i793] = null;
                int i794 = i793 - 1;
                this.initRecordTimeStamp = i794;
                int[] iArr331 = this.GetContactSyncConfig;
                iArr331[i794 - 1] = iArr331[i794] ^ iArr331[i794 - 1];
                return 0;
            case 383:
                int[] iArr332 = this.GetContactSyncConfig;
                int i795 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i795 + 1;
                iArr332[i795] = 93;
                return 0;
            case 384:
                int[] iArr333 = this.GetContactSyncConfig;
                int i796 = this.initRecordTimeStamp;
                int i797 = i796 + 1;
                this.initRecordTimeStamp = i797;
                iArr333[i796] = 113;
                int i798 = i797 + 2;
                this.initRecordTimeStamp = i798;
                iArr333[i798 - 1] = iArr333[i798 - 3];
                iArr333[i797] = iArr333[i798 - 4];
                int i799 = i798 + 2;
                this.initRecordTimeStamp = i799;
                iArr333[i799 - 1] = iArr333[i799 - 3];
                iArr333[i798] = iArr333[i799 - 4];
                return 0;
            case 385:
                int[] iArr334 = this.GetContactSyncConfig;
                int i800 = this.initRecordTimeStamp;
                int i801 = i800 + 1;
                this.initRecordTimeStamp = i801;
                iArr334[i800] = 115;
                iArr334[i801 - 1] = -iArr334[i801 - 1];
                return 0;
            case 386:
                int[] iArr335 = this.GetContactSyncConfig;
                int i802 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i802 + 1;
                iArr335[i802] = 73;
                return 0;
            case 387:
                int[] iArr336 = this.GetContactSyncConfig;
                int i803 = this.initRecordTimeStamp;
                int i804 = i803 + 1;
                this.initRecordTimeStamp = i804;
                iArr336[i803] = 41;
                int i805 = i804 + 1;
                this.initRecordTimeStamp = i805;
                iArr336[i804] = 0;
                int i806 = i805 - 1;
                this.initRecordTimeStamp = i806;
                iArr336[i806 - 1] = iArr336[i806 - 1] / iArr336[i806];
                return 0;
            case 388:
                int[] iArr337 = this.GetContactSyncConfig;
                int i807 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i807 + 1;
                iArr337[i807] = 62;
                return 0;
            case 389:
                int[] iArr338 = this.GetContactSyncConfig;
                int i808 = this.initRecordTimeStamp;
                int i809 = i808 + 1;
                this.initRecordTimeStamp = i809;
                iArr338[i808] = 39;
                int i810 = i809 + 1;
                this.initRecordTimeStamp = i810;
                iArr338[i809] = iArr338[i810 - 2];
                this.initRecordTimeStamp = i810 + 1;
                iArr338[i810] = -1;
                return 0;
            case 390:
                int[] iArr339 = this.GetContactSyncConfig;
                int i811 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i811 + 1;
                iArr339[i811] = 115;
                return 0;
            case 391:
                int[] iArr340 = this.GetContactSyncConfig;
                int i812 = this.initRecordTimeStamp;
                int i813 = i812 + 1;
                this.initRecordTimeStamp = i813;
                iArr340[i812] = 19;
                int i814 = i813 + 2;
                this.initRecordTimeStamp = i814;
                iArr340[i814 - 1] = iArr340[i814 - 3];
                iArr340[i813] = iArr340[i814 - 4];
                int i815 = i814 + 2;
                this.initRecordTimeStamp = i815;
                iArr340[i815 - 1] = iArr340[i815 - 3];
                iArr340[i814] = iArr340[i815 - 4];
                return 0;
            case 392:
                int i816 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i816;
                this.PrepareContext[i816] = null;
                int[] iArr341 = this.GetContactSyncConfig;
                int i817 = i816 + 2;
                this.initRecordTimeStamp = i817;
                iArr341[i817 - 1] = iArr341[i817 - 3];
                iArr341[i816] = iArr341[i817 - 4];
                int i818 = i817 - 1;
                this.initRecordTimeStamp = i818;
                iArr341[i818 - 1] = iArr341[i818] ^ iArr341[i818 - 1];
                return 0;
            case 393:
                int[] iArr342 = this.GetContactSyncConfig;
                int i819 = this.initRecordTimeStamp;
                iArr342[i819 - 1] = -iArr342[i819 - 1];
                int i820 = i819 - 1;
                this.initRecordTimeStamp = i820;
                iArr342[i820 - 1] = iArr342[i820 - 1] | iArr342[i820];
                this.initRecordTimeStamp = i820 + 1;
                iArr342[i820] = 1;
                return 0;
            case 394:
                int[] iArr343 = this.GetContactSyncConfig;
                int i821 = this.initRecordTimeStamp;
                iArr343[i821 - 1] = -iArr343[i821 - 1];
                int i822 = i821 + 2;
                this.initRecordTimeStamp = i822;
                iArr343[i822 - 1] = iArr343[i822 - 3];
                iArr343[i821] = iArr343[i822 - 4];
                int i823 = i822 - 1;
                this.initRecordTimeStamp = i823;
                iArr343[i823 - 1] = iArr343[i823] & iArr343[i823 - 1];
                return 0;
            case 395:
                int i824 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i824;
                int[] iArr344 = this.GetContactSyncConfig;
                iArr344[i824 - 1] = iArr344[i824 - 1] + iArr344[i824];
                this.initRecordTimeStamp = i824 + 1;
                iArr344[i824] = 1;
                return 0;
            case 396:
                Object[] objArr51 = this.PrepareContext;
                int i825 = this.initRecordTimeStamp;
                int i826 = i825 + 1;
                this.initRecordTimeStamp = i826;
                objArr51[i825] = objArr51[10];
                int[] iArr345 = this.GetContactSyncConfig;
                this.initRecordTimeStamp = i826 + 1;
                iArr345[i826] = iArr345[11];
                return 0;
            case 397:
                int i827 = this.initRecordTimeStamp - 1;
                this.initRecordTimeStamp = i827;
                int[] iArr346 = this.GetContactSyncConfig;
                iArr346[i827 - 1] = iArr346[i827 - 1] & iArr346[i827];
                int i828 = i827 - 1;
                this.initRecordTimeStamp = i828;
                iArr346[i828 - 1] = iArr346[i828 - 1] | iArr346[i828];
                this.initRecordTimeStamp = i828 + 1;
                iArr346[i828] = 1;
                return 0;
            case 398:
                int[] iArr347 = this.GetContactSyncConfig;
                int i829 = this.initRecordTimeStamp;
                int i830 = i829 + 1;
                this.initRecordTimeStamp = i830;
                iArr347[i829] = 89;
                int i831 = i830 + 1;
                this.initRecordTimeStamp = i831;
                iArr347[i830] = 0;
                int i832 = i831 - 1;
                this.initRecordTimeStamp = i832;
                iArr347[i832 - 1] = iArr347[i832 - 1] / iArr347[i832];
                return 0;
            case SecExceptionCode.SEC_ERROR_STA_UNKNOWN_ERROR /* 399 */:
                int[] iArr348 = this.GetContactSyncConfig;
                int i833 = this.initRecordTimeStamp;
                this.initRecordTimeStamp = i833 + 1;
                iArr348[i833] = 64;
                return 0;
            default:
                return i;
        }
        return 0;
    }
}
