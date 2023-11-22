package com.iap.ac.android.acs.plugin.ui.adapter;

import android.app.Activity;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.iap.ac.android.acs.plugin.R;
import com.iap.ac.android.acs.plugin.a.a;
import com.iap.ac.android.acs.plugin.rpc.getphonenumber.PhoneNumberFacade;
import com.iap.ac.android.acs.plugin.rpc.getphonenumber.model.MobilePhoneInfo;
import com.iap.ac.android.acs.plugin.rpc.getphonenumber.request.UserPhoneRequest;
import com.iap.ac.android.acs.plugin.ui.utils.UIUtils;
import com.iap.ac.android.acs.plugin.ui.view.ACPluginDialog;
import com.iap.ac.android.acs.plugin.utils.MonitorUtil;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.rpc.RPCProxyHost;
import com.iap.ac.android.common.task.async.IAPAsyncTask;
import com.iap.ac.android.rpccommon.model.domain.result.BaseRpcResult;
import java.util.List;

/* loaded from: classes8.dex */
public class PhoneNumberListAdapter extends BaseAdapter implements View.OnClickListener {
    public Activity mActivity;
    public String mCancelText;
    public String mConfirmDeleteText;
    public String mDeleteDialogDesc;
    public String mDeleteText;
    public View mDeleteView;
    public OnDeleteAllListener mOnDeleteAllListener;
    public List<MobilePhoneInfo> mPhoneInfoList;
    public int mSelectedPosition = 0;

    /* loaded from: classes8.dex */
    public interface OnDeleteAllListener {
        void onDeleteAll();
    }

    /* loaded from: classes8.dex */
    public static class ViewHolder {
        public TextView deleteText;
        public TextView phoneNumText;
        public ImageView selectedFlag;

        public ViewHolder() {
        }
    }

