package com.wajahatkarim3.easyflipview;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* loaded from: classes8.dex */
public class EasyFlipView extends FrameLayout {
    public static final int DEFAULT_FLIP_DURATION = 400;
    public static final String TAG = "EasyFlipView";
    private int animFlipHorizontalInId;
    private int animFlipHorizontalOutId;
    private int animFlipVerticalInId;
    private int animFlipVerticalOutId;
    private Context context;
    private int flipDuration;
    private boolean flipEnabled;
    private boolean flipOnTouch;
    private int flipType;
    private View mCardBackLayout;
    private View mCardFrontLayout;
    private FlipState mFlipState;
    private boolean mIsBackVisible;
    private AnimatorSet mSetBottomIn;
    private AnimatorSet mSetLeftIn;
    private AnimatorSet mSetRightOut;
    private AnimatorSet mSetTopOut;
    private OnFlipAnimationListener onFlipListener;
    private float x1;
    private float y1;

    /* loaded from: classes8.dex */
    public enum FlipState {
        FRONT_SIDE,
        BACK_SIDE
    }

    /* loaded from: classes8.dex */
    public static class FlipType {
        public static int HORIZONTAL = 0;
        public static int VERTICAL = 1;
    }

    /* loaded from: classes8.dex */
    public interface OnFlipAnimationListener {
        void onViewFlipCompleted(EasyFlipView easyFlipView, FlipState flipState);
    }

    public EasyFlipView(Context context) {
        super(context);
        this.animFlipHorizontalOutId = R.animator.animation_horizontal_flip_out;
        this.animFlipHorizontalInId = R.animator.animation_horizontal_flip_in;
        this.animFlipVerticalOutId = R.animator.animation_vertical_flip_out;
        this.animFlipVerticalInId = R.animator.animation_vertical_flip_in;
        this.mIsBackVisible = false;
        this.flipType = FlipType.VERTICAL;
        this.mFlipState = FlipState.FRONT_SIDE;
        this.onFlipListener = null;
        this.context = context;
        init(context, null);
    }

