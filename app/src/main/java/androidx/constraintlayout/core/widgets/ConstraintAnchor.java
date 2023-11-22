package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.analyzer.Grouping;
import androidx.constraintlayout.core.widgets.analyzer.WidgetGroup;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class ConstraintAnchor {
    public boolean KClassImpl$Data$declaredNonStaticMembers$2;
    public SolverVariable NetworkUserEntityData$$ExternalSyntheticLambda0;
    public int PlaceComponentResult;
    public final Type getErrorConfigVersion;
    public final ConstraintWidget lookAheadTest;
    public ConstraintAnchor moveToNextValue;
    public HashSet<ConstraintAnchor> MyBillsEntityDataFactory = null;
    public int getAuthRequestContext = 0;
    int BuiltInFictitiousFunctionClassFactory = Integer.MIN_VALUE;

    /* loaded from: classes3.dex */
    public enum Type {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(int i, ArrayList<WidgetGroup> arrayList, WidgetGroup widgetGroup) {
        HashSet<ConstraintAnchor> hashSet = this.MyBillsEntityDataFactory;
        if (hashSet != null) {
            Iterator<ConstraintAnchor> it = hashSet.iterator();
            while (it.hasNext()) {
                Grouping.getAuthRequestContext(it.next().lookAheadTest, i, arrayList, widgetGroup);
            }
        }
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        HashSet<ConstraintAnchor> hashSet = this.MyBillsEntityDataFactory;
        return hashSet != null && hashSet.size() > 0;
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        HashSet<ConstraintAnchor> hashSet = this.MyBillsEntityDataFactory;
        if (hashSet == null) {
            return false;
        }
        Iterator<ConstraintAnchor> it = hashSet.iterator();
        while (it.hasNext()) {
            if (it.next().PlaceComponentResult().scheduleImpl()) {
                return true;
            }
        }
        return false;
    }

    public final boolean getAuthRequestContext() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public ConstraintAnchor(ConstraintWidget constraintWidget, Type type) {
        this.lookAheadTest = constraintWidget;
        this.getErrorConfigVersion = type;
    }

    public final int MyBillsEntityDataFactory() {
        ConstraintAnchor constraintAnchor;
        if (this.lookAheadTest.h == 8) {
            return 0;
        }
        if (this.BuiltInFictitiousFunctionClassFactory != Integer.MIN_VALUE && (constraintAnchor = this.moveToNextValue) != null && constraintAnchor.lookAheadTest.h == 8) {
            return this.BuiltInFictitiousFunctionClassFactory;
        }
        return this.getAuthRequestContext;
    }

    public final void lookAheadTest() {
        HashSet<ConstraintAnchor> hashSet;
        ConstraintAnchor constraintAnchor = this.moveToNextValue;
        if (constraintAnchor != null && (hashSet = constraintAnchor.MyBillsEntityDataFactory) != null) {
            hashSet.remove(this);
            if (this.moveToNextValue.MyBillsEntityDataFactory.size() == 0) {
                this.moveToNextValue.MyBillsEntityDataFactory = null;
            }
        }
        this.MyBillsEntityDataFactory = null;
        this.moveToNextValue = null;
        this.getAuthRequestContext = 0;
        this.BuiltInFictitiousFunctionClassFactory = Integer.MIN_VALUE;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
        this.PlaceComponentResult = 0;
    }

    public final boolean BuiltInFictitiousFunctionClassFactory(ConstraintAnchor constraintAnchor, int i, int i2, boolean z) {
        if (constraintAnchor == null) {
            lookAheadTest();
            return true;
        } else if (z || BuiltInFictitiousFunctionClassFactory(constraintAnchor)) {
            this.moveToNextValue = constraintAnchor;
            if (constraintAnchor.MyBillsEntityDataFactory == null) {
                constraintAnchor.MyBillsEntityDataFactory = new HashSet<>();
            }
            HashSet<ConstraintAnchor> hashSet = this.moveToNextValue.MyBillsEntityDataFactory;
            if (hashSet != null) {
                hashSet.add(this);
            }
            this.getAuthRequestContext = i;
            this.BuiltInFictitiousFunctionClassFactory = i2;
            return true;
        } else {
            return false;
        }
    }

    public final boolean BuiltInFictitiousFunctionClassFactory(ConstraintAnchor constraintAnchor, int i) {
        return BuiltInFictitiousFunctionClassFactory(constraintAnchor, i, Integer.MIN_VALUE, false);
    }

    public final boolean scheduleImpl() {
        return this.moveToNextValue != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.constraintlayout.core.widgets.ConstraintAnchor$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] MyBillsEntityDataFactory;

        static {
            int[] iArr = new int[Type.values().length];
            MyBillsEntityDataFactory = iArr;
            try {
                iArr[Type.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                MyBillsEntityDataFactory[Type.LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                MyBillsEntityDataFactory[Type.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                MyBillsEntityDataFactory[Type.TOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                MyBillsEntityDataFactory[Type.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                MyBillsEntityDataFactory[Type.BASELINE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                MyBillsEntityDataFactory[Type.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                MyBillsEntityDataFactory[Type.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                MyBillsEntityDataFactory[Type.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.lookAheadTest.NetworkUserEntityData$$ExternalSyntheticLambda4);
        sb.append(":");
        sb.append(this.getErrorConfigVersion.toString());
        return sb.toString();
    }

    public final ConstraintAnchor PlaceComponentResult() {
        switch (AnonymousClass1.MyBillsEntityDataFactory[this.getErrorConfigVersion.ordinal()]) {
            case 1:
            case 6:
            case 7:
            case 8:
            case 9:
                return null;
            case 2:
                return this.lookAheadTest.c;
            case 3:
                return this.lookAheadTest.I;
            case 4:
                return this.lookAheadTest.isLayoutRequested;
            case 5:
                return this.lookAheadTest.f5939a;
            default:
                throw new AssertionError(this.getErrorConfigVersion.name());
        }
    }

    public final boolean BuiltInFictitiousFunctionClassFactory(ConstraintAnchor constraintAnchor) {
        if (constraintAnchor == null) {
            return false;
        }
        Type type = constraintAnchor.getErrorConfigVersion;
        Type type2 = this.getErrorConfigVersion;
        if (type == type2) {
            return type2 != Type.BASELINE || (constraintAnchor.lookAheadTest.NetworkUserEntityData$$ExternalSyntheticLambda7() && this.lookAheadTest.NetworkUserEntityData$$ExternalSyntheticLambda7());
        }
        switch (AnonymousClass1.MyBillsEntityDataFactory[this.getErrorConfigVersion.ordinal()]) {
            case 1:
                return (type == Type.BASELINE || type == Type.CENTER_X || type == Type.CENTER_Y) ? false : true;
            case 2:
            case 3:
                boolean z = type == Type.LEFT || type == Type.RIGHT;
                if (constraintAnchor.lookAheadTest instanceof Guideline) {
                    return z || type == Type.CENTER_X;
                }
                return z;
            case 4:
            case 5:
                boolean z2 = type == Type.TOP || type == Type.BOTTOM;
                if (constraintAnchor.lookAheadTest instanceof Guideline) {
                    return z2 || type == Type.CENTER_Y;
                }
                return z2;
            case 6:
                return (type == Type.LEFT || type == Type.RIGHT) ? false : true;
            case 7:
            case 8:
            case 9:
                return false;
            default:
                throw new AssertionError(this.getErrorConfigVersion.name());
        }
    }
}
