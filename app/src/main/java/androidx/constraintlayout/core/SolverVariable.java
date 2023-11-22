package androidx.constraintlayout.core;

import java.util.Arrays;
import java.util.HashSet;

/* loaded from: classes3.dex */
public class SolverVariable implements Comparable<SolverVariable> {
    private static int isLayoutRequested = 1;
    public float KClassImpl$Data$declaredNonStaticMembers$2;
    public boolean MyBillsEntityDataFactory;
    private String NetworkUserEntityData$$ExternalSyntheticLambda7;
    Type initRecordTimeStamp;
    public int BuiltInFictitiousFunctionClassFactory = -1;
    int getAuthRequestContext = -1;
    public int NetworkUserEntityData$$ExternalSyntheticLambda1 = 0;
    public boolean NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
    float[] GetContactSyncConfig = new float[9];
    float[] PlaceComponentResult = new float[9];
    ArrayRow[] moveToNextValue = new ArrayRow[16];
    int getErrorConfigVersion = 0;
    public int NetworkUserEntityData$$ExternalSyntheticLambda8 = 0;
    boolean scheduleImpl = false;
    int NetworkUserEntityData$$ExternalSyntheticLambda2 = -1;
    float DatabaseTableConfigUtil = 0.0f;
    HashSet<ArrayRow> lookAheadTest = null;

    /* loaded from: classes3.dex */
    public enum Type {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(SolverVariable solverVariable) {
        return this.BuiltInFictitiousFunctionClassFactory - solverVariable.BuiltInFictitiousFunctionClassFactory;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void getAuthRequestContext() {
        isLayoutRequested++;
    }

    /* renamed from: androidx.constraintlayout.core.SolverVariable$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] MyBillsEntityDataFactory;

        static {
            int[] iArr = new int[Type.values().length];
            MyBillsEntityDataFactory = iArr;
            try {
                iArr[Type.UNRESTRICTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                MyBillsEntityDataFactory[Type.CONSTANT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                MyBillsEntityDataFactory[Type.SLACK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                MyBillsEntityDataFactory[Type.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                MyBillsEntityDataFactory[Type.UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public SolverVariable(Type type) {
        this.initRecordTimeStamp = type;
    }

    public final void getAuthRequestContext(ArrayRow arrayRow) {
        int i = 0;
        while (true) {
            int i2 = this.getErrorConfigVersion;
            if (i < i2) {
                if (this.moveToNextValue[i] == arrayRow) {
                    return;
                }
                i++;
            } else {
                ArrayRow[] arrayRowArr = this.moveToNextValue;
                if (i2 >= arrayRowArr.length) {
                    this.moveToNextValue = (ArrayRow[]) Arrays.copyOf(arrayRowArr, arrayRowArr.length * 2);
                }
                ArrayRow[] arrayRowArr2 = this.moveToNextValue;
                int i3 = this.getErrorConfigVersion;
                arrayRowArr2[i3] = arrayRow;
                this.getErrorConfigVersion = i3 + 1;
                return;
            }
        }
    }

    public final void PlaceComponentResult(ArrayRow arrayRow) {
        int i = this.getErrorConfigVersion;
        int i2 = 0;
        while (i2 < i) {
            if (this.moveToNextValue[i2] == arrayRow) {
                while (i2 < i - 1) {
                    ArrayRow[] arrayRowArr = this.moveToNextValue;
                    int i3 = i2 + 1;
                    arrayRowArr[i2] = arrayRowArr[i3];
                    i2 = i3;
                }
                this.getErrorConfigVersion--;
                return;
            }
            i2++;
        }
    }

    public final void BuiltInFictitiousFunctionClassFactory(LinearSystem linearSystem, ArrayRow arrayRow) {
        int i = this.getErrorConfigVersion;
        for (int i2 = 0; i2 < i; i2++) {
            this.moveToNextValue[i2].MyBillsEntityDataFactory(linearSystem, arrayRow, false);
        }
        this.getErrorConfigVersion = 0;
    }

    public final void getAuthRequestContext(LinearSystem linearSystem, float f) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = f;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
        this.scheduleImpl = false;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = -1;
        this.DatabaseTableConfigUtil = 0.0f;
        int i = this.getErrorConfigVersion;
        this.getAuthRequestContext = -1;
        for (int i2 = 0; i2 < i; i2++) {
            this.moveToNextValue[i2].MyBillsEntityDataFactory(linearSystem, this, false);
        }
        this.getErrorConfigVersion = 0;
    }

    public final void MyBillsEntityDataFactory() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = null;
        this.initRecordTimeStamp = Type.UNKNOWN;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = 0;
        this.BuiltInFictitiousFunctionClassFactory = -1;
        this.getAuthRequestContext = -1;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = 0.0f;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
        this.scheduleImpl = false;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = -1;
        this.DatabaseTableConfigUtil = 0.0f;
        int i = this.getErrorConfigVersion;
        for (int i2 = 0; i2 < i; i2++) {
            this.moveToNextValue[i2] = null;
        }
        this.getErrorConfigVersion = 0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = 0;
        this.MyBillsEntityDataFactory = false;
        Arrays.fill(this.PlaceComponentResult, 0.0f);
    }

    public String toString() {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda7 != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.BuiltInFictitiousFunctionClassFactory);
        return sb2.toString();
    }
}
