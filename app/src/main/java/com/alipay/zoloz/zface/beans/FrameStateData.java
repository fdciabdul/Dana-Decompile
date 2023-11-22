package com.alipay.zoloz.zface.beans;

import com.alipay.zoloz.toyger.algorithm.TGFaceState;
import com.alipay.zoloz.toyger.face.ToygerFaceAttr;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes7.dex */
public class FrameStateData {
    public ToygerFaceAttr attr;
    public int uiDesState = 0;
    public TGFaceState tgFaceState = new TGFaceState();
    public Map extMap = new HashMap();

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FrameStateData{uiDesState=");
        sb.append(this.uiDesState);
        sb.append(", attr=");
        sb.append(this.attr);
        sb.append(", extMap=");
        sb.append(this.extMap);
        sb.append('}');
        return sb.toString();
    }
}
