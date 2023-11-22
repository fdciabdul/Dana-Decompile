package org.yaml.snakeyaml.external.com.google.gdata.util.common.base;

import java.io.IOException;

/* loaded from: classes6.dex */
public abstract class UnicodeEscaper implements Escaper {
    private static final ThreadLocal<char[]> MyBillsEntityDataFactory = new ThreadLocal<char[]>() { // from class: org.yaml.snakeyaml.external.com.google.gdata.util.common.base.UnicodeEscaper.2
        private static char[] MyBillsEntityDataFactory() {
            return new char[1024];
        }

        @Override // java.lang.ThreadLocal
        protected /* synthetic */ char[] initialValue() {
            return MyBillsEntityDataFactory();
        }
    };

    protected abstract char[] BuiltInFictitiousFunctionClassFactory(int i);

    protected int KClassImpl$Data$declaredNonStaticMembers$2(CharSequence charSequence, int i, int i2) {
        while (i < i2) {
            int authRequestContext = getAuthRequestContext(charSequence, i, i2);
            if (authRequestContext < 0 || BuiltInFictitiousFunctionClassFactory(authRequestContext) != null) {
                break;
            }
            i += Character.isSupplementaryCodePoint(authRequestContext) ? 2 : 1;
        }
        return i;
    }

    @Override // org.yaml.snakeyaml.external.com.google.gdata.util.common.base.Escaper
    public String getAuthRequestContext(String str) {
        int length = str.length();
        int KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(str, 0, length);
        return KClassImpl$Data$declaredNonStaticMembers$2 != length ? MyBillsEntityDataFactory(str, KClassImpl$Data$declaredNonStaticMembers$2) : str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String MyBillsEntityDataFactory(String str, int i) {
        int length = str.length();
        char[] cArr = MyBillsEntityDataFactory.get();
        int i2 = 0;
        int i3 = 0;
        while (i < length) {
            int authRequestContext = getAuthRequestContext(str, i, length);
            if (authRequestContext < 0) {
                throw new IllegalArgumentException("Trailing high surrogate at end of input");
            }
            char[] BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(authRequestContext);
            if (BuiltInFictitiousFunctionClassFactory != null) {
                int i4 = i - i2;
                int i5 = i3 + i4;
                int length2 = BuiltInFictitiousFunctionClassFactory.length + i5;
                if (cArr.length < length2) {
                    cArr = KClassImpl$Data$declaredNonStaticMembers$2(cArr, i3, length2 + (length - i) + 32);
                }
                if (i4 > 0) {
                    str.getChars(i2, i, cArr, i3);
                    i3 = i5;
                }
                if (BuiltInFictitiousFunctionClassFactory.length > 0) {
                    System.arraycopy(BuiltInFictitiousFunctionClassFactory, 0, cArr, i3, BuiltInFictitiousFunctionClassFactory.length);
                    i3 += BuiltInFictitiousFunctionClassFactory.length;
                }
            }
            i2 = (Character.isSupplementaryCodePoint(authRequestContext) ? 2 : 1) + i;
            i = KClassImpl$Data$declaredNonStaticMembers$2(str, i2, length);
        }
        int i6 = length - i2;
        if (i6 > 0) {
            int i7 = i6 + i3;
            if (cArr.length < i7) {
                cArr = KClassImpl$Data$declaredNonStaticMembers$2(cArr, i3, i7);
            }
            str.getChars(i2, length, cArr, i3);
            i3 = i7;
        }
        return new String(cArr, 0, i3);
    }

    /* renamed from: org.yaml.snakeyaml.external.com.google.gdata.util.common.base.UnicodeEscaper$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    class AnonymousClass1 implements Appendable {
        int BuiltInFictitiousFunctionClassFactory;
        final /* synthetic */ UnicodeEscaper MyBillsEntityDataFactory;
        final char[] PlaceComponentResult;
        final /* synthetic */ Appendable getAuthRequestContext;

        @Override // java.lang.Appendable
        public Appendable append(CharSequence charSequence) throws IOException {
            return append(charSequence, 0, charSequence.length());
        }

        @Override // java.lang.Appendable
        public Appendable append(CharSequence charSequence, int i, int i2) throws IOException {
            int i3;
            if (i < i2) {
                if (this.BuiltInFictitiousFunctionClassFactory != -1) {
                    int i4 = i + 1;
                    char charAt = charSequence.charAt(i);
                    if (!Character.isLowSurrogate(charAt)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Expected low surrogate character but got ");
                        sb.append(charAt);
                        throw new IllegalArgumentException(sb.toString());
                    }
                    char[] BuiltInFictitiousFunctionClassFactory = this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(Character.toCodePoint((char) this.BuiltInFictitiousFunctionClassFactory, charAt));
                    if (BuiltInFictitiousFunctionClassFactory != null) {
                        for (char c : BuiltInFictitiousFunctionClassFactory) {
                            this.getAuthRequestContext.append(c);
                        }
                        i = i4;
                    } else {
                        this.getAuthRequestContext.append((char) this.BuiltInFictitiousFunctionClassFactory);
                    }
                    this.BuiltInFictitiousFunctionClassFactory = -1;
                    i3 = i;
                    i = i4;
                } else {
                    i3 = i;
                }
                while (true) {
                    int KClassImpl$Data$declaredNonStaticMembers$2 = this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(charSequence, i, i2);
                    if (KClassImpl$Data$declaredNonStaticMembers$2 > i3) {
                        this.getAuthRequestContext.append(charSequence, i3, KClassImpl$Data$declaredNonStaticMembers$2);
                    }
                    if (KClassImpl$Data$declaredNonStaticMembers$2 == i2) {
                        break;
                    }
                    int authRequestContext = UnicodeEscaper.getAuthRequestContext(charSequence, KClassImpl$Data$declaredNonStaticMembers$2, i2);
                    if (authRequestContext < 0) {
                        this.BuiltInFictitiousFunctionClassFactory = -authRequestContext;
                        break;
                    }
                    char[] BuiltInFictitiousFunctionClassFactory2 = this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(authRequestContext);
                    if (BuiltInFictitiousFunctionClassFactory2 != null) {
                        for (char c2 : BuiltInFictitiousFunctionClassFactory2) {
                            this.getAuthRequestContext.append(c2);
                        }
                    } else {
                        int chars = Character.toChars(authRequestContext, this.PlaceComponentResult, 0);
                        char[] cArr = this.PlaceComponentResult;
                        for (int i5 = 0; i5 < chars; i5++) {
                            this.getAuthRequestContext.append(cArr[i5]);
                        }
                    }
                    i3 = (Character.isSupplementaryCodePoint(authRequestContext) ? 2 : 1) + KClassImpl$Data$declaredNonStaticMembers$2;
                    i = i3;
                }
            }
            return this;
        }

        @Override // java.lang.Appendable
        public Appendable append(char c) throws IOException {
            int i = 0;
            if (this.BuiltInFictitiousFunctionClassFactory != -1) {
                if (!Character.isLowSurrogate(c)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Expected low surrogate character but got '");
                    sb.append(c);
                    sb.append("' with value ");
                    sb.append((int) c);
                    throw new IllegalArgumentException(sb.toString());
                }
                char[] BuiltInFictitiousFunctionClassFactory = this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(Character.toCodePoint((char) this.BuiltInFictitiousFunctionClassFactory, c));
                if (BuiltInFictitiousFunctionClassFactory != null) {
                    int length = BuiltInFictitiousFunctionClassFactory.length;
                    while (i < length) {
                        this.getAuthRequestContext.append(BuiltInFictitiousFunctionClassFactory[i]);
                        i++;
                    }
                } else {
                    this.getAuthRequestContext.append((char) this.BuiltInFictitiousFunctionClassFactory);
                    this.getAuthRequestContext.append(c);
                }
                this.BuiltInFictitiousFunctionClassFactory = -1;
            } else if (Character.isHighSurrogate(c)) {
                this.BuiltInFictitiousFunctionClassFactory = c;
            } else if (Character.isLowSurrogate(c)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unexpected low surrogate character '");
                sb2.append(c);
                sb2.append("' with value ");
                sb2.append((int) c);
                throw new IllegalArgumentException(sb2.toString());
            } else {
                char[] BuiltInFictitiousFunctionClassFactory2 = this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(c);
                if (BuiltInFictitiousFunctionClassFactory2 != null) {
                    int length2 = BuiltInFictitiousFunctionClassFactory2.length;
                    while (i < length2) {
                        this.getAuthRequestContext.append(BuiltInFictitiousFunctionClassFactory2[i]);
                        i++;
                    }
                } else {
                    this.getAuthRequestContext.append(c);
                }
            }
            return this;
        }
    }

