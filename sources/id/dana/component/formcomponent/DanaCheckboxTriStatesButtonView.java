package id.dana.component.formcomponent;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.base.Ascii;
import id.dana.component.R;
import id.dana.component.formcomponent.DanaCheckboxTriStatesButtonView;
import id.dana.component.utils.SizeUtil;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u0000 +2\u00020\u0001:\u0002+,B\u0011\b\u0016\u0012\u0006\u0010%\u001a\u00020\u0005¢\u0006\u0004\b&\u0010'B\u001b\b\u0016\u0012\u0006\u0010%\u001a\u00020\u0005\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b&\u0010\u000bB#\b\u0016\u0012\u0006\u0010%\u001a\u00020\u0005\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010)\u001a\u00020\u0002¢\u0006\u0004\b&\u0010*J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0011\u0010\u0010\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0016\u0010\u0015J\u0015\u0010\u0017\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001b\u0010\u001aR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001c\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u001fR\u0016\u0010\u0019\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010 R\u0014\u0010\u001b\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001dR\u0014\u0010\"\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\u001dR\u0016\u0010$\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010 "}, d2 = {"Lid/dana/component/formcomponent/DanaCheckboxTriStatesButtonView;", "Landroidx/appcompat/widget/AppCompatCheckBox;", "", "getState", "()I", "Landroid/content/Context;", "p0", "Landroid/util/AttributeSet;", "p1", "", "PlaceComponentResult", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Landroid/os/Parcelable;", "state", "onRestoreInstanceState", "(Landroid/os/Parcelable;)V", "onSaveInstanceState", "()Landroid/os/Parcelable;", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnCheckedTriStatesChangeListener", "(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V", "setOnCheckedTwoStatesChangeListener", "setState", "(I)V", "getAuthRequestContext", "()V", "MyBillsEntityDataFactory", "BuiltInFictitiousFunctionClassFactory", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "", "Z", "I", "scheduleImpl", "KClassImpl$Data$declaredNonStaticMembers$2", "moveToNextValue", "lookAheadTest", HummerConstants.CONTEXT, "<init>", "(Landroid/content/Context;)V", "attrs", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "SavedState"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes4.dex */
public final class DanaCheckboxTriStatesButtonView extends AppCompatCheckBox {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private CompoundButton.OnCheckedChangeListener PlaceComponentResult;
    private HashMap KClassImpl$Data$declaredNonStaticMembers$2;
    private final CompoundButton.OnCheckedChangeListener MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private boolean BuiltInFictitiousFunctionClassFactory;
    private int getAuthRequestContext;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private int lookAheadTest;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final CompoundButton.OnCheckedChangeListener KClassImpl$Data$declaredNonStaticMembers$2;

