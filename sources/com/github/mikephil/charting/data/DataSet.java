package com.github.mikephil.charting.data;

import com.github.mikephil.charting.data.Entry;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class DataSet<T extends Entry> extends BaseDataSet<T> {
    protected float FragmentBottomSheetPaymentSettingBinding;
    protected float NetworkUserEntityData$$ExternalSyntheticLambda3;
    protected float NetworkUserEntityData$$ExternalSyntheticLambda4;
    protected List<T> NetworkUserEntityData$$ExternalSyntheticLambda5;
    protected float NetworkUserEntityData$$ExternalSyntheticLambda6;

    /* loaded from: classes3.dex */
    public enum Rounding {
        UP,
        DOWN,
        CLOSEST
    }

    public DataSet(List<T> list, String str) {
        super(str);
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = -3.4028235E38f;
        this.FragmentBottomSheetPaymentSettingBinding = Float.MAX_VALUE;
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = -3.4028235E38f;
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = Float.MAX_VALUE;
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = list;
        if (list == null) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = new ArrayList();
        }
        List<T> list2 = this.NetworkUserEntityData$$ExternalSyntheticLambda5;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = -3.4028235E38f;
        this.FragmentBottomSheetPaymentSettingBinding = Float.MAX_VALUE;
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = -3.4028235E38f;
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = Float.MAX_VALUE;
        Iterator<T> it = this.NetworkUserEntityData$$ExternalSyntheticLambda5.iterator();
        while (it.hasNext()) {
            PlaceComponentResult((DataSet<T>) it.next());
        }
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public final void KClassImpl$Data$declaredNonStaticMembers$2(float f, float f2) {
        List<T> list = this.NetworkUserEntityData$$ExternalSyntheticLambda5;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = -3.4028235E38f;
        this.FragmentBottomSheetPaymentSettingBinding = Float.MAX_VALUE;
        int MyBillsEntityDataFactory = MyBillsEntityDataFactory(f2, Float.NaN, Rounding.UP);
        for (int MyBillsEntityDataFactory2 = MyBillsEntityDataFactory(f, Float.NaN, Rounding.DOWN); MyBillsEntityDataFactory2 <= MyBillsEntityDataFactory; MyBillsEntityDataFactory2++) {
            KClassImpl$Data$declaredNonStaticMembers$2((DataSet<T>) this.NetworkUserEntityData$$ExternalSyntheticLambda5.get(MyBillsEntityDataFactory2));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void PlaceComponentResult(T t) {
        if (t == null) {
            return;
        }
        BuiltInFictitiousFunctionClassFactory((DataSet<T>) t);
        KClassImpl$Data$declaredNonStaticMembers$2((DataSet<T>) t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void BuiltInFictitiousFunctionClassFactory(T t) {
        if (t.MyBillsEntityDataFactory() < this.NetworkUserEntityData$$ExternalSyntheticLambda4) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = t.MyBillsEntityDataFactory();
        }
        if (t.MyBillsEntityDataFactory() > this.NetworkUserEntityData$$ExternalSyntheticLambda3) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = t.MyBillsEntityDataFactory();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void KClassImpl$Data$declaredNonStaticMembers$2(T t) {
        if (t.getAuthRequestContext() < this.FragmentBottomSheetPaymentSettingBinding) {
            this.FragmentBottomSheetPaymentSettingBinding = t.getAuthRequestContext();
        }
        if (t.getAuthRequestContext() > this.NetworkUserEntityData$$ExternalSyntheticLambda6) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = t.getAuthRequestContext();
        }
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public final int BottomSheetCardBindingView$watcherCardNumberView$1() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda5.size();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        StringBuilder sb = new StringBuilder();
        sb.append("DataSet, label: ");
        sb.append(newProxyInstance() == null ? "" : newProxyInstance());
        sb.append(", entries: ");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda5.size());
        sb.append("\n");
        stringBuffer2.append(sb.toString());
        stringBuffer.append(stringBuffer2.toString());
        for (int i = 0; i < this.NetworkUserEntityData$$ExternalSyntheticLambda5.size(); i++) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.NetworkUserEntityData$$ExternalSyntheticLambda5.get(i).toString());
            sb2.append(" ");
            stringBuffer.append(sb2.toString());
        }
        return stringBuffer.toString();
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public final float D() {
        return this.FragmentBottomSheetPaymentSettingBinding;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public final float getOnBoardingScenario() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda6;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public final float C() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda4;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public final float VerifyPinStateManager$executeRiskChallenge$2$1() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda3;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public final int MyBillsEntityDataFactory(Entry entry) {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda5.indexOf(entry);
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public final T BuiltInFictitiousFunctionClassFactory(float f, Rounding rounding) {
        int MyBillsEntityDataFactory = MyBillsEntityDataFactory(f, Float.NaN, rounding);
        if (MyBillsEntityDataFactory >= 0) {
            return this.NetworkUserEntityData$$ExternalSyntheticLambda5.get(MyBillsEntityDataFactory);
        }
        return null;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public final T getAuthRequestContext(float f, float f2) {
        int MyBillsEntityDataFactory = MyBillsEntityDataFactory(f, f2, Rounding.CLOSEST);
        if (MyBillsEntityDataFactory >= 0) {
            return this.NetworkUserEntityData$$ExternalSyntheticLambda5.get(MyBillsEntityDataFactory);
        }
        return null;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public final T getErrorConfigVersion(int i) {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda5.get(i);
    }

    private int MyBillsEntityDataFactory(float f, float f2, Rounding rounding) {
        T t;
        List<T> list = this.NetworkUserEntityData$$ExternalSyntheticLambda5;
        if (list == null || list.isEmpty()) {
            return -1;
        }
        int i = 0;
        int size = this.NetworkUserEntityData$$ExternalSyntheticLambda5.size() - 1;
        while (i < size) {
            int i2 = (i + size) / 2;
            float MyBillsEntityDataFactory = this.NetworkUserEntityData$$ExternalSyntheticLambda5.get(i2).MyBillsEntityDataFactory() - f;
            int i3 = i2 + 1;
            float MyBillsEntityDataFactory2 = this.NetworkUserEntityData$$ExternalSyntheticLambda5.get(i3).MyBillsEntityDataFactory();
            float abs = Math.abs(MyBillsEntityDataFactory);
            float abs2 = Math.abs(MyBillsEntityDataFactory2 - f);
            if (abs2 >= abs) {
                if (abs >= abs2) {
                    double d = MyBillsEntityDataFactory;
                    if (d < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                        if (d < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                        }
                    }
                }
                size = i2;
            }
            i = i3;
        }
        if (size != -1) {
            float MyBillsEntityDataFactory3 = this.NetworkUserEntityData$$ExternalSyntheticLambda5.get(size).MyBillsEntityDataFactory();
            if (rounding == Rounding.UP) {
                if (MyBillsEntityDataFactory3 < f && size < this.NetworkUserEntityData$$ExternalSyntheticLambda5.size() - 1) {
                    size++;
                }
            } else if (rounding == Rounding.DOWN && MyBillsEntityDataFactory3 > f && size > 0) {
                size--;
            }
            if (!Float.isNaN(f2)) {
                while (size > 0 && this.NetworkUserEntityData$$ExternalSyntheticLambda5.get(size - 1).MyBillsEntityDataFactory() == MyBillsEntityDataFactory3) {
                    size--;
                }
                float authRequestContext = this.NetworkUserEntityData$$ExternalSyntheticLambda5.get(size).getAuthRequestContext();
                loop2: while (true) {
                    int i4 = size;
                    do {
                        i4++;
                        if (i4 >= this.NetworkUserEntityData$$ExternalSyntheticLambda5.size()) {
                            break loop2;
                        }
                        t = this.NetworkUserEntityData$$ExternalSyntheticLambda5.get(i4);
                        if (t.MyBillsEntityDataFactory() != MyBillsEntityDataFactory3) {
                            break loop2;
                        }
                    } while (Math.abs(t.getAuthRequestContext() - f2) >= Math.abs(authRequestContext - f2));
                    authRequestContext = f2;
                    size = i4;
                }
            }
        }
        return size;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public final List<T> MyBillsEntityDataFactory(float f) {
        ArrayList arrayList = new ArrayList();
        int size = this.NetworkUserEntityData$$ExternalSyntheticLambda5.size() - 1;
        int i = 0;
        while (true) {
            if (i > size) {
                break;
            }
            int i2 = (size + i) / 2;
            T t = this.NetworkUserEntityData$$ExternalSyntheticLambda5.get(i2);
            if (f == t.MyBillsEntityDataFactory()) {
                while (i2 > 0 && this.NetworkUserEntityData$$ExternalSyntheticLambda5.get(i2 - 1).MyBillsEntityDataFactory() == f) {
                    i2--;
                }
                int size2 = this.NetworkUserEntityData$$ExternalSyntheticLambda5.size();
                while (i2 < size2) {
                    T t2 = this.NetworkUserEntityData$$ExternalSyntheticLambda5.get(i2);
                    if (t2.MyBillsEntityDataFactory() != f) {
                        break;
                    }
                    arrayList.add(t2);
                    i2++;
                }
            } else if (f > t.MyBillsEntityDataFactory()) {
                i = i2 + 1;
            } else {
                size = i2 - 1;
            }
        }
        return arrayList;
    }
}
