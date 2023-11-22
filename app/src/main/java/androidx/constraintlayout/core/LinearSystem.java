package androidx.constraintlayout.core;

import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class LinearSystem {
    public static boolean BuiltInFictitiousFunctionClassFactory = false;
    public static boolean KClassImpl$Data$declaredNonStaticMembers$2 = true;
    public static long MyBillsEntityDataFactory = 0;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda7 = 1000;
    public static long PlaceComponentResult = 0;
    public static boolean getAuthRequestContext = true;
    public static Metrics getErrorConfigVersion = null;
    public static boolean lookAheadTest = true;
    public static boolean moveToNextValue = false;
    ArrayRow[] GetContactSyncConfig;
    public final Cache NetworkUserEntityData$$ExternalSyntheticLambda2;
    private Row NetworkUserEntityData$$ExternalSyntheticLambda6;
    private Row isLayoutRequested;
    public boolean scheduleImpl = false;
    int initRecordTimeStamp = 0;
    private HashMap<String, SolverVariable> getCallingPid = null;
    private int NetworkUserEntityData$$ExternalSyntheticLambda8 = 32;
    private int NetworkUserEntityData$$ExternalSyntheticLambda3 = 32;
    public boolean NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
    public boolean PrepareContext = false;
    private boolean[] newProxyInstance = new boolean[32];
    int DatabaseTableConfigUtil = 1;
    int NetworkUserEntityData$$ExternalSyntheticLambda1 = 0;
    private int FragmentBottomSheetPaymentSettingBinding = 32;
    private SolverVariable[] NetworkUserEntityData$$ExternalSyntheticLambda5 = new SolverVariable[NetworkUserEntityData$$ExternalSyntheticLambda7];
    private int NetworkUserEntityData$$ExternalSyntheticLambda4 = 0;

    /* loaded from: classes3.dex */
    public interface Row {
        void KClassImpl$Data$declaredNonStaticMembers$2(Row row);

        void KClassImpl$Data$declaredNonStaticMembers$2(SolverVariable solverVariable);

        boolean KClassImpl$Data$declaredNonStaticMembers$2();

        SolverVariable MyBillsEntityDataFactory(boolean[] zArr);

        void MyBillsEntityDataFactory();

        SolverVariable getAuthRequestContext();
    }

    /* loaded from: classes3.dex */
    public class ValuesRow extends ArrayRow {
        public ValuesRow(Cache cache) {
            LinearSystem.this = r1;
            this.BuiltInFictitiousFunctionClassFactory = new SolverVariableValues(this, cache);
        }
    }

    public LinearSystem() {
        this.GetContactSyncConfig = null;
        this.GetContactSyncConfig = new ArrayRow[32];
        moveToNextValue();
        Cache cache = new Cache();
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = cache;
        this.isLayoutRequested = new PriorityGoalRow(cache);
        if (BuiltInFictitiousFunctionClassFactory) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = new ValuesRow(cache);
        } else {
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = new ArrayRow(cache);
        }
    }

    public static void PlaceComponentResult(Metrics metrics) {
        getErrorConfigVersion = metrics;
    }

    private void scheduleImpl() {
        int i = this.NetworkUserEntityData$$ExternalSyntheticLambda8 * 2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = i;
        this.GetContactSyncConfig = (ArrayRow[]) Arrays.copyOf(this.GetContactSyncConfig, i);
        Cache cache = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        cache.KClassImpl$Data$declaredNonStaticMembers$2 = (SolverVariable[]) Arrays.copyOf(cache.KClassImpl$Data$declaredNonStaticMembers$2, this.NetworkUserEntityData$$ExternalSyntheticLambda8);
        int i2 = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
        this.newProxyInstance = new boolean[i2];
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = i2;
        this.FragmentBottomSheetPaymentSettingBinding = i2;
        Metrics metrics = getErrorConfigVersion;
        if (metrics != null) {
            metrics.A++;
            Metrics metrics2 = getErrorConfigVersion;
            metrics2.NetworkUserEntityData$$ExternalSyntheticLambda7 = Math.max(metrics2.NetworkUserEntityData$$ExternalSyntheticLambda7, this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            Metrics metrics3 = getErrorConfigVersion;
            metrics3.GetContactSyncConfig = metrics3.NetworkUserEntityData$$ExternalSyntheticLambda7;
        }
    }

    private void moveToNextValue() {
        int i = 0;
        if (BuiltInFictitiousFunctionClassFactory) {
            while (i < this.NetworkUserEntityData$$ExternalSyntheticLambda1) {
                ArrayRow arrayRow = this.GetContactSyncConfig[i];
                if (arrayRow != null) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda2.PlaceComponentResult.PlaceComponentResult(arrayRow);
                }
                this.GetContactSyncConfig[i] = null;
                i++;
            }
            return;
        }
        while (i < this.NetworkUserEntityData$$ExternalSyntheticLambda1) {
            ArrayRow arrayRow2 = this.GetContactSyncConfig[i];
            if (arrayRow2 != null) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda2.MyBillsEntityDataFactory.PlaceComponentResult(arrayRow2);
            }
            this.GetContactSyncConfig[i] = null;
            i++;
        }
    }

    public final void BuiltInFictitiousFunctionClassFactory() {
        for (int i = 0; i < this.NetworkUserEntityData$$ExternalSyntheticLambda2.KClassImpl$Data$declaredNonStaticMembers$2.length; i++) {
            SolverVariable solverVariable = this.NetworkUserEntityData$$ExternalSyntheticLambda2.KClassImpl$Data$declaredNonStaticMembers$2[i];
            if (solverVariable != null) {
                solverVariable.MyBillsEntityDataFactory();
            }
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.getAuthRequestContext.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda5, this.NetworkUserEntityData$$ExternalSyntheticLambda4);
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = 0;
        Arrays.fill(this.NetworkUserEntityData$$ExternalSyntheticLambda2.KClassImpl$Data$declaredNonStaticMembers$2, (Object) null);
        HashMap<String, SolverVariable> hashMap = this.getCallingPid;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.initRecordTimeStamp = 0;
        this.isLayoutRequested.MyBillsEntityDataFactory();
        this.DatabaseTableConfigUtil = 1;
        for (int i2 = 0; i2 < this.NetworkUserEntityData$$ExternalSyntheticLambda1; i2++) {
            ArrayRow arrayRow = this.GetContactSyncConfig[i2];
            if (arrayRow != null) {
                arrayRow.getAuthRequestContext = false;
            }
        }
        moveToNextValue();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = 0;
        if (BuiltInFictitiousFunctionClassFactory) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = new ValuesRow(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        } else {
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = new ArrayRow(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        }
    }

    public final SolverVariable PlaceComponentResult(Object obj) {
        SolverVariable solverVariable = null;
        if (obj == null) {
            return null;
        }
        if (this.DatabaseTableConfigUtil + 1 >= this.NetworkUserEntityData$$ExternalSyntheticLambda3) {
            scheduleImpl();
        }
        if (obj instanceof ConstraintAnchor) {
            ConstraintAnchor constraintAnchor = (ConstraintAnchor) obj;
            solverVariable = constraintAnchor.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (solverVariable == null) {
                SolverVariable solverVariable2 = constraintAnchor.NetworkUserEntityData$$ExternalSyntheticLambda0;
                if (solverVariable2 == null) {
                    constraintAnchor.NetworkUserEntityData$$ExternalSyntheticLambda0 = new SolverVariable(SolverVariable.Type.UNRESTRICTED);
                } else {
                    solverVariable2.MyBillsEntityDataFactory();
                }
                solverVariable = constraintAnchor.NetworkUserEntityData$$ExternalSyntheticLambda0;
            }
            if (solverVariable.BuiltInFictitiousFunctionClassFactory == -1 || solverVariable.BuiltInFictitiousFunctionClassFactory > this.initRecordTimeStamp || this.NetworkUserEntityData$$ExternalSyntheticLambda2.KClassImpl$Data$declaredNonStaticMembers$2[solverVariable.BuiltInFictitiousFunctionClassFactory] == null) {
                if (solverVariable.BuiltInFictitiousFunctionClassFactory != -1) {
                    solverVariable.MyBillsEntityDataFactory();
                }
                int i = this.initRecordTimeStamp + 1;
                this.initRecordTimeStamp = i;
                this.DatabaseTableConfigUtil++;
                solverVariable.BuiltInFictitiousFunctionClassFactory = i;
                solverVariable.initRecordTimeStamp = SolverVariable.Type.UNRESTRICTED;
                this.NetworkUserEntityData$$ExternalSyntheticLambda2.KClassImpl$Data$declaredNonStaticMembers$2[this.initRecordTimeStamp] = solverVariable;
            }
        }
        return solverVariable;
    }

    public final ArrayRow MyBillsEntityDataFactory() {
        ArrayRow MyBillsEntityDataFactory2;
        if (BuiltInFictitiousFunctionClassFactory) {
            MyBillsEntityDataFactory2 = this.NetworkUserEntityData$$ExternalSyntheticLambda2.PlaceComponentResult.MyBillsEntityDataFactory();
            if (MyBillsEntityDataFactory2 == null) {
                MyBillsEntityDataFactory2 = new ValuesRow(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
                MyBillsEntityDataFactory++;
            } else {
                MyBillsEntityDataFactory2.PlaceComponentResult = null;
                MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult();
                MyBillsEntityDataFactory2.KClassImpl$Data$declaredNonStaticMembers$2 = 0.0f;
                MyBillsEntityDataFactory2.MyBillsEntityDataFactory = false;
            }
        } else {
            MyBillsEntityDataFactory2 = this.NetworkUserEntityData$$ExternalSyntheticLambda2.MyBillsEntityDataFactory.MyBillsEntityDataFactory();
            if (MyBillsEntityDataFactory2 == null) {
                MyBillsEntityDataFactory2 = new ArrayRow(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
                PlaceComponentResult++;
            } else {
                MyBillsEntityDataFactory2.PlaceComponentResult = null;
                MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult();
                MyBillsEntityDataFactory2.KClassImpl$Data$declaredNonStaticMembers$2 = 0.0f;
                MyBillsEntityDataFactory2.MyBillsEntityDataFactory = false;
            }
        }
        SolverVariable.getAuthRequestContext();
        return MyBillsEntityDataFactory2;
    }

    public final SolverVariable getAuthRequestContext() {
        Metrics metrics = getErrorConfigVersion;
        if (metrics != null) {
            metrics.getSupportButtonTintMode++;
        }
        if (this.DatabaseTableConfigUtil + 1 >= this.NetworkUserEntityData$$ExternalSyntheticLambda3) {
            scheduleImpl();
        }
        SolverVariable KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2(SolverVariable.Type.SLACK);
        int i = this.initRecordTimeStamp + 1;
        this.initRecordTimeStamp = i;
        this.DatabaseTableConfigUtil++;
        KClassImpl$Data$declaredNonStaticMembers$22.BuiltInFictitiousFunctionClassFactory = i;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.KClassImpl$Data$declaredNonStaticMembers$2[this.initRecordTimeStamp] = KClassImpl$Data$declaredNonStaticMembers$22;
        return KClassImpl$Data$declaredNonStaticMembers$22;
    }

    private SolverVariable lookAheadTest() {
        Metrics metrics = getErrorConfigVersion;
        if (metrics != null) {
            metrics.PlaceComponentResult++;
        }
        if (this.DatabaseTableConfigUtil + 1 >= this.NetworkUserEntityData$$ExternalSyntheticLambda3) {
            scheduleImpl();
        }
        SolverVariable KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2(SolverVariable.Type.SLACK);
        int i = this.initRecordTimeStamp + 1;
        this.initRecordTimeStamp = i;
        this.DatabaseTableConfigUtil++;
        KClassImpl$Data$declaredNonStaticMembers$22.BuiltInFictitiousFunctionClassFactory = i;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.KClassImpl$Data$declaredNonStaticMembers$2[this.initRecordTimeStamp] = KClassImpl$Data$declaredNonStaticMembers$22;
        return KClassImpl$Data$declaredNonStaticMembers$22;
    }

    public final SolverVariable PlaceComponentResult(int i) {
        Metrics metrics = getErrorConfigVersion;
        if (metrics != null) {
            metrics.MyBillsEntityDataFactory++;
        }
        if (this.DatabaseTableConfigUtil + 1 >= this.NetworkUserEntityData$$ExternalSyntheticLambda3) {
            scheduleImpl();
        }
        SolverVariable KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2(SolverVariable.Type.ERROR);
        int i2 = this.initRecordTimeStamp + 1;
        this.initRecordTimeStamp = i2;
        this.DatabaseTableConfigUtil++;
        KClassImpl$Data$declaredNonStaticMembers$22.BuiltInFictitiousFunctionClassFactory = i2;
        KClassImpl$Data$declaredNonStaticMembers$22.NetworkUserEntityData$$ExternalSyntheticLambda1 = i;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.KClassImpl$Data$declaredNonStaticMembers$2[this.initRecordTimeStamp] = KClassImpl$Data$declaredNonStaticMembers$22;
        this.isLayoutRequested.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$22);
        return KClassImpl$Data$declaredNonStaticMembers$22;
    }

    private SolverVariable KClassImpl$Data$declaredNonStaticMembers$2(SolverVariable.Type type) {
        SolverVariable MyBillsEntityDataFactory2 = this.NetworkUserEntityData$$ExternalSyntheticLambda2.getAuthRequestContext.MyBillsEntityDataFactory();
        if (MyBillsEntityDataFactory2 == null) {
            MyBillsEntityDataFactory2 = new SolverVariable(type);
            MyBillsEntityDataFactory2.initRecordTimeStamp = type;
        } else {
            MyBillsEntityDataFactory2.MyBillsEntityDataFactory();
            MyBillsEntityDataFactory2.initRecordTimeStamp = type;
        }
        int i = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
        int i2 = NetworkUserEntityData$$ExternalSyntheticLambda7;
        if (i >= i2) {
            int i3 = i2 * 2;
            NetworkUserEntityData$$ExternalSyntheticLambda7 = i3;
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = (SolverVariable[]) Arrays.copyOf(this.NetworkUserEntityData$$ExternalSyntheticLambda5, i3);
        }
        SolverVariable[] solverVariableArr = this.NetworkUserEntityData$$ExternalSyntheticLambda5;
        int i4 = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = i4 + 1;
        solverVariableArr[i4] = MyBillsEntityDataFactory2;
        return MyBillsEntityDataFactory2;
    }

    public static int KClassImpl$Data$declaredNonStaticMembers$2(Object obj) {
        SolverVariable solverVariable = ((ConstraintAnchor) obj).NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (solverVariable != null) {
            return (int) (solverVariable.KClassImpl$Data$declaredNonStaticMembers$2 + 0.5f);
        }
        return 0;
    }

    public final void PlaceComponentResult() throws Exception {
        Metrics metrics = getErrorConfigVersion;
        if (metrics != null) {
            metrics.NetworkUserEntityData$$ExternalSyntheticLambda5++;
        }
        if (this.isLayoutRequested.KClassImpl$Data$declaredNonStaticMembers$2()) {
            NetworkUserEntityData$$ExternalSyntheticLambda0();
        } else if (this.NetworkUserEntityData$$ExternalSyntheticLambda0 || this.PrepareContext) {
            Metrics metrics2 = getErrorConfigVersion;
            if (metrics2 != null) {
                metrics2.NetworkUserEntityData$$ExternalSyntheticLambda0++;
            }
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= this.NetworkUserEntityData$$ExternalSyntheticLambda1) {
                    z = true;
                    break;
                } else if (!this.GetContactSyncConfig[i].MyBillsEntityDataFactory) {
                    break;
                } else {
                    i++;
                }
            }
            if (!z) {
                getAuthRequestContext(this.isLayoutRequested);
                return;
            }
            Metrics metrics3 = getErrorConfigVersion;
            if (metrics3 != null) {
                metrics3.moveToNextValue++;
            }
            NetworkUserEntityData$$ExternalSyntheticLambda0();
        } else {
            getAuthRequestContext(this.isLayoutRequested);
        }
    }

    private void getAuthRequestContext(Row row) throws Exception {
        Metrics metrics = getErrorConfigVersion;
        if (metrics != null) {
            metrics.NetworkUserEntityData$$ExternalSyntheticLambda3++;
            Metrics metrics2 = getErrorConfigVersion;
            metrics2.isLayoutRequested = Math.max(metrics2.isLayoutRequested, this.DatabaseTableConfigUtil);
            Metrics metrics3 = getErrorConfigVersion;
            metrics3.initRecordTimeStamp = Math.max(metrics3.initRecordTimeStamp, this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        }
        getErrorConfigVersion();
        KClassImpl$Data$declaredNonStaticMembers$2(row);
        NetworkUserEntityData$$ExternalSyntheticLambda0();
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x00b1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:101:0x00b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void getAuthRequestContext(androidx.constraintlayout.core.ArrayRow r8) {
        /*
            r7 = this;
            if (r8 != 0) goto L3
            return
        L3:
            androidx.constraintlayout.core.Metrics r0 = androidx.constraintlayout.core.LinearSystem.getErrorConfigVersion
            r1 = 1
            if (r0 == 0) goto L19
            long r3 = r0.BuiltInFictitiousFunctionClassFactory
            long r3 = r3 + r1
            r0.BuiltInFictitiousFunctionClassFactory = r3
            boolean r0 = r8.MyBillsEntityDataFactory
            if (r0 == 0) goto L19
            androidx.constraintlayout.core.Metrics r0 = androidx.constraintlayout.core.LinearSystem.getErrorConfigVersion
            long r3 = r0.SubSequence
            long r3 = r3 + r1
            r0.SubSequence = r3
        L19:
            int r0 = r7.NetworkUserEntityData$$ExternalSyntheticLambda1
            r3 = 1
            int r0 = r0 + r3
            int r4 = r7.FragmentBottomSheetPaymentSettingBinding
            if (r0 >= r4) goto L28
            int r0 = r7.DatabaseTableConfigUtil
            int r0 = r0 + r3
            int r4 = r7.NetworkUserEntityData$$ExternalSyntheticLambda3
            if (r0 < r4) goto L2b
        L28:
            r7.scheduleImpl()
        L2b:
            boolean r0 = r8.MyBillsEntityDataFactory
            r4 = 0
            if (r0 != 0) goto Lb3
            r8.BuiltInFictitiousFunctionClassFactory(r7)
            boolean r0 = r8.KClassImpl$Data$declaredNonStaticMembers$2()
            if (r0 == 0) goto L3a
            return
        L3a:
            float r0 = r8.KClassImpl$Data$declaredNonStaticMembers$2
            r5 = 0
            int r5 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r5 >= 0) goto L4c
            r5 = -1082130432(0xffffffffbf800000, float:-1.0)
            float r0 = r0 * r5
            r8.KClassImpl$Data$declaredNonStaticMembers$2 = r0
            androidx.constraintlayout.core.ArrayRow$ArrayRowVariables r0 = r8.BuiltInFictitiousFunctionClassFactory
            r0.getAuthRequestContext()
        L4c:
            boolean r0 = r8.PlaceComponentResult()
            if (r0 == 0) goto Laa
            androidx.constraintlayout.core.SolverVariable r0 = r7.lookAheadTest()
            r8.PlaceComponentResult = r0
            int r5 = r7.NetworkUserEntityData$$ExternalSyntheticLambda1
            r7.KClassImpl$Data$declaredNonStaticMembers$2(r8)
            int r6 = r7.NetworkUserEntityData$$ExternalSyntheticLambda1
            int r5 = r5 + r3
            if (r6 != r5) goto Laa
            androidx.constraintlayout.core.LinearSystem$Row r4 = r7.NetworkUserEntityData$$ExternalSyntheticLambda6
            r4.KClassImpl$Data$declaredNonStaticMembers$2(r8)
            androidx.constraintlayout.core.LinearSystem$Row r4 = r7.NetworkUserEntityData$$ExternalSyntheticLambda6
            r7.KClassImpl$Data$declaredNonStaticMembers$2(r4)
            int r4 = r0.getAuthRequestContext
            r5 = -1
            if (r4 != r5) goto Lab
            androidx.constraintlayout.core.SolverVariable r4 = r8.PlaceComponentResult
            if (r4 != r0) goto L88
            r4 = 0
            androidx.constraintlayout.core.SolverVariable r0 = r8.BuiltInFictitiousFunctionClassFactory(r4, r0)
            if (r0 == 0) goto L88
            androidx.constraintlayout.core.Metrics r4 = androidx.constraintlayout.core.LinearSystem.getErrorConfigVersion
            if (r4 == 0) goto L85
            long r5 = r4.whenAvailable
            long r5 = r5 + r1
            r4.whenAvailable = r5
        L85:
            r8.getAuthRequestContext(r0)
        L88:
            boolean r0 = r8.MyBillsEntityDataFactory
            if (r0 != 0) goto L91
            androidx.constraintlayout.core.SolverVariable r0 = r8.PlaceComponentResult
            r0.BuiltInFictitiousFunctionClassFactory(r7, r8)
        L91:
            boolean r0 = androidx.constraintlayout.core.LinearSystem.BuiltInFictitiousFunctionClassFactory
            if (r0 == 0) goto L9d
            androidx.constraintlayout.core.Cache r0 = r7.NetworkUserEntityData$$ExternalSyntheticLambda2
            androidx.constraintlayout.core.Pools$Pool<androidx.constraintlayout.core.ArrayRow> r0 = r0.PlaceComponentResult
            r0.PlaceComponentResult(r8)
            goto La4
        L9d:
            androidx.constraintlayout.core.Cache r0 = r7.NetworkUserEntityData$$ExternalSyntheticLambda2
            androidx.constraintlayout.core.Pools$Pool<androidx.constraintlayout.core.ArrayRow> r0 = r0.MyBillsEntityDataFactory
            r0.PlaceComponentResult(r8)
        La4:
            int r0 = r7.NetworkUserEntityData$$ExternalSyntheticLambda1
            int r0 = r0 - r3
            r7.NetworkUserEntityData$$ExternalSyntheticLambda1 = r0
            goto Lab
        Laa:
            r3 = 0
        Lab:
            boolean r0 = r8.BuiltInFictitiousFunctionClassFactory()
            if (r0 != 0) goto Lb2
            return
        Lb2:
            r4 = r3
        Lb3:
            if (r4 != 0) goto Lb8
            r7.KClassImpl$Data$declaredNonStaticMembers$2(r8)
        Lb8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.LinearSystem.getAuthRequestContext(androidx.constraintlayout.core.ArrayRow):void");
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(ArrayRow arrayRow) {
        int i;
        if (getAuthRequestContext && arrayRow.MyBillsEntityDataFactory) {
            arrayRow.PlaceComponentResult.getAuthRequestContext(this, arrayRow.KClassImpl$Data$declaredNonStaticMembers$2);
        } else {
            this.GetContactSyncConfig[this.NetworkUserEntityData$$ExternalSyntheticLambda1] = arrayRow;
            arrayRow.PlaceComponentResult.getAuthRequestContext = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1++;
            arrayRow.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(this, arrayRow);
        }
        if (getAuthRequestContext && this.scheduleImpl) {
            int i2 = 0;
            while (i2 < this.NetworkUserEntityData$$ExternalSyntheticLambda1) {
                if (this.GetContactSyncConfig[i2] == null) {
                    System.out.println("WTF");
                }
                ArrayRow arrayRow2 = this.GetContactSyncConfig[i2];
                if (arrayRow2 != null && arrayRow2.MyBillsEntityDataFactory) {
                    ArrayRow arrayRow3 = this.GetContactSyncConfig[i2];
                    arrayRow3.PlaceComponentResult.getAuthRequestContext(this, arrayRow3.KClassImpl$Data$declaredNonStaticMembers$2);
                    if (BuiltInFictitiousFunctionClassFactory) {
                        this.NetworkUserEntityData$$ExternalSyntheticLambda2.PlaceComponentResult.PlaceComponentResult(arrayRow3);
                    } else {
                        this.NetworkUserEntityData$$ExternalSyntheticLambda2.MyBillsEntityDataFactory.PlaceComponentResult(arrayRow3);
                    }
                    this.GetContactSyncConfig[i2] = null;
                    int i3 = i2 + 1;
                    int i4 = i3;
                    while (true) {
                        i = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                        if (i3 >= i) {
                            break;
                        }
                        ArrayRow[] arrayRowArr = this.GetContactSyncConfig;
                        int i5 = i3 - 1;
                        ArrayRow arrayRow4 = arrayRowArr[i3];
                        arrayRowArr[i5] = arrayRow4;
                        if (arrayRow4.PlaceComponentResult.getAuthRequestContext == i3) {
                            this.GetContactSyncConfig[i5].PlaceComponentResult.getAuthRequestContext = i5;
                        }
                        i4 = i3;
                        i3++;
                    }
                    if (i4 < i) {
                        this.GetContactSyncConfig[i4] = null;
                    }
                    this.NetworkUserEntityData$$ExternalSyntheticLambda1 = i - 1;
                    i2--;
                }
                i2++;
            }
            this.scheduleImpl = false;
        }
    }

    private final int KClassImpl$Data$declaredNonStaticMembers$2(Row row) {
        Metrics metrics = getErrorConfigVersion;
        if (metrics != null) {
            metrics.readMicros++;
        }
        for (int i = 0; i < this.DatabaseTableConfigUtil; i++) {
            this.newProxyInstance[i] = false;
        }
        boolean z = false;
        int i2 = 0;
        while (!z) {
            Metrics metrics2 = getErrorConfigVersion;
            if (metrics2 != null) {
                metrics2.NetworkUserEntityData$$ExternalSyntheticLambda1++;
            }
            i2++;
            if (i2 >= this.DatabaseTableConfigUtil * 2) {
                return i2;
            }
            if (row.getAuthRequestContext() != null) {
                this.newProxyInstance[row.getAuthRequestContext().BuiltInFictitiousFunctionClassFactory] = true;
            }
            SolverVariable MyBillsEntityDataFactory2 = row.MyBillsEntityDataFactory(this.newProxyInstance);
            if (MyBillsEntityDataFactory2 != null) {
                if (this.newProxyInstance[MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory]) {
                    return i2;
                }
                this.newProxyInstance[MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory] = true;
            }
            if (MyBillsEntityDataFactory2 != null) {
                float f = Float.MAX_VALUE;
                int i3 = -1;
                for (int i4 = 0; i4 < this.NetworkUserEntityData$$ExternalSyntheticLambda1; i4++) {
                    ArrayRow arrayRow = this.GetContactSyncConfig[i4];
                    if (arrayRow.PlaceComponentResult.initRecordTimeStamp != SolverVariable.Type.UNRESTRICTED && !arrayRow.MyBillsEntityDataFactory && arrayRow.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory2)) {
                        float MyBillsEntityDataFactory3 = arrayRow.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(MyBillsEntityDataFactory2);
                        if (MyBillsEntityDataFactory3 < 0.0f) {
                            float f2 = (-arrayRow.KClassImpl$Data$declaredNonStaticMembers$2) / MyBillsEntityDataFactory3;
                            if (f2 < f) {
                                i3 = i4;
                                f = f2;
                            }
                        }
                    }
                }
                if (i3 >= 0) {
                    ArrayRow arrayRow2 = this.GetContactSyncConfig[i3];
                    arrayRow2.PlaceComponentResult.getAuthRequestContext = -1;
                    Metrics metrics3 = getErrorConfigVersion;
                    if (metrics3 != null) {
                        metrics3.whenAvailable++;
                    }
                    arrayRow2.getAuthRequestContext(MyBillsEntityDataFactory2);
                    arrayRow2.PlaceComponentResult.getAuthRequestContext = i3;
                    arrayRow2.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(this, arrayRow2);
                }
            } else {
                z = true;
            }
        }
        return i2;
    }

    private int getErrorConfigVersion() throws Exception {
        boolean z;
        int i = 0;
        while (true) {
            if (i >= this.NetworkUserEntityData$$ExternalSyntheticLambda1) {
                z = false;
                break;
            } else if (this.GetContactSyncConfig[i].PlaceComponentResult.initRecordTimeStamp != SolverVariable.Type.UNRESTRICTED && this.GetContactSyncConfig[i].KClassImpl$Data$declaredNonStaticMembers$2 < 0.0f) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (z) {
            boolean z2 = false;
            int i2 = 0;
            while (!z2) {
                Metrics metrics = getErrorConfigVersion;
                if (metrics != null) {
                    metrics.KClassImpl$Data$declaredNonStaticMembers$2++;
                }
                i2++;
                float f = Float.MAX_VALUE;
                int i3 = -1;
                int i4 = -1;
                int i5 = 0;
                for (int i6 = 0; i6 < this.NetworkUserEntityData$$ExternalSyntheticLambda1; i6++) {
                    ArrayRow arrayRow = this.GetContactSyncConfig[i6];
                    if (arrayRow.PlaceComponentResult.initRecordTimeStamp != SolverVariable.Type.UNRESTRICTED && !arrayRow.MyBillsEntityDataFactory && arrayRow.KClassImpl$Data$declaredNonStaticMembers$2 < 0.0f) {
                        int i7 = 9;
                        if (KClassImpl$Data$declaredNonStaticMembers$2) {
                            int MyBillsEntityDataFactory2 = arrayRow.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory();
                            int i8 = 0;
                            while (i8 < MyBillsEntityDataFactory2) {
                                SolverVariable KClassImpl$Data$declaredNonStaticMembers$22 = arrayRow.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(i8);
                                float MyBillsEntityDataFactory3 = arrayRow.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$22);
                                if (MyBillsEntityDataFactory3 > 0.0f) {
                                    int i9 = 0;
                                    while (i9 < i7) {
                                        float f2 = KClassImpl$Data$declaredNonStaticMembers$22.GetContactSyncConfig[i9] / MyBillsEntityDataFactory3;
                                        if ((f2 < f && i9 == i5) || i9 > i5) {
                                            i4 = KClassImpl$Data$declaredNonStaticMembers$22.BuiltInFictitiousFunctionClassFactory;
                                            i5 = i9;
                                            i3 = i6;
                                            f = f2;
                                        }
                                        i9++;
                                        i7 = 9;
                                    }
                                }
                                i8++;
                                i7 = 9;
                            }
                        } else {
                            for (int i10 = 1; i10 < this.DatabaseTableConfigUtil; i10++) {
                                SolverVariable solverVariable = this.NetworkUserEntityData$$ExternalSyntheticLambda2.KClassImpl$Data$declaredNonStaticMembers$2[i10];
                                float MyBillsEntityDataFactory4 = arrayRow.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(solverVariable);
                                if (MyBillsEntityDataFactory4 > 0.0f) {
                                    for (int i11 = 0; i11 < 9; i11++) {
                                        float f3 = solverVariable.GetContactSyncConfig[i11] / MyBillsEntityDataFactory4;
                                        if ((f3 < f && i11 == i5) || i11 > i5) {
                                            i4 = i10;
                                            i5 = i11;
                                            i3 = i6;
                                            f = f3;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (i3 != -1) {
                    ArrayRow arrayRow2 = this.GetContactSyncConfig[i3];
                    arrayRow2.PlaceComponentResult.getAuthRequestContext = -1;
                    Metrics metrics2 = getErrorConfigVersion;
                    if (metrics2 != null) {
                        metrics2.whenAvailable++;
                    }
                    arrayRow2.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda2.KClassImpl$Data$declaredNonStaticMembers$2[i4]);
                    arrayRow2.PlaceComponentResult.getAuthRequestContext = i3;
                    arrayRow2.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(this, arrayRow2);
                } else {
                    z2 = true;
                }
                if (i2 > this.DatabaseTableConfigUtil / 2) {
                    z2 = true;
                }
            }
            return i2;
        }
        return 0;
    }

    private void NetworkUserEntityData$$ExternalSyntheticLambda0() {
        for (int i = 0; i < this.NetworkUserEntityData$$ExternalSyntheticLambda1; i++) {
            ArrayRow arrayRow = this.GetContactSyncConfig[i];
            arrayRow.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2 = arrayRow.KClassImpl$Data$declaredNonStaticMembers$2;
        }
    }

    public final void PlaceComponentResult(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        ArrayRow MyBillsEntityDataFactory2 = MyBillsEntityDataFactory();
        SolverVariable authRequestContext = getAuthRequestContext();
        authRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda1 = 0;
        MyBillsEntityDataFactory2.PlaceComponentResult(solverVariable, solverVariable2, authRequestContext, i);
        if (i2 != 8) {
            MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(PlaceComponentResult(i2), (int) (MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(authRequestContext) * (-1.0f)));
        }
        getAuthRequestContext(MyBillsEntityDataFactory2);
    }

    public final void BuiltInFictitiousFunctionClassFactory(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        ArrayRow MyBillsEntityDataFactory2 = MyBillsEntityDataFactory();
        SolverVariable authRequestContext = getAuthRequestContext();
        authRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda1 = 0;
        MyBillsEntityDataFactory2.MyBillsEntityDataFactory(solverVariable, solverVariable2, authRequestContext, i);
        if (i2 != 8) {
            MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(PlaceComponentResult(i2), (int) (MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(authRequestContext) * (-1.0f)));
        }
        getAuthRequestContext(MyBillsEntityDataFactory2);
    }

    public final void BuiltInFictitiousFunctionClassFactory(SolverVariable solverVariable, SolverVariable solverVariable2, int i, float f, SolverVariable solverVariable3, SolverVariable solverVariable4, int i2, int i3) {
        ArrayRow MyBillsEntityDataFactory2 = MyBillsEntityDataFactory();
        if (solverVariable2 == solverVariable3) {
            MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(solverVariable, 1.0f);
            MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(solverVariable4, 1.0f);
            MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(solverVariable2, -2.0f);
        } else if (f == 0.5f) {
            MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(solverVariable, 1.0f);
            MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(solverVariable2, -1.0f);
            MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(solverVariable3, -1.0f);
            MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(solverVariable4, 1.0f);
            if (i > 0 || i2 > 0) {
                MyBillsEntityDataFactory2.KClassImpl$Data$declaredNonStaticMembers$2 = (-i) + i2;
            }
        } else if (f <= 0.0f) {
            MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(solverVariable, -1.0f);
            MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(solverVariable2, 1.0f);
            MyBillsEntityDataFactory2.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        } else if (f >= 1.0f) {
            MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(solverVariable4, -1.0f);
            MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(solverVariable3, 1.0f);
            MyBillsEntityDataFactory2.KClassImpl$Data$declaredNonStaticMembers$2 = -i2;
        } else {
            float f2 = 1.0f - f;
            MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(solverVariable, f2 * 1.0f);
            MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(solverVariable2, f2 * (-1.0f));
            MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(solverVariable3, (-1.0f) * f);
            MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(solverVariable4, 1.0f * f);
            if (i > 0 || i2 > 0) {
                MyBillsEntityDataFactory2.KClassImpl$Data$declaredNonStaticMembers$2 = ((-i) * f2) + (i2 * f);
            }
        }
        if (i3 != 8) {
            MyBillsEntityDataFactory2.KClassImpl$Data$declaredNonStaticMembers$2(this, i3);
        }
        getAuthRequestContext(MyBillsEntityDataFactory2);
    }

    public final ArrayRow KClassImpl$Data$declaredNonStaticMembers$2(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        if (lookAheadTest && i2 == 8 && solverVariable2.NetworkUserEntityData$$ExternalSyntheticLambda0 && solverVariable.getAuthRequestContext == -1) {
            solverVariable.getAuthRequestContext(this, solverVariable2.KClassImpl$Data$declaredNonStaticMembers$2 + i);
            return null;
        }
        ArrayRow MyBillsEntityDataFactory2 = MyBillsEntityDataFactory();
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            MyBillsEntityDataFactory2.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        }
        if (!z) {
            MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(solverVariable, -1.0f);
            MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(solverVariable2, 1.0f);
        } else {
            MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(solverVariable, 1.0f);
            MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(solverVariable2, -1.0f);
        }
        if (i2 != 8) {
            MyBillsEntityDataFactory2.KClassImpl$Data$declaredNonStaticMembers$2(this, i2);
        }
        getAuthRequestContext(MyBillsEntityDataFactory2);
        return MyBillsEntityDataFactory2;
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(SolverVariable solverVariable, int i) {
        if (lookAheadTest && solverVariable.getAuthRequestContext == -1) {
            float f = i;
            solverVariable.getAuthRequestContext(this, f);
            for (int i2 = 0; i2 < this.initRecordTimeStamp + 1; i2++) {
                SolverVariable solverVariable2 = this.NetworkUserEntityData$$ExternalSyntheticLambda2.KClassImpl$Data$declaredNonStaticMembers$2[i2];
                if (solverVariable2 != null && solverVariable2.scheduleImpl && solverVariable2.NetworkUserEntityData$$ExternalSyntheticLambda2 == solverVariable.BuiltInFictitiousFunctionClassFactory) {
                    solverVariable2.getAuthRequestContext(this, solverVariable2.DatabaseTableConfigUtil + f);
                }
            }
            return;
        }
        int i3 = solverVariable.getAuthRequestContext;
        if (solverVariable.getAuthRequestContext != -1) {
            ArrayRow arrayRow = this.GetContactSyncConfig[i3];
            if (arrayRow.MyBillsEntityDataFactory) {
                arrayRow.KClassImpl$Data$declaredNonStaticMembers$2 = i;
                return;
            } else if (arrayRow.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory() == 0) {
                arrayRow.MyBillsEntityDataFactory = true;
                arrayRow.KClassImpl$Data$declaredNonStaticMembers$2 = i;
                return;
            } else {
                ArrayRow MyBillsEntityDataFactory2 = MyBillsEntityDataFactory();
                if (i < 0) {
                    MyBillsEntityDataFactory2.KClassImpl$Data$declaredNonStaticMembers$2 = i * (-1);
                    MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(solverVariable, 1.0f);
                } else {
                    MyBillsEntityDataFactory2.KClassImpl$Data$declaredNonStaticMembers$2 = i;
                    MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(solverVariable, -1.0f);
                }
                getAuthRequestContext(MyBillsEntityDataFactory2);
                return;
            }
        }
        ArrayRow MyBillsEntityDataFactory3 = MyBillsEntityDataFactory();
        MyBillsEntityDataFactory3.PlaceComponentResult = solverVariable;
        float f2 = i;
        solverVariable.KClassImpl$Data$declaredNonStaticMembers$2 = f2;
        MyBillsEntityDataFactory3.KClassImpl$Data$declaredNonStaticMembers$2 = f2;
        MyBillsEntityDataFactory3.MyBillsEntityDataFactory = true;
        getAuthRequestContext(MyBillsEntityDataFactory3);
    }

    public static ArrayRow BuiltInFictitiousFunctionClassFactory(LinearSystem linearSystem, SolverVariable solverVariable, SolverVariable solverVariable2, float f) {
        ArrayRow MyBillsEntityDataFactory2 = linearSystem.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(solverVariable, -1.0f);
        MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(solverVariable2, f);
        return MyBillsEntityDataFactory2;
    }
}
