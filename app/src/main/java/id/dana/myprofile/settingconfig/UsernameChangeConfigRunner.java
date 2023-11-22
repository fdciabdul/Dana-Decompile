package id.dana.myprofile.settingconfig;

import android.content.Context;
import android.widget.ExpandableListView;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.domain.profilemenu.settingconfig.SettingConfigurationRunner;
import id.dana.domain.user.UserInfoResponse;
import id.dana.domain.user.repository.UserRepository;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import o.BottomSheetCardBindingView$watcherCardNumberView$1;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\n\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0016\u001a\u00020\u000e¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\r\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0013"}, d2 = {"Lid/dana/myprofile/settingconfig/UsernameChangeConfigRunner;", "Lid/dana/domain/profilemenu/settingconfig/SettingConfigurationRunner;", "", "getSettingName", "()Ljava/lang/String;", "Lid/dana/domain/profilemenu/model/SettingModel;", "p0", "Lio/reactivex/Observable;", "performConfiguration", "(Lid/dana/domain/profilemenu/model/SettingModel;)Lio/reactivex/Observable;", "Landroid/content/Context;", "MyBillsEntityDataFactory", "Landroid/content/Context;", "PlaceComponentResult", "Lid/dana/domain/featureconfig/FeatureConfigRepository;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/domain/featureconfig/FeatureConfigRepository;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/domain/user/repository/UserRepository;", "Lid/dana/domain/user/repository/UserRepository;", "getAuthRequestContext", "p1", "p2", "<init>", "(Landroid/content/Context;Lid/dana/domain/user/repository/UserRepository;Lid/dana/domain/featureconfig/FeatureConfigRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UsernameChangeConfigRunner implements SettingConfigurationRunner {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int moveToNextValue = 0;
    private static int scheduleImpl = 1;

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final UserRepository getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final FeatureConfigRepository BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final Context PlaceComponentResult;
    private static char[] PlaceComponentResult = {39915, 39929, 39912, 39925, 39918, 39927, 39935, 39913, 39914, 39933, 39921, 39931, 39924};
    private static boolean lookAheadTest = true;
    private static boolean NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
    private static int getAuthRequestContext = 909155164;

    public static /* synthetic */ ObservableSource BuiltInFictitiousFunctionClassFactory(Throwable th) {
        int i = moveToNextValue + 81;
        scheduleImpl = i % 128;
        int i2 = i % 2;
        try {
            ObservableSource PlaceComponentResult2 = PlaceComponentResult(th);
            int i3 = moveToNextValue + 75;
            scheduleImpl = i3 % 128;
            if ((i3 % 2 == 0 ? (char) 11 : 'U') != 11) {
                return PlaceComponentResult2;
            }
            Object[] objArr = null;
            int length = objArr.length;
            return PlaceComponentResult2;
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ SettingModel MyBillsEntityDataFactory(SettingModel settingModel, UsernameChangeConfigRunner usernameChangeConfigRunner, UserInfoResponse userInfoResponse, Boolean bool) {
        int i = scheduleImpl + 111;
        moveToNextValue = i % 128;
        int i2 = i % 2;
        SettingModel BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(settingModel, usernameChangeConfigRunner, userInfoResponse, bool);
        int i3 = moveToNextValue + 21;
        scheduleImpl = i3 % 128;
        if (!(i3 % 2 == 0)) {
            return BuiltInFictitiousFunctionClassFactory;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return BuiltInFictitiousFunctionClassFactory;
    }

    public static /* synthetic */ ObservableSource getAuthRequestContext(UsernameChangeConfigRunner usernameChangeConfigRunner, SettingModel settingModel, UserInfoResponse userInfoResponse) {
        int i = moveToNextValue + 57;
        scheduleImpl = i % 128;
        if ((i % 2 == 0 ? '[' : (char) 14) == 14) {
            try {
                return KClassImpl$Data$declaredNonStaticMembers$2(usernameChangeConfigRunner, settingModel, userInfoResponse);
            } catch (Exception e) {
                throw e;
            }
        }
        ObservableSource KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(usernameChangeConfigRunner, settingModel, userInfoResponse);
        Object[] objArr = null;
        int length = objArr.length;
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // id.dana.domain.profilemenu.settingconfig.SettingConfigurationRunner
    public final String getSettingName() {
        int i = scheduleImpl + 43;
        moveToNextValue = i % 128;
        int i2 = i % 2;
        Object[] objArr = new Object[1];
        Object obj = null;
        a(ExpandableListView.getPackedPositionType(0L) + 127, new byte[]{-126, -122, -123, -118, -115, -116, -121, -126, -117, -118, -123, -119, -126, -127, -120, -121, -122, -123, -124, -125, -125, -126, -127}, null, null, objArr);
        String intern = ((String) objArr[0]).intern();
        int i3 = moveToNextValue + 35;
        scheduleImpl = i3 % 128;
        if ((i3 % 2 == 0 ? '!' : 'F') != '!') {
            return intern;
        }
        obj.hashCode();
        return intern;
    }

    @Inject
    public UsernameChangeConfigRunner(Context context, UserRepository userRepository, FeatureConfigRepository featureConfigRepository) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(userRepository, "");
        Intrinsics.checkNotNullParameter(featureConfigRepository, "");
        this.PlaceComponentResult = context;
        this.getAuthRequestContext = userRepository;
        this.BuiltInFictitiousFunctionClassFactory = featureConfigRepository;
    }

    @Override // id.dana.domain.profilemenu.settingconfig.SettingConfigurationRunner
    public final Observable<SettingModel> performConfiguration(final SettingModel p0) {
        try {
            int i = moveToNextValue + 121;
            try {
                scheduleImpl = i % 128;
                int i2 = i % 2;
                if ((p0 == null ? (char) 24 : (char) 27) == 24) {
                    int i3 = scheduleImpl + 109;
                    moveToNextValue = i3 % 128;
                    int i4 = i3 % 2;
                    Observable<SettingModel> just = Observable.just(SettingModel.empty());
                    Intrinsics.checkNotNullExpressionValue(just, "");
                    return just;
                }
                Observable<SettingModel> onErrorResumeNext = this.getAuthRequestContext.getUserInfo(true).flatMap(new Function() { // from class: id.dana.myprofile.settingconfig.UsernameChangeConfigRunner$$ExternalSyntheticLambda0
                    @Override // io.reactivex.functions.Function
                    public final Object apply(Object obj) {
                        return UsernameChangeConfigRunner.getAuthRequestContext(UsernameChangeConfigRunner.this, p0, (UserInfoResponse) obj);
                    }
                }).onErrorResumeNext(new Function() { // from class: id.dana.myprofile.settingconfig.UsernameChangeConfigRunner$$ExternalSyntheticLambda1
                    @Override // io.reactivex.functions.Function
                    public final Object apply(Object obj) {
                        return UsernameChangeConfigRunner.BuiltInFictitiousFunctionClassFactory((Throwable) obj);
                    }
                });
                Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "");
                return onErrorResumeNext;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static final ObservableSource KClassImpl$Data$declaredNonStaticMembers$2(final UsernameChangeConfigRunner usernameChangeConfigRunner, final SettingModel settingModel, final UserInfoResponse userInfoResponse) {
        Intrinsics.checkNotNullParameter(usernameChangeConfigRunner, "");
        Intrinsics.checkNotNullParameter(userInfoResponse, "");
        ObservableSource map = usernameChangeConfigRunner.BuiltInFictitiousFunctionClassFactory.isChangeUsernameEnabled().map(new Function() { // from class: id.dana.myprofile.settingconfig.UsernameChangeConfigRunner$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UsernameChangeConfigRunner.MyBillsEntityDataFactory(SettingModel.this, usernameChangeConfigRunner, userInfoResponse, (Boolean) obj);
            }
        });
        int i = scheduleImpl + 61;
        moveToNextValue = i % 128;
        if ((i % 2 != 0 ? '1' : '*') != '*') {
            int i2 = 31 / 0;
            return map;
        }
        return map;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0024, code lost:
    
        if ((r7) != true) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0036, code lost:
    
        if (r7.booleanValue() != false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0038, code lost:
    
        r7 = id.dana.myprofile.settingconfig.UsernameChangeConfigRunner.moveToNextValue + 71;
        id.dana.myprofile.settingconfig.UsernameChangeConfigRunner.scheduleImpl = r7 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0042, code lost:
    
        if ((r7 % 2) != 0) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0045, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0049, code lost:
    
        if (r1 == false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x004b, code lost:
    
        r4.setNeedToShow(true);
        r4.setEnable(true);
        r4.setTitle(r5.PlaceComponentResult.getString(id.dana.R.string.username_toolbar_title));
        r5 = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x005d, code lost:
    
        r4.setNeedToShow(true);
        r4.setEnable(true);
        r4.setTitle(r5.PlaceComponentResult.getString(id.dana.R.string.username_toolbar_title));
        r5 = 57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x006e, code lost:
    
        r4.setViewType(r5);
        r4.setUsername(r6.getUsername());
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0079, code lost:
    
        r4.setNeedToShow(false);
        r4.setEnable(false);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final id.dana.domain.profilemenu.model.SettingModel BuiltInFictitiousFunctionClassFactory(id.dana.domain.profilemenu.model.SettingModel r4, id.dana.myprofile.settingconfig.UsernameChangeConfigRunner r5, id.dana.domain.user.UserInfoResponse r6, java.lang.Boolean r7) {
        /*
            int r0 = id.dana.myprofile.settingconfig.UsernameChangeConfigRunner.moveToNextValue
            int r0 = r0 + 59
            int r1 = r0 % 128
            id.dana.myprofile.settingconfig.UsernameChangeConfigRunner.scheduleImpl = r1
            int r0 = r0 % 2
            r1 = 0
            java.lang.String r2 = ""
            r3 = 1
            if (r0 != 0) goto L29
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r2)
            boolean r7 = r7.booleanValue()
            r0 = 0
            int r0 = r0.length     // Catch: java.lang.Throwable -> L27
            if (r7 == 0) goto L23
            r7 = 1
            goto L24
        L23:
            r7 = 0
        L24:
            if (r7 == r3) goto L38
            goto L79
        L27:
            r4 = move-exception
            throw r4
        L29:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r2)
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L79
        L38:
            int r7 = id.dana.myprofile.settingconfig.UsernameChangeConfigRunner.moveToNextValue
            int r7 = r7 + 71
            int r0 = r7 % 128
            id.dana.myprofile.settingconfig.UsernameChangeConfigRunner.scheduleImpl = r0
            int r7 = r7 % 2
            if (r7 != 0) goto L45
            goto L46
        L45:
            r1 = 1
        L46:
            r7 = 2131957911(0x7f131897, float:1.955242E38)
            if (r1 == 0) goto L5d
            r4.setNeedToShow(r3)
            r4.setEnable(r3)
            android.content.Context r5 = r5.PlaceComponentResult
            java.lang.String r5 = r5.getString(r7)
            r4.setTitle(r5)
            r5 = 16
            goto L6e
        L5d:
            r4.setNeedToShow(r3)
            r4.setEnable(r3)
            android.content.Context r5 = r5.PlaceComponentResult
            java.lang.String r5 = r5.getString(r7)
            r4.setTitle(r5)
            r5 = 57
        L6e:
            r4.setViewType(r5)
            java.lang.String r5 = r6.getUsername()
            r4.setUsername(r5)
            goto L7f
        L79:
            r4.setNeedToShow(r1)
            r4.setEnable(r1)
        L7f:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.settingconfig.UsernameChangeConfigRunner.BuiltInFictitiousFunctionClassFactory(id.dana.domain.profilemenu.model.SettingModel, id.dana.myprofile.settingconfig.UsernameChangeConfigRunner, id.dana.domain.user.UserInfoResponse, java.lang.Boolean):id.dana.domain.profilemenu.model.SettingModel");
    }

    private static final ObservableSource PlaceComponentResult(Throwable th) {
        try {
            int i = scheduleImpl + 53;
            moveToNextValue = i % 128;
            if (!(i % 2 != 0)) {
                Intrinsics.checkNotNullParameter(th, "");
                return Observable.just(SettingModel.empty());
            }
            Intrinsics.checkNotNullParameter(th, "");
            int i2 = 58 / 0;
            return Observable.just(SettingModel.empty());
        } catch (Exception e) {
            throw e;
        }
    }

    private static void a(int i, byte[] bArr, char[] cArr, int[] iArr, Object[] objArr) {
        int i2;
        BottomSheetCardBindingView$watcherCardNumberView$1 bottomSheetCardBindingView$watcherCardNumberView$1 = new BottomSheetCardBindingView$watcherCardNumberView$1();
        char[] cArr2 = PlaceComponentResult;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            int i3 = 0;
            while (i3 < length) {
                try {
                    int i4 = $11 + 89;
                    $10 = i4 % 128;
                    if (i4 % 2 != 0) {
                        cArr3[i3] = (char) (cArr2[i3] & 4571606982258105150L);
                        i3 += 0;
                    } else {
                        cArr3[i3] = (char) (cArr2[i3] ^ 4571606982258105150L);
                        i3++;
                    }
                } catch (Exception e) {
                    throw e;
                }
            }
            cArr2 = cArr3;
        }
        int i5 = (int) (4571606982258105150L ^ getAuthRequestContext);
        if (!(NetworkUserEntityData$$ExternalSyntheticLambda0)) {
            if (!(!lookAheadTest)) {
                int i6 = $10 + 7;
                $11 = i6 % 128;
                int i7 = i6 % 2;
                bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = cArr.length;
                char[] cArr4 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                    int i8 = $10 + 75;
                    $11 = i8 % 128;
                    if (i8 % 2 == 0) {
                        cArr4[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[cArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult * 1) + bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] << i] >> i5);
                        i2 = bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory >> 1;
                    } else {
                        cArr4[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[cArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i5);
                        i2 = bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory + 1;
                    }
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = i2;
                }
                objArr[0] = new String(cArr4);
                return;
            }
            bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = iArr.length;
            char[] cArr5 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                int i9 = $10 + 21;
                $11 = i9 % 128;
                if (i9 % 2 == 0) {
                    cArr5[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[iArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult << 0) >> bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] * i] * i5);
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory /= 1;
                } else {
                    cArr5[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[iArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i5);
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                }
            }
            String str = new String(cArr5);
            int i10 = $11 + 91;
            $10 = i10 % 128;
            int i11 = i10 % 2;
            objArr[0] = str;
            return;
        }
        bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = bArr.length;
        char[] cArr6 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
        bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
        int i12 = $11 + 61;
        $10 = i12 % 128;
        int i13 = i12 % 2;
        while (true) {
            if ((bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult ? (char) 29 : (char) 4) != 29) {
                objArr[0] = new String(cArr6);
                return;
            } else {
                cArr6[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[bArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] + i] - i5);
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
            }
        }
    }
}
