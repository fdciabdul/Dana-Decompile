package com.alipay.zoloz.toyger.doc;

import com.alipay.zoloz.toyger.algorithm.TGFrame;
import java.util.Map;

/* loaded from: classes7.dex */
public interface ToygerDocCallback {
    boolean onComplete(int i, TGFrame tGFrame);

    boolean onEvent(int i, Map<String, Object> map);

    boolean onStateUpdated(ToygerDocState toygerDocState, ToygerDocAttr toygerDocAttr, Map<String, Object> map);
}
