package you.thiago.signaturepad

import android.graphics.Bitmap
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import you.thiago.signaturecore.ExperimentalSignatureApi
import you.thiago.signaturecore.Signature
import you.thiago.signatureview.views.SignaturePad
import you.thiago.signatureview.views.SignedListener

@SuppressWarnings("LongParameterList")
@Composable
fun SignaturePadView(
    penMinWidth: Dp = 3.dp,
    penMaxWidth: Dp = 7.dp,
    penColor: Color = Color.Black,
    velocityFilterWeight: Float = 0.9F,
    clearOnDoubleClick: Boolean = false,
    onReady: (svg: SignaturePadAdapter) -> Unit = {},
    onStartSigning: () -> Unit = {},
    onSigned: () -> Unit = {},
    onClear: () -> Unit = {},
) {
    AndroidView(
        modifier = Modifier
            .fillMaxSize(),
        factory = { context ->
            // Creates custom view
            SignaturePad(context, null).apply {
                this.setOnSignedListener(object : SignedListener {
                    override fun onStartSigning() {
                        onStartSigning()
                    }

                    override fun onSigned() {
                        onSigned()
                    }

                    override fun onClear() {
                        onClear()
                    }
                })
            }
        },
        update = {
            it.setMinWidth(penMinWidth.value)
            it.setMaxWidth(penMaxWidth.value)
            it.setPenColor(penColor.toArgb())
            it.setVelocityFilterWeight(velocityFilterWeight)
            it.setClearOnDoubleClick(clearOnDoubleClick)
            onReady(SignaturePadAdapter(it))
        },
    )
}

class SignaturePadAdapter(private val signaturePad: SignaturePad) {

    fun clear() {
        signaturePad.clear()
    }

    val isEmpty: Boolean
        get() = signaturePad.isEmpty

    @Suppress("unused")
    fun getSignatureBitmap(): Bitmap {
        return signaturePad.getSignatureBitmap()
    }

    @Suppress("unused")
    fun getTransparentSignatureBitmap(): Bitmap {
        return signaturePad.getTransparentSignatureBitmap()
    }

    fun getSignatureSvg(): String {
        return signaturePad.getSignatureSvg()
    }

    @ExperimentalSignatureApi
    fun getSignature(): Signature {
        return signaturePad.getSignature()
    }

    @ExperimentalSignatureApi
    fun setSignature(signature: Signature) {
        return signaturePad.setSignature(signature)
    }
}
