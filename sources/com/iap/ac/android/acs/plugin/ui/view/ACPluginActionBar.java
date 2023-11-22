package com.iap.ac.android.acs.plugin.ui.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iap.ac.android.acs.transition.R;
import com.iap.ac.android.common.log.ACLog;

/* loaded from: classes8.dex */
public class ACPluginActionBar extends LinearLayout implements View.OnClickListener {
    public ActionBarListener mActionBarListener;
    public TextView mTitleText;

    /* loaded from: classes8.dex */
    public interface ActionBarListener {
        void onBack();
    }

    public ACPluginActionBar(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.acplugin_layout_action_bar, (ViewGroup) this, true);
        initView();
    }

    private void initView() {
        findViewById(R.id.back_view).setOnClickListener(this);
        this.mTitleText = (TextView) findViewById(R.id.title_text);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.back_view) {
            ActionBarListener actionBarListener = this.mActionBarListener;
            if (actionBarListener != null) {
                actionBarListener.onBack();
            } else if (getContext() instanceof Activity) {
                ACLog.d("IAPConnectPlugin", "ACPluginActionBar#onClick, back icon on click, finish activity");
                ((Activity) getContext()).finish();
            }
        }
    }

    public void setActionBarListener(ActionBarListener actionBarListener) {
        this.mActionBarListener = actionBarListener;
    }

    public void setTitle(String str) {
        this.mTitleText.setText(str);
    }

    public ACPluginActionBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(context).inflate(R.layout.acplugin_layout_action_bar, (ViewGroup) this, true);
        initView();
    }

    public ACPluginActionBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R.layout.acplugin_layout_action_bar, (ViewGroup) this, true);
        initView();
    }
}
