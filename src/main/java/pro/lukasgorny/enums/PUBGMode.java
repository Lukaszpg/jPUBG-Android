package pro.lukasgorny.enums;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Łukasz "Husar" Górny on 2017-06-29.
 */
public enum PUBGMode {

    @SerializedName("solo")
    solo("solo"),

    @SerializedName("duo")
    duo("duo"),

    @SerializedName("squad")
    squad("squad"),

    @SerializedName("solo-fpp")
    solo_fpp("solo-fpp"),

    @SerializedName("duo-fpp")
    duo_fpp("duo-fpp"),

    @SerializedName("squad-fpp")
    squad_fpp("squad-fpp");

    PUBGMode(String modeName) {
        this.modeName = modeName;
    }

    private String modeName;

    public String getModeName() {
        return modeName;
    }
}