package com.alibaba.ariver.kernel.ipc;

import androidx.collection.LongSparseArray;
import com.alibaba.ariver.kernel.api.IIpcChannel;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class IpcChannelManager {

    /* renamed from: a  reason: collision with root package name */
    private static IpcChannelManager f6168a;
    private static IIpcChannel b;
    private static final LongSparseArray<IIpcChannel> c = new LongSparseArray<>(5);
    private static final List<ClientListener> d = new ArrayList();
    private static final List<ServerReadyListener> e = new ArrayList();

    /* loaded from: classes3.dex */
    public interface ClientListener {
        void onRegister(long j, IIpcChannel iIpcChannel);

        void onUnRegister(long j);
    }

    /* loaded from: classes3.dex */
    public interface ServerReadyListener {
        void onServerReady();
    }

    public static IpcChannelManager getInstance() {
        if (f6168a == null) {
            synchronized (IpcChannelManager.class) {
                if (f6168a == null) {
                    f6168a = new IpcChannelManager();
                }
            }
        }
        return f6168a;
    }

    public void registerServerReadyListener(ServerReadyListener serverReadyListener) {
        List<ServerReadyListener> list = e;
        synchronized (list) {
            list.add(serverReadyListener);
        }
    }

    public void unRegisterServerReadyListener(ServerReadyListener serverReadyListener) {
        List<ServerReadyListener> list = e;
        synchronized (list) {
            list.remove(serverReadyListener);
        }
    }

    public void registerServerChannel(IIpcChannel iIpcChannel) {
        synchronized (this) {
            RVLogger.d("AriverKernel:IpcChannelManager", "registerServerChannel");
            b = iIpcChannel;
            List<ServerReadyListener> list = e;
            synchronized (list) {
                Iterator<ServerReadyListener> it = list.iterator();
                while (it.hasNext()) {
                    it.next().onServerReady();
                }
            }
        }
    }

    public void unRegisterServerChannel() {
        synchronized (this) {
            RVLogger.d("AriverKernel:IpcChannelManager", "unRegisterServerChannel");
            b = null;
        }
    }

    public IIpcChannel getServerChannel() {
        IIpcChannel iIpcChannel;
        synchronized (this) {
            iIpcChannel = b;
        }
        return iIpcChannel;
    }

    public void registerClientListener(ClientListener clientListener) {
        List<ClientListener> list = d;
        synchronized (list) {
            list.add(clientListener);
        }
    }

    public void unRegisterClientListener(ClientListener clientListener) {
        List<ClientListener> list = d;
        synchronized (list) {
            list.remove(clientListener);
        }
    }

    public void registerClientChannel(long j, IIpcChannel iIpcChannel) {
        synchronized (this) {
            LongSparseArray<IIpcChannel> longSparseArray = c;
            if (longSparseArray.MyBillsEntityDataFactory(j, null) != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("registerClientChannel: ");
                sb.append(j);
                sb.append(" but already registered.");
                RVLogger.w("AriverKernel:IpcChannelManager", sb.toString());
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("registerClientChannel: ");
            sb2.append(j);
            RVLogger.d("AriverKernel:IpcChannelManager", sb2.toString());
            longSparseArray.getAuthRequestContext(j, iIpcChannel);
            List<ClientListener> list = d;
            synchronized (list) {
                Iterator<ClientListener> it = list.iterator();
                while (it.hasNext()) {
                    it.next().onRegister(j, iIpcChannel);
                }
            }
        }
    }

    public void unRegisterClientChannel(long j) {
        synchronized (this) {
            LongSparseArray<IIpcChannel> longSparseArray = c;
            if (longSparseArray.MyBillsEntityDataFactory(j, null) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("unRegisterClientChannel: ");
                sb.append(j);
                sb.append(" but already unregistered.");
                RVLogger.w("AriverKernel:IpcChannelManager", sb.toString());
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("unRegisterClientChannel: ");
            sb2.append(j);
            RVLogger.d("AriverKernel:IpcChannelManager", sb2.toString());
            ShadowNodePool.getInstance().unBindStartToken(j);
            longSparseArray.PlaceComponentResult(j);
            List<ClientListener> list = d;
            synchronized (list) {
                Iterator<ClientListener> it = list.iterator();
                while (it.hasNext()) {
                    it.next().onUnRegister(j);
                }
            }
        }
    }

    public IIpcChannel getClientChannel(long j) {
        IIpcChannel MyBillsEntityDataFactory;
        synchronized (this) {
            MyBillsEntityDataFactory = c.MyBillsEntityDataFactory(j, null);
        }
        return MyBillsEntityDataFactory;
    }
}
