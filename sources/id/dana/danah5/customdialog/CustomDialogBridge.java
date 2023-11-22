package id.dana.danah5.customdialog;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;
import android.widget.CompoundButton;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.ipc.IpcMessageConstants;
import com.alibaba.fastjson.JSONObject;
import id.dana.R;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import id.dana.danah5.constant.BridgeName;
import id.dana.danah5.customdialog.CustomDialogKey;
import id.dana.dialog.CommonDialog;
import id.dana.dialog.DialogPermission;
import id.dana.dialog.DialogWithImage;
import id.dana.dialog.TwoButtonWithImageDialog;
import id.dana.lib.gcontainer.extension.BridgeExtensionExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u001f\u0010 J7\u0010\u000b\u001a\u00020\n2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0012J\u001f\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0014\u0010\u0012J\u001f\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0015\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e"}, d2 = {"Lid/dana/danah5/customdialog/CustomDialogBridge;", "Lcom/alibaba/ariver/kernel/api/extension/bridge/SimpleBridgeExtension;", "", IpcMessageConstants.EXTRA_EVENT, "Lcom/alibaba/fastjson/JSONObject;", "info", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", "Lcom/alibaba/ariver/app/api/Page;", "page", "", BridgeName.CUSTOM_DIALOG, "(Ljava/lang/String;Lcom/alibaba/fastjson/JSONObject;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;Lcom/alibaba/ariver/app/api/Page;)V", "btnOrientation", "", "getPermissionDialogType", "(Ljava/lang/String;)I", "renderCommonDialog", "(Lcom/alibaba/fastjson/JSONObject;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;)V", "renderHorizontalImageDialog", "renderLocationDialog", "renderVerticalImageDialog", "Landroid/app/Activity;", AkuEventParamsKey.KEY_ACTIVITY, "Landroid/app/Activity;", "Lid/dana/dialog/CommonDialog;", "commonDialog", "Lid/dana/dialog/CommonDialog;", "Lid/dana/dialog/DialogPermission;", "dialogPermission", "Lid/dana/dialog/DialogPermission;", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CustomDialogBridge extends SimpleBridgeExtension {
    private static final String HORIZONTAL = "horizontal";
    private static final String VERTICAL = "vertical";
    private Activity activity;
    private CommonDialog commonDialog;
    private DialogPermission dialogPermission;

    @ThreadType(ExecutorType.UI)
    @ActionFilter(canOverride = false)
    public final void customDialog(@BindingParam(name = {"event"}) String eventName, @BindingParam(name = {"info"}) JSONObject info, @BindingCallback BridgeCallback bridgeCallback, @BindingNode(Page.class) Page page) {
        Intrinsics.checkNotNullParameter(eventName, "");
        Intrinsics.checkNotNullParameter(info, "");
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        Intrinsics.checkNotNullParameter(page, "");
        Activity activity = BridgeExtensionExtKt.getActivity(page);
        if (activity == null) {
            return;
        }
        this.activity = activity;
        switch (eventName.hashCode()) {
            case -1605063445:
                if (eventName.equals(CustomDialogKey.Event.OVERLAY_DIALOG_ILLUSTRATION_VERTICAL)) {
                    renderVerticalImageDialog(info, bridgeCallback);
                    return;
                }
                return;
            case -1354814997:
                if (eventName.equals(CustomDialogKey.Event.COMMON)) {
                    renderCommonDialog(info, bridgeCallback);
                    return;
                }
                return;
            case 609372249:
                if (eventName.equals(CustomDialogKey.Event.OVERLAY_DIALOG_ILLUSTRATION_HORIZONTAL)) {
                    renderHorizontalImageDialog(info, bridgeCallback);
                    return;
                }
                return;
            case 1901043637:
                if (eventName.equals("location")) {
                    renderLocationDialog(info, bridgeCallback);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private final void renderVerticalImageDialog(JSONObject info, final BridgeCallback bridgeCallback) {
        DialogWithImage.Builder MyBillsEntityDataFactory = new DialogWithImage.Builder().MyBillsEntityDataFactory(true);
        Boolean bool = info.getBoolean("cancelOutside");
        Intrinsics.checkNotNullExpressionValue(bool, "");
        DialogWithImage.Builder KClassImpl$Data$declaredNonStaticMembers$2 = MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(bool.booleanValue());
        KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = info.getString("topImage");
        KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue = info.getString("title");
        KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = info.getString("description");
        KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0 = info.getString("positiveButtonText");
        KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = info.getString("negativeButtonText");
        KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = new DialogInterface.OnClickListener() { // from class: id.dana.danah5.customdialog.CustomDialogBridge$$ExternalSyntheticLambda4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                CustomDialogBridge.m648renderVerticalImageDialog$lambda2(BridgeCallback.this, dialogInterface, i);
            }
        };
        Activity activity = this.activity;
        if (activity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            activity = null;
        }
        new DialogWithImage(activity, KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest, KClassImpl$Data$declaredNonStaticMembers$2, (byte) 0).MyBillsEntityDataFactory();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: renderVerticalImageDialog$lambda-2  reason: not valid java name */
    public static final void m648renderVerticalImageDialog$lambda2(BridgeCallback bridgeCallback, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        if (-1 == i) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(CustomDialogKey.Response.POSITIVE_CLICK, (Object) Boolean.TRUE);
            bridgeCallback.sendJSONResponse(jSONObject);
        } else {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(CustomDialogKey.Response.POSITIVE_CLICK, (Object) Boolean.FALSE);
            bridgeCallback.sendJSONResponse(jSONObject2);
        }
        dialogInterface.dismiss();
    }

    /* JADX WARN: Type inference failed for: r9v2, types: [id.dana.base.BaseMaterialDialog, T, id.dana.dialog.TwoButtonWithImageDialog] */
    private final void renderHorizontalImageDialog(JSONObject info, final BridgeCallback bridgeCallback) {
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Activity activity = this.activity;
        if (activity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            activity = null;
        }
        TwoButtonWithImageDialog.Builder builder = new TwoButtonWithImageDialog.Builder(activity);
        builder.FragmentBottomSheetPaymentSettingBinding = info.getString("title");
        builder.getErrorConfigVersion = info.getString("description");
        builder.scheduleImpl = info.getString("topImage");
        TwoButtonWithImageDialog.Builder PlaceComponentResult = builder.PlaceComponentResult(true);
        Boolean bool = info.getBoolean("cancelOutside");
        Intrinsics.checkNotNullExpressionValue(bool, "");
        TwoButtonWithImageDialog.Builder MyBillsEntityDataFactory = PlaceComponentResult.MyBillsEntityDataFactory(bool.booleanValue());
        String string = info.getString("positiveButtonText");
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: id.dana.danah5.customdialog.CustomDialogBridge$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CustomDialogBridge.m645renderHorizontalImageDialog$lambda5(BridgeCallback.this, objectRef, booleanRef, view);
            }
        };
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda8 = string;
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda4 = onClickListener;
        String string2 = info.getString("negativeButtonText");
        View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: id.dana.danah5.customdialog.CustomDialogBridge$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CustomDialogBridge.m646renderHorizontalImageDialog$lambda7(BridgeCallback.this, objectRef, booleanRef, view);
            }
        };
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda2 = string2;
        MyBillsEntityDataFactory.DatabaseTableConfigUtil = onClickListener2;
        Activity activity2 = this.activity;
        if (activity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            activity2 = null;
        }
        MyBillsEntityDataFactory.lookAheadTest = activity2.getString(R.string.sdet_img_dialog);
        Activity activity3 = this.activity;
        if (activity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            activity3 = null;
        }
        String string3 = activity3.getString(R.string.sdet_lbl_dialog);
        Activity activity4 = this.activity;
        if (activity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            activity4 = null;
        }
        String string4 = activity4.getString(R.string.sdet_desc_dialog);
        MyBillsEntityDataFactory.SubSequence = string3;
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = string4;
        Activity activity5 = this.activity;
        if (activity5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            activity5 = null;
        }
        MyBillsEntityDataFactory.PrepareContext = activity5.getString(R.string.sdet_btn_positive_dialog);
        Activity activity6 = this.activity;
        if (activity6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            activity6 = null;
        }
        MyBillsEntityDataFactory.GetContactSyncConfig = activity6.getString(R.string.sdet_btn_negative_dialog);
        String string5 = info.getString("checkboxText");
        String str = string5;
        String str2 = (str == null || str.length() == 0) ^ true ? string5 : null;
        if (str2 != null) {
            CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: id.dana.danah5.customdialog.CustomDialogBridge$$ExternalSyntheticLambda7
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    CustomDialogBridge.m644renderHorizontalImageDialog$lambda10$lambda9(Ref.BooleanRef.this, compoundButton, z);
                }
            };
            MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = str2;
            MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda7 = onCheckedChangeListener;
        }
        ?? KClassImpl$Data$declaredNonStaticMembers$2 = MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory();
        objectRef.element = KClassImpl$Data$declaredNonStaticMembers$2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: renderHorizontalImageDialog$lambda-5  reason: not valid java name */
    public static final void m645renderHorizontalImageDialog$lambda5(BridgeCallback bridgeCallback, Ref.ObjectRef objectRef, Ref.BooleanRef booleanRef, View view) {
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        Intrinsics.checkNotNullParameter(objectRef, "");
        Intrinsics.checkNotNullParameter(booleanRef, "");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(CustomDialogKey.Response.POSITIVE_CLICK, (Object) Boolean.TRUE);
        jSONObject.put(CustomDialogKey.Response.IS_CHECKED, (Object) Boolean.valueOf(booleanRef.element));
        bridgeCallback.sendJSONResponse(jSONObject);
        TwoButtonWithImageDialog twoButtonWithImageDialog = (TwoButtonWithImageDialog) objectRef.element;
        if (twoButtonWithImageDialog != null) {
            twoButtonWithImageDialog.getAuthRequestContext();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: renderHorizontalImageDialog$lambda-7  reason: not valid java name */
    public static final void m646renderHorizontalImageDialog$lambda7(BridgeCallback bridgeCallback, Ref.ObjectRef objectRef, Ref.BooleanRef booleanRef, View view) {
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        Intrinsics.checkNotNullParameter(objectRef, "");
        Intrinsics.checkNotNullParameter(booleanRef, "");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(CustomDialogKey.Response.POSITIVE_CLICK, (Object) Boolean.FALSE);
        jSONObject.put(CustomDialogKey.Response.IS_CHECKED, (Object) Boolean.valueOf(booleanRef.element));
        bridgeCallback.sendJSONResponse(jSONObject);
        TwoButtonWithImageDialog twoButtonWithImageDialog = (TwoButtonWithImageDialog) objectRef.element;
        if (twoButtonWithImageDialog != null) {
            twoButtonWithImageDialog.getAuthRequestContext();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: renderHorizontalImageDialog$lambda-10$lambda-9  reason: not valid java name */
    public static final void m644renderHorizontalImageDialog$lambda10$lambda9(Ref.BooleanRef booleanRef, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(booleanRef, "");
        booleanRef.element = z;
    }

    private final void renderLocationDialog(JSONObject info, final BridgeCallback bridgeCallback) {
        if (this.dialogPermission == null) {
            String string = info.getString("btnOrientation");
            if (string == null) {
                string = "vertical";
            }
            Activity activity = this.activity;
            Activity activity2 = null;
            if (activity == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                activity = null;
            }
            DialogPermission.Builder builder = new DialogPermission.Builder(activity, new DialogInterface.OnDismissListener() { // from class: id.dana.danah5.customdialog.CustomDialogBridge$$ExternalSyntheticLambda3
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    CustomDialogBridge.m647renderLocationDialog$lambda12(CustomDialogBridge.this, dialogInterface);
                }
            });
            builder.initRecordTimeStamp = getPermissionDialogType(string);
            builder.scheduleImpl = R.drawable.ic_request_location;
            builder.NetworkUserEntityData$$ExternalSyntheticLambda1 = info.getString("title");
            builder.lookAheadTest = info.getString("message");
            Boolean bool = info.getBoolean("cancelOutside");
            Intrinsics.checkNotNullExpressionValue(bool, "");
            DialogPermission.Builder KClassImpl$Data$declaredNonStaticMembers$2 = builder.KClassImpl$Data$declaredNonStaticMembers$2(bool.booleanValue());
            Activity activity3 = this.activity;
            if (activity3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                activity2 = activity3;
            }
            KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = activity2.getString(R.string.allow_permission_services);
            KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0 = new DialogPermission.DialogListener() { // from class: id.dana.danah5.customdialog.CustomDialogBridge$renderLocationDialog$2
                @Override // id.dana.dialog.DialogPermission.DialogListener
                public final void onDialogDismissed() {
                }

                @Override // id.dana.dialog.DialogPermission.DialogListener
                public final void onPositiveButtonClicked() {
                    DialogPermission dialogPermission;
                    BridgeCallback bridgeCallback2 = BridgeCallback.this;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("checkPermission", (Object) Boolean.TRUE);
                    bridgeCallback2.sendJSONResponse(jSONObject);
                    dialogPermission = this.dialogPermission;
                    if (dialogPermission != null) {
                        dialogPermission.getAuthRequestContext();
                    }
                }

                @Override // id.dana.dialog.DialogPermission.DialogListener
                public final void onNegativeButtonClicked() {
                    DialogPermission dialogPermission;
                    BridgeCallback bridgeCallback2 = BridgeCallback.this;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("checkPermission", (Object) Boolean.FALSE);
                    bridgeCallback2.sendJSONResponse(jSONObject);
                    dialogPermission = this.dialogPermission;
                    if (dialogPermission != null) {
                        dialogPermission.getAuthRequestContext();
                    }
                }
            };
            this.dialogPermission = new DialogPermission(KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory, KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue, KClassImpl$Data$declaredNonStaticMembers$2, (byte) 0);
        }
        DialogPermission dialogPermission = this.dialogPermission;
        if (dialogPermission != null) {
            dialogPermission.MyBillsEntityDataFactory();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: renderLocationDialog$lambda-12  reason: not valid java name */
    public static final void m647renderLocationDialog$lambda12(CustomDialogBridge customDialogBridge, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(customDialogBridge, "");
        customDialogBridge.dialogPermission = null;
    }

    private final int getPermissionDialogType(String btnOrientation) {
        String lowerCase = btnOrientation.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "");
        if (Intrinsics.areEqual(lowerCase, "horizontal")) {
            return 1;
        }
        Intrinsics.areEqual(lowerCase, "vertical");
        return 0;
    }

    private final void renderCommonDialog(JSONObject info, final BridgeCallback bridgeCallback) {
        if (this.commonDialog == null) {
            Activity activity = this.activity;
            Activity activity2 = null;
            if (activity == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                activity = null;
            }
            CommonDialog.Builder builder = new CommonDialog.Builder(activity);
            builder.MyBillsEntityDataFactory = new DialogInterface.OnDismissListener() { // from class: id.dana.danah5.customdialog.CustomDialogBridge$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    CustomDialogBridge.m641renderCommonDialog$lambda13(CustomDialogBridge.this, dialogInterface);
                }
            };
            builder.GetContactSyncConfig = info.getString("title");
            builder.KClassImpl$Data$declaredNonStaticMembers$2 = info.getString("message");
            Activity activity3 = this.activity;
            if (activity3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                activity3 = null;
            }
            String string = activity3.getString(R.string.dialog_positive);
            Intrinsics.checkNotNullExpressionValue(string, "");
            String upperCase = string.toUpperCase();
            Intrinsics.checkNotNullExpressionValue(upperCase, "");
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: id.dana.danah5.customdialog.CustomDialogBridge$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CustomDialogBridge.m642renderCommonDialog$lambda15(BridgeCallback.this, view);
                }
            };
            builder.lookAheadTest = upperCase;
            builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = onClickListener;
            Activity activity4 = this.activity;
            if (activity4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                activity2 = activity4;
            }
            String string2 = activity2.getString(R.string.dialog_negative);
            Intrinsics.checkNotNullExpressionValue(string2, "");
            String upperCase2 = string2.toUpperCase();
            Intrinsics.checkNotNullExpressionValue(upperCase2, "");
            View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: id.dana.danah5.customdialog.CustomDialogBridge$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CustomDialogBridge.m643renderCommonDialog$lambda17(BridgeCallback.this, view);
                }
            };
            builder.moveToNextValue = upperCase2;
            builder.getErrorConfigVersion = onClickListener2;
            Boolean bool = info.getBoolean("autoDismiss");
            Intrinsics.checkNotNullExpressionValue(bool, "");
            builder.PlaceComponentResult = bool.booleanValue();
            builder.getAuthRequestContext = info.getInteger("delay").intValue();
            Boolean bool2 = info.getBoolean("cancelOutside");
            Intrinsics.checkNotNullExpressionValue(bool2, "");
            CommonDialog.Builder PlaceComponentResult = builder.PlaceComponentResult(bool2.booleanValue());
            this.commonDialog = new CommonDialog(PlaceComponentResult.BuiltInFictitiousFunctionClassFactory, PlaceComponentResult.MyBillsEntityDataFactory, PlaceComponentResult.scheduleImpl, PlaceComponentResult);
        }
        CommonDialog commonDialog = this.commonDialog;
        if (commonDialog != null) {
            commonDialog.MyBillsEntityDataFactory();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: renderCommonDialog$lambda-13  reason: not valid java name */
    public static final void m641renderCommonDialog$lambda13(CustomDialogBridge customDialogBridge, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(customDialogBridge, "");
        customDialogBridge.commonDialog = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: renderCommonDialog$lambda-15  reason: not valid java name */
    public static final void m642renderCommonDialog$lambda15(BridgeCallback bridgeCallback, View view) {
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(CustomDialogKey.Response.POSITIVE_CLICK, (Object) Boolean.TRUE);
        bridgeCallback.sendJSONResponse(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: renderCommonDialog$lambda-17  reason: not valid java name */
    public static final void m643renderCommonDialog$lambda17(BridgeCallback bridgeCallback, View view) {
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(CustomDialogKey.Response.POSITIVE_CLICK, (Object) Boolean.FALSE);
        bridgeCallback.sendJSONResponse(jSONObject);
    }
}
