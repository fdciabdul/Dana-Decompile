package com.alibaba.ariver.app.ipc;

import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.api.IIpcChannel;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.ipc.IpcChannelManager;
import com.alibaba.ariver.kernel.ipc.IpcMessage;
import com.alibaba.ariver.kernel.ipc.IpcMessageHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class ServerMsgReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static ServerMsgReceiver f5983a;
    private final Bundle b = new Bundle();
    private final Map<String, List<IpcMessageHandler>> c = new HashMap();

    public static ServerMsgReceiver getInstance() {
        if (f5983a == null) {
            synchronized (ServerMsgReceiver.class) {
                f5983a = new ServerMsgReceiver();
            }
        }
        return f5983a;
    }

    private ServerMsgReceiver() {
        IpcChannelManager.getInstance().registerClientListener(new IpcChannelManager.ClientListener() { // from class: com.alibaba.ariver.app.ipc.ServerMsgReceiver.1
            @Override // com.alibaba.ariver.kernel.ipc.IpcChannelManager.ClientListener
            public void onRegister(long j, IIpcChannel iIpcChannel) {
                StringBuilder sb = new StringBuilder();
                sb.append("ServerMsgReceiver onRegister startToken ");
                sb.append(j);
                RVLogger.d(IpcServerUtils.LOG_TAG, sb.toString());
                IpcServerUtils.flushMessages(j);
            }

            @Override // com.alibaba.ariver.kernel.ipc.IpcChannelManager.ClientListener
            public void onUnRegister(long j) {
                IpcServerUtils.removeToken(j);
            }
        });
    }

    public final void registerBizHandler(String str, IpcMessageHandler ipcMessageHandler) {
        StringBuilder sb = new StringBuilder();
        sb.append("ServerMsgReceiver registerBiz: ");
        sb.append(str);
        RVLogger.d(IpcServerUtils.LOG_TAG, sb.toString());
        synchronized (this.c) {
            List<IpcMessageHandler> list = this.c.get(str);
            if (list == null) {
                list = new ArrayList<>();
                this.c.put(str, list);
            }
            list.add(ipcMessageHandler);
        }
    }

    public final void unRegisterBizHandler(String str, IpcMessageHandler ipcMessageHandler) {
        StringBuilder sb = new StringBuilder();
        sb.append("ServerMsgReceiver unRegisterBizHandler: ");
        sb.append(str);
        sb.append(" and ");
        sb.append(ipcMessageHandler);
        RVLogger.d(IpcServerUtils.LOG_TAG, sb.toString());
        if (ipcMessageHandler == null) {
            return;
        }
        synchronized (this.c) {
            List<IpcMessageHandler> list = this.c.get(str);
            if (list == null) {
                return;
            }
            list.remove(ipcMessageHandler);
            if (list.size() == 0) {
                this.c.remove(str);
            }
        }
    }

    public final void handleMessage(IpcMessage ipcMessage) {
        Bundle data = ipcMessage.bizMsg.getData();
        if (data == null) {
            data = this.b;
        }
        data.setClassLoader(ServerMsgReceiver.class.getClassLoader());
        String str = ipcMessage.biz;
        if (TextUtils.isEmpty(str)) {
            RVLogger.e(IpcServerUtils.LOG_TAG, "ServerMsgReceiver biz empty!");
            return;
        }
        synchronized (this.c) {
            List<IpcMessageHandler> list = this.c.get(str);
            if (list != null) {
                Iterator<IpcMessageHandler> it = list.iterator();
                while (it.hasNext()) {
                    it.next().handleMessage(ipcMessage);
                }
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("ServerMsgReceiver biz ");
                sb.append(str);
                sb.append(" has not register handler");
                RVLogger.w(IpcServerUtils.LOG_TAG, sb.toString());
            }
        }
    }
}
