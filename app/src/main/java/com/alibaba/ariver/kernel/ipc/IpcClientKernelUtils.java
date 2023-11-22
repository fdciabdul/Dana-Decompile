package com.alibaba.ariver.kernel.ipc;

import android.os.Bundle;
import android.os.Message;
import android.os.RemoteException;
import com.alibaba.ariver.kernel.api.IIpcChannel;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.ipc.IpcChannelManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class IpcClientKernelUtils {
    public static final String LOG_TAG = "AriverInt:IpcClient";

    /* renamed from: a  reason: collision with root package name */
    private static final List<IpcMessage> f6169a = new ArrayList();
    private static final AtomicBoolean b = new AtomicBoolean(false);

    public static boolean enableBridgeCatchIpcException() {
        return ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigBoolean("ariver_catchApiIpcException", true);
    }

    public static void sendMsgToServer(String str, int i, Bundle bundle) {
        try {
            sendMsgToServerUnSafe(str, i, bundle);
        } catch (RemoteException e) {
            RVLogger.w("AriverInt:IpcClient", "sendMsgToServer exception!", e);
        }
    }

    public static void sendMsgToServerUnSafe(String str, int i, Bundle bundle) throws RemoteException {
        Message obtain = Message.obtain();
        obtain.what = i;
        if (bundle == null) {
            bundle = new Bundle();
        }
        int lpid = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getLpid();
        bundle.putBoolean(IpcMessageConstants.EXTRA_FROM_LITE_PROCESS, !ProcessUtils.isMainProcess());
        bundle.putInt(IpcMessageConstants.EXTRA_LPID, lpid);
        obtain.setData(bundle);
        IpcMessage ipcMessage = new IpcMessage();
        ipcMessage.biz = str;
        ipcMessage.bizMsg = obtain;
        ipcMessage.clientId = ProcessUtils.getProcessName();
        ipcMessage.pid = ProcessUtils.getPid();
        ipcMessage.lpid = lpid;
        synchronized (f6169a) {
            IIpcChannel serverChannel = IpcChannelManager.getInstance().getServerChannel();
            if (serverChannel != null) {
                serverChannel.sendMessage(ipcMessage);
            } else {
                a(ipcMessage);
                RVLogger.w("AriverInt:IpcClient", "sendMsgToServer but cannot find serverProxy!");
            }
        }
    }

    private static void a(IpcMessage ipcMessage) {
        if (!b.getAndSet(true)) {
            RVLogger.d("AriverInt:IpcClient", "registerServerReadyListener");
            IpcChannelManager.getInstance().registerServerReadyListener(new IpcChannelManager.ServerReadyListener() { // from class: com.alibaba.ariver.kernel.ipc.IpcClientKernelUtils.1
                @Override // com.alibaba.ariver.kernel.ipc.IpcChannelManager.ServerReadyListener
                public final void onServerReady() {
                    RVLogger.d("AriverInt:IpcClient", "onServerReady");
                    IIpcChannel serverChannel = IpcChannelManager.getInstance().getServerChannel();
                    if (serverChannel != null) {
                        synchronized (IpcClientKernelUtils.f6169a) {
                            Iterator it = IpcClientKernelUtils.f6169a.iterator();
                            while (it.hasNext()) {
                                try {
                                    serverChannel.sendMessage((IpcMessage) it.next());
                                } catch (RemoteException e) {
                                    RVLogger.w("AriverInt:IpcClient", "sendMessage to server exception!", e);
                                }
                            }
                        }
                        IpcChannelManager.getInstance().unRegisterServerReadyListener(this);
                        return;
                    }
                    RVLogger.e("AriverInt:IpcClient", "onServerReady but server channel == null!!");
                }
            });
        }
        f6169a.add(ipcMessage);
    }
}
