package com.alipay.plus.push.core;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alipay.plus.push.core.model.PushMessage;
import com.alipay.plus.push.core.net.IPushApiProxy;
import com.alipay.plus.push.core.pushservice.IPushService;
import com.fullstory.instrumentation.InstrumentInjector;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class PushService implements IPushService {
    private String apiSignature;
    private String appKey;
    private PushMessageReceiver<String> globalPushMessageReceiver;
    private IPushApiProxy iPushApiProxy;
    private final String FILED_BIZ_TYPE = "bizType";
    private final String FILED_DATA = "data";
    protected boolean autoReport = false;
    private List<ComponentDescription> componentDescriptions = new LinkedList();

    @Override // com.alipay.plus.push.core.pushservice.IPushService
    public abstract String getPushToken();

    @Override // com.alipay.plus.push.core.pushservice.IPushService
    public abstract void init(Context context);

    public void resumePush() {
    }

    public void stopPush() {
    }

    @Override // com.alipay.plus.push.core.pushservice.IPushService
    public void registerGlobalMsgReceiver(PushMessageReceiver<String> pushMessageReceiver) {
        synchronized (this) {
            this.globalPushMessageReceiver = pushMessageReceiver;
        }
    }

    @Override // com.alipay.plus.push.core.pushservice.IPushService
    public void unregisterMsgReceiver(PushMessageReceiver pushMessageReceiver) {
        synchronized (this) {
            Iterator<ComponentDescription> it = this.componentDescriptions.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().getReceiveCallback() == pushMessageReceiver) {
                    this.componentDescriptions.remove(pushMessageReceiver);
                    break;
                }
            }
            if (pushMessageReceiver != null && pushMessageReceiver == this.globalPushMessageReceiver) {
                this.globalPushMessageReceiver = null;
            }
        }
    }

    @Override // com.alipay.plus.push.core.pushservice.IPushService
    public void registerMsgReceiver(String str, PushMessageReceiver pushMessageReceiver) {
        boolean z;
        synchronized (this) {
            new Handler();
            if (TextUtils.isEmpty(str) || pushMessageReceiver == null) {
                InstrumentInjector.log_e(PushExtConstants.GLOBAL_TAG, "register ComponentDescription failed");
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("registerMsgReceiver == ");
            sb.append(str);
            InstrumentInjector.log_e(PushExtConstants.GLOBAL_TAG, sb.toString());
            Iterator<ComponentDescription> it = this.componentDescriptions.iterator();
            while (true) {
                z = false;
                if (!it.hasNext()) {
                    break;
                } else if (it.next().getBizType().equals(str)) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                ComponentDescription componentDescription = new ComponentDescription();
                componentDescription.setBizType(str);
                componentDescription.setReceiveCallback(pushMessageReceiver);
                this.componentDescriptions.add(componentDescription);
            }
        }
    }

    public PushMessageReceiver getPushDataReceiveCallback(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (ComponentDescription componentDescription : this.componentDescriptions) {
            if (componentDescription.getBizType().equalsIgnoreCase(str)) {
                return componentDescription.getReceiveCallback();
            }
        }
        return null;
    }

    @Override // com.alipay.plus.push.core.pushservice.IPushService
    public void dispatchMessage(Object obj) {
        if (obj == null) {
            return;
        }
        if (obj instanceof PushMessage) {
            dispatch(((PushMessage) obj).getExtras());
        } else if (obj instanceof Map) {
            dispatch((Map) obj);
        }
    }

    private void dispatch(Map<String, String> map) {
        try {
            if (map.get("data") == null) {
                return;
            }
            String str = map.get("data");
            if (map != null && map.size() > 0) {
                String str2 = map.get("bizType");
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                PushMessageReceiver pushDataReceiveCallback = getPushDataReceiveCallback(str2);
                if (pushDataReceiveCallback != null) {
                    try {
                        Type[] genericInterfaces = pushDataReceiveCallback.getClass().getGenericInterfaces();
                        if (genericInterfaces.length > 0) {
                            Type type = genericInterfaces[0];
                            if (type instanceof ParameterizedType) {
                                Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                                if (((Class) type2).getName().equals(String.class.getName())) {
                                    pushDataReceiveCallback.onMessageReceived(str.toString());
                                } else {
                                    pushDataReceiveCallback.onMessageReceived(JSON.parseObject(str, type2, new Feature[0]));
                                }
                                InstrumentInjector.log_d(PushExtConstants.GLOBAL_TAG, "dispatchMessage found the callback");
                            }
                        }
                        pushDataReceiveCallback.onMessageReceived(str.toString());
                    } catch (Exception unused) {
                    }
                }
            }
            PushMessageReceiver<String> pushMessageReceiver = this.globalPushMessageReceiver;
            if (pushMessageReceiver == null || str == null) {
                return;
            }
            pushMessageReceiver.onMessageReceived(str);
        } catch (Exception unused2) {
        }
    }

    @Override // com.alipay.plus.push.core.pushservice.IPushService
    public void autoReport(boolean z) {
        this.autoReport = z;
    }
}
