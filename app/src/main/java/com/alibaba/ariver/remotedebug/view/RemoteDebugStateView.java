package com.alibaba.ariver.remotedebug.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alibaba.ariver.remotedebug.R;

/* loaded from: classes6.dex */
public class RemoteDebugStateView extends FrameLayout implements IDebugStateView {

    /* renamed from: a  reason: collision with root package name */
    private TextView f6193a;
    private ActionEventListener b;
    private TextView c;

    @Override // com.alibaba.ariver.remotedebug.view.IDebugStateView
    public View getView() {
        return this;
    }

    public RemoteDebugStateView(Context context) {
        super(context);
        a();
    }

    private void a() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.setMargins(0, 0, 0, 30);
        TextView textView = new TextView(getContext());
        this.f6193a = textView;
        textView.setTextSize(18.0f);
        this.f6193a.setTextColor(-1);
        this.f6193a.setBackgroundColor(0);
        this.f6193a.setLayoutParams(layoutParams);
        TextView textView2 = new TextView(getContext());
        this.c = textView2;
        textView2.setText(R.string.remote_debug_exit);
        textView2.setTextSize(15.0f);
        textView2.setTextColor(-1);
        textView2.setPadding(25, 8, 25, 8);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(0);
        gradientDrawable.setCornerRadius(3.0f);
        gradientDrawable.setStroke(3, -1);
        textView2.setBackgroundDrawable(gradientDrawable);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.ariver.remotedebug.view.RemoteDebugStateView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RemoteDebugStateView.this.b != null) {
                    RemoteDebugStateView.this.b.exitRemoteDebug();
                }
            }
        });
        textView2.setLayoutParams(layoutParams);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setBackgroundColor(0);
        linearLayout.addView(this.f6193a);
        linearLayout.addView(textView2);
        linearLayout.setOrientation(1);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        addView(linearLayout, layoutParams2);
        setBackgroundColor(getResources().getColor(R.color.default_remote_debug_modal_bg_color));
        setClickable(true);
    }

    @Override // com.alibaba.ariver.remotedebug.view.IDebugStateView
    public void setStateText(String str) {
        this.f6193a.setText(str);
    }

    @Override // com.alibaba.ariver.remotedebug.view.IDebugStateView
    public void setExitText(String str) {
        this.c.setText(str);
    }

    @Override // com.alibaba.ariver.remotedebug.view.IDebugStateView
    public void setActionEventListener(ActionEventListener actionEventListener) {
        this.b = actionEventListener;
    }

    @Override // com.alibaba.ariver.remotedebug.view.IDebugStateView
    public void setShown(boolean z) {
        setVisibility(z ? 0 : 8);
    }
}
