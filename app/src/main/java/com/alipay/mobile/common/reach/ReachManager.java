package com.alipay.mobile.common.reach;

import android.app.Application;
import android.text.TextUtils;
import com.alipay.iap.android.common.product.delegate.UserInfoManager;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncMessage;
import com.alipay.iap.android.common.syncintegration.impl.IAPSyncMessageParsedCallback;
import com.alipay.iap.android.common.syncintegration.impl.SyncProvider;
import com.alipay.plus.push.core.PushMessageReceiver;
import com.alipay.plus.push.core.PushServiceInstance;
import com.alipay.plus.push.core.model.PushSource;
import com.alipay.plus.push.core.pushservice.IPushService;
import java.util.HashMap;
import java.util.List;
import reach.IAPReachMsgModel;
import reach.IReachManager;
import reach.MessageReceiver;

/* loaded from: classes.dex */
public class ReachManager implements IReachManager {
    private MessageReceiver<String> globalMessageReceiver;
    public IPushService iPushService;
    HashMap<String, MessageReceiver> receiverHashMap;
    private SyncProvider syncProvider;
    private String userId;

    /* loaded from: classes3.dex */
    static class SingletonReachManagerInstance {
        private static final ReachManager IAP_REACH_MANAGER = new ReachManager();

        private SingletonReachManagerInstance() {
        }
    }

    public static ReachManager getInstance() {
        return SingletonReachManagerInstance.IAP_REACH_MANAGER;
    }

    private ReachManager() {
    }

    public void init(Application application) {
        this.iPushService = PushServiceInstance.create(application, PushSource.FCM);
        this.syncProvider = new SyncProvider();
        this.receiverHashMap = new HashMap<>();
        this.userId = UserInfoManager.instance().getUserId();
    }

    public void registerMsgReceiver(final String str, MessageReceiver messageReceiver) {
        if (TextUtils.isEmpty(str) || messageReceiver == null) {
            return;
        }
        this.receiverHashMap.put(str, messageReceiver);
        IPushService iPushService = this.iPushService;
        if (iPushService != null) {
            iPushService.registerMsgReceiver(str, new PushMessageReceiver() { // from class: com.alipay.mobile.common.reach.ReachManager.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.alipay.plus.push.core.PushMessageReceiver
                public void onMessageReceived(Object obj) {
                    MessageReceiver messageReceiver2 = ReachManager.this.receiverHashMap.get(str);
                    if (messageReceiver2 != null) {
                        IAPReachMsgModel iAPReachMsgModel = new IAPReachMsgModel();
                        iAPReachMsgModel.KClassImpl$Data$declaredNonStaticMembers$2 = obj;
                        iAPReachMsgModel.BuiltInFictitiousFunctionClassFactory = obj.toString();
                        messageReceiver2.MyBillsEntityDataFactory(iAPReachMsgModel);
                    }
                }
            });
        }
        SyncProvider syncProvider = this.syncProvider;
        if (syncProvider != null) {
            syncProvider.registerReceiveCallback(str, new IAPSyncMessageParsedCallback() { // from class: com.alipay.mobile.common.reach.ReachManager.2
                @Override // com.alipay.iap.android.common.syncintegration.impl.IAPSyncMessageParsedCallback
                public void onReceiveParsedSyncMessage(IAPSyncMessage iAPSyncMessage, String str2, List<String> list) {
                    ReachManager.this.onReceiveSyncData(iAPSyncMessage, str);
                }
            });
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [T, java.lang.String] */
    public void onReceiveSyncData(IAPSyncMessage iAPSyncMessage, String str) {
        MessageReceiver messageReceiver = this.receiverHashMap.get(str);
        if (messageReceiver != null) {
            IAPReachMsgModel iAPReachMsgModel = new IAPReachMsgModel();
            iAPReachMsgModel.KClassImpl$Data$declaredNonStaticMembers$2 = iAPSyncMessage.msgData;
            iAPReachMsgModel.BuiltInFictitiousFunctionClassFactory = iAPSyncMessage.msgData;
            messageReceiver.MyBillsEntityDataFactory(iAPReachMsgModel);
        }
    }

    public void registerGlobalMsgReceiver(MessageReceiver<String> messageReceiver) {
        this.globalMessageReceiver = messageReceiver;
        IPushService iPushService = this.iPushService;
        if (iPushService != null) {
            iPushService.registerGlobalMsgReceiver(new PushMessageReceiver<String>() { // from class: com.alipay.mobile.common.reach.ReachManager.3
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.alipay.plus.push.core.PushMessageReceiver
                public void onMessageReceived(String str) {
                    IAPReachMsgModel iAPReachMsgModel = new IAPReachMsgModel();
                    iAPReachMsgModel.KClassImpl$Data$declaredNonStaticMembers$2 = str;
                    iAPReachMsgModel.BuiltInFictitiousFunctionClassFactory = str;
                    ReachManager.this.globalMessageReceiver.MyBillsEntityDataFactory(iAPReachMsgModel);
                }
            });
        }
    }

    public void dispatchMessage(Object obj) {
        IPushService iPushService;
        if (obj == null || (iPushService = this.iPushService) == null) {
            return;
        }
        iPushService.dispatchMessage(obj);
    }

    public void unregisterMsgReceiver(MessageReceiver messageReceiver) {
        for (String str : this.receiverHashMap.keySet()) {
            if (this.receiverHashMap.get(str) == messageReceiver) {
                this.receiverHashMap.remove(str);
            }
        }
    }

    public void report(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.iPushService.report(str, null);
    }

    public void setSyncProvider(SyncProvider syncProvider) {
        this.syncProvider = syncProvider;
    }
}
