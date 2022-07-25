package you.thiago.signatureview.views

interface SignedListener {
    fun onStartSigning()
    fun onSigned()
    fun onClear()
}
