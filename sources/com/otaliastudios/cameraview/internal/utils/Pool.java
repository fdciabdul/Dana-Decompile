package com.otaliastudios.cameraview.internal.utils;

import com.otaliastudios.cameraview.CameraLogger;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes8.dex */
public class Pool<T> {
    private static final CameraLogger KClassImpl$Data$declaredNonStaticMembers$2 = CameraLogger.KClassImpl$Data$declaredNonStaticMembers$2("Pool");
    private int BuiltInFictitiousFunctionClassFactory;
    public final Object MyBillsEntityDataFactory = new Object();
    private int NetworkUserEntityData$$ExternalSyntheticLambda0;
    private Factory<T> PlaceComponentResult;
    public LinkedBlockingQueue<T> getAuthRequestContext;

    /* loaded from: classes8.dex */
    public interface Factory<T> {
        T getAuthRequestContext();
    }

    public Pool(int i, Factory<T> factory) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = i;
        this.getAuthRequestContext = new LinkedBlockingQueue<>(i);
        this.PlaceComponentResult = factory;
    }

    public final boolean MyBillsEntityDataFactory() {
        boolean z;
        synchronized (this.MyBillsEntityDataFactory) {
            z = getAuthRequestContext() >= this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        }
        return z;
    }

    public final T KClassImpl$Data$declaredNonStaticMembers$2() {
        synchronized (this.MyBillsEntityDataFactory) {
            T poll = this.getAuthRequestContext.poll();
            if (poll != null) {
                this.BuiltInFictitiousFunctionClassFactory++;
                KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(0, "GET - Reusing recycled item.", this);
                return poll;
            } else if (!MyBillsEntityDataFactory()) {
                this.BuiltInFictitiousFunctionClassFactory++;
                KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(0, "GET - Creating a new item.", this);
                return this.PlaceComponentResult.getAuthRequestContext();
            } else {
                KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(0, "GET - Returning null. Too much items requested.", this);
                return null;
            }
        }
    }

    public final void MyBillsEntityDataFactory(T t) {
        synchronized (this.MyBillsEntityDataFactory) {
            KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(0, "RECYCLE - Recycling item.", this);
            int i = this.BuiltInFictitiousFunctionClassFactory - 1;
            this.BuiltInFictitiousFunctionClassFactory = i;
            if (i < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("Trying to recycle an item which makes activeCount < 0. This means that this or some previous items being recycled were not coming from this pool, or some item was recycled more than once. ");
                sb.append(this);
                throw new IllegalStateException(sb.toString());
            } else if (!this.getAuthRequestContext.offer(t)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Trying to recycle an item while the queue is full. This means that this or some previous items being recycled were not coming from this pool, or some item was recycled more than once. ");
                sb2.append(this);
                throw new IllegalStateException(sb2.toString());
            }
        }
    }

    private int getAuthRequestContext() {
        int BuiltInFictitiousFunctionClassFactory;
        int PlaceComponentResult;
        synchronized (this.MyBillsEntityDataFactory) {
            BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory();
            PlaceComponentResult = PlaceComponentResult();
        }
        return BuiltInFictitiousFunctionClassFactory + PlaceComponentResult;
    }

    private int BuiltInFictitiousFunctionClassFactory() {
        int i;
        synchronized (this.MyBillsEntityDataFactory) {
            i = this.BuiltInFictitiousFunctionClassFactory;
        }
        return i;
    }

    private int PlaceComponentResult() {
        int size;
        synchronized (this.MyBillsEntityDataFactory) {
            size = this.getAuthRequestContext.size();
        }
        return size;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" - count:");
        sb.append(getAuthRequestContext());
        sb.append(", active:");
        sb.append(BuiltInFictitiousFunctionClassFactory());
        sb.append(", recycled:");
        sb.append(PlaceComponentResult());
        return sb.toString();
    }
}
