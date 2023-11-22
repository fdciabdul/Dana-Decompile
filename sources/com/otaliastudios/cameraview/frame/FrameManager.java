package com.otaliastudios.cameraview.frame;

import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.size.Size;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes8.dex */
public abstract class FrameManager<T> {
    protected static final CameraLogger getAuthRequestContext = CameraLogger.KClassImpl$Data$declaredNonStaticMembers$2("FrameManager");
    private LinkedBlockingQueue<Frame> MyBillsEntityDataFactory;
    final Class<T> PlaceComponentResult;
    private final int moveToNextValue;
    private int BuiltInFictitiousFunctionClassFactory = -1;
    private Size getErrorConfigVersion = null;
    private int KClassImpl$Data$declaredNonStaticMembers$2 = -1;

    protected abstract void BuiltInFictitiousFunctionClassFactory(T t, boolean z);

    /* JADX INFO: Access modifiers changed from: protected */
    public FrameManager(int i, Class<T> cls) {
        this.moveToNextValue = i;
        this.PlaceComponentResult = cls;
        this.MyBillsEntityDataFactory = new LinkedBlockingQueue<>(i);
    }

    public final int BuiltInFictitiousFunctionClassFactory() {
        return this.moveToNextValue;
    }

    public final int PlaceComponentResult() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    public void PlaceComponentResult(int i, Size size) {
        getAuthRequestContext();
        this.getErrorConfigVersion = size;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        Double.isNaN(r3);
        this.BuiltInFictitiousFunctionClassFactory = (int) Math.ceil(r3 / 8.0d);
        for (int i2 = 0; i2 < this.moveToNextValue; i2++) {
            this.MyBillsEntityDataFactory.offer(new Frame(this));
        }
    }

    private boolean getAuthRequestContext() {
        return this.getErrorConfigVersion != null;
    }

    public final Frame BuiltInFictitiousFunctionClassFactory(T t, long j, int i) {
        if (!getAuthRequestContext()) {
            throw new IllegalStateException("Can't call getFrame() after releasing or before setUp.");
        }
        Frame poll = this.MyBillsEntityDataFactory.poll();
        if (poll != null) {
            getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(0, "getFrame for time:", Long.valueOf(j), "RECYCLING.");
            Size size = this.getErrorConfigVersion;
            int i2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            poll.getAuthRequestContext = t;
            poll.moveToNextValue = j;
            poll.PlaceComponentResult = j;
            poll.BuiltInFictitiousFunctionClassFactory = i;
            poll.lookAheadTest = size;
            poll.KClassImpl$Data$declaredNonStaticMembers$2 = i2;
            return poll;
        }
        getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(1, "getFrame for time:", Long.valueOf(j), "NOT AVAILABLE.");
        BuiltInFictitiousFunctionClassFactory(t, false);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void MyBillsEntityDataFactory(Frame frame, T t) {
        if (getAuthRequestContext()) {
            BuiltInFictitiousFunctionClassFactory(t, this.MyBillsEntityDataFactory.offer(frame));
        }
    }

    public void MyBillsEntityDataFactory() {
        if (!getAuthRequestContext()) {
            getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(2, "release called twice. Ignoring.");
            return;
        }
        getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(1, "release: Clearing the frame and buffer queue.");
        this.MyBillsEntityDataFactory.clear();
        this.BuiltInFictitiousFunctionClassFactory = -1;
        this.getErrorConfigVersion = null;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = -1;
    }
}
