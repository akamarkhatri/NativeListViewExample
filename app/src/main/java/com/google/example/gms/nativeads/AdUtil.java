package com.google.example.gms.nativeads;

import com.google.android.gms.ads.doubleclick.PublisherAdRequest;

/**
 * Created by QAIT\amarkhatri on 22/7/16.
 */
public class AdUtil {

    public static PublisherAdRequest getPublisherAdRequest() {
        return new PublisherAdRequest.Builder().build();
//        return new PublisherAdRequest.Builder().addTestDevice("E9586B10E8D9E56473B5A5D3E18EED99").build();
    }

    public static final String TOP_LISTING="/28928716/DB_APP_Native_Top";
    public static final String MIDDLE_LISTING="/28928716/DB_APP_Native_Mid";
    public static final String BOTTOM_LISTING="/28928716/DB_APP_Native_Bottom";

    public static final String TOP_LISTING_BOLLYWOOD="/28928716/DB_APP_Native_Top_ListingPage";
    public static final String MIDDLE_LISTING_BOLLYWOOD="/28928716/DB_APP_Native_Mid_ListingPage";
    public static final String BOTTOM_LISTING_BOLLYWOOD="/28928716/DB_APP_Native_Bottom_ListingPage";

}
