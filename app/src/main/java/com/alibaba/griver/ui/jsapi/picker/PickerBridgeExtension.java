package com.alibaba.griver.ui.jsapi.picker;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingRequest;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.ui.R;
import com.alibaba.griver.ui.jsapi.picker.nebula.wheelview.multilevel.MultilevelSelectActivity;
import com.alibaba.griver.ui.jsapi.picker.nebula.wheelview.multilevel.MultilevelSelectCallBack;
import com.alibaba.griver.ui.jsapi.picker.nebula.wheelview.picker.OptionPickerDialog;
import com.alibaba.griver.ui.jsapi.picker.nebula.wheelview.picker.TwoWheelOptionPickerDialog;
import id.dana.mybills.ui.constant.MyBillsPurposeAction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public class PickerBridgeExtension implements BridgeExtension {
    private static final String TAG = "PickerBridgeExtension";
    private final String[] paramKeyArray = {"title", "optionsOne", "optionsTwo", "selectedOneIndex", "selectedTwoIndex", "selectedOneOption", "selectedTwoOption", "positiveString", "negativeString", "startTimestamp", "duartion", "startHour", "endHour"};

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void beehiveOptionsPicker(@BindingApiContext ApiContext apiContext, @BindingRequest JSONObject jSONObject, @BindingCallback BridgeCallback bridgeCallback) {
        optionsPicker(apiContext, jSONObject, bridgeCallback);
    }

    private String[] parseJsonArrayToStringArray(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.isEmpty()) {
            return null;
        }
        String[] strArr = new String[jSONArray.size()];
        for (int i = 0; i < jSONArray.size(); i++) {
            strArr[i] = String.valueOf(jSONArray.get(i));
        }
        return strArr;
    }

    private void optionsPicker(ApiContext apiContext, JSONObject jSONObject, BridgeCallback bridgeCallback) {
        String str;
        String str2;
        if (jSONObject == null) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        String string = jSONObject.containsKey(this.paramKeyArray[0]) ? jSONObject.getString(this.paramKeyArray[0]) : "";
        String[] parseJsonArrayToStringArray = jSONObject.containsKey(this.paramKeyArray[1]) ? parseJsonArrayToStringArray(jSONObject.getJSONArray(this.paramKeyArray[1])) : null;
        String[] parseJsonArrayToStringArray2 = jSONObject.containsKey(this.paramKeyArray[2]) ? parseJsonArrayToStringArray(jSONObject.getJSONArray(this.paramKeyArray[2])) : null;
        if (GriverEnv.getResources() != null) {
            str = GriverEnv.getResources().getString(R.string.griver_base_confirm);
            str2 = GriverEnv.getResources().getString(R.string.griver_base_cancel);
        } else {
            str = "Confirm";
            str2 = MyBillsPurposeAction.CANCEL;
        }
        if (jSONObject.containsKey(this.paramKeyArray[7])) {
            str = jSONObject.getString(this.paramKeyArray[7]);
        }
        String str3 = str;
        String string2 = jSONObject.containsKey(this.paramKeyArray[8]) ? jSONObject.getString(this.paramKeyArray[8]) : str2;
        int intValue = jSONObject.containsKey(this.paramKeyArray[3]) ? jSONObject.getInteger(this.paramKeyArray[3]).intValue() : 0;
        Activity activity = GriverEnv.getTopActivity() != null ? GriverEnv.getTopActivity().get() : null;
        Activity activity2 = (activity != null || apiContext == null) ? activity : apiContext.getActivity();
        if (activity2 == null) {
            GriverLogger.e(TAG, "activity is null, return error");
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
        } else if (parseJsonArrayToStringArray != null && parseJsonArrayToStringArray2 != null) {
            showTwoWheelDialog(jSONObject, string, parseJsonArrayToStringArray, parseJsonArrayToStringArray2, str3, string2, intValue, activity2, bridgeCallback);
        } else if (parseJsonArrayToStringArray != null) {
            showSingleWheelDialog(string, str3, string2, parseJsonArrayToStringArray, intValue, activity2, bridgeCallback);
        }
    }

    private void showSingleWheelDialog(String str, String str2, String str3, String[] strArr, int i, Activity activity, final BridgeCallback bridgeCallback) {
        OptionPickerDialog optionPickerDialog = new OptionPickerDialog(activity, str, str2, str3, strArr);
        optionPickerDialog.setOnOptionPickListener(new OptionPickerDialog.OnOptionPickListener() { // from class: com.alibaba.griver.ui.jsapi.picker.PickerBridgeExtension.1
            @Override // com.alibaba.griver.ui.jsapi.picker.nebula.wheelview.picker.OptionPickerDialog.OnOptionPickListener
            public void onOptionPicked(String str4, int i2) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(PickerBridgeExtension.this.paramKeyArray[3], (Object) Integer.valueOf(i2));
                jSONObject.put(PickerBridgeExtension.this.paramKeyArray[5], (Object) str4);
                bridgeCallback.sendBridgeResponse(new BridgeResponse(jSONObject));
            }
        });
        final Runnable runnable = new Runnable() { // from class: com.alibaba.griver.ui.jsapi.picker.PickerBridgeExtension.2
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(PickerBridgeExtension.this.paramKeyArray[3], (Object) "");
                jSONObject.put(PickerBridgeExtension.this.paramKeyArray[5], (Object) "");
                bridgeCallback.sendBridgeResponse(new BridgeResponse(jSONObject));
            }
        };
        optionPickerDialog.setNegativeListener(new View.OnClickListener() { // from class: com.alibaba.griver.ui.jsapi.picker.PickerBridgeExtension.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                runnable.run();
            }
        });
        optionPickerDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.alibaba.griver.ui.jsapi.picker.PickerBridgeExtension.4
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                runnable.run();
            }
        });
        optionPickerDialog.setSelectedIndex(i);
        optionPickerDialog.show();
    }

    private void showTwoWheelDialog(JSONObject jSONObject, String str, String[] strArr, String[] strArr2, String str2, String str3, int i, Activity activity, final BridgeCallback bridgeCallback) {
        TwoWheelOptionPickerDialog twoWheelOptionPickerDialog = new TwoWheelOptionPickerDialog(activity, str, str2, str3, strArr, strArr2);
        twoWheelOptionPickerDialog.setOnOptionPickListener(new TwoWheelOptionPickerDialog.OnOptionPickListener() { // from class: com.alibaba.griver.ui.jsapi.picker.PickerBridgeExtension.5
            @Override // com.alibaba.griver.ui.jsapi.picker.nebula.wheelview.picker.TwoWheelOptionPickerDialog.OnOptionPickListener
            public void onOptionPicked(String str4, int i2, String str5, int i3) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(PickerBridgeExtension.this.paramKeyArray[3], (Object) Integer.valueOf(i2));
                jSONObject2.put(PickerBridgeExtension.this.paramKeyArray[4], (Object) Integer.valueOf(i3));
                jSONObject2.put(PickerBridgeExtension.this.paramKeyArray[5], (Object) str4);
                jSONObject2.put(PickerBridgeExtension.this.paramKeyArray[6], (Object) str5);
                bridgeCallback.sendBridgeResponse(new BridgeResponse(jSONObject2));
            }
        });
        final Runnable runnable = new Runnable() { // from class: com.alibaba.griver.ui.jsapi.picker.PickerBridgeExtension.6
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(PickerBridgeExtension.this.paramKeyArray[3], (Object) "");
                jSONObject2.put(PickerBridgeExtension.this.paramKeyArray[4], (Object) "");
                jSONObject2.put(PickerBridgeExtension.this.paramKeyArray[5], (Object) "");
                jSONObject2.put(PickerBridgeExtension.this.paramKeyArray[6], (Object) "");
                bridgeCallback.sendBridgeResponse(new BridgeResponse(jSONObject2));
            }
        };
        twoWheelOptionPickerDialog.setNegativeListener(new View.OnClickListener() { // from class: com.alibaba.griver.ui.jsapi.picker.PickerBridgeExtension.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                runnable.run();
            }
        });
        twoWheelOptionPickerDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.alibaba.griver.ui.jsapi.picker.PickerBridgeExtension.8
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                runnable.run();
            }
        });
        int intValue = jSONObject.containsKey(this.paramKeyArray[4]) ? jSONObject.getInteger(this.paramKeyArray[4]).intValue() : 0;
        twoWheelOptionPickerDialog.setLeftSelectedIndex(i);
        twoWheelOptionPickerDialog.setRightSelectedIndex(intValue);
        twoWheelOptionPickerDialog.show();
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void beehiveMultilevelSelect(@BindingApiContext ApiContext apiContext, @BindingRequest JSONObject jSONObject, @BindingCallback BridgeCallback bridgeCallback) {
        multilevelSelect(apiContext, jSONObject, bridgeCallback);
    }

    private void multilevelSelect(ApiContext apiContext, JSONObject jSONObject, final BridgeCallback bridgeCallback) {
        if (jSONObject == null) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        Bundle bundle = new Bundle();
        Iterator<Map.Entry<String, Object>> it = jSONObject.entrySet().iterator();
        while (it.hasNext()) {
            String key = it.next().getKey();
            key.hashCode();
            char c = 65535;
            switch (key.hashCode()) {
                case -934426595:
                    if (key.equals("result")) {
                        c = 0;
                        break;
                    }
                    break;
                case 3322014:
                    if (key.equals("list")) {
                        c = 1;
                        break;
                    }
                    break;
                case 110371416:
                    if (key.equals("title")) {
                        c = 2;
                        break;
                    }
                    break;
                case 150981469:
                    if (key.equals("defaultSegmentName")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            if (c == 0 || c == 1 || c == 2 || c == 3) {
                bundle.putString(key, jSONObject.getString(key));
            }
        }
        Intent intent = new Intent();
        Activity activity = GriverEnv.getTopActivity().get();
        if (activity == null) {
            activity = apiContext.getActivity();
        }
        if (activity == null) {
            GriverLogger.e(TAG, "activity is null, multiselect return false");
            bridgeCallback.sendBridgeResponse(BridgeResponse.FORBIDDEN_ERROR);
            return;
        }
        intent.setClass(activity, MultilevelSelectActivity.class);
        intent.putExtras(bundle);
        activity.startActivity(intent);
        MultilevelSelectActivity.multilevelSelectCallBack = new MultilevelSelectCallBack() { // from class: com.alibaba.griver.ui.jsapi.picker.PickerBridgeExtension.9
            @Override // com.alibaba.griver.ui.jsapi.picker.nebula.wheelview.multilevel.MultilevelSelectCallBack
            public void onSuccess(JSONArray jSONArray) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("success", (Object) Boolean.TRUE);
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.size(); i++) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("name", jSONArray.getJSONObject(i).get("name"));
                    arrayList.add(jSONObject3);
                }
                jSONObject2.put("result", (Object) arrayList);
                bridgeCallback.sendBridgeResponse(new BridgeResponse(jSONObject2));
            }

            @Override // com.alibaba.griver.ui.jsapi.picker.nebula.wheelview.multilevel.MultilevelSelectCallBack
            public void onCancel() {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("success", (Object) Boolean.FALSE);
                bridgeCallback.sendBridgeResponse(new BridgeResponse(jSONObject2));
            }
        };
    }
}
