package androidx.recyclerview.widget;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class DiffUtil {
    private static final Comparator<Diagonal> BuiltInFictitiousFunctionClassFactory = new Comparator<Diagonal>() { // from class: androidx.recyclerview.widget.DiffUtil.1
        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Diagonal diagonal, Diagonal diagonal2) {
            return diagonal.PlaceComponentResult - diagonal2.PlaceComponentResult;
        }
    };

    /* loaded from: classes3.dex */
    public static abstract class Callback {
        public abstract boolean KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2);

        public abstract boolean MyBillsEntityDataFactory(int i, int i2);

        public abstract int PlaceComponentResult();

        public Object PlaceComponentResult(int i, int i2) {
            return null;
        }

        public abstract int getAuthRequestContext();
    }

    /* loaded from: classes2.dex */
    public static abstract class ItemCallback<T> {
        public static Object getAuthRequestContext() {
            return null;
        }

        public abstract boolean KClassImpl$Data$declaredNonStaticMembers$2(T t, T t2);

        public abstract boolean getAuthRequestContext(T t, T t2);
    }

    private DiffUtil() {
    }

    public static DiffResult getAuthRequestContext(Callback callback) {
        return BuiltInFictitiousFunctionClassFactory(callback);
    }

    public static DiffResult BuiltInFictitiousFunctionClassFactory(Callback callback) {
        int authRequestContext = callback.getAuthRequestContext();
        int PlaceComponentResult = callback.PlaceComponentResult();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new Range(authRequestContext, PlaceComponentResult));
        int i = ((((authRequestContext + PlaceComponentResult) + 1) / 2) * 2) + 1;
        CenteredArray centeredArray = new CenteredArray(i);
        CenteredArray centeredArray2 = new CenteredArray(i);
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            Range range = (Range) arrayList2.remove(arrayList2.size() - 1);
            Snake PlaceComponentResult2 = PlaceComponentResult(range, callback, centeredArray, centeredArray2);
            if (PlaceComponentResult2 == null) {
                arrayList3.add(range);
            } else {
                if (Math.min(PlaceComponentResult2.MyBillsEntityDataFactory - PlaceComponentResult2.KClassImpl$Data$declaredNonStaticMembers$2, PlaceComponentResult2.PlaceComponentResult - PlaceComponentResult2.getAuthRequestContext) > 0) {
                    arrayList.add(PlaceComponentResult2.MyBillsEntityDataFactory());
                }
                Range range2 = arrayList3.isEmpty() ? new Range() : (Range) arrayList3.remove(arrayList3.size() - 1);
                range2.KClassImpl$Data$declaredNonStaticMembers$2 = range.KClassImpl$Data$declaredNonStaticMembers$2;
                range2.PlaceComponentResult = range.PlaceComponentResult;
                range2.getAuthRequestContext = PlaceComponentResult2.KClassImpl$Data$declaredNonStaticMembers$2;
                range2.MyBillsEntityDataFactory = PlaceComponentResult2.getAuthRequestContext;
                arrayList2.add(range2);
                range.getAuthRequestContext = range.getAuthRequestContext;
                range.MyBillsEntityDataFactory = range.MyBillsEntityDataFactory;
                range.KClassImpl$Data$declaredNonStaticMembers$2 = PlaceComponentResult2.MyBillsEntityDataFactory;
                range.PlaceComponentResult = PlaceComponentResult2.PlaceComponentResult;
                arrayList2.add(range);
            }
        }
        Collections.sort(arrayList, BuiltInFictitiousFunctionClassFactory);
        return new DiffResult(callback, arrayList, centeredArray.BuiltInFictitiousFunctionClassFactory, centeredArray2.BuiltInFictitiousFunctionClassFactory);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class Diagonal {
        public final int BuiltInFictitiousFunctionClassFactory;
        public final int PlaceComponentResult;
        public final int getAuthRequestContext;

        Diagonal(int i, int i2, int i3) {
            this.PlaceComponentResult = i;
            this.getAuthRequestContext = i2;
            this.BuiltInFictitiousFunctionClassFactory = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class Snake {
        public boolean BuiltInFictitiousFunctionClassFactory;
        public int KClassImpl$Data$declaredNonStaticMembers$2;
        public int MyBillsEntityDataFactory;
        public int PlaceComponentResult;
        public int getAuthRequestContext;

        Snake() {
        }

        private boolean PlaceComponentResult() {
            return this.PlaceComponentResult - this.getAuthRequestContext != this.MyBillsEntityDataFactory - this.KClassImpl$Data$declaredNonStaticMembers$2;
        }

        private boolean BuiltInFictitiousFunctionClassFactory() {
            return this.PlaceComponentResult - this.getAuthRequestContext > this.MyBillsEntityDataFactory - this.KClassImpl$Data$declaredNonStaticMembers$2;
        }

        final Diagonal MyBillsEntityDataFactory() {
            if (PlaceComponentResult()) {
                if (this.BuiltInFictitiousFunctionClassFactory) {
                    int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
                    int i2 = this.getAuthRequestContext;
                    return new Diagonal(i, i2, Math.min(this.MyBillsEntityDataFactory - i, this.PlaceComponentResult - i2));
                } else if (BuiltInFictitiousFunctionClassFactory()) {
                    int i3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                    int i4 = this.getAuthRequestContext;
                    return new Diagonal(i3, i4 + 1, Math.min(this.MyBillsEntityDataFactory - i3, this.PlaceComponentResult - i4));
                } else {
                    int i5 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                    int i6 = this.getAuthRequestContext;
                    return new Diagonal(i5 + 1, i6, Math.min(this.MyBillsEntityDataFactory - i5, this.PlaceComponentResult - i6));
                }
            }
            int i7 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            return new Diagonal(i7, this.getAuthRequestContext, this.MyBillsEntityDataFactory - i7);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class Range {
        int KClassImpl$Data$declaredNonStaticMembers$2;
        int MyBillsEntityDataFactory;
        int PlaceComponentResult;
        int getAuthRequestContext;

        public Range() {
        }

        public Range(int i, int i2) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
            this.getAuthRequestContext = i;
            this.PlaceComponentResult = 0;
            this.MyBillsEntityDataFactory = i2;
        }
    }

    /* loaded from: classes3.dex */
    public static class DiffResult {
        private final int[] BuiltInFictitiousFunctionClassFactory;
        private final Callback KClassImpl$Data$declaredNonStaticMembers$2;
        private final boolean MyBillsEntityDataFactory;
        private final int PlaceComponentResult;
        private final List<Diagonal> getAuthRequestContext;
        private final int[] lookAheadTest;
        private final int scheduleImpl;

        DiffResult(Callback callback, List<Diagonal> list, int[] iArr, int[] iArr2) {
            this.getAuthRequestContext = list;
            this.lookAheadTest = iArr;
            this.BuiltInFictitiousFunctionClassFactory = iArr2;
            Arrays.fill(iArr, 0);
            Arrays.fill(iArr2, 0);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = callback;
            this.scheduleImpl = callback.getAuthRequestContext();
            this.PlaceComponentResult = callback.PlaceComponentResult();
            this.MyBillsEntityDataFactory = true;
            Diagonal diagonal = this.getAuthRequestContext.isEmpty() ? null : this.getAuthRequestContext.get(0);
            if (diagonal == null || diagonal.PlaceComponentResult != 0 || diagonal.getAuthRequestContext != 0) {
                this.getAuthRequestContext.add(0, new Diagonal(0, 0, 0));
            }
            this.getAuthRequestContext.add(new Diagonal(this.scheduleImpl, this.PlaceComponentResult, 0));
            for (Diagonal diagonal2 : this.getAuthRequestContext) {
                for (int i = 0; i < diagonal2.BuiltInFictitiousFunctionClassFactory; i++) {
                    int i2 = diagonal2.PlaceComponentResult + i;
                    int i3 = diagonal2.getAuthRequestContext + i;
                    int i4 = this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(i2, i3) ? 1 : 2;
                    this.lookAheadTest[i2] = (i3 << 4) | i4;
                    this.BuiltInFictitiousFunctionClassFactory[i3] = (i2 << 4) | i4;
                }
            }
            if (this.MyBillsEntityDataFactory) {
                int i5 = 0;
                for (Diagonal diagonal3 : this.getAuthRequestContext) {
                    while (i5 < diagonal3.PlaceComponentResult) {
                        if (this.lookAheadTest[i5] == 0) {
                            int size = this.getAuthRequestContext.size();
                            int i6 = 0;
                            int i7 = 0;
                            while (true) {
                                if (i6 < size) {
                                    Diagonal diagonal4 = this.getAuthRequestContext.get(i6);
                                    while (i7 < diagonal4.getAuthRequestContext) {
                                        if (this.BuiltInFictitiousFunctionClassFactory[i7] == 0 && this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(i5, i7)) {
                                            int i8 = this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(i5, i7) ? 8 : 4;
                                            this.lookAheadTest[i5] = (i7 << 4) | i8;
                                            this.BuiltInFictitiousFunctionClassFactory[i7] = i8 | (i5 << 4);
                                        } else {
                                            i7++;
                                        }
                                    }
                                    i7 = diagonal4.getAuthRequestContext + diagonal4.BuiltInFictitiousFunctionClassFactory;
                                    i6++;
                                }
                            }
                        }
                        i5++;
                    }
                    i5 = diagonal3.PlaceComponentResult + diagonal3.BuiltInFictitiousFunctionClassFactory;
                }
            }
        }

        public final int getAuthRequestContext(int i) {
            if (i < 0 || i >= this.scheduleImpl) {
                StringBuilder sb = new StringBuilder();
                sb.append("Index out of bounds - passed position = ");
                sb.append(i);
                sb.append(", old list size = ");
                sb.append(this.scheduleImpl);
                throw new IndexOutOfBoundsException(sb.toString());
            }
            int i2 = this.lookAheadTest[i];
            if ((i2 & 15) == 0) {
                return -1;
            }
            return i2 >> 4;
        }

        public final void MyBillsEntityDataFactory(ListUpdateCallback listUpdateCallback) {
            BatchingListUpdateCallback batchingListUpdateCallback;
            int i;
            if (listUpdateCallback instanceof BatchingListUpdateCallback) {
                batchingListUpdateCallback = (BatchingListUpdateCallback) listUpdateCallback;
            } else {
                batchingListUpdateCallback = new BatchingListUpdateCallback(listUpdateCallback);
            }
            int i2 = this.scheduleImpl;
            ArrayDeque arrayDeque = new ArrayDeque();
            int i3 = this.scheduleImpl;
            int i4 = this.PlaceComponentResult;
            for (int size = this.getAuthRequestContext.size() - 1; size >= 0; size--) {
                Diagonal diagonal = this.getAuthRequestContext.get(size);
                int i5 = diagonal.PlaceComponentResult + diagonal.BuiltInFictitiousFunctionClassFactory;
                int i6 = diagonal.getAuthRequestContext + diagonal.BuiltInFictitiousFunctionClassFactory;
                while (true) {
                    if (i3 <= i5) {
                        break;
                    }
                    i3--;
                    int i7 = this.lookAheadTest[i3];
                    if ((i7 & 12) != 0) {
                        int i8 = i7 >> 4;
                        PostponedUpdate KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(arrayDeque, i8, false);
                        if (KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                            int i9 = (i2 - KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext) - 1;
                            batchingListUpdateCallback.getAuthRequestContext();
                            batchingListUpdateCallback.getAuthRequestContext.getAuthRequestContext(i3, i9);
                            if ((i7 & 4) != 0) {
                                batchingListUpdateCallback.getAuthRequestContext(i9, 1, this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(i3, i8));
                            }
                        } else {
                            arrayDeque.add(new PostponedUpdate(i3, (i2 - i3) - 1, true));
                        }
                    } else {
                        batchingListUpdateCallback.KClassImpl$Data$declaredNonStaticMembers$2(i3, 1);
                        i2--;
                    }
                }
                while (i4 > i6) {
                    i4--;
                    int i10 = this.BuiltInFictitiousFunctionClassFactory[i4];
                    if ((i10 & 12) != 0) {
                        int i11 = i10 >> 4;
                        PostponedUpdate KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2(arrayDeque, i11, true);
                        if (KClassImpl$Data$declaredNonStaticMembers$22 == null) {
                            arrayDeque.add(new PostponedUpdate(i4, i2 - i3, false));
                        } else {
                            int i12 = (i2 - KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext) - 1;
                            batchingListUpdateCallback.getAuthRequestContext();
                            batchingListUpdateCallback.getAuthRequestContext.getAuthRequestContext(i12, i3);
                            if ((i10 & 4) != 0) {
                                batchingListUpdateCallback.getAuthRequestContext(i3, 1, this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(i11, i4));
                            }
                        }
                    } else {
                        batchingListUpdateCallback.PlaceComponentResult(i3, 1);
                        i2++;
                    }
                }
                int i13 = diagonal.PlaceComponentResult;
                int i14 = diagonal.getAuthRequestContext;
                for (i = 0; i < diagonal.BuiltInFictitiousFunctionClassFactory; i++) {
                    if ((this.lookAheadTest[i13] & 15) == 2) {
                        batchingListUpdateCallback.getAuthRequestContext(i13, 1, this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(i13, i14));
                    }
                    i13++;
                    i14++;
                }
                i3 = diagonal.PlaceComponentResult;
                i4 = diagonal.getAuthRequestContext;
            }
            batchingListUpdateCallback.getAuthRequestContext();
        }

        private static PostponedUpdate KClassImpl$Data$declaredNonStaticMembers$2(Collection<PostponedUpdate> collection, int i, boolean z) {
            PostponedUpdate postponedUpdate;
            Iterator<PostponedUpdate> it = collection.iterator();
            while (true) {
                if (!it.hasNext()) {
                    postponedUpdate = null;
                    break;
                }
                postponedUpdate = it.next();
                if (postponedUpdate.PlaceComponentResult == i && postponedUpdate.BuiltInFictitiousFunctionClassFactory == z) {
                    it.remove();
                    break;
                }
            }
            while (it.hasNext()) {
                PostponedUpdate next = it.next();
                if (z) {
                    next.getAuthRequestContext--;
                } else {
                    next.getAuthRequestContext++;
                }
            }
            return postponedUpdate;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class PostponedUpdate {
        boolean BuiltInFictitiousFunctionClassFactory;
        int PlaceComponentResult;
        int getAuthRequestContext;

        PostponedUpdate(int i, int i2, boolean z) {
            this.PlaceComponentResult = i;
            this.getAuthRequestContext = i2;
            this.BuiltInFictitiousFunctionClassFactory = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class CenteredArray {
        final int[] BuiltInFictitiousFunctionClassFactory;
        final int MyBillsEntityDataFactory;

        CenteredArray(int i) {
            this.BuiltInFictitiousFunctionClassFactory = new int[i];
            this.MyBillsEntityDataFactory = i / 2;
        }
    }

    private static Snake getAuthRequestContext(Range range, Callback callback, CenteredArray centeredArray, CenteredArray centeredArray2, int i) {
        int i2;
        int i3;
        int i4;
        Range range2 = range;
        boolean z = ((range2.getAuthRequestContext - range2.KClassImpl$Data$declaredNonStaticMembers$2) - (range2.MyBillsEntityDataFactory - range2.PlaceComponentResult)) % 2 == 0;
        int i5 = range2.getAuthRequestContext - range2.KClassImpl$Data$declaredNonStaticMembers$2;
        int i6 = range2.MyBillsEntityDataFactory - range2.PlaceComponentResult;
        int i7 = -i;
        int i8 = i7;
        while (i8 <= i) {
            if (i8 != i7 && (i8 == i || centeredArray2.BuiltInFictitiousFunctionClassFactory[i8 + 1 + centeredArray2.MyBillsEntityDataFactory] >= centeredArray2.BuiltInFictitiousFunctionClassFactory[(i8 - 1) + centeredArray2.MyBillsEntityDataFactory])) {
                i2 = centeredArray2.BuiltInFictitiousFunctionClassFactory[(i8 - 1) + centeredArray2.MyBillsEntityDataFactory];
                i3 = i2 - 1;
            } else {
                i2 = centeredArray2.BuiltInFictitiousFunctionClassFactory[i8 + 1 + centeredArray2.MyBillsEntityDataFactory];
                i3 = i2;
            }
            int i9 = range2.MyBillsEntityDataFactory - ((range2.getAuthRequestContext - i3) - i8);
            int i10 = (i == 0 || i3 != i2) ? i9 : i9 + 1;
            while (i3 > range2.KClassImpl$Data$declaredNonStaticMembers$2 && i9 > range2.PlaceComponentResult) {
                if (!callback.KClassImpl$Data$declaredNonStaticMembers$2(i3 - 1, i9 - 1)) {
                    break;
                }
                i3--;
                i9--;
            }
            centeredArray2.BuiltInFictitiousFunctionClassFactory[centeredArray2.MyBillsEntityDataFactory + i8] = i3;
            if (z && (i4 = (i5 - i6) - i8) >= i7 && i4 <= i && centeredArray.BuiltInFictitiousFunctionClassFactory[i4 + centeredArray.MyBillsEntityDataFactory] >= i3) {
                Snake snake = new Snake();
                snake.KClassImpl$Data$declaredNonStaticMembers$2 = i3;
                snake.getAuthRequestContext = i9;
                snake.MyBillsEntityDataFactory = i2;
                snake.PlaceComponentResult = i10;
                snake.BuiltInFictitiousFunctionClassFactory = true;
                return snake;
            }
            i8 += 2;
            range2 = range;
        }
        return null;
    }

    private static Snake MyBillsEntityDataFactory(Range range, Callback callback, CenteredArray centeredArray, CenteredArray centeredArray2, int i) {
        int i2;
        int i3;
        int i4;
        Range range2 = range;
        boolean z = Math.abs((range2.getAuthRequestContext - range2.KClassImpl$Data$declaredNonStaticMembers$2) - (range2.MyBillsEntityDataFactory - range2.PlaceComponentResult)) % 2 == 1;
        int i5 = range2.getAuthRequestContext - range2.KClassImpl$Data$declaredNonStaticMembers$2;
        int i6 = range2.MyBillsEntityDataFactory - range2.PlaceComponentResult;
        int i7 = -i;
        int i8 = i7;
        while (i8 <= i) {
            if (i8 != i7 && (i8 == i || centeredArray.BuiltInFictitiousFunctionClassFactory[i8 + 1 + centeredArray.MyBillsEntityDataFactory] <= centeredArray.BuiltInFictitiousFunctionClassFactory[(i8 - 1) + centeredArray.MyBillsEntityDataFactory])) {
                i2 = centeredArray.BuiltInFictitiousFunctionClassFactory[(i8 - 1) + centeredArray.MyBillsEntityDataFactory];
                i3 = i2 + 1;
            } else {
                i2 = centeredArray.BuiltInFictitiousFunctionClassFactory[i8 + 1 + centeredArray.MyBillsEntityDataFactory];
                i3 = i2;
            }
            int i9 = (range2.PlaceComponentResult + (i3 - range2.KClassImpl$Data$declaredNonStaticMembers$2)) - i8;
            int i10 = (i == 0 || i3 != i2) ? i9 : i9 - 1;
            while (i3 < range2.getAuthRequestContext && i9 < range2.MyBillsEntityDataFactory) {
                if (!callback.KClassImpl$Data$declaredNonStaticMembers$2(i3, i9)) {
                    break;
                }
                i3++;
                i9++;
            }
            centeredArray.BuiltInFictitiousFunctionClassFactory[centeredArray.MyBillsEntityDataFactory + i8] = i3;
            if (z && (i4 = (i5 - i6) - i8) >= i7 + 1 && i4 <= i - 1 && centeredArray2.BuiltInFictitiousFunctionClassFactory[i4 + centeredArray2.MyBillsEntityDataFactory] <= i3) {
                Snake snake = new Snake();
                snake.KClassImpl$Data$declaredNonStaticMembers$2 = i2;
                snake.getAuthRequestContext = i10;
                snake.MyBillsEntityDataFactory = i3;
                snake.PlaceComponentResult = i9;
                snake.BuiltInFictitiousFunctionClassFactory = false;
                return snake;
            }
            i8 += 2;
            range2 = range;
        }
        return null;
    }

    private static Snake PlaceComponentResult(Range range, Callback callback, CenteredArray centeredArray, CenteredArray centeredArray2) {
        if (range.getAuthRequestContext - range.KClassImpl$Data$declaredNonStaticMembers$2 <= 0 || range.MyBillsEntityDataFactory - range.PlaceComponentResult <= 0) {
            return null;
        }
        int i = (((range.getAuthRequestContext - range.KClassImpl$Data$declaredNonStaticMembers$2) + (range.MyBillsEntityDataFactory - range.PlaceComponentResult)) + 1) / 2;
        centeredArray.BuiltInFictitiousFunctionClassFactory[centeredArray.MyBillsEntityDataFactory + 1] = range.KClassImpl$Data$declaredNonStaticMembers$2;
        centeredArray2.BuiltInFictitiousFunctionClassFactory[centeredArray2.MyBillsEntityDataFactory + 1] = range.getAuthRequestContext;
        for (int i2 = 0; i2 < i; i2++) {
            Snake MyBillsEntityDataFactory = MyBillsEntityDataFactory(range, callback, centeredArray, centeredArray2, i2);
            if (MyBillsEntityDataFactory != null) {
                return MyBillsEntityDataFactory;
            }
            Snake authRequestContext = getAuthRequestContext(range, callback, centeredArray, centeredArray2, i2);
            if (authRequestContext != null) {
                return authRequestContext;
            }
        }
        return null;
    }
}
