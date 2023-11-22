package androidx.recyclerview.widget;

import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import androidx.recyclerview.widget.ThreadUtil;
import androidx.recyclerview.widget.TileList;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes6.dex */
public class AsyncListUtil<T> {
    boolean BuiltInFictitiousFunctionClassFactory;
    final Class<T> DatabaseTableConfigUtil;
    final TileList<T> GetContactSyncConfig;
    int KClassImpl$Data$declaredNonStaticMembers$2;
    final DataCallback<T> MyBillsEntityDataFactory;
    int NetworkUserEntityData$$ExternalSyntheticLambda0;
    final int[] NetworkUserEntityData$$ExternalSyntheticLambda1;
    final int[] NetworkUserEntityData$$ExternalSyntheticLambda2;
    int PlaceComponentResult;
    final ThreadUtil.BackgroundCallback<T> getAuthRequestContext;
    final int[] getErrorConfigVersion;
    final int initRecordTimeStamp;
    final ViewCallback isLayoutRequested;
    int lookAheadTest;
    final SparseIntArray moveToNextValue;
    final ThreadUtil.MainThreadCallback<T> scheduleImpl;

    /* loaded from: classes6.dex */
    public static abstract class DataCallback<T> {
        public abstract int MyBillsEntityDataFactory();
    }

    /* renamed from: androidx.recyclerview.widget.AsyncListUtil$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    class AnonymousClass1 implements ThreadUtil.MainThreadCallback<T> {
        final /* synthetic */ AsyncListUtil PlaceComponentResult;

