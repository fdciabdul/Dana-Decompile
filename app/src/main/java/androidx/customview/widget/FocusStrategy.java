package androidx.customview.widget;

import android.graphics.Rect;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* loaded from: classes3.dex */
class FocusStrategy {

    /* loaded from: classes3.dex */
    public interface BoundsAdapter<T> {
        void MyBillsEntityDataFactory(T t, Rect rect);
    }

    /* loaded from: classes3.dex */
    public interface CollectionAdapter<T, V> {
        int KClassImpl$Data$declaredNonStaticMembers$2(T t);

        V getAuthRequestContext(T t, int i);
    }

    public static <L, T> T MyBillsEntityDataFactory(L l, CollectionAdapter<L, T> collectionAdapter, BoundsAdapter<T> boundsAdapter, T t, int i, boolean z) {
        int KClassImpl$Data$declaredNonStaticMembers$2 = collectionAdapter.KClassImpl$Data$declaredNonStaticMembers$2(l);
        ArrayList arrayList = new ArrayList(KClassImpl$Data$declaredNonStaticMembers$2);
        for (int i2 = 0; i2 < KClassImpl$Data$declaredNonStaticMembers$2; i2++) {
            arrayList.add(collectionAdapter.getAuthRequestContext(l, i2));
        }
        Collections.sort(arrayList, new SequentialComparator(z, boundsAdapter));
        if (i != 1) {
            if (i != 2) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
            }
            int size = arrayList.size();
            int lastIndexOf = (t != null ? arrayList.lastIndexOf(t) : -1) + 1;
            if (lastIndexOf < size) {
                return (T) arrayList.get(lastIndexOf);
            }
            return null;
        }
        int size2 = arrayList.size();
        if (t != null) {
            size2 = arrayList.indexOf(t);
        }
        int i3 = size2 - 1;
        if (i3 >= 0) {
            return (T) arrayList.get(i3);
        }
        return null;
    }

    /* loaded from: classes3.dex */
    static class SequentialComparator<T> implements Comparator<T> {
        private final BoundsAdapter<T> KClassImpl$Data$declaredNonStaticMembers$2;
        private final boolean MyBillsEntityDataFactory;
        private final Rect BuiltInFictitiousFunctionClassFactory = new Rect();
        private final Rect getAuthRequestContext = new Rect();

        SequentialComparator(boolean z, BoundsAdapter<T> boundsAdapter) {
            this.MyBillsEntityDataFactory = z;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = boundsAdapter;
        }

        @Override // java.util.Comparator
        public int compare(T t, T t2) {
            Rect rect = this.BuiltInFictitiousFunctionClassFactory;
            Rect rect2 = this.getAuthRequestContext;
            this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(t, rect);
            this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(t2, rect2);
            if (rect.top < rect2.top) {
                return -1;
            }
            if (rect.top > rect2.top) {
                return 1;
            }
            if (rect.left < rect2.left) {
                return this.MyBillsEntityDataFactory ? 1 : -1;
            } else if (rect.left > rect2.left) {
                return !this.MyBillsEntityDataFactory ? 1 : -1;
            } else if (rect.bottom < rect2.bottom) {
                return -1;
            } else {
                if (rect.bottom > rect2.bottom) {
                    return 1;
                }
                if (rect.right < rect2.right) {
                    return this.MyBillsEntityDataFactory ? 1 : -1;
                } else if (rect.right > rect2.right) {
                    return !this.MyBillsEntityDataFactory ? 1 : -1;
                } else {
                    return 0;
                }
            }
        }
    }

    public static <L, T> T getAuthRequestContext(L l, CollectionAdapter<L, T> collectionAdapter, BoundsAdapter<T> boundsAdapter, T t, Rect rect, int i) {
        Rect rect2 = new Rect(rect);
        if (i == 17) {
            rect2.offset(rect.width() + 1, 0);
        } else if (i == 33) {
            rect2.offset(0, rect.height() + 1);
        } else if (i == 66) {
            rect2.offset(-(rect.width() + 1), 0);
        } else if (i == 130) {
            rect2.offset(0, -(rect.height() + 1));
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        T t2 = null;
        int KClassImpl$Data$declaredNonStaticMembers$2 = collectionAdapter.KClassImpl$Data$declaredNonStaticMembers$2(l);
        Rect rect3 = new Rect();
        for (int i2 = 0; i2 < KClassImpl$Data$declaredNonStaticMembers$2; i2++) {
            T authRequestContext = collectionAdapter.getAuthRequestContext(l, i2);
            if (authRequestContext != t) {
                boundsAdapter.MyBillsEntityDataFactory(authRequestContext, rect3);
                if (MyBillsEntityDataFactory(i, rect, rect3, rect2)) {
                    rect2.set(rect3);
                    t2 = authRequestContext;
                }
            }
        }
        return t2;
    }

    private static boolean MyBillsEntityDataFactory(int i, Rect rect, Rect rect2, Rect rect3) {
        if (PlaceComponentResult(rect, rect2, i)) {
            if (PlaceComponentResult(rect, rect3, i) && !getAuthRequestContext(i, rect, rect2, rect3)) {
                if (getAuthRequestContext(i, rect, rect3, rect2)) {
                    return false;
                }
                int max = Math.max(0, BuiltInFictitiousFunctionClassFactory(i, rect, rect2));
                int MyBillsEntityDataFactory = MyBillsEntityDataFactory(i, rect, rect2);
                int i2 = (max * 13 * max) + (MyBillsEntityDataFactory * MyBillsEntityDataFactory);
                int max2 = Math.max(0, BuiltInFictitiousFunctionClassFactory(i, rect, rect3));
                int MyBillsEntityDataFactory2 = MyBillsEntityDataFactory(i, rect, rect3);
                return i2 < ((max2 * 13) * max2) + (MyBillsEntityDataFactory2 * MyBillsEntityDataFactory2);
            }
            return true;
        }
        return false;
    }

    private static boolean getAuthRequestContext(int i, Rect rect, Rect rect2, Rect rect3) {
        int i2;
        int i3;
        boolean KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(i, rect, rect2);
        if (KClassImpl$Data$declaredNonStaticMembers$2(i, rect, rect3) || !KClassImpl$Data$declaredNonStaticMembers$2) {
            return false;
        }
        if (!PlaceComponentResult(i, rect, rect3) || i == 17 || i == 66) {
            return true;
        }
        int max = Math.max(0, BuiltInFictitiousFunctionClassFactory(i, rect, rect2));
        if (i == 17) {
            i2 = rect.left;
            i3 = rect3.left;
        } else if (i == 33) {
            i2 = rect.top;
            i3 = rect3.top;
        } else if (i == 66) {
            i2 = rect3.right;
            i3 = rect.right;
        } else if (i == 130) {
            i2 = rect3.bottom;
            i3 = rect.bottom;
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return max < Math.max(1, i2 - i3);
    }

    private static boolean PlaceComponentResult(Rect rect, Rect rect2, int i) {
        if (i == 17) {
            return (rect.right > rect2.right || rect.left >= rect2.right) && rect.left > rect2.left;
        } else if (i == 33) {
            return (rect.bottom > rect2.bottom || rect.top >= rect2.bottom) && rect.top > rect2.top;
        } else if (i == 66) {
            return (rect.left < rect2.left || rect.right <= rect2.left) && rect.right < rect2.right;
        } else if (i == 130) {
            return (rect.top < rect2.top || rect.bottom <= rect2.top) && rect.bottom < rect2.bottom;
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(int i, Rect rect, Rect rect2) {
        if (i != 17) {
            if (i != 33) {
                if (i != 66) {
                    if (i != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return rect2.right >= rect.left && rect2.left <= rect.right;
        }
        return rect2.bottom >= rect.top && rect2.top <= rect.bottom;
    }

    private static boolean PlaceComponentResult(int i, Rect rect, Rect rect2) {
        if (i == 17) {
            return rect.left >= rect2.right;
        } else if (i == 33) {
            return rect.top >= rect2.bottom;
        } else if (i == 66) {
            return rect.right <= rect2.left;
        } else if (i == 130) {
            return rect.bottom <= rect2.top;
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
    }

    private static int BuiltInFictitiousFunctionClassFactory(int i, Rect rect, Rect rect2) {
        int i2;
        int i3;
        if (i == 17) {
            i2 = rect.left;
            i3 = rect2.right;
        } else if (i == 33) {
            i2 = rect.top;
            i3 = rect2.bottom;
        } else if (i == 66) {
            i2 = rect2.left;
            i3 = rect.right;
        } else if (i == 130) {
            i2 = rect2.top;
            i3 = rect.bottom;
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return i2 - i3;
    }

    private static int MyBillsEntityDataFactory(int i, Rect rect, Rect rect2) {
        if (i != 17) {
            if (i != 33) {
                if (i != 66) {
                    if (i != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return Math.abs((rect.left + (rect.width() / 2)) - (rect2.left + (rect2.width() / 2)));
        }
        return Math.abs((rect.top + (rect.height() / 2)) - (rect2.top + (rect2.height() / 2)));
    }

    private FocusStrategy() {
    }
}
