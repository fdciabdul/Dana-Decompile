package id.dana.utils;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes5.dex */
public class OnSwipeListener implements View.OnTouchListener {
    public final GestureListener KClassImpl$Data$declaredNonStaticMembers$2;
    private final GestureDetector getAuthRequestContext;

    public void KClassImpl$Data$declaredNonStaticMembers$2() {
    }

    public void MyBillsEntityDataFactory() {
    }

    public void getAuthRequestContext() {
    }

    public OnSwipeListener(Context context) {
        GestureListener gestureListener = new GestureListener(this, (byte) 0);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = gestureListener;
        this.getAuthRequestContext = new GestureDetector(context, gestureListener);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return this.getAuthRequestContext.onTouchEvent(motionEvent);
    }

    /* loaded from: classes5.dex */
    public final class GestureListener extends GestureDetector.SimpleOnGestureListener {
        private int BuiltInFictitiousFunctionClassFactory;
        private int MyBillsEntityDataFactory;

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        private GestureListener() {
            this.MyBillsEntityDataFactory = 100;
            this.BuiltInFictitiousFunctionClassFactory = 100;
        }

        /* synthetic */ GestureListener(OnSwipeListener onSwipeListener, byte b) {
            this();
        }

        public static /* synthetic */ int KClassImpl$Data$declaredNonStaticMembers$2(GestureListener gestureListener) {
            gestureListener.BuiltInFictitiousFunctionClassFactory = 50;
            return 50;
        }

        public static /* synthetic */ int PlaceComponentResult(GestureListener gestureListener) {
            gestureListener.MyBillsEntityDataFactory = 50;
            return 50;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            OnSwipeListener.this.MyBillsEntityDataFactory();
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            try {
                float y = motionEvent2.getY() - motionEvent.getY();
                float x = motionEvent2.getX() - motionEvent.getX();
                if (Math.abs(x) > Math.abs(y) && Math.abs(x) > this.MyBillsEntityDataFactory && Math.abs(f) > this.BuiltInFictitiousFunctionClassFactory) {
                    int i = (x > 0.0f ? 1 : (x == 0.0f ? 0 : -1));
                } else if (Math.abs(y) <= this.MyBillsEntityDataFactory || Math.abs(f2) <= this.BuiltInFictitiousFunctionClassFactory) {
                    return false;
                } else {
                    if (y > 0.0f) {
                        OnSwipeListener.this.getAuthRequestContext();
                    } else {
                        OnSwipeListener.this.KClassImpl$Data$declaredNonStaticMembers$2();
                    }
                }
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
    }
}
