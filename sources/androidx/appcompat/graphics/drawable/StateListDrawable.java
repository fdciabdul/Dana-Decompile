package androidx.appcompat.graphics.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.appcompat.graphics.drawable.DrawableContainer;
import androidx.appcompat.resources.Compatibility;
import androidx.appcompat.resources.R;
import androidx.core.content.res.TypedArrayUtils;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
class StateListDrawable extends DrawableContainer {
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;
    private StateListState MyBillsEntityDataFactory;

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    StateListDrawable() {
        this(null, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        int MyBillsEntityDataFactory = this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(iArr);
        if (MyBillsEntityDataFactory < 0) {
            MyBillsEntityDataFactory = this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(StateSet.WILD_CARD);
        }
        return KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory) || onStateChange;
    }

    public void KClassImpl$Data$declaredNonStaticMembers$2(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray authRequestContext = TypedArrayUtils.getAuthRequestContext(resources, theme, attributeSet, R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda7);
        setVisible(authRequestContext.getBoolean(R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda5, true), true);
        BuiltInFictitiousFunctionClassFactory(authRequestContext);
        MyBillsEntityDataFactory(resources);
        authRequestContext.recycle();
        BuiltInFictitiousFunctionClassFactory(context, resources, xmlPullParser, attributeSet, theme);
        onStateChange(getState());
    }

