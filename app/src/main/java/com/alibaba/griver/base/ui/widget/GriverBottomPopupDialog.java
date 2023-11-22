package com.alibaba.griver.base.ui.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import com.alibaba.griver.base.R;

/* loaded from: classes6.dex */
public class GriverBottomPopupDialog extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private boolean f6385a;

    public GriverBottomPopupDialog(Context context, View view) {
        super(context, R.style.GriverDialog);
        this.f6385a = true;
        View inflate = LayoutInflater.from(context).inflate(R.layout.griver_bottom_popup_window, (ViewGroup) null);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.layout_pop_up_content);
        inflate.findViewById(R.id.tv_empty_text).setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.griver.base.ui.widget.GriverBottomPopupDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (GriverBottomPopupDialog.this.f6385a) {
                    GriverBottomPopupDialog.this.cancel();
                }
            }
        });
        frameLayout.removeAllViews();
        frameLayout.addView(view);
        setContentView(inflate);
        Window window = getWindow();
        if (window != null) {
            window.getDecorView().setPadding(0, 0, 0, 0);
            window.setFlags(1024, 1024);
            window.setWindowAnimations(R.style.griverBottomPopupDialogAnimation);
            window.setGravity(80);
        }
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean z) {
        super.setCancelable(z);
        this.f6385a = false;
    }
}