    public PhoneNumberListAdapter(Activity activity, List<MobilePhoneInfo> list) {
        this.mActivity = activity;
        this.mPhoneInfoList = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteItem(int i) {
        if (i >= 0 && i < this.mPhoneInfoList.size()) {
            StringBuilder sb = new StringBuilder();
            sb.append("PhoneNumberListAdapter#deleteItem, position: ");
            sb.append(i);
            ACLog.d("IAPConnectPlugin", sb.toString());
            deletePhoneNumber(this.mPhoneInfoList.remove(i));
            if (this.mPhoneInfoList.isEmpty() && this.mOnDeleteAllListener != null) {
                ACLog.d("IAPConnectPlugin", "PhoneNumberListAdapter#deleteItem, all items have been deleted");
                this.mOnDeleteAllListener.onDeleteAll();
                return;
            }
            int i2 = this.mSelectedPosition;
            if (i2 == i) {
                this.mSelectedPosition = 0;
            } else if (i2 > i) {
                this.mSelectedPosition = i2 - 1;
            }
            StringBuilder a2 = a.a("PhoneNumberListAdapter#deleteItem, selected position after delete: ");
            a2.append(this.mSelectedPosition);
            ACLog.d("IAPConnectPlugin", a2.toString());
            notifyDataSetChanged();
            return;
        }
        ACLog.e("IAPConnectPlugin", "PhoneNumberListAdapter#deleteItem, position illegal");
    }

    private void deletePhoneNumber(final MobilePhoneInfo mobilePhoneInfo) {
        StringBuilder a2 = a.a("PhoneNumberListAdapter#deletePhoneNumber, prefix: ");
        a2.append(mobilePhoneInfo.mobilePhoneRegionCode);
        a2.append(", phone number: ");
        a2.append(UIUtils.encryptPhoneNumber(mobilePhoneInfo.mobilePhoneNumber));
        ACLog.d("IAPConnectPlugin", a2.toString());
        IAPAsyncTask.asyncTask(new Runnable() { // from class: com.iap.ac.android.acs.plugin.ui.adapter.PhoneNumberListAdapter.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    PhoneNumberFacade phoneNumberFacade = (PhoneNumberFacade) RPCProxyHost.getInterfaceProxy(PhoneNumberFacade.class, "ac_biz");
                    UserPhoneRequest userPhoneRequest = new UserPhoneRequest();
                    userPhoneRequest.mobilePhoneNumber = mobilePhoneInfo.mobilePhoneNumber;
                    userPhoneRequest.mobilePhoneRegionCode = mobilePhoneInfo.mobilePhoneRegionCode;
                    BaseRpcResult delete = phoneNumberFacade.delete(userPhoneRequest);
                    MonitorUtil.monitorRPC(PhoneNumberFacade.OPERATION_TYPE_DELETE, SystemClock.elapsedRealtime() - elapsedRealtime, delete);
                    if (delete == null) {
                        ACLog.e("IAPConnectPlugin", "PhoneNumberListAdapter#deletePhoneNumber, rpc result is null");
                    } else if (!delete.success) {
                        StringBuilder a3 = a.a("PhoneNumberListAdapter#deletePhoneNumber, rpc result fail, error: ");
                        a3.append(delete.errorCode);
                        a3.append(", errorMessage: ");
                        a3.append(delete.errorMessage);
                        ACLog.e("IAPConnectPlugin", a3.toString());
                    } else {
                        ACLog.d("IAPConnectPlugin", "PhoneNumberListAdapter#deletePhoneNumber, rpc result success");
                    }
                } catch (Throwable th) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("PhoneNumberListAdapter#deletePhoneNumber,rpc error: ");
                    sb.append(th);
                    ACLog.e("IAPConnectPlugin", sb.toString());
                }
            }
        });
    }

    private void showDeleteDialog(final int i) {
        if (i >= 0 && i < this.mPhoneInfoList.size()) {
            if (UIUtils.isActivityDisabled(this.mActivity)) {
                ACLog.e("IAPConnectPlugin", "PhoneNumberListAdapter#showDeleteDialog, activity disabled");
                return;
            }
            String str = this.mPhoneInfoList.get(i).formattedMobilePhoneNumber;
            if (TextUtils.isEmpty(str)) {
                ACLog.e("IAPConnectPlugin", "PhoneNumberListAdapter#showDeleteDialog, phone number is empty");
                return;
            }
            String format = String.format(this.mDeleteDialogDesc, str);
            StringBuilder sb = new StringBuilder();
            sb.append("PhoneNumberListAdapter#showDeleteDialog, position: ");
            sb.append(i);
            sb.append(", phone number: ");
            sb.append(UIUtils.encryptPhoneNumber(str));
            ACLog.d("IAPConnectPlugin", sb.toString());
            ACPluginDialog aCPluginDialog = new ACPluginDialog(this.mActivity, format, this.mCancelText, this.mConfirmDeleteText);
            aCPluginDialog.setConfirmListener(new ACPluginDialog.OnConfirmListener() { // from class: com.iap.ac.android.acs.plugin.ui.adapter.PhoneNumberListAdapter.1
                @Override // com.iap.ac.android.acs.plugin.ui.view.ACPluginDialog.OnConfirmListener
                public void onConfirm() {
                    PhoneNumberListAdapter.this.deleteItem(i);
                }
            });
            aCPluginDialog.setCancelListener(new ACPluginDialog.OnCancelListener() { // from class: com.iap.ac.android.acs.plugin.ui.adapter.PhoneNumberListAdapter.2
                @Override // com.iap.ac.android.acs.plugin.ui.view.ACPluginDialog.OnCancelListener
                public void onCancel() {
                    PhoneNumberListAdapter.this.notifyDataSetChanged();
                }
            });
            aCPluginDialog.show();
            return;
        }
        ACLog.e("IAPConnectPlugin", "PhoneNumberListAdapter#showDeleteDialog, position illegal");
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mPhoneInfoList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.mPhoneInfoList.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public MobilePhoneInfo getSelectedPhoneInfo() {
        int i = this.mSelectedPosition;
        if (i >= 0 && i < this.mPhoneInfoList.size()) {
            return this.mPhoneInfoList.get(this.mSelectedPosition);
        }
        StringBuilder a2 = a.a("PhoneNumberListAdapter#getSelectedPhoneInfo, selected position illegal: ");
        a2.append(this.mSelectedPosition);
        ACLog.e("IAPConnectPlugin", a2.toString());
        return null;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(this.mActivity).inflate(R.layout.acplugin_layout_phone_num_item, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.phoneNumText = (TextView) view.findViewById(R.id.phone_num_text);
            viewHolder.selectedFlag = (ImageView) view.findViewById(R.id.selected_flag);
            viewHolder.deleteText = (TextView) view.findViewById(R.id.delete_text);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.phoneNumText.setText(this.mPhoneInfoList.get(i).formattedMobilePhoneNumber);
        viewHolder.deleteText.setText(this.mDeleteText);
        viewHolder.selectedFlag.setVisibility(i != this.mSelectedPosition ? 4 : 0);
        viewHolder.deleteText.setOnClickListener(this);
        viewHolder.deleteText.setVisibility(8);
        viewHolder.deleteText.setTag(Integer.valueOf(i));
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.delete_text) {
            showDeleteDialog(((Integer) view.getTag()).intValue());
        }
    }

    public void onItemClick(int i) {
        if (i >= 0 && i < this.mPhoneInfoList.size()) {
            StringBuilder sb = new StringBuilder();
            sb.append("PhoneNumberListAdapter#onItemClick, position: ");
            sb.append(i);
            ACLog.d("IAPConnectPlugin", sb.toString());
            this.mSelectedPosition = i;
            notifyDataSetChanged();
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("PhoneNumberListAdapter#onItemClick, position illegal: ");
        sb2.append(i);
        ACLog.e("IAPConnectPlugin", sb2.toString());
    }

    public boolean onItemLongClick(View view) {
        StringBuilder sb = new StringBuilder();
        sb.append("PhoneNumberListAdapter#onItemLongClick, view: ");
        sb.append(view);
        ACLog.d("IAPConnectPlugin", sb.toString());
        if (view == null || !(view.getTag() instanceof ViewHolder)) {
            return false;
        }
        TextView textView = ((ViewHolder) view.getTag()).deleteText;
        if (textView == null) {
            ACLog.e("IAPConnectPlugin", "PhoneNumberListAdapter#onItemLongClick, delete view is null");
            return true;
        }
        View view2 = this.mDeleteView;
        if (view2 != null && view2 != textView) {
            view2.setVisibility(8);
        }
        this.mDeleteView = textView;
        textView.setVisibility(0);
        ACLog.d("IAPConnectPlugin", "PhoneNumberListAdapter#onItemLongClick, show new delete view");
        return true;
    }

    public void setMultiLanguageText(String str, String str2, String str3, String str4) {
        this.mDeleteText = str;
        this.mDeleteDialogDesc = str2;
        this.mCancelText = str3;
        this.mConfirmDeleteText = str4;
    }

    public void setOnDeleteAllListener(OnDeleteAllListener onDeleteAllListener) {
        this.mOnDeleteAllListener = onDeleteAllListener;
    }
}
