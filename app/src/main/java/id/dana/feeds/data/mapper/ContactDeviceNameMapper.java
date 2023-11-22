package id.dana.feeds.data.mapper;

import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.data.R;
import id.dana.data.account.AccountEntity;
import id.dana.data.account.repository.source.AccountEntityData;
import id.dana.data.account.repository.source.AccountEntityDataFactory;
import id.dana.data.social.common.CursorExtensionKt;
import id.dana.data.social.common.PhoneNumberUtilKt;
import id.dana.data.social.repository.source.persistence.entity.PhoneNumberToContactNameMappable;
import id.dana.data.storage.Serializer;
import id.dana.domain.util.StringUtil;
import id.dana.feeds.data.synccontact.FeedsContactProvider;
import id.dana.feeds.data.synccontact.SocialSyncConstantKt;
import id.dana.feeds.domain.detail.model.Comment;
import id.dana.feeds.domain.reactions.model.ActivityReactionsUser;
import id.dana.feeds.domain.timeline.model.ActivityResponse;
import id.dana.sendmoney.contact.provider.ContactProvider;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0003\u0018\u0000 C2\u00020\u0001:\u0001CB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0016\u0010!\u001a\u00020\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$H\u0002J\u0010\u0010&\u001a\n \u001c*\u0004\u0018\u00010\r0\rH\u0002J$\u0010'\u001a\u00020\r2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u00182\u0006\u0010)\u001a\u00020%H\u0002J\u0010\u0010*\u001a\u00020+2\u0006\u0010)\u001a\u00020%H\u0002JF\u0010,\u001a\b\u0012\u0004\u0012\u00020%0\u00172\f\u0010-\u001a\b\u0012\u0004\u0012\u00020%0\u00172\u000e\b\u0002\u0010.\u001a\b\u0012\u0004\u0012\u00020\"0/2\u001a\b\u0002\u00100\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\u0017\u0012\u0004\u0012\u00020\"0\u0018J\u000e\u00101\u001a\u0002022\u0006\u00103\u001a\u000202J&\u00101\u001a\b\u0012\u0004\u0012\u0002040\u00172\f\u00105\u001a\b\u0012\u0004\u0012\u0002040\u00172\b\b\u0002\u00106\u001a\u00020+H\u0002J\u001a\u00107\u001a\b\u0012\u0004\u0012\u00020%0\u00172\f\u0010-\u001a\b\u0012\u0004\u0012\u00020%0\u0017J\u001a\u00108\u001a\b\u0012\u0004\u0012\u00020%0\u00172\f\u0010-\u001a\b\u0012\u0004\u0012\u00020%0\u0017J\u0016\u00109\u001a\u00020\"2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020%0\u0017H\u0002J\b\u0010:\u001a\u00020\"H\u0002J\u0016\u0010;\u001a\u00020\"2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020%0\u0017H\u0007J\u0016\u0010=\u001a\b\u0012\u0004\u0012\u00020\r0>2\u0006\u0010<\u001a\u00020%H\u0002J\u0016\u0010?\u001a\u00020\"2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\r0AH\u0002J\u0016\u0010B\u001a\u00020\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0\u0017H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R<\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\f2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\f@GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0019\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u001a\u001a\n \u001c*\u0004\u0018\u00010\u001b0\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lid/dana/feeds/data/mapper/ContactDeviceNameMapper;", "", "feedsContactProvider", "Lid/dana/feeds/data/synccontact/FeedsContactProvider;", "serializer", "Lid/dana/data/storage/Serializer;", "accountEntityDataFactory", "Lid/dana/data/account/repository/source/AccountEntityDataFactory;", HummerConstants.CONTEXT, "Landroid/content/Context;", "(Lid/dana/feeds/data/synccontact/FeedsContactProvider;Lid/dana/data/storage/Serializer;Lid/dana/data/account/repository/source/AccountEntityDataFactory;Landroid/content/Context;)V", "cachedPhoneDeviceAndUserName", "", "", "getCachedPhoneDeviceAndUserName", "()Ljava/util/Map;", "setCachedPhoneDeviceAndUserName", "(Ljava/util/Map;)V", "<set-?>", "cachedPhoneDeviceNames", "getCachedPhoneDeviceNames", "setCachedPhoneDeviceNames", "formattingFunctionForAllPossiblePrefixOfAPhoneNumber", "", "Lkotlin/Function1;", "formattingFunctionForManyPrefixToOneFormat", "localAccountEntityData", "Lid/dana/data/account/repository/source/AccountEntityData;", "kotlin.jvm.PlatformType", "getLocalAccountEntityData", "()Lid/dana/data/account/repository/source/AccountEntityData;", "localAccountEntityData$delegate", "Lkotlin/Lazy;", "applyNicknameUpdate", "", "relationshipItemWhoseNicknameNeedUpdateFromDb", "", "Lid/dana/data/social/repository/source/persistence/entity/PhoneNumberToContactNameMappable;", "getCurrentUserPhoneNumber", "getMappingKey", "formatter", "mappablePhoneNumber", "isPhoneNumberContainMasking", "", "mapDeviceContactName", "phoneNumberToContact", "maskingFunction", "Lkotlin/Function0;", "updateNicknameWithUsernameIfExist", "mapPhoneNumberToDeviceContactName", "Lid/dana/feeds/domain/timeline/model/SocialFeed;", "socialFeed", "Lid/dana/feeds/domain/timeline/model/ActivityResponse;", "activities", "shouldMapComment", "mapPhoneNumberToDeviceContactNameForRelationshipItem", "mapPhoneNumberToDeviceContactNameNotUsername", "maskNicknameDisplayName", "updateCurrentuserWithYou", "updateHeadernameForUserProfile", "phoneNumberToContactNameMappableItem", "updateNicknameFromCacheForRelationship", "", "updateNicknameWithContactDeviceName", "phoneNumNotFoundInCacheForDbQuery", "", "updateUsernameForRelationship", "Companion", "feature-feeds_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ContactDeviceNameMapper {
    public static final Companion getAuthRequestContext = new Companion(null);
    public Map<String, String> BuiltInFictitiousFunctionClassFactory;
    public Map<String, String> KClassImpl$Data$declaredNonStaticMembers$2;
    private final AccountEntityDataFactory MyBillsEntityDataFactory;
    private final Serializer NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Context PlaceComponentResult;
    private final FeedsContactProvider getErrorConfigVersion;
    private final List<Function1<String, String>> lookAheadTest;
    private final List<Function1<String, String>> moveToNextValue;
    private final Lazy scheduleImpl;

    @Inject
    public ContactDeviceNameMapper(FeedsContactProvider feedsContactProvider, Serializer serializer, AccountEntityDataFactory accountEntityDataFactory, Context context) {
        Intrinsics.checkNotNullParameter(feedsContactProvider, "");
        Intrinsics.checkNotNullParameter(serializer, "");
        Intrinsics.checkNotNullParameter(accountEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(context, "");
        this.getErrorConfigVersion = feedsContactProvider;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = serializer;
        this.MyBillsEntityDataFactory = accountEntityDataFactory;
        this.PlaceComponentResult = context;
        this.scheduleImpl = LazyKt.lazy(new Function0<AccountEntityData>() { // from class: id.dana.feeds.data.mapper.ContactDeviceNameMapper$localAccountEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AccountEntityData invoke() {
                AccountEntityDataFactory accountEntityDataFactory2;
                accountEntityDataFactory2 = ContactDeviceNameMapper.this.MyBillsEntityDataFactory;
                return accountEntityDataFactory2.createData2("local");
            }
        });
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();
        this.BuiltInFictitiousFunctionClassFactory = new LinkedHashMap();
        this.moveToNextValue = CollectionsKt.listOf((Object[]) new Function1[]{new Function1<String, String>() { // from class: id.dana.feeds.data.mapper.ContactDeviceNameMapper$formattingFunctionForAllPossiblePrefixOfAPhoneNumber$1
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(String str) {
                Intrinsics.checkNotNullParameter(str, "");
                return PhoneNumberUtilKt.replaceIndoRegionDashWithPhonePrefix(str);
            }
        }, new Function1<String, String>() { // from class: id.dana.feeds.data.mapper.ContactDeviceNameMapper$formattingFunctionForAllPossiblePrefixOfAPhoneNumber$2
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(String str) {
                Intrinsics.checkNotNullParameter(str, "");
                return PhoneNumberUtilKt.replaceIndoRegionDashWithPlusSixTwoEight(str);
            }
        }, new Function1<String, String>() { // from class: id.dana.feeds.data.mapper.ContactDeviceNameMapper$formattingFunctionForAllPossiblePrefixOfAPhoneNumber$3
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(String str) {
                Intrinsics.checkNotNullParameter(str, "");
                return PhoneNumberUtilKt.replaceIndoRegionDashWithSixTwo(str);
            }
        }});
        this.lookAheadTest = CollectionsKt.listOf((Object[]) new Function1[]{new Function1<String, String>() { // from class: id.dana.feeds.data.mapper.ContactDeviceNameMapper$formattingFunctionForManyPrefixToOneFormat$1
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(String str) {
                Intrinsics.checkNotNullParameter(str, "");
                return PhoneNumberUtilKt.replacePhonePrefixWithIndoRegionDash(str);
            }
        }, new Function1<String, String>() { // from class: id.dana.feeds.data.mapper.ContactDeviceNameMapper$formattingFunctionForManyPrefixToOneFormat$2
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(String str) {
                Intrinsics.checkNotNullParameter(str, "");
                return PhoneNumberUtilKt.replacePlusSixTwoEightWithIndoRegionDash(str);
            }
        }, new Function1<String, String>() { // from class: id.dana.feeds.data.mapper.ContactDeviceNameMapper$formattingFunctionForManyPrefixToOneFormat$3
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(String str) {
                Intrinsics.checkNotNullParameter(str, "");
                return PhoneNumberUtilKt.replaceSixTwoWithIndoRegionDash(str);
            }
        }});
    }

    public final List<ActivityResponse> getAuthRequestContext(List<ActivityResponse> list, boolean z) {
        ArrayList arrayList = new ArrayList();
        List<ActivityResponse> list2 = list;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (ActivityResponse activityResponse : list2) {
            arrayList.add(new ActivityMappableToContact(this.NetworkUserEntityData$$ExternalSyntheticLambda0, activityResponse));
            if (z && (!activityResponse.getLatestComments().isEmpty()) != false) {
                List<Comment> latestComments = activityResponse.getLatestComments();
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(latestComments, 10));
                Iterator<T> it = latestComments.iterator();
                while (it.hasNext()) {
                    arrayList3.add(((Comment) it.next()).getUser());
                }
                ArrayList arrayList4 = arrayList3;
                ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList4, 10));
                Iterator it2 = arrayList4.iterator();
                while (it2.hasNext()) {
                    arrayList5.add(new ActivityReactionMappableToContact((ActivityReactionsUser) it2.next()));
                }
                arrayList.addAll(arrayList5);
            }
            arrayList2.add(activityResponse);
        }
        Intrinsics.checkNotNullParameter(arrayList, "");
        PlaceComponentResult(this, arrayList, new ContactDeviceNameMapper$mapPhoneNumberToDeviceContactNameForRelationshipItem$1(this, arrayList), null, 4);
        return list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ List PlaceComponentResult(ContactDeviceNameMapper contactDeviceNameMapper, List list, Function0 function0, Function1 function1, int i) {
        if ((i & 2) != 0) {
            function0 = new Function0<Unit>() { // from class: id.dana.feeds.data.mapper.ContactDeviceNameMapper$mapDeviceContactName$1
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        if ((i & 4) != 0) {
            function1 = new Function1<List<? extends PhoneNumberToContactNameMappable>, Unit>() { // from class: id.dana.feeds.data.mapper.ContactDeviceNameMapper$mapDeviceContactName$2
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(List<? extends PhoneNumberToContactNameMappable> list2) {
                    Intrinsics.checkNotNullParameter(list2, "");
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(List<? extends PhoneNumberToContactNameMappable> list2) {
                    invoke2(list2);
                    return Unit.INSTANCE;
                }
            };
        }
        return contactDeviceNameMapper.BuiltInFictitiousFunctionClassFactory(list, function0, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final List<PhoneNumberToContactNameMappable> BuiltInFictitiousFunctionClassFactory(List<? extends PhoneNumberToContactNameMappable> list, Function0<Unit> function0, Function1<? super List<? extends PhoneNumberToContactNameMappable>, Unit> function1) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(function0, "");
        Intrinsics.checkNotNullParameter(function1, "");
        function0.invoke();
        for (List<? extends PhoneNumberToContactNameMappable> list2 : CollectionsKt.chunked(list, 50)) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            ArrayList arrayList = new ArrayList();
            for (PhoneNumberToContactNameMappable phoneNumberToContactNameMappable : list2) {
                linkedHashSet.addAll(getAuthRequestContext(phoneNumberToContactNameMappable));
                arrayList.add(phoneNumberToContactNameMappable);
            }
            MyBillsEntityDataFactory(linkedHashSet);
            MyBillsEntityDataFactory();
            BuiltInFictitiousFunctionClassFactory(list2);
            function1.invoke(list2);
        }
        return list;
    }

    private static boolean MyBillsEntityDataFactory(PhoneNumberToContactNameMappable phoneNumberToContactNameMappable) {
        return StringsKt.contains$default((CharSequence) phoneNumberToContactNameMappable.getLoginId(), (CharSequence) "*", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) phoneNumberToContactNameMappable.getLoginId(), (CharSequence) "•", false, 2, (Object) null);
    }

    private void BuiltInFictitiousFunctionClassFactory(List<? extends PhoneNumberToContactNameMappable> list) {
        Intrinsics.checkNotNullParameter(list, "");
        for (PhoneNumberToContactNameMappable phoneNumberToContactNameMappable : list) {
            Iterator<T> it = this.moveToNextValue.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Function1 function1 = (Function1) it.next();
                String str = this.KClassImpl$Data$declaredNonStaticMembers$2.get(getAuthRequestContext(function1, phoneNumberToContactNameMappable));
                if (!(str == null || StringsKt.isBlank(str))) {
                    String str2 = this.KClassImpl$Data$declaredNonStaticMembers$2.get(getAuthRequestContext(function1, phoneNumberToContactNameMappable));
                    if (str2 == null) {
                        str2 = "";
                    }
                    phoneNumberToContactNameMappable.updateHeaderName(str2);
                }
            }
            if (phoneNumberToContactNameMappable.getHeaderName().length() == 0) {
                phoneNumberToContactNameMappable.updateHeaderName(phoneNumberToContactNameMappable.getNickname());
            }
        }
    }

    private static String getAuthRequestContext(Function1<? super String, String> function1, PhoneNumberToContactNameMappable phoneNumberToContactNameMappable) {
        if (MyBillsEntityDataFactory(phoneNumberToContactNameMappable)) {
            return phoneNumberToContactNameMappable.getUserId();
        }
        return function1.invoke(phoneNumberToContactNameMappable.getLoginId());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void MyBillsEntityDataFactory() {
        Iterator<T> it = this.lookAheadTest.iterator();
        while (it.hasNext()) {
            Function1 function1 = (Function1) it.next();
            String str = (String) ((AccountEntityData) this.scheduleImpl.getValue()).getAccount().map(new Function() { // from class: id.dana.feeds.data.mapper.ContactDeviceNameMapper$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return ContactDeviceNameMapper.MyBillsEntityDataFactory((AccountEntity) obj);
                }
            }).blockingFirst();
            Intrinsics.checkNotNullExpressionValue(str, "");
            String str2 = (String) function1.invoke(str);
            Iterator<T> it2 = this.moveToNextValue.iterator();
            while (it2.hasNext()) {
                Function1 function12 = (Function1) it2.next();
                Map<String, String> map = this.KClassImpl$Data$declaredNonStaticMembers$2;
                Object invoke = function12.invoke(str2);
                String string = this.PlaceComponentResult.getString(R.string.lookAheadTest);
                Intrinsics.checkNotNullExpressionValue(string, "");
                map.put(invoke, string);
            }
        }
    }

    private final void MyBillsEntityDataFactory(Set<String> set) {
        String[] strArr;
        HashMap hashMap;
        Map<String, String> phoneNumberAndContactNameMap;
        if (set.isEmpty()) {
            return;
        }
        FeedsContactProvider feedsContactProvider = this.getErrorConfigVersion;
        Map<String, String> map = this.KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullParameter(set, "");
        Intrinsics.checkNotNullParameter(map, "");
        if (!feedsContactProvider.PlaceComponentResult()) {
            hashMap = new HashMap();
        } else {
            List mutableListOf = CollectionsKt.mutableListOf(ContactProvider.Column.MIMETYPE_PHONENUMBER);
            mutableListOf.addAll(CollectionsKt.toMutableList((Collection) set));
            strArr = SocialSyncConstantKt.KClassImpl$Data$declaredNonStaticMembers$2;
            String format = String.format("mimetype = ? AND data1 IN (%s)", Arrays.copyOf(new Object[]{FeedsContactProvider.KClassImpl$Data$declaredNonStaticMembers$2(mutableListOf)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "");
            Object[] array = mutableListOf.toArray(new String[0]);
            if (array != null) {
                String format2 = String.format(ContactProvider.SortOrder.SORT_ORDER_ASCENDING, Arrays.copyOf(new Object[]{ContactProvider.Column.PHONENUMBER}, 1));
                Intrinsics.checkNotNullExpressionValue(format2, "");
                Cursor query = feedsContactProvider.PlaceComponentResult.query(ContactsContract.Data.CONTENT_URI, strArr, format, (String[]) array, format2);
                if (query != null && (phoneNumberAndContactNameMap = CursorExtensionKt.toPhoneNumberAndContactNameMap(query, map)) != null) {
                    map = phoneNumberAndContactNameMap;
                }
                hashMap = map;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = hashMap;
    }

    private final Set<String> getAuthRequestContext(PhoneNumberToContactNameMappable phoneNumberToContactNameMappable) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<T> it = this.moveToNextValue.iterator();
        while (it.hasNext()) {
            String authRequestContext = getAuthRequestContext((Function1) it.next(), phoneNumberToContactNameMappable);
            if (!this.KClassImpl$Data$declaredNonStaticMembers$2.containsKey(authRequestContext)) {
                linkedHashSet.add(authRequestContext);
            }
        }
        return linkedHashSet;
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/feeds/data/mapper/ContactDeviceNameMapper$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public static /* synthetic */ String MyBillsEntityDataFactory(AccountEntity accountEntity) {
        Intrinsics.checkNotNullParameter(accountEntity, "");
        return accountEntity.getPhoneNumber();
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(List list) {
        List<PhoneNumberToContactNameMappable> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (PhoneNumberToContactNameMappable phoneNumberToContactNameMappable : list2) {
            if (MyBillsEntityDataFactory(phoneNumberToContactNameMappable)) {
                phoneNumberToContactNameMappable.updateNickName(StringUtil.maskName(phoneNumberToContactNameMappable.getNickname()));
            }
            arrayList.add(Unit.INSTANCE);
        }
    }
}
