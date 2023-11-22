package com.alipay.mobile.jsengine.v8;

/* loaded from: classes6.dex */
public class V8Context extends V8Object {
    private long handle;

    public V8Context(V8 v8) {
        super(v8);
    }

    public V8Context(V8 v8, Object obj, String str) {
        super(v8, obj);
        v8.debugRegisterContext(this.handle, str);
    }

    @Override // com.alipay.mobile.jsengine.v8.V8Object, com.alipay.mobile.jsengine.v8.V8Value
    protected V8Value createTwin() {
        return new V8Context(this.v8);
    }

    @Override // com.alipay.mobile.jsengine.v8.V8Object, com.alipay.mobile.jsengine.v8.V8Value
    public V8Context twin() {
        return (V8Context) super.twin();
    }

    @Override // com.alipay.mobile.jsengine.v8.V8Object
    public String toString() {
        return (this.released || this.v8.isReleased()) ? "[Context released]" : super.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8Value
    public void initialize(long j, Object obj) {
        this.handle = this.v8.initNewV8Context(j, obj != null ? ((V8Object) obj).getHandle() : 0L);
        this.released = false;
        addObjectReference(this.v8.getContextGlobalHandle(j, this.handle));
    }

    public void enter() {
        this.v8.checkThread();
        checkReleased();
        this.v8.enterContext(this.v8.getV8RuntimePtr(), this.handle);
    }

    public void exit() {
        this.v8.checkThread();
        checkReleased();
        this.v8.exitContext(this.v8.getV8RuntimePtr(), this.handle);
    }

    public long getContextHandle() {
        return this.handle;
    }
}
