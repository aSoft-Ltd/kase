package kase.progress

class StageProgressBag : AbstractProgressBag() {
    override fun onUpdate(callback: (ProgressState) -> Unit) {
        handlers.add(callback)
    }
}