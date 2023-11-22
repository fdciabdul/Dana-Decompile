package androidx.core.view;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* loaded from: classes3.dex */
public final class GestureDetectorCompat {
    private final GestureDetectorCompatImpl getAuthRequestContext;

    /* loaded from: classes3.dex */
    interface GestureDetectorCompatImpl {
        boolean BuiltInFictitiousFunctionClassFactory(MotionEvent motionEvent);
    }

    /* loaded from: classes3.dex */
    static class GestureDetectorCompatImplBase implements GestureDetectorCompatImpl {
        boolean BuiltInFictitiousFunctionClassFactory;
        private boolean DatabaseTableConfigUtil;
        private MotionEvent FragmentBottomSheetPaymentSettingBinding;
        private final Handler GetContactSyncConfig;
        MotionEvent KClassImpl$Data$declaredNonStaticMembers$2;
        boolean MyBillsEntityDataFactory;
        private int NetworkUserEntityData$$ExternalSyntheticLambda0;
        private float NetworkUserEntityData$$ExternalSyntheticLambda1;
        private float NetworkUserEntityData$$ExternalSyntheticLambda2;
        private VelocityTracker NetworkUserEntityData$$ExternalSyntheticLambda3;
        private int NetworkUserEntityData$$ExternalSyntheticLambda6;
        private boolean NetworkUserEntityData$$ExternalSyntheticLambda7;
        private float NetworkUserEntityData$$ExternalSyntheticLambda8;
        GestureDetector.OnDoubleTapListener PlaceComponentResult;
        private int PrepareContext;
        final GestureDetector.OnGestureListener getAuthRequestContext;
        private boolean getErrorConfigVersion;
        private boolean initRecordTimeStamp;
        private float isLayoutRequested;
        private boolean moveToNextValue;
        private int newProxyInstance;
        private static final int scheduleImpl = ViewConfiguration.getTapTimeout();
        private static final int lookAheadTest = ViewConfiguration.getDoubleTapTimeout();

        /* loaded from: classes3.dex */
        class GestureHandler extends Handler {
            GestureHandler() {
            }

            GestureHandler(Handler handler) {
                super(handler.getLooper());
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i = message.what;
                if (i == 1) {
                    GestureDetectorCompatImplBase.this.getAuthRequestContext.onShowPress(GestureDetectorCompatImplBase.this.KClassImpl$Data$declaredNonStaticMembers$2);
                } else if (i == 2) {
                    GestureDetectorCompatImplBase.this.KClassImpl$Data$declaredNonStaticMembers$2();
                } else if (i == 3) {
                    if (GestureDetectorCompatImplBase.this.PlaceComponentResult != null) {
                        if (!GestureDetectorCompatImplBase.this.MyBillsEntityDataFactory) {
                            GestureDetectorCompatImplBase.this.PlaceComponentResult.onSingleTapConfirmed(GestureDetectorCompatImplBase.this.KClassImpl$Data$declaredNonStaticMembers$2);
                        } else {
                            GestureDetectorCompatImplBase.this.BuiltInFictitiousFunctionClassFactory = true;
                        }
                    }
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unknown message ");
                    sb.append(message);
                    throw new RuntimeException(sb.toString());
                }
            }
        }

        GestureDetectorCompatImplBase(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            if (handler != null) {
                this.GetContactSyncConfig = new GestureHandler(handler);
            } else {
                this.GetContactSyncConfig = new GestureHandler();
            }
            this.getAuthRequestContext = onGestureListener;
            if (onGestureListener instanceof GestureDetector.OnDoubleTapListener) {
                BuiltInFictitiousFunctionClassFactory((GestureDetector.OnDoubleTapListener) onGestureListener);
            }
            getAuthRequestContext(context);
        }

        private void getAuthRequestContext(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null");
            }
            if (this.getAuthRequestContext == null) {
                throw new IllegalArgumentException("OnGestureListener must not be null");
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = true;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
            int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
            this.newProxyInstance = viewConfiguration.getScaledMinimumFlingVelocity();
            this.PrepareContext = viewConfiguration.getScaledMaximumFlingVelocity();
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = scaledTouchSlop * scaledTouchSlop;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = scaledDoubleTapSlop * scaledDoubleTapSlop;
        }

