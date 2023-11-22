package com.alipay.zoloz.toyger.doc;

import android.graphics.Rect;
import android.graphics.RectF;
import com.alibaba.fastjson.JSON;

/* loaded from: classes7.dex */
public class ToygerDocConfig {
    public String docType;
    public int pageNo;
    public float[] points;
    public Rect rect;
    public float docThreshold = 0.7f;
    public float faceThreshold = 30.0f;
    public float boundaryThreshold = 0.7f;
    public int thickness = 14;
    public int logLevel = 0;
    public String subType = "";
    public int flash = 500;
    public int stackTime = 0;
    public RectF faceROI = new RectF(0.1f, 0.0f, 1.0f, 1.0f);

    public static ToygerDocConfig from(String str) {
        return (ToygerDocConfig) JSON.parseObject(str, ToygerDocConfig.class);
    }
}
