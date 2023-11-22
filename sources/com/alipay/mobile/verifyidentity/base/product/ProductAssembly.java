package com.alipay.mobile.verifyidentity.base.product;

import java.util.ArrayList;

/* loaded from: classes3.dex */
public class ProductAssembly {
    private IEnvInfo envInfo;
    private int curIndex = 0;
    private ProcessType processType = ProcessType.OR;
    private ToastType toastType = ToastType.NORMAl;
    private ArrayList<String> productItemArrayList = new ArrayList<>();

    /* loaded from: classes3.dex */
    public enum ProcessType {
        OR,
        AND
    }

    /* loaded from: classes3.dex */
    public enum ToastType {
        NORMAl,
        ALIPAYLOG
    }

    public void setProcessType(ProcessType processType) {
        this.processType = processType;
    }

    public ProcessType getProcessType() {
        return this.processType;
    }

    public ToastType getToastType() {
        return this.toastType;
    }

    public void setToastType(ToastType toastType) {
        this.toastType = toastType;
    }

    public IEnvInfo getEnvInfo() {
        return this.envInfo;
    }

    public void setEnvInfo(IEnvInfo iEnvInfo) {
        this.envInfo = iEnvInfo;
    }

    public void addProduct(String str) {
        this.productItemArrayList.add(str);
    }

    public String getFirstProduct() {
        if (this.productItemArrayList.size() > 0) {
            this.curIndex = 0;
            return this.productItemArrayList.get(0);
        }
        return null;
    }

    public String getNextProduct() {
        int size = this.productItemArrayList.size();
        int i = this.curIndex + 1;
        if (size > i) {
            this.curIndex = i;
            return this.productItemArrayList.get(i);
        }
        return null;
    }

    public int number() {
        return this.productItemArrayList.size();
    }
}
