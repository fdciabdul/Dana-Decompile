package com.iap.ac.android.acs.plugin.ui.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.iap.ac.android.acs.plugin.ui.utils.UIUtils;
import com.iap.ac.android.acs.transition.R;

/* loaded from: classes8.dex */
public class ACPluginToast {
    public static final int TYPE_FAIL = 2;
    public static final int TYPE_SUCCESS = 1;

    /* loaded from: classes8.dex */
    public interface OnToastDismissListener {
        void onDismiss();
    }

    public static Toast makeToast(Context context, int i, CharSequence charSequence, int i2) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.acplugin_layout_toast, (ViewGroup) null);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.inner_layout);
        int dp2px = UIUtils.dp2px(context, 140);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(dp2px, dp2px));
        ImageView imageView = (ImageView) inflate.findViewById(R.id.tip_image);
        if (i == 1) {
            imageView.setVisibility(0);
            imageView.setBackgroundResource(R.drawable.acplugin_success);
        } else if (i == 2) {
            imageView.setVisibility(0);
            imageView.setBackgroundResource(R.drawable.acplugin_failed);
        } else {
            imageView.setVisibility(8);
        }
        TextView textView = (TextView) inflate.findViewById(R.id.tip_text);
        if (!TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(0);
            textView.setText(charSequence);
        } else {
            textView.setVisibility(8);
        }
        Toast makeText = Toast.makeText(context, charSequence, i2);
        makeText.setView(inflate);
        makeText.setGravity(17, 0, 0);
        return makeText;
    }

    public static Toast makeToast(Context context, int i, CharSequence charSequence, int i2, final OnToastDismissListener onToastDismissListener) {
        Toast makeToast = makeToast(context, i, charSequence, i2);
        View view = makeToast.getView();
        if (view != null) {
            view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.iap.ac.android.acs.plugin.ui.view.ACPluginToast.1
                @Override // android.view.View.OnAttachStateChangeListener
                public final void onViewAttachedToWindow(View view2) {
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public final void onViewDetachedFromWindow(View view2) {
                    OnToastDismissListener.this.onDismiss();
                }
            });
        }
        return makeToast;
    }
}
