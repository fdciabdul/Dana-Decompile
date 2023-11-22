package com.alibaba.ariver.resource.api.content;

import android.graphics.ImageFormat;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.engine.api.resources.ResourceSourceType;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.kernel.common.utils.UrlUtils;
import java.util.HashMap;
import java.util.Map;
import kotlin.text.Typography;
import o.A;

/* loaded from: classes6.dex */
abstract class AbstractResource implements Resource {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 0;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 269894726;
    private static int MyBillsEntityDataFactory = 1;

    /* renamed from: a  reason: collision with root package name */
    private String f6204a;
    private String b;
    private Map<String, String> c;
    private String d;
    private Map<String, String> e;
    protected ResourceSourceType mSourceType;

    @Override // com.alibaba.ariver.engine.api.resources.Resource
    public String getEncoding() {
        int i = BuiltInFictitiousFunctionClassFactory + 79;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        Object[] objArr = new Object[1];
        f(new char[]{2, 16, 17, 65524, 65513}, ImageFormat.getBitsPerPixel(0) + 168, (ViewConfiguration.getScrollDefaultDelay() >> 16) + 5, true, 3 - (KeyEvent.getMaxKeyCode() >> 16), objArr);
        String intern = ((String) objArr[0]).intern();
        int i3 = BuiltInFictitiousFunctionClassFactory + 103;
        MyBillsEntityDataFactory = i3 % 128;
        int i4 = i3 % 2;
        return intern;
    }

