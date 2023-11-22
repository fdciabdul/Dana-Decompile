package ru.noties.markwon.html.impl.jsoup.nodes;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Arrays;
import java.util.Iterator;
import ru.noties.markwon.html.impl.jsoup.helper.Validate;

/* loaded from: classes6.dex */
public class Attributes implements Iterable<Attribute>, Cloneable {
    private static final String[] MyBillsEntityDataFactory = new String[0];
    public String[] BuiltInFictitiousFunctionClassFactory;
    public String[] PlaceComponentResult;
    public int getAuthRequestContext = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        return str == null ? "" : str;
    }

    public Attributes() {
        String[] strArr = MyBillsEntityDataFactory;
        this.BuiltInFictitiousFunctionClassFactory = strArr;
        this.PlaceComponentResult = strArr;
    }

    public final int BuiltInFictitiousFunctionClassFactory(String str) {
        Validate.MyBillsEntityDataFactory(str);
        for (int i = 0; i < this.getAuthRequestContext; i++) {
            if (str.equals(this.BuiltInFictitiousFunctionClassFactory[i])) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: ru.noties.markwon.html.impl.jsoup.nodes.Attributes$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    class AnonymousClass1 implements Iterator<Attribute>, j$.util.Iterator {
        int getAuthRequestContext = 0;

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.getAuthRequestContext(this, consumer);
        }

        @Override // java.util.Iterator
        public /* synthetic */ void forEachRemaining(java.util.function.Consumer<? super Attribute> consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
        }

        AnonymousClass1() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.getAuthRequestContext < Attributes.this.getAuthRequestContext;
        }

        @Override // java.util.Iterator
        public void remove() {
            Attributes attributes = Attributes.this;
            int i = this.getAuthRequestContext - 1;
            this.getAuthRequestContext = i;
            Attributes.MyBillsEntityDataFactory(attributes, i);
        }

        @Override // java.util.Iterator
        public /* synthetic */ Attribute next() {
            String str = Attributes.this.PlaceComponentResult[this.getAuthRequestContext];
            String str2 = Attributes.this.BuiltInFictitiousFunctionClassFactory[this.getAuthRequestContext];
            if (str == null) {
                str = "";
            }
            Attribute attribute = new Attribute(str2, str, Attributes.this);
            this.getAuthRequestContext++;
            return attribute;
        }
    }

    @Override // java.lang.Iterable
    public java.util.Iterator<Attribute> iterator() {
        return new AnonymousClass1();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Attributes attributes = (Attributes) obj;
        if (this.getAuthRequestContext == attributes.getAuthRequestContext && Arrays.equals(this.BuiltInFictitiousFunctionClassFactory, attributes.BuiltInFictitiousFunctionClassFactory)) {
            return Arrays.equals(this.PlaceComponentResult, attributes.PlaceComponentResult);
        }
        return false;
    }

    public int hashCode() {
        return (((this.getAuthRequestContext * 31) + Arrays.hashCode(this.BuiltInFictitiousFunctionClassFactory)) * 31) + Arrays.hashCode(this.PlaceComponentResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: merged with bridge method [inline-methods] */
    public Attributes clone() {
        try {
            Attributes attributes = (Attributes) super.clone();
            attributes.getAuthRequestContext = this.getAuthRequestContext;
            String[] strArr = this.BuiltInFictitiousFunctionClassFactory;
            int i = this.getAuthRequestContext;
            String[] strArr2 = new String[i];
            System.arraycopy(strArr, 0, strArr2, 0, Math.min(strArr.length, i));
            this.BuiltInFictitiousFunctionClassFactory = strArr2;
            String[] strArr3 = this.PlaceComponentResult;
            int i2 = this.getAuthRequestContext;
            String[] strArr4 = new String[i2];
            System.arraycopy(strArr3, 0, strArr4, 0, Math.min(strArr3.length, i2));
            this.PlaceComponentResult = strArr4;
            return attributes;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    static /* synthetic */ void MyBillsEntityDataFactory(Attributes attributes, int i) {
        Validate.BuiltInFictitiousFunctionClassFactory(i >= attributes.getAuthRequestContext);
        int i2 = (attributes.getAuthRequestContext - i) - 1;
        if (i2 > 0) {
            String[] strArr = attributes.BuiltInFictitiousFunctionClassFactory;
            int i3 = i + 1;
            System.arraycopy(strArr, i3, strArr, i, i2);
            String[] strArr2 = attributes.PlaceComponentResult;
            System.arraycopy(strArr2, i3, strArr2, i, i2);
        }
        int i4 = attributes.getAuthRequestContext - 1;
        attributes.getAuthRequestContext = i4;
        attributes.BuiltInFictitiousFunctionClassFactory[i4] = null;
        attributes.PlaceComponentResult[i4] = null;
    }
}
