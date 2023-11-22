package id.dana.richview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.viewpager.widget.ViewPager;

/* loaded from: classes9.dex */
public class ClickableViewPager extends ViewPager {
    OnItemClickListener onItemClickListener;

    /* loaded from: classes9.dex */
    public interface OnItemClickListener {
    }

    public ClickableViewPager(Context context) {
        super(context);
        MyBillsEntityDataFactory();
    }

    public ClickableViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        MyBillsEntityDataFactory();
    }

    private void MyBillsEntityDataFactory() {
        final GestureDetector gestureDetector = new GestureDetector(getContext(), new TapGestureListener(this, (byte) 0));
        setOnTouchListener(new View.OnTouchListener() { // from class: id.dana.richview.ClickableViewPager$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return ClickableViewPager.lambda$setup$0(gestureDetector, view, motionEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$setup$0(GestureDetector gestureDetector, View view, MotionEvent motionEvent) {
        gestureDetector.onTouchEvent(motionEvent);
        return false;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class TapGestureListener extends GestureDetector.SimpleOnGestureListener {
        private TapGestureListener() {
        }

        /* synthetic */ TapGestureListener(ClickableViewPager clickableViewPager, byte b) {
            this();
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (ClickableViewPager.this.onItemClickListener != null) {
                OnItemClickListener onItemClickListener = ClickableViewPager.this.onItemClickListener;
                ClickableViewPager.this.getCurrentItem();
                return true;
            }
            return true;
        }
    }
}
