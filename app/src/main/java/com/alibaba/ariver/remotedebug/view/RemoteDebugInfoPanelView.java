package com.alibaba.ariver.remotedebug.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alibaba.ariver.kernel.common.utils.DimensionUtil;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.remotedebug.R;

/* loaded from: classes6.dex */
public class RemoteDebugInfoPanelView extends LinearLayout implements IDebugInfoPanelView {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f6192a;
    private TextView b;
    private TextView c;
    private ActionEventListener d;
    private float e;
    private float f;
    private float g;
    private float h;
    private int i;
    private int j;
    private int k;
    private int l;

    @Override // com.alibaba.ariver.remotedebug.view.IDebugInfoPanelView
    public View getView() {
        return this;
    }

    public RemoteDebugInfoPanelView(Context context) {
        super(context);
        a();
    }

    private void a() {
        Context context = getContext();
        ImageView imageView = new ImageView(context);
        this.f6192a = imageView;
        imageView.setBackgroundColor(-16711936);
        int density = (int) (DimensionUtil.getDensity(context) * 4.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(density, density);
        layoutParams.gravity = 16;
        layoutParams.setMargins(25, 0, 25, 0);
        this.f6192a.setLayoutParams(layoutParams);
        TextView textView = new TextView(context);
        this.b = textView;
        textView.setMinWidth((int) (DimensionUtil.getDensity(context) * 100.0f));
        this.b.setTextColor(-1);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.setMargins(0, 0, 25, 0);
        this.b.setLayoutParams(layoutParams2);
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.ariver.remotedebug.view.RemoteDebugInfoPanelView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        TextView textView2 = new TextView(context);
        this.c = textView2;
        textView2.setTextColor(-1);
        this.c.setText(R.string.remote_debug_exit);
        this.c.setPadding(0, 25, 25, 25);
        this.c.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.ariver.remotedebug.view.RemoteDebugInfoPanelView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RemoteDebugInfoPanelView.this.d != null) {
                    RemoteDebugInfoPanelView.this.d.exitRemoteDebug();
                }
            }
        });
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 16;
        this.c.setLayoutParams(layoutParams3);
        addView(this.f6192a);
        addView(this.b);
        addView(this.c);
        setOrientation(0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#CC606066"));
        gradientDrawable.setCornerRadius(18.0f);
        setBackgroundDrawable(gradientDrawable);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.g = motionEvent.getX();
            this.h = motionEvent.getY();
        } else if (action == 1) {
            if (Math.abs(this.e) <= 3.0f && Math.abs(this.f) <= 3.0f) {
                this.h = 0.0f;
                this.g = 0.0f;
                return super.onTouchEvent(motionEvent);
            }
            b();
            this.h = 0.0f;
            this.g = 0.0f;
            return true;
        } else if (action == 2) {
            this.e = motionEvent.getX() - this.g;
            this.f = motionEvent.getY() - this.h;
            b();
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.alibaba.ariver.remotedebug.view.IDebugInfoPanelView
    public void setMoveRange(int i, int i2, int i3, int i4) {
        this.i = i;
        this.j = i2;
        this.k = i3;
        this.l = i4;
    }

    @Override // com.alibaba.ariver.remotedebug.view.IDebugInfoPanelView
    public void setShown(boolean z) {
        setVisibility(z ? 0 : 8);
    }

    private void b() {
        try {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
            float x = getX() + this.e;
            float y = getY() + this.f;
            layoutParams.topMargin = (int) (layoutParams.topMargin + this.f);
            int i = this.k;
            int i2 = this.i;
            int i3 = i - i2;
            float f = i2;
            if (x <= f) {
                setX(f);
            } else if (getWidth() + x > i3) {
                setX(i3 - getWidth());
            } else {
                setX(x);
            }
            int i4 = this.l;
            int i5 = this.j;
            int i6 = i4 - i5;
            float f2 = i5;
            if (y < f2) {
                setY(f2);
            } else if (getHeight() + y > i6) {
                setY(i6 - getHeight());
            } else {
                setY(y);
            }
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("updateViewPosition...e=");
            sb.append(th);
            RVLogger.e("RemoteDebugInfoPanelView", sb.toString());
        }
    }

    @Override // com.alibaba.ariver.remotedebug.view.IDebugInfoPanelView
    public void setActionEventListener(ActionEventListener actionEventListener) {
        this.d = actionEventListener;
    }

    @Override // com.alibaba.ariver.remotedebug.view.IDebugInfoPanelView
    public void setStateConnecting() {
        this.f6192a.setBackgroundColor(-7829368);
        this.b.setText(R.string.tiny_remote_debug_connecting);
    }

    @Override // com.alibaba.ariver.remotedebug.view.IDebugInfoPanelView
    public void setStateConnected() {
        this.f6192a.setBackgroundColor(-16711936);
        this.b.setText(R.string.tiny_remote_debug_connected);
    }

    @Override // com.alibaba.ariver.remotedebug.view.IDebugInfoPanelView
    public void setStateConnectFailed() {
        this.f6192a.setBackgroundColor(-65536);
        this.b.setText(R.string.tiny_remote_debug_disconnected);
    }

    @Override // com.alibaba.ariver.remotedebug.view.IDebugInfoPanelView
    public void setStateText(String str) {
        this.b.setText(str);
    }

    @Override // com.alibaba.ariver.remotedebug.view.IDebugInfoPanelView
    public void setExitText(String str) {
        this.c.setText(str);
    }
}