    public final void _$_clearFindViewByIdCache() {
        HashMap hashMap = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final View _$_findCachedViewById(int i) {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new HashMap();
        }
        View view = (View) this.KClassImpl$Data$declaredNonStaticMembers$2.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            this.KClassImpl$Data$declaredNonStaticMembers$2.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DanaCheckboxTriStatesButtonView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new CompoundButton.OnCheckedChangeListener() { // from class: id.dana.component.formcomponent.DanaCheckboxTriStatesButtonView$twoStateListener$1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                int i;
                i = DanaCheckboxTriStatesButtonView.this.getAuthRequestContext;
                if (i == -1) {
                    DanaCheckboxTriStatesButtonView.this.setState(1);
                } else if (i == 0) {
                    DanaCheckboxTriStatesButtonView.this.setState(1);
                } else if (i == 1) {
                    DanaCheckboxTriStatesButtonView.this.setState(0);
                }
            }
        };
        this.MyBillsEntityDataFactory = new CompoundButton.OnCheckedChangeListener() { // from class: id.dana.component.formcomponent.DanaCheckboxTriStatesButtonView$triStateListener$1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                int i;
                i = DanaCheckboxTriStatesButtonView.this.getAuthRequestContext;
                if (i == -1) {
                    DanaCheckboxTriStatesButtonView.this.setState(1);
                } else if (i == 0) {
                    DanaCheckboxTriStatesButtonView.this.setState(-1);
                } else if (i == 1) {
                    DanaCheckboxTriStatesButtonView.this.setState(0);
                }
            }
        };
        PlaceComponentResult(context, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DanaCheckboxTriStatesButtonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new CompoundButton.OnCheckedChangeListener() { // from class: id.dana.component.formcomponent.DanaCheckboxTriStatesButtonView$twoStateListener$1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                int i;
                i = DanaCheckboxTriStatesButtonView.this.getAuthRequestContext;
                if (i == -1) {
                    DanaCheckboxTriStatesButtonView.this.setState(1);
                } else if (i == 0) {
                    DanaCheckboxTriStatesButtonView.this.setState(1);
                } else if (i == 1) {
                    DanaCheckboxTriStatesButtonView.this.setState(0);
                }
            }
        };
        this.MyBillsEntityDataFactory = new CompoundButton.OnCheckedChangeListener() { // from class: id.dana.component.formcomponent.DanaCheckboxTriStatesButtonView$triStateListener$1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                int i;
                i = DanaCheckboxTriStatesButtonView.this.getAuthRequestContext;
                if (i == -1) {
                    DanaCheckboxTriStatesButtonView.this.setState(1);
                } else if (i == 0) {
                    DanaCheckboxTriStatesButtonView.this.setState(-1);
                } else if (i == 1) {
                    DanaCheckboxTriStatesButtonView.this.setState(0);
                }
            }
        };
        PlaceComponentResult(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DanaCheckboxTriStatesButtonView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new CompoundButton.OnCheckedChangeListener() { // from class: id.dana.component.formcomponent.DanaCheckboxTriStatesButtonView$twoStateListener$1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                int i2;
                i2 = DanaCheckboxTriStatesButtonView.this.getAuthRequestContext;
                if (i2 == -1) {
                    DanaCheckboxTriStatesButtonView.this.setState(1);
                } else if (i2 == 0) {
                    DanaCheckboxTriStatesButtonView.this.setState(1);
                } else if (i2 == 1) {
                    DanaCheckboxTriStatesButtonView.this.setState(0);
                }
            }
        };
        this.MyBillsEntityDataFactory = new CompoundButton.OnCheckedChangeListener() { // from class: id.dana.component.formcomponent.DanaCheckboxTriStatesButtonView$triStateListener$1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                int i2;
                i2 = DanaCheckboxTriStatesButtonView.this.getAuthRequestContext;
                if (i2 == -1) {
                    DanaCheckboxTriStatesButtonView.this.setState(1);
                } else if (i2 == 0) {
                    DanaCheckboxTriStatesButtonView.this.setState(-1);
                } else if (i2 == 1) {
                    DanaCheckboxTriStatesButtonView.this.setState(0);
                }
            }
        };
        PlaceComponentResult(context, attributeSet);
    }

    private final void PlaceComponentResult(Context p0, AttributeSet p1) {
        if (p1 != null) {
            TypedArray obtainStyledAttributes = p0.getTheme().obtainStyledAttributes(p1, R.styleable.connectForeground, 0, 0);
            try {
                this.getAuthRequestContext = obtainStyledAttributes.getInt(R.styleable.FlowViewUtil$textChanges$2, 0);
                this.lookAheadTest = obtainStyledAttributes.getInt(R.styleable.h, 0);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        setPadding(SizeUtil.PlaceComponentResult(8), 0, 0, SizeUtil.PlaceComponentResult(0));
        MyBillsEntityDataFactory();
        getAuthRequestContext();
    }

    private final void getAuthRequestContext() {
        int i = this.lookAheadTest;
        if (i == 2) {
            setOnCheckedTwoStatesChangeListener(this.KClassImpl$Data$declaredNonStaticMembers$2);
        } else if (i == 3) {
            setOnCheckedTriStatesChangeListener(this.MyBillsEntityDataFactory);
        }
    }

    /* renamed from: getState  reason: from getter */
    public final int getGetAuthRequestContext() {
        return this.getAuthRequestContext;
    }

    public final void setState(int state) {
        if (this.BuiltInFictitiousFunctionClassFactory || this.getAuthRequestContext == state) {
            return;
        }
        this.getAuthRequestContext = state;
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = this.PlaceComponentResult;
        if (onCheckedChangeListener != null && onCheckedChangeListener != null) {
            onCheckedChangeListener.onCheckedChanged(this, isChecked());
        }
        MyBillsEntityDataFactory();
    }

    public final void setOnCheckedTwoStatesChangeListener(CompoundButton.OnCheckedChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "");
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (onCheckedChangeListener != listener) {
            this.PlaceComponentResult = listener;
        }
        super.setOnCheckedChangeListener(onCheckedChangeListener);
    }

    public final void setOnCheckedTriStatesChangeListener(CompoundButton.OnCheckedChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "");
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = this.MyBillsEntityDataFactory;
        if (onCheckedChangeListener != listener) {
            this.PlaceComponentResult = listener;
        }
        super.setOnCheckedChangeListener(onCheckedChangeListener);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.BuiltInFictitiousFunctionClassFactory = this.getAuthRequestContext;
        return savedState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable state) {
        Intrinsics.checkNotNullParameter(state, "");
        this.BuiltInFictitiousFunctionClassFactory = true;
        SavedState savedState = (SavedState) state;
        super.onRestoreInstanceState(savedState.getSuperState());
        setState(savedState.BuiltInFictitiousFunctionClassFactory);
        requestLayout();
        this.BuiltInFictitiousFunctionClassFactory = false;
    }

    private final void MyBillsEntityDataFactory() {
        int i = R.drawable.ic_dana_checkbox_indeterminate;
        int i2 = this.getAuthRequestContext;
        if (i2 == -1) {
            i = R.drawable.ic_dana_checkbox_indeterminate;
        } else if (i2 == 0) {
            i = R.drawable.res_0x7f080876_networkuserentitydata_externalsyntheticlambda7;
        } else if (i2 == 1) {
            i = R.drawable.ic_dana_checkbox_active;
        }
        setButtonDrawable(i);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0013\u0010\u0014B\u0011\b\u0012\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0013\u0010\u0015J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\f8\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0012\u0010\u0011\u001a\u00020\u0007X\u0086\u0002¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/component/formcomponent/DanaCheckboxTriStatesButtonView$SavedState;", "Landroid/view/View$BaseSavedState;", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p0", "", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Landroid/os/Parcelable$Creator;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/os/Parcelable$Creator;", "getAuthRequestContext", "I", "BuiltInFictitiousFunctionClassFactory", "Landroid/os/Parcelable;", "<init>", "(Landroid/os/Parcelable;)V", "(Landroid/os/Parcel;)V"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes4.dex */
    public static final class SavedState extends View.BaseSavedState {
        public static final byte[] BuiltInFictitiousFunctionClassFactory = {94, Ascii.EM, -44, 73, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
        public static final int PlaceComponentResult = 112;
        public final Parcelable.Creator<SavedState> KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        int BuiltInFictitiousFunctionClassFactory;

        /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x0030). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void a(short r6, int r7, short r8, java.lang.Object[] r9) {
            /*
                int r7 = r7 * 15
                int r7 = r7 + 4
                int r8 = r8 * 4
                int r8 = r8 + 16
                int r6 = 106 - r6
                byte[] r0 = id.dana.component.formcomponent.DanaCheckboxTriStatesButtonView.SavedState.BuiltInFictitiousFunctionClassFactory
                byte[] r1 = new byte[r8]
                r2 = 0
                if (r0 != 0) goto L17
                r3 = r1
                r4 = 0
                r1 = r0
                r0 = r9
                r9 = r8
                goto L30
            L17:
                r3 = 0
            L18:
                byte r4 = (byte) r6
                r1[r3] = r4
                int r3 = r3 + 1
                if (r3 != r8) goto L27
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                r9[r2] = r6
                return
            L27:
                r4 = r0[r7]
                r5 = r9
                r9 = r8
                r8 = r4
                r4 = r3
                r3 = r1
                r1 = r0
                r0 = r5
            L30:
                int r8 = -r8
                int r6 = r6 + r8
                int r6 = r6 + 2
                int r7 = r7 + 1
                r8 = r9
                r9 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                goto L18
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.component.formcomponent.DanaCheckboxTriStatesButtonView.SavedState.a(short, int, short, java.lang.Object[]):void");
        }

        public /* synthetic */ SavedState(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
            this(parcel);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new Parcelable.Creator<SavedState>() { // from class: id.dana.component.formcomponent.DanaCheckboxTriStatesButtonView$SavedState$CREATOR$1
                @Override // android.os.Parcelable.Creator
                public final /* synthetic */ DanaCheckboxTriStatesButtonView.SavedState createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "");
                    return new DanaCheckboxTriStatesButtonView.SavedState(parcel, null);
                }

                @Override // android.os.Parcelable.Creator
                public final /* bridge */ /* synthetic */ DanaCheckboxTriStatesButtonView.SavedState[] newArray(int i) {
                    return new DanaCheckboxTriStatesButtonView.SavedState[i];
                }
            };
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new Parcelable.Creator<SavedState>() { // from class: id.dana.component.formcomponent.DanaCheckboxTriStatesButtonView$SavedState$CREATOR$1
                @Override // android.os.Parcelable.Creator
                public final /* synthetic */ DanaCheckboxTriStatesButtonView.SavedState createFromParcel(Parcel parcel2) {
                    Intrinsics.checkNotNullParameter(parcel2, "");
                    return new DanaCheckboxTriStatesButtonView.SavedState(parcel2, null);
                }

                @Override // android.os.Parcelable.Creator
                public final /* bridge */ /* synthetic */ DanaCheckboxTriStatesButtonView.SavedState[] newArray(int i) {
                    return new DanaCheckboxTriStatesButtonView.SavedState[i];
                }
            };
            this.BuiltInFictitiousFunctionClassFactory = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel p0, int p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            super.writeToParcel(p0, p1);
            p0.writeValue(Integer.valueOf(this.BuiltInFictitiousFunctionClassFactory));
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("CheckboxTriState.SavedState{");
            try {
                Object[] objArr = {this};
                byte b = (byte) (BuiltInFictitiousFunctionClassFactory[5] - 1);
                byte b2 = BuiltInFictitiousFunctionClassFactory[5];
                Object[] objArr2 = new Object[1];
                a(b, b2, (byte) (b2 - 1), objArr2);
                Class<?> cls = Class.forName((String) objArr2[0]);
                byte b3 = BuiltInFictitiousFunctionClassFactory[5];
                byte b4 = (byte) (b3 - 1);
                Object[] objArr3 = new Object[1];
                a(b3, b4, b4, objArr3);
                sb.append(Integer.toHexString(((Integer) cls.getMethod((String) objArr3[0], Object.class).invoke(null, objArr)).intValue()));
                sb.append(" state=");
                sb.append(this.BuiltInFictitiousFunctionClassFactory);
                sb.append("}");
                return sb.toString();
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        }
    }
}
