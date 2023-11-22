package androidx.core.app;

import android.app.Activity;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.SparseIntArray;
import android.view.FrameMetrics;
import android.view.Window;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class FrameMetricsAggregator {
    public final FrameMetricsBaseImpl MyBillsEntityDataFactory;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface MetricType {
    }

    public FrameMetricsAggregator() {
        this((byte) 0);
    }

    private FrameMetricsAggregator(byte b) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.MyBillsEntityDataFactory = new FrameMetricsApi24Impl(1);
        } else {
            this.MyBillsEntityDataFactory = new FrameMetricsBaseImpl();
        }
    }

    /* loaded from: classes.dex */
    public static class FrameMetricsBaseImpl {
        public SparseIntArray[] KClassImpl$Data$declaredNonStaticMembers$2() {
            return null;
        }

        public void MyBillsEntityDataFactory(Activity activity) {
        }

        public SparseIntArray[] PlaceComponentResult() {
            return null;
        }

        public SparseIntArray[] PlaceComponentResult(Activity activity) {
            return null;
        }

        FrameMetricsBaseImpl() {
        }
    }

    /* loaded from: classes.dex */
    static class FrameMetricsApi24Impl extends FrameMetricsBaseImpl {
        private static HandlerThread BuiltInFictitiousFunctionClassFactory;
        private static Handler MyBillsEntityDataFactory;
        int KClassImpl$Data$declaredNonStaticMembers$2;
        SparseIntArray[] PlaceComponentResult = new SparseIntArray[9];
        private final ArrayList<WeakReference<Activity>> lookAheadTest = new ArrayList<>();
        Window.OnFrameMetricsAvailableListener getAuthRequestContext = new Window.OnFrameMetricsAvailableListener() { // from class: androidx.core.app.FrameMetricsAggregator.FrameMetricsApi24Impl.1
            @Override // android.view.Window.OnFrameMetricsAvailableListener
            public void onFrameMetricsAvailable(Window window, FrameMetrics frameMetrics, int i) {
                if ((FrameMetricsApi24Impl.this.KClassImpl$Data$declaredNonStaticMembers$2 & 1) != 0) {
                    FrameMetricsApi24Impl frameMetricsApi24Impl = FrameMetricsApi24Impl.this;
                    frameMetricsApi24Impl.PlaceComponentResult(frameMetricsApi24Impl.PlaceComponentResult[0], frameMetrics.getMetric(8));
                }
                if ((FrameMetricsApi24Impl.this.KClassImpl$Data$declaredNonStaticMembers$2 & 2) != 0) {
                    FrameMetricsApi24Impl frameMetricsApi24Impl2 = FrameMetricsApi24Impl.this;
                    frameMetricsApi24Impl2.PlaceComponentResult(frameMetricsApi24Impl2.PlaceComponentResult[1], frameMetrics.getMetric(1));
                }
                if ((FrameMetricsApi24Impl.this.KClassImpl$Data$declaredNonStaticMembers$2 & 4) != 0) {
                    FrameMetricsApi24Impl frameMetricsApi24Impl3 = FrameMetricsApi24Impl.this;
                    frameMetricsApi24Impl3.PlaceComponentResult(frameMetricsApi24Impl3.PlaceComponentResult[2], frameMetrics.getMetric(3));
                }
                if ((FrameMetricsApi24Impl.this.KClassImpl$Data$declaredNonStaticMembers$2 & 8) != 0) {
                    FrameMetricsApi24Impl frameMetricsApi24Impl4 = FrameMetricsApi24Impl.this;
                    frameMetricsApi24Impl4.PlaceComponentResult(frameMetricsApi24Impl4.PlaceComponentResult[3], frameMetrics.getMetric(4));
                }
                if ((FrameMetricsApi24Impl.this.KClassImpl$Data$declaredNonStaticMembers$2 & 16) != 0) {
                    FrameMetricsApi24Impl frameMetricsApi24Impl5 = FrameMetricsApi24Impl.this;
                    frameMetricsApi24Impl5.PlaceComponentResult(frameMetricsApi24Impl5.PlaceComponentResult[4], frameMetrics.getMetric(5));
                }
                if ((FrameMetricsApi24Impl.this.KClassImpl$Data$declaredNonStaticMembers$2 & 64) != 0) {
                    FrameMetricsApi24Impl frameMetricsApi24Impl6 = FrameMetricsApi24Impl.this;
                    frameMetricsApi24Impl6.PlaceComponentResult(frameMetricsApi24Impl6.PlaceComponentResult[6], frameMetrics.getMetric(7));
                }
                if ((FrameMetricsApi24Impl.this.KClassImpl$Data$declaredNonStaticMembers$2 & 32) != 0) {
                    FrameMetricsApi24Impl frameMetricsApi24Impl7 = FrameMetricsApi24Impl.this;
                    frameMetricsApi24Impl7.PlaceComponentResult(frameMetricsApi24Impl7.PlaceComponentResult[5], frameMetrics.getMetric(6));
                }
                if ((FrameMetricsApi24Impl.this.KClassImpl$Data$declaredNonStaticMembers$2 & 128) != 0) {
                    FrameMetricsApi24Impl frameMetricsApi24Impl8 = FrameMetricsApi24Impl.this;
                    frameMetricsApi24Impl8.PlaceComponentResult(frameMetricsApi24Impl8.PlaceComponentResult[7], frameMetrics.getMetric(0));
                }
                if ((FrameMetricsApi24Impl.this.KClassImpl$Data$declaredNonStaticMembers$2 & 256) != 0) {
                    FrameMetricsApi24Impl frameMetricsApi24Impl9 = FrameMetricsApi24Impl.this;
                    frameMetricsApi24Impl9.PlaceComponentResult(frameMetricsApi24Impl9.PlaceComponentResult[8], frameMetrics.getMetric(2));
                }
            }
        };

        FrameMetricsApi24Impl(int i) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        }

        void PlaceComponentResult(SparseIntArray sparseIntArray, long j) {
            if (sparseIntArray != null) {
                int i = (int) ((500000 + j) / 1000000);
                if (j >= 0) {
                    sparseIntArray.put(i, sparseIntArray.get(i) + 1);
                }
            }
        }

        @Override // androidx.core.app.FrameMetricsAggregator.FrameMetricsBaseImpl
        public void MyBillsEntityDataFactory(Activity activity) {
            if (BuiltInFictitiousFunctionClassFactory == null) {
                HandlerThread handlerThread = new HandlerThread("FrameMetricsAggregator");
                BuiltInFictitiousFunctionClassFactory = handlerThread;
                handlerThread.start();
                MyBillsEntityDataFactory = new Handler(BuiltInFictitiousFunctionClassFactory.getLooper());
            }
            for (int i = 0; i <= 8; i++) {
                SparseIntArray[] sparseIntArrayArr = this.PlaceComponentResult;
                if (sparseIntArrayArr[i] == null && (this.KClassImpl$Data$declaredNonStaticMembers$2 & (1 << i)) != 0) {
                    sparseIntArrayArr[i] = new SparseIntArray();
                }
            }
            activity.getWindow().addOnFrameMetricsAvailableListener(this.getAuthRequestContext, MyBillsEntityDataFactory);
            this.lookAheadTest.add(new WeakReference<>(activity));
        }

        @Override // androidx.core.app.FrameMetricsAggregator.FrameMetricsBaseImpl
        public SparseIntArray[] PlaceComponentResult(Activity activity) {
            Iterator<WeakReference<Activity>> it = this.lookAheadTest.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                WeakReference<Activity> next = it.next();
                if (next.get() == activity) {
                    this.lookAheadTest.remove(next);
                    break;
                }
            }
            activity.getWindow().removeOnFrameMetricsAvailableListener(this.getAuthRequestContext);
            return this.PlaceComponentResult;
        }

        @Override // androidx.core.app.FrameMetricsAggregator.FrameMetricsBaseImpl
        public SparseIntArray[] PlaceComponentResult() {
            return this.PlaceComponentResult;
        }

        @Override // androidx.core.app.FrameMetricsAggregator.FrameMetricsBaseImpl
        public SparseIntArray[] KClassImpl$Data$declaredNonStaticMembers$2() {
            SparseIntArray[] sparseIntArrayArr = this.PlaceComponentResult;
            this.PlaceComponentResult = new SparseIntArray[9];
            return sparseIntArrayArr;
        }
    }
}