    private void BuiltInFictitiousFunctionClassFactory(TypedArray typedArray) {
        StateListState stateListState = this.MyBillsEntityDataFactory;
        if (Build.VERSION.SDK_INT >= 21) {
            stateListState.BuiltInFictitiousFunctionClassFactory |= Compatibility.Api21Impl.BuiltInFictitiousFunctionClassFactory(typedArray);
        }
        stateListState.D = typedArray.getBoolean(R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda3, stateListState.D);
        stateListState.isLayoutRequested = typedArray.getBoolean(R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda8, stateListState.isLayoutRequested);
        stateListState.NetworkUserEntityData$$ExternalSyntheticLambda5 = typedArray.getInt(R.styleable.FragmentBottomSheetPaymentSettingBinding, stateListState.NetworkUserEntityData$$ExternalSyntheticLambda5);
        stateListState.NetworkUserEntityData$$ExternalSyntheticLambda4 = typedArray.getInt(R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda6, stateListState.NetworkUserEntityData$$ExternalSyntheticLambda4);
        stateListState.newProxyInstance = typedArray.getBoolean(R.styleable.PrepareContext, stateListState.newProxyInstance);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0047, code lost:
    
        if (r4 == null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0049, code lost:
    
        r4 = r11.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004e, code lost:
    
        if (r4 == 4) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0050, code lost:
    
        if (r4 != 2) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0056, code lost:
    
        if (android.os.Build.VERSION.SDK_INT < 21) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0058, code lost:
    
        r4 = android.graphics.drawable.Drawable.createFromXmlInner(r10, r11, r12, r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005d, code lost:
    
        r4 = android.graphics.drawable.Drawable.createFromXmlInner(r10, r11, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0062, code lost:
    
        r9 = new java.lang.StringBuilder();
        r9.append(r11.getPositionDescription());
        r9.append(": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x007c, code lost:
    
        throw new org.xmlpull.v1.XmlPullParserException(r9.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x007d, code lost:
    
        r0.getAuthRequestContext(r3, r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void BuiltInFictitiousFunctionClassFactory(android.content.Context r9, android.content.res.Resources r10, org.xmlpull.v1.XmlPullParser r11, android.util.AttributeSet r12, android.content.res.Resources.Theme r13) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r8 = this;
            androidx.appcompat.graphics.drawable.StateListDrawable$StateListState r0 = r8.MyBillsEntityDataFactory
            int r1 = r11.getDepth()
            r2 = 1
            int r1 = r1 + r2
        L8:
            int r3 = r11.next()
            if (r3 == r2) goto L81
            int r4 = r11.getDepth()
            if (r4 >= r1) goto L17
            r5 = 3
            if (r3 == r5) goto L81
        L17:
            r5 = 2
            if (r3 != r5) goto L8
            if (r4 > r1) goto L8
            java.lang.String r3 = r11.getName()
            java.lang.String r4 = "item"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L8
            int[] r3 = androidx.appcompat.resources.R.styleable.isLayoutRequested
            android.content.res.TypedArray r3 = androidx.core.content.res.TypedArrayUtils.getAuthRequestContext(r10, r13, r12, r3)
            r4 = 0
            int r6 = androidx.appcompat.resources.R.styleable.newProxyInstance
            r7 = -1
            int r6 = r3.getResourceId(r6, r7)
            if (r6 <= 0) goto L40
            androidx.appcompat.widget.ResourceManagerInternal r4 = androidx.appcompat.widget.ResourceManagerInternal.KClassImpl$Data$declaredNonStaticMembers$2()
            android.graphics.drawable.Drawable r4 = r4.BuiltInFictitiousFunctionClassFactory(r9, r6)
        L40:
            r3.recycle()
            int[] r3 = r8.BuiltInFictitiousFunctionClassFactory(r12)
            if (r4 != 0) goto L7d
        L49:
            int r4 = r11.next()
            r6 = 4
            if (r4 == r6) goto L49
            if (r4 != r5) goto L62
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 21
            if (r4 < r5) goto L5d
            android.graphics.drawable.Drawable r4 = androidx.appcompat.resources.Compatibility.Api21Impl.KClassImpl$Data$declaredNonStaticMembers$2(r10, r11, r12, r13)
            goto L7d
        L5d:
            android.graphics.drawable.Drawable r4 = android.graphics.drawable.Drawable.createFromXmlInner(r10, r11, r12)
            goto L7d
        L62:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = r11.getPositionDescription()
            r9.append(r10)
            java.lang.String r10 = ": <item> tag requires a 'drawable' attribute or child tag defining a drawable"
            r9.append(r10)
            org.xmlpull.v1.XmlPullParserException r10 = new org.xmlpull.v1.XmlPullParserException
            java.lang.String r9 = r9.toString()
            r10.<init>(r9)
            throw r10
        L7d:
            r0.getAuthRequestContext(r3, r4)
            goto L8
        L81:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.graphics.drawable.StateListDrawable.BuiltInFictitiousFunctionClassFactory(android.content.Context, android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] BuiltInFictitiousFunctionClassFactory(AttributeSet attributeSet) {
        int attributeCount = attributeSet.getAttributeCount();
        int[] iArr = new int[attributeCount];
        int i = 0;
        for (int i2 = 0; i2 < attributeCount; i2++) {
            int attributeNameResource = attributeSet.getAttributeNameResource(i2);
            if (attributeNameResource != 0 && attributeNameResource != 16842960 && attributeNameResource != 16843161) {
                if (!attributeSet.getAttributeBooleanValue(i2, false)) {
                    attributeNameResource = -attributeNameResource;
                }
                iArr[i] = attributeNameResource;
                i++;
            }
        }
        return StateSet.trimStateSet(iArr, i);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.KClassImpl$Data$declaredNonStaticMembers$2 && super.mutate() == this) {
            this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2();
            this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.appcompat.graphics.drawable.DrawableContainer
    /* renamed from: PlaceComponentResult  reason: merged with bridge method [inline-methods] */
    public StateListState BuiltInFictitiousFunctionClassFactory() {
        return new StateListState(this.MyBillsEntityDataFactory, this, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class StateListState extends DrawableContainer.DrawableContainerState {
        int[][] getValueOfTouchPositionAbsolute;

        /* JADX INFO: Access modifiers changed from: package-private */
        public StateListState(StateListState stateListState, StateListDrawable stateListDrawable, Resources resources) {
            super(stateListState, stateListDrawable, resources);
            if (stateListState != null) {
                this.getValueOfTouchPositionAbsolute = stateListState.getValueOfTouchPositionAbsolute;
            } else {
                this.getValueOfTouchPositionAbsolute = new int[BuiltInFictitiousFunctionClassFactory()];
            }
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableContainer.DrawableContainerState
        void KClassImpl$Data$declaredNonStaticMembers$2() {
            int[][] iArr = this.getValueOfTouchPositionAbsolute;
            int[][] iArr2 = new int[iArr.length];
            for (int length = iArr.length - 1; length >= 0; length--) {
                int[] iArr3 = this.getValueOfTouchPositionAbsolute[length];
                iArr2[length] = iArr3 != null ? (int[]) iArr3.clone() : null;
            }
            this.getValueOfTouchPositionAbsolute = iArr2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int getAuthRequestContext(int[] iArr, Drawable drawable) {
            int PlaceComponentResult = PlaceComponentResult(drawable);
            this.getValueOfTouchPositionAbsolute[PlaceComponentResult] = iArr;
            return PlaceComponentResult;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int MyBillsEntityDataFactory(int[] iArr) {
            int[][] iArr2 = this.getValueOfTouchPositionAbsolute;
            int MyBillsEntityDataFactory = MyBillsEntityDataFactory();
            for (int i = 0; i < MyBillsEntityDataFactory; i++) {
                if (StateSet.stateSetMatches(iArr2[i], iArr)) {
                    return i;
                }
            }
            return -1;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new StateListDrawable(this, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new StateListDrawable(this, resources);
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableContainer.DrawableContainerState
        public void MyBillsEntityDataFactory(int i, int i2) {
            super.MyBillsEntityDataFactory(i, i2);
            int[][] iArr = new int[i2];
            System.arraycopy(this.getValueOfTouchPositionAbsolute, 0, iArr, 0, i);
            this.getValueOfTouchPositionAbsolute = iArr;
        }
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.appcompat.graphics.drawable.DrawableContainer
    public void PlaceComponentResult(DrawableContainer.DrawableContainerState drawableContainerState) {
        super.PlaceComponentResult(drawableContainerState);
        if (drawableContainerState instanceof StateListState) {
            this.MyBillsEntityDataFactory = (StateListState) drawableContainerState;
        }
    }

    StateListDrawable(StateListState stateListState, Resources resources) {
        PlaceComponentResult(new StateListState(stateListState, this, resources));
        onStateChange(getState());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public StateListDrawable(StateListState stateListState) {
        if (stateListState != null) {
            PlaceComponentResult(stateListState);
        }
    }
}
