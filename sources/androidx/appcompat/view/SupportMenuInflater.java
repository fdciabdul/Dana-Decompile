package androidx.appcompat.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ActionProvider;
import androidx.core.view.MenuItemCompat;
import com.fullstory.instrumentation.InstrumentInjector;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class SupportMenuInflater extends MenuInflater {
    static final Class<?>[] KClassImpl$Data$declaredNonStaticMembers$2;
    static final Class<?>[] PlaceComponentResult;
    public static final byte[] getErrorConfigVersion;
    public static final int scheduleImpl = 241;
    final Object[] BuiltInFictitiousFunctionClassFactory;
    final Object[] MyBillsEntityDataFactory;
    Context getAuthRequestContext;
    private Object lookAheadTest;

    public SupportMenuInflater(Context context) {
        super(context);
        this.getAuthRequestContext = context;
        Object[] objArr = {context};
        this.MyBillsEntityDataFactory = objArr;
        this.BuiltInFictitiousFunctionClassFactory = objArr;
    }

    @Override // android.view.MenuInflater
    public void inflate(int i, Menu menu) {
        if (!(menu instanceof SupportMenu)) {
            super.inflate(i, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                try {
                    xmlResourceParser = this.getAuthRequestContext.getResources().getLayout(i);
                    getAuthRequestContext(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
                } catch (IOException e) {
                    throw new InflateException("Error inflating menu XML", e);
                }
            } catch (XmlPullParserException e2) {
                throw new InflateException("Error inflating menu XML", e2);
            }
        } finally {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        }
    }

    private void getAuthRequestContext(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IOException {
        MenuState menuState = new MenuState(menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if (name.equals("menu")) {
                    eventType = xmlPullParser.next();
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Expecting menu, got ");
                    sb.append(name);
                    throw new RuntimeException(sb.toString());
                }
            } else {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            }
        }
        String str = null;
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            if (eventType == 1) {
                throw new RuntimeException("Unexpected end of document");
            }
            if (eventType != 2) {
                if (eventType == 3) {
                    String name2 = xmlPullParser.getName();
                    if (z2 && name2.equals(str)) {
                        str = null;
                        z2 = false;
                    } else if (!name2.equals("group")) {
                        if (name2.equals("item")) {
                            if (!menuState.KClassImpl$Data$declaredNonStaticMembers$2()) {
                                if (menuState.NetworkUserEntityData$$ExternalSyntheticLambda0 != null && menuState.NetworkUserEntityData$$ExternalSyntheticLambda0.MyBillsEntityDataFactory()) {
                                    menuState.MyBillsEntityDataFactory();
                                } else {
                                    menuState.DatabaseTableConfigUtil = true;
                                    menuState.getAuthRequestContext(menuState.C.add(menuState.MyBillsEntityDataFactory, menuState.FragmentBottomSheetPaymentSettingBinding, menuState.GetContactSyncConfig, menuState.getCallingPid));
                                }
                            }
                        } else if (name2.equals("menu")) {
                            z = true;
                        }
                    } else {
                        menuState.MyBillsEntityDataFactory = 0;
                        menuState.getAuthRequestContext = 0;
                        menuState.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
                        menuState.BuiltInFictitiousFunctionClassFactory = 0;
                        menuState.lookAheadTest = true;
                        menuState.PlaceComponentResult = true;
                    }
                }
            } else if (!z2) {
                String name3 = xmlPullParser.getName();
                if (!name3.equals("group")) {
                    if (!name3.equals("item")) {
                        if (name3.equals("menu")) {
                            getAuthRequestContext(xmlPullParser, attributeSet, menuState.MyBillsEntityDataFactory());
                        } else {
                            str = name3;
                            z2 = true;
                        }
                    } else {
                        TintTypedArray MyBillsEntityDataFactory = TintTypedArray.MyBillsEntityDataFactory(SupportMenuInflater.this.getAuthRequestContext, attributeSet, R.styleable.CYFMonitor$ChallengeActionCallback);
                        menuState.FragmentBottomSheetPaymentSettingBinding = MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.getResourceId(R.styleable.SecuritySettingsActivity$createPinLauncher$2$2, 0);
                        menuState.GetContactSyncConfig = (MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.getInt(R.styleable.applyTrimPathIfNeeded, menuState.getAuthRequestContext) & (-65536)) | (MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.getInt(R.styleable.BaseSocialFeedContract$Presenter, menuState.KClassImpl$Data$declaredNonStaticMembers$2) & 65535);
                        menuState.getCallingPid = MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.getText(R.styleable.ArrayTable$3);
                        menuState.SubSequence = MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.getText(R.styleable.ConcurrentKt);
                        menuState.NetworkUserEntityData$$ExternalSyntheticLambda7 = MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.getResourceId(R.styleable.encodingStream, 0);
                        menuState.initRecordTimeStamp = MenuState.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.getString(R.styleable.useDaemonThreadFactory));
                        menuState.NetworkUserEntityData$$ExternalSyntheticLambda1 = MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.getInt(R.styleable.getFontAssetManager, 4096);
                        menuState.NetworkUserEntityData$$ExternalSyntheticLambda4 = MenuState.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.getString(R.styleable.isInfoWindowShown));
                        menuState.NetworkUserEntityData$$ExternalSyntheticLambda6 = MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.getInt(R.styleable.ArrayTable$2, 4096);
                        if (MyBillsEntityDataFactory.getAuthRequestContext(R.styleable.getRawPath)) {
                            menuState.NetworkUserEntityData$$ExternalSyntheticLambda2 = MyBillsEntityDataFactory.getAuthRequestContext(R.styleable.getRawPath, false) ? 1 : 0;
                        } else {
                            menuState.NetworkUserEntityData$$ExternalSyntheticLambda2 = menuState.BuiltInFictitiousFunctionClassFactory;
                        }
                        menuState.PrepareContext = MyBillsEntityDataFactory.getAuthRequestContext(R.styleable.getTextEndPadding, false);
                        menuState.getSupportButtonTintMode = MyBillsEntityDataFactory.getAuthRequestContext(R.styleable.f2x461046d9, menuState.lookAheadTest);
                        menuState.newProxyInstance = MyBillsEntityDataFactory.getAuthRequestContext(R.styleable.WrappedDrawableState, menuState.PlaceComponentResult);
                        menuState.readMicros = MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.getInt(R.styleable.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1, -1);
                        menuState.NetworkUserEntityData$$ExternalSyntheticLambda5 = MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.getString(R.styleable.SecuritySettingsActivity$createPinLauncher$2$1);
                        menuState.moveToNextValue = MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.getResourceId(R.styleable.rotateTo, 0);
                        menuState.scheduleImpl = MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.getString(R.styleable.isRegionMiniProgram);
                        String string = MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.getString(R.styleable.FlowableConcatMapEagerPublisher);
                        menuState.getErrorConfigVersion = string;
                        boolean z3 = string != null;
                        if (z3 && menuState.moveToNextValue == 0 && menuState.scheduleImpl == null) {
                            menuState.NetworkUserEntityData$$ExternalSyntheticLambda0 = (ActionProvider) menuState.BuiltInFictitiousFunctionClassFactory(string, PlaceComponentResult, SupportMenuInflater.this.BuiltInFictitiousFunctionClassFactory);
                        } else {
                            if (z3) {
                                InstrumentInjector.log_w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                            }
                            menuState.NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
                        }
                        menuState.NetworkUserEntityData$$ExternalSyntheticLambda8 = MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.getText(R.styleable.CheckPromoQuestFeature);
                        menuState.whenAvailable = MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.getText(R.styleable.WithdrawSavedCardChannelView);
                        if (MyBillsEntityDataFactory.getAuthRequestContext(R.styleable.ArrayTable$1)) {
                            menuState.NetworkUserEntityData$$ExternalSyntheticLambda3 = DrawableUtils.MyBillsEntityDataFactory(MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.getInt(R.styleable.ArrayTable$1, -1), menuState.NetworkUserEntityData$$ExternalSyntheticLambda3);
                        } else {
                            menuState.NetworkUserEntityData$$ExternalSyntheticLambda3 = null;
                        }
                        if (MyBillsEntityDataFactory.getAuthRequestContext(R.styleable.containsObjectForKey)) {
                            menuState.isLayoutRequested = MyBillsEntityDataFactory.PlaceComponentResult(R.styleable.containsObjectForKey);
                        } else {
                            menuState.isLayoutRequested = null;
                        }
                        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.recycle();
                        menuState.DatabaseTableConfigUtil = false;
                    }
                } else {
                    TypedArray obtainStyledAttributes = SupportMenuInflater.this.getAuthRequestContext.obtainStyledAttributes(attributeSet, R.styleable.retainOrRemoveAllInternal);
                    menuState.MyBillsEntityDataFactory = obtainStyledAttributes.getResourceId(R.styleable.NewMerchantCategoryAdapter, 0);
                    menuState.getAuthRequestContext = obtainStyledAttributes.getInt(R.styleable.access$setShowcaseShowing$p, 0);
                    menuState.KClassImpl$Data$declaredNonStaticMembers$2 = obtainStyledAttributes.getInt(R.styleable.insertActivities, 0);
                    menuState.BuiltInFictitiousFunctionClassFactory = obtainStyledAttributes.getInt(R.styleable.SendMoneyScenario, 0);
                    menuState.lookAheadTest = obtainStyledAttributes.getBoolean(R.styleable.getReadyFragment, true);
                    menuState.PlaceComponentResult = obtainStyledAttributes.getBoolean(R.styleable.FlowableKt$toIterable$1, true);
                    obtainStyledAttributes.recycle();
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    final Object BuiltInFictitiousFunctionClassFactory() {
        if (this.lookAheadTest == null) {
            Object obj = this.getAuthRequestContext;
            if (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) {
                obj = ((ContextWrapper) obj).getBaseContext();
                if (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) {
                    obj = ((ContextWrapper) obj).getBaseContext();
                    if (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) {
                        obj = BuiltInFictitiousFunctionClassFactory(((ContextWrapper) obj).getBaseContext());
                    }
                }
            }
            this.lookAheadTest = obj;
        }
        return this.lookAheadTest;
    }

    private Object BuiltInFictitiousFunctionClassFactory(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? BuiltInFictitiousFunctionClassFactory(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class InflatedOnMenuItemClickListener implements MenuItem.OnMenuItemClickListener {
        private static final Class<?>[] KClassImpl$Data$declaredNonStaticMembers$2 = {MenuItem.class};
        private Method BuiltInFictitiousFunctionClassFactory;
        private Object PlaceComponentResult;

        public InflatedOnMenuItemClickListener(Object obj, String str) {
            this.PlaceComponentResult = obj;
            Class<?> cls = obj.getClass();
            try {
                this.BuiltInFictitiousFunctionClassFactory = cls.getMethod(str, KClassImpl$Data$declaredNonStaticMembers$2);
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Couldn't resolve menu item onClick handler ");
                sb.append(str);
                sb.append(" in class ");
                sb.append(cls.getName());
                InflateException inflateException = new InflateException(sb.toString());
                inflateException.initCause(e);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.BuiltInFictitiousFunctionClassFactory.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.BuiltInFictitiousFunctionClassFactory.invoke(this.PlaceComponentResult, menuItem)).booleanValue();
                }
                this.BuiltInFictitiousFunctionClassFactory.invoke(this.PlaceComponentResult, menuItem);
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class MenuState {
        Menu C;
        boolean DatabaseTableConfigUtil;
        int FragmentBottomSheetPaymentSettingBinding;
        int GetContactSyncConfig;
        ActionProvider NetworkUserEntityData$$ExternalSyntheticLambda0;
        int NetworkUserEntityData$$ExternalSyntheticLambda1;
        int NetworkUserEntityData$$ExternalSyntheticLambda2;
        char NetworkUserEntityData$$ExternalSyntheticLambda4;
        String NetworkUserEntityData$$ExternalSyntheticLambda5;
        int NetworkUserEntityData$$ExternalSyntheticLambda6;
        int NetworkUserEntityData$$ExternalSyntheticLambda7;
        CharSequence NetworkUserEntityData$$ExternalSyntheticLambda8;
        boolean PrepareContext;
        CharSequence SubSequence;
        CharSequence getCallingPid;
        String getErrorConfigVersion;
        boolean getSupportButtonTintMode;
        char initRecordTimeStamp;
        int moveToNextValue;
        boolean newProxyInstance;
        int readMicros;
        String scheduleImpl;
        CharSequence whenAvailable;
        ColorStateList isLayoutRequested = null;
        PorterDuff.Mode NetworkUserEntityData$$ExternalSyntheticLambda3 = null;
        int MyBillsEntityDataFactory = 0;
        int getAuthRequestContext = 0;
        int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        int BuiltInFictitiousFunctionClassFactory = 0;
        boolean lookAheadTest = true;
        boolean PlaceComponentResult = true;

        public MenuState(Menu menu) {
            this.C = menu;
        }

        static char KClassImpl$Data$declaredNonStaticMembers$2(String str) {
            if (str == null) {
                return (char) 0;
            }
            return str.charAt(0);
        }

        final void getAuthRequestContext(MenuItem menuItem) {
            boolean z = true;
            menuItem.setChecked(this.PrepareContext).setVisible(this.getSupportButtonTintMode).setEnabled(this.newProxyInstance).setCheckable(this.NetworkUserEntityData$$ExternalSyntheticLambda2 > 0).setTitleCondensed(this.SubSequence).setIcon(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            int i = this.readMicros;
            if (i >= 0) {
                menuItem.setShowAsAction(i);
            }
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda5 != null) {
                if (SupportMenuInflater.this.getAuthRequestContext.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new InflatedOnMenuItemClickListener(SupportMenuInflater.this.BuiltInFictitiousFunctionClassFactory(), this.NetworkUserEntityData$$ExternalSyntheticLambda5));
            }
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda2 >= 2) {
                if (menuItem instanceof MenuItemImpl) {
                    MenuItemImpl menuItemImpl = (MenuItemImpl) menuItem;
                    menuItemImpl.MyBillsEntityDataFactory = (menuItemImpl.MyBillsEntityDataFactory & (-5)) | 4;
                } else if (menuItem instanceof MenuItemWrapperICS) {
                    ((MenuItemWrapperICS) menuItem).PlaceComponentResult();
                }
            }
            String str = this.scheduleImpl;
            if (str != null) {
                menuItem.setActionView((View) BuiltInFictitiousFunctionClassFactory(str, SupportMenuInflater.KClassImpl$Data$declaredNonStaticMembers$2, SupportMenuInflater.this.MyBillsEntityDataFactory));
            } else {
                z = false;
            }
            int i2 = this.moveToNextValue;
            if (i2 > 0) {
                if (!z) {
                    menuItem.setActionView(i2);
                } else {
                    InstrumentInjector.log_w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            ActionProvider actionProvider = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (actionProvider != null) {
                MenuItemCompat.PlaceComponentResult(menuItem, actionProvider);
            }
            MenuItemCompat.MyBillsEntityDataFactory(menuItem, this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            MenuItemCompat.PlaceComponentResult(menuItem, this.whenAvailable);
            MenuItemCompat.KClassImpl$Data$declaredNonStaticMembers$2(menuItem, this.initRecordTimeStamp, this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            MenuItemCompat.PlaceComponentResult(menuItem, this.NetworkUserEntityData$$ExternalSyntheticLambda4, this.NetworkUserEntityData$$ExternalSyntheticLambda6);
            PorterDuff.Mode mode = this.NetworkUserEntityData$$ExternalSyntheticLambda3;
            if (mode != null) {
                MenuItemCompat.KClassImpl$Data$declaredNonStaticMembers$2(menuItem, mode);
            }
            ColorStateList colorStateList = this.isLayoutRequested;
            if (colorStateList != null) {
                MenuItemCompat.BuiltInFictitiousFunctionClassFactory(menuItem, colorStateList);
            }
        }

        public final SubMenu MyBillsEntityDataFactory() {
            this.DatabaseTableConfigUtil = true;
            SubMenu addSubMenu = this.C.addSubMenu(this.MyBillsEntityDataFactory, this.FragmentBottomSheetPaymentSettingBinding, this.GetContactSyncConfig, this.getCallingPid);
            getAuthRequestContext(addSubMenu.getItem());
            return addSubMenu;
        }

        public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
            return this.DatabaseTableConfigUtil;
        }

        final <T> T BuiltInFictitiousFunctionClassFactory(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = Class.forName(str, false, SupportMenuInflater.this.getAuthRequestContext.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return (T) constructor.newInstance(objArr);
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Cannot instantiate class: ");
                sb.append(str);
                InstrumentInjector.log_w("SupportMenuInflater", sb.toString(), e);
                return null;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x003f -> B:11:0x0045). Please submit an issue!!! */
    static {
        /*
            r0 = 26
            byte[] r0 = new byte[r0]
            r0 = {x0050: FILL_ARRAY_DATA , data: [39, -116, 116, 127, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4} // fill-array
            androidx.appcompat.view.SupportMenuInflater.getErrorConfigVersion = r0
            r1 = 241(0xf1, float:3.38E-43)
            androidx.appcompat.view.SupportMenuInflater.scheduleImpl = r1
            r1 = 1
            java.lang.Class[] r2 = new java.lang.Class[r1]
            r3 = 23
            byte[] r4 = new byte[r3]
            r5 = 3
            r6 = 97
            r7 = 0
            if (r0 != 0) goto L21
            r6 = r4
            r8 = 3
            r9 = 97
            r10 = 0
            r4 = r2
            goto L45
        L21:
            r5 = r4
            r6 = 3
            r8 = 97
            r9 = 0
            r4 = r2
        L27:
            int r6 = r6 + r1
            int r10 = r9 + 1
            byte r11 = (byte) r8
            r5[r9] = r11
            if (r10 != r3) goto L3f
            java.lang.String r0 = new java.lang.String
            r0.<init>(r5, r7)
            java.lang.Class r0 = java.lang.Class.forName(r0)
            r2[r7] = r0
            androidx.appcompat.view.SupportMenuInflater.KClassImpl$Data$declaredNonStaticMembers$2 = r4
            androidx.appcompat.view.SupportMenuInflater.PlaceComponentResult = r4
            return
        L3f:
            r9 = r0[r6]
            r12 = r6
            r6 = r5
            r5 = r8
            r8 = r12
        L45:
            int r9 = -r9
            int r5 = r5 + r9
            int r5 = r5 + (-8)
            r9 = r10
            r12 = r8
            r8 = r5
            r5 = r6
            r6 = r12
            goto L27
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.SupportMenuInflater.<clinit>():void");
    }
}
