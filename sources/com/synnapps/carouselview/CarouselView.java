package com.synnapps.carouselview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RemoteViews;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import java.util.Timer;
import java.util.TimerTask;

@RemoteViews.RemoteView
/* loaded from: classes8.dex */
public class CarouselView extends FrameLayout {
    public static final int DEFAULT_INDICATOR_VISIBILITY = 0;
    private static final int DEFAULT_SLIDE_INTERVAL = 3500;
    private static final int DEFAULT_SLIDE_VELOCITY = 400;
    private final int DEFAULT_GRAVITY;
    private boolean animateOnBoundary;
    private boolean autoPlay;
    ViewPager.OnPageChangeListener carouselOnPageChangeListener;
    private CarouselViewPager containerViewPager;
    private boolean disableAutoPlayOnUserInteraction;
    private ImageClickListener imageClickListener;
    private int indicatorMarginHorizontal;
    private int indicatorMarginVertical;
    private int indicatorVisibility;
    private ImageListener mImageListener;
    private CirclePageIndicator mIndicator;
    private int mIndicatorGravity;
    private int mPageCount;
    private ViewListener mViewListener;
    private int pageTransformInterval;
    private ViewPager.PageTransformer pageTransformer;
    private int previousState;
    private int slideInterval;
    private SwipeTask swipeTask;
    private Timer swipeTimer;

