package id.dana.danah5.sendevent;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.ipc.IpcMessageConstants;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.core.jsapi.device.location.RequestPermission;
import com.alipay.iap.android.wallet.acl.payment.PaymentResult;
import com.anggrayudi.storage.permission.PermissionCallback;
import com.anggrayudi.storage.permission.PermissionRequest;
import com.anggrayudi.storage.permission.PermissionResult;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import id.dana.danah5.globalnetwork.manager.CheckoutFinishGnEventPluginManager;
import id.dana.data.globalnetwork.source.remote.PaymentServiceProvider;
import id.dana.data.globalnetwork.source.remote.RemoteGnPaymentEntityData;
import id.dana.data.h5event.changephone.ChangePhoneFinishEntity;
import id.dana.data.h5event.changephone.ChangePhoneNumberEventManager;
import id.dana.data.h5event.sendmoney.CheckoutFinishEntity;
import id.dana.data.h5event.sendmoney.CheckoutFinishEventManager;
import id.dana.data.h5event.sendmoney.PayQueryResponse;
import id.dana.data.toggle.SplitFacade;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerGContainerComponent;
import id.dana.di.modules.GContainerModule;
import id.dana.domain.account.interactor.SaveLastTransaction;
import id.dana.globalnetwork.GnTopUpSaveDataManager;
import id.dana.globalnetwork.model.GnTopUpResultModel;
import id.dana.lib.gcontainer.app.bridge.core.BaseBridge;
import id.dana.lib.gcontainer.extension.BridgeExtensionExtKt;
import id.dana.sendmoney.domain.groupsend.GroupSendOperationType;
import id.dana.sync_engine.domain.interactor.GetContactsUseCase;
import id.dana.sync_engine.domain.model.ContactResult;
import id.dana.sync_engine.domain.model.SyncForFeature;
import id.dana.utils.extension.JSONExtKt;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.greenrobot.eventbus.EventBus;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 >2\u00020\u0001:\u0001>B\u0007¢\u0006\u0004\b=\u0010\u0010J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J)\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u0015\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J9\u0010\u001e\u001a\u00020\f2\b\b\u0001\u0010\u0017\u001a\u00020\u00162\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\b\u0001\u0010\u001b\u001a\u00020\u001a2\b\b\u0001\u0010\u001d\u001a\u00020\u001cH\u0007¢\u0006\u0004\b\u001e\u0010\u001fR\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001b\u0010 R\"\u0010\"\u001a\u00020!8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010)\u001a\u00020(8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00100\u001a\u00020/8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u00107\u001a\u0002068\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<"}, d2 = {"Lid/dana/danah5/sendevent/SendEventBridge;", "Lid/dana/lib/gcontainer/app/bridge/core/BaseBridge;", "Lid/dana/data/h5event/sendmoney/CheckoutFinishEntity;", "entity", "", "isErrorPage", "(Lid/dana/data/h5event/sendmoney/CheckoutFinishEntity;)Z", "", RequestPermission.REQUEST_CODE, "resultCode", "Landroid/content/Intent;", "data", "", "onActivityResult", "(IILandroid/content/Intent;)V", "onFinalized", "()V", "onInitialized", "Landroid/app/Activity;", AkuEventParamsKey.KEY_ACTIVITY, "processEvent", "(Landroid/app/Activity;)V", "", IpcMessageConstants.EXTRA_EVENT, "Lcom/alibaba/fastjson/JSONObject;", "info", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", "Lcom/alibaba/ariver/app/api/Page;", "page", "sendEvent", "(Ljava/lang/String;Lcom/alibaba/fastjson/JSONObject;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;Lcom/alibaba/ariver/app/api/Page;)V", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "Lid/dana/sync_engine/domain/interactor/GetContactsUseCase;", GroupSendOperationType.GROUP_GET_CONTACT_USE_CASE, "Lid/dana/sync_engine/domain/interactor/GetContactsUseCase;", "getGetContactsUseCase", "()Lid/dana/sync_engine/domain/interactor/GetContactsUseCase;", "setGetContactsUseCase", "(Lid/dana/sync_engine/domain/interactor/GetContactsUseCase;)V", "Lid/dana/data/globalnetwork/source/remote/RemoteGnPaymentEntityData;", "remoteGnPaymentEntityData", "Lid/dana/data/globalnetwork/source/remote/RemoteGnPaymentEntityData;", "getRemoteGnPaymentEntityData", "()Lid/dana/data/globalnetwork/source/remote/RemoteGnPaymentEntityData;", "setRemoteGnPaymentEntityData", "(Lid/dana/data/globalnetwork/source/remote/RemoteGnPaymentEntityData;)V", "Lid/dana/domain/account/interactor/SaveLastTransaction;", "saveLastTransaction", "Lid/dana/domain/account/interactor/SaveLastTransaction;", "getSaveLastTransaction", "()Lid/dana/domain/account/interactor/SaveLastTransaction;", "setSaveLastTransaction", "(Lid/dana/domain/account/interactor/SaveLastTransaction;)V", "Lid/dana/data/toggle/SplitFacade;", "splitFacade", "Lid/dana/data/toggle/SplitFacade;", "getSplitFacade", "()Lid/dana/data/toggle/SplitFacade;", "setSplitFacade", "(Lid/dana/data/toggle/SplitFacade;)V", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SendEventBridge extends BaseBridge {
    private static final String SUCCESS = "success";
    private static final String TOP_UP = "TOP_UP";
    private BridgeCallback bridgeCallback;
    @Inject
    public GetContactsUseCase getContactsUseCase;
    @Inject
    public RemoteGnPaymentEntityData remoteGnPaymentEntityData;
    @Inject
    public SaveLastTransaction saveLastTransaction;
    @Inject
    public SplitFacade splitFacade;

    @JvmName(name = "getRemoteGnPaymentEntityData")
    public final RemoteGnPaymentEntityData getRemoteGnPaymentEntityData() {
        RemoteGnPaymentEntityData remoteGnPaymentEntityData = this.remoteGnPaymentEntityData;
        if (remoteGnPaymentEntityData != null) {
            return remoteGnPaymentEntityData;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setRemoteGnPaymentEntityData")
    public final void setRemoteGnPaymentEntityData(RemoteGnPaymentEntityData remoteGnPaymentEntityData) {
        Intrinsics.checkNotNullParameter(remoteGnPaymentEntityData, "");
        this.remoteGnPaymentEntityData = remoteGnPaymentEntityData;
    }

    @JvmName(name = "getSplitFacade")
    public final SplitFacade getSplitFacade() {
        SplitFacade splitFacade = this.splitFacade;
        if (splitFacade != null) {
            return splitFacade;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setSplitFacade")
    public final void setSplitFacade(SplitFacade splitFacade) {
        Intrinsics.checkNotNullParameter(splitFacade, "");
        this.splitFacade = splitFacade;
    }

    @JvmName(name = "getSaveLastTransaction")
    public final SaveLastTransaction getSaveLastTransaction() {
        SaveLastTransaction saveLastTransaction = this.saveLastTransaction;
        if (saveLastTransaction != null) {
            return saveLastTransaction;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setSaveLastTransaction")
    public final void setSaveLastTransaction(SaveLastTransaction saveLastTransaction) {
        Intrinsics.checkNotNullParameter(saveLastTransaction, "");
        this.saveLastTransaction = saveLastTransaction;
    }

    @JvmName(name = "getGetContactsUseCase")
    public final GetContactsUseCase getGetContactsUseCase() {
        GetContactsUseCase getContactsUseCase = this.getContactsUseCase;
        if (getContactsUseCase != null) {
            return getContactsUseCase;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setGetContactsUseCase")
    public final void setGetContactsUseCase(GetContactsUseCase getContactsUseCase) {
        Intrinsics.checkNotNullParameter(getContactsUseCase, "");
        this.getContactsUseCase = getContactsUseCase;
    }

    @Override // id.dana.lib.gcontainer.app.bridge.core.BaseBridge, com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension, com.alibaba.ariver.kernel.api.extension.Extension
    public final void onInitialized() {
        super.onInitialized();
        DaggerGContainerComponent.Builder PlaceComponentResult = DaggerGContainerComponent.PlaceComponentResult();
        Application applicationContext = GriverEnv.getApplicationContext();
        if (applicationContext == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.DanaApplication");
        }
        PlaceComponentResult.PlaceComponentResult = (ApplicationComponent) Preconditions.getAuthRequestContext(((DanaApplication) applicationContext).getApplicationComponent());
        PlaceComponentResult.getAuthRequestContext = (GContainerModule) Preconditions.getAuthRequestContext(new GContainerModule());
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2().BuiltInFictitiousFunctionClassFactory(this);
    }

    @Override // id.dana.lib.gcontainer.app.bridge.core.BaseBridge, com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension, com.alibaba.ariver.kernel.api.extension.Extension
    public final void onFinalized() {
        getGetContactsUseCase().dispose();
        super.onFinalized();
    }

    @ThreadType(ExecutorType.NORMAL)
    @ActionFilter(canOverride = false)
    public final void sendEvent(@BindingParam(name = {"event"}) String eventName, @BindingParam(name = {"info"}) JSONObject info, @BindingCallback BridgeCallback bridgeCallback, @BindingNode(Page.class) Page page) {
        Context context;
        Object obj;
        JSONObject jSONObject;
        Object obj2;
        Intrinsics.checkNotNullParameter(eventName, "");
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        Intrinsics.checkNotNullParameter(page, "");
        final Activity activity = BridgeExtensionExtKt.getActivity(page);
        if (activity == null) {
            return;
        }
        this.bridgeCallback = bridgeCallback;
        int hashCode = eventName.hashCode();
        Object obj3 = null;
        ChangePhoneFinishEntity changePhoneFinishEntity = null;
        if (hashCode != -1939354664) {
            if (hashCode == -901986576) {
                if (eventName.equals(SendEventKey.CONTACT)) {
                    requestPermissions(activity, new String[]{"android.permission.READ_CONTACTS"}, new PermissionCallback() { // from class: id.dana.danah5.sendevent.SendEventBridge$sendEvent$1
                        @Override // com.anggrayudi.storage.permission.PermissionCallback
                        public final /* synthetic */ void onDisplayConsentDialog(PermissionRequest permissionRequest) {
                            PermissionCallback.CC.getAuthRequestContext(permissionRequest);
                        }

                        @Override // com.anggrayudi.storage.permission.PermissionCallback
                        public final /* synthetic */ void onShouldRedirectToSystemSettings(List list) {
                            PermissionCallback.CC.BuiltInFictitiousFunctionClassFactory(list);
                        }

                        @Override // com.anggrayudi.storage.permission.PermissionCallback
                        public final void onPermissionsChecked(PermissionResult result, boolean fromSystemDialog) {
                            Intrinsics.checkNotNullParameter(result, "");
                            if (result.MyBillsEntityDataFactory()) {
                                SendEventBridge.this.getGetContactsUseCase().executeInBackground(new GetContactsUseCase.Params(SyncForFeature.MobileRecharge, null, null, false, false, 30, null), new Function1<ContactResult, Unit>() { // from class: id.dana.danah5.sendevent.SendEventBridge$sendEvent$1$onPermissionsChecked$1
                                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                    public final void invoke2(ContactResult contactResult) {
                                        Intrinsics.checkNotNullParameter(contactResult, "");
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final /* bridge */ /* synthetic */ Unit invoke(ContactResult contactResult) {
                                        invoke2(contactResult);
                                        return Unit.INSTANCE;
                                    }
                                }, new Function1<Throwable, Unit>() { // from class: id.dana.danah5.sendevent.SendEventBridge$sendEvent$1$onPermissionsChecked$2
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                                        invoke2(th);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                    public final void invoke2(Throwable th) {
                                        Intrinsics.checkNotNullParameter(th, "");
                                        StringBuilder sb = new StringBuilder();
                                        sb.append(DanaLogConstants.Prefix.CONTACT_SYNC_PREFIX);
                                        sb.append(getClass().getName());
                                        sb.append("onError: ");
                                        sb.append(th.getMessage());
                                        DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.SYNC_CONTACT_TAG, sb.toString(), th);
                                    }
                                });
                                SendEventBridge.this.processEvent(activity);
                            }
                        }
                    });
                }
            } else if (hashCode == 790572537 && eventName.equals(SendEventKey.CHANGE_PHONE_FINISH)) {
                if (info != null) {
                    try {
                        obj3 = JSONObject.parseObject(info.toJSONString(), new TypeReference<ChangePhoneFinishEntity>() { // from class: id.dana.danah5.sendevent.SendEventBridge$sendEvent$$inlined$toObject$default$1
                        }, new Feature[0]);
                    } catch (JSONException | NullPointerException unused) {
                    }
                    changePhoneFinishEntity = (ChangePhoneFinishEntity) obj3;
                }
                ChangePhoneNumberEventManager.processEvent(changePhoneFinishEntity);
            }
        } else if (!eventName.equals(SendEventKey.CHECKOUT_FINISH) || (context = BridgeExtensionExtKt.getContext(page)) == null) {
        } else {
            if (info != null) {
                try {
                    obj = JSONObject.parseObject(info.toJSONString(), new TypeReference<JSONObject>() { // from class: id.dana.danah5.sendevent.SendEventBridge$sendEvent$lambda-1$$inlined$toObject$default$1
                    }, new Feature[0]);
                } catch (JSONException | NullPointerException unused2) {
                    obj = null;
                }
                jSONObject = (JSONObject) obj;
            } else {
                jSONObject = null;
            }
            CheckoutFinishEventManager.processEvent(context, jSONObject, getSplitFacade(), getSaveLastTransaction());
            CheckoutFinishGnEventPluginManager checkoutFinishGnEventPluginManager = new CheckoutFinishGnEventPluginManager(getRemoteGnPaymentEntityData());
            try {
                obj2 = JSONExtKt.PlaceComponentResult().fromJson(JSONExtKt.KClassImpl$Data$declaredNonStaticMembers$2(info != null ? info.toJSONString() : null, null), (Class<Object>) CheckoutFinishEntity.class);
            } catch (Exception unused3) {
                obj2 = null;
            }
            CheckoutFinishEntity checkoutFinishEntity = (CheckoutFinishEntity) obj2;
            if (checkoutFinishEntity != null && ((Intrinsics.areEqual(checkoutFinishEntity.getTransType(), "TOP_UP") || isErrorPage(checkoutFinishEntity)) && Intrinsics.areEqual(GnTopUpSaveDataManager.INSTANCE.PlaceComponentResult().BuiltInFictitiousFunctionClassFactory, Boolean.TRUE))) {
                boolean areEqual = Intrinsics.areEqual(checkoutFinishEntity.getProcessingStatus(), "success");
                PayQueryResponse payQueryResponse = checkoutFinishEntity.getPayQueryResponse();
                String errorCode = payQueryResponse != null ? payQueryResponse.getErrorCode() : null;
                PayQueryResponse payQueryResponse2 = checkoutFinishEntity.getPayQueryResponse();
                GnTopUpSaveDataManager.INSTANCE.PlaceComponentResult().MyBillsEntityDataFactory = new GnTopUpResultModel(areEqual, errorCode, payQueryResponse2 != null ? payQueryResponse2.getErrorMsg() : null);
            } else if (checkoutFinishEntity != null && checkoutFinishGnEventPluginManager.isGnScenario(checkoutFinishEntity) && !checkoutFinishGnEventPluginManager.isAcCashierGnScenario(checkoutFinishEntity)) {
                checkoutFinishGnEventPluginManager.sendCallbackResult(checkoutFinishEntity);
            } else if (checkoutFinishEntity != null && checkoutFinishGnEventPluginManager.isAcCashierGnScenario(checkoutFinishEntity)) {
                checkoutFinishGnEventPluginManager.sendCallbackResultWithoutCallback(checkoutFinishEntity);
            } else {
                PaymentResult paymentResult = new PaymentResult();
                paymentResult.setResultMessage(checkoutFinishEntity != null ? checkoutFinishEntity.getProcessingStatus() : null);
                paymentResult.setResultCode(checkoutFinishGnEventPluginManager.getPayStatus$app_productionRelease(paymentResult.getResultMessage()));
                EventBus.getDefault().post(new PaymentServiceProvider.MiniProgramPaymentCompletedMessageEvent(paymentResult));
            }
        }
    }

    public final void processEvent(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "");
        startActivityForResult(activity, new Intent("android.intent.action.PICK", ContactsContract.CommonDataKinds.Phone.CONTENT_URI), 101);
    }

    @Override // id.dana.lib.gcontainer.app.bridge.core.BaseBridge
    public final void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == -1 && requestCode == 101) {
            ContactEventManager contactEventManager = ContactEventManager.INSTANCE;
            BridgeCallback bridgeCallback = this.bridgeCallback;
            if (bridgeCallback == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                bridgeCallback = null;
            }
            contactEventManager.onReceiveActivityResult(bridgeCallback, requestCode, data);
        }
    }

    private final boolean isErrorPage(CheckoutFinishEntity entity) {
        if (((entity == null || entity.getApiSuccess()) ? false : true) && entity.getTransType() == null) {
            PayQueryResponse payQueryResponse = entity.getPayQueryResponse();
            String errorCode = payQueryResponse != null ? payQueryResponse.getErrorCode() : null;
            if (errorCode == null || StringsKt.isBlank(errorCode)) {
                return false;
            }
            PayQueryResponse payQueryResponse2 = entity.getPayQueryResponse();
            String errorMsg = payQueryResponse2 != null ? payQueryResponse2.getErrorMsg() : null;
            return !(errorMsg == null || StringsKt.isBlank(errorMsg));
        }
        return false;
    }
}
