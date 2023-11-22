package ru.noties.markwon.renderer.html2;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes6.dex */
public abstract class CssInlineStyleParser {
    public abstract Iterable<CssProperty> getAuthRequestContext(String str);

    public static CssInlineStyleParser BuiltInFictitiousFunctionClassFactory() {
        return new Impl();
    }

    /* loaded from: classes6.dex */
    static class Impl extends CssInlineStyleParser {
        Impl() {
        }

        @Override // ru.noties.markwon.renderer.html2.CssInlineStyleParser
        public final Iterable<CssProperty> getAuthRequestContext(String str) {
            return new CssIterable(str);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes6.dex */
        public static class CssIterable implements Iterable<CssProperty> {
            private final String getAuthRequestContext;

            CssIterable(String str) {
                this.getAuthRequestContext = str;
            }

            @Override // java.lang.Iterable
            public Iterator<CssProperty> iterator() {
                return new CssIterator(this, (byte) 0);
            }

            /* loaded from: classes6.dex */
            class CssIterator implements Iterator<CssProperty> {
                private int BuiltInFictitiousFunctionClassFactory;
                private final StringBuilder MyBillsEntityDataFactory;
                private final int PlaceComponentResult;
                private final CssProperty getAuthRequestContext;

                private CssIterator() {
                    this.getAuthRequestContext = new CssProperty();
                    this.MyBillsEntityDataFactory = new StringBuilder();
                    this.PlaceComponentResult = CssIterable.this.getAuthRequestContext.length();
                }

                /* synthetic */ CssIterator(CssIterable cssIterable, byte b) {
                    this();
                }

                private boolean MyBillsEntityDataFactory() {
                    return PlaceComponentResult(this.getAuthRequestContext.getAuthRequestContext, this.getAuthRequestContext.PlaceComponentResult);
                }

                private static boolean PlaceComponentResult(String str, String str2) {
                    return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) ? false : true;
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    CssProperty cssProperty = this.getAuthRequestContext;
                    cssProperty.getAuthRequestContext = "";
                    cssProperty.PlaceComponentResult = "";
                    this.MyBillsEntityDataFactory.setLength(0);
                    int i = this.BuiltInFictitiousFunctionClassFactory;
                    String str = null;
                    String str2 = null;
                    boolean z = false;
                    while (true) {
                        if (i < this.PlaceComponentResult) {
                            char charAt = CssIterable.this.getAuthRequestContext.charAt(i);
                            if (str == null) {
                                if (':' == charAt) {
                                    if (this.MyBillsEntityDataFactory.length() > 0) {
                                        str = this.MyBillsEntityDataFactory.toString().trim();
                                    }
                                    this.MyBillsEntityDataFactory.setLength(0);
                                } else if (';' == charAt) {
                                    this.MyBillsEntityDataFactory.setLength(0);
                                } else if (Character.isWhitespace(charAt)) {
                                    if (this.MyBillsEntityDataFactory.length() > 0) {
                                        z = true;
                                    }
                                } else if (z) {
                                    this.MyBillsEntityDataFactory.setLength(0);
                                    this.MyBillsEntityDataFactory.append(charAt);
                                    z = false;
                                } else {
                                    this.MyBillsEntityDataFactory.append(charAt);
                                }
                            } else if (str2 != null) {
                                continue;
                            } else if (Character.isWhitespace(charAt)) {
                                if (this.MyBillsEntityDataFactory.length() > 0) {
                                    this.MyBillsEntityDataFactory.append(charAt);
                                }
                            } else if (';' == charAt) {
                                str2 = this.MyBillsEntityDataFactory.toString().trim();
                                this.MyBillsEntityDataFactory.setLength(0);
                                if (PlaceComponentResult(str, str2)) {
                                    this.BuiltInFictitiousFunctionClassFactory = i + 1;
                                    CssProperty cssProperty2 = this.getAuthRequestContext;
                                    cssProperty2.getAuthRequestContext = str;
                                    cssProperty2.PlaceComponentResult = str2;
                                    break;
                                }
                            } else {
                                this.MyBillsEntityDataFactory.append(charAt);
                            }
                            i++;
                        } else if (str != null && this.MyBillsEntityDataFactory.length() > 0) {
                            String trim = this.MyBillsEntityDataFactory.toString().trim();
                            CssProperty cssProperty3 = this.getAuthRequestContext;
                            cssProperty3.getAuthRequestContext = str;
                            cssProperty3.PlaceComponentResult = trim;
                            this.BuiltInFictitiousFunctionClassFactory = this.PlaceComponentResult;
                        }
                    }
                    return MyBillsEntityDataFactory();
                }

                @Override // java.util.Iterator
                public /* synthetic */ CssProperty next() {
                    if (!MyBillsEntityDataFactory()) {
                        throw new NoSuchElementException();
                    }
                    return this.getAuthRequestContext;
                }
            }
        }
    }
}
