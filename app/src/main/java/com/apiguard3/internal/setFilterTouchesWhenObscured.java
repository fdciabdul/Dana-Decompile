package com.apiguard3.internal;

import android.content.Context;
import com.apiguard3.internal.setPressed;
import java.io.File;
import java.io.FilenameFilter;
import java.util.HashSet;
import java.util.Set;
import kotlin.text.Typography;

/* loaded from: classes7.dex */
public final class setFilterTouchesWhenObscured {
    private static int getSharedInstance = 1;
    private static int values;
    private setPressed.AGState AGState;
    private Set<String> APIGuard;
    private setPressed.values valueOf;

    static /* synthetic */ void values(setFilterTouchesWhenObscured setfiltertoucheswhenobscured, Context context, String str, String str2) {
        int i = values + 113;
        getSharedInstance = i % 128;
        boolean z = i % 2 != 0;
        setfiltertoucheswhenobscured.valueOf(context, str, str2);
        if (z) {
            return;
        }
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public setFilterTouchesWhenObscured() {
        this(new setContextClickable(), new setHasTransientState());
    }

    private setFilterTouchesWhenObscured(setPressed.AGState aGState, setPressed.values valuesVar) {
        this.APIGuard = new HashSet();
        this.AGState = aGState;
        this.valueOf = valuesVar;
    }

    public final void valueOf(final Context context, final String str, final String str2, final setPressed.valueOf valueof) {
        int i = values + 75;
        getSharedInstance = i % 128;
        if ((i % 2 == 0 ? '*' : (char) 31) == '*') {
            throw null;
        } else if (context == null) {
            throw new IllegalArgumentException("Given context is null");
        } else {
            if (setPressed.values(str)) {
                throw new IllegalArgumentException("Given library is either null or empty");
            }
            if (valueof == null) {
                valueOf(context, str, str2);
                return;
            }
            new Thread(new Runnable() { // from class: com.apiguard3.internal.setFilterTouchesWhenObscured.5
                private static int analyzeResponse = 1;
                private static int initialize;

                @Override // java.lang.Runnable
                public final void run() {
                    int i2 = initialize + 31;
                    analyzeResponse = i2 % 128;
                    try {
                        if ((i2 % 2 == 0 ? 'Q' : 'M') != 'Q') {
                            setFilterTouchesWhenObscured.values(setFilterTouchesWhenObscured.this, context, str, str2);
                            valueof.APIGuard();
                            return;
                        }
                        setFilterTouchesWhenObscured.values(setFilterTouchesWhenObscured.this, context, str, str2);
                        valueof.APIGuard();
                        throw new NullPointerException();
                    } catch (setWillNotCacheDrawing e) {
                        valueof.APIGuard(e);
                    } catch (UnsatisfiedLinkError e2) {
                        valueof.APIGuard(e2);
                    }
                }
            }).start();
            int i2 = getSharedInstance + 23;
            values = i2 % 128;
            if (i2 % 2 == 0) {
                return;
            }
            throw new NullPointerException();
        }
    }

    private void valueOf(Context context, String str, String str2) {
        int i = values + 53;
        getSharedInstance = i % 128;
        if ((i % 2 == 0 ? 'K' : (char) 24) == 24) {
            if ((!this.APIGuard.contains(str)) != true) {
                int i2 = getSharedInstance + 49;
                values = i2 % 128;
                if (i2 % 2 == 0) {
                    return;
                }
                throw new ArithmeticException();
            }
            try {
                this.AGState.getSharedInstance(str);
                this.APIGuard.add(str);
                return;
            } catch (UnsatisfiedLinkError unused) {
                File values2 = values(context, str, str2);
                if (!values2.exists()) {
                    getSharedInstance(context, str, str2);
                    this.valueOf.AGState(context, this.AGState.getSharedInstance(), this.AGState.APIGuard(str), values2, this);
                }
                this.AGState.AGState(values2.getAbsolutePath());
                this.APIGuard.add(str);
                return;
            }
        }
        this.APIGuard.contains(str);
        throw new ArithmeticException();
    }

    private static File valueOf(Context context) {
        int i = values + 15;
        getSharedInstance = i % 128;
        File dir = i % 2 != 0 ? context.getDir("lib", 0) : context.getDir("lib", 1);
        int i2 = values + 101;
        getSharedInstance = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
        return dir;
    }

    private File values(Context context, String str, String str2) {
        int i = values + 33;
        getSharedInstance = i % 128;
        if (!(i % 2 == 0)) {
            String APIGuard = this.AGState.APIGuard(str);
            if (setPressed.values(str2)) {
                File file = new File(valueOf(context), APIGuard);
                values = (getSharedInstance + 75) % 128;
                return file;
            }
            File valueOf = valueOf(context);
            StringBuilder sb = new StringBuilder();
            sb.append(APIGuard);
            sb.append(".");
            sb.append(str2);
            return new File(valueOf, sb.toString());
        }
        this.AGState.APIGuard(str);
        setPressed.values(str2);
        throw new NullPointerException();
    }

    private void getSharedInstance(Context context, String str, String str2) {
        File valueOf = valueOf(context);
        File values2 = values(context, str, str2);
        final String APIGuard = this.AGState.APIGuard(str);
        File[] listFiles = valueOf.listFiles(new FilenameFilter() { // from class: com.apiguard3.internal.setFilterTouchesWhenObscured.2
            private static int valueOf = 0;
            private static int values = 1;

            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str3) {
                int i = valueOf + 101;
                values = i % 128;
                if (!(i % 2 == 0)) {
                    return str3.startsWith(APIGuard);
                }
                throw null;
            }
        });
        if (listFiles == null) {
            return;
        }
        int length = listFiles.length;
        int i = 0;
        while (true) {
            if ((i < length ? (char) 29 : 'R') != 29) {
                return;
            }
            getSharedInstance = (values + 71) % 128;
            File file = listFiles[i];
            if ((!file.getAbsolutePath().equals(values2.getAbsolutePath()) ? Typography.dollar : (char) 3) != 3) {
                getSharedInstance = (values + 97) % 128;
                file.delete();
            }
            i++;
        }
    }
}
