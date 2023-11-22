package com.alipay.mobile.verifyidentity.uitools.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.alipay.mobile.verifyidentity.uitools.R;

/* loaded from: classes7.dex */
public class ModalDialog extends AlertDialog {
    private Context mContext;
    private ModalInterface modalInterface;
    private TextView tvMessage;
    private TextView tvOk;

    public ModalDialog(Context context, ModalInterface modalInterface) {
        super(context);
        this.modalInterface = modalInterface;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setCancelable(false);
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.modal_dailog, (ViewGroup) null);
        this.tvMessage = (TextView) inflate.findViewById(R.id.tv_msg);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_ok);
        this.tvOk = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.alipay.mobile.verifyidentity.uitools.dialog.ModalDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ModalDialog.this.modalInterface != null) {
                    ModalDialog.this.modalInterface.onOk();
                }
            }
        });
        setView(inflate);
    }

    public void setMessage(String str) {
        this.tvMessage.setText(str);
    }
}
