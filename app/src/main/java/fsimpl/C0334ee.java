package fsimpl;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.fullstory.instrumentation.InstrumentInjector;
import com.fullstory.rust.RustInterface;
import com.fullstory.util.Log;
import com.google.common.base.Ascii;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: fsimpl.ee  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0334ee {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ RustInterface f7968a;
    public static final byte[] PlaceComponentResult = {TarHeader.LF_DIR, 93, -14, -126, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
    public static final int BuiltInFictitiousFunctionClassFactory = 69;

    public C0334ee(RustInterface rustInterface) {
        this.f7968a = rustInterface;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:11:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(byte r5, int r6, int r7, java.lang.Object[] r8) {
        /*
            byte[] r0 = fsimpl.C0334ee.PlaceComponentResult
            int r5 = r5 * 3
            int r5 = 16 - r5
            int r6 = r6 + 4
            int r7 = 106 - r7
            byte[] r1 = new byte[r5]
            r2 = -1
            int r5 = r5 + r2
            if (r0 != 0) goto L16
            r2 = r1
            r3 = -1
            r1 = r0
            r0 = r8
            r8 = r6
            goto L34
        L16:
            r4 = r7
            r7 = r6
            r6 = r4
        L19:
            int r2 = r2 + 1
            byte r3 = (byte) r6
            r1[r2] = r3
            int r7 = r7 + 1
            if (r2 != r5) goto L2b
            java.lang.String r5 = new java.lang.String
            r6 = 0
            r5.<init>(r1, r6)
            r8[r6] = r5
            return
        L2b:
            r3 = r0[r7]
            r4 = r8
            r8 = r7
            r7 = r3
            r3 = r2
            r2 = r1
            r1 = r0
            r0 = r4
        L34:
            int r7 = -r7
            int r6 = r6 + r7
            int r6 = r6 + 2
            r7 = r8
            r8 = r0
            r0 = r1
            r1 = r2
            r2 = r3
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: fsimpl.C0334ee.b(byte, int, int, java.lang.Object[]):void");
    }

    private long java_create_scanner(byte[] bArr) {
        InterfaceC0333ed interfaceC0333ed;
        AtomicReference atomicReference;
        InterfaceC0333ed interfaceC0333ed2;
        try {
            interfaceC0333ed = this.f7968a.b;
            InterfaceC0335ef a2 = interfaceC0333ed.a(bArr);
            if (a2 != null) {
                atomicReference = this.f7968a.f7430a;
                if (((InterfaceC0335ef) atomicReference.getAndSet(a2)) != null) {
                    Log.e("Scanner improperly set twice");
                }
                InstrumentInjector.gotSession();
                interfaceC0333ed2 = this.f7968a.b;
                try {
                    Object[] objArr = {interfaceC0333ed2};
                    Object[] objArr2 = new Object[1];
                    b((byte) (PlaceComponentResult[5] - 1), (byte) (-PlaceComponentResult[2]), (byte) (PlaceComponentResult[5] - 1), objArr2);
                    Class<?> cls = Class.forName((String) objArr2[0]);
                    b((byte) (PlaceComponentResult[5] - 1), (byte) (-PlaceComponentResult[5]), PlaceComponentResult[5], new Object[1]);
                    return ((Integer) cls.getMethod((String) r6[0], Object.class).invoke(null, objArr)).intValue();
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause != null) {
                        throw cause;
                    }
                    throw th;
                }
            }
        } catch (Exception e) {
            this.f7968a.a(e);
        }
        Log.e("Uh-oh: didn't create a scanner");
        return 0L;
    }

    private void java_destroy_scanner(long j) {
        AtomicReference atomicReference;
        String obj;
        try {
            atomicReference = this.f7968a.f7430a;
            InterfaceC0335ef interfaceC0335ef = (InterfaceC0335ef) atomicReference.getAndSet(null);
            try {
                Object[] objArr = new Object[1];
                b((byte) (PlaceComponentResult[5] - 1), (byte) (-PlaceComponentResult[2]), (byte) (PlaceComponentResult[5] - 1), objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                b((byte) (PlaceComponentResult[5] - 1), (byte) (-PlaceComponentResult[5]), PlaceComponentResult[5], objArr2);
                int intValue = ((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, interfaceC0335ef)).intValue();
                if (interfaceC0335ef == null) {
                    obj = "Destroy scanner called twice";
                } else if (intValue == j) {
                    interfaceC0335ef.c();
                    return;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Destroy scanner called improperly: ");
                    sb.append(intValue);
                    sb.append(" vs ");
                    sb.append(j);
                    obj = sb.toString();
                }
                Log.e(obj);
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        } catch (Exception e) {
            this.f7968a.a(e);
        }
    }

    public void java_async_http_request(long j, String str, byte[] bArr, String str2, String str3, boolean z, boolean z2) {
        InterfaceC0333ed interfaceC0333ed;
        try {
            interfaceC0333ed = this.f7968a.b;
            interfaceC0333ed.a(j, str, bArr, str2, str3, z, z2);
        } catch (Exception e) {
            this.f7968a.a(e);
        }
    }

    public void java_consent_changed(boolean z) {
        AtomicReference atomicReference;
        try {
            atomicReference = this.f7968a.f7430a;
            InterfaceC0335ef interfaceC0335ef = (InterfaceC0335ef) atomicReference.get();
            if (interfaceC0335ef == null) {
                Log.e("ScannerCallbacks was null");
            } else {
                interfaceC0335ef.b(z);
            }
        } catch (Exception e) {
            this.f7968a.a(e);
        }
    }

    public boolean java_eval_webview_js(long j, String str, String str2) {
        InterfaceC0333ed interfaceC0333ed;
        try {
            interfaceC0333ed = this.f7968a.b;
            return interfaceC0333ed.a(j, str, str2);
        } catch (Exception e) {
            this.f7968a.a(e);
            return false;
        }
    }

    public void java_got_session(byte[] bArr) {
        AtomicReference atomicReference;
        atomicReference = this.f7968a.f7430a;
        InterfaceC0335ef interfaceC0335ef = (InterfaceC0335ef) atomicReference.get();
        if (bArr == null || bArr.length == 0) {
            try {
                Object[] objArr = {interfaceC0335ef};
                Object[] objArr2 = new Object[1];
                b((byte) (PlaceComponentResult[5] - 1), (byte) (-PlaceComponentResult[2]), (byte) (PlaceComponentResult[5] - 1), objArr2);
                Class<?> cls = Class.forName((String) objArr2[0]);
                b((byte) (PlaceComponentResult[5] - 1), (byte) (-PlaceComponentResult[5]), PlaceComponentResult[5], new Object[1]);
                java_destroy_scanner(((Integer) cls.getMethod((String) r7[0], Object.class).invoke(null, objArr)).intValue());
                return;
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
        if (interfaceC0335ef != null) {
            try {
                Object[] objArr3 = {interfaceC0335ef};
                Object[] objArr4 = new Object[1];
                b((byte) (PlaceComponentResult[5] - 1), (byte) (-PlaceComponentResult[2]), (byte) (PlaceComponentResult[5] - 1), objArr4);
                Class<?> cls2 = Class.forName((String) objArr4[0]);
                b((byte) (PlaceComponentResult[5] - 1), (byte) (-PlaceComponentResult[5]), PlaceComponentResult[5], new Object[1]);
                java_destroy_scanner(((Integer) cls2.getMethod((String) r8[0], Object.class).invoke(null, objArr3)).intValue());
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        java_create_scanner(bArr);
    }

    public String java_sync_read_config_key(String str) {
        InterfaceC0333ed interfaceC0333ed;
        try {
            interfaceC0333ed = this.f7968a.b;
            return interfaceC0333ed.a(str);
        } catch (Exception e) {
            this.f7968a.a(e);
            return null;
        }
    }

    public boolean java_sync_read_config_key_bool(String str) {
        InterfaceC0333ed interfaceC0333ed;
        try {
            interfaceC0333ed = this.f7968a.b;
            return interfaceC0333ed.b(str);
        } catch (Exception e) {
            this.f7968a.a(e);
            return false;
        }
    }

    public byte[] java_sync_read_config_key_buffer(String str) {
        InterfaceC0333ed interfaceC0333ed;
        try {
            interfaceC0333ed = this.f7968a.b;
            return interfaceC0333ed.d(str);
        } catch (Exception e) {
            this.f7968a.a(e);
            return null;
        }
    }

    public int java_sync_read_config_key_i32(String str) {
        InterfaceC0333ed interfaceC0333ed;
        try {
            interfaceC0333ed = this.f7968a.b;
            return interfaceC0333ed.c(str);
        } catch (Exception e) {
            this.f7968a.a(e);
            return 0;
        }
    }

    public String java_sync_read_key(String str) {
        InterfaceC0333ed interfaceC0333ed;
        try {
            interfaceC0333ed = this.f7968a.b;
            return interfaceC0333ed.e(str);
        } catch (Exception e) {
            this.f7968a.a(e);
            return null;
        }
    }

    public Boolean java_sync_read_key_bool(String str) {
        InterfaceC0333ed interfaceC0333ed;
        try {
            interfaceC0333ed = this.f7968a.b;
            return interfaceC0333ed.f(str);
        } catch (Exception e) {
            this.f7968a.a(e);
            return null;
        }
    }

    public Long java_sync_read_key_long(String str) {
        InterfaceC0333ed interfaceC0333ed;
        try {
            interfaceC0333ed = this.f7968a.b;
            return interfaceC0333ed.g(str);
        } catch (Exception e) {
            this.f7968a.a(e);
            return null;
        }
    }

    public int java_sync_scan_ui(int i, Object obj) {
        AtomicReference atomicReference;
        try {
            atomicReference = this.f7968a.f7430a;
            InterfaceC0335ef interfaceC0335ef = (InterfaceC0335ef) atomicReference.get();
            if (interfaceC0335ef == null) {
                Log.e("ScannerCallbacks was null");
                return -1;
            }
            return interfaceC0335ef.a(i, obj);
        } catch (Exception e) {
            this.f7968a.a(e);
            return -1;
        }
    }

    public void java_sync_write_key(String str, String str2) {
        InterfaceC0333ed interfaceC0333ed;
        try {
            interfaceC0333ed = this.f7968a.b;
            interfaceC0333ed.a(str, str2);
        } catch (Exception e) {
            this.f7968a.a(e);
        }
    }

    public void java_sync_write_key_bool(String str, Boolean bool) {
        InterfaceC0333ed interfaceC0333ed;
        try {
            interfaceC0333ed = this.f7968a.b;
            interfaceC0333ed.a(str, bool);
        } catch (Exception e) {
            this.f7968a.a(e);
        }
    }

    public void java_sync_write_key_long(String str, Long l) {
        InterfaceC0333ed interfaceC0333ed;
        try {
            interfaceC0333ed = this.f7968a.b;
            interfaceC0333ed.a(str, l);
        } catch (Exception e) {
            this.f7968a.a(e);
        }
    }
}
