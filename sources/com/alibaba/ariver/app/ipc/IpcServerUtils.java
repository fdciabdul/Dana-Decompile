package com.alibaba.ariver.app.ipc;

import android.os.Bundle;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import androidx.collection.LongSparseArray;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.api.IIpcChannel;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.ipc.IpcChannelManager;
import com.alibaba.ariver.kernel.ipc.IpcMessage;
import com.alibaba.ariver.kernel.ipc.IpcMessageConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class IpcServerUtils {
    public static final String LOG_TAG = "AriverInt:IpcServer";

    /* renamed from: a  reason: collision with root package name */
    private static final LongSparseArray<List<Message>> f5982a = new LongSparseArray<>();

    public static void flushMessages(long j) {
        IIpcChannel clientChannel = IpcChannelManager.getInstance().getClientChannel(j);
        LongSparseArray<List<Message>> longSparseArray = f5982a;
        synchronized (longSparseArray) {
            List<Message> MyBillsEntityDataFactory = longSparseArray.MyBillsEntityDataFactory(j, null);
            int size = MyBillsEntityDataFactory == null ? 0 : MyBillsEntityDataFactory.size();
            StringBuilder sb = new StringBuilder();
            sb.append("flushMessages: ");
            sb.append(j);
            sb.append(" msgSize: ");
            sb.append(size);
            RVLogger.d(LOG_TAG, sb.toString());
            if (MyBillsEntityDataFactory != null) {
                Iterator<Message> it = MyBillsEntityDataFactory.iterator();
                while (it.hasNext()) {
                    a(clientChannel, IpcMessageConstants.BIZ_APP, it.next());
                }
            }
            f5982a.PlaceComponentResult(j);
        }
    }

    public static void removeToken(long j) {
        f5982a.PlaceComponentResult(j);
    }

    public static void addStubToClient(String str, long j, String str2, long j2) {
        Bundle bundle = new Bundle();
        bundle.putString(IpcMessageConstants.EXTRA_STUB_NAME, str2);
        bundle.putLong(IpcMessageConstants.EXTRA_STUB_TS, j2);
        sendMsgToClient(str, j, 12, bundle);
    }

    public static void addAttrToClient(String str, long j, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString(IpcMessageConstants.EXTRA_STUB_NAME, str2);
        bundle.putString(IpcMessageConstants.EXTRA_ATTR_VALUE, str3);
        sendMsgToClient(str, j, 16, bundle);
    }

    public static void sendMsgToClient(String str, long j, int i, Bundle bundle) {
        sendMsgToClient(str, j, i, IpcMessageConstants.BIZ_APP, bundle);
    }

    public static void sendMsgToClient(String str, long j, int i, String str2, Bundle bundle) {
        if (i == 4) {
            StringBuilder sb = new StringBuilder();
            sb.append("send SERVER_MSG_FORCE_FINISH with stack: ");
            sb.append(Log.getStackTraceString(new Throwable("Just Print")));
            RVLogger.w(LOG_TAG, sb.toString());
        }
        Message message = new Message();
        message.what = i;
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.setClassLoader(IpcServerUtils.class.getClassLoader());
        bundle.putString("appId", str);
        bundle.putLong(RVConstants.EXTRA_START_TOKEN, j);
        message.setData(bundle);
        IIpcChannel clientChannel = IpcChannelManager.getInstance().getClientChannel(j);
        if (clientChannel == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("sendMsgToClient (pending) ");
            sb2.append(i);
            sb2.append(" token: ");
            sb2.append(j);
            RVLogger.d(LOG_TAG, sb2.toString());
            a(j, message);
            return;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("sendMsgToClient (direct) ");
        sb3.append(i);
        sb3.append(" token: ");
        sb3.append(j);
        RVLogger.d(LOG_TAG, sb3.toString());
        a(clientChannel, str2, message);
    }

    private static void a(long j, Message message) {
        LongSparseArray<List<Message>> longSparseArray = f5982a;
        synchronized (longSparseArray) {
            List<Message> MyBillsEntityDataFactory = longSparseArray.MyBillsEntityDataFactory(j, null);
            if (MyBillsEntityDataFactory == null) {
                MyBillsEntityDataFactory = new ArrayList<>();
                longSparseArray.getAuthRequestContext(j, MyBillsEntityDataFactory);
            }
            MyBillsEntityDataFactory.add(message);
        }
    }

    private static void a(IIpcChannel iIpcChannel, String str, Message message) {
        if (iIpcChannel == null) {
            return;
        }
        IpcMessage ipcMessage = new IpcMessage();
        ipcMessage.biz = str;
        ipcMessage.bizMsg = message;
        try {
            iIpcChannel.sendMessage(ipcMessage);
        } catch (RemoteException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("IpcMsgServer send error ");
            sb.append(Log.getStackTraceString(e));
            RVLogger.e(LOG_TAG, sb.toString());
        }
    }
}
