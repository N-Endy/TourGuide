package com.example.android.tourguide;

/**
 * {@link Place} represents a place in the user's locality.
 * It contains resource IDs for the name of place, address, and
 * image file for that word.
 */
public class Place {

    /** String resource ID for the default translation of the word */
    private String mNameId;

    /** String resource ID for the Miwok translation of the word */
    private String mAddressId;

    /** Image resource ID for the word */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /** Constant value that represents no image was provided for this word */
    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Create a new Place object.
     *
     * @param nameId is the name of the location
     * @param addressId is the address of the place
     */
    public Place(String nameId, String addressId) {
        mNameId = nameId;
        mAddressId = addressId;
    }

    /**
     * Create a new Word object.
     *
     * @param nameId is the name of the location
     * @param addressId is the address of the place
     * @param imageResourceId is the drawable resource ID for the image associated with the place
     */
    public Place(String nameId, String addressId, int imageResourceId) {
        mNameId = nameId;
        mAddressId = addressId;
        mImageResourceId = imageResourceId;
    }

    /**
     * Get the string resource ID for the name of the place.
     */
    public String getNameId() {
        return mNameId;
    }

    /**
     * Get the string resource ID for the address of the place.
     */
    public String getAddressId() {
        return mAddressId;
    }

    /**
     * Return the image resource ID of the word.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Returns whether or not there is an image for this word.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
