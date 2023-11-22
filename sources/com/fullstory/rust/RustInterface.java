package com.fullstory.rust;

import com.fullstory.util.Log;
import fsimpl.C0230ah;
import fsimpl.C0283cg;
import fsimpl.C0334ee;
import fsimpl.C0342em;
import fsimpl.InterfaceC0333ed;
import fsimpl.InterfaceC0335ef;
import fsimpl.InterfaceC0339ej;
import fsimpl.eJ;
import fsimpl.fi;
import fsimpl.fl;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public class RustInterface {
    private InterfaceC0333ed b;
    private long c;

    /* renamed from: a  reason: collision with root package name */
    private final AtomicReference f7430a = new AtomicReference();
    private final Object d = new C0334ee(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Throwable th) {
        Log.e("Got an exception in a Rust callback", th);
    }

    private void a(byte[] bArr) {
        jni_java_submit_events(this.c, bArr);
    }

    private static native void jni_java_accumulate_and_finish_pointer(long j, int i, float f, float f2);

    private static native void jni_java_accumulate_pointer(long j, int i, float f, float f2);

    private static native void jni_java_activity_change_event(long j, String str, short s);

    private static native void jni_java_crash_event(long j, String str, Object[] objArr);

    private static native void jni_java_finish_all_pointers(long j);

    private static native void jni_java_finish_pointer(long j, int i);

    private static native int jni_java_get_webview_api_msg_type();

    private static native void jni_java_http_complete(long j, long j2, int i, byte[] bArr);

    private static native void jni_java_input_event(long j, short s, int i, String str);

    private static native void jni_java_json_api(long j, String str);

    private static native void jni_java_keep_event(long j, short s, int i);

    private static native void jni_java_key_event(long j, int i, int i2);

    private static native void jni_java_keyboard_visibility_change_event(long j, boolean z);

    private static native void jni_java_log_event(long j, short s, String str, String str2);

    private static native void jni_java_low_memory_event(long j, long j2, long j3);

    private static native String jni_java_make_base_injection_snippet(String str);

    private static native String jni_java_make_shutdown_snippet();

    private static native void jni_java_pause(long j, int i);

    private static native int jni_java_record_string(long j, String str);

    private static native int jni_java_record_view_canvas(long j, int i, byte[] bArr, int i2);

    private static native long jni_java_register(Object obj, boolean z);

    private static native void jni_java_restart(long j);

    private static native void jni_java_secondary_nav_event(long j, short s, short s2, String str);

    private static native void jni_java_send_internal_message(long j, String str);

    private static native void jni_java_shutdown(long j);

    private static native void jni_java_submit_events(long j, byte[] bArr);

    private static native void jni_java_unpause(long j);

    private static native void jni_java_user_activity_event(long j);

    private static native void jni_java_webview_message(long j, long j2, int i, int i2, int i3, String str);

    private static native void jni_java_webview_not_recording(long j, long j2, int i, short s);

    public int a(int i, ByteBuffer byteBuffer) {
        return jni_java_record_view_canvas(this.c, i, byteBuffer.array(), byteBuffer.limit());
    }

    public C0230ah a() {
        InterfaceC0335ef interfaceC0335ef = (InterfaceC0335ef) this.f7430a.get();
        if (interfaceC0335ef != null) {
            return interfaceC0335ef.b();
        }
        return null;
    }

    public String a(String str) {
        return jni_java_make_base_injection_snippet(str);
    }

    public String a(boolean z) {
        InterfaceC0335ef interfaceC0335ef = (InterfaceC0335ef) this.f7430a.get();
        if (interfaceC0335ef != null) {
            return interfaceC0335ef.a(z);
        }
        return null;
    }

    public void a(int i) {
        jni_java_pause(this.c, i);
    }

    public void a(int i, float f, float f2) {
        jni_java_accumulate_pointer(this.c, i, f, f2);
    }

    public void a(int i, int i2) {
        jni_java_key_event(this.c, i, i2);
    }

    public void a(long j) {
        jni_java_webview_message(this.c, j, 0, 0, 0, null);
    }

    public void a(long j, int i, byte b, String str) {
        jni_java_webview_message(this.c, j, 1, b, i, str);
    }

    public void a(long j, int i, short s) {
        jni_java_webview_not_recording(this.c, j, i, s);
    }

    public void a(long j, int i, byte[] bArr) {
        jni_java_http_complete(this.c, j, i, bArr);
    }

    public void a(long j, long j2) {
        jni_java_low_memory_event(this.c, j, j2);
    }

    public void a(InterfaceC0333ed interfaceC0333ed) {
        this.b = interfaceC0333ed;
        this.c = jni_java_register(this.d, !Log.DISABLE_LOGGING);
    }

    public void a(InterfaceC0339ej interfaceC0339ej) {
        if (interfaceC0339ej == null) {
            return;
        }
        fi fiVar = new fi();
        eJ eJVar = new eJ();
        interfaceC0339ej.a(fiVar, eJVar);
        if (eJVar.b() > 0) {
            fiVar.h(C0283cg.a(fiVar, C0283cg.a(fiVar, eJVar.c())));
            ByteBuffer slice = fl.a(fiVar).slice();
            int remaining = slice.remaining();
            byte[] bArr = new byte[remaining];
            slice.get(bArr, 0, remaining);
            a(bArr);
        }
    }

    public void a(C0342em c0342em) {
        a((InterfaceC0339ej) c0342em);
    }

    public void a(String str, short s) {
        jni_java_activity_change_event(this.c, str, s);
    }

    public void a(String str, String[] strArr) {
        jni_java_crash_event(this.c, str, strArr);
    }

    public void a(short s, int i) {
        jni_java_keep_event(this.c, s, i);
    }

    public void a(short s, int i, String str) {
        long j = this.c;
        if (str == null) {
            str = "";
        }
        jni_java_input_event(j, s, i, str);
    }

    public void a(short s, String str, String str2) {
        jni_java_log_event(this.c, s, str, str2);
    }

    public void a(short s, short s2, String str) {
        jni_java_secondary_nav_event(this.c, s, s2, str);
    }

    public String b() {
        InterfaceC0335ef interfaceC0335ef = (InterfaceC0335ef) this.f7430a.get();
        if (interfaceC0335ef != null) {
            return interfaceC0335ef.a();
        }
        return null;
    }

    public void b(int i) {
        jni_java_finish_pointer(this.c, i);
    }

    public void b(int i, float f, float f2) {
        jni_java_accumulate_and_finish_pointer(this.c, i, f, f2);
    }

    public void b(long j) {
        jni_java_webview_message(this.c, j, 2, 0, 0, null);
    }

    public void b(String str) {
        jni_java_json_api(this.c, str);
    }

    public void b(boolean z) {
        jni_java_keyboard_visibility_change_event(this.c, z);
    }

    public int c(String str) {
        return jni_java_record_string(this.c, str);
    }

    public void c() {
        jni_java_unpause(this.c);
    }

    public void d() {
        jni_java_shutdown(this.c);
    }

    public void d(String str) {
        jni_java_send_internal_message(this.c, str);
    }

    public void e() {
        jni_java_restart(this.c);
    }

    public String f() {
        return jni_java_make_shutdown_snippet();
    }

    public int g() {
        return jni_java_get_webview_api_msg_type();
    }

    public void h() {
        jni_java_finish_all_pointers(this.c);
    }

    public void i() {
        jni_java_user_activity_event(this.c);
    }
}
