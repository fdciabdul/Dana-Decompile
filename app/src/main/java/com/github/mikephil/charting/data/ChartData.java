package com.github.mikephil.charting.data;

import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class ChartData<T extends IDataSet<? extends Entry>> {
    protected List<T> BuiltInFictitiousFunctionClassFactory;
    protected float KClassImpl$Data$declaredNonStaticMembers$2;
    protected float MyBillsEntityDataFactory;
    protected float NetworkUserEntityData$$ExternalSyntheticLambda0;
    protected float getAuthRequestContext;
    protected float getErrorConfigVersion;
    protected float lookAheadTest;
    protected float moveToNextValue;
    protected float scheduleImpl;

    public ChartData() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = -3.4028235E38f;
        this.lookAheadTest = Float.MAX_VALUE;
        this.getErrorConfigVersion = -3.4028235E38f;
        this.scheduleImpl = Float.MAX_VALUE;
        this.getAuthRequestContext = -3.4028235E38f;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = Float.MAX_VALUE;
        this.MyBillsEntityDataFactory = -3.4028235E38f;
        this.moveToNextValue = Float.MAX_VALUE;
        this.BuiltInFictitiousFunctionClassFactory = new ArrayList();
    }

    public ChartData(List<T> list) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = -3.4028235E38f;
        this.lookAheadTest = Float.MAX_VALUE;
        this.getErrorConfigVersion = -3.4028235E38f;
        this.scheduleImpl = Float.MAX_VALUE;
        this.getAuthRequestContext = -3.4028235E38f;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = Float.MAX_VALUE;
        this.MyBillsEntityDataFactory = -3.4028235E38f;
        this.moveToNextValue = Float.MAX_VALUE;
        this.BuiltInFictitiousFunctionClassFactory = list;
        NetworkUserEntityData$$ExternalSyntheticLambda2();
    }

    public void NetworkUserEntityData$$ExternalSyntheticLambda2() {
        PlaceComponentResult();
    }

    public final void getAuthRequestContext(float f, float f2) {
        Iterator<T> it = this.BuiltInFictitiousFunctionClassFactory.iterator();
        while (it.hasNext()) {
            it.next().KClassImpl$Data$declaredNonStaticMembers$2(f, f2);
        }
        PlaceComponentResult();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void PlaceComponentResult() {
        T t;
        T t2;
        List<T> list = this.BuiltInFictitiousFunctionClassFactory;
        if (list == null) {
            return;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = -3.4028235E38f;
        this.lookAheadTest = Float.MAX_VALUE;
        this.getErrorConfigVersion = -3.4028235E38f;
        this.scheduleImpl = Float.MAX_VALUE;
        for (T t3 : list) {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda0 < t3.getOnBoardingScenario()) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = t3.getOnBoardingScenario();
            }
            if (this.lookAheadTest > t3.D()) {
                this.lookAheadTest = t3.D();
            }
            if (this.getErrorConfigVersion < t3.VerifyPinStateManager$executeRiskChallenge$2$1()) {
                this.getErrorConfigVersion = t3.VerifyPinStateManager$executeRiskChallenge$2$1();
            }
            if (this.scheduleImpl > t3.C()) {
                this.scheduleImpl = t3.C();
            }
            if (t3.scheduleImpl() == YAxis.AxisDependency.LEFT) {
                if (this.getAuthRequestContext < t3.getOnBoardingScenario()) {
                    this.getAuthRequestContext = t3.getOnBoardingScenario();
                }
                if (this.KClassImpl$Data$declaredNonStaticMembers$2 > t3.D()) {
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = t3.D();
                }
            } else {
                if (this.MyBillsEntityDataFactory < t3.getOnBoardingScenario()) {
                    this.MyBillsEntityDataFactory = t3.getOnBoardingScenario();
                }
                if (this.moveToNextValue > t3.D()) {
                    this.moveToNextValue = t3.D();
                }
            }
        }
        this.getAuthRequestContext = -3.4028235E38f;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = Float.MAX_VALUE;
        this.MyBillsEntityDataFactory = -3.4028235E38f;
        this.moveToNextValue = Float.MAX_VALUE;
        Iterator<T> it = this.BuiltInFictitiousFunctionClassFactory.iterator();
        while (true) {
            t = null;
            if (!it.hasNext()) {
                t2 = null;
                break;
            }
            t2 = it.next();
            if (t2.scheduleImpl() == YAxis.AxisDependency.LEFT) {
                break;
            }
        }
        if (t2 != null) {
            this.getAuthRequestContext = t2.getOnBoardingScenario();
            this.KClassImpl$Data$declaredNonStaticMembers$2 = t2.D();
            for (T t4 : this.BuiltInFictitiousFunctionClassFactory) {
                if (t4.scheduleImpl() == YAxis.AxisDependency.LEFT) {
                    if (t4.D() < this.KClassImpl$Data$declaredNonStaticMembers$2) {
                        this.KClassImpl$Data$declaredNonStaticMembers$2 = t4.D();
                    }
                    if (t4.getOnBoardingScenario() > this.getAuthRequestContext) {
                        this.getAuthRequestContext = t4.getOnBoardingScenario();
                    }
                }
            }
        }
        Iterator<T> it2 = this.BuiltInFictitiousFunctionClassFactory.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            T next = it2.next();
            if (next.scheduleImpl() == YAxis.AxisDependency.RIGHT) {
                t = next;
                break;
            }
        }
        if (t != null) {
            this.MyBillsEntityDataFactory = t.getOnBoardingScenario();
            this.moveToNextValue = t.D();
            for (T t5 : this.BuiltInFictitiousFunctionClassFactory) {
                if (t5.scheduleImpl() == YAxis.AxisDependency.RIGHT) {
                    if (t5.D() < this.moveToNextValue) {
                        this.moveToNextValue = t5.D();
                    }
                    if (t5.getOnBoardingScenario() > this.MyBillsEntityDataFactory) {
                        this.MyBillsEntityDataFactory = t5.getOnBoardingScenario();
                    }
                }
            }
        }
    }

    public final int KClassImpl$Data$declaredNonStaticMembers$2() {
        List<T> list = this.BuiltInFictitiousFunctionClassFactory;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public final float moveToNextValue() {
        return this.lookAheadTest;
    }

    public final float MyBillsEntityDataFactory(YAxis.AxisDependency axisDependency) {
        if (axisDependency == YAxis.AxisDependency.LEFT) {
            float f = this.KClassImpl$Data$declaredNonStaticMembers$2;
            return f == Float.MAX_VALUE ? this.moveToNextValue : f;
        }
        float f2 = this.moveToNextValue;
        return f2 == Float.MAX_VALUE ? this.KClassImpl$Data$declaredNonStaticMembers$2 : f2;
    }

    public final float scheduleImpl() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }

    public final float getAuthRequestContext(YAxis.AxisDependency axisDependency) {
        if (axisDependency == YAxis.AxisDependency.LEFT) {
            float f = this.getAuthRequestContext;
            return f == -3.4028235E38f ? this.MyBillsEntityDataFactory : f;
        }
        float f2 = this.MyBillsEntityDataFactory;
        return f2 == -3.4028235E38f ? this.getAuthRequestContext : f2;
    }

    public final float lookAheadTest() {
        return this.scheduleImpl;
    }

    public final float NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return this.getErrorConfigVersion;
    }

    public final List<T> BuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    public T MyBillsEntityDataFactory(int i) {
        List<T> list = this.BuiltInFictitiousFunctionClassFactory;
        if (list == null || i < 0 || i >= list.size()) {
            return null;
        }
        return this.BuiltInFictitiousFunctionClassFactory.get(i);
    }

    public final T MyBillsEntityDataFactory(Entry entry) {
        if (entry == null) {
            return null;
        }
        for (int i = 0; i < this.BuiltInFictitiousFunctionClassFactory.size(); i++) {
            T t = this.BuiltInFictitiousFunctionClassFactory.get(i);
            for (int i2 = 0; i2 < t.BottomSheetCardBindingView$watcherCardNumberView$1(); i2++) {
                if (entry.KClassImpl$Data$declaredNonStaticMembers$2(t.getAuthRequestContext(entry.MyBillsEntityDataFactory(), entry.getAuthRequestContext()))) {
                    return t;
                }
            }
        }
        return null;
    }

    public final void MyBillsEntityDataFactory() {
        List<T> list = this.BuiltInFictitiousFunctionClassFactory;
        if (list != null) {
            list.clear();
        }
        NetworkUserEntityData$$ExternalSyntheticLambda2();
    }

    public final int getAuthRequestContext() {
        Iterator<T> it = this.BuiltInFictitiousFunctionClassFactory.iterator();
        int i = 0;
        while (it.hasNext()) {
            i += it.next().BottomSheetCardBindingView$watcherCardNumberView$1();
        }
        return i;
    }

    public final T getErrorConfigVersion() {
        List<T> list = this.BuiltInFictitiousFunctionClassFactory;
        if (list == null || list.isEmpty()) {
            return null;
        }
        T t = this.BuiltInFictitiousFunctionClassFactory.get(0);
        for (T t2 : this.BuiltInFictitiousFunctionClassFactory) {
            if (t2.BottomSheetCardBindingView$watcherCardNumberView$1() > t.BottomSheetCardBindingView$watcherCardNumberView$1()) {
                t = t2;
            }
        }
        return t;
    }

    public Entry BuiltInFictitiousFunctionClassFactory(Highlight highlight) {
        if (highlight.MyBillsEntityDataFactory >= this.BuiltInFictitiousFunctionClassFactory.size()) {
            return null;
        }
        return this.BuiltInFictitiousFunctionClassFactory.get(highlight.MyBillsEntityDataFactory).getAuthRequestContext(highlight.moveToNextValue, highlight.lookAheadTest);
    }
}