        @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
        public final void MyBillsEntityDataFactory(int i, int i2) {
            int i3;
            if (MyBillsEntityDataFactory(i)) {
                this.PlaceComponentResult.PlaceComponentResult = i2;
                ViewCallback viewCallback = this.PlaceComponentResult.isLayoutRequested;
                AsyncListUtil asyncListUtil = this.PlaceComponentResult;
                asyncListUtil.KClassImpl$Data$declaredNonStaticMembers$2 = asyncListUtil.NetworkUserEntityData$$ExternalSyntheticLambda0;
                int i4 = 0;
                while (i4 < this.PlaceComponentResult.GetContactSyncConfig.getAuthRequestContext.size()) {
                    ThreadUtil.BackgroundCallback<T> backgroundCallback = this.PlaceComponentResult.getAuthRequestContext;
                    TileList<T> tileList = this.PlaceComponentResult.GetContactSyncConfig;
                    backgroundCallback.PlaceComponentResult((i4 < 0 || i4 >= tileList.getAuthRequestContext.size()) ? null : tileList.getAuthRequestContext.valueAt(i4));
                    i4++;
                }
                this.PlaceComponentResult.GetContactSyncConfig.getAuthRequestContext.clear();
                this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory = false;
                AsyncListUtil asyncListUtil2 = this.PlaceComponentResult;
                ViewCallback viewCallback2 = asyncListUtil2.isLayoutRequested;
                int[] iArr = asyncListUtil2.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int[] iArr2 = asyncListUtil2.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i5 = iArr2[0];
                int i6 = iArr2[1];
                if (i5 > i6 || i5 < 0 || i6 >= asyncListUtil2.PlaceComponentResult) {
                    return;
                }
                if (asyncListUtil2.BuiltInFictitiousFunctionClassFactory) {
                    int[] iArr3 = asyncListUtil2.getErrorConfigVersion;
                    if (i5 <= iArr3[1] && (i3 = iArr3[0]) <= i6) {
                        if (i5 < i3) {
                            asyncListUtil2.lookAheadTest = 1;
                        } else if (i5 > i3) {
                            asyncListUtil2.lookAheadTest = 2;
                        }
                        int[] iArr4 = asyncListUtil2.getErrorConfigVersion;
                        iArr4[0] = i5;
                        iArr4[1] = i6;
                        ViewCallback viewCallback3 = asyncListUtil2.isLayoutRequested;
                        ViewCallback.MyBillsEntityDataFactory(iArr2, asyncListUtil2.NetworkUserEntityData$$ExternalSyntheticLambda2, asyncListUtil2.lookAheadTest);
                        int[] iArr5 = asyncListUtil2.NetworkUserEntityData$$ExternalSyntheticLambda2;
                        iArr5[0] = Math.min(asyncListUtil2.NetworkUserEntityData$$ExternalSyntheticLambda1[0], Math.max(iArr5[0], 0));
                        int[] iArr6 = asyncListUtil2.NetworkUserEntityData$$ExternalSyntheticLambda2;
                        iArr6[1] = Math.max(asyncListUtil2.NetworkUserEntityData$$ExternalSyntheticLambda1[1], Math.min(iArr6[1], asyncListUtil2.PlaceComponentResult - 1));
                        ThreadUtil.BackgroundCallback<T> backgroundCallback2 = asyncListUtil2.getAuthRequestContext;
                        int[] iArr7 = asyncListUtil2.NetworkUserEntityData$$ExternalSyntheticLambda1;
                        int i7 = iArr7[0];
                        int i8 = iArr7[1];
                        int[] iArr8 = asyncListUtil2.NetworkUserEntityData$$ExternalSyntheticLambda2;
                        backgroundCallback2.MyBillsEntityDataFactory(i7, i8, iArr8[0], iArr8[1], asyncListUtil2.lookAheadTest);
                    }
                }
                asyncListUtil2.lookAheadTest = 0;
                int[] iArr42 = asyncListUtil2.getErrorConfigVersion;
                iArr42[0] = i5;
                iArr42[1] = i6;
                ViewCallback viewCallback32 = asyncListUtil2.isLayoutRequested;
                ViewCallback.MyBillsEntityDataFactory(iArr2, asyncListUtil2.NetworkUserEntityData$$ExternalSyntheticLambda2, asyncListUtil2.lookAheadTest);
                int[] iArr52 = asyncListUtil2.NetworkUserEntityData$$ExternalSyntheticLambda2;
                iArr52[0] = Math.min(asyncListUtil2.NetworkUserEntityData$$ExternalSyntheticLambda1[0], Math.max(iArr52[0], 0));
                int[] iArr62 = asyncListUtil2.NetworkUserEntityData$$ExternalSyntheticLambda2;
                iArr62[1] = Math.max(asyncListUtil2.NetworkUserEntityData$$ExternalSyntheticLambda1[1], Math.min(iArr62[1], asyncListUtil2.PlaceComponentResult - 1));
                ThreadUtil.BackgroundCallback<T> backgroundCallback22 = asyncListUtil2.getAuthRequestContext;
                int[] iArr72 = asyncListUtil2.NetworkUserEntityData$$ExternalSyntheticLambda1;
                int i72 = iArr72[0];
                int i82 = iArr72[1];
                int[] iArr82 = asyncListUtil2.NetworkUserEntityData$$ExternalSyntheticLambda2;
                backgroundCallback22.MyBillsEntityDataFactory(i72, i82, iArr82[0], iArr82[1], asyncListUtil2.lookAheadTest);
            }
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
        public final void getAuthRequestContext(int i, TileList.Tile<T> tile) {
            TileList.Tile<T> tile2;
            if (!MyBillsEntityDataFactory(i)) {
                this.PlaceComponentResult.getAuthRequestContext.PlaceComponentResult(tile);
                return;
            }
            TileList<T> tileList = this.PlaceComponentResult.GetContactSyncConfig;
            int indexOfKey = tileList.getAuthRequestContext.indexOfKey(tile.PlaceComponentResult);
            if (indexOfKey < 0) {
                tileList.getAuthRequestContext.put(tile.PlaceComponentResult, tile);
                tile2 = null;
            } else {
                TileList.Tile<T> valueAt = tileList.getAuthRequestContext.valueAt(indexOfKey);
                tileList.getAuthRequestContext.setValueAt(indexOfKey, tile);
                if (tileList.KClassImpl$Data$declaredNonStaticMembers$2 == valueAt) {
                    tileList.KClassImpl$Data$declaredNonStaticMembers$2 = tile;
                }
                tile2 = valueAt;
            }
            if (tile2 != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("duplicate tile @");
                sb.append(tile2.PlaceComponentResult);
                InstrumentInjector.log_e("AsyncListUtil", sb.toString());
                this.PlaceComponentResult.getAuthRequestContext.PlaceComponentResult(tile2);
            }
            int i2 = tile.PlaceComponentResult;
            int i3 = tile.MyBillsEntityDataFactory;
            int i4 = 0;
            while (i4 < this.PlaceComponentResult.moveToNextValue.size()) {
                int keyAt = this.PlaceComponentResult.moveToNextValue.keyAt(i4);
                if (tile.PlaceComponentResult > keyAt || keyAt >= i2 + i3) {
                    i4++;
                } else {
                    this.PlaceComponentResult.moveToNextValue.removeAt(i4);
                    ViewCallback viewCallback = this.PlaceComponentResult.isLayoutRequested;
                }
            }
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
        public final void getAuthRequestContext(int i, int i2) {
            if (MyBillsEntityDataFactory(i)) {
                TileList<T> tileList = this.PlaceComponentResult.GetContactSyncConfig;
                TileList.Tile<T> tile = tileList.getAuthRequestContext.get(i2);
                if (tileList.KClassImpl$Data$declaredNonStaticMembers$2 == tile) {
                    tileList.KClassImpl$Data$declaredNonStaticMembers$2 = null;
                }
                tileList.getAuthRequestContext.delete(i2);
                if (tile == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("tile not found @");
                    sb.append(i2);
                    InstrumentInjector.log_e("AsyncListUtil", sb.toString());
                    return;
                }
                this.PlaceComponentResult.getAuthRequestContext.PlaceComponentResult(tile);
            }
        }

        private boolean MyBillsEntityDataFactory(int i) {
            return i == this.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda0;
        }
    }

    /* renamed from: androidx.recyclerview.widget.AsyncListUtil$2  reason: invalid class name */
    /* loaded from: classes6.dex */
    class AnonymousClass2 implements ThreadUtil.BackgroundCallback<T> {
        private int BuiltInFictitiousFunctionClassFactory;
        private int KClassImpl$Data$declaredNonStaticMembers$2;
        final SparseBooleanArray MyBillsEntityDataFactory;
        private int PlaceComponentResult;
        final /* synthetic */ AsyncListUtil getAuthRequestContext;
        private int moveToNextValue;
        private TileList.Tile<T> scheduleImpl;

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public final void getAuthRequestContext(int i) {
            this.PlaceComponentResult = i;
            this.MyBillsEntityDataFactory.clear();
            this.BuiltInFictitiousFunctionClassFactory = this.getAuthRequestContext.MyBillsEntityDataFactory.MyBillsEntityDataFactory();
            this.getAuthRequestContext.scheduleImpl.MyBillsEntityDataFactory(this.PlaceComponentResult, this.BuiltInFictitiousFunctionClassFactory);
        }

        private void BuiltInFictitiousFunctionClassFactory(int i, int i2, int i3, boolean z) {
            int i4 = i;
            while (i4 <= i2) {
                this.getAuthRequestContext.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(z ? (i2 + i) - i4 : i4, i3);
                i4 += this.getAuthRequestContext.initRecordTimeStamp;
            }
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public final void BuiltInFictitiousFunctionClassFactory(int i, int i2) {
            if (PlaceComponentResult(i)) {
                return;
            }
            TileList.Tile<T> tile = this.scheduleImpl;
            if (tile != null) {
                this.scheduleImpl = tile.getAuthRequestContext;
            } else {
                tile = new TileList.Tile<>(this.getAuthRequestContext.DatabaseTableConfigUtil, this.getAuthRequestContext.initRecordTimeStamp);
            }
            tile.PlaceComponentResult = i;
            tile.MyBillsEntityDataFactory = Math.min(this.getAuthRequestContext.initRecordTimeStamp, this.BuiltInFictitiousFunctionClassFactory - tile.PlaceComponentResult);
            DataCallback<T> dataCallback = this.getAuthRequestContext.MyBillsEntityDataFactory;
            T[] tArr = tile.KClassImpl$Data$declaredNonStaticMembers$2;
            int i3 = tile.PlaceComponentResult;
            int i4 = tile.MyBillsEntityDataFactory;
            DataCallback<T> dataCallback2 = this.getAuthRequestContext.MyBillsEntityDataFactory;
            while (this.MyBillsEntityDataFactory.size() >= 10) {
                int keyAt = this.MyBillsEntityDataFactory.keyAt(0);
                SparseBooleanArray sparseBooleanArray = this.MyBillsEntityDataFactory;
                int keyAt2 = sparseBooleanArray.keyAt(sparseBooleanArray.size() - 1);
                int i5 = this.KClassImpl$Data$declaredNonStaticMembers$2 - keyAt;
                int i6 = keyAt2 - this.moveToNextValue;
                if (i5 > 0 && (i5 >= i6 || i2 == 2)) {
                    this.MyBillsEntityDataFactory.delete(keyAt);
                    this.getAuthRequestContext.scheduleImpl.getAuthRequestContext(this.PlaceComponentResult, keyAt);
                } else if (i6 <= 0 || (i5 >= i6 && i2 != 1)) {
                    break;
                } else {
                    this.MyBillsEntityDataFactory.delete(keyAt2);
                    this.getAuthRequestContext.scheduleImpl.getAuthRequestContext(this.PlaceComponentResult, keyAt2);
                }
            }
            this.MyBillsEntityDataFactory.put(tile.PlaceComponentResult, true);
            this.getAuthRequestContext.scheduleImpl.getAuthRequestContext(this.PlaceComponentResult, tile);
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public final void PlaceComponentResult(TileList.Tile<T> tile) {
            DataCallback<T> dataCallback = this.getAuthRequestContext.MyBillsEntityDataFactory;
            T[] tArr = tile.KClassImpl$Data$declaredNonStaticMembers$2;
            int i = tile.MyBillsEntityDataFactory;
            tile.getAuthRequestContext = this.scheduleImpl;
            this.scheduleImpl = tile;
        }

        private boolean PlaceComponentResult(int i) {
            return this.MyBillsEntityDataFactory.get(i);
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public final void MyBillsEntityDataFactory(int i, int i2, int i3, int i4, int i5) {
            if (i > i2) {
                return;
            }
            int i6 = i - (i % this.getAuthRequestContext.initRecordTimeStamp);
            int i7 = i2 - (i2 % this.getAuthRequestContext.initRecordTimeStamp);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i3 - (i3 % this.getAuthRequestContext.initRecordTimeStamp);
            int i8 = i4 - (i4 % this.getAuthRequestContext.initRecordTimeStamp);
            this.moveToNextValue = i8;
            if (i5 == 1) {
                BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2, i7, i5, true);
                BuiltInFictitiousFunctionClassFactory(i7 + this.getAuthRequestContext.initRecordTimeStamp, this.moveToNextValue, i5, false);
                return;
            }
            BuiltInFictitiousFunctionClassFactory(i6, i8, i5, false);
            BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2, i6 - this.getAuthRequestContext.initRecordTimeStamp, i5, true);
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class ViewCallback {
        public static void MyBillsEntityDataFactory(int[] iArr, int[] iArr2, int i) {
            int i2 = iArr[1];
            int i3 = iArr[0];
            int i4 = (i2 - i3) + 1;
            int i5 = i4 / 2;
            iArr2[0] = i3 - (i == 1 ? i4 : i5);
            if (i != 2) {
                i4 = i5;
            }
            iArr2[1] = i2 + i4;
        }
    }
}
