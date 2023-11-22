package androidx.asynclayoutinflater.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.util.Pools;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.concurrent.ArrayBlockingQueue;

/* loaded from: classes3.dex */
public final class AsyncLayoutInflater {
    LayoutInflater getAuthRequestContext;
    private Handler.Callback PlaceComponentResult = new Handler.Callback() { // from class: androidx.asynclayoutinflater.view.AsyncLayoutInflater.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InflateRequest inflateRequest = (InflateRequest) message.obj;
            if (inflateRequest.BuiltInFictitiousFunctionClassFactory == null) {
                inflateRequest.BuiltInFictitiousFunctionClassFactory = AsyncLayoutInflater.this.getAuthRequestContext.inflate(inflateRequest.PlaceComponentResult, inflateRequest.getAuthRequestContext, false);
            }
            inflateRequest.MyBillsEntityDataFactory.PlaceComponentResult(inflateRequest.BuiltInFictitiousFunctionClassFactory, inflateRequest.PlaceComponentResult, inflateRequest.getAuthRequestContext);
            InflateThread inflateThread = AsyncLayoutInflater.this.KClassImpl$Data$declaredNonStaticMembers$2;
            inflateRequest.MyBillsEntityDataFactory = null;
            inflateRequest.KClassImpl$Data$declaredNonStaticMembers$2 = null;
            inflateRequest.getAuthRequestContext = null;
            inflateRequest.PlaceComponentResult = 0;
            inflateRequest.BuiltInFictitiousFunctionClassFactory = null;
            inflateThread.PlaceComponentResult.MyBillsEntityDataFactory(inflateRequest);
            return true;
        }
    };
    Handler BuiltInFictitiousFunctionClassFactory = new Handler(this.PlaceComponentResult);
    public InflateThread KClassImpl$Data$declaredNonStaticMembers$2 = InflateThread.PlaceComponentResult();

    /* loaded from: classes3.dex */
    public static class InflateRequest {
        View BuiltInFictitiousFunctionClassFactory;
        public AsyncLayoutInflater KClassImpl$Data$declaredNonStaticMembers$2;
        public OnInflateFinishedListener MyBillsEntityDataFactory;
        public int PlaceComponentResult;
        public ViewGroup getAuthRequestContext;
    }

    /* loaded from: classes3.dex */
    public interface OnInflateFinishedListener {
        void PlaceComponentResult(View view, int i, ViewGroup viewGroup);
    }

    public AsyncLayoutInflater(Context context) {
        this.getAuthRequestContext = new BasicInflater(context);
    }

    /* loaded from: classes3.dex */
    static class BasicInflater extends LayoutInflater {
        private static final String[] PlaceComponentResult = {"android.widget.", "android.webkit.", "android.app."};

        BasicInflater(Context context) {
            super(context);
        }

        @Override // android.view.LayoutInflater
        public LayoutInflater cloneInContext(Context context) {
            return new BasicInflater(context);
        }

        @Override // android.view.LayoutInflater
        protected View onCreateView(String str, AttributeSet attributeSet) throws ClassNotFoundException {
            View createView;
            for (String str2 : PlaceComponentResult) {
                try {
                    createView = createView(str, str2, attributeSet);
                } catch (ClassNotFoundException unused) {
                }
                if (createView != null) {
                    return createView;
                }
            }
            return super.onCreateView(str, attributeSet);
        }
    }

    /* loaded from: classes3.dex */
    public static class InflateThread extends Thread {
        private static final InflateThread BuiltInFictitiousFunctionClassFactory;
        public ArrayBlockingQueue<InflateRequest> KClassImpl$Data$declaredNonStaticMembers$2 = new ArrayBlockingQueue<>(10);
        public Pools.SynchronizedPool<InflateRequest> PlaceComponentResult = new Pools.SynchronizedPool<>(10);

        private InflateThread() {
        }

        static {
            InflateThread inflateThread = new InflateThread();
            BuiltInFictitiousFunctionClassFactory = inflateThread;
            inflateThread.start();
        }

        public static InflateThread PlaceComponentResult() {
            return BuiltInFictitiousFunctionClassFactory;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (true) {
                try {
                    InflateRequest take = this.KClassImpl$Data$declaredNonStaticMembers$2.take();
                    try {
                        take.BuiltInFictitiousFunctionClassFactory = take.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.inflate(take.PlaceComponentResult, take.getAuthRequestContext, false);
                    } catch (RuntimeException e) {
                        InstrumentInjector.log_w("AsyncLayoutInflater", "Failed to inflate resource in the background! Retrying on the UI thread", e);
                    }
                    Message.obtain(take.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory, 0, take).sendToTarget();
                } catch (InterruptedException e2) {
                    InstrumentInjector.log_w("AsyncLayoutInflater", e2);
                }
            }
        }
    }
}
