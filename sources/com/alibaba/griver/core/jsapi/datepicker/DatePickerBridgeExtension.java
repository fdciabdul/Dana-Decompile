package com.alibaba.griver.core.jsapi.datepicker;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.DatePicker;
import android.widget.TimePicker;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.core.R;
import id.dana.data.config.source.amcs.result.MaintenanceBroadcastResult;
import id.dana.mybills.ui.constant.MyBillsPurposeAction;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/* loaded from: classes2.dex */
public class DatePickerBridgeExtension implements BridgeExtension {
    private static final int HOUR_MINUTE = 0;
    private static final String TAG = "AriverAPI:DatePickerBridgeExtension";
    private static final int YEAR = 4;
    private static final int YEAR_MONTH = 3;
    private static final int YEAR_MONTH_DAY = 1;
    private static final int YEAR_MONTH_DAY_HOUR_MINUTE = 2;

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
    public void datePicker(@BindingApiContext(required = true) ApiContext apiContext, @BindingParam({"mode"}) int i, @BindingParam({"minDate"}) String str, @BindingParam({"maxDate"}) String str2, @BindingParam({"beginDate"}) String str3, @BindingParam({"isIDCard"}) boolean z, @BindingCallback BridgeCallback bridgeCallback) {
        String str4 = i == 0 ? "HH:mm:ss" : i == 1 ? "yyyy-MM-dd" : i == 2 ? "yyyy-MM-dd HH:mm:ss" : i == 3 ? "yyyy-MM" : i == 4 ? "yyyy" : null;
        Calendar parseDate = parseDate(str, str4);
        Calendar parseDate2 = parseDate(str2, str4);
        if (parseDate != null && parseDate2 != null && parseDate.getTimeInMillis() > parseDate2.getTimeInMillis()) {
            RVLogger.e(TAG, "min date should less than max date!");
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(2, "min date should less than max date!"));
            return;
        }
        Calendar parseDate3 = parseDate(str3, str4);
        if (parseDate3 == null) {
            parseDate3 = Calendar.getInstance();
        }
        JSONObject jSONObject = new JSONObject();
        if (i == 0) {
            showTimeDialog(apiContext, parseDate3, parseDate, parseDate2, bridgeCallback, z, jSONObject);
        } else {
            showDateDialog(apiContext, parseDate3, parseDate, parseDate2, z, i == 2, bridgeCallback, jSONObject, i);
        }
    }

    private void showDateDialog(final ApiContext apiContext, final Calendar calendar, final Calendar calendar2, final Calendar calendar3, final boolean z, final boolean z2, final BridgeCallback bridgeCallback, final JSONObject jSONObject, final int i) {
        Activity activity = apiContext.getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        DatePickerDialog datePickerDialog = new DatePickerDialog(activity, new DatePickerDialog.OnDateSetListener() { // from class: com.alibaba.griver.core.jsapi.datepicker.DatePickerBridgeExtension.1
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public void onDateSet(DatePicker datePicker, int i2, int i3, int i4) {
                StringBuilder sb;
                Calendar calendar4;
                if (calendar2 != null && (calendar4 = calendar3) != null) {
                    if (calendar4.get(1) <= i2) {
                        i2 = calendar3.get(1);
                    } else if (calendar2.get(1) >= i2) {
                        i2 = calendar2.get(1);
                    }
                }
                int i5 = i3 + 1;
                StringBuilder sb2 = new StringBuilder();
                if (i5 < 10) {
                    sb2.append("0");
                }
                sb2.append(i5);
                String obj = sb2.toString();
                if (i4 < 10) {
                    sb = new StringBuilder();
                    sb.append("0");
                } else {
                    sb = new StringBuilder();
                }
                sb.append(i4);
                String obj2 = sb.toString();
                if (z2) {
                    JSONObject jSONObject2 = jSONObject;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(i2);
                    sb3.append("/");
                    sb3.append(obj);
                    sb3.append("/");
                    sb3.append(obj2);
                    sb3.append(" ");
                    jSONObject2.put(MaintenanceBroadcastResult.KEY_DATE, (Object) sb3.toString());
                    DatePickerBridgeExtension.this.showTimeDialog(apiContext, calendar, calendar2, calendar3, bridgeCallback, z, jSONObject);
                    return;
                }
                int i6 = i;
                if (i6 == 4) {
                    JSONObject jSONObject3 = jSONObject;
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(i2);
                    jSONObject3.put(MaintenanceBroadcastResult.KEY_DATE, (Object) sb4.toString());
                } else if (i6 == 3) {
                    JSONObject jSONObject4 = jSONObject;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(i2);
                    sb5.append("/");
                    sb5.append(obj);
                    jSONObject4.put(MaintenanceBroadcastResult.KEY_DATE, (Object) sb5.toString());
                } else {
                    JSONObject jSONObject5 = jSONObject;
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(i2);
                    sb6.append("/");
                    sb6.append(obj);
                    sb6.append("/");
                    sb6.append(obj2);
                    jSONObject5.put(MaintenanceBroadcastResult.KEY_DATE, (Object) sb6.toString());
                }
                bridgeCallback.sendJSONResponse(jSONObject);
            }
        }, calendar.get(1), calendar.get(2), calendar.get(5)) { // from class: com.alibaba.griver.core.jsapi.datepicker.DatePickerBridgeExtension.2
            @Override // android.app.Dialog
            protected void onStop() {
            }
        };
        datePickerDialog.setTitle(apiContext.getActivity().getResources().getString(R.string.griver_core_jsapi_choosedate));
        datePickerDialog.setCancelable(false);
        datePickerDialog.setButton(-2, apiContext.getActivity().getResources().getString(R.string.griver_base_cancel), new DialogInterface.OnClickListener() { // from class: com.alibaba.griver.core.jsapi.datepicker.DatePickerBridgeExtension.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.newError(11, "User canceled"));
                dialogInterface.dismiss();
            }
        });
        if (z) {
            datePickerDialog.setButton(-3, apiContext.getActivity().getResources().getString(R.string.griver_core_jsapi_datevalid), new DialogInterface.OnClickListener() { // from class: com.alibaba.griver.core.jsapi.datepicker.DatePickerBridgeExtension.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    jSONObject.put(MaintenanceBroadcastResult.KEY_DATE, (Object) apiContext.getActivity().getResources().getString(R.string.griver_core_jsapi_date_longterm));
                    bridgeCallback.sendJSONResponse(jSONObject);
                    dialogInterface.dismiss();
                }
            });
        }
        try {
            DatePicker datePicker = datePickerDialog.getDatePicker();
            if (calendar2 != null) {
                datePicker.setMinDate(calendar2.getTimeInMillis());
            }
            if (calendar3 != null) {
                datePicker.setMaxDate(calendar3.getTimeInMillis());
            }
        } catch (Throwable th) {
            RVLogger.e(TAG, "set min or max date exception.", th);
        }
        try {
            DatePicker datePicker2 = datePickerDialog.getDatePicker();
            if (i == 3) {
                datePicker2.findViewById(Resources.getSystem().getIdentifier("day", "id", "android")).setVisibility(8);
            } else if (i == 4) {
                datePicker2.findViewById(Resources.getSystem().getIdentifier("day", "id", "android")).setVisibility(8);
                datePicker2.findViewById(Resources.getSystem().getIdentifier("month", "id", "android")).setVisibility(8);
            }
        } catch (Exception e) {
            RVLogger.e(TAG, "set date mode exception", e);
        }
        try {
            datePickerDialog.show();
        } catch (Exception e2) {
            RVLogger.e(TAG, "show date dialog exception.", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showTimeDialog(ApiContext apiContext, Calendar calendar, final Calendar calendar2, final Calendar calendar3, final BridgeCallback bridgeCallback, boolean z, final JSONObject jSONObject) {
        Activity activity = apiContext.getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        final Resources resources = activity.getResources();
        TimePickerDialog timePickerDialog = new TimePickerDialog(activity, new TimePickerDialog.OnTimeSetListener() { // from class: com.alibaba.griver.core.jsapi.datepicker.DatePickerBridgeExtension.5
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i, int i2) {
                String obj;
                BridgeCallback bridgeCallback2;
                BridgeCallback bridgeCallback3;
                String string = jSONObject.getString(MaintenanceBroadcastResult.KEY_DATE);
                if (TextUtils.isEmpty(string)) {
                    string = "";
                }
                StringBuilder sb = new StringBuilder(string);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(i);
                sb2.append(":");
                sb2.append(i2);
                sb2.append(":00");
                sb.append(sb2.toString());
                Calendar parseDate = DatePickerBridgeExtension.this.parseDate(sb.toString(), TextUtils.isEmpty(string) ? "HH:mm:ss" : "yyyy/MM/dd HH:mm:ss");
                if (parseDate == null && (bridgeCallback3 = bridgeCallback) != null) {
                    bridgeCallback3.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
                    return;
                }
                Calendar calendar4 = calendar2;
                if (calendar4 != null && calendar4.getTimeInMillis() > parseDate.getTimeInMillis()) {
                    RVLogger.d(DatePickerBridgeExtension.TAG, "set selected date as min date");
                    parseDate = calendar2;
                }
                Calendar calendar5 = calendar3;
                if (calendar5 != null && calendar5.getTimeInMillis() < parseDate.getTimeInMillis()) {
                    RVLogger.d(DatePickerBridgeExtension.TAG, "set selected date as max date");
                    parseDate = calendar3;
                }
                if (parseDate == null && (bridgeCallback2 = bridgeCallback) != null) {
                    bridgeCallback2.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
                    return;
                }
                StringBuilder sb3 = new StringBuilder();
                if (!TextUtils.isEmpty(string)) {
                    int i3 = parseDate.get(1);
                    int i4 = parseDate.get(2);
                    int i5 = parseDate.get(5);
                    int i6 = i4 + 1;
                    StringBuilder sb4 = new StringBuilder();
                    if (i6 < 10) {
                        sb4.append("0");
                    }
                    sb4.append(i6);
                    String obj2 = sb4.toString();
                    StringBuilder sb5 = new StringBuilder();
                    if (i5 < 10) {
                        sb5.append("0");
                    }
                    sb5.append(i5);
                    String obj3 = sb5.toString();
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(i3);
                    sb6.append("/");
                    sb6.append(obj2);
                    sb6.append("/");
                    sb6.append(obj3);
                    sb6.append(" ");
                    sb3.append(sb6.toString());
                }
                int i7 = parseDate.get(11);
                int i8 = parseDate.get(12);
                StringBuilder sb7 = new StringBuilder();
                if (i7 < 10) {
                    sb7.append("0");
                }
                sb7.append(i7);
                String obj4 = sb7.toString();
                if (i8 < 10) {
                    StringBuilder sb8 = new StringBuilder();
                    sb8.append("0");
                    sb8.append(i8);
                    obj = sb8.toString();
                } else {
                    StringBuilder sb9 = new StringBuilder();
                    sb9.append(i8);
                    obj = sb9.toString();
                }
                StringBuilder sb10 = new StringBuilder();
                sb10.append(obj4);
                sb10.append(":");
                sb10.append(obj);
                sb10.append(":00");
                sb3.append(sb10.toString());
                jSONObject.put(MaintenanceBroadcastResult.KEY_DATE, (Object) sb3.toString());
                RVLogger.e(DatePickerBridgeExtension.TAG, sb.toString());
                bridgeCallback.sendJSONResponse(jSONObject);
            }
        }, calendar.get(11), calendar.get(12), true) { // from class: com.alibaba.griver.core.jsapi.datepicker.DatePickerBridgeExtension.6
            @Override // android.app.Dialog
            protected void onStop() {
            }
        };
        timePickerDialog.setTitle(resources.getString(R.string.griver_core_jsapi_choosetime));
        timePickerDialog.setCancelable(false);
        timePickerDialog.setButton(-2, resources.getString(R.string.griver_base_cancel), new DialogInterface.OnClickListener() { // from class: com.alibaba.griver.core.jsapi.datepicker.DatePickerBridgeExtension.7
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.newError(11, MyBillsPurposeAction.CANCEL));
                dialogInterface.dismiss();
            }
        });
        if (z) {
            timePickerDialog.setButton(-3, resources.getString(R.string.griver_core_jsapi_datevalid), new DialogInterface.OnClickListener() { // from class: com.alibaba.griver.core.jsapi.datepicker.DatePickerBridgeExtension.8
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    jSONObject.put(MaintenanceBroadcastResult.KEY_DATE, (Object) resources.getString(R.string.griver_core_jsapi_date_longterm));
                    bridgeCallback.sendJSONResponse(jSONObject);
                    dialogInterface.dismiss();
                }
            });
        }
        try {
            timePickerDialog.show();
        } catch (Exception e) {
            RVLogger.e(TAG, "show time dialog exception.", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Calendar parseDate(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2);
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(simpleDateFormat.parse(str));
            return calendar;
        } catch (ParseException e) {
            RVLogger.e(TAG, "exception detail", e);
            return null;
        }
    }
}
