package com.alibaba.ariver.app.api.ui.darkmode;

/* loaded from: classes2.dex */
public class ColorSchemeModelTemplate<T> {

    /* renamed from: a  reason: collision with root package name */
    private T f5973a;
    private T b;
    private T c;
    private ColorSchemeDecider d;

    public T getTarget() {
        T t;
        ColorSchemeDecider colorSchemeDecider = this.d;
        if (colorSchemeDecider != null) {
            int i = AnonymousClass1.$SwitchMap$com$alibaba$ariver$app$api$ui$darkmode$ColorSchemeType[colorSchemeDecider.getCurrentColorScheme().ordinal()];
            if (i == 1) {
                T t2 = this.b;
                if (t2 != null) {
                    return t2;
                }
            } else if (i == 2 && (t = this.c) != null) {
                return t;
            }
        }
        return this.f5973a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.alibaba.ariver.app.api.ui.darkmode.ColorSchemeModelTemplate$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$alibaba$ariver$app$api$ui$darkmode$ColorSchemeType;

        static {
            int[] iArr = new int[ColorSchemeType.values().length];
            $SwitchMap$com$alibaba$ariver$app$api$ui$darkmode$ColorSchemeType = iArr;
            try {
                iArr[ColorSchemeType.LIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$alibaba$ariver$app$api$ui$darkmode$ColorSchemeType[ColorSchemeType.DARK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public void setColorSchemeDecider(ColorSchemeDecider colorSchemeDecider) {
        this.d = colorSchemeDecider;
    }

    public void setDefault(T t) {
        this.f5973a = t;
    }

    public void setLight(T t) {
        this.b = t;
    }

    public void setDark(T t) {
        this.c = t;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ColorSchemeModelTemplate{def=");
        sb.append(this.f5973a);
        sb.append(", light=");
        sb.append(this.b);
        sb.append(", dark=");
        sb.append(this.c);
        sb.append('}');
        return sb.toString();
    }
}
