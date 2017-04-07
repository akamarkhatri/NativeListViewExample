package com.google.example.gms.nativeads;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeAppInstallAdView;

import java.util.List;

/**
 * A class that creates, holds, and populates the view assets for a {@link NativeAppInstallAd}.
 */
public class AppInstallAdViewHolder extends AdViewHolder {
    private final TextView contentExtraTextView;
    public NativeAppInstallAdView mAdView;
    private String extraText="SampleId App-Install";

    /**
     * Stores the View for a {@link NativeAppInstallAd} and locates specific {@link View}s used
     * to display its assets.
     *
     * @param adView the {@link View} used to display assets for a native app install ad.
     */
    public AppInstallAdViewHolder(NativeAppInstallAdView adView) {
        mAdView = adView;
        mAdView.setVisibility(View.VISIBLE);
        mAdView.setHeadlineView(mAdView.findViewById(R.id.appinstall_headline));
        mAdView.setImageView(mAdView.findViewById(R.id.appinstall_image));
        mAdView.setBodyView(mAdView.findViewById(R.id.appinstall_body));
        mAdView.setCallToActionView(mAdView.findViewById(R.id.appinstall_call_to_action));
        mAdView.setIconView(mAdView.findViewById(R.id.appinstall_app_icon));
        mAdView.setPriceView(mAdView.findViewById(R.id.appinstall_price));
        mAdView.setStarRatingView(mAdView.findViewById(R.id.appinstall_stars));
        mAdView.setStoreView(mAdView.findViewById(R.id.appinstall_store));
        contentExtraTextView= (TextView) mAdView.findViewById(R.id.appinstall_advertisement);
//        contentExtraTextView.append("\n"+extraText);
    }

    /**
     * Populates the asset {@link View}s contained it the {@link NativeAppInstallAdView} with data
     * from the {@link NativeAppInstallAd} object. This method is invoked when an
     * {@link AppInstallAdFetcher} has successfully loaded a {@link NativeAppInstallAd}.
     *
     * @param appInstallAd the ad that is to be displayed
     */
    public void populateView(NativeAppInstallAd appInstallAd) {
        ((TextView) mAdView.getHeadlineView()).setText(appInstallAd.getHeadline());
        ((TextView) mAdView.getBodyView()).setText(appInstallAd.getBody());
        ((TextView) mAdView.getPriceView()).setText(appInstallAd.getPrice());
        ((TextView) mAdView.getStoreView()).setText(appInstallAd.getStore());
        ((Button) mAdView.getCallToActionView()).setText(appInstallAd.getCallToAction());
        ((ImageView) mAdView.getIconView()).setImageDrawable(appInstallAd.getIcon().getDrawable());
        ((RatingBar) mAdView.getStarRatingView())
                .setRating(appInstallAd.getStarRating().floatValue());
        contentExtraTextView.setText("\n"+extraText);
        List<NativeAd.Image> images = appInstallAd.getImages();

        if (images.size() > 0) {
            ((ImageView) mAdView.getImageView())
                    .setImageDrawable(images.get(0).getDrawable());
        }

        // assign native ad object to the native view and make visible
        mAdView.setNativeAd(appInstallAd);
        mAdView.setVisibility(View.VISIBLE);
    }

    /**
     * Hides the {@link NativeAppInstallAdView} used to display the native ad.
     */
    @Override
    public void hideView() {
//        mAdView.setVisibility(View.GONE);
//        contentExtraTextView.setText("\n"+"Failed To Load");
        contentExtraTextView.setText(extraText+"\n"+"Failed To Load : AppInstall-AD");
    }

    public void setExtraText(String extraText) {
        this.extraText = extraText;
    }
}
