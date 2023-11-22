package com.alibaba.ariver.kernel.ipc;

import androidx.collection.LongSparseArray;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class ShadowNodePool {

    /* renamed from: a  reason: collision with root package name */
    private static ShadowNodePool f6170a;
    private final LongSparseArray<Set<Long>> b = new LongSparseArray<>();
    private final Map<Long, Node> c = new ConcurrentHashMap();

    public static ShadowNodePool getInstance() {
        if (f6170a == null) {
            synchronized (ShadowNodePool.class) {
                if (f6170a == null) {
                    f6170a = new ShadowNodePool();
                }
            }
        }
        return f6170a;
    }

    public Node createOrGetNode(Node node, long j) {
        Node node2 = this.c.get(Long.valueOf(j));
        if (node2 == null) {
            if (node == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("generateNodeId ");
            sb.append(j);
            sb.append(" for localNode: ");
            sb.append(node);
            RVLogger.d("AriverKernel:ShadowNodePool", sb.toString());
            boolean configBoolean = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigBoolean("ariver_enableShadowNodeOpt", true);
            Node node3 = node;
            while (node3.getParentNode() != null) {
                Node parentNode = node3.getParentNode();
                if (configBoolean) {
                    Node node4 = this.c.get(Long.valueOf(parentNode.getNodeId()));
                    if (node4 == null) {
                        parentNode.onInitialized();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("generateNodeId ");
                        sb2.append(parentNode.getNodeId());
                        sb2.append(" for parentNode: ");
                        sb2.append(parentNode);
                        RVLogger.d("AriverKernel:ShadowNodePool", sb2.toString());
                        this.c.put(Long.valueOf(parentNode.getNodeId()), parentNode);
                    } else {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("replace parentNode ");
                        sb3.append(parentNode.getNodeId());
                        sb3.append(" and instance ");
                        sb3.append(parentNode);
                        sb3.append(" to existed: ");
                        sb3.append(node4);
                        RVLogger.d("AriverKernel:ShadowNodePool", sb3.toString());
                        node3.setParentNode(node4);
                    }
                } else {
                    parentNode.onInitialized();
                }
                node3 = parentNode;
            }
            node.onInitialized();
            this.c.put(Long.valueOf(j), node);
            return node;
        }
        return node2;
    }

    public void bindStartToken(long j, long j2) {
        Set<Long> MyBillsEntityDataFactory = this.b.MyBillsEntityDataFactory(j, null);
        if (MyBillsEntityDataFactory == null) {
            MyBillsEntityDataFactory = new HashSet<>();
            this.b.getAuthRequestContext(j, MyBillsEntityDataFactory);
        }
        MyBillsEntityDataFactory.add(Long.valueOf(j2));
    }

    public void unBindStartToken(long j) {
        StringBuilder sb = new StringBuilder();
        sb.append("unBindStartToken ");
        sb.append(j);
        RVLogger.d("AriverKernel:ShadowNodePool", sb.toString());
        Set<Long> MyBillsEntityDataFactory = this.b.MyBillsEntityDataFactory(j, null);
        if (MyBillsEntityDataFactory != null) {
            Iterator<Long> it = MyBillsEntityDataFactory.iterator();
            while (it.hasNext()) {
                onNodeExit(it.next().longValue());
            }
        }
        this.b.PlaceComponentResult(j);
    }

    public void onNodeExit(long j) {
        Node remove = this.c.remove(Long.valueOf(j));
        StringBuilder sb = new StringBuilder();
        sb.append("onNodeExit ");
        sb.append(j);
        sb.append(" node: ");
        sb.append(remove);
        RVLogger.d("AriverKernel:ShadowNodePool", sb.toString());
        if (remove != null) {
            remove.onFinalized();
        }
    }
}
