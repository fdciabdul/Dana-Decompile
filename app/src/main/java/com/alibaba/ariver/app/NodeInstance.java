package com.alibaba.ariver.app;

import android.os.Parcel;
import android.os.Process;
import com.alibaba.ariver.kernel.api.extension.ExtensionManager;
import com.alibaba.ariver.kernel.api.node.DataNode;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.api.node.ValueStore;
import com.alibaba.ariver.kernel.api.security.Accessor;
import com.alibaba.ariver.kernel.api.security.DefaultGroup;
import com.alibaba.ariver.kernel.api.security.Group;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.multiinstance.InstanceType;
import com.alibaba.ariver.kernel.common.multiinstance.MultiInstanceUtils;
import com.alibaba.ariver.kernel.common.utils.RVKernelUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes3.dex */
public class NodeInstance implements DataNode, ValueStore {
    private static final String TAG = "AriverNodeInstance";
    protected static ExtensionManager sExtensionManager;
    private static int sNodeIdBase = Process.myPid() * 10000;
    private static int sNodeIdCounter = 1;
    private boolean mAlreadyFinalized;
    private final Stack<Node> mChildNodes;
    private final Map<Class, Object> mDataStore;
    private CountDownLatch mFinalizedLatch;
    private InstanceType mInstanceType;
    private long mNodeId;
    private Node mParentNode;
    private final Map<String, Object> mValueStoreMap;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.alibaba.ariver.kernel.api.security.Accessor
    public void inquiry(List<? extends Permission> list, Accessor.InquiryCallback inquiryCallback) {
    }

    @Override // com.alibaba.ariver.kernel.api.security.Accessor
    public List<Permission> usePermissions() {
        return null;
    }

    public NodeInstance() {
        this.mChildNodes = new Stack<>();
        this.mDataStore = new ConcurrentHashMap();
        this.mValueStoreMap = new ConcurrentHashMap();
        this.mAlreadyFinalized = false;
        this.mFinalizedLatch = new CountDownLatch(1);
        this.mNodeId = generateNodeId();
    }

    public static long generateNodeId() {
        int i = sNodeIdBase;
        sNodeIdCounter = sNodeIdCounter + 1;
        return i + r1;
    }

    public void setNodeId(long j) {
        this.mNodeId = j;
    }

    public NodeInstance(Node node) {
        this();
        this.mParentNode = node;
        this.mInstanceType = node.getInstanceType() == null ? MultiInstanceUtils.getDefaultInstanceType() : node.getInstanceType();
        onInitialized();
    }

    public static void bindExtensionManager(ExtensionManager extensionManager) {
        sExtensionManager = extensionManager;
    }

    public static ExtensionManager getBindedExtensionManager() {
        return sExtensionManager;
    }

    @Override // com.alibaba.ariver.kernel.api.node.Node
    public void onInitialized() {
        synchronized (this) {
            ExtensionManager extensionManager = sExtensionManager;
            if (extensionManager != null) {
                extensionManager.enterNode(this);
            }
        }
    }

    @Override // com.alibaba.ariver.kernel.api.node.Node
    public void onFinalized() {
        synchronized (this) {
            ExtensionManager extensionManager = sExtensionManager;
            if (extensionManager != null) {
                extensionManager.exitNode(this);
            }
            this.mParentNode = null;
            this.mValueStoreMap.clear();
            this.mValueStoreMap.put(Node.KEY_IS_FINALIZED, Boolean.TRUE);
            this.mAlreadyFinalized = true;
            this.mFinalizedLatch.countDown();
        }
    }

