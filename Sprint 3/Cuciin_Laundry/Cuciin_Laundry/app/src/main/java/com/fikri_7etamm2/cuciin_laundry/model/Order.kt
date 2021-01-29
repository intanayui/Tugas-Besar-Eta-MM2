package com.fikri_7etamm2.cuciin_laundry.model;

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize;

@Parcelize
data class Order(
        var pilihan : String,
        var detail : String,
        var jumlah : String,
        var biaya : String,
        var catatan : String
) : Parcelable
