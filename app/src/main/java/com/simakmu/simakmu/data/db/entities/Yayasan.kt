package com.simakmu.simakmu.data.db.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize

const val CURRENT_CABANG_ID = 0
const val CURRENT_LEMBAGA_ID = 0

@Entity
@Parcelize
data class Cabang(
    val nama: String? = null,
    val alamat: String? = null,
    val kelurahan: String? = null,
    val kecamatan: String? = null,
    val kota: String? = null,
    val provinsi: String? = null,
    val yayasan: String? = null,
    val status: String? = null,
    val sk: String? = null,
    val tahun: String? = null,
    val pengurus: String? = null,
    val telp: String? = null,
): Parcelable {
    @IgnoredOnParcel
    @PrimaryKey(autoGenerate = false)
    var uid: Int = CURRENT_CABANG_ID
}

@Entity
@Parcelize
data class Lembaga(
    val nama: String? = null,
    val alamat: String? = null,
    val telp: String? = null,
    val email: String? = null,
    val periode: String? = null,
    val ketua: String? = null,
    val mudir: String? = null,
    val sekretaris: String? = null,
    val bendahara: String? = null,
    val administrasi: String? = null,
): Parcelable {
    @IgnoredOnParcel
    @PrimaryKey(autoGenerate = false)
    var uid: Int = CURRENT_LEMBAGA_ID
}