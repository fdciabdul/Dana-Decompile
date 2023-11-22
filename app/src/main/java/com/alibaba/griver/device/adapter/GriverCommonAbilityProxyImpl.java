package com.alibaba.griver.device.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.griver.api.ui.dialog.GriverCreateDialogParam;
import com.alibaba.griver.api.ui.dialog.GriverDialogExtension;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.device.R;
import com.alibaba.griver.device.adapter.SimpleListAdapter;
import com.alibaba.griver.device.jsapi.contact.AddPhoneContactView;
import com.alibaba.griver.device.proxy.RVCommonAbilityProxy;
import java.util.ArrayList;

/* loaded from: classes6.dex */
public class GriverCommonAbilityProxyImpl implements RVCommonAbilityProxy {
    @Override // com.alibaba.griver.device.proxy.RVCommonAbilityProxy
    public String getAppAlias() {
        return null;
    }

    @Override // com.alibaba.griver.device.proxy.RVCommonAbilityProxy
    public String getDevicePerformance() {
        return RVCommonAbilityProxy.HIGH;
    }

    @Override // com.alibaba.griver.device.proxy.RVCommonAbilityProxy
    public float getFontSizeSetting() {
        return 16.0f;
    }

    @Override // com.alibaba.griver.device.proxy.RVCommonAbilityProxy
    public String getLocalLanguage() {
        return null;
    }

    @Override // com.alibaba.griver.device.proxy.RVCommonAbilityProxy
    public boolean hasRootStatusPermission(String str) {
        return true;
    }

    /* renamed from: com.alibaba.griver.device.adapter.GriverCommonAbilityProxyImpl$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    class AnonymousClass1 implements AddPhoneContactView {
        DialogInterface.OnCancelListener cancelListener;
        Dialog dialog;
        AdapterView.OnItemClickListener onItemClickListener;
        SimpleListAdapter simpleListAdapter;

        AnonymousClass1() {
        }

        @Override // com.alibaba.griver.device.jsapi.contact.AddPhoneContactView
        public void initView(Context context, ArrayList<String> arrayList) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.griver_device_dialog_simple_list, (ViewGroup) null);
            RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.rv_simple_list);
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            GriverCreateDialogParam griverCreateDialogParam = new GriverCreateDialogParam(context.getString(R.string.griver_add_contact), null, null, context.getString(R.string.griver_base_cancel), null);
            griverCreateDialogParam.customView = inflate;
            griverCreateDialogParam.negativeListener = new DialogInterface.OnClickListener() { // from class: com.alibaba.griver.device.adapter.GriverCommonAbilityProxyImpl.1.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    if (AnonymousClass1.this.cancelListener != null) {
                        AnonymousClass1.this.cancelListener.onCancel(dialogInterface);
                    }
                }
            };
            this.dialog = ((GriverDialogExtension) RVProxy.get(GriverDialogExtension.class)).createDialog(GriverEnv.getTopActivity().get(), griverCreateDialogParam);
            SimpleListAdapter simpleListAdapter = new SimpleListAdapter(context, arrayList);
            this.simpleListAdapter = simpleListAdapter;
            recyclerView.setAdapter(simpleListAdapter);
            this.simpleListAdapter.setOnItemClickListener(new SimpleListAdapter.OnItemClickListener() { // from class: com.alibaba.griver.device.adapter.GriverCommonAbilityProxyImpl.1.2
                @Override // com.alibaba.griver.device.adapter.SimpleListAdapter.OnItemClickListener
                public void onItemClick(int i) {
                    if (AnonymousClass1.this.onItemClickListener != null) {
                        AnonymousClass1.this.onItemClickListener.onItemClick(null, null, i, 0L);
                        AnonymousClass1.this.dialog.dismiss();
                    }
                }
            });
        }

        @Override // com.alibaba.griver.device.jsapi.contact.AddPhoneContactView
        public void setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
            this.cancelListener = onCancelListener;
        }

        @Override // com.alibaba.griver.device.jsapi.contact.AddPhoneContactView
        public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
            this.onItemClickListener = onItemClickListener;
        }

        @Override // com.alibaba.griver.device.jsapi.contact.AddPhoneContactView
        public void show() {
            this.dialog.show();
        }
    }

    @Override // com.alibaba.griver.device.proxy.RVCommonAbilityProxy
    public AddPhoneContactView getAddPhoneContactDialog() {
        return new AnonymousClass1();
    }
}
