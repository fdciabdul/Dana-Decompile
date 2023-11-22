package androidx.recyclerview.widget;

import androidx.collection.LongSparseArray;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Pools;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ViewInfoStore {
    final SimpleArrayMap<RecyclerView.ViewHolder, InfoRecord> KClassImpl$Data$declaredNonStaticMembers$2 = new SimpleArrayMap<>();
    final LongSparseArray<RecyclerView.ViewHolder> getAuthRequestContext = new LongSparseArray<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface ProcessCallback {
        void BuiltInFictitiousFunctionClassFactory(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2);

        void MyBillsEntityDataFactory(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2);

        void PlaceComponentResult(RecyclerView.ViewHolder viewHolder);

        void PlaceComponentResult(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void BuiltInFictitiousFunctionClassFactory(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo) {
        InfoRecord infoRecord = this.KClassImpl$Data$declaredNonStaticMembers$2.get(viewHolder);
        if (infoRecord == null) {
            infoRecord = InfoRecord.getAuthRequestContext();
            this.KClassImpl$Data$declaredNonStaticMembers$2.put(viewHolder, infoRecord);
        }
        infoRecord.getAuthRequestContext = itemHolderInfo;
        infoRecord.MyBillsEntityDataFactory |= 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean getAuthRequestContext(RecyclerView.ViewHolder viewHolder) {
        InfoRecord infoRecord = this.KClassImpl$Data$declaredNonStaticMembers$2.get(viewHolder);
        return (infoRecord == null || (infoRecord.MyBillsEntityDataFactory & 1) == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final RecyclerView.ItemAnimator.ItemHolderInfo getAuthRequestContext(RecyclerView.ViewHolder viewHolder, int i) {
        InfoRecord infoRecord;
        RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo;
        SimpleArrayMap<RecyclerView.ViewHolder, InfoRecord> simpleArrayMap = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int PlaceComponentResult = viewHolder == null ? simpleArrayMap.PlaceComponentResult() : simpleArrayMap.KClassImpl$Data$declaredNonStaticMembers$2(viewHolder, viewHolder.hashCode());
        if (PlaceComponentResult < 0 || (infoRecord = (InfoRecord) this.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue[(PlaceComponentResult << 1) + 1]) == null || (infoRecord.MyBillsEntityDataFactory & i) == 0) {
            return null;
        }
        infoRecord.MyBillsEntityDataFactory &= i ^ (-1);
        if (i == 4) {
            itemHolderInfo = infoRecord.getAuthRequestContext;
        } else if (i == 8) {
            itemHolderInfo = infoRecord.KClassImpl$Data$declaredNonStaticMembers$2;
        } else {
            throw new IllegalArgumentException("Must provide flag PRE or POST");
        }
        if ((infoRecord.MyBillsEntityDataFactory & 12) == 0) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(PlaceComponentResult);
            InfoRecord.MyBillsEntityDataFactory(infoRecord);
        }
        return itemHolderInfo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean PlaceComponentResult(RecyclerView.ViewHolder viewHolder) {
        InfoRecord infoRecord = this.KClassImpl$Data$declaredNonStaticMembers$2.get(viewHolder);
        return (infoRecord == null || (infoRecord.MyBillsEntityDataFactory & 4) == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void getAuthRequestContext(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo) {
        InfoRecord infoRecord = this.KClassImpl$Data$declaredNonStaticMembers$2.get(viewHolder);
        if (infoRecord == null) {
            infoRecord = InfoRecord.getAuthRequestContext();
            this.KClassImpl$Data$declaredNonStaticMembers$2.put(viewHolder, infoRecord);
        }
        infoRecord.KClassImpl$Data$declaredNonStaticMembers$2 = itemHolderInfo;
        infoRecord.MyBillsEntityDataFactory |= 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void KClassImpl$Data$declaredNonStaticMembers$2(RecyclerView.ViewHolder viewHolder) {
        InfoRecord infoRecord = this.KClassImpl$Data$declaredNonStaticMembers$2.get(viewHolder);
        if (infoRecord == null) {
            infoRecord = InfoRecord.getAuthRequestContext();
            this.KClassImpl$Data$declaredNonStaticMembers$2.put(viewHolder, infoRecord);
        }
        infoRecord.MyBillsEntityDataFactory |= 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void MyBillsEntityDataFactory(RecyclerView.ViewHolder viewHolder) {
        LongSparseArray<RecyclerView.ViewHolder> longSparseArray = this.getAuthRequestContext;
        if (longSparseArray.MyBillsEntityDataFactory) {
            longSparseArray.BuiltInFictitiousFunctionClassFactory();
        }
        int i = longSparseArray.KClassImpl$Data$declaredNonStaticMembers$2 - 1;
        while (true) {
            if (i < 0) {
                break;
            }
            LongSparseArray<RecyclerView.ViewHolder> longSparseArray2 = this.getAuthRequestContext;
            if (longSparseArray2.MyBillsEntityDataFactory) {
                longSparseArray2.BuiltInFictitiousFunctionClassFactory();
            }
            if (viewHolder == longSparseArray2.BuiltInFictitiousFunctionClassFactory[i]) {
                LongSparseArray<RecyclerView.ViewHolder> longSparseArray3 = this.getAuthRequestContext;
                Object[] objArr = longSparseArray3.BuiltInFictitiousFunctionClassFactory;
                Object obj = objArr[i];
                Object obj2 = LongSparseArray.getAuthRequestContext;
                if (obj != obj2) {
                    objArr[i] = obj2;
                    longSparseArray3.MyBillsEntityDataFactory = true;
                }
            } else {
                i--;
            }
        }
        InfoRecord remove = this.KClassImpl$Data$declaredNonStaticMembers$2.remove(viewHolder);
        if (remove != null) {
            InfoRecord.MyBillsEntityDataFactory(remove);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void getAuthRequestContext() {
        InfoRecord.BuiltInFictitiousFunctionClassFactory();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class InfoRecord {
        static Pools.Pool<InfoRecord> BuiltInFictitiousFunctionClassFactory = new Pools.SimplePool(20);
        RecyclerView.ItemAnimator.ItemHolderInfo KClassImpl$Data$declaredNonStaticMembers$2;
        int MyBillsEntityDataFactory;
        RecyclerView.ItemAnimator.ItemHolderInfo getAuthRequestContext;

        private InfoRecord() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static InfoRecord getAuthRequestContext() {
            InfoRecord BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory();
            return BuiltInFictitiousFunctionClassFactory2 == null ? new InfoRecord() : BuiltInFictitiousFunctionClassFactory2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static void MyBillsEntityDataFactory(InfoRecord infoRecord) {
            infoRecord.MyBillsEntityDataFactory = 0;
            infoRecord.getAuthRequestContext = null;
            infoRecord.KClassImpl$Data$declaredNonStaticMembers$2 = null;
            BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(infoRecord);
        }

        static void BuiltInFictitiousFunctionClassFactory() {
            do {
            } while (BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory() != null);
        }
    }
}
