package com.huawei.hms.api;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.activity.EnableServiceActivity;
import com.huawei.hms.activity.ForegroundIntentBuilder;
import com.huawei.hms.activity.internal.BusResponseCallback;
import com.huawei.hms.activity.internal.BusResponseResult;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.common.ErrorDialogFragment;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.api.AvailabilityException;
import com.huawei.hms.common.api.HuaweiApiCallable;
import com.huawei.hms.common.internal.ConnectionErrorMessages;
import com.huawei.hms.common.internal.DialogRedirect;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.note.AppSpoofResolution;
import com.huawei.hms.update.note.DoNothingResolution;
import com.huawei.hms.update.note.NotInstalledHmsResolution;
import com.huawei.hms.update.ui.NotInstalledHmsDialogHelper;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.Util;

/* loaded from: classes7.dex */
public final class b extends HuaweiApiAvailability {
    private static final b getAuthRequestContext = new b();

    /* loaded from: classes7.dex */
    class a implements BusResponseCallback {
        final /* synthetic */ TaskCompletionSource[] PlaceComponentResult;

        a(TaskCompletionSource[] taskCompletionSourceArr) {
            this.PlaceComponentResult = taskCompletionSourceArr;
        }

        @Override // com.huawei.hms.activity.internal.BusResponseCallback
        public BusResponseResult innerError(Activity activity, int i, String str) {
            StringBuilder sb = new StringBuilder();
            sb.append("Test foreground bus error: resultCode ");
            sb.append(i);
            sb.append(", errMessage");
            sb.append(str);
            HMSLog.e("HuaweiApiAvailabilityImpl", sb.toString());
            TaskCompletionSource taskCompletionSource = this.PlaceComponentResult[0];
            taskCompletionSource.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2((Exception) new AvailabilityException());
            return null;
        }

        @Override // com.huawei.hms.activity.internal.BusResponseCallback
        public BusResponseResult succeedReturn(Activity activity, int i, Intent intent) {
            StringBuilder sb = new StringBuilder();
            sb.append("Test foreground bus success: resultCode ");
            sb.append(i);
            sb.append(", data");
            sb.append(intent);
            HMSLog.i("HuaweiApiAvailabilityImpl", sb.toString());
            return null;
        }
    }

    private b() {
    }