    public EasyFlipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.animFlipHorizontalOutId = R.animator.animation_horizontal_flip_out;
        this.animFlipHorizontalInId = R.animator.animation_horizontal_flip_in;
        this.animFlipVerticalOutId = R.animator.animation_vertical_flip_out;
        this.animFlipVerticalInId = R.animator.animation_vertical_flip_in;
        this.mIsBackVisible = false;
        this.flipType = FlipType.VERTICAL;
        this.mFlipState = FlipState.FRONT_SIDE;
        this.onFlipListener = null;
        this.context = context;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.flipOnTouch = true;
        this.flipDuration = 400;
        this.flipEnabled = true;
        this.flipType = FlipType.VERTICAL;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.easy_flip_view, 0, 0);
            try {
                this.flipOnTouch = obtainStyledAttributes.getBoolean(R.styleable.easy_flip_view_flipOnTouch, true);
                this.flipDuration = obtainStyledAttributes.getInt(R.styleable.easy_flip_view_flipDuration, 400);
                this.flipEnabled = obtainStyledAttributes.getBoolean(R.styleable.easy_flip_view_flipEnabled, true);
                this.flipType = obtainStyledAttributes.getInt(R.styleable.easy_flip_view_flipType, FlipType.HORIZONTAL);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        loadAnimations();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() > 2) {
            throw new IllegalStateException("EasyFlipView can host only two direct children!");
        }
        findViews();
        changeCameraDistance();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() == 2) {
            throw new IllegalStateException("EasyFlipView can host only two direct children!");
        }
        super.addView(view, i, layoutParams);
        findViews();
        changeCameraDistance();
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        super.removeView(view);
        findViews();
    }

    @Override // android.view.ViewGroup
    public void removeAllViewsInLayout() {
        super.removeAllViewsInLayout();
        this.mFlipState = FlipState.FRONT_SIDE;
        findViews();
    }

    private void findViews() {
        this.mCardBackLayout = null;
        this.mCardFrontLayout = null;
        int childCount = getChildCount();
        if (childCount <= 0) {
            return;
        }
        if (childCount < 2) {
            this.mFlipState = FlipState.FRONT_SIDE;
            this.mCardFrontLayout = getChildAt(0);
        } else if (childCount == 2) {
            this.mCardFrontLayout = getChildAt(1);
            this.mCardBackLayout = getChildAt(0);
        }
        if (isFlipOnTouch()) {
            return;
        }
        this.mCardFrontLayout.setVisibility(0);
        View view = this.mCardBackLayout;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    private void loadAnimations() {
        if (this.flipType == FlipType.HORIZONTAL) {
            this.mSetRightOut = (AnimatorSet) AnimatorInflater.loadAnimator(this.context, this.animFlipHorizontalOutId);
            AnimatorSet animatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(this.context, this.animFlipHorizontalInId);
            this.mSetLeftIn = animatorSet;
            AnimatorSet animatorSet2 = this.mSetRightOut;
            if (animatorSet2 == null || animatorSet == null) {
                throw new RuntimeException("No Animations Found! Please set Flip in and Flip out animation Ids.");
            }
            animatorSet2.removeAllListeners();
            this.mSetRightOut.addListener(new Animator.AnimatorListener() { // from class: com.wajahatkarim3.easyflipview.EasyFlipView.1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (EasyFlipView.this.mFlipState == FlipState.FRONT_SIDE) {
                        EasyFlipView.this.mCardBackLayout.setVisibility(8);
                        EasyFlipView.this.mCardFrontLayout.setVisibility(0);
                        if (EasyFlipView.this.onFlipListener != null) {
                            EasyFlipView.this.onFlipListener.onViewFlipCompleted(EasyFlipView.this, FlipState.FRONT_SIDE);
                            return;
                        }
                        return;
                    }
                    EasyFlipView.this.mCardBackLayout.setVisibility(0);
                    EasyFlipView.this.mCardFrontLayout.setVisibility(8);
                    if (EasyFlipView.this.onFlipListener != null) {
                        EasyFlipView.this.onFlipListener.onViewFlipCompleted(EasyFlipView.this, FlipState.BACK_SIDE);
                    }
                }
            });
            setFlipDuration(this.flipDuration);
            return;
        }
        this.mSetTopOut = (AnimatorSet) AnimatorInflater.loadAnimator(this.context, this.animFlipVerticalOutId);
        AnimatorSet animatorSet3 = (AnimatorSet) AnimatorInflater.loadAnimator(this.context, this.animFlipVerticalInId);
        this.mSetBottomIn = animatorSet3;
        AnimatorSet animatorSet4 = this.mSetTopOut;
        if (animatorSet4 == null || animatorSet3 == null) {
            throw new RuntimeException("No Animations Found! Please set Flip in and Flip out animation Ids.");
        }
        animatorSet4.removeAllListeners();
        this.mSetTopOut.addListener(new Animator.AnimatorListener() { // from class: com.wajahatkarim3.easyflipview.EasyFlipView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (EasyFlipView.this.mFlipState == FlipState.FRONT_SIDE) {
                    EasyFlipView.this.mCardBackLayout.setVisibility(8);
                    EasyFlipView.this.mCardFrontLayout.setVisibility(0);
                    if (EasyFlipView.this.onFlipListener != null) {
                        EasyFlipView.this.onFlipListener.onViewFlipCompleted(EasyFlipView.this, FlipState.FRONT_SIDE);
                        return;
                    }
                    return;
                }
                EasyFlipView.this.mCardBackLayout.setVisibility(0);
                EasyFlipView.this.mCardFrontLayout.setVisibility(8);
                if (EasyFlipView.this.onFlipListener != null) {
                    EasyFlipView.this.onFlipListener.onViewFlipCompleted(EasyFlipView.this, FlipState.BACK_SIDE);
                }
            }
        });
        setFlipDuration(this.flipDuration);
    }

    private void changeCameraDistance() {
        float f = getResources().getDisplayMetrics().density * 8000.0f;
        View view = this.mCardFrontLayout;
        if (view != null) {
            view.setCameraDistance(f);
        }
        View view2 = this.mCardBackLayout;
        if (view2 != null) {
            view2.setCameraDistance(f);
        }
    }

    public void flipTheView() {
        if (!this.flipEnabled || getChildCount() < 2) {
            return;
        }
        if (this.flipType == FlipType.HORIZONTAL) {
            if (this.mSetRightOut.isRunning() || this.mSetLeftIn.isRunning()) {
                return;
            }
            this.mCardBackLayout.setVisibility(0);
            this.mCardFrontLayout.setVisibility(0);
            if (this.mFlipState == FlipState.FRONT_SIDE) {
                this.mSetRightOut.setTarget(this.mCardFrontLayout);
                this.mSetLeftIn.setTarget(this.mCardBackLayout);
                this.mSetRightOut.start();
                this.mSetLeftIn.start();
                this.mIsBackVisible = true;
                this.mFlipState = FlipState.BACK_SIDE;
                return;
            }
            this.mSetRightOut.setTarget(this.mCardBackLayout);
            this.mSetLeftIn.setTarget(this.mCardFrontLayout);
            this.mSetRightOut.start();
            this.mSetLeftIn.start();
            this.mIsBackVisible = false;
            this.mFlipState = FlipState.FRONT_SIDE;
        } else if (this.mSetTopOut.isRunning() || this.mSetBottomIn.isRunning()) {
        } else {
            this.mCardBackLayout.setVisibility(0);
            this.mCardFrontLayout.setVisibility(0);
            if (this.mFlipState == FlipState.FRONT_SIDE) {
                this.mSetTopOut.setTarget(this.mCardFrontLayout);
                this.mSetBottomIn.setTarget(this.mCardBackLayout);
                this.mSetTopOut.start();
                this.mSetBottomIn.start();
                this.mIsBackVisible = true;
                this.mFlipState = FlipState.BACK_SIDE;
                return;
            }
            this.mSetTopOut.setTarget(this.mCardBackLayout);
            this.mSetBottomIn.setTarget(this.mCardFrontLayout);
            this.mSetTopOut.start();
            this.mSetBottomIn.start();
            this.mIsBackVisible = false;
            this.mFlipState = FlipState.FRONT_SIDE;
        }
    }

    public void flipTheView(boolean z) {
        if (getChildCount() < 2) {
            return;
        }
        if (this.flipType == FlipType.HORIZONTAL) {
            if (!z) {
                this.mSetLeftIn.setDuration(0L);
                this.mSetRightOut.setDuration(0L);
                boolean z2 = this.flipEnabled;
                this.flipEnabled = true;
                flipTheView();
                this.mSetLeftIn.setDuration(this.flipDuration);
                this.mSetRightOut.setDuration(this.flipDuration);
                this.flipEnabled = z2;
                return;
            }
            flipTheView();
        } else if (!z) {
            this.mSetBottomIn.setDuration(0L);
            this.mSetTopOut.setDuration(0L);
            boolean z3 = this.flipEnabled;
            this.flipEnabled = true;
            flipTheView();
            this.mSetBottomIn.setDuration(this.flipDuration);
            this.mSetTopOut.setDuration(this.flipDuration);
            this.flipEnabled = z3;
        } else {
            flipTheView();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled() && this.flipOnTouch) {
            getParent().requestDisallowInterceptTouchEvent(true);
            int action = motionEvent.getAction();
            if (action == 0) {
                this.x1 = motionEvent.getX();
                this.y1 = motionEvent.getY();
                return true;
            } else if (action == 1) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                float f = x - this.x1;
                float f2 = y - this.y1;
                if (f >= 0.0f && f < 0.5f && f2 >= 0.0f && f2 < 0.5f) {
                    flipTheView();
                }
                return true;
            } else {
                return super.onTouchEvent(motionEvent);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean isFlipOnTouch() {
        return this.flipOnTouch;
    }

    public void setFlipOnTouch(boolean z) {
        this.flipOnTouch = z;
    }

    public int getFlipDuration() {
        return this.flipDuration;
    }

    public void setFlipDuration(int i) {
        this.flipDuration = i;
        if (this.flipType == FlipType.HORIZONTAL) {
            long j = i;
            this.mSetRightOut.getChildAnimations().get(0).setDuration(j);
            long j2 = i / 2;
            this.mSetRightOut.getChildAnimations().get(1).setStartDelay(j2);
            this.mSetLeftIn.getChildAnimations().get(1).setDuration(j);
            this.mSetLeftIn.getChildAnimations().get(2).setStartDelay(j2);
            return;
        }
        long j3 = i;
        this.mSetTopOut.getChildAnimations().get(0).setDuration(j3);
        long j4 = i / 2;
        this.mSetTopOut.getChildAnimations().get(1).setStartDelay(j4);
        this.mSetBottomIn.getChildAnimations().get(1).setDuration(j3);
        this.mSetBottomIn.getChildAnimations().get(2).setStartDelay(j4);
    }

    public boolean isFlipEnabled() {
        return this.flipEnabled;
    }

    public void setFlipEnabled(boolean z) {
        this.flipEnabled = z;
    }

    public FlipState getCurrentFlipState() {
        return this.mFlipState;
    }

    public boolean isFrontSide() {
        return this.mFlipState == FlipState.FRONT_SIDE;
    }

    public boolean isBackSide() {
        return this.mFlipState == FlipState.BACK_SIDE;
    }

    public OnFlipAnimationListener getOnFlipListener() {
        return this.onFlipListener;
    }

    public void setOnFlipListener(OnFlipAnimationListener onFlipAnimationListener) {
        this.onFlipListener = onFlipAnimationListener;
    }

    public boolean isHorizontalType() {
        return this.flipType == FlipType.HORIZONTAL;
    }

    public boolean isVerticalType() {
        return this.flipType == FlipType.VERTICAL;
    }

    public void setToHorizontalType() {
        this.flipType = FlipType.HORIZONTAL;
    }

    public void setToVerticalType() {
        this.flipType = FlipType.VERTICAL;
    }
}
