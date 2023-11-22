package com.alibaba.ariver.app.ipc;

import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import androidx.collection.LongSparseArray;
import com.alibaba.ariver.app.AppNode;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.AppManager;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.RVTraceKey;
import com.alibaba.ariver.kernel.common.utils.RVTraceUtils;
import com.alibaba.ariver.kernel.ipc.IpcMessage;
import com.alibaba.ariver.kernel.ipc.IpcMessageConstants;
import com.alibaba.ariver.kernel.ipc.IpcMessageHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class ClientMsgReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static ClientMsgReceiver f5981a;
    private static final Map<String, IpcMessageHandler> b = new HashMap();
    private static final LongSparseArray<IpcMessageHandler> c = new LongSparseArray<>();
    private static final LongSparseArray<List<IpcMessage>> d = new LongSparseArray<>();

    private ClientMsgReceiver() {
    }

    public static ClientMsgReceiver getInstance() {
        ClientMsgReceiver clientMsgReceiver;
        ClientMsgReceiver clientMsgReceiver2 = f5981a;
        if (clientMsgReceiver2 == null) {
            synchronized (ClientMsgReceiver.class) {
                if (f5981a == null) {
                    f5981a = new ClientMsgReceiver();
                }
                clientMsgReceiver = f5981a;
            }
            return clientMsgReceiver;
        }
        return clientMsgReceiver2;
    }

    public void registerAppHandler(App app) {
        long startToken = app.getStartToken();
        IpcMessageHandler msgHandler = app.getMsgHandler();
        StringBuilder sb = new StringBuilder();
        sb.append("registerAppHandler ");
        sb.append(startToken);
        RVLogger.d("AriverInt:IpcClient", sb.toString());
        synchronized (ClientMsgReceiver.class) {
            c.getAuthRequestContext(startToken, msgHandler);
            List<IpcMessage> MyBillsEntityDataFactory = d.MyBillsEntityDataFactory(startToken, null);
            if (MyBillsEntityDataFactory != null) {
                Iterator<IpcMessage> it = MyBillsEntityDataFactory.iterator();
                while (it.hasNext()) {
                    msgHandler.handleMessage(it.next());
                }
            }
            d.PlaceComponentResult(startToken);
        }
    }

    public void unRegisterAppHandler(long j) {
        synchronized (ClientMsgReceiver.class) {
            StringBuilder sb = new StringBuilder();
            sb.append("unRegisterAppHandler ");
            sb.append(j);
            RVLogger.d("AriverInt:IpcClient", sb.toString());
            d.PlaceComponentResult(j);
            c.PlaceComponentResult(j);
        }
    }

    public void registerBizHandler(String str, IpcMessageHandler ipcMessageHandler) {
        synchronized (ClientMsgReceiver.class) {
            b.put(str, ipcMessageHandler);
        }
    }

    public void unRegisterBizHandler(String str) {
        synchronized (ClientMsgReceiver.class) {
            b.remove(str);
        }
    }

    private void a(long j, IpcMessage ipcMessage) {
        synchronized (ClientMsgReceiver.class) {
            LongSparseArray<List<IpcMessage>> longSparseArray = d;
            List<IpcMessage> MyBillsEntityDataFactory = longSparseArray.MyBillsEntityDataFactory(j, null);
            if (MyBillsEntityDataFactory == null) {
                MyBillsEntityDataFactory = new ArrayList<>();
                longSparseArray.getAuthRequestContext(j, MyBillsEntityDataFactory);
            }
            MyBillsEntityDataFactory.add(ipcMessage);
        }
    }

    public void handleMessage(IpcMessage ipcMessage) {
        if (ipcMessage.bizMsg != null && ipcMessage.bizMsg.getData() != null) {
            ipcMessage.bizMsg.getData().setClassLoader(ClientMsgReceiver.class.getClassLoader());
        }
        if (TextUtils.isEmpty(ipcMessage.biz)) {
            return;
        }
        Message message = ipcMessage.bizMsg;
        if (IpcMessageConstants.BIZ_APP.equals(ipcMessage.biz)) {
            long j = BundleUtils.getLong(message.getData(), RVConstants.EXTRA_START_TOKEN, -1L);
            StringBuilder sb = new StringBuilder();
            sb.append("ClientMsgReceiver handle app message what: ");
            sb.append(message.what);
            sb.append(" token: ");
            sb.append(j);
            RVLogger.d("AriverInt:IpcClient", sb.toString());
            if (j > 0) {
                synchronized (ClientMsgReceiver.class) {
                    if (message.what == 6) {
                        a(j, message);
                        return;
                    }
                    IpcMessageHandler MyBillsEntityDataFactory = c.MyBillsEntityDataFactory(j, null);
                    if (MyBillsEntityDataFactory != null) {
                        MyBillsEntityDataFactory.handleMessage(ipcMessage);
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("ClientMsgReceiver handleMessage ");
                        sb2.append(ipcMessage);
                        sb2.append(" with ");
                        sb2.append(j);
                        sb2.append(" add pending!");
                        RVLogger.w("AriverInt:IpcClient", sb2.toString());
                        a(j, ipcMessage);
                    }
                    return;
                }
            }
            return;
        }
        IpcMessageHandler ipcMessageHandler = b.get(ipcMessage.biz);
        if (ipcMessageHandler != null) {
            ipcMessageHandler.handleMessage(ipcMessage);
            return;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("ClientMsgReceiver biz ");
        sb3.append(ipcMessage.biz);
        sb3.append(" not registered");
        RVLogger.d("AriverInt:IpcClient", sb3.toString());
    }

    private void a(final long j, Message message) {
        StringBuilder sb = new StringBuilder();
        sb.append("quickStartApp! ");
        sb.append(j);
        RVLogger.d("AriverInt:IpcClient", sb.toString());
        final String string = BundleUtils.getString(message.getData(), "appId");
        final Bundle bundle = (Bundle) BundleUtils.getParcelable(message.getData(), "startParams");
        final Bundle bundle2 = (Bundle) BundleUtils.getParcelable(message.getData(), RVConstants.EXTRA_SCENE_PARAMS);
        ExecutorUtils.runNotOnMain(ExecutorType.URGENT_DISPLAY, new Runnable() { // from class: com.alibaba.ariver.app.ipc.ClientMsgReceiver.1
            @Override // java.lang.Runnable
            public void run() {
                ClientMsgReceiver.this.manualStartApp(j, string, bundle, bundle2);
                RVLogger.d("AriverInt:IpcClient", "end quickStartApp!");
            }
        });
    }

    public void manualPreCreateApp(long j, String str, Bundle bundle, Bundle bundle2) {
        AppManager appManager = (AppManager) RVProxy.get(AppManager.class);
        synchronized (AppManager.class) {
            if (j > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("manualPreCreateApp, startToken: ");
                sb.append(j);
                RVLogger.d("AriverInt:IpcClient", sb.toString());
                if (appManager.findAppByToken(j) == null) {
                    appManager.preCreateApp(str, bundle, bundle2);
                }
            }
        }
    }

    public void manualStartApp(long j, String str, Bundle bundle, Bundle bundle2) {
        RVTraceUtils.traceBeginSection(RVTraceKey.RV_App_manualStartApp);
        AppManager appManager = (AppManager) RVProxy.get(AppManager.class);
        synchronized (AppManager.class) {
            if (j > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("manualStartApp, startToken: ");
                sb.append(j);
                RVLogger.d("AriverInt:IpcClient", sb.toString());
                App findAppByToken = appManager.findAppByToken(j);
                if (findAppByToken == null || !((AppNode) findAppByToken).isInited()) {
                    findAppByToken = appManager.startApp(str, bundle, bundle2);
                }
                if (findAppByToken != null) {
                    findAppByToken.start();
                }
            }
        }
        RVTraceUtils.traceEndSection(RVTraceKey.RV_App_manualStartApp);
    }
}
