import expect.expect
import kase.Loading
import kase.progress.StageProgressBag
import kotlin.test.Test

class ProgressSettingTest {
    @Test
    fun should_easily_update_progress() {
        val bag = StageProgressBag()
        val (cats, prods) = bag.setStages("Fetching categories", "Fetching products")
        expect(cats.number).toBe(1)
        expect(cats.outOf).toBe(2)

        expect(prods.number).toBe(2)
        expect(prods.outOf).toBe(2)

        val loading = Loading<Int>(
            message = "loading",
            progress = bag.updateProgress(cats(30L, 100L))
        )

        val executing = Loading<Int>(
            message = "executing",
            progress = bag.updateProgress(cats(60L, 100L))
        )

        expect(loading.progress.current.done).toBe(30L)
        expect(executing.progress.current.done).toBe(60L)
    }
}