    @Override // com.alibaba.ariver.kernel.api.node.Node
    public InstanceType getInstanceType() {
        return this.mInstanceType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setInstanceType(InstanceType instanceType) {
        this.mInstanceType = instanceType;
    }

    public boolean waitOnFinalized() {
        try {
            this.mFinalizedLatch.await();
            return this.mAlreadyFinalized;
        } catch (InterruptedException unused) {
            return false;
        }
    }

    @Override // com.alibaba.ariver.kernel.api.node.Node
    public Node getParentNode() {
        return this.mParentNode;
    }

    @Override // com.alibaba.ariver.kernel.api.node.Node
    public void setParentNode(Node node) {
        this.mParentNode = node;
    }

    @Override // com.alibaba.ariver.kernel.api.node.Node
    public int getIndexOfChild(Node node) {
        if (node == null) {
            return -1;
        }
        synchronized (this.mChildNodes) {
            int size = this.mChildNodes.size();
            for (int i = 0; i < size; i++) {
                if (node == this.mChildNodes.get(i)) {
                    return i;
                }
            }
            return -1;
        }
    }

    @Override // com.alibaba.ariver.kernel.api.node.Node
    public void pushChild(Node node) {
        if (node == null) {
            return;
        }
        synchronized (this.mChildNodes) {
            node.setParentNode(this);
            this.mChildNodes.push(node);
        }
    }

    @Override // com.alibaba.ariver.kernel.api.node.Node
    public Node popChild() {
        Node pop;
        synchronized (this.mChildNodes) {
            pop = this.mChildNodes.pop();
        }
        return pop;
    }

    @Override // com.alibaba.ariver.kernel.api.node.Node
    public Node peekChild() {
        synchronized (this.mChildNodes) {
            if (this.mChildNodes.empty()) {
                return null;
            }
            return this.mChildNodes.peek();
        }
    }

    @Override // com.alibaba.ariver.kernel.api.node.Node
    public Node getChildAt(int i) {
        if (i < 0 || this.mChildNodes.size() == 0 || i >= this.mChildNodes.size()) {
            return null;
        }
        return this.mChildNodes.get(i);
    }

    @Override // com.alibaba.ariver.kernel.api.node.Node
    public int getChildCount() {
        return this.mChildNodes.size();
    }

    @Override // com.alibaba.ariver.kernel.api.node.Node
    public Node getChild(long j) {
        synchronized (this.mChildNodes) {
            Iterator<Node> it = this.mChildNodes.iterator();
            while (it.hasNext()) {
                Node next = it.next();
                if (j == next.getNodeId()) {
                    return next;
                }
            }
            return null;
        }
    }

    @Override // com.alibaba.ariver.kernel.api.node.Node
    public boolean removeChild(Node node) {
        boolean remove;
        synchronized (this.mChildNodes) {
            remove = this.mChildNodes.remove(node);
        }
        return remove;
    }

    @Override // com.alibaba.ariver.kernel.api.node.Node
    public boolean isChildless() {
        boolean empty;
        synchronized (this.mChildNodes) {
            empty = this.mChildNodes.empty();
        }
        return empty;
    }

    @Override // com.alibaba.ariver.kernel.api.node.Node
    public long getNodeId() {
        return this.mNodeId;
    }

    @Override // com.alibaba.ariver.kernel.api.node.Node
    public <T extends Node> T bubbleFindNode(Class<T> cls) {
        for (NodeInstance nodeInstance = this; nodeInstance != null; nodeInstance = (T) nodeInstance.getParentNode()) {
            if (cls.isAssignableFrom(nodeInstance.getClass())) {
                return nodeInstance;
            }
        }
        return null;
    }

    @Override // com.alibaba.ariver.kernel.api.security.Accessor
    public Group getGroup() {
        return DefaultGroup.INTERNAL;
    }

    @Override // com.alibaba.ariver.kernel.api.node.DataNode, com.alibaba.ariver.kernel.api.node.Node
    public <T> T getData(Class<T> cls, boolean z) {
        T t = (T) this.mDataStore.get(cls);
        if (t == null && z) {
            try {
                t = cls.newInstance();
                this.mDataStore.put(cls, t);
                return t;
            } catch (Throwable th) {
                RVLogger.w(TAG, "getData Exception", th);
                return t;
            }
        }
        return t;
    }

    @Override // com.alibaba.ariver.kernel.api.node.DataNode
    public <T> T getData(Class<T> cls) {
        return (T) getData(cls, false);
    }

    @Override // com.alibaba.ariver.kernel.api.node.DataNode
    public <T> void setData(Class<T> cls, T t) {
        if (t == null) {
            this.mDataStore.remove(cls);
            return;
        }
        if (RVKernelUtils.isDebug()) {
            StringBuilder sb = new StringBuilder();
            sb.append("setData [");
            sb.append(cls);
            sb.append("] value: ");
            sb.append(t);
            RVLogger.d(TAG, sb.toString());
        }
        this.mDataStore.put(cls, t);
    }

    public NodeInstance(Parcel parcel) {
        this.mChildNodes = new Stack<>();
        this.mDataStore = new ConcurrentHashMap();
        this.mValueStoreMap = new ConcurrentHashMap();
        this.mAlreadyFinalized = false;
        this.mFinalizedLatch = new CountDownLatch(1);
        this.mNodeId = parcel.readLong();
        this.mParentNode = (Node) parcel.readParcelable(NodeInstance.class.getClassLoader());
        int readInt = parcel.readInt();
        if (readInt >= 0) {
            this.mInstanceType = InstanceType.values()[readInt];
        } else {
            this.mInstanceType = MultiInstanceUtils.getDefaultInstanceType();
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.mNodeId);
        parcel.writeParcelable(this.mParentNode, 0);
        InstanceType instanceType = this.mInstanceType;
        if (instanceType == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(instanceType.ordinal());
        }
    }

    @Override // com.alibaba.ariver.kernel.api.node.ValueStore
    public boolean containsKey(String str) {
        return this.mValueStoreMap.containsKey(str);
    }

    @Override // com.alibaba.ariver.kernel.api.node.ValueStore
    public String getStringValue(String str) {
        Object obj = this.mValueStoreMap.get(str);
        if (obj != null) {
            try {
                return (String) obj;
            } catch (Throwable th) {
                RVLogger.e(TAG, "getStringValue error!", th);
                return null;
            }
        }
        return null;
    }

    @Override // com.alibaba.ariver.kernel.api.node.ValueStore
    public void putStringValue(String str, String str2) {
        if (str2 == null) {
            this.mValueStoreMap.remove(str);
        } else {
            this.mValueStoreMap.put(str, str2);
        }
    }

    @Override // com.alibaba.ariver.kernel.api.node.ValueStore
    public boolean getBooleanValue(String str) {
        Object obj = this.mValueStoreMap.get(str);
        if (obj != null) {
            try {
                return ((Boolean) obj).booleanValue();
            } catch (Throwable th) {
                RVLogger.e(TAG, "getStringValue error!", th);
                return false;
            }
        }
        return false;
    }

    @Override // com.alibaba.ariver.kernel.api.node.ValueStore
    public void putBooleanValue(String str, boolean z) {
        this.mValueStoreMap.put(str, Boolean.valueOf(z));
    }

    @Override // com.alibaba.ariver.kernel.api.node.ValueStore
    public int getIntValue(String str) {
        Object obj = this.mValueStoreMap.get(str);
        if (obj != null) {
            try {
                return ((Integer) obj).intValue();
            } catch (Throwable th) {
                RVLogger.e(TAG, "getStringValue error!", th);
                return 0;
            }
        }
        return 0;
    }

    @Override // com.alibaba.ariver.kernel.api.node.ValueStore
    public void putIntValue(String str, int i) {
        this.mValueStoreMap.put(str, Integer.valueOf(i));
    }

    @Override // com.alibaba.ariver.kernel.api.node.ValueStore
    public long getLongValue(String str) {
        Object obj = this.mValueStoreMap.get(str);
        if (obj != null) {
            try {
                return ((Long) obj).longValue();
            } catch (Throwable th) {
                RVLogger.e(TAG, "getStringValue error!", th);
                return 0L;
            }
        }
        return 0L;
    }

    @Override // com.alibaba.ariver.kernel.api.node.ValueStore
    public void putLongValue(String str, long j) {
        this.mValueStoreMap.put(str, Long.valueOf(j));
    }

    @Override // com.alibaba.ariver.kernel.api.node.ValueStore
    public JSONObject getJsonValue(String str) {
        Object obj = this.mValueStoreMap.get(str);
        if (obj != null) {
            try {
                return (JSONObject) obj;
            } catch (Throwable th) {
                RVLogger.e(TAG, "getStringValue error!", th);
                return null;
            }
        }
        return null;
    }

    @Override // com.alibaba.ariver.kernel.api.node.ValueStore
    public void putJsonValue(String str, JSONObject jSONObject) {
        this.mValueStoreMap.put(str, jSONObject);
    }

    @Override // com.alibaba.ariver.kernel.api.node.ValueStore
    public JSONArray getJsonArrayValue(String str) {
        Object obj = this.mValueStoreMap.get(str);
        if (obj != null) {
            try {
                return (JSONArray) obj;
            } catch (Throwable th) {
                RVLogger.e(TAG, "getStringValue error!", th);
                return null;
            }
        }
        return null;
    }

    @Override // com.alibaba.ariver.kernel.api.node.ValueStore
    public void putJsonArrayValue(String str, JSONArray jSONArray) {
        this.mValueStoreMap.put(str, jSONArray);
    }
}
