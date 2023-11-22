package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ChildHelper {
    final Callback MyBillsEntityDataFactory;
    final Bucket getAuthRequestContext = new Bucket();
    final List<View> BuiltInFictitiousFunctionClassFactory = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface Callback {
        void BuiltInFictitiousFunctionClassFactory(int i);

        void BuiltInFictitiousFunctionClassFactory(View view);

        RecyclerView.ViewHolder KClassImpl$Data$declaredNonStaticMembers$2(View view);

        int MyBillsEntityDataFactory();

        int MyBillsEntityDataFactory(View view);

        void MyBillsEntityDataFactory(int i);

        void MyBillsEntityDataFactory(View view, int i, ViewGroup.LayoutParams layoutParams);

        void PlaceComponentResult(View view);

        View getAuthRequestContext(int i);

        void getAuthRequestContext();

        void getAuthRequestContext(View view, int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChildHelper(Callback callback) {
        this.MyBillsEntityDataFactory = callback;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        if (this.BuiltInFictitiousFunctionClassFactory.remove(view)) {
            this.MyBillsEntityDataFactory.PlaceComponentResult(view);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void MyBillsEntityDataFactory(View view, int i, boolean z) {
        int BuiltInFictitiousFunctionClassFactory;
        if (i < 0) {
            BuiltInFictitiousFunctionClassFactory = this.MyBillsEntityDataFactory.MyBillsEntityDataFactory();
        } else {
            BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(i);
        }
        this.getAuthRequestContext.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory, z);
        if (z) {
            this.BuiltInFictitiousFunctionClassFactory.add(view);
            this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(view);
        }
        this.MyBillsEntityDataFactory.getAuthRequestContext(view, BuiltInFictitiousFunctionClassFactory);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int BuiltInFictitiousFunctionClassFactory(int i) {
        if (i < 0) {
            return -1;
        }
        int MyBillsEntityDataFactory = this.MyBillsEntityDataFactory.MyBillsEntityDataFactory();
        int i2 = i;
        while (i2 < MyBillsEntityDataFactory) {
            int authRequestContext = i - (i2 - this.getAuthRequestContext.getAuthRequestContext(i2));
            if (authRequestContext == 0) {
                while (this.getAuthRequestContext.PlaceComponentResult(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += authRequestContext;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void MyBillsEntityDataFactory(int i) {
        int BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(i);
        View authRequestContext = this.MyBillsEntityDataFactory.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory);
        if (authRequestContext == null) {
            return;
        }
        if (this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory)) {
            KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext);
        }
        this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void KClassImpl$Data$declaredNonStaticMembers$2(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        int BuiltInFictitiousFunctionClassFactory;
        if (i < 0) {
            BuiltInFictitiousFunctionClassFactory = this.MyBillsEntityDataFactory.MyBillsEntityDataFactory();
        } else {
            BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(i);
        }
        this.getAuthRequestContext.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory, z);
        if (z) {
            this.BuiltInFictitiousFunctionClassFactory.add(view);
            this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(view);
        }
        this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(view, BuiltInFictitiousFunctionClassFactory, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int getAuthRequestContext(View view) {
        int MyBillsEntityDataFactory = this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(view);
        if (MyBillsEntityDataFactory == -1 || this.getAuthRequestContext.PlaceComponentResult(MyBillsEntityDataFactory)) {
            return -1;
        }
        return MyBillsEntityDataFactory - this.getAuthRequestContext.getAuthRequestContext(MyBillsEntityDataFactory);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean MyBillsEntityDataFactory(View view) {
        return this.BuiltInFictitiousFunctionClassFactory.contains(view);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getAuthRequestContext.toString());
        sb.append(", hidden list:");
        sb.append(this.BuiltInFictitiousFunctionClassFactory.size());
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean PlaceComponentResult(View view) {
        int MyBillsEntityDataFactory = this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(view);
        if (MyBillsEntityDataFactory == -1) {
            KClassImpl$Data$declaredNonStaticMembers$2(view);
            return true;
        } else if (this.getAuthRequestContext.PlaceComponentResult(MyBillsEntityDataFactory)) {
            this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory);
            KClassImpl$Data$declaredNonStaticMembers$2(view);
            this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory);
            return true;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Bucket {
        Bucket MyBillsEntityDataFactory;
        long PlaceComponentResult = 0;

        Bucket() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void MyBillsEntityDataFactory(int i) {
            Bucket bucket = this;
            while (i >= 64) {
                bucket = bucket.MyBillsEntityDataFactory;
                if (bucket == null) {
                    return;
                }
                i -= 64;
            }
            bucket.PlaceComponentResult &= (1 << i) ^ (-1);
        }

        final int getAuthRequestContext(int i) {
            Bucket bucket = this.MyBillsEntityDataFactory;
            if (bucket == null) {
                if (i >= 64) {
                    return Long.bitCount(this.PlaceComponentResult);
                }
                return Long.bitCount(this.PlaceComponentResult & ((1 << i) - 1));
            } else if (i < 64) {
                return Long.bitCount(this.PlaceComponentResult & ((1 << i) - 1));
            } else {
                return bucket.getAuthRequestContext(i - 64) + Long.bitCount(this.PlaceComponentResult);
            }
        }

        public String toString() {
            if (this.MyBillsEntityDataFactory == null) {
                return Long.toBinaryString(this.PlaceComponentResult);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.MyBillsEntityDataFactory.toString());
            sb.append("xx");
            sb.append(Long.toBinaryString(this.PlaceComponentResult));
            return sb.toString();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final boolean PlaceComponentResult(int i) {
            Bucket bucket = this;
            while (i >= 64) {
                if (bucket.MyBillsEntityDataFactory == null) {
                    bucket.MyBillsEntityDataFactory = new Bucket();
                }
                bucket = bucket.MyBillsEntityDataFactory;
                i -= 64;
            }
            return (bucket.PlaceComponentResult & (1 << i)) != 0;
        }

        final void getAuthRequestContext(int i, boolean z) {
            Bucket bucket = this;
            while (true) {
                if (i < 64) {
                    long j = bucket.PlaceComponentResult;
                    boolean z2 = (Long.MIN_VALUE & j) != 0;
                    long j2 = (1 << i) - 1;
                    bucket.PlaceComponentResult = (j & j2) | ((((-1) ^ j2) & j) << 1);
                    if (z) {
                        bucket.KClassImpl$Data$declaredNonStaticMembers$2(i);
                    } else {
                        bucket.MyBillsEntityDataFactory(i);
                    }
                    if (!z2 && bucket.MyBillsEntityDataFactory == null) {
                        return;
                    }
                    if (bucket.MyBillsEntityDataFactory == null) {
                        bucket.MyBillsEntityDataFactory = new Bucket();
                    }
                    bucket = bucket.MyBillsEntityDataFactory;
                    z = z2;
                    i = 0;
                } else {
                    if (bucket.MyBillsEntityDataFactory == null) {
                        bucket.MyBillsEntityDataFactory = new Bucket();
                    }
                    bucket = bucket.MyBillsEntityDataFactory;
                    i -= 64;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final boolean BuiltInFictitiousFunctionClassFactory(int i) {
            Bucket bucket = this;
            while (i >= 64) {
                if (bucket.MyBillsEntityDataFactory == null) {
                    bucket.MyBillsEntityDataFactory = new Bucket();
                }
                bucket = bucket.MyBillsEntityDataFactory;
                i -= 64;
            }
            long j = 1 << i;
            long j2 = bucket.PlaceComponentResult;
            boolean z = (j2 & j) != 0;
            long j3 = j2 & (j ^ (-1));
            bucket.PlaceComponentResult = j3;
            long j4 = j - 1;
            bucket.PlaceComponentResult = Long.rotateRight((j4 ^ (-1)) & j3, 1) | (j4 & j3);
            Bucket bucket2 = bucket.MyBillsEntityDataFactory;
            if (bucket2 != null) {
                if (bucket2.PlaceComponentResult(0)) {
                    bucket.KClassImpl$Data$declaredNonStaticMembers$2(63);
                }
                bucket.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(0);
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void KClassImpl$Data$declaredNonStaticMembers$2(int i) {
            Bucket bucket = this;
            while (i >= 64) {
                if (bucket.MyBillsEntityDataFactory == null) {
                    bucket.MyBillsEntityDataFactory = new Bucket();
                }
                bucket = bucket.MyBillsEntityDataFactory;
                i -= 64;
            }
            bucket.PlaceComponentResult |= 1 << i;
        }
    }
}