    public static b PlaceComponentResult() {
        return getAuthRequestContext;
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public final Task<Void> checkApiAccessible(HuaweiApi<?> huaweiApi, HuaweiApi<?>... huaweiApiArr) {
        Task task = new TaskCompletionSource().MyBillsEntityDataFactory;
        if (huaweiApi != null) {
            try {
                PlaceComponentResult(huaweiApi);
            } catch (AvailabilityException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("checkApi has AvailabilityException ");
                sb.append(e.getMessage());
                HMSLog.i("HuaweiApiAvailabilityImpl", sb.toString());
            }
        }
        if (huaweiApiArr != null) {
            for (HuaweiApi<?> huaweiApi2 : huaweiApiArr) {
                PlaceComponentResult(huaweiApi2);
            }
        }
        return task;
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public final PendingIntent getErrPendingIntent(Context context, ConnectionResult connectionResult) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(connectionResult);
        int errorCode = connectionResult.getErrorCode();
        StringBuilder sb = new StringBuilder();
        sb.append("Enter getResolveErrorPendingIntent, errorCode: ");
        sb.append(errorCode);
        HMSLog.i("HuaweiApiAvailabilityImpl", sb.toString());
        Intent MyBillsEntityDataFactory = MyBillsEntityDataFactory(context, errorCode);
        if (MyBillsEntityDataFactory != null) {
            return PendingIntent.getActivity(context, 0, MyBillsEntityDataFactory, 67108864);
        }
        return null;
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public final Dialog getErrorDialog(Activity activity, int i, int i2) {
        Checker.checkNonNull(activity, "activity must not be null.");
        StringBuilder sb = new StringBuilder();
        sb.append("Enter getErrorDialog, errorCode: ");
        sb.append(i);
        HMSLog.i("HuaweiApiAvailabilityImpl", sb.toString());
        return getErrorDialog(activity, i, i2, null);
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public final String getErrorString(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("Enter getErrorString, errorCode: ");
        sb.append(i);
        HMSLog.i("HuaweiApiAvailabilityImpl", sb.toString());
        return ConnectionResult.getErrorString(i);
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public final Task<Void> getHuaweiServicesReady(Activity activity) {
        Preconditions.checkNotNull(activity);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        TaskCompletionSource[] taskCompletionSourceArr = {taskCompletionSource};
        Task task = taskCompletionSource.MyBillsEntityDataFactory;
        int isHuaweiMobileServicesAvailable = isHuaweiMobileServicesAvailable(activity.getApplicationContext(), 30000000);
        Intent resolveErrorIntent = getResolveErrorIntent(activity, isHuaweiMobileServicesAvailable);
        Intent intentStartBridgeActivity = BridgeActivity.getIntentStartBridgeActivity(activity, ResolutionDelegate.class.getName());
        if (resolveErrorIntent != null) {
            ForegroundIntentBuilder.registerResponseCallback(ResolutionDelegate.CALLBACK_METHOD, new a(taskCompletionSourceArr));
            Bundle bundle = new Bundle();
            bundle.putParcelable(CommonCode.MapKey.HAS_RESOLUTION, resolveErrorIntent);
            intentStartBridgeActivity.putExtras(bundle);
            activity.startActivity(intentStartBridgeActivity);
        } else if (isHuaweiMobileServicesAvailable == 3) {
            Intent intent = new Intent();
            intent.setClass(activity, EnableServiceActivity.class);
            activity.startActivity(intent);
        } else if (isHuaweiMobileServicesAvailable == 0) {
            HMSLog.i("HuaweiApiAvailabilityImpl", "The HMS service is available.");
        } else {
            HMSLog.e("HuaweiApiAvailabilityImpl", "Framework can not solve the availability problem.");
            taskCompletionSourceArr[0].MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2((Exception) new AvailabilityException());
        }
        return task;
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public final Intent getResolveErrorIntent(Activity activity, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("Enter getResolveErrorIntent, errorCode: ");
        sb.append(i);
        HMSLog.i("HuaweiApiAvailabilityImpl", sb.toString());
        if (i == 1 || i == 2) {
            return BridgeActivity.getIntentStartBridgeActivity(activity, NotInstalledHmsResolution.class.getName());
        }
        if (i != 6) {
            if (i == 9 && Util.isAvailableLibExist(activity)) {
                return BridgeActivity.getIntentStartBridgeActivity(activity, AppSpoofResolution.class.getName());
            }
            return null;
        }
        return BridgeActivity.getIntentStartBridgeActivity(activity, BindingFailedResolution.class.getName());
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public final PendingIntent getResolveErrorPendingIntent(Activity activity, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("Enter getResolveErrorPendingIntent, errorCode: ");
        sb.append(i);
        HMSLog.i("HuaweiApiAvailabilityImpl", sb.toString());
        Intent resolveErrorIntent = getResolveErrorIntent(activity, i);
        if (resolveErrorIntent != null) {
            return PendingIntent.getActivity(activity, 0, resolveErrorIntent, 67108864);
        }
        return null;
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public final int isHuaweiMobileNoticeAvailable(Context context) {
        Checker.checkNonNull(context, "context must not be null.");
        if (PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(new PackageManagerHelper(context).getPackageStates(HMSPackageManager.getInstance(context).getHMSPackageNameForMultiService()))) {
            return 1;
        }
        return HMSPackageManager.getInstance(context).isApkUpdateNecessary(20600000) ? 2 : 0;
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public final int isHuaweiMobileServicesAvailable(Context context) {
        Checker.checkNonNull(context, "context must not be null.");
        return HuaweiMobileServicesUtil.isHuaweiMobileServicesAvailable(context, HuaweiApiAvailability.getServicesVersionCode());
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public final boolean isUserResolvableError(int i) {
        return isUserResolvableError(i, null);
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public final boolean isUserResolvableError(int i, PendingIntent pendingIntent) {
        if (i == 0) {
            return false;
        }
        return pendingIntent != null || i == 1 || i == 2 || i == 6 || i == 9;
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public final void popupErrNotification(Context context, ConnectionResult connectionResult) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(connectionResult);
        showErrorNotification(context, connectionResult.getErrorCode());
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public final void resolveError(Activity activity, int i, int i2) {
        resolveError(activity, i, i2, null);
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public final boolean showErrorDialogFragment(Activity activity, int i, int i2) {
        return showErrorDialogFragment(activity, i, i2, null);
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public final void showErrorNotification(Context context, int i) {
        Checker.checkNonNull(context, "context must not be null.");
        StringBuilder sb = new StringBuilder();
        sb.append("Enter showErrorNotification, errorCode: ");
        sb.append(i);
        HMSLog.i("HuaweiApiAvailabilityImpl", sb.toString());
        if (!(context instanceof Activity)) {
            HMSLog.i("HuaweiApiAvailabilityImpl", "context not instanceof Activity");
            return;
        }
        Dialog errorDialog = getErrorDialog((Activity) context, i, 0);
        if (errorDialog == null) {
            HMSLog.i("HuaweiApiAvailabilityImpl", "showErrorNotification errorDialog can not be null");
        } else {
            errorDialog.show();
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public final void resolveError(Activity activity, int i, int i2, PendingIntent pendingIntent) {
        Checker.checkNonNull(activity, "activity must not be null.");
        if (pendingIntent != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Enter resolveError, param pendingIntent is not null. and.errorCode: ");
            sb.append(i);
            HMSLog.i("HuaweiApiAvailabilityImpl", sb.toString());
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Enter resolveError, param pendingIntent is  null. get pendingIntent from error code.and.errorCode: ");
            sb2.append(i);
            HMSLog.i("HuaweiApiAvailabilityImpl", sb2.toString());
            pendingIntent = getResolveErrorPendingIntent(activity, i);
        }
        if (pendingIntent != null) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("In resolveError, start pendingIntent.errorCode: ");
            sb3.append(i);
            HMSLog.i("HuaweiApiAvailabilityImpl", sb3.toString());
            try {
                activity.startIntentSenderForResult(pendingIntent.getIntentSender(), i2, null, 0, 0, 0);
            } catch (IntentSender.SendIntentException unused) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Enter resolveError, start pendingIntent failed.errorCode: ");
                sb4.append(i);
                HMSLog.e("HuaweiApiAvailabilityImpl", sb4.toString());
            }
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public final boolean showErrorDialogFragment(Activity activity, int i, int i2, DialogInterface.OnCancelListener onCancelListener) {
        Dialog errorDialog = getErrorDialog(activity, i, i2, onCancelListener);
        if (errorDialog == null) {
            return false;
        }
        Checker.checkNonNull(activity, "activity must not be null.");
        ErrorDialogFragment.newInstance(errorDialog, onCancelListener).show(activity.getFragmentManager(), HuaweiMobileServicesUtil.HMS_ERROR_DIALOG);
        return true;
    }

    private static Intent MyBillsEntityDataFactory(Context context, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("Enter getResolveErrorIntent, errorCode: ");
        sb.append(i);
        HMSLog.i("HuaweiApiAvailabilityImpl", sb.toString());
        if (i == 1 || i == 2) {
            return BridgeActivity.getIntentStartBridgeActivity(context, NotInstalledHmsResolution.class.getName());
        }
        if (i != 6) {
            if (i == 9 && Util.isAvailableLibExist(context)) {
                return BridgeActivity.getIntentStartBridgeActivity(context, AppSpoofResolution.class.getName());
            }
            return null;
        }
        return BridgeActivity.getIntentStartBridgeActivity(context, BindingFailedResolution.class.getName());
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public final Dialog getErrorDialog(Activity activity, int i, int i2, DialogInterface.OnCancelListener onCancelListener) {
        Intent intentStartBridgeActivity;
        Checker.checkNonNull(activity, "activity must not be null.");
        StringBuilder sb = new StringBuilder();
        sb.append("Enter getErrorDialog, errorCode: ");
        sb.append(i);
        HMSLog.i("HuaweiApiAvailabilityImpl", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("getErrorResolutionIntent, errorCode: ");
        sb2.append(i);
        HMSLog.i("HuaweiApiAvailabilityImpl", sb2.toString());
        if (i == 1 || i == 2) {
            intentStartBridgeActivity = BridgeActivity.getIntentStartBridgeActivity(activity, DoNothingResolution.class.getName());
        } else if (i != 6) {
            intentStartBridgeActivity = (i == 9 && Util.isAvailableLibExist(activity)) ? BridgeActivity.getIntentStartBridgeActivity(activity, AppSpoofResolution.class.getName()) : null;
        } else {
            intentStartBridgeActivity = BridgeActivity.getIntentStartBridgeActivity(activity, BindingFailedResolution.class.getName());
        }
        DialogRedirect dialogRedirect = DialogRedirect.getInstance(activity, intentStartBridgeActivity, i2);
        if (i == 0) {
            return null;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, NotInstalledHmsDialogHelper.getDialogThemeId(activity));
        builder.setMessage(ConnectionErrorMessages.getErrorMessage(activity, i));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        builder.setPositiveButton(ConnectionErrorMessages.getErrorDialogButtonMessage(activity, i), dialogRedirect);
        String errorTitle = ConnectionErrorMessages.getErrorTitle(activity, i);
        if (errorTitle != null) {
            builder.setTitle(errorTitle);
        }
        return builder.create();
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public final PendingIntent getErrPendingIntent(Context context, int i, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append("Enter getResolveErrorPendingIntent, errorCode: ");
        sb.append(i);
        sb.append(" requestCode: ");
        sb.append(i2);
        HMSLog.i("HuaweiApiAvailabilityImpl", sb.toString());
        Intent MyBillsEntityDataFactory = MyBillsEntityDataFactory(context, i);
        if (MyBillsEntityDataFactory != null) {
            return PendingIntent.getActivity(context, i2, MyBillsEntityDataFactory, 67108864);
        }
        return null;
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public final int isHuaweiMobileServicesAvailable(Context context, int i) {
        Checker.checkNonNull(context, "context must not be null.");
        return HuaweiMobileServicesUtil.isHuaweiMobileServicesAvailable(context, i);
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public final boolean showErrorDialogFragment(Activity activity, int i, Fragment fragment, int i2, DialogInterface.OnCancelListener onCancelListener) {
        return showErrorDialogFragment(activity, i, i2, onCancelListener);
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public final Task<Void> checkApiAccessible(HuaweiApiCallable huaweiApiCallable, HuaweiApiCallable... huaweiApiCallableArr) {
        Task task = new TaskCompletionSource().MyBillsEntityDataFactory;
        if (huaweiApiCallable != null) {
            try {
                PlaceComponentResult(huaweiApiCallable);
            } catch (AvailabilityException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("HuaweiApiCallable checkApi has AvailabilityException ");
                sb.append(e.getMessage());
                HMSLog.i("HuaweiApiAvailabilityImpl", sb.toString());
            }
        }
        if (huaweiApiCallableArr != null) {
            for (HuaweiApiCallable huaweiApiCallable2 : huaweiApiCallableArr) {
                PlaceComponentResult(huaweiApiCallable2);
            }
        }
        return task;
    }

    private static void PlaceComponentResult(Object obj) throws AvailabilityException {
        ConnectionResult connectionResult;
        AvailabilityException availabilityException = new AvailabilityException();
        if (obj instanceof HuaweiApi) {
            connectionResult = availabilityException.getConnectionResult((HuaweiApi) obj);
        } else {
            connectionResult = availabilityException.getConnectionResult((HuaweiApiCallable) obj);
        }
        if (connectionResult.getErrorCode() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("The service is unavailable: ");
        sb.append(availabilityException.getMessage());
        HMSLog.i("HuaweiApiAvailabilityImpl", sb.toString());
        throw availabilityException;
    }
}
