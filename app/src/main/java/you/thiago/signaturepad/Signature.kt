package you.thiago.signaturepad

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Signature(
    val versionCode: Int,
    val events: List<Event>,
) : Parcelable
