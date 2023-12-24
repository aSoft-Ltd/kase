package kase.progress

object VoidProgressBus : AbstractProgressBag() {
    override fun onUpdate(callback: (ProgressState) -> Unit) {

    }
}