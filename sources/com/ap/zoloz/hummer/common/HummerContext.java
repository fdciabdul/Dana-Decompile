package com.ap.zoloz.hummer.common;

import android.content.Context;
import com.alibaba.fastjson.JSONObject;
import com.alipay.zoloz.config.ConfigCenter;
import com.ap.zoloz.hummer.api.TaskUIConfig;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.ap.zoloz.hummer.biz.HummerLogger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class HummerContext {
    ClientConfig mClientConfig;
    public Context mContext;
    private TaskConfig mCurrentTaskConfig;
    public String mHummerId;
    TaskUIConfig mTaskUIConfig;
    private Map<String, Object> serverResponse = new HashMap();
    private Map<String, Object> runtimeContext = new HashMap();
    private Map<Integer, Object> argumentContext = new HashMap();
    public ArrayList<Integer> rpcTaskIndexs = new ArrayList<>();
    private List<Map<String, String>> mZStack = new ArrayList();

    public void setClientConfig(ClientConfig clientConfig) {
        this.mClientConfig = clientConfig;
    }

    public void setTaskUIConfig(TaskUIConfig taskUIConfig) {
        this.mTaskUIConfig = taskUIConfig;
    }

    public void setCurrentTaskConfig(TaskConfig taskConfig) {
        this.mCurrentTaskConfig = taskConfig;
    }

    public TaskConfig getCurrentTaskConfig() {
        return this.mCurrentTaskConfig;
    }

    public void release() {
        this.serverResponse.clear();
        this.runtimeContext.clear();
        this.argumentContext.clear();
        this.mZStack.clear();
        this.mContext = null;
        this.mCurrentTaskConfig = null;
    }

    public void forceQuit() {
        HummerLogger.i("HummerContext forceQuit");
        this.mZStack.clear();
        this.serverResponse.clear();
        this.runtimeContext.clear();
        this.argumentContext.clear();
        this.mCurrentTaskConfig = null;
    }

    public Object query(String str) {
        HashMap hashMap = new HashMap(ConfigCenter.getInstance().getBizConfig());
        HashMap hashMap2 = new HashMap(ConfigCenter.getInstance().getFrameworkConfigs());
        if (hashMap.containsKey(str)) {
            return hashMap.get(str);
        }
        if (this.serverResponse.containsKey(str)) {
            return this.serverResponse.get(str);
        }
        if (this.runtimeContext.containsKey(str)) {
            return this.runtimeContext.get(str);
        }
        if (hashMap2.containsKey(str)) {
            return hashMap2.get(str);
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void add(String str, String str2, Object obj) {
        char c;
        HashMap hashMap = new HashMap();
        str2.hashCode();
        switch (str2.hashCode()) {
            case -1589682499:
                if (str2.equals(HummerConstants.ARGUMENT)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -722006482:
                if (str2.equals(HummerConstants.ZSTACK)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -170019676:
                if (str2.equals(HummerConstants.SERVER_RESPONSE)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 3029889:
                if (str2.equals(HummerConstants.BOTH)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 951530927:
                if (str2.equals(HummerConstants.CONTEXT)) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        if (c == 0) {
            if (this.mCurrentTaskConfig != null) {
                hashMap.clear();
                if (this.argumentContext.containsKey(Integer.valueOf(this.mCurrentTaskConfig.index))) {
                    hashMap.putAll((Map) this.argumentContext.get(Integer.valueOf(this.mCurrentTaskConfig.index)));
                }
                hashMap.put(str, obj);
                this.argumentContext.put(Integer.valueOf(this.mCurrentTaskConfig.index), hashMap);
            }
        } else if (c == 1) {
            updateZStack(this.mCurrentTaskConfig.name, String.valueOf(obj));
        } else if (c == 2) {
            this.serverResponse.put(str, obj);
        } else if (c != 3) {
            if (c != 4) {
                return;
            }
            this.runtimeContext.put(str, obj);
        } else {
            this.runtimeContext.put(str, obj);
            if (this.mCurrentTaskConfig != null) {
                hashMap.clear();
                if (this.argumentContext.containsKey(Integer.valueOf(this.mCurrentTaskConfig.index))) {
                    hashMap.putAll((Map) this.argumentContext.get(Integer.valueOf(this.mCurrentTaskConfig.index)));
                }
                hashMap.put(str, obj);
                this.argumentContext.put(Integer.valueOf(this.mCurrentTaskConfig.index), hashMap);
            }
        }
    }

    public boolean needRPC(String str) {
        TaskConfig taskConfig = getTaskConfig(getNextIndex(str));
        return (taskConfig == null || !HummerConstants.SERVER_TASK.equals(taskConfig.type) || HummerConstants.TASK_FINALIZE.equals(taskConfig.name) || "cancel".equals(taskConfig.name)) ? false : true;
    }

    public int getNextIndex(String str) {
        TaskConfig taskConfig = this.mCurrentTaskConfig;
        if (taskConfig == null || taskConfig.navigateConfig == null || !this.mCurrentTaskConfig.navigateConfig.containsKey(str)) {
            return 0;
        }
        return ((Integer) ((Map) this.mCurrentTaskConfig.navigateConfig.get(str)).get("index")).intValue();
    }

    public Map<String, Object> getInputParam() {
        TaskConfig taskConfig = this.mCurrentTaskConfig;
        if (taskConfig != null) {
            return taskConfig.inputParams;
        }
        return null;
    }

    public JSONObject getOutputParam(String str) {
        TaskConfig taskConfig = this.mCurrentTaskConfig;
        if (taskConfig != null && taskConfig.navigateConfig.containsKey(str)) {
            return (JSONObject) ((Map) this.mCurrentTaskConfig.navigateConfig.get(str)).get(HummerConstants.OUTPUT_PARAM);
        }
        return null;
    }

    public void delete(String str) {
        this.argumentContext.remove(str);
        this.runtimeContext.remove(str);
        this.serverResponse.remove(str);
        this.argumentContext.remove(str);
    }

    public HashMap<String, Object> packageRPCArguments() {
        TaskConfig taskConfig = this.mCurrentTaskConfig;
        if (taskConfig == null) {
            return null;
        }
        int i = taskConfig.index;
        HashMap<String, Object> hashMap = new HashMap<>();
        ArrayList arrayList = new ArrayList(this.rpcTaskIndexs);
        Collections.sort(arrayList);
        if (arrayList.contains(Integer.valueOf(i))) {
            int intValue = this.rpcTaskIndexs.indexOf(Integer.valueOf(i)) > 0 ? ((Integer) arrayList.get(this.rpcTaskIndexs.indexOf(Integer.valueOf(i)) - 1)).intValue() : 0;
            for (Map.Entry<Integer, Object> entry : this.argumentContext.entrySet()) {
                if (entry.getKey().intValue() > intValue && entry.getKey().intValue() <= i) {
                    hashMap.putAll((Map) entry.getValue());
                }
            }
            return hashMap;
        }
        return null;
    }

    public List<Map<String, String>> getZStack() {
        return this.mZStack;
    }

    public void updateRpcIndexList() {
        TaskConfig taskConfig = this.mCurrentTaskConfig;
        if (taskConfig == null) {
            return;
        }
        this.rpcTaskIndexs.add(Integer.valueOf(taskConfig.index));
        HummerLogger.d(this.rpcTaskIndexs.toString());
    }

    public TaskConfig getTaskConfig(int i) {
        ClientConfig clientConfig = this.mClientConfig;
        if (clientConfig == null || clientConfig.tasks == null || this.mClientConfig.tasks.size() == 0) {
            return null;
        }
        for (int i2 = 0; i2 < this.mClientConfig.tasks.size(); i2++) {
            if (i == this.mClientConfig.tasks.get(i2).index) {
                return this.mClientConfig.tasks.get(i2);
            }
        }
        return null;
    }

    public UIConfig getCurrentUIConfig(String str) {
        TaskUIConfig taskUIConfig = this.mTaskUIConfig;
        if (taskUIConfig == null || taskUIConfig.tasks.size() == 0) {
            return null;
        }
        for (int i = 0; i < this.mTaskUIConfig.tasks.size(); i++) {
            if (str.equals(this.mTaskUIConfig.tasks.get(i).name)) {
                return this.mTaskUIConfig.tasks.get(i);
            }
        }
        return null;
    }

    public void updateZStack(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(str, str2);
        this.mZStack.add(hashMap);
    }

    public void recordSystemError(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("subCode", str2);
        hashMap.put(HummerConstants.CURRENT_TASK_NAME, str);
        RecordManager.getInstance().record("ztech_system_error", hashMap);
    }

    public void overwriteZStack(List<Map<String, String>> list) {
        this.mZStack.clear();
        this.mZStack.addAll(list);
    }

    public String getLastZStackCode() {
        List<Map<String, String>> list = this.mZStack;
        String str = "";
        if (list != null && list.size() > 0) {
            Map<String, String> map = this.mZStack.get(r0.size() - 1);
            Iterator<String> it = map.keySet().iterator();
            while (it.hasNext()) {
                str = map.get(it.next());
            }
        }
        return str;
    }

    public int getCancelIndex() {
        ClientConfig clientConfig = this.mClientConfig;
        if (clientConfig != null && clientConfig.tasks != null && this.mClientConfig.tasks.size() != 0) {
            for (int i = 0; i < this.mClientConfig.tasks.size(); i++) {
                if ("cancel".equals(this.mClientConfig.tasks.get(i).name)) {
                    return this.mClientConfig.tasks.get(i).index;
                }
            }
        }
        return 0;
    }
}