        public void BuiltInFictitiousFunctionClassFactory(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
            this.PlaceComponentResult = onDoubleTapListener;
        }

        /* JADX WARN: Removed duplicated region for block: B:104:0x0205  */
        /* JADX WARN: Removed duplicated region for block: B:107:0x021c  */
        @Override // androidx.core.view.GestureDetectorCompat.GestureDetectorCompatImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean BuiltInFictitiousFunctionClassFactory(android.view.MotionEvent r13) {
            /*
                Method dump skipped, instructions count: 590
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.GestureDetectorCompat.GestureDetectorCompatImplBase.BuiltInFictitiousFunctionClassFactory(android.view.MotionEvent):boolean");
        }

        private void BuiltInFictitiousFunctionClassFactory() {
            this.GetContactSyncConfig.removeMessages(1);
            this.GetContactSyncConfig.removeMessages(2);
            this.GetContactSyncConfig.removeMessages(3);
            this.NetworkUserEntityData$$ExternalSyntheticLambda3.recycle();
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = null;
            this.DatabaseTableConfigUtil = false;
            this.MyBillsEntityDataFactory = false;
            this.getErrorConfigVersion = false;
            this.moveToNextValue = false;
            this.BuiltInFictitiousFunctionClassFactory = false;
            if (this.initRecordTimeStamp) {
                this.initRecordTimeStamp = false;
            }
        }

        private void MyBillsEntityDataFactory() {
            this.GetContactSyncConfig.removeMessages(1);
            this.GetContactSyncConfig.removeMessages(2);
            this.GetContactSyncConfig.removeMessages(3);
            this.DatabaseTableConfigUtil = false;
            this.getErrorConfigVersion = false;
            this.moveToNextValue = false;
            this.BuiltInFictitiousFunctionClassFactory = false;
            if (this.initRecordTimeStamp) {
                this.initRecordTimeStamp = false;
            }
        }

        private boolean MyBillsEntityDataFactory(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
            if (this.moveToNextValue && motionEvent3.getEventTime() - motionEvent2.getEventTime() <= lookAheadTest) {
                int x = ((int) motionEvent.getX()) - ((int) motionEvent3.getX());
                int y = ((int) motionEvent.getY()) - ((int) motionEvent3.getY());
                return (x * x) + (y * y) < this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            }
            return false;
        }

        void KClassImpl$Data$declaredNonStaticMembers$2() {
            this.GetContactSyncConfig.removeMessages(3);
            this.BuiltInFictitiousFunctionClassFactory = false;
            this.initRecordTimeStamp = true;
            this.getAuthRequestContext.onLongPress(this.KClassImpl$Data$declaredNonStaticMembers$2);
        }
    }

    /* loaded from: classes3.dex */
    static class GestureDetectorCompatImplJellybeanMr2 implements GestureDetectorCompatImpl {
        private final GestureDetector MyBillsEntityDataFactory;

        GestureDetectorCompatImplJellybeanMr2(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            this.MyBillsEntityDataFactory = new GestureDetector(context, onGestureListener, handler);
        }

        @Override // androidx.core.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public boolean BuiltInFictitiousFunctionClassFactory(MotionEvent motionEvent) {
            return this.MyBillsEntityDataFactory.onTouchEvent(motionEvent);
        }
    }

    public GestureDetectorCompat(Context context, GestureDetector.OnGestureListener onGestureListener) {
        this(context, onGestureListener, null);
    }

    public GestureDetectorCompat(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
        if (Build.VERSION.SDK_INT > 17) {
            this.getAuthRequestContext = new GestureDetectorCompatImplJellybeanMr2(context, onGestureListener, handler);
        } else {
            this.getAuthRequestContext = new GestureDetectorCompatImplBase(context, onGestureListener, handler);
        }
    }

    public final boolean MyBillsEntityDataFactory(MotionEvent motionEvent) {
        return this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(motionEvent);
    }
}