    @Override // com.alibaba.ariver.engine.api.resources.Resource
    public boolean isLocal() {
        int i = MyBillsEntityDataFactory + 39;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        return (i % 2 != 0 ? 'G' : Typography.quote) != '\"';
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractResource(String str) {
        this.b = str;
        this.f6204a = UrlUtils.purifyUrl(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getOriginUrl() {
        String str;
        try {
            int i = BuiltInFictitiousFunctionClassFactory + 47;
            MyBillsEntityDataFactory = i % 128;
            if (!(i % 2 != 0)) {
                str = this.b;
                int i2 = 55 / 0;
            } else {
                str = this.b;
            }
            int i3 = MyBillsEntityDataFactory + 91;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            if ((i3 % 2 != 0 ? 'C' : ')') != 'C') {
                return str;
            }
            Object[] objArr = null;
            int length = objArr.length;
            return str;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // com.alibaba.ariver.engine.api.resources.Resource
    public String getUrl() {
        String str;
        int i = BuiltInFictitiousFunctionClassFactory + 37;
        MyBillsEntityDataFactory = i % 128;
        if (!(i % 2 != 0)) {
            str = this.f6204a;
            Object obj = null;
            obj.hashCode();
        } else {
            str = this.f6204a;
        }
        try {
            int i2 = BuiltInFictitiousFunctionClassFactory + 113;
            MyBillsEntityDataFactory = i2 % 128;
            int i3 = i2 % 2;
            return str;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001f, code lost:
    
        if ((android.text.TextUtils.isEmpty(r3.d) ? 'H' : 'Y') != 'Y') goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002d, code lost:
    
        if ((android.text.TextUtils.isEmpty(r3.d)) != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002f, code lost:
    
        r0 = com.alibaba.ariver.resource.api.content.AbstractResource.BuiltInFictitiousFunctionClassFactory + 105;
        com.alibaba.ariver.resource.api.content.AbstractResource.MyBillsEntityDataFactory = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003b, code lost:
    
        r3.d = com.alibaba.ariver.kernel.common.utils.FileUtils.getMimeType(r3.f6204a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0042, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0043, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0044, code lost:
    
        r0 = r3.d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0046, code lost:
    
        r1 = com.alibaba.ariver.resource.api.content.AbstractResource.BuiltInFictitiousFunctionClassFactory + 47;
        com.alibaba.ariver.resource.api.content.AbstractResource.MyBillsEntityDataFactory = r1 % 128;
        r1 = r1 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0050, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0051, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0052, code lost:
    
        throw r0;
     */
    @Override // com.alibaba.ariver.engine.api.resources.Resource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String getMimeType() {
        /*
            r3 = this;
            int r0 = com.alibaba.ariver.resource.api.content.AbstractResource.BuiltInFictitiousFunctionClassFactory
            int r0 = r0 + 45
            int r1 = r0 % 128
            com.alibaba.ariver.resource.api.content.AbstractResource.MyBillsEntityDataFactory = r1
            int r0 = r0 % 2
            r1 = 0
            if (r0 != 0) goto L24
            java.lang.String r0 = r3.d
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r2 = 41
            int r2 = r2 / r1
            r1 = 89
            if (r0 == 0) goto L1d
            r0 = 72
            goto L1f
        L1d:
            r0 = 89
        L1f:
            if (r0 == r1) goto L44
            goto L2f
        L22:
            r0 = move-exception
            throw r0
        L24:
            java.lang.String r0 = r3.d
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L2d
            r1 = 1
        L2d:
            if (r1 == 0) goto L44
        L2f:
            int r0 = com.alibaba.ariver.resource.api.content.AbstractResource.BuiltInFictitiousFunctionClassFactory
            int r0 = r0 + 105
            int r1 = r0 % 128
            com.alibaba.ariver.resource.api.content.AbstractResource.MyBillsEntityDataFactory = r1
            int r0 = r0 % 2
            java.lang.String r0 = r3.f6204a     // Catch: java.lang.Exception -> L42
            java.lang.String r0 = com.alibaba.ariver.kernel.common.utils.FileUtils.getMimeType(r0)     // Catch: java.lang.Exception -> L51
            r3.d = r0     // Catch: java.lang.Exception -> L51
            goto L44
        L42:
            r0 = move-exception
            throw r0
        L44:
            java.lang.String r0 = r3.d     // Catch: java.lang.Exception -> L51
            int r1 = com.alibaba.ariver.resource.api.content.AbstractResource.BuiltInFictitiousFunctionClassFactory
            int r1 = r1 + 47
            int r2 = r1 % 128
            com.alibaba.ariver.resource.api.content.AbstractResource.MyBillsEntityDataFactory = r2
            int r1 = r1 % 2
            return r0
        L51:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.resource.api.content.AbstractResource.getMimeType():java.lang.String");
    }

    @Override // com.alibaba.ariver.engine.api.resources.Resource
    public void setSourceType(ResourceSourceType resourceSourceType) {
        try {
            int i = MyBillsEntityDataFactory + 81;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            if (!(i % 2 == 0)) {
                this.mSourceType = resourceSourceType;
                int i2 = 14 / 0;
            } else {
                try {
                    this.mSourceType = resourceSourceType;
                } catch (Exception e) {
                    throw e;
                }
            }
            int i3 = BuiltInFictitiousFunctionClassFactory + 79;
            MyBillsEntityDataFactory = i3 % 128;
            if ((i3 % 2 == 0 ? '\f' : (char) 20) != 20) {
                int i4 = 48 / 0;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // com.alibaba.ariver.engine.api.resources.Resource
    public ResourceSourceType getSourceType() {
        int i = BuiltInFictitiousFunctionClassFactory + 115;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        try {
            ResourceSourceType resourceSourceType = this.mSourceType;
            int i3 = BuiltInFictitiousFunctionClassFactory + 33;
            MyBillsEntityDataFactory = i3 % 128;
            int i4 = i3 % 2;
            return resourceSourceType;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // com.alibaba.ariver.engine.api.resources.Resource
    public Map<String, String> getHeaders() {
        int i = BuiltInFictitiousFunctionClassFactory + 83;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        try {
            Map<String, String> map = this.c;
            int i3 = MyBillsEntityDataFactory + 57;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            int i4 = i3 % 2;
            return map;
        } catch (Exception e) {
            throw e;
        }
    }

    public Map<String, String> getRequestHeadersMap() {
        try {
            int i = MyBillsEntityDataFactory + 37;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            int i2 = i % 2;
            Map<String, String> map = this.e;
            int i3 = BuiltInFictitiousFunctionClassFactory + 97;
            MyBillsEntityDataFactory = i3 % 128;
            if ((i3 % 2 == 0 ? (char) 6 : 'U') != 6) {
                return map;
            }
            int i4 = 76 / 0;
            return map;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0018, code lost:
    
        if (r4.e == null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x001f, code lost:
    
        if (r4.e == null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0021, code lost:
    
        r4.e = new java.util.HashMap();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void addRequestHeader(java.lang.String r5, java.lang.String r6) {
        /*
            r4 = this;
            int r0 = com.alibaba.ariver.resource.api.content.AbstractResource.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Exception -> L43
            int r0 = r0 + 13
            int r1 = r0 % 128
            com.alibaba.ariver.resource.api.content.AbstractResource.MyBillsEntityDataFactory = r1     // Catch: java.lang.Exception -> L43
            int r0 = r0 % 2
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            if (r0 == 0) goto L1d
            java.util.Map<java.lang.String, java.lang.String> r0 = r4.e
            r3 = 99
            int r3 = r3 / r2
            if (r0 != 0) goto L28
            goto L21
        L1b:
            r5 = move-exception
            throw r5
        L1d:
            java.util.Map<java.lang.String, java.lang.String> r0 = r4.e
            if (r0 != 0) goto L28
        L21:
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r4.e = r0
        L28:
            java.util.Map<java.lang.String, java.lang.String> r0 = r4.e
            r0.put(r5, r6)
            int r5 = com.alibaba.ariver.resource.api.content.AbstractResource.BuiltInFictitiousFunctionClassFactory
            int r5 = r5 + 61
            int r6 = r5 % 128
            com.alibaba.ariver.resource.api.content.AbstractResource.MyBillsEntityDataFactory = r6
            int r5 = r5 % 2
            if (r5 != 0) goto L3a
            goto L3b
        L3a:
            r2 = 1
        L3b:
            if (r2 == r1) goto L42
            r5 = 0
            int r5 = r5.length     // Catch: java.lang.Throwable -> L40
            return
        L40:
            r5 = move-exception
            throw r5
        L42:
            return
        L43:
            r5 = move-exception
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.resource.api.content.AbstractResource.addRequestHeader(java.lang.String, java.lang.String):void");
    }

    @Override // com.alibaba.ariver.engine.api.resources.Resource
    public void addHeader(String str, String str2) {
        int i = MyBillsEntityDataFactory + 121;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        if (!(!"Content-Type".equalsIgnoreCase(str))) {
            try {
                this.d = FileUtils.getMimeTypeFromContentType(str2);
                int i3 = MyBillsEntityDataFactory + 121;
                BuiltInFictitiousFunctionClassFactory = i3 % 128;
                if (i3 % 2 != 0) {
                    Object obj = null;
                    obj.hashCode();
                    return;
                }
                return;
            } catch (Exception e) {
                throw e;
            }
        }
        if (this.c == null) {
            this.c = new HashMap();
        }
        this.c.put(str, str2);
    }

    private static void f(char[] cArr, int i, int i2, boolean z, int i3, Object[] objArr) {
        A a2 = new A();
        char[] cArr2 = new char[i2];
        try {
            a2.MyBillsEntityDataFactory = 0;
            while (true) {
                if ((a2.MyBillsEntityDataFactory < i2 ? (char) 15 : '2') != 15) {
                    break;
                }
                a2.KClassImpl$Data$declaredNonStaticMembers$2 = cArr[a2.MyBillsEntityDataFactory];
                cArr2[a2.MyBillsEntityDataFactory] = (char) (a2.KClassImpl$Data$declaredNonStaticMembers$2 + i);
                int i4 = a2.MyBillsEntityDataFactory;
                cArr2[i4] = (char) (cArr2[i4] - ((int) (KClassImpl$Data$declaredNonStaticMembers$2 ^ (-5694784870793460699L))));
                a2.MyBillsEntityDataFactory++;
            }
            if (i3 > 0) {
                a2.BuiltInFictitiousFunctionClassFactory = i3;
                char[] cArr3 = new char[i2];
                System.arraycopy(cArr2, 0, cArr3, 0, i2);
                System.arraycopy(cArr3, 0, cArr2, i2 - a2.BuiltInFictitiousFunctionClassFactory, a2.BuiltInFictitiousFunctionClassFactory);
                System.arraycopy(cArr3, a2.BuiltInFictitiousFunctionClassFactory, cArr2, 0, i2 - a2.BuiltInFictitiousFunctionClassFactory);
            }
            if ((z ? Typography.dollar : '^') != '^') {
                char[] cArr4 = new char[i2];
                a2.MyBillsEntityDataFactory = 0;
                while (a2.MyBillsEntityDataFactory < i2) {
                    int i5 = $10 + 111;
                    $11 = i5 % 128;
                    if (i5 % 2 == 0) {
                        try {
                            cArr4[a2.MyBillsEntityDataFactory] = cArr2[(a2.MyBillsEntityDataFactory + i2) >>> 1];
                            a2.MyBillsEntityDataFactory %= 1;
                        } catch (Exception e) {
                            throw e;
                        }
                    } else {
                        cArr4[a2.MyBillsEntityDataFactory] = cArr2[(i2 - a2.MyBillsEntityDataFactory) - 1];
                        a2.MyBillsEntityDataFactory++;
                    }
                    int i6 = $11 + 13;
                    $10 = i6 % 128;
                    int i7 = i6 % 2;
                }
                cArr2 = cArr4;
            }
            objArr[0] = new String(cArr2);
        } catch (Exception e2) {
            throw e2;
        }
    }
}
