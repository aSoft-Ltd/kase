package kase

import kase.outcome.Failure
import kase.outcome.Outcome
import kase.outcome.Success
import kommander.expect
import kommander.toBe
import kotlin.test.Test
import kotlin.test.fail

class SyntaxTest {

    @Test
    fun should_have_a_good_syntax() = when (val o: Outcome<Int, String> = Failure(69)) {
        is Failure -> {
            val f: Int = o.value
            expect(f).toBe(69)
        }

        is Success -> fail("Should not be here")
    }

    @Test
    fun should_be_able_to_map_a_failure() {
        val o: Outcome<Int, String> = Failure(69)
        val res = o.map {
            it.length
        }.map {
            it * 3
        }
        expect(res).toBe<Failure<Int>>()
        println(res)
    }

    @Test
    fun should_not_crash_when_underlying_types_failure_types_change() {
        val o: Outcome<Exception, String> = Success("Hello")
        val res = o.flatMapError {
            Failure(it)
        }
        expect(res.get()).toBe("Hello")
    }

    @Test
    fun should_not_crash_when_underlying_success_failure_types_change() {
        val o: Outcome<String, Int> = Failure("Bad number")
        val res = o.map { it.toChar() }.getOrNull() ?: 'C'
        expect(res).toBe('C')
    }

    @Test
    fun should_be_able_to_flat_map_successes() {
        val o: Outcome<Throwable, String> = Success("69")
        val res = o.flatMap { Success(it.toInt()) }.get()
        expect(res).toBe(69)
    }

    @Test
    fun should_be_able_to_flat_map_errors() {
        val o: Outcome<Throwable, String> = Failure(IllegalStateException("Bad Number"))
        val res = o.flatMap { Success(it.toInt()) as Outcome<Throwable, Int> }.error()

        expect(res.message).toBe("Bad Number")
    }
}