    protected static final int getAuthRequestContext(CharSequence charSequence, int i, int i2) {
        if (i < i2) {
            int i3 = i + 1;
            char charAt = charSequence.charAt(i);
            if (charAt < 55296 || charAt > 57343) {
                return charAt;
            }
            if (charAt > 56319) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unexpected low surrogate character '");
                sb.append(charAt);
                sb.append("' with value ");
                sb.append((int) charAt);
                sb.append(" at index ");
                sb.append(i3 - 1);
                throw new IllegalArgumentException(sb.toString());
            } else if (i3 == i2) {
                return -charAt;
            } else {
                char charAt2 = charSequence.charAt(i3);
                if (Character.isLowSurrogate(charAt2)) {
                    return Character.toCodePoint(charAt, charAt2);
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Expected low surrogate but got char '");
                sb2.append(charAt2);
                sb2.append("' with value ");
                sb2.append((int) charAt2);
                sb2.append(" at index ");
                sb2.append(i3);
                throw new IllegalArgumentException(sb2.toString());
            }
        }
        throw new IndexOutOfBoundsException("Index exceeds specified range");
    }

    private static final char[] KClassImpl$Data$declaredNonStaticMembers$2(char[] cArr, int i, int i2) {
        char[] cArr2 = new char[i2];
        if (i > 0) {
            System.arraycopy(cArr, 0, cArr2, 0, i);
        }
        return cArr2;
    }
}