    public CarouselView(Context context) {
        super(context);
        this.DEFAULT_GRAVITY = 81;
        this.slideInterval = 3500;
        this.mIndicatorGravity = 81;
        this.pageTransformInterval = 400;
        this.indicatorVisibility = 0;
        this.mViewListener = null;
        this.mImageListener = null;
        this.imageClickListener = null;
        this.animateOnBoundary = true;
        this.carouselOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.synnapps.carouselview.CarouselView.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (CarouselView.this.previousState != 1 || i != 2) {
                    int unused = CarouselView.this.previousState;
                } else if (CarouselView.this.disableAutoPlayOnUserInteraction) {
                    CarouselView.this.pauseCarousel();
                } else {
                    CarouselView.this.playCarousel();
                }
                CarouselView.this.previousState = i;
            }
        };
    }

    public CarouselView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.DEFAULT_GRAVITY = 81;
        this.slideInterval = 3500;
        this.mIndicatorGravity = 81;
        this.pageTransformInterval = 400;
        this.indicatorVisibility = 0;
        this.mViewListener = null;
        this.mImageListener = null;
        this.imageClickListener = null;
        this.animateOnBoundary = true;
        this.carouselOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.synnapps.carouselview.CarouselView.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (CarouselView.this.previousState != 1 || i != 2) {
                    int unused = CarouselView.this.previousState;
                } else if (CarouselView.this.disableAutoPlayOnUserInteraction) {
                    CarouselView.this.pauseCarousel();
                } else {
                    CarouselView.this.playCarousel();
                }
                CarouselView.this.previousState = i;
            }
        };
        initView(context, attributeSet, 0, 0);
    }

    public CarouselView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.DEFAULT_GRAVITY = 81;
        this.slideInterval = 3500;
        this.mIndicatorGravity = 81;
        this.pageTransformInterval = 400;
        this.indicatorVisibility = 0;
        this.mViewListener = null;
        this.mImageListener = null;
        this.imageClickListener = null;
        this.animateOnBoundary = true;
        this.carouselOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.synnapps.carouselview.CarouselView.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i22) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                if (CarouselView.this.previousState != 1 || i2 != 2) {
                    int unused = CarouselView.this.previousState;
                } else if (CarouselView.this.disableAutoPlayOnUserInteraction) {
                    CarouselView.this.pauseCarousel();
                } else {
                    CarouselView.this.playCarousel();
                }
                CarouselView.this.previousState = i2;
            }
        };
        initView(context, attributeSet, i, 0);
    }

    public CarouselView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.DEFAULT_GRAVITY = 81;
        this.slideInterval = 3500;
        this.mIndicatorGravity = 81;
        this.pageTransformInterval = 400;
        this.indicatorVisibility = 0;
        this.mViewListener = null;
        this.mImageListener = null;
        this.imageClickListener = null;
        this.animateOnBoundary = true;
        this.carouselOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.synnapps.carouselview.CarouselView.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i22, float f, int i222) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i22) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i22) {
                if (CarouselView.this.previousState != 1 || i22 != 2) {
                    int unused = CarouselView.this.previousState;
                } else if (CarouselView.this.disableAutoPlayOnUserInteraction) {
                    CarouselView.this.pauseCarousel();
                } else {
                    CarouselView.this.playCarousel();
                }
                CarouselView.this.previousState = i22;
            }
        };
        initView(context, attributeSet, i, i2);
    }

    private void initView(Context context, AttributeSet attributeSet, int i, int i2) {
        if (isInEditMode()) {
            return;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.view_carousel, (ViewGroup) this, true);
        this.containerViewPager = (CarouselViewPager) inflate.findViewById(R.id.containerViewPager);
        this.mIndicator = (CirclePageIndicator) inflate.findViewById(R.id.indicator);
        this.containerViewPager.addOnPageChangeListener(this.carouselOnPageChangeListener);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CarouselView, i, 0);
        try {
            this.indicatorMarginVertical = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CarouselView_indicatorMarginVertical, getResources().getDimensionPixelSize(R.dimen.default_indicator_margin_vertical));
            this.indicatorMarginHorizontal = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CarouselView_indicatorMarginHorizontal, getResources().getDimensionPixelSize(R.dimen.default_indicator_margin_horizontal));
            setPageTransformInterval(obtainStyledAttributes.getInt(R.styleable.CarouselView_pageTransformInterval, 400));
            setSlideInterval(obtainStyledAttributes.getInt(R.styleable.CarouselView_slideInterval, 3500));
            setOrientation(obtainStyledAttributes.getInt(R.styleable.CarouselView_indicatorOrientation, 0));
            setIndicatorGravity(obtainStyledAttributes.getInt(R.styleable.CarouselView_indicatorGravity, 81));
            setAutoPlay(obtainStyledAttributes.getBoolean(R.styleable.CarouselView_autoPlay, true));
            setDisableAutoPlayOnUserInteraction(obtainStyledAttributes.getBoolean(R.styleable.CarouselView_disableAutoPlayOnUserInteraction, false));
            setAnimateOnBoundary(obtainStyledAttributes.getBoolean(R.styleable.CarouselView_animateOnBoundary, true));
            setPageTransformer(obtainStyledAttributes.getInt(R.styleable.CarouselView_pageTransformer, -1));
            int i3 = obtainStyledAttributes.getInt(R.styleable.CarouselView_indicatorVisibility, 0);
            this.indicatorVisibility = i3;
            setIndicatorVisibility(i3);
            if (this.indicatorVisibility == 0) {
                int color = obtainStyledAttributes.getColor(R.styleable.CarouselView_fillColor, 0);
                if (color != 0) {
                    setFillColor(color);
                }
                int color2 = obtainStyledAttributes.getColor(R.styleable.CarouselView_pageColor, 0);
                if (color2 != 0) {
                    setPageColor(color2);
                }
                float dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CarouselView_radius, 0);
                if (dimensionPixelSize != 0.0f) {
                    setRadius(dimensionPixelSize);
                }
                setSnap(obtainStyledAttributes.getBoolean(R.styleable.CarouselView_snap, getResources().getBoolean(R.bool.default_circle_indicator_snap)));
                int color3 = obtainStyledAttributes.getColor(R.styleable.CarouselView_strokeColor, 0);
                if (color3 != 0) {
                    setStrokeColor(color3);
                }
                float dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CarouselView_strokeWidth, 0);
                if (dimensionPixelSize2 != 0.0f) {
                    setStrokeWidth(dimensionPixelSize2);
                }
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.swipeTimer.cancel();
    }

    public int getSlideInterval() {
        return this.slideInterval;
    }

    public void setSlideInterval(int i) {
        this.slideInterval = i;
        if (this.containerViewPager != null) {
            playCarousel();
        }
    }

    public void reSetSlideInterval(int i) {
        setSlideInterval(i);
        if (this.containerViewPager != null) {
            playCarousel();
        }
    }

    public void setPageTransformInterval(int i) {
        if (i > 0) {
            this.pageTransformInterval = i;
        } else {
            this.pageTransformInterval = 400;
        }
        this.containerViewPager.setTransitionVelocity(i);
    }

    public ViewPager.PageTransformer getPageTransformer() {
        return this.pageTransformer;
    }

    public void setPageTransformer(ViewPager.PageTransformer pageTransformer) {
        this.pageTransformer = pageTransformer;
        this.containerViewPager.setPageTransformer(true, pageTransformer);
    }

    public void setPageTransformer(int i) {
        setPageTransformer(new CarouselViewPagerTransformer(i));
    }

    public void setAnimateOnBoundary(boolean z) {
        this.animateOnBoundary = z;
    }

    public boolean isAutoPlay() {
        return this.autoPlay;
    }

    private void setAutoPlay(boolean z) {
        this.autoPlay = z;
    }

    public boolean isDisableAutoPlayOnUserInteraction() {
        return this.disableAutoPlayOnUserInteraction;
    }

    private void setDisableAutoPlayOnUserInteraction(boolean z) {
        this.disableAutoPlayOnUserInteraction = z;
    }

    private void setData() {
        this.containerViewPager.setAdapter(new CarouselPagerAdapter(getContext()));
        this.mIndicator.setViewPager(this.containerViewPager);
        this.mIndicator.requestLayout();
        this.mIndicator.invalidate();
        this.containerViewPager.setOffscreenPageLimit(getPageCount());
        playCarousel();
    }

    private void stopScrollTimer() {
        Timer timer = this.swipeTimer;
        if (timer != null) {
            timer.cancel();
        }
        SwipeTask swipeTask = this.swipeTask;
        if (swipeTask != null) {
            swipeTask.cancel();
        }
    }

    private void resetScrollTimer() {
        stopScrollTimer();
        this.swipeTask = new SwipeTask();
        this.swipeTimer = new Timer();
    }

    public void playCarousel() {
        resetScrollTimer();
        if (!this.autoPlay || this.slideInterval <= 0 || this.containerViewPager.getAdapter() == null || this.containerViewPager.getAdapter().getCount() <= 1) {
            return;
        }
        Timer timer = this.swipeTimer;
        SwipeTask swipeTask = this.swipeTask;
        long j = this.slideInterval;
        timer.schedule(swipeTask, j, j);
    }

    public void pauseCarousel() {
        resetScrollTimer();
    }

    public void stopCarousel() {
        this.autoPlay = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public class CarouselPagerAdapter extends PagerAdapter {
        private Context mContext;

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        public CarouselPagerAdapter(Context context) {
            this.mContext = context;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            if (CarouselView.this.mImageListener == null) {
                if (CarouselView.this.mViewListener != null) {
                    View viewForPosition = CarouselView.this.mViewListener.setViewForPosition(i);
                    if (viewForPosition != null) {
                        viewGroup.addView(viewForPosition);
                        return viewForPosition;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("View can not be null for position ");
                    sb.append(i);
                    throw new RuntimeException(sb.toString());
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("View must set ");
                sb2.append("ImageListener");
                sb2.append(" or ");
                sb2.append("ViewListener");
                sb2.append(".");
                throw new RuntimeException(sb2.toString());
            }
            ImageView imageView = new ImageView(this.mContext);
            imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            CarouselView.this.mImageListener.setImageForPosition(i, imageView);
            viewGroup.addView(imageView);
            return imageView;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return CarouselView.this.getPageCount();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public class SwipeTask extends TimerTask {
        private SwipeTask() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            CarouselView.this.containerViewPager.post(new Runnable() { // from class: com.synnapps.carouselview.CarouselView.SwipeTask.1
                @Override // java.lang.Runnable
                public void run() {
                    boolean z = true;
                    int currentItem = (CarouselView.this.containerViewPager.getCurrentItem() + 1) % CarouselView.this.getPageCount();
                    CarouselViewPager carouselViewPager = CarouselView.this.containerViewPager;
                    if (currentItem == 0 && !CarouselView.this.animateOnBoundary) {
                        z = false;
                    }
                    carouselViewPager.setCurrentItem(currentItem, z);
                }
            });
        }
    }

    public void setImageListener(ImageListener imageListener) {
        this.mImageListener = imageListener;
    }

    public void setViewListener(ViewListener viewListener) {
        this.mViewListener = viewListener;
    }

    public void setImageClickListener(ImageClickListener imageClickListener) {
        this.imageClickListener = imageClickListener;
        this.containerViewPager.setImageClickListener(imageClickListener);
    }

    public int getPageCount() {
        return this.mPageCount;
    }

    public void setPageCount(int i) {
        this.mPageCount = i;
        setData();
    }

    public void addOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.containerViewPager.addOnPageChangeListener(onPageChangeListener);
    }

    public void clearOnPageChangeListeners() {
        this.containerViewPager.clearOnPageChangeListeners();
    }

    public void setCurrentItem(int i) {
        this.containerViewPager.setCurrentItem(i);
    }

    public int getCurrentItem() {
        return this.containerViewPager.getCurrentItem();
    }

    public int getIndicatorMarginVertical() {
        return this.indicatorMarginVertical;
    }

    public void setIndicatorMarginVertical(int i) {
        this.indicatorMarginVertical = i;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        layoutParams.topMargin = this.indicatorMarginVertical;
        layoutParams.bottomMargin = this.indicatorMarginVertical;
    }

    public int getIndicatorMarginHorizontal() {
        return this.indicatorMarginHorizontal;
    }

    public void setIndicatorMarginHorizontal(int i) {
        this.indicatorMarginHorizontal = i;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        layoutParams.leftMargin = this.indicatorMarginHorizontal;
        layoutParams.rightMargin = this.indicatorMarginHorizontal;
    }

    public int getIndicatorGravity() {
        return this.mIndicatorGravity;
    }

    public void setIndicatorGravity(int i) {
        this.mIndicatorGravity = i;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = this.mIndicatorGravity;
        int i2 = this.indicatorMarginHorizontal;
        int i3 = this.indicatorMarginVertical;
        layoutParams.setMargins(i2, i3, i2, i3);
        this.mIndicator.setLayoutParams(layoutParams);
    }

    public void setIndicatorVisibility(int i) {
        this.mIndicator.setVisibility(i);
    }

    public int getOrientation() {
        return this.mIndicator.getOrientation();
    }

    public int getFillColor() {
        return this.mIndicator.getFillColor();
    }

    public int getStrokeColor() {
        return this.mIndicator.getStrokeColor();
    }

    public void setSnap(boolean z) {
        this.mIndicator.setSnap(z);
    }

    public void setRadius(float f) {
        this.mIndicator.setRadius(f);
    }

    public float getStrokeWidth() {
        return this.mIndicator.getStrokeWidth();
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        super.setBackground(drawable);
    }

    public Drawable getIndicatorBackground() {
        return this.mIndicator.getBackground();
    }

    public void setFillColor(int i) {
        this.mIndicator.setFillColor(i);
    }

    public int getPageColor() {
        return this.mIndicator.getPageColor();
    }

    public void setOrientation(int i) {
        this.mIndicator.setOrientation(i);
    }

    public boolean isSnap() {
        return this.mIndicator.isSnap();
    }

    public void setStrokeColor(int i) {
        this.mIndicator.setStrokeColor(i);
    }

    public float getRadius() {
        return this.mIndicator.getRadius();
    }

    public void setPageColor(int i) {
        this.mIndicator.setPageColor(i);
    }

    public void setStrokeWidth(float f) {
        this.mIndicator.setStrokeWidth(f);
        int i = (int) f;
        this.mIndicator.setPadding(i, i, i, i);
    }
}
