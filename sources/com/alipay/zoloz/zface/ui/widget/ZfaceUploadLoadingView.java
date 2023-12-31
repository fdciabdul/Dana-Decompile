package com.alipay.zoloz.zface.ui.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alipay.mobile.security.bio.utils.StringUtil;
import com.alipay.zoloz.toyger.R;
import com.alipay.zoloz.toyger.R2;
import zoloz.ap.com.toolkit.ui.DialogCallback;

/* loaded from: classes7.dex */
public class ZfaceUploadLoadingView extends RelativeLayout {
    private static final int COUNT_TIME_OUT = 15;
    private DialogCallback mCallback;
    Context mContext;
    private Handler mHandler;
    private boolean mIsShowProcess;
    private Handler mMainHandler;
    TextView mProcessTextView;
    RelativeLayout mRootView;
    UploadProgressBar mUploadProgressBar;
    ValueAnimator mValueAnimator;
    private int processsAngle;

    public void stopProcess() {
    }

    public ZfaceUploadLoadingView(Context context) {
        super(context);
        this.processsAngle = 180;
        this.mValueAnimator = null;
        this.mHandler = new Handler();
        this.mContext = context;
        initViews();
    }

    public ZfaceUploadLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.processsAngle = 180;
        this.mValueAnimator = null;
        this.mHandler = new Handler();
        this.mContext = context;
        initViews();
    }

    public ZfaceUploadLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.processsAngle = 180;
        this.mValueAnimator = null;
        this.mHandler = new Handler();
        this.mContext = context;
        initViews();
    }

    public void initViews() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.zface_upload_loading, (ViewGroup) this, true);
        this.mRootView = (RelativeLayout) inflate.findViewById(R.id.zface_upload_loading_root_view);
        this.mMainHandler = new Handler(Looper.getMainLooper());
        this.mUploadProgressBar = (UploadProgressBar) inflate.findViewById(R.id.zface_upload_loading_progress);
        this.mProcessTextView = (TextView) inflate.findViewById(R.id.zface_upload_loading_process_text);
    }

    public void startProcess() {
        this.mProcessTextView.setText(R2.string.zface_processing());
        intervalAction();
    }

    public void setCallback(DialogCallback dialogCallback) {
        this.mCallback = dialogCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void intervalAction() {
        this.mMainHandler.postDelayed(new Runnable() { // from class: com.alipay.zoloz.zface.ui.widget.ZfaceUploadLoadingView.1
            @Override // java.lang.Runnable
            public void run() {
                if (ZfaceUploadLoadingView.this.mContext != null) {
                    ZfaceUploadLoadingView.this.intervalAction();
                    ZfaceUploadLoadingView.this.mIsShowProcess = false;
                }
            }
        }, 1000L);
        if (this.mIsShowProcess) {
            return;
        }
        this.mIsShowProcess = true;
        ValueAnimator valueAnimator = this.mValueAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 30);
        this.mValueAnimator = ofInt;
        ofInt.setDuration(1000L);
        this.mValueAnimator.setInterpolator(new LinearInterpolator());
        this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.alipay.zoloz.zface.ui.widget.ZfaceUploadLoadingView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                StringBuilder sb = new StringBuilder();
                sb.append(ZfaceUploadLoadingView.this.mValueAnimator.getAnimatedValue());
                int parseInt = Integer.parseInt(sb.toString());
                ZfaceUploadLoadingView.this.processsAngle += 4;
                ZfaceUploadLoadingView.this.mUploadProgressBar.setProgressAngle(ZfaceUploadLoadingView.this.processsAngle);
                if (30 == parseInt) {
                    ZfaceUploadLoadingView.this.mValueAnimator.cancel();
                    ZfaceUploadLoadingView.this.mValueAnimator = null;
                }
            }
        });
        this.mValueAnimator.start();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.mRootView.setBackgroundColor(i);
    }

    private String getString(String str, String str2) {
        return StringUtil.isNullorEmpty(str) ? str2 : str;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startProcess();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopProcess();
        this.mContext = null;
    }
